package qfc;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f532800a;

    @Override // qfc.w.a
    public final void b() {
        w.b(this.f532800a);
    }

    public k(w r100) {
        this.f532800a = r100;
    }

    @Override // qfc.w.a
    public final void c(RectF r100) {
        w.a(this.f532800a, r100);
    }

    @Override // qfc.w.a
    public final void a(float r100, float r101) {
        w r102 = this.f532800a;
        RectF r103 = r102.f532827j;
        float r104 = r103.top;
        if ((r101 - r104) > r102.B) goto L5;
        return;
    L5:
        if (r102.f532843z == false) goto L9;
        float r105 = r103.right - ((r101 - r104) / r102.A);
        if (r105 < r102.f532828k.a().left) goto L10;
        RectF r106 = this.f532800a.f532827j;
        r106.left = r105;
        r106.bottom = r101;
    L10:
        this.f532800a.h();
        return;
    L9:
        r103.bottom = r101;
        goto L10
    }
}
