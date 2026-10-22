package fz4;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.doc.screenshot.DocShotPresenter;
import com.bytedance.ee.bear.doc.screenshot.DocShotView;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes16.dex */
public final class x extends hz4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f479381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f479382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f479383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DocShotPresenter f479384d;

    public final void b() {
        DocShotPresenter r100 = this.f479384d;
        if (r100.f218091t == false) goto L15;
        boolean r101 = true;
        if (r100.f218093v.get() < 1) goto L16;
        FragmentActivity r102 = r100.f218076e;
        if (r102 != null) goto L9;
    L11:
        r101 = false;
    L12:
        if (r101 == false) goto L17;
        r100.f218093v.decrementAndGet();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).r(r100.f218076e);
        return;
    L17:
        return;
    L9:
        if (r102.isFinishing() == true) goto L11;
    L16:
        return;
    }

    public final void a(String r100, int r110) {
        DocShotPresenter r101 = this.f479384d;
        if (r101.f218090s == false) goto L5;
        DocShotPresenter.a(r101, true);
    L5:
        tt5.a.d("DocShotPresenter", "code:-1, errorInfo :" + r100);
        this.f479384d.i(r100, null);
        DocShotPresenter.b(this.f479384d, this.f479381a, this.f479382b, this.f479383c, 1, r110);
    }

    public final void c(VFSPath r110, float r111, int r112) {
        DocShotPresenter r100 = this.f479384d;
        if (r100.f218090s == false) goto L5;
        DocShotPresenter.a(r100, true);
    L5:
        DocShotPresenter r101 = this.f479384d;
        WebView r102 = r101.f218078g;
        if (r102 == null) goto L8;
        r102.scrollTo(0, r101.f218094w);
    L8:
        tt5.a.h("DocShotPresenter", "docShotSuccess()..");
        if (r101.f218077f == null) goto L11;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().getClass();
        km5.c.d();
        ((DocShotView) r101.f218077f).e(r110, r111);
    L11:
        com.bytedance.ee.bear.contract.m.b r113 = r101.f218074c;
        if (r113 == null) goto L14;
        com.bytedance.ee.bear.document.export.e.d(((com.bytedance.ee.bear.document.export.a.C3128a) r113).f219691a.f219690c, "jpg_long");
        r101.f218074c = null;
    L14:
        if (r110 == null) goto L16;
        r101.f218079h = r110;
        r101.f218080i = null;
    L16:
        r101.l(0, "success", null);
        r101.j(1, r101.f218078g);
        DocShotPresenter.b(this.f479384d, this.f479381a, this.f479382b, this.f479383c, 0, r112);
    }

    public x(DocShotPresenter r100, int r101, int r102, int r103) {
        this.f479384d = r100;
        this.f479381a = r101;
        this.f479382b = r102;
        this.f479383c = r103;
    }
}
