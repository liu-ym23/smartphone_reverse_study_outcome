package com.obric.oui.tab;

import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OTabLayoutBase f403226a;

    public a(OTabLayoutBase r100, int r101) {
        this.f403226a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        OTabLayoutBase r103 = this.f403226a;
        FastOutSlowInInterpolator r104 = OTabLayoutBase.I2;
        r103.getClass();
        this.f403226a.postInvalidate();
        return false;
    L5:
        if (r102 != 1) goto L7;
    L9:
        OTabLayoutBase r105 = this.f403226a;
        FastOutSlowInInterpolator r106 = OTabLayoutBase.I2;
        r105.getClass();
        this.f403226a.postInvalidate();
        return false;
    L7:
        if (r102 == 3) goto L9;
        return false;
    }
}
