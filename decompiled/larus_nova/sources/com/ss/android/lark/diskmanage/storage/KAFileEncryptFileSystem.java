package com.ss.android.lark.diskmanage.storage;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.ChainedFileSystem;
import com.ss.android.lark.vfs.FileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.g;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import com.ss.lark.android.encryption.exception.EncryptException;
import ikc.f;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0002()B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/diskmanage/storage/KAFileEncryptFileSystem;", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "onlyDecrypt", "", "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;Z)V", "TAG", "", "cipherStatus", "", "getName", "isEncryptOn", "isStreamCipherOn", "onInstalled", "", "fms", "Lcom/ss/android/lark/vfs/FileSystemManager;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "openInput", "Ljava/io/InputStream;", "getReadFile", "Ljava/io/File;", "openOutput", "Ljava/io/OutputStream;", "append", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "afterWriteCompat", "originalFile", "Lcom/ss/android/lark/vfs/VFSFile;", "beforeReadCompat", "size", "", "encryptFile", "decryptFile", "file", "Companion", "KAFileEncryptFileSystemFactory", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KAFileEncryptFileSystem extends ChainedFileSystem {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<String, WeakReference<ReentrantLock>> f420479a = null;
    private final String TAG;
    private int cipherStatus;
    private final boolean onlyDecrypt;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/diskmanage/storage/KAFileEncryptFileSystem$KAFileEncryptFileSystemFactory;", "Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;", "onlyDecrypt", "", "<init>", "(Z)V", "create", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class KAFileEncryptFileSystemFactory extends FileSystemManager.FileSystemFactory {
        private final boolean onlyDecrypt;

        public KAFileEncryptFileSystemFactory() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public KAFileEncryptFileSystemFactory(boolean r100) {
            this.onlyDecrypt = r100;
        }

        @Override // com.ss.android.lark.vfs.FileSystemManager.FileSystemFactory
        public ChainedFileSystem create(FileSystem r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            return new KAFileEncryptFileSystem(r100, this.onlyDecrypt);
        }

        public /* synthetic */ KAFileEncryptFileSystemFactory(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    public static final class a {
        public a() {
        }

        public static Lock a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            WeakHashMap r101 = KAFileEncryptFileSystem.access$getFileLockCache$cp();
            monitor-enter(r101);
            WeakReference r102 = (WeakReference) KAFileEncryptFileSystem.access$getFileLockCache$cp().get(r100);     // Catch: Throwable -> L12
            if (r102 == null) goto L7;
            Lock r103 = (Lock) r102.get();     // Catch: Throwable -> L12
        L8:
            if (r103 != null) goto L10;
            r103 = new ReentrantLock();     // Catch: Throwable -> L12
            KAFileEncryptFileSystem.access$getFileLockCache$cp().put(r100, new WeakReference(r103));     // Catch: Throwable -> L12
        L10:
            monitor-exit(r101);
            return r103;
        L7:
            r103 = null;
        L12:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = new a();
        f420479a = new WeakHashMap();
    }

    public static final /* synthetic */ WeakHashMap access$getFileLockCache$cp() {
        return f420479a;
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public String getName() {
        return this.TAG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final File a(File r110) {
        Log.i(this.TAG, "start decrypt file: " + r110.getAbsolutePath());
        PolarisFileWrapper r100 = null;
        Lock r101 = null;
        a r102 = Companion;     // Catch: Throwable -> L13 DecryptException -> L15
        String r103 = r110.getAbsolutePath();     // Catch: Throwable -> L13 DecryptException -> L15
        r102.getClass();     // Catch: Throwable -> L13 DecryptException -> L15
        Lock r104 = a.a(r103);     // Catch: Throwable -> L13 DecryptException -> L15
        r104.lock();     // Catch: Throwable -> L9 DecryptException -> L11
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L9 DecryptException -> L11
        com.ss.android.lark.storage.monitor.b.f441102a.getClass();     // Catch: Throwable -> L9 DecryptException -> L11
        r100 = CipherManager.e(r110, false);     // Catch: Throwable -> L9 DecryptException -> L11
        Intrinsics.checkNotNullParameter(r110, "file");     // Catch: Throwable -> L9 DecryptException -> L11
        long r106 = System.currentTimeMillis() - r105;     // Catch: Throwable -> L9 DecryptException -> L11
        if (Intrinsics.areEqual(r100.getPath(), r110.getPath()) == true) goto L7;
        Log.i(this.TAG, "decrypt success, cost: " + r106 + ", " + r110.getAbsolutePath() + "\n  -> " + r100.getAbsolutePath());     // Catch: Throwable -> L9 DecryptException -> L11
    L8:
        r104.unlock();
    L21:
        if (r100 != null) goto L24;
        return r110;
    L24:
        return r100;
    L7:
        Log.i(this.TAG, "not encrypt file: " + r110.getAbsolutePath());     // Catch: Throwable -> L9 DecryptException -> L11
    L11:
        e = e;
        r101 = r104;
    L17:
        com.ss.android.lark.storage.monitor.b r107 = com.ss.android.lark.storage.monitor.b.f441102a;     // Catch: Throwable -> L13
        e.getErrorCode();     // Catch: Throwable -> L13
        r107.getClass();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r110, "file");     // Catch: Throwable -> L13
        Log.e(this.TAG, "decrypt fail: " + r110.getAbsolutePath());     // Catch: Throwable -> L13
        if (r101 == null) goto L20;
        r101.unlock();
    L20:
        r100 = null;
    L9:
        th = th;
    L26:
        if (r104 == 0) goto L28;
        r104.unlock();
    L28:
        throw th;
    L13:
        th = th;
        r104 = r100;
    L15:
        e = e;
        goto L17
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public File afterWriteCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        File r101 = super.afterWriteCompat(r100);
        if (this.onlyDecrypt == true) goto L5;
        b(r101);
    L5:
        return r101;
    }

    public final void b(File r110) {
        if (this.onlyDecrypt == true) goto L30;
        int r100 = this.cipherStatus;
        boolean r101 = true;
        if (r100 == 1) goto L9;
        if (r100 == 0) goto L9;
        this.cipherStatus = CipherManager.d();
    L9:
        if (this.cipherStatus == 1) goto L12;
        r101 = false;
    L12:
        if (r101 == false) goto L36;
        Log.i(this.TAG, "start encrypt file: " + r110.getAbsolutePath());
        Lock r102 = null;
        a r103 = Companion;     // Catch: Throwable -> L20 EncryptException -> L22
        String r104 = r110.getAbsolutePath();     // Catch: Throwable -> L20 EncryptException -> L22
        r103.getClass();     // Catch: Throwable -> L20 EncryptException -> L22
        r102 = a.a(r104);     // Catch: Throwable -> L20 EncryptException -> L22
        r102.lock();     // Catch: Throwable -> L20 EncryptException -> L22
        long r105 = r110.lastModified();     // Catch: Throwable -> L20 EncryptException -> L22
        long r106 = System.currentTimeMillis();     // Catch: Throwable -> L20 EncryptException -> L22
        com.ss.android.lark.storage.monitor.b.f441102a.getClass();     // Catch: Throwable -> L20 EncryptException -> L22
        CipherManager.c(r110);     // Catch: Throwable -> L20 EncryptException -> L22
        Intrinsics.checkNotNullParameter(r110, "file");     // Catch: Throwable -> L20 EncryptException -> L22
        long r107 = r110.lastModified();     // Catch: Throwable -> L20 EncryptException -> L22
        long r111 = System.currentTimeMillis() - r106;     // Catch: Throwable -> L20 EncryptException -> L22
        if (r105 != r107) goto L18;
        Log.w(this.TAG, "encrypt status is open, but encrypt not worked, may file is encrypt already. " + r110);     // Catch: Throwable -> L20 EncryptException -> L22
    L33:
    L25:
        r102.unlock();
        return;
    L18:
        Log.w(this.TAG, "encrypt file success, cost:" + r111 + ", " + r110);     // Catch: Throwable -> L20 EncryptException -> L22
    L20:
        th = move-exception;
        if (r102 == null) goto L29;
        r102.unlock();
    L29:
        throw th;
    L22:
        e = move-exception;
        com.ss.android.lark.storage.monitor.b r108 = com.ss.android.lark.storage.monitor.b.f441102a;     // Catch: Throwable -> L20
        e.getErrorCode();     // Catch: Throwable -> L20
        r108.getClass();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r110, "file");     // Catch: Throwable -> L20
        Log.e(this.TAG, "encrypt file failed: " + r110, e);     // Catch: Throwable -> L20
        if (r102 != null) goto L25;
        return;
    L36:
        return;
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public File beforeReadCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return a(super.beforeReadCompat(r100));
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public File getReadFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return a(super.getReadFile(r100));
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public InputStream openInput(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Log.i(this.TAG, "openInput: " + r100.getRealPath());
        if (this.onlyDecrypt == true) goto L5;
        f.f490295a.f490292a.b();
    L5:
        VFSFiles r101 = VFSFiles.f444819b;
        VFSPath r102 = r101.t(getReadFile(r100));
        if (Intrinsics.areEqual(r102, r100) == false) goto L9;
        return super.openInput(r100);
    L9:
        return r101.l(r102);
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public long size(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return CipherManager.f(super.getReadFile(r100).getAbsolutePath());
    }

    public KAFileEncryptFileSystem(FileSystem r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        super(r100);
        this.onlyDecrypt = r101;
        this.TAG = "KAFileEncryptFileSystem";
        this.cipherStatus = -1;
    }

    public static final /* synthetic */ void access$encryptFile(KAFileEncryptFileSystem r100, File r101) {
        r100.b(r101);
    }

    public static final /* synthetic */ File access$getWriteFile$s17248747(KAFileEncryptFileSystem r100, VFSPath r101) {
        return super.getWriteFile(r101);
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public void onInstalled(FileSystemManager r100, VFSPath r101) {
        Intrinsics.checkNotNullParameter(r100, "fms");
        Intrinsics.checkNotNullParameter(r101, "path");
        super.onInstalled(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public OutputStream openOutput(final VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Log.i(this.TAG, "openOutput: " + r100.getRealPath() + ", append:" + r101);
        if (this.onlyDecrypt == false) goto L7;
        if (r101 == false) goto L10;
        return new PolarisFileOutputStreamWrapper(a(getWriteFile(r100)));
    L10:
        return super.openOutput(r100, r101);
    L7:
        f.f490295a.f490292a.b();
        return new g(super.openOutput(r100, r101), new KAFileEncryptFileSystem$openOutput$outputStream$2(this, r100));
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public RandomAccessFile randomAccessFile(VFSPath r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "mode");
        File r102 = getReadFile(r100);
        return super.randomAccessFile(VFSFiles.f444819b.t(r102), r101);
    }

    public /* synthetic */ KAFileEncryptFileSystem(FileSystem r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}
