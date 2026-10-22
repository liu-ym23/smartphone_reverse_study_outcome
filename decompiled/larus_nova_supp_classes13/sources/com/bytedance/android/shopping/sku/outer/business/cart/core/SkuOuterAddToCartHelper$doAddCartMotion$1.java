package com.bytedance.android.shopping.sku.outer.business.cart.core;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class SkuOuterAddToCartHelper$doAddCartMotion$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $destinationView;
    final /* synthetic */ View $sourceView;

    public SkuOuterAddToCartHelper$doAddCartMotion$1(View r1, View r2) {
        this.$sourceView = r1;
        this.$destinationView = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2920invoke() {
        View r7 = this.$sourceView;
        View r1 = this.$destinationView;
        Boolean r6 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r7, "sourceView");
        Intrinsics.checkNotNullParameter(r1, "destinationView");
        Object r2 = r1.getContext().getSystemService("window");
        if ((r2 instanceof WindowManager) == true) goto L5;
        r2 = null;
    L5:
        WindowManager r9 = (WindowManager) r2;
        int[] r3 = new int[2];
        r7.getLocationOnScreen(r3);
        float r4 = r3[0] + (r7.getWidth() / 2);
        float r5 = r3[1] + (r7.getHeight() / 2);
        int[] r8 = new int[2];
        r1.getLocationOnScreen(r8);
        float r10 = r8[0] + (r1.getWidth() / 2);
        float r11 = r8[1] + (r1.getHeight() / 2);
        int r13 = vf4.a.a(r7.getContext(), 5.0f);
        Context r14 = r7.getContext();
        WindowManager.LayoutParams r15 = new WindowManager.LayoutParams();
        r15.width = vf4.a.a(r14, 10.0f);
        r15.height = vf4.a.a(r14, 10.0f);
        r15.x = ((int) r4) - r13;
        r15.y = (((int) r5) - eh.b.b(r14)) - r13;
        r15.flags = 664;
        r15.format = -3;
        r15.gravity = 8388659;
        r15.type = 99;
        View r12 = th.a.d(r1.getContext(), 2131564882, null, 4);
        if (r9 == null) goto L9;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r12, r15);
        r9.addView(r12, r15);
    L9:
        if (r11 >= r5) goto L11;
        TypeEvaluator r16 = new sh3.e(new PointF((r4 + r10) / 2, (float) (((double) r11) - (((double) (r5 - r11)) * 0.3d))));
    L12:
        ValueAnimator r17 = ValueAnimator.ofObject(r16, new Object[]{new PointF(r4, r5), new PointF(r10, r11)});
        r17.addUpdateListener(new sh3.a(r9, r12, r15, r13, r6, r7));
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r12, "scaleX", new float[]{1.0f, 0.3f});
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r12, "scaleY", new float[]{1.0f, 0.3f});
        AnimatorSet r20 = new AnimatorSet();
        r20.setDuration(600);
        r20.setInterpolator(new DecelerateInterpolator());
        r20.setStartDelay(500);
        r20.addListener(new sh3.b(r12, null, r9));
        r20.playTogether(new Animator[]{r17, r18, r19});
        r20.start();
        return;
    L11:
        r16 = new sh3.d();
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2920invoke();
        return Unit.INSTANCE;
    }
}
