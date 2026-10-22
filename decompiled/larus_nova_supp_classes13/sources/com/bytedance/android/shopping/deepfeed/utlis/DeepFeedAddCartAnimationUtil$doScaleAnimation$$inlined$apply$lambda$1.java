package com.bytedance.android.shopping.deepfeed.utlis;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.WindowManager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/shopping/deepfeed/utlis/DeepFeedAddCartAnimationUtil$doScaleAnimation$animatorSet$1$safeRemove$1"}, k = 3, mv = {1, 4, 3})
final class DeepFeedAddCartAnimationUtil$doScaleAnimation$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Animator $appearAnimator$inlined;
    final /* synthetic */ ECDraweeView $productImage$inlined;
    final /* synthetic */ AnimatorSet $this_apply;
    final /* synthetic */ AnimatorSet $throwAndCartAndDisapearAnimator$inlined;
    final /* synthetic */ WindowManager $windowManager$inlined;

    public DeepFeedAddCartAnimationUtil$doScaleAnimation$$inlined$apply$lambda$1(AnimatorSet r1, Animator r2, AnimatorSet r3, ECDraweeView r4, WindowManager r5) {
        this.$this_apply = r1;
        this.$appearAnimator$inlined = r2;
        this.$throwAndCartAndDisapearAnimator$inlined = r3;
        this.$productImage$inlined = r4;
        this.$windowManager$inlined = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m826invoke() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        this.$productImage$inlined.setVisibility(4);     // Catch: Throwable -> L9
        WindowManager r2 = this.$windowManager$inlined;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.removeViewImmediate(this.$productImage$inlined);     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r4) == null) goto L17;
        this.$productImage$inlined.setVisibility(4);
        return;
    L17:
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m826invoke();
        return Unit.INSTANCE;
    }
}
