package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a2\u0010\u0010\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0080@¢\u0006\u0002\u0010\u0015\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"TargetDistance", "Landroidx/compose/ui/unit/Dp;", "F", "BoundDistance", "MinimumDistance", "DEBUG", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "isItemVisible", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "index", "", "animateScrollToItem", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutScrollScopeKt {
    private static final float BoundDistance = 0.0f;
    private static final boolean DEBUG = false;
    private static final float MinimumDistance = 0.0f;
    private static final float TargetDistance = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt", f = "LazyLayoutScrollScope.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {177, 264}, m = "animateScrollToItem", n = {"$this$animateScrollToItem", "loop", "anim", "loops", "index", "scrollOffset", "numOfItemsForTeleport", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$animateScrollToItem", "index", "scrollOffset"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "F$0", "F$1", "F$2", "I$3", "L$0", "I$0", "I$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return LazyLayoutScrollScopeKt.animateScrollToItem(null, 0, 0, 0, null, this);
        }
    }

    public static /* synthetic */ Unit a(LazyLayoutScrollScope r0, int r1, float r2, Ref.FloatRef r3, Ref.BooleanRef r4, boolean r5, float r6, Ref.IntRef r7, int r8, int r9, Ref.ObjectRef r10, AnimationScope r11) {
        return animateScrollToItem$lambda$15(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(float r0, Ref.FloatRef r1, LazyLayoutScrollScope r2, AnimationScope r3) {
        return animateScrollToItem$lambda$19(r0, r1, r2, r3);
    }

    private static final void debugLog(Function0<String> r0) {
    }

    static {
        TargetDistance = Dp.constructor-impl(2500);
        BoundDistance = Dp.constructor-impl(ProgressIndicatorKt.CircularAnimationAdditionalRotationDelay);
        MinimumDistance = Dp.constructor-impl(50);
    }

    public static final boolean isItemVisible(LazyLayoutScrollScope r2, int r3) {
        int r0 = r2.getFirstVisibleItemIndex();
        if (r3 > r2.getLastVisibleItemIndex()) goto L7;
        if (r0 > r3) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    private static final boolean animateScrollToItem$isOvershot(boolean r2, LazyLayoutScrollScope r3, int r4, int r5) {
        if (r2 == false) goto L13;
        if (r3.getFirstVisibleItemIndex() <= r4) goto L8;
    L14:
        return true;
    L8:
        if (r3.getFirstVisibleItemIndex() == r4) goto L10;
        return false;
    L10:
        if (r3.getFirstVisibleItemScrollOffset() > r5) goto L14;
        return false;
    L13:
        if (r3.getFirstVisibleItemIndex() < r4) goto L14;
        if (r3.getFirstVisibleItemIndex() == r4) goto L18;
        return false;
    L18:
        if (r3.getFirstVisibleItemScrollOffset() < r5) goto L14;
        return false;
    }

    private static final Unit animateScrollToItem$lambda$19(float r3, Ref.FloatRef r4, LazyLayoutScrollScope r5, AnimationScope r6) {
        float r0 = MenuKt.ClosedAlphaTarget;
        if (r3 <= MenuKt.ClosedAlphaTarget) goto L6;
        r0 = RangesKt.coerceAtMost(((Number) r6.getValue()).floatValue(), r3);
    L8:
        float r7 = r0 - r4.element;
        boolean r1 = true;
        if (r7 != r5.scrollBy(r7)) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
    L18:
        r6.cancelAnimation();
    L19:
        r4.element += r7;
        return Unit.INSTANCE;
    L14:
        if (r0 == ((Number) r6.getValue()).floatValue()) goto L17;
        r1 = false;
    L17:
        if (r1 == true) goto L19;
    L11:
        r8 = false;
        goto L12
    L6:
        if (r3 >= MenuKt.ClosedAlphaTarget) goto L8;
        r0 = RangesKt.coerceAtLeast(((Number) r6.getValue()).floatValue(), r3);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01af -> B:102:0x01b1). Please report as a decompilation issue!!! */
    public static final Object animateScrollToItem(LazyLayoutScrollScope r40, int r41, int r42, int r43, Density r44, Continuation<? super Unit> r45) {
        int r1 = r41;
        if ((r45 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r45;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r0 = r3.I$1;
        r1 = r3.I$0;
        LazyLayoutScrollScope r7 = (LazyLayoutScrollScope) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L91:
        r7.snapToItem(r1, r0);
    L93:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r8 = r3.I$3;
        float r9 = r3.F$2;
        float r10 = r3.F$1;
        float r11 = r3.F$0;
        int r12 = r3.I$2;
        int r13 = r3.I$1;
        int r14 = r3.I$0;
        Ref.IntRef r15 = (Ref.IntRef) r3.L$3;
        Ref.ObjectRef r16 = (Ref.ObjectRef) r3.L$2;
        Ref.BooleanRef r17 = (Ref.BooleanRef) r3.L$1;
        LazyLayoutScrollScope r18 = (LazyLayoutScrollScope) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: ItemFoundInScroll -> L18
        int r19 = r14;
        int r20 = r8;
        int r21 = r12;
        Ref.BooleanRef r110 = r17;
        float r22 = r10;
        AnonymousClass1 r23 = r3;
        int r24 = r13;
        float r111 = r11;
        Ref.ObjectRef r112 = r16;
        Object r25 = r5;
        float r26 = r9;
        LazyLayoutScrollScope r27 = r18;
    L102:
        r15.element++;     // Catch: ItemFoundInScroll -> L66
    L100:
    L70:
        e = e;
        LazyLayoutScrollScope r46 = r27;
    L72:
        r1 = r19;
        r3 = r23;
        r5 = r25;
        boolean r28 = false;
        final LazyLayoutScrollScope r29 = r46;
    L84:
        AnimationState r30 = AnimationStateKt.copy$default(e.getPreviousAnimation(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
        final float r31 = e.getItemOffset() + r24;
        final Ref.FloatRef r32 = new Ref.FloatRef();
        Float r33 = Boxing.boxFloat(r31);
        if (((Number) r30.getVelocity()).floatValue() != MenuKt.ClosedAlphaTarget) goto L87;
        r28 = true;
    L87:
        Function1 r113 = new x(r31, r32, r29);
        r3.L$0 = r29;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.I$0 = r1;
        r3.I$1 = r24;
        r3.label = 2;
        if (SuspendAnimationKt.animateTo$default(r30, r33, null, !r28, r113, r3, 2, null) != r5) goto L90;
        return r5;
    L90:
        r0 = r24;
        r7 = r29;
        goto L91
    L35:
        if (r110.element == false) goto L93;
        if (r27.getItemCount() <= 0) goto L93;
        int r34 = LazyLayoutScrollScope.CC.calculateDistanceTo$default(r27, r19, 0, 2, null) + r24;     // Catch: ItemFoundInScroll -> L70
        if (Math.abs(r34) < r111) goto L42;
        if (r20 == 0) goto L48;
        final float r210 = r111;
    L50:
        r112.element = AnimationStateKt.copy$default((AnimationState) r112.element, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);     // Catch: ItemFoundInScroll -> L70
        final Ref.FloatRef r211 = new Ref.FloatRef();     // Catch: ItemFoundInScroll -> L70
        AnimationState r35 = (AnimationState) r112.element;     // Catch: ItemFoundInScroll -> L70
        Float r114 = Boxing.boxFloat(r210);     // Catch: ItemFoundInScroll -> L70
        if (((Number) ((AnimationState) r112.element).getVelocity()).floatValue() != MenuKt.ClosedAlphaTarget) goto L53;
        boolean r115 = true;
    L54:
        boolean r116 = !r115;     // Catch: ItemFoundInScroll -> L70
        if (r20 == 0) goto L57;
        final boolean r212 = true;
    L58:
        final LazyLayoutScrollScope r117 = r27;
        final int r118 = r19;
        final Ref.BooleanRef r213 = r110;
        final float r214 = r22;
        final Ref.IntRef r215 = r15;
        final int r216 = r21;
        final int r217 = r24;
        final Ref.ObjectRef r218 = r112;
        Function1 r219 = new w(r117, r118, r210, r211, r213, r212, r214, r215, r216, r217, r218);     // Catch: ItemFoundInScroll -> L70
        r23.L$0 = r27;     // Catch: ItemFoundInScroll -> L70
        r23.L$1 = r110;     // Catch: ItemFoundInScroll -> L70
        r23.L$2 = r112;     // Catch: ItemFoundInScroll -> L70
        r23.L$3 = r15;     // Catch: ItemFoundInScroll -> L70
        r23.I$0 = r19;     // Catch: ItemFoundInScroll -> L70
        r23.I$1 = r24;     // Catch: ItemFoundInScroll -> L70
        r23.I$2 = r21;     // Catch: ItemFoundInScroll -> L70
        r23.F$0 = r111;     // Catch: ItemFoundInScroll -> L70
        r23.F$1 = r22;     // Catch: ItemFoundInScroll -> L70
        r23.F$2 = r26;     // Catch: ItemFoundInScroll -> L70
        r23.I$3 = r20;     // Catch: ItemFoundInScroll -> L70
        r46 = r27;
        r23.label = 1;     // Catch: ItemFoundInScroll -> L68
        if (SuspendAnimationKt.animateTo$default(r35, r114, null, r116, r219, r23, 2, null) != r25) goto L63;
        return r25;
    L63:
        r27 = r46;
    L68:
        e = e;
        goto L72
    L57:
        r212 = false;
        goto L58
    L53:
        r115 = false;
        goto L54
    L48:
        float r36 = -r111;
    L49:
        r210 = r36;
        goto L50
    L42:
        r36 = Math.max(Math.abs(r34), r26);     // Catch: ItemFoundInScroll -> L66
        if (r20 != 0) goto L49;
        r36 = -r36;
    L66:
        e = e;
        r3 = r23;
        r5 = r25;
        r28 = false;
        int r39 = r19;
        r29 = r27;
        r1 = r39;
    L18:
        e = e;
        r29 = r18;
        r1 = r14;
        r28 = false;
        r3 = r3;
        r24 = r13;
        goto L84
    L20:
        ResultKt.throwOnFailure(r2);
        if (r1 < MenuKt.ClosedAlphaTarget) goto L23;
        boolean r37 = true;
    L24:
        if (r37 == true) goto L104;
        InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative");
    L104:
        float r38 = r44.toPx-0680j_4(TargetDistance);     // Catch: ItemFoundInScroll -> L80
        float r47 = r44.toPx-0680j_4(BoundDistance);     // Catch: ItemFoundInScroll -> L80
        float r48 = r44.toPx-0680j_4(MinimumDistance);     // Catch: ItemFoundInScroll -> L80
        Ref.BooleanRef r49 = new Ref.BooleanRef();     // Catch: ItemFoundInScroll -> L80
        r49.element = true;     // Catch: ItemFoundInScroll -> L80
        Ref.ObjectRef r50 = new Ref.ObjectRef();     // Catch: ItemFoundInScroll -> L80
        r50.element = AnimationStateKt.AnimationState$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);     // Catch: ItemFoundInScroll -> L80
        if (isItemVisible(r40, r41) == false) goto L106;
        r29 = r40;
        r28 = false;
    L78:
        e = e;
    L83:
        r24 = r42;
        goto L84
    L77:
        throw new ItemFoundInScroll(LazyLayoutScrollScope.CC.calculateDistanceTo$default(r29, r1, 0, 2, null), (AnimationState) r50.element);     // Catch: ItemFoundInScroll -> L78
    L106:
    L73:
        e = e;
        r29 = r40;
        r28 = false;
        goto L83
    L29:
        if (r1 <= r40.getFirstVisibleItemIndex()) goto L31;
        r20 = 1;
    L32:
        Ref.IntRef r119 = new Ref.IntRef();     // Catch: ItemFoundInScroll -> L73
        r119.element = 1;     // Catch: ItemFoundInScroll -> L73
        r111 = r38;
        r110 = r49;
        r15 = r119;
        r19 = r1;
        r25 = r5;
        r112 = r50;
        r27 = r40;
        r26 = r48;
        r22 = r47;
        r21 = r43;
        r23 = r3;
        r24 = r42;
        goto L100
    L31:
        r20 = 0;
    L80:
        e = e;
        r29 = r40;
        r28 = false;
        goto L83
    L23:
        r37 = false;
    L7:
        r3 = new AnonymousClass1(r45);
        goto L8
    }

    private static final Unit animateScrollToItem$lambda$15(LazyLayoutScrollScope r4, int r5, float r6, Ref.FloatRef r7, Ref.BooleanRef r8, boolean r9, float r10, Ref.IntRef r11, int r12, int r13, Ref.ObjectRef r14, AnimationScope r15) {
        if (isItemVisible(r4, r5) == true) goto L40;
        if (r6 <= MenuKt.ClosedAlphaTarget) goto L7;
        float r16 = RangesKt.coerceAtMost(((Number) r15.getValue()).floatValue(), r6);
    L8:
        float r17 = r16 - r7.element;
        float r0 = r4.scrollBy(r17);
        if (isItemVisible(r4, r5) == true) goto L40;
        if (animateScrollToItem$isOvershot(r9, r4, r5, r13) == true) goto L40;
        if (r17 != r0) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == true) goto L20;
        r15.cancelAnimation();
        r8.element = false;
        return Unit.INSTANCE;
    L20:
        r7.element += r17;
        if (r9 == false) goto L26;
        if (((Number) r15.getValue()).floatValue() <= r10) goto L28;
        r15.cancelAnimation();
    L28:
        if (r9 == false) goto L35;
        if (r11.element < 2) goto L40;
        if ((r5 - r4.getLastVisibleItemIndex()) <= r12) goto L40;
        r4.snapToItem(r5 - r12, 0);
        goto L40
    L35:
        if (r11.element < 2) goto L40;
        if ((r4.getFirstVisibleItemIndex() - r5) <= r12) goto L40;
        r4.snapToItem(r12 + r5, 0);
        goto L40
    L26:
        if (((Number) r15.getValue()).floatValue() >= (-r10)) goto L28;
        r15.cancelAnimation();
        goto L28
    L16:
        r1 = false;
        goto L17
    L7:
        r16 = RangesKt.coerceAtLeast(((Number) r15.getValue()).floatValue(), r6);
    L40:
        if (animateScrollToItem$isOvershot(r9, r4, r5, r13) == false) goto L44;
        r4.snapToItem(r5, r13);
        r8.element = false;
        r15.cancelAnimation();
        return Unit.INSTANCE;
    L44:
        if (isItemVisible(r4, r5) == true) goto L48;
        return Unit.INSTANCE;
    L48:
        throw new ItemFoundInScroll(LazyLayoutScrollScope.CC.calculateDistanceTo$default(r4, r5, 0, 2, null), (AnimationState) r14.element);
    }
}
