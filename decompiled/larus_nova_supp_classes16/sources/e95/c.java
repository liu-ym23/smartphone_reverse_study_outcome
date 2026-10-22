package e95;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<V> implements Callable {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public c(b r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public final DriveFilePath call() {
        b r0 = this.a;
        DriveFilePath r2 = r0.a.d;
        String r3 = this.b;
        long r4 = this.c;
        a95.a r6 = r0.b;
        Biz r1 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r1, "biz");
        Intrinsics.checkNotNullParameter("archive", "relativePath");
        DriveFilePath r8 = new DriveFilePath(r1, "archive", "", false);
        UserSession r5 = r6.b;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        z75.a.C0333a r7 = z75.a.a;
        Biz r9 = r8.getBiz();
        String r10 = r8.getRelativePath();
        VFSPath r11 = z75.a.a.a(r9, r10, null, r5);
        long r13 = System.currentTimeMillis();
        VFSFile r12 = z75.b.e(r2, r6.b);
        if (r12 != null) goto L6;
    L26:
        String r14 = null;
    L27:
        tt5.a.h("ArchiveHelper", "extractEntry()...destRootPath = " + r11.getRealPath() + ", md5 = " + r14 + " costTime=" + (System.currentTimeMillis() - r13));
        if (r14 != null) goto L30;
        tt5.a.d("ArchiveHelper", "extractEntry()...srcFileMD5 is null");
    L54:
        return null;
    L30:
        z75.b.c(r8, r14);
        VFSPath r16 = r11.subPath(r14);
        VFSFile r17 = r16.toFile();
        if (r17.exists() == false) goto L35;
        if (r17.isDirectory() == false) goto L35;
    L78:
        int r18 = r3.lastIndexOf(File.separator);     // Catch: Exception -> L42
        if (r18 != (-1)) goto L40;
        r8.cacheName(r3);     // Catch: Exception -> L42
    L44:
        VFSPath r19 = r16.subPath(r3);
        tt5.a.b("ArchiveHelper", "extractEntry()...destEntryFilePath = " + r19.getRealPath());
        VFSFile r20 = r19.toFile();
        boolean r110 = r20.exists();
        if (r110 == true) goto L47;
    L49:
        tt5.a.h("ArchiveHelper", "extractEntry()...entry file not cached or invalidate");
        if (r110 == false) goto L80;
        boolean r21 = r20.delete();
        tt5.a.h("ArchiveHelper", "delete cache file, result = " + r21);
        if (r21 == true) goto L80;
        tt5.a.d("ArchiveHelper", "delete cached file failed");
    L80:
        DriveFilePath r22 = null;
        int r23 = Archive.extractEntry(z75.b.a(r2, r6.b), r3, r16.getRealPath().concat(File.separator), null, 0);     // Catch: IOException -> L65
        if (r23 == 0) goto L63;
        VFSFile r24 = r19.toFile();     // Catch: IOException -> L65
        if (r24.exists() == false) goto L62;
        tt5.a.h("ArchiveHelper", "delete archive file, result = " + r24.delete());     // Catch: IOException -> L65
    L62:
        tt5.a.d("ArchiveHelper", "extract entry failed, code = " + r23);     // Catch: IOException -> L65
    L73:
        return r22;
    L63:
        tt5.a.h("ArchiveHelper", "extractEntry success");     // Catch: IOException -> L65
        return r8;
    L65:
        e = e;
    L69:
        tt5.a.d("ArchiveHelper", "extractEntry()...error = " + e);
        VFSFile r26 = r19.toFile();
        if (r26.exists() == false) goto L73;
        tt5.a.h("ArchiveHelper", "delete error file, result = " + r26.delete());
    L67:
        e = e;
        r22 = null;
        goto L69
    L47:
        if (r20.length() != r4) goto L49;
        tt5.a.h("ArchiveHelper", "extractEntry()...entry file has cached");
        return r8;
    L40:
        String r27 = r3.substring(0, r18);     // Catch: Exception -> L42
        String r28 = r3.substring(r18 + 1);     // Catch: Exception -> L42
        z75.b.c(r8, r27);     // Catch: Exception -> L42
        r8.cacheName(r28);     // Catch: Exception -> L42
    L42:
        e = move-exception;
        tt5.a.d("ArchiveHelper", "extractEntry fail: " + e);
    L35:
        if (r17.mkdirs() == true) goto L78;
        tt5.a.d("ArchiveHelper", "extractEntry()...destRootPath mkdir failed");
        goto L54
    L6:
        if (r12.isFile() == false) goto L26;
        int r111 = 1024;
        byte[] r112 = new byte[1024];
        MessageDigest r113 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L20 Exception -> L22
        PolarisFileInputStreamWrapper r29 = new PolarisFileInputStreamWrapper(r12);     // Catch: Throwable -> L20 Exception -> L22
    L82:
        int r30 = r29.read(r112, 0, r111);     // Catch: Exception -> L18 Throwable -> L74
        if (r30 == (-1)) goto L14;
        r113.update(r112, 0, r30);     // Catch: Exception -> L18 Throwable -> L74
        r111 = 1024;
        goto L82
    L14:
        o.a(new Closeable[]{r29});
        r14 = new BigInteger(1, r113.digest()).toString(16);
    L16:
        if (r14.length() >= 32) goto L27;
        r14 = DiagramData$RESULT.FAIL.concat(r14);
    L18:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L74
        o.a(new Closeable[]{r29});
        goto L26
    L74:
        th = th;
        String r114 = r10;
        int r31 = 1;
    L76:
        Closeable[] r32 = new Closeable[r31];
        r32[0] = r114;
        o.a(r32);
        throw th;
    L22:
        e = e;
        r29 = null;
    L20:
        th = th;
        r31 = 1;
        r114 = null;
        goto L76
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
