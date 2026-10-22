package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a~\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u000f\u001a\n\u0010\u0010\u001a\u00020\f*\u00020\u0011\u001a\u0013\u0010\u0012\u001a\u00020\f*\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\f*\u00020\u0011\u001a\u000f\u0010\u0016\u001a\u00020\u0007*\u00020\u0011¢\u0006\u0002\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\f*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "", "onGesture", "Lkotlin/Function4;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "centroid", "pan", "", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRotation", "Landroidx/compose/ui/input/pointer/PointerEvent;", "angle", "angle-k-4lQ0M", "(J)F", "calculateZoom", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateCentroidSize", "useCurrent", "calculateCentroid", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformGestureDetectorKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {60, 62}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
    public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(boolean r1, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> r2, Continuation<? super AnonymousClass2> r3) {
            this.$panZoomLock = r1;
            this.$onGesture = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$panZoomLock, this.$onGesture, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a0 -> B:18:0x00a3). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r26) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            int r9 = 2;
            int r12 = 1;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            int r1 = this.I$1;
            float r2 = this.F$2;
            int r3 = this.I$0;
            long r4 = this.J$0;
            float r5 = this.F$1;
            float r13 = this.F$0;
            AwaitPointerEventScope r14 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r26);
            Object r10 = r26;
            AnonymousClass2 r15 = this;
        L18:
            PointerEvent r11 = (PointerEvent) r10;
            List r8 = r11.getChanges();
            int r16 = r8.size();
            int r17 = 0;
        L19:
            if (r17 >= r16) goto L24;
            if (((PointerInputChange) ListProtector.get(r8, r17)).isConsumed() == true) goto L22;
            r17 = r17 + 1;
            goto L19
        L22:
            boolean r18 = true;
        L25:
            if (r18 == true) goto L73;
            float r19 = TransformGestureDetectorKt.calculateZoom(r11);
            float r110 = TransformGestureDetectorKt.calculateRotation(r11);
            long r111 = TransformGestureDetectorKt.calculatePan(r11);
            if (r3 != 0) goto L43;
            r5 = r5 * r19;
            r13 = r13 + r110;
            r4 = Offset.plus-MK-Hz9U(r4, r111);
            int r21 = r1;
            float r22 = TransformGestureDetectorKt.calculateCentroidSize(r11, false);
            int r112 = r3;
            float r6 = Math.abs(1 - r5) * r22;
            float r23 = Math.abs(((3.1415927f * r13) * r22) / 180.0f);
            float r24 = Offset.getDistance-impl(r4);
            if (r6 > r2) goto L37;
            if (r23 > r2) goto L37;
            if (r24 > r2) goto L37;
            r3 = r112;
        L44:
            if (r3 == 0) goto L71;
            long r25 = TransformGestureDetectorKt.calculateCentroid(r11, false);
            if (r21 == 0) goto L48;
            float r113 = MenuKt.ClosedAlphaTarget;
        L50:
            if (r113 != MenuKt.ClosedAlphaTarget) goto L52;
            boolean r114 = true;
        L53:
            if (r114 == true) goto L55;
            float r27 = r2;
        L64:
            r15.$onGesture.invoke(Offset.box-impl(r25), Offset.box-impl(r111), Boxing.boxFloat(r19), Boxing.boxFloat(r113));
        L65:
            List r20 = r11.getChanges();
            int r28 = r20.size();
            int r115 = 0;
        L66:
            if (r115 >= r28) goto L72;
            PointerInputChange r116 = (PointerInputChange) ListProtector.get(r20, r115);
            if (PointerEventKt.positionChanged(r116) == false) goto L70;
            r116.consume();
        L70:
            r115 = r115 + 1;
        L72:
            r1 = r21;
        L74:
            if (r18 == true) goto L86;
            List r29 = r11.getChanges();
            int r30 = r29.size();
            int r31 = 0;
        L76:
            if (r31 >= r30) goto L81;
            if (((PointerInputChange) ListProtector.get(r29, r31)).getPressed() == true) goto L79;
            r31 = r31 + 1;
            goto L76
        L79:
            boolean r32 = true;
        L82:
            if (r32 == false) goto L86;
            r2 = r27;
            r9 = 2;
            r12 = 1;
        L15:
            r15.L$0 = r14;
            r15.F$0 = r13;
            r15.F$1 = r5;
            r15.J$0 = r4;
            r15.I$0 = r3;
            r15.F$2 = r2;
            r15.I$1 = r1;
            r15.label = r9;
            r10 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r14, null, r15, r12, null);
            if (r10 != r7) goto L18;
            return r7;
        L81:
            r32 = false;
        L86:
            return Unit.INSTANCE;
        L55:
            if (r19 != 1.0f) goto L57;
            boolean r117 = true;
        L58:
            if (r117 == false) goto L62;
            r27 = r2;
            if (Offset.equals-impl0(r111, Offset.Companion.getZero-F1C5BW0()) == true) goto L65;
        L62:
            r27 = r2;
            goto L64
        L57:
            r117 = false;
            goto L58
        L52:
            r114 = false;
            goto L53
        L48:
            r113 = r110;
            goto L50
        L71:
            r27 = r2;
        L37:
            if (r15.$panZoomLock == true) goto L39;
        L41:
            int r33 = 0;
        L42:
            r21 = r33;
            r3 = 1;
            goto L44
        L39:
            if (r23 >= r2) goto L41;
            r33 = 1;
            goto L42
        L43:
            r21 = r1;
            goto L44
        L73:
            r27 = r2;
            goto L74
        L24:
            r18 = false;
            goto L25
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r1 = this.I$1;
            r2 = this.F$2;
            r3 = this.I$0;
            r4 = this.J$0;
            r5 = this.F$1;
            r13 = this.F$0;
            r14 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r26);
        L14:
            r15 = this;
            goto L15
        L10:
            ResultKt.throwOnFailure(r26);
            r14 = (AwaitPointerEventScope) this.L$0;
            long r34 = Offset.Companion.getZero-F1C5BW0();
            float r118 = r14.getViewConfiguration().getTouchSlop();
            this.L$0 = r14;
            this.F$0 = MenuKt.ClosedAlphaTarget;
            this.F$1 = 1.0f;
            this.J$0 = r34;
            this.I$0 = 0;
            this.F$2 = r118;
            this.I$1 = 0;
            this.label = 1;
            if (TapGestureDetectorKt.awaitFirstDown$default(r14, false, null, this, 2, null) != r7) goto L13;
            return r7;
        L13:
            r2 = r118;
            r4 = r34;
            r1 = 0;
            r3 = 0;
            r5 = 1.0f;
            r13 = MenuKt.ClosedAlphaTarget;
            goto L14
        }
    }

    /* JADX INFO: renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m720anglek4lQ0M(long r9) {
        int r1 = (int) (r9 >> 32);
        boolean r2 = true;
        if (Float.intBitsToFloat(r1) != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L15;
        if (Float.intBitsToFloat((int) (r9 & 4294967295L)) == MenuKt.ClosedAlphaTarget) goto L12;
        r2 = false;
    L12:
        if (r2 == false) goto L15;
        return MenuKt.ClosedAlphaTarget;
    L15:
        return ((-((float) Math.atan2(Float.intBitsToFloat(r1), Float.intBitsToFloat((int) (r9 & 4294967295L))))) * 180.0f) / 3.1415927f;
    L5:
        r0 = false;
        goto L7
    }

    public static final long calculatePan(PointerEvent r5) {
        long r0 = calculateCentroid(r5, true);
        Offset.Companion r2 = Offset.Companion;
        if (Offset.equals-impl0(r0, r2.getUnspecified-F1C5BW0()) == false) goto L7;
        return r2.getZero-F1C5BW0();
    L7:
        return Offset.minus-MK-Hz9U(r0, calculateCentroid(r5, false));
    }

    public static final float calculateRotation(PointerEvent r16) {
        List r1 = r16.getChanges();
        int r2 = r1.size();
        int r4 = 0;
        int r5 = 0;
    L3:
        int r6 = 1;
        if (r4 >= r2) goto L12;
        PointerInputChange r7 = (PointerInputChange) ListProtector.get(r1, r4);
        if (r7.getPreviousPressed() == true) goto L8;
    L10:
        r6 = 0;
    L11:
        r5 = r5 + r6;
        r4 = r4 + 1;
        goto L3
    L8:
        if (r7.getPressed() == false) goto L10;
    L12:
        float r3 = MenuKt.ClosedAlphaTarget;
        if (r5 >= 2) goto L15;
        return MenuKt.ClosedAlphaTarget;
    L15:
        long r8 = calculateCentroid(r16, true);
        long r9 = calculateCentroid(r16, false);
        List r0 = r16.getChanges();
        int r10 = r0.size();
        int r11 = 0;
        float r12 = MenuKt.ClosedAlphaTarget;
        float r13 = MenuKt.ClosedAlphaTarget;
    L16:
        if (r11 >= r10) goto L30;
        PointerInputChange r14 = (PointerInputChange) ListProtector.get(r0, r11);
        if (r14.getPressed() == false) goto L28;
        if (r14.getPreviousPressed() == false) goto L28;
        long r15 = r14.getPosition-F1C5BW0();
        long r17 = Offset.minus-MK-Hz9U(r14.getPreviousPosition-F1C5BW0(), r9);
        long r18 = Offset.minus-MK-Hz9U(r15, r8);
        float r19 = m720anglek4lQ0M(r17);
        float r110 = m720anglek4lQ0M(r18) - r19;
        float r20 = Offset.getDistance-impl(Offset.plus-MK-Hz9U(r18, r17)) / 2.0f;
        if (r110 <= 180.0f) goto L25;
        r110 = r110 - 360.0f;
    L27:
        r13 = r13 + (r110 * r20);
        r12 = r12 + r20;
        goto L28
    L25:
        if (r110 >= (-180.0f)) goto L27;
        r110 = r110 + 360.0f;
    L28:
        r11 = r11 + 1;
        r3 = MenuKt.ClosedAlphaTarget;
        goto L16
    L30:
        if (r12 != r3) goto L32;
        boolean r21 = true;
    L33:
        if (r21 == false) goto L36;
        return r3;
    L36:
        return r13 / r12;
    L32:
        r21 = false;
        goto L33
    }

    public static final float calculateZoom(PointerEvent r5) {
        boolean r0 = true;
        float r1 = calculateCentroidSize(r5, true);
        float r6 = calculateCentroidSize(r5, false);
        if (r1 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return 1.0f;
    L8:
        if (r6 == MenuKt.ClosedAlphaTarget) goto L11;
        r0 = false;
    L11:
        if (r0 == false) goto L14;
        return 1.0f;
    L14:
        return r1 / r6;
    L5:
        r4 = false;
        goto L6
    }

    public static final long calculateCentroid(PointerEvent r7, boolean r8) {
        long r0 = Offset.Companion.getZero-F1C5BW0();
        List r9 = r7.getChanges();
        int r2 = r9.size();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L13;
        PointerInputChange r5 = (PointerInputChange) ListProtector.get(r9, r3);
        if (r5.getPressed() == false) goto L12;
        if (r5.getPreviousPressed() == false) goto L12;
        if (r8 == false) goto L10;
        long r6 = r5.getPosition-F1C5BW0();
    L11:
        r0 = Offset.plus-MK-Hz9U(r0, r6);
        r4 = r4 + 1;
        goto L12
    L10:
        r6 = r5.getPreviousPosition-F1C5BW0();
    L12:
        r3 = r3 + 1;
        goto L3
    L13:
        if (r4 != 0) goto L16;
        return Offset.Companion.getUnspecified-F1C5BW0();
    L16:
        return Offset.div-tuRUvjQ(r0, r4);
    }

    public static final float calculateCentroidSize(PointerEvent r8, boolean r9) {
        long r0 = calculateCentroid(r8, r9);
        boolean r2 = Offset.equals-impl0(r0, Offset.Companion.getUnspecified-F1C5BW0());
        float r3 = MenuKt.ClosedAlphaTarget;
        if (r2 == false) goto L5;
        return MenuKt.ClosedAlphaTarget;
    L5:
        List r10 = r8.getChanges();
        int r4 = r10.size();
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L17;
        PointerInputChange r7 = (PointerInputChange) ListProtector.get(r10, r5);
        if (r7.getPressed() == false) goto L15;
        if (r7.getPreviousPressed() == false) goto L15;
        if (r9 == false) goto L13;
        long r11 = r7.getPosition-F1C5BW0();
    L14:
        r3 = r3 + Offset.getDistance-impl(Offset.minus-MK-Hz9U(r11, r0));
        r6 = r6 + 1;
        goto L15
    L13:
        r11 = r7.getPreviousPosition-F1C5BW0();
    L15:
        r5 = r5 + 1;
        goto L6
    L17:
        return r3 / r6;
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return calculateCentroid(r0, r1);
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return calculateCentroidSize(r0, r1);
    }

    public static final Object detectTransformGestures(PointerInputScope r2, boolean r3, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> r4, Continuation<? super Unit> r5) {
        Object r6 = ForEachGestureKt.awaitEachGesture(r2, new AnonymousClass2(r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope r0, boolean r1, Function4 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return detectTransformGestures(r0, r1, r2, r3);
    }
}
