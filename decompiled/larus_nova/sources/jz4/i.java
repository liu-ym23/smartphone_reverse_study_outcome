package jz4;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.doc.screenshot.plugin.OfficeDocShotPresenter;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes16.dex */
public final class i extends kz4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f501191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f501192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f501193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OfficeDocShotPresenter f501194d;

    public final void b() {
        OfficeDocShotPresenter r100 = this.f501194d;
        if (r100.f218120b == false) goto L15;
        boolean r101 = true;
        if (r100.f218133o.get() < 1) goto L16;
        FragmentActivity r102 = r100.f218122d;
        if (r102 != null) goto L9;
    L11:
        r101 = false;
    L12:
        if (r101 == false) goto L17;
        r100.f218133o.decrementAndGet();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).r(r100.f218122d);
        return;
    L17:
        return;
    L9:
        if (r102.isFinishing() == true) goto L11;
    L16:
        return;
    }

    public final void a(String r100, int r110) {
        OfficeDocShotPresenter r101 = this.f501194d;
        if (r101.f218119a == false) goto L5;
        OfficeDocShotPresenter.a(r101, true);
    L5:
        tt5.a.d("OfficeDocShotPresenter", "code:-1, errorInfo :" + r100);
        this.f501194d.d(r100, null);
        OfficeDocShotPresenter.b(this.f501194d, this.f501191a, this.f501192b, this.f501193c, 1, r110);
    }

    public final void c(VFSPath r110, float r111, int r112) {
        OfficeDocShotPresenter r100 = this.f501194d;
        if (r100.f218119a == false) goto L5;
        OfficeDocShotPresenter.a(r100, true);
    L5:
        OfficeDocShotPresenter r101 = this.f501194d;
        WebView r102 = r101.f218123e;
        if (r102 == null) goto L8;
        r102.scrollTo(0, r101.f218124f);
    L8:
        tt5.a.h("OfficeDocShotPresenter", "docShotSuccess()..");
        wz4.c r103 = r101.f218135q;
        if (r103 == null) goto L12;
        if (r110 == null) goto L12;
        r103.onSnapshotSuccess(r110.getAbsolutePath(), r111);
        r101.f218135q = null;
    L12:
        if (r110 == null) goto L14;
        r101.f218131m = r110;
    L14:
        r101.g(0, "success", null);
        r101.e(1, r101.f218123e);
        OfficeDocShotPresenter.b(this.f501194d, this.f501191a, this.f501192b, this.f501193c, 0, r112);
    }

    public i(OfficeDocShotPresenter r100, int r101, int r102, int r103) {
        this.f501194d = r100;
        this.f501191a = r101;
        this.f501192b = r102;
        this.f501193c = r103;
    }
}
