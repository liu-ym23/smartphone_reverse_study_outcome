package com.obric.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.audio.impl.databinding.SvaEnrollingFragmentBinding;
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

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$showTip$1", f = "EnrollingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    /* JADX WARN: Type inference failed for: r3v12, types: [com.obric.audio.enroll.ui.fragment.e0, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r110);
        if (this.$errorTip.element == false) goto L14;
        Context r111 = this.this$0.getContext();
        if (r111 == null) goto L10;
        ria.a.a(r111);
    L10:
        if (this.this$0.f395619j != EnrollingFragment.TipState.ERROR) goto L12;
        SvaEnrollingFragmentBinding r112 = this.this$0.f395614e;
        Intrinsics.checkNotNull(r112);
        r112.f395795b.setText(this.$text);
    L17:
        this.$countDownLatch.countDown();
        return Unit.INSTANCE;
    L12:
        this.this$0.f395619j = EnrollingFragment.TipState.CHANGING;
        SvaEnrollingFragmentBinding r113 = this.this$0.f395614e;
        Intrinsics.checkNotNull(r113);
        r113.f395795b.setText(this.$text);
        SvaEnrollingFragmentBinding r114 = this.this$0.f395614e;
        Intrinsics.checkNotNull(r114);
        r114.f395800g.animate().alpha(0.0f).setDuration(200).start();
        SvaEnrollingFragmentBinding r115 = this.this$0.f395614e;
        Intrinsics.checkNotNull(r115);
        AppCompatTextView r116 = r115.f395795b;
        final EnrollingFragment r100 = this.this$0;
        ?? r101 = new e0(r100);
        int r102 = jia.b.f499249a;
        Intrinsics.checkNotNullParameter(r116, "view");
        Intrinsics.checkNotNullParameter(r101, "end");
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{0.0f, 1.0f});
        r103.setDuration(200);
        r103.setInterpolator(new LinearInterpolator());
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{1.0f, 0.1f});
        r104.setStartDelay(100);
        r104.setDuration(200);
        r104.setInterpolator(new LinearInterpolator());
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{0.1f, 1.0f});
        r117.setDuration(200);
        r117.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNull(r117);
        r117.addListener(new jia.a(r101));
        AnimatorSet r105 = new AnimatorSet();
        r105.playSequentially(new Animator[]{r103, r104, r117});
        r105.start();
        goto L17
    L14:
        if (this.this$0.f395619j != EnrollingFragment.TipState.NORMAL) goto L16;
        SvaEnrollingFragmentBinding r118 = this.this$0.f395614e;
        Intrinsics.checkNotNull(r118);
        r118.f395800g.setText(this.$text);
        goto L17
    L16:
        this.this$0.f395619j = EnrollingFragment.TipState.CHANGING;
        SvaEnrollingFragmentBinding r119 = this.this$0.f395614e;
        Intrinsics.checkNotNull(r119);
        r119.f395800g.setText(this.$text);
        SvaEnrollingFragmentBinding r120 = this.this$0.f395614e;
        Intrinsics.checkNotNull(r120);
        ViewPropertyAnimator r121 = r120.f395800g.animate().alpha(1.0f).setDuration(200);
        final EnrollingFragment r106 = this.this$0;
        ViewPropertyAnimator r122 = r121.withEndAction(new f0(r106));
        SvaEnrollingFragmentBinding r107 = this.this$0.f395614e;
        Intrinsics.checkNotNull(r107);
        r107.f395795b.animate().alpha(0.0f).setDuration(200).start();
        r122.start();
        goto L17
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
