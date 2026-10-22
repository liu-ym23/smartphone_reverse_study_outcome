package pc7;

import com.bytedance.sdk.account.twiceverify.TwiceVerifyActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends q26.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TwiceVerifyActivity f528536a;

    public a(TwiceVerifyActivity r100) {
        this.f528536a = r100;
    }

    @Override // q26.e.a, q26.e
    public final void c(q26.d r100) {
        d.a("TwiceVerifyActivity", "IBulletUILifecycleListener onClose called");
        TwiceVerifyActivity r101 = this.f528536a;
        int r102 = TwiceVerifyActivity.f269520f;
        r101.y1(5, "web page close cause bullet.onClose");
    }
}
