package xk5;

import ay4.d;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ee.util.io.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements u45.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ c b;

    public final void a(int r1) {
    }

    public final void onStart() {
    }

    public final void b(VFSPath r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        c r0 = this.b;
        String r1 = this.a;
        r0.getClass();
        boolean r2 = c.b(r1);
        tt5.a.h("OnBoardingImageDownloader", "isZipFile : " + r2);
        if (r2 == false) goto L29;
        VFSFile r3 = r0.b.toFile();
        ZipInputStream r4 = null;
        VFSFile r5 = r0.b.toFile();     // Catch: Throwable -> L20 Exception -> L22
        if (r5.exists() == true) goto L11;
        r5.mkdirs();     // Catch: Throwable -> L20 Exception -> L22
    L13:
        ZipInputStream r7 = new ZipInputStream(d.a().l(r6));     // Catch: Throwable -> L20 Exception -> L22
        f.a(r7, r3.getAbsolutePath());     // Catch: Throwable -> L16 Exception -> L18
        com.suite.lark.component.storage.ext.b.delete(r6);     // Catch: Throwable -> L16 Exception -> L18
        FileUtils.d(r7);
        tt5.a.h("OnBoardingImageDownloader", "unzip successfully.");
        goto L29
    L18:
        Exception e = e;
        r4 = r7;
    L24:
        tt5.a.e("OnBoardingImageDownloader", "unzip failed", e, false);     // Catch: Throwable -> L20
        FileUtils.d(r4);
    L16:
        th = th;
    L27:
        FileUtils.d(r7);
        throw th;
    L11:
        if (r5.isFile() == false) goto L13;
        r5.delete();     // Catch: Throwable -> L20 Exception -> L22
        r5.mkdirs();     // Catch: Throwable -> L20 Exception -> L22
    L22:
        e = move-exception;
        e = e;
    L20:
        th = th;
        r7 = r4;
    L29:
        tt5.a.h("OnBoardingImageDownloader", "updateProgress SUCCESS: temoFile length: " + com.suite.lark.component.storage.ext.b.e(r6) + "; path: " + du5.b.g(r6.getRealPath()));
    }

    public final void c(Exception r4) {
        tt5.a.e("OnBoardingImageDownloader", "onFailed :", r4, false);
    }

    public b(c r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
