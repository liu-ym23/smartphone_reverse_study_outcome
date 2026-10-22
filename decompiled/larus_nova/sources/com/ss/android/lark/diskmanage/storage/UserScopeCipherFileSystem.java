package com.ss.android.lark.diskmanage.storage;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.vfs.ChainedFileSystem;
import com.ss.android.lark.vfs.FileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.g;
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
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0002)*B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/diskmanage/storage/UserScopeCipherFileSystem;", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "cipherManager", "Lcom/ss/lark/android/encryption/interfaces/ICipherManager;", "onlyDecrypt", "", "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;Lcom/ss/lark/android/encryption/interfaces/ICipherManager;Z)V", "cipherStatus", "", "getName", "", "isEncryptOn", "isStreamCipherOn", "onInstalled", "", "fms", "Lcom/ss/android/lark/vfs/FileSystemManager;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "openInput", "Ljava/io/InputStream;", "getReadFile", "Ljava/io/File;", "openOutput", "Ljava/io/OutputStream;", "append", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "afterWriteCompat", "originalFile", "Lcom/ss/android/lark/vfs/VFSFile;", "beforeReadCompat", "size", "", "encryptFile", "decryptFile", "file", "Companion", "UserScopeCipherFileSystemFactory", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserScopeCipherFileSystem extends ChainedFileSystem {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<String, WeakReference<ReentrantLock>> f420482a = null;
    private final jkc.c cipherManager;
    private int cipherStatus;
    private final boolean onlyDecrypt;

    @UserScope
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/diskmanage/storage/UserScopeCipherFileSystem$UserScopeCipherFileSystemFactory;", "Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;", "cipherManager", "Lcom/ss/lark/android/encryption/interfaces/ICipherManager;", "<init>", "(Lcom/ss/lark/android/encryption/interfaces/ICipherManager;)V", "onlyDecrypt", "", "setOnlyDecrypt", "create", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserScopeCipherFileSystemFactory extends FileSystemManager.FileSystemFactory {
        private final jkc.c cipherManager;
        private boolean onlyDecrypt;

        @Inject
        public UserScopeCipherFileSystemFactory(jkc.c r100) {
            Intrinsics.checkNotNullParameter(r100, "cipherManager");
            this.cipherManager = r100;
        }

        @Override // com.ss.android.lark.vfs.FileSystemManager.FileSystemFactory
        public ChainedFileSystem create(FileSystem r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            return new UserScopeCipherFileSystem(r100, this.cipherManager, this.onlyDecrypt);
        }

        public final UserScopeCipherFileSystemFactory setOnlyDecrypt(boolean r100) {
            this.onlyDecrypt = r100;
            return this;
        }
    }

    public static final class a {
        public a() {
        }

        public static Lock a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            WeakHashMap r101 = UserScopeCipherFileSystem.access$getFileLockCache$cp();
            monitor-enter(r101);
            WeakReference r102 = (WeakReference) UserScopeCipherFileSystem.access$getFileLockCache$cp().get(r100);     // Catch: Throwable -> L12
            if (r102 == null) goto L7;
            Lock r103 = (Lock) r102.get();     // Catch: Throwable -> L12
        L8:
            if (r103 != null) goto L10;
            r103 = new ReentrantLock();     // Catch: Throwable -> L12
            UserScopeCipherFileSystem.access$getFileLockCache$cp().put(r100, new WeakReference(r103));     // Catch: Throwable -> L12
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

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public String getName() {
        return "KAFileEncryptFileSystem";
    }

    static {
        Companion = new a();
        f420482a = new WeakHashMap();
    }

    public static final /* synthetic */ WeakHashMap access$getFileLockCache$cp() {
        return f420482a;
    }

    public final File a(File r110) {
        Log.i("KAFileEncryptFileSystem", "start decrypt file: " + r110.getAbsolutePath());
        Lock r100 = null;
        PolarisFileWrapper r101 = null;
        r100 = null;
        a r102 = Companion;     // Catch: Throwable -> L16 DecryptException -> L18
        String r103 = r110.getAbsolutePath();     // Catch: Throwable -> L16 DecryptException -> L18
        r102.getClass();     // Catch: Throwable -> L16 DecryptException -> L18
        Lock r104 = a.a(r103);     // Catch: Throwable -> L16 DecryptException -> L18
        r104.lock();     // Catch: Throwable -> L12 DecryptException -> L14
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L12 DecryptException -> L14
        com.ss.android.lark.storage.monitor.b.f441102a.getClass();     // Catch: Throwable -> L12 DecryptException -> L14
        PolarisFileWrapper r106 = new PolarisFileWrapper((String) this.cipherManager.m3(r110).second);     // Catch: Throwable -> L12 DecryptException -> L14
        Intrinsics.checkNotNullParameter(r110, "file");     // Catch: DecryptException -> L10 Throwable -> L12
        long r111 = System.currentTimeMillis() - r105;     // Catch: DecryptException -> L10 Throwable -> L12
        if (Intrinsics.areEqual(r106.getPath(), r110.getPath()) == true) goto L8;
        Log.i("KAFileEncryptFileSystem", "decrypt success, cost: " + r111 + ", " + r110.getAbsolutePath() + "\n  -> " + r106.getAbsolutePath());     // Catch: DecryptException -> L10 Throwable -> L12
    L9:
        r104.unlock();
    L24:
        if (r106 != null) goto L27;
        return r110;
    L27:
        return r106;
    L8:
        Log.i("KAFileEncryptFileSystem", "not encrypt file: " + r110.getAbsolutePath());     // Catch: DecryptException -> L10 Throwable -> L12
    L10:
        e = e;
        r101 = r106;
    L15:
        PolarisFileWrapper r107 = r101;
        r100 = r104;
    L20:
        com.ss.android.lark.storage.monitor.b r108 = com.ss.android.lark.storage.monitor.b.f441102a;     // Catch: Throwable -> L16
        e.getErrorCode();     // Catch: Throwable -> L16
        r108.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r110, "file");     // Catch: Throwable -> L16
        Log.e("KAFileEncryptFileSystem", "decrypt fail: " + r110.getAbsolutePath());     // Catch: Throwable -> L16
        if (r100 == null) goto L23;
        r100.unlock();
    L23:
        r106 = r107;
    L12:
        th = th;
    L29:
        if (r104 == null) goto L31;
        r104.unlock();
    L31:
        throw th;
    L14:
        e = e;
    L18:
        e = e;
        r107 = null;
    L16:
        th = th;
        r104 = r100;
        goto L29
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
        if (this.onlyDecrypt == true) goto L33;
        int r100 = this.cipherStatus;
        boolean r101 = true;
        if (r100 == 1) goto L9;
        if (r100 == 0) goto L9;
        this.cipherStatus = this.cipherManager.o1();
    L9:
        if (this.cipherStatus == 1) goto L12;
        r101 = false;
    L12:
        if (r101 == false) goto L36;
        Log.i("KAFileEncryptFileSystem", "start encrypt file: " + r110.getAbsolutePath());
        Lock r102 = null;
        a r103 = Companion;     // Catch: Throwable -> L23 EncryptException -> L25
        String r111 = r110.getAbsolutePath();     // Catch: Throwable -> L23 EncryptException -> L25
        r103.getClass();     // Catch: Throwable -> L23 EncryptException -> L25
        r102 = a.a(r111);     // Catch: Throwable -> L23 EncryptException -> L25
        r102.lock();     // Catch: Throwable -> L23 EncryptException -> L25
        long r104 = r110.lastModified();     // Catch: Throwable -> L23 EncryptException -> L25
        long r112 = System.currentTimeMillis();     // Catch: Throwable -> L23 EncryptException -> L25
        com.ss.android.lark.storage.monitor.b.f441102a.getClass();     // Catch: Throwable -> L23 EncryptException -> L25
        int r113 = this.cipherManager.Q9(r110);     // Catch: Throwable -> L23 EncryptException -> L25
        if (r113 == 0) goto L18;
        Log.e("KAFileEncryptFileSystem", "encrypt file failed. file=" + r110.getAbsolutePath() + ", code=" + r113);     // Catch: Throwable -> L23 EncryptException -> L25
    L18:
        Intrinsics.checkNotNullParameter(r110, "file");     // Catch: Throwable -> L23 EncryptException -> L25
        long r114 = r110.lastModified();     // Catch: Throwable -> L23 EncryptException -> L25
        long r115 = System.currentTimeMillis() - r112;     // Catch: Throwable -> L23 EncryptException -> L25
        if (r104 != r114) goto L21;
        Log.w("KAFileEncryptFileSystem", "encrypt status is open, but encrypt not worked, may file is encrypt already. " + r110.getAbsolutePath());     // Catch: Throwable -> L23 EncryptException -> L25
    L28:
        r102.unlock();
        return;
    L21:
        Log.w("KAFileEncryptFileSystem", "encrypt file success, cost:" + r115 + ", " + r110);     // Catch: Throwable -> L23 EncryptException -> L25
    L23:
        th = move-exception;
        if (0 == 0) goto L32;
        r102.unlock();
    L32:
        throw th;
    L25:
        e = move-exception;
        com.ss.android.lark.storage.monitor.b r105 = com.ss.android.lark.storage.monitor.b.f441102a;     // Catch: Throwable -> L23
        e.getErrorCode();     // Catch: Throwable -> L23
        r105.getClass();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r110, "file");     // Catch: Throwable -> L23
        Log.e("KAFileEncryptFileSystem", "encrypt file failed: " + r110.getAbsolutePath(), e);     // Catch: Throwable -> L23
        if (0 != 0) goto L28;
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
        Log.i("KAFileEncryptFileSystem", "openInput: " + r100.getRealPath());
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
        return new PolarisFileWrapper((String) this.cipherManager.m3(super.getReadFile(r100)).second).length();
    }

    public static final /* synthetic */ void access$encryptFile(UserScopeCipherFileSystem r100, File r101) {
        r100.b(r101);
    }

    public static final /* synthetic */ File access$getWriteFile$s17248747(UserScopeCipherFileSystem r100, VFSPath r101) {
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
        Log.i("KAFileEncryptFileSystem", "openOutput: " + r100.getRealPath() + ", append:" + r101);
        if (this.onlyDecrypt == false) goto L7;
        if (r101 == false) goto L10;
        return new PolarisFileOutputStreamWrapper(a(getWriteFile(r100)));
    L10:
        return super.openOutput(r100, r101);
    L7:
        f.f490295a.f490292a.b();
        return new g(super.openOutput(r100, r101), new UserScopeCipherFileSystem$openOutput$outputStream$2(this, r100));
    }

    @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
    public RandomAccessFile randomAccessFile(VFSPath r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "mode");
        File r102 = getReadFile(r100);
        return super.randomAccessFile(VFSFiles.f444819b.t(r102), r101);
    }

    public UserScopeCipherFileSystem(FileSystem r100, jkc.c r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "cipherManager");
        super(r100);
        this.cipherManager = r101;
        this.onlyDecrypt = r102;
        this.cipherStatus = -1;
    }

    public /* synthetic */ UserScopeCipherFileSystem(FileSystem r100, jkc.c r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        this(r100, r101, r102);
    }
}
