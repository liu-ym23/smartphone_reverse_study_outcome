package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0018\u0010\u0019\u001a\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"scrollable2D", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "enabled", "", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic2D;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "magnitude", "", "Landroidx/compose/ui/unit/Velocity;", "getMagnitude-TH1AsA0", "(J)F", "angle", "getAngle-TH1AsA0", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Scrollable2DKt {
    private static final Scroll2DScope NoOpScrollScope = null;

    static {
        NoOpScrollScope = new Scrollable2DKt$NoOpScrollScope$1();
    }

    public static final /* synthetic */ Scroll2DScope access$getNoOpScrollScope$p() {
        return NoOpScrollScope;
    }

    /* JADX INFO: renamed from: access$getAngle-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ float m659access$getAngleTH1AsA0(long r0) {
        return m662getAngleTH1AsA0(r0);
    }

    /* JADX INFO: renamed from: access$getMagnitude-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ float m660access$getMagnitudeTH1AsA0(long r0) {
        return m663getMagnitudeTH1AsA0(r0);
    }

    /* JADX INFO: renamed from: getAngle-TH1AsA0, reason: not valid java name */
    private static final float m662getAngleTH1AsA0(long r2) {
        return (float) Math.atan2(Velocity.getY-impl(r2), Velocity.getX-impl(r2));
    }

    /* JADX INFO: renamed from: getMagnitude-TH1AsA0, reason: not valid java name */
    private static final float m663getMagnitudeTH1AsA0(long r4) {
        double r2 = 2;
        return (float) Math.sqrt(((float) Math.pow(Velocity.getX-impl(r4), r2)) + ((float) Math.pow(Velocity.getY-impl(r4), r2)));
    }

    /* JADX INFO: renamed from: access$semanticsScrollBy-d-4ec7I, reason: not valid java name */
    public static final /* synthetic */ Object m661access$semanticsScrollByd4ec7I(ScrollingLogic2D r0, long r1, Continuation r3) {
        return m664semanticsScrollByd4ec7I(r0, r1, r3);
    }

    /* JADX INFO: renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    private static final Object m664semanticsScrollByd4ec7I(ScrollingLogic2D r6, long r7, Continuation<? super Offset> r9) {
        if ((r9 instanceof Scrollable2DKt$semanticsScrollBy$1) == false) goto L7;
        Scrollable2DKt$semanticsScrollBy$1 r0 = (Scrollable2DKt$semanticsScrollBy$1) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.LongRef r8 = (Ref.LongRef) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L19:
        return Offset.box-impl(r8.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Ref.LongRef r11 = new Ref.LongRef();
        r11.element = Offset.Companion.getZero-F1C5BW0();
        MutatePriority r4 = MutatePriority.Default;
        Scrollable2DKt$semanticsScrollBy$2 r5 = new Scrollable2DKt$semanticsScrollBy$2(r7, r11, null);
        r0.L$0 = r11;
        r0.label = 1;
        if (r6.scroll(r4, r5, r0) != r2) goto L17;
        return r2;
    L17:
        r8 = r11;
    L7:
        r0 = new Scrollable2DKt$semanticsScrollBy$1(r9);
        goto L8
    }

    public static final Modifier scrollable2D(Modifier r7, Scrollable2DState r8, boolean r9, OverscrollEffect r10, FlingBehavior r11, MutableInteractionSource r12) {
        return r7.then(new Scrollable2DElement(r8, r10, r9, r11, r12));
    }

    public static /* synthetic */ Modifier scrollable2D$default(Modifier r6, Scrollable2DState r7, boolean r8, OverscrollEffect r9, FlingBehavior r10, MutableInteractionSource r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r12 & 4) == 0) goto L9;
        OverscrollEffect r3 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        FlingBehavior r4 = null;
    L15:
        if ((r12 & 16) == 0) goto L17;
        MutableInteractionSource r5 = null;
    L19:
        return scrollable2D(r6, r7, r2, r3, r4, r5);
    L17:
        r5 = r11;
        goto L19
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }
}
