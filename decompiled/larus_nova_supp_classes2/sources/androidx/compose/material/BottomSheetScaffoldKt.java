package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\n\u001a!\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001aý\u0001\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\f2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020&2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b-\u0010.\u001ao\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020$2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010+\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0004\b1\u00102\u001a\u0098\u0001\u00103\u001a\u00020\u00122\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0011\u00104\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0006\u0010(\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u0001H\u0003¢\u0006\u0004\b8\u00109\u001a\u001c\u0010:\u001a\u00020;2\n\u00100\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u00020>H\u0002\"\u0010\u0010?\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@¨\u0006C"}, d2 = {"rememberBottomSheetState", "Landroidx/compose/material/BottomSheetState;", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "rememberBottomSheetScaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "bottomSheetState", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "BottomSheetScaffold", "", "sheetContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "topBar", "Lkotlin/Function0;", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "Landroidx/compose/ui/unit/Dp;", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheet", "state", "BottomSheet-dAqlCkY", "(Landroidx/compose/material/BottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-HJHHjMs", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;ILandroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "FabSpacing", "F", "BottomSheetScaffoldPositionalThreshold", "BottomSheetScaffoldVelocityThreshold", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetScaffoldKt {
    private static final float BottomSheetScaffoldPositionalThreshold = 0.0f;
    private static final float BottomSheetScaffoldVelocityThreshold = 0.0f;
    private static final float FabSpacing = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/material/BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        public Object m1965onPreFlingQWom1Mo(long r6, Continuation<? super Velocity> r8) {
            if ((r8 instanceof BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == false) goto L7;
            BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r8;
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
            r0 = new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, r8);
            goto L8
        }

        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public long m1966onPreScrollOzD1aCk(long r1, int r3) {
            float r2 = offsetToFloat(r1);
            if (r2 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L8;
            if (NestedScrollSource.equals-impl0(r3, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L8;
            return toOffset(this.$state.dispatchRawDelta(r2));
        L8:
            return Offset.Companion.getZero-F1C5BW0();
        }

        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public Object m1963onPostFlingRZ2iAVY(long r3, long r5, Continuation<? super Velocity> r7) {
            if ((r7 instanceof BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == false) goto L7;
            BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r4 = (BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r7;
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
            r4 = new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, r7);
            goto L8
        }

        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public long m1964onPostScrollDzOQY0M(long r1, long r3, int r5) {
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
            int[] r0 = new int[BottomSheetValue.values().length];
            r0[BottomSheetValue.Collapsed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BottomSheetValue.Expanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final Unit BottomSheetScaffoldLayout_HJHHjMs$lambda$17(Function2 r12, Function2 r13, Function2 r14, Function2 r15, Function2 r16, float r17, Function0 r18, int r19, BottomSheetState r20, int r21, Composer r22, int r23) {
        m1959BottomSheetScaffoldLayoutHJHHjMs(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit BottomSheetScaffold_HnlDQGw$lambda$6(Function3 r24, Modifier r25, BottomSheetScaffoldState r26, Function2 r27, Function3 r28, Function2 r29, int r30, boolean r31, Shape r32, float r33, long r34, long r36, float r38, long r39, long r41, Function3 r43, int r44, int r45, int r46, Composer r47, int r48) {
        m1958BottomSheetScaffoldHnlDQGw(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r36, r38, r39, r41, r43, r47, RecomposeScopeImplKt.updateChangedFlags(r44 | 1), RecomposeScopeImplKt.updateChangedFlags(r45), r46);
        return Unit.INSTANCE;
    }

    private static final Unit BottomSheet_dAqlCkY$lambda$15(BottomSheetState r15, boolean r16, Shape r17, float r18, long r19, long r21, float r23, Modifier r24, Function3 r25, int r26, int r27, Composer r28, int r29) {
        m1957BottomSheetdAqlCkY(r15, r16, r17, r18, r19, r21, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Function2 r1, Function2 r2, Function2 r3, Function2 r4, float r5, Function0 r6, int r7, BottomSheetState r8, int r9, Composer r10, int r11) {
        return BottomSheetScaffoldLayout_HJHHjMs$lambda$17(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(int r0, float r1, float r2, DraggableAnchorsConfig r3) {
        return BottomSheet_dAqlCkY$lambda$10$lambda$9$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Pair c(BottomSheetState r0, float r1, IntSize r2, Constraints r3) {
        return BottomSheet_dAqlCkY$lambda$10$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit d(BottomSheetState r0, boolean r1, Shape r2, float r3, long r4, long r6, float r8, Modifier r9, Function3 r10, int r11, int r12, Composer r13, int r14) {
        return BottomSheet_dAqlCkY$lambda$15(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ BottomSheetState e(BottomSheetValue r0, Density r1, AnimationSpec r2, Function1 r3) {
        return rememberBottomSheetState$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean f(BottomSheetState r0, CoroutineScope r1) {
        return BottomSheet_dAqlCkY$lambda$14$lambda$13$lambda$11(r0, r1);
    }

    public static /* synthetic */ boolean g(BottomSheetState r0, CoroutineScope r1) {
        return BottomSheet_dAqlCkY$lambda$14$lambda$13$lambda$12(r0, r1);
    }

    public static /* synthetic */ boolean h(BottomSheetValue r0) {
        return rememberBottomSheetState$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ Unit i(Function3 r1, Modifier r2, BottomSheetScaffoldState r3, Function2 r4, Function3 r5, Function2 r6, int r7, boolean r8, Shape r9, float r10, long r11, long r13, float r15, long r16, long r18, Function3 r20, int r21, int r22, int r23, Composer r24, int r25) {
        return BottomSheetScaffold_HnlDQGw$lambda$6(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r18, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ Unit j(BottomSheetState r0, CoroutineScope r1, SemanticsPropertyReceiver r2) {
        return BottomSheet_dAqlCkY$lambda$14$lambda$13(r0, r1, r2);
    }

    private static final boolean rememberBottomSheetState$lambda$1$lambda$0(BottomSheetValue r0) {
        return true;
    }

    static {
        FabSpacing = Dp.constructor-impl(16);
        BottomSheetScaffoldPositionalThreshold = Dp.constructor-impl(56);
        BottomSheetScaffoldVelocityThreshold = Dp.constructor-impl(125);
    }

    public static final /* synthetic */ float access$getBottomSheetScaffoldPositionalThreshold$p() {
        return BottomSheetScaffoldPositionalThreshold;
    }

    public static final /* synthetic */ float access$getBottomSheetScaffoldVelocityThreshold$p() {
        return BottomSheetScaffoldVelocityThreshold;
    }

    public static final /* synthetic */ float access$getFabSpacing$p() {
        return FabSpacing;
    }

    private static final boolean BottomSheet_dAqlCkY$lambda$14$lambda$13$lambda$11(BottomSheetState r7, CoroutineScope r8) {
        if (((Boolean) r7.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(BottomSheetValue.Expanded)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new BottomSheetScaffoldKt$BottomSheet$2$1$1$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final boolean BottomSheet_dAqlCkY$lambda$14$lambda$13$lambda$12(BottomSheetState r7, CoroutineScope r8) {
        if (((Boolean) r7.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(BottomSheetValue.Collapsed)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new BottomSheetScaffoldKt$BottomSheet$2$1$2$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> r1, Orientation r2) {
        return new AnonymousClass1(r1, r2);
    }

    public static final /* synthetic */ NestedScrollConnection access$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState r0, Orientation r1) {
        return ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r0, r1);
    }

    private static final Unit BottomSheet_dAqlCkY$lambda$14$lambda$13(final BottomSheetState r3, final CoroutineScope r4, SemanticsPropertyReceiver r5) {
        if (r3.getAnchoredDraggableState$material().getAnchors().getSize() <= 1) goto L9;
        if (r3.isCollapsed() == false) goto L7;
        SemanticsPropertiesKt.expand$default(r5, null, new d2(r3, r4), 1, null);
        goto L9
    L7:
        SemanticsPropertiesKt.collapse$default(r5, null, new e2(r3, r4), 1, null);
    L9:
        return Unit.INSTANCE;
    }

    private static final Pair BottomSheet_dAqlCkY$lambda$10$lambda$9(BottomSheetState r4, final float r5, IntSize r6, Constraints r7) {
        final int r8 = Constraints.getMaxHeight-impl(r7.unbox-impl());
        final float r9 = (int) (r6.unbox-impl() & 4294967295L);
        DraggableAnchors r10 = AnchoredDraggableKt.DraggableAnchors(new a2(r8, r5, r9));
        int r11 = WhenMappings.$EnumSwitchMapping$0[r4.getAnchoredDraggableState$material().getTargetValue().ordinal()];
        if (r11 != 1) goto L5;
        BottomSheetValue r12 = BottomSheetValue.Collapsed;
    L14:
        return TuplesKt.to(r10, r12);
    L5:
        if (r11 != 2) goto L11;
        r12 = BottomSheetValue.Expanded;
        if (r10.hasAnchorFor(r12) == true) goto L14;
        r12 = BottomSheetValue.Collapsed;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private static final Unit BottomSheet_dAqlCkY$lambda$10$lambda$9$lambda$8(int r2, float r3, float r4, DraggableAnchorsConfig r5) {
        float r6 = r2;
        r5.at(BottomSheetValue.Collapsed, r6 - r3);
        if (r4 <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L11;
        if (r4 != r3) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r5.at(BottomSheetValue.Expanded, r6 - r4);
        goto L11
    L7:
        r7 = false;
    L11:
        return Unit.INSTANCE;
    }

    private static final BottomSheetState rememberBottomSheetState$lambda$3$lambda$2(BottomSheetValue r1, Density r2, AnimationSpec r3, Function1 r4) {
        return new BottomSheetState(r1, r2, r3, r4);
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(BottomSheetState r7, SnackbarHostState r8, Composer r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r7 = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, r9, 6, 6);
    L6:
        if ((r11 & 2) == 0) goto L12;
        Object r12 = r9.rememberedValue();
        if (r12 != Composer.Companion.getEmpty()) goto L10;
        r12 = new SnackbarHostState();
        r9.updateRememberedValue(r12);
    L10:
        r8 = (SnackbarHostState) r12;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(-1022285988, r10, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:266)");
    L14:
        boolean r0 = false;
        if (((r10 & 14) ^ 6) <= 4) goto L19;
        if (r9.changed(r7) == false) goto L19;
    L20:
        boolean r13 = true;
    L23:
        if (((r10 & 112) ^ 48) <= 32) goto L27;
        if (r9.changed(r8) == false) goto L27;
    L28:
        r0 = true;
    L29:
        boolean r14 = r13 | r0;
        Object r15 = r9.rememberedValue();
        if (r14 == false) goto L32;
    L33:
        r15 = new BottomSheetScaffoldState(r7, r8);
        r9.updateRememberedValue(r15);
    L34:
        BottomSheetScaffoldState r16 = (BottomSheetScaffoldState) r15;
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        return r16;
    L32:
        if (r15 != Composer.Companion.getEmpty()) goto L34;
    L27:
        if ((r10 & 48) != 32) goto L29;
    L19:
        if ((r10 & 6) == 4) goto L20;
        r13 = false;
        goto L23
    }

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue r7, final AnimationSpec<Float> r8, final Function1<? super BottomSheetValue, Boolean> r9, Composer r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r8 = BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec();
    L6:
        if ((r12 & 4) == 0) goto L12;
        Object r13 = r10.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L10;
        r13 = new b2();
        r10.updateRememberedValue(r13);
    L10:
        r9 = (Function1) r13;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1808153344, r11, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:224)");
    L14:
        final Density r14 = (Density) r10.consume(CompositionLocalsKt.getLocalDensity());
        boolean r1 = true;
        Object[] r2 = {r8};
        Saver<BottomSheetState, ?> r4 = BottomSheetState.Companion.Saver(r8, r9, r14);
        if (((r11 & 14) ^ 6) <= 4) goto L19;
        if (r10.changed(r7.ordinal()) == false) goto L19;
    L20:
        boolean r0 = true;
    L22:
        boolean r3 = (r0 | r10.changed(r14)) | r10.changedInstance(r8);
        if (((r11 & 896) ^ 384) <= 256) goto L27;
        if (r10.changed(r9) == false) goto L27;
    L30:
        boolean r15 = r3 | r1;
        Object r5 = r10.rememberedValue();
        if (r15 == false) goto L33;
    L34:
        r5 = new c2(r7, r14, r8, r9);
        r10.updateRememberedValue(r5);
    L35:
        BottomSheetState r16 = (BottomSheetState) RememberSaveableKt.rememberSaveable(r2, r4, (Function0) r5, r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r16;
    L33:
        if (r5 != Composer.Companion.getEmpty()) goto L35;
    L27:
        if ((r11 & 384) == 256) goto L30;
        r1 = false;
    L19:
        if ((r11 & 6) == 4) goto L20;
        r0 = false;
        goto L22
    }

    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-HJHHjMs, reason: not valid java name */
    private static final void m1959BottomSheetScaffoldLayoutHJHHjMs(final Function2<? super Composer, ? super Integer, Unit> r18, final Function2<? super Composer, ? super Integer, Unit> r19, final Function2<? super Composer, ? super Integer, Unit> r20, final Function2<? super Composer, ? super Integer, Unit> r21, final Function2<? super Composer, ? super Integer, Unit> r22, final float r23, final Function0<Float> r24, final int r25, final BottomSheetState r26, Composer r27, final int r28) {
        Composer r11 = r27.startRestartGroup(757616750);
        if ((r28 & 6) == 0) goto L5;
        int r12 = r28;
    L11:
        if ((r28 & 48) != 0) goto L18;
        if (r11.changedInstance(r19) == false) goto L15;
        int r15 = 32;
    L16:
        r12 = r12 | r15;
        goto L18
    L15:
        r15 = 16;
    L18:
        if ((r28 & 384) != 0) goto L25;
        if (r11.changedInstance(r20) == false) goto L22;
        int r16 = 256;
    L23:
        r12 = r12 | r16;
        goto L25
    L22:
        r16 = 128;
    L25:
        if ((r28 & 3072) != 0) goto L32;
        if (r11.changedInstance(r21) == false) goto L29;
        int r17 = 2048;
    L30:
        r12 = r12 | r17;
        goto L32
    L29:
        r17 = 1024;
    L32:
        if ((r28 & 24576) != 0) goto L39;
        if (r11.changedInstance(r22) == false) goto L36;
        int r110 = 16384;
    L37:
        r12 = r12 | r110;
        goto L39
    L36:
        r110 = 8192;
    L39:
        if ((196608 & r28) != 0) goto L46;
        if (r11.changed(r23) == false) goto L43;
        int r111 = 131072;
    L44:
        r12 = r12 | r111;
        goto L46
    L43:
        r111 = 65536;
    L46:
        if ((1572864 & r28) != 0) goto L53;
        if (r11.changedInstance(r24) == false) goto L50;
        int r112 = 1048576;
    L51:
        r12 = r12 | r112;
        goto L53
    L50:
        r112 = 524288;
    L53:
        if ((12582912 & r28) != 0) goto L60;
        if (r11.changed(r25) == false) goto L57;
        int r113 = 8388608;
    L58:
        r12 = r12 | r113;
        goto L60
    L57:
        r113 = 4194304;
    L60:
        if ((100663296 & r28) == 0) goto L62;
    L66:
        boolean r114 = true;
        if ((38347923 & r12) == 38347922) goto L69;
        boolean r13 = true;
    L71:
        if (r11.shouldExecute(r13, r12 & 1) == true) goto L73;
        r11.skipToGroupEnd();
    L128:
        ScopeUpdateScope r14 = r11.endRestartGroup();
        if (r14 == null) goto L132;
        r14.updateScope(new f2(r18, r19, r20, r21, r22, r23, r24, r25, r26, r28));
        return;
    L132:
        return;
    L73:
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventStart(757616750, r12, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:469)");
    L75:
        Function2[] r0 = new Function2[5];
        if (r18 != null) goto L78;
        Function2<? super Composer, ? super Integer, Unit> r115 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2022getLambda$505419337$material();
    L79:
        r0[0] = r115;
        r0[1] = r19;
        r0[2] = r20;
        if (r21 != null) goto L82;
        Function2<? super Composer, ? super Integer, Unit> r116 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$687232378$material();
    L83:
        r0[3] = r116;
        r0[4] = r22;
        List r1 = CollectionsKt.listOf(r0);
        if ((3670016 & r12) != 1048576) goto L86;
        boolean r117 = true;
    L88:
        if ((29360128 & r12) != 8388608) goto L90;
        boolean r118 = true;
    L91:
        boolean r119 = r117 | r118;
        if ((458752 & r12) != 131072) goto L94;
        boolean r120 = true;
    L95:
        boolean r121 = r119 | r120;
        if ((r12 & 234881024) != 67108864) goto L98;
        boolean r122 = true;
    L99:
        boolean r123 = r122 | r121;
        Object r124 = r11.rememberedValue();
        if (r123 == false) goto L102;
    L103:
        r124 = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(r24, r25, r23, r26);
        r11.updateRememberedValue(r124);
    L104:
        MultiContentMeasurePolicy r125 = (MultiContentMeasurePolicy) r124;
        Modifier.Companion r126 = Modifier.Companion;
        Function2 r2 = LayoutKt.combineAsVirtualLayouts(r1);
        if (r11.changed(r125) == true) goto L107;
        r114 = false;
    L107:
        Object r127 = r11.rememberedValue();
        if (r114 == false) goto L110;
    L111:
        r127 = MultiContentMeasurePolicyKt.createMeasurePolicy(r125);
        r11.updateRememberedValue(r127);
    L112:
        MeasurePolicy r128 = (MeasurePolicy) r127;
        int r129 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r130 = r11.getCurrentCompositionLocalMap();
        Modifier r131 = ComposedModifierKt.materializeModifier(r11, r126);
        ComposeUiNode.Companion r132 = ComposeUiNode.Companion;
        Function0 r3 = r132.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L115;
        ComposablesKt.invalidApplier();
    L115:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L118;
        r11.createNode(r3);
    L119:
        Composer r4 = Updater.constructor-impl(r11);
        Updater.set-impl(r4, r128, r132.getSetMeasurePolicy());
        Updater.set-impl(r4, r130, r132.getSetResolvedCompositionLocals());
        Function2 r5 = r132.getSetCompositeKeyHash();
        if (r4.getInserting() == false) goto L122;
    L123:
        r4.updateRememberedValue(Integer.valueOf(r129));
        r4.apply(Integer.valueOf(r129), r5);
    L124:
        Updater.set-impl(r4, r131, r132.getSetModifier());
        r2.invoke(r11, 0);
        r11.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
        goto L128
    L122:
        if (Intrinsics.areEqual(r4.rememberedValue(), Integer.valueOf(r129)) == true) goto L124;
    L118:
        r11.useNode();
        goto L119
    L110:
        if (r127 != Composer.Companion.getEmpty()) goto L112;
    L102:
        if (r124 != Composer.Companion.getEmpty()) goto L104;
    L98:
        r122 = false;
        goto L99
    L94:
        r120 = false;
        goto L95
    L90:
        r118 = false;
        goto L91
    L86:
        r117 = false;
        goto L88
    L82:
        r116 = r21;
        goto L83
    L78:
        r115 = r18;
        goto L79
    L69:
        r13 = false;
        goto L71
    L62:
        if (r11.changed(r26) == false) goto L64;
        int r133 = 67108864;
    L65:
        r12 = r12 | r133;
        goto L66
    L64:
        r133 = 33554432;
        goto L65
    L5:
        if (r11.changedInstance(r18) == false) goto L7;
        int r134 = 4;
    L8:
        r12 = r134 | r28;
        goto L11
    L7:
        r134 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$BottomSheetScaffoldLayout-HJHHjMs, reason: not valid java name */
    public static final /* synthetic */ void m1961access$BottomSheetScaffoldLayoutHJHHjMs(Function2 r0, Function2 r1, Function2 r2, Function2 r3, Function2 r4, float r5, Function0 r6, int r7, BottomSheetState r8, Composer r9, int r10) {
        m1959BottomSheetScaffoldLayoutHJHHjMs(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX INFO: renamed from: BottomSheet-dAqlCkY, reason: not valid java name */
    private static final void m1957BottomSheetdAqlCkY(final BottomSheetState r26, final boolean r27, final Shape r28, final float r29, final long r30, final long r32, final float r34, Modifier r35, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r2 = r37.startRestartGroup(-426833549);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L14:
        if ((r39 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r39 & 4) == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r39 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L47:
        if ((r39 & 16) == 0) goto L50;
        r3 = r3 | 24576;
    L57:
        if ((r39 & 32) == 0) goto L60;
        r3 = r3 | 196608;
    L67:
        if ((r39 & 64) == 0) goto L70;
        r3 = r3 | 1572864;
    L76:
        int r8 = r39 & 128;
        if (r8 == 0) goto L79;
        r3 = r3 | 12582912;
        final Modifier r10 = r35;
    L87:
        if ((r39 & 256) == 0) goto L90;
        r3 = r3 | 100663296;
    L97:
        if ((38347923 & r3) == 38347922) goto L99;
        boolean r0 = true;
    L101:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L131;
        if (r8 == 0) goto L105;
        r10 = Modifier.Companion;
    L105:
        if (ComposerKt.isTraceInProgress() == false) goto L107;
        ComposerKt.traceEventStart(-426833549, r3, -1, "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:387)");
    L107:
        Object r1 = r2.rememberedValue();
        Composer.Companion r4 = Composer.Companion;
        if (r1 != r4.getEmpty()) goto L110;
        r1 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r2);
        r2.updateRememberedValue(r1);
    L110:
        final CoroutineScope r5 = (CoroutineScope) r1;
        final float r9 = ((Density) r2.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(r34);
        AnchoredDraggableState<BottomSheetValue> r6 = r26.getAnchoredDraggableState$material();
        Orientation r7 = Orientation.Vertical;
        boolean r16 = r2.changed(r9);
        int r11 = r3 & 14;
        if (r11 != 4) goto L113;
        boolean r12 = true;
    L114:
        boolean r13 = r16 | r12;
        Object r14 = r2.rememberedValue();
        if (r13 == false) goto L117;
    L118:
        r14 = new x1(r26, r9);
        r2.updateRememberedValue(r14);
    L119:
        Modifier r15 = AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(r10, r6, r7, (Function2) r14), r26.getAnchoredDraggableState$material(), r7, r27, false, null, false, 56, null);
        if (r11 != 4) goto L122;
        boolean r17 = true;
    L123:
        boolean r18 = r17 | r2.changedInstance(r5);
        Object r19 = r2.rememberedValue();
        if (r18 == false) goto L126;
    L127:
        r19 = new y1(r26, r5);
        r2.updateRememberedValue(r19);
    L128:
        int r20 = r3 >> 6;
        SurfaceKt.m2175SurfaceFjzlyU(SemanticsModifierKt.semantics$default(r15, false, (Function1) r19, 1, null), r28, r30, r32, null, r29, ComposableLambdaKt.rememberComposableLambda(1065607095, true, new BottomSheetScaffoldKt$BottomSheet$3(r36), r2, 54), r2, (((((r3 >> 3) & 112) | 1572864) | (r20 & 896)) | (r20 & 7168)) | ((r3 << 6) & 458752), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventEnd();
    L132:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L136;
        r110.updateScope(new z1(r26, r27, r28, r29, r30, r32, r34, r10, r36, r38, r39));
        return;
    L136:
        return;
    L126:
        if (r19 != r4.getEmpty()) goto L128;
    L122:
        r17 = false;
        goto L123
    L117:
        if (r14 != r4.getEmpty()) goto L119;
    L113:
        r12 = false;
        goto L114
    L131:
        r2.skipToGroupEnd();
        goto L132
    L99:
        r0 = false;
        goto L101
    L90:
        if ((r38 & 100663296) != 0) goto L97;
        if (r2.changedInstance(r36) == false) goto L94;
        int r21 = 67108864;
    L95:
        r3 = r3 | r21;
        goto L97
    L94:
        r21 = 33554432;
        goto L95
    L79:
        r10 = r35;
        if ((r38 & 12582912) != 0) goto L87;
        if (r2.changed(r10) == false) goto L84;
        int r111 = 8388608;
    L85:
        r3 = r3 | r111;
        goto L87
    L84:
        r111 = 4194304;
        goto L85
    L70:
        if ((r38 & 1572864) != 0) goto L76;
        if (r2.changed(r34) == false) goto L74;
        int r22 = 1048576;
    L75:
        r3 = r3 | r22;
        goto L76
    L74:
        r22 = 524288;
        goto L75
    L60:
        if ((r38 & 196608) != 0) goto L67;
        if (r2.changed(r32) == false) goto L64;
        int r23 = 131072;
    L65:
        r3 = r3 | r23;
        goto L67
    L64:
        r23 = 65536;
        goto L65
    L50:
        if ((r38 & 24576) != 0) goto L57;
        if (r2.changed(r30) == false) goto L54;
        int r24 = 16384;
    L55:
        r3 = r3 | r24;
        goto L57
    L54:
        r24 = 8192;
        goto L55
    L39:
        if ((r38 & 3072) != 0) goto L47;
        if (r2.changed(r29) == false) goto L43;
        int r25 = 2048;
    L44:
        r3 = r3 | r25;
        goto L47
    L43:
        r25 = 1024;
        goto L44
    L28:
        if ((r38 & 384) != 0) goto L36;
        if (r2.changed(r28) == false) goto L32;
        int r31 = 256;
    L33:
        r3 = r3 | r31;
        goto L36
    L32:
        r31 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L25;
        if (r2.changed(r27) == false) goto L21;
        int r33 = 32;
    L22:
        r3 = r3 | r33;
        goto L25
    L21:
        r33 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L14
    L8:
        if (r2.changed(r26) == false) goto L10;
        int r40 = 4;
    L11:
        r3 = r40 | r38;
        goto L14
    L10:
        r40 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: access$BottomSheet-dAqlCkY, reason: not valid java name */
    public static final /* synthetic */ void m1960access$BottomSheetdAqlCkY(BottomSheetState r0, boolean r1, Shape r2, float r3, long r4, long r6, float r8, Modifier r9, Function3 r10, Composer r11, int r12, int r13) {
        m1957BottomSheetdAqlCkY(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: BottomSheetScaffold-HnlDQGw, reason: not valid java name */
    public static final void m1958BottomSheetScaffoldHnlDQGw(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r34, Modifier r35, BottomSheetScaffoldState r36, Function2<? super Composer, ? super Integer, Unit> r37, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r38, Function2<? super Composer, ? super Integer, Unit> r39, int r40, boolean r41, Shape r42, float r43, long r44, long r46, float r48, long r49, long r51, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r53, Composer r54, final int r55, final int r56, final int r57) {
        Composer r1 = r54.startRestartGroup(194495313);
        if ((r57 & 1) == 0) goto L6;
        int r5 = r55 | 6;
    L13:
        int r6 = r57 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L23:
        Modifier r9 = r35;
    L25:
        if ((r55 & 384) == 0) goto L27;
        BottomSheetScaffoldState r10 = r36;
    L35:
        int r16 = r57 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r5 = r5 | 3072;
    L46:
        int r19 = r57 & 16;
        int r20 = 16384;
        if (r19 == 0) goto L50;
        r5 = r5 | 24576;
    L57:
        int r23 = r57 & 32;
        if (r23 == 0) goto L60;
        r5 = r5 | 196608;
        Function2<? super Composer, ? super Integer, Unit> r7 = r39;
    L67:
        int r26 = r57 & 64;
        if (r26 == 0) goto L70;
        r5 = r5 | 1572864;
        int r8 = r40;
    L77:
        int r11 = r57 & 128;
        if (r11 == 0) goto L80;
        r5 = r5 | 12582912;
        boolean r12 = r41;
    L88:
        if ((r55 & 100663296) != 0) goto L99;
        if ((r57 & 256) != 0) goto L95;
        if (r1.changed(r42) == false) goto L95;
        int r32 = 67108864;
    L96:
        r5 = r5 | r32;
    L95:
        r32 = 33554432;
    L99:
        if ((r55 & 805306368) != 0) goto L110;
        if ((r57 & 512) != 0) goto L106;
        if (r1.changed(r43) == false) goto L106;
        int r33 = 536870912;
    L107:
        r5 = r5 | r33;
    L106:
        r33 = 268435456;
    L110:
        if ((r56 & 6) == 0) goto L112;
        int r0 = r56;
    L120:
        if ((r56 & 48) != 0) goto L131;
        if ((r57 & 2048) != 0) goto L127;
        if (r1.changed(r46) == false) goto L127;
        int r25 = 32;
    L128:
        r0 = r0 | r25;
    L127:
        r25 = 16;
    L131:
        if ((r56 & 384) != 0) goto L142;
        if ((r57 & 4096) != 0) goto L138;
        if (r1.changed(r48) == false) goto L138;
        int r29 = 256;
    L139:
        r0 = r0 | r29;
    L138:
        r29 = 128;
    L142:
        if ((r56 & 3072) != 0) goto L153;
        if ((r57 & 8192) != 0) goto L149;
        if (r1.changed(r49) == false) goto L149;
    L150:
        r0 = r0 | r17;
    L149:
        r17 = 1024;
    L153:
        if ((r56 & 24576) != 0) goto L164;
        if ((r57 & 16384) != 0) goto L160;
        if (r1.changed(r51) == false) goto L160;
    L161:
        r0 = r0 | r20;
    L160:
        r20 = 8192;
    L164:
        if ((r57 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L167;
        r0 = r0 | 196608;
    L174:
        if ((r5 & 306783379) == 306783378) goto L176;
    L179:
        boolean r2 = true;
    L181:
        if (r1.shouldExecute(r2, r5 & 1) == false) goto L266;
        r1.startDefaults();
        if ((r55 & 1) != 0) goto L185;
    L212:
        if (r6 == 0) goto L215;
        r9 = Modifier.Companion;
    L215:
        if ((r57 & 4) == 0) goto L217;
        r5 = r5 & (-897);
        r10 = rememberBottomSheetScaffoldState(null, null, r1, 0, 3);
    L217:
        if (r16 == 0) goto L219;
        Function2<? super Composer, ? super Integer, Unit> r3 = null;
    L220:
        if (r19 == 0) goto L222;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r13 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
    L223:
        if (r23 == 0) goto L225;
        r7 = null;
    L225:
        if (r26 == 0) goto L227;
        r8 = FabPosition.Companion.m2069getEnd5ygKITE();
    L227:
        if (r11 == 0) goto L230;
        r12 = true;
    L230:
        if ((r57 & 256) == 0) goto L232;
        Shape r14 = MaterialTheme.INSTANCE.getShapes(r1, 6).getLarge();
        r5 = r5 & (-234881025);
    L234:
        if ((r57 & 512) == 0) goto L236;
        float r4 = BottomSheetScaffoldDefaults.INSTANCE.m1955getSheetElevationD9Ej5fM();
        r5 = r5 & (-1879048193);
    L238:
        if ((r57 & 1024) == 0) goto L240;
        long r15 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
        r0 = r0 & (-15);
    L241:
        float r310 = r4;
        if ((r57 & 2048) == 0) goto L244;
        long r18 = ColorsKt.m2017contentColorForek8zF_U(r15, r1, r0 & 14);
        r0 = r0 & (-113);
    L246:
        if ((r57 & 4096) == 0) goto L248;
        float r21 = BottomSheetScaffoldDefaults.INSTANCE.m1956getSheetPeekHeightD9Ej5fM();
        r0 = r0 & (-897);
    L249:
        long r110 = r15;
        if ((r57 & 8192) == 0) goto L252;
        long r22 = MaterialTheme.INSTANCE.getColors(r1, 6).m1992getBackground0d7_KjU();
        r0 = r0 & (-7169);
    L253:
        float r311 = r21;
        if ((r57 & 16384) == 0) goto L256;
        long r24 = ColorsKt.m2017contentColorForek8zF_U(r22, r1, (r0 >> 9) & 14);
        r0 = r0 & (-57345);
    L257:
        int r111 = r0;
        int r112 = r5;
        Function2<? super Composer, ? super Integer, Unit> r27 = r3;
        long r28 = r22;
        float r30 = r311;
        float r31 = r310;
    L258:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L262;
        ComposerKt.traceEventStart(194495313, r112, r111, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
    L262:
        Function2<? super Composer, ? super Integer, Unit> r47 = r27;
        int r45 = r111 >> 3;
        long r312 = r28;
        long r313 = r24;
        SurfaceKt.m2175SurfaceFjzlyU(SizeKt.fillMaxSize$default(r9, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), null, r312, r313, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, ComposableLambdaKt.rememberComposableLambda(-747577963, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(r10, r27, r7, r30, r8, r53, r12, r14, r31, r110, r18, r34, r13), r1, 54), r1, (r45 & 7168) | ((r45 & 896) | 1572864), 50);
        if (ComposerKt.isTraceInProgress() == false) goto L265;
        ComposerKt.traceEventEnd();
    L265:
        final Function2<? super Composer, ? super Integer, Unit> r50 = r47;
        final float r113 = r30;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r52 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r58 = r7;
        final int r59 = r8;
        final BottomSheetScaffoldState r60 = r10;
        final boolean r61 = r12;
        final long r114 = r18;
        final long r115 = r28;
        final float r116 = r31;
        final Modifier r62 = r9;
        final Shape r63 = r14;
        final long r117 = r110;
        final long r118 = r24;
    L267:
        ScopeUpdateScope r64 = r1.endRestartGroup();
        if (r64 == null) goto L271;
        r64.updateScope(new g2(r34, r62, r60, r50, r52, r58, r59, r61, r63, r116, r117, r114, r113, r115, r118, r53, r55, r56, r57));
        return;
    L271:
        return;
    L256:
        r24 = r51;
        goto L257
    L252:
        r22 = r49;
        goto L253
    L248:
        r21 = r48;
        goto L249
    L244:
        r18 = r46;
        goto L246
    L240:
        r15 = r44;
        goto L241
    L236:
        r4 = r43;
        goto L238
    L232:
        r14 = r42;
        goto L234
    L222:
        r13 = r38;
        goto L223
    L219:
        r3 = r37;
        goto L220
    L185:
        if (r1.getDefaultsInvalid() == true) goto L212;
        r1.skipToGroupEnd();
        if ((r57 & 4) == 0) goto L191;
        r5 = r5 & (-897);
    L191:
        if ((r57 & 256) == 0) goto L194;
        r5 = r5 & (-234881025);
    L194:
        if ((r57 & 512) == 0) goto L197;
        r5 = r5 & (-1879048193);
    L197:
        if ((r57 & 1024) == 0) goto L200;
        r0 = r0 & (-15);
    L200:
        if ((r57 & 2048) == 0) goto L203;
        r0 = r0 & (-113);
    L203:
        if ((r57 & 4096) == 0) goto L206;
        r0 = r0 & (-897);
    L206:
        if ((r57 & 8192) == 0) goto L209;
        r0 = r0 & (-7169);
    L209:
        if ((r57 & 16384) == 0) goto L211;
        r0 = r0 & (-57345);
    L211:
        r13 = r38;
        r14 = r42;
        r31 = r43;
        r110 = r44;
        r18 = r46;
        r30 = r48;
        r24 = r51;
        r111 = r0;
        r112 = r5;
        r27 = r37;
        r28 = r49;
        goto L258
    L266:
        r1.skipToGroupEnd();
        r50 = r37;
        r52 = r38;
        r114 = r46;
        r113 = r48;
        r115 = r49;
        r118 = r51;
        r58 = r7;
        r59 = r8;
        r62 = r9;
        r60 = r10;
        r61 = r12;
        r63 = r42;
        r116 = r43;
        r117 = r44;
        goto L267
    L176:
        if ((74899 & r0) != 74898) goto L179;
        r2 = false;
        goto L181
    L167:
        if ((r56 & 196608) != 0) goto L174;
        if (r1.changedInstance(r53) == false) goto L171;
        int r119 = 131072;
    L172:
        r0 = r0 | r119;
        goto L174
    L171:
        r119 = 65536;
        goto L172
    L112:
        if ((r57 & 1024) == 0) goto L114;
    L116:
        int r210 = 2;
    L117:
        r0 = r56 | r210;
        goto L120
    L114:
        if (r1.changed(r44) == false) goto L116;
        r210 = 4;
        goto L117
    L80:
        r12 = r41;
        if ((r55 & 12582912) != 0) goto L88;
        if (r1.changed(r12) == false) goto L85;
        int r314 = 8388608;
    L86:
        r5 = r5 | r314;
        goto L88
    L85:
        r314 = 4194304;
        goto L86
    L70:
        r8 = r40;
        if ((r55 & 1572864) != 0) goto L77;
        if (r1.changed(r8) == false) goto L75;
        int r211 = 1048576;
    L76:
        r5 = r5 | r211;
        goto L77
    L75:
        r211 = 524288;
        goto L76
    L60:
        r7 = r39;
        if ((r55 & 196608) != 0) goto L67;
        if (r1.changedInstance(r7) == false) goto L65;
        int r212 = 131072;
    L66:
        r5 = r5 | r212;
        goto L67
    L65:
        r212 = 65536;
        goto L66
    L50:
        if ((r55 & 24576) != 0) goto L57;
        if (r1.changedInstance(r38) == false) goto L54;
        int r213 = 16384;
    L55:
        r5 = r5 | r213;
        goto L57
    L54:
        r213 = 8192;
        goto L55
    L39:
        if ((r55 & 3072) != 0) goto L46;
        if (r1.changedInstance(r37) == false) goto L43;
        int r120 = 2048;
    L44:
        r5 = r5 | r120;
        goto L46
    L43:
        r120 = 1024;
        goto L44
    L27:
        if ((r57 & 4) != 0) goto L31;
        r10 = r36;
        if (r1.changed(r10) == false) goto L32;
        int r121 = 256;
    L33:
        r5 = r5 | r121;
    L32:
        r121 = 128;
        goto L33
    L31:
        r10 = r36;
        goto L32
    L17:
        if ((r55 & 48) != 0) goto L23;
        r9 = r35;
        if (r1.changed(r9) == false) goto L21;
        int r122 = 32;
    L22:
        r5 = r5 | r122;
        goto L25
    L21:
        r122 = 16;
        goto L22
    L6:
        if ((r55 & 6) == 0) goto L8;
        r5 = r55;
        goto L13
    L8:
        if (r1.changedInstance(r34) == false) goto L10;
        int r65 = 4;
    L11:
        r5 = r65 | r55;
        goto L13
    L10:
        r65 = 2;
        goto L11
    }
}
