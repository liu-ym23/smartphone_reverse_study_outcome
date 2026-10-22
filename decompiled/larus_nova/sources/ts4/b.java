package ts4;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f547389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f547390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f547391c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f547391c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        a r100 = this.f547390b;
        View r101 = r100.f547379e;
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = false;
        if (r101 != null) goto L9;
        int r103 = 0;
    L12:
        a r104 = this.f547390b;
        View r105 = r104.f547379e;
        if (r105 != null) goto L16;
    L23:
        if (r102 == false) goto L34;
        int r106 = this.f547389a;
        if (r106 == r103) goto L35;
        a r107 = this.f547390b;
        int r108 = r106 - r103;
        View r109 = r107.f547379e;
        if (r109 != null) goto L30;
        return;
    L30:
        if (r107.f547376b != 1) goto L32;
        r109.setTranslationY(r109.getTranslationY() + r108);
        return;
    L32:
        r109.setTranslationX(r109.getTranslationX() + r108);
        return;
    L35:
        return;
    L34:
        return;
    L16:
        if (r104.f547376b != 1) goto L21;
        if (r105.getTranslationY() >= 0.0f) goto L23;
    L22:
        r102 = true;
        goto L23
    L21:
        if (r105.getTranslationX() >= 0.0f) goto L23;
    L9:
        if (r100.f547376b != 1) goto L11;
        r103 = r101.getHeight();
        goto L12
    L11:
        r103 = r101.getWidth();
        goto L12
    }

    public b(a r100, View r101) {
        this.f547390b = r100;
        this.f547391c = r101;
        View r102 = r100.f547379e;
        if (r102 != null) goto L6;
        int r103 = 0;
    L9:
        this.f547389a = r103;
        return;
    L6:
        if (r100.f547376b != 1) goto L8;
        r103 = r102.getHeight();
        goto L9
    L8:
        r103 = r102.getWidth();
        goto L9
    }
}
