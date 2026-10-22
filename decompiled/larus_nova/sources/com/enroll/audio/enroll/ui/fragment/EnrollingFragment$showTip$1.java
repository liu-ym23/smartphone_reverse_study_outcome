package com.enroll.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.enroll.audio.impl.databinding.EnrollEnrollingFragmentBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.enroll.audio.enroll.ui.fragment.EnrollingFragment$showTip$1", f = "EnrollingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EnrollingFragment$showTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CountDownLatch $countDownLatch;
    final /* synthetic */ Ref.BooleanRef $errorTip;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    public EnrollingFragment$showTip$1(Ref.BooleanRef r100, EnrollingFragment r101, String r102, CountDownLatch r103, Continuation<? super EnrollingFragment$showTip$1> r104) {
        this.$errorTip = r100;
        this.this$0 = r101;
        this.$text = r102;
        this.$countDownLatch = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new EnrollingFragment$showTip$1(this.$errorTip, this.this$0, this.$text, this.$countDownLatch, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EnrollingFragment$showTip$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.enroll.audio.enroll.ui.fragment.r, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r110);
        if (this.$errorTip.element == false) goto L14;
        Context r111 = this.this$0.getContext();
        if (r111 == null) goto L10;
        int r100 = com.enroll.audio.enroll.sound.a.f273810a;
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.enroll.audio.enroll.sound.a.a(r111, 1, 70);
    L10:
        if (this.this$0.f273848j != EnrollingFragment.TipState.ERROR) goto L12;
        EnrollEnrollingFragmentBinding r112 = this.this$0.f273843e;
        Intrinsics.checkNotNull(r112);
        r112.f273996b.setText(this.$text);
    L17:
        this.$countDownLatch.countDown();
        return Unit.INSTANCE;
    L12:
        this.this$0.f273848j = EnrollingFragment.TipState.CHANGING;
        EnrollEnrollingFragmentBinding r113 = this.this$0.f273843e;
        Intrinsics.checkNotNull(r113);
        r113.f273996b.setText(this.$text);
        EnrollEnrollingFragmentBinding r114 = this.this$0.f273843e;
        Intrinsics.checkNotNull(r114);
        r114.f274000f.animate().alpha(0.0f).setDuration(200).start();
        EnrollEnrollingFragmentBinding r115 = this.this$0.f273843e;
        Intrinsics.checkNotNull(r115);
        AppCompatTextView r116 = r115.f273996b;
        final EnrollingFragment r101 = this.this$0;
        ?? r102 = new r(r101);
        int r103 = bt7.b.f20566a;
        Intrinsics.checkNotNullParameter(r116, "view");
        Intrinsics.checkNotNullParameter(r102, "end");
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{0.0f, 1.0f});
        r104.setDuration(200);
        r104.setInterpolator(new LinearInterpolator());
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{1.0f, 0.1f});
        r105.setStartDelay(100);
        r105.setDuration(200);
        r105.setInterpolator(new LinearInterpolator());
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{0.1f, 1.0f});
        r117.setDuration(200);
        r117.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNull(r117);
        r117.addListener(new bt7.a(r102));
        AnimatorSet r106 = new AnimatorSet();
        r106.playSequentially(new Animator[]{r104, r105, r117});
        r106.start();
        goto L17
    L14:
        if (this.this$0.f273848j != EnrollingFragment.TipState.NORMAL) goto L16;
        EnrollEnrollingFragmentBinding r118 = this.this$0.f273843e;
        Intrinsics.checkNotNull(r118);
        r118.f274000f.setText(this.$text);
        goto L17
    L16:
        this.this$0.f273848j = EnrollingFragment.TipState.CHANGING;
        EnrollEnrollingFragmentBinding r119 = this.this$0.f273843e;
        Intrinsics.checkNotNull(r119);
        r119.f274000f.setText(this.$text);
        EnrollEnrollingFragmentBinding r120 = this.this$0.f273843e;
        Intrinsics.checkNotNull(r120);
        ViewPropertyAnimator r121 = r120.f274000f.animate().alpha(1.0f).setDuration(200);
        final EnrollingFragment r107 = this.this$0;
        ViewPropertyAnimator r122 = r121.withEndAction(new s(r107));
        EnrollEnrollingFragmentBinding r108 = this.this$0.f273843e;
        Intrinsics.checkNotNull(r108);
        r108.f273996b.animate().alpha(0.0f).setDuration(200).start();
        r122.start();
        goto L17
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
