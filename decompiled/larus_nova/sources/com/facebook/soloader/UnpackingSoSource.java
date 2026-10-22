package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String INSTANCE_LOCK_FILE_NAME = "dso_instance_lock";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    protected static final byte STATE_CLEAN = 1;
    protected static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";

    @Nullable
    private String[] mAbis;
    protected final Context mContext;

    @Nullable
    protected String mCorruptedLib;

    @Nullable
    protected FileLocker mInstanceLock;
    private final Map<String, Object> mLibsBeingLoaded;

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String r100, String r101) {
            this.name = r100;
            this.hash = r101;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] r100) {
            this.dsos = r100;
        }

        public static final DsoManifest read(DataInput r100) throws IOException {
            if (r100.readByte() != 1) goto L14;
            int r101 = r100.readInt();
            if (r101 < 0) goto L12;
            Dso[] r102 = new Dso[r101];
            int r103 = 0;
        L7:
            if (r103 >= r101) goto L10;
            r102[r103] = new Dso(r100.readUTF(), r100.readUTF());
            r103 = r103 + 1;
            goto L7
        L10:
            return new DsoManifest(r102);
        L12:
            throw new RuntimeException("illegal number of shared libraries");
        L14:
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput r100) throws IOException {
            r100.writeByte(1);
            r100.writeInt(this.dsos.length);
            int r101 = 0;
        L3:
            Dso[] r102 = this.dsos;
            if (r101 >= r102.length) goto L6;
            r100.writeUTF(r102[r101].name);
            r100.writeUTF(this.dsos[r101].hash);
            r101 = r101 + 1;
            goto L3
        }
    }

    public interface InputDso extends Closeable {
        int available() throws IOException;

        Dso getDso();

        String getFileName();

        InputStream getStream();

        void write(DataOutput r100, byte[] r101) throws IOException;
    }

    public static abstract class InputDsoIterator implements Closeable {
        public InputDsoIterator() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        @Nullable
        public abstract InputDso next() throws IOException;
    }

    public static class InputDsoStream implements InputDso {
        private final InputStream content;
        private final Dso dso;

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public int available() throws IOException {
            return this.content.available();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.content.close();
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public String getFileName() {
            return this.dso.name;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public Dso getDso() {
            return this.dso;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public InputStream getStream() {
            return this.content;
        }

        public InputDsoStream(Dso r100, InputStream r101) {
            this.dso = r100;
            this.content = r101;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public void write(DataOutput r100, byte[] r101) throws IOException {
            SysUtil.copyBytes(r100, this.content, Integer.MAX_VALUE, r101);
        }
    }

    public static abstract class Unpacker implements Closeable {
        public Unpacker() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    public String getSoNameFromFileName(String r100) {
        return r100;
    }

    public abstract Unpacker makeUnpacker(byte r100) throws IOException;

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        String[] r100 = this.mAbis;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return super.getSoSourceAbis();
    }

    public byte[] getDepsBlock() throws IOException {
        Parcel r100 = Parcel.obtain();
        Unpacker r101 = makeUnpacker((byte) 1);
        Dso[] r102 = r101.getDsoManifest().dsos;     // Catch: Throwable -> L10
        r100.writeByte((byte) 1);     // Catch: Throwable -> L10
        r100.writeInt(r102.length);     // Catch: Throwable -> L10
        int r103 = 0;
    L5:
        if (r103 >= r102.length) goto L8;
        r100.writeString(r102[r103].name);     // Catch: Throwable -> L10
        r100.writeString(r102[r103].hash);     // Catch: Throwable -> L10
        r103 = r103 + 1;
        goto L5
    L8:
        r101.close();
        byte[] r104 = r100.marshall();
        r100.recycle();
        return r104;
    L10:
        th = move-exception;
        if (r101 != null) goto L19;
    L16:
        throw th;
    L19:
        r101.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }

    private void deleteUnmentionedFiles(Dso[] r100) throws IOException {
        String[] r101 = this.soDirectory.list();
        if (r101 == null) goto L31;
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L29;
        String r103 = r101[r102];
        if (r103.equals(STATE_FILE_NAME) == true) goto L28;
        if (r103.equals(LOCK_FILE_NAME) == true) goto L28;
        if (r103.equals(INSTANCE_LOCK_FILE_NAME) == true) goto L28;
        if (r103.equals(DEPS_FILE_NAME) == true) goto L28;
        if (r103.equals(MANIFEST_FILE_NAME) == true) goto L28;
        boolean r104 = false;
        int r105 = 0;
    L19:
        if (r104 == true) goto L26;
        if (r105 >= r100.length) goto L26;
        if (r100[r105].name.equals(getSoNameFromFileName(r103)) == false) goto L25;
        r104 = true;
    L25:
        r105 = r105 + 1;
    L26:
        if (r104 == true) goto L28;
        PolarisFileWrapper r106 = new PolarisFileWrapper(this.soDirectory, r103);
        r106.toString();
        SysUtil.dumbDeleteRecursive(r106);
    L28:
        r102 = r102 + 1;
        goto L6
    L29:
        return;
    L31:
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    private Object getLibraryLock(String r100) {
        Map<String, Object> r101 = this.mLibsBeingLoaded;
        monitor-enter(r101);
        Object r102 = this.mLibsBeingLoaded.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = new Object();     // Catch: Throwable -> L9
        this.mLibsBeingLoaded.put(r100, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String r100) throws IOException {
        File r101 = getSoFileByName(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getCanonicalPath();
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int r100) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker r101 = getOrCreateLock(new PolarisFileWrapper(this.soDirectory, LOCK_FILE_NAME), true);
        if (this.mInstanceLock != null) goto L5;
        this.mInstanceLock = getOrCreateLock(new PolarisFileWrapper(this.soDirectory, INSTANCE_LOCK_FILE_NAME), false);
    L5:
        boolean r102 = this.soDirectory.canWrite();
        Objects.toString(this.soDirectory);     // Catch: Throwable -> L19
        if (r102 == true) goto L10;
        this.soDirectory.setWritable(true);     // Catch: Throwable -> L19
    L10:
        if (refreshLocked(r101, r100, getDepsBlock()) == false) goto L12;
        r101 = null;
    L13:
        if (r102 == true) goto L15;
        this.soDirectory.setWritable(false);
    L15:
        if (r101 == null) goto L17;
        Objects.toString(this.soDirectory);
        r101.close();
        return;
    L17:
        Objects.toString(this.soDirectory);
        return;
    L12:
        Objects.toString(this.soDirectory);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (r102 == true) goto L22;
        this.soDirectory.setWritable(false);
    L22:
        if (r101 == null) goto L24;
        Objects.toString(this.soDirectory);
        r101.close();
    L25:
        throw th;
    L24:
        Objects.toString(this.soDirectory);
        goto L25
    }

    public void setSoSourceAbis(String[] r100) {
        this.mAbis = r100;
    }

    public synchronized void prepare(String r100) throws IOException {
        monitor-enter(this);
        Object r101 = getLibraryLock(r100);     // Catch: Throwable -> L12
        monitor-enter(r101);     // Catch: Throwable -> L12
        this.mCorruptedLib = r100;     // Catch: Throwable -> L9
        prepare(2);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public UnpackingSoSource(Context r100, String r101) {
        super(getSoStorePath(r100, r101), 1);
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = r100;
    }

    public static /* synthetic */ void access$000(File r100, byte r101) throws IOException {
        writeState(r100, r101);
    }

    private void extractDso(InputDso r100, byte[] r101) throws IOException {
        String r102 = r100.getDso().name;
    L12:
        th = move-exception;
        if (this.soDirectory.setWritable(false) == true) goto L16;
        this.soDirectory.getCanonicalPath();
    L16:
        throw th;
    L4:
        if (this.soDirectory.setWritable(true) == false) goto L11;
        extractDsoImpl(r100, r101);     // Catch: Throwable -> L12
        if (this.soDirectory.setWritable(false) == true) goto L18;
        this.soDirectory.getCanonicalPath();
        return;
    L18:
        return;
    L11:
        throw new IOException("cannot make directory writable for us: " + this.soDirectory);     // Catch: Throwable -> L12
    }

    private void extractDsoImpl(InputDso r110, byte[] r111) throws IOException {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.soDirectory, r110.getFileName());
        RandomAccessFile r101 = null;
    L25:
        e = move-exception;
        SysUtil.dumbDeleteRecursive(r100);     // Catch: Throwable -> L23
        throw e;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r100.setWritable(false) == true) goto L31;
        r100.toString();
    L31:
        if (r101 == null) goto L33;
        r101.close();
    L33:
        throw th;
    L4:
        if (r100.exists() == true) goto L6;
    L36:
        RandomAccessFile r102 = new RandomAccessFile(r100, "rw");     // Catch: IOException -> L10 Throwable -> L23
    L9:
        r101 = r102;
        int r103 = r110.available();     // Catch: Throwable -> L23 IOException -> L25
        if (r103 <= 1) goto L14;
        SysUtil.fallocateIfSupported(r101.getFD(), r103);     // Catch: Throwable -> L23 IOException -> L25
    L14:
        r110.write(r101, r111);     // Catch: Throwable -> L23 IOException -> L25
        r101.setLength(r101.getFilePointer());     // Catch: Throwable -> L23 IOException -> L25
        if (r100.setExecutable(true, false) == false) goto L22;
        if (r100.setWritable(false) == true) goto L19;
        r100.toString();
    L19:
        r101.close();
        return;
    L22:
        throw new IOException("cannot make file executable: " + r100);     // Catch: Throwable -> L23 IOException -> L25
    L10:
        r100.toString();     // Catch: Throwable -> L23 IOException -> L25
        SysUtil.dumbDeleteRecursive(r100);     // Catch: Throwable -> L23 IOException -> L25
        r102 = new RandomAccessFile(r100, "rw");     // Catch: Throwable -> L23 IOException -> L25
        goto L9
    L6:
        if (r100.setWritable(true) == true) goto L36;
        r100.toString();     // Catch: Throwable -> L23 IOException -> L25
        goto L36
    }

    public static File getSoStorePath(Context r100, String r101) {
        return new PolarisFileWrapper(r100.getApplicationInfo().dataDir + HTTP.URL_DEFAULT + r101);
    }

    private static void writeState(File r100, byte r101) throws IOException {
        RandomAccessFile r102 = new RandomAccessFile(r100, "rw");     // Catch: SyncFailedException -> L14
        r102.seek(0);     // Catch: Throwable -> L7
        r102.write(r101);     // Catch: Throwable -> L7
        r102.setLength(r102.getFilePointer());     // Catch: Throwable -> L7
        r102.getFD().sync();     // Catch: Throwable -> L7
        r102.close();     // Catch: SyncFailedException -> L14
        return;
    L7:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: SyncFailedException -> L14
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: SyncFailedException -> L14
    }

    public boolean depsChanged(byte[] r100, byte[] r101) {
        return !Arrays.equals(r100, r101);
    }

    @Nullable
    public FileLocker getOrCreateLock(File r100, boolean r101) throws IOException {
        return SysUtil.getOrCreateLockOnDir(this.soDirectory, r100, r101);
    }

    public UnpackingSoSource(Context r100, File r101) {
        super(r101, 1);
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = r100;
    }

    private void regenerate(byte r100, DsoManifest r110, InputDsoIterator r111) throws IOException {
        RandomAccessFile r101 = new RandomAccessFile(new PolarisFileWrapper(this.soDirectory, MANIFEST_FILE_NAME), "rw");
        if (r100 == 1) goto L48;
    L8:
        DsoManifest r102 = null;
    L10:
        if (r102 != null) goto L12;
        r102 = new DsoManifest(new Dso[0]);     // Catch: Throwable -> L6
    L12:
        deleteUnmentionedFiles(r110.dsos);     // Catch: Throwable -> L6
        byte[] r112 = new byte[32768];     // Catch: Throwable -> L6
    L14:
        if (r111.hasNext() == false) goto L40;
        InputDso r103 = r111.next();     // Catch: Throwable -> L6
        boolean r104 = true;
        int r105 = 0;
    L17:
        if (r104 == false) goto L27;
        if (r105 >= r102.dsos.length) goto L27;
        String r106 = r103.getDso().name;     // Catch: Throwable -> L33
        if (r102.dsos[r105].name.equals(r106) == false) goto L25;
        if (r102.dsos[r105].hash.equals(r103.getDso().hash) == false) goto L25;
        r104 = false;
    L25:
        r105 = r105 + 1;     // Catch: Throwable -> L33
        goto L17
    L33:
        th = move-exception;
        if (r103 != null) goto L55;
    L39:
        throw th;     // Catch: Throwable -> L6
    L55:
        r103.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L44
    L46:
        throw th;
    L44:
        th = move-exception;
        th.addSuppressed(th);
    L27:
        if (new PolarisFileWrapper(this.soDirectory, r103.getFileName()).exists() == true) goto L29;
        r104 = true;
    L29:
        if (r104 == false) goto L31;
        extractDso(r103, r112);     // Catch: Throwable -> L33
    L31:
        r103.close();     // Catch: Throwable -> L6
        goto L14
    L40:
        r101.close();
        return;
    L48:
        r102 = DsoManifest.read(r101);     // Catch: Throwable -> L6 Exception -> L47
        goto L10
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String r100, int r101, StrictMode.ThreadPolicy r102) throws IOException {
        Object r103 = getLibraryLock(r100);
        monitor-enter(r103);
        int r104 = loadLibraryFrom(r100, r101, this.soDirectory, r102);     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return r104;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean refreshLocked(FileLocker r110, int r111, byte[] r112) throws IOException {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.soDirectory, STATE_FILE_NAME);
        RandomAccessFile r101 = new RandomAccessFile(r100, "rw");
        byte r102 = r101.readByte();     // Catch: Throwable -> L7 EOFException -> L60
        if (r102 == 1) goto L14;
        Objects.toString(this.soDirectory);     // Catch: Throwable -> L7 EOFException -> L60
    L14:
        r101.close();
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.soDirectory, DEPS_FILE_NAME);
        RandomAccessFile r104 = new RandomAccessFile(r103, "rw");
        int r105 = (int) r104.length();     // Catch: Throwable -> L54
        byte[] r106 = new byte[r105];     // Catch: Throwable -> L54
        if (r104.read(r106) == r105) goto L19;
        r102 = 0;
    L19:
        if (depsChanged(r106, r112) == false) goto L21;
        r102 = 0;
    L21:
        if (r102 != 0) goto L23;
    L26:
        writeState(r100, (byte) 0);     // Catch: Throwable -> L54
        Unpacker r107 = makeUnpacker(r102);     // Catch: Throwable -> L54
        DsoManifest r108 = r107.getDsoManifest();     // Catch: Throwable -> L47
        InputDsoIterator r109 = r107.openDsoIterator();     // Catch: Throwable -> L47
        regenerate(r102, r108, r109);     // Catch: Throwable -> L40
        if (r109 == null) goto L31;
        r109.close();     // Catch: Throwable -> L47
    L31:
        r107.close();     // Catch: Throwable -> L54
    L32:
        r104.close();
        if (r108 != null) goto L35;
        return false;
    L35:
        Runnable r113 = createSyncer(r110, r112, r100, r103, r108, Boolean.FALSE);
        if ((r111 & 1) == 0) goto L38;
        ThreadMethodProxy.start(new PthreadThreadV2(r113, "SoSync:" + this.soDirectory.getName()));
    L39:
        return true;
    L38:
        r113.run();
        goto L39
    L40:
        th = move-exception;
        if (r109 != null) goto L61;
    L46:
        throw th;     // Catch: Throwable -> L47
    L61:
        r109.close();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        if (r107 != null) goto L71;
    L53:
        throw th;     // Catch: Throwable -> L54
    L71:
        r107.close();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L54
        goto L53
    L23:
        if ((r111 & 2) != 0) goto L26;
        r108 = null;
    L54:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L57
    L59:
        throw th;
    L57:
        th = move-exception;
        th.addSuppressed(th);
    L7:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L10
    L12:
        throw th;
    L10:
        th = move-exception;
        th.addSuppressed(th);
    L13:
        r102 = 0;
        goto L14
    }

    private Runnable createSyncer(final FileLocker r110, final byte[] r111, final File r112, final File r113, final DsoManifest r114, final Boolean r115) {
        return new AnonymousClass1(this, r113, r111, r114, r112, r110, r115);
    }
}
