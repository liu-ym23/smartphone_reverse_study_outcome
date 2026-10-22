package fz4;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.doc.screenshot.DocShotPresenter;
import com.bytedance.ee.bear.doc.screenshot.DocShotView;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x extends hz4.c {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ DocShotPresenter d;

    public final void b() {
        DocShotPresenter r0 = this.d;
        if (r0.t == false) goto L15;
        boolean r2 = true;
        if (r0.v.get() < 1) goto L16;
        FragmentActivity r1 = r0.e;
        if (r1 != null) goto L9;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L17;
        r0.v.decrementAndGet();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).r(r0.e);
        return;
    L17:
        return;
    L9:
        if (r1.isFinishing() == true) goto L11;
    L16:
        return;
    }

    public final void a(String r9, int r10) {
        DocShotPresenter r0 = this.d;
        if (r0.s == false) goto L5;
        DocShotPresenter.a(r0, true);
    L5:
        tt5.a.d("DocShotPresenter", "code:-1, errorInfo :" + r9);
        this.d.i(r9, null);
        DocShotPresenter.b(this.d, this.a, this.b, this.c, 1, r10);
    }

    public final void c(VFSPath r10, float r11, int r12) {
        DocShotPresenter r0 = this.d;
        if (r0.s == false) goto L5;
        DocShotPresenter.a(r0, true);
    L5:
        DocShotPresenter r1 = this.d;
        WebView r2 = r1.g;
        if (r2 == null) goto L8;
        r2.scrollTo(0, r1.w);
    L8:
        tt5.a.h("DocShotPresenter", "docShotSuccess()..");
        if (r1.f == null) goto L11;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().getClass();
        km5.c.d();
        ((DocShotView) r1.f).e(r10, r11);
    L11:
        com.bytedance.ee.bear.contract.m.b r13 = r1.c;
        if (r13 == null) goto L14;
        com.bytedance.ee.bear.document.export.e.d(((com.bytedance.ee.bear.document.export.a.C0072a) r13).a.c, "jpg_long");
        r1.c = null;
    L14:
        if (r10 == null) goto L16;
        r1.h = r10;
        r1.i = null;
    L16:
        r1.l(0, "success", null);
        r1.j(1, r1.g);
        DocShotPresenter.b(this.d, this.a, this.b, this.c, 0, r12);
    }

    public x(DocShotPresenter r1, int r2, int r3, int r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
