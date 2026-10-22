package xk5;

import ay4.d;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ee.util.io.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements u45.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f564213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f564214b;

    @Override // u45.a
    public final void a(int r100) {
    }

    @Override // u45.a
    public final void onStart() {
    }

    @Override // u45.a
    public final void b(VFSPath r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        c r101 = this.f564214b;
        String r102 = this.f564213a;
        r101.getClass();
        boolean r103 = c.b(r102);
        tt5.a.h("OnBoardingImageDownloader", "isZipFile : " + r103);
        if (r103 == false) goto L29;
        VFSFile r104 = r101.f564216b.toFile();
        ZipInputStream r105 = null;
        VFSFile r106 = r101.f564216b.toFile();     // Catch: Throwable -> L20 Exception -> L22
        if (r106.exists() == true) goto L11;
        r106.mkdirs();     // Catch: Throwable -> L20 Exception -> L22
    L13:
        ZipInputStream r107 = new ZipInputStream(d.a().l(r100));     // Catch: Throwable -> L20 Exception -> L22
        f.a(r107, r104.getAbsolutePath());     // Catch: Throwable -> L16 Exception -> L18
        com.suite.lark.component.storage.ext.b.delete(r100);     // Catch: Throwable -> L16 Exception -> L18
        FileUtils.d(r107);
        tt5.a.h("OnBoardingImageDownloader", "unzip successfully.");
        goto L29
    L18:
        Exception e100 = e;
        r105 = r107;
    L24:
        tt5.a.e("OnBoardingImageDownloader", "unzip failed", e100, false);     // Catch: Throwable -> L20
        FileUtils.d(r105);
    L16:
        th = th;
    L27:
        FileUtils.d(r107);
        throw th;
    L11:
        if (r106.isFile() == false) goto L13;
        r106.delete();     // Catch: Throwable -> L20 Exception -> L22
        r106.mkdirs();     // Catch: Throwable -> L20 Exception -> L22
    L22:
        e = move-exception;
        e100 = e;
    L20:
        th = th;
        r107 = r105;
    L29:
        tt5.a.h("OnBoardingImageDownloader", "updateProgress SUCCESS: temoFile length: " + com.suite.lark.component.storage.ext.b.e(r100) + "; path: " + du5.b.g(r100.getRealPath()));
    }

    @Override // u45.a
    public final void c(Exception r100) {
        tt5.a.e("OnBoardingImageDownloader", "onFailed :", r100, false);
    }

    public b(c r100, String r101) {
        this.f564214b = r100;
        this.f564213a = r101;
    }
}
