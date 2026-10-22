package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a]\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0016\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0017\u001a=\u0010\u0018\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0019\u001ai\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b%\u0010&\u001aq\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b'\u0010(\u001ai\u0010)\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b*\u0010&\u001aq\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b+\u0010(\u001ai\u0010,\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b-\u0010&\u001a{\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00101\u001a\u0002022\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0001¢\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a$\u00109\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010:\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010;\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u0014\u0010<\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a\u0014\u0010>\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a.\u0010?\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010@\u001a\u008e\u0001\u0010A\u001a\u00020\t2\u0011\u0010B\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\u0006\u0010C\u001a\u00020\u00062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0015\b\u0002\u0010E\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010G\u001a\u00020\u001c2\b\b\u0002\u0010H\u001a\u00020I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0002\u0010L\u001a \u0010M\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\u0006\u0010P\u001a\u000207H\u0002\u001a;\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u00062\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010T\u001a\b\u0012\u0004\u0012\u0002070\u000b2\u0006\u0010U\u001a\u00020\u0012H\u0003¢\u0006\u0004\bV\u0010W\"\u000e\u0010X\u001a\u000207X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010[\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0016\u0010\\\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b]\u0010^\"\u0016\u0010_\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b`\u0010^\"\u0016\u0010a\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bb\u0010^\"\u0014\u0010c\u001a\b\u0012\u0004\u0012\u0002070dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u000207X\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"rememberDrawerState", "Landroidx/compose/material3/DrawerState;", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "ModalNavigationDrawer", "", "drawerContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "content", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "drawerContentColor", "drawerTonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet-Snr_uVM", "(Landroidx/compose/material3/DrawerState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleDrawerSheet", "DismissibleDrawerSheet-afqeVBk", "DismissibleDrawerSheet-Snr_uVM", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "DrawerSheet", "drawerPredictiveBackState", "Landroidx/compose/material3/DrawerPredictiveBackState;", "drawerOffset", "Landroidx/compose/material3/internal/FloatProducer;", "DrawerSheet-cm3T3N0", "(Landroidx/compose/material3/DrawerPredictiveBackState;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "horizontalScaleUp", "drawerWidth", "", "isRtl", "horizontalScaleDown", "predictiveBackDrawerContainer", "predictiveBackDrawerChild", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "calculatePredictiveBackScaleY", "DrawerPredictiveBackHandler", "(Landroidx/compose/material3/DrawerState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", "a", "b", "pos", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "F", "MinimumDrawerWidth", "PredictiveBackDrawerMaxScaleXDistanceGrow", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "AnchoredDraggableDefaultAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "material3", "anchorsInitialized", "minValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerKt {
    private static final TweenSpec<Float> AnchoredDraggableDefaultAnimationSpec = null;
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold = 0.0f;
    private static final float MinimumDrawerWidth = 0.0f;
    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow = 0.0f;
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink = 0.0f;
    private static final float PredictiveBackDrawerMaxScaleYDistance = 0.0f;

    public static /* synthetic */ Unit A(boolean r0, Function0 r1, Function0 r2, long r3, int r5, Composer r6, int r7) {
        return Scrim_Bx497Mc$lambda$72(r0, r1, r2, r3, r5, r6, r7);
    }

    public static /* synthetic */ Unit B(DrawerPredictiveBackState r0, boolean r1, GraphicsLayerScope r2) {
        return predictiveBackDrawerChild$lambda$57(r0, r1, r2);
    }

    public static /* synthetic */ Unit C(DrawerPredictiveBackState r0, WindowInsets r1, Modifier r2, Shape r3, long r4, long r6, float r8, FloatProducer r9, Function3 r10, int r11, int r12, Composer r13, int r14) {
        return DrawerSheet_cm3T3N0$lambda$53(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit D(boolean r0, DrawerState r1, CoroutineScope r2) {
        return ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(r0, r1, r2);
    }

    private static final Unit DismissibleDrawerSheet_Snr_uVM$lambda$46(DrawerState r14, Modifier r15, Shape r16, long r17, long r19, float r21, WindowInsets r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m2903DismissibleDrawerSheetSnr_uVM(r14, r15, r16, r17, r19, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit DismissibleDrawerSheet_afqeVBk$lambda$45(Modifier r13, Shape r14, long r15, long r17, float r19, WindowInsets r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m2904DismissibleDrawerSheetafqeVBk(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit DismissibleNavigationDrawer$lambda$39(Function2 r9, Modifier r10, DrawerState r11, boolean r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        DismissibleNavigationDrawer(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit DrawerPredictiveBackHandler$lambda$62(DrawerState r0, Function3 r1, int r2, Composer r3, int r4) {
        DrawerPredictiveBackHandler(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final float DrawerSheet_cm3T3N0$lambda$51$lambda$50() {
        return MenuKt.ClosedAlphaTarget;
    }

    private static final Unit DrawerSheet_cm3T3N0$lambda$53(DrawerPredictiveBackState r15, WindowInsets r16, Modifier r17, Shape r18, long r19, long r21, float r23, FloatProducer r24, Function3 r25, int r26, int r27, Composer r28, int r29) {
        m2905DrawerSheetcm3T3N0(r15, r16, r17, r18, r19, r21, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ IntOffset E(DrawerState r0, Density r1) {
        return ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(r0, r1);
    }

    public static /* synthetic */ Unit F(String r0, Function0 r1, SemanticsPropertyReceiver r2) {
        return Scrim_Bx497Mc$lambda$69$lambda$68(r0, r1, r2);
    }

    public static /* synthetic */ Unit G(DrawerPredictiveBackState r0, boolean r1, GraphicsLayerScope r2) {
        return predictiveBackDrawerContainer$lambda$56(r0, r1, r2);
    }

    private static final Unit ModalDrawerSheet_Snr_uVM$lambda$44(DrawerState r14, Modifier r15, Shape r16, long r17, long r19, float r21, WindowInsets r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m2906ModalDrawerSheetSnr_uVM(r14, r15, r16, r17, r19, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit ModalDrawerSheet_afqeVBk$lambda$43(Modifier r13, Shape r14, long r15, long r17, float r19, WindowInsets r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m2907ModalDrawerSheetafqeVBk(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit ModalNavigationDrawer_FHprtrg$lambda$25(Function2 r11, Modifier r12, DrawerState r13, boolean r14, long r15, Function2 r17, int r18, int r19, Composer r20, int r21) {
        m2908ModalNavigationDrawerFHprtrg(r11, r12, r13, r14, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit NavigationDrawerItem$lambda$65(Function2 r13, boolean r14, Function0 r15, Modifier r16, Function2 r17, Function2 r18, Shape r19, NavigationDrawerItemColors r20, MutableInteractionSource r21, int r22, int r23, Composer r24, int r25) {
        NavigationDrawerItem(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit PermanentDrawerSheet_afqeVBk$lambda$49(Modifier r13, Shape r14, long r15, long r17, float r19, WindowInsets r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m2909PermanentDrawerSheetafqeVBk(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit PermanentNavigationDrawer$lambda$42(Function2 r6, Modifier r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        PermanentNavigationDrawer(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_Bx497Mc$lambda$72(boolean r7, Function0 r8, Function0 r9, long r10, int r12, Composer r13, int r14) {
        m2910ScrimBx497Mc(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Modifier r1, Function2 r2, int r3, int r4, Composer r5, int r6) {
        return PermanentNavigationDrawer$lambda$42(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit b(SemanticsPropertyReceiver r0) {
        return NavigationDrawerItem$lambda$64$lambda$63(r0);
    }

    public static /* synthetic */ Unit c(FloatProducer r0, float r1, boolean r2, GraphicsLayerScope r3) {
        return horizontalScaleUp$lambda$54(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit d(DrawerState r0, Function3 r1, int r2, Composer r3, int r4) {
        return DrawerPredictiveBackHandler$lambda$62(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit e(Function2 r0, boolean r1, Function0 r2, Modifier r3, Function2 r4, Function2 r5, Shape r6, NavigationDrawerItemColors r7, MutableInteractionSource r8, int r9, int r10, Composer r11, int r12) {
        return NavigationDrawerItem$lambda$65(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit f(Function2 r0, Modifier r1, DrawerState r2, boolean r3, Function2 r4, int r5, int r6, Composer r7, int r8) {
        return DismissibleNavigationDrawer$lambda$39(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit g(String r0, DrawerState r1, CoroutineScope r2, SemanticsPropertyReceiver r3) {
        return ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit h(DrawerState r0, Density r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3) {
        return DismissibleNavigationDrawer$lambda$30$lambda$29(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit i(Modifier r0, Shape r1, long r2, long r4, float r6, WindowInsets r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return ModalDrawerSheet_afqeVBk$lambda$43(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ DrawerState j(DrawerValue r0, Function1 r1) {
        return rememberDrawerState$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit k(long r0, Function0 r2, DrawScope r3) {
        return Scrim_Bx497Mc$lambda$71$lambda$70(r0, r2, r3);
    }

    public static /* synthetic */ float l(DrawerState r1, MutableFloatState r2) {
        return ModalNavigationDrawer_FHprtrg$lambda$24$lambda$16$lambda$15(MenuKt.ClosedAlphaTarget, r1, r2);
    }

    public static /* synthetic */ float m() {
        return DrawerSheet_cm3T3N0$lambda$51$lambda$50();
    }

    public static /* synthetic */ Unit n(DrawerState r0, Modifier r1, Shape r2, long r3, long r5, float r7, WindowInsets r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return DismissibleDrawerSheet_Snr_uVM$lambda$46(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit o(String r0, DrawerState r1, CoroutineScope r2, SemanticsPropertyReceiver r3) {
        return DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit p(Modifier r0, Shape r1, long r2, long r4, float r6, WindowInsets r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return PermanentDrawerSheet_afqeVBk$lambda$49(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ boolean q(Function0 r0) {
        return Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(r0);
    }

    public static /* synthetic */ boolean r(DrawerState r0, CoroutineScope r1) {
        return DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(r0, r1);
    }

    private static final boolean rememberDrawerState$lambda$1$lambda$0(DrawerValue r0) {
        return true;
    }

    public static /* synthetic */ boolean s(DrawerState r0, CoroutineScope r1) {
        return ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(r0, r1);
    }

    public static /* synthetic */ Unit t(Function2 r0, Modifier r1, DrawerState r2, boolean r3, long r4, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return ModalNavigationDrawer_FHprtrg$lambda$25(r0, r1, r2, r3, r4, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit u(FloatProducer r0, float r1, boolean r2, GraphicsLayerScope r3) {
        return horizontalScaleDown$lambda$55(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean v(DrawerValue r0) {
        return rememberDrawerState$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ Unit w(DrawerState r0, Density r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3, FiniteAnimationSpec r4) {
        return ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit x(Modifier r0, Shape r1, long r2, long r4, float r6, WindowInsets r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return DismissibleDrawerSheet_afqeVBk$lambda$45(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit y(DrawerState r0, Modifier r1, Shape r2, long r3, long r5, float r7, WindowInsets r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return ModalDrawerSheet_Snr_uVM$lambda$44(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit z(String r0, SemanticsPropertyReceiver r1) {
        return PermanentDrawerSheet_afqeVBk$lambda$48$lambda$47(r0, r1);
    }

    static {
        DrawerVelocityThreshold = Dp.constructor-impl(400);
        MinimumDrawerWidth = Dp.constructor-impl(240);
        PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.constructor-impl(12);
        PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.constructor-impl(24);
        PredictiveBackDrawerMaxScaleYDistance = Dp.constructor-impl(48);
        AnchoredDraggableDefaultAnimationSpec = new TweenSpec(256, 0, null, 6, null);
    }

    public static final /* synthetic */ TweenSpec access$getAnchoredDraggableDefaultAnimationSpec$p() {
        return AnchoredDraggableDefaultAnimationSpec;
    }

    public static final /* synthetic */ float access$getDrawerPositionalThreshold$p() {
        return DrawerPositionalThreshold;
    }

    public static final /* synthetic */ float access$getDrawerVelocityThreshold$p() {
        return DrawerVelocityThreshold;
    }

    public static final /* synthetic */ float access$getMinimumDrawerWidth$p() {
        return MinimumDrawerWidth;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return PredictiveBackDrawerMaxScaleYDistance;
    }

    private static final boolean DismissibleNavigationDrawer$lambda$27(MutableState<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final boolean ModalNavigationDrawer_FHprtrg$lambda$5(MutableState<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final float ModalNavigationDrawer_FHprtrg$lambda$8(MutableFloatState r0) {
        return r0.getFloatValue();
    }

    private static final Unit NavigationDrawerItem$lambda$64$lambda$63(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getTab-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final boolean Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(Function0 r0) {
        r0.invoke();
        return true;
    }

    public static final /* synthetic */ boolean access$DismissibleNavigationDrawer$lambda$27(MutableState r0) {
        return DismissibleNavigationDrawer$lambda$27(r0);
    }

    public static final /* synthetic */ boolean access$ModalNavigationDrawer_FHprtrg$lambda$5(MutableState r0) {
        return ModalNavigationDrawer_FHprtrg$lambda$5(r0);
    }

    public static final /* synthetic */ float access$ModalNavigationDrawer_FHprtrg$lambda$8(MutableFloatState r0) {
        return ModalNavigationDrawer_FHprtrg$lambda$8(r0);
    }

    private static final void DismissibleNavigationDrawer$lambda$28(MutableState<Boolean> r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    private static final boolean DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(DrawerState r7, CoroutineScope r8) {
        if (((Boolean) r7.getConfirmStateChange$material3().invoke(DrawerValue.Closed)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final IntOffset ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(DrawerState r4, Density r5) {
        float r0 = r4.getCurrentOffset();
        if (Float.isNaN(r0) == true) goto L6;
        int r6 = MathKt.roundToInt(r0);
    L10:
        return IntOffset.box-impl(IntOffset.constructor-impl((((long) r6) << 32) | (((long) 0) & 4294967295L)));
    L6:
        if (r4.isOpen() == false) goto L8;
        r6 = 0;
        goto L10
    L8:
        r6 = -r5.roundToPx-0680j_4(DrawerDefaults.INSTANCE.m2643getMaximumDrawerWidthD9Ej5fM());
        goto L10
    }

    private static final boolean ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(DrawerState r7, CoroutineScope r8) {
        if (((Boolean) r7.getConfirmStateChange$material3().invoke(DrawerValue.Closed)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final void ModalNavigationDrawer_FHprtrg$lambda$6(MutableState<Boolean> r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    private static final void ModalNavigationDrawer_FHprtrg$lambda$9(MutableFloatState r0, float r1) {
        r0.setFloatValue(r1);
    }

    private static final Unit PermanentDrawerSheet_afqeVBk$lambda$48$lambda$47(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setPaneTitle(r1, r0);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$DismissibleNavigationDrawer$lambda$28(MutableState r0, boolean r1) {
        DismissibleNavigationDrawer$lambda$28(r0, r1);
    }

    public static final /* synthetic */ void access$ModalNavigationDrawer_FHprtrg$lambda$6(MutableState r0, boolean r1) {
        ModalNavigationDrawer_FHprtrg$lambda$6(r0, r1);
    }

    public static final /* synthetic */ void access$ModalNavigationDrawer_FHprtrg$lambda$9(MutableFloatState r0, float r1) {
        ModalNavigationDrawer_FHprtrg$lambda$9(r0, r1);
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope r3, DrawerPredictiveBackState r4) {
        float r5 = Float.intBitsToFloat((int) (r3.getSize-NH-jbRc() >> 32));
        if (Float.isNaN(r5) == true) goto L16;
        int r2 = 1;
        if (r5 != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return 1.0f;
    L11:
        if (r4.getSwipeEdgeMatchesDrawer() == true) goto L15;
        r2 = -1;
    L15:
        return 1.0f + ((r4.getScaleXDistance() * r2) / r5);
    L7:
        r0 = false;
        goto L8
    L16:
        return 1.0f;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope r4, DrawerPredictiveBackState r5) {
        float r6 = Float.intBitsToFloat((int) (r4.getSize-NH-jbRc() & 4294967295L));
        if (Float.isNaN(r6) == false) goto L5;
        return 1.0f;
    L5:
        if (r6 != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return 1.0f;
    L11:
        return 1.0f - (r5.getScaleYDistance() / r6);
    L7:
        r0 = false;
        goto L8
    }

    private static final DrawerState rememberDrawerState$lambda$3$lambda$2(DrawerValue r1, Function1 r2) {
        return new DrawerState(r1, r2);
    }

    private static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(boolean r6, DrawerState r7, CoroutineScope r8) {
        if (r6 == false) goto L7;
        if (((Boolean) r7.getConfirmStateChange$material3().invoke(DrawerValue.Closed)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1(r7, null), 3, null);
    L7:
        return Unit.INSTANCE;
    }

    private static final float ModalNavigationDrawer_FHprtrg$lambda$24$lambda$16$lambda$15(float r0, DrawerState r1, MutableFloatState r2) {
        return calculateFraction(ModalNavigationDrawer_FHprtrg$lambda$8(r2), r0, r1.requireOffset$material3());
    }

    private static final Unit Scrim_Bx497Mc$lambda$69$lambda$68(String r1, final Function0 r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r1);
        SemanticsPropertiesKt.onClick$default(r3, null, new ig(r2), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_Bx497Mc$lambda$71$lambda$70(long r13, Function0 r15, DrawScope r16) {
        DrawScope.-CC.drawRect-n-J9OG0$default(r16, r13, 0, 0, ((Number) r15.invoke()).floatValue(), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Modifier access$predictiveBackDrawerChild(Modifier r0, DrawerPredictiveBackState r1, boolean r2) {
        return predictiveBackDrawerChild(r0, r1, r2);
    }

    private static final float calculateFraction(float r0, float r1, float r2) {
        return RangesKt.coerceIn((r2 - r0) / (r1 - r0), MenuKt.ClosedAlphaTarget, 1.0f);
    }

    private static final Modifier predictiveBackDrawerChild(Modifier r1, final DrawerPredictiveBackState r2, final boolean r3) {
        return GraphicsLayerModifierKt.graphicsLayer(r1, new qg(r2, r3));
    }

    private static final Unit predictiveBackDrawerChild$lambda$57(DrawerPredictiveBackState r4, boolean r5, GraphicsLayerScope r6) {
        float r0 = calculatePredictiveBackScaleX(r6, r4);
        float r7 = calculatePredictiveBackScaleY(r6, r4);
        if (r0 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r2 = true;
    L6:
        float r3 = 1.0f;
        if (r2 == true) goto L9;
        float r8 = r7 / r0;
    L10:
        r6.setScaleX(r8);
        if (r5 == false) goto L13;
        r3 = MenuKt.ClosedAlphaTarget;
    L13:
        r6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(r3, MenuKt.ClosedAlphaTarget));
        return Unit.INSTANCE;
    L9:
        r8 = 1.0f;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private static final Modifier predictiveBackDrawerContainer(Modifier r1, final DrawerPredictiveBackState r2, final boolean r3) {
        return GraphicsLayerModifierKt.graphicsLayer(r1, new lg(r2, r3));
    }

    private static final Unit predictiveBackDrawerContainer$lambda$56(DrawerPredictiveBackState r1, boolean r2, GraphicsLayerScope r3) {
        r3.setScaleX(calculatePredictiveBackScaleX(r3, r1));
        r3.setScaleY(calculatePredictiveBackScaleY(r3, r1));
        if (r2 == false) goto L5;
        float r4 = 1.0f;
    L6:
        r3.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(r4, 0.5f));
        return Unit.INSTANCE;
    L5:
        r4 = MenuKt.ClosedAlphaTarget;
        goto L6
    }

    private static final Unit DismissibleNavigationDrawer$lambda$30$lambda$29(DrawerState r0, Density r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3) {
        r0.setDensity$material3(r1);
        r0.setOpenDrawerMotionSpec$material3(r2);
        r0.setCloseDrawerMotionSpec$material3(r3);
        return Unit.INSTANCE;
    }

    private static final Unit DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(String r0, final DrawerState r1, final CoroutineScope r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setPaneTitle(r3, r0);
        if (r1.isOpen() == false) goto L6;
        SemanticsPropertiesKt.dismiss$default(r3, null, new ag(r1, r2), 1, null);
    L6:
        return Unit.INSTANCE;
    }

    public static final void DrawerPredictiveBackHandler(final DrawerState r20, Function3<? super DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> r21, Composer r22, final int r23) {
        Composer r12 = r22.startRestartGroup(-383087355);
        if ((r23 & 6) == 0) goto L5;
        int r1 = r23;
    L11:
        if ((r23 & 48) == 0) goto L13;
    L17:
        int r14 = r1;
        if ((r14 & 19) == 18) goto L20;
        boolean r2 = true;
    L22:
        if (r12.shouldExecute(r2, r14 & 1) == true) goto L24;
        final Function3<? super DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> r3 = r21;
        r12.skipToGroupEnd();
    L60:
        ScopeUpdateScope r0 = r12.endRestartGroup();
        if (r0 == null) goto L64;
        r0.updateScope(new zf(r20, r3, r23));
        return;
    L64:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-383087355, r14, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.kt:941)");
    L26:
        Object r4 = r12.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r4 != r16.getEmpty()) goto L29;
        r4 = new DrawerPredictiveBackState();
        r12.updateRememberedValue(r4);
    L29:
        DrawerPredictiveBackState r7 = (DrawerPredictiveBackState) r4;
        Object r5 = r12.rememberedValue();
        if (r5 != r16.getEmpty()) goto L32;
        r5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r12);
        r12.updateRememberedValue(r5);
    L32:
        CoroutineScope r6 = (CoroutineScope) r5;
        if (r12.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L35;
        boolean r8 = true;
    L36:
        Ref.FloatRef r9 = new Ref.FloatRef();
        Ref.FloatRef r10 = new Ref.FloatRef();
        Ref.FloatRef r11 = new Ref.FloatRef();
        Density r13 = (Density) r12.consume(CompositionLocalsKt.getLocalDensity());
        r9.element = r13.toPx-0680j_4(PredictiveBackDrawerMaxScaleXDistanceGrow);
        r10.element = r13.toPx-0680j_4(PredictiveBackDrawerMaxScaleXDistanceShrink);
        r11.element = r13.toPx-0680j_4(PredictiveBackDrawerMaxScaleYDistance);
        boolean r15 = r20.isOpen();
        boolean r17 = (((r12.changed(r8) | r12.changed(r9.element)) | r12.changed(r10.element)) | r12.changed(r11.element)) | r12.changedInstance(r6);
        int r18 = r14 & 14;
        if (r18 != 4) goto L39;
        boolean r19 = true;
    L40:
        boolean r24 = r17 | r19;
        Object r110 = r12.rememberedValue();
        if (r24 == false) goto L43;
    L46:
        int r111 = 0;
        r110 = new NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(r7, r6, r20, r8, r9, r10, r11, null);
        r12.updateRememberedValue(r110);
    L47:
        BackHandler_androidKt.PredictiveBackHandler(r15, (Function2) r110, r12, r111, r111);
        Boolean r25 = Boolean.valueOf(r20.isClosed());
        if (r18 != 4) goto L50;
        boolean r112 = true;
    L51:
        Object r26 = r12.rememberedValue();
        if (r112 == false) goto L54;
    L55:
        r26 = new NavigationDrawerKt$DrawerPredictiveBackHandler$3$1(r20, r7, null);
        r12.updateRememberedValue(r26);
    L56:
        EffectsKt.LaunchedEffect(r25, (Function2) r26, r12, r111);
        r3 = r21;
        r3.invoke(r7, r12, Integer.valueOf((r14 & 112) | 6));
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventEnd();
        goto L60
    L54:
        if (r26 != r16.getEmpty()) goto L56;
    L50:
        r112 = false;
        goto L51
    L43:
        if (r110 == r16.getEmpty()) goto L46;
        r111 = 0;
        goto L47
    L39:
        r19 = false;
        goto L40
    L35:
        r8 = false;
        goto L36
    L20:
        r2 = false;
        goto L22
    L13:
        if (r12.changedInstance(r21) == false) goto L15;
        int r27 = 32;
    L16:
        r1 = r1 | r27;
        goto L17
    L15:
        r27 = 16;
        goto L16
    L5:
        if (r12.changed(r20) == false) goto L7;
        int r28 = 4;
    L8:
        r1 = r28 | r23;
        goto L11
    L7:
        r28 = 2;
        goto L8
    }

    private static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(String r0, final DrawerState r1, final CoroutineScope r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setPaneTitle(r3, r0);
        if (r1.isOpen() == false) goto L6;
        SemanticsPropertiesKt.dismiss$default(r3, null, new pg(r1, r2), 1, null);
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Modifier access$horizontalScaleDown(Modifier r0, FloatProducer r1, float r2, boolean r3) {
        return horizontalScaleDown(r0, r1, r2, r3);
    }

    private static final Modifier horizontalScaleDown(Modifier r1, final FloatProducer r2, final float r3, final boolean r4) {
        return GraphicsLayerModifierKt.graphicsLayer(r1, new dh(r2, r3, r4));
    }

    private static final Unit horizontalScaleDown$lambda$55(FloatProducer r3, float r4, boolean r5, GraphicsLayerScope r6) {
        float r7 = r3.invoke();
        float r0 = 1.0f;
        if (r7 <= MenuKt.ClosedAlphaTarget) goto L5;
        float r2 = 1 / ((r7 / r4) + 1.0f);
    L6:
        r6.setScaleX(r2);
        if (r5 == false) goto L9;
        r0 = MenuKt.ClosedAlphaTarget;
    L9:
        r6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(r0, MenuKt.ClosedAlphaTarget));
        return Unit.INSTANCE;
    L5:
        r2 = 1.0f;
        goto L6
    }

    private static final Modifier horizontalScaleUp(Modifier r1, final FloatProducer r2, final float r3, final boolean r4) {
        return GraphicsLayerModifierKt.graphicsLayer(r1, new fg(r2, r3, r4));
    }

    private static final Unit horizontalScaleUp$lambda$54(FloatProducer r3, float r4, boolean r5, GraphicsLayerScope r6) {
        float r7 = r3.invoke();
        float r0 = 1.0f;
        if (r7 <= MenuKt.ClosedAlphaTarget) goto L5;
        float r8 = (r7 / r4) + 1.0f;
    L6:
        r6.setScaleX(r8);
        if (r5 == false) goto L9;
        r0 = MenuKt.ClosedAlphaTarget;
    L9:
        r6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(r0, 0.5f));
        return Unit.INSTANCE;
    L5:
        r8 = 1.0f;
        goto L6
    }

    private static final Unit ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(DrawerState r0, Density r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3, FiniteAnimationSpec r4) {
        r0.setDensity$material3(r1);
        r0.setOpenDrawerMotionSpec$material3(r2);
        r0.setCloseDrawerMotionSpec$material3(r3);
        r0.setAnchoredDraggableMotionSpec$material3(r4);
        return Unit.INSTANCE;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue r6, final Function1<? super DrawerValue, Boolean> r7, Composer r8, int r9, int r10) {
        if ((r10 & 2) == 0) goto L9;
        Object r11 = r8.rememberedValue();
        if (r11 != Composer.Companion.getEmpty()) goto L7;
        r11 = new kg();
        r8.updateRememberedValue(r11);
    L7:
        r7 = (Function1) r11;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(2098699222, r9, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:305)");
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
        r4 = new vg(r6, r7);
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

    public static final void PermanentNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> r10, Modifier r11, final Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(89297160);
        if ((r15 & 1) == 0) goto L6;
        int r1 = r14 | 6;
    L13:
        int r2 = r15 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r15 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r1 & 147) == 146) goto L36;
        boolean r3 = true;
    L38:
        if (r16.shouldExecute(r3, r1 & 1) == false) goto L71;
        if (r2 == 0) goto L42;
        r11 = Modifier.Companion;
    L42:
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventStart(89297160, r1, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:561)");
    L44:
        Modifier r0 = SizeKt.fillMaxSize$default(r11, MenuKt.ClosedAlphaTarget, 1, null);
        Arrangement.Horizontal r4 = Arrangement.INSTANCE.getStart();
        Alignment.Companion r5 = Alignment.Companion;
        MeasurePolicy r6 = RowKt.rowMeasurePolicy(r4, r5.getTop(), r16, 0);
        int r7 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r8 = r16.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r16, r0);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r18 = r17.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L47;
        ComposablesKt.invalidApplier();
    L47:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L50;
        r16.createNode(r18);
    L51:
        Composer r19 = Updater.constructor-impl(r16);
        Updater.set-impl(r19, r6, r17.getSetMeasurePolicy());
        Updater.set-impl(r19, r8, r17.getSetResolvedCompositionLocals());
        Function2 r20 = r17.getSetCompositeKeyHash();
        if (r19.getInserting() == false) goto L54;
    L55:
        r19.updateRememberedValue(Integer.valueOf(r7));
        r19.apply(Integer.valueOf(r7), r20);
    L56:
        Updater.set-impl(r19, r9, r17.getSetModifier());
        RowScopeInstance r21 = RowScopeInstance.INSTANCE;
        r10.invoke(r16, Integer.valueOf(r1 & 14));
        Modifier.Companion r22 = Modifier.Companion;
        MeasurePolicy r23 = BoxKt.maybeCachedBoxMeasurePolicy(r5.getTopStart(), false);
        int r24 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r25 = r16.getCurrentCompositionLocalMap();
        Modifier r26 = ComposedModifierKt.materializeModifier(r16, r22);
        Function0 r27 = r17.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L59;
        ComposablesKt.invalidApplier();
    L59:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L62;
        r16.createNode(r27);
    L63:
        Composer r28 = Updater.constructor-impl(r16);
        Updater.set-impl(r28, r23, r17.getSetMeasurePolicy());
        Updater.set-impl(r28, r25, r17.getSetResolvedCompositionLocals());
        Function2 r29 = r17.getSetCompositeKeyHash();
        if (r28.getInserting() == false) goto L66;
    L67:
        r28.updateRememberedValue(Integer.valueOf(r24));
        r28.apply(Integer.valueOf(r24), r29);
    L68:
        Updater.set-impl(r28, r26, r17.getSetModifier());
        BoxScopeInstance r30 = BoxScopeInstance.INSTANCE;
        r12.invoke(r16, Integer.valueOf((r1 >> 6) & 14));
        r16.endNode();
        r16.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
    L72:
        final Modifier r31 = r11;
        ScopeUpdateScope r110 = r16.endRestartGroup();
        if (r110 == null) goto L76;
        r110.updateScope(new zg(r10, r31, r12, r14, r15));
        return;
    L76:
        return;
    L66:
        if (Intrinsics.areEqual(r28.rememberedValue(), Integer.valueOf(r24)) == true) goto L68;
    L62:
        r16.useNode();
        goto L63
    L54:
        if (Intrinsics.areEqual(r19.rememberedValue(), Integer.valueOf(r7)) == true) goto L56;
    L50:
        r16.useNode();
        goto L51
    L71:
        r16.skipToGroupEnd();
        goto L72
    L36:
        r3 = false;
        goto L38
    L27:
        if ((r14 & 384) != 0) goto L34;
        if (r16.changedInstance(r12) == false) goto L31;
        int r32 = 256;
    L32:
        r1 = r1 | r32;
        goto L34
    L31:
        r32 = 128;
        goto L32
    L17:
        if ((r14 & 48) != 0) goto L24;
        if (r16.changed(r11) == false) goto L21;
        int r33 = 32;
    L22:
        r1 = r1 | r33;
        goto L24
    L21:
        r33 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r1 = r14;
        goto L13
    L8:
        if (r16.changedInstance(r10) == false) goto L10;
        int r34 = 4;
    L11:
        r1 = r34 | r14;
        goto L13
    L10:
        r34 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    private static final void m2910ScrimBx497Mc(final boolean r17, final Function0<Unit> r18, final Function0<Float> r19, final long r20, Composer r22, final int r23) {
        Composer r7 = r22.startRestartGroup(2106487387);
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
        r12.updateScope(new ch(r17, r18, r19, r20, r23));
        return;
    L83:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(2106487387, r8, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1284)");
    L40:
        final String r0 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131895696), r7, 0);
        if (r17 == false) goto L61;
        r7.startReplaceGroup(598792893);
        Modifier.Companion r13 = Modifier.Companion;
        int r14 = r8 & 112;
        if (r14 != 32) goto L45;
        boolean r16 = true;
    L46:
        Object r110 = r7.rememberedValue();
        if (r16 == false) goto L49;
    L50:
        r110 = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(r18);
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
        r114 = new ah(r0, r18);
        r7.updateRememberedValue(r114);
    L60:
        Modifier r1 = SemanticsModifierKt.semantics(r21, true, (Function1) r114);
        r7.endReplaceGroup();
    L62:
        Modifier r2 = SizeKt.fillMaxSize$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, 1, null).then(r1);
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
        r26 = new bh(r20, r19);
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
        r7.startReplaceGroup(599116967);
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

    public static final void DismissibleNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> r26, Modifier r27, DrawerState r28, boolean r29, final Function2<? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32, final int r33) {
        Composer r2 = r31.startRestartGroup(1150092038);
        if ((r33 & 1) == 0) goto L6;
        int r3 = r32 | 6;
    L13:
        int r7 = r33 & 2;
        if (r7 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r8 = r27;
    L25:
        if ((r32 & 384) == 0) goto L27;
        final DrawerState r9 = r28;
    L35:
        int r11 = r33 & 8;
        if (r11 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r12 = r29;
    L47:
        if ((r33 & 16) == 0) goto L50;
        r3 = r3 | 24576;
    L57:
        if ((r3 & 9363) == 9362) goto L59;
        boolean r13 = true;
    L61:
        if (r2.shouldExecute(r13, r3 & 1) == false) goto L181;
        r2.startDefaults();
        if ((r32 & 1) != 0) goto L65;
    L70:
        if (r7 == 0) goto L73;
        r8 = Modifier.Companion;
    L73:
        if ((r33 & 4) == 0) goto L75;
        r3 = r3 & (-897);
        r9 = rememberDrawerState(DrawerValue.Closed, null, r2, 6, 2);
    L75:
        if (r11 == 0) goto L77;
        r12 = true;
    L77:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L80;
        ComposerKt.traceEventStart(1150092038, r3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:463)");
    L80:
        Object r0 = r2.rememberedValue();
        Composer.Companion r10 = Composer.Companion;
        if (r0 != r10.getEmpty()) goto L83;
        r0 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r2.updateRememberedValue(r0);
    L83:
        MutableState r1 = (MutableState) r0;
        final Density r4 = (Density) r2.consume(CompositionLocalsKt.getLocalDensity());
        final FiniteAnimationSpec r14 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r2, 6);
        final FiniteAnimationSpec r15 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r2, 6);
        int r16 = (r3 & 896) ^ 384;
        if (r16 <= 256) goto L88;
        if (r2.changed(r9) == false) goto L88;
    L89:
        boolean r17 = true;
    L91:
        boolean r18 = ((r17 | r2.changed(r4)) | r2.changedInstance(r14)) | r2.changedInstance(r15);
        Object r19 = r2.rememberedValue();
        if (r18 == false) goto L94;
    L95:
        r19 = new cg(r9, r4, r14, r15);
        r2.updateRememberedValue(r19);
    L96:
        EffectsKt.SideEffect((Function0) r19, r2, 0);
        Object r5 = r2.rememberedValue();
        if (r5 != r10.getEmpty()) goto L99;
        r5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r2);
        r2.updateRememberedValue(r5);
    L99:
        final CoroutineScope r6 = (CoroutineScope) r5;
        final String r110 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911858), r2, 0);
        if (r2.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L102;
        boolean r111 = true;
    L103:
        Modifier r112 = r8;
        Modifier r113 = AnchoredDraggableKt.anchoredDraggable$default(r112, r9.getAnchoredDraggableState$material3(), r111, Orientation.Horizontal, r12, null, null, null, 112, null);
        Alignment.Companion r114 = Alignment.Companion;
        MeasurePolicy r115 = BoxKt.maybeCachedBoxMeasurePolicy(r114.getTopStart(), false);
        int r116 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r20 = r2.getCurrentCompositionLocalMap();
        Modifier r117 = ComposedModifierKt.materializeModifier(r2, r113);
        ComposeUiNode.Companion r118 = ComposeUiNode.Companion;
        Modifier r210 = r8;
        Function0 r21 = r118.getConstructor();
        boolean r211 = r12;
        if ((r2.getApplier() instanceof Applier) == true) goto L106;
        ComposablesKt.invalidApplier();
    L106:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L109;
        r2.createNode(r21);
    L110:
        Composer r22 = Updater.constructor-impl(r2);
        Updater.set-impl(r22, r115, r118.getSetMeasurePolicy());
        Updater.set-impl(r22, r20, r118.getSetResolvedCompositionLocals());
        Function2 r23 = r118.getSetCompositeKeyHash();
        if (r22.getInserting() == false) goto L113;
    L114:
        r22.updateRememberedValue(Integer.valueOf(r116));
        r22.apply(Integer.valueOf(r116), r23);
    L115:
        Updater.set-impl(r22, r117, r118.getSetModifier());
        BoxScopeInstance r24 = BoxScopeInstance.INSTANCE;
        if (r16 <= 256) goto L120;
        if (r2.changed(r9) == false) goto L120;
    L121:
        boolean r25 = true;
    L123:
        Object r34 = r2.rememberedValue();
        if (r25 == false) goto L126;
    L127:
        r34 = new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(r9, r1);
        r2.updateRememberedValue(r34);
    L128:
        MeasurePolicy r35 = (MeasurePolicy) r34;
        Modifier.Companion r36 = Modifier.Companion;
        int r119 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r37 = r2.getCurrentCompositionLocalMap();
        Modifier r120 = ComposedModifierKt.materializeModifier(r2, r36);
        Function0 r121 = r118.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L131;
        ComposablesKt.invalidApplier();
    L131:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L134;
        r2.createNode(r121);
    L135:
        Composer r38 = Updater.constructor-impl(r2);
        Updater.set-impl(r38, r35, r118.getSetMeasurePolicy());
        Updater.set-impl(r38, r37, r118.getSetResolvedCompositionLocals());
        Function2 r39 = r118.getSetCompositeKeyHash();
        if (r38.getInserting() == false) goto L138;
    L139:
        r38.updateRememberedValue(Integer.valueOf(r119));
        r38.apply(Integer.valueOf(r119), r39);
    L140:
        Updater.set-impl(r38, r120, r118.getSetModifier());
        boolean r40 = r2.changed(r110);
        if (r16 <= 256) goto L145;
        if (r2.changed(r9) == false) goto L145;
    L146:
        boolean r41 = true;
    L148:
        boolean r42 = (r40 | r41) | r2.changedInstance(r6);
        Object r43 = r2.rememberedValue();
        if (r42 == false) goto L151;
    L152:
        r43 = new dg(r110, r9, r6);
        r2.updateRememberedValue(r43);
    L153:
        Modifier r44 = SemanticsModifierKt.semantics$default(r36, false, (Function1) r43, 1, null);
        MeasurePolicy r45 = BoxKt.maybeCachedBoxMeasurePolicy(r114.getTopStart(), false);
        int r46 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r47 = r2.getCurrentCompositionLocalMap();
        Modifier r48 = ComposedModifierKt.materializeModifier(r2, r44);
        Function0 r49 = r118.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L156;
        ComposablesKt.invalidApplier();
    L156:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L159;
        r2.createNode(r49);
    L160:
        Composer r50 = Updater.constructor-impl(r2);
        Updater.set-impl(r50, r45, r118.getSetMeasurePolicy());
        Updater.set-impl(r50, r47, r118.getSetResolvedCompositionLocals());
        Function2 r51 = r118.getSetCompositeKeyHash();
        if (r50.getInserting() == false) goto L163;
    L164:
        r50.updateRememberedValue(Integer.valueOf(r46));
        r50.apply(Integer.valueOf(r46), r51);
    L165:
        Updater.set-impl(r50, r48, r118.getSetModifier());
        r26.invoke(r2, Integer.valueOf(r3 & 14));
        r2.endNode();
        MeasurePolicy r52 = BoxKt.maybeCachedBoxMeasurePolicy(r114.getTopStart(), false);
        int r53 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r54 = r2.getCurrentCompositionLocalMap();
        Modifier r55 = ComposedModifierKt.materializeModifier(r2, r36);
        Function0 r56 = r118.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L168;
        ComposablesKt.invalidApplier();
    L168:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L171;
        r2.createNode(r56);
    L172:
        Composer r57 = Updater.constructor-impl(r2);
        Updater.set-impl(r57, r52, r118.getSetMeasurePolicy());
        Updater.set-impl(r57, r54, r118.getSetResolvedCompositionLocals());
        Function2 r58 = r118.getSetCompositeKeyHash();
        if (r57.getInserting() == false) goto L175;
    L176:
        r57.updateRememberedValue(Integer.valueOf(r53));
        r57.apply(Integer.valueOf(r53), r58);
    L177:
        Updater.set-impl(r57, r55, r118.getSetModifier());
        r30.invoke(r2, Integer.valueOf((r3 >> 12) & 14));
        r2.endNode();
        r2.endNode();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L180;
        ComposerKt.traceEventEnd();
    L180:
        r8 = r210;
        final boolean r59 = r211;
        final DrawerState r60 = r9;
    L182:
        ScopeUpdateScope r61 = r2.endRestartGroup();
        if (r61 == null) goto L186;
        final Modifier r62 = r8;
        r61.updateScope(new eg(r26, r62, r60, r59, r30, r32, r33));
        return;
    L186:
        return;
    L175:
        if (Intrinsics.areEqual(r57.rememberedValue(), Integer.valueOf(r53)) == true) goto L177;
    L171:
        r2.useNode();
        goto L172
    L163:
        if (Intrinsics.areEqual(r50.rememberedValue(), Integer.valueOf(r46)) == true) goto L165;
    L159:
        r2.useNode();
        goto L160
    L151:
        if (r43 != r10.getEmpty()) goto L153;
    L145:
        if ((r3 & 384) == 256) goto L146;
        r41 = false;
        goto L148
    L138:
        if (Intrinsics.areEqual(r38.rememberedValue(), Integer.valueOf(r119)) == true) goto L140;
    L134:
        r2.useNode();
        goto L135
    L126:
        if (r34 != r10.getEmpty()) goto L128;
    L120:
        if ((r3 & 384) == 256) goto L121;
        r25 = false;
        goto L123
    L113:
        if (Intrinsics.areEqual(r22.rememberedValue(), Integer.valueOf(r116)) == true) goto L115;
    L109:
        r2.useNode();
        goto L110
    L102:
        r111 = false;
        goto L103
    L94:
        if (r19 != r10.getEmpty()) goto L96;
    L88:
        if ((r3 & 384) == 256) goto L89;
        r17 = false;
        goto L91
    L65:
        if (r2.getDefaultsInvalid() == true) goto L70;
        r2.skipToGroupEnd();
        if ((r33 & 4) == 0) goto L77;
        r3 = r3 & (-897);
        goto L77
    L181:
        r2.skipToGroupEnd();
        r60 = r9;
        r59 = r12;
        goto L182
    L59:
        r13 = false;
        goto L61
    L50:
        if ((r32 & 24576) != 0) goto L57;
        if (r2.changedInstance(r30) == false) goto L54;
        int r122 = 16384;
    L55:
        r3 = r3 | r122;
        goto L57
    L54:
        r122 = 8192;
        goto L55
    L39:
        if ((r32 & 3072) != 0) goto L45;
        r12 = r29;
        if (r2.changed(r12) == false) goto L43;
        int r123 = 2048;
    L44:
        r3 = r3 | r123;
        goto L47
    L43:
        r123 = 1024;
        goto L44
    L27:
        if ((r33 & 4) != 0) goto L31;
        r9 = r28;
        if (r2.changed(r9) == false) goto L32;
        int r124 = 256;
    L33:
        r3 = r3 | r124;
    L32:
        r124 = 128;
        goto L33
    L31:
        r9 = r28;
        goto L32
    L17:
        if ((r32 & 48) != 0) goto L23;
        r8 = r27;
        if (r2.changed(r8) == false) goto L21;
        int r63 = 32;
    L22:
        r3 = r3 | r63;
        goto L25
    L21:
        r63 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r3 = r32;
        goto L13
    L8:
        if (r2.changedInstance(r26) == false) goto L10;
        int r64 = 4;
    L11:
        r3 = r64 | r32;
        goto L13
    L10:
        r64 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    public static final void m2908ModalNavigationDrawerFHprtrg(final Function2<? super Composer, ? super Integer, Unit> r30, Modifier r31, DrawerState r32, boolean r33, long r34, final Function2<? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r2 = r37.startRestartGroup(-1907430816);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L13:
        int r5 = r39 & 2;
        if (r5 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r6 = r31;
    L25:
        if ((r38 & 384) == 0) goto L27;
        DrawerState r9 = r32;
    L35:
        int r10 = r39 & 8;
        if (r10 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r12 = r33;
    L47:
        if ((r38 & 24576) == 0) goto L49;
        long r13 = r34;
    L58:
        if ((r39 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((r3 & 74899) == 74898) goto L70;
        boolean r11 = true;
    L72:
        if (r2.shouldExecute(r11, r3 & 1) == false) goto L239;
        r2.startDefaults();
        if ((r38 & 1) != 0) goto L76;
    L84:
        if (r5 == 0) goto L87;
        r6 = Modifier.Companion;
    L87:
        if ((r39 & 4) == 0) goto L89;
        r3 = r3 & (-897);
        r9 = rememberDrawerState(DrawerValue.Closed, null, r2, 6, 2);
    L89:
        if (r10 == 0) goto L92;
        r12 = true;
    L92:
        if ((r39 & 16) == 0) goto L94;
        int r14 = r3 & (-57345);
        final DrawerState r4 = r9;
        long r28 = DrawerDefaults.INSTANCE.getScrimColor(r2, 6);
        final boolean r7 = r12;
    L95:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventStart(-1907430816, r14, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:338)");
    L98:
        Object r15 = r2.rememberedValue();
        Composer.Companion r17 = Composer.Companion;
        if (r15 != r17.getEmpty()) goto L101;
        r15 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r2);
        r2.updateRememberedValue(r15);
    L101:
        final CoroutineScope r16 = (CoroutineScope) r15;
        String r18 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911858), r2, 0);
        final Density r19 = (Density) r2.consume(CompositionLocalsKt.getLocalDensity());
        Object r20 = r2.rememberedValue();
        if (r20 != r17.getEmpty()) goto L104;
        r20 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r2.updateRememberedValue(r20);
    L104:
        MutableState r8 = (MutableState) r20;
        boolean r21 = r2.changed(r19);
        Object r110 = r2.rememberedValue();
        if (r21 == false) goto L107;
    L108:
        r110 = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        r2.updateRememberedValue(r110);
    L109:
        MutableFloatState r111 = (MutableFloatState) r110;
        MotionSchemeKeyTokens r22 = MotionSchemeKeyTokens.DefaultSpatial;
        final FiniteAnimationSpec r112 = MotionSchemeKt.value(r22, r2, 6);
        final FiniteAnimationSpec r23 = MotionSchemeKt.value(r22, r2, 6);
        final FiniteAnimationSpec r24 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r2, 6);
        int r0 = (r14 & 896) ^ 384;
        if (r0 > 256) goto L112;
    L115:
        String r35 = r18;
        if ((r14 & 384) != 256) goto L118;
    L117:
        boolean r113 = true;
    L119:
        boolean r114 = (((r113 | r2.changed(r19)) | r2.changedInstance(r23)) | r2.changedInstance(r24)) | r2.changedInstance(r112);
        Object r115 = r2.rememberedValue();
        if (r114 == false) goto L122;
    L125:
        final DrawerState r116 = r4;
        MutableFloatState r310 = r111;
        Function0 r117 = new sg(r116, r19, r23, r24, r112);
        r2.updateRememberedValue(r117);
        r115 = r117;
    L126:
        EffectsKt.SideEffect((Function0) r115, r2, 0);
        if (r2.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L129;
        float r25 = MenuKt.ClosedAlphaTarget;
        int r26 = 1;
        Object r118 = null;
        boolean r27 = true;
    L130:
        Modifier r29 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(r6, r25, r26, r118), r4.getAnchoredDraggableState$material3(), r27, Orientation.Horizontal, r7, null, null, null, 112, null);
        Alignment.Companion r119 = Alignment.Companion;
        MeasurePolicy r120 = BoxKt.maybeCachedBoxMeasurePolicy(r119.getTopStart(), false);
        int r121 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r122 = r2.getCurrentCompositionLocalMap();
        Modifier r40 = ComposedModifierKt.materializeModifier(r2, r29);
        ComposeUiNode.Companion r123 = ComposeUiNode.Companion;
        Function0 r124 = r123.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L133;
        ComposablesKt.invalidApplier();
    L133:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L136;
        r2.createNode(r124);
    L137:
        Composer r41 = Updater.constructor-impl(r2);
        Updater.set-impl(r41, r120, r123.getSetMeasurePolicy());
        Updater.set-impl(r41, r122, r123.getSetResolvedCompositionLocals());
        Function2 r125 = r123.getSetCompositeKeyHash();
        if (r41.getInserting() == false) goto L140;
    L141:
        r41.updateRememberedValue(Integer.valueOf(r121));
        r41.apply(Integer.valueOf(r121), r125);
    L142:
        Updater.set-impl(r41, r40, r123.getSetModifier());
        BoxScopeInstance r42 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r43 = Modifier.Companion;
        MeasurePolicy r44 = BoxKt.maybeCachedBoxMeasurePolicy(r119.getTopStart(), false);
        int r126 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r127 = r2.getCurrentCompositionLocalMap();
        Modifier r128 = ComposedModifierKt.materializeModifier(r2, r43);
        Function0 r129 = r123.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L145;
        ComposablesKt.invalidApplier();
    L145:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L148;
        r2.createNode(r129);
    L149:
        Composer r130 = Updater.constructor-impl(r2);
        Updater.set-impl(r130, r44, r123.getSetMeasurePolicy());
        Updater.set-impl(r130, r127, r123.getSetResolvedCompositionLocals());
        Function2 r45 = r123.getSetCompositeKeyHash();
        if (r130.getInserting() == false) goto L152;
    L153:
        r130.updateRememberedValue(Integer.valueOf(r126));
        r130.apply(Integer.valueOf(r126), r45);
    L154:
        Updater.set-impl(r130, r128, r123.getSetModifier());
        r36.invoke(r2, Integer.valueOf((r14 >> 15) & 14));
        r2.endNode();
        boolean r46 = r4.isOpen();
        if ((r14 & 7168) != 2048) goto L157;
        boolean r131 = true;
    L159:
        if (r0 <= 256) goto L163;
        if (r2.changed(r4) == false) goto L163;
    L164:
        boolean r132 = true;
    L166:
        boolean r133 = (r131 | r132) | r2.changedInstance(r16);
        Object r134 = r2.rememberedValue();
        if (r133 == false) goto L169;
    L170:
        r134 = new tg(r7, r4, r16);
        r2.updateRememberedValue(r134);
    L171:
        Function0 r135 = (Function0) r134;
        final MutableFloatState r136 = r310;
        boolean r137 = r2.changed(r136);
        if (r0 <= 256) goto L176;
        if (r2.changed(r4) == false) goto L176;
    L177:
        boolean r138 = true;
    L179:
        boolean r139 = r137 | r138;
        Object r140 = r2.rememberedValue();
        if (r139 == false) goto L182;
    L183:
        r140 = new ug(r4, r136);
        r2.updateRememberedValue(r140);
    L184:
        long r141 = r28;
        boolean r311 = r7;
        Modifier r210 = r6;
        m2910ScrimBx497Mc(r46, r135, (Function0) r140, r141, r2, (r14 >> 3) & 7168);
        if (r0 <= 256) goto L189;
        if (r2.changed(r4) == false) goto L189;
    L190:
        boolean r47 = true;
    L192:
        Object r142 = r2.rememberedValue();
        if (r47 == false) goto L195;
    L196:
        r142 = new wg(r4);
        r2.updateRememberedValue(r142);
    L197:
        Modifier r48 = OffsetKt.offset(r43, (Function1) r142);
        final String r49 = r35;
        boolean r143 = r2.changed(r49);
        if (r0 <= 256) goto L202;
        if (r2.changed(r4) == false) goto L202;
    L203:
        boolean r144 = true;
    L205:
        boolean r145 = (r143 | r144) | r2.changedInstance(r16);
        Object r146 = r2.rememberedValue();
        if (r145 == false) goto L208;
    L209:
        r146 = new xg(r49, r4, r16);
        r2.updateRememberedValue(r146);
    L210:
        Modifier r1 = SemanticsModifierKt.semantics$default(r48, false, (Function1) r146, 1, null);
        if (r0 <= 256) goto L215;
        if (r2.changed(r4) == false) goto L215;
    L216:
        boolean r50 = true;
    L218:
        boolean r51 = r50 | r2.changed(r136);
        Object r52 = r2.rememberedValue();
        if (r51 == false) goto L221;
    L222:
        r52 = new NavigationDrawerKt$ModalNavigationDrawer$2$6$1(r4, r8, r136, MenuKt.ClosedAlphaTarget);
        r2.updateRememberedValue(r52);
    L223:
        MeasurePolicy r53 = (MeasurePolicy) r52;
        int r54 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r55 = r2.getCurrentCompositionLocalMap();
        Modifier r56 = ComposedModifierKt.materializeModifier(r2, r1);
        Function0 r57 = r123.getConstructor();
        int r58 = (((r14 & 14) << 6) & 896) | 6;
        if ((r2.getApplier() instanceof Applier) == true) goto L226;
        ComposablesKt.invalidApplier();
    L226:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L229;
        r2.createNode(r57);
    L230:
        Composer r59 = Updater.constructor-impl(r2);
        Updater.set-impl(r59, r53, r123.getSetMeasurePolicy());
        Updater.set-impl(r59, r55, r123.getSetResolvedCompositionLocals());
        Function2 r60 = r123.getSetCompositeKeyHash();
        if (r59.getInserting() == false) goto L233;
    L234:
        r59.updateRememberedValue(Integer.valueOf(r54));
        r59.apply(Integer.valueOf(r54), r60);
    L235:
        Updater.set-impl(r59, r56, r123.getSetModifier());
        r30.invoke(r2, Integer.valueOf((r58 >> 6) & 14));
        r2.endNode();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L238;
        ComposerKt.traceEventEnd();
    L238:
        final boolean r61 = r311;
        r6 = r210;
        r13 = r28;
    L240:
        ScopeUpdateScope r147 = r2.endRestartGroup();
        if (r147 == null) goto L244;
        final Modifier r62 = r6;
        final long r63 = r13;
        r147.updateScope(new yg(r30, r62, r4, r61, r63, r36, r38, r39));
        return;
    L244:
        return;
    L233:
        if (Intrinsics.areEqual(r59.rememberedValue(), Integer.valueOf(r54)) == true) goto L235;
    L229:
        r2.useNode();
        goto L230
    L221:
        if (r52 != r17.getEmpty()) goto L223;
    L215:
        if ((r14 & 384) == 256) goto L216;
        r50 = false;
        goto L218
    L208:
        if (r146 != r17.getEmpty()) goto L210;
    L202:
        if ((r14 & 384) == 256) goto L203;
        r144 = false;
        goto L205
    L195:
        if (r142 != r17.getEmpty()) goto L197;
    L189:
        if ((r14 & 384) == 256) goto L190;
        r47 = false;
        goto L192
    L182:
        if (r140 != r17.getEmpty()) goto L184;
    L176:
        if ((r14 & 384) == 256) goto L177;
        r138 = false;
        goto L179
    L169:
        if (r134 != r17.getEmpty()) goto L171;
    L163:
        if ((r14 & 384) == 256) goto L164;
        r132 = false;
        goto L166
    L157:
        r131 = false;
        goto L159
    L152:
        if (Intrinsics.areEqual(r130.rememberedValue(), Integer.valueOf(r126)) == true) goto L154;
    L148:
        r2.useNode();
        goto L149
    L140:
        if (Intrinsics.areEqual(r41.rememberedValue(), Integer.valueOf(r121)) == true) goto L142;
    L136:
        r2.useNode();
        goto L137
    L129:
        r25 = MenuKt.ClosedAlphaTarget;
        r26 = 1;
        r118 = null;
        r27 = false;
        goto L130
    L122:
        if (r115 == r17.getEmpty()) goto L125;
        r310 = r111;
        goto L126
    L118:
        r113 = false;
        goto L119
    L112:
        if (r2.changed(r4) == false) goto L115;
        r35 = r18;
        goto L117
    L107:
        if (r110 != r17.getEmpty()) goto L109;
    L94:
        r7 = r12;
        r28 = r13;
        r14 = r3;
        r4 = r9;
        goto L95
    L76:
        if (r2.getDefaultsInvalid() == true) goto L84;
        r2.skipToGroupEnd();
        if ((r39 & 4) == 0) goto L82;
        r3 = r3 & (-897);
    L82:
        if ((r39 & 16) == 0) goto L94;
        r3 = r3 & (-57345);
        goto L94
    L239:
        r2.skipToGroupEnd();
        r4 = r9;
        r61 = r12;
        goto L240
    L70:
        r11 = false;
        goto L72
    L61:
        if ((r38 & 196608) != 0) goto L68;
        if (r2.changedInstance(r36) == false) goto L65;
        int r148 = 131072;
    L66:
        r3 = r3 | r148;
        goto L68
    L65:
        r148 = 65536;
        goto L66
    L49:
        if ((r39 & 16) != 0) goto L53;
        r13 = r34;
        if (r2.changed(r13) == false) goto L54;
        int r149 = 16384;
    L55:
        r3 = r3 | r149;
    L54:
        r149 = 8192;
        goto L55
    L53:
        r13 = r34;
        goto L54
    L39:
        if ((r38 & 3072) != 0) goto L45;
        r12 = r33;
        if (r2.changed(r12) == false) goto L43;
        int r150 = 2048;
    L44:
        r3 = r3 | r150;
        goto L47
    L43:
        r150 = 1024;
        goto L44
    L27:
        if ((r39 & 4) != 0) goto L31;
        r9 = r32;
        if (r2.changed(r9) == false) goto L32;
        int r151 = 256;
    L33:
        r3 = r3 | r151;
    L32:
        r151 = 128;
        goto L33
    L31:
        r9 = r32;
        goto L32
    L17:
        if ((r38 & 48) != 0) goto L23;
        r6 = r31;
        if (r2.changed(r6) == false) goto L21;
        int r64 = 32;
    L22:
        r3 = r3 | r64;
        goto L25
    L21:
        r64 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L13
    L8:
        if (r2.changedInstance(r30) == false) goto L10;
        int r65 = 4;
    L11:
        r3 = r65 | r38;
        goto L13
    L10:
        r65 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m2904DismissibleDrawerSheetafqeVBk(Modifier r27, Shape r28, long r29, long r31, float r33, WindowInsets r34, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r35, Composer r36, final int r37, final int r38) {
        Composer r1 = r36.startRestartGroup(-1496398234);
        int r2 = r38 & 1;
        if (r2 == 0) goto L6;
        int r4 = r37 | 6;
    L13:
        int r5 = r38 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Shape r6 = r28;
    L25:
        if ((r37 & 384) == 0) goto L27;
        long r7 = r29;
    L36:
        if ((r37 & 3072) != 0) goto L44;
        long r11 = r31;
        if ((r38 & 8) == 0) goto L40;
    L42:
        int r9 = 1024;
    L43:
        r4 = r4 | r9;
    L45:
        int r10 = r38 & 16;
        if (r10 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        float r13 = r33;
    L57:
        if ((196608 & r37) == 0) goto L59;
        WindowInsets r14 = r34;
    L68:
        if ((r38 & 64) == 0) goto L71;
        r4 = r4 | 1572864;
    L79:
        if ((r4 & 599187) == 599186) goto L81;
        boolean r0 = true;
    L83:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L124;
        r1.startDefaults();
        if ((r37 & 1) != 0) goto L87;
    L101:
        if (r2 == 0) goto L103;
        Modifier r3 = Modifier.Companion;
    L104:
        if (r5 == 0) goto L107;
        r6 = RectangleShapeKt.getRectangleShape();
    L107:
        if ((r38 & 4) == 0) goto L110;
        r7 = DrawerDefaults.INSTANCE.getStandardContainerColor(r1, 6);
        r4 = r4 & (-897);
    L110:
        if ((r38 & 8) == 0) goto L112;
        r11 = ColorSchemeKt.m2496contentColorForek8zF_U(r7, r1, (r4 >> 6) & 14);
        r4 = r4 & (-7169);
    L112:
        if (r10 == 0) goto L115;
        r13 = DrawerDefaults.INSTANCE.m2642getDismissibleDrawerElevationD9Ej5fM();
    L115:
        if ((r38 & 32) != 0) goto L116;
    L99:
        float r8 = r13;
        WindowInsets r12 = r14;
    L100:
        long r25 = r11;
        int r15 = r4;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventStart(-1496398234, r15, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:686)");
    L120:
        int r16 = ((r15 >> 12) & 112) | 6;
        int r17 = r15 << 6;
        int r23 = ((((((r17 & 896) | r16) | (r17 & 7168)) | (57344 & r17)) | (458752 & r17)) | (3670016 & r17)) | (r17 & 234881024);
        m2905DrawerSheetcm3T3N0(null, r12, r3, r6, r7, r25, r8, null, r35, r1, r23, 128);
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventEnd();
    L123:
        r11 = r25;
        final long r18 = r7;
        final WindowInsets r19 = r12;
        final float r20 = r8;
        Modifier r21 = r3;
    L125:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L129;
        final Modifier r22 = r21;
        final Shape r24 = r6;
        final long r26 = r11;
        r110.updateScope(new og(r22, r24, r18, r26, r20, r19, r35, r37, r38));
        return;
    L129:
        return;
    L116:
        r4 = r4 & (-458753);
        r12 = DrawerDefaults.INSTANCE.getWindowInsets(r1, 6);
        r8 = r13;
        goto L100
    L103:
        r3 = r27;
        goto L104
    L87:
        if (r1.getDefaultsInvalid() == true) goto L101;
        r1.skipToGroupEnd();
        if ((r38 & 4) == 0) goto L93;
        r4 = r4 & (-897);
    L93:
        if ((r38 & 8) == 0) goto L96;
        r4 = r4 & (-7169);
    L96:
        if ((r38 & 32) == 0) goto L98;
        r4 = r4 & (-458753);
    L98:
        r3 = r27;
        goto L99
    L124:
        r1.skipToGroupEnd();
        r21 = r27;
        r18 = r7;
        r20 = r13;
        r19 = r14;
        goto L125
    L81:
        r0 = false;
        goto L83
    L71:
        if ((r37 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r35) == false) goto L75;
        int r111 = 1048576;
    L76:
        r4 = r4 | r111;
        goto L79
    L75:
        r111 = 524288;
        goto L76
    L59:
        if ((r38 & 32) != 0) goto L63;
        r14 = r34;
        if (r1.changed(r14) == false) goto L64;
        int r112 = 131072;
    L65:
        r4 = r4 | r112;
    L64:
        r112 = 65536;
        goto L65
    L63:
        r14 = r34;
        goto L64
    L49:
        if ((r37 & 24576) != 0) goto L55;
        r13 = r33;
        if (r1.changed(r13) == false) goto L53;
        int r113 = 16384;
    L54:
        r4 = r4 | r113;
        goto L57
    L53:
        r113 = 8192;
        goto L54
    L40:
        if (r1.changed(r11) == false) goto L42;
        r9 = 2048;
        goto L43
    L44:
        r11 = r31;
        goto L45
    L27:
        if ((r38 & 4) != 0) goto L31;
        r7 = r29;
        if (r1.changed(r7) == false) goto L32;
        int r30 = 256;
    L33:
        r4 = r4 | r30;
    L32:
        r30 = 128;
        goto L33
    L31:
        r7 = r29;
        goto L32
    L17:
        if ((r37 & 48) != 0) goto L23;
        r6 = r28;
        if (r1.changed(r6) == false) goto L21;
        int r32 = 32;
    L22:
        r4 = r4 | r32;
        goto L25
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r4 = r37;
        goto L13
    L8:
        if (r1.changed(r27) == false) goto L10;
        int r39 = 4;
    L11:
        r4 = r39 | r37;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m2907ModalDrawerSheetafqeVBk(Modifier r25, Shape r26, long r27, long r29, float r31, WindowInsets r32, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r33, Composer r34, final int r35, final int r36) {
        Composer r1 = r34.startRestartGroup(1922633461);
        int r2 = r36 & 1;
        if (r2 == 0) goto L6;
        int r4 = r35 | 6;
        Modifier r3 = r25;
    L14:
        if ((r35 & 48) == 0) goto L16;
        Shape r5 = r26;
    L25:
        if ((r35 & 384) == 0) goto L27;
        long r6 = r27;
    L36:
        if ((r35 & 3072) == 0) goto L38;
        long r8 = r29;
    L46:
        int r11 = r36 & 16;
        if (r11 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        float r12 = r31;
    L58:
        if ((196608 & r35) == 0) goto L60;
        WindowInsets r13 = r32;
    L69:
        if ((r36 & 64) == 0) goto L72;
        r4 = r4 | 1572864;
    L79:
        if ((599187 & r4) == 599186) goto L81;
        boolean r0 = true;
    L83:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L127;
        r1.startDefaults();
        if ((r35 & 1) != 0) goto L87;
    L103:
        if (r2 == 0) goto L105;
        Modifier r7 = Modifier.Companion;
    L107:
        if ((r36 & 2) == 0) goto L110;
        r4 = r4 & (-113);
        r5 = DrawerDefaults.INSTANCE.getShape(r1, 6);
    L110:
        if ((r36 & 4) == 0) goto L113;
        r4 = r4 & (-897);
        r6 = DrawerDefaults.INSTANCE.getModalContainerColor(r1, 6);
    L113:
        if ((r36 & 8) == 0) goto L115;
        long r9 = ColorSchemeKt.m2496contentColorForek8zF_U(r6, r1, (r4 >> 6) & 14);
        r4 = r4 & (-7169);
        r8 = r9;
    L115:
        if (r11 == 0) goto L118;
        r12 = DrawerDefaults.INSTANCE.m2644getModalDrawerElevationD9Ej5fM();
    L118:
        if ((r36 & 32) != 0) goto L119;
    L102:
        float r10 = r12;
        WindowInsets r14 = r13;
    L120:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventStart(1922633461, r4, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:597)");
    L123:
        int r15 = ((r4 >> 12) & 112) | 6;
        int r16 = r4 << 6;
        int r23 = (((((r15 | (r16 & 896)) | (r16 & 7168)) | (57344 & r16)) | (458752 & r16)) | (3670016 & r16)) | (r16 & 234881024);
        m2905DrawerSheetcm3T3N0(null, r14, r7, r5, r6, r8, r10, null, r33, r1, r23, 128);
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventEnd();
    L126:
        r12 = r10;
        r13 = r14;
        final Shape r17 = r5;
        r3 = r7;
    L128:
        ScopeUpdateScope r18 = r1.endRestartGroup();
        if (r18 == null) goto L132;
        final Modifier r19 = r3;
        final long r20 = r6;
        final long r21 = r8;
        final float r22 = r12;
        final WindowInsets r24 = r13;
        r18.updateScope(new jg(r19, r17, r20, r21, r22, r24, r33, r35, r36));
        return;
    L132:
        return;
    L119:
        r4 = r4 & (-458753);
        r14 = DrawerDefaults.INSTANCE.getWindowInsets(r1, 6);
        r10 = r12;
        goto L120
    L105:
        r7 = r3;
        goto L107
    L87:
        if (r1.getDefaultsInvalid() == true) goto L103;
        r1.skipToGroupEnd();
        if ((r36 & 2) == 0) goto L93;
        r4 = r4 & (-113);
    L93:
        if ((r36 & 4) == 0) goto L96;
        r4 = r4 & (-897);
    L96:
        if ((r36 & 8) == 0) goto L99;
        r4 = r4 & (-7169);
    L99:
        if ((r36 & 32) == 0) goto L101;
        r4 = r4 & (-458753);
    L101:
        r7 = r3;
        goto L102
    L127:
        r1.skipToGroupEnd();
        r17 = r5;
        goto L128
    L81:
        r0 = false;
        goto L83
    L72:
        if ((r35 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r33) == false) goto L76;
        int r110 = 1048576;
    L77:
        r4 = r4 | r110;
        goto L79
    L76:
        r110 = 524288;
        goto L77
    L60:
        if ((r36 & 32) != 0) goto L64;
        r13 = r32;
        if (r1.changed(r13) == false) goto L65;
        int r111 = 131072;
    L66:
        r4 = r4 | r111;
    L65:
        r111 = 65536;
        goto L66
    L64:
        r13 = r32;
        goto L65
    L50:
        if ((r35 & 24576) != 0) goto L56;
        r12 = r31;
        if (r1.changed(r12) == false) goto L54;
        int r112 = 16384;
    L55:
        r4 = r4 | r112;
        goto L58
    L54:
        r112 = 8192;
        goto L55
    L38:
        if ((r36 & 8) != 0) goto L42;
        r8 = r29;
        if (r1.changed(r8) == false) goto L43;
        int r113 = 2048;
    L44:
        r4 = r4 | r113;
    L43:
        r113 = 1024;
        goto L44
    L42:
        r8 = r29;
        goto L43
    L27:
        if ((r36 & 4) != 0) goto L31;
        r6 = r27;
        if (r1.changed(r6) == false) goto L32;
        int r28 = 256;
    L33:
        r4 = r4 | r28;
    L32:
        r28 = 128;
        goto L33
    L31:
        r6 = r27;
        goto L32
    L16:
        if ((r36 & 2) != 0) goto L20;
        r5 = r26;
        if (r1.changed(r5) == false) goto L21;
        int r30 = 32;
    L22:
        r4 = r4 | r30;
    L21:
        r30 = 16;
        goto L22
    L20:
        r5 = r26;
        goto L21
    L6:
        if ((r35 & 6) != 0) goto L12;
        r3 = r25;
        if (r1.changed(r3) == false) goto L10;
        int r37 = 4;
    L11:
        r4 = r37 | r35;
        goto L14
    L10:
        r37 = 2;
        goto L11
    L12:
        r3 = r25;
        r4 = r35;
        goto L14
    }

    /* JADX INFO: renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m2909PermanentDrawerSheetafqeVBk(Modifier r27, Shape r28, long r29, long r31, float r33, WindowInsets r34, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r35, Composer r36, final int r37, final int r38) {
        Composer r1 = r36.startRestartGroup(1877158612);
        int r2 = r38 & 1;
        if (r2 == 0) goto L6;
        int r4 = r37 | 6;
    L13:
        int r5 = r38 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L25:
        if ((r37 & 384) == 0) goto L27;
        long r7 = r29;
    L36:
        if ((r37 & 3072) != 0) goto L44;
        long r11 = r31;
        if ((r38 & 8) == 0) goto L40;
    L42:
        int r9 = 1024;
    L43:
        r4 = r4 | r9;
    L45:
        int r10 = r38 & 16;
        if (r10 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        float r13 = r33;
    L57:
        if ((196608 & r37) == 0) goto L59;
        WindowInsets r14 = r34;
    L68:
        if ((r38 & 64) == 0) goto L71;
        r4 = r4 | 1572864;
    L79:
        if ((r4 & 599187) == 599186) goto L81;
        boolean r0 = true;
    L83:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L131;
        r1.startDefaults();
        if ((r37 & 1) != 0) goto L87;
    L101:
        if (r2 == 0) goto L103;
        Modifier r3 = Modifier.Companion;
    L104:
        if (r5 == 0) goto L106;
        Shape r6 = RectangleShapeKt.getRectangleShape();
    L108:
        if ((r38 & 4) == 0) goto L111;
        r7 = DrawerDefaults.INSTANCE.getStandardContainerColor(r1, 6);
        r4 = r4 & (-897);
    L111:
        if ((r38 & 8) == 0) goto L113;
        r11 = ColorSchemeKt.m2496contentColorForek8zF_U(r7, r1, (r4 >> 6) & 14);
        r4 = r4 & (-7169);
    L113:
        if (r10 == 0) goto L115;
        float r8 = DrawerDefaults.INSTANCE.m2645getPermanentDrawerElevationD9Ej5fM();
    L117:
        if ((r38 & 32) != 0) goto L118;
    L99:
        WindowInsets r12 = r14;
    L100:
        long r25 = r11;
        int r15 = r4;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L122;
        ComposerKt.traceEventStart(1877158612, r15, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:771)");
    L122:
        final String r16 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911858), r1, 0);
        boolean r17 = r1.changed(r16);
        Object r18 = r1.rememberedValue();
        if (r17 == false) goto L125;
    L126:
        r18 = new gg(r16);
        r1.updateRememberedValue(r18);
    L127:
        int r19 = ((r15 >> 12) & 112) | 6;
        int r110 = r15 << 6;
        int r23 = ((((r19 | (r110 & 7168)) | (57344 & r110)) | (458752 & r110)) | (3670016 & r110)) | (r110 & 234881024);
        WindowInsets r111 = r12;
        m2905DrawerSheetcm3T3N0(null, r111, SemanticsModifierKt.semantics$default(r3, false, (Function1) r18, 1, null), r6, r7, r25, r8, null, r35, r1, r23, 128);
        if (ComposerKt.isTraceInProgress() == false) goto L130;
        ComposerKt.traceEventEnd();
    L130:
        r13 = r8;
        final long r20 = r25;
        Shape r21 = r6;
        Modifier r22 = r3;
    L132:
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L136;
        final Modifier r24 = r22;
        final Shape r26 = r21;
        final long r30 = r7;
        final float r32 = r13;
        final WindowInsets r39 = r12;
        r112.updateScope(new hg(r24, r26, r30, r20, r32, r39, r35, r37, r38));
        return;
    L136:
        return;
    L125:
        if (r18 != Composer.Companion.getEmpty()) goto L127;
    L118:
        r12 = DrawerDefaults.INSTANCE.getWindowInsets(r1, 6);
        r4 = r4 & (-458753);
        goto L100
    L115:
        r8 = r13;
        goto L117
    L106:
        r6 = r28;
        goto L108
    L103:
        r3 = r27;
        goto L104
    L87:
        if (r1.getDefaultsInvalid() == true) goto L101;
        r1.skipToGroupEnd();
        if ((r38 & 4) == 0) goto L93;
        r4 = r4 & (-897);
    L93:
        if ((r38 & 8) == 0) goto L96;
        r4 = r4 & (-7169);
    L96:
        if ((r38 & 32) == 0) goto L98;
        r4 = r4 & (-458753);
    L98:
        r3 = r27;
        r6 = r28;
        r8 = r13;
        goto L99
    L131:
        r1.skipToGroupEnd();
        r22 = r27;
        r21 = r28;
        r20 = r11;
        r12 = r14;
        goto L132
    L81:
        r0 = false;
        goto L83
    L71:
        if ((r37 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r35) == false) goto L75;
        int r113 = 1048576;
    L76:
        r4 = r4 | r113;
        goto L79
    L75:
        r113 = 524288;
        goto L76
    L59:
        if ((r38 & 32) != 0) goto L63;
        r14 = r34;
        if (r1.changed(r14) == false) goto L64;
        int r114 = 131072;
    L65:
        r4 = r4 | r114;
    L64:
        r114 = 65536;
        goto L65
    L63:
        r14 = r34;
        goto L64
    L49:
        if ((r37 & 24576) != 0) goto L55;
        r13 = r33;
        if (r1.changed(r13) == false) goto L53;
        int r115 = 16384;
    L54:
        r4 = r4 | r115;
        goto L57
    L53:
        r115 = 8192;
        goto L54
    L40:
        if (r1.changed(r11) == false) goto L42;
        r9 = 2048;
        goto L43
    L44:
        r11 = r31;
        goto L45
    L27:
        if ((r38 & 4) != 0) goto L31;
        r7 = r29;
        if (r1.changed(r7) == false) goto L32;
        int r40 = 256;
    L33:
        r4 = r4 | r40;
    L32:
        r40 = 128;
        goto L33
    L31:
        r7 = r29;
        goto L32
    L17:
        if ((r37 & 48) != 0) goto L25;
        if (r1.changed(r28) == false) goto L21;
        int r41 = 32;
    L22:
        r4 = r4 | r41;
        goto L25
    L21:
        r41 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r4 = r37;
        goto L13
    L8:
        if (r1.changed(r27) == false) goto L10;
        int r42 = 4;
    L11:
        r4 = r42 | r37;
        goto L13
    L10:
        r42 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DismissibleDrawerSheet-Snr_uVM, reason: not valid java name */
    public static final void m2903DismissibleDrawerSheetSnr_uVM(final DrawerState r25, Modifier r26, Shape r27, long r28, long r30, float r32, WindowInsets r33, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r34, Composer r35, final int r36, final int r37) {
        Composer r14 = r35.startRestartGroup(496605370);
        if ((r37 & 1) == 0) goto L6;
        int r1 = r36 | 6;
    L13:
        int r2 = r37 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r4 = r37 & 4;
        if (r4 == 0) goto L28;
        r1 = r1 | 384;
    L34:
        Shape r5 = r27;
    L36:
        if ((r36 & 3072) == 0) goto L38;
        long r6 = r28;
    L47:
        if ((r36 & 24576) == 0) goto L49;
        long r8 = r30;
    L57:
        int r10 = r37 & 32;
        if (r10 == 0) goto L61;
        r1 = r1 | 196608;
    L69:
        if ((r36 & 1572864) != 0) goto L79;
        if ((r37 & 64) == 0) goto L73;
    L75:
        int r17 = 524288;
    L76:
        r1 = r1 | r17;
        goto L79
    L73:
        if (r14.changed(r33) == false) goto L75;
        r17 = 1048576;
    L79:
        if ((r37 & 128) == 0) goto L82;
        r1 = r1 | 12582912;
    L90:
        if ((r1 & 4793491) == 4793490) goto L92;
        boolean r0 = true;
    L94:
        if (r14.shouldExecute(r0, r1 & 1) == false) goto L136;
        r14.startDefaults();
        if ((r36 & 1) != 0) goto L98;
    L111:
        if (r2 == 0) goto L113;
        Modifier r3 = Modifier.Companion;
    L114:
        if (r4 == 0) goto L117;
        r5 = RectangleShapeKt.getRectangleShape();
    L117:
        if ((r37 & 8) == 0) goto L120;
        r6 = DrawerDefaults.INSTANCE.getStandardContainerColor(r14, 6);
        r1 = r1 & (-7169);
    L120:
        if ((r37 & 16) == 0) goto L122;
        r8 = ColorSchemeKt.m2496contentColorForek8zF_U(r6, r14, (r1 >> 9) & 14);
        r1 = r1 & (-57345);
    L122:
        if (r10 == 0) goto L124;
        float r7 = DrawerDefaults.INSTANCE.m2642getDismissibleDrawerElevationD9Ej5fM();
    L126:
        if ((r37 & 64) == 0) goto L128;
        WindowInsets r9 = DrawerDefaults.INSTANCE.getWindowInsets(r14, 6);
        Modifier r18 = r3;
        int r11 = r1 & (-3670017);
        float r23 = r7;
        WindowInsets r24 = r9;
    L110:
        Shape r19 = r5;
        long r110 = r6;
        long r21 = r8;
        r14.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventStart(496605370, r11, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:730)");
    L132:
        DrawerPredictiveBackHandler(r25, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new NavigationDrawerKt$DismissibleDrawerSheet$2(r24, r18, r19, r110, r21, r23, r25, r34), r14, 54), r14, (r11 & 14) | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventEnd();
    L135:
        final Modifier r12 = r18;
        final Shape r13 = r19;
        final long r15 = r110;
        final long r16 = r21;
        final float r20 = r23;
        final WindowInsets r22 = r24;
    L137:
        ScopeUpdateScope r111 = r14.endRestartGroup();
        if (r111 == null) goto L141;
        r111.updateScope(new rg(r25, r12, r13, r15, r16, r20, r22, r34, r36, r37));
        return;
    L141:
        return;
    L128:
        r24 = r33;
        r18 = r3;
        r11 = r1;
        r23 = r7;
        goto L110
    L124:
        r7 = r32;
        goto L126
    L113:
        r3 = r26;
        goto L114
    L98:
        if (r14.getDefaultsInvalid() == true) goto L111;
        r14.skipToGroupEnd();
        if ((r37 & 8) == 0) goto L104;
        r1 = r1 & (-7169);
    L104:
        if ((r37 & 16) == 0) goto L107;
        r1 = r1 & (-57345);
    L107:
        if ((r37 & 64) == 0) goto L109;
        r1 = r1 & (-3670017);
    L109:
        r18 = r26;
        r23 = r32;
        r24 = r33;
        r11 = r1;
        goto L110
    L136:
        r14.skipToGroupEnd();
        r12 = r26;
        r13 = r5;
        r15 = r6;
        r16 = r8;
        r20 = r32;
        r22 = r33;
        goto L137
    L92:
        r0 = false;
        goto L94
    L82:
        if ((r36 & 12582912) != 0) goto L90;
        if (r14.changedInstance(r34) == false) goto L86;
        int r112 = 8388608;
    L87:
        r1 = r1 | r112;
        goto L90
    L86:
        r112 = 4194304;
        goto L87
    L61:
        if ((196608 & r36) != 0) goto L69;
        if (r14.changed(r32) == false) goto L65;
        int r113 = 131072;
    L66:
        r1 = r1 | r113;
        goto L69
    L65:
        r113 = 65536;
        goto L66
    L49:
        if ((r37 & 16) != 0) goto L53;
        r8 = r30;
        if (r14.changed(r8) == false) goto L54;
        int r114 = 16384;
    L55:
        r1 = r1 | r114;
    L54:
        r114 = 8192;
        goto L55
    L53:
        r8 = r30;
        goto L54
    L38:
        if ((r37 & 8) != 0) goto L42;
        r6 = r28;
        if (r14.changed(r6) == false) goto L43;
        int r29 = 2048;
    L44:
        r1 = r1 | r29;
    L43:
        r29 = 1024;
        goto L44
    L42:
        r6 = r28;
        goto L43
    L28:
        if ((r36 & 384) != 0) goto L34;
        r5 = r27;
        if (r14.changed(r5) == false) goto L32;
        int r31 = 256;
    L33:
        r1 = r1 | r31;
        goto L36
    L32:
        r31 = 128;
        goto L33
    L17:
        if ((r36 & 48) != 0) goto L24;
        if (r14.changed(r26) == false) goto L21;
        int r38 = 32;
    L22:
        r1 = r1 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r1 = r36;
        goto L13
    L8:
        if (r14.changed(r25) == false) goto L10;
        int r39 = 4;
    L11:
        r1 = r39 | r36;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalDrawerSheet-Snr_uVM, reason: not valid java name */
    public static final void m2906ModalDrawerSheetSnr_uVM(final DrawerState r24, Modifier r25, Shape r26, long r27, long r29, float r31, WindowInsets r32, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r33, Composer r34, final int r35, final int r36) {
        Composer r14 = r34.startRestartGroup(-1620540727);
        if ((r36 & 1) == 0) goto L6;
        int r1 = r35 | 6;
    L13:
        int r2 = r36 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r35 & 384) == 0) goto L27;
        Shape r4 = r26;
    L36:
        if ((r35 & 3072) == 0) goto L38;
        long r5 = r27;
    L47:
        if ((r35 & 24576) == 0) goto L49;
        long r7 = r29;
    L57:
        int r9 = r36 & 32;
        if (r9 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        float r10 = r31;
    L69:
        if ((1572864 & r35) != 0) goto L80;
        if ((r36 & 64) != 0) goto L76;
        if (r14.changed(r32) == false) goto L76;
        int r16 = 1048576;
    L77:
        r1 = r1 | r16;
    L76:
        r16 = 524288;
    L80:
        if ((r36 & 128) == 0) goto L83;
        r1 = r1 | 12582912;
    L91:
        if ((r1 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r14.shouldExecute(r0, r1 & 1) == false) goto L140;
        r14.startDefaults();
        if ((r35 & 1) != 0) goto L99;
    L115:
        if (r2 == 0) goto L117;
        Modifier r3 = Modifier.Companion;
    L119:
        if ((r36 & 4) == 0) goto L122;
        r1 = r1 & (-897);
        r4 = DrawerDefaults.INSTANCE.getShape(r14, 6);
    L122:
        if ((r36 & 8) == 0) goto L125;
        r5 = DrawerDefaults.INSTANCE.getModalContainerColor(r14, 6);
        r1 = r1 & (-7169);
    L125:
        if ((r36 & 16) == 0) goto L127;
        r7 = ColorSchemeKt.m2496contentColorForek8zF_U(r5, r14, (r1 >> 9) & 14);
        r1 = r1 & (-57345);
    L127:
        if (r9 == 0) goto L130;
        r10 = DrawerDefaults.INSTANCE.m2644getModalDrawerElevationD9Ej5fM();
    L130:
        if ((r36 & 64) == 0) goto L132;
        r1 = r1 & (-3670017);
        Modifier r15 = r3;
        WindowInsets r23 = DrawerDefaults.INSTANCE.getWindowInsets(r14, 6);
    L114:
        Shape r17 = r4;
        long r18 = r5;
        long r20 = r7;
        float r22 = r10;
        int r11 = r1;
        r14.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L136;
        ComposerKt.traceEventStart(-1620540727, r11, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:641)");
    L136:
        DrawerPredictiveBackHandler(r24, ComposableLambdaKt.rememberComposableLambda(797187326, true, new NavigationDrawerKt$ModalDrawerSheet$2(r23, r15, r17, r18, r20, r22, r24, r33), r14, 54), r14, (r11 & 14) | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventEnd();
    L139:
        final Modifier r6 = r15;
        final Shape r8 = r17;
        final long r12 = r18;
        final long r13 = r20;
        final float r19 = r22;
        final WindowInsets r21 = r23;
    L141:
        ScopeUpdateScope r110 = r14.endRestartGroup();
        if (r110 == null) goto L145;
        r110.updateScope(new bg(r24, r6, r8, r12, r13, r19, r21, r33, r35, r36));
        return;
    L145:
        return;
    L132:
        r23 = r32;
        r15 = r3;
        goto L114
    L117:
        r3 = r25;
        goto L119
    L99:
        if (r14.getDefaultsInvalid() == true) goto L115;
        r14.skipToGroupEnd();
        if ((r36 & 4) == 0) goto L105;
        r1 = r1 & (-897);
    L105:
        if ((r36 & 8) == 0) goto L108;
        r1 = r1 & (-7169);
    L108:
        if ((r36 & 16) == 0) goto L111;
        r1 = r1 & (-57345);
    L111:
        if ((r36 & 64) == 0) goto L113;
        r1 = r1 & (-3670017);
    L113:
        r15 = r25;
        r23 = r32;
        goto L114
    L140:
        r14.skipToGroupEnd();
        r6 = r25;
        r21 = r32;
        r8 = r4;
        r12 = r5;
        r13 = r7;
        r19 = r10;
        goto L141
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r35 & 12582912) != 0) goto L91;
        if (r14.changedInstance(r33) == false) goto L87;
        int r111 = 8388608;
    L88:
        r1 = r1 | r111;
        goto L91
    L87:
        r111 = 4194304;
        goto L88
    L61:
        if ((196608 & r35) != 0) goto L67;
        r10 = r31;
        if (r14.changed(r10) == false) goto L65;
        int r112 = 131072;
    L66:
        r1 = r1 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L49:
        if ((r36 & 16) != 0) goto L53;
        r7 = r29;
        if (r14.changed(r7) == false) goto L54;
        int r28 = 16384;
    L55:
        r1 = r1 | r28;
    L54:
        r28 = 8192;
        goto L55
    L53:
        r7 = r29;
        goto L54
    L38:
        if ((r36 & 8) != 0) goto L42;
        r5 = r27;
        if (r14.changed(r5) == false) goto L43;
        int r30 = 2048;
    L44:
        r1 = r1 | r30;
    L43:
        r30 = 1024;
        goto L44
    L42:
        r5 = r27;
        goto L43
    L27:
        if ((r36 & 4) != 0) goto L31;
        r4 = r26;
        if (r14.changed(r4) == false) goto L32;
        int r37 = 256;
    L33:
        r1 = r1 | r37;
    L32:
        r37 = 128;
        goto L33
    L31:
        r4 = r26;
        goto L32
    L17:
        if ((r35 & 48) != 0) goto L25;
        if (r14.changed(r25) == false) goto L21;
        int r38 = 32;
    L22:
        r1 = r1 | r38;
        goto L25
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r1 = r35;
        goto L13
    L8:
        if (r14.changed(r24) == false) goto L10;
        int r39 = 4;
    L11:
        r1 = r39 | r35;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DrawerSheet-cm3T3N0, reason: not valid java name */
    public static final void m2905DrawerSheetcm3T3N0(final DrawerPredictiveBackState r32, final WindowInsets r33, Modifier r34, Shape r35, long r36, long r38, float r40, FloatProducer r41, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r42, Composer r43, final int r44, final int r45) {
        Composer r3 = r43.startRestartGroup(1560288494);
        if ((r45 & 1) == 0) goto L6;
        int r4 = r44 | 6;
    L14:
        if ((r45 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r6 = r45 & 4;
        if (r6 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Modifier r7 = r34;
    L35:
        int r8 = r45 & 8;
        if (r8 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Shape r9 = r35;
    L47:
        if ((r44 & 24576) == 0) goto L49;
        long r10 = r36;
    L58:
        if ((196608 & r44) == 0) goto L60;
        long r14 = r38;
    L68:
        int r16 = r45 & 64;
        if (r16 == 0) goto L72;
        r4 = r4 | 1572864;
    L79:
        if ((r44 & 12582912) != 0) goto L91;
        if ((r45 & 128) == 0) goto L83;
    L88:
        int r2 = 4194304;
    L89:
        r4 = r4 | r2;
        goto L91
    L83:
        if ((16777216 & r44) != 0) goto L85;
        boolean r5 = r3.changed(r41);
    L86:
        if (r5 == false) goto L88;
        r2 = 8388608;
        goto L89
    L85:
        r5 = r3.changedInstance(r41);
    L91:
        if ((r45 & 256) == 0) goto L94;
        r4 = r4 | 100663296;
    L102:
        if ((r4 & 38347923) == 38347922) goto L104;
        boolean r0 = true;
    L106:
        if (r3.shouldExecute(r0, r4 & 1) == false) goto L157;
        r3.startDefaults();
        if ((r44 & 1) != 0) goto L110;
    L124:
        if (r6 == 0) goto L126;
        r7 = Modifier.Companion;
    L126:
        if (r8 == 0) goto L129;
        r9 = RectangleShapeKt.getRectangleShape();
    L129:
        if ((r45 & 16) == 0) goto L132;
        r10 = DrawerDefaults.INSTANCE.getStandardContainerColor(r3, 6);
        r4 = r4 & (-57345);
    L132:
        if ((r45 & 32) == 0) goto L134;
        r14 = ColorSchemeKt.m2496contentColorForek8zF_U(r10, r3, (r4 >> 12) & 14);
        r4 = r4 & (-458753);
    L134:
        if (r16 == 0) goto L136;
        float r1 = DrawerDefaults.INSTANCE.m2645getPermanentDrawerElevationD9Ej5fM();
    L138:
        if ((r45 & 128) != 0) goto L139;
    L122:
        FloatProducer r11 = r41;
    L123:
        long r27 = r14;
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L146;
        ComposerKt.traceEventStart(1560288494, r4, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:796)");
    L146:
        Density r12 = (Density) r3.consume(CompositionLocalsKt.getLocalDensity());
        final float r13 = NavigationDrawerTokens.INSTANCE.getContainerWidth-D9Ej5fM();
        final float r15 = r12.toPx-0680j_4(r13);
        if (r3.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L149;
        boolean r17 = true;
    L150:
        if (r32 == null) goto L152;
        Modifier r18 = predictiveBackDrawerContainer(Modifier.Companion, r32, r17);
    L153:
        Modifier r37 = r7;
        Modifier r29 = r7;
        Modifier r19 = SizeKt.fillMaxHeight$default(horizontalScaleUp(SizeKt.m1018sizeInqDBjuR0$default(r37, MinimumDrawerWidth, MenuKt.ClosedAlphaTarget, r13, MenuKt.ClosedAlphaTarget, 10, null), r11, r15, r17).then(r18), MenuKt.ClosedAlphaTarget, 1, null);
        final boolean r39 = r17;
        final FloatProducer r310 = r11;
        ComposableLambda r23 = ComposableLambdaKt.rememberComposableLambda(-315420087, true, new NavigationDrawerKt$DrawerSheet$2(r32, r39, r13, r310, r15, r33, r42), r3, 54);
        int r20 = r4 >> 6;
        Shape r110 = r9;
        long r111 = r10;
        float r21 = r1;
        SurfaceKt.m3213SurfaceT9BRK9s(r19, r110, r111, r27, r21, MenuKt.ClosedAlphaTarget, null, r23, r3, ((((r20 & 112) | 12582912) | (r20 & 896)) | (r20 & 7168)) | (r20 & 57344), 96);
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventEnd();
    L156:
        final Shape r22 = r9;
        r7 = r29;
        final float r24 = r1;
        long r30 = r10;
        final FloatProducer r112 = r11;
        final long r25 = r30;
    L158:
        ScopeUpdateScope r113 = r3.endRestartGroup();
        if (r113 == null) goto L162;
        final Modifier r26 = r7;
        final long r28 = r27;
        r113.updateScope(new ng(r32, r33, r26, r22, r25, r28, r24, r112, r42, r44, r45));
        return;
    L162:
        return;
    L152:
        r18 = Modifier.Companion;
        goto L153
    L149:
        r17 = false;
        goto L150
    L139:
        Object r31 = r3.rememberedValue();
        if (r31 != Composer.Companion.getEmpty()) goto L142;
        r31 = new mg();
        r3.updateRememberedValue(r31);
    L142:
        r11 = (FloatProducer) r31;
        r4 = r4 & (-29360129);
        goto L123
    L136:
        r1 = r40;
        goto L138
    L110:
        if (r3.getDefaultsInvalid() == true) goto L124;
        r3.skipToGroupEnd();
        if ((r45 & 16) == 0) goto L116;
        r4 = r4 & (-57345);
    L116:
        if ((r45 & 32) == 0) goto L119;
        r4 = r4 & (-458753);
    L119:
        if ((r45 & 128) == 0) goto L121;
        r4 = r4 & (-29360129);
    L121:
        r1 = r40;
        goto L122
    L157:
        r3.skipToGroupEnd();
        r22 = r9;
        r25 = r10;
        r27 = r14;
        r24 = r40;
        r112 = r41;
        goto L158
    L104:
        r0 = false;
        goto L106
    L94:
        if ((r44 & 100663296) != 0) goto L102;
        if (r3.changedInstance(r42) == false) goto L98;
        int r114 = 67108864;
    L99:
        r4 = r4 | r114;
        goto L102
    L98:
        r114 = 33554432;
        goto L99
    L72:
        if ((r44 & 1572864) != 0) goto L79;
        if (r3.changed(r40) == false) goto L76;
        int r115 = 1048576;
    L77:
        r4 = r4 | r115;
        goto L79
    L76:
        r115 = 524288;
        goto L77
    L60:
        if ((r45 & 32) != 0) goto L64;
        r14 = r38;
        if (r3.changed(r14) == false) goto L65;
        int r116 = 131072;
    L66:
        r4 = r4 | r116;
    L65:
        r116 = 65536;
        goto L66
    L64:
        r14 = r38;
        goto L65
    L49:
        if ((r45 & 16) != 0) goto L53;
        r10 = r36;
        if (r3.changed(r10) == false) goto L54;
        int r117 = 16384;
    L55:
        r4 = r4 | r117;
    L54:
        r117 = 8192;
        goto L55
    L53:
        r10 = r36;
        goto L54
    L39:
        if ((r44 & 3072) != 0) goto L45;
        r9 = r35;
        if (r3.changed(r9) == false) goto L43;
        int r118 = 2048;
    L44:
        r4 = r4 | r118;
        goto L47
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r44 & 384) != 0) goto L34;
        r7 = r34;
        if (r3.changed(r7) == false) goto L32;
        int r46 = 256;
    L33:
        r4 = r4 | r46;
        goto L35
    L32:
        r46 = 128;
        goto L33
    L17:
        if ((r44 & 48) != 0) goto L24;
        if (r3.changed(r33) == false) goto L21;
        int r47 = 32;
    L22:
        r4 = r4 | r47;
        goto L24
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r44 & 6) == 0) goto L8;
        r4 = r44;
        goto L14
    L8:
        if (r3.changed(r32) == false) goto L10;
        int r48 = 4;
    L11:
        r4 = r48 | r44;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }

    public static final void NavigationDrawerItem(final Function2<? super Composer, ? super Integer, Unit> r35, final boolean r36, final Function0<Unit> r37, Modifier r38, Function2<? super Composer, ? super Integer, Unit> r39, Function2<? super Composer, ? super Integer, Unit> r40, Shape r41, NavigationDrawerItemColors r42, MutableInteractionSource r43, Composer r44, final int r45, final int r46) {
        Composer r1 = r44.startRestartGroup(-583709666);
        if ((r46 & 1) == 0) goto L6;
        int r2 = r45 | 6;
    L14:
        if ((r46 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r46 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L33:
        int r5 = r46 & 8;
        if (r5 == 0) goto L37;
        r2 = r2 | 3072;
    L44:
        int r7 = r46 & 16;
        if (r7 == 0) goto L48;
        r2 = r2 | 24576;
    L55:
        int r9 = r46 & 32;
        if (r9 == 0) goto L59;
        r2 = r2 | 196608;
    L65:
        Function2<? super Composer, ? super Integer, Unit> r10 = r40;
    L67:
        if ((1572864 & r45) == 0) goto L69;
        Shape r15 = r41;
    L78:
        if ((r45 & 12582912) != 0) goto L88;
        if ((r46 & 128) != 0) goto L85;
        if (r1.changed(r42) == false) goto L85;
        int r16 = 8388608;
    L86:
        r2 = r2 | r16;
    L85:
        r16 = 4194304;
    L88:
        int r0 = r46 & 256;
        if (r0 == 0) goto L92;
        r2 = r2 | 100663296;
    L99:
        if ((r2 & 38347923) == 38347922) goto L101;
        boolean r3 = true;
    L103:
        if (r1.shouldExecute(r3, r2 & 1) == false) goto L147;
        r1.startDefaults();
        if ((r45 & 1) != 0) goto L107;
    L117:
        if (r5 == 0) goto L119;
        Modifier r4 = Modifier.Companion;
    L120:
        if (r7 == 0) goto L122;
        Function2<? super Composer, ? super Integer, Unit> r6 = null;
    L123:
        if (r9 == 0) goto L126;
        r10 = null;
    L126:
        if ((r46 & 64) == 0) goto L128;
        Shape r8 = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), r1, 6);
        r2 = r2 & (-3670017);
    L130:
        if ((r46 & 128) == 0) goto L132;
        NavigationDrawerItemColors r11 = NavigationDrawerItemDefaults.INSTANCE.m2902colorsoq7We08(0, 0, 0, 0, 0, 0, 0, 0, r1, 100663296, 255);
        r2 = r2 & (-29360129);
    L133:
        if (r0 == 0) goto L135;
        MutableInteractionSource r21 = null;
    L136:
        NavigationDrawerItemColors r17 = r11;
        Function2<? super Composer, ? super Integer, Unit> r19 = r10;
    L116:
        int r12 = r2;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L140;
        ComposerKt.traceEventStart(-583709666, r12, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1077)");
    L140:
        Object r13 = r1.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L143;
        r13 = new eh();
        r1.updateRememberedValue(r13);
    L143:
        int r18 = r12 >> 3;
        int r110 = r18 & 14;
        final Function2<? super Composer, ? super Integer, Unit> r310 = r6;
        final NavigationDrawerItemColors r47 = r17;
        final Function2<? super Composer, ? super Integer, Unit> r48 = r19;
        NavigationDrawerItemColors r22 = r17;
        Modifier r23 = r4;
        Composer r26 = r1;
        SurfaceKt.m3214Surfaced85dljk(r36, r37, SizeKt.fillMaxWidth$default(SizeKt.m1002heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(r4, false, (Function1) r13, 1, null), NavigationDrawerTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM(), MenuKt.ClosedAlphaTarget, 2, null), MenuKt.ClosedAlphaTarget, 1, null), false, r8, ((Color) r17.containerColor(r36, r1, r110 | ((r12 >> 18) & 112)).getValue()).unbox-impl(), 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, r21, ComposableLambdaKt.rememberComposableLambda(-1173018444, true, new AnonymousClass2(r310, r47, r36, r48, r35), r1, 54), r26, (r110 | (r18 & 112)) | ((r12 >> 6) & 57344), ((r12 >> 24) & 14) | 48, 968);
        if (ComposerKt.isTraceInProgress() == false) goto L146;
        ComposerKt.traceEventEnd();
    L146:
        final Function2<? super Composer, ? super Integer, Unit> r14 = r6;
        final Function2<? super Composer, ? super Integer, Unit> r20 = r19;
        final Shape r24 = r8;
        final MutableInteractionSource r25 = r21;
        final NavigationDrawerItemColors r27 = r22;
        final Modifier r28 = r23;
    L148:
        ScopeUpdateScope r111 = r26.endRestartGroup();
        if (r111 == null) goto L152;
        r111.updateScope(new fh(r35, r36, r37, r28, r14, r20, r24, r27, r25, r45, r46));
        return;
    L152:
        return;
    L135:
        r21 = r43;
        goto L136
    L132:
        r11 = r42;
        goto L133
    L128:
        r8 = r15;
        goto L130
    L122:
        r6 = r39;
        goto L123
    L119:
        r4 = r38;
        goto L120
    L107:
        if (r1.getDefaultsInvalid() == true) goto L117;
        r1.skipToGroupEnd();
        if ((r46 & 64) == 0) goto L113;
        r2 = r2 & (-3670017);
    L113:
        if ((r46 & 128) == 0) goto L115;
        r2 = r2 & (-29360129);
    L115:
        r4 = r38;
        r6 = r39;
        r21 = r43;
        r19 = r10;
        r8 = r15;
        r17 = r42;
        goto L116
    L147:
        r26 = r1;
        r26.skipToGroupEnd();
        r28 = r38;
        r14 = r39;
        r27 = r42;
        r25 = r43;
        r20 = r10;
        r24 = r15;
        goto L148
    L101:
        r3 = false;
        goto L103
    L92:
        if ((r45 & 100663296) != 0) goto L99;
        if (r1.changed(r43) == false) goto L96;
        int r112 = 67108864;
    L97:
        r2 = r2 | r112;
        goto L99
    L96:
        r112 = 33554432;
        goto L97
    L69:
        if ((r46 & 64) != 0) goto L73;
        r15 = r41;
        if (r1.changed(r15) == false) goto L74;
        int r113 = 1048576;
    L75:
        r2 = r2 | r113;
    L74:
        r113 = 524288;
        goto L75
    L73:
        r15 = r41;
        goto L74
    L59:
        if ((196608 & r45) != 0) goto L65;
        r10 = r40;
        if (r1.changedInstance(r10) == false) goto L63;
        int r114 = 131072;
    L64:
        r2 = r2 | r114;
        goto L67
    L63:
        r114 = 65536;
        goto L64
    L48:
        if ((r45 & 24576) != 0) goto L55;
        if (r1.changedInstance(r39) == false) goto L52;
        int r29 = 16384;
    L53:
        r2 = r2 | r29;
        goto L55
    L52:
        r29 = 8192;
        goto L53
    L37:
        if ((r45 & 3072) != 0) goto L44;
        if (r1.changed(r38) == false) goto L41;
        int r30 = 2048;
    L42:
        r2 = r2 | r30;
        goto L44
    L41:
        r30 = 1024;
        goto L42
    L27:
        if ((r45 & 384) != 0) goto L33;
        if (r1.changedInstance(r37) == false) goto L31;
        int r31 = 256;
    L32:
        r2 = r2 | r31;
        goto L33
    L31:
        r31 = 128;
        goto L32
    L17:
        if ((r45 & 48) != 0) goto L24;
        if (r1.changed(r36) == false) goto L21;
        int r32 = 32;
    L22:
        r2 = r2 | r32;
        goto L24
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r2 = r45;
        goto L14
    L8:
        if (r1.changedInstance(r35) == false) goto L10;
        int r33 = 4;
    L11:
        r2 = r33 | r45;
        goto L14
    L10:
        r33 = 2;
        goto L11
    }
}
