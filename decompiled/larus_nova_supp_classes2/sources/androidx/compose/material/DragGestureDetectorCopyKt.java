package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a^\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000626\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bH\u0080@¢\u0006\u0004\b\u000f\u0010\u0010\u001aT\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u0013H\u0082H¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010!\u001a\u00020\f*\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b#\u0010$\"\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0010\u0010\u001f\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u000e\u0010 \u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "change", "", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop = 0.0f;
    private static final float mouseSlop = 0.0f;
    private static final float mouseToTouchSlopRatio = 0.0f;

    static {
        float r0 = Dp.constructor-impl((float) 0.125d);
        mouseSlop = r0;
        float r1 = Dp.constructor-impl(18);
        defaultTouchSlop = r1;
        mouseToTouchSlopRatio = r0 / r1;
    }

    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m2035isPointerUpDmW0f2w(PointerEvent r6, long r7) {
        List r8 = r6.getChanges();
        int r0 = r8.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Object r3 = ListProtector.get(r8, r2);
        if (PointerId.equals-impl0(((PointerInputChange) r3).getId-J3iCeTQ(), r7) == true) goto L9;
        r2 = r2 + 1;
    L9:
        PointerInputChange r4 = (PointerInputChange) r3;
        if (r4 == null) goto L15;
        if (r4.getPressed() != true) goto L15;
        r1 = true;
    L15:
        return true ^ r1;
    L8:
        r3 = null;
        goto L9
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m2036pointerSlopE8SPZFQ(ViewConfiguration r1, int r2) {
        if (PointerType.equals-impl0(r2, PointerType.Companion.getMouse-T8wyACA()) == false) goto L6;
        return r1.getTouchSlop() * mouseToTouchSlopRatio;
    L6:
        return r1.getTouchSlop();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0121 -> B:57:0x0175). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0168 -> B:53:0x016b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0190 -> B:57:0x0175). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final Object m2033awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope r19, long r20, int r22, Function2<? super PointerInputChange, ? super Float, Unit> r23, Continuation<? super PointerInputChange> r24) {
        if ((r24 instanceof DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) == false) goto L7;
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) r24;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r8 = 1;
        PointerEventPass r9 = null;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        float r0 = r3.F$1;
        float r1 = r3.F$0;
        PointerInputChange r7 = (PointerInputChange) r3.L$3;
        Ref.LongRef r10 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r11 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r12 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        float r13 = r0;
        AwaitPointerEventScope r14 = r11;
        Ref.LongRef r15 = r10;
        Object r16 = r5;
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r17 = r3;
        float r18 = r1;
        Function2<? super PointerInputChange, ? super Float, Unit> r21 = r12;
    L54:
        if (r7.isConsumed() == false) goto L56;
    L55:
        return null;
    L56:
        Object r25 = r16;
        Ref.LongRef r110 = r15;
    L57:
        r8 = 1;
        r9 = null;
    L20:
        r17.L$0 = r21;
        r17.L$1 = r14;
        r17.L$2 = r110;
        r17.L$3 = r9;
        r17.F$0 = r18;
        r17.F$1 = r13;
        r17.label = r8;
        Object r111 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r14, r9, r17, r8, r9);
        if (r111 != r25) goto L23;
        return r25;
    L23:
        float r112 = r18;
        float r26 = r13;
        r2 = r111;
        r15 = r110;
        r16 = r25;
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r27 = r17;
        float r28 = r112;
    L24:
        PointerEvent r29 = (PointerEvent) r2;
        List r113 = r29.getChanges();
        int r114 = r113.size();
        int r115 = 0;
        int r116 = 0;
    L25:
        if (r116 >= r114) goto L30;
        Object r117 = ListProtector.get(r113, r116);
        if (PointerId.equals-impl0(((PointerInputChange) r117).getId-J3iCeTQ(), r15.element) == true) goto L31;
        r116 = r116 + 1;
    L31:
        Intrinsics.checkNotNull(r117);
        PointerInputChange r30 = (PointerInputChange) r117;
        if (r30.isConsumed() == true) goto L55;
        if (PointerEventKt.changedToUpIgnoreConsumed(r30) == false) goto L47;
        List r31 = r29.getChanges();
        int r32 = r31.size();
    L37:
        if (r115 >= r32) goto L42;
        Object r33 = ListProtector.get(r31, r115);
        if (((PointerInputChange) r33).getPressed() == true) goto L43;
        r115 = r115 + 1;
    L43:
        PointerInputChange r34 = (PointerInputChange) r33;
        if (r34 == null) goto L55;
        r15.element = r34.getId-J3iCeTQ();
        r13 = r26;
        r18 = r28;
        r17 = r27;
        r25 = r16;
        r110 = r15;
        goto L57
    L42:
        r33 = null;
        goto L43
    L47:
        long r35 = r30.getPosition-F1C5BW0();
        long r118 = r30.getPreviousPosition-F1C5BW0();
        r13 = r26 + (Float.intBitsToFloat((int) (r35 >> 32)) - Float.intBitsToFloat((int) (r118 >> 32)));
        if (Math.abs(r13) >= r28) goto L58;
        PointerEventPass r36 = PointerEventPass.Final;
        r27.L$0 = r21;
        r27.L$1 = r14;
        r27.L$2 = r15;
        r27.L$3 = r30;
        r27.F$0 = r28;
        r27.F$1 = r13;
        r27.label = 2;
        if (r14.awaitPointerEvent(r36, r27) != r16) goto L52;
        return r16;
    L52:
        r18 = r28;
        r17 = r27;
        r7 = r30;
        goto L54
    L58:
        r21.invoke(r30, Boxing.boxFloat(r13 - (Math.signum(r13) * r28)));
        if (r30.isConsumed() == true) goto L61;
        r18 = r28;
        r17 = r27;
        r25 = r16;
        r110 = r15;
        r13 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L57
    L61:
        return r30;
    L30:
        r117 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r37 = r3.F$1;
        float r38 = r3.F$0;
        Ref.LongRef r39 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r119 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r120 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r121 = r3;
        r26 = r37;
        r14 = r119;
        r16 = r5;
        r28 = r38;
        r21 = r120;
        r15 = r39;
        r27 = r121;
        goto L24
    L16:
        ResultKt.throwOnFailure(r2);
        if (m2035isPointerUpDmW0f2w(r19.getCurrentEvent(), r20) == true) goto L68;
        float r40 = m2036pointerSlopE8SPZFQ(r19.getViewConfiguration(), r22);
        Ref.LongRef r41 = new Ref.LongRef();
        r41.element = r20;
        r14 = r19;
        r21 = r23;
        r110 = r41;
        r25 = r5;
        r17 = r3;
        r18 = r40;
        r13 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L20
    L68:
        return null;
    L7:
        r3 = new DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1(r24);
        goto L8
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m2034awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope r16, long r17, int r19, Function2<? super PointerInputChange, ? super Float, Unit> r20, Function1<? super Offset, Float> r21, Continuation<? super PointerInputChange> r22) {
        if (m2035isPointerUpDmW0f2w(r16.getCurrentEvent(), r17) == false) goto L5;
        return null;
    L5:
        float r5 = m2036pointerSlopE8SPZFQ(r16.getViewConfiguration(), r19);
        Ref.LongRef r7 = new Ref.LongRef();
        r7.element = r17;
        float r2 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L6:
        InlineMarker.mark(0);
        Object r10 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r16, null, r22, 1, null);
        InlineMarker.mark(1);
        PointerEvent r11 = (PointerEvent) r10;
        List r12 = r11.getChanges();
        int r13 = r12.size();
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L12;
        Object r15 = ListProtector.get(r12, r14);
        float r18 = r2;
        if (Boolean.valueOf(PointerId.equals-impl0(((PointerInputChange) r15).getId-J3iCeTQ(), r7.element)).booleanValue() == true) goto L13;
        r14 = r14 + 1;
        r2 = r18;
    L13:
        Intrinsics.checkNotNull(r15);
        PointerInputChange r110 = (PointerInputChange) r15;
        if (r110.isConsumed() == true) goto L15;
        if (PointerEventKt.changedToUpIgnoreConsumed(r110) == false) goto L29;
        List r1 = r11.getChanges();
        int r3 = r1.size();
        int r8 = 0;
    L19:
        if (r8 >= r3) goto L24;
        Object r9 = ListProtector.get(r1, r8);
        if (Boolean.valueOf(((PointerInputChange) r9).getPressed()).booleanValue() == true) goto L25;
        r8 = r8 + 1;
    L25:
        PointerInputChange r23 = (PointerInputChange) r9;
        if (r23 == null) goto L27;
        r7.element = r23.getId-J3iCeTQ();
    L40:
        r2 = r18;
        goto L6
    L27:
        return null;
    L24:
        r9 = null;
        goto L25
    L29:
        float r4 = r18 + (((Number) r21.invoke(Offset.box-impl(r110.getPosition-F1C5BW0()))).floatValue() - ((Number) r21.invoke(Offset.box-impl(r110.getPreviousPosition-F1C5BW0()))).floatValue());
        if (Math.abs(r4) >= r5) goto L36;
        PointerEventPass r6 = PointerEventPass.Final;
        InlineMarker.mark(0);
        r16.awaitPointerEvent(r6, r22);
        InlineMarker.mark(1);
        if (r110.isConsumed() == true) goto L33;
        r18 = r4;
        goto L40
    L33:
        return null;
    L36:
        r20.invoke(r110, Float.valueOf(r4 - (Math.signum(r4) * r5)));
        if (r110.isConsumed() == true) goto L38;
        r18 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L40
    L38:
        return r110;
    L15:
        return null;
    L12:
        r18 = r2;
        r15 = null;
        goto L13
    }
}
