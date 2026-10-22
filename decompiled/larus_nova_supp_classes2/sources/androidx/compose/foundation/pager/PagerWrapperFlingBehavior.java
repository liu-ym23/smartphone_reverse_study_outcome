package androidx.compose.foundation.pager;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "<init>", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PagerWrapperFlingBehavior implements FlingBehavior {
    private final TargetedFlingBehavior originalFlingBehavior;
    private final PagerState pagerState;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerWrapperFlingBehavior", f = "LazyLayoutPager.kt", i = {}, l = {385}, m = "performFling", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PagerWrapperFlingBehavior this$0;

        public AnonymousClass1(PagerWrapperFlingBehavior r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.performFling(null, MenuKt.ClosedAlphaTarget, this);
        }
    }

    public static /* synthetic */ Unit a(PagerWrapperFlingBehavior r0, ScrollScope r1, float r2) {
        return performFling$lambda$2$lambda$1(r0, r1, r2);
    }

    public final TargetedFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    public PagerWrapperFlingBehavior(TargetedFlingBehavior r1, PagerState r2) {
        this.originalFlingBehavior = r1;
        this.pagerState = r2;
    }

    private static final Unit performFling$lambda$2$lambda$1(PagerWrapperFlingBehavior r1, ScrollScope r2, float r3) {
        if (r1.pagerState.getPageSizeWithSpacing$foundation_release() == 0) goto L5;
        float r4 = r3 / r1.pagerState.getPageSizeWithSpacing$foundation_release();
    L6:
        r1.pagerState.updateTargetPage(r2, MathKt.roundToInt(r4) + r1.pagerState.getCurrentPage());
        return Unit.INSTANCE;
    L5:
        r4 = MenuKt.ClosedAlphaTarget;
        goto L6
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(final ScrollScope r5, float r6, Continuation<? super Float> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        float r9 = ((Number) r8).floatValue();
        if (this.pagerState.getCurrentPageOffsetFraction() == MenuKt.ClosedAlphaTarget) goto L21;
        r4 = false;
    L21:
        if (r4 == false) goto L23;
    L25:
        Boxing.boxFloat(this.pagerState.getCurrentPageOffsetFraction());
    L27:
        return Boxing.boxFloat(r9);
    L23:
        if (Math.abs(this.pagerState.getCurrentPageOffsetFraction()) >= 0.001d) goto L25;
        PagerState r10 = this.pagerState;
        PagerState.requestScrollToPage$default(r10, r10.getCurrentPage(), MenuKt.ClosedAlphaTarget, 2, null);
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        TargetedFlingBehavior r11 = this.originalFlingBehavior;
        Function1<? super Float, Unit> r12 = new h0(this, r5);
        r0.label = 1;
        r8 = r11.performFling(r5, r6, r12, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }
}
