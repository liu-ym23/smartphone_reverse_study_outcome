package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2", f = "WindowInsetsConnection.android.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {})
public final class WindowInsetsNestedScrollConnection$fling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WindowInsetsAnimationController $animationController;
    final /* synthetic */ int $current;
    final /* synthetic */ Ref.FloatRef $endVelocity;
    final /* synthetic */ float $flingAmount;
    final /* synthetic */ int $hidden;
    final /* synthetic */ int $shown;
    final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
    final /* synthetic */ boolean $targetShown;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1", f = "WindowInsetsConnection.android.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WindowInsetsAnimationController $animationController;
        final /* synthetic */ int $current;
        final /* synthetic */ Ref.FloatRef $endVelocity;
        final /* synthetic */ float $flingAmount;
        final /* synthetic */ int $hidden;
        final /* synthetic */ int $shown;
        final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
        final /* synthetic */ boolean $targetShown;
        int label;
        final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

        public AnonymousClass1(int r1, float r2, SplineBasedFloatDecayAnimationSpec r3, int r4, int r5, WindowInsetsNestedScrollConnection r6, Ref.FloatRef r7, WindowInsetsAnimationController r8, boolean r9, Continuation<? super AnonymousClass1> r10) {
            this.$current = r1;
            this.$flingAmount = r2;
            this.$spec = r3;
            this.$hidden = r4;
            this.$shown = r5;
            this.this$0 = r6;
            this.$endVelocity = r7;
            this.$animationController = r8;
            this.$targetShown = r9;
            super(2, r10);
        }

        public static /* synthetic */ Unit a(int r0, int r1, WindowInsetsNestedScrollConnection r2, Ref.FloatRef r3, WindowInsetsAnimationController r4, boolean r5, float r6, float r7) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7);
        }

        public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
            return new AnonymousClass1(this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.this$0, this.$endVelocity, this.$animationController, this.$targetShown, r13);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            float r14 = this.$current;
            float r2 = this.$flingAmount;
            SplineBasedFloatDecayAnimationSpec r3 = this.$spec;
            final int r5 = this.$hidden;
            final int r6 = this.$shown;
            final WindowInsetsNestedScrollConnection r7 = this.this$0;
            final Ref.FloatRef r8 = this.$endVelocity;
            final WindowInsetsAnimationController r9 = this.$animationController;
            final boolean r10 = this.$targetShown;
            Function2 r11 = new l2(r5, r6, r7, r8, r9, r10);
            this.label = 1;
            if (SuspendAnimationKt.animateDecay(r14, r2, r3, r11, this) != r0) goto L12;
            return r0;
        }

        private static final Unit invokeSuspend$lambda$0(int r1, int r2, WindowInsetsNestedScrollConnection r3, Ref.FloatRef r4, WindowInsetsAnimationController r5, boolean r6, float r7, float r8) {
            float r9 = r1;
            boolean r0 = false;
            if (r7 <= r2) goto L5;
        L7:
            if (r0 == false) goto L9;
            WindowInsetsNestedScrollConnection.access$adjustInsets(r3, r7);
        L13:
            return Unit.INSTANCE;
        L9:
            r4.element = r8;
            r5.finish(r6);
            WindowInsetsNestedScrollConnection.access$setAnimationController$p(r3, null);
            Job r10 = WindowInsetsNestedScrollConnection.access$getAnimationJob$p(r3);
            if (r10 == null) goto L13;
            r10.cancel(new WindowInsetsAnimationCancelledException());
            goto L13
        L5:
            if (r9 > r7) goto L7;
            r0 = true;
            goto L7
        }
    }

    public WindowInsetsNestedScrollConnection$fling$2(WindowInsetsNestedScrollConnection r1, int r2, float r3, SplineBasedFloatDecayAnimationSpec r4, int r5, int r6, Ref.FloatRef r7, WindowInsetsAnimationController r8, boolean r9, Continuation<? super WindowInsetsNestedScrollConnection$fling$2> r10) {
        this.this$0 = r1;
        this.$current = r2;
        this.$flingAmount = r3;
        this.$spec = r4;
        this.$hidden = r5;
        this.$shown = r6;
        this.$endVelocity = r7;
        this.$animationController = r8;
        this.$targetShown = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        WindowInsetsNestedScrollConnection$fling$2 r11 = new WindowInsetsNestedScrollConnection$fling$2(this.this$0, this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.$endVelocity, this.$animationController, this.$targetShown, r14);
        r11.L$0 = r13;
        return r11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
    L13:
        WindowInsetsNestedScrollConnection.access$setAnimationJob$p(this.this$0, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        WindowInsetsNestedScrollConnection r3 = this.this$0;
        WindowInsetsNestedScrollConnection.access$setAnimationJob$p(r3, BuildersKt.launch$default(r4, null, null, new AnonymousClass1(this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, r3, this.$endVelocity, this.$animationController, this.$targetShown, null), 3, null));
        Job r5 = WindowInsetsNestedScrollConnection.access$getAnimationJob$p(this.this$0);
        if (r5 == null) goto L13;
        this.label = 1;
        if (r5.join(this) != r1) goto L13;
        return r1;
    }
}
