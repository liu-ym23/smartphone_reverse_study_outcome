package com.bytedance.android.shopping.anchorv4.voavhs.car;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ AnchorV4CarAddressView c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        float r0 = this.a / this.b;
        AnchorV4CarAddressView.a(this.c).setPivotX(0.0f);
        AnchorV4CarAddressView.a(this.c).setPivotY(0.0f);
        AnchorV4CarAddressView.a(this.c).setScaleX(r0);
        AnchorV4CarAddressView.a(this.c).setScaleY(r0);
        AnchorV4CarAddressView.a(this.c).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        float r1 = r0 * AnchorV4CarAddressView.a(this.c).getMeasuredHeight();
        LinearLayout r2 = AnchorV4CarAddressView.a(this.c);
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = (int) r1;
        Unit r4 = Unit.INSTANCE;
        r2.setLayoutParams(r3);
    }

    public c(int r1, int r2, AnchorV4CarAddressView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
