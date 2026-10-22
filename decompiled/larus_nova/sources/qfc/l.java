package qfc;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f532801a;

    @Override // qfc.w.a
    public final void b() {
        w.b(this.f532801a);
    }

    public l(w r100) {
        this.f532801a = r100;
    }

    @Override // qfc.w.a
    public final void c(RectF r100) {
        w.a(this.f532801a, r100);
    }

    @Override // qfc.w.a
    public final void a(float r100, float r101) {
        w r102 = this.f532801a;
        RectF r103 = r102.f532827j;
        float r104 = r103.right;
        if ((r104 - r100) > w.E) goto L5;
        return;
    L5:
        if (r102.f532843z == false) goto L7;
        r103.bottom = (r102.A * (r104 - r100)) + r103.top;
    L7:
        r103.left = r100;
        r102.h();
    }
}
