package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a;\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\n2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0090\u0001\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00100\"¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b#\u0010$\u001a\u0090\u0001\u0010%\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00100\"¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b&\u0010'\u001a \u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0002\u001a-\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\u0006\u0010/\u001a\u00020\u0006H\u0003¢\u0006\u0004\b0\u00101\u001a;\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00062\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\"2\u0006\u0010-\u001a\u00020\u001eH\u0003¢\u0006\u0004\b6\u00107\u001a\u0014\u0010?\u001a\u00020@2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030BH\u0002\"\u0010\u00108\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0010\u0010:\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0010\u0010;\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006C²\u0006\n\u0010D\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"rememberDrawerState", "Landroidx/compose/material/DrawerState;", "initialValue", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "rememberBottomDrawerState", "Landroidx/compose/material/BottomDrawerState;", "Landroidx/compose/material/BottomDrawerValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "ModalDrawer", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "Landroidx/compose/ui/unit/Dp;", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawer", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", "a", "b", "pos", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "EndDrawerPadding", "F", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "BottomDrawerOpenFraction", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "material", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DrawerKt {
    private static final TweenSpec<Float> AnimationSpec = null;
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float DrawerPositionalThreshold = 0.0f;
    private static final float DrawerVelocityThreshold = 0.0f;
    private static final float EndDrawerPadding = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0007*\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0019*\u00020\u0012H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001b\u001a\u00020\u0019*\u00020\u0007H\u0003¢\u0006\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001f"}, d2 = {"androidx/compose/material/DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ AnchoredDraggableState<?> $state;
        private final Orientation orientation;

        public final Orientation getOrientation() {
            return this.orientation;
        }

        public AnonymousClass1(AnchoredDraggableState<?> r1) {
            this.$state = r1;
            this.orientation = Orientation.Vertical;
        }

        private final float offsetToFloat(long r3) {
            if (this.orientation != Orientation.Horizontal) goto L5;
            long r4 = r3 >> 32;
        L7:
            return Float.intBitsToFloat((int) r4);
        L5:
            r4 = r3 & 4294967295L;
            goto L7
        }

        private final long toOffset(float r7) {
            Orientation r0 = this.orientation;
            if (r0 != Orientation.Horizontal) goto L5;
            float r1 = r7;
        L7:
            if (r0 == Orientation.Vertical) goto L11;
            r7 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        L11:
            return Offset.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L));
        L5:
            r1 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
            goto L7
        }

        private final float velocityToFloat(long r3) {
            if (this.orientation != Orientation.Horizontal) goto L6;
            return Velocity.getX-impl(r3);
        L6:
            return Velocity.getY-impl(r3);
        }

        /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public Object m2048onPreFlingQWom1Mo(long r6, Continuation<? super Velocity> r8) {
            if ((r8 instanceof DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == false) goto L7;
            DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r8;
            int r1 = r0.label;
            if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
            r0.label = r1 - RtlSpacingHelper.UNDEFINED;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r6 = r0.J$0;
            ResultKt.throwOnFailure(r9);
        L23:
            return Velocity.box-impl(r6);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r9);
            float r10 = velocityToFloat(r6);
            float r4 = this.$state.requireOffset();
            if (r10 < androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L17;
        L21:
            r6 = Velocity.Companion.getZero-9UxMQ8M();
            goto L23
        L17:
            if (r4 <= this.$state.getAnchors().minAnchor()) goto L21;
            AnchoredDraggableState<?> r5 = this.$state;
            r0.J$0 = r6;
            r0.label = 1;
            if (r5.settle(r10, r0) != r2) goto L23;
            return r2;
        L7:
            r0 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, r8);
            goto L8
        }

        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public long m2049onPreScrollOzD1aCk(long r1, int r3) {
            float r2 = offsetToFloat(r1);
            if (r2 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L8;
            if (NestedScrollSource.equals-impl0(r3, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L8;
            return toOffset(this.$state.dispatchRawDelta(r2));
        L8:
            return Offset.Companion.getZero-F1C5BW0();
        }

        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public Object m2046onPostFlingRZ2iAVY(long r3, long r5, Continuation<? super Velocity> r7) {
            if ((r7 instanceof DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == false) goto L7;
            DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r4 = (DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r7;
            int r6 = r4.label;
            if ((r6 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
            r4.label = r6 - RtlSpacingHelper.UNDEFINED;
        L8:
            Object r8 = r4.result;
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = r4.label;
            if (r0 == 0) goto L14;
            if (r0 != 1) goto L13;
            r5 = r4.J$0;
            ResultKt.throwOnFailure(r8);
        L18:
            return Velocity.box-impl(r5);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            AnchoredDraggableState<?> r10 = this.$state;
            float r1 = velocityToFloat(r5);
            r4.J$0 = r5;
            r4.label = 1;
            if (r10.settle(r1, r4) != r9) goto L18;
            return r9;
        L7:
            r4 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, r7);
            goto L8
        }

        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public long m2047onPostScrollDzOQY0M(long r1, long r3, int r5) {
            if (NestedScrollSource.equals-impl0(r5, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L6;
            return toOffset(this.$state.dispatchRawDelta(offsetToFloat(r3)));
        L6:
            return Offset.Companion.getZero-F1C5BW0();
        }
    }

    private static final Unit BottomDrawerScrim_3J_VO9M$lambda$17(long r6, Function0 r8, boolean r9, int r10, Composer r11, int r12) {
        m2041BottomDrawerScrim3JVO9M(r6, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit BottomDrawer_Gs3lGvM$lambda$9(Function3 r17, Modifier r18, BottomDrawerState r19, boolean r20, Shape r21, float r22, long r23, long r25, long r27, Function2 r29, int r30, int r31, Composer r32, int r33) {
        m2040BottomDrawerGs3lGvM(r17, r18, r19, r20, r21, r22, r23, r25, r27, r29, r32, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), r31);
        return Unit.INSTANCE;
    }

    private static final Unit ModalDrawer_Gs3lGvM$lambda$8(Function3 r17, Modifier r18, DrawerState r19, boolean r20, Shape r21, float r22, long r23, long r25, long r27, Function2 r29, int r30, int r31, Composer r32, int r33) {
        m2042ModalDrawerGs3lGvM(r17, r18, r19, r20, r21, r22, r23, r25, r27, r29, r32, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), r31);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_Bx497Mc$lambda$24(boolean r7, Function0 r8, Function0 r9, long r10, int r12, Composer r13, int r14) {
        m2043ScrimBx497Mc(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(long r0, Function0 r2, DrawScope r3) {
        return Scrim_Bx497Mc$lambda$23$lambda$22(r0, r2, r3);
    }

    public static /* synthetic */ boolean b(BottomDrawerValue r0) {
        return rememberBottomDrawerState$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ DrawerState c(DrawerValue r0, Function1 r1) {
        return rememberDrawerState$lambda$3$lambda$2(r0, r1);
    }

    private static final float calculateFraction(float r0, float r1, float r2) {
        float r3 = (r2 - r0) / (r1 - r0);
        if (r3 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L6;
        r3 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L6:
        if (r3 <= 1.0f) goto L9;
        return 1.0f;
    L9:
        return r3;
    }

    public static /* synthetic */ boolean d(Function0 r0) {
        return Scrim_Bx497Mc$lambda$21$lambda$20$lambda$19(r0);
    }

    public static /* synthetic */ Unit e(String r0, Function0 r1, SemanticsPropertyReceiver r2) {
        return Scrim_Bx497Mc$lambda$21$lambda$20(r0, r1, r2);
    }

    public static /* synthetic */ boolean f(Function0 r0) {
        return BottomDrawerScrim_3J_VO9M$lambda$14$lambda$13$lambda$12(r0);
    }

    public static /* synthetic */ Unit g(Function3 r1, Modifier r2, BottomDrawerState r3, boolean r4, Shape r5, float r6, long r7, long r9, long r11, Function2 r13, int r14, int r15, Composer r16, int r17) {
        return BottomDrawer_Gs3lGvM$lambda$9(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ BottomDrawerState h(BottomDrawerValue r0, Density r1, Function1 r2, AnimationSpec r3) {
        return rememberBottomDrawerState$lambda$7$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit i(boolean r0, Function0 r1, Function0 r2, long r3, int r5, Composer r6, int r7) {
        return Scrim_Bx497Mc$lambda$24(r0, r1, r2, r3, r5, r6, r7);
    }

    public static /* synthetic */ Unit j(Function3 r1, Modifier r2, DrawerState r3, boolean r4, Shape r5, float r6, long r7, long r9, long r11, Function2 r13, int r14, int r15, Composer r16, int r17) {
        return ModalDrawer_Gs3lGvM$lambda$8(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit k(String r0, Function0 r1, SemanticsPropertyReceiver r2) {
        return BottomDrawerScrim_3J_VO9M$lambda$14$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ Unit l(long r0, Function0 r2, boolean r3, int r4, Composer r5, int r6) {
        return BottomDrawerScrim_3J_VO9M$lambda$17(r0, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit m(long r0, State r2, DrawScope r3) {
        return BottomDrawerScrim_3J_VO9M$lambda$16$lambda$15(r0, r2, r3);
    }

    public static /* synthetic */ boolean n(DrawerValue r0) {
        return rememberDrawerState$lambda$1$lambda$0(r0);
    }

    private static final boolean rememberBottomDrawerState$lambda$5$lambda$4(BottomDrawerValue r0) {
        return true;
    }

    private static final boolean rememberDrawerState$lambda$1$lambda$0(DrawerValue r0) {
        return true;
    }

    static {
        float r0 = 56;
        EndDrawerPadding = Dp.constructor-impl(r0);
        DrawerPositionalThreshold = Dp.constructor-impl(r0);
        DrawerVelocityThreshold = Dp.constructor-impl(400);
        AnimationSpec = new TweenSpec(256, 0, null, 6, null);
    }

    public static final /* synthetic */ TweenSpec access$getAnimationSpec$p() {
        return AnimationSpec;
    }

    public static final /* synthetic */ float access$getDrawerPositionalThreshold$p() {
        return DrawerPositionalThreshold;
    }

    public static final /* synthetic */ float access$getDrawerVelocityThreshold$p() {
        return DrawerVelocityThreshold;
    }

    public static final /* synthetic */ float access$getEndDrawerPadding$p() {
        return EndDrawerPadding;
    }

    private static final float BottomDrawerScrim_3J_VO9M$lambda$10(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final boolean BottomDrawerScrim_3J_VO9M$lambda$14$lambda$13$lambda$12(Function0 r0) {
        r0.invoke();
        return true;
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> r1) {
        return new AnonymousClass1(r1);
    }

    private static final boolean Scrim_Bx497Mc$lambda$21$lambda$20$lambda$19(Function0 r0) {
        r0.invoke();
        return true;
    }

    public static final /* synthetic */ NestedScrollConnection access$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState r0) {
        return ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r0);
    }

    private static final DrawerState rememberDrawerState$lambda$3$lambda$2(DrawerValue r1, Function1 r2) {
        return new DrawerState(r1, r2);
    }

    private static final Unit BottomDrawerScrim_3J_VO9M$lambda$14$lambda$13(String r1, final Function0 r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r1);
        SemanticsPropertiesKt.onClick$default(r3, null, new j3(r2), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit BottomDrawerScrim_3J_VO9M$lambda$16$lambda$15(long r13, State r15, DrawScope r16) {
        DrawScope.-CC.drawRect-n-J9OG0$default(r16, r13, 0, 0, BottomDrawerScrim_3J_VO9M$lambda$10(r15), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_Bx497Mc$lambda$21$lambda$20(String r1, final Function0 r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r1);
        SemanticsPropertiesKt.onClick$default(r3, null, new o3(r2), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_Bx497Mc$lambda$23$lambda$22(long r13, Function0 r15, DrawScope r16) {
        DrawScope.-CC.drawRect-n-J9OG0$default(r16, r13, 0, 0, ((Number) r15.invoke()).floatValue(), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ float access$calculateFraction(float r0, float r1, float r2) {
        return calculateFraction(r0, r1, r2);
    }

    private static final BottomDrawerState rememberBottomDrawerState$lambda$7$lambda$6(BottomDrawerValue r1, Density r2, Function1 r3, AnimationSpec r4) {
        return new BottomDrawerState(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    private static final void m2041BottomDrawerScrim3JVO9M(final long r22, final Function0<Unit> r24, final boolean r25, Composer r26, final int r27) {
        Composer r14 = r26.startRestartGroup(-513067266);
        if ((r27 & 6) == 0) goto L5;
        int r6 = r27;
    L11:
        if ((r27 & 48) != 0) goto L18;
        if (r14.changedInstance(r24) == false) goto L15;
        int r7 = 32;
    L16:
        r6 = r6 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r27 & 384) == 0) goto L20;
    L24:
        int r12 = r6;
        if ((r12 & 147) == 146) goto L27;
        boolean r8 = true;
    L29:
        if (r14.shouldExecute(r8, r12 & 1) == true) goto L31;
        r14.skipToGroupEnd();
    L79:
        ScopeUpdateScope r9 = r14.endRestartGroup();
        if (r9 == null) goto L83;
        r9.updateScope(new m3(r22, r24, r25, r27));
        return;
    L83:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-513067266, r12, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:725)");
    L34:
        if (r22 == 16) goto L36;
        boolean r0 = true;
    L37:
        if (r0 == false) goto L74;
        r14.startReplaceGroup(1001834356);
        if (r25 == false) goto L41;
        float r10 = 1.0f;
    L42:
        final State<Float> r11 = AnimateAsStateKt.animateFloatAsState(r10, new TweenSpec(0, 0, null, 7, null), androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, null, r14, 48, 28);
        final String r13 = Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2166getCloseDrawerUdPEhr4(), r14, 6);
        if (r25 == false) goto L63;
        r14.startReplaceGroup(1002054704);
        Modifier.Companion r15 = Modifier.Companion;
        int r16 = r12 & 112;
        if (r16 != 32) goto L47;
        boolean r17 = true;
    L48:
        Object r18 = r14.rememberedValue();
        if (r17 == false) goto L51;
    L52:
        r18 = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(r24);
        r14.updateRememberedValue(r18);
    L53:
        Modifier r19 = SuspendingPointerInputFilterKt.pointerInput(r15, r24, (PointerInputEventHandler) r18);
        boolean r110 = r14.changed(r13);
        if (r16 != 32) goto L56;
        boolean r111 = true;
    L57:
        boolean r1 = r110 | r111;
        Object r20 = r14.rememberedValue();
        if (r1 == false) goto L60;
    L61:
        r20 = new k3(r13, r24);
        r14.updateRememberedValue(r20);
    L62:
        Modifier r2 = SemanticsModifierKt.semantics(r19, true, (Function1) r20);
        r14.endReplaceGroup();
    L64:
        Modifier r3 = SizeKt.fillMaxSize$default(Modifier.Companion, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null).then(r2);
        if ((r12 & 14) != 4) goto L67;
        boolean r112 = true;
    L68:
        boolean r21 = r14.changed(r11) | r112;
        Object r23 = r14.rememberedValue();
        if (r21 == false) goto L71;
    L72:
        r23 = new l3(r22, r11);
        r14.updateRememberedValue(r23);
    L73:
        CanvasKt.Canvas(r3, (Function1) r23, r14, 0);
        r14.endReplaceGroup();
    L76:
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
        goto L79
    L71:
        if (r23 != Composer.Companion.getEmpty()) goto L73;
    L67:
        r112 = false;
        goto L68
    L60:
        if (r20 != Composer.Companion.getEmpty()) goto L62;
    L56:
        r111 = false;
        goto L57
    L51:
        if (r18 != Composer.Companion.getEmpty()) goto L53;
    L47:
        r17 = false;
        goto L48
    L63:
        r14.startReplaceGroup(1002419388);
        r14.endReplaceGroup();
        r2 = Modifier.Companion;
        goto L64
    L41:
        r10 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L42
    L74:
        r14.startReplaceGroup(1002587780);
        r14.endReplaceGroup();
        goto L76
    L36:
        r0 = false;
        goto L37
    L27:
        r8 = false;
        goto L29
    L20:
        if (r14.changed(r25) == false) goto L22;
        int r28 = 256;
    L23:
        r6 = r6 | r28;
        goto L24
    L22:
        r28 = 128;
        goto L23
    L5:
        if (r14.changed(r22) == false) goto L7;
        int r29 = 4;
    L8:
        r6 = r29 | r27;
        goto L11
    L7:
        r29 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final /* synthetic */ void m2044access$BottomDrawerScrim3JVO9M(long r0, Function0 r2, boolean r3, Composer r4, int r5) {
        m2041BottomDrawerScrim3JVO9M(r0, r2, r3, r4, r5);
    }

    public static final DrawerState rememberDrawerState(final DrawerValue r6, final Function1<? super DrawerValue, Boolean> r7, Composer r8, int r9, int r10) {
        if ((r10 & 2) == 0) goto L9;
        Object r11 = r8.rememberedValue();
        if (r11 != Composer.Companion.getEmpty()) goto L7;
        r11 = new i3();
        r8.updateRememberedValue(r11);
    L7:
        r7 = (Function1) r11;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1435874229, r9, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:390)");
    L11:
        Object[] r0 = new Object[0];
        Saver<DrawerState, DrawerValue> r1 = DrawerState.Companion.Saver(r7);
        boolean r3 = true;
        if (((r9 & 14) ^ 6) <= 4) goto L16;
        if (r8.changed(r6.ordinal()) == false) goto L16;
    L17:
        boolean r2 = true;
    L20:
        if (((r9 & 112) ^ 48) <= 32) goto L24;
        if (r8.changed(r7) == false) goto L24;
    L27:
        boolean r12 = r2 | r3;
        Object r4 = r8.rememberedValue();
        if (r12 == false) goto L30;
    L31:
        r4 = new n3(r6, r7);
        r8.updateRememberedValue(r4);
    L32:
        DrawerState r13 = (DrawerState) RememberSaveableKt.rememberSaveable(r0, r1, (Function0) r4, r8, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
    L35:
        return r13;
    L30:
        if (r4 != Composer.Companion.getEmpty()) goto L32;
    L24:
        if ((r9 & 48) == 32) goto L27;
        r3 = false;
    L16:
        if ((r9 & 6) == 4) goto L17;
        r2 = false;
        goto L20
    }

    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    private static final void m2043ScrimBx497Mc(final boolean r17, final Function0<Unit> r18, final Function0<Float> r19, final long r20, Composer r22, final int r23) {
        Composer r7 = r22.startRestartGroup(1983403750);
        if ((r23 & 6) == 0) goto L5;
        int r8 = r23;
    L11:
        if ((r23 & 48) != 0) goto L18;
        if (r7.changedInstance(r18) == false) goto L15;
        int r9 = 32;
    L16:
        r8 = r8 | r9;
        goto L18
    L15:
        r9 = 16;
    L18:
        if ((r23 & 384) != 0) goto L25;
        if (r7.changedInstance(r19) == false) goto L22;
        int r10 = 256;
    L23:
        r8 = r8 | r10;
        goto L25
    L22:
        r10 = 128;
    L25:
        if ((r23 & 3072) == 0) goto L27;
    L31:
        boolean r15 = true;
        if ((r8 & 1171) == 1170) goto L34;
        boolean r11 = true;
    L36:
        if (r7.shouldExecute(r11, r8 & 1) == true) goto L38;
        r7.skipToGroupEnd();
    L79:
        ScopeUpdateScope r12 = r7.endRestartGroup();
        if (r12 == null) goto L83;
        r12.updateScope(new u3(r17, r18, r19, r20, r23));
        return;
    L83:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(1983403750, r8, -1, "androidx.compose.material.Scrim (Drawer.kt:751)");
    L40:
        final String r0 = Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2166getCloseDrawerUdPEhr4(), r7, 6);
        if (r17 == false) goto L61;
        r7.startReplaceGroup(1716233810);
        Modifier.Companion r13 = Modifier.Companion;
        int r14 = r8 & 112;
        if (r14 != 32) goto L45;
        boolean r16 = true;
    L46:
        Object r110 = r7.rememberedValue();
        if (r16 == false) goto L49;
    L50:
        r110 = new DrawerKt$Scrim$dismissDrawer$1$1(r18);
        r7.updateRememberedValue(r110);
    L51:
        Modifier r21 = SuspendingPointerInputFilterKt.pointerInput(r13, r18, (PointerInputEventHandler) r110);
        boolean r111 = r7.changed(r0);
        if (r14 != 32) goto L54;
        boolean r112 = true;
    L55:
        boolean r113 = r112 | r111;
        Object r114 = r7.rememberedValue();
        if (r113 == false) goto L58;
    L59:
        r114 = new s3(r0, r18);
        r7.updateRememberedValue(r114);
    L60:
        Modifier r1 = SemanticsModifierKt.semantics(r21, true, (Function1) r114);
        r7.endReplaceGroup();
    L62:
        Modifier r2 = SizeKt.fillMaxSize$default(Modifier.Companion, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null).then(r1);
        if ((r8 & 7168) != 2048) goto L65;
        boolean r24 = true;
    L67:
        if ((r8 & 896) == 256) goto L70;
        r15 = false;
    L70:
        boolean r25 = r24 | r15;
        Object r26 = r7.rememberedValue();
        if (r25 == false) goto L73;
    L74:
        r26 = new t3(r20, r19);
        r7.updateRememberedValue(r26);
    L75:
        CanvasKt.Canvas(r2, (Function1) r26, r7, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
        goto L79
    L73:
        if (r26 != Composer.Companion.getEmpty()) goto L75;
    L65:
        r24 = false;
        goto L67
    L58:
        if (r114 != Composer.Companion.getEmpty()) goto L60;
    L54:
        r112 = false;
        goto L55
    L49:
        if (r110 != Composer.Companion.getEmpty()) goto L51;
    L45:
        r16 = false;
        goto L46
    L61:
        r7.startReplaceGroup(1716557884);
        r7.endReplaceGroup();
        r1 = Modifier.Companion;
        goto L62
    L34:
        r11 = false;
        goto L36
    L27:
        if (r7.changed(r20) == false) goto L29;
        int r27 = 2048;
    L30:
        r8 = r8 | r27;
        goto L31
    L29:
        r27 = 1024;
        goto L30
    L5:
        if (r7.changed(r17) == false) goto L7;
        int r28 = 4;
    L8:
        r8 = r28 | r23;
        goto L11
    L7:
        r28 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$Scrim-Bx497Mc, reason: not valid java name */
    public static final /* synthetic */ void m2045access$ScrimBx497Mc(boolean r0, Function0 r1, Function0 r2, long r3, Composer r5, int r6) {
        m2043ScrimBx497Mc(r0, r1, r2, r3, r5, r6);
    }

    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue r7, final Function1<? super BottomDrawerValue, Boolean> r8, final AnimationSpec<Float> r9, Composer r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L9;
        Object r13 = r10.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L7;
        r13 = new p3();
        r10.updateRememberedValue(r13);
    L7:
        r8 = (Function1) r13;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r9 = DrawerDefaults.INSTANCE.getAnimationSpec();
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1477366969, r11, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:409)");
    L14:
        final Density r14 = (Density) r10.consume(CompositionLocalsKt.getLocalDensity());
        boolean r1 = true;
        Object[] r2 = {r14};
        Saver<BottomDrawerState, BottomDrawerValue> r4 = BottomDrawerState.Companion.Saver(r14, r8, r9);
        if (((r11 & 14) ^ 6) <= 4) goto L19;
        if (r10.changed(r7.ordinal()) == false) goto L19;
    L20:
        boolean r0 = true;
    L22:
        boolean r3 = r0 | r10.changed(r14);
        if (((r11 & 112) ^ 48) <= 32) goto L27;
        if (r10.changed(r8) == false) goto L27;
    L30:
        boolean r15 = (r3 | r1) | r10.changedInstance(r9);
        Object r5 = r10.rememberedValue();
        if (r15 == false) goto L33;
    L34:
        r5 = new q3(r7, r14, r8, r9);
        r10.updateRememberedValue(r5);
    L35:
        BottomDrawerState r16 = (BottomDrawerState) RememberSaveableKt.rememberSaveable(r2, r4, (Function0) r5, r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r16;
    L33:
        if (r5 != Composer.Companion.getEmpty()) goto L35;
    L27:
        if ((r11 & 48) == 32) goto L30;
        r1 = false;
    L19:
        if ((r11 & 6) == 4) goto L20;
        r0 = false;
        goto L22
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX INFO: renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m2040BottomDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r36, Modifier r37, BottomDrawerState r38, boolean r39, Shape r40, float r41, long r42, long r44, long r46, final Function2<? super Composer, ? super Integer, Unit> r48, Composer r49, final int r50, final int r51) {
        Composer r7 = r49.startRestartGroup(-1403479060);
        if ((r51 & 1) == 0) goto L6;
        int r1 = r50 | 6;
    L13:
        int r2 = r51 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r50 & 384) == 0) goto L27;
        BottomDrawerState r4 = r38;
    L35:
        int r9 = r51 & 8;
        if (r9 == 0) goto L38;
        r1 = r1 | 3072;
        boolean r10 = r39;
    L46:
        if ((r50 & 24576) != 0) goto L54;
        Shape r11 = r40;
        if ((r51 & 16) == 0) goto L50;
    L52:
        int r5 = 8192;
    L53:
        r1 = r1 | r5;
    L55:
        int r12 = r51 & 32;
        if (r12 == 0) goto L58;
        r1 = r1 | 196608;
        float r13 = r41;
    L66:
        if ((1572864 & r50) != 0) goto L77;
        if ((r51 & 64) != 0) goto L73;
        if (r7.changed(r42) == false) goto L73;
        int r16 = 1048576;
    L74:
        r1 = r1 | r16;
    L73:
        r16 = 524288;
    L77:
        if ((r50 & 12582912) != 0) goto L87;
        if ((r51 & 128) == 0) goto L81;
    L83:
        int r0 = 4194304;
    L84:
        r1 = r1 | r0;
        goto L87
    L81:
        if (r7.changed(r44) == false) goto L83;
        r0 = 8388608;
    L87:
        if ((100663296 & r50) != 0) goto L97;
        if ((r51 & 256) == 0) goto L91;
    L93:
        int r3 = 33554432;
    L94:
        r1 = r1 | r3;
        goto L97
    L91:
        if (r7.changed(r46) == false) goto L93;
        r3 = 67108864;
    L97:
        if ((r51 & 512) == 0) goto L100;
        r1 = r1 | 805306368;
    L108:
        if ((r1 & 306783379) == 306783378) goto L110;
        boolean r6 = true;
    L112:
        if (r7.shouldExecute(r6, r1 & 1) == false) goto L173;
        r7.startDefaults();
        if ((r50 & 1) != 0) goto L116;
    L134:
        if (r2 == 0) goto L136;
        Modifier r8 = Modifier.Companion;
    L138:
        if ((r51 & 4) == 0) goto L140;
        int r30 = r1;
        boolean r14 = true;
        r4 = rememberBottomDrawerState(BottomDrawerValue.Closed, null, null, r7, 6, 6);
        int r15 = r30 & (-897);
    L141:
        if (r9 == 0) goto L144;
        r10 = true;
    L144:
        if ((r51 & 16) == 0) goto L146;
        Shape r17 = DrawerDefaults.INSTANCE.getShape(r7, 6);
        r15 = r15 & (-57345);
    L147:
        if (r12 == 0) goto L149;
        float r18 = DrawerDefaults.INSTANCE.m2039getElevationD9Ej5fM();
    L151:
        if ((r51 & 64) == 0) goto L153;
        long r19 = DrawerDefaults.INSTANCE.getBackgroundColor(r7, 6);
        r15 = r15 & (-3670017);
    L155:
        if ((r51 & 128) == 0) goto L157;
        long r110 = ColorsKt.m2017contentColorForek8zF_U(r19, r7, (r15 >> 18) & 14);
        r15 = r15 & (-29360129);
    L159:
        if ((r51 & 256) == 0) goto L161;
        r15 = r15 & (-234881025);
        long r32 = DrawerDefaults.INSTANCE.getScrimColor(r7, 6);
    L162:
        Modifier r20 = r8;
        ?? r21 = r14;
    L163:
        r7.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L166;
        ComposerKt.traceEventStart(-1403479060, r15, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:588)");
    L166:
        Object r22 = r7.rememberedValue();
        if (r22 != Composer.Companion.getEmpty()) goto L169;
        r22 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r7);
        r7.updateRememberedValue(r22);
    L169:
        CoroutineScope r23 = (CoroutineScope) r22;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(r20, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r21, null), null, false, ComposableLambdaKt.rememberComposableLambda(468886998, r21, new DrawerKt$BottomDrawer$1(r10, r4, r48, r32, r23, r17, r19, r110, r18, r36), r7, 54), r7, 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L172;
        ComposerKt.traceEventEnd();
    L172:
        final Modifier r24 = r20;
        final float r25 = r18;
        final Shape r26 = r17;
        final BottomDrawerState r27 = r4;
        final boolean r28 = r10;
        final long r29 = r110;
    L174:
        ScopeUpdateScope r111 = r7.endRestartGroup();
        if (r111 == null) goto L178;
        final long r31 = r19;
        final long r112 = r32;
        r111.updateScope(new r3(r36, r24, r27, r28, r26, r25, r31, r29, r112, r48, r50, r51));
        return;
    L178:
        return;
    L161:
        r32 = r46;
        goto L162
    L157:
        r110 = r44;
        goto L159
    L153:
        r19 = r42;
        goto L155
    L149:
        r18 = r13;
        goto L151
    L146:
        r17 = r11;
        goto L147
    L140:
        r15 = r1;
        r14 = true;
        r4 = r4;
        goto L141
    L136:
        r8 = r37;
        goto L138
    L116:
        if (r7.getDefaultsInvalid() == true) goto L134;
        r7.skipToGroupEnd();
        if ((r51 & 4) == 0) goto L122;
        r1 = r1 & (-897);
    L122:
        if ((r51 & 16) == 0) goto L125;
        r1 = r1 & (-57345);
    L125:
        if ((r51 & 64) == 0) goto L128;
        r1 = r1 & (-3670017);
    L128:
        if ((r51 & 128) == 0) goto L131;
        r1 = r1 & (-29360129);
    L131:
        if ((r51 & 256) == 0) goto L133;
        r1 = r1 & (-234881025);
    L133:
        r110 = r44;
        r32 = r46;
        r15 = r1;
        r17 = r11;
        r18 = r13;
        r21 = 1;
        r20 = r37;
        r19 = r42;
        goto L163
    L173:
        r7.skipToGroupEnd();
        r24 = r37;
        r32 = r46;
        r27 = r4;
        r28 = r10;
        r26 = r11;
        r25 = r13;
        r19 = r42;
        r29 = r44;
        goto L174
    L110:
        r6 = false;
        goto L112
    L100:
        if ((r50 & 805306368) != 0) goto L108;
        if (r7.changedInstance(r48) == false) goto L104;
        int r113 = 536870912;
    L105:
        r1 = r1 | r113;
        goto L108
    L104:
        r113 = 268435456;
        goto L105
    L58:
        r13 = r41;
        if ((196608 & r50) != 0) goto L66;
        if (r7.changed(r13) == false) goto L63;
        int r33 = 131072;
    L64:
        r1 = r1 | r33;
        goto L66
    L63:
        r33 = 65536;
        goto L64
    L50:
        if (r7.changed(r11) == false) goto L52;
        r5 = 16384;
        goto L53
    L54:
        r11 = r40;
        goto L55
    L38:
        r10 = r39;
        if ((r50 & 3072) != 0) goto L46;
        if (r7.changed(r10) == false) goto L43;
        int r34 = 2048;
    L44:
        r1 = r1 | r34;
        goto L46
    L43:
        r34 = 1024;
        goto L44
    L27:
        if ((r51 & 4) != 0) goto L31;
        r4 = r38;
        if (r7.changedInstance(r4) == false) goto L32;
        int r35 = 256;
    L33:
        r1 = r1 | r35;
    L32:
        r35 = 128;
        goto L33
    L31:
        r4 = r38;
        goto L32
    L17:
        if ((r50 & 48) != 0) goto L25;
        if (r7.changed(r37) == false) goto L21;
        int r43 = 32;
    L22:
        r1 = r1 | r43;
        goto L25
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r50 & 6) == 0) goto L8;
        r1 = r50;
        goto L13
    L8:
        if (r7.changedInstance(r36) == false) goto L10;
        int r45 = 4;
    L11:
        r1 = r45 | r50;
        goto L13
    L10:
        r45 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m2042ModalDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r34, Modifier r35, DrawerState r36, boolean r37, Shape r38, float r39, long r40, long r42, long r44, final Function2<? super Composer, ? super Integer, Unit> r46, Composer r47, final int r48, final int r49) {
        Composer r1 = r47.startRestartGroup(1979404999);
        if ((r49 & 1) == 0) goto L6;
        int r4 = r48 | 6;
    L13:
        int r5 = r49 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Modifier r6 = r35;
    L25:
        if ((r48 & 384) == 0) goto L27;
        DrawerState r7 = r36;
    L35:
        int r8 = r49 & 8;
        if (r8 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r9 = r37;
    L47:
        if ((r48 & 24576) == 0) goto L49;
        Shape r10 = r38;
    L57:
        int r11 = r49 & 32;
        if (r11 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        float r12 = r39;
    L69:
        if ((1572864 & r48) == 0) goto L71;
        int r13 = r4;
    L80:
        if ((r48 & 12582912) != 0) goto L90;
        if ((r49 & 128) == 0) goto L84;
    L86:
        int r0 = 4194304;
    L87:
        r13 = r13 | r0;
        goto L90
    L84:
        if (r1.changed(r42) == false) goto L86;
        r0 = 8388608;
    L90:
        if ((100663296 & r48) != 0) goto L100;
        if ((r49 & 256) == 0) goto L94;
    L96:
        int r2 = 33554432;
    L97:
        r13 = r13 | r2;
        goto L100
    L94:
        if (r1.changed(r44) == false) goto L96;
        r2 = 67108864;
    L100:
        if ((r49 & 512) == 0) goto L103;
        r13 = r13 | 805306368;
    L110:
        if ((306783379 & r13) == 306783378) goto L112;
        boolean r3 = true;
    L114:
        if (r1.shouldExecute(r3, r13 & 1) == false) goto L174;
        r1.startDefaults();
        if ((r48 & 1) != 0) goto L118;
    L136:
        if (r5 == 0) goto L138;
        Modifier r14 = Modifier.Companion;
    L140:
        if ((r49 & 4) == 0) goto L142;
        DrawerState r15 = rememberDrawerState(DrawerValue.Closed, null, r1, 6, 2);
        r13 = r13 & (-897);
    L143:
        if (r8 == 0) goto L146;
        r9 = true;
    L146:
        if ((r49 & 16) == 0) goto L148;
        Shape r16 = DrawerDefaults.INSTANCE.getShape(r1, 6);
        r13 = r13 & (-57345);
    L149:
        if (r11 == 0) goto L151;
        float r17 = DrawerDefaults.INSTANCE.m2039getElevationD9Ej5fM();
    L153:
        if ((r49 & 64) == 0) goto L155;
        long r18 = DrawerDefaults.INSTANCE.getBackgroundColor(r1, 6);
        r13 = r13 & (-3670017);
    L157:
        if ((r49 & 128) == 0) goto L159;
        long r19 = ColorsKt.m2017contentColorForek8zF_U(r18, r1, (r13 >> 18) & 14);
        r13 = r13 & (-29360129);
    L161:
        if ((r49 & 256) == 0) goto L163;
        long r20 = DrawerDefaults.INSTANCE.getScrimColor(r1, 6);
        int r21 = r13 & (-234881025);
        long r110 = r19;
        long r30 = r20;
    L164:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(1979404999, r21, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:461)");
    L167:
        Object r22 = r1.rememberedValue();
        if (r22 != Composer.Companion.getEmpty()) goto L170;
        r22 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r1);
        r1.updateRememberedValue(r22);
    L170:
        CoroutineScope r111 = (CoroutineScope) r22;
        Modifier r112 = r14;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(r14, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(-1549911011, true, new DrawerKt$ModalDrawer$1(r15, r9, r111, r30, r16, r18, r110, r17, r46, r34), r1, 54), r1, 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L173;
        ComposerKt.traceEventEnd();
    L173:
        final DrawerState r23 = r15;
        final Shape r24 = r16;
        final float r25 = r17;
        final boolean r26 = r9;
        final long r27 = r18;
        final long r28 = r110;
        final Modifier r29 = r112;
        final long r113 = r30;
    L175:
        ScopeUpdateScope r114 = r1.endRestartGroup();
        if (r114 == null) goto L179;
        r114.updateScope(new v3(r34, r29, r23, r26, r24, r25, r27, r28, r113, r46, r48, r49));
        return;
    L179:
        return;
    L163:
        r30 = r44;
        r21 = r13;
        r110 = r19;
        goto L164
    L159:
        r19 = r42;
        goto L161
    L155:
        r18 = r40;
        goto L157
    L151:
        r17 = r12;
        goto L153
    L148:
        r16 = r10;
        goto L149
    L142:
        r15 = r7;
        goto L143
    L138:
        r14 = r6;
        goto L140
    L118:
        if (r1.getDefaultsInvalid() == true) goto L136;
        r1.skipToGroupEnd();
        if ((r49 & 4) == 0) goto L124;
        r13 = r13 & (-897);
    L124:
        if ((r49 & 16) == 0) goto L127;
        r13 = r13 & (-57345);
    L127:
        if ((r49 & 64) == 0) goto L130;
        r13 = r13 & (-3670017);
    L130:
        if ((r49 & 128) == 0) goto L133;
        r13 = r13 & (-29360129);
    L133:
        if ((r49 & 256) == 0) goto L135;
        r13 = r13 & (-234881025);
    L135:
        r30 = r44;
        r14 = r6;
        r15 = r7;
        r16 = r10;
        r17 = r12;
        r21 = r13;
        r18 = r40;
        r110 = r42;
        goto L164
    L174:
        r1.skipToGroupEnd();
        r29 = r6;
        r23 = r7;
        r26 = r9;
        r24 = r10;
        r25 = r12;
        r27 = r40;
        r28 = r42;
        r113 = r44;
        goto L175
    L112:
        r3 = false;
        goto L114
    L103:
        if ((r48 & 805306368) != 0) goto L110;
        if (r1.changedInstance(r46) == false) goto L107;
        int r31 = 536870912;
    L108:
        r13 = r13 | r31;
        goto L110
    L107:
        r31 = 268435456;
        goto L108
    L71:
        if ((r49 & 64) != 0) goto L75;
        int r115 = r4;
        if (r1.changed(r40) == false) goto L76;
        int r116 = 1048576;
    L77:
        r13 = r115 | r116;
    L76:
        r116 = 524288;
        goto L77
    L75:
        r115 = r4;
        goto L76
    L61:
        if ((196608 & r48) != 0) goto L67;
        r12 = r39;
        if (r1.changed(r12) == false) goto L65;
        int r117 = 131072;
    L66:
        r4 = r4 | r117;
        goto L69
    L65:
        r117 = 65536;
        goto L66
    L49:
        if ((r49 & 16) != 0) goto L53;
        r10 = r38;
        if (r1.changed(r10) == false) goto L54;
        int r118 = 16384;
    L55:
        r4 = r4 | r118;
    L54:
        r118 = 8192;
        goto L55
    L53:
        r10 = r38;
        goto L54
    L39:
        if ((r48 & 3072) != 0) goto L45;
        r9 = r37;
        if (r1.changed(r9) == false) goto L43;
        int r119 = 2048;
    L44:
        r4 = r4 | r119;
        goto L47
    L43:
        r119 = 1024;
        goto L44
    L27:
        if ((r49 & 4) != 0) goto L31;
        r7 = r36;
        if (r1.changed(r7) == false) goto L32;
        int r32 = 256;
    L33:
        r4 = r4 | r32;
    L32:
        r32 = 128;
        goto L33
    L31:
        r7 = r36;
        goto L32
    L17:
        if ((r48 & 48) != 0) goto L23;
        r6 = r35;
        if (r1.changed(r6) == false) goto L21;
        int r33 = 32;
    L22:
        r4 = r4 | r33;
        goto L25
    L21:
        r33 = 16;
        goto L22
    L6:
        if ((r48 & 6) == 0) goto L8;
        r4 = r48;
        goto L13
    L8:
        if (r1.changedInstance(r34) == false) goto L10;
        int r41 = 4;
    L11:
        r4 = r41 | r48;
        goto L13
    L10:
        r41 = 2;
        goto L11
    }
}
