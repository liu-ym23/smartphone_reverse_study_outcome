package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001a!\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001aË\u0001\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2>\b\u0002\u0010\u0012\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\u0002\b\u001b2>\b\u0002\u0010\u001c\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001b\u0010 \u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010 \u001a\u00020\u0004*\u00020#2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\"\u001a\u0013\u0010%\u001a\u00020#*\u00020#H\u0002¢\u0006\u0004\b&\u0010'\"F\u0010(\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\u0002\b\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010)\"F\u0010*\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\u0002\b\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006+"}, d2 = {"DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "velocity", "reverseDirection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toValidVelocity", "toValidVelocity-TH1AsA0", "(J)J", "NoOpOnDragStarted", "Lkotlin/jvm/functions/Function3;", "NoOpOnDragStopped", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DraggableKt {
    private static final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> NoOpOnDragStarted = null;
    private static final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> NoOpOnDragStopped = null;

    public static /* synthetic */ Unit a(State r0, float r1) {
        return rememberDraggableState$lambda$1$lambda$0(r0, r1);
    }

    static {
        NoOpOnDragStarted = new DraggableKt$NoOpOnDragStarted$1(null);
        NoOpOnDragStopped = new DraggableKt$NoOpOnDragStopped$1(null);
    }

    public static final /* synthetic */ Function3 access$getNoOpOnDragStarted$p() {
        return NoOpOnDragStarted;
    }

    public static final /* synthetic */ Function3 access$getNoOpOnDragStopped$p() {
        return NoOpOnDragStopped;
    }

    public static final DraggableState DraggableState(Function1<? super Float, Unit> r1) {
        return new DefaultDraggableState(r1);
    }

    /* JADX INFO: renamed from: access$toValidVelocity-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ long m596access$toValidVelocityTH1AsA0(long r0) {
        return m599toValidVelocityTH1AsA0(r0);
    }

    /* JADX INFO: renamed from: toValidVelocity-TH1AsA0, reason: not valid java name */
    private static final long m599toValidVelocityTH1AsA0(long r3) {
        boolean r0 = Float.isNaN(Velocity.getX-impl(r3));
        float r1 = MenuKt.ClosedAlphaTarget;
        if (r0 == false) goto L5;
        float r2 = MenuKt.ClosedAlphaTarget;
    L7:
        if (Float.isNaN(Velocity.getY-impl(r3)) == true) goto L11;
        r1 = Velocity.getY-impl(r3);
    L11:
        return VelocityKt.Velocity(r2, r1);
    L5:
        r2 = Velocity.getX-impl(r3);
        goto L7
    }

    /* JADX INFO: renamed from: access$toFloat-3MmeM6k, reason: not valid java name */
    public static final /* synthetic */ float m594access$toFloat3MmeM6k(long r0, Orientation r2) {
        return m597toFloat3MmeM6k(r0, r2);
    }

    /* JADX INFO: renamed from: access$toFloat-sF-c-tU, reason: not valid java name */
    public static final /* synthetic */ float m595access$toFloatsFctU(long r0, Orientation r2) {
        return m598toFloatsFctU(r0, r2);
    }

    private static final Unit rememberDraggableState$lambda$1$lambda$0(State r0, float r1) {
        ((Function1) r0.getValue()).invoke(Float.valueOf(r1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: toFloat-3MmeM6k, reason: not valid java name */
    private static final float m597toFloat3MmeM6k(long r2, Orientation r4) {
        if (r4 != Orientation.Vertical) goto L5;
        long r3 = r2 & 4294967295L;
    L7:
        return Float.intBitsToFloat((int) r3);
    L5:
        r3 = r2 >> 32;
        goto L7
    }

    /* JADX INFO: renamed from: toFloat-sF-c-tU, reason: not valid java name */
    private static final float m598toFloatsFctU(long r1, Orientation r3) {
        if (r3 != Orientation.Vertical) goto L6;
        return Velocity.getY-impl(r1);
    L6:
        return Velocity.getX-impl(r1);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-183245213, r5, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:130)");
    L5:
        final State r6 = SnapshotStateKt.rememberUpdatedState(r3, r4, r5 & 14);
        Object r7 = r4.rememberedValue();
        if (r7 != Composer.Companion.getEmpty()) goto L8;
        r7 = DraggableState(new q1(r6));
        r4.updateRememberedValue(r7);
    L8:
        DraggableState r8 = (DraggableState) r7;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r8;
    }

    public static final Modifier draggable(Modifier r10, DraggableState r11, Orientation r12, boolean r13, MutableInteractionSource r14, boolean r15, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r16, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> r17, boolean r18) {
        return r10.then(new DraggableElement(r11, r12, r13, r14, r15, r16, r17, r18));
    }

    public static /* synthetic */ Modifier draggable$default(Modifier r11, DraggableState r12, Orientation r13, boolean r14, MutableInteractionSource r15, boolean r16, Function3 r17, Function3 r18, boolean r19, int r20, Object r21) {
        if ((r20 & 4) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r20 & 8) == 0) goto L9;
        MutableInteractionSource r6 = null;
    L11:
        if ((r20 & 16) == 0) goto L13;
        boolean r7 = false;
    L15:
        if ((r20 & 32) == 0) goto L17;
        Function3 r8 = NoOpOnDragStarted;
    L19:
        if ((r20 & 64) == 0) goto L21;
        Function3 r9 = NoOpOnDragStopped;
    L23:
        if ((r20 & 128) == 0) goto L25;
        boolean r10 = false;
    L27:
        return draggable(r11, r12, r13, r5, r6, r7, r8, r9, r10);
    L25:
        r10 = r19;
        goto L27
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
