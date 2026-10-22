package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0090\u0001\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\r0\u001f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b \u0010!\u001a\u0014\u0010\"\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a-\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\u001f2\u0006\u0010&\u001a\u00020\tH\u0003¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010)\u001a\u00020*2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020.H\u0002\"\u0010\u0010/\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u00063²\u0006\n\u00104\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"rememberModalBottomSheetState", "Landroidx/compose/material/ModalBottomSheetState;", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "ModalBottomSheetLayout", "", "sheetContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "sheetGesturesEnabled", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "Landroidx/compose/ui/unit/Dp;", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "modalBottomSheetAnchors", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetPositionalThreshold", "F", "ModalBottomSheetVelocityThreshold", "MaxModalBottomSheetWidth", "material", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt {
    private static final float MaxModalBottomSheetWidth = 0.0f;
    private static final float ModalBottomSheetPositionalThreshold = 0.0f;
    private static final float ModalBottomSheetVelocityThreshold = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/material/ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        private final float offsetToFloat(long r3) {
            if (this.$orientation != Orientation.Horizontal) goto L5;
            long r4 = r3 >> 32;
        L7:
            return Float.intBitsToFloat((int) r4);
        L5:
            r4 = r3 & 4294967295L;
            goto L7
        }

        private final long toOffset(float r7) {
            Orientation r0 = this.$orientation;
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
            if (this.$orientation != Orientation.Horizontal) goto L6;
            return Velocity.getX-impl(r3);
        L6:
            return Velocity.getY-impl(r3);
        }

        public AnonymousClass1(AnchoredDraggableState<?> r1, Orientation r2) {
            this.$state = r1;
            this.$orientation = r2;
        }

        /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public Object m2101onPreFlingQWom1Mo(long r6, Continuation<? super Velocity> r8) {
            if ((r8 instanceof ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == false) goto L7;
            ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r8;
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
            r0 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, r8);
            goto L8
        }

        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public long m2102onPreScrollOzD1aCk(long r1, int r3) {
            float r2 = offsetToFloat(r1);
            if (r2 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L8;
            if (NestedScrollSource.equals-impl0(r3, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L8;
            return toOffset(this.$state.dispatchRawDelta(r2));
        L8:
            return Offset.Companion.getZero-F1C5BW0();
        }

        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public Object m2099onPostFlingRZ2iAVY(long r3, long r5, Continuation<? super Velocity> r7) {
            if ((r7 instanceof ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == false) goto L7;
            ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r4 = (ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r7;
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
            r4 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, r7);
            goto L8
        }

        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public long m2100onPostScrollDzOQY0M(long r1, long r3, int r5) {
            if (NestedScrollSource.equals-impl0(r5, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L6;
            return toOffset(this.$state.dispatchRawDelta(offsetToFloat(r3)));
        L6:
            return Offset.Companion.getZero-F1C5BW0();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ModalBottomSheetValue.values().length];
            r0[ModalBottomSheetValue.Hidden.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ModalBottomSheetValue.Expanded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final Unit ModalBottomSheetLayout_Gs3lGvM$lambda$14(Function3 r17, Modifier r18, ModalBottomSheetState r19, boolean r20, Shape r21, float r22, long r23, long r25, long r27, Function2 r29, int r30, int r31, Composer r32, int r33) {
        m2097ModalBottomSheetLayoutGs3lGvM(r17, r18, r19, r20, r21, r22, r23, r25, r27, r29, r32, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), r31);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_3J_VO9M$lambda$24(long r6, Function0 r8, boolean r9, int r10, Composer r11, int r12) {
        m2098Scrim3JVO9M(r6, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function3 r1, Modifier r2, ModalBottomSheetState r3, boolean r4, Shape r5, float r6, long r7, long r9, long r11, Function2 r13, int r14, int r15, Composer r16, int r17) {
        return ModalBottomSheetLayout_Gs3lGvM$lambda$14(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ boolean b(Function0 r0) {
        return Scrim_3J_VO9M$lambda$21$lambda$20$lambda$19(r0);
    }

    public static /* synthetic */ Unit c(float r0, ModalBottomSheetState r1, IntSize r2, DraggableAnchorsConfig r3) {
        return modalBottomSheetAnchors$lambda$16$lambda$15(r0, r1, r2, r3);
    }

    public static /* synthetic */ ModalBottomSheetState d(ModalBottomSheetValue r0, Density r1, Function1 r2, AnimationSpec r3, boolean r4) {
        return rememberModalBottomSheetState$lambda$3$lambda$2(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit e(ModalBottomSheetState r0, CoroutineScope r1, SemanticsPropertyReceiver r2) {
        return ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$12$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ boolean f(ModalBottomSheetState r0, CoroutineScope r1) {
        return ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$12$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit g(long r0, State r2, DrawScope r3) {
        return Scrim_3J_VO9M$lambda$23$lambda$22(r0, r2, r3);
    }

    public static /* synthetic */ Unit h(String r0, Function0 r1, SemanticsPropertyReceiver r2) {
        return Scrim_3J_VO9M$lambda$21$lambda$20(r0, r1, r2);
    }

    public static /* synthetic */ boolean i(ModalBottomSheetState r0, CoroutineScope r1) {
        return ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$12$lambda$11$lambda$8(r0, r1);
    }

    public static /* synthetic */ boolean j(ModalBottomSheetState r0, CoroutineScope r1) {
        return ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$12$lambda$11$lambda$9(r0, r1);
    }

    public static /* synthetic */ Pair k(ModalBottomSheetState r0, IntSize r1, Constraints r2) {
        return modalBottomSheetAnchors$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ boolean l(ModalBottomSheetValue r0) {
        return rememberModalBottomSheetState$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ Unit m(ModalBottomSheetState r0, CoroutineScope r1) {
        return ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$6$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit n(long r0, Function0 r2, boolean r3, int r4, Composer r5, int r6) {
        return Scrim_3J_VO9M$lambda$24(r0, r2, r3, r4, r5, r6);
    }

    private static final boolean rememberModalBottomSheetState$lambda$1$lambda$0(ModalBottomSheetValue r0) {
        return true;
    }

    static {
        ModalBottomSheetPositionalThreshold = Dp.constructor-impl(56);
        ModalBottomSheetVelocityThreshold = Dp.constructor-impl(125);
        MaxModalBottomSheetWidth = Dp.constructor-impl(640);
    }

    public static final /* synthetic */ float access$getModalBottomSheetPositionalThreshold$p() {
        return ModalBottomSheetPositionalThreshold;
    }

    public static final /* synthetic */ float access$getModalBottomSheetVelocityThreshold$p() {
        return ModalBottomSheetVelocityThreshold;
    }

    private static final float Scrim_3J_VO9M$lambda$17(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final boolean Scrim_3J_VO9M$lambda$21$lambda$20$lambda$19(Function0 r0) {
        r0.invoke();
        return true;
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> r1, Orientation r2) {
        return new AnonymousClass1(r1, r2);
    }

    private static final boolean ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$12$lambda$11$lambda$10(ModalBottomSheetState r7, CoroutineScope r8) {
        if (((Boolean) r7.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(ModalBottomSheetValue.HalfExpanded)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$3$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final boolean ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$12$lambda$11$lambda$8(ModalBottomSheetState r7, CoroutineScope r8) {
        if (((Boolean) r7.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(ModalBottomSheetValue.Hidden)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$1$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final boolean ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$12$lambda$11$lambda$9(ModalBottomSheetState r7, CoroutineScope r8) {
        if (((Boolean) r7.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(ModalBottomSheetValue.Expanded)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$2$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final Unit ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$6$lambda$5$lambda$4(ModalBottomSheetState r7, CoroutineScope r8) {
        if (((Boolean) r7.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(ModalBottomSheetValue.Hidden)).booleanValue() == false) goto L6;
        BuildersKt.launch$default(r8, null, null, new ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1$1(r7, null), 3, null);
    L6:
        return Unit.INSTANCE;
    }

    private static final Modifier modalBottomSheetAnchors(Modifier r3, final ModalBottomSheetState r4) {
        return AnchoredDraggableKt.draggableAnchors(r3, r4.getAnchoredDraggableState$material(), Orientation.Vertical, new f6(r4));
    }

    private static final Unit ModalBottomSheetLayout_Gs3lGvM$lambda$13$lambda$12$lambda$11(final ModalBottomSheetState r4, final CoroutineScope r5, SemanticsPropertyReceiver r6) {
        if (r4.isVisible() == false) goto L11;
        SemanticsPropertiesKt.dismiss$default(r6, null, new m6(r4, r5), 1, null);
        if (r4.getAnchoredDraggableState$material().getCurrentValue() != ModalBottomSheetValue.HalfExpanded) goto L8;
        SemanticsPropertiesKt.expand$default(r6, null, new n6(r4, r5), 1, null);
        goto L11
    L8:
        if (r4.getHasHalfExpandedState$material() == false) goto L11;
        SemanticsPropertiesKt.collapse$default(r6, null, new o6(r4, r5), 1, null);
    L11:
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_3J_VO9M$lambda$21$lambda$20(String r1, final Function0 r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r1);
        SemanticsPropertiesKt.onClick$default(r3, null, new p6(r2), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_3J_VO9M$lambda$23$lambda$22(long r13, State r15, DrawScope r16) {
        DrawScope.-CC.drawRect-n-J9OG0$default(r16, r13, 0, 0, RangesKt.coerceIn(Scrim_3J_VO9M$lambda$17(r15), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    private static final Pair modalBottomSheetAnchors$lambda$16(final ModalBottomSheetState r2, final IntSize r3, Constraints r4) {
        final float r5 = Constraints.getMaxHeight-impl(r4.unbox-impl());
        DraggableAnchors r6 = AnchoredDraggableKt.DraggableAnchors(new l6(r5, r2, r3));
        if (r2.getAnchoredDraggableState$material().getAnchors().getSize() <= 0) goto L5;
        boolean r7 = true;
    L6:
        ModalBottomSheetValue r1 = r2.getCurrentValue();
        if (r7 == false) goto L9;
    L11:
        int r8 = WhenMappings.$EnumSwitchMapping$0[r2.getTargetValue().ordinal()];
        if (r8 != 1) goto L14;
        r1 = ModalBottomSheetValue.Hidden;
    L29:
        return TuplesKt.to(r6, r1);
    L14:
        if (r8 != 2) goto L16;
    L20:
        ModalBottomSheetValue r9 = ModalBottomSheetValue.HalfExpanded;
        if (r6.hasAnchorFor(r9) == false) goto L23;
    L22:
        r1 = r9;
        goto L29
    L23:
        r9 = ModalBottomSheetValue.Expanded;
        if (r6.hasAnchorFor(r9) == true) goto L22;
        r9 = ModalBottomSheetValue.Hidden;
        goto L22
    L16:
        if (r8 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    L9:
        if (r6.hasAnchorFor(r1) == false) goto L11;
    L5:
        r7 = false;
        goto L6
    }

    private static final Unit modalBottomSheetAnchors$lambda$16$lambda$15(float r5, ModalBottomSheetState r6, IntSize r7, DraggableAnchorsConfig r8) {
        r8.at(ModalBottomSheetValue.Hidden, r5);
        float r0 = r5 / 2.0f;
        if (r6.isSkipHalfExpanded$material() == true) goto L8;
        if (((int) (r7.unbox-impl() & 4294967295L)) <= r0) goto L8;
        r8.at(ModalBottomSheetValue.HalfExpanded, r0);
    L8:
        if (((int) (r7.unbox-impl() & 4294967295L)) == 0) goto L11;
        r8.at(ModalBottomSheetValue.Expanded, Math.max(androidx.compose.material3.MenuKt.ClosedAlphaTarget, r5 - ((int) (r7.unbox-impl() & 4294967295L))));
    L11:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    private static final void m2098Scrim3JVO9M(final long r22, final Function0<Unit> r24, final boolean r25, Composer r26, final int r27) {
        Composer r14 = r26.startRestartGroup(-526532668);
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
        r9.updateScope(new k6(r22, r24, r25, r27));
        return;
    L83:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-526532668, r12, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:489)");
    L34:
        if (r22 == 16) goto L36;
        boolean r0 = true;
    L37:
        if (r0 == false) goto L74;
        r14.startReplaceGroup(-714009568);
        if (r25 == false) goto L41;
        float r10 = 1.0f;
    L42:
        final State<Float> r11 = AnimateAsStateKt.animateFloatAsState(r10, new TweenSpec(0, 0, null, 7, null), androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, null, r14, 48, 28);
        final String r13 = Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2167getCloseSheetUdPEhr4(), r14, 6);
        if (r25 == false) goto L63;
        r14.startReplaceGroup(-713791669);
        Modifier.Companion r15 = Modifier.Companion;
        int r16 = r12 & 112;
        if (r16 != 32) goto L47;
        boolean r17 = true;
    L48:
        Object r18 = r14.rememberedValue();
        if (r17 == false) goto L51;
    L52:
        r18 = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(r24);
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
        r20 = new e6(r13, r24);
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
        r23 = new j6(r22, r11);
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
        r14.startReplaceGroup(-713427946);
        r14.endReplaceGroup();
        r2 = Modifier.Companion;
        goto L64
    L41:
        r10 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L42
    L74:
        r14.startReplaceGroup(-713242690);
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

    private static final ModalBottomSheetState rememberModalBottomSheetState$lambda$3$lambda$2(ModalBottomSheetValue r7, Density r8, Function1 r9, AnimationSpec r10, boolean r11) {
        return new ModalBottomSheetState(r7, r8, r9, r10, r11);
    }

    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue r7, AnimationSpec<Float> r8, Function1<? super ModalBottomSheetValue, Boolean> r9, boolean r10, Composer r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        r8 = ModalBottomSheetDefaults.INSTANCE.getAnimationSpec();
    L5:
        final AnimationSpec<Float> r4 = r8;
        if ((r13 & 4) == 0) goto L11;
        Object r14 = r11.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L10;
        r14 = new q6();
        r11.updateRememberedValue(r14);
    L10:
        r9 = (Function1) r14;
    L11:
        final Function1<? super ModalBottomSheetValue, Boolean> r3 = r9;
        if ((r13 & 8) == 0) goto L14;
        final boolean r5 = false;
    L16:
        if (ComposerKt.isTraceInProgress() == false) goto L18;
        ComposerKt.traceEventStart(-126412120, r12, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:277)");
    L18:
        final Density r2 = (Density) r11.consume(CompositionLocalsKt.getLocalDensity());
        r11.startMovableGroup(-1222943993, r7);
        boolean r15 = true;
        Object[] r16 = {r7, r4, Boolean.valueOf(r5), r3, r2};
        Saver<ModalBottomSheetState, ?> r6 = ModalBottomSheetState.Companion.Saver(r4, r3, r5, r2);
        if (((r12 & 14) ^ 6) <= 4) goto L23;
        if (r11.changed(r7.ordinal()) == false) goto L23;
    L24:
        boolean r17 = true;
    L26:
        boolean r18 = r17 | r11.changed(r2);
        if (((r12 & 896) ^ 384) <= 256) goto L31;
        if (r11.changed(r3) == false) goto L31;
    L32:
        boolean r0 = true;
    L34:
        boolean r19 = (r18 | r0) | r11.changedInstance(r4);
        if (((r12 & 7168) ^ 3072) <= 2048) goto L39;
        if (r11.changed(r5) == false) goto L39;
    L42:
        boolean r110 = r15 | r19;
        Object r111 = r11.rememberedValue();
        if (r110 == false) goto L45;
    L46:
        r111 = new r6(r7, r2, r3, r4, r5);
        r11.updateRememberedValue(r111);
    L47:
        ModalBottomSheetState r20 = (ModalBottomSheetState) RememberSaveableKt.rememberSaveable(r16, r6, (Function0) r111, r11, 0);
        r11.endMovableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L50;
        ComposerKt.traceEventEnd();
    L50:
        return r20;
    L45:
        if (r111 != Composer.Companion.getEmpty()) goto L47;
    L39:
        if ((r12 & 3072) == 2048) goto L42;
        r15 = false;
    L31:
        if ((r12 & 384) == 256) goto L32;
        r0 = false;
    L23:
        if ((r12 & 6) == 4) goto L24;
        r17 = false;
        goto L26
    L14:
        r5 = r10;
        goto L16
    }

    /* JADX INFO: renamed from: ModalBottomSheetLayout-Gs3lGvM, reason: not valid java name */
    public static final void m2097ModalBottomSheetLayoutGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r40, Modifier r41, ModalBottomSheetState r42, boolean r43, Shape r44, float r45, long r46, long r48, long r50, final Function2<? super Composer, ? super Integer, Unit> r52, Composer r53, final int r54, final int r55) {
        Composer r9 = r53.startRestartGroup(-336264970);
        if ((r55 & 1) == 0) goto L6;
        int r2 = r54 | 6;
    L13:
        int r3 = r55 & 2;
        if (r3 == 0) goto L17;
        r2 = r2 | 48;
    L23:
        Modifier r4 = r41;
    L25:
        if ((r54 & 384) == 0) goto L27;
        ModalBottomSheetState r5 = r42;
    L35:
        int r11 = r55 & 8;
        if (r11 == 0) goto L38;
        r2 = r2 | 3072;
        boolean r12 = r43;
    L46:
        if ((r54 & 24576) != 0) goto L56;
        if ((r55 & 16) == 0) goto L50;
    L52:
        int r6 = 8192;
    L53:
        r2 = r2 | r6;
        goto L56
    L50:
        if (r9.changed(r44) == false) goto L52;
        r6 = 16384;
    L56:
        if ((196608 & r54) != 0) goto L66;
        if ((r55 & 32) == 0) goto L60;
    L62:
        int r7 = 65536;
    L63:
        r2 = r2 | r7;
        goto L66
    L60:
        if (r9.changed(r45) == false) goto L62;
        r7 = 131072;
    L66:
        if ((r54 & 1572864) != 0) goto L76;
        if ((r55 & 64) == 0) goto L70;
    L72:
        int r8 = 524288;
    L73:
        r2 = r2 | r8;
        goto L76
    L70:
        if (r9.changed(r46) == false) goto L72;
        r8 = 1048576;
    L76:
        if ((12582912 & r54) != 0) goto L84;
        long r10 = r48;
        if ((r55 & 128) == 0) goto L80;
    L82:
        int r13 = 4194304;
    L83:
        r2 = r2 | r13;
    L86:
        if ((100663296 & r54) != 0) goto L94;
        long r14 = r50;
        if ((r55 & 256) == 0) goto L90;
    L92:
        int r15 = 33554432;
    L93:
        r2 = r2 | r15;
    L96:
        if ((r55 & 512) == 0) goto L99;
        r2 = r2 | 805306368;
    L105:
        int r16 = r2;
        if ((306783379 & r16) == 306783378) goto L108;
        boolean r0 = true;
    L110:
        if (r9.shouldExecute(r0, r16 & 1) == false) goto L233;
        r9.startDefaults();
        if ((r54 & 1) != 0) goto L114;
    L135:
        if (r3 == 0) goto L137;
        Modifier r1 = Modifier.Companion;
    L139:
        if ((r55 & 4) == 0) goto L141;
        final ModalBottomSheetState r17 = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, r9, 6, 14);
        r16 = r16 & (-897);
    L142:
        if (r11 == 0) goto L145;
        r12 = true;
    L145:
        if ((r55 & 16) == 0) goto L147;
        Shape r18 = MaterialTheme.INSTANCE.getShapes(r9, 6).getLarge();
        r16 = r16 & (-57345);
    L149:
        if ((r55 & 32) == 0) goto L151;
        float r19 = ModalBottomSheetDefaults.INSTANCE.m2096getElevationD9Ej5fM();
        r16 = r16 & (-458753);
    L153:
        if ((r55 & 64) == 0) goto L155;
        long r20 = MaterialTheme.INSTANCE.getColors(r9, 6).m2003getSurface0d7_KjU();
        r16 = r16 & (-3670017);
    L157:
        if ((r55 & 128) == 0) goto L160;
        r10 = ColorsKt.m2017contentColorForek8zF_U(r20, r9, (r16 >> 18) & 14);
        r16 = (-29360129) & r16;
    L160:
        if ((r55 & 256) == 0) goto L162;
        long r21 = ModalBottomSheetDefaults.INSTANCE.getScrimColor(r9, 0);
        int r22 = r16 & (-234881025);
        long r23 = r21;
    L163:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(-336264970, r22, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:352)");
    L167:
        Object r24 = r9.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r24 != r110.getEmpty()) goto L170;
        r24 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r9);
        r9.updateRememberedValue(r24);
    L170:
        final CoroutineScope r25 = (CoroutineScope) r24;
        Orientation r111 = Orientation.Vertical;
        Alignment.Companion r112 = Alignment.Companion;
        long r49 = r10;
        MeasurePolicy r113 = BoxKt.maybeCachedBoxMeasurePolicy(r112.getTopStart(), false);
        int r114 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r115 = r9.getCurrentCompositionLocalMap();
        long r51 = r20;
        Modifier r26 = ComposedModifierKt.materializeModifier(r9, r1);
        ComposeUiNode.Companion r27 = ComposeUiNode.Companion;
        Modifier r35 = r1;
        Function0 r28 = r27.getConstructor();
        Shape r36 = r18;
        if ((r9.getApplier() instanceof Applier) == true) goto L173;
        ComposablesKt.invalidApplier();
    L173:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L176;
        r9.createNode(r28);
    L177:
        Composer r29 = Updater.constructor-impl(r9);
        Updater.set-impl(r29, r113, r27.getSetMeasurePolicy());
        Updater.set-impl(r29, r115, r27.getSetResolvedCompositionLocals());
        Function2 r30 = r27.getSetCompositeKeyHash();
        if (r29.getInserting() == false) goto L180;
    L181:
        r29.updateRememberedValue(Integer.valueOf(r114));
        r29.apply(Integer.valueOf(r114), r30);
    L182:
        Updater.set-impl(r29, r26, r27.getSetModifier());
        BoxScopeInstance r31 = BoxScopeInstance.INSTANCE;
        Modifier r32 = Modifier.Companion;
        Modifier r116 = SizeKt.fillMaxSize$default(r32, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null);
        MeasurePolicy r117 = BoxKt.maybeCachedBoxMeasurePolicy(r112.getTopStart(), false);
        int r210 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r33 = r9.getCurrentCompositionLocalMap();
        Modifier r118 = ComposedModifierKt.materializeModifier(r9, r116);
        Function0 r119 = r27.getConstructor();
        boolean r37 = r12;
        if ((r9.getApplier() instanceof Applier) == true) goto L185;
        ComposablesKt.invalidApplier();
    L185:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L188;
        r9.createNode(r119);
    L189:
        Composer r120 = Updater.constructor-impl(r9);
        Updater.set-impl(r120, r117, r27.getSetMeasurePolicy());
        Updater.set-impl(r120, r33, r27.getSetResolvedCompositionLocals());
        Function2 r34 = r27.getSetCompositeKeyHash();
        if (r120.getInserting() == false) goto L192;
    L193:
        r120.updateRememberedValue(Integer.valueOf(r210));
        r120.apply(Integer.valueOf(r210), r34);
    L194:
        Updater.set-impl(r120, r118, r27.getSetModifier());
        r52.invoke(r9, Integer.valueOf((r22 >> 27) & 14));
        boolean r38 = r9.changedInstance(r17) | r9.changedInstance(r25);
        Object r39 = r9.rememberedValue();
        if (r38 == false) goto L197;
    L198:
        r39 = new g6(r17, r25);
        r9.updateRememberedValue(r39);
    L199:
        Function0 r47 = (Function0) r39;
        ModalBottomSheetValue r56 = r17.getAnchoredDraggableState$material().getTargetValue();
        ModalBottomSheetValue r121 = ModalBottomSheetValue.Hidden;
        if (r56 == r121) goto L202;
        boolean r57 = true;
    L203:
        long r410 = r23;
        boolean r411 = r57;
        m2098Scrim3JVO9M(r410, r47, r411, r9, (r22 >> 24) & 14);
        r9.endNode();
        Modifier r58 = SizeKt.fillMaxWidth$default(SizeKt.m1021widthInVpY3zN4$default(r31.align(r32, r112.getTopCenter()), androidx.compose.material3.MenuKt.ClosedAlphaTarget, MaxModalBottomSheetWidth, 1, null), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null);
        if (r37 == false) goto L213;
        r9.startReplaceGroup(351375666);
        boolean r59 = r9.changed(r17.getAnchoredDraggableState$material());
        Object r60 = r9.rememberedValue();
        if (r59 == false) goto L208;
    L211:
        Orientation r61 = r111;
        Object r62 = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r17.getAnchoredDraggableState$material(), r61);
        r9.updateRememberedValue(r62);
    L212:
        Modifier r63 = NestedScrollModifierKt.nestedScroll$default(r32, (NestedScrollConnection) r62, null, 2, null);
        r9.endReplaceGroup();
    L214:
        Modifier r211 = modalBottomSheetAnchors(r58.then(r63), r17);
        AnchoredDraggableState<ModalBottomSheetValue> r212 = r17.getAnchoredDraggableState$material();
        if (r37 == true) goto L217;
    L219:
        boolean r213 = false;
    L220:
        Modifier r64 = AnchoredDraggableKt.anchoredDraggable$default(r211, r212, r61, r213, false, null, false, 56, null);
        if (r37 == false) goto L228;
        r9.startReplaceGroup(352377090);
        boolean r65 = r9.changedInstance(r17) | r9.changedInstance(r25);
        Object r66 = r9.rememberedValue();
        if (r65 == false) goto L225;
    L226:
        r66 = new h6(r17, r25);
        r9.updateRememberedValue(r66);
    L227:
        r32 = SemanticsModifierKt.semantics$default(r32, false, (Function1) r66, 1, null);
        r9.endReplaceGroup();
    L229:
        int r67 = r22 >> 12;
        float r214 = r19;
        SurfaceKt.m2175SurfaceFjzlyU(r64.then(r32), r36, r51, r49, null, r214, ComposableLambdaKt.rememberComposableLambda(-1557535116, true, new ModalBottomSheetKt$ModalBottomSheetLayout$1$4(r40), r9, 54), r9, (((((r22 >> 9) & 112) | 1572864) | (r67 & 896)) | (r67 & 7168)) | (r22 & 458752), 16);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L232;
        ComposerKt.traceEventEnd();
    L232:
        long r122 = r49;
        long r123 = r51;
        final ModalBottomSheetState r68 = r17;
        long r124 = r23;
        final Modifier r69 = r35;
        final Shape r70 = r36;
        final boolean r71 = r37;
        final float r72 = r19;
    L234:
        ScopeUpdateScope r125 = r9.endRestartGroup();
        if (r125 == null) goto L238;
        final long r73 = r123;
        final long r74 = r122;
        final long r126 = r124;
        r125.updateScope(new i6(r40, r69, r68, r71, r70, r72, r73, r74, r126, r52, r54, r55));
        return;
    L238:
        return;
    L225:
        if (r66 != r110.getEmpty()) goto L227;
    L228:
        r9.startReplaceGroup(1258354200);
        r9.endReplaceGroup();
        goto L229
    L217:
        if (r17.getAnchoredDraggableState$material().getCurrentValue() == r121) goto L219;
        r213 = true;
        goto L220
    L208:
        if (r60 == r110.getEmpty()) goto L211;
        r62 = r60;
        r61 = r111;
        goto L212
    L213:
        r61 = r111;
        r9.startReplaceGroup(1258275768);
        r9.endReplaceGroup();
        r63 = r32;
        goto L214
    L202:
        r57 = false;
        goto L203
    L197:
        if (r39 != r110.getEmpty()) goto L199;
    L192:
        if (Intrinsics.areEqual(r120.rememberedValue(), Integer.valueOf(r210)) == true) goto L194;
    L188:
        r9.useNode();
        goto L189
    L180:
        if (Intrinsics.areEqual(r29.rememberedValue(), Integer.valueOf(r114)) == true) goto L182;
    L176:
        r9.useNode();
        goto L177
    L162:
        r22 = r16;
        r23 = r50;
        goto L163
    L155:
        r20 = r46;
        goto L157
    L151:
        r19 = r45;
        goto L153
    L147:
        r18 = r44;
        goto L149
    L141:
        r17 = r5;
        goto L142
    L137:
        r1 = r4;
        goto L139
    L114:
        if (r9.getDefaultsInvalid() == true) goto L135;
        r9.skipToGroupEnd();
        if ((r55 & 4) == 0) goto L120;
        r16 = r16 & (-897);
    L120:
        if ((r55 & 16) == 0) goto L123;
        r16 = r16 & (-57345);
    L123:
        if ((r55 & 32) == 0) goto L126;
        r16 = r16 & (-458753);
    L126:
        if ((r55 & 64) == 0) goto L129;
        r16 = r16 & (-3670017);
    L129:
        if ((r55 & 128) == 0) goto L132;
        r16 = r16 & (-29360129);
    L132:
        if ((r55 & 256) == 0) goto L134;
        r16 = r16 & (-234881025);
    L134:
        r18 = r44;
        r1 = r4;
        r17 = r5;
        r22 = r16;
        r23 = r14;
        r19 = r45;
        r20 = r46;
        goto L163
    L233:
        r9.skipToGroupEnd();
        r72 = r45;
        r124 = r50;
        r69 = r4;
        r68 = r5;
        r122 = r10;
        r71 = r12;
        r70 = r44;
        r123 = r46;
        goto L234
    L108:
        r0 = false;
        goto L110
    L99:
        if ((r54 & 805306368) != 0) goto L105;
        if (r9.changedInstance(r52) == false) goto L103;
        int r75 = 536870912;
    L104:
        r2 = r2 | r75;
        goto L105
    L103:
        r75 = 268435456;
        goto L104
    L90:
        if (r9.changed(r14) == false) goto L92;
        r15 = 67108864;
        goto L93
    L94:
        r14 = r50;
        goto L96
    L80:
        if (r9.changed(r10) == false) goto L82;
        r13 = 8388608;
        goto L83
    L84:
        r10 = r48;
        goto L86
    L38:
        r12 = r43;
        if ((r54 & 3072) != 0) goto L46;
        if (r9.changed(r12) == false) goto L43;
        int r76 = 2048;
    L44:
        r2 = r2 | r76;
        goto L46
    L43:
        r76 = 1024;
        goto L44
    L27:
        if ((r55 & 4) != 0) goto L31;
        r5 = r42;
        if (r9.changedInstance(r5) == false) goto L32;
        int r77 = 256;
    L33:
        r2 = r2 | r77;
    L32:
        r77 = 128;
        goto L33
    L31:
        r5 = r42;
        goto L32
    L17:
        if ((r54 & 48) != 0) goto L23;
        r4 = r41;
        if (r9.changed(r4) == false) goto L21;
        int r78 = 32;
    L22:
        r2 = r2 | r78;
        goto L25
    L21:
        r78 = 16;
        goto L22
    L6:
        if ((r54 & 6) == 0) goto L8;
        r2 = r54;
        goto L13
    L8:
        if (r9.changedInstance(r40) == false) goto L10;
        int r79 = 4;
    L11:
        r2 = r79 | r54;
        goto L13
    L10:
        r79 = 2;
        goto L11
    }
}
