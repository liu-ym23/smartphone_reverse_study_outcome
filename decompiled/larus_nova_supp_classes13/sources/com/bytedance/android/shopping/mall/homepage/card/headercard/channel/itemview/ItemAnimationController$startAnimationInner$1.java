package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.a;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ItemAnimationController$startAnimationInner$1", f = "ItemAnimationController.kt", i = {2, 3}, l = {92, 94, 102, 109}, m = "invokeSuspend", n = {"run", "run"}, s = {"I$0", "I$0"})
public final class ItemAnimationController$startAnimationInner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ ItemAnimationController this$0;

    public ItemAnimationController$startAnimationInner$1(ItemAnimationController r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new ItemAnimationController$startAnimationInner$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0190 -> B:44:0x0193). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        long r7 = 200;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r17);
        ItemAnimationController$startAnimationInner$1 r12 = this;
    L44:
        r7 = 200;
    L25:
        if (r3 == 0) goto L46;
        AnimatorSet r13 = r12.this$0.c;
        if (r13 == null) goto L29;
        r13.cancel();
    L29:
        ItemAnimationController r14 = r12.this$0;
        int r15 = a.a;
        View r16 = r14.n;
        Intrinsics.checkNotNullParameter(r16, FreqActions.ACTION_VIEW);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r16, View.SCALE_X, new float[]{1.0f, 0.1f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r16, View.SCALE_Y, new float[]{1.0f, 0.1f});
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r16, View.ALPHA, new float[]{1.0f, 0.0f});
        AnimatorSet r18 = new AnimatorSet();
        r18.setDuration(r7);
        r18.setInterpolator(new LinearInterpolator());
        r18.playTogether(new Animator[]{r6, r4, r11});
        r16.setPivotX(r16.getWidth() / 2.0f);
        r16.setPivotY(r16.getHeight() / 2.0f);
        r14.c = r18;
        AnimatorSet r5 = r12.this$0.c;
        if (r5 == null) goto L32;
        r5.start();
    L32:
        r12.I$0 = r3;
        r12.label = 3;
        if (DelayKt.delay(200, r12) != r1) goto L35;
        return r1;
    L35:
        ItemAnimationController r8 = r12.this$0;
        int r9 = (r8.f + r8.h) % r8.i;
        r8.f = r9;
        r8.m.L1(r8.g, r9);
        AnimatorSet r10 = r12.this$0.b;
        if (r10 == null) goto L38;
        r10.cancel();
    L38:
        ItemAnimationController r19 = r12.this$0;
        int r20 = a.a;
        View r21 = r19.n;
        Intrinsics.checkNotNullParameter(r21, FreqActions.ACTION_VIEW);
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r21, View.SCALE_X, new float[]{0.1f, 1.0f});
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r21, View.SCALE_Y, new float[]{0.1f, 1.0f});
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r21, View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet r111 = new AnimatorSet();
        r111.setDuration(200);
        r111.setInterpolator(new LinearInterpolator());
        r111.playTogether(new Animator[]{r22, r23, r110});
        r21.setPivotX(r21.getWidth() / 2.0f);
        r21.setPivotY(r21.getHeight() / 2.0f);
        r21.setScaleX(0.1f);
        r21.setScaleY(0.1f);
        r21.setAlpha(0.0f);
        r19.b = r111;
        AnimatorSet r24 = r12.this$0.b;
        if (r24 == null) goto L41;
        r24.start();
    L41:
        long r112 = r12.this$0.k;
        r12.I$0 = r3;
        r12.label = 4;
        if (DelayKt.delay(r112, r12) != r1) goto L44;
        return r1;
    L46:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r3 = this.I$0;
        ResultKt.throwOnFailure(r17);
        r12 = this;
        goto L35
    L12:
        ResultKt.throwOnFailure(r17);
    L24:
        r12 = this;
        r3 = 1;
        goto L25
    L13:
        ResultKt.throwOnFailure(r17);
        Object r25 = r17;
    L18:
        if (((Boolean) r25).booleanValue() == false) goto L20;
        long r113 = this.this$0.l;
        this.label = 2;
        if (DelayKt.delay(r113, this) != r1) goto L24;
        return r1;
    L20:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r17);
        ItemAnimationController r26 = this.this$0;
        this.label = 1;
        r26.getClass();
        r25 = BuildersKt.withContext(Dispatchers.getIO(), new ItemAnimationController$checkControl$2(r26, null), this);
        if (r25 != r1) goto L18;
        return r1;
    }
}
