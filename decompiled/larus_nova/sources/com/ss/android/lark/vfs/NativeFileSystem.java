package com.ss.android.lark.vfs;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.LynxError;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 32\u00020\u0001:\u0003345B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u0017J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020\u001eJ\u0010\u0010'\u001a\u00020%2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0016J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010.\u001a\u00020%2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u0019H\u0016J\u0010\u00102\u001a\u00020%2\u0006\u00101\u001a\u00020\u0019H\u0016¨\u00066"}, d2 = {"Lcom/ss/android/lark/vfs/NativeFileSystem;", "Lcom/ss/android/lark/vfs/AbstractFileSystem;", "<init>", "()V", "getName", "", "resolvePath", "Lcom/ss/android/lark/vfs/FilePath;", "uri", "Landroid/net/Uri;", "openInput", "Ljava/io/InputStream;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "openOutput", "Ljava/io/OutputStream;", "append", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "list", "", "(Lcom/ss/android/lark/vfs/VFSPath;)[Ljava/lang/String;", "listFiles", "Lcom/ss/android/lark/vfs/VFSFile;", "(Lcom/ss/android/lark/vfs/VFSPath;)[Lcom/ss/android/lark/vfs/VFSFile;", "exists", "delete", "size", "", "lastModified", "createNewFile", "mkdirs", "printErrorEnvInfo", "", "targetDir", "Ljava/io/File;", "getTotalExternalMemorySize", "getReadFile", "getWriteFile", "move", "src", "dest", "isFile", "isDirectory", "toFile", "toString", "afterWriteCompat", "originalFile", "beforeReadCompat", "Companion", "MakeDirFailedException", "MakeDirIsFileException", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NativeFileSystem extends AbstractFileSystem {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<NativeFileSystem> f444814a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/vfs/NativeFileSystem$MakeDirFailedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", LynxError.LYNX_THROWABLE, "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MakeDirFailedException extends Exception {
        public MakeDirFailedException(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100, r101);
        }

        public /* synthetic */ MakeDirFailedException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/vfs/NativeFileSystem$MakeDirIsFileException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", LynxError.LYNX_THROWABLE, "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MakeDirIsFileException extends Exception {
        public MakeDirIsFileException(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100, r101);
        }

        public /* synthetic */ MakeDirIsFileException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public File afterWriteCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return r100;
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public File beforeReadCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return r100;
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public String getName() {
        return "NativeFileSystem";
    }

    static {
        Companion = new a();
        f444814a = LazyKt.lazy(NativeFileSystem$Companion$Default$2.INSTANCE);
    }

    public final long getTotalExternalMemorySize() {
        if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) == false) goto L5;
        StatFs r100 = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (r100.getAvailableBlocksLong() * r100.getBlockSizeLong()) / 1024;
    L5:
        return -1;
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem
    public String toString() {
        return getName();
    }

    public NativeFileSystem() {
    }

    public static final /* synthetic */ Lazy access$getDefault$delegate$cp() {
        return f444814a;
    }

    public static final File a(File r100) {
        if (r100.exists() == true) goto L12;
        File r101 = r100.getParentFile();
        if (r101 == null) goto L9;
        File r102 = a(r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return null;
    L12:
        return r100;
    }

    public static PolarisFileWrapper b(VFSPath r100) {
        return new PolarisFileWrapper(r100.getRealPath());
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public boolean createNewFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        PolarisFileWrapper r101 = b(r100);
        File r102 = r101.getParentFile();
        if (r102 == null) goto L8;
        if (r102.exists() == true) goto L8;
        r102.mkdirs();
    L8:
        return r101.createNewFile();
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public boolean delete(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(r100).delete();
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public boolean exists(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(r100).exists();
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public File getReadFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(r100);
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public File getWriteFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(r100);
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public boolean isDirectory(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(r100).isDirectory();
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public boolean isFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(r100).isFile();
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public long lastModified(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(r100).lastModified();
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public String[] list(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        String[] r101 = b(r100).list();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new String[0];
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public VFSFile[] listFiles(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        File[] r101 = b(r100).listFiles();
        if (r101 == null) goto L10;
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        File r105 = r101[r104];
        VFSFiles r106 = VFSFiles.f444819b;
        Intrinsics.checkNotNull(r105);
        r102.add(new VFSFile(r106.t(r105)));
        r104 = r104 + 1;
        goto L5
    L7:
        VFSFile[] r107 = (VFSFile[]) r102.toArray(new VFSFile[0]);
        if (r107 == null) goto L10;
        return r107;
    L10:
        return new VFSFile[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public boolean mkdirs(VFSPath r110) {
        Intrinsics.checkNotNullParameter(r110, "path");
        PolarisFileWrapper r111 = b(r110);
        String r100 = "";
        String r101 = null;
        Object[] r102 = 0;
        Object[] r103 = 0;
        if (r111.exists() == true) goto L18;
        boolean r104 = r111.mkdirs();
        if (r104 == false) goto L7;
    L16:
        Throwable th10 = null;
    L21:
        if (r104 == false) goto L45;
    L43:
        return r104;
    L45:
        File r105 = a(r111);     // Catch: Throwable -> L37
        int r106 = com.ss.android.lark.storage.monitor.b.a.f441106a;     // Catch: Throwable -> L37
        String r107 = getName();     // Catch: Throwable -> L37
        StringBuilder r108 = new StringBuilder("\n      mkdir failed details:\n      path=");     // Catch: Throwable -> L37
        r108.append(r111.getAbsolutePath());     // Catch: Throwable -> L37
        r108.append("\n      existDir=");     // Catch: Throwable -> L37
        if (r105 == null) goto L26;
        String r112 = r105.getAbsolutePath();     // Catch: Throwable -> L37
    L27:
        r108.append(r112);     // Catch: Throwable -> L37
        r108.append("\n      isDir=");     // Catch: Throwable -> L37
        if (r105 == null) goto L30;
        Boolean r113 = Boolean.valueOf(r105.isDirectory());     // Catch: Throwable -> L37
    L31:
        r108.append(r113);     // Catch: Throwable -> L37
        r108.append("\n      canWrite=");     // Catch: Throwable -> L37
        if (r105 == null) goto L34;
        Boolean r114 = Boolean.valueOf(r105.canWrite());     // Catch: Throwable -> L37
    L35:
        r108.append(r114);     // Catch: Throwable -> L37
        r108.append("\n      mountState=");     // Catch: Throwable -> L37
        r108.append(Environment.getExternalStorageState());     // Catch: Throwable -> L37
        r108.append("\n      leftSpace=");     // Catch: Throwable -> L37
        r108.append(getTotalExternalMemorySize());     // Catch: Throwable -> L37
        r108.append("\n    ");     // Catch: Throwable -> L37
        com.ss.android.lark.storage.monitor.b.a.b(r107, StringsKt.trimIndent(r108.toString()), null, 12);     // Catch: Throwable -> L37
    L39:
        int r115 = com.ss.android.lark.storage.monitor.b.a.f441106a;
        String r116 = getName();
        StringBuilder r109 = new StringBuilder();
        r109.append(r100);
        r109.append(", ");
        if (th10 == null) goto L42;
        r101 = th10.getMessage();
    L42:
        r109.append(r101);
        com.ss.android.lark.storage.monitor.b.a.a(r116, r100, new MakeDirFailedException(r109.toString(), th10), true);
        goto L43
    L34:
        r114 = null;
        goto L35
    L30:
        r113 = null;
        goto L31
    L26:
        r112 = null;
    L37:
        th = move-exception;
        int r117 = com.ss.android.lark.storage.monitor.b.a.f441106a;
        com.ss.android.lark.storage.monitor.b.a.b(getName(), "printErrorEnvInfo error", th, 8);
        goto L39
    L7:
        if (r111.exists() == false) goto L44;
    L20:
        th10 = null;
        r104 = true;
        goto L21
    L44:
    L14:
        th10 = th;
        r100 = "mkdir failed, msg=" + th10.getMessage() + " path=" + r111.getAbsolutePath();
        int r118 = com.ss.android.lark.storage.monitor.b.a.f441106a;
        com.ss.android.lark.storage.monitor.b.a.a(getName(), r100, th10, true);
        goto L21
    L10:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        Files.createDirectories(r111.toPath(), new FileAttribute[0]);     // Catch: Throwable -> L14
        goto L20
    L12:
        r100 = "mkdir failed, path=" + r111.getAbsolutePath();     // Catch: Throwable -> L14
        goto L16
    L18:
        if (r111.isFile() == false) goto L20;
        r100 = "mkdir failed, dir exist but is a file, path:" + r111.getAbsolutePath();
        int r119 = com.ss.android.lark.storage.monitor.b.a.f441106a;
        com.ss.android.lark.storage.monitor.b.a.a(getName(), r100, new MakeDirIsFileException(r100, r103 == true ? 1 : 0, 2, r102 == true ? 1 : 0), true);
        goto L20
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public InputStream openInput(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return new PolarisFileInputStreamWrapper(r100.getRealPath());
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public FilePath resolvePath(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return new FilePath(this, r100, false);
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public long size(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(r100).length();
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public /* bridge */ /* synthetic */ VFSPath resolvePath(Uri r100) {
        return resolvePath(r100);
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public boolean move(VFSPath r100, VFSPath r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        return b(r100).renameTo(b(r101));
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public OutputStream openOutput(VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return new PolarisFileOutputStreamWrapper(r100.getRealPath(), r101);
    }

    @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
    public RandomAccessFile randomAccessFile(VFSPath r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "mode");
        return new RandomAccessFile(r100.getRealPath(), r101);
    }
}
