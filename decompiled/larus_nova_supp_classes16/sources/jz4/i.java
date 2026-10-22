package jz4;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.doc.screenshot.plugin.OfficeDocShotPresenter;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends kz4.c {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ OfficeDocShotPresenter d;

    public final void b() {
        OfficeDocShotPresenter r0 = this.d;
        if (r0.b == false) goto L15;
        boolean r2 = true;
        if (r0.o.get() < 1) goto L16;
        FragmentActivity r1 = r0.d;
        if (r1 != null) goto L9;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L17;
        r0.o.decrementAndGet();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).r(r0.d);
        return;
    L17:
        return;
    L9:
        if (r1.isFinishing() == true) goto L11;
    L16:
        return;
    }

    public final void a(String r9, int r10) {
        OfficeDocShotPresenter r0 = this.d;
        if (r0.a == false) goto L5;
        OfficeDocShotPresenter.a(r0, true);
    L5:
        tt5.a.d("OfficeDocShotPresenter", "code:-1, errorInfo :" + r9);
        this.d.d(r9, null);
        OfficeDocShotPresenter.b(this.d, this.a, this.b, this.c, 1, r10);
    }

    public final void c(VFSPath r10, float r11, int r12) {
        OfficeDocShotPresenter r0 = this.d;
        if (r0.a == false) goto L5;
        OfficeDocShotPresenter.a(r0, true);
    L5:
        OfficeDocShotPresenter r1 = this.d;
        WebView r2 = r1.e;
        if (r2 == null) goto L8;
        r2.scrollTo(0, r1.f);
    L8:
        tt5.a.h("OfficeDocShotPresenter", "docShotSuccess()..");
        wz4.c r3 = r1.q;
        if (r3 == null) goto L12;
        if (r10 == null) goto L12;
        r3.onSnapshotSuccess(r10.getAbsolutePath(), r11);
        r1.q = null;
    L12:
        if (r10 == null) goto L14;
        r1.m = r10;
    L14:
        r1.g(0, "success", null);
        r1.e(1, r1.e);
        OfficeDocShotPresenter.b(this.d, this.a, this.b, this.c, 0, r12);
    }

    public i(OfficeDocShotPresenter r1, int r2, int r3, int r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
