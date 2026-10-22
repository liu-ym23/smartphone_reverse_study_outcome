package e95;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larksuite.framework.utils.o;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f471496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f471497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f471498c;

    public c(b r100, String r101, long r102) {
        this.f471496a = r100;
        this.f471497b = r101;
        this.f471498c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public final DriveFilePath call() {
        b r100 = this.f471496a;
        DriveFilePath r101 = r100.f471490a.f225836d;
        String r102 = this.f471497b;
        long r103 = this.f471498c;
        a95.a r104 = r100.f471491b;
        Biz r105 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r105, "biz");
        Intrinsics.checkNotNullParameter("archive", "relativePath");
        DriveFilePath r106 = new DriveFilePath(r105, "archive", "", false);
        UserSession r107 = r104.f2278b;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        z75.a.C8426a r108 = z75.a.f570666a;
        Biz r109 = r106.getBiz();
        String r110 = r106.getRelativePath();
        VFSPath r111 = z75.a.f570666a.a(r109, r110, null, r107);
        long r112 = System.currentTimeMillis();
        VFSFile r113 = z75.b.e(r101, r104.f2278b);
        if (r113 != null) goto L6;
    L26:
        String r114 = null;
    L27:
        tt5.a.h("ArchiveHelper", "extractEntry()...destRootPath = " + r111.getRealPath() + ", md5 = " + r114 + " costTime=" + (System.currentTimeMillis() - r112));
        if (r114 != null) goto L30;
        tt5.a.d("ArchiveHelper", "extractEntry()...srcFileMD5 is null");
    L54:
        return null;
    L30:
        z75.b.c(r106, r114);
        VFSPath r115 = r111.subPath(r114);
        VFSFile r116 = r115.toFile();
        if (r116.exists() == false) goto L35;
        if (r116.isDirectory() == false) goto L35;
    L78:
        int r117 = r102.lastIndexOf(File.separator);     // Catch: Exception -> L42
        if (r117 != (-1)) goto L40;
        r106.cacheName(r102);     // Catch: Exception -> L42
    L44:
        VFSPath r118 = r115.subPath(r102);
        tt5.a.b("ArchiveHelper", "extractEntry()...destEntryFilePath = " + r118.getRealPath());
        VFSFile r119 = r118.toFile();
        boolean r120 = r119.exists();
        if (r120 == true) goto L47;
    L49:
        tt5.a.h("ArchiveHelper", "extractEntry()...entry file not cached or invalidate");
        if (r120 == false) goto L80;
        boolean r121 = r119.delete();
        tt5.a.h("ArchiveHelper", "delete cache file, result = " + r121);
        if (r121 == true) goto L80;
        tt5.a.d("ArchiveHelper", "delete cached file failed");
    L80:
        DriveFilePath r122 = null;
        int r123 = Archive.extractEntry(z75.b.a(r101, r104.f2278b), r102, r115.getRealPath().concat(File.separator), null, 0);     // Catch: IOException -> L65
        if (r123 == 0) goto L63;
        VFSFile r124 = r118.toFile();     // Catch: IOException -> L65
        if (r124.exists() == false) goto L62;
        tt5.a.h("ArchiveHelper", "delete archive file, result = " + r124.delete());     // Catch: IOException -> L65
    L62:
        tt5.a.d("ArchiveHelper", "extract entry failed, code = " + r123);     // Catch: IOException -> L65
    L73:
        return r122;
    L63:
        tt5.a.h("ArchiveHelper", "extractEntry success");     // Catch: IOException -> L65
        return r106;
    L65:
        e = e;
    L69:
        tt5.a.d("ArchiveHelper", "extractEntry()...error = " + e);
        VFSFile r125 = r118.toFile();
        if (r125.exists() == false) goto L73;
        tt5.a.h("ArchiveHelper", "delete error file, result = " + r125.delete());
    L67:
        e = e;
        r122 = null;
        goto L69
    L47:
        if (r119.length() != r103) goto L49;
        tt5.a.h("ArchiveHelper", "extractEntry()...entry file has cached");
        return r106;
    L40:
        String r126 = r102.substring(0, r117);     // Catch: Exception -> L42
        String r127 = r102.substring(r117 + 1);     // Catch: Exception -> L42
        z75.b.c(r106, r126);     // Catch: Exception -> L42
        r106.cacheName(r127);     // Catch: Exception -> L42
    L42:
        e = move-exception;
        tt5.a.d("ArchiveHelper", "extractEntry fail: " + e);
    L35:
        if (r116.mkdirs() == true) goto L78;
        tt5.a.d("ArchiveHelper", "extractEntry()...destRootPath mkdir failed");
        goto L54
    L6:
        if (r113.isFile() == false) goto L26;
        int r128 = 1024;
        byte[] r129 = new byte[1024];
        MessageDigest r130 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L20 Exception -> L22
        PolarisFileInputStreamWrapper r131 = new PolarisFileInputStreamWrapper(r113);     // Catch: Throwable -> L20 Exception -> L22
    L82:
        int r132 = r131.read(r129, 0, r128);     // Catch: Exception -> L18 Throwable -> L74
        if (r132 == (-1)) goto L14;
        r130.update(r129, 0, r132);     // Catch: Exception -> L18 Throwable -> L74
        r128 = 1024;
        goto L82
    L14:
        o.a(new Closeable[]{r131});
        r114 = new BigInteger(1, r130.digest()).toString(16);
    L16:
        if (r114.length() >= 32) goto L27;
        r114 = "0".concat(r114);
    L18:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L74
        o.a(new Closeable[]{r131});
        goto L26
    L74:
        th = th;
        String r133 = r110;
        int r134 = 1;
    L76:
        Closeable[] r135 = new Closeable[r134];
        r135[0] = r133;
        o.a(r135);
        throw th;
    L22:
        e = e;
        r131 = null;
    L20:
        th = th;
        r134 = 1;
        r133 = null;
        goto L76
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
