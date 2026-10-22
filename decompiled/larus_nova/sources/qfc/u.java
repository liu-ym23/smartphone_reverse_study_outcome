package qfc;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class u implements w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f532816a;

    @Override // qfc.w.a
    public final void b() {
        w.b(this.f532816a);
    }

    public u(w r100) {
        this.f532816a = r100;
    }

    @Override // qfc.w.a
    public final void c(RectF r100) {
        w.a(this.f532816a, r100);
    }

    @Override // qfc.w.a
    public final void a(float r100, float r101) {
        w r102 = this.f532816a;
        boolean r103 = true;
        boolean r104 = false;
        if (r102.f532843z == false) goto L8;
        RectF r105 = r102.f532827j;
        float r106 = r105.left;
        if ((r100 - r106) <= w.E) goto L7;
        r105.right = r100;
        r105.bottom = (r102.A * (r100 - r106)) + r105.top;
    L15:
        if (r103 == false) goto L18;
        r102.h();
        return;
    L18:
        return;
    L7:
        r103 = false;
        goto L15
    L8:
        RectF r107 = r102.f532827j;
        float r108 = r100 - r107.left;
        int r109 = w.E;
        if (r108 <= r109) goto L12;
        r107.right = r100;
        r104 = true;
    L12:
        if ((r101 - r107.top) <= r109) goto L14;
        r107.bottom = r101;
        goto L15
    L14:
        r103 = r104;
        goto L15
    }
}
