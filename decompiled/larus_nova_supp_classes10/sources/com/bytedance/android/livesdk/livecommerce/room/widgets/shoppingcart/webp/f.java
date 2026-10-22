package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.w;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends BaseControllerListener<Object> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function1 d;

    public static final class a extends BaseAnimationListener {
        public int a;
        public final /* synthetic */ f b;
        public final /* synthetic */ Animatable c;

        public final void onAnimationStart(AnimatedDrawable2 r1) {
            this.b.b.invoke();
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
            this.b.c.invoke();
        }

        public a(f r1, Animatable r2) {
            this.b = r1;
            this.c = r2;
            this.a = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
            if (r3 >= this.a) goto L5;
            this.c.stop();
        L5:
            Function1 r4 = this.b.d;
            if (r4 == null) goto L8;
            Unit r5 = (Unit) r4.invoke(Integer.valueOf(r3));
        L8:
            this.a = r3;
        }
    }

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
        Function0 r3 = this.a;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke();
        return;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        if ((r4 instanceof AnimatedDrawable2) == true) goto L5;
    L8:
        if (r4 == null) goto L11;
        r4.start();
        return;
    L11:
        return;
    L5:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SHOPPING_CART_FIX_ANIM() == false) goto L7;
        int r5 = w.a;
        AnimatedDrawable2 r6 = (AnimatedDrawable2) r4;
        DropFramesFrameScheduler r7 = new DropFramesFrameScheduler(r6.getAnimationBackend());
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "frameScheduler");
    L7:
        ((AnimatedDrawable2) r4).setAnimationListener(new a(this, r4));
        goto L8
    }

    public f(Function0 r1, Function0 r2, Function0 r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
