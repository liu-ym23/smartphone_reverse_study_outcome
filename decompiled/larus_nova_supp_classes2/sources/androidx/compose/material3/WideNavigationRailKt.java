package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.NavigationRailHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001as\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001am\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\u0017\u001a\u009d\u0001\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b \u0010!\u001a\u0089\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010'\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\b\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0004\b.\u0010/\u001aÖ\u0001\u00100\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0006\u00106\u001a\u00020721\u00108\u001a-\b\u0001\u0012\u0013\u0012\u001104¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010=\u0012\u0006\u0012\u0004\u0018\u00010>092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u001d2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\bC\u0010D\u001a\u001c\u0010E\u001a\u000204*\u00020F2\u0006\u0010G\u001a\u0002042\u0006\u0010H\u001a\u00020\u0015H\u0002\u001a\u0014\u0010I\u001a\u000204*\u00020F2\u0006\u0010G\u001a\u000204H\u0002\u001a=\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2\u001c\u0010M\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010=\u0012\u0006\u0012\u0004\u0018\u00010>0N2\u0006\u0010O\u001a\u00020\u0015H\u0003¢\u0006\u0004\bP\u0010Q\"\u0016\u0010R\u001a\u00020\u001dX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010T\"\u0010\u0010V\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010W\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010X\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010Y\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010Z\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010[\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010\\\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010]\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010^\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010_\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010`\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010a\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u000e\u0010b\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020dX\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020g0fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010i\"\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020k0fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010i¨\u0006m²\u0006\n\u0010n\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010q\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010r\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010s\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010u\u001a\u000204X\u008a\u0084\u0002²\u0006\n\u0010v\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"WideNavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/WideNavigationRailState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", WideNavigationRailKt.HeaderLayoutIdTag, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WideNavigationRailLayout", "isModal", "", "expanded", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ModalWideNavigationRail", "hideOnCollapse", "collapsedShape", "expandedShape", "expandedHeaderTopPadding", "Landroidx/compose/ui/unit/Dp;", "expandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRail-k3FuEkE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "WideNavigationRailItem", "selected", "onClick", "icon", "label", "railExpanded", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "WideNavigationRailItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ModalWideNavigationRailContent", "isStandaloneModal", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "settleToDismiss", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "velocity", "Lkotlin/coroutines/Continuation;", "", "railState", "Landroidx/compose/material3/ModalWideNavigationRailState;", "openModalRailMaxWidth", "gesturesEnabled", "ModalWideNavigationRailContent-pU6N4AM", "(ZZLandroidx/compose/animation/core/Animatable;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ModalWideNavigationRailState;Landroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;FLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "swipeEdgeMatchesRail", "calculatePredictiveBackScaleY", "Scrim", "color", "Landroidx/compose/ui/graphics/Color;", "onDismissRequest", "Lkotlin/Function1;", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "WNRItemNoLabelIndicatorPadding", "getWNRItemNoLabelIndicatorPadding", "()F", "F", "ItemHorizontalPadding", "WNRVerticalPadding", "WNRHeaderPadding", "CollapsedRailWidth", "ExpandedRailMinWidth", "ExpandedRailMaxWidth", "TopIconItemMinHeight", "ItemTopIconIndicatorVerticalPadding", "ItemTopIconIndicatorHorizontalPadding", "ItemStartIconIndicatorVerticalPadding", "PredictiveBackMaxScaleXDistance", "PredictiveBackMaxScaleYDistance", "PredictiveBackPivotFractionY", "HeaderLayoutIdTag", "", "LocalWideNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/WideNavigationRailOverride;", "getLocalWideNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalModalWideNavigationRailOverride", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "getLocalModalWideNavigationRailOverride", "material3", "currentWidth", "", "actualMaxExpandedWidth", "minWidth", "widthFullRange", "itemVerticalSpacedBy", "itemMinHeight", "alpha", "dismiss"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailKt {
    private static final float CollapsedRailWidth = 0.0f;
    private static final float ExpandedRailMaxWidth = 0.0f;
    private static final float ExpandedRailMinWidth = 0.0f;
    private static final String HeaderLayoutIdTag = "header";
    private static final float ItemHorizontalPadding = 0.0f;
    private static final float ItemStartIconIndicatorVerticalPadding = 0.0f;
    private static final float ItemTopIconIndicatorHorizontalPadding = 0.0f;
    private static final float ItemTopIconIndicatorVerticalPadding = 0.0f;
    private static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> LocalModalWideNavigationRailOverride = null;
    private static final ProvidableCompositionLocal<WideNavigationRailOverride> LocalWideNavigationRailOverride = null;
    private static final float PredictiveBackMaxScaleXDistance = 0.0f;
    private static final float PredictiveBackMaxScaleYDistance = 0.0f;
    private static final float PredictiveBackPivotFractionY = 0.5f;
    private static final float TopIconItemMinHeight = 0.0f;
    private static final float WNRHeaderPadding = 0.0f;
    private static final float WNRItemNoLabelIndicatorPadding = 0.0f;
    private static final float WNRVerticalPadding = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MutableIntState $actualMaxExpandedWidth$delegate;
        final /* synthetic */ Arrangement.Vertical $arrangement;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ MutableIntState $currentWidth$delegate;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Function2<Composer, Integer, Unit> $header;
        final /* synthetic */ State<Dp> $itemMinHeight$delegate;
        final /* synthetic */ State<Dp> $itemVerticalSpacedBy$delegate;
        final /* synthetic */ State<Dp> $minWidth$delegate;
        final /* synthetic */ float $minimumA11ySize;
        final /* synthetic */ State<Dp> $widthFullRange$delegate;
        final /* synthetic */ WindowInsets $windowInsets;

        /* JADX INFO: renamed from: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/compose/material3/WideNavigationRailKt$WideNavigationRailLayout$1$2", "Landroidx/compose/ui/layout/MeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass2 implements MeasurePolicy {
            final /* synthetic */ MutableIntState $actualMaxExpandedWidth$delegate;
            final /* synthetic */ Arrangement.Vertical $arrangement;
            final /* synthetic */ MutableIntState $currentWidth$delegate;
            final /* synthetic */ boolean $expanded;
            final /* synthetic */ Function2<Composer, Integer, Unit> $header;
            final /* synthetic */ State<Dp> $itemMinHeight$delegate;
            final /* synthetic */ State<Dp> $itemVerticalSpacedBy$delegate;
            final /* synthetic */ State<Dp> $minWidth$delegate;
            final /* synthetic */ float $minimumA11ySize;
            final /* synthetic */ State<Dp> $widthFullRange$delegate;

            public static /* synthetic */ Unit a(Placeable.PlacementScope r0) {
                return measure_3p2s80s$lambda$0(r0);
            }

            public static /* synthetic */ Unit b(int r0, MeasureScope r1, Ref.ObjectRef r2, List r3, Arrangement.Vertical r4, State r5, Placeable.PlacementScope r6) {
                return measure_3p2s80s$lambda$6(r0, r1, r2, r3, r4, r5, r6);
            }

            public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
                return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
            }

            public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
                return MeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
            }

            public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
                return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
            }

            public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
                return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
            }

            private static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope r0) {
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
            public MeasureResult m3622measure3p2s80s(final MeasureScope r28, List<? extends Measurable> r29, long r30) {
                List<? extends Measurable> r1 = r29;
                final int r9 = Constraints.getMaxHeight-impl(r30);
                int r2 = r29.size();
                int r3 = Constraints.getMinWidth-impl(r30);
                if (Constraints.getMinWidth-impl(r30) != 0) goto L5;
                r3 = RangesKt.coerceAtMost(r28.roundToPx-0680j_4(WideNavigationRailKt.access$getExpandedRailMinWidth$p()), Constraints.getMaxWidth-impl(r30));
                int r4 = RangesKt.coerceAtMost(r28.roundToPx-0680j_4(WideNavigationRailKt.access$WideNavigationRailLayout$lambda$8(this.$minWidth$delegate)), Constraints.getMaxWidth-impl(r30));
            L7:
                if (r2 < 1) goto L9;
                long r6 = Constraints.copy-Zbe2FdA$default(r30, 0, 0, 0, 0, 10, null);
                Ref.ObjectRef r10 = new Ref.ObjectRef();
                if (this.$header == null) goto L23;
                int r11 = r1.size();
                int r13 = 0;
            L13:
                if (r13 >= r11) goto L21;
                Measurable r14 = (Measurable) ListProtector.get(r1, r13);
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r14), WideNavigationRailKt.HeaderLayoutIdTag) == true) goto L16;
                r13 = r13 + 1;
                goto L13
            L16:
                r10.element = r14.measure-BRTryo0(r6);
                if (r2 <= 1) goto L19;
                r1 = r1.subList(1, r2);
            L19:
                r2 = r2 - 1;
                int r5 = ((Placeable) r10.element).getHeight();
            L24:
                if (r2 <= 0) goto L26;
                ArrayList r7 = new ArrayList();
            L27:
                final ArrayList r12 = r7;
                if (this.$expanded == false) goto L30;
                int r8 = Constraints.getMaxWidth-impl(r6);
            L31:
                if (r12 == null) goto L40;
                float r15 = this.$minimumA11ySize;
                boolean r16 = this.$expanded;
                State<Dp> r17 = this.$itemMinHeight$delegate;
                int r210 = r5;
                ArrayList r18 = new ArrayList(r1.size());
                int r19 = r1.size();
                int r20 = 0;
                int r21 = 0;
                int r22 = r210;
            L33:
                if (r20 >= r19) goto L39;
                List<? extends Measurable> r211 = r1;
                Measurable r23 = (Measurable) ListProtector.get(r1, r20);
                Ref.ObjectRef r26 = r10;
                long r24 = ConstraintsKt.offset-NN6Ew-U$default(r6, 0, -r22, 1, null);
                int r110 = r19;
                float r111 = r15;
                State<Dp> r25 = r17;
                long r27 = r6;
                Placeable r0 = r23.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r24, Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(r28.roundToPx-0680j_4(r15), r8, r28.roundToPx-0680j_4(WideNavigationRailKt.access$WideNavigationRailLayout$lambda$11(r17)), Constraints.getMaxHeight-impl(r6))));
                int r31 = r0.getMeasuredWidth();
                if (r16 == false) goto L38;
                if (r21 >= r31) goto L38;
                r21 = r28.roundToPx-0680j_4(WideNavigationRailKt.access$getItemHorizontalPadding$p()) + r31;
            L38:
                r22 = r0.getHeight();
                r18.add(Boolean.valueOf(r12.add(r0)));
                r20 = r20 + 1;
                r1 = r211;
                r19 = r110;
                r15 = r111;
                r17 = r25;
                r6 = r27;
                r10 = r26;
                goto L33
            L39:
                Ref.ObjectRef r212 = r10;
            L42:
                if (this.$expanded == false) goto L52;
                Ref.ObjectRef r32 = r212;
                Placeable r33 = (Placeable) r32.element;
                if (r33 == null) goto L46;
                int r112 = r33.getWidth();
            L47:
                int r34 = Math.max(r21, r112);
                int r35 = r4;
                if (r34 <= r35) goto L56;
                int r36 = r3;
                if (r34 <= r36) goto L56;
                int r37 = RangesKt.coerceAtMost(r28.roundToPx-0680j_4(WideNavigationRailKt.access$WideNavigationRailLayout$lambda$9(this.$widthFullRange$delegate)), RangesKt.coerceAtMost(Math.max(r34, r36), Constraints.getMaxWidth-impl(r30)));
                WideNavigationRailKt.access$WideNavigationRailLayout$lambda$7(this.$actualMaxExpandedWidth$delegate, r37);
            L55:
                int r38 = r37;
            L57:
                WideNavigationRailKt.access$WideNavigationRailLayout$lambda$4(this.$currentWidth$delegate, r38);
                final Arrangement.Vertical r39 = this.$arrangement;
                final State<Dp> r40 = this.$itemVerticalSpacedBy$delegate;
                final Ref.ObjectRef r41 = r32;
                return MeasureScope.-CC.layout$default(r28, r38, r9, null, new oy(r9, r28, r41, r12, r39, r40), 4, null);
            L56:
                r38 = r35;
                goto L57
            L46:
                r112 = 0;
                goto L47
            L52:
                r35 = r4;
                r32 = r212;
                if (WideNavigationRailKt.access$WideNavigationRailLayout$lambda$6(this.$actualMaxExpandedWidth$delegate) <= 0) goto L56;
                r37 = RangesKt.coerceIn(r28.roundToPx-0680j_4(WideNavigationRailKt.access$WideNavigationRailLayout$lambda$9(this.$widthFullRange$delegate)), r35, RangesKt.coerceAtLeast(WideNavigationRailKt.access$WideNavigationRailLayout$lambda$3(this.$currentWidth$delegate), r35));
                goto L55
            L40:
                r212 = r10;
                r21 = 0;
                goto L42
            L30:
                r8 = r4;
                goto L31
            L26:
                r7 = null;
                goto L27
            L21:
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            L23:
                r5 = 0;
                goto L24
            L9:
                return MeasureScope.-CC.layout$default(r28, r4, r9, null, new ny(), 4, null);
            L5:
                r4 = Constraints.getMinWidth-impl(r30);
                goto L7
            }

            private static final Unit measure_3p2s80s$lambda$6(int r9, MeasureScope r10, Ref.ObjectRef r11, List r12, Arrangement.Vertical r13, State r14, Placeable.PlacementScope r15) {
                int r16 = r9 - r10.roundToPx-0680j_4(WideNavigationRailKt.access$getWNRVerticalPadding$p());
                Object r0 = r11.element;
                int r1 = 0;
                if (r0 != null) goto L5;
            L7:
                int r17 = 0;
            L8:
                if (r12 == null) goto L26;
                if (Intrinsics.areEqual(r13, Arrangement.INSTANCE.getCenter()) == true) goto L13;
                r16 = r16 - r17;
            L13:
                int[] r2 = new int[r12.size()];
                List r3 = r12;
                int r4 = r3.size();
                int r5 = 0;
            L14:
                if (r5 >= r4) goto L19;
                r2[r5] = ((Placeable) ListProtector.get(r12, r5)).getHeight();
                if (r5 >= (r12.size() - 1)) goto L18;
                r2[r5] = r2[r5] + r10.roundToPx-0680j_4(WideNavigationRailKt.access$WideNavigationRailLayout$lambda$10(r14));
            L18:
                r5 = r5 + 1;
                goto L14
            L19:
                int[] r18 = new int[r12.size()];
                r13.arrange(r10, r16, r2, r18);
                if (Intrinsics.areEqual(r13, Arrangement.INSTANCE.getCenter()) == false) goto L22;
                r17 = 0;
            L22:
                int r19 = r3.size();
            L23:
                if (r1 >= r19) goto L26;
                Placeable.PlacementScope.placeRelative$default(r15, (Placeable) ListProtector.get(r12, r1), 0, r18[r1] + r17, MenuKt.ClosedAlphaTarget, 4, null);
                r1 = r1 + 1;
            L26:
                return Unit.INSTANCE;
            L5:
                if (((Placeable) r0).getHeight() <= 0) goto L7;
                Placeable.PlacementScope.placeRelative$default(r15, (Placeable) r11.element, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
                r17 = (((Placeable) r11.element).getHeight() + r10.roundToPx-0680j_4(WideNavigationRailKt.access$getWNRHeaderPadding$p())) + 0;
                goto L8
            }

            public AnonymousClass2(Function2<? super Composer, ? super Integer, Unit> r1, boolean r2, State<Dp> r3, float r4, State<Dp> r5, State<Dp> r6, MutableIntState r7, MutableIntState r8, Arrangement.Vertical r9, State<Dp> r10) {
                this.$header = r1;
                this.$expanded = r2;
                this.$minWidth$delegate = r3;
                this.$minimumA11ySize = r4;
                this.$itemMinHeight$delegate = r5;
                this.$widthFullRange$delegate = r6;
                this.$actualMaxExpandedWidth$delegate = r7;
                this.$currentWidth$delegate = r8;
                this.$arrangement = r9;
                this.$itemVerticalSpacedBy$delegate = r10;
            }
        }

        public AnonymousClass1(WindowInsets r1, Function2<? super Composer, ? super Integer, Unit> r2, boolean r3, State<Dp> r4, float r5, State<Dp> r6, State<Dp> r7, MutableIntState r8, MutableIntState r9, Arrangement.Vertical r10, State<Dp> r11, Function2<? super Composer, ? super Integer, Unit> r12) {
            this.$windowInsets = r1;
            this.$header = r2;
            this.$expanded = r3;
            this.$minWidth$delegate = r4;
            this.$minimumA11ySize = r5;
            this.$itemMinHeight$delegate = r6;
            this.$widthFullRange$delegate = r7;
            this.$actualMaxExpandedWidth$delegate = r8;
            this.$currentWidth$delegate = r9;
            this.$arrangement = r10;
            this.$itemVerticalSpacedBy$delegate = r11;
            this.$content = r12;
        }

        public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
            return invoke$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r1) {
            SemanticsPropertiesKt.setTraversalGroup(r1, true);
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r20, int r21) {
            if ((r21 & 3) == 2) goto L5;
            boolean r3 = true;
        L7:
            if (r20.shouldExecute(r3, r21 & 1) == true) goto L9;
            r20.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(-1489314345, r21, -1, "androidx.compose.material3.WideNavigationRailLayout.<anonymous> (WideNavigationRail.kt:258)");
        L11:
            Modifier.Companion r2 = Modifier.Companion;
            Modifier r4 = SelectableGroupKt.selectableGroup(PaddingKt.m964paddingqDBjuR0$default(SizeKt.m1021widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(r2, MenuKt.ClosedAlphaTarget, 1, null), this.$windowInsets), MenuKt.ClosedAlphaTarget, WideNavigationRailKt.access$getExpandedRailMaxWidth$p(), 1, null), MenuKt.ClosedAlphaTarget, WideNavigationRailKt.access$getWNRVerticalPadding$p(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 13, null));
            Object r8 = r20.rememberedValue();
            if (r8 != Composer.Companion.getEmpty()) goto L14;
            r8 = new my();
            r20.updateRememberedValue(r8);
        L14:
            Modifier r5 = SemanticsModifierKt.semantics$default(r4, false, (Function1) r8, 1, null);
            AnonymousClass2 r6 = new AnonymousClass2(this.$header, this.$expanded, this.$minWidth$delegate, this.$minimumA11ySize, this.$itemMinHeight$delegate, this.$widthFullRange$delegate, this.$actualMaxExpandedWidth$delegate, this.$currentWidth$delegate, this.$arrangement, this.$itemVerticalSpacedBy$delegate);
            Function2<Composer, Integer, Unit> r7 = this.$header;
            Function2<Composer, Integer, Unit> r9 = this.$content;
            int r10 = ComposablesKt.getCurrentCompositeKeyHash(r20, 0);
            CompositionLocalMap r11 = r20.getCurrentCompositionLocalMap();
            Modifier r12 = ComposedModifierKt.materializeModifier(r20, r5);
            ComposeUiNode.Companion r13 = ComposeUiNode.Companion;
            Function0 r14 = r13.getConstructor();
            if ((r20.getApplier() instanceof Applier) == true) goto L17;
            ComposablesKt.invalidApplier();
        L17:
            r20.startReusableNode();
            if (r20.getInserting() == false) goto L20;
            r20.createNode(r14);
        L21:
            Composer r15 = Updater.constructor-impl(r20);
            Updater.set-impl(r15, r6, r13.getSetMeasurePolicy());
            Updater.set-impl(r15, r11, r13.getSetResolvedCompositionLocals());
            Function2 r16 = r13.getSetCompositeKeyHash();
            if (r15.getInserting() == false) goto L24;
        L25:
            r15.updateRememberedValue(Integer.valueOf(r10));
            r15.apply(Integer.valueOf(r10), r16);
        L26:
            Updater.set-impl(r15, r12, r13.getSetModifier());
            if (r7 == null) goto L41;
            r20.startReplaceGroup(1714892004);
            Modifier r17 = LayoutIdKt.layoutId(r2, WideNavigationRailKt.HeaderLayoutIdTag);
            MeasurePolicy r18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            int r19 = ComposablesKt.getCurrentCompositeKeyHash(r20, 0);
            CompositionLocalMap r22 = r20.getCurrentCompositionLocalMap();
            Modifier r23 = ComposedModifierKt.materializeModifier(r20, r17);
            Function0 r24 = r13.getConstructor();
            if ((r20.getApplier() instanceof Applier) == true) goto L31;
            ComposablesKt.invalidApplier();
        L31:
            r20.startReusableNode();
            if (r20.getInserting() == false) goto L34;
            r20.createNode(r24);
        L35:
            Composer r25 = Updater.constructor-impl(r20);
            Updater.set-impl(r25, r18, r13.getSetMeasurePolicy());
            Updater.set-impl(r25, r22, r13.getSetResolvedCompositionLocals());
            Function2 r26 = r13.getSetCompositeKeyHash();
            if (r25.getInserting() == false) goto L38;
        L39:
            r25.updateRememberedValue(Integer.valueOf(r19));
            r25.apply(Integer.valueOf(r19), r26);
        L40:
            Updater.set-impl(r25, r23, r13.getSetModifier());
            BoxScopeInstance r27 = BoxScopeInstance.INSTANCE;
            r7.invoke(r20, 0);
            r20.endNode();
            r20.endReplaceGroup();
        L42:
            r9.invoke(r20, 0);
            r20.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L47;
            ComposerKt.traceEventEnd();
            return;
        L47:
            return;
        L38:
            if (Intrinsics.areEqual(r25.rememberedValue(), Integer.valueOf(r19)) == true) goto L40;
        L34:
            r20.useNode();
            goto L35
        L41:
            r20.startReplaceGroup(1714982338);
            r20.endReplaceGroup();
            goto L42
        L24:
            if (Intrinsics.areEqual(r15.rememberedValue(), Integer.valueOf(r10)) == true) goto L26;
        L20:
            r20.useNode();
            goto L21
        L5:
            r3 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    private static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$25(boolean r18, boolean r19, Animatable r20, RailPredictiveBackState r21, Function2 r22, Modifier r23, ModalWideNavigationRailState r24, WideNavigationRailColors r25, Shape r26, float r27, Function2 r28, WindowInsets r29, boolean r30, Arrangement.Vertical r31, Function2 r32, int r33, int r34, Composer r35, int r36) {
        m3617ModalWideNavigationRailContentpU6N4AM(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r35, RecomposeScopeImplKt.updateChangedFlags(r33 | 1), RecomposeScopeImplKt.updateChangedFlags(r34));
        return Unit.INSTANCE;
    }

    private static final Unit ModalWideNavigationRail_k3FuEkE$lambda$14(Modifier r17, WideNavigationRailState r18, boolean r19, Shape r20, Shape r21, WideNavigationRailColors r22, Function2 r23, float r24, WindowInsets r25, Arrangement.Vertical r26, ModalWideNavigationRailProperties r27, Function2 r28, int r29, int r30, int r31, Composer r32, int r33) {
        m3616ModalWideNavigationRailk3FuEkE(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_3J_VO9M$lambda$37(long r6, Function1 r8, boolean r9, int r10, Composer r11, int r12) {
        m3618Scrim3JVO9M(r6, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit WideNavigationRail$lambda$1(Modifier r12, WideNavigationRailState r13, Shape r14, WideNavigationRailColors r15, Function2 r16, WindowInsets r17, Arrangement.Vertical r18, Function2 r19, int r20, int r21, Composer r22, int r23) {
        WideNavigationRail(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit WideNavigationRailItem_pli_t6k$lambda$16(boolean r14, Function0 r15, Function2 r16, Function2 r17, boolean r18, Modifier r19, boolean r20, int r21, NavigationItemColors r22, MutableInteractionSource r23, int r24, int r25, Composer r26, int r27) {
        m3619WideNavigationRailItemplit6k(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit WideNavigationRailLayout$lambda$12(Modifier r12, boolean r13, boolean r14, WideNavigationRailColors r15, Shape r16, Function2 r17, WindowInsets r18, Arrangement.Vertical r19, Function2 r20, int r21, Composer r22, int r23) {
        WideNavigationRailLayout(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(long r0, State r2, DrawScope r3) {
        return Scrim_3J_VO9M$lambda$35$lambda$34(r0, r2, r3);
    }

    public static /* synthetic */ WideNavigationRailOverride b() {
        return LocalWideNavigationRailOverride$lambda$38();
    }

    public static /* synthetic */ Unit c(long r0, Function1 r2, boolean r3, int r4, Composer r5, int r6) {
        return Scrim_3J_VO9M$lambda$37(r0, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit d(Modifier r0, boolean r1, boolean r2, WideNavigationRailColors r3, Shape r4, Function2 r5, WindowInsets r6, Arrangement.Vertical r7, Function2 r8, int r9, Composer r10, int r11) {
        return WideNavigationRailLayout$lambda$12(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ boolean e(MutableState r0) {
        return Scrim_3J_VO9M$lambda$33$lambda$32$lambda$31(r0);
    }

    public static /* synthetic */ ModalWideNavigationRailOverride f() {
        return LocalModalWideNavigationRailOverride$lambda$39();
    }

    public static /* synthetic */ Unit g(Animatable r0, ModalWideNavigationRailState r1, RailPredictiveBackState r2, boolean r3, GraphicsLayerScope r4) {
        return ModalWideNavigationRailContent_pU6N4AM$lambda$20$lambda$19(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Pair h(boolean r0, boolean r1, ModalWideNavigationRailState r2, IntSize r3, Constraints r4) {
        return ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit i(boolean r0, Function0 r1, Function2 r2, Function2 r3, boolean r4, Modifier r5, boolean r6, int r7, NavigationItemColors r8, MutableInteractionSource r9, int r10, int r11, Composer r12, int r13) {
        return WideNavigationRailItem_pli_t6k$lambda$16(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit j(String r0, SemanticsPropertyReceiver r1) {
        return ModalWideNavigationRailContent_pU6N4AM$lambda$18$lambda$17(r0, r1);
    }

    public static /* synthetic */ Unit k(Modifier r1, WideNavigationRailState r2, boolean r3, Shape r4, Shape r5, WideNavigationRailColors r6, Function2 r7, float r8, WindowInsets r9, Arrangement.Vertical r10, ModalWideNavigationRailProperties r11, Function2 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return ModalWideNavigationRail_k3FuEkE$lambda$14(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit l(float r1, DraggableAnchorsConfig r2) {
        return ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22$lambda$21(r1, MenuKt.ClosedAlphaTarget, r2);
    }

    public static /* synthetic */ Unit m(Modifier r0, WideNavigationRailState r1, Shape r2, WideNavigationRailColors r3, Function2 r4, WindowInsets r5, Arrangement.Vertical r6, Function2 r7, int r8, int r9, Composer r10, int r11) {
        return WideNavigationRail$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit n(boolean r1, boolean r2, Animatable r3, RailPredictiveBackState r4, Function2 r5, Modifier r6, ModalWideNavigationRailState r7, WideNavigationRailColors r8, Shape r9, float r10, Function2 r11, WindowInsets r12, boolean r13, Arrangement.Vertical r14, Function2 r15, int r16, int r17, Composer r18, int r19) {
        return ModalWideNavigationRailContent_pU6N4AM$lambda$25(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Unit o(String r0, MutableState r1, SemanticsPropertyReceiver r2) {
        return Scrim_3J_VO9M$lambda$33$lambda$32(r0, r1, r2);
    }

    static {
        NavigationRailVerticalItemTokens r0 = NavigationRailVerticalItemTokens.INSTANCE;
        float r1 = r0.getActiveIndicatorWidth-D9Ej5fM();
        NavigationRailBaselineItemTokens r2 = NavigationRailBaselineItemTokens.INSTANCE;
        float r3 = 2;
        WNRItemNoLabelIndicatorPadding = Dp.constructor-impl(Dp.constructor-impl(r1 - r2.getIconSize-D9Ej5fM()) / r3);
        ItemHorizontalPadding = Dp.constructor-impl(20);
        NavigationRailCollapsedTokens r4 = NavigationRailCollapsedTokens.INSTANCE;
        WNRVerticalPadding = r4.getTopSpace-D9Ej5fM();
        WNRHeaderPadding = r2.getHeaderSpaceMinimum-D9Ej5fM();
        CollapsedRailWidth = r4.getContainerWidth-D9Ej5fM();
        NavigationRailExpandedTokens r5 = NavigationRailExpandedTokens.INSTANCE;
        ExpandedRailMinWidth = r5.getContainerWidthMinimum-D9Ej5fM();
        ExpandedRailMaxWidth = r5.getContainerWidthMaximum-D9Ej5fM();
        TopIconItemMinHeight = r2.getContainerHeight-D9Ej5fM();
        ItemTopIconIndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(r0.getActiveIndicatorHeight-D9Ej5fM() - r2.getIconSize-D9Ej5fM()) / r3);
        ItemTopIconIndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(r0.getActiveIndicatorWidth-D9Ej5fM() - r2.getIconSize-D9Ej5fM()) / r3);
        ItemStartIconIndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationRailHorizontalItemTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() - r2.getIconSize-D9Ej5fM()) / r3);
        PredictiveBackMaxScaleXDistance = Dp.constructor-impl(24);
        PredictiveBackMaxScaleYDistance = Dp.constructor-impl(48);
        LocalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new xx(), 1, null);
        LocalModalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new yx(), 1, null);
    }

    private static final ModalWideNavigationRailOverride LocalModalWideNavigationRailOverride$lambda$39() {
        return DefaultModalWideNavigationRailOverride.INSTANCE;
    }

    private static final WideNavigationRailOverride LocalWideNavigationRailOverride$lambda$38() {
        return DefaultWideNavigationRailOverride.INSTANCE;
    }

    public static final /* synthetic */ float access$getCollapsedRailWidth$p() {
        return CollapsedRailWidth;
    }

    public static final /* synthetic */ float access$getExpandedRailMaxWidth$p() {
        return ExpandedRailMaxWidth;
    }

    public static final /* synthetic */ float access$getExpandedRailMinWidth$p() {
        return ExpandedRailMinWidth;
    }

    public static final /* synthetic */ float access$getItemHorizontalPadding$p() {
        return ItemHorizontalPadding;
    }

    public static final /* synthetic */ float access$getWNRHeaderPadding$p() {
        return WNRHeaderPadding;
    }

    public static final /* synthetic */ float access$getWNRVerticalPadding$p() {
        return WNRVerticalPadding;
    }

    public static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> getLocalModalWideNavigationRailOverride() {
        return LocalModalWideNavigationRailOverride;
    }

    public static final ProvidableCompositionLocal<WideNavigationRailOverride> getLocalWideNavigationRailOverride() {
        return LocalWideNavigationRailOverride;
    }

    public static final float getWNRItemNoLabelIndicatorPadding() {
        return WNRItemNoLabelIndicatorPadding;
    }

    private static final float Scrim_3J_VO9M$lambda$26(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final boolean Scrim_3J_VO9M$lambda$28(MutableState<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final boolean Scrim_3J_VO9M$lambda$33$lambda$32$lambda$31(MutableState r1) {
        Scrim_3J_VO9M$lambda$29(r1, true);
        return true;
    }

    private static final float WideNavigationRailLayout$lambda$10(State<Dp> r0) {
        return ((Dp) r0.getValue()).unbox-impl();
    }

    private static final float WideNavigationRailLayout$lambda$11(State<Dp> r0) {
        return ((Dp) r0.getValue()).unbox-impl();
    }

    private static final int WideNavigationRailLayout$lambda$3(MutableIntState r0) {
        return r0.getIntValue();
    }

    private static final int WideNavigationRailLayout$lambda$6(MutableIntState r0) {
        return r0.getIntValue();
    }

    private static final float WideNavigationRailLayout$lambda$8(State<Dp> r0) {
        return ((Dp) r0.getValue()).unbox-impl();
    }

    private static final float WideNavigationRailLayout$lambda$9(State<Dp> r0) {
        return ((Dp) r0.getValue()).unbox-impl();
    }

    public static final /* synthetic */ boolean access$Scrim_3J_VO9M$lambda$28(MutableState r0) {
        return Scrim_3J_VO9M$lambda$28(r0);
    }

    public static final /* synthetic */ float access$WideNavigationRailLayout$lambda$10(State r0) {
        return WideNavigationRailLayout$lambda$10(r0);
    }

    public static final /* synthetic */ float access$WideNavigationRailLayout$lambda$11(State r0) {
        return WideNavigationRailLayout$lambda$11(r0);
    }

    public static final /* synthetic */ int access$WideNavigationRailLayout$lambda$3(MutableIntState r0) {
        return WideNavigationRailLayout$lambda$3(r0);
    }

    public static final /* synthetic */ int access$WideNavigationRailLayout$lambda$6(MutableIntState r0) {
        return WideNavigationRailLayout$lambda$6(r0);
    }

    public static final /* synthetic */ float access$WideNavigationRailLayout$lambda$8(State r0) {
        return WideNavigationRailLayout$lambda$8(r0);
    }

    public static final /* synthetic */ float access$WideNavigationRailLayout$lambda$9(State r0) {
        return WideNavigationRailLayout$lambda$9(r0);
    }

    private static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$18$lambda$17(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setPaneTitle(r1, r0);
        return Unit.INSTANCE;
    }

    private static final void Scrim_3J_VO9M$lambda$29(MutableState<Boolean> r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    private static final void WideNavigationRailLayout$lambda$4(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    private static final void WideNavigationRailLayout$lambda$7(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    public static final /* synthetic */ void access$Scrim_3J_VO9M$lambda$29(MutableState r0, boolean r1) {
        Scrim_3J_VO9M$lambda$29(r0, r1);
    }

    public static final /* synthetic */ void access$WideNavigationRailLayout$lambda$4(MutableIntState r0, int r1) {
        WideNavigationRailLayout$lambda$4(r0, r1);
    }

    public static final /* synthetic */ void access$WideNavigationRailLayout$lambda$7(MutableIntState r0, int r1) {
        WideNavigationRailLayout$lambda$7(r0, r1);
    }

    public static final /* synthetic */ float access$calculatePredictiveBackScaleY(GraphicsLayerScope r0, float r1) {
        return calculatePredictiveBackScaleY(r0, r1);
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope r4, float r5) {
        float r0 = Float.intBitsToFloat((int) (r4.getSize-NH-jbRc() & 4294967295L));
        if (Float.isNaN(r0) == false) goto L5;
        return 1.0f;
    L5:
        if (r0 != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L11;
        return 1.0f;
    L11:
        return 1.0f - (MathHelpersKt.lerp(MenuKt.ClosedAlphaTarget, Math.min(r4.toPx-0680j_4(PredictiveBackMaxScaleYDistance), r0), r5) / r0);
    L7:
        r3 = false;
        goto L8
    }

    private static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22$lambda$21(float r1, float r2, DraggableAnchorsConfig r3) {
        r3.at(WideNavigationRailValue.Collapsed, r1);
        r3.at(WideNavigationRailValue.Expanded, r2);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_3J_VO9M$lambda$33$lambda$32(String r1, final MutableState r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r1);
        SemanticsPropertiesKt.onClick$default(r3, null, new hy(r2), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_3J_VO9M$lambda$35$lambda$34(long r13, State r15, DrawScope r16) {
        DrawScope.-CC.drawRect-n-J9OG0$default(r16, r13, 0, 0, RangesKt.coerceIn(Scrim_3J_VO9M$lambda$26(r15), MenuKt.ClosedAlphaTarget, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ float access$calculatePredictiveBackScaleX(GraphicsLayerScope r0, float r1, boolean r2) {
        return calculatePredictiveBackScaleX(r0, r1, r2);
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope r4, float r5, boolean r6) {
        float r0 = Float.intBitsToFloat((int) (r4.getSize-NH-jbRc() >> 32));
        if (Float.isNaN(r0) == false) goto L5;
        return 1.0f;
    L5:
        if (r0 != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L16;
        if (r6 == false) goto L12;
        float r7 = 1.0f;
    L14:
        return 1.0f + ((r7 * MathHelpersKt.lerp(MenuKt.ClosedAlphaTarget, Math.min(r4.toPx-0680j_4(PredictiveBackMaxScaleXDistance), r0), r5)) / r0);
    L12:
        r7 = -1.0f;
        goto L14
    L16:
        return 1.0f;
    L7:
        r3 = false;
        goto L8
    }

    private static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$20$lambda$19(Animatable r4, ModalWideNavigationRailState r5, RailPredictiveBackState r6, boolean r7, GraphicsLayerScope r8) {
        float r9 = ((Number) r4.getValue()).floatValue();
        float r0 = MenuKt.ClosedAlphaTarget;
        if (r9 <= MenuKt.ClosedAlphaTarget) goto L5;
        float r10 = r5.getCurrentOffset();
        float r1 = Float.intBitsToFloat((int) (r8.getSize-NH-jbRc() >> 32));
        if (Float.isNaN(r10) == true) goto L20;
        if (Float.isNaN(r1) == true) goto L20;
        if (r1 != MenuKt.ClosedAlphaTarget) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == true) goto L20;
        r8.setScaleX(calculatePredictiveBackScaleX(r8, r9, r6.getSwipeEdgeMatchesRail()));
        r8.setScaleY(calculatePredictiveBackScaleY(r8, r9));
        if (r7 == false) goto L18;
        r0 = 1.0f;
    L18:
        r8.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(r0, 0.5f));
        goto L20
    L13:
        r11 = false;
    L20:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private static final Pair ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22(boolean r1, boolean r2, ModalWideNavigationRailState r3, IntSize r4, Constraints r5) {
        final float r6 = (int) (r4.unbox-impl() >> 32);
        if (r1 == false) goto L7;
        if (r2 == true) goto L9;
        r6 = -r6;
    L9:
        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new fy(r6)), r3.getTargetValue());
    L7:
        r6 = MenuKt.ClosedAlphaTarget;
        goto L9
    }

    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    private static final void m3618Scrim3JVO9M(final long r20, final Function1<? super Continuation<? super Unit>, ? extends Object> r22, final boolean r23, Composer r24, final int r25) {
        Composer r14 = r24.startRestartGroup(144695261);
        if ((r25 & 6) == 0) goto L5;
        int r6 = r25;
    L11:
        if ((r25 & 48) != 0) goto L18;
        if (r14.changedInstance(r22) == false) goto L15;
        int r7 = 32;
    L16:
        r6 = r6 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r25 & 384) == 0) goto L20;
    L24:
        int r12 = r6;
        if ((r12 & 147) == 146) goto L27;
        boolean r8 = true;
    L29:
        if (r14.shouldExecute(r8, r12 & 1) == true) goto L31;
        r14.skipToGroupEnd();
    L77:
        ScopeUpdateScope r9 = r14.endRestartGroup();
        if (r9 == null) goto L81;
        r9.updateScope(new vx(r20, r22, r23, r25));
        return;
    L81:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(144695261, r12, -1, "androidx.compose.material3.Scrim (WideNavigationRail.kt:1102)");
    L34:
        if (r20 == 16) goto L36;
        boolean r0 = true;
    L37:
        if (r0 == false) goto L72;
        r14.startReplaceGroup(-1530482291);
        if (r23 == false) goto L41;
        float r10 = 1.0f;
    L42:
        final State<Float> r11 = AnimateAsStateKt.animateFloatAsState(r10, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r14, 6), MenuKt.ClosedAlphaTarget, null, null, r14, 0, 28);
        Object r13 = r14.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r13 != r15.getEmpty()) goto L45;
        r13 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r14.updateRememberedValue(r13);
    L45:
        final MutableState r16 = (MutableState) r13;
        final String r1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911777), r14, 0);
        if (r23 == false) goto L56;
        r14.startReplaceGroup(-1530047423);
        Modifier.Companion r17 = Modifier.Companion;
        Object r18 = r14.rememberedValue();
        if (r18 != r15.getEmpty()) goto L50;
        r18 = new WideNavigationRailKt$Scrim$dismissModalRail$1$1(r16);
        r14.updateRememberedValue(r18);
    L50:
        Modifier r19 = SuspendingPointerInputFilterKt.pointerInput(r17, r22, (PointerInputEventHandler) r18);
        boolean r110 = r14.changed(r1);
        Object r111 = r14.rememberedValue();
        if (r110 == false) goto L53;
    L54:
        r111 = new iy(r1, r16);
        r14.updateRememberedValue(r111);
    L55:
        int r2 = 1;
        Modifier r21 = SemanticsModifierKt.semantics(r19, true, (Function1) r111);
        r14.endReplaceGroup();
    L57:
        Modifier r26 = SizeKt.fillMaxSize$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, r2, null).then(r21);
        if ((r12 & 14) != 4) goto L60;
        boolean r112 = true;
    L61:
        boolean r3 = r14.changed(r11) | r112;
        Object r113 = r14.rememberedValue();
        if (r3 == false) goto L64;
    L65:
        r113 = new jy(r20, r11);
        r14.updateRememberedValue(r113);
    L66:
        CanvasKt.Canvas(r26, (Function1) r113, r14, 0);
        Boolean r4 = Boolean.valueOf(Scrim_3J_VO9M$lambda$28(r16));
        boolean r27 = r14.changedInstance(r22);
        Object r28 = r14.rememberedValue();
        if (r27 == false) goto L69;
    L70:
        r28 = new WideNavigationRailKt$Scrim$2$1(r22, r16, null);
        r14.updateRememberedValue(r28);
    L71:
        EffectsKt.LaunchedEffect(r4, (Function2) r28, r14, 0);
        r14.endReplaceGroup();
    L74:
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventEnd();
        goto L77
    L69:
        if (r28 != r15.getEmpty()) goto L71;
    L64:
        if (r113 != r15.getEmpty()) goto L66;
    L60:
        r112 = false;
        goto L61
    L53:
        if (r111 != r15.getEmpty()) goto L55;
    L56:
        r2 = 1;
        r14.startReplaceGroup(-1529667363);
        r14.endReplaceGroup();
        r21 = Modifier.Companion;
        goto L57
    L41:
        r10 = MenuKt.ClosedAlphaTarget;
        goto L42
    L72:
        r14.startReplaceGroup(-1529413659);
        r14.endReplaceGroup();
        goto L74
    L36:
        r0 = false;
        goto L37
    L27:
        r8 = false;
        goto L29
    L20:
        if (r14.changed(r23) == false) goto L22;
        int r29 = 256;
    L23:
        r6 = r6 | r29;
        goto L24
    L22:
        r29 = 128;
        goto L23
    L5:
        if (r14.changed(r20) == false) goto L7;
        int r30 = 4;
    L8:
        r6 = r30 | r25;
        goto L11
    L7:
        r30 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$Scrim-3J-VO9M, reason: not valid java name */
    public static final /* synthetic */ void m3621access$Scrim3JVO9M(long r0, Function1 r2, boolean r3, Composer r4, int r5) {
        m3618Scrim3JVO9M(r0, r2, r3, r4, r5);
    }

    public static final void WideNavigationRail(Modifier r24, WideNavigationRailState r25, Shape r26, WideNavigationRailColors r27, Function2<? super Composer, ? super Integer, Unit> r28, WindowInsets r29, Arrangement.Vertical r30, final Function2<? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33, final int r34) {
        Composer r2 = r32.startRestartGroup(164193188);
        int r3 = r34 & 1;
        if (r3 == 0) goto L6;
        int r5 = r33 | 6;
        Modifier r4 = r24;
    L14:
        if ((r33 & 48) != 0) goto L26;
        if ((r34 & 2) == 0) goto L18;
    L23:
        int r6 = 16;
    L24:
        r5 = r5 | r6;
        goto L26
    L18:
        if ((r33 & 64) != 0) goto L20;
        boolean r7 = r2.changed(r25);
    L21:
        if (r7 == false) goto L23;
        r6 = 32;
        goto L24
    L20:
        r7 = r2.changedInstance(r25);
    L26:
        if ((r33 & 384) == 0) goto L28;
        Shape r8 = r26;
    L37:
        if ((r33 & 3072) == 0) goto L39;
        WideNavigationRailColors r9 = r27;
    L47:
        int r10 = r34 & 16;
        if (r10 == 0) goto L51;
        r5 = r5 | 24576;
    L57:
        Function2<? super Composer, ? super Integer, Unit> r11 = r28;
    L59:
        if ((196608 & r33) == 0) goto L61;
        WindowInsets r12 = r29;
    L70:
        if ((1572864 & r33) == 0) goto L72;
        Arrangement.Vertical r13 = r30;
    L81:
        if ((r34 & 128) == 0) goto L84;
        r5 = r5 | 12582912;
    L92:
        if ((4793491 & r5) == 4793490) goto L94;
        boolean r1 = true;
    L96:
        if (r2.shouldExecute(r1, r5 & 1) == false) goto L146;
        r2.startDefaults();
        if ((r33 & 1) != 0) goto L100;
    L118:
        if (r3 == 0) goto L120;
        final Modifier r14 = Modifier.Companion;
    L122:
        if ((r34 & 2) == 0) goto L124;
        WideNavigationRailState r0 = WideNavigationRailStateKt.rememberWideNavigationRailState(null, r2, 0, 1);
        r5 = r5 & (-113);
    L126:
        if ((r34 & 4) == 0) goto L129;
        r5 = r5 & (-897);
        r8 = WideNavigationRailDefaults.INSTANCE.getShape(r2, 6);
    L129:
        if ((r34 & 8) == 0) goto L131;
        r5 = r5 & (-7169);
        r9 = WideNavigationRailDefaults.INSTANCE.colors(r2, 6);
    L131:
        if (r10 == 0) goto L134;
        r11 = null;
    L134:
        if ((r34 & 32) == 0) goto L137;
        r12 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(r2, 6);
        r5 = r5 & (-458753);
    L137:
        if ((r34 & 64) == 0) goto L139;
        r5 = r5 & (-3670017);
        r13 = WideNavigationRailDefaults.INSTANCE.getArrangement();
    L139:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventStart(164193188, r5, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:169)");
    L142:
        ((WideNavigationRailOverride) r2.consume(LocalWideNavigationRailOverride)).WideNavigationRail(new WideNavigationRailOverrideScope(r14, r0, r8, r9, r11, r12, r13, r31), r2, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventEnd();
    L145:
        WideNavigationRailState r15 = r0;
    L147:
        final WideNavigationRailColors r16 = r9;
        final Function2<? super Composer, ? super Integer, Unit> r17 = r11;
        final Arrangement.Vertical r18 = r13;
        ScopeUpdateScope r19 = r2.endRestartGroup();
        if (r19 == null) goto L151;
        final WideNavigationRailState r20 = r15;
        final Shape r21 = r8;
        final WindowInsets r22 = r12;
        r19.updateScope(new zx(r14, r20, r21, r16, r17, r22, r18, r31, r33, r34));
        return;
    L151:
        return;
    L124:
        r0 = r25;
        goto L126
    L120:
        r14 = r4;
        goto L122
    L100:
        if (r2.getDefaultsInvalid() == true) goto L118;
        r2.skipToGroupEnd();
        if ((r34 & 2) == 0) goto L106;
        r5 = r5 & (-113);
    L106:
        if ((r34 & 4) == 0) goto L109;
        r5 = r5 & (-897);
    L109:
        if ((r34 & 8) == 0) goto L112;
        r5 = r5 & (-7169);
    L112:
        if ((r34 & 32) == 0) goto L115;
        r5 = r5 & (-458753);
    L115:
        if ((r34 & 64) == 0) goto L117;
        r5 = r5 & (-3670017);
    L117:
        r0 = r25;
        r14 = r4;
        goto L139
    L146:
        r2.skipToGroupEnd();
        r15 = r25;
        r14 = r4;
        goto L147
    L94:
        r1 = false;
        goto L96
    L84:
        if ((r33 & 12582912) != 0) goto L92;
        if (r2.changedInstance(r31) == false) goto L88;
        int r110 = 8388608;
    L89:
        r5 = r5 | r110;
        goto L92
    L88:
        r110 = 4194304;
        goto L89
    L72:
        if ((r34 & 64) != 0) goto L76;
        r13 = r30;
        if (r2.changed(r13) == false) goto L77;
        int r111 = 1048576;
    L78:
        r5 = r5 | r111;
    L77:
        r111 = 524288;
        goto L78
    L76:
        r13 = r30;
        goto L77
    L61:
        if ((r34 & 32) != 0) goto L65;
        r12 = r29;
        if (r2.changed(r12) == false) goto L66;
        int r112 = 131072;
    L67:
        r5 = r5 | r112;
    L66:
        r112 = 65536;
        goto L67
    L65:
        r12 = r29;
        goto L66
    L51:
        if ((r33 & 24576) != 0) goto L57;
        r11 = r28;
        if (r2.changedInstance(r11) == false) goto L55;
        int r113 = 16384;
    L56:
        r5 = r5 | r113;
        goto L59
    L55:
        r113 = 8192;
        goto L56
    L39:
        if ((r34 & 8) != 0) goto L43;
        r9 = r27;
        if (r2.changed(r9) == false) goto L44;
        int r23 = 2048;
    L45:
        r5 = r5 | r23;
    L44:
        r23 = 1024;
        goto L45
    L43:
        r9 = r27;
        goto L44
    L28:
        if ((r34 & 4) != 0) goto L32;
        r8 = r26;
        if (r2.changed(r8) == false) goto L33;
        int r35 = 256;
    L34:
        r5 = r5 | r35;
    L33:
        r35 = 128;
        goto L34
    L32:
        r8 = r26;
        goto L33
    L6:
        if ((r33 & 6) != 0) goto L12;
        r4 = r24;
        if (r2.changed(r4) == false) goto L10;
        int r36 = 4;
    L11:
        r5 = r36 | r33;
        goto L14
    L10:
        r36 = 2;
        goto L11
    L12:
        r4 = r24;
        r5 = r33;
        goto L14
    }

    private static final void WideNavigationRailLayout(final Modifier r30, final boolean r31, final boolean r32, final WideNavigationRailColors r33, final Shape r34, final Function2<? super Composer, ? super Integer, Unit> r35, final WindowInsets r36, final Arrangement.Vertical r37, final Function2<? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40) {
        Composer r15 = r39.startRestartGroup(-1004308036);
        if ((r40 & 6) == 0) goto L5;
        int r4 = r40;
    L11:
        if ((r40 & 48) != 0) goto L18;
        if (r15.changed(r31) == false) goto L15;
        int r5 = 32;
    L16:
        r4 = r4 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r40 & 384) != 0) goto L25;
        if (r15.changed(r32) == false) goto L22;
        int r6 = 256;
    L23:
        r4 = r4 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r40 & 3072) != 0) goto L32;
        if (r15.changed(r33) == false) goto L29;
        int r7 = 2048;
    L30:
        r4 = r4 | r7;
        goto L32
    L29:
        r7 = 1024;
    L32:
        if ((r40 & 24576) != 0) goto L39;
        if (r15.changed(r34) == false) goto L36;
        int r8 = 16384;
    L37:
        r4 = r4 | r8;
        goto L39
    L36:
        r8 = 8192;
    L39:
        if ((196608 & r40) != 0) goto L46;
        if (r15.changedInstance(r35) == false) goto L43;
        int r9 = 131072;
    L44:
        r4 = r4 | r9;
        goto L46
    L43:
        r9 = 65536;
    L46:
        if ((1572864 & r40) != 0) goto L53;
        if (r15.changed(r36) == false) goto L50;
        int r10 = 1048576;
    L51:
        r4 = r4 | r10;
        goto L53
    L50:
        r10 = 524288;
    L53:
        if ((r40 & 12582912) != 0) goto L60;
        if (r15.changed(r37) == false) goto L57;
        int r11 = 8388608;
    L58:
        r4 = r4 | r11;
        goto L60
    L57:
        r11 = 4194304;
    L60:
        if ((100663296 & r40) == 0) goto L62;
    L66:
        int r12 = r4;
        if ((38347923 & r12) == 38347922) goto L69;
        boolean r13 = true;
    L71:
        if (r15.shouldExecute(r13, r12 & 1) == true) goto L73;
        Composer r0 = r15;
        r0.skipToGroupEnd();
    L119:
        ScopeUpdateScope r14 = r0.endRestartGroup();
        if (r14 == null) goto L123;
        r14.updateScope(new gy(r30, r31, r32, r33, r34, r35, r36, r37, r38, r40));
        return;
    L123:
        return;
    L73:
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventStart(-1004308036, r12, -1, "androidx.compose.material3.WideNavigationRailLayout (WideNavigationRail.kt:218)");
    L75:
        Object r3 = r15.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r3 != r16.getEmpty()) goto L78;
        r3 = SnapshotIntStateKt.mutableIntStateOf(0);
        r15.updateRememberedValue(r3);
    L78:
        MutableIntState r17 = (MutableIntState) r3;
        Object r18 = r15.rememberedValue();
        if (r18 != r16.getEmpty()) goto L81;
        r18 = SnapshotIntStateKt.mutableIntStateOf(0);
        r15.updateRememberedValue(r18);
    L81:
        MutableIntState r19 = (MutableIntState) r18;
        if (Dp.equals-impl0(((Dp) r15.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl(), Dp.Companion.getUnspecified-D9Ej5fM()) == false) goto L84;
        r15.startReplaceGroup(-597966102);
        r15.endReplaceGroup();
        float r20 = Dp.constructor-impl(0);
    L85:
        float r110 = r20;
        FiniteAnimationSpec r21 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r15, 6);
        FiniteAnimationSpec r22 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r15, 6);
        if (r32 == true) goto L88;
        float r23 = CollapsedRailWidth;
    L89:
        if (r31 == true) goto L91;
        FiniteAnimationSpec r24 = r21;
    L92:
        State<Dp> r25 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(r23, r24, null, null, r15, 0, 12);
        if (r32 == true) goto L95;
        float r26 = CollapsedRailWidth;
    L96:
        if (r31 == true) goto L98;
        FiniteAnimationSpec r27 = r21;
    L99:
        State<Dp> r28 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(r26, r27, null, null, r15, 0, 12);
        if (r32 == true) goto L102;
        float r1 = NavigationRailCollapsedTokens.INSTANCE.getItemVerticalSpace-D9Ej5fM();
    L103:
        State<Dp> r2 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(r1, r21, null, null, r15, 0, 12);
        if (r32 == true) goto L106;
        float r29 = TopIconItemMinHeight;
    L107:
        State<Dp> r41 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(r29, r21, null, null, r15, 0, 12);
        if (r31 == true) goto L110;
        long r42 = r33.m3608getContainerColor0d7_KjU();
    L111:
        long r210 = r42;
        if (r31 == true) goto L114;
        long r43 = r33.m3609getContentColor0d7_KjU();
    L115:
        r0 = r15;
        SurfaceKt.m3213SurfaceT9BRK9s(r30, r34, r210, r43, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(-1489314345, true, new AnonymousClass1(r36, r35, r32, r25, r110, r41, r28, r19, r17, r37, r2, r38), r0, 54), r0, ((r12 & 14) | 12582912) | ((r12 >> 9) & 112), 112);
        if (ComposerKt.isTraceInProgress() == false) goto L119;
        ComposerKt.traceEventEnd();
        goto L119
    L114:
        r43 = r33.m3611getModalContentColor0d7_KjU();
        goto L115
    L110:
        r42 = r33.m3610getModalContainerColor0d7_KjU();
        goto L111
    L106:
        r29 = r110;
        goto L107
    L102:
        r1 = Dp.constructor-impl(0);
        goto L103
    L98:
        r27 = r22;
        goto L99
    L95:
        r26 = ExpandedRailMaxWidth;
        goto L96
    L91:
        r24 = r22;
        goto L92
    L88:
        r23 = ExpandedRailMinWidth;
        goto L89
    L84:
        r15.startReplaceGroup(-597931134);
        r20 = ((Dp) r15.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl();
        r15.endReplaceGroup();
        goto L85
    L69:
        r13 = false;
        goto L71
    L62:
        if (r15.changedInstance(r38) == false) goto L64;
        int r44 = 67108864;
    L65:
        r4 = r4 | r44;
        goto L66
    L64:
        r44 = 33554432;
        goto L65
    L5:
        if (r15.changed(r30) == false) goto L7;
        int r45 = 4;
    L8:
        r4 = r45 | r40;
        goto L11
    L7:
        r45 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$WideNavigationRailLayout(Modifier r0, boolean r1, boolean r2, WideNavigationRailColors r3, Shape r4, Function2 r5, WindowInsets r6, Arrangement.Vertical r7, Function2 r8, Composer r9, int r10) {
        WideNavigationRailLayout(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX INFO: renamed from: WideNavigationRailItem-pli-t6k, reason: not valid java name */
    public static final void m3619WideNavigationRailItemplit6k(final boolean r38, final Function0<Unit> r39, final Function2<? super Composer, ? super Integer, Unit> r40, final Function2<? super Composer, ? super Integer, Unit> r41, final boolean r42, Modifier r43, boolean r44, int r45, NavigationItemColors r46, MutableInteractionSource r47, Composer r48, final int r49, final int r50) {
        Composer r1 = r48.startRestartGroup(-1894733304);
        if ((r50 & 1) == 0) goto L6;
        int r3 = r49 | 6;
    L14:
        if ((r50 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r50 & 4) == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r50 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L47:
        if ((r50 & 16) == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r8 = r50 & 32;
        if (r8 == 0) goto L60;
        r3 = r3 | 196608;
    L66:
        Modifier r9 = r43;
    L67:
        int r10 = r50 & 64;
        if (r10 == 0) goto L71;
        r3 = r3 | 1572864;
    L77:
        boolean r13 = r44;
    L79:
        if ((12582912 & r49) == 0) goto L81;
        int r14 = r45;
    L90:
        if ((100663296 & r49) == 0) goto L92;
        NavigationItemColors r15 = r46;
    L100:
        int r0 = r50 & 512;
        if (r0 == 0) goto L104;
        r3 = r3 | 805306368;
    L111:
        if ((r3 & 306783379) == 306783378) goto L113;
        boolean r2 = true;
    L115:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L154;
        r1.startDefaults();
        if ((r49 & 1) != 0) goto L119;
    L129:
        if (r8 == 0) goto L131;
        r9 = Modifier.Companion;
    L131:
        if (r10 == 0) goto L134;
        r13 = true;
    L134:
        if ((r50 & 128) == 0) goto L137;
        r3 = r3 & (-29360129);
        r14 = WideNavigationRailItemDefaults.INSTANCE.m3615iconPositionFors8pcRp0(r42);
    L137:
        if ((r50 & 256) == 0) goto L139;
        r3 = r3 & (-234881025);
        r15 = WideNavigationRailItemDefaults.INSTANCE.colors(r1, 6);
    L139:
        if (r0 != 0) goto L140;
    L127:
        MutableInteractionSource r11 = r47;
    L128:
        int r12 = r3;
        boolean r4 = r13;
        int r5 = r14;
        NavigationItemColors r6 = r15;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventStart(-1894733304, r12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:688)");
    L144:
        if (r11 != null) goto L149;
        r1.startReplaceGroup(-1539072909);
        Object r16 = r1.rememberedValue();
        if (r16 != Composer.Companion.getEmpty()) goto L148;
        r16 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r16);
    L148:
        r1.endReplaceGroup();
        MutableInteractionSource r33 = (MutableInteractionSource) r16;
    L150:
        Shape r17 = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), r1, 6);
        NavigationRailVerticalItemTokens r18 = NavigationRailVerticalItemTokens.INSTANCE;
        float r19 = r18.getActiveIndicatorWidth-D9Ej5fM();
        TextStyle r110 = TypographyKt.getValue(r18.getLabelTextFont(), r1, 6);
        NavigationRailHorizontalItemTokens r111 = NavigationRailHorizontalItemTokens.INSTANCE;
        int r112 = r12 << 3;
        Modifier r29 = r9;
        NavigationItemKt.m2933AnimatedNavigationItemDQd_Gtc(r38, r39, r40, r17, r19, r110, TypographyKt.getValue(r111.getLabelTextFont(), r1, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, r18.getIconLabelSpace-D9Ej5fM(), r111.getFullWidthLeadingSpace-D9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, r111.getIconLabelSpace-D9Ej5fM(), ItemHorizontalPadding, r6, r29, r4, r41, r5, r33, r1, (((r12 & 14) | 918577152) | (r12 & 112)) | (r12 & 896), ((((((r12 >> 9) & 458752) | 28086) | (3670016 & r112)) | (r112 & 29360128)) | ((r12 << 15) & 234881024)) | ((r12 << 6) & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventEnd();
    L153:
        r13 = r4;
        r15 = r6;
        final MutableInteractionSource r113 = r11;
        final int r20 = r5;
    L155:
        ScopeUpdateScope r114 = r1.endRestartGroup();
        if (r114 == null) goto L159;
        final Modifier r7 = r9;
        final boolean r21 = r13;
        final NavigationItemColors r22 = r15;
        r114.updateScope(new wx(r38, r39, r40, r41, r42, r7, r21, r20, r22, r113, r49, r50));
        return;
    L159:
        return;
    L149:
        r1.startReplaceGroup(227446500);
        r1.endReplaceGroup();
        r33 = r11;
        goto L150
    L140:
        r11 = null;
        goto L128
    L119:
        if (r1.getDefaultsInvalid() == true) goto L129;
        r1.skipToGroupEnd();
        if ((r50 & 128) == 0) goto L125;
        r3 = r3 & (-29360129);
    L125:
        if ((r50 & 256) == 0) goto L127;
        r3 = r3 & (-234881025);
        goto L127
    L154:
        r1.skipToGroupEnd();
        r113 = r47;
        r20 = r14;
        goto L155
    L113:
        r2 = false;
        goto L115
    L104:
        if ((r49 & 805306368) != 0) goto L111;
        if (r1.changed(r47) == false) goto L108;
        int r115 = 536870912;
    L109:
        r3 = r3 | r115;
        goto L111
    L108:
        r115 = 268435456;
        goto L109
    L92:
        if ((r50 & 256) != 0) goto L96;
        r15 = r46;
        if (r1.changed(r15) == false) goto L97;
        int r116 = 67108864;
    L98:
        r3 = r3 | r116;
    L97:
        r116 = 33554432;
        goto L98
    L96:
        r15 = r46;
        goto L97
    L81:
        if ((r50 & 128) != 0) goto L85;
        r14 = r45;
        if (r1.changed(r14) == false) goto L86;
        int r117 = 8388608;
    L87:
        r3 = r3 | r117;
    L86:
        r117 = 4194304;
        goto L87
    L85:
        r14 = r45;
        goto L86
    L71:
        if ((1572864 & r49) != 0) goto L77;
        r13 = r44;
        if (r1.changed(r13) == false) goto L75;
        int r118 = 1048576;
    L76:
        r3 = r3 | r118;
        goto L79
    L75:
        r118 = 524288;
        goto L76
    L60:
        if ((196608 & r49) != 0) goto L66;
        r9 = r43;
        if (r1.changed(r9) == false) goto L64;
        int r119 = 131072;
    L65:
        r3 = r3 | r119;
        goto L67
    L64:
        r119 = 65536;
        goto L65
    L50:
        if ((r49 & 24576) != 0) goto L56;
        if (r1.changed(r42) == false) goto L54;
        int r23 = 16384;
    L55:
        r3 = r3 | r23;
        goto L56
    L54:
        r23 = 8192;
        goto L55
    L39:
        if ((r49 & 3072) != 0) goto L47;
        if (r1.changedInstance(r41) == false) goto L43;
        int r24 = 2048;
    L44:
        r3 = r3 | r24;
        goto L47
    L43:
        r24 = 1024;
        goto L44
    L28:
        if ((r49 & 384) != 0) goto L36;
        if (r1.changedInstance(r40) == false) goto L32;
        int r25 = 256;
    L33:
        r3 = r3 | r25;
        goto L36
    L32:
        r25 = 128;
        goto L33
    L17:
        if ((r49 & 48) != 0) goto L25;
        if (r1.changedInstance(r39) == false) goto L21;
        int r26 = 32;
    L22:
        r3 = r3 | r26;
        goto L25
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r49 & 6) == 0) goto L8;
        r3 = r49;
        goto L14
    L8:
        if (r1.changed(r38) == false) goto L10;
        int r27 = 4;
    L11:
        r3 = r27 | r49;
        goto L14
    L10:
        r27 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalWideNavigationRail-k3FuEkE, reason: not valid java name */
    public static final void m3616ModalWideNavigationRailk3FuEkE(Modifier r38, WideNavigationRailState r39, boolean r40, Shape r41, Shape r42, WideNavigationRailColors r43, Function2<? super Composer, ? super Integer, Unit> r44, float r45, WindowInsets r46, Arrangement.Vertical r47, ModalWideNavigationRailProperties r48, final Function2<? super Composer, ? super Integer, Unit> r49, Composer r50, final int r51, final int r52, final int r53) {
        Composer r2 = r50.startRestartGroup(-38559147);
        int r3 = r53 & 1;
        if (r3 == 0) goto L6;
        int r7 = r51 | 6;
    L14:
        if ((r51 & 48) == 0) goto L16;
    L25:
        int r8 = r53 & 4;
        if (r8 == 0) goto L29;
        r7 = r7 | 384;
    L35:
        boolean r11 = r40;
    L37:
        if ((r51 & 3072) == 0) goto L39;
        Shape r12 = r41;
    L48:
        if ((r51 & 24576) == 0) goto L50;
        Shape r14 = r42;
    L59:
        if ((r51 & 196608) != 0) goto L68;
        if ((r53 & 32) == 0) goto L63;
    L65:
        int r16 = 65536;
    L66:
        r7 = r7 | r16;
        goto L68
    L63:
        if (r2.changed(r43) == false) goto L65;
        r16 = 131072;
    L68:
        int r17 = r53 & 64;
        if (r17 == 0) goto L72;
        r7 = r7 | 1572864;
    L78:
        int r9 = r53 & 128;
        if (r9 == 0) goto L81;
        r7 = r7 | 12582912;
        float r10 = r45;
    L89:
        if ((r51 & 100663296) != 0) goto L100;
        if ((r53 & 256) != 0) goto L96;
        if (r2.changed(r46) == false) goto L96;
        int r21 = 67108864;
    L97:
        r7 = r7 | r21;
    L96:
        r21 = 33554432;
    L100:
        if ((r51 & 805306368) != 0) goto L110;
        if ((r53 & 512) != 0) goto L107;
        if (r2.changed(r47) == false) goto L107;
        int r22 = 536870912;
    L108:
        r7 = r7 | r22;
    L107:
        r22 = 268435456;
    L110:
        int r0 = r53 & 1024;
        if (r0 == 0) goto L114;
        int r18 = r52 | 6;
    L122:
        if ((r53 & 2048) == 0) goto L125;
        r18 = r18 | 48;
    L132:
        int r1 = r18;
        if ((r7 & 306783379) == 306783378) goto L135;
    L138:
        boolean r4 = true;
    L140:
        if (r2.shouldExecute(r4, r7 & 1) == false) goto L210;
        r2.startDefaults();
        if ((r51 & 1) != 0) goto L144;
    L165:
        if (r3 == 0) goto L167;
        Modifier r5 = Modifier.Companion;
    L168:
        Function2<? super Composer, ? super Integer, Unit> r6 = null;
        if ((r53 & 2) == 0) goto L171;
        WideNavigationRailState r13 = WideNavigationRailStateKt.rememberWideNavigationRailState(null, r2, 0, 1);
        r7 = r7 & (-113);
    L172:
        if (r8 == 0) goto L175;
        r11 = false;
    L175:
        if ((r53 & 8) == 0) goto L177;
        final Shape r15 = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(r2, 6);
        r7 = r7 & (-7169);
    L179:
        if ((r53 & 16) == 0) goto L181;
        Shape r19 = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(r2, 6);
        r7 = r7 & (-57345);
    L183:
        if ((r53 & 32) == 0) goto L185;
        WideNavigationRailColors r110 = WideNavigationRailDefaults.INSTANCE.colors(r2, 6);
        r7 = r7 & (-458753);
    L186:
        if (r17 != 0) goto L189;
        r6 = r44;
    L189:
        if (r9 == 0) goto L191;
        float r20 = Dp.constructor-impl(0);
    L193:
        if ((r53 & 256) == 0) goto L195;
        WindowInsets r23 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(r2, 6);
        r7 = r7 & (-234881025);
    L197:
        if ((r53 & 512) == 0) goto L199;
        final Arrangement.Vertical r111 = WideNavigationRailDefaults.INSTANCE.getArrangement();
        r7 = r7 & (-1879048193);
    L200:
        if (r0 == 0) goto L202;
        ModalWideNavigationRailProperties r24 = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
    L203:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L206;
        ComposerKt.traceEventStart(-38559147, r7, r1, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:477)");
    L206:
        ((ModalWideNavigationRailOverride) r2.consume(LocalModalWideNavigationRailOverride)).ModalWideNavigationRail(new ModalWideNavigationRailOverrideScope(r5, r13, r11, r15, r19, r110, r6, r20, r23, r111, r24, r49, null), r2, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L209;
        ComposerKt.traceEventEnd();
    L209:
        final Modifier r25 = r5;
        final Function2<? super Composer, ? super Integer, Unit> r26 = r6;
        final boolean r27 = r11;
        final Shape r28 = r19;
        final ModalWideNavigationRailProperties r112 = r24;
        float r37 = r20;
        final WindowInsets r29 = r23;
        final float r30 = r37;
    L211:
        ScopeUpdateScope r113 = r2.endRestartGroup();
        if (r113 == null) goto L215;
        final WideNavigationRailState r31 = r13;
        final WideNavigationRailColors r32 = r110;
        r113.updateScope(new ux(r25, r31, r27, r15, r28, r32, r26, r30, r29, r111, r112, r49, r51, r52, r53));
        return;
    L215:
        return;
    L202:
        r24 = r48;
        goto L203
    L199:
        r111 = r47;
        goto L200
    L195:
        r23 = r46;
        goto L197
    L191:
        r20 = r10;
        goto L193
    L185:
        r110 = r43;
        goto L186
    L181:
        r19 = r14;
        goto L183
    L177:
        r15 = r12;
        goto L179
    L171:
        r13 = r39;
        goto L172
    L167:
        r5 = r38;
        goto L168
    L144:
        if (r2.getDefaultsInvalid() == true) goto L165;
        r2.skipToGroupEnd();
        if ((r53 & 2) == 0) goto L150;
        r7 = r7 & (-113);
    L150:
        if ((r53 & 8) == 0) goto L153;
        r7 = r7 & (-7169);
    L153:
        if ((r53 & 16) == 0) goto L156;
        r7 = r7 & (-57345);
    L156:
        if ((r53 & 32) == 0) goto L159;
        r7 = r7 & (-458753);
    L159:
        if ((r53 & 256) == 0) goto L162;
        r7 = r7 & (-234881025);
    L162:
        if ((r53 & 512) == 0) goto L164;
        r7 = r7 & (-1879048193);
    L164:
        r5 = r38;
        r13 = r39;
        r6 = r44;
        r23 = r46;
        r24 = r48;
        r20 = r10;
        r15 = r12;
        r19 = r14;
        r110 = r43;
        r111 = r47;
        goto L203
    L210:
        r2.skipToGroupEnd();
        r25 = r38;
        r13 = r39;
        r26 = r44;
        r29 = r46;
        r30 = r10;
        r27 = r11;
        r15 = r12;
        r28 = r14;
        r110 = r43;
        r111 = r47;
        r112 = r48;
        goto L211
    L135:
        if ((r1 & 19) != 18) goto L138;
        r4 = false;
        goto L140
    L125:
        if ((r52 & 48) != 0) goto L132;
        if (r2.changedInstance(r49) == false) goto L129;
        int r114 = 32;
    L130:
        r18 = r18 | r114;
        goto L132
    L129:
        r114 = 16;
        goto L130
    L114:
        if ((r52 & 6) == 0) goto L116;
        r18 = r52;
        goto L122
    L116:
        if (r2.changed(r48) == false) goto L118;
        int r115 = 4;
    L119:
        r18 = r52 | r115;
        goto L122
    L118:
        r115 = 2;
        goto L119
    L81:
        r10 = r45;
        if ((r51 & 12582912) != 0) goto L89;
        if (r2.changed(r10) == false) goto L86;
        int r210 = 8388608;
    L87:
        r7 = r7 | r210;
        goto L89
    L86:
        r210 = 4194304;
        goto L87
    L72:
        if ((r51 & 1572864) != 0) goto L78;
        if (r2.changedInstance(r44) == false) goto L76;
        int r116 = 1048576;
    L77:
        r7 = r7 | r116;
        goto L78
    L76:
        r116 = 524288;
        goto L77
    L50:
        if ((r53 & 16) != 0) goto L54;
        r14 = r42;
        if (r2.changed(r14) == false) goto L55;
        int r117 = 16384;
    L56:
        r7 = r7 | r117;
    L55:
        r117 = 8192;
        goto L56
    L54:
        r14 = r42;
        goto L55
    L39:
        if ((r53 & 8) != 0) goto L43;
        r12 = r41;
        if (r2.changed(r12) == false) goto L44;
        int r118 = 2048;
    L45:
        r7 = r7 | r118;
    L44:
        r118 = 1024;
        goto L45
    L43:
        r12 = r41;
        goto L44
    L29:
        if ((r51 & 384) != 0) goto L35;
        r11 = r40;
        if (r2.changed(r11) == false) goto L33;
        int r119 = 256;
    L34:
        r7 = r7 | r119;
        goto L37
    L33:
        r119 = 128;
        goto L34
    L16:
        if ((r53 & 2) == 0) goto L18;
    L23:
        int r33 = 16;
    L24:
        r7 = r7 | r33;
        goto L25
    L18:
        if ((r51 & 64) != 0) goto L20;
        boolean r34 = r2.changed(r39);
    L21:
        if (r34 == false) goto L23;
        r33 = 32;
        goto L24
    L20:
        r34 = r2.changedInstance(r39);
        goto L21
    L6:
        if ((r51 & 6) == 0) goto L8;
        r7 = r51;
        goto L14
    L8:
        if (r2.changed(r38) == false) goto L10;
        int r35 = 4;
    L11:
        r7 = r35 | r51;
        goto L14
    L10:
        r35 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalWideNavigationRailContent-pU6N4AM, reason: not valid java name */
    private static final void m3617ModalWideNavigationRailContentpU6N4AM(final boolean r40, final boolean r41, final Animatable<Float, AnimationVector1D> r42, final RailPredictiveBackState r43, final Function2<? super Float, ? super Continuation<? super Unit>, ? extends Object> r44, final Modifier r45, final ModalWideNavigationRailState r46, final WideNavigationRailColors r47, final Shape r48, final float r49, final Function2<? super Composer, ? super Integer, Unit> r50, final WindowInsets r51, final boolean r52, final Arrangement.Vertical r53, final Function2<? super Composer, ? super Integer, Unit> r54, Composer r55, final int r56, final int r57) {
        Composer r9 = r55.startRestartGroup(-1593438005);
        if ((r56 & 6) == 0) goto L5;
        int r4 = r56;
    L10:
        int r16 = 16;
        if ((r56 & 48) == 0) goto L13;
    L17:
        int r17 = 128;
        if ((r56 & 384) == 0) goto L20;
    L27:
        int r19 = 1024;
        if ((r56 & 3072) == 0) goto L30;
    L34:
        int r21 = 16384;
        if ((r56 & 24576) != 0) goto L42;
        if (r9.changedInstance(r44) == false) goto L39;
        int r7 = 16384;
    L40:
        r4 = r4 | r7;
        goto L42
    L39:
        r7 = 8192;
    L42:
        if ((196608 & r56) != 0) goto L49;
        if (r9.changed(r45) == false) goto L46;
        int r8 = 131072;
    L47:
        r4 = r4 | r8;
        goto L49
    L46:
        r8 = 65536;
    L49:
        if ((1572864 & r56) != 0) goto L56;
        if (r9.changedInstance(r46) == false) goto L53;
        int r10 = 1048576;
    L54:
        r4 = r4 | r10;
        goto L56
    L53:
        r10 = 524288;
    L56:
        if ((r56 & 12582912) != 0) goto L64;
        if (r9.changed(r47) == false) goto L60;
        int r24 = 8388608;
    L61:
        r4 = r4 | r24;
        goto L64
    L60:
        r24 = 4194304;
    L64:
        if ((r56 & 100663296) != 0) goto L71;
        if (r9.changed(r48) == false) goto L68;
        int r25 = 67108864;
    L69:
        r4 = r4 | r25;
        goto L71
    L68:
        r25 = 33554432;
    L71:
        if ((r56 & 805306368) != 0) goto L78;
        if (r9.changed(r49) == false) goto L75;
        int r26 = 536870912;
    L76:
        r4 = r4 | r26;
        goto L78
    L75:
        r26 = 268435456;
    L78:
        if ((r57 & 6) == 0) goto L80;
        int r18 = r57;
    L86:
        if ((r57 & 48) != 0) goto L92;
        if (r9.changed(r51) == false) goto L90;
        r16 = 32;
    L90:
        r18 = r18 | r16;
    L92:
        if ((r57 & 384) != 0) goto L99;
        if (r9.changed(r52) == false) goto L96;
        r17 = 256;
    L96:
        r18 = r18 | r17;
    L99:
        if ((r57 & 3072) != 0) goto L106;
        if (r9.changed(r53) == false) goto L103;
        r19 = 2048;
    L103:
        r18 = r18 | r19;
    L106:
        if ((r57 & 24576) != 0) goto L113;
        if (r9.changedInstance(r54) == true) goto L111;
        r21 = 8192;
    L111:
        r18 = r18 | r21;
    L113:
        int r3 = r18;
        if ((r4 & 306783379) == 306783378) goto L116;
    L119:
        boolean r5 = true;
    L121:
        if (r9.shouldExecute(r5, r4 & 1) == true) goto L123;
        Composer r1 = r9;
        r1.skipToGroupEnd();
    L170:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L174;
        r13.updateScope(new ey(r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r56, r57));
        return;
    L174:
        return;
    L123:
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventStart(-1593438005, r4, r3, "androidx.compose.material3.ModalWideNavigationRailContent (WideNavigationRail.kt:988)");
    L126:
        if (r9.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L128;
        final boolean r6 = true;
    L129:
        final String r11 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911778), r9, 0);
        long r110 = r47.m3610getModalContainerColor0d7_KjU();
        long r22 = r47.m3611getModalContentColor0d7_KjU();
        Modifier r12 = SizeKt.fillMaxHeight$default(SizeKt.m1021widthInVpY3zN4$default(r45, MenuKt.ClosedAlphaTarget, r49, 1, null), MenuKt.ClosedAlphaTarget, 1, null);
        boolean r14 = r9.changed(r11);
        Object r15 = r9.rememberedValue();
        if (r14 == false) goto L132;
    L133:
        r15 = new ay(r11);
        r9.updateRememberedValue(r15);
    L134:
        Modifier r20 = SemanticsModifierKt.semantics$default(r12, false, (Function1) r15, 1, null);
        if ((r4 & 896) != 256) goto L137;
    L142:
        boolean r23 = true;
    L143:
        boolean r27 = r23 | r9.changedInstance(r46);
        if ((r4 & 7168) != 2048) goto L146;
        boolean r28 = true;
    L147:
        boolean r29 = (r27 | r28) | r9.changed(r6);
        Object r30 = r9.rememberedValue();
        if (r29 == false) goto L150;
    L151:
        r30 = new cy(r42, r46, r43, r6);
        r9.updateRememberedValue(r30);
    L152:
        Modifier r31 = GraphicsLayerModifierKt.graphicsLayer(r20, (Function1) r30);
        AnchoredDraggableState<WideNavigationRailValue> r32 = r46.getAnchoredDraggableState$material3();
        Orientation r33 = Orientation.Horizontal;
        if ((r4 & 112) != 32) goto L155;
        boolean r34 = true;
    L156:
        boolean r35 = (r34 | r9.changed(r6)) | r9.changedInstance(r46);
        Object r111 = r9.rememberedValue();
        if (r35 == false) goto L159;
    L160:
        r111 = new dy(r41, r6, r46);
        r9.updateRememberedValue(r111);
    L161:
        Modifier r210 = AnchoredDraggableKt.draggableAnchors(r31, r32, r33, (Function2) r111);
        DraggableState r211 = r46.getAnchoredDraggableState$material3().getDraggableState$material3();
        boolean r36 = r46.getAnchoredDraggableState$material3().isAnimationRunning();
        boolean r37 = r9.changedInstance(r44);
        Object r38 = r9.rememberedValue();
        if (r37 == false) goto L164;
    L165:
        r38 = new WideNavigationRailKt$ModalWideNavigationRailContent$4$1(r44, null);
        r9.updateRememberedValue(r38);
    L166:
        r1 = r9;
        SurfaceKt.m3213SurfaceT9BRK9s(DraggableKt.draggable$default(r210, r211, r33, r52, null, r36, null, (Function3) r38, false, 168, null), r48, r110, r22, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(-1043835354, true, new WideNavigationRailKt$ModalWideNavigationRailContent$5(r42, r43, r6, r40, r47, r48, r50, r51, r53, r54), r1, 54), r1, ((r4 >> 21) & 112) | 12582912, 112);
        if (ComposerKt.isTraceInProgress() == false) goto L170;
        ComposerKt.traceEventEnd();
        goto L170
    L164:
        if (r38 != Composer.Companion.getEmpty()) goto L166;
    L159:
        if (r111 != Composer.Companion.getEmpty()) goto L161;
    L155:
        r34 = false;
        goto L156
    L150:
        if (r30 != Composer.Companion.getEmpty()) goto L152;
    L146:
        r28 = false;
        goto L147
    L137:
        if ((r4 & 512) != 0) goto L139;
    L141:
        r23 = false;
        goto L143
    L139:
        if (r9.changedInstance(r42) == false) goto L141;
    L132:
        if (r15 != Composer.Companion.getEmpty()) goto L134;
    L128:
        r6 = false;
        goto L129
    L116:
        if ((r3 & 9363) != 9362) goto L119;
        r5 = false;
        goto L121
    L80:
        if (r9.changedInstance(r50) == false) goto L82;
        int r112 = 4;
    L83:
        r18 = r57 | r112;
        goto L86
    L82:
        r112 = 2;
        goto L83
    L30:
        if (r9.changed(r43) == false) goto L32;
        int r39 = 2048;
    L33:
        r4 = r4 | r39;
        goto L34
    L32:
        r39 = 1024;
        goto L33
    L20:
        if ((r56 & 512) != 0) goto L22;
        boolean r58 = r9.changed(r42);
    L23:
        if (r58 == false) goto L25;
        int r59 = 256;
    L26:
        r4 = r4 | r59;
        goto L27
    L25:
        r59 = 128;
        goto L26
    L22:
        r58 = r9.changedInstance(r42);
        goto L23
    L13:
        if (r9.changed(r41) == false) goto L15;
        int r60 = 32;
    L16:
        r4 = r4 | r60;
        goto L17
    L15:
        r60 = 16;
        goto L16
    L5:
        if (r9.changed(r40) == false) goto L7;
        int r61 = 4;
    L8:
        r4 = r61 | r56;
        goto L10
    L7:
        r61 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$ModalWideNavigationRailContent-pU6N4AM, reason: not valid java name */
    public static final /* synthetic */ void m3620access$ModalWideNavigationRailContentpU6N4AM(boolean r0, boolean r1, Animatable r2, RailPredictiveBackState r3, Function2 r4, Modifier r5, ModalWideNavigationRailState r6, WideNavigationRailColors r7, Shape r8, float r9, Function2 r10, WindowInsets r11, boolean r12, Arrangement.Vertical r13, Function2 r14, Composer r15, int r16, int r17) {
        m3617ModalWideNavigationRailContentpU6N4AM(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
