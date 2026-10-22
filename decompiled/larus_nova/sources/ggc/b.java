package ggc;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ttapkdiffpatch.applier.ApplyPatchFailException;
import com.ss.android.ttmd5.TTMd5;
import java.io.File;
import java.io.IOException;
import jgc.f;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f481226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f481227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f481228c;

    public final void a() throws ApplyPatchFailException {
        kv7.a.b();
        String r100 = this.f481226a;
        String r101 = this.f481227b;
        String r102 = this.f481228c;
        File r103 = null;
        c.a(r101, "patch file path");     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        c.a(r100, "old apk file path");     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        c.a(r102, "output apk file path");     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        d r104 = hgc.a.d(r101);     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        int r105 = TTMd5.checkMd5(r104.f481234e, new PolarisFileWrapper(r100));     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        if (r105 != 0) goto L35;
        igc.a r106 = c.f481229a;     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        if (r106 == null) goto L33;
        igc.b r107 = ((kgc.a) r106).a(r104.f481233d);     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        if (r107 == null) goto L31;
        d.a r108 = r104.f481237h;     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        File r109 = jgc.d.a("patchTmpFile");     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        r108.a(r109);     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        int r110 = r107.a(r100, r109.getPath(), r102, this);     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        if (r110 != 0) goto L29;
        if (f.a(r102) == false) goto L14;
        boolean r111 = false;
    L15:
        if (r111 == false) goto L27;
        int r112 = TTMd5.checkMd5(r104.f481235f, new PolarisFileWrapper(r102));     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        if (r112 != 0) goto L23;
        if (r109.exists() == false) goto L59;
        r109.delete();
        return;
    L59:
        return;
    L23:
        throw new ApplyPatchFailException(2003, "new apk md5 check fail with error code " + r112);     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
    L27:
        throw new ApplyPatchFailException(2006, "output file not exist with path " + r102);     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
    L14:
        r111 = new PolarisFileWrapper(r102).exists();     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
        goto L15
    L29:
        throw new ApplyPatchFailException(2004, "diff library return result :" + r110);     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
    L31:
        throw new ApplyPatchFailException(2005, String.valueOf(r104.f481233d));     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
    L33:
        throw new ApplyPatchFailException(2001, "you must set diff applier provider before apply!");     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
    L35:
        throw new ApplyPatchFailException(2002, "old apk md5 check fail with error code " + r105);     // Catch: Throwable -> L24 IOException -> L38 ApplyPatchFailException -> L45
    L47:
        th = move-exception;
        if (0 == 0) goto L53;
        if (r103.exists() == false) goto L53;
        r103.delete();
    L53:
        if (f.a(r102) == true) goto L57;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r102);
        if (r113.exists() == false) goto L57;
        r113.delete();
    L57:
        throw th;
    L45:
        e = move-exception;
        throw e;     // Catch: Throwable -> L47
    L38:
        e = move-exception;
        if (jgc.c.a(e) == false) goto L44;
        throw new ApplyPatchFailException(2011, e);     // Catch: Throwable -> L47
    L44:
        throw new ApplyPatchFailException(2010, e);     // Catch: Throwable -> L47
    L24:
        th = move-exception;
        throw new ApplyPatchFailException(2099, th);     // Catch: Throwable -> L47
    }

    public b(String r100, String r101, String r102) {
        this.f481226a = r100;
        this.f481227b = r101;
        this.f481228c = r102;
    }
}
