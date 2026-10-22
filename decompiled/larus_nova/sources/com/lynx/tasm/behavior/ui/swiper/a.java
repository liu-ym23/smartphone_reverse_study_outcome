package com.lynx.tasm.behavior.ui.swiper;

import android.view.View;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements ViewPager.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f383065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f383066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f383067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f383068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f383069e;

    public a() {
        this.f383065a = 0.0f;
        this.f383066b = 0.8f;
        this.f383067c = 1.0f;
        this.f383068d = 0.8f;
        this.f383069e = 1.0f;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.e
    public final void a(View r100) {
        if (r100 == null) goto L5;
        r100.setScaleX(1.0f);
        r100.setScaleY(1.0f);
        r100.setTranslationX(0.0f);
        r100.setTranslationY(0.0f);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.e
    public final void b(ViewPager r100, View r101, boolean r102, int r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f383067c >= this.f383066b) goto L6;
        return;
    L6:
        if (this.f383069e >= this.f383068d) goto L8;
        return;
    L8:
        if (r100.getChildExpectSize() <= 0) goto L32;
        float r103 = Math.abs(r110);
        int r104 = r100.getChildExpectSize();
        float r105 = this.f383067c;
        float r106 = this.f383066b;
        float r107 = r104;
        float r108 = this.f383069e;
        float r109 = r108 - (((r108 - this.f383068d) * r103) / r107);
        float r111 = MathUtils.clamp(r105 - (((r105 - r106) * r103) / r107), r106, r105);
        float r112 = MathUtils.clamp(r109, this.f383068d, this.f383069e);
        r101.setScaleX(r111);
        r101.setScaleY(r112);
        float r113 = this.f383065a;
        if (r113 > 0.0f) goto L12;
        return;
    L12:
        if (r102 == false) goto L14;
        float r114 = r113 * r107;
        float r115 = 2.0f - this.f383069e;
        float r116 = this.f383068d;
    L15:
        float r117 = (r114 * (r115 - r116)) / 2.0f;
        float r118 = Math.min(r103, r107);
        float r119 = r107 / 2.0f;
        float r120 = 1.0f - (Math.abs(r118 - r119) / r119);
        if (r110 > 0) goto L18;
        float r121 = r120 * 0.5f;
        if (r118 > r119) goto L24;
    L23:
        float r122 = r121 * r117;
    L25:
        if (r102 == false) goto L27;
        r101.setTranslationY(r122);
        return;
    L27:
        r101.setTranslationX(r122);
        return;
    L24:
        r122 = r117 - (r121 * r117);
        goto L25
    L18:
        if (r118 < r119) goto L20;
        r122 = (-r117) + ((r120 * 0.5f) * r117);
        goto L25
    L20:
        r121 = r120 * (-0.5f);
        goto L23
    L14:
        r114 = r113 * r107;
        r115 = 2.0f - this.f383067c;
        r116 = this.f383066b;
        goto L15
    }
}
