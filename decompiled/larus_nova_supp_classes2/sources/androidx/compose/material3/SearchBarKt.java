package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.PredictiveBack;
import androidx.compose.material3.internal.PredictiveBackState;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.MotionTokens;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\\\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001ar\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0099\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b!\u0010\"\u001a\u0084\u0001\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020$2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b*\u0010+\u001a\u008e\u0001\u0010,\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b-\u0010.\u001a7\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u0002012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u000204032\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0007¢\u0006\u0002\u00106\u001a\u0090\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010;\u001a\u00020(2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020(2\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bC\u0010D\u001a\u0086\u0002\u0010,\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010;\u001a\u00020(2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020(2\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bE\u0010F\u001aÄ\u0001\u0010K\u001a\u00020\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0001¢\u0006\u0004\bV\u0010W\u001a \u0001\u0010X\u001a\u00020\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010Y\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010Z\u001ap\u0010[\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\b\\\u0010]\u001a\u0080\u0001\u0010^\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\ba\u0010b\u001a\u000e\u0010c\u001a\u000204*\u0004\u0018\u00010dH\u0002\u001a#\u0010j\u001a\u00020\u00012\u0006\u0010A\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010m\u001a-\u0010n\u001a\u0002042\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010o\u001a\u0002042\u0006\u0010O\u001a\u000204H\u0002¢\u0006\u0002\u0010p\u001aG\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020r2\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010v\u001a\u00020w2\u0006\u0010o\u001a\u0002042\u0006\u0010x\u001a\u000204H\u0002¢\u0006\u0004\by\u0010z\u001aW\u0010{\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020r2\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u000e\u0010Q\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010|\u001a\u00020r2\u0006\u0010}\u001a\u00020r2\u0006\u0010x\u001a\u000204H\u0002¢\u0006\u0004\b~\u0010\u007f\"\u001e\u0010G\u001a\u00020(*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bH\u0010I\u001a\u0004\bG\u0010J\"\u001e\u0010e\u001a\u00020f*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bg\u0010I\u001a\u0004\bh\u0010i\"\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000f\u0010\u0082\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0083\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0084\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0085\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u001a\u0010\u0089\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u001a\u0010\u008c\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u008d\u0001\u0010\u0087\u0001\"\u000f\u0010\u008e\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u008f\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0090\u0001\u0010\u0087\u0001\"\u0012\u0010\u0091\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u001a\u0010\u0092\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0093\u0001\u0010\u0087\u0001\"\u0012\u0010\u0094\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0095\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0096\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0097\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0098\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0099\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u009a\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u009b\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u009e\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0001²\u0006\u000b\u0010«\u0001\u001a\u00020(X\u008a\u0084\u0002²\u0006\u000b\u0010¬\u0001\u001a\u00020(X\u008a\u0084\u0002²\u0006\f\u0010\u00ad\u0001\u001a\u00030®\u0001X\u008a\u0084\u0002"}, d2 = {"SearchBar", "", "state", "Landroidx/compose/material3/SearchBarState;", "inputField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "SearchBar-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/runtime/Composer;II)V", "TopSearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "scrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "TopSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/SearchBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "ExpandedFullScreenSearchBar", "collapsedShape", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ExpandedFullScreenSearchBar-_UtchM0", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ExpandedDockedSearchBar", "Landroidx/compose/ui/window/PopupProperties;", "ExpandedDockedSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "expanded", "", "onExpandedChange", "SearchBar-Y92LkZI", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DockedSearchBar", "DockedSearchBar-EQC0FA8", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSearchBarState", "initialValue", "Landroidx/compose/material3/SearchBarValue;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpecForCollapse", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarState;", "query", "", "onQueryChange", "onSearch", "active", "onActiveChange", "enabled", "placeholder", "leadingIcon", "trailingIcon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "isExpanded", "isExpanded$annotations", "(Landroidx/compose/material3/SearchBarState;)V", "(Landroidx/compose/material3/SearchBarState;)Z", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DockedSearchBarLayout", "DockedSearchBarLayout-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "FullScreenSearchBarLayout", "predictiveBackState", "Landroidx/compose/material3/internal/PredictiveBackState;", "FullScreenSearchBarLayout-EQC0FA8", "(Landroidx/compose/material3/SearchBarState;Landroidx/compose/material3/internal/PredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "transform", "Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "collapsedBounds", "Landroidx/compose/ui/unit/IntRect;", "getCollapsedBounds$annotations", "getCollapsedBounds", "(Landroidx/compose/material3/SearchBarState;)Landroidx/compose/ui/unit/IntRect;", "DetectClickFromInteractionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "onClick", "(Landroidx/compose/foundation/interaction/InteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", "progress", "(Landroidx/activity/BackEventCompat;FF)F", "calculatePredictiveBackOffsetX", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "LayoutIdInputField", "LayoutIdSurface", "LayoutIdSearchContent", "SearchBarAsTopBarPadding", "getSearchBarAsTopBarPadding", "()F", "F", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "DockedExpandedTableMinHeight", "getDockedExpandedTableMinHeight", "DockedExpandedTableMaxHeightScreenRatio", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarMaxWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "SearchBarIconOffsetX", "SearchBarPredictiveBackMinScale", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "AnimationEnterDurationMillis", "AnimationExitDurationMillis", "AnimationDelayMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationExitEasing", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "AnimationExitFloatSpec", "AnimationPredictiveBackExitFloatSpec", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitSizeSpec", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "material3", "useFullScreenShape", "showContent", "backEvent", "Landroidx/compose/material3/internal/BackEventProgress;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SearchBarKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing = null;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec = null;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec = null;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing = null;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec = null;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec = null;
    private static final FiniteAnimationSpec<Float> AnimationPredictiveBackExitFloatSpec = null;
    private static final EnterTransition DockedEnterTransition = null;
    private static final ExitTransition DockedExitTransition = null;
    private static final float DockedExpandedTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedExpandedTableMinHeight = 0.0f;
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    private static final float SearchBarAsTopBarPadding = 0.0f;
    private static final float SearchBarCornerRadius = 0.0f;
    private static final float SearchBarIconOffsetX = 0.0f;
    private static final float SearchBarMaxWidth = 0.0f;
    private static final float SearchBarMinWidth = 0.0f;
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    private static final float SearchBarPredictiveBackMaxOffsetY = 0.0f;
    private static final float SearchBarPredictiveBackMinMargin = 0.0f;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final float SearchBarVerticalPadding = 0.0f;
    private static final TextFieldColors UnspecifiedTextFieldColors = null;

    public static /* synthetic */ Unit A(SearchBarState r0, Function2 r1, Modifier r2, Shape r3, SearchBarColors r4, float r5, float r6, int r7, int r8, Composer r9, int r10) {
        return SearchBar_nbWgWpA$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit B(String r1, Function1 r2, Function1 r3, boolean r4, Function1 r5, Modifier r6, boolean r7, Function2 r8, Function2 r9, Function2 r10, Shape r11, SearchBarColors r12, float r13, float r14, WindowInsets r15, MutableInteractionSource r16, Function3 r17, int r18, int r19, int r20, Composer r21, int r22) {
        return SearchBar_WuY5d9Q$lambda$28(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    private static final Unit DetectClickFromInteractionSource$lambda$73(InteractionSource r0, Function0 r1, int r2, Composer r3, int r4) {
        DetectClickFromInteractionSource(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit DockedSearchBarLayout_nbWgWpA$lambda$52(SearchBarState r11, Function2 r12, Modifier r13, Shape r14, SearchBarColors r15, float r16, float r17, Function3 r18, int r19, Composer r20, int r21) {
        m3053DockedSearchBarLayoutnbWgWpA(r11, r12, r13, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit DockedSearchBar_EQC0FA8$lambda$25(Function2 r13, boolean r14, Function1 r15, Modifier r16, Shape r17, SearchBarColors r18, float r19, float r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m3051DockedSearchBarEQC0FA8(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit DockedSearchBar_eWTbjVg$lambda$29(String r20, Function1 r21, Function1 r22, boolean r23, Function1 r24, Modifier r25, boolean r26, Function2 r27, Function2 r28, Function2 r29, Shape r30, SearchBarColors r31, float r32, float r33, MutableInteractionSource r34, Function3 r35, int r36, int r37, int r38, Composer r39, int r40) {
        m3052DockedSearchBareWTbjVg(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r39, RecomposeScopeImplKt.updateChangedFlags(r36 | 1), RecomposeScopeImplKt.updateChangedFlags(r37), r38);
        return Unit.INSTANCE;
    }

    private static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$10(SearchBarState r13, Function2 r14, Modifier r15, Shape r16, SearchBarColors r17, float r18, float r19, PopupProperties r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m3054ExpandedDockedSearchBarqKj4JfE(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$14(SearchBarState r13, Function2 r14, Modifier r15, Shape r16, SearchBarColors r17, float r18, float r19, PopupProperties r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m3054ExpandedDockedSearchBarqKj4JfE(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$6(SearchBarState r14, Function2 r15, Modifier r16, Shape r17, SearchBarColors r18, float r19, float r20, Function2 r21, DialogProperties r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m3055ExpandedFullScreenSearchBar_UtchM0(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$9(SearchBarState r14, Function2 r15, Modifier r16, Shape r17, SearchBarColors r18, float r19, float r20, Function2 r21, DialogProperties r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m3055ExpandedFullScreenSearchBar_UtchM0(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$70(SearchBarState r13, PredictiveBackState r14, Function2 r15, Modifier r16, Shape r17, SearchBarColors r18, float r19, float r20, WindowInsets r21, Function3 r22, int r23, Composer r24, int r25) {
        m3056FullScreenSearchBarLayoutEQC0FA8(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, RecomposeScopeImplKt.updateChangedFlags(r23 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SearchBarImpl_j1jLAyQ$lambda$39(Animatable r17, MutableFloatState r18, MutableState r19, MutableState r20, Modifier r21, Function2 r22, Shape r23, SearchBarColors r24, float r25, float r26, WindowInsets r27, Function3 r28, int r29, int r30, int r31, Composer r32, int r33) {
        m3060SearchBarImplj1jLAyQ(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit SearchBarLayout$lambda$49(Animatable r12, MutableFloatState r13, MutableState r14, MutableState r15, Modifier r16, WindowInsets r17, Function2 r18, Function2 r19, Function2 r20, int r21, Composer r22, int r23) {
        SearchBarLayout(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SearchBar_WuY5d9Q$lambda$28(String r21, Function1 r22, Function1 r23, boolean r24, Function1 r25, Modifier r26, boolean r27, Function2 r28, Function2 r29, Function2 r30, Shape r31, SearchBarColors r32, float r33, float r34, WindowInsets r35, MutableInteractionSource r36, Function3 r37, int r38, int r39, int r40, Composer r41, int r42) {
        m3057SearchBarWuY5d9Q(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r41, RecomposeScopeImplKt.updateChangedFlags(r38 | 1), RecomposeScopeImplKt.updateChangedFlags(r39), r40);
        return Unit.INSTANCE;
    }

    private static final Unit SearchBar_Y92LkZI$lambda$22(Function2 r14, boolean r15, Function1 r16, Modifier r17, Shape r18, SearchBarColors r19, float r20, float r21, WindowInsets r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m3058SearchBarY92LkZI(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit SearchBar_nbWgWpA$lambda$2(SearchBarState r11, Function2 r12, Modifier r13, Shape r14, SearchBarColors r15, float r16, float r17, int r18, int r19, Composer r20, int r21) {
        m3059SearchBarnbWgWpA(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit TopSearchBar_qKj4JfE$lambda$5(SearchBarState r13, Function2 r14, Modifier r15, Shape r16, SearchBarColors r17, float r18, float r19, WindowInsets r20, SearchBarScrollBehavior r21, int r22, int r23, Composer r24, int r25) {
        m3061TopSearchBarqKj4JfE(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(String r1, Function1 r2, Function1 r3, boolean r4, Function1 r5, Modifier r6, boolean r7, Function2 r8, Function2 r9, Function2 r10, Shape r11, SearchBarColors r12, float r13, float r14, MutableInteractionSource r15, Function3 r16, int r17, int r18, int r19, Composer r20, int r21) {
        return DockedSearchBar_eWTbjVg$lambda$29(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ Unit b(Shape r0, Shape r1, Density r2, SearchBarState r3, MutableState r4, Path r5, Size r6, LayoutDirection r7) {
        return FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit c(Function2 r0, boolean r1, Function1 r2, Modifier r3, Shape r4, SearchBarColors r5, float r6, float r7, WindowInsets r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return SearchBar_Y92LkZI$lambda$22(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit d(SearchBarState r0, Function2 r1, Modifier r2, Shape r3, SearchBarColors r4, float r5, float r6, Function2 r7, DialogProperties r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return ExpandedFullScreenSearchBar__UtchM0$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit e(SearchBarState r0, PredictiveBackState r1, Function2 r2, Modifier r3, Shape r4, SearchBarColors r5, float r6, float r7, WindowInsets r8, Function3 r9, int r10, Composer r11, int r12) {
        return FullScreenSearchBarLayout_EQC0FA8$lambda$70(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit f(InteractionSource r0, Function0 r1, int r2, Composer r3, int r4) {
        return DetectClickFromInteractionSource$lambda$73(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean g(Animatable r0) {
        return SearchBarImpl_j1jLAyQ$lambda$31$lambda$30(r0);
    }

    private static /* synthetic */ void getCollapsedBounds$annotations(SearchBarState r0) {
    }

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    public static /* synthetic */ BackEventProgress h(PredictiveBackState r0) {
        return FullScreenSearchBarLayout_EQC0FA8$lambda$54$lambda$53(r0);
    }

    public static /* synthetic */ Unit i(Animatable r0, MutableFloatState r1, MutableState r2, MutableState r3, Modifier r4, WindowInsets r5, Function2 r6, Function2 r7, Function2 r8, int r9, Composer r10, int r11) {
        return SearchBarLayout$lambda$49(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    private static /* synthetic */ void isExpanded$annotations(SearchBarState r0) {
    }

    public static /* synthetic */ Unit j(CoroutineScope r0, SearchBarState r1) {
        return ExpandedFullScreenSearchBar__UtchM0$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit k(SearchBarState r0, Function2 r1, Modifier r2, Shape r3, SearchBarColors r4, float r5, float r6, Function3 r7, int r8, Composer r9, int r10) {
        return DockedSearchBarLayout_nbWgWpA$lambda$52(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit l(CoroutineScope r0, SearchBarState r1) {
        return DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(r0, r1);
    }

    public static /* synthetic */ Unit m(SearchBarState r0, Function2 r1, Modifier r2, Shape r3, SearchBarColors r4, float r5, float r6, PopupProperties r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return ExpandedDockedSearchBar_qKj4JfE$lambda$10(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit n(Density r0, Animatable r1, Path r2, Size r3, LayoutDirection r4) {
        return SearchBarImpl_j1jLAyQ$lambda$35$lambda$34(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit o(SearchBarState r0, Function2 r1, Modifier r2, Shape r3, SearchBarColors r4, float r5, float r6, WindowInsets r7, SearchBarScrollBehavior r8, int r9, int r10, Composer r11, int r12) {
        return TopSearchBar_qKj4JfE$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit p(CoroutineScope r0, SearchBarState r1) {
        return ExpandedDockedSearchBar_qKj4JfE$lambda$13$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit q(SearchBarState r0, LayoutCoordinates r1) {
        return SearchBar_nbWgWpA$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit r(Function2 r0, boolean r1, Function1 r2, Modifier r3, Shape r4, SearchBarColors r5, float r6, float r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return DockedSearchBar_EQC0FA8$lambda$25(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ SearchBarState s(SearchBarValue r0, AnimationSpec r1, AnimationSpec r2) {
        return rememberSearchBarState$lambda$27$lambda$26(r0, r1, r2);
    }

    public static /* synthetic */ Unit t(MutableWindowInsets r0, WindowInsets r1, WindowInsets r2) {
        return SearchBarLayout$lambda$42$lambda$41(r0, r1, r2);
    }

    public static /* synthetic */ Unit u(Animatable r1, MutableFloatState r2, MutableState r3, MutableState r4, Modifier r5, Function2 r6, Shape r7, SearchBarColors r8, float r9, float r10, WindowInsets r11, Function3 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return SearchBarImpl_j1jLAyQ$lambda$39(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit v(Function1 r0) {
        return DockedSearchBar_EQC0FA8$lambda$24$lambda$23(r0);
    }

    public static /* synthetic */ Unit w(SearchBarState r0, Function2 r1, Modifier r2, Shape r3, SearchBarColors r4, float r5, float r6, PopupProperties r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return ExpandedDockedSearchBar_qKj4JfE$lambda$14(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit x(SearchBarState r0, Function2 r1, Modifier r2, Shape r3, SearchBarColors r4, float r5, float r6, Function2 r7, DialogProperties r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return ExpandedFullScreenSearchBar__UtchM0$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit y(MutableWindowInsets r0, WindowInsets r1, WindowInsets r2) {
        return FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(r0, r1, r2);
    }

    public static /* synthetic */ boolean z(Animatable r0) {
        return SearchBarImpl_j1jLAyQ$lambda$37$lambda$36(r0);
    }

    static {
        Color.Companion r84 = Color.Companion;
        UnspecifiedTextFieldColors = new TextFieldColors(r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), new TextSelectionColors(r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), null), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), r84.getUnspecified-0d7_KjU(), null);
        float r0 = 8;
        SearchBarAsTopBarPadding = Dp.constructor-impl(r0);
        SearchBarCornerRadius = Dp.constructor-impl(SearchBarDefaults.INSTANCE.m3044getInputFieldHeightD9Ej5fM() / 2);
        DockedExpandedTableMinHeight = Dp.constructor-impl(240);
        SearchBarMinWidth = Dp.constructor-impl(360);
        SearchBarMaxWidth = Dp.constructor-impl(720);
        SearchBarVerticalPadding = Dp.constructor-impl(r0);
        SearchBarIconOffsetX = Dp.constructor-impl(4);
        SearchBarPredictiveBackMinMargin = Dp.constructor-impl(r0);
        SearchBarPredictiveBackMaxOffsetY = Dp.constructor-impl(24);
        CubicBezierEasing r1 = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = r1;
        CubicBezierEasing r2 = new CubicBezierEasing(MenuKt.ClosedAlphaTarget, 1.0f, MenuKt.ClosedAlphaTarget, 1.0f);
        AnimationExitEasing = r2;
        TweenSpec r6 = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, r1);
        AnimationEnterFloatSpec = r6;
        TweenSpec r8 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, r2);
        AnimationExitFloatSpec = r8;
        AnimationPredictiveBackExitFloatSpec = AnimationSpecKt.tween$default(AnimationExitDurationMillis, 0, r2, 2, null);
        TweenSpec r11 = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, r1);
        AnimationEnterSizeSpec = r11;
        TweenSpec r3 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, r2);
        AnimationExitSizeSpec = r3;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(r6, MenuKt.ClosedAlphaTarget, 2, null).plus(EnterExitTransitionKt.expandVertically$default(r11, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(r8, MenuKt.ClosedAlphaTarget, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(r3, null, false, null, 14, null));
    }

    public static final /* synthetic */ FiniteAnimationSpec access$getAnimationEnterFloatSpec$p() {
        return AnimationEnterFloatSpec;
    }

    public static final /* synthetic */ FiniteAnimationSpec access$getAnimationExitFloatSpec$p() {
        return AnimationExitFloatSpec;
    }

    public static final /* synthetic */ FiniteAnimationSpec access$getAnimationPredictiveBackExitFloatSpec$p() {
        return AnimationPredictiveBackExitFloatSpec;
    }

    public static final /* synthetic */ EnterTransition access$getDockedEnterTransition$p() {
        return DockedEnterTransition;
    }

    public static final /* synthetic */ ExitTransition access$getDockedExitTransition$p() {
        return DockedExitTransition;
    }

    public static final /* synthetic */ float access$getSearchBarIconOffsetX$p() {
        return SearchBarIconOffsetX;
    }

    public static final /* synthetic */ float access$getSearchBarMaxWidth$p() {
        return SearchBarMaxWidth;
    }

    public static final /* synthetic */ float access$getSearchBarPredictiveBackMaxOffsetY$p() {
        return SearchBarPredictiveBackMaxOffsetY;
    }

    public static final /* synthetic */ float access$getSearchBarPredictiveBackMinMargin$p() {
        return SearchBarPredictiveBackMinMargin;
    }

    public static final /* synthetic */ TextFieldColors access$getUnspecifiedTextFieldColors$p() {
        return UnspecifiedTextFieldColors;
    }

    public static final float getDockedExpandedTableMinHeight() {
        return DockedExpandedTableMinHeight;
    }

    public static final float getSearchBarAsTopBarPadding() {
        return SearchBarAsTopBarPadding;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    private static final Unit DockedSearchBar_EQC0FA8$lambda$24$lambda$23(Function1 r1) {
        r1.invoke(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private static final BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$54$lambda$53(PredictiveBackState r0) {
        return r0.getValue();
    }

    private static final BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$55(State<? extends BackEventProgress> r0) {
        return (BackEventProgress) r0.getValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$31$lambda$30(Animatable r1) {
        if (((Number) r1.getValue()).floatValue() != 1.0f) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$32(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$37$lambda$36(Animatable r1) {
        if (((Number) r1.getValue()).floatValue() <= MenuKt.ClosedAlphaTarget) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$38(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    public static final /* synthetic */ IntRect access$getCollapsedBounds(SearchBarState r0) {
        return getCollapsedBounds(r0);
    }

    public static final /* synthetic */ boolean access$isExpanded(SearchBarState r0) {
        return isExpanded(r0);
    }

    public static final /* synthetic */ float access$transform(BackEventProgress.InProgress r0) {
        return transform(r0);
    }

    private static final IntRect getCollapsedBounds(SearchBarState r4) {
        LayoutCoordinates r5 = r4.getCollapsedCoords();
        if (r5 == null) goto L7;
        IntRect r6 = IntRectKt.IntRect-VbeCjmY(IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionInWindow(r5)), r5.getSize-YbymL2g());
        if (r6 == null) goto L7;
        return r6;
    L7:
        return IntRect.Companion.getZero();
    }

    private static final boolean isExpanded(SearchBarState r1) {
        if (r1.getCurrentValue() != SearchBarValue.Expanded) goto L5;
        return true;
    L5:
        return false;
    }

    private static final float transform(BackEventProgress.InProgress r1) {
        if (r1 != null) goto L5;
        return MenuKt.ClosedAlphaTarget;
    L5:
        return PredictiveBack.INSTANCE.transform$material3(r1.getProgress());
    }

    private static final Unit DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(CoroutineScope r6, SearchBarState r7) {
        BuildersKt.launch$default(r6, null, null, new SearchBarKt$DockedSearchBarLayout$1$1$1(r7, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$13$lambda$12(CoroutineScope r6, SearchBarState r7) {
        BuildersKt.launch$default(r6, null, null, new SearchBarKt$ExpandedDockedSearchBar$2$1$1(r7, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$8$lambda$7(CoroutineScope r6, SearchBarState r7) {
        BuildersKt.launch$default(r6, null, null, new SearchBarKt$ExpandedFullScreenSearchBar$3$1$1(r7, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit SearchBar_nbWgWpA$lambda$1$lambda$0(SearchBarState r0, LayoutCoordinates r1) {
        r0.setCollapsedCoords(r1);
        return Unit.INSTANCE;
    }

    private static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(MutableWindowInsets r0, WindowInsets r1, WindowInsets r2) {
        r0.setInsets(WindowInsetsKt.exclude(r1, r2));
        return Unit.INSTANCE;
    }

    private static final Unit SearchBarLayout$lambda$42$lambda$41(MutableWindowInsets r0, WindowInsets r1, WindowInsets r2) {
        r0.setInsets(WindowInsetsKt.exclude(r1, r2));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ float access$calculatePredictiveBackMultiplier(BackEventCompat r0, float r1, float r2) {
        return calculatePredictiveBackMultiplier(r0, r1, r2);
    }

    private static final float calculatePredictiveBackMultiplier(BackEventCompat r1, float r2, float r3) {
        if (r1 != null) goto L6;
        return MenuKt.ClosedAlphaTarget;
    L6:
        if (Float.isNaN(r3) == false) goto L9;
        return 1.0f;
    L9:
        if (r3 > MenuKt.ClosedAlphaTarget) goto L12;
        return MenuKt.ClosedAlphaTarget;
    L12:
        return r2 / r3;
    }

    private static final SearchBarState rememberSearchBarState$lambda$27$lambda$26(SearchBarValue r1, AnimationSpec r2, AnimationSpec r3) {
        return new SearchBarState(r1, r2, r3);
    }

    private static final void DetectClickFromInteractionSource(final InteractionSource r8, final Function0<Unit> r9, Composer r10, final int r11) {
        Composer r12 = r10.startRestartGroup(-652650823);
        if ((r11 & 6) == 0) goto L5;
        int r1 = r11;
    L11:
        if ((r11 & 48) == 0) goto L13;
    L17:
        boolean r6 = false;
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r12.shouldExecute(r3, r1 & 1) == true) goto L24;
        r12.skipToGroupEnd();
    L42:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L46;
        r13.updateScope(new em(r8, r9, r11));
        return;
    L46:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-652650823, r1, -1, "androidx.compose.material3.DetectClickFromInteractionSource (SearchBar.kt:2592)");
    L26:
        int r0 = r1 & 14;
        if (r0 != 4) goto L29;
        boolean r2 = true;
    L31:
        if ((r1 & 112) != 32) goto L33;
        r6 = true;
    L33:
        boolean r4 = r2 | r6;
        Object r5 = r12.rememberedValue();
        if (r4 == false) goto L36;
    L37:
        r5 = new SearchBarKt$DetectClickFromInteractionSource$1$1(r8, r9, null);
        r12.updateRememberedValue(r5);
    L38:
        EffectsKt.LaunchedEffect(r8, (Function2) r5, r12, r0);
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventEnd();
        goto L42
    L36:
        if (r5 != Composer.Companion.getEmpty()) goto L38;
    L29:
        r2 = false;
        goto L31
    L20:
        r3 = false;
        goto L22
    L13:
        if (r12.changedInstance(r9) == false) goto L15;
        int r7 = 32;
    L16:
        r1 = r1 | r7;
        goto L17
    L15:
        r7 = 16;
        goto L16
    L5:
        if (r12.changed(r8) == false) goto L7;
        int r14 = 4;
    L8:
        r1 = r14 | r11;
        goto L11
    L7:
        r14 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$DetectClickFromInteractionSource(InteractionSource r0, Function0 r1, Composer r2, int r3) {
        DetectClickFromInteractionSource(r0, r1, r2, r3);
    }

    private static final Unit SearchBarImpl_j1jLAyQ$lambda$35$lambda$34(Density r4, Animatable r5, Path r6, Size r7, LayoutDirection r8) {
        float r9 = r4.toPx-0680j_4(Dp.constructor-impl(SearchBarCornerRadius * (1 - ((Number) r5.getValue()).floatValue())));
        Path.-CC.addRoundRect$default(r6, RoundRectKt.RoundRect-sniSvfs(SizeKt.toRect-uvyYCjk(r7.unbox-impl()), CornerRadius.constructor-impl((Float.floatToRawIntBits(r9) << 32) | (((long) Float.floatToRawIntBits(r9)) & 4294967295L))), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$calculatePredictiveBackOffsetX-rOvwMX4, reason: not valid java name */
    public static final /* synthetic */ int m3064access$calculatePredictiveBackOffsetXrOvwMX4(long r0, int r2, BackEventCompat r3, LayoutDirection r4, float r5, float r6) {
        return m3066calculatePredictiveBackOffsetXrOvwMX4(r0, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: calculatePredictiveBackOffsetX-rOvwMX4, reason: not valid java name */
    private static final int m3066calculatePredictiveBackOffsetXrOvwMX4(long r3, int r5, BackEventCompat r6, LayoutDirection r7, float r8, float r9) {
        if (r6 != null) goto L5;
    L19:
        return 0;
    L5:
        if (r9 != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L19;
        int r0 = -1;
        if (r6.getSwipeEdge() != 0) goto L13;
        int r10 = 1;
    L15:
        if (r7 != LayoutDirection.Ltr) goto L18;
        r0 = 1;
    L18:
        return MathKt.roundToInt((((((Constraints.getMaxWidth-impl(r3) * SearchBarPredictiveBackMaxOffsetXRatio) - r5) * (1 - r8)) * r9) * r10) * r0);
    L13:
        r10 = -1;
        goto L15
    L7:
        r1 = false;
        goto L8
    }

    public static final SearchBarState rememberSearchBarState(final SearchBarValue r6, final AnimationSpec<Float> r7, final AnimationSpec<Float> r8, Composer r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r6 = SearchBarValue.Collapsed;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r7 = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowSpatial, r9, 6);
    L9:
        if ((r11 & 4) == 0) goto L12;
        r8 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r9, 6);
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(-546016819, r10, -1, "androidx.compose.material3.rememberSearchBarState (SearchBar.kt:819)");
    L14:
        boolean r3 = true;
        Object[] r12 = {r6, r7, r8};
        Saver<SearchBarState, ?> r4 = SearchBarState.Companion.Saver(r7, r8);
        if (((r10 & 14) ^ 6) <= 4) goto L19;
        if (r9.changed(r6.ordinal()) == false) goto L19;
    L22:
        boolean r13 = (r9.changedInstance(r7) | r3) | r9.changedInstance(r8);
        Object r0 = r9.rememberedValue();
        if (r13 == false) goto L25;
    L26:
        r0 = new pm(r6, r7, r8);
        r9.updateRememberedValue(r0);
    L27:
        SearchBarState r14 = (SearchBarState) RememberSaveableKt.rememberSaveable(r12, r4, (Function0) r0, r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
    L30:
        return r14;
    L25:
        if (r0 != Composer.Companion.getEmpty()) goto L27;
    L19:
        if ((r10 & 6) == 4) goto L22;
        r3 = false;
        goto L22
    }

    /* JADX INFO: renamed from: access$calculatePredictiveBackOffsetY-dzo92Q0, reason: not valid java name */
    public static final /* synthetic */ int m3065access$calculatePredictiveBackOffsetYdzo92Q0(long r0, int r2, BackEventCompat r3, BackEventCompat r4, int r5, int r6, float r7) {
        return m3067calculatePredictiveBackOffsetYdzo92Q0(r0, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: calculatePredictiveBackOffsetY-dzo92Q0, reason: not valid java name */
    private static final int m3067calculatePredictiveBackOffsetYdzo92Q0(long r2, int r4, BackEventCompat r5, BackEventCompat r6, int r7, int r8, float r9) {
        if (r6 == null) goto L13;
        if (r5 == null) goto L13;
        if (r9 != MenuKt.ClosedAlphaTarget) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        int r10 = Math.min(Math.max(0, ((Constraints.getMaxHeight-impl(r2) - r7) / 2) - r4), r8);
        float r11 = r5.getTouchY() - r6.getTouchY();
        float r12 = Math.abs(r11) / Constraints.getMaxHeight-impl(r2);
        return MathKt.roundToInt((MathHelpersKt.lerp(0, r10, r12) * r9) * Math.signum(r11));
    L8:
        r1 = false;
    L13:
        return 0;
    }

    private static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(Shape r5, Shape r6, Density r7, SearchBarState r8, MutableState r9, Path r10, Size r11, LayoutDirection r12) {
        if (r5 != RoundedCornerShapeKt.getCircleShape()) goto L11;
        if (r6 != RectangleShapeKt.getRectangleShape()) goto L11;
        float r13 = r7.toPx-0680j_4(Dp.constructor-impl(SearchBarCornerRadius * Math.max(1 - r8.getProgress(), transform((BackEventProgress.InProgress) r9.getValue()))));
        if (r13 >= 0.001d) goto L9;
        Path.-CC.addRect$default(r10, SizeKt.toRect-uvyYCjk(r11.unbox-impl()), null, 2, null);
    L16:
        return Unit.INSTANCE;
    L9:
        Path.-CC.addRoundRect$default(r10, RoundRectKt.RoundRect-sniSvfs(SizeKt.toRect-uvyYCjk(r11.unbox-impl()), CornerRadius.constructor-impl((Float.floatToRawIntBits(r13) << 32) | (((long) Float.floatToRawIntBits(r13)) & 4294967295L))), null, 2, null);
    L11:
        if (r8.getProgress() < 0.5f) goto L14;
        r5 = r6;
    L14:
        OutlineKt.addOutline(r10, r5.createOutline-Pq9zytI(r11.unbox-impl(), r12, r7));
        goto L16
    }

    /* JADX INFO: renamed from: DockedSearchBarLayout-nbWgWpA, reason: not valid java name */
    private static final void m3053DockedSearchBarLayoutnbWgWpA(final SearchBarState r23, final Function2<? super Composer, ? super Integer, Unit> r24, final Modifier r25, final Shape r26, final SearchBarColors r27, final float r28, final float r29, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32) {
        Composer r3 = r31.startRestartGroup(1402423467);
        if ((r32 & 6) == 0) goto L5;
        int r4 = r32;
    L11:
        if ((r32 & 48) != 0) goto L18;
        if (r3.changedInstance(r24) == false) goto L15;
        int r7 = 32;
    L16:
        r4 = r4 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r32 & 384) != 0) goto L26;
        if (r3.changed(r25) == false) goto L22;
        int r10 = 256;
    L23:
        r4 = r4 | r10;
        goto L26
    L22:
        r10 = 128;
    L26:
        if ((r32 & 3072) != 0) goto L33;
        if (r3.changed(r26) == false) goto L30;
        int r11 = 2048;
    L31:
        r4 = r4 | r11;
        goto L33
    L30:
        r11 = 1024;
    L33:
        if ((r32 & 24576) != 0) goto L40;
        if (r3.changed(r27) == false) goto L37;
        int r12 = 16384;
    L38:
        r4 = r4 | r12;
        goto L40
    L37:
        r12 = 8192;
    L40:
        if ((196608 & r32) != 0) goto L47;
        if (r3.changed(r28) == false) goto L44;
        int r13 = 131072;
    L45:
        r4 = r4 | r13;
        goto L47
    L44:
        r13 = 65536;
    L47:
        if ((1572864 & r32) != 0) goto L54;
        if (r3.changed(r29) == false) goto L51;
        int r14 = 1048576;
    L52:
        r4 = r4 | r14;
        goto L54
    L51:
        r14 = 524288;
    L54:
        if ((r32 & 12582912) != 0) goto L61;
        if (r3.changedInstance(r30) == false) goto L58;
        int r15 = 8388608;
    L59:
        r4 = r4 | r15;
        goto L61
    L58:
        r15 = 4194304;
    L61:
        if ((4793491 & r4) == 4793490) goto L63;
        boolean r16 = true;
    L65:
        if (r3.shouldExecute(r16, r4 & 1) == true) goto L67;
        r3.skipToGroupEnd();
    L85:
        ScopeUpdateScope r17 = r3.endRestartGroup();
        if (r17 == null) goto L89;
        r17.updateScope(new om(r23, r24, r25, r26, r27, r28, r29, r30, r32));
        return;
    L89:
        return;
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventStart(1402423467, r4, -1, "androidx.compose.material3.DockedSearchBarLayout (SearchBar.kt:2323)");
    L69:
        Object r0 = r3.rememberedValue();
        Composer.Companion r18 = Composer.Companion;
        if (r0 != r18.getEmpty()) goto L72;
        r0 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r3);
        r3.updateRememberedValue(r0);
    L72:
        final CoroutineScope r1 = (CoroutineScope) r0;
        boolean r19 = isExpanded(r23);
        boolean r110 = r3.changedInstance(r1);
        if ((r4 & 14) != 4) goto L75;
        boolean r6 = true;
    L76:
        boolean r8 = r110 | r6;
        Object r111 = r3.rememberedValue();
        if (r8 == false) goto L79;
    L80:
        r111 = new nm(r1, r23);
        r3.updateRememberedValue(r111);
    L81:
        BackHandler_androidKt.BackHandler(r19, (Function0) r111, r3, 0, 0);
        long r112 = r27.m3038getContainerColor0d7_KjU();
        long r113 = ColorSchemeKt.m2496contentColorForek8zF_U(r27.m3038getContainerColor0d7_KjU(), r3, 0);
        Modifier r114 = WindowInsetsPadding_androidKt.imePadding(r25);
        ComposableLambda r2 = ComposableLambdaKt.rememberComposableLambda(-956905210, true, new SearchBarKt$DockedSearchBarLayout$2(r24, r23, r27, r30), r3, 54);
        int r9 = ((r4 >> 6) & 112) | 12582912;
        int r5 = r4 >> 3;
        int r20 = r9 | (57344 & r5);
        SurfaceKt.m3213SurfaceT9BRK9s(r114, r26, r112, r113, r28, r29, null, r2, r3, (r5 & 458752) | r20, 64);
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventEnd();
        goto L85
    L79:
        if (r111 != r18.getEmpty()) goto L81;
    L75:
        r6 = false;
        goto L76
    L63:
        r16 = false;
        goto L65
    L5:
        if (r3.changed(r23) == false) goto L7;
        int r21 = 4;
    L8:
        r4 = r21 | r32;
        goto L11
    L7:
        r21 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: SearchBar-nbWgWpA, reason: not valid java name */
    public static final void m3059SearchBarnbWgWpA(final SearchBarState r26, final Function2<? super Composer, ? super Integer, Unit> r27, Modifier r28, Shape r29, SearchBarColors r30, float r31, float r32, Composer r33, final int r34, final int r35) {
        Composer r2 = r33.startRestartGroup(1234122643);
        if ((r35 & 1) == 0) goto L6;
        int r3 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r35 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r7 = r28;
    L36:
        if ((r34 & 3072) == 0) goto L38;
        Shape r9 = r29;
    L47:
        if ((r34 & 24576) == 0) goto L49;
        SearchBarColors r10 = r30;
    L57:
        int r18 = r35 & 32;
        if (r18 == 0) goto L60;
        r3 = r3 | 196608;
        float r15 = r31;
    L67:
        int r19 = r35 & 64;
        if (r19 == 0) goto L70;
        r3 = r3 | 1572864;
        float r14 = r32;
    L78:
        if ((599187 & r3) == 599186) goto L80;
        boolean r11 = true;
    L82:
        if (r2.shouldExecute(r11, r3 & 1) == false) goto L129;
        r2.startDefaults();
        if ((r34 & 1) != 0) goto L86;
    L95:
        if (r6 == 0) goto L97;
        Modifier r8 = Modifier.Companion;
    L99:
        if ((r35 & 8) == 0) goto L101;
        Shape r12 = SearchBarDefaults.INSTANCE.getInputFieldShape(r2, 6);
        r3 = r3 & (-7169);
    L103:
        if ((r35 & 16) == 0) goto L105;
        SearchBarColors r13 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r2, 3072, 7);
        r3 = r3 & (-57345);
    L106:
        if (r18 == 0) goto L108;
        float r16 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L109:
        if (r19 == 0) goto L111;
        float r23 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L112:
        SearchBarColors r25 = r13;
        int r17 = r3;
        SearchBarColors r4 = r25;
    L113:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(1234122643, r17, -1, "androidx.compose.material3.SearchBar (SearchBar.kt:232)");
    L117:
        if ((r17 & 14) != 4) goto L119;
        boolean r110 = true;
    L120:
        Object r0 = r2.rememberedValue();
        if (r110 == false) goto L123;
    L124:
        r0 = new yl(r26);
        r2.updateRememberedValue(r0);
    L125:
        int r111 = r17 >> 3;
        int r20 = ((((r17 >> 6) & 112) | (57344 & r111)) | (r111 & 458752)) | ((r17 << 18) & 29360128);
        Shape r112 = r12;
        SurfaceKt.m3213SurfaceT9BRK9s(OnGloballyPositionedModifierKt.onGloballyPositioned(r8, (Function1) r0), r112, r4.m3038getContainerColor0d7_KjU(), ColorSchemeKt.m2496contentColorForek8zF_U(r4.m3038getContainerColor0d7_KjU(), r2, 0), r16, r23, null, r27, r2, r20, 64);
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
    L128:
        r10 = r4;
        final Modifier r5 = r8;
        final Shape r21 = r12;
        final float r22 = r16;
        final float r24 = r23;
    L130:
        ScopeUpdateScope r113 = r2.endRestartGroup();
        if (r113 == null) goto L134;
        final SearchBarColors r36 = r10;
        r113.updateScope(new zl(r26, r27, r5, r21, r36, r22, r24, r34, r35));
        return;
    L134:
        return;
    L123:
        if (r0 != Composer.Companion.getEmpty()) goto L125;
    L119:
        r110 = false;
        goto L120
    L111:
        r23 = r32;
        goto L112
    L108:
        r16 = r31;
        goto L109
    L105:
        r13 = r10;
        goto L106
    L101:
        r12 = r9;
        goto L103
    L97:
        r8 = r7;
        goto L99
    L86:
        if (r2.getDefaultsInvalid() == true) goto L95;
        r2.skipToGroupEnd();
        if ((r35 & 8) == 0) goto L92;
        r3 = r3 & (-7169);
    L92:
        if ((r35 & 16) == 0) goto L94;
        r3 = r3 & (-57345);
    L94:
        r8 = r7;
        r12 = r9;
        r23 = r14;
        r16 = r15;
        r17 = r3;
        r4 = r10;
        goto L113
    L129:
        r2.skipToGroupEnd();
        r22 = r31;
        r5 = r7;
        r21 = r9;
        r24 = r32;
        goto L130
    L80:
        r11 = false;
        goto L82
    L70:
        r14 = r32;
        if ((1572864 & r34) != 0) goto L78;
        if (r2.changed(r14) == false) goto L75;
        int r114 = 1048576;
    L76:
        r3 = r3 | r114;
        goto L78
    L75:
        r114 = 524288;
        goto L76
    L60:
        r15 = r31;
        if ((196608 & r34) != 0) goto L67;
        if (r2.changed(r15) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
        goto L67
    L65:
        r115 = 65536;
        goto L66
    L49:
        if ((r35 & 16) != 0) goto L53;
        r10 = r30;
        if (r2.changed(r10) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
    L54:
        r116 = 8192;
        goto L55
    L53:
        r10 = r30;
        goto L54
    L38:
        if ((r35 & 8) != 0) goto L42;
        r9 = r29;
        if (r2.changed(r9) == false) goto L43;
        int r117 = 2048;
    L44:
        r3 = r3 | r117;
    L43:
        r117 = 1024;
        goto L44
    L42:
        r9 = r29;
        goto L43
    L28:
        if ((r34 & 384) != 0) goto L34;
        r7 = r28;
        if (r2.changed(r7) == false) goto L32;
        int r37 = 256;
    L33:
        r3 = r3 | r37;
        goto L36
    L32:
        r37 = 128;
        goto L33
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r2.changedInstance(r27) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r3 = r34;
        goto L14
    L8:
        if (r2.changed(r26) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r34;
        goto L14
    L10:
        r39 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: access$DockedSearchBarLayout-nbWgWpA, reason: not valid java name */
    public static final /* synthetic */ void m3062access$DockedSearchBarLayoutnbWgWpA(SearchBarState r0, Function2 r1, Modifier r2, Shape r3, SearchBarColors r4, float r5, float r6, Function3 r7, Composer r8, int r9) {
        m3053DockedSearchBarLayoutnbWgWpA(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private static final void SearchBarLayout(final Animatable<Float, AnimationVector1D> r19, final MutableFloatState r20, final MutableState<BackEventCompat> r21, final MutableState<BackEventCompat> r22, final Modifier r23, final WindowInsets r24, final Function2<? super Composer, ? super Integer, Unit> r25, final Function2<? super Composer, ? super Integer, Unit> r26, final Function2<? super Composer, ? super Integer, Unit> r27, Composer r28, final int r29) {
        Composer r13 = r28.startRestartGroup(1217602934);
        if ((r29 & 6) == 0) goto L5;
        int r1 = r29;
    L14:
        if ((r29 & 48) != 0) goto L21;
        if (r13.changed(r20) == false) goto L18;
        int r3 = 32;
    L19:
        r1 = r1 | r3;
        goto L21
    L18:
        r3 = 16;
    L21:
        if ((r29 & 384) != 0) goto L28;
        if (r13.changed(r21) == false) goto L25;
        int r4 = 256;
    L26:
        r1 = r1 | r4;
        goto L28
    L25:
        r4 = 128;
    L28:
        if ((r29 & 3072) != 0) goto L36;
        if (r13.changed(r22) == false) goto L32;
        int r16 = 2048;
    L33:
        r1 = r1 | r16;
        goto L36
    L32:
        r16 = 1024;
    L36:
        if ((r29 & 24576) != 0) goto L43;
        if (r13.changed(r23) == false) goto L40;
        int r5 = 16384;
    L41:
        r1 = r1 | r5;
        goto L43
    L40:
        r5 = 8192;
    L43:
        if ((196608 & r29) != 0) goto L50;
        if (r13.changed(r24) == false) goto L47;
        int r6 = 131072;
    L48:
        r1 = r1 | r6;
        goto L50
    L47:
        r6 = 65536;
    L50:
        if ((1572864 & r29) != 0) goto L57;
        if (r13.changedInstance(r25) == false) goto L54;
        int r7 = 1048576;
    L55:
        r1 = r1 | r7;
        goto L57
    L54:
        r7 = 524288;
    L57:
        if ((12582912 & r29) != 0) goto L64;
        if (r13.changedInstance(r26) == false) goto L61;
        int r8 = 8388608;
    L62:
        r1 = r1 | r8;
        goto L64
    L61:
        r8 = 4194304;
    L64:
        if ((100663296 & r29) == 0) goto L66;
    L70:
        int r9 = r1;
        if ((38347923 & r9) == 38347922) goto L73;
        boolean r2 = true;
    L75:
        if (r13.shouldExecute(r2, r9 & 1) == true) goto L77;
        r13.skipToGroupEnd();
    L177:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L181;
        r14.updateScope(new ul(r19, r20, r21, r22, r23, r24, r25, r26, r27, r29));
        return;
    L181:
        return;
    L77:
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventStart(1217602934, r9, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.kt:2167)");
    L79:
        Object r0 = r13.rememberedValue();
        Composer.Companion r10 = Composer.Companion;
        if (r0 != r10.getEmpty()) goto L83;
        r0 = new MutableWindowInsets(null, 1, null);
        r13.updateRememberedValue(r0);
    L83:
        final MutableWindowInsets r11 = (MutableWindowInsets) r0;
        Modifier r12 = ZIndexModifierKt.zIndex(r23, 1.0f);
        if ((r9 & 458752) != 131072) goto L86;
        boolean r15 = true;
    L87:
        Object r17 = r13.rememberedValue();
        if (r15 == false) goto L90;
    L91:
        r17 = new um(r11, r24);
        r13.updateRememberedValue(r17);
    L92:
        Modifier r18 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(r12, (Function1) r17), r24);
        if ((r9 & 14) != 4) goto L95;
    L100:
        boolean r30 = true;
    L102:
        if ((r9 & 7168) != 2048) goto L104;
        boolean r31 = true;
    L105:
        boolean r32 = r30 | r31;
        if ((r9 & 112) != 32) goto L108;
        boolean r33 = true;
    L109:
        boolean r34 = r32 | r33;
        if ((r9 & 896) != 256) goto L112;
        boolean r35 = true;
    L113:
        boolean r36 = r34 | r35;
        Object r37 = r13.rememberedValue();
        if (r36 == false) goto L116;
    L119:
        int r38 = 0;
        SearchBarKt$SearchBarLayout$2$1 r39 = new SearchBarKt$SearchBarLayout$2$1(r19, r11, r22, r20, r21);
        r13.updateRememberedValue(r39);
        r37 = r39;
    L120:
        MeasurePolicy r40 = (MeasurePolicy) r37;
        int r41 = ComposablesKt.getCurrentCompositeKeyHash(r13, r38);
        CompositionLocalMap r42 = r13.getCurrentCompositionLocalMap();
        Modifier r43 = ComposedModifierKt.materializeModifier(r13, r18);
        ComposeUiNode.Companion r44 = ComposeUiNode.Companion;
        Function0 r45 = r44.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L123;
        ComposablesKt.invalidApplier();
    L123:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L126;
        r13.createNode(r45);
    L127:
        Composer r46 = Updater.constructor-impl(r13);
        Updater.set-impl(r46, r40, r44.getSetMeasurePolicy());
        Updater.set-impl(r46, r42, r44.getSetResolvedCompositionLocals());
        Function2 r47 = r44.getSetCompositeKeyHash();
        if (r46.getInserting() == false) goto L130;
    L131:
        r46.updateRememberedValue(Integer.valueOf(r41));
        r46.apply(Integer.valueOf(r41), r47);
    L132:
        Updater.set-impl(r46, r43, r44.getSetModifier());
        Modifier.Companion r48 = Modifier.Companion;
        Modifier r49 = LayoutIdKt.layoutId(r48, LayoutIdSurface);
        Alignment.Companion r50 = Alignment.Companion;
        MeasurePolicy r51 = BoxKt.maybeCachedBoxMeasurePolicy(r50.getTopStart(), true);
        int r52 = ComposablesKt.getCurrentCompositeKeyHash(r13, r38);
        CompositionLocalMap r53 = r13.getCurrentCompositionLocalMap();
        Modifier r54 = ComposedModifierKt.materializeModifier(r13, r49);
        Function0 r55 = r44.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L135;
        ComposablesKt.invalidApplier();
    L135:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L138;
        r13.createNode(r55);
    L139:
        Composer r56 = Updater.constructor-impl(r13);
        Updater.set-impl(r56, r51, r44.getSetMeasurePolicy());
        Updater.set-impl(r56, r53, r44.getSetResolvedCompositionLocals());
        Function2 r57 = r44.getSetCompositeKeyHash();
        if (r56.getInserting() == false) goto L142;
    L143:
        r56.updateRememberedValue(Integer.valueOf(r52));
        r56.apply(Integer.valueOf(r52), r57);
    L144:
        Updater.set-impl(r56, r54, r44.getSetModifier());
        BoxScopeInstance r58 = BoxScopeInstance.INSTANCE;
        r26.invoke(r13, Integer.valueOf((r9 >> 21) & 14));
        r13.endNode();
        Modifier r59 = LayoutIdKt.layoutId(r48, LayoutIdInputField);
        MeasurePolicy r60 = BoxKt.maybeCachedBoxMeasurePolicy(r50.getTopStart(), true);
        int r61 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r62 = r13.getCurrentCompositionLocalMap();
        Modifier r63 = ComposedModifierKt.materializeModifier(r13, r59);
        Function0 r64 = r44.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L147;
        ComposablesKt.invalidApplier();
    L147:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L150;
        r13.createNode(r64);
    L151:
        Composer r65 = Updater.constructor-impl(r13);
        Updater.set-impl(r65, r60, r44.getSetMeasurePolicy());
        Updater.set-impl(r65, r62, r44.getSetResolvedCompositionLocals());
        Function2 r66 = r44.getSetCompositeKeyHash();
        if (r65.getInserting() == false) goto L154;
    L155:
        r65.updateRememberedValue(Integer.valueOf(r61));
        r65.apply(Integer.valueOf(r61), r66);
    L156:
        Updater.set-impl(r65, r63, r44.getSetModifier());
        r25.invoke(r13, Integer.valueOf((r9 >> 18) & 14));
        r13.endNode();
        if (r27 != null) goto L160;
        r13.startReplaceGroup(2058820276);
    L159:
        r13.endReplaceGroup();
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L177;
        ComposerKt.traceEventEnd();
        goto L177
    L160:
        r13.startReplaceGroup(2058820277);
        Modifier r67 = LayoutIdKt.layoutId(r48, LayoutIdSearchContent);
        MeasurePolicy r68 = BoxKt.maybeCachedBoxMeasurePolicy(r50.getTopStart(), true);
        int r69 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r70 = r13.getCurrentCompositionLocalMap();
        Modifier r71 = ComposedModifierKt.materializeModifier(r13, r67);
        Function0 r72 = r44.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L163;
        ComposablesKt.invalidApplier();
    L163:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L166;
        r13.createNode(r72);
    L167:
        Composer r73 = Updater.constructor-impl(r13);
        Updater.set-impl(r73, r68, r44.getSetMeasurePolicy());
        Updater.set-impl(r73, r70, r44.getSetResolvedCompositionLocals());
        Function2 r74 = r44.getSetCompositeKeyHash();
        if (r73.getInserting() == false) goto L170;
    L171:
        r73.updateRememberedValue(Integer.valueOf(r69));
        r73.apply(Integer.valueOf(r69), r74);
    L172:
        Updater.set-impl(r73, r71, r44.getSetModifier());
        r27.invoke(r13, 0);
        r13.endNode();
        Unit r75 = Unit.INSTANCE;
        goto L159
    L170:
        if (Intrinsics.areEqual(r73.rememberedValue(), Integer.valueOf(r69)) == true) goto L172;
    L166:
        r13.useNode();
        goto L167
    L154:
        if (Intrinsics.areEqual(r65.rememberedValue(), Integer.valueOf(r61)) == true) goto L156;
    L150:
        r13.useNode();
        goto L151
    L142:
        if (Intrinsics.areEqual(r56.rememberedValue(), Integer.valueOf(r52)) == true) goto L144;
    L138:
        r13.useNode();
        goto L139
    L130:
        if (Intrinsics.areEqual(r46.rememberedValue(), Integer.valueOf(r41)) == true) goto L132;
    L126:
        r13.useNode();
        goto L127
    L116:
        if (r37 == r10.getEmpty()) goto L119;
        r38 = 0;
        goto L120
    L112:
        r35 = false;
        goto L113
    L108:
        r33 = false;
        goto L109
    L104:
        r31 = false;
        goto L105
    L95:
        if ((r9 & 8) != 0) goto L97;
    L99:
        r30 = false;
        goto L102
    L97:
        if (r13.changedInstance(r19) == false) goto L99;
    L90:
        if (r17 != r10.getEmpty()) goto L92;
    L86:
        r15 = false;
        goto L87
    L73:
        r2 = false;
        goto L75
    L66:
        if (r13.changedInstance(r27) == false) goto L68;
        int r76 = 67108864;
    L69:
        r1 = r1 | r76;
        goto L70
    L68:
        r76 = 33554432;
        goto L69
    L5:
        if ((r29 & 8) != 0) goto L7;
        boolean r77 = r13.changed(r19);
    L8:
        if (r77 == false) goto L10;
        int r78 = 4;
    L11:
        r1 = r78 | r29;
        goto L14
    L10:
        r78 = 2;
        goto L11
    L7:
        r77 = r13.changedInstance(r19);
        goto L8
    }

    /* JADX INFO: renamed from: DockedSearchBar-EQC0FA8, reason: not valid java name */
    public static final void m3051DockedSearchBarEQC0FA8(final Function2<? super Composer, ? super Integer, Unit> r27, final boolean r28, final Function1<? super Boolean, Unit> r29, Modifier r30, Shape r31, SearchBarColors r32, float r33, float r34, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r35, Composer r36, final int r37, final int r38) {
        Composer r4 = r36.startRestartGroup(-2008777812);
        if ((r38 & 1) == 0) goto L6;
        int r5 = r37 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        if ((r38 & 4) == 0) goto L27;
        r5 = r5 | 384;
    L33:
        int r6 = r38 & 8;
        if (r6 == 0) goto L37;
        r5 = r5 | 3072;
    L43:
        Modifier r8 = r30;
    L45:
        if ((r37 & 24576) == 0) goto L47;
        Shape r12 = r31;
    L56:
        if ((196608 & r37) == 0) goto L58;
        SearchBarColors r13 = r32;
    L66:
        int r21 = r38 & 64;
        if (r21 == 0) goto L70;
        r5 = r5 | 1572864;
    L76:
        int r14 = r38 & 128;
        if (r14 == 0) goto L80;
        r5 = r5 | 12582912;
    L87:
        if ((r38 & 256) == 0) goto L90;
        r5 = r5 | 100663296;
    L97:
        if ((38347923 & r5) == 38347922) goto L99;
        boolean r0 = true;
    L101:
        if (r4.shouldExecute(r0, r5 & 1) == false) goto L147;
        r4.startDefaults();
        if ((r37 & 1) != 0) goto L105;
    L115:
        if (r6 == 0) goto L118;
        r8 = Modifier.Companion;
    L118:
        if ((r38 & 16) == 0) goto L120;
        Shape r1 = SearchBarDefaults.INSTANCE.getDockedShape(r4, 6);
        r5 = r5 & (-57345);
    L122:
        if ((r38 & 32) == 0) goto L124;
        final SearchBarColors r7 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r4, 3072, 7);
        r5 = r5 & (-458753);
    L125:
        if (r21 == 0) goto L127;
        final float r9 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L128:
        if (r14 == 0) goto L130;
        int r15 = r5;
        float r10 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L131:
        r4.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventStart(-2008777812, r15, -1, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:657)");
    L134:
        long r16 = r7.m3038getContainerColor0d7_KjU();
        long r17 = ColorSchemeKt.m2496contentColorForek8zF_U(r7.m3038getContainerColor0d7_KjU(), r4, 0);
        Modifier r18 = androidx.compose.foundation.layout.SizeKt.m1019width3ABfNKs(ZIndexModifierKt.zIndex(r8, 1.0f), SearchBarMinWidth);
        SearchBarColors r39 = r7;
        ComposableLambda r22 = ComposableLambdaKt.rememberComposableLambda(401953073, true, new SearchBarKt$DockedSearchBar$1(r27, r28, r7, r35), r4, 54);
        int r11 = r15 >> 6;
        int r23 = ((((r15 >> 9) & 112) | 12582912) | (57344 & r11)) | (r11 & 458752);
        int r2 = r15;
        SurfaceKt.m3213SurfaceT9BRK9s(r18, r1, r16, r17, r9, r10, null, r22, r4, r23, 64);
        if ((r2 & 896) != 256) goto L137;
        boolean r19 = true;
    L138:
        Object r20 = r4.rememberedValue();
        if (r19 == false) goto L141;
    L142:
        r20 = new vl(r29);
        r4.updateRememberedValue(r20);
    L143:
        BackHandler_androidKt.BackHandler(r28, (Function0) r20, r4, (r2 >> 3) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L146;
        ComposerKt.traceEventEnd();
    L146:
        final SearchBarColors r24 = r39;
        float r110 = r10;
        final Shape r25 = r1;
    L148:
        ScopeUpdateScope r111 = r4.endRestartGroup();
        if (r111 == null) goto L152;
        final Modifier r26 = r8;
        final float r40 = r110;
        r111.updateScope(new wl(r27, r28, r29, r26, r25, r24, r9, r40, r35, r37, r38));
        return;
    L152:
        return;
    L141:
        if (r20 != Composer.Companion.getEmpty()) goto L143;
    L137:
        r19 = false;
        goto L138
    L130:
        r15 = r5;
    L114:
        r10 = r34;
        goto L131
    L127:
        r9 = r33;
        goto L128
    L124:
        r7 = r13;
        goto L125
    L120:
        r1 = r12;
        goto L122
    L105:
        if (r4.getDefaultsInvalid() == true) goto L115;
        r4.skipToGroupEnd();
        if ((r38 & 16) == 0) goto L111;
        r5 = r5 & (-57345);
    L111:
        if ((r38 & 32) == 0) goto L113;
        r5 = r5 & (-458753);
    L113:
        r9 = r33;
        r15 = r5;
        r1 = r12;
        r7 = r13;
        goto L114
    L147:
        r4.skipToGroupEnd();
        r9 = r33;
        r110 = r34;
        r25 = r12;
        r24 = r13;
        goto L148
    L99:
        r0 = false;
        goto L101
    L90:
        if ((r37 & 100663296) != 0) goto L97;
        if (r4.changedInstance(r35) == false) goto L94;
        int r3 = 67108864;
    L95:
        r5 = r5 | r3;
        goto L97
    L94:
        r3 = 33554432;
        goto L95
    L80:
        if ((r37 & 12582912) != 0) goto L87;
        if (r4.changed(r34) == false) goto L84;
        int r112 = 8388608;
    L85:
        r5 = r5 | r112;
        goto L87
    L84:
        r112 = 4194304;
        goto L85
    L70:
        if ((1572864 & r37) != 0) goto L76;
        if (r4.changed(r33) == false) goto L74;
        int r113 = 1048576;
    L75:
        r5 = r5 | r113;
        goto L76
    L74:
        r113 = 524288;
        goto L75
    L58:
        if ((r38 & 32) != 0) goto L62;
        r13 = r32;
        if (r4.changed(r13) == false) goto L63;
        int r114 = 131072;
    L64:
        r5 = r5 | r114;
    L63:
        r114 = 65536;
        goto L64
    L62:
        r13 = r32;
        goto L63
    L47:
        if ((r38 & 16) != 0) goto L51;
        r12 = r31;
        if (r4.changed(r12) == false) goto L52;
        int r115 = 16384;
    L53:
        r5 = r5 | r115;
    L52:
        r115 = 8192;
        goto L53
    L51:
        r12 = r31;
        goto L52
    L37:
        if ((r37 & 3072) != 0) goto L43;
        r8 = r30;
        if (r4.changed(r8) == false) goto L41;
        int r116 = 2048;
    L42:
        r5 = r5 | r116;
        goto L45
    L41:
        r116 = 1024;
        goto L42
    L27:
        if ((r37 & 384) != 0) goto L33;
        if (r4.changedInstance(r29) == false) goto L31;
        int r41 = 256;
    L32:
        r5 = r5 | r41;
        goto L33
    L31:
        r41 = 128;
        goto L32
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r4.changed(r28) == false) goto L21;
        int r42 = 32;
    L22:
        r5 = r5 | r42;
        goto L24
    L21:
        r42 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r5 = r37;
        goto L14
    L8:
        if (r4.changedInstance(r27) == false) goto L10;
        int r43 = 4;
    L11:
        r5 = r43 | r37;
        goto L14
    L10:
        r43 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ExpandedDockedSearchBar-qKj4JfE, reason: not valid java name */
    public static final void m3054ExpandedDockedSearchBarqKj4JfE(final SearchBarState r24, final Function2<? super Composer, ? super Integer, Unit> r25, Modifier r26, Shape r27, SearchBarColors r28, float r29, float r30, PopupProperties r31, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r8 = r33.startRestartGroup(-1121062437);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r35 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r4 = r26;
    L35:
        if ((r34 & 3072) == 0) goto L37;
        Shape r5 = r27;
    L46:
        if ((r34 & 24576) == 0) goto L48;
        SearchBarColors r6 = r28;
    L56:
        int r21 = r35 & 32;
        if (r21 == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        int r22 = r35 & 64;
        if (r22 == 0) goto L69;
        r1 = r1 | 1572864;
        float r13 = r30;
    L76:
        int r14 = r35 & 128;
        if (r14 == 0) goto L80;
        r1 = r1 | 12582912;
    L86:
        PopupProperties r12 = r31;
    L88:
        if ((r35 & 256) == 0) goto L91;
        r1 = r1 | 100663296;
    L98:
        boolean r23 = false;
        if ((r1 & 38347923) == 38347922) goto L101;
        boolean r0 = true;
    L103:
        if (r8.shouldExecute(r0, r1 & 1) == false) goto L171;
        r8.startDefaults();
        if ((r34 & 1) != 0) goto L107;
    L116:
        if (r3 == 0) goto L119;
        r4 = Modifier.Companion;
    L119:
        if ((r35 & 8) == 0) goto L122;
        r1 = r1 & (-7169);
        r5 = SearchBarDefaults.INSTANCE.getDockedShape(r8, 6);
    L122:
        if ((r35 & 16) == 0) goto L125;
        r1 = r1 & (-57345);
        r6 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r8, 3072, 7);
    L125:
        if (r21 == 0) goto L127;
        float r2 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L128:
        if (r22 == 0) goto L130;
        float r7 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L131:
        if (r14 == 0) goto L133;
        PopupProperties r18 = new PopupProperties(true, false, false, false, 6, null);
    L134:
        int r15 = r1;
        float r16 = r2;
        float r17 = r7;
        Modifier r19 = r4;
        Shape r110 = r5;
        SearchBarColors r111 = r6;
    L135:
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventStart(-1121062437, r15, -1, "androidx.compose.material3.ExpandedDockedSearchBar (SearchBar.kt:435)");
    L139:
        if (isExpanded(r24) == false) goto L141;
        int r9 = r15 & 14;
        if (r9 != 4) goto L150;
        boolean r10 = true;
    L151:
        Object r11 = r8.rememberedValue();
        if (r10 == false) goto L154;
    L155:
        r11 = new SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1(r24);
        r8.updateRememberedValue(r11);
    L156:
        SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1 r112 = (SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1) r11;
        Object r20 = r8.rememberedValue();
        Composer.Companion r36 = Composer.Companion;
        if (r20 != r36.getEmpty()) goto L159;
        r20 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r8);
        r8.updateRememberedValue(r20);
    L159:
        final CoroutineScope r37 = (CoroutineScope) r20;
        boolean r38 = r8.changedInstance(r37);
        if (r9 != 4) goto L162;
        r23 = true;
    L162:
        boolean r39 = r38 | r23;
        Object r40 = r8.rememberedValue();
        if (r39 == false) goto L165;
    L166:
        r40 = new bm(r37, r24);
        r8.updateRememberedValue(r40);
    L167:
        Function0 r210 = (Function0) r40;
        final Modifier r41 = r19;
        final Shape r42 = r110;
        final SearchBarColors r43 = r111;
        final float r44 = r16;
        final float r45 = r17;
        Composer r113 = r8;
        PopupProperties r46 = r18;
        AndroidPopup_androidKt.Popup(r112, r210, r46, ComposableLambdaKt.rememberComposableLambda(-363177991, true, new SearchBarKt$ExpandedDockedSearchBar$3(r24, r41, r42, r43, r44, r45, r32, r25), r113, 54), r113, ((r15 >> 15) & 896) | 3072, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L170;
        ComposerKt.traceEventEnd();
    L170:
        final Modifier r47 = r19;
        final Shape r48 = r110;
        final SearchBarColors r49 = r111;
        final float r50 = r16;
        final float r51 = r17;
        final PopupProperties r52 = r18;
    L172:
        ScopeUpdateScope r114 = r113.endRestartGroup();
        if (r114 == null) goto L177;
        r114.updateScope(new cm(r24, r25, r47, r48, r49, r50, r51, r52, r32, r34, r35));
        return;
    L177:
        return;
    L165:
        if (r40 != r36.getEmpty()) goto L167;
    L154:
        if (r11 != Composer.Companion.getEmpty()) goto L156;
    L150:
        r10 = false;
        goto L151
    L141:
        if (ComposerKt.isTraceInProgress() == false) goto L143;
        ComposerKt.traceEventEnd();
    L143:
        ScopeUpdateScope r115 = r8.endRestartGroup();
        if (r115 == null) goto L176;
        final Modifier r53 = r19;
        final Shape r54 = r110;
        final SearchBarColors r55 = r111;
        final float r56 = r16;
        final float r57 = r17;
        final PopupProperties r58 = r18;
        r115.updateScope(new am(r24, r25, r53, r54, r55, r56, r57, r58, r32, r34, r35));
        return;
    L176:
        return;
    L133:
        r18 = r31;
        goto L134
    L130:
        r7 = r30;
        goto L131
    L127:
        r2 = r29;
        goto L128
    L107:
        if (r8.getDefaultsInvalid() == true) goto L116;
        r8.skipToGroupEnd();
        if ((r35 & 8) == 0) goto L113;
        r1 = r1 & (-7169);
    L113:
        if ((r35 & 16) == 0) goto L115;
        r1 = r1 & (-57345);
    L115:
        r16 = r29;
        r110 = r5;
        r111 = r6;
        r18 = r12;
        r17 = r13;
        r15 = r1;
        r19 = r4;
        goto L135
    L171:
        r113 = r8;
        r113.skipToGroupEnd();
        r51 = r30;
        r52 = r31;
        r47 = r4;
        r48 = r5;
        r49 = r6;
        r50 = r29;
        goto L172
    L101:
        r0 = false;
        goto L103
    L91:
        if ((r34 & 100663296) != 0) goto L98;
        if (r8.changedInstance(r32) == false) goto L95;
        int r116 = 67108864;
    L96:
        r1 = r1 | r116;
        goto L98
    L95:
        r116 = 33554432;
        goto L96
    L80:
        if ((12582912 & r34) != 0) goto L86;
        r12 = r31;
        if (r8.changed(r12) == false) goto L84;
        int r117 = 8388608;
    L85:
        r1 = r1 | r117;
        goto L88
    L84:
        r117 = 4194304;
        goto L85
    L69:
        r13 = r30;
        if ((1572864 & r34) != 0) goto L76;
        if (r8.changed(r13) == false) goto L74;
        int r118 = 1048576;
    L75:
        r1 = r1 | r118;
        goto L76
    L74:
        r118 = 524288;
        goto L75
    L60:
        if ((196608 & r34) != 0) goto L66;
        if (r8.changed(r29) == false) goto L64;
        int r119 = 131072;
    L65:
        r1 = r1 | r119;
        goto L66
    L64:
        r119 = 65536;
        goto L65
    L48:
        if ((r35 & 16) != 0) goto L52;
        r6 = r28;
        if (r8.changed(r6) == false) goto L53;
        int r120 = 16384;
    L54:
        r1 = r1 | r120;
    L53:
        r120 = 8192;
        goto L54
    L52:
        r6 = r28;
        goto L53
    L37:
        if ((r35 & 8) != 0) goto L41;
        r5 = r27;
        if (r8.changed(r5) == false) goto L42;
        int r59 = 2048;
    L43:
        r1 = r1 | r59;
    L42:
        r59 = 1024;
        goto L43
    L41:
        r5 = r27;
        goto L42
    L27:
        if ((r34 & 384) != 0) goto L33;
        r4 = r26;
        if (r8.changed(r4) == false) goto L31;
        int r60 = 256;
    L32:
        r1 = r1 | r60;
        goto L35
    L31:
        r60 = 128;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L23;
        if (r8.changedInstance(r25) == false) goto L21;
        int r61 = 32;
    L22:
        r1 = r1 | r61;
        goto L23
    L21:
        r61 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L14
    L8:
        if (r8.changed(r24) == false) goto L10;
        int r62 = 4;
    L11:
        r1 = r62 | r34;
        goto L14
    L10:
        r62 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: FullScreenSearchBarLayout-EQC0FA8, reason: not valid java name */
    private static final void m3056FullScreenSearchBarLayoutEQC0FA8(final SearchBarState r28, final PredictiveBackState r29, final Function2<? super Composer, ? super Integer, Unit> r30, final Modifier r31, final Shape r32, final SearchBarColors r33, final float r34, final float r35, final WindowInsets r36, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39) {
        Composer r15 = r38.startRestartGroup(-740838201);
        if ((r39 & 6) == 0) goto L5;
        int r1 = r39;
    L11:
        if ((r39 & 48) != 0) goto L21;
        if ((r39 & 64) != 0) goto L15;
        boolean r3 = r15.changed(r29);
    L16:
        if (r3 == false) goto L18;
        int r4 = 32;
    L19:
        r1 = r1 | r4;
        goto L21
    L18:
        r4 = 16;
        goto L19
    L15:
        r3 = r15.changedInstance(r29);
    L21:
        if ((r39 & 384) != 0) goto L28;
        if (r15.changedInstance(r30) == false) goto L25;
        int r5 = 256;
    L26:
        r1 = r1 | r5;
        goto L28
    L25:
        r5 = 128;
    L28:
        if ((r39 & 3072) != 0) goto L35;
        if (r15.changed(r31) == false) goto L32;
        int r6 = 2048;
    L33:
        r1 = r1 | r6;
        goto L35
    L32:
        r6 = 1024;
    L35:
        if ((r39 & 24576) != 0) goto L42;
        if (r15.changed(r32) == false) goto L39;
        int r7 = 16384;
    L40:
        r1 = r1 | r7;
        goto L42
    L39:
        r7 = 8192;
    L42:
        if ((196608 & r39) != 0) goto L49;
        if (r15.changed(r33) == false) goto L46;
        int r8 = 131072;
    L47:
        r1 = r1 | r8;
        goto L49
    L46:
        r8 = 65536;
    L49:
        if ((1572864 & r39) != 0) goto L56;
        if (r15.changed(r34) == false) goto L53;
        int r9 = 1048576;
    L54:
        r1 = r1 | r9;
        goto L56
    L53:
        r9 = 524288;
    L56:
        if ((12582912 & r39) != 0) goto L64;
        if (r15.changed(r35) == false) goto L60;
        int r16 = 8388608;
    L61:
        r1 = r1 | r16;
        goto L64
    L60:
        r16 = 4194304;
    L64:
        if ((r39 & 100663296) != 0) goto L71;
        if (r15.changed(r36) == false) goto L68;
        int r17 = 67108864;
    L69:
        r1 = r1 | r17;
        goto L71
    L68:
        r17 = 33554432;
    L71:
        if ((r39 & 805306368) != 0) goto L78;
        if (r15.changedInstance(r37) == false) goto L75;
        int r18 = 536870912;
    L76:
        r1 = r1 | r18;
        goto L78
    L75:
        r18 = 268435456;
    L78:
        if ((r1 & 306783379) == 306783378) goto L80;
        boolean r2 = true;
    L82:
        if (r15.shouldExecute(r2, r1 & 1) == true) goto L84;
        Composer r10 = r15;
        r10.skipToGroupEnd();
    L187:
        ScopeUpdateScope r12 = r10.endRestartGroup();
        if (r12 == null) goto L191;
        r12.updateScope(new jm(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r39));
        return;
    L191:
        return;
    L84:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventStart(-740838201, r1, -1, "androidx.compose.material3.FullScreenSearchBarLayout (SearchBar.kt:2398)");
    L86:
        Object r0 = r15.rememberedValue();
        Composer.Companion r13 = Composer.Companion;
        if (r0 != r13.getEmpty()) goto L89;
        r0 = SnapshotStateKt.derivedStateOf(new gm(r29));
        r15.updateRememberedValue(r0);
    L89:
        State r11 = (State) r0;
        Object r14 = r15.rememberedValue();
        if (r14 != r13.getEmpty()) goto L92;
        r14 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r15.updateRememberedValue(r14);
    L92:
        MutableState r19 = (MutableState) r14;
        BackEventProgress r20 = FullScreenSearchBarLayout_EQC0FA8$lambda$55(r11);
        if ((r20 instanceof BackEventProgress.InProgress) == false) goto L98;
        if (r19.getValue() != null) goto L102;
        r19.setValue(r20);
    L102:
        Object r21 = r15.rememberedValue();
        if (r21 != r13.getEmpty()) goto L106;
        r21 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r15.updateRememberedValue(r21);
    L106:
        final MutableState r22 = (MutableState) r21;
        BackEventProgress r23 = FullScreenSearchBarLayout_EQC0FA8$lambda$55(r11);
        if ((r23 instanceof BackEventProgress.InProgress) == false) goto L110;
        r22.setValue(r23);
    L114:
        final Density r24 = (Density) r15.consume(CompositionLocalsKt.getLocalDensity());
        final Shape r25 = SearchBarDefaults.INSTANCE.getFullScreenShape(r15, 6);
        boolean r26 = r15.changed(r24) | r15.changed(r25);
        Object r27 = r15.rememberedValue();
        if (r26 == true) goto L121;
        if (r27 == r13.getEmpty()) goto L121;
        int r210 = 6;
    L122:
        GenericShape r110 = (GenericShape) r27;
        Object r40 = r15.rememberedValue();
        if (r40 != r13.getEmpty()) goto L125;
        r40 = new MutableWindowInsets(null, 1, null);
        r15.updateRememberedValue(r40);
    L125:
        final MutableWindowInsets r41 = (MutableWindowInsets) r40;
        WindowInsets r42 = r41.getInsets();
        WindowInsetsSides.Companion r43 = WindowInsetsSides.Companion;
        WindowInsets r44 = WindowInsetsKt.m1046onlybOOhFvg(r42, WindowInsetsSides.m1060plusgK_yJZ4(r43.m1070getHorizontalJoeWqyM(), r43.m1068getBottomJoeWqyM()));
        if ((r1 & 234881024) != 67108864) goto L128;
        boolean r45 = true;
    L129:
        Object r46 = r15.rememberedValue();
        if (r45 == false) goto L132;
    L133:
        r46 = new im(r41, r36);
        r15.updateRememberedValue(r46);
    L134:
        Modifier r47 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(r31, (Function1) r46), r36);
        boolean r48 = r15.changed(r22);
        if ((r1 & 14) != 4) goto L137;
        boolean r49 = true;
    L138:
        boolean r50 = (r48 | r49) | r15.changed(r19);
        Object r51 = r15.rememberedValue();
        if (r50 == false) goto L141;
    L142:
        r51 = new SearchBarKt$FullScreenSearchBarLayout$2$1(r22, r28, r41, r19);
        r15.updateRememberedValue(r51);
    L143:
        MeasurePolicy r52 = (MeasurePolicy) r51;
        int r53 = ComposablesKt.getCurrentCompositeKeyHash(r15, 0);
        CompositionLocalMap r54 = r15.getCurrentCompositionLocalMap();
        Modifier r55 = ComposedModifierKt.materializeModifier(r15, r47);
        ComposeUiNode.Companion r56 = ComposeUiNode.Companion;
        Function0 r57 = r56.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L146;
        ComposablesKt.invalidApplier();
    L146:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L149;
        r15.createNode(r57);
    L150:
        Composer r58 = Updater.constructor-impl(r15);
        Updater.set-impl(r58, r52, r56.getSetMeasurePolicy());
        Updater.set-impl(r58, r54, r56.getSetResolvedCompositionLocals());
        Function2 r59 = r56.getSetCompositeKeyHash();
        if (r58.getInserting() == false) goto L153;
    L154:
        r58.updateRememberedValue(Integer.valueOf(r53));
        r58.apply(Integer.valueOf(r53), r59);
    L155:
        Updater.set-impl(r58, r55, r56.getSetModifier());
        Modifier.Companion r60 = Modifier.Companion;
        Modifier r61 = PaddingKt.padding(LayoutIdKt.layoutId(r60, LayoutIdInputField), WindowInsetsKt.asPaddingValues(WindowInsetsKt.m1046onlybOOhFvg(r44, r43.m1070getHorizontalJoeWqyM()), r15, 0));
        Alignment.Companion r62 = Alignment.Companion;
        MeasurePolicy r63 = BoxKt.maybeCachedBoxMeasurePolicy(r62.getTopStart(), true);
        int r64 = ComposablesKt.getCurrentCompositeKeyHash(r15, 0);
        CompositionLocalMap r65 = r15.getCurrentCompositionLocalMap();
        Modifier r66 = ComposedModifierKt.materializeModifier(r15, r61);
        Function0 r111 = r56.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L158;
        ComposablesKt.invalidApplier();
    L158:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L161;
        r15.createNode(r111);
    L162:
        Composer r112 = Updater.constructor-impl(r15);
        Updater.set-impl(r112, r63, r56.getSetMeasurePolicy());
        Updater.set-impl(r112, r65, r56.getSetResolvedCompositionLocals());
        Function2 r67 = r56.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L165;
    L166:
        r112.updateRememberedValue(Integer.valueOf(r64));
        r112.apply(Integer.valueOf(r64), r67);
    L167:
        Updater.set-impl(r112, r66, r56.getSetModifier());
        BoxScopeInstance r68 = BoxScopeInstance.INSTANCE;
        int r69 = r1 >> 6;
        r30.invoke(r15, Integer.valueOf(r69 & 14));
        r15.endNode();
        Modifier r113 = LayoutIdKt.layoutId(r60, LayoutIdSurface);
        long r70 = r33.m3038getContainerColor0d7_KjU();
        long r114 = ColorSchemeKt.m2496contentColorForek8zF_U(r33.m3038getContainerColor0d7_KjU(), r15, 0);
        Function2<Composer, Integer, Unit> r211 = ComposableSingletons$SearchBarKt.INSTANCE.m2538getLambda$1146652811$material3();
        int r212 = ((57344 & r69) | 12582918) | (r69 & 458752);
        r10 = r15;
        SurfaceKt.m3213SurfaceT9BRK9s(r113, r110, r70, r114, r34, r35, null, r211, r10, r212, 64);
        Modifier r71 = PaddingKt.padding(LayoutIdKt.layoutId(r60, LayoutIdSearchContent), WindowInsetsKt.asPaddingValues(r44, r10, 0));
        MeasurePolicy r72 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r62.getStart(), r10, 0);
        int r73 = ComposablesKt.getCurrentCompositeKeyHash(r10, 0);
        CompositionLocalMap r74 = r10.getCurrentCompositionLocalMap();
        Modifier r75 = ComposedModifierKt.materializeModifier(r10, r71);
        Function0 r76 = r56.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L170;
        ComposablesKt.invalidApplier();
    L170:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L173;
        r10.createNode(r76);
    L174:
        Composer r77 = Updater.constructor-impl(r10);
        Updater.set-impl(r77, r72, r56.getSetMeasurePolicy());
        Updater.set-impl(r77, r74, r56.getSetResolvedCompositionLocals());
        Function2 r78 = r56.getSetCompositeKeyHash();
        if (r77.getInserting() == false) goto L177;
    L178:
        r77.updateRememberedValue(Integer.valueOf(r73));
        r77.apply(Integer.valueOf(r73), r78);
    L179:
        Updater.set-impl(r77, r75, r56.getSetModifier());
        ColumnScopeInstance r79 = ColumnScopeInstance.INSTANCE;
        DividerKt.m2634HorizontalDivider9IZ8Weo(null, MenuKt.ClosedAlphaTarget, r33.m3039getDividerColor0d7_KjU(), r10, 0, 3);
        r37.invoke(r79, r10, Integer.valueOf(r210 | ((r1 >> 24) & 112)));
        r10.endNode();
        r10.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L187;
        ComposerKt.traceEventEnd();
        goto L187
    L177:
        if (Intrinsics.areEqual(r77.rememberedValue(), Integer.valueOf(r73)) == true) goto L179;
    L173:
        r10.useNode();
        goto L174
    L165:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r64)) == true) goto L167;
    L161:
        r15.useNode();
        goto L162
    L153:
        if (Intrinsics.areEqual(r58.rememberedValue(), Integer.valueOf(r53)) == true) goto L155;
    L149:
        r15.useNode();
        goto L150
    L141:
        if (r51 != r13.getEmpty()) goto L143;
    L137:
        r49 = false;
        goto L138
    L132:
        if (r46 != r13.getEmpty()) goto L134;
    L128:
        r45 = false;
    L121:
        r210 = 6;
        GenericShape r80 = new GenericShape(new hm(r32, r25, r24, r28, r22));
        r15.updateRememberedValue(r80);
        r27 = r80;
        goto L122
    L110:
        if (Intrinsics.areEqual(r23, BackEventProgress.NotRunning.INSTANCE) == false) goto L113;
        r22.setValue(null);
        goto L114
    L113:
        if (Intrinsics.areEqual(r23, BackEventProgress.Completed.INSTANCE) == true) goto L114;
        throw new NoWhenBranchMatchedException();
    L98:
        if (Intrinsics.areEqual(r20, BackEventProgress.NotRunning.INSTANCE) == false) goto L101;
        r19.setValue(null);
        goto L102
    L101:
        if (Intrinsics.areEqual(r20, BackEventProgress.Completed.INSTANCE) == true) goto L102;
        throw new NoWhenBranchMatchedException();
    L80:
        r2 = false;
        goto L82
    L5:
        if (r15.changed(r28) == false) goto L7;
        int r81 = 4;
    L8:
        r1 = r81 | r39;
        goto L11
    L7:
        r81 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: TopSearchBar-qKj4JfE, reason: not valid java name */
    public static final void m3061TopSearchBarqKj4JfE(final SearchBarState r29, final Function2<? super Composer, ? super Integer, Unit> r30, Modifier r31, Shape r32, SearchBarColors r33, float r34, float r35, WindowInsets r36, SearchBarScrollBehavior r37, Composer r38, final int r39, final int r40) {
        Composer r15 = r38.startRestartGroup(782822734);
        if ((r40 & 1) == 0) goto L6;
        int r1 = r39 | 6;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r40 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L35:
        if ((r39 & 3072) == 0) goto L37;
        final Shape r4 = r32;
    L46:
        if ((r39 & 24576) == 0) goto L48;
        final SearchBarColors r5 = r33;
    L56:
        int r12 = r40 & 32;
        if (r12 == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        int r16 = r40 & 64;
        if (r16 == 0) goto L69;
        r1 = r1 | 1572864;
        float r8 = r35;
    L77:
        if ((12582912 & r39) != 0) goto L85;
        WindowInsets r7 = r36;
        if ((r40 & 128) == 0) goto L81;
    L83:
        int r6 = 4194304;
    L84:
        r1 = r1 | r6;
    L86:
        int r9 = r40 & 256;
        if (r9 == 0) goto L90;
        r1 = r1 | 100663296;
    L97:
        if ((r1 & 38347923) == 38347922) goto L99;
        boolean r0 = true;
    L101:
        if (r15.shouldExecute(r0, r1 & 1) == false) goto L153;
        r15.startDefaults();
        if ((r39 & 1) != 0) goto L105;
    L117:
        if (r2 == 0) goto L119;
        Modifier r3 = Modifier.Companion;
    L121:
        if ((r40 & 8) == 0) goto L123;
        int r22 = r1 & (-7169);
        Shape r21 = SearchBarDefaults.INSTANCE.getInputFieldShape(r15, 6);
    L125:
        if ((r40 & 16) == 0) goto L127;
        int r10 = 6;
        r22 = r22 & (-57345);
        r5 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r15, 3072, 7);
    L128:
        if (r12 == 0) goto L130;
        float r11 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L131:
        if (r16 == 0) goto L133;
        float r13 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L135:
        if ((r40 & 128) == 0) goto L137;
        WindowInsets r14 = SearchBarDefaults.INSTANCE.getWindowInsets(r15, r10);
        r22 = r22 & (-29360129);
    L138:
        r7 = r14;
        r8 = r13;
        r4 = r21;
        int r17 = r22;
        if (r9 == 0) goto L141;
        SearchBarScrollBehavior r18 = null;
        Modifier r19 = r3;
    L142:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventStart(782822734, r17, -1, "androidx.compose.material3.TopSearchBar (SearchBar.kt:292)");
    L145:
        if (r18 == null) goto L148;
        Modifier r20 = r18.searchBarScrollBehavior(Modifier.Companion);
        if (r20 == null) goto L148;
    L149:
        Modifier r23 = r19;
        Composer r24 = r15;
        Shape r110 = r4;
        SearchBarColors r111 = r5;
        float r112 = r11;
        float r113 = r8;
        m3059SearchBarnbWgWpA(r29, r30, androidx.compose.foundation.layout.SizeKt.wrapContentWidth$default(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(PaddingKt.m960padding3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(r19.then(r20), r7), SearchBarAsTopBarPadding), MenuKt.ClosedAlphaTarget, 1, null), null, false, 3, null), r110, r111, r112, r113, r24, (((((r17 & 14) | (r17 & 112)) | (r17 & 7168)) | (57344 & r17)) | (458752 & r17)) | (r17 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L152;
        ComposerKt.traceEventEnd();
    L152:
        final float r25 = r11;
        final SearchBarScrollBehavior r26 = r18;
        final Modifier r27 = r23;
        float r28 = r8;
        final WindowInsets r41 = r7;
        final float r42 = r28;
    L154:
        ScopeUpdateScope r114 = r24.endRestartGroup();
        if (r114 == null) goto L158;
        r114.updateScope(new xl(r29, r30, r27, r4, r5, r25, r42, r41, r26, r39, r40));
        return;
    L158:
        return;
    L148:
        r20 = Modifier.Companion;
        goto L149
    L141:
        r19 = r3;
        r18 = r37;
        goto L142
    L137:
        r14 = r36;
        goto L138
    L133:
        r13 = r35;
        goto L135
    L130:
        r11 = r34;
        goto L131
    L127:
        r10 = 6;
        goto L128
    L123:
        r22 = r1;
        r21 = r4;
        goto L125
    L119:
        r3 = r31;
        goto L121
    L105:
        if (r15.getDefaultsInvalid() == true) goto L117;
        r15.skipToGroupEnd();
        if ((r40 & 8) == 0) goto L111;
        r1 = r1 & (-7169);
    L111:
        if ((r40 & 16) == 0) goto L114;
        r1 = r1 & (-57345);
    L114:
        if ((r40 & 128) == 0) goto L116;
        r1 = r1 & (-29360129);
    L116:
        r19 = r31;
        r18 = r37;
        r17 = r1;
        r11 = r34;
        goto L142
    L153:
        r24 = r15;
        r24.skipToGroupEnd();
        r27 = r31;
        r25 = r34;
        r42 = r35;
        r41 = r36;
        r26 = r37;
        goto L154
    L99:
        r0 = false;
        goto L101
    L90:
        if ((r39 & 100663296) != 0) goto L97;
        if (r15.changed(r37) == false) goto L94;
        int r115 = 67108864;
    L95:
        r1 = r1 | r115;
        goto L97
    L94:
        r115 = 33554432;
        goto L95
    L81:
        if (r15.changed(r7) == false) goto L83;
        r6 = 8388608;
        goto L84
    L85:
        r7 = r36;
        goto L86
    L69:
        r8 = r35;
        if ((1572864 & r39) != 0) goto L77;
        if (r15.changed(r8) == false) goto L74;
        int r43 = 1048576;
    L75:
        r1 = r1 | r43;
        goto L77
    L74:
        r43 = 524288;
        goto L75
    L60:
        if ((196608 & r39) != 0) goto L66;
        if (r15.changed(r34) == false) goto L64;
        int r44 = 131072;
    L65:
        r1 = r1 | r44;
        goto L66
    L64:
        r44 = 65536;
        goto L65
    L48:
        if ((r40 & 16) != 0) goto L52;
        r5 = r33;
        if (r15.changed(r5) == false) goto L53;
        int r45 = 16384;
    L54:
        r1 = r1 | r45;
    L53:
        r45 = 8192;
        goto L54
    L52:
        r5 = r33;
        goto L53
    L37:
        if ((r40 & 8) != 0) goto L41;
        r4 = r32;
        if (r15.changed(r4) == false) goto L42;
        int r46 = 2048;
    L43:
        r1 = r1 | r46;
    L42:
        r46 = 1024;
        goto L43
    L41:
        r4 = r32;
        goto L42
    L27:
        if ((r39 & 384) != 0) goto L35;
        if (r15.changed(r31) == false) goto L31;
        int r47 = 256;
    L32:
        r1 = r1 | r47;
        goto L35
    L31:
        r47 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L23;
        if (r15.changedInstance(r30) == false) goto L21;
        int r48 = 32;
    L22:
        r1 = r1 | r48;
        goto L23
    L21:
        r48 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r1 = r39;
        goto L14
    L8:
        if (r15.changed(r29) == false) goto L10;
        int r49 = 4;
    L11:
        r1 = r49 | r39;
        goto L14
    L10:
        r49 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: access$FullScreenSearchBarLayout-EQC0FA8, reason: not valid java name */
    public static final /* synthetic */ void m3063access$FullScreenSearchBarLayoutEQC0FA8(SearchBarState r0, PredictiveBackState r1, Function2 r2, Modifier r3, Shape r4, SearchBarColors r5, float r6, float r7, WindowInsets r8, Function3 r9, Composer r10, int r11) {
        m3056FullScreenSearchBarLayoutEQC0FA8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    /* JADX INFO: renamed from: ExpandedFullScreenSearchBar-_UtchM0, reason: not valid java name */
    public static final void m3055ExpandedFullScreenSearchBar_UtchM0(final SearchBarState r29, final Function2<? super Composer, ? super Integer, Unit> r30, Modifier r31, Shape r32, SearchBarColors r33, float r34, float r35, Function2<? super Composer, ? super Integer, ? extends WindowInsets> r36, DialogProperties r37, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40, final int r41) {
        Composer r13 = r39.startRestartGroup(-909632031);
        if ((r41 & 1) == 0) goto L6;
        int r1 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r41 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L35:
        if ((r40 & 3072) == 0) goto L37;
        final Shape r4 = r32;
    L46:
        if ((r40 & 24576) == 0) goto L48;
        final SearchBarColors r5 = r33;
    L56:
        int r16 = r41 & 32;
        if (r16 == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        int r18 = r41 & 64;
        if (r18 == 0) goto L69;
        r1 = r1 | 1572864;
        float r8 = r35;
    L77:
        if ((12582912 & r40) != 0) goto L85;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> r7 = r36;
        if ((r41 & 128) == 0) goto L81;
    L83:
        int r6 = 4194304;
    L84:
        r1 = r1 | r6;
    L86:
        int r9 = r41 & 256;
        if (r9 == 0) goto L89;
        r1 = r1 | 100663296;
        DialogProperties r14 = r37;
    L97:
        if ((r41 & 512) == 0) goto L100;
        r1 = r1 | 805306368;
    L107:
        boolean r20 = false;
        if ((r1 & 306783379) == 306783378) goto L110;
        boolean r0 = true;
    L112:
        if (r13.shouldExecute(r0, r1 & 1) == false) goto L179;
        r13.startDefaults();
        if ((r40 & 1) != 0) goto L116;
    L128:
        if (r2 == 0) goto L130;
        Modifier r3 = Modifier.Companion;
    L132:
        if ((r41 & 8) == 0) goto L134;
        int r24 = r1 & (-7169);
        Shape r23 = SearchBarDefaults.INSTANCE.getInputFieldShape(r13, 6);
    L136:
        if ((r41 & 16) == 0) goto L138;
        boolean r11 = true;
        r24 = r24 & (-57345);
        r5 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r13, 3072, 7);
    L139:
        if (r16 == 0) goto L141;
        float r10 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L142:
        if (r18 == 0) goto L144;
        float r12 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L146:
        if ((r41 & 128) == 0) goto L148;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> r15 = SearchBarKt$ExpandedFullScreenSearchBar$1.INSTANCE;
        int r17 = r24 & (-29360129);
    L149:
        if (r9 == 0) goto L151;
        Modifier r19 = r3;
        float r21 = r10;
        float r22 = r12;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> r25 = r15;
        int r110 = r17;
        SearchBarColors r111 = r5;
        DialogProperties r26 = new DialogProperties(false, false, false, 7, null);
    L152:
        r13.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventStart(-909632031, r110, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar (SearchBar.kt:353)");
    L156:
        if (isExpanded(r29) == false) goto L158;
        Object r27 = r13.rememberedValue();
        Composer.Companion r28 = Composer.Companion;
        if (r27 != r28.getEmpty()) goto L167;
        r27 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r13);
        r13.updateRememberedValue(r27);
    L167:
        final CoroutineScope r42 = (CoroutineScope) r27;
        boolean r43 = r13.changedInstance(r42);
        if ((r110 & 14) != 4) goto L170;
        r20 = true;
    L170:
        boolean r44 = r43 | r20;
        Object r45 = r13.rememberedValue();
        if (r44 == false) goto L173;
    L174:
        r45 = new lm(r42, r29);
        r13.updateRememberedValue(r45);
    L175:
        Function0 r112 = (Function0) r45;
        final Modifier r46 = r19;
        final Shape r47 = r23;
        final SearchBarColors r48 = r111;
        final float r49 = r21;
        final float r50 = r22;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> r51 = r25;
        DialogProperties r52 = r26;
        BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog(r112, null, r52, false, false, ComposableLambdaKt.rememberComposableLambda(625093617, r11, new SearchBarKt$ExpandedFullScreenSearchBar$4(r29, r46, r47, r48, r49, r50, r51, r38, r30), r13, 54), r13, ((r110 >> 18) & 896) | 196608, 26);
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        ComposerKt.traceEventEnd();
    L178:
        final Modifier r53 = r19;
        r5 = r111;
        final float r54 = r21;
        final float r55 = r22;
        r4 = r23;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> r56 = r25;
        final DialogProperties r57 = r26;
    L180:
        ScopeUpdateScope r113 = r13.endRestartGroup();
        if (r113 == null) goto L185;
        r113.updateScope(new mm(r29, r30, r53, r4, r5, r54, r55, r56, r57, r38, r40, r41));
        return;
    L185:
        return;
    L173:
        if (r45 != r28.getEmpty()) goto L175;
    L158:
        if (ComposerKt.isTraceInProgress() == false) goto L160;
        ComposerKt.traceEventEnd();
    L160:
        ScopeUpdateScope r114 = r13.endRestartGroup();
        if (r114 == null) goto L184;
        final Modifier r58 = r19;
        final Shape r59 = r23;
        final SearchBarColors r60 = r111;
        final float r61 = r21;
        final float r62 = r22;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> r63 = r25;
        final DialogProperties r64 = r26;
        r114.updateScope(new km(r29, r30, r58, r59, r60, r61, r62, r63, r64, r38, r40, r41));
        return;
    L184:
        return;
    L151:
        r19 = r3;
        r21 = r10;
        r22 = r12;
        r25 = r15;
        r111 = r5;
        r26 = r14;
        r110 = r17;
        goto L152
    L148:
        r15 = r36;
        r17 = r24;
        goto L149
    L144:
        r12 = r35;
        goto L146
    L141:
        r10 = r34;
        goto L142
    L138:
        r11 = true;
        goto L139
    L134:
        r24 = r1;
        r23 = r4;
        goto L136
    L130:
        r3 = r31;
        goto L132
    L116:
        if (r13.getDefaultsInvalid() == true) goto L128;
        r13.skipToGroupEnd();
        if ((r41 & 8) == 0) goto L122;
        r1 = r1 & (-7169);
    L122:
        if ((r41 & 16) == 0) goto L125;
        r1 = r1 & (-57345);
    L125:
        if ((r41 & 128) == 0) goto L127;
        r1 = r1 & (-29360129);
    L127:
        r19 = r31;
        r21 = r34;
        r23 = r4;
        r111 = r5;
        r25 = r7;
        r22 = r8;
        r26 = r14;
        r11 = true;
        r110 = r1;
        goto L152
    L179:
        r13.skipToGroupEnd();
        r53 = r31;
        r54 = r34;
        r55 = r35;
        r56 = r36;
        r57 = r14;
        goto L180
    L110:
        r0 = false;
        goto L112
    L100:
        if ((r40 & 805306368) != 0) goto L107;
        if (r13.changedInstance(r38) == false) goto L104;
        int r210 = 536870912;
    L105:
        r1 = r1 | r210;
        goto L107
    L104:
        r210 = 268435456;
        goto L105
    L89:
        r14 = r37;
        if ((r40 & 100663296) != 0) goto L97;
        if (r13.changed(r14) == false) goto L94;
        int r115 = 67108864;
    L95:
        r1 = r1 | r115;
        goto L97
    L94:
        r115 = 33554432;
        goto L95
    L81:
        if (r13.changedInstance(r7) == false) goto L83;
        r6 = 8388608;
        goto L84
    L85:
        r7 = r36;
        goto L86
    L69:
        r8 = r35;
        if ((1572864 & r40) != 0) goto L77;
        if (r13.changed(r8) == false) goto L74;
        int r65 = 1048576;
    L75:
        r1 = r1 | r65;
        goto L77
    L74:
        r65 = 524288;
        goto L75
    L60:
        if ((r40 & 196608) != 0) goto L66;
        if (r13.changed(r34) == false) goto L64;
        int r66 = 131072;
    L65:
        r1 = r1 | r66;
        goto L66
    L64:
        r66 = 65536;
        goto L65
    L48:
        if ((r41 & 16) != 0) goto L52;
        r5 = r33;
        if (r13.changed(r5) == false) goto L53;
        int r67 = 16384;
    L54:
        r1 = r1 | r67;
    L53:
        r67 = 8192;
        goto L54
    L52:
        r5 = r33;
        goto L53
    L37:
        if ((r41 & 8) != 0) goto L41;
        r4 = r32;
        if (r13.changed(r4) == false) goto L42;
        int r68 = 2048;
    L43:
        r1 = r1 | r68;
    L42:
        r68 = 1024;
        goto L43
    L41:
        r4 = r32;
        goto L42
    L27:
        if ((r40 & 384) != 0) goto L35;
        if (r13.changed(r31) == false) goto L31;
        int r69 = 256;
    L32:
        r1 = r1 | r69;
        goto L35
    L31:
        r69 = 128;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L23;
        if (r13.changedInstance(r30) == false) goto L21;
        int r70 = 32;
    L22:
        r1 = r1 | r70;
        goto L23
    L21:
        r70 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r1 = r40;
        goto L14
    L8:
        if (r13.changed(r29) == false) goto L10;
        int r71 = 4;
    L11:
        r1 = r71 | r40;
        goto L14
    L10:
        r71 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SearchBar-Y92LkZI, reason: not valid java name */
    public static final void m3058SearchBarY92LkZI(final Function2<? super Composer, ? super Integer, Unit> r36, final boolean r37, final Function1<? super Boolean, Unit> r38, Modifier r39, Shape r40, SearchBarColors r41, float r42, float r43, WindowInsets r44, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r45, Composer r46, final int r47, final int r48) {
        Composer r8 = r46.startRestartGroup(1451547856);
        if ((r48 & 1) == 0) goto L6;
        int r1 = r47 | 6;
    L14:
        if ((r48 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r48 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r3 = r48 & 8;
        if (r3 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        Modifier r5 = r39;
    L45:
        if ((r47 & 24576) == 0) goto L47;
        Shape r13 = r40;
    L56:
        if ((196608 & r47) == 0) goto L58;
        SearchBarColors r14 = r41;
    L66:
        int r22 = r48 & 64;
        if (r22 == 0) goto L70;
        r1 = r1 | 1572864;
    L76:
        float r15 = r42;
    L77:
        int r10 = r48 & 128;
        if (r10 == 0) goto L80;
        r1 = r1 | 12582912;
        float r4 = r43;
    L88:
        if ((r47 & 100663296) != 0) goto L99;
        if ((r48 & 256) != 0) goto L95;
        if (r8.changed(r44) == false) goto L95;
        int r16 = 67108864;
    L96:
        r1 = r1 | r16;
    L95:
        r16 = 33554432;
    L99:
        if ((r48 & 512) == 0) goto L102;
        r1 = r1 | 805306368;
    L110:
        if ((r1 & 306783379) == 306783378) goto L112;
        boolean r0 = true;
    L114:
        if (r8.shouldExecute(r0, r1 & 1) == false) goto L202;
        r8.startDefaults();
        if ((r47 & 1) != 0) goto L118;
    L130:
        if (r3 == 0) goto L133;
        r5 = Modifier.Companion;
    L133:
        if ((r48 & 16) == 0) goto L135;
        Shape r2 = SearchBarDefaults.INSTANCE.getInputFieldShape(r8, 6);
        r1 = r1 & (-57345);
    L137:
        if ((r48 & 32) == 0) goto L139;
        SearchBarColors r17 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r8, 3072, 7);
        r1 = r1 & (-458753);
    L140:
        if (r22 == 0) goto L142;
        float r18 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L143:
        if (r10 == 0) goto L146;
        r4 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L146:
        if ((r48 & 256) == 0) goto L148;
        int r19 = r1 & (-234881025);
        WindowInsets r33 = SearchBarDefaults.INSTANCE.getWindowInsets(r8, 6);
    L149:
        float r32 = r4;
        Modifier r11 = r5;
        SearchBarColors r30 = r17;
        float r31 = r18;
    L150:
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventStart(1451547856, r19, -1, "androidx.compose.material3.SearchBar (SearchBar.kt:544)");
    L153:
        Object r6 = r8.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r6 != r110.getEmpty()) goto L156;
        r6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r8);
        r8.updateRememberedValue(r6);
    L156:
        CoroutineScope r111 = (CoroutineScope) r6;
        Object r7 = r8.rememberedValue();
        if (r7 == r110.getEmpty()) goto L159;
    L163:
        Animatable r9 = (Animatable) r7;
        Object r12 = r8.rememberedValue();
        if (r12 != r110.getEmpty()) goto L166;
        r12 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        r8.updateRememberedValue(r12);
    L166:
        MutableFloatState r23 = (MutableFloatState) r12;
        Object r20 = r8.rememberedValue();
        if (r20 != r110.getEmpty()) goto L169;
        int r21 = 2;
        r20 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r8.updateRememberedValue(r20);
    L170:
        MutableState r24 = (MutableState) r20;
        Object r25 = r8.rememberedValue();
        if (r25 != r110.getEmpty()) goto L173;
        r25 = SnapshotStateKt.mutableStateOf$default(null, null, r21, null);
        r8.updateRememberedValue(r25);
    L173:
        MutableState r26 = (MutableState) r25;
        Boolean r27 = Boolean.valueOf(r37);
        boolean r28 = r8.changedInstance(r9);
        if ((r19 & 112) != 32) goto L176;
        boolean r29 = true;
    L177:
        boolean r34 = r28 | r29;
        Object r35 = r8.rememberedValue();
        if (r34 == false) goto L180;
    L183:
        int r112 = 0;
        SearchBarKt$SearchBar$3$1 r49 = new SearchBarKt$SearchBar$3$1(r9, r37, r23, r24, r26, null);
        r8.updateRememberedValue(r49);
        r35 = r49;
    L184:
        int r50 = (r19 >> 3) & 14;
        EffectsKt.LaunchedEffect(r27, (Function2) r35, r8, r50);
        Object r51 = r8.rememberedValue();
        if (r51 != r110.getEmpty()) goto L187;
        r51 = new MutatorMutex();
        r8.updateRememberedValue(r51);
    L187:
        MutatorMutex r52 = (MutatorMutex) r51;
        boolean r53 = r8.changedInstance(r9);
        if ((r19 & 896) != 256) goto L190;
        boolean r54 = true;
    L191:
        boolean r55 = (r53 | r54) | r8.changedInstance(r111);
        Object r56 = r8.rememberedValue();
        if (r55 == false) goto L194;
    L197:
        r56 = new SearchBarKt$SearchBar$4$1(r52, r23, r9, r38, r111, r24, r26, null);
        r8.updateRememberedValue(r56);
    L198:
        BackHandler_androidKt.PredictiveBackHandler(r37, (Function2) r56, r8, r50, r112);
        int r57 = ((Animatable.$stable | 3504) | ((r19 << 3) & 57344)) | ((r19 << 15) & 458752);
        int r58 = r19 << 6;
        int r210 = (((r57 | (3670016 & r58)) | (29360128 & r58)) | (234881024 & r58)) | (r58 & 1879048192);
        int r59 = r19 >> 24;
        Modifier r113 = r11;
        Shape r114 = r2;
        SearchBarColors r211 = r30;
        float r212 = r31;
        float r213 = r32;
        WindowInsets r214 = r33;
        m3060SearchBarImplj1jLAyQ(r9, r23, r24, r26, r113, r36, r114, r211, r212, r213, r214, r45, r8, r210, (r59 & 14) | (r59 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L201;
        ComposerKt.traceEventEnd();
    L201:
        final Modifier r60 = r11;
        final Shape r61 = r2;
        final SearchBarColors r62 = r30;
        final WindowInsets r63 = r33;
    L203:
        ScopeUpdateScope r115 = r8.endRestartGroup();
        if (r115 == null) goto L207;
        final float r64 = r31;
        final float r65 = r32;
        r115.updateScope(new fm(r36, r37, r38, r60, r61, r62, r64, r65, r63, r45, r47, r48));
        return;
    L207:
        return;
    L194:
        if (r56 != r110.getEmpty()) goto L198;
    L190:
        r54 = false;
        goto L191
    L180:
        if (r35 == r110.getEmpty()) goto L183;
        r112 = 0;
        goto L184
    L176:
        r29 = false;
        goto L177
    L169:
        r21 = 2;
        goto L170
    L159:
        if (r37 == false) goto L161;
        float r66 = 1.0f;
    L162:
        r7 = AnimatableKt.Animatable$default(r66, MenuKt.ClosedAlphaTarget, 2, null);
        r8.updateRememberedValue(r7);
        goto L163
    L161:
        r66 = MenuKt.ClosedAlphaTarget;
        goto L162
    L148:
        r33 = r44;
        r19 = r1;
        goto L149
    L142:
        r18 = r42;
        goto L143
    L139:
        r17 = r14;
        goto L140
    L135:
        r2 = r13;
        goto L137
    L118:
        if (r8.getDefaultsInvalid() == true) goto L130;
        r8.skipToGroupEnd();
        if ((r48 & 16) == 0) goto L124;
        r1 = r1 & (-57345);
    L124:
        if ((r48 & 32) == 0) goto L127;
        r1 = r1 & (-458753);
    L127:
        if ((r48 & 256) == 0) goto L129;
        r1 = r1 & (-234881025);
    L129:
        r33 = r44;
        r32 = r4;
        r11 = r5;
        r2 = r13;
        r30 = r14;
        r31 = r15;
        r19 = r1;
        goto L150
    L202:
        r8.skipToGroupEnd();
        r31 = r42;
        r63 = r44;
        r32 = r4;
        r60 = r5;
        r61 = r13;
        r62 = r14;
        goto L203
    L112:
        r0 = false;
        goto L114
    L102:
        if ((r47 & 805306368) != 0) goto L110;
        if (r8.changedInstance(r45) == false) goto L106;
        int r116 = 536870912;
    L107:
        r1 = r1 | r116;
        goto L110
    L106:
        r116 = 268435456;
        goto L107
    L80:
        r4 = r43;
        if ((r47 & 12582912) != 0) goto L88;
        if (r8.changed(r4) == false) goto L85;
        int r117 = 8388608;
    L86:
        r1 = r1 | r117;
        goto L88
    L85:
        r117 = 4194304;
        goto L86
    L70:
        if ((1572864 & r47) != 0) goto L76;
        r15 = r42;
        if (r8.changed(r15) == false) goto L74;
        int r118 = 1048576;
    L75:
        r1 = r1 | r118;
        goto L77
    L74:
        r118 = 524288;
        goto L75
    L58:
        if ((r48 & 32) != 0) goto L62;
        r14 = r41;
        if (r8.changed(r14) == false) goto L63;
        int r119 = 131072;
    L64:
        r1 = r1 | r119;
    L63:
        r119 = 65536;
        goto L64
    L62:
        r14 = r41;
        goto L63
    L47:
        if ((r48 & 16) != 0) goto L51;
        r13 = r40;
        if (r8.changed(r13) == false) goto L52;
        int r120 = 16384;
    L53:
        r1 = r1 | r120;
    L52:
        r120 = 8192;
        goto L53
    L51:
        r13 = r40;
        goto L52
    L37:
        if ((r47 & 3072) != 0) goto L43;
        r5 = r39;
        if (r8.changed(r5) == false) goto L41;
        int r121 = 2048;
    L42:
        r1 = r1 | r121;
        goto L45
    L41:
        r121 = 1024;
        goto L42
    L27:
        if ((r47 & 384) != 0) goto L33;
        if (r8.changedInstance(r38) == false) goto L31;
        int r67 = 256;
    L32:
        r1 = r1 | r67;
        goto L33
    L31:
        r67 = 128;
        goto L32
    L17:
        if ((r47 & 48) != 0) goto L24;
        if (r8.changed(r37) == false) goto L21;
        int r68 = 32;
    L22:
        r1 = r1 | r68;
        goto L24
    L21:
        r68 = 16;
        goto L22
    L6:
        if ((r47 & 6) == 0) goto L8;
        r1 = r47;
        goto L14
    L8:
        if (r8.changedInstance(r36) == false) goto L10;
        int r69 = 4;
    L11:
        r1 = r69 | r47;
        goto L14
    L10:
        r69 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SearchBarImpl-j1jLAyQ, reason: not valid java name */
    public static final void m3060SearchBarImplj1jLAyQ(final Animatable<Float, AnimationVector1D> r31, final MutableFloatState r32, final MutableState<BackEventCompat> r33, final MutableState<BackEventCompat> r34, Modifier r35, final Function2<? super Composer, ? super Integer, Unit> r36, Shape r37, SearchBarColors r38, float r39, float r40, WindowInsets r41, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r42, Composer r43, final int r44, final int r45, final int r46) {
        Composer r14 = r43.startRestartGroup(501752896);
        if ((r46 & 1) == 0) goto L6;
        int r1 = r44 | 6;
    L17:
        if ((r46 & 2) == 0) goto L20;
        r1 = r1 | 48;
    L27:
        if ((r46 & 4) == 0) goto L30;
        r1 = r1 | 384;
    L37:
        if ((r46 & 8) == 0) goto L40;
        r1 = r1 | 3072;
    L46:
        int r4 = r46 & 16;
        if (r4 == 0) goto L50;
        r1 = r1 | 24576;
    L56:
        Modifier r7 = r35;
    L58:
        if ((r46 & 32) == 0) goto L61;
        r1 = r1 | 196608;
    L68:
        if ((r44 & 1572864) != 0) goto L76;
        Shape r2 = r37;
        if ((r46 & 64) == 0) goto L72;
    L74:
        int r18 = 524288;
    L75:
        r1 = r1 | r18;
    L78:
        if ((r44 & 12582912) == 0) goto L80;
        SearchBarColors r3 = r38;
    L88:
        int r9 = r46 & 256;
        if (r9 == 0) goto L92;
        r1 = r1 | 100663296;
    L99:
        int r10 = r46 & 512;
        if (r10 == 0) goto L103;
        r1 = r1 | 805306368;
    L111:
        if ((r45 & 6) == 0) goto L113;
        WindowInsets r5 = r41;
        int r19 = r45;
    L122:
        if ((r46 & 2048) == 0) goto L125;
        r19 = r19 | 48;
    L132:
        if ((306783379 & r1) == 306783378) goto L134;
    L137:
        boolean r0 = true;
    L139:
        if (r14.shouldExecute(r0, r1 & 1) == false) goto L212;
        r14.startDefaults();
        int r6 = 6;
        if ((r44 & 1) != 0) goto L143;
    L155:
        if (r4 == 0) goto L157;
        Modifier r8 = Modifier.Companion;
    L159:
        if ((r46 & 64) == 0) goto L161;
        r2 = SearchBarDefaults.INSTANCE.getInputFieldShape(r14, 6);
        r1 = r1 & (-3670017);
    L161:
        int r24 = r1;
        Shape r23 = r2;
        if ((r46 & 128) == 0) goto L164;
        SearchBarColors r11 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r14, 3072, 7);
        int r12 = r24 & (-29360129);
    L165:
        if (r9 == 0) goto L167;
        float r13 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L168:
        if (r10 == 0) goto L170;
        float r15 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L172:
        if ((r46 & 1024) == 0) goto L174;
        r6 = 6;
        final SearchBarColors r16 = r11;
        r1 = r12;
        final float r17 = r13;
        WindowInsets r20 = SearchBarDefaults.INSTANCE.getWindowInsets(r14, 6);
        int r21 = r19 & (-15);
        Shape r22 = r23;
        Modifier r110 = r8;
        final float r25 = r15;
    L175:
        r14.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        ComposerKt.traceEventStart(501752896, r1, r21, "androidx.compose.material3.SearchBarImpl (SearchBar.kt:2093)");
    L178:
        final Density r26 = (Density) r14.consume(CompositionLocalsKt.getLocalDensity());
        SearchBarDefaults r27 = SearchBarDefaults.INSTANCE;
        Shape r28 = r27.getInputFieldShape(r14, r6);
        Shape r29 = r27.getFullScreenShape(r14, r6);
        Object r30 = r14.rememberedValue();
        Composer.Companion r210 = Composer.Companion;
        if (r30 != r210.getEmpty()) goto L181;
        r30 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new qm(r31));
        r14.updateRememberedValue(r30);
    L181:
        State r47 = (State) r30;
        boolean r48 = r14.changed(SearchBarImpl_j1jLAyQ$lambda$32(r47));
        if (((r1 & 3670016) ^ 1572864) <= 1048576) goto L186;
        if (r14.changed(r22) == false) goto L186;
    L187:
        boolean r111 = true;
    L189:
        boolean r49 = r48 | r111;
        Object r112 = r14.rememberedValue();
        if (r49 == true) goto L194;
        if (r112 == r210.getEmpty()) goto L194;
    L201:
        final Shape r113 = (Shape) r112;
        ComposableLambda r114 = ComposableLambdaKt.rememberComposableLambda(-1304392981, true, new SearchBarKt$SearchBarImpl$surface$1(r113, r16, r17, r25), r14, 54);
        Object r50 = r14.rememberedValue();
        if (r50 != r210.getEmpty()) goto L205;
        r50 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new sm(r31));
        r14.updateRememberedValue(r50);
    L205:
        if (SearchBarImpl_j1jLAyQ$lambda$38((State) r50) == false) goto L207;
        r14.startReplaceGroup(1236615731);
        ComposableLambda r51 = ComposableLambdaKt.rememberComposableLambda(1831594093, true, new SearchBarKt$SearchBarImpl$wrappedContent$1(r31, r16, r42), r14, 54);
        r14.endReplaceGroup();
    L208:
        Modifier r52 = r110;
        float r115 = r25;
        WindowInsets r53 = r20;
        float r116 = r17;
        SearchBarColors r211 = r16;
        Shape r212 = r22;
        SearchBarLayout(r31, r32, r33, r34, r52, r53, r36, r114, r51, r14, (((((((Animatable.$stable | 12582912) | (r1 & 14)) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | ((r21 << 15) & 458752)) | ((r1 << 3) & 3670016));
        if (ComposerKt.isTraceInProgress() == false) goto L211;
        ComposerKt.traceEventEnd();
    L211:
        final float r117 = r115;
        final float r54 = r116;
        final Modifier r55 = r110;
        final SearchBarColors r56 = r211;
        final Shape r57 = r212;
    L213:
        ScopeUpdateScope r118 = r14.endRestartGroup();
        if (r118 == null) goto L217;
        final WindowInsets r119 = r20;
        r118.updateScope(new tm(r31, r32, r33, r34, r55, r36, r57, r56, r54, r117, r119, r42, r44, r45, r46));
        return;
    L217:
        return;
    L207:
        r14.startReplaceGroup(1236851485);
        r14.endReplaceGroup();
        r51 = null;
    L194:
        if (Intrinsics.areEqual(r22, r28) == false) goto L197;
        Shape r58 = new GenericShape(new rm(r26, r31));
    L200:
        r14.updateRememberedValue(r58);
        r112 = r58;
        goto L201
    L197:
        if (SearchBarImpl_j1jLAyQ$lambda$32(r47) == false) goto L199;
        r58 = r29;
        goto L200
    L199:
        r58 = r22;
    L186:
        if ((r1 & 1572864) == 1048576) goto L187;
        r111 = false;
        goto L189
    L174:
        r6 = 6;
        r20 = r41;
        r16 = r11;
        r1 = r12;
        r17 = r13;
        r25 = r15;
        r21 = r19;
        r22 = r23;
        r110 = r8;
        goto L175
    L170:
        r15 = r40;
        goto L172
    L167:
        r13 = r39;
        goto L168
    L164:
        r11 = r3;
        r12 = r24;
        goto L165
    L157:
        r8 = r7;
        goto L159
    L143:
        if (r14.getDefaultsInvalid() == true) goto L155;
        r14.skipToGroupEnd();
        if ((r46 & 64) == 0) goto L149;
        r1 = r1 & (-3670017);
    L149:
        if ((r46 & 128) == 0) goto L152;
        r1 = r1 & (-29360129);
    L152:
        if ((r46 & 1024) == 0) goto L154;
        r19 = r19 & (-15);
    L154:
        r22 = r2;
        r16 = r3;
        r20 = r5;
        r21 = r19;
        r25 = r40;
        r110 = r7;
        r17 = r39;
        goto L175
    L212:
        r14.skipToGroupEnd();
        r54 = r39;
        r117 = r40;
        r20 = r41;
        r56 = r3;
        r55 = r7;
        r57 = r2;
        goto L213
    L134:
        if ((r19 & 19) != 18) goto L137;
        r0 = false;
        goto L139
    L125:
        if ((r45 & 48) != 0) goto L132;
        if (r14.changedInstance(r42) == false) goto L129;
        int r213 = 32;
    L130:
        r19 = r19 | r213;
        goto L132
    L129:
        r213 = 16;
        goto L130
    L113:
        if ((r46 & 1024) != 0) goto L117;
        r5 = r41;
        if (r14.changed(r5) == false) goto L118;
        int r120 = 4;
    L119:
        r19 = r45 | r120;
    L118:
        r120 = 2;
        goto L119
    L117:
        r5 = r41;
        goto L118
    L103:
        if ((r44 & 805306368) != 0) goto L111;
        if (r14.changed(r40) == false) goto L107;
        int r214 = 536870912;
    L108:
        r1 = r1 | r214;
        goto L111
    L107:
        r214 = 268435456;
        goto L108
    L92:
        if ((r44 & 100663296) != 0) goto L99;
        if (r14.changed(r39) == false) goto L96;
        int r215 = 67108864;
    L97:
        r1 = r1 | r215;
        goto L99
    L96:
        r215 = 33554432;
        goto L97
    L80:
        if ((r46 & 128) != 0) goto L84;
        r3 = r38;
        if (r14.changed(r3) == false) goto L85;
        int r216 = 8388608;
    L86:
        r1 = r1 | r216;
    L85:
        r216 = 4194304;
        goto L86
    L84:
        r3 = r38;
        goto L85
    L72:
        if (r14.changed(r2) == false) goto L74;
        r18 = 1048576;
        goto L75
    L76:
        r2 = r37;
        goto L78
    L61:
        if ((r44 & 196608) != 0) goto L68;
        if (r14.changedInstance(r36) == false) goto L65;
        int r121 = 131072;
    L66:
        r1 = r1 | r121;
        goto L68
    L65:
        r121 = 65536;
        goto L66
    L50:
        if ((r44 & 24576) != 0) goto L56;
        r7 = r35;
        if (r14.changed(r7) == false) goto L54;
        int r122 = 16384;
    L55:
        r1 = r1 | r122;
        goto L58
    L54:
        r122 = 8192;
        goto L55
    L40:
        if ((r44 & 3072) != 0) goto L46;
        if (r14.changed(r34) == false) goto L44;
        int r59 = 2048;
    L45:
        r1 = r1 | r59;
        goto L46
    L44:
        r59 = 1024;
        goto L45
    L30:
        if ((r44 & 384) != 0) goto L37;
        if (r14.changed(r33) == false) goto L34;
        int r60 = 256;
    L35:
        r1 = r1 | r60;
        goto L37
    L34:
        r60 = 128;
        goto L35
    L20:
        if ((r44 & 48) != 0) goto L27;
        if (r14.changed(r32) == false) goto L24;
        int r61 = 32;
    L25:
        r1 = r1 | r61;
        goto L27
    L24:
        r61 = 16;
        goto L25
    L6:
        if ((r44 & 6) == 0) goto L8;
        r1 = r44;
        goto L17
    L8:
        if ((r44 & 8) != 0) goto L10;
        boolean r62 = r14.changed(r31);
    L11:
        if (r62 == false) goto L13;
        int r63 = 4;
    L14:
        r1 = r63 | r44;
        goto L17
    L13:
        r63 = 2;
        goto L14
    L10:
        r62 = r14.changedInstance(r31);
        goto L11
    }

    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(expression = "DockedSearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: DockedSearchBar-eWTbjVg, reason: not valid java name */
    public static final void m3052DockedSearchBareWTbjVg(final String r44, final Function1<? super String, Unit> r45, final Function1<? super String, Unit> r46, final boolean r47, final Function1<? super Boolean, Unit> r48, Modifier r49, boolean r50, Function2<? super Composer, ? super Integer, Unit> r51, Function2<? super Composer, ? super Integer, Unit> r52, Function2<? super Composer, ? super Integer, Unit> r53, Shape r54, SearchBarColors r55, float r56, float r57, MutableInteractionSource r58, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r59, Composer r60, final int r61, final int r62, final int r63) {
        Composer r12 = r60.startRestartGroup(1929583712);
        if ((r63 & 1) == 0) goto L6;
        int r1 = r61 | 6;
    L14:
        if ((r63 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r63 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r16 = 2048;
        if ((r63 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        int r19 = 16384;
        if ((r63 & 16) == 0) goto L48;
        r1 = r1 | 24576;
    L55:
        int r18 = r63 & 32;
        int r21 = 131072;
        if (r18 == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        int r25 = r63 & 64;
        if (r25 == 0) goto L68;
        r1 = r1 | 1572864;
        boolean r5 = r50;
    L75:
        int r6 = r63 & 128;
        if (r6 == 0) goto L78;
        r1 = r1 | 12582912;
        Function2<? super Composer, ? super Integer, Unit> r7 = r51;
    L85:
        int r8 = r63 & 256;
        if (r8 == 0) goto L89;
        r1 = r1 | 100663296;
    L95:
        int r0 = r63 & 512;
        if (r0 == 0) goto L99;
        r1 = r1 | 805306368;
    L106:
        if ((r62 & 6) == 0) goto L108;
        int r24 = r62;
    L117:
        if ((r62 & 48) != 0) goto L127;
        if ((r63 & 2048) != 0) goto L124;
        if (r12.changed(r55) == false) goto L124;
        int r26 = 32;
    L125:
        r24 = r24 | r26;
    L124:
        r26 = 16;
    L127:
        int r2 = r24;
        int r9 = r63 & 4096;
        if (r9 == 0) goto L131;
        r2 = r2 | 384;
    L138:
        int r10 = r63 & 8192;
        if (r10 == 0) goto L142;
        r2 = r2 | 3072;
    L149:
        int r11 = r63 & 16384;
        if (r11 == 0) goto L153;
        r2 = r2 | 24576;
    L161:
        if ((r63 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L164;
        r2 = r2 | 196608;
    L172:
        if ((r1 & 306783379) == 306783378) goto L174;
    L177:
        boolean r3 = true;
    L179:
        if (r12.shouldExecute(r3, r1 & 1) == false) goto L235;
        r12.startDefaults();
        if ((r61 & 1) != 0) goto L183;
    L192:
        if (r18 == 0) goto L194;
        Modifier r110 = Modifier.Companion;
    L195:
        if (r25 == 0) goto L197;
        boolean r111 = true;
    L199:
        if (r6 == 0) goto L201;
        Function2<? super Composer, ? super Integer, Unit> r22 = null;
    L202:
        if (r8 == 0) goto L204;
        Function2<? super Composer, ? super Integer, Unit> r23 = null;
    L205:
        if (r0 == 0) goto L207;
        Function2<? super Composer, ? super Integer, Unit> r4 = null;
    L209:
        if ((r63 & 1024) == 0) goto L211;
        int r27 = r2 & (-15);
        Shape r28 = SearchBarDefaults.INSTANCE.getDockedShape(r12, 6);
    L213:
        if ((r63 & 2048) == 0) goto L215;
        int r32 = r1;
        boolean r13 = true;
        int r29 = r11;
        SearchBarColors r14 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r12, 3072, 7);
        r2 = r27 & (-113);
    L216:
        if (r9 == 0) goto L218;
        float r38 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L219:
        if (r10 == 0) goto L221;
        float r39 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L222:
        Function2<? super Composer, ? super Integer, Unit> r35 = r4;
        if (r29 == 0) goto L225;
        MutableInteractionSource r40 = null;
    L226:
        Function2<? super Composer, ? super Integer, Unit> r33 = r22;
        Function2<? super Composer, ? super Integer, Unit> r34 = r23;
        Shape r36 = r28;
    L227:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L230;
        int r15 = r32;
        ComposerKt.traceEventStart(1929583712, r15, r2, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:2047)");
    L231:
        final SearchBarColors r17 = r14;
        final boolean r210 = r111;
        final Function2<? super Composer, ? super Integer, Unit> r211 = r33;
        final Function2<? super Composer, ? super Integer, Unit> r212 = r34;
        final Function2<? super Composer, ? super Integer, Unit> r213 = r35;
        final MutableInteractionSource r214 = r40;
        ComposableLambda r20 = ComposableLambdaKt.rememberComposableLambda(-1275782414, r13, new SearchBarKt$DockedSearchBar$4(r17, r44, r45, r46, r47, r48, r210, r211, r212, r213, r214), r12, 54);
        int r30 = r15 >> 6;
        int r31 = (r30 & 7168) | (((r30 & 112) | 6) | (r30 & 896));
        int r37 = r2 << 12;
        int r41 = ((((r31 | (57344 & r37)) | (458752 & r37)) | (3670016 & r37)) | (r37 & 29360128)) | ((r2 << 9) & 234881024);
        Composer r42 = r12;
        m3051DockedSearchBarEQC0FA8(r20, r47, r48, r110, r36, r14, r38, r39, r59, r12, r41, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L234;
        ComposerKt.traceEventEnd();
    L234:
        final Modifier r43 = r110;
        final boolean r64 = r111;
        final Function2<? super Composer, ? super Integer, Unit> r65 = r33;
        final Function2<? super Composer, ? super Integer, Unit> r66 = r34;
        final Function2<? super Composer, ? super Integer, Unit> r112 = r35;
        final Shape r113 = r36;
        final SearchBarColors r114 = r14;
    L236:
        ScopeUpdateScope r67 = r42.endRestartGroup();
        if (r67 == null) goto L240;
        final float r115 = r38;
        final float r116 = r39;
        final MutableInteractionSource r117 = r40;
        r67.updateScope(new dm(r44, r45, r46, r47, r48, r43, r64, r65, r66, r112, r113, r114, r115, r116, r117, r59, r61, r62, r63));
        return;
    L240:
        return;
    L230:
        r15 = r32;
        goto L231
    L225:
        r40 = r58;
        goto L226
    L221:
        r39 = r57;
        goto L222
    L218:
        r38 = r56;
        goto L219
    L215:
        r32 = r1;
        r13 = true;
        r29 = r11;
        r14 = r55;
        r2 = r27;
        goto L216
    L211:
        r28 = r54;
        r27 = r2;
        goto L213
    L207:
        r4 = r53;
        goto L209
    L204:
        r23 = r52;
        goto L205
    L201:
        r22 = r7;
        goto L202
    L197:
        r111 = r5;
        goto L199
    L194:
        r110 = r49;
        goto L195
    L183:
        if (r12.getDefaultsInvalid() == true) goto L192;
        r12.skipToGroupEnd();
        if ((r63 & 1024) == 0) goto L189;
        r2 = r2 & (-15);
    L189:
        if ((r63 & 2048) == 0) goto L191;
        r2 = r2 & (-113);
    L191:
        r110 = r49;
        r34 = r52;
        r35 = r53;
        r36 = r54;
        r14 = r55;
        r38 = r56;
        r39 = r57;
        r40 = r58;
        r32 = r1;
        r111 = r5;
        r33 = r7;
        r13 = true;
        goto L227
    L235:
        r42 = r12;
        r42.skipToGroupEnd();
        r43 = r49;
        r66 = r52;
        r112 = r53;
        r113 = r54;
        r114 = r55;
        r38 = r56;
        r39 = r57;
        r40 = r58;
        r65 = r7;
        r64 = r5;
        goto L236
    L174:
        if ((74899 & r2) != 74898) goto L177;
        r3 = false;
        goto L179
    L164:
        if ((r62 & 196608) != 0) goto L172;
        if (r12.changedInstance(r59) == true) goto L169;
        r21 = 65536;
    L169:
        r2 = r2 | r21;
        goto L172
    L153:
        if ((r62 & 24576) != 0) goto L161;
        if (r12.changed(r58) == true) goto L158;
        r19 = 8192;
    L158:
        r2 = r2 | r19;
        goto L161
    L142:
        if ((r62 & 3072) != 0) goto L149;
        if (r12.changed(r57) == true) goto L147;
        r16 = 1024;
    L147:
        r2 = r2 | r16;
        goto L149
    L131:
        if ((r62 & 384) != 0) goto L138;
        if (r12.changed(r56) == false) goto L135;
        int r215 = 256;
    L136:
        r2 = r2 | r215;
        goto L138
    L135:
        r215 = 128;
        goto L136
    L108:
        if ((r63 & 1024) != 0) goto L113;
        if (r12.changed(r54) == false) goto L113;
        int r216 = 4;
    L114:
        r24 = r62 | r216;
    L113:
        r216 = 2;
        goto L114
    L99:
        if ((r61 & 805306368) != 0) goto L106;
        if (r12.changedInstance(r53) == false) goto L103;
        int r310 = 536870912;
    L104:
        r1 = r1 | r310;
        goto L106
    L103:
        r310 = 268435456;
        goto L104
    L89:
        if ((r61 & 100663296) != 0) goto L95;
        if (r12.changedInstance(r52) == false) goto L93;
        int r311 = 67108864;
    L94:
        r1 = r1 | r311;
        goto L95
    L93:
        r311 = 33554432;
        goto L94
    L78:
        r7 = r51;
        if ((r61 & 12582912) != 0) goto L85;
        if (r12.changedInstance(r7) == false) goto L83;
        int r217 = 8388608;
    L84:
        r1 = r1 | r217;
        goto L85
    L83:
        r217 = 4194304;
        goto L84
    L68:
        r5 = r50;
        if ((r61 & 1572864) != 0) goto L75;
        if (r12.changed(r5) == false) goto L73;
        int r218 = 1048576;
    L74:
        r1 = r1 | r218;
        goto L75
    L73:
        r218 = 524288;
        goto L74
    L59:
        if ((r61 & 196608) != 0) goto L65;
        if (r12.changed(r49) == false) goto L63;
        int r219 = 131072;
    L64:
        r1 = r1 | r219;
        goto L65
    L63:
        r219 = 65536;
        goto L64
    L48:
        if ((r61 & 24576) != 0) goto L55;
        if (r12.changedInstance(r48) == false) goto L52;
        int r118 = 16384;
    L53:
        r1 = r1 | r118;
        goto L55
    L52:
        r118 = 8192;
        goto L53
    L37:
        if ((r61 & 3072) != 0) goto L44;
        if (r12.changed(r47) == false) goto L41;
        int r119 = 2048;
    L42:
        r1 = r1 | r119;
        goto L44
    L41:
        r119 = 1024;
        goto L42
    L27:
        if ((r61 & 384) != 0) goto L33;
        if (r12.changedInstance(r46) == false) goto L31;
        int r68 = 256;
    L32:
        r1 = r1 | r68;
        goto L33
    L31:
        r68 = 128;
        goto L32
    L17:
        if ((r61 & 48) != 0) goto L24;
        if (r12.changedInstance(r45) == false) goto L21;
        int r69 = 32;
    L22:
        r1 = r1 | r69;
        goto L24
    L21:
        r69 = 16;
        goto L22
    L6:
        if ((r61 & 6) == 0) goto L8;
        r1 = r61;
        goto L14
    L8:
        if (r12.changed(r44) == false) goto L10;
        int r70 = 4;
    L11:
        r1 = r70 | r61;
        goto L14
    L10:
        r70 = 2;
        goto L11
    }

    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(expression = "SearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    windowInsets = windowInsets,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: SearchBar-WuY5d9Q, reason: not valid java name */
    public static final void m3057SearchBarWuY5d9Q(final String r37, final Function1<? super String, Unit> r38, final Function1<? super String, Unit> r39, final boolean r40, final Function1<? super Boolean, Unit> r41, Modifier r42, boolean r43, Function2<? super Composer, ? super Integer, Unit> r44, Function2<? super Composer, ? super Integer, Unit> r45, Function2<? super Composer, ? super Integer, Unit> r46, Shape r47, SearchBarColors r48, float r49, float r50, WindowInsets r51, MutableInteractionSource r52, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r53, Composer r54, final int r55, final int r56, final int r57) {
        Composer r10 = r54.startRestartGroup(1506988286);
        if ((r57 & 1) == 0) goto L6;
        int r1 = r55 | 6;
    L14:
        if ((r57 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r57 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r16 = 2048;
        if ((r57 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        int r19 = 8192;
        if ((r57 & 16) == 0) goto L48;
        r1 = r1 | 24576;
    L55:
        int r18 = r57 & 32;
        int r21 = 131072;
        if (r18 == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        int r25 = r57 & 64;
        if (r25 == 0) goto L68;
        r1 = r1 | 1572864;
        boolean r5 = r43;
    L75:
        int r6 = r57 & 128;
        if (r6 == 0) goto L78;
        r1 = r1 | 12582912;
        Function2<? super Composer, ? super Integer, Unit> r7 = r44;
    L85:
        int r8 = r57 & 256;
        if (r8 == 0) goto L89;
        r1 = r1 | 100663296;
    L95:
        int r0 = r57 & 512;
        if (r0 == 0) goto L99;
        r1 = r1 | 805306368;
    L106:
        if ((r56 & 6) == 0) goto L108;
        int r24 = r56;
    L117:
        if ((r56 & 48) != 0) goto L127;
        if ((r57 & 2048) != 0) goto L124;
        if (r10.changed(r48) == false) goto L124;
        int r27 = 32;
    L125:
        r24 = r24 | r27;
    L124:
        r27 = 16;
    L127:
        int r2 = r24;
        int r9 = r57 & 4096;
        if (r9 == 0) goto L131;
        r2 = r2 | 384;
    L138:
        int r11 = r57 & 8192;
        if (r11 == 0) goto L142;
        r2 = r2 | 3072;
    L150:
        if ((r56 & 24576) != 0) goto L159;
        if ((r57 & 16384) != 0) goto L157;
        if (r10.changed(r51) == false) goto L157;
        r19 = 16384;
    L157:
        r2 = r2 | r19;
    L159:
        int r17 = r57 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r17 == 0) goto L163;
        r2 = r2 | 196608;
    L171:
        if ((r57 & 65536) == 0) goto L174;
        r2 = r2 | 1572864;
    L181:
        if ((r1 & 306783379) == 306783378) goto L183;
    L186:
        boolean r3 = true;
    L188:
        if (r10.shouldExecute(r3, r1 & 1) == false) goto L250;
        r10.startDefaults();
        if ((r55 & 1) != 0) goto L192;
    L204:
        if (r18 == 0) goto L206;
        Modifier r110 = Modifier.Companion;
    L207:
        if (r25 == 0) goto L209;
        boolean r111 = true;
    L211:
        if (r6 == 0) goto L213;
        Function2<? super Composer, ? super Integer, Unit> r22 = null;
    L214:
        if (r8 == 0) goto L216;
        Function2<? super Composer, ? super Integer, Unit> r23 = null;
    L217:
        if (r0 == 0) goto L219;
        Function2<? super Composer, ? super Integer, Unit> r4 = null;
    L221:
        if ((r57 & 1024) == 0) goto L223;
        int r26 = r2 & (-15);
        Shape r28 = SearchBarDefaults.INSTANCE.getInputFieldShape(r10, 6);
    L225:
        if ((r57 & 2048) == 0) goto L227;
        int r33 = r1;
        int r112 = r9;
        SearchBarColors r12 = SearchBarDefaults.INSTANCE.m3041colorsKlgxPg(0, 0, null, r10, 3072, 7);
        r26 = r26 & (-113);
    L228:
        if (r112 == 0) goto L230;
        float r13 = SearchBarDefaults.INSTANCE.m3046getTonalElevationD9Ej5fM();
    L231:
        if (r11 == 0) goto L233;
        float r29 = SearchBarDefaults.INSTANCE.m3045getShadowElevationD9Ej5fM();
    L235:
        if ((r57 & 16384) == 0) goto L237;
        WindowInsets r30 = SearchBarDefaults.INSTANCE.getWindowInsets(r10, 6);
        int r14 = r26 & (-57345);
    L238:
        if (r17 == 0) goto L240;
        MutableInteractionSource r32 = null;
    L241:
        r7 = r22;
        Function2<? super Composer, ? super Integer, Unit> r15 = r23;
        Shape r20 = r28;
        Function2<? super Composer, ? super Integer, Unit> r31 = r4;
    L242:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L245;
        int r113 = r33;
        ComposerKt.traceEventStart(1506988286, r113, r14, "androidx.compose.material3.SearchBar (SearchBar.kt:1967)");
    L246:
        final SearchBarColors r114 = r12;
        final boolean r210 = r111;
        final Function2<? super Composer, ? super Integer, Unit> r211 = r7;
        final Function2<? super Composer, ? super Integer, Unit> r212 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r213 = r31;
        final MutableInteractionSource r214 = r32;
        boolean r410 = r111;
        Function2<? super Composer, ? super Integer, Unit> r411 = r15;
        int r34 = r113 >> 6;
        int r35 = ((6 | (r34 & 112)) | (r34 & 896)) | (r34 & 7168);
        int r36 = r14 << 12;
        m3058SearchBarY92LkZI(ComposableLambdaKt.rememberComposableLambda(-1597173218, true, new SearchBarKt$SearchBar$6(r114, r37, r38, r39, r40, r41, r210, r211, r212, r213, r214), r10, 54), r40, r41, r110, r20, r12, r13, r29, r30, r53, r10, (((((r35 | (57344 & r36)) | (458752 & r36)) | (3670016 & r36)) | (29360128 & r36)) | (r36 & 234881024)) | ((r14 << 9) & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L249;
        ComposerKt.traceEventEnd();
    L249:
        Function2<? super Composer, ? super Integer, Unit> r115 = r31;
        Shape r116 = r20;
        SearchBarColors r117 = r12;
        float r118 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r58 = r411;
        final Modifier r59 = r110;
        final Function2<? super Composer, ? super Integer, Unit> r60 = r7;
        final boolean r61 = r410;
    L251:
        ScopeUpdateScope r119 = r10.endRestartGroup();
        if (r119 == null) goto L255;
        final Function2<? super Composer, ? super Integer, Unit> r120 = r115;
        final Shape r121 = r116;
        final SearchBarColors r122 = r117;
        final float r123 = r118;
        final float r124 = r29;
        final WindowInsets r125 = r30;
        final MutableInteractionSource r126 = r32;
        r119.updateScope(new tl(r37, r38, r39, r40, r41, r59, r61, r60, r58, r120, r121, r122, r123, r124, r125, r126, r53, r55, r56, r57));
        return;
    L255:
        return;
    L245:
        r113 = r33;
        goto L246
    L240:
        r32 = r52;
        goto L241
    L237:
        r30 = r51;
        r14 = r26;
        goto L238
    L233:
        r29 = r50;
        goto L235
    L230:
        r13 = r49;
        goto L231
    L227:
        r33 = r1;
        r112 = r9;
        r12 = r48;
        goto L228
    L223:
        r28 = r47;
        r26 = r2;
        goto L225
    L219:
        r4 = r46;
        goto L221
    L216:
        r23 = r45;
        goto L217
    L213:
        r22 = r7;
        goto L214
    L209:
        r111 = r5;
        goto L211
    L206:
        r110 = r42;
        goto L207
    L192:
        if (r10.getDefaultsInvalid() == true) goto L204;
        r10.skipToGroupEnd();
        if ((r57 & 1024) == 0) goto L198;
        r2 = r2 & (-15);
    L198:
        if ((r57 & 2048) == 0) goto L201;
        r2 = r2 & (-113);
    L201:
        if ((r57 & 16384) == 0) goto L203;
        r2 = r2 & (-57345);
    L203:
        r15 = r45;
        r31 = r46;
        r20 = r47;
        r12 = r48;
        r13 = r49;
        r29 = r50;
        r30 = r51;
        r32 = r52;
        r33 = r1;
        r110 = r42;
        boolean r310 = r5;
        r14 = r2;
        r111 = r310;
        goto L242
    L250:
        r10.skipToGroupEnd();
        r59 = r42;
        r58 = r45;
        r115 = r46;
        r116 = r47;
        r117 = r48;
        r118 = r49;
        r29 = r50;
        r30 = r51;
        r32 = r52;
        r60 = r7;
        r61 = r5;
        goto L251
    L183:
        if ((599187 & r2) != 599186) goto L186;
        r3 = false;
        goto L188
    L174:
        if ((r56 & 1572864) != 0) goto L181;
        if (r10.changedInstance(r53) == false) goto L178;
        int r127 = 1048576;
    L179:
        r2 = r2 | r127;
        goto L181
    L178:
        r127 = 524288;
        goto L179
    L163:
        if ((r56 & 196608) != 0) goto L171;
        if (r10.changed(r52) == true) goto L168;
        r21 = 65536;
    L168:
        r2 = r2 | r21;
        goto L171
    L142:
        if ((r56 & 3072) != 0) goto L150;
        if (r10.changed(r50) == true) goto L147;
        r16 = 1024;
    L147:
        r2 = r2 | r16;
        goto L150
    L131:
        if ((r56 & 384) != 0) goto L138;
        if (r10.changed(r49) == false) goto L135;
        int r215 = 256;
    L136:
        r2 = r2 | r215;
        goto L138
    L135:
        r215 = 128;
        goto L136
    L108:
        if ((r57 & 1024) != 0) goto L113;
        if (r10.changed(r47) == false) goto L113;
        int r216 = 4;
    L114:
        r24 = r56 | r216;
    L113:
        r216 = 2;
        goto L114
    L99:
        if ((r55 & 805306368) != 0) goto L106;
        if (r10.changedInstance(r46) == false) goto L103;
        int r311 = 536870912;
    L104:
        r1 = r1 | r311;
        goto L106
    L103:
        r311 = 268435456;
        goto L104
    L89:
        if ((r55 & 100663296) != 0) goto L95;
        if (r10.changedInstance(r45) == false) goto L93;
        int r312 = 67108864;
    L94:
        r1 = r1 | r312;
        goto L95
    L93:
        r312 = 33554432;
        goto L94
    L78:
        r7 = r44;
        if ((r55 & 12582912) != 0) goto L85;
        if (r10.changedInstance(r7) == false) goto L83;
        int r313 = 8388608;
    L84:
        r1 = r1 | r313;
        goto L85
    L83:
        r313 = 4194304;
        goto L84
    L68:
        r5 = r43;
        if ((r55 & 1572864) != 0) goto L75;
        if (r10.changed(r5) == false) goto L73;
        int r217 = 1048576;
    L74:
        r1 = r1 | r217;
        goto L75
    L73:
        r217 = 524288;
        goto L74
    L59:
        if ((r55 & 196608) != 0) goto L65;
        if (r10.changed(r42) == false) goto L63;
        int r218 = 131072;
    L64:
        r1 = r1 | r218;
        goto L65
    L63:
        r218 = 65536;
        goto L64
    L48:
        if ((r55 & 24576) != 0) goto L55;
        if (r10.changedInstance(r41) == false) goto L52;
        int r128 = 16384;
    L53:
        r1 = r1 | r128;
        goto L55
    L52:
        r128 = 8192;
        goto L53
    L37:
        if ((r55 & 3072) != 0) goto L44;
        if (r10.changed(r40) == false) goto L41;
        int r129 = 2048;
    L42:
        r1 = r1 | r129;
        goto L44
    L41:
        r129 = 1024;
        goto L42
    L27:
        if ((r55 & 384) != 0) goto L33;
        if (r10.changedInstance(r39) == false) goto L31;
        int r62 = 256;
    L32:
        r1 = r1 | r62;
        goto L33
    L31:
        r62 = 128;
        goto L32
    L17:
        if ((r55 & 48) != 0) goto L24;
        if (r10.changedInstance(r38) == false) goto L21;
        int r63 = 32;
    L22:
        r1 = r1 | r63;
        goto L24
    L21:
        r63 = 16;
        goto L22
    L6:
        if ((r55 & 6) == 0) goto L8;
        r1 = r55;
        goto L14
    L8:
        if (r10.changed(r37) == false) goto L10;
        int r64 = 4;
    L11:
        r1 = r64 | r55;
        goto L14
    L10:
        r64 = 2;
        goto L11
    }
}
