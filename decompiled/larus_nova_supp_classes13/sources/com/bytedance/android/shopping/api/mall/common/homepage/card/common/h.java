package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.drawable.Animatable;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends BaseAnimationListener {
    public final /* synthetic */ Animatable a;
    public final /* synthetic */ i b;

    public final void onAnimationRepeat(AnimatedDrawable2 r1) {
        this.a.stop();
        b0.e(this.b.a);
    }

    public final void onAnimationStop(AnimatedDrawable2 r1) {
        b0.e(this.b.a);
    }

    public h(Animatable r1, i r2) {
        this.a = r1;
        this.b = r2;
    }
}
