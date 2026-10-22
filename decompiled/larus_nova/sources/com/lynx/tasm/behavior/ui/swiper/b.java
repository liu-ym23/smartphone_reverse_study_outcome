package com.lynx.tasm.behavior.ui.swiper;

import android.view.View;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements ViewPager.e {
    public b() {
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.e
    public final void a(View r100) {
        if (r100 == null) goto L5;
        r100.setRotationX(0.0f);
        r100.setRotationY(0.0f);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.e
    public final void b(ViewPager r100, View r101, boolean r102, int r103) {
        if (r100 == null) goto L12;
        int r104 = r100.getChildExpectSize();
        if (r104 == 0) goto L6;
        float r105 = r103 / r104;
    L7:
        float r106 = MathUtils.clamp(r105 * 9.0f, -9.0f, 9.0f);
        r101.setCameraDistance(1280.0f);
        if (r102 == false) goto L10;
        r101.setRotationX(r106);
        return;
    L10:
        r101.setRotationY(-r106);
        return;
    L6:
        r105 = 0.0f;
        goto L7
    }
}
