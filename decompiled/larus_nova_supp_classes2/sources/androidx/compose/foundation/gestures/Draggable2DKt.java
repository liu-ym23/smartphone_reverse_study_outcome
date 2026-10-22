package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001a!\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0088\u0001\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2#\b\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u00032#\b\u0002\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0017\u001a\u00020\fH\u0007\")\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\")\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Draggable2DState", "Landroidx/compose/foundation/gestures/Draggable2DState;", "onDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "rememberDraggable2DState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/Draggable2DState;", "draggable2D", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startedPosition", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "NoOpOnDragStart", "NoOpOnDragStop", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Draggable2DKt {
    private static final Function1<Offset, Unit> NoOpOnDragStart = null;
    private static final Function1<Velocity, Unit> NoOpOnDragStop = null;

    public static /* synthetic */ Unit a(State r0, Offset r1) {
        return rememberDraggable2DState$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(Velocity r0) {
        return NoOpOnDragStop$lambda$3(r0);
    }

    public static /* synthetic */ Unit c(Offset r0) {
        return NoOpOnDragStart$lambda$2(r0);
    }

    static {
        NoOpOnDragStart = new l1();
        NoOpOnDragStop = new m1();
    }

    public static final Draggable2DState Draggable2DState(Function1<? super Offset, Unit> r1) {
        return new DefaultDraggable2DState(r1);
    }

    private static final Unit NoOpOnDragStart$lambda$2(Offset r0) {
        return Unit.INSTANCE;
    }

    private static final Unit NoOpOnDragStop$lambda$3(Velocity r0) {
        return Unit.INSTANCE;
    }

    private static final Unit rememberDraggable2DState$lambda$1$lambda$0(State r0, Offset r1) {
        ((Function1) r0.getValue()).invoke(r1);
        return Unit.INSTANCE;
    }

    public static final Draggable2DState rememberDraggable2DState(Function1<? super Offset, Unit> r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1150277615, r5, -1, "androidx.compose.foundation.gestures.rememberDraggable2DState (Draggable2D.kt:106)");
    L5:
        final State r6 = SnapshotStateKt.rememberUpdatedState(r3, r4, r5 & 14);
        Object r7 = r4.rememberedValue();
        if (r7 != Composer.Companion.getEmpty()) goto L8;
        r7 = Draggable2DState(new n1(r6));
        r4.updateRememberedValue(r7);
    L8:
        Draggable2DState r8 = (Draggable2DState) r7;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r8;
    }

    public static final Modifier draggable2D(Modifier r9, Draggable2DState r10, boolean r11, MutableInteractionSource r12, boolean r13, Function1<? super Offset, Unit> r14, Function1<? super Velocity, Unit> r15, boolean r16) {
        return r9.then(new Draggable2DElement(r10, r11, r12, r13, r14, r15, r16));
    }

    public static /* synthetic */ Modifier draggable2D$default(Modifier r7, Draggable2DState r8, boolean r9, MutableInteractionSource r10, boolean r11, Function1 r12, Function1 r13, boolean r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r15 & 4) == 0) goto L9;
        MutableInteractionSource r1 = null;
    L10:
        boolean r3 = false;
        if ((r15 & 8) == 0) goto L13;
        boolean r2 = false;
    L15:
        if ((r15 & 16) == 0) goto L17;
        Function1 r4 = NoOpOnDragStart;
    L19:
        if ((r15 & 32) == 0) goto L21;
        Function1 r5 = NoOpOnDragStop;
    L23:
        if ((r15 & 64) != 0) goto L27;
        r3 = r14;
    L27:
        return draggable2D(r7, r8, r0, r1, r2, r4, r5, r3);
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r2 = r11;
        goto L15
    L9:
        r1 = r10;
        goto L10
    L5:
        r0 = r9;
        goto L7
    }
}
