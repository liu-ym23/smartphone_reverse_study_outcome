package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {1015, 1037}, m = "invokeSuspend", n = {"$this$withTimeout", "finished", "$this$withTimeout", "event", "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
public final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.BooleanRef $deepPress;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.BooleanRef r1, Ref.ObjectRef<PointerInputChange> r2, Ref.ObjectRef<PointerInputChange> r3, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> r4) {
        this.$deepPress = r1;
        this.$currentDown = r2;
        this.$longPress = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 r0 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$deepPress, this.$currentDown, this.$longPress, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d4 -> B:47:0x00d6). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        Object r4 = null;
        boolean r6 = true;
        r6 = true;
        r6 = true;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        int r3 = this.I$0;
        PointerEvent r7 = (PointerEvent) this.L$1;
        AwaitPointerEventScope r8 = (AwaitPointerEventScope) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r5 = r18;
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 r9 = this;
    L47:
        List r10 = ((PointerEvent) r5).getChanges();
        int r11 = r10.size();
        int r12 = 0;
    L48:
        if (r12 >= r11) goto L53;
        if (((PointerInputChange) ListProtector.get(r10, r12)).isConsumed() == true) goto L51;
        r12 = r12 + 1;
        goto L48
    L51:
        boolean r13 = true;
    L54:
        if (r13 == false) goto L57;
        r3 = 1;
    L57:
        if (DragGestureDetectorKt.m568access$isPointerUpDmW0f2w(r7, ((PointerInputChange) r9.$currentDown.element).getId-J3iCeTQ()) == false) goto L69;
        List r14 = r7.getChanges();
        int r15 = r14.size();
        int r16 = 0;
    L59:
        if (r16 >= r15) goto L64;
        Object r17 = ListProtector.get(r14, r16);
        if (((PointerInputChange) r17).getPressed() == true) goto L65;
        r16 = r16 + 1;
    L65:
        PointerInputChange r19 = (PointerInputChange) r17;
        if (r19 == null) goto L68;
        r9.$currentDown.element = r19;
        r9.$longPress.element = r19;
    L77:
        r4 = null;
        r6 = true;
    L78:
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 r20 = r9;
    L11:
        if (r3 != 0) goto L80;
        PointerEventPass r21 = PointerEventPass.Main;
        r20.L$0 = r8;
        r20.L$1 = r4;
        r20.I$0 = r3;
        r20.label = r6 ? 1 : 0;
        Object r22 = r8.awaitPointerEvent(r21, r20);
        if (r22 != r1) goto L15;
        return r1;
    L15:
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 r110 = r20;
        r8 = r8;
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 r23 = r110;
    L16:
        PointerEvent r24 = (PointerEvent) r22;
        List r111 = r24.getChanges();
        int r112 = r111.size();
        int r113 = 0;
    L17:
        if (r113 >= r112) goto L22;
        if (PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange) ListProtector.get(r111, r113)) == false) goto L20;
        r113 = r113 + 1;
        goto L17
    L20:
        boolean r114 = false;
    L23:
        if (r114 == false) goto L25;
        r3 = 1;
    L25:
        List r115 = r24.getChanges();
        int r116 = r115.size();
        int r117 = 0;
    L26:
        if (r117 >= r116) goto L37;
        PointerInputChange r118 = (PointerInputChange) ListProtector.get(r115, r117);
        if (r118.isConsumed() == false) goto L30;
    L33:
        boolean r25 = true;
    L34:
        if (r25 == true) goto L35;
        r117 = r117 + 1;
        goto L26
    L35:
        boolean r26 = true;
    L38:
        if (r26 == false) goto L41;
        r3 = 1;
    L41:
        if (TapGestureDetector_androidKt.isDeepPress(r24) == false) goto L43;
        r23.$deepPress.element = r6;
        r3 = 1;
    L43:
        PointerEventPass r27 = PointerEventPass.Final;
        r23.L$0 = r8;
        r23.L$1 = r24;
        r23.I$0 = r3;
        r23.label = 2;
        r5 = r8.awaitPointerEvent(r27, r23);
        if (r5 != r1) goto L46;
        return r1;
    L46:
        r9 = r23;
        r7 = r24;
        goto L47
    L30:
        if (PointerEventKt.isOutOfBounds-jwHxaWs(r118, r8.getSize-YbymL2g(), r8.getExtendedTouchPadding-NH-jbRc()) == true) goto L33;
        r25 = false;
        goto L34
    L37:
        r26 = false;
        goto L38
    L22:
        r114 = true;
        goto L23
    L80:
        return Unit.INSTANCE;
    L68:
        r3 = 1;
        r4 = null;
        goto L78
    L64:
        r17 = null;
        goto L65
    L69:
        Ref.ObjectRef<PointerInputChange> r28 = r9.$longPress;
        List r29 = r7.getChanges();
        Ref.ObjectRef<PointerInputChange> r30 = r9.$currentDown;
        int r119 = r29.size();
        int r120 = 0;
    L70:
        if (r120 >= r119) goto L75;
        Object r121 = ListProtector.get(r29, r120);
        List r122 = r29;
        if (PointerId.equals-impl0(((PointerInputChange) r121).getId-J3iCeTQ(), ((PointerInputChange) r30.element).getId-J3iCeTQ()) == true) goto L76;
        r120 = r120 + 1;
        r29 = r122;
    L76:
        r28.element = r121;
        goto L77
    L75:
        r121 = null;
        goto L76
    L53:
        r13 = false;
        goto L54
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r3 = this.I$0;
        AwaitPointerEventScope r31 = (AwaitPointerEventScope) this.L$0;
        ResultKt.throwOnFailure(r18);
        r22 = r18;
        r8 = r31;
        r23 = this;
        goto L16
    L10:
        ResultKt.throwOnFailure(r18);
        r20 = this;
        r8 = (AwaitPointerEventScope) this.L$0;
        r3 = 0;
        goto L11
    }
}
