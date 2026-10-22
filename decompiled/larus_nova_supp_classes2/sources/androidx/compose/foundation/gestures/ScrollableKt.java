package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007\u001a\u001c\u0010%\u001a\u00020&*\u00020'2\u0006\u0010(\u001a\u00020&H\u0082@¢\u0006\u0004\b)\u0010*\" \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0018\u001a\u00020\u0007*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u000e\u0010\u001b\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006+"}, d2 = {"scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "getCanDragCalculation", "()Lkotlin/jvm/functions/Function1;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "shouldBeTriggeredByMouseWheel", "getShouldBeTriggeredByMouseWheel", "(Landroidx/compose/foundation/gestures/FlingBehavior;)Z", "DefaultScrollMotionDurationScaleFactor", "", "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "UnityDensity", "Landroidx/compose/ui/unit/Density;", "getUnityDensity", "()Landroidx/compose/ui/unit/Density;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScrollableKt {
    private static final Function1<PointerInputChange, Boolean> CanDragCalculation = null;
    private static final MotionDurationScale DefaultScrollMotionDurationScale = null;
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final ScrollScope NoOpScrollScope = null;
    private static final Density UnityDensity = null;

    public static /* synthetic */ boolean a(PointerInputChange r0) {
        return CanDragCalculation$lambda$0(r0);
    }

    static {
        CanDragCalculation = new d2();
        NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();
        DefaultScrollMotionDurationScale = new ScrollableKt$DefaultScrollMotionDurationScale$1();
        UnityDensity = new ScrollableKt$UnityDensity$1();
    }

    public static final /* synthetic */ ScrollScope access$getNoOpScrollScope$p() {
        return NoOpScrollScope;
    }

    public static final Function1<PointerInputChange, Boolean> getCanDragCalculation() {
        return CanDragCalculation;
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }

    public static final Density getUnityDensity() {
        return UnityDensity;
    }

    private static final boolean CanDragCalculation$lambda$0(PointerInputChange r1) {
        return !PointerType.equals-impl0(r1.getType-T8wyACA(), PointerType.Companion.getMouse-T8wyACA());
    }

    public static final /* synthetic */ boolean access$getShouldBeTriggeredByMouseWheel(FlingBehavior r0) {
        return getShouldBeTriggeredByMouseWheel(r0);
    }

    private static final boolean getShouldBeTriggeredByMouseWheel(FlingBehavior r0) {
        return !(r0 instanceof ScrollableDefaultFlingBehavior);
    }

    /* JADX INFO: renamed from: access$semanticsScrollBy-d-4ec7I, reason: not valid java name */
    public static final /* synthetic */ Object m667access$semanticsScrollByd4ec7I(ScrollingLogic r0, long r1, Continuation r3) {
        return m668semanticsScrollByd4ec7I(r0, r1, r3);
    }

    /* JADX INFO: renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    private static final Object m668semanticsScrollByd4ec7I(ScrollingLogic r11, long r12, Continuation<? super Offset> r14) {
        if ((r14 instanceof ScrollableKt$semanticsScrollBy$1) == false) goto L7;
        ScrollableKt$semanticsScrollBy$1 r0 = (ScrollableKt$semanticsScrollBy$1) r14;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.FloatRef r13 = (Ref.FloatRef) r0.L$1;
        ScrollingLogic r16 = (ScrollingLogic) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Ref.FloatRef r17 = r13;
        r11 = r16;
    L18:
        return Offset.box-impl(r11.m702toOffsettuRUvjQ(r17.element));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r17 = new Ref.FloatRef();
        MutatePriority r4 = MutatePriority.Default;
        ScrollableKt$semanticsScrollBy$2 r10 = new ScrollableKt$semanticsScrollBy$2(r11, r12, r17, null);
        r0.L$0 = r11;
        r0.L$1 = r17;
        r0.label = 1;
        if (r11.scroll(r4, r10, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new ScrollableKt$semanticsScrollBy$1(r14);
        goto L8
    }

    public static final Modifier scrollable(Modifier r11, ScrollableState r12, Orientation r13, boolean r14, boolean r15, FlingBehavior r16, MutableInteractionSource r17) {
        return scrollable$default(r11, r12, r13, null, r14, r15, r16, r17, null, 128, null);
    }

    public static final Modifier scrollable(Modifier r10, ScrollableState r11, Orientation r12, OverscrollEffect r13, boolean r14, boolean r15, FlingBehavior r16, MutableInteractionSource r17, BringIntoViewSpec r18) {
        return r10.then(new ScrollableElement(r11, r12, r13, r14, r15, r16, r17, r18));
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier r7, ScrollableState r8, Orientation r9, boolean r10, boolean r11, FlingBehavior r12, MutableInteractionSource r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r14 & 8) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r14 & 16) == 0) goto L13;
        FlingBehavior r5 = null;
    L15:
        if ((r14 & 32) == 0) goto L17;
        MutableInteractionSource r6 = null;
    L19:
        return scrollable(r7, r8, r9, r3, r4, r5, r6);
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier r11, ScrollableState r12, Orientation r13, OverscrollEffect r14, boolean r15, boolean r16, FlingBehavior r17, MutableInteractionSource r18, BringIntoViewSpec r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        boolean r6 = true;
    L7:
        if ((r20 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r20 & 32) == 0) goto L13;
        FlingBehavior r8 = null;
    L15:
        if ((r20 & 64) == 0) goto L17;
        MutableInteractionSource r9 = null;
    L19:
        if ((r20 & 128) == 0) goto L21;
        BringIntoViewSpec r10 = null;
    L23:
        return scrollable(r11, r12, r13, r14, r6, r7, r8, r9, r10);
    L21:
        r10 = r19;
        goto L23
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }
}
