package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001aE\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0010\u001aï\u0001\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00012\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\n¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020#2\b\b\u0002\u0010)\u001a\u00020#2\b\b\u0002\u0010*\u001a\u00020#H\u0007¢\u0006\u0004\b+\u0010,\u001a-\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020#2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u00100\u001a\u00020\u000bH\u0003¢\u0006\u0004\b1\u00102\u001a;\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00032\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015H\u0003¢\u0006\u0002\u00106\u001a[\u00107\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:0\n2\u001d\u0010;\u001a\u0019\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120<¢\u0006\u0002\b\u0015H\u0003¢\u0006\u0002\u0010=\u001a\u001c\u0010B\u001a\u00020C2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030E2\u0006\u0010F\u001a\u00020GH\u0000\"\u0010\u0010>\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010@\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010A\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?¨\u0006H²\u0006\n\u0010I\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"BackdropScaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "initialValue", "Landroidx/compose/material/BackdropValue;", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "rememberBackdropScaffoldState", "confirmStateChange", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "BackdropScaffold", "", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "snackbarHost", "gesturesEnabled", "peekHeight", "Landroidx/compose/ui/unit/Dp;", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "BackdropScaffold-0hNv9B8", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;Lkotlin/jvm/functions/Function3;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLandroidx/compose/runtime/Composer;III)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "BackLayerTransition", "target", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropStack", "backLayer", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "AnimationSlideOffset", "F", "VelocityThreshold", "PositionalThreshold", "ConsumeSwipeNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "material", "alpha", "animationProgress"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = 0.0f;
    private static final float PositionalThreshold = 0.0f;
    private static final float VelocityThreshold = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/material/BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        public Object m1940onPreFlingQWom1Mo(long r6, Continuation<? super Velocity> r8) {
            if ((r8 instanceof BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1) == false) goto L7;
            BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 r0 = (BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1) r8;
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
            r0 = new BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1(this, r8);
            goto L8
        }

        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public long m1941onPreScrollOzD1aCk(long r1, int r3) {
            float r2 = offsetToFloat(r1);
            if (r2 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L8;
            if (NestedScrollSource.equals-impl0(r3, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L8;
            return toOffset(this.$state.dispatchRawDelta(r2));
        L8:
            return Offset.Companion.getZero-F1C5BW0();
        }

        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public Object m1938onPostFlingRZ2iAVY(long r3, long r5, Continuation<? super Velocity> r7) {
            if ((r7 instanceof BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1) == false) goto L7;
            BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1 r4 = (BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1) r7;
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
            r4 = new BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1(this, r7);
            goto L8
        }

        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public long m1939onPostScrollDzOQY0M(long r1, long r3, int r5) {
            if (NestedScrollSource.equals-impl0(r5, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L6;
            return toOffset(this.$state.dispatchRawDelta(offsetToFloat(r3)));
        L6:
            return Offset.Companion.getZero-F1C5BW0();
        }
    }

    private static final Unit BackLayerTransition$lambda$34(BackdropValue r0, Function2 r1, Function2 r2, int r3, Composer r4, int r5) {
        BackLayerTransition(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final boolean BackdropScaffoldState$lambda$0(BackdropValue r0) {
        return true;
    }

    private static final Unit BackdropScaffold_0hNv9B8$lambda$13(Function2 r27, Function2 r28, Function2 r29, Modifier r30, BackdropScaffoldState r31, Function3 r32, boolean r33, float r34, float r35, boolean r36, boolean r37, long r38, long r40, Shape r42, float r43, long r44, long r46, long r48, int r50, int r51, int r52, Composer r53, int r54) {
        m1934BackdropScaffold0hNv9B8(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r40, r42, r43, r44, r46, r48, r53, RecomposeScopeImplKt.updateChangedFlags(r50 | 1), RecomposeScopeImplKt.updateChangedFlags(r51), r52);
        return Unit.INSTANCE;
    }

    private static final Unit BackdropStack$lambda$41(Modifier r6, Function2 r7, Function1 r8, Function4 r9, int r10, Composer r11, int r12) {
        BackdropStack(r6, r7, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_3J_VO9M$lambda$18(long r6, Function0 r8, boolean r9, int r10, Composer r11, int r12) {
        m1935Scrim3JVO9M(r6, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Placeable r0, float r1, Placeable.PlacementScope r2) {
        return BackLayerTransition$lambda$33$lambda$29$lambda$28$lambda$27(r0, r1, r2);
    }

    public static /* synthetic */ MeasureResult b(State r0, MeasureScope r1, Measurable r2, Constraints r3) {
        return BackLayerTransition$lambda$33$lambda$23$lambda$22(r0, r1, r2, r3);
    }

    public static /* synthetic */ BackdropScaffoldState c(BackdropValue r0, Density r1, AnimationSpec r2, Function1 r3, SnackbarHostState r4) {
        return rememberBackdropScaffoldState$lambda$6$lambda$5(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit d(float r0, State r1, GraphicsLayerScope r2) {
        return BackLayerTransition$lambda$33$lambda$25$lambda$24(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(Placeable r0, float r1, Placeable.PlacementScope r2) {
        return BackLayerTransition$lambda$33$lambda$23$lambda$22$lambda$21(r0, r1, r2);
    }

    public static /* synthetic */ MeasureResult f(State r0, MeasureScope r1, Measurable r2, Constraints r3) {
        return BackLayerTransition$lambda$33$lambda$29$lambda$28(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean g(BackdropValue r0) {
        return rememberBackdropScaffoldState$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit h(float r0, State r1, GraphicsLayerScope r2) {
        return BackLayerTransition$lambda$33$lambda$31$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ Unit i(BackdropValue r0, Function2 r1, Function2 r2, int r3, Composer r4, int r5) {
        return BackLayerTransition$lambda$34(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Constraints j(float r0, Constraints r1) {
        return BackdropScaffold_0hNv9B8$lambda$12$lambda$11(r0, r1);
    }

    public static /* synthetic */ Unit k(long r0, State r2, DrawScope r3) {
        return Scrim_3J_VO9M$lambda$17$lambda$16(r0, r2, r3);
    }

    public static /* synthetic */ MeasureResult l(Function2 r0, Function1 r1, Function4 r2, SubcomposeMeasureScope r3, Constraints r4) {
        return BackdropStack$lambda$40$lambda$39(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean m(BackdropValue r0) {
        return BackdropScaffoldState$lambda$0(r0);
    }

    public static /* synthetic */ Unit n(Modifier r0, Function2 r1, Function1 r2, Function4 r3, int r4, Composer r5, int r6) {
        return BackdropStack$lambda$41(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit o(BackdropScaffoldState r0, Density r1) {
        return BackdropScaffold_0hNv9B8$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit p(long r0, Function0 r2, boolean r3, int r4, Composer r5, int r6) {
        return Scrim_3J_VO9M$lambda$18(r0, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit q(Placeable r0, List r1, Placeable.PlacementScope r2) {
        return BackdropStack$lambda$40$lambda$39$lambda$38(r0, r1, r2);
    }

    public static /* synthetic */ Unit r(Function2 r1, Function2 r2, Function2 r3, Modifier r4, BackdropScaffoldState r5, Function3 r6, boolean r7, float r8, float r9, boolean r10, boolean r11, long r12, long r14, Shape r16, float r17, long r18, long r20, long r22, int r24, int r25, int r26, Composer r27, int r28) {
        return BackdropScaffold_0hNv9B8$lambda$13(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r16, r17, r18, r20, r22, r24, r25, r26, r27, r28);
    }

    private static final boolean rememberBackdropScaffoldState$lambda$3$lambda$2(BackdropValue r0) {
        return true;
    }

    static {
        AnimationSlideOffset = Dp.constructor-impl(20);
        VelocityThreshold = Dp.constructor-impl(125);
        PositionalThreshold = Dp.constructor-impl(56);
    }

    public static final /* synthetic */ float access$getPositionalThreshold$p() {
        return PositionalThreshold;
    }

    public static final /* synthetic */ float access$getVelocityThreshold$p() {
        return VelocityThreshold;
    }

    private static final float BackLayerTransition$lambda$19(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final float Scrim_3J_VO9M$lambda$14(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final Constraints BackdropScaffold_0hNv9B8$lambda$12$lambda$11(float r14, Constraints r15) {
        return Constraints.box-impl(ConstraintsKt.offset-NN6Ew-U$default(Constraints.copy-Zbe2FdA$default(r15.unbox-impl(), 0, 0, 0, 0, 10, null), 0, -MathKt.roundToInt(r14), 1, null));
    }

    private static final Unit BackdropScaffold_0hNv9B8$lambda$8$lambda$7(BackdropScaffoldState r0, Density r1) {
        r0.setDensity$material(r1);
        return Unit.INSTANCE;
    }

    public static final NestedScrollConnection ConsumeSwipeNestedScrollConnection(AnchoredDraggableState<?> r1, Orientation r2) {
        return new AnonymousClass1(r1, r2);
    }

    private static final Unit BackLayerTransition$lambda$33$lambda$23$lambda$22$lambda$21(Placeable r1, float r2, Placeable.PlacementScope r3) {
        r3.place(r1, 0, 0, r2);
        return Unit.INSTANCE;
    }

    private static final Unit BackLayerTransition$lambda$33$lambda$25$lambda$24(float r3, State r4, GraphicsLayerScope r5) {
        float r0 = 1;
        float r6 = BackLayerTransition$lambda$19(r4) - r0;
        if (r6 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L6;
        r6 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L6:
        if (r6 <= 1.0f) goto L8;
        r6 = 1.0f;
    L8:
        r5.setAlpha(r6);
        r5.setTranslationY((r0 - r6) * r3);
        return Unit.INSTANCE;
    }

    private static final Unit BackLayerTransition$lambda$33$lambda$29$lambda$28$lambda$27(Placeable r1, float r2, Placeable.PlacementScope r3) {
        r3.place(r1, 0, 0, r2);
        return Unit.INSTANCE;
    }

    private static final Unit BackLayerTransition$lambda$33$lambda$31$lambda$30(float r3, State r4, GraphicsLayerScope r5) {
        float r0 = 1;
        float r6 = r0 - BackLayerTransition$lambda$19(r4);
        if (r6 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L6;
        r6 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L6:
        if (r6 <= 1.0f) goto L8;
        r6 = 1.0f;
    L8:
        r5.setAlpha(r6);
        r5.setTranslationY((r0 - r6) * r3);
        return Unit.INSTANCE;
    }

    private static final Unit BackdropStack$lambda$40$lambda$39$lambda$38(Placeable r9, List r10, Placeable.PlacementScope r11) {
        Placeable.PlacementScope.placeRelative$default(r11, r9, 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        int r12 = r10.size();
        int r0 = 0;
    L3:
        if (r0 >= r12) goto L6;
        Placeable.PlacementScope.placeRelative$default(r11, (Placeable) ListProtector.get(r10, r0), 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r0 = r0 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_3J_VO9M$lambda$17$lambda$16(long r13, State r15, DrawScope r16) {
        DrawScope.-CC.drawRect-n-J9OG0$default(r16, r13, 0, 0, Scrim_3J_VO9M$lambda$14(r15), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    private static final MeasureResult BackLayerTransition$lambda$33$lambda$23$lambda$22(State r7, MeasureScope r8, Measurable r9, Constraints r10) {
        final float r11 = BackLayerTransition$lambda$19(r7) - 1;
        if (r11 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L6;
        r11 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L6:
        if (r11 <= 1.0f) goto L8;
        r11 = 1.0f;
    L8:
        final Placeable r12 = r9.measure-BRTryo0(r10.unbox-impl());
        return MeasureScope.-CC.layout$default(r8, r12.getWidth(), r12.getHeight(), null, new f0(r12, r11), 4, null);
    }

    private static final MeasureResult BackLayerTransition$lambda$33$lambda$29$lambda$28(State r8, MeasureScope r9, Measurable r10, Constraints r11) {
        final float r0 = 1 - BackLayerTransition$lambda$19(r8);
        if (r0 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L6;
        r0 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L6:
        if (r0 <= 1.0f) goto L8;
        r0 = 1.0f;
    L8:
        final Placeable r12 = r10.measure-BRTryo0(r11.unbox-impl());
        return MeasureScope.-CC.layout$default(r9, r12.getWidth(), r12.getHeight(), null, new p0(r12, r0), 4, null);
    }

    private static final void BackLayerTransition(final BackdropValue r16, final Function2<? super Composer, ? super Integer, Unit> r17, final Function2<? super Composer, ? super Integer, Unit> r18, Composer r19, final int r20) {
        Composer r13 = r19.startRestartGroup(2129748230);
        if ((r20 & 6) == 0) goto L5;
        int r5 = r20;
    L11:
        if ((r20 & 48) != 0) goto L18;
        if (r13.changedInstance(r17) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r20 & 384) == 0) goto L20;
    L24:
        int r14 = r5;
        if ((r14 & 147) == 146) goto L27;
        boolean r7 = true;
    L29:
        if (r13.shouldExecute(r7, r14 & 1) == true) goto L31;
        r13.skipToGroupEnd();
    L97:
        ScopeUpdateScope r0 = r13.endRestartGroup();
        if (r0 == null) goto L101;
        r0.updateScope(new k0(r16, r17, r18, r20));
        return;
    L101:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(2129748230, r14, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:519)");
    L34:
        if (r16 != BackdropValue.Revealed) goto L36;
        float r8 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L37:
        final State<Float> r4 = AnimateAsStateKt.animateFloatAsState(r8, new TweenSpec(0, 0, null, 7, null), androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, null, r13, 48, 28);
        final float r9 = ((Density) r13.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(AnimationSlideOffset);
        Modifier.Companion r10 = Modifier.Companion;
        Alignment.Companion r11 = Alignment.Companion;
        MeasurePolicy r12 = BoxKt.maybeCachedBoxMeasurePolicy(r11.getTopStart(), false);
        int r15 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r110 = r13.getCurrentCompositionLocalMap();
        Modifier r111 = ComposedModifierKt.materializeModifier(r13, r10);
        ComposeUiNode.Companion r112 = ComposeUiNode.Companion;
        Function0 r113 = r112.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L40;
        ComposablesKt.invalidApplier();
    L40:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L43;
        r13.createNode(r113);
    L44:
        Composer r1 = Updater.constructor-impl(r13);
        Updater.set-impl(r1, r12, r112.getSetMeasurePolicy());
        Updater.set-impl(r1, r110, r112.getSetResolvedCompositionLocals());
        Function2 r21 = r112.getSetCompositeKeyHash();
        if (r1.getInserting() == false) goto L47;
    L48:
        r1.updateRememberedValue(Integer.valueOf(r15));
        r1.apply(Integer.valueOf(r15), r21);
    L49:
        Updater.set-impl(r1, r111, r112.getSetModifier());
        BoxScopeInstance r2 = BoxScopeInstance.INSTANCE;
        boolean r3 = r13.changed(r4);
        Object r22 = r13.rememberedValue();
        if (r3 == false) goto L52;
    L53:
        r22 = new g0(r4);
        r13.updateRememberedValue(r22);
    L54:
        Modifier r23 = LayoutModifierKt.layout(r10, (Function3) r22);
        boolean r24 = r13.changed(r4) | r13.changed(r9);
        Object r25 = r13.rememberedValue();
        if (r24 == false) goto L57;
    L58:
        r25 = new h0(r9, r4);
        r13.updateRememberedValue(r25);
    L59:
        Modifier r26 = GraphicsLayerModifierKt.graphicsLayer(r23, (Function1) r25);
        MeasurePolicy r27 = BoxKt.maybeCachedBoxMeasurePolicy(r11.getTopStart(), false);
        int r114 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r28 = r13.getCurrentCompositionLocalMap();
        Modifier r29 = ComposedModifierKt.materializeModifier(r13, r26);
        Function0 r115 = r112.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L62;
        ComposablesKt.invalidApplier();
    L62:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L65;
        r13.createNode(r115);
    L66:
        Composer r116 = Updater.constructor-impl(r13);
        Updater.set-impl(r116, r27, r112.getSetMeasurePolicy());
        Updater.set-impl(r116, r28, r112.getSetResolvedCompositionLocals());
        Function2 r30 = r112.getSetCompositeKeyHash();
        if (r116.getInserting() == false) goto L69;
    L70:
        r116.updateRememberedValue(Integer.valueOf(r114));
        r116.apply(Integer.valueOf(r114), r30);
    L71:
        Updater.set-impl(r116, r29, r112.getSetModifier());
        r17.invoke(r13, Integer.valueOf((r14 >> 3) & 14));
        r13.endNode();
        boolean r31 = r13.changed(r4);
        Object r32 = r13.rememberedValue();
        if (r31 == false) goto L74;
    L75:
        r32 = new i0(r4);
        r13.updateRememberedValue(r32);
    L76:
        Modifier r33 = LayoutModifierKt.layout(r10, (Function3) r32);
        boolean r34 = r13.changed(r4) | r13.changed(r9);
        Object r35 = r13.rememberedValue();
        if (r34 == false) goto L79;
    L80:
        r35 = new j0(r9, r4);
        r13.updateRememberedValue(r35);
    L81:
        Modifier r36 = GraphicsLayerModifierKt.graphicsLayer(r33, (Function1) r35);
        MeasurePolicy r37 = BoxKt.maybeCachedBoxMeasurePolicy(r11.getTopStart(), false);
        int r38 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r39 = r13.getCurrentCompositionLocalMap();
        Modifier r40 = ComposedModifierKt.materializeModifier(r13, r36);
        Function0 r41 = r112.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L84;
        ComposablesKt.invalidApplier();
    L84:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L87;
        r13.createNode(r41);
    L88:
        Composer r42 = Updater.constructor-impl(r13);
        Updater.set-impl(r42, r37, r112.getSetMeasurePolicy());
        Updater.set-impl(r42, r39, r112.getSetResolvedCompositionLocals());
        Function2 r43 = r112.getSetCompositeKeyHash();
        if (r42.getInserting() == false) goto L91;
    L92:
        r42.updateRememberedValue(Integer.valueOf(r38));
        r42.apply(Integer.valueOf(r38), r43);
    L93:
        Updater.set-impl(r42, r40, r112.getSetModifier());
        r18.invoke(r13, Integer.valueOf((r14 >> 6) & 14));
        r13.endNode();
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
        goto L97
    L91:
        if (Intrinsics.areEqual(r42.rememberedValue(), Integer.valueOf(r38)) == true) goto L93;
    L87:
        r13.useNode();
        goto L88
    L79:
        if (r35 != Composer.Companion.getEmpty()) goto L81;
    L74:
        if (r32 != Composer.Companion.getEmpty()) goto L76;
    L69:
        if (Intrinsics.areEqual(r116.rememberedValue(), Integer.valueOf(r114)) == true) goto L71;
    L65:
        r13.useNode();
        goto L66
    L57:
        if (r25 != Composer.Companion.getEmpty()) goto L59;
    L52:
        if (r22 != Composer.Companion.getEmpty()) goto L54;
    L47:
        if (Intrinsics.areEqual(r1.rememberedValue(), Integer.valueOf(r15)) == true) goto L49;
    L43:
        r13.useNode();
        goto L44
    L36:
        r8 = 2.0f;
        goto L37
    L27:
        r7 = false;
        goto L29
    L20:
        if (r13.changedInstance(r18) == false) goto L22;
        int r44 = 256;
    L23:
        r5 = r5 | r44;
        goto L24
    L22:
        r44 = 128;
        goto L23
    L5:
        if (r13.changed(r16.ordinal()) == false) goto L7;
        int r45 = 4;
    L8:
        r5 = r45 | r20;
        goto L11
    L7:
        r45 = 2;
        goto L8
    }

    public static final BackdropScaffoldState BackdropScaffoldState(BackdropValue r1, Density r2, AnimationSpec<Float> r3, Function1<? super BackdropValue, Boolean> r4, SnackbarHostState r5) {
        BackdropScaffoldState r0 = new BackdropScaffoldState(r1, r3, r4, r5);
        r0.setDensity$material(r2);
        return r0;
    }

    private static final MeasureResult BackdropStack$lambda$40$lambda$39(Function2 r9, Function1 r10, final Function4 r11, SubcomposeMeasureScope r12, final Constraints r13) {
        final Placeable r14 = ((Measurable) CollectionsKt.first(r12.subcompose(BackdropLayers.Back, r9))).measure-BRTryo0(((Constraints) r10.invoke(r13)).unbox-impl());
        final float r15 = r14.getHeight();
        List r16 = r12.subcompose(BackdropLayers.Front, ComposableLambdaKt.composableLambdaInstance(-344317043, true, new BackdropScaffoldKt$BackdropStack$1$1$placeables$1(r11, r13, r15)));
        final ArrayList r17 = new ArrayList(r16.size());
        int r0 = r16.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r17.add(((Measurable) ListProtector.get(r16, r2)).measure-BRTryo0(r13.unbox-impl()));
        r2 = r2 + 1;
        goto L3
    L5:
        int r18 = Math.max(Constraints.getMinWidth-impl(r13.unbox-impl()), r14.getWidth());
        int r19 = Math.max(Constraints.getMinHeight-impl(r13.unbox-impl()), r14.getHeight());
        int r3 = r17.size();
        int r4 = r18;
        int r5 = r19;
    L6:
        if (r1 >= r3) goto L9;
        Placeable r110 = (Placeable) ListProtector.get(r17, r1);
        r4 = Math.max(r4, r110.getWidth());
        r5 = Math.max(r5, r110.getHeight());
        r1 = r1 + 1;
        goto L6
    L9:
        return MeasureScope.-CC.layout$default(r12, r4, r5, null, new v0(r14, r17), 4, null);
    }

    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    private static final void m1935Scrim3JVO9M(final long r22, final Function0<Unit> r24, final boolean r25, Composer r26, final int r27) {
        Composer r14 = r26.startRestartGroup(-92141505);
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
    L70:
        ScopeUpdateScope r9 = r14.endRestartGroup();
        if (r9 == null) goto L74;
        r9.updateScope(new r0(r22, r24, r25, r27));
        return;
    L74:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-92141505, r12, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:493)");
    L34:
        if (r22 == 16) goto L36;
        boolean r0 = true;
    L37:
        if (r0 == false) goto L65;
        r14.startReplaceGroup(-503346240);
        if (r25 == false) goto L41;
        float r10 = 1.0f;
    L42:
        final State<Float> r11 = AnimateAsStateKt.animateFloatAsState(r10, new TweenSpec(0, 0, null, 7, null), androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, null, r14, 48, 28);
        if (r25 == false) goto L54;
        r14.startReplaceGroup(-503180638);
        Modifier.Companion r13 = Modifier.Companion;
        Unit r15 = Unit.INSTANCE;
        if ((r12 & 112) != 32) goto L47;
        boolean r16 = true;
    L48:
        Object r1 = r14.rememberedValue();
        if (r16 == false) goto L51;
    L52:
        r1 = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(r24);
        r14.updateRememberedValue(r1);
    L53:
        Modifier r2 = SuspendingPointerInputFilterKt.pointerInput(r13, r15, (PointerInputEventHandler) r1);
        r14.endReplaceGroup();
    L55:
        Modifier r3 = SizeKt.fillMaxSize$default(Modifier.Companion, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null).then(r2);
        if ((r12 & 14) != 4) goto L58;
        boolean r17 = true;
    L59:
        boolean r18 = r14.changed(r11) | r17;
        Object r19 = r14.rememberedValue();
        if (r18 == false) goto L62;
    L63:
        r19 = new q0(r22, r11);
        r14.updateRememberedValue(r19);
    L64:
        CanvasKt.Canvas(r3, (Function1) r19, r14, 0);
        r14.endReplaceGroup();
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventEnd();
        goto L70
    L62:
        if (r19 != Composer.Companion.getEmpty()) goto L64;
    L58:
        r17 = false;
        goto L59
    L51:
        if (r1 != Composer.Companion.getEmpty()) goto L53;
    L47:
        r16 = false;
        goto L48
    L54:
        r14.startReplaceGroup(-503080229);
        r14.endReplaceGroup();
        r2 = Modifier.Companion;
        goto L55
    L41:
        r10 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L42
    L65:
        r14.startReplaceGroup(-502912829);
        r14.endReplaceGroup();
        goto L67
    L36:
        r0 = false;
        goto L37
    L27:
        r8 = false;
        goto L29
    L20:
        if (r14.changed(r25) == false) goto L22;
        int r20 = 256;
    L23:
        r6 = r6 | r20;
        goto L24
    L22:
        r20 = 128;
        goto L23
    L5:
        if (r14.changed(r22) == false) goto L7;
        int r21 = 4;
    L8:
        r6 = r21 | r27;
        goto L11
    L7:
        r21 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$BackLayerTransition(BackdropValue r0, Function2 r1, Function2 r2, Composer r3, int r4) {
        BackLayerTransition(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: access$Scrim-3J-VO9M, reason: not valid java name */
    public static final /* synthetic */ void m1936access$Scrim3JVO9M(long r0, Function0 r2, boolean r3, Composer r4, int r5) {
        m1935Scrim3JVO9M(r0, r2, r3, r4, r5);
    }

    private static final BackdropScaffoldState rememberBackdropScaffoldState$lambda$6$lambda$5(BackdropValue r0, Density r1, AnimationSpec r2, Function1 r3, SnackbarHostState r4) {
        return BackdropScaffoldState(r0, r1, r2, r3, r4);
    }

    private static final void BackdropStack(final Modifier r9, final Function2<? super Composer, ? super Integer, Unit> r10, final Function1<? super Constraints, Constraints> r11, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> r12, Composer r13, final int r14) {
        Composer r15 = r13.startRestartGroup(1490100844);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r14 & 48) != 0) goto L18;
        if (r15.changedInstance(r10) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r14 & 384) != 0) goto L25;
        if (r15.changedInstance(r11) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r14 & 3072) == 0) goto L27;
    L31:
        boolean r7 = true;
        if ((r1 & 1171) == 1170) goto L34;
        boolean r4 = true;
    L36:
        if (r15.shouldExecute(r4, r1 & 1) == true) goto L38;
        r15.skipToGroupEnd();
    L61:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L65;
        r16.updateScope(new m0(r9, r10, r11, r12, r14));
        return;
    L65:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventStart(1490100844, r1, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:572)");
    L41:
        if ((r1 & 112) != 32) goto L43;
        boolean r0 = true;
    L45:
        if ((r1 & 896) != 256) goto L47;
        boolean r5 = true;
    L48:
        boolean r6 = r0 | r5;
        if ((r1 & 7168) == 2048) goto L52;
        r7 = false;
    L52:
        boolean r8 = r6 | r7;
        Object r17 = r15.rememberedValue();
        if (r8 == false) goto L55;
    L56:
        r17 = new l0(r10, r11, r12);
        r15.updateRememberedValue(r17);
    L57:
        SubcomposeLayoutKt.SubcomposeLayout(r9, (Function2) r17, r15, r1 & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
        goto L61
    L55:
        if (r17 != Composer.Companion.getEmpty()) goto L57;
    L47:
        r5 = false;
        goto L48
    L43:
        r0 = false;
        goto L45
    L34:
        r4 = false;
        goto L36
    L27:
        if (r15.changedInstance(r12) == false) goto L29;
        int r18 = 2048;
    L30:
        r1 = r1 | r18;
        goto L31
    L29:
        r18 = 1024;
        goto L30
    L5:
        if (r15.changed(r9) == false) goto L7;
        int r19 = 4;
    L8:
        r1 = r19 | r14;
        goto L11
    L7:
        r19 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$BackdropStack(Modifier r0, Function2 r1, Function1 r2, Function4 r3, Composer r4, int r5) {
        BackdropStack(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ BackdropScaffoldState BackdropScaffoldState$default(BackdropValue r0, Density r1, AnimationSpec r2, Function1 r3, SnackbarHostState r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r2 = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
    L6:
        if ((r5 & 8) == 0) goto L9;
        r3 = new u0();
    L9:
        if ((r5 & 16) == 0) goto L12;
        r4 = new SnackbarHostState();
    L12:
        return BackdropScaffoldState(r0, r1, r2, r3, r4);
    }

    public static final BackdropScaffoldState rememberBackdropScaffoldState(final BackdropValue r7, AnimationSpec<Float> r8, Function1<? super BackdropValue, Boolean> r9, SnackbarHostState r10, Composer r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        r8 = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
    L5:
        final AnimationSpec<Float> r3 = r8;
        if ((r13 & 4) == 0) goto L11;
        Object r14 = r11.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L10;
        r14 = new s0();
        r11.updateRememberedValue(r14);
    L10:
        r9 = (Function1) r14;
    L11:
        final Function1<? super BackdropValue, Boolean> r4 = r9;
        if ((r13 & 8) == 0) goto L17;
        Object r15 = r11.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L16;
        r15 = new SnackbarHostState();
        r11.updateRememberedValue(r15);
    L16:
        r10 = (SnackbarHostState) r15;
    L17:
        final SnackbarHostState r5 = r10;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventStart(-862178912, r12, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:257)");
    L20:
        final Density r2 = (Density) r11.consume(CompositionLocalsKt.getLocalDensity());
        boolean r16 = true;
        Object[] r17 = {r3, r4, r5};
        Saver<BackdropScaffoldState, ?> r18 = BackdropScaffoldState.Companion.Saver(r3, r4, r5, r2);
        if (((r12 & 14) ^ 6) <= 4) goto L25;
        if (r11.changed(r7.ordinal()) == false) goto L25;
    L26:
        boolean r0 = true;
    L28:
        boolean r1 = (r0 | r11.changed(r2)) | r11.changedInstance(r3);
        if (((r12 & 896) ^ 384) <= 256) goto L33;
        if (r11.changed(r4) == false) goto L33;
    L34:
        boolean r6 = true;
    L36:
        boolean r19 = r1 | r6;
        if (((r12 & 7168) ^ 3072) <= 2048) goto L41;
        if (r11.changed(r5) == false) goto L41;
    L44:
        boolean r110 = r16 | r19;
        Object r111 = r11.rememberedValue();
        if (r110 == false) goto L47;
    L48:
        r111 = new t0(r7, r2, r3, r4, r5);
        r11.updateRememberedValue(r111);
    L49:
        BackdropScaffoldState r20 = (BackdropScaffoldState) RememberSaveableKt.rememberSaveable(r17, r18, (Function0) r111, r11, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L52;
        ComposerKt.traceEventEnd();
    L52:
        return r20;
    L47:
        if (r111 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r12 & 3072) == 2048) goto L44;
        r16 = false;
    L33:
        if ((r12 & 384) == 256) goto L34;
        r6 = false;
    L25:
        if ((r12 & 6) == 4) goto L26;
        r0 = false;
        goto L28
    }

    /* JADX INFO: renamed from: BackdropScaffold-0hNv9B8, reason: not valid java name */
    public static final void m1934BackdropScaffold0hNv9B8(final Function2<? super Composer, ? super Integer, Unit> r51, final Function2<? super Composer, ? super Integer, Unit> r52, final Function2<? super Composer, ? super Integer, Unit> r53, Modifier r54, BackdropScaffoldState r55, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r56, boolean r57, float r58, float r59, boolean r60, boolean r61, long r62, long r64, Shape r66, float r67, long r68, long r70, long r72, Composer r74, final int r75, final int r76, final int r77) {
        Composer r0 = r74.startRestartGroup(-1364899063);
        if ((r77 & 1) == 0) goto L6;
        int r3 = r75 | 6;
    L14:
        if ((r77 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r77 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L33:
        int r6 = r77 & 8;
        if (r6 == 0) goto L37;
        r3 = r3 | 3072;
    L44:
        int r18 = 8192;
        if ((r75 & 24576) == 0) goto L47;
        final BackdropScaffoldState r5 = r55;
    L55:
        int r20 = r77 & 32;
        if (r20 == 0) goto L58;
        r3 = r3 | 196608;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r13 = r56;
    L65:
        int r24 = r77 & 64;
        if (r24 == 0) goto L69;
        r3 = r3 | 1572864;
    L76:
        if ((r75 & 12582912) == 0) goto L78;
        float r7 = r58;
    L87:
        if ((r75 & 100663296) == 0) goto L89;
        float r8 = r59;
    L97:
        int r9 = r77 & 512;
        if (r9 == 0) goto L101;
        int r30 = r3 | 805306368;
        r9 = r9;
    L109:
        int r4 = r77 & 1024;
        if (r4 == 0) goto L113;
        int r17 = r76 | 6;
    L121:
        if ((r76 & 48) != 0) goto L131;
        if ((r77 & 2048) == 0) goto L125;
    L127:
        int r26 = 16;
    L128:
        r17 = r17 | r26;
        goto L131
    L125:
        if (r0.changed(r62) == false) goto L127;
        r26 = 32;
    L131:
        if ((r76 & 384) != 0) goto L141;
        if ((r77 & 4096) == 0) goto L135;
    L137:
        int r28 = 128;
    L138:
        r17 = r17 | r28;
        goto L141
    L135:
        if (r0.changed(r64) == false) goto L137;
        r28 = 256;
    L141:
        if ((r76 & 3072) != 0) goto L152;
        if ((r77 & 8192) != 0) goto L148;
        if (r0.changed(r66) == false) goto L148;
        int r23 = 2048;
    L149:
        r17 = r17 | r23;
    L148:
        r23 = 1024;
    L152:
        if ((r76 & 24576) != 0) goto L162;
        if ((r77 & 16384) != 0) goto L159;
        if (r0.changed(r67) == false) goto L159;
        r18 = 16384;
    L159:
        r17 = r17 | r18;
    L162:
        if ((r76 & 196608) != 0) goto L172;
        if ((r77 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L166;
    L168:
        int r16 = 65536;
    L169:
        r17 = r17 | r16;
        goto L172
    L166:
        if (r0.changed(r68) == false) goto L168;
        r16 = 131072;
    L172:
        if ((r76 & 1572864) != 0) goto L182;
        if ((r77 & 65536) == 0) goto L176;
    L178:
        int r19 = 524288;
    L179:
        r17 = r17 | r19;
        goto L182
    L176:
        if (r0.changed(r70) == false) goto L178;
        r19 = 1048576;
    L182:
        if ((r76 & 12582912) != 0) goto L192;
        if ((r77 & 131072) == 0) goto L186;
    L188:
        int r110 = 4194304;
    L189:
        r17 = r17 | r110;
        goto L192
    L186:
        if (r0.changed(r72) == false) goto L188;
        r110 = 8388608;
    L192:
        if ((r30 & 306783379) == 306783378) goto L194;
    L197:
        boolean r10 = true;
    L199:
        if (r0.shouldExecute(r10, r30 & 1) == false) goto L317;
        r0.startDefaults();
        if ((r75 & 1) != 0) goto L203;
    L236:
        if (r6 == 0) goto L238;
        Modifier r111 = Modifier.Companion;
    L240:
        if ((r77 & 16) == 0) goto L243;
        r30 = r30 & (-57345);
        r5 = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, r0, 6, 14);
    L243:
        if (r20 == 0) goto L245;
        r13 = ComposableSingletons$BackdropScaffoldKt.INSTANCE.getLambda$2057676608$material();
    L245:
        if (r24 == 0) goto L247;
        boolean r11 = true;
    L249:
        if ((r77 & 128) == 0) goto L251;
        float r12 = BackdropScaffoldDefaults.INSTANCE.m1933getPeekHeightD9Ej5fM();
        r30 = r30 & (-29360129);
    L253:
        if ((r77 & 256) == 0) goto L255;
        float r14 = BackdropScaffoldDefaults.INSTANCE.m1932getHeaderHeightD9Ej5fM();
        r30 = r30 & (-234881025);
    L256:
        if (r9 == 0) goto L258;
        boolean r15 = true;
    L259:
        if (r4 == 0) goto L261;
        boolean r21 = true;
    L263:
        if ((r77 & 2048) == 0) goto L265;
        long r25 = MaterialTheme.INSTANCE.getColors(r0, 6).m1999getPrimary0d7_KjU();
        int r22 = r17 & (-113);
        long r112 = r25;
    L266:
        boolean r510 = r11;
        if ((r77 & 4096) == 0) goto L269;
        long r27 = ColorsKt.m2017contentColorForek8zF_U(r112, r0, (r22 >> 3) & 14);
        r22 = r22 & (-897);
    L271:
        if ((r77 & 8192) == 0) goto L273;
        Shape r29 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(r0, 0);
        r22 = r22 & (-7169);
    L275:
        if ((r77 & 16384) == 0) goto L277;
        float r31 = BackdropScaffoldDefaults.INSTANCE.m1931getFrontLayerElevationD9Ej5fM();
        r22 = r22 & (-57345);
    L278:
        Shape r511 = r29;
        if ((r77 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L281;
        long r32 = MaterialTheme.INSTANCE.getColors(r0, 6).m2003getSurface0d7_KjU();
        r22 = r22 & (-458753);
    L283:
        if ((r77 & 65536) == 0) goto L285;
        long r113 = ColorsKt.m2017contentColorForek8zF_U(r32, r0, (r22 >> 15) & 14);
        int r33 = (-3670017) & r22;
    L287:
        if ((r77 & 131072) == 0) goto L289;
        long r210 = r32;
        int r114 = r33 & (-29360129);
        long r43 = r210;
        long r47 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(r0, 0);
    L290:
        final boolean r34 = r15;
        r7 = r12;
    L291:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L295;
        ComposerKt.traceEventStart(-1364899063, r30, r114, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:363)");
    L295:
        final Density r115 = (Density) r0.consume(CompositionLocalsKt.getLocalDensity());
        if (((57344 & r30) ^ 24576) <= 16384) goto L300;
        if (r0.changed(r5) == false) goto L300;
    L301:
        boolean r116 = true;
    L303:
        boolean r117 = r116 | r0.changed(r115);
        Object r118 = r0.rememberedValue();
        if (r117 == false) goto L306;
    L307:
        r118 = new e0(r5, r115);
        r0.updateRememberedValue(r118);
    L308:
        EffectsKt.SideEffect((Function0) r118, r0, 0);
        final float r35 = ((Density) r0.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(r7);
        final float r119 = ((Density) r0.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(r14);
        final ComposableLambda r120 = ComposableLambdaKt.rememberComposableLambda(998762775, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(r34, r5, r51, r52), r0, 54);
        boolean r1 = r0.changed(r119);
        Object r121 = r0.rememberedValue();
        if (r1 == false) goto L311;
    L312:
        r121 = new n0(r119);
        r0.updateRememberedValue(r121);
    L313:
        final Function1 r122 = (Function1) r121;
        final AnchoredDraggableState<BackdropValue> r211 = r5.getAnchoredDraggableState$material();
        final Modifier r123 = r111;
        final boolean r212 = r21;
        final boolean r213 = r510;
        final BackdropScaffoldState r214 = r5;
        final Shape r215 = r511;
        final long r216 = r43;
        final long r217 = r113;
        final float r36 = r31;
        final float r37 = r14;
        final float r38 = r7;
        final long r39 = r47;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r310 = r13;
        int r124 = r114 << 3;
        int r125 = (r124 & 896) | 1572864;
        long r512 = r112;
        long r513 = r27;
        SurfaceKt.m2175SurfaceFjzlyU(null, null, r512, r513, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, ComposableLambdaKt.rememberComposableLambda(-1243386547, true, new BackdropScaffoldKt$BackdropScaffold$2(r123, r120, r122, r119, r212, r213, r214, r211, r215, r216, r217, r36, r37, r35, r38, r53, r39, r310), r0, 54), r0, (r124 & 7168) | r125, 51);
        if (ComposerKt.isTraceInProgress() == false) goto L316;
        ComposerKt.traceEventEnd();
    L316:
        final boolean r126 = r34;
        final boolean r127 = r21;
        final long r128 = r27;
        final Shape r129 = r511;
        final float r130 = r31;
        final long r131 = r43;
        final long r218 = r113;
        final long r219 = r47;
        final float r40 = r14;
        final float r41 = r7;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r42 = r13;
        final long r132 = r112;
        final boolean r44 = r510;
        final Modifier r45 = r111;
    L318:
        ScopeUpdateScope r46 = r0.endRestartGroup();
        if (r46 == null) goto L322;
        r46.updateScope(new o0(r51, r52, r53, r45, r5, r42, r44, r41, r40, r126, r127, r132, r128, r129, r130, r131, r218, r219, r75, r76, r77));
        return;
    L322:
        return;
    L311:
        if (r121 != Composer.Companion.getEmpty()) goto L313;
    L306:
        if (r118 != Composer.Companion.getEmpty()) goto L308;
    L300:
        if ((r30 & 24576) == 16384) goto L301;
        r116 = false;
        goto L303
    L289:
        r47 = r72;
        r114 = r33;
        r43 = r32;
        goto L290
    L285:
        r113 = r70;
        r33 = r22;
        goto L287
    L281:
        r32 = r68;
        goto L283
    L277:
        r31 = r67;
        goto L278
    L273:
        r29 = r66;
        goto L275
    L269:
        r27 = r64;
        goto L271
    L265:
        r112 = r62;
        r22 = r17;
        goto L266
    L261:
        r21 = r61;
        goto L263
    L258:
        r15 = r60;
        goto L259
    L255:
        r14 = r59;
        goto L256
    L251:
        r12 = r58;
        goto L253
    L247:
        r11 = r57;
        goto L249
    L238:
        r111 = r54;
        goto L240
    L203:
        if (r0.getDefaultsInvalid() == true) goto L236;
        r0.skipToGroupEnd();
        if ((r77 & 16) == 0) goto L209;
        r30 = r30 & (-57345);
    L209:
        if ((r77 & 128) == 0) goto L212;
        r30 = r30 & (-29360129);
    L212:
        if ((r77 & 256) == 0) goto L215;
        r30 = r30 & (-234881025);
    L215:
        if ((r77 & 2048) == 0) goto L217;
        r17 = r17 & (-113);
    L217:
        int r48 = r17;
        if ((r77 & 4096) == 0) goto L221;
        r48 = r48 & (-897);
    L221:
        if ((r77 & 8192) == 0) goto L224;
        r48 = r48 & (-7169);
    L224:
        if ((r77 & 16384) == 0) goto L227;
        r48 = r48 & (-57345);
    L227:
        if ((32768 & r77) == 0) goto L230;
        r48 = r48 & (-458753);
    L230:
        if ((r77 & 65536) == 0) goto L233;
        r48 = r48 & (-3670017);
    L233:
        if ((r77 & 131072) == 0) goto L235;
        r48 = r48 & (-29360129);
    L235:
        r510 = r57;
        r21 = r61;
        r112 = r62;
        r27 = r64;
        r511 = r66;
        r31 = r67;
        r43 = r68;
        r113 = r70;
        r47 = r72;
        r114 = r48;
        r14 = r8;
        r30 = r30;
        r111 = r54;
        r34 = r60;
        goto L291
    L317:
        r0.skipToGroupEnd();
        r45 = r54;
        r44 = r57;
        r41 = r58;
        r40 = r59;
        r126 = r60;
        r127 = r61;
        r128 = r64;
        r129 = r66;
        r130 = r67;
        r131 = r68;
        r218 = r70;
        r219 = r72;
        r42 = r13;
        r132 = r62;
        goto L318
    L194:
        if ((r17 & 4793491) != 4793490) goto L197;
        r10 = false;
        goto L199
    L113:
        if ((r76 & 6) == 0) goto L115;
        r17 = r76;
        goto L121
    L115:
        if (r0.changed(r61) == false) goto L117;
        int r133 = 4;
    L118:
        r17 = r76 | r133;
        goto L121
    L117:
        r133 = 2;
        goto L118
    L101:
        if ((r75 & 805306368) != 0) goto L108;
        if (r0.changed(r60) == false) goto L105;
        int r311 = 536870912;
    L106:
        r3 = r3 | r311;
        goto L108
    L105:
        r311 = 268435456;
    L108:
        r30 = r3;
        goto L109
    L89:
        if ((r77 & 256) != 0) goto L93;
        r8 = r59;
        if (r0.changed(r8) == false) goto L94;
        int r220 = 67108864;
    L95:
        r3 = r3 | r220;
    L94:
        r220 = 33554432;
        goto L95
    L93:
        r8 = r59;
        goto L94
    L78:
        if ((r77 & 128) != 0) goto L82;
        r7 = r58;
        if (r0.changed(r7) == false) goto L83;
        int r221 = 8388608;
    L84:
        r3 = r3 | r221;
    L83:
        r221 = 4194304;
        goto L84
    L82:
        r7 = r58;
        goto L83
    L69:
        if ((r75 & 1572864) != 0) goto L76;
        if (r0.changed(r57) == false) goto L73;
        int r222 = 1048576;
    L74:
        r3 = r3 | r222;
        goto L76
    L73:
        r222 = 524288;
        goto L74
    L58:
        r13 = r56;
        if ((r75 & 196608) != 0) goto L65;
        if (r0.changedInstance(r13) == false) goto L63;
        int r223 = 131072;
    L64:
        r3 = r3 | r223;
        goto L65
    L63:
        r223 = 65536;
        goto L64
    L47:
        if ((r77 & 16) != 0) goto L51;
        r5 = r55;
        if (r0.changed(r5) == false) goto L52;
        int r224 = 16384;
    L53:
        r3 = r3 | r224;
    L52:
        r224 = 8192;
        goto L53
    L51:
        r5 = r55;
        goto L52
    L37:
        if ((r75 & 3072) != 0) goto L44;
        if (r0.changed(r54) == false) goto L41;
        int r134 = 2048;
    L42:
        r3 = r3 | r134;
        goto L44
    L41:
        r134 = 1024;
        goto L42
    L27:
        if ((r75 & 384) != 0) goto L33;
        if (r0.changedInstance(r53) == false) goto L31;
        int r49 = 256;
    L32:
        r3 = r3 | r49;
        goto L33
    L31:
        r49 = 128;
        goto L32
    L17:
        if ((r75 & 48) != 0) goto L24;
        if (r0.changedInstance(r52) == false) goto L21;
        int r50 = 32;
    L22:
        r3 = r3 | r50;
        goto L24
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r75 & 6) == 0) goto L8;
        r3 = r75;
        goto L14
    L8:
        if (r0.changedInstance(r51) == false) goto L10;
        int r63 = 4;
    L11:
        r3 = r63 | r75;
        goto L14
    L10:
        r63 = 2;
        goto L11
    }
}
