package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3", f = "WindowInsetsConnection.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WindowInsetsNestedScrollConnection$fling$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WindowInsetsAnimationController $animationController;
    final /* synthetic */ int $current;
    final /* synthetic */ float $flingAmount;
    final /* synthetic */ int $target;
    final /* synthetic */ boolean $targetShown;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3$1", f = "WindowInsetsConnection.android.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WindowInsetsAnimationController $animationController;
        final /* synthetic */ int $current;
        final /* synthetic */ float $flingAmount;
        final /* synthetic */ int $target;
        final /* synthetic */ boolean $targetShown;
        int label;
        final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

        public AnonymousClass1(int r1, int r2, float r3, WindowInsetsAnimationController r4, boolean r5, WindowInsetsNestedScrollConnection r6, Continuation<? super AnonymousClass1> r7) {
            this.$current = r1;
            this.$target = r2;
            this.$flingAmount = r3;
            this.$animationController = r4;
            this.$targetShown = r5;
            this.this$0 = r6;
            super(2, r7);
        }

        public static /* synthetic */ Unit a(WindowInsetsNestedScrollConnection r0, Animatable r1) {
            return invokeSuspend$lambda$0(r0, r1);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass1(this.$current, this.$target, this.$flingAmount, this.$animationController, this.$targetShown, this.this$0, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            this.$animationController.finish(this.$targetShown);
            WindowInsetsNestedScrollConnection.access$setAnimationController$p(this.this$0, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            Animatable r5 = AnimatableKt.Animatable$default(this.$current, MenuKt.ClosedAlphaTarget, 2, null);
            Float r6 = Boxing.boxFloat(this.$target);
            Float r8 = Boxing.boxFloat(this.$flingAmount);
            final WindowInsetsNestedScrollConnection r15 = this.this$0;
            Function1 r9 = new m2(r15);
            this.label = 1;
            if (Animatable.animateTo$default(r5, r6, null, r8, r9, this, 2, null) != r0) goto L11;
            return r0;
        }

        private static final Unit invokeSuspend$lambda$0(WindowInsetsNestedScrollConnection r0, Animatable r1) {
            WindowInsetsNestedScrollConnection.access$adjustInsets(r0, ((Number) r1.getValue()).floatValue());
            return Unit.INSTANCE;
        }
    }

    public WindowInsetsNestedScrollConnection$fling$3(WindowInsetsNestedScrollConnection r1, int r2, int r3, float r4, WindowInsetsAnimationController r5, boolean r6, Continuation<? super WindowInsetsNestedScrollConnection$fling$3> r7) {
        this.this$0 = r1;
        this.$current = r2;
        this.$target = r3;
        this.$flingAmount = r4;
        this.$animationController = r5;
        this.$targetShown = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        WindowInsetsNestedScrollConnection$fling$3 r8 = new WindowInsetsNestedScrollConnection$fling$3(this.this$0, this.$current, this.$target, this.$flingAmount, this.$animationController, this.$targetShown, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        WindowInsetsNestedScrollConnection r14 = this.this$0;
        WindowInsetsNestedScrollConnection.access$setAnimationJob$p(r14, BuildersKt.launch$default(r0, null, null, new AnonymousClass1(this.$current, this.$target, this.$flingAmount, this.$animationController, this.$targetShown, r14, null), 3, null));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
