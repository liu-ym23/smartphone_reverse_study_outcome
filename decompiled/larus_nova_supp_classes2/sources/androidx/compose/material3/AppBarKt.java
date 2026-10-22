package androidx.compose.material3;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.AppBarLargeFlexibleTokens;
import androidx.compose.material3.tokens.AppBarLargeTokens;
import androidx.compose.material3.tokens.AppBarMediumFlexibleTokens;
import androidx.compose.material3.tokens.AppBarMediumTokens;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u007f\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u008b\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0016\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u007f\u0010\u001e\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0095\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b \u0010!\u001a¶\u0001\u0010\"\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b#\u0010$\u001a\u007f\u0010%\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0095\u0001\u0010%\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b&\u0010!\u001a¶\u0001\u0010'\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b(\u0010$\u001aà\u0001\u0010)\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062*\b\u0002\u0010\u0019\u001a$\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b.\u0010/\u001a\u0080\u0001\u00100\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b8\u00109\u001a\u008c\u0001\u00100\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:H\u0007¢\u0006\u0004\b;\u0010<\u001ai\u00100\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b>\u0010?\u001au\u00100\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b@\u0010A\u001a\u007f\u0010B\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0004\bE\u0010F\u001ay\u0010G\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00142\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u0002072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0004\bI\u0010J\u001a+\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020N2\b\b\u0002\u0010P\u001a\u00020NH\u0007¢\u0006\u0002\u0010Q\u001a+\u0010R\u001a\u00020S2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020N2\b\b\u0002\u0010P\u001a\u00020NH\u0007¢\u0006\u0002\u0010T\u001a \u0010U\u001a\u00020S2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NH\u0007\u001a>\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020S2\u0006\u0010Y\u001a\u00020N2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010[2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010]H\u0082@¢\u0006\u0002\u0010^\u001a¬\u0001\u0010f\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\u0006\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\bj\u0010k\u001aô\u0001\u0010)\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0006\u0010s\u001a\u00020\u00142\u0011\u0010t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010u\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\u0013\u0010v\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010w\u001a\u00020h2\u0006\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\bx\u0010y\u001a\u0016\u0010~\u001a\u00020\u0006*\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u001aá\u0001\u0010\u007f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u0002032\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0084\u0001\u001a\u0002032\u0007\u0010\u0085\u0001\u001a\u0002032\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020N0\u00032\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0007\u0010s\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020*2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0007\u0010\u008b\u0001\u001a\u00020\u0014H\u0003¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a@\u0010\u008e\u0001\u001a\u00020W2\u0006\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020N2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010[2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010]H\u0082@¢\u0006\u0003\u0010\u008f\u0001\u001a\u0016\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0091\u0001H\u0003¢\u0006\u0003\u0010\u0092\u0001\"\u0010\u0010_\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0016\u0010a\u001a\u00020\u0014X\u0080\u0004¢\u0006\n\n\u0002\u0010`\u001a\u0004\bb\u0010c\"\u0010\u0010d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010e\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\" \u0010l\u001a\b\u0012\u0004\u0012\u00020n0mX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bo\u0010p\u001a\u0004\bq\u0010r\" \u0010z\u001a\b\u0012\u0004\u0012\u00020{0mX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010p\u001a\u0004\b}\u0010r\"\u0018\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0011\u0010\u0097\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u0098\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u0099\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u009a\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`¨\u0006\u009b\u0001²\u0006\u000b\u0010\u009c\u0001\u001a\u00020*X\u008a\u0084\u0002"}, d2 = {"TopAppBar", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "expandedHeight", "Landroidx/compose/ui/unit/Dp;", "TopAppBar-GHTll3U", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "CenterAlignedTopAppBar-GHTll3U", "subtitle", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "TopAppBar-cJHQLPU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumTopAppBar", "collapsedHeight", "MediumTopAppBar-oKE7A98", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumFlexibleTopAppBar", "MediumFlexibleTopAppBar-eXZ4JBQ", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LargeTopAppBar", "LargeTopAppBar-oKE7A98", "LargeFlexibleTopAppBar", "LargeFlexibleTopAppBar-eXZ4JBQ", "TwoRowsTopAppBar", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "expanded", "TwoRowsTopAppBar-eXZ4JBQ", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "BottomAppBar", "floatingActionButton", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlexibleBottomAppBar", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "FlexibleBottomAppBar-wBhsO_E", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/Arrangement$Horizontal;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarLayout", "containerHeight", "BottomAppBarLayout-t5fmz9U", "(FLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "rememberBottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "BottomAppBarState", "settleAppBarBottom", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BottomAppBarHorizontalPadding", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "subtitleTextStyle", "SingleRowTopAppBar-wn8IZOc", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LocalSingleRowTopAppBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/SingleRowTopAppBarOverride;", "getLocalSingleRowTopAppBarOverride$annotations", "()V", "getLocalSingleRowTopAppBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "titleBottomPadding", "smallTitle", "smallTitleTextStyle", "smallSubtitle", "smallSubtitleTextStyle", "TwoRowsTopAppBar-pJA5dT0", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LocalTwoRowsTopAppBarOverride", "Landroidx/compose/material3/TwoRowsTopAppBarOverride;", "getLocalTwoRowsTopAppBarOverride$annotations", "getLocalTwoRowsTopAppBarOverride", "adjustHeightOffsetLimit", "TopAppBarLayout", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "navigationIconContentColor", "titleContentColor", "subtitleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "hideTitleSemantics", "height", "TopAppBarLayout-lyUyIHI", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/internal/FloatProducer;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;II)V", "settleAppBar", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rememberTouchExplorationService", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "MediumTitleBottomPadding", "LargeTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "material3", "touchExplorationServiceEnabled"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding = 0.0f;
    private static final float BottomAppBarVerticalPadding = 0.0f;
    private static final float FABHorizontalPadding = 0.0f;
    private static final float FABVerticalPadding = 0.0f;
    private static final float LargeTitleBottomPadding = 0.0f;
    private static final ProvidableCompositionLocal<SingleRowTopAppBarOverride> LocalSingleRowTopAppBarOverride = null;
    private static final ProvidableCompositionLocal<TwoRowsTopAppBarOverride> LocalTwoRowsTopAppBarOverride = null;
    private static final float MediumTitleBottomPadding = 0.0f;
    private static final float TopAppBarHorizontalPadding = 0.0f;
    private static final float TopAppBarTitleInset = 0.0f;
    private static final CubicBezierEasing TopTitleAlphaEasing = null;

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarKt$settleAppBar$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AppBarKt", f = "AppBar.kt", i = {0, 0, 0, 1}, l = {3464, 3480}, m = "settleAppBar", n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return AppBarKt.access$settleAppBar(null, MenuKt.ClosedAlphaTarget, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarKt$settleAppBarBottom$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AppBarKt", f = "AppBar.kt", i = {0, 0, 0, 1}, l = {2424, 2440}, m = "settleAppBarBottom", n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class C02551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02551(Continuation<? super C02551> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return AppBarKt.access$settleAppBarBottom(null, MenuKt.ClosedAlphaTarget, null, null, this);
        }
    }

    public static /* synthetic */ Unit A(Function0 r0, GraphicsLayerScope r1) {
        return TopAppBarLayout_lyUyIHI$lambda$51$lambda$43$lambda$42(r0, r1);
    }

    public static /* synthetic */ Unit B(Ref.FloatRef r0, BottomAppBarState r1, Ref.FloatRef r2, AnimationScope r3) {
        return settleAppBarBottom$lambda$29(r0, r1, r2, r3);
    }

    private static final Unit BottomAppBarLayout_t5fmz9U$lambda$24(float r16, Arrangement.Horizontal r17, Modifier r18, long r19, long r21, float r23, PaddingValues r24, WindowInsets r25, BottomAppBarScrollBehavior r26, Function3 r27, int r28, int r29, Composer r30, int r31) {
        m2306BottomAppBarLayoutt5fmz9U(r16, r17, r18, r19, r21, r23, r24, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit BottomAppBar_1oL4kX8$lambda$14(Modifier r13, long r14, long r16, float r18, PaddingValues r19, WindowInsets r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m2302BottomAppBar1oL4kX8(r13, r14, r16, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit BottomAppBar_Snr_uVM$lambda$12(Function3 r14, Modifier r15, Function2 r16, long r17, long r19, float r21, PaddingValues r22, WindowInsets r23, int r24, int r25, Composer r26, int r27) {
        m2303BottomAppBarSnr_uVM(r14, r15, r16, r17, r19, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit BottomAppBar_e_3WI5M$lambda$15(Modifier r14, long r15, long r17, float r19, PaddingValues r20, WindowInsets r21, BottomAppBarScrollBehavior r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m2304BottomAppBare3WI5M(r14, r15, r17, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit BottomAppBar_qhFBPw4$lambda$13(Function3 r15, Modifier r16, Function2 r17, long r18, long r20, float r22, PaddingValues r23, WindowInsets r24, BottomAppBarScrollBehavior r25, int r26, int r27, Composer r28, int r29) {
        m2305BottomAppBarqhFBPw4(r15, r16, r17, r18, r20, r22, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit C(Modifier r1, Function2 r2, TextStyle r3, float r4, Function2 r5, TextStyle r6, Function2 r7, TextStyle r8, Function2 r9, TextStyle r10, Alignment.Horizontal r11, Function2 r12, Function3 r13, float r14, float r15, WindowInsets r16, TopAppBarColors r17, TopAppBarScrollBehavior r18, int r19, int r20, int r21, Composer r22, int r23) {
        return TwoRowsTopAppBar_pJA5dT0$lambda$35(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    private static final Unit CenterAlignedTopAppBar$lambda$2(Function2 r11, Modifier r12, Function2 r13, Function3 r14, WindowInsets r15, TopAppBarColors r16, TopAppBarScrollBehavior r17, int r18, int r19, Composer r20, int r21) {
        CenterAlignedTopAppBar(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit CenterAlignedTopAppBar_GHTll3U$lambda$3(Function2 r12, Modifier r13, Function2 r14, Function3 r15, float r16, WindowInsets r17, TopAppBarColors r18, TopAppBarScrollBehavior r19, int r20, int r21, Composer r22, int r23) {
        m2307CenterAlignedTopAppBarGHTll3U(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit D(BottomAppBarState r0, AnimationScope r1) {
        return settleAppBarBottom$lambda$30(r0, r1);
    }

    public static /* synthetic */ Unit E(float r0, Arrangement.Horizontal r1, Modifier r2, long r3, long r5, float r7, PaddingValues r8, WindowInsets r9, BottomAppBarScrollBehavior r10, Function3 r11, int r12, int r13, Composer r14, int r15) {
        return BottomAppBarLayout_t5fmz9U$lambda$24(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit F(Modifier r0, long r1, long r3, PaddingValues r5, Arrangement.Horizontal r6, float r7, WindowInsets r8, BottomAppBarScrollBehavior r9, Function3 r10, int r11, int r12, Composer r13, int r14) {
        return FlexibleBottomAppBar_wBhsO_E$lambda$16(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    private static final Unit FlexibleBottomAppBar_wBhsO_E$lambda$16(Modifier r15, long r16, long r18, PaddingValues r20, Arrangement.Horizontal r21, float r22, WindowInsets r23, BottomAppBarScrollBehavior r24, Function3 r25, int r26, int r27, Composer r28, int r29) {
        m2308FlexibleBottomAppBarwBhsO_E(r15, r16, r18, r20, r21, r22, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit G(Function2 r0, Modifier r1, Function2 r2, Function3 r3, float r4, float r5, WindowInsets r6, TopAppBarColors r7, TopAppBarScrollBehavior r8, int r9, int r10, Composer r11, int r12) {
        return LargeTopAppBar_oKE7A98$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit H(Function2 r0, Modifier r1, Function2 r2, Function3 r3, float r4, float r5, WindowInsets r6, TopAppBarColors r7, TopAppBarScrollBehavior r8, int r9, int r10, Composer r11, int r12) {
        return MediumTopAppBar_oKE7A98$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit I(SemanticsPropertyReceiver r0) {
        return TopAppBarLayout_lyUyIHI$lambda$51$lambda$41$lambda$40(r0);
    }

    public static /* synthetic */ Unit J(Modifier r0, long r1, long r3, float r5, PaddingValues r6, WindowInsets r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return BottomAppBar_1oL4kX8$lambda$14(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit K(Modifier r1, Function2 r2, TextStyle r3, Function2 r4, TextStyle r5, Alignment.Horizontal r6, Function2 r7, Function3 r8, float r9, WindowInsets r10, TopAppBarColors r11, TopAppBarScrollBehavior r12, int r13, int r14, int r15, Composer r16, int r17) {
        return SingleRowTopAppBar_wn8IZOc$lambda$32(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    private static final Unit LargeFlexibleTopAppBar_eXZ4JBQ$lambda$10(Function2 r16, Modifier r17, Function2 r18, Function2 r19, Function3 r20, Alignment.Horizontal r21, float r22, float r23, WindowInsets r24, TopAppBarColors r25, TopAppBarScrollBehavior r26, int r27, int r28, int r29, Composer r30, int r31) {
        m2309LargeFlexibleTopAppBareXZ4JBQ(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit LargeTopAppBar$lambda$8(Function2 r11, Modifier r12, Function2 r13, Function3 r14, WindowInsets r15, TopAppBarColors r16, TopAppBarScrollBehavior r17, int r18, int r19, Composer r20, int r21) {
        LargeTopAppBar(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit LargeTopAppBar_oKE7A98$lambda$9(Function2 r13, Modifier r14, Function2 r15, Function3 r16, float r17, float r18, WindowInsets r19, TopAppBarColors r20, TopAppBarScrollBehavior r21, int r22, int r23, Composer r24, int r25) {
        m2310LargeTopAppBaroKE7A98(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit MediumFlexibleTopAppBar_eXZ4JBQ$lambda$7(Function2 r16, Modifier r17, Function2 r18, Function2 r19, Function3 r20, Alignment.Horizontal r21, float r22, float r23, WindowInsets r24, TopAppBarColors r25, TopAppBarScrollBehavior r26, int r27, int r28, int r29, Composer r30, int r31) {
        m2311MediumFlexibleTopAppBareXZ4JBQ(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit MediumTopAppBar$lambda$5(Function2 r11, Modifier r12, Function2 r13, Function3 r14, WindowInsets r15, TopAppBarColors r16, TopAppBarScrollBehavior r17, int r18, int r19, Composer r20, int r21) {
        MediumTopAppBar(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit MediumTopAppBar_oKE7A98$lambda$6(Function2 r13, Modifier r14, Function2 r15, Function3 r16, float r17, float r18, WindowInsets r19, TopAppBarColors r20, TopAppBarScrollBehavior r21, int r22, int r23, Composer r24, int r25) {
        m2312MediumTopAppBaroKE7A98(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit SingleRowTopAppBar_wn8IZOc$lambda$32(Modifier r17, Function2 r18, TextStyle r19, Function2 r20, TextStyle r21, Alignment.Horizontal r22, Function2 r23, Function3 r24, float r25, WindowInsets r26, TopAppBarColors r27, TopAppBarScrollBehavior r28, int r29, int r30, int r31, Composer r32, int r33) {
        m2313SingleRowTopAppBarwn8IZOc(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBar$lambda$0(Function2 r11, Modifier r12, Function2 r13, Function3 r14, WindowInsets r15, TopAppBarColors r16, TopAppBarScrollBehavior r17, int r18, int r19, Composer r20, int r21) {
        TopAppBar(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBarLayout_lyUyIHI$lambda$53(Modifier r25, FloatProducer r26, long r27, long r29, long r31, long r33, Function2 r35, TextStyle r36, Function2 r37, TextStyle r38, Function0 r39, Arrangement.Vertical r40, Alignment.Horizontal r41, int r42, boolean r43, Function2 r44, Function2 r45, float r46, int r47, int r48, Composer r49, int r50) {
        m2316TopAppBarLayoutlyUyIHI(r25, r26, r27, r29, r31, r33, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r49, RecomposeScopeImplKt.updateChangedFlags(r47 | 1), RecomposeScopeImplKt.updateChangedFlags(r48));
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBar_GHTll3U$lambda$1(Function2 r12, Modifier r13, Function2 r14, Function3 r15, float r16, WindowInsets r17, TopAppBarColors r18, TopAppBarScrollBehavior r19, int r20, int r21, Composer r22, int r23) {
        m2314TopAppBarGHTll3U(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBar_cJHQLPU$lambda$4(Function2 r14, Function2 r15, Modifier r16, Function2 r17, Function3 r18, Alignment.Horizontal r19, float r20, WindowInsets r21, TopAppBarColors r22, TopAppBarScrollBehavior r23, int r24, int r25, Composer r26, int r27) {
        m2315TopAppBarcJHQLPU(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit TwoRowsTopAppBar_eXZ4JBQ$lambda$11(Function3 r16, Modifier r17, Function3 r18, Function2 r19, Function3 r20, Alignment.Horizontal r21, float r22, float r23, WindowInsets r24, TopAppBarColors r25, TopAppBarScrollBehavior r26, int r27, int r28, int r29, Composer r30, int r31) {
        m2317TwoRowsTopAppBareXZ4JBQ(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit TwoRowsTopAppBar_pJA5dT0$lambda$35(Modifier r22, Function2 r23, TextStyle r24, float r25, Function2 r26, TextStyle r27, Function2 r28, TextStyle r29, Function2 r30, TextStyle r31, Alignment.Horizontal r32, Function2 r33, Function3 r34, float r35, float r36, WindowInsets r37, TopAppBarColors r38, TopAppBarScrollBehavior r39, int r40, int r41, int r42, Composer r43, int r44) {
        m2318TwoRowsTopAppBarpJA5dT0(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r43, RecomposeScopeImplKt.updateChangedFlags(r40 | 1), RecomposeScopeImplKt.updateChangedFlags(r41), r42);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Modifier r1, Function2 r2, Function2 r3, Function3 r4, Alignment.Horizontal r5, float r6, float r7, WindowInsets r8, TopAppBarColors r9, TopAppBarScrollBehavior r10, int r11, int r12, int r13, Composer r14, int r15) {
        return LargeFlexibleTopAppBar_eXZ4JBQ$lambda$10(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit b(Function0 r0, GraphicsLayerScope r1) {
        return TopAppBarLayout_lyUyIHI$lambda$51$lambda$48$lambda$47(r0, r1);
    }

    public static /* synthetic */ Unit c(Function2 r0, Modifier r1, Function2 r2, Function3 r3, float r4, WindowInsets r5, TopAppBarColors r6, TopAppBarScrollBehavior r7, int r8, int r9, Composer r10, int r11) {
        return CenterAlignedTopAppBar_GHTll3U$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit d(Function2 r0, Modifier r1, Function2 r2, Function3 r3, WindowInsets r4, TopAppBarColors r5, TopAppBarScrollBehavior r6, int r7, int r8, Composer r9, int r10) {
        return TopAppBar$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ MeasureResult e(BottomAppBarScrollBehavior r0, MeasureScope r1, Measurable r2, Constraints r3) {
        return BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22(r0, r1, r2, r3);
    }

    public static /* synthetic */ SingleRowTopAppBarOverride f() {
        return LocalSingleRowTopAppBarOverride$lambda$33();
    }

    public static /* synthetic */ Unit g(Function2 r0, Modifier r1, Function2 r2, Function3 r3, float r4, WindowInsets r5, TopAppBarColors r6, TopAppBarScrollBehavior r7, int r8, int r9, Composer r10, int r11) {
        return TopAppBar_GHTll3U$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void getLocalSingleRowTopAppBarOverride$annotations() {
    }

    public static /* synthetic */ void getLocalTwoRowsTopAppBarOverride$annotations() {
    }

    public static /* synthetic */ Unit h(Function2 r0, Modifier r1, Function2 r2, Function3 r3, WindowInsets r4, TopAppBarColors r5, TopAppBarScrollBehavior r6, int r7, int r8, Composer r9, int r10) {
        return MediumTopAppBar$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit i(BottomAppBarScrollBehavior r0, float r1) {
        return BottomAppBarLayout_t5fmz9U$lambda$19$lambda$18(r0, r1);
    }

    public static /* synthetic */ TwoRowsTopAppBarOverride j() {
        return LocalTwoRowsTopAppBarOverride$lambda$36();
    }

    public static /* synthetic */ Unit k(Function2 r0, Modifier r1, Function2 r2, Function3 r3, WindowInsets r4, TopAppBarColors r5, TopAppBarScrollBehavior r6, int r7, int r8, Composer r9, int r10) {
        return CenterAlignedTopAppBar$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit l(TopAppBarState r0, AnimationScope r1) {
        return settleAppBar$lambda$55(r0, r1);
    }

    public static /* synthetic */ Unit m(TopAppBarState r0, IntSize r1) {
        return adjustHeightOffsetLimit$lambda$38$lambda$37(r0, r1);
    }

    public static /* synthetic */ Unit n(Function2 r0, Function2 r1, Modifier r2, Function2 r3, Function3 r4, Alignment.Horizontal r5, float r6, WindowInsets r7, TopAppBarColors r8, TopAppBarScrollBehavior r9, int r10, int r11, Composer r12, int r13) {
        return TopAppBar_cJHQLPU$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit o(SemanticsPropertyReceiver r0) {
        return TopAppBarLayout_lyUyIHI$lambda$51$lambda$46$lambda$45(r0);
    }

    public static /* synthetic */ BottomAppBarState p(float r0, float r1, float r2) {
        return rememberBottomAppBarState$lambda$28$lambda$27(r0, r1, r2);
    }

    public static /* synthetic */ Unit q(Function3 r0, Modifier r1, Function2 r2, long r3, long r5, float r7, PaddingValues r8, WindowInsets r9, BottomAppBarScrollBehavior r10, int r11, int r12, Composer r13, int r14) {
        return BottomAppBar_qhFBPw4$lambda$13(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ TopAppBarState r(float r0, float r1, float r2) {
        return rememberTopAppBarState$lambda$26$lambda$25(r0, r1, r2);
    }

    public static /* synthetic */ Unit s(Placeable r0, Placeable.PlacementScope r1) {
        return BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22$lambda$21(r0, r1);
    }

    public static /* synthetic */ Unit t(Function3 r0, Modifier r1, Function3 r2, Function2 r3, Function3 r4, Alignment.Horizontal r5, float r6, float r7, WindowInsets r8, TopAppBarColors r9, TopAppBarScrollBehavior r10, int r11, int r12, int r13, Composer r14, int r15) {
        return TwoRowsTopAppBar_eXZ4JBQ$lambda$11(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit u(Function3 r0, Modifier r1, Function2 r2, long r3, long r5, float r7, PaddingValues r8, WindowInsets r9, int r10, int r11, Composer r12, int r13) {
        return BottomAppBar_Snr_uVM$lambda$12(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit v(Function2 r0, Modifier r1, Function2 r2, Function3 r3, WindowInsets r4, TopAppBarColors r5, TopAppBarScrollBehavior r6, int r7, int r8, Composer r9, int r10) {
        return LargeTopAppBar$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit w(Modifier r1, FloatProducer r2, long r3, long r5, long r7, long r9, Function2 r11, TextStyle r12, Function2 r13, TextStyle r14, Function0 r15, Arrangement.Vertical r16, Alignment.Horizontal r17, int r18, boolean r19, Function2 r20, Function2 r21, float r22, int r23, int r24, Composer r25, int r26) {
        return TopAppBarLayout_lyUyIHI$lambda$53(r1, r2, r3, r5, r7, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public static /* synthetic */ Unit x(Ref.FloatRef r0, TopAppBarState r1, Ref.FloatRef r2, AnimationScope r3) {
        return settleAppBar$lambda$54(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit y(Function2 r0, Modifier r1, Function2 r2, Function2 r3, Function3 r4, Alignment.Horizontal r5, float r6, float r7, WindowInsets r8, TopAppBarColors r9, TopAppBarScrollBehavior r10, int r11, int r12, int r13, Composer r14, int r15) {
        return MediumFlexibleTopAppBar_eXZ4JBQ$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit z(Modifier r0, long r1, long r3, float r5, PaddingValues r6, WindowInsets r7, BottomAppBarScrollBehavior r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return BottomAppBar_e_3WI5M$lambda$15(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    static {
        float r0 = 16;
        float r2 = 12;
        float r1 = Dp.constructor-impl(Dp.constructor-impl(r0) - Dp.constructor-impl(r2));
        BottomAppBarHorizontalPadding = r1;
        float r3 = Dp.constructor-impl(Dp.constructor-impl(r0) - Dp.constructor-impl(r2));
        BottomAppBarVerticalPadding = r3;
        FABHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(r0) - r1);
        FABVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(r2) - r3);
        LocalSingleRowTopAppBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new x0(), 1, null);
        LocalTwoRowsTopAppBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new y0(), 1, null);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, MenuKt.ClosedAlphaTarget, 0.8f, 0.15f);
        MediumTitleBottomPadding = Dp.constructor-impl(24);
        LargeTitleBottomPadding = Dp.constructor-impl(28);
        float r4 = Dp.constructor-impl(4);
        TopAppBarHorizontalPadding = r4;
        TopAppBarTitleInset = Dp.constructor-impl(Dp.constructor-impl(r0) - r4);
    }

    private static final SingleRowTopAppBarOverride LocalSingleRowTopAppBarOverride$lambda$33() {
        return DefaultSingleRowTopAppBarOverride.INSTANCE;
    }

    private static final TwoRowsTopAppBarOverride LocalTwoRowsTopAppBarOverride$lambda$36() {
        return DefaultTwoRowsTopAppBarOverride.INSTANCE;
    }

    public static final /* synthetic */ float access$getBottomAppBarHorizontalPadding$p() {
        return BottomAppBarHorizontalPadding;
    }

    public static final /* synthetic */ float access$getFABHorizontalPadding$p() {
        return FABHorizontalPadding;
    }

    public static final /* synthetic */ float access$getFABVerticalPadding$p() {
        return FABVerticalPadding;
    }

    public static final /* synthetic */ float access$getTopAppBarTitleInset$p() {
        return TopAppBarTitleInset;
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    public static final ProvidableCompositionLocal<SingleRowTopAppBarOverride> getLocalSingleRowTopAppBarOverride() {
        return LocalSingleRowTopAppBarOverride;
    }

    public static final ProvidableCompositionLocal<TwoRowsTopAppBarOverride> getLocalTwoRowsTopAppBarOverride() {
        return LocalTwoRowsTopAppBarOverride;
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    private static final boolean BottomAppBarLayout_t5fmz9U$lambda$17(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$41$lambda$40(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$46$lambda$45(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final Unit BottomAppBarLayout_t5fmz9U$lambda$19$lambda$18(BottomAppBarScrollBehavior r1, float r2) {
        BottomAppBarState r3 = r1.getState();
        r3.setHeightOffset(r3.getHeightOffset() - r2);
        return Unit.INSTANCE;
    }

    private static final Unit BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22$lambda$21(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$43$lambda$42(Function0 r0, GraphicsLayerScope r1) {
        r1.setAlpha(((Number) r0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$48$lambda$47(Function0 r0, GraphicsLayerScope r1) {
        r1.setAlpha(((Number) r0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Modifier access$adjustHeightOffsetLimit(Modifier r0, TopAppBarScrollBehavior r1) {
        return adjustHeightOffsetLimit(r0, r1);
    }

    private static final Modifier adjustHeightOffsetLimit(Modifier r1, TopAppBarScrollBehavior r2) {
        if (r2 == null) goto L10;
        final TopAppBarState r3 = r2.getState();
        if (r3 == null) goto L11;
        Modifier r4 = OnRemeasuredModifierKt.onSizeChanged(r1, new c1(r3));
        if (r4 != null) goto L9;
        return r1;
    L9:
        return r4;
    L11:
        return r1;
    L10:
        return r1;
    }

    private static final Unit adjustHeightOffsetLimit$lambda$38$lambda$37(TopAppBarState r4, IntSize r5) {
        r4.setHeightOffsetLimit(-(((int) (r5.unbox-impl() & 4294967295L)) - r4.getHeightOffset()));
        return Unit.INSTANCE;
    }

    private static final State<Boolean> rememberTouchExplorationService(Composer r9, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1660719518, r10, -1, "androidx.compose.material3.rememberTouchExplorationService (AppBar.kt:3498)");
    L5:
        State<Boolean> r11 = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(true, false, false, r9, 438, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r11;
    }

    private static final Unit settleAppBar$lambda$55(TopAppBarState r0, AnimationScope r1) {
        r0.setHeightOffset(((Number) r1.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    private static final Unit settleAppBarBottom$lambda$30(BottomAppBarState r0, AnimationScope r1) {
        r0.setHeightOffset(((Number) r1.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    public static final BottomAppBarState BottomAppBarState(float r1, float r2, float r3) {
        return new BottomAppBarStateImpl(r1, r2, r3);
    }

    private static final BottomAppBarState rememberBottomAppBarState$lambda$28$lambda$27(float r0, float r1, float r2) {
        return BottomAppBarState(r0, r1, r2);
    }

    private static final TopAppBarState rememberTopAppBarState$lambda$26$lambda$25(float r1, float r2, float r3) {
        return new TopAppBarState(r1, r2, r3);
    }

    private static final MeasureResult BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22(BottomAppBarScrollBehavior r7, MeasureScope r8, Measurable r9, Constraints r10) {
        final Placeable r11 = r9.measure-BRTryo0(r10.unbox-impl());
        if (r7 == null) goto L7;
        BottomAppBarState r12 = r7.getState();
        if (r12 == null) goto L7;
        r12.setHeightOffsetLimit(-r11.getHeight());
    L7:
        float r13 = r11.getHeight();
        if (r7 == null) goto L12;
        BottomAppBarState r14 = r7.getState();
        if (r14 == null) goto L12;
        float r15 = r14.getHeightOffset();
    L14:
        return MeasureScope.-CC.layout$default(r8, r11.getWidth(), MathKt.roundToInt(RangesKt.coerceAtLeast(r13 + r15, MenuKt.ClosedAlphaTarget)), null, new d0(r11), 4, null);
    L12:
        r15 = MenuKt.ClosedAlphaTarget;
        goto L14
    }

    private static final Unit settleAppBar$lambda$54(Ref.FloatRef r3, TopAppBarState r4, Ref.FloatRef r5, AnimationScope r6) {
        float r0 = ((Number) r6.getValue()).floatValue() - r3.element;
        float r1 = r4.getHeightOffset();
        r4.setHeightOffset(r1 + r0);
        float r7 = Math.abs(r1 - r4.getHeightOffset());
        r3.element = ((Number) r6.getValue()).floatValue();
        r5.element = ((Number) r6.getVelocity()).floatValue();
        if (Math.abs(r0 - r7) <= 0.5f) goto L6;
        r6.cancelAnimation();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit settleAppBarBottom$lambda$29(Ref.FloatRef r3, BottomAppBarState r4, Ref.FloatRef r5, AnimationScope r6) {
        float r0 = ((Number) r6.getValue()).floatValue() - r3.element;
        float r1 = r4.getHeightOffset();
        r4.setHeightOffset(r1 + r0);
        float r7 = Math.abs(r1 - r4.getHeightOffset());
        r3.element = ((Number) r6.getValue()).floatValue();
        r5.element = ((Number) r6.getVelocity()).floatValue();
        if (Math.abs(r0 - r7) <= 0.5f) goto L6;
        r6.cancelAnimation();
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$settleAppBar(TopAppBarState r0, float r1, DecayAnimationSpec r2, AnimationSpec r3, Continuation r4) {
        return settleAppBar(r0, r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$settleAppBarBottom(BottomAppBarState r0, float r1, DecayAnimationSpec r2, AnimationSpec r3, Continuation r4) {
        return settleAppBarBottom(r0, r1, r2, r3, r4);
    }

    private static final Object settleAppBar(TopAppBarState r22, float r23, DecayAnimationSpec<Float> r24, AnimationSpec<Float> r25, Continuation<? super Velocity> r26) {
        final TopAppBarState r0 = r22;
        if ((r26 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) r26;
        int r3 = r2.label;
        if ((r3 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r2.label = r3 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r1 = r2.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        Ref.FloatRef r5 = (Ref.FloatRef) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L46:
        final Ref.FloatRef r6 = r5;
    L48:
        return Velocity.box-impl(VelocityKt.Velocity(MenuKt.ClosedAlphaTarget, r6.element));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.FloatRef r7 = (Ref.FloatRef) r2.L$2;
        AnimationSpec<Float> r8 = (AnimationSpec) r2.L$1;
        TopAppBarState r9 = (TopAppBarState) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r6 = r7;
        AnimationSpec<Float> r13 = r8;
        r0 = r9;
    L31:
        AnimationSpec<Float> r10 = r13;
        if (r10 == null) goto L48;
        if (r0.getHeightOffset() >= MenuKt.ClosedAlphaTarget) goto L48;
        if (r0.getHeightOffset() <= r0.getHeightOffsetLimit()) goto L48;
        AnimationState r12 = AnimationStateKt.AnimationState$default(r0.getHeightOffset(), MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
        if (r0.getCollapsedFraction() >= 0.5f) goto L41;
        float r14 = MenuKt.ClosedAlphaTarget;
    L42:
        Float r15 = Boxing.boxFloat(r14);
        Function1 r16 = new m0(r0);
        r2.L$0 = r6;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.label = 2;
        if (SuspendAnimationKt.animateTo$default(r12, r15, r10, false, r16, r2, 4, null) != r11) goto L45;
        return r11;
    L45:
        r5 = r6;
        goto L46
    L41:
        r14 = r0.getHeightOffsetLimit();
        goto L42
    L16:
        ResultKt.throwOnFailure(r1);
        if (r22.getCollapsedFraction() < 0.01f) goto L50;
        if (r22.getCollapsedFraction() != 1.0f) goto L21;
        boolean r17 = true;
    L22:
        if (r17 == true) goto L50;
        r6 = new Ref.FloatRef();
        r6.element = r23;
        if (r24 != null) goto L27;
    L32:
        r13 = r25;
        goto L31
    L27:
        if (Math.abs(r23) <= 1.0f) goto L32;
        final Ref.FloatRef r18 = new Ref.FloatRef();
        AnimationState r19 = AnimationStateKt.AnimationState$default(MenuKt.ClosedAlphaTarget, r23, 0, 0, false, 28, null);
        Function1 r20 = new l0(r18, r0, r6);
        r2.L$0 = r0;
        r13 = r25;
        r2.L$1 = r13;
        r2.L$2 = r6;
        r2.label = 1;
        if (SuspendAnimationKt.animateDecay$default(r19, r24, false, r20, r2, 2, null) != r11) goto L31;
        return r11;
    L21:
        r17 = false;
    L50:
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    L7:
        r2 = new AnonymousClass1(r26);
        goto L8
    }

    private static final Object settleAppBarBottom(BottomAppBarState r22, float r23, DecayAnimationSpec<Float> r24, AnimationSpec<Float> r25, Continuation<? super Velocity> r26) {
        final BottomAppBarState r0 = r22;
        if ((r26 instanceof C02551) == false) goto L7;
        C02551 r2 = (C02551) r26;
        int r3 = r2.label;
        if ((r3 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r2.label = r3 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r1 = r2.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        Ref.FloatRef r5 = (Ref.FloatRef) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L46:
        final Ref.FloatRef r6 = r5;
    L48:
        return Velocity.box-impl(VelocityKt.Velocity(MenuKt.ClosedAlphaTarget, r6.element));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.FloatRef r7 = (Ref.FloatRef) r2.L$2;
        AnimationSpec<Float> r8 = (AnimationSpec) r2.L$1;
        BottomAppBarState r9 = (BottomAppBarState) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r6 = r7;
        AnimationSpec<Float> r13 = r8;
        r0 = r9;
    L31:
        AnimationSpec<Float> r10 = r13;
        if (r10 == null) goto L48;
        if (r0.getHeightOffset() >= MenuKt.ClosedAlphaTarget) goto L48;
        if (r0.getHeightOffset() <= r0.getHeightOffsetLimit()) goto L48;
        AnimationState r12 = AnimationStateKt.AnimationState$default(r0.getHeightOffset(), MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
        if (r0.getCollapsedFraction() >= 0.5f) goto L41;
        float r14 = MenuKt.ClosedAlphaTarget;
    L42:
        Float r15 = Boxing.boxFloat(r14);
        Function1 r16 = new w(r0);
        r2.L$0 = r6;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.label = 2;
        if (SuspendAnimationKt.animateTo$default(r12, r15, r10, false, r16, r2, 4, null) != r11) goto L45;
        return r11;
    L45:
        r5 = r6;
        goto L46
    L41:
        r14 = r0.getHeightOffsetLimit();
        goto L42
    L16:
        ResultKt.throwOnFailure(r1);
        if (r22.getCollapsedFraction() < 0.01f) goto L50;
        if (r22.getCollapsedFraction() != 1.0f) goto L21;
        boolean r17 = true;
    L22:
        if (r17 == true) goto L50;
        r6 = new Ref.FloatRef();
        r6.element = r23;
        if (r24 != null) goto L27;
    L32:
        r13 = r25;
        goto L31
    L27:
        if (Math.abs(r23) <= 1.0f) goto L32;
        final Ref.FloatRef r18 = new Ref.FloatRef();
        AnimationState r19 = AnimationStateKt.AnimationState$default(MenuKt.ClosedAlphaTarget, r23, 0, 0, false, 28, null);
        Function1 r20 = new v(r18, r0, r6);
        r2.L$0 = r0;
        r13 = r25;
        r2.L$1 = r13;
        r2.L$2 = r6;
        r2.label = 1;
        if (SuspendAnimationKt.animateDecay$default(r19, r24, false, r20, r2, 2, null) != r11) goto L31;
        return r11;
    L21:
        r17 = false;
    L50:
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    L7:
        r2 = new C02551(r26);
        goto L8
    }

    public static final BottomAppBarState rememberBottomAppBarState(final float r6, final float r7, final float r8, Composer r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r6 = -3.4028235E38f;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r7 = MenuKt.ClosedAlphaTarget;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r8 = MenuKt.ClosedAlphaTarget;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1420874240, r10, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:2234)");
    L14:
        Object[] r1 = new Object[0];
        Saver<BottomAppBarState, ?> r2 = BottomAppBarState.Companion.getSaver();
        boolean r4 = true;
        if (((r10 & 14) ^ 6) <= 4) goto L19;
        if (r9.changed(r6) == false) goto L19;
    L20:
        boolean r0 = true;
    L23:
        if (((r10 & 112) ^ 48) <= 32) goto L27;
        if (r9.changed(r7) == false) goto L27;
    L28:
        boolean r3 = true;
    L30:
        boolean r5 = r0 | r3;
        if (((r10 & 896) ^ 384) <= 256) goto L35;
        if (r9.changed(r8) == false) goto L35;
    L38:
        boolean r12 = r5 | r4;
        Object r13 = r9.rememberedValue();
        if (r12 == false) goto L41;
    L42:
        r13 = new w0(r6, r7, r8);
        r9.updateRememberedValue(r13);
    L43:
        BottomAppBarState r14 = (BottomAppBarState) RememberSaveableKt.rememberSaveable(r1, r2, (Function0) r13, r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
    L46:
        return r14;
    L41:
        if (r13 != Composer.Companion.getEmpty()) goto L43;
    L35:
        if ((r10 & 384) == 256) goto L38;
        r4 = false;
    L27:
        if ((r10 & 48) == 32) goto L28;
        r3 = false;
    L19:
        if ((r10 & 6) == 4) goto L20;
        r0 = false;
        goto L23
    }

    public static final TopAppBarState rememberTopAppBarState(final float r6, final float r7, final float r8, Composer r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r6 = -3.4028235E38f;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r7 = MenuKt.ClosedAlphaTarget;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r8 = MenuKt.ClosedAlphaTarget;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1801969826, r10, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1857)");
    L14:
        Object[] r1 = new Object[0];
        Saver<TopAppBarState, ?> r2 = TopAppBarState.Companion.getSaver();
        boolean r4 = true;
        if (((r10 & 14) ^ 6) <= 4) goto L19;
        if (r9.changed(r6) == false) goto L19;
    L20:
        boolean r0 = true;
    L23:
        if (((r10 & 112) ^ 48) <= 32) goto L27;
        if (r9.changed(r7) == false) goto L27;
    L28:
        boolean r3 = true;
    L30:
        boolean r5 = r0 | r3;
        if (((r10 & 896) ^ 384) <= 256) goto L35;
        if (r9.changed(r8) == false) goto L35;
    L38:
        boolean r12 = r5 | r4;
        Object r13 = r9.rememberedValue();
        if (r12 == false) goto L41;
    L42:
        r13 = new u0(r6, r7, r8);
        r9.updateRememberedValue(r13);
    L43:
        TopAppBarState r14 = (TopAppBarState) RememberSaveableKt.rememberSaveable(r1, r2, (Function0) r13, r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
    L46:
        return r14;
    L41:
        if (r13 != Composer.Companion.getEmpty()) goto L43;
    L35:
        if ((r10 & 384) == 256) goto L38;
        r4 = false;
    L27:
        if ((r10 & 48) == 32) goto L28;
        r3 = false;
    L19:
        if ((r10 & 6) == 4) goto L20;
        r0 = false;
        goto L23
    }

    /* JADX INFO: renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    public static final void m2302BottomAppBar1oL4kX8(Modifier r24, long r25, long r27, float r29, PaddingValues r30, WindowInsets r31, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r1 = r33.startRestartGroup(107726720);
        int r2 = r35 & 1;
        if (r2 == 0) goto L6;
        int r4 = r34 | 6;
    L14:
        if ((r34 & 48) == 0) goto L16;
        long r5 = r25;
    L25:
        if ((r34 & 384) == 0) goto L27;
        long r7 = r27;
    L35:
        int r9 = r35 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        float r11 = r29;
    L46:
        int r12 = r35 & 16;
        if (r12 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        PaddingValues r13 = r30;
    L58:
        if ((196608 & r34) == 0) goto L60;
        WindowInsets r14 = r31;
    L69:
        if ((r35 & 64) == 0) goto L72;
        r4 = r4 | 1572864;
    L80:
        if ((r4 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L124;
        r1.startDefaults();
        if ((r34 & 1) != 0) goto L88;
    L101:
        if (r2 == 0) goto L103;
        Modifier r3 = Modifier.Companion;
    L105:
        if ((r35 & 2) == 0) goto L108;
        r5 = BottomAppBarDefaults.INSTANCE.getContainerColor(r1, 6);
        r4 = r4 & (-113);
    L108:
        if ((r35 & 4) == 0) goto L110;
        r7 = ColorSchemeKt.m2496contentColorForek8zF_U(r5, r1, (r4 >> 3) & 14);
        r4 = r4 & (-897);
    L110:
        if (r9 == 0) goto L112;
        r11 = BottomAppBarDefaults.INSTANCE.m2330getContainerElevationD9Ej5fM();
    L112:
        if (r12 == 0) goto L115;
        r13 = BottomAppBarDefaults.INSTANCE.getContentPadding();
    L115:
        if ((r35 & 32) != 0) goto L116;
    L100:
        int r10 = r4;
        float r6 = r11;
        PaddingValues r8 = r13;
        WindowInsets r15 = r14;
    L117:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventStart(107726720, r10, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1173)");
    L120:
        int r22 = (((((((r10 & 14) | 1572864) | (r10 & 112)) | (r10 & 896)) | (r10 & 7168)) | (57344 & r10)) | (458752 & r10)) | ((r10 << 3) & 29360128);
        m2304BottomAppBare3WI5M(r3, r5, r7, r6, r8, r15, null, r32, r1, r22, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventEnd();
    L123:
        r11 = r6;
        r13 = r8;
        r14 = r15;
        Modifier r16 = r3;
    L125:
        ScopeUpdateScope r17 = r1.endRestartGroup();
        if (r17 == null) goto L129;
        final Modifier r18 = r16;
        final long r19 = r5;
        final long r20 = r7;
        final float r21 = r11;
        final PaddingValues r23 = r13;
        final WindowInsets r26 = r14;
        r17.updateScope(new s0(r18, r19, r20, r21, r23, r26, r32, r34, r35));
        return;
    L129:
        return;
    L116:
        r10 = r4 & (-458753);
        r8 = r13;
        r15 = BottomAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
        r6 = r11;
        goto L117
    L103:
        r3 = r24;
        goto L105
    L88:
        if (r1.getDefaultsInvalid() == true) goto L101;
        r1.skipToGroupEnd();
        if ((r35 & 2) == 0) goto L94;
        r4 = r4 & (-113);
    L94:
        if ((r35 & 4) == 0) goto L97;
        r4 = r4 & (-897);
    L97:
        if ((r35 & 32) == 0) goto L99;
        r4 = r4 & (-458753);
    L99:
        r3 = r24;
        goto L100
    L124:
        r1.skipToGroupEnd();
        r16 = r24;
        goto L125
    L82:
        r0 = false;
        goto L84
    L72:
        if ((r34 & 1572864) != 0) goto L80;
        if (r1.changedInstance(r32) == false) goto L76;
        int r110 = 1048576;
    L77:
        r4 = r4 | r110;
        goto L80
    L76:
        r110 = 524288;
        goto L77
    L60:
        if ((r35 & 32) != 0) goto L64;
        r14 = r31;
        if (r1.changed(r14) == false) goto L65;
        int r111 = 131072;
    L66:
        r4 = r4 | r111;
    L65:
        r111 = 65536;
        goto L66
    L64:
        r14 = r31;
        goto L65
    L50:
        if ((r34 & 24576) != 0) goto L56;
        r13 = r30;
        if (r1.changed(r13) == false) goto L54;
        int r112 = 16384;
    L55:
        r4 = r4 | r112;
        goto L58
    L54:
        r112 = 8192;
        goto L55
    L39:
        if ((r34 & 3072) != 0) goto L45;
        r11 = r29;
        if (r1.changed(r11) == false) goto L43;
        int r113 = 2048;
    L44:
        r4 = r4 | r113;
        goto L46
    L43:
        r113 = 1024;
        goto L44
    L27:
        if ((r35 & 4) != 0) goto L31;
        r7 = r27;
        if (r1.changed(r7) == false) goto L32;
        int r28 = 256;
    L33:
        r4 = r4 | r28;
    L32:
        r28 = 128;
        goto L33
    L31:
        r7 = r27;
        goto L32
    L16:
        if ((r35 & 2) != 0) goto L20;
        r5 = r25;
        if (r1.changed(r5) == false) goto L21;
        int r36 = 32;
    L22:
        r4 = r4 | r36;
    L21:
        r36 = 16;
        goto L22
    L20:
        r5 = r25;
        goto L21
    L6:
        if ((r34 & 6) == 0) goto L8;
        r4 = r34;
        goto L14
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r37 = 4;
    L11:
        r4 = r37 | r34;
        goto L14
    L10:
        r37 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of CenterAlignedTopAppBar with expandedHeight parameter")
    public static final /* synthetic */ void CenterAlignedTopAppBar(final Function2 r20, Modifier r21, Function2 r22, Function3 r23, WindowInsets r24, TopAppBarColors r25, TopAppBarScrollBehavior r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(603182999);
        if ((r29 & 1) == 0) goto L6;
        int r3 = r28 | 6;
    L13:
        int r4 = r29 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r21;
    L24:
        int r6 = r29 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2 r7 = r22;
    L35:
        int r9 = r29 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3 r10 = r23;
    L47:
        if ((r28 & 24576) == 0) goto L49;
        WindowInsets r11 = r24;
    L58:
        if ((196608 & r28) == 0) goto L60;
        TopAppBarColors r12 = r25;
    L68:
        int r13 = r29 & 64;
        if (r13 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        TopAppBarScrollBehavior r14 = r26;
    L80:
        if ((599187 & r3) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L121;
        r1.startDefaults();
        if ((r28 & 1) != 0) goto L88;
    L98:
        if (r4 == 0) goto L100;
        Modifier r2 = Modifier.Companion;
    L101:
        if (r6 == 0) goto L103;
        r7 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1866429650$material3();
    L103:
        if (r9 == 0) goto L106;
        r10 = ComposableSingletons$AppBarKt.INSTANCE.m2523getLambda$541682128$material3();
    L106:
        if ((r29 & 16) == 0) goto L109;
        r3 = r3 & (-57345);
        r11 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L109:
        if ((r29 & 32) == 0) goto L111;
        r3 = r3 & (-458753);
        r12 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
    L111:
        if (r13 == 0) goto L113;
        int r15 = r3;
        TopAppBarScrollBehavior r8 = null;
        Function3 r16 = r10;
        WindowInsets r17 = r11;
        TopAppBarColors r18 = r12;
    L114:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(603182999, r15, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:291)");
    L117:
        int r19 = ((((r15 & 14) | 24576) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168);
        int r30 = r15 << 3;
        m2307CenterAlignedTopAppBarGHTll3U(r20, r2, r7, r16, TopAppBarDefaults.INSTANCE.m3586getTopAppBarExpandedHeightD9Ej5fM(), r17, r18, r8, r1, ((r19 | (458752 & r30)) | (3670016 & r30)) | (r30 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        r11 = r17;
        final Function3 r31 = r16;
        final Function2 r32 = r7;
        final TopAppBarScrollBehavior r33 = r8;
        final TopAppBarColors r34 = r18;
        r5 = r2;
    L122:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L126;
        final Modifier r35 = r5;
        final WindowInsets r36 = r11;
        r110.updateScope(new p0(r20, r35, r32, r31, r36, r34, r33, r28, r29));
        return;
    L126:
        return;
    L113:
        r15 = r3;
    L97:
        r16 = r10;
        r17 = r11;
        r18 = r12;
        r8 = r14;
        goto L114
    L100:
        r2 = r5;
        goto L101
    L88:
        if (r1.getDefaultsInvalid() == true) goto L98;
        r1.skipToGroupEnd();
        if ((r29 & 16) == 0) goto L94;
        r3 = r3 & (-57345);
    L94:
        if ((r29 & 32) == 0) goto L96;
        r3 = r3 & (-458753);
    L96:
        r15 = r3;
        r2 = r5;
        goto L97
    L121:
        r1.skipToGroupEnd();
        r32 = r7;
        r31 = r10;
        r34 = r12;
        r33 = r14;
        goto L122
    L82:
        r0 = false;
        goto L84
    L72:
        if ((1572864 & r28) != 0) goto L78;
        r14 = r26;
        if (r1.changed(r14) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L80
    L76:
        r111 = 524288;
        goto L77
    L60:
        if ((r29 & 32) != 0) goto L64;
        r12 = r25;
        if (r1.changed(r12) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
    L65:
        r112 = 65536;
        goto L66
    L64:
        r12 = r25;
        goto L65
    L49:
        if ((r29 & 16) != 0) goto L53;
        r11 = r24;
        if (r1.changed(r11) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
    L54:
        r113 = 8192;
        goto L55
    L53:
        r11 = r24;
        goto L54
    L39:
        if ((r28 & 3072) != 0) goto L45;
        r10 = r23;
        if (r1.changedInstance(r10) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
        goto L47
    L43:
        r114 = 1024;
        goto L44
    L28:
        if ((r28 & 384) != 0) goto L34;
        r7 = r22;
        if (r1.changedInstance(r7) == false) goto L32;
        int r37 = 256;
    L33:
        r3 = r3 | r37;
        goto L35
    L32:
        r37 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L23;
        r5 = r21;
        if (r1.changed(r5) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r3 = r28;
        goto L13
    L8:
        if (r1.changedInstance(r20) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r28;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of LargeTopAppBar with collapsedHeight and expandedHeight parameters")
    public static final /* synthetic */ void LargeTopAppBar(final Function2 r21, Modifier r22, Function2 r23, Function3 r24, WindowInsets r25, TopAppBarColors r26, TopAppBarScrollBehavior r27, Composer r28, final int r29, final int r30) {
        Composer r1 = r28.startRestartGroup(-330927229);
        if ((r30 & 1) == 0) goto L6;
        int r3 = r29 | 6;
    L13:
        int r4 = r30 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r22;
    L24:
        int r6 = r30 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2 r7 = r23;
    L35:
        int r9 = r30 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3 r10 = r24;
    L47:
        if ((r29 & 24576) == 0) goto L49;
        WindowInsets r11 = r25;
    L58:
        if ((196608 & r29) == 0) goto L60;
        TopAppBarColors r12 = r26;
    L68:
        int r13 = r30 & 64;
        if (r13 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        TopAppBarScrollBehavior r14 = r27;
    L80:
        if ((599187 & r3) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L121;
        r1.startDefaults();
        if ((r29 & 1) != 0) goto L88;
    L98:
        if (r4 == 0) goto L100;
        Modifier r2 = Modifier.Companion;
    L101:
        if (r6 == 0) goto L103;
        r7 = ComposableSingletons$AppBarKt.INSTANCE.m2526getLambda$699106370$material3();
    L103:
        if (r9 == 0) goto L106;
        r10 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1702484764$material3();
    L106:
        if ((r30 & 16) == 0) goto L109;
        r3 = r3 & (-57345);
        r11 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L109:
        if ((r30 & 32) == 0) goto L111;
        r3 = r3 & (-458753);
        r12 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
    L111:
        if (r13 == 0) goto L113;
        int r15 = r3;
        TopAppBarScrollBehavior r8 = null;
        Function3 r16 = r10;
        WindowInsets r17 = r11;
        TopAppBarColors r18 = r12;
    L114:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(-330927229, r15, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:696)");
    L117:
        TopAppBarDefaults r19 = TopAppBarDefaults.INSTANCE;
        float r110 = r19.m3578getLargeAppBarCollapsedHeightD9Ej5fM();
        float r111 = r19.m3579getLargeAppBarExpandedHeightD9Ej5fM();
        int r112 = ((((r15 & 14) | 221184) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168);
        int r20 = r15 << 6;
        m2310LargeTopAppBaroKE7A98(r21, r2, r7, r16, r110, r111, r17, r18, r8, r1, ((r112 | (3670016 & r20)) | (29360128 & r20)) | (r20 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        r11 = r17;
        final Function3 r31 = r16;
        final Function2 r32 = r7;
        final TopAppBarScrollBehavior r33 = r8;
        final TopAppBarColors r34 = r18;
        r5 = r2;
    L122:
        ScopeUpdateScope r113 = r1.endRestartGroup();
        if (r113 == null) goto L126;
        final Modifier r35 = r5;
        final WindowInsets r36 = r11;
        r113.updateScope(new r0(r21, r35, r32, r31, r36, r34, r33, r29, r30));
        return;
    L126:
        return;
    L113:
        r15 = r3;
    L97:
        r16 = r10;
        r17 = r11;
        r18 = r12;
        r8 = r14;
        goto L114
    L100:
        r2 = r5;
        goto L101
    L88:
        if (r1.getDefaultsInvalid() == true) goto L98;
        r1.skipToGroupEnd();
        if ((r30 & 16) == 0) goto L94;
        r3 = r3 & (-57345);
    L94:
        if ((r30 & 32) == 0) goto L96;
        r3 = r3 & (-458753);
    L96:
        r15 = r3;
        r2 = r5;
        goto L97
    L121:
        r1.skipToGroupEnd();
        r32 = r7;
        r31 = r10;
        r34 = r12;
        r33 = r14;
        goto L122
    L82:
        r0 = false;
        goto L84
    L72:
        if ((1572864 & r29) != 0) goto L78;
        r14 = r27;
        if (r1.changed(r14) == false) goto L76;
        int r114 = 1048576;
    L77:
        r3 = r3 | r114;
        goto L80
    L76:
        r114 = 524288;
        goto L77
    L60:
        if ((r30 & 32) != 0) goto L64;
        r12 = r26;
        if (r1.changed(r12) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
    L65:
        r115 = 65536;
        goto L66
    L64:
        r12 = r26;
        goto L65
    L49:
        if ((r30 & 16) != 0) goto L53;
        r11 = r25;
        if (r1.changed(r11) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
    L54:
        r116 = 8192;
        goto L55
    L53:
        r11 = r25;
        goto L54
    L39:
        if ((r29 & 3072) != 0) goto L45;
        r10 = r24;
        if (r1.changedInstance(r10) == false) goto L43;
        int r117 = 2048;
    L44:
        r3 = r3 | r117;
        goto L47
    L43:
        r117 = 1024;
        goto L44
    L28:
        if ((r29 & 384) != 0) goto L34;
        r7 = r23;
        if (r1.changedInstance(r7) == false) goto L32;
        int r37 = 256;
    L33:
        r3 = r3 | r37;
        goto L35
    L32:
        r37 = 128;
        goto L33
    L17:
        if ((r29 & 48) != 0) goto L23;
        r5 = r22;
        if (r1.changed(r5) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r29 & 6) == 0) goto L8;
        r3 = r29;
        goto L13
    L8:
        if (r1.changedInstance(r21) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r29;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of MediumTopAppBar with collapsedHeight and expandedHeight parameters")
    public static final /* synthetic */ void MediumTopAppBar(final Function2 r21, Modifier r22, Function2 r23, Function3 r24, WindowInsets r25, TopAppBarColors r26, TopAppBarScrollBehavior r27, Composer r28, final int r29, final int r30) {
        Composer r1 = r28.startRestartGroup(-319217319);
        if ((r30 & 1) == 0) goto L6;
        int r3 = r29 | 6;
    L13:
        int r4 = r30 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r22;
    L24:
        int r6 = r30 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2 r7 = r23;
    L35:
        int r9 = r30 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3 r10 = r24;
    L47:
        if ((r29 & 24576) == 0) goto L49;
        WindowInsets r11 = r25;
    L58:
        if ((196608 & r29) == 0) goto L60;
        TopAppBarColors r12 = r26;
    L68:
        int r13 = r30 & 64;
        if (r13 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        TopAppBarScrollBehavior r14 = r27;
    L80:
        if ((599187 & r3) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L121;
        r1.startDefaults();
        if ((r29 & 1) != 0) goto L88;
    L98:
        if (r4 == 0) goto L100;
        Modifier r2 = Modifier.Companion;
    L101:
        if (r6 == 0) goto L103;
        r7 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1152131198$material3();
    L103:
        if (r9 == 0) goto L106;
        r10 = ComposableSingletons$AppBarKt.INSTANCE.m2516getLambda$1707954976$material3();
    L106:
        if ((r30 & 16) == 0) goto L109;
        r3 = r3 & (-57345);
        r11 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L109:
        if ((r30 & 32) == 0) goto L111;
        r3 = r3 & (-458753);
        r12 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
    L111:
        if (r13 == 0) goto L113;
        int r15 = r3;
        TopAppBarScrollBehavior r8 = null;
        Function3 r16 = r10;
        WindowInsets r17 = r11;
        TopAppBarColors r18 = r12;
    L114:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(-319217319, r15, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:451)");
    L117:
        TopAppBarDefaults r19 = TopAppBarDefaults.INSTANCE;
        float r110 = r19.m3582getMediumAppBarCollapsedHeightD9Ej5fM();
        float r111 = r19.m3583getMediumAppBarExpandedHeightD9Ej5fM();
        int r112 = ((((r15 & 14) | 221184) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168);
        int r20 = r15 << 6;
        m2312MediumTopAppBaroKE7A98(r21, r2, r7, r16, r110, r111, r17, r18, r8, r1, ((r112 | (3670016 & r20)) | (29360128 & r20)) | (r20 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        r11 = r17;
        final Function3 r31 = r16;
        final Function2 r32 = r7;
        final TopAppBarScrollBehavior r33 = r8;
        final TopAppBarColors r34 = r18;
        r5 = r2;
    L122:
        ScopeUpdateScope r113 = r1.endRestartGroup();
        if (r113 == null) goto L126;
        final Modifier r35 = r5;
        final WindowInsets r36 = r11;
        r113.updateScope(new h0(r21, r35, r32, r31, r36, r34, r33, r29, r30));
        return;
    L126:
        return;
    L113:
        r15 = r3;
    L97:
        r16 = r10;
        r17 = r11;
        r18 = r12;
        r8 = r14;
        goto L114
    L100:
        r2 = r5;
        goto L101
    L88:
        if (r1.getDefaultsInvalid() == true) goto L98;
        r1.skipToGroupEnd();
        if ((r30 & 16) == 0) goto L94;
        r3 = r3 & (-57345);
    L94:
        if ((r30 & 32) == 0) goto L96;
        r3 = r3 & (-458753);
    L96:
        r15 = r3;
        r2 = r5;
        goto L97
    L121:
        r1.skipToGroupEnd();
        r32 = r7;
        r31 = r10;
        r34 = r12;
        r33 = r14;
        goto L122
    L82:
        r0 = false;
        goto L84
    L72:
        if ((1572864 & r29) != 0) goto L78;
        r14 = r27;
        if (r1.changed(r14) == false) goto L76;
        int r114 = 1048576;
    L77:
        r3 = r3 | r114;
        goto L80
    L76:
        r114 = 524288;
        goto L77
    L60:
        if ((r30 & 32) != 0) goto L64;
        r12 = r26;
        if (r1.changed(r12) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
    L65:
        r115 = 65536;
        goto L66
    L64:
        r12 = r26;
        goto L65
    L49:
        if ((r30 & 16) != 0) goto L53;
        r11 = r25;
        if (r1.changed(r11) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
    L54:
        r116 = 8192;
        goto L55
    L53:
        r11 = r25;
        goto L54
    L39:
        if ((r29 & 3072) != 0) goto L45;
        r10 = r24;
        if (r1.changedInstance(r10) == false) goto L43;
        int r117 = 2048;
    L44:
        r3 = r3 | r117;
        goto L47
    L43:
        r117 = 1024;
        goto L44
    L28:
        if ((r29 & 384) != 0) goto L34;
        r7 = r23;
        if (r1.changedInstance(r7) == false) goto L32;
        int r37 = 256;
    L33:
        r3 = r3 | r37;
        goto L35
    L32:
        r37 = 128;
        goto L33
    L17:
        if ((r29 & 48) != 0) goto L23;
        r5 = r22;
        if (r1.changed(r5) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r29 & 6) == 0) goto L8;
        r3 = r29;
        goto L13
    L8:
        if (r1.changedInstance(r21) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r29;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of TopAppBar with expandedHeight parameter")
    public static final /* synthetic */ void TopAppBar(final Function2 r20, Modifier r21, Function2 r22, Function3 r23, WindowInsets r24, TopAppBarColors r25, TopAppBarScrollBehavior r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(1788762628);
        if ((r29 & 1) == 0) goto L6;
        int r3 = r28 | 6;
    L13:
        int r4 = r29 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r21;
    L24:
        int r6 = r29 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2 r7 = r22;
    L35:
        int r9 = r29 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3 r10 = r23;
    L47:
        if ((r28 & 24576) == 0) goto L49;
        WindowInsets r11 = r24;
    L58:
        if ((196608 & r28) == 0) goto L60;
        TopAppBarColors r12 = r25;
    L68:
        int r13 = r29 & 64;
        if (r13 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        TopAppBarScrollBehavior r14 = r26;
    L80:
        if ((599187 & r3) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L121;
        r1.startDefaults();
        if ((r28 & 1) != 0) goto L88;
    L98:
        if (r4 == 0) goto L100;
        Modifier r2 = Modifier.Companion;
    L101:
        if (r6 == 0) goto L103;
        r7 = ComposableSingletons$AppBarKt.INSTANCE.m2529getLambda$944449303$material3();
    L103:
        if (r9 == 0) goto L106;
        r10 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$917296843$material3();
    L106:
        if ((r29 & 16) == 0) goto L109;
        r3 = r3 & (-57345);
        r11 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L109:
        if ((r29 & 32) == 0) goto L111;
        r3 = r3 & (-458753);
        r12 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
    L111:
        if (r13 == 0) goto L113;
        int r15 = r3;
        TopAppBarScrollBehavior r8 = null;
        Function3 r16 = r10;
        WindowInsets r17 = r11;
        TopAppBarColors r18 = r12;
    L114:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(1788762628, r15, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:168)");
    L117:
        int r19 = ((((r15 & 14) | 24576) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168);
        int r30 = r15 << 3;
        m2314TopAppBarGHTll3U(r20, r2, r7, r16, TopAppBarDefaults.INSTANCE.m3586getTopAppBarExpandedHeightD9Ej5fM(), r17, r18, r8, r1, ((r19 | (458752 & r30)) | (3670016 & r30)) | (r30 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        r11 = r17;
        final Function3 r31 = r16;
        final Function2 r32 = r7;
        final TopAppBarScrollBehavior r33 = r8;
        final TopAppBarColors r34 = r18;
        r5 = r2;
    L122:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L126;
        final Modifier r35 = r5;
        final WindowInsets r36 = r11;
        r110.updateScope(new x(r20, r35, r32, r31, r36, r34, r33, r28, r29));
        return;
    L126:
        return;
    L113:
        r15 = r3;
    L97:
        r16 = r10;
        r17 = r11;
        r18 = r12;
        r8 = r14;
        goto L114
    L100:
        r2 = r5;
        goto L101
    L88:
        if (r1.getDefaultsInvalid() == true) goto L98;
        r1.skipToGroupEnd();
        if ((r29 & 16) == 0) goto L94;
        r3 = r3 & (-57345);
    L94:
        if ((r29 & 32) == 0) goto L96;
        r3 = r3 & (-458753);
    L96:
        r15 = r3;
        r2 = r5;
        goto L97
    L121:
        r1.skipToGroupEnd();
        r32 = r7;
        r31 = r10;
        r34 = r12;
        r33 = r14;
        goto L122
    L82:
        r0 = false;
        goto L84
    L72:
        if ((1572864 & r28) != 0) goto L78;
        r14 = r26;
        if (r1.changed(r14) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L80
    L76:
        r111 = 524288;
        goto L77
    L60:
        if ((r29 & 32) != 0) goto L64;
        r12 = r25;
        if (r1.changed(r12) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
    L65:
        r112 = 65536;
        goto L66
    L64:
        r12 = r25;
        goto L65
    L49:
        if ((r29 & 16) != 0) goto L53;
        r11 = r24;
        if (r1.changed(r11) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
    L54:
        r113 = 8192;
        goto L55
    L53:
        r11 = r24;
        goto L54
    L39:
        if ((r28 & 3072) != 0) goto L45;
        r10 = r23;
        if (r1.changedInstance(r10) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
        goto L47
    L43:
        r114 = 1024;
        goto L44
    L28:
        if ((r28 & 384) != 0) goto L34;
        r7 = r22;
        if (r1.changedInstance(r7) == false) goto L32;
        int r37 = 256;
    L33:
        r3 = r3 | r37;
        goto L35
    L32:
        r37 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L23;
        r5 = r21;
        if (r1.changed(r5) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r3 = r28;
        goto L13
    L8:
        if (r1.changedInstance(r20) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r28;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    public static final void m2303BottomAppBarSnr_uVM(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r31, Modifier r32, Function2<? super Composer, ? super Integer, Unit> r33, long r34, long r36, float r38, PaddingValues r39, WindowInsets r40, Composer r41, final int r42, final int r43) {
        Composer r1 = r41.startRestartGroup(-2144093983);
        if ((r43 & 1) == 0) goto L6;
        int r3 = r42 | 6;
    L13:
        int r4 = r43 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r32;
    L24:
        int r6 = r43 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r7 = r33;
    L36:
        if ((r42 & 3072) == 0) goto L38;
        long r8 = r34;
    L47:
        if ((r42 & 24576) != 0) goto L55;
        long r13 = r36;
        if ((r43 & 16) == 0) goto L51;
    L53:
        int r10 = 8192;
    L54:
        r3 = r3 | r10;
    L56:
        int r11 = r43 & 32;
        if (r11 == 0) goto L60;
        r3 = r3 | 196608;
    L66:
        float r15 = r38;
    L67:
        int r16 = r43 & 64;
        if (r16 == 0) goto L71;
        r3 = r3 | 1572864;
    L78:
        if ((r42 & 12582912) != 0) goto L89;
        if ((r43 & 128) != 0) goto L85;
        if (r1.changed(r40) == false) goto L85;
        int r18 = 8388608;
    L86:
        r3 = r3 | r18;
    L85:
        r18 = 4194304;
    L89:
        if ((r3 & 4793491) == 4793490) goto L91;
        boolean r0 = true;
    L93:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L137;
        r1.startDefaults();
        if ((r42 & 1) != 0) goto L97;
    L111:
        if (r4 == 0) goto L113;
        r5 = Modifier.Companion;
    L113:
        if (r6 == 0) goto L116;
        r7 = null;
    L116:
        if ((r43 & 8) == 0) goto L119;
        r8 = BottomAppBarDefaults.INSTANCE.getContainerColor(r1, 6);
        r3 = r3 & (-7169);
    L119:
        if ((r43 & 16) == 0) goto L121;
        r13 = ColorSchemeKt.m2496contentColorForek8zF_U(r8, r1, (r3 >> 9) & 14);
        r3 = r3 & (-57345);
    L121:
        if (r11 == 0) goto L123;
        r15 = BottomAppBarDefaults.INSTANCE.m2330getContainerElevationD9Ej5fM();
    L123:
        if (r16 == 0) goto L125;
        PaddingValues r2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
    L127:
        if ((r43 & 128) == 0) goto L129;
        int r12 = r3 & (-29360129);
        r40 = BottomAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
        long r9 = r13;
        PaddingValues r14 = r2;
    L110:
        float r17 = r15;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L133;
        ComposerKt.traceEventStart(-2144093983, r12, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1044)");
    L133:
        m2305BottomAppBarqhFBPw4(r31, r5, r7, r8, r9, r17, r14, r40, null, r1, ((((((((r12 & 14) | 100663296) | (r12 & 112)) | (r12 & 896)) | (r12 & 7168)) | (57344 & r12)) | (458752 & r12)) | (3670016 & r12)) | (r12 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L136;
        ComposerKt.traceEventEnd();
    L136:
        final WindowInsets r19 = r40;
        long r27 = r8;
        final float r20 = r17;
        final PaddingValues r21 = r14;
        long r29 = r9;
        final Modifier r22 = r5;
        final Function2<? super Composer, ? super Integer, Unit> r23 = r7;
        final long r24 = r27;
        final long r25 = r29;
    L138:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L142;
        r110.updateScope(new q0(r31, r22, r23, r24, r25, r20, r21, r19, r42, r43));
        return;
    L142:
        return;
    L129:
        r14 = r2;
    L109:
        r12 = r3;
        r9 = r13;
        goto L110
    L125:
        r2 = r39;
        goto L127
    L97:
        if (r1.getDefaultsInvalid() == true) goto L111;
        r1.skipToGroupEnd();
        if ((r43 & 8) == 0) goto L103;
        r3 = r3 & (-7169);
    L103:
        if ((r43 & 16) == 0) goto L106;
        r3 = r3 & (-57345);
    L106:
        if ((r43 & 128) == 0) goto L108;
        r3 = r3 & (-29360129);
    L108:
        r14 = r39;
        goto L109
    L137:
        r1.skipToGroupEnd();
        r19 = r40;
        r22 = r5;
        r23 = r7;
        r24 = r8;
        r25 = r13;
        r20 = r15;
        r21 = r39;
        goto L138
    L91:
        r0 = false;
        goto L93
    L71:
        if ((r42 & 1572864) != 0) goto L78;
        if (r1.changed(r39) == false) goto L75;
        int r111 = 1048576;
    L76:
        r3 = r3 | r111;
        goto L78
    L75:
        r111 = 524288;
        goto L76
    L60:
        if ((196608 & r42) != 0) goto L66;
        r15 = r38;
        if (r1.changed(r15) == false) goto L64;
        int r112 = 131072;
    L65:
        r3 = r3 | r112;
        goto L67
    L64:
        r112 = 65536;
        goto L65
    L51:
        if (r1.changed(r13) == false) goto L53;
        r10 = 16384;
        goto L54
    L55:
        r13 = r36;
        goto L56
    L38:
        if ((r43 & 8) != 0) goto L42;
        r8 = r34;
        if (r1.changed(r8) == false) goto L43;
        int r113 = 2048;
    L44:
        r3 = r3 | r113;
    L43:
        r113 = 1024;
        goto L44
    L42:
        r8 = r34;
        goto L43
    L28:
        if ((r42 & 384) != 0) goto L34;
        r7 = r33;
        if (r1.changedInstance(r7) == false) goto L32;
        int r26 = 256;
    L33:
        r3 = r3 | r26;
        goto L36
    L32:
        r26 = 128;
        goto L33
    L17:
        if ((r42 & 48) != 0) goto L23;
        r5 = r32;
        if (r1.changed(r5) == false) goto L21;
        int r28 = 32;
    L22:
        r3 = r3 | r28;
        goto L24
    L21:
        r28 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r3 = r42;
        goto L13
    L8:
        if (r1.changedInstance(r31) == false) goto L10;
        int r30 = 4;
    L11:
        r3 = r30 | r42;
        goto L13
    L10:
        r30 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: BottomAppBar-e-3WI5M, reason: not valid java name */
    public static final void m2304BottomAppBare3WI5M(Modifier r28, long r29, long r31, float r33, PaddingValues r34, WindowInsets r35, BottomAppBarScrollBehavior r36, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39, final int r40) {
        Composer r1 = r38.startRestartGroup(1562683362);
        int r2 = r40 & 1;
        if (r2 == 0) goto L6;
        int r4 = r39 | 6;
    L14:
        if ((r39 & 48) == 0) goto L16;
        long r5 = r29;
    L25:
        if ((r39 & 384) == 0) goto L27;
        long r7 = r31;
    L35:
        int r9 = r40 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        float r10 = r33;
    L46:
        int r13 = r40 & 16;
        if (r13 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        PaddingValues r14 = r34;
    L58:
        if ((196608 & r39) == 0) goto L60;
        WindowInsets r15 = r35;
    L68:
        int r16 = r40 & 64;
        if (r16 == 0) goto L72;
        r4 = r4 | 1572864;
    L79:
        if ((r40 & 128) == 0) goto L82;
        r4 = r4 | 12582912;
    L90:
        if ((r4 & 4793491) == 4793490) goto L92;
        boolean r0 = true;
    L94:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L137;
        r1.startDefaults();
        if ((r39 & 1) != 0) goto L98;
    L112:
        if (r2 == 0) goto L114;
        Modifier r3 = Modifier.Companion;
    L116:
        if ((r40 & 2) == 0) goto L119;
        r5 = BottomAppBarDefaults.INSTANCE.getContainerColor(r1, 6);
        r4 = r4 & (-113);
    L119:
        if ((r40 & 4) == 0) goto L121;
        r7 = ColorSchemeKt.m2496contentColorForek8zF_U(r5, r1, (r4 >> 3) & 14);
        r4 = r4 & (-897);
    L121:
        if (r9 == 0) goto L123;
        r10 = BottomAppBarDefaults.INSTANCE.m2330getContainerElevationD9Ej5fM();
    L123:
        if (r13 == 0) goto L126;
        r14 = BottomAppBarDefaults.INSTANCE.getContentPadding();
    L126:
        if ((r40 & 32) == 0) goto L128;
        r4 = r4 & (-458753);
        r15 = BottomAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L128:
        if (r16 != 0) goto L129;
    L110:
        final BottomAppBarScrollBehavior r11 = r36;
    L111:
        int r17 = r4;
        PaddingValues r6 = r14;
        WindowInsets r8 = r15;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L133;
        ComposerKt.traceEventStart(1562683362, r17, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1226)");
    L133:
        int r18 = r17 << 6;
        m2306BottomAppBarLayoutt5fmz9U(BottomAppBarTokens.INSTANCE.getContainerHeight-D9Ej5fM(), Arrangement.INSTANCE.getStart(), r3, r5, r7, r10, r6, r8, r11, r37, r1, (((((((r18 & 7168) | ((r18 & 896) | 54)) | (57344 & r18)) | (458752 & r18)) | (3670016 & r18)) | (29360128 & r18)) | (234881024 & r18)) | (r18 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L136;
        ComposerKt.traceEventEnd();
    L136:
        r14 = r6;
        r15 = r8;
        Modifier r12 = r3;
    L138:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L142;
        final Modifier r20 = r12;
        final long r21 = r5;
        final long r22 = r7;
        final float r23 = r10;
        final PaddingValues r24 = r14;
        final WindowInsets r25 = r15;
        r19.updateScope(new t0(r20, r21, r22, r23, r24, r25, r11, r37, r39, r40));
        return;
    L142:
        return;
    L129:
        r11 = null;
        goto L111
    L114:
        r3 = r28;
        goto L116
    L98:
        if (r1.getDefaultsInvalid() == true) goto L112;
        r1.skipToGroupEnd();
        if ((r40 & 2) == 0) goto L104;
        r4 = r4 & (-113);
    L104:
        if ((r40 & 4) == 0) goto L107;
        r4 = r4 & (-897);
    L107:
        if ((r40 & 32) == 0) goto L109;
        r4 = r4 & (-458753);
    L109:
        r3 = r28;
        goto L110
    L137:
        r1.skipToGroupEnd();
        r12 = r28;
        r11 = r36;
        goto L138
    L92:
        r0 = false;
        goto L94
    L82:
        if ((r39 & 12582912) != 0) goto L90;
        if (r1.changedInstance(r37) == false) goto L86;
        int r110 = 8388608;
    L87:
        r4 = r4 | r110;
        goto L90
    L86:
        r110 = 4194304;
        goto L87
    L72:
        if ((r39 & 1572864) != 0) goto L79;
        if (r1.changed(r36) == false) goto L76;
        int r111 = 1048576;
    L77:
        r4 = r4 | r111;
        goto L79
    L76:
        r111 = 524288;
        goto L77
    L60:
        if ((r40 & 32) != 0) goto L64;
        r15 = r35;
        if (r1.changed(r15) == false) goto L65;
        int r112 = 131072;
    L66:
        r4 = r4 | r112;
    L65:
        r112 = 65536;
        goto L66
    L64:
        r15 = r35;
        goto L65
    L50:
        if ((r39 & 24576) != 0) goto L56;
        r14 = r34;
        if (r1.changed(r14) == false) goto L54;
        int r113 = 16384;
    L55:
        r4 = r4 | r113;
        goto L58
    L54:
        r113 = 8192;
        goto L55
    L39:
        if ((r39 & 3072) != 0) goto L45;
        r10 = r33;
        if (r1.changed(r10) == false) goto L43;
        int r114 = 2048;
    L44:
        r4 = r4 | r114;
        goto L46
    L43:
        r114 = 1024;
        goto L44
    L27:
        if ((r40 & 4) != 0) goto L31;
        r7 = r31;
        if (r1.changed(r7) == false) goto L32;
        int r26 = 256;
    L33:
        r4 = r4 | r26;
    L32:
        r26 = 128;
        goto L33
    L31:
        r7 = r31;
        goto L32
    L16:
        if ((r40 & 2) != 0) goto L20;
        r5 = r29;
        if (r1.changed(r5) == false) goto L21;
        int r27 = 32;
    L22:
        r4 = r4 | r27;
    L21:
        r27 = 16;
        goto L22
    L20:
        r5 = r29;
        goto L21
    L6:
        if ((r39 & 6) == 0) goto L8;
        r4 = r39;
        goto L14
    L8:
        if (r1.changed(r28) == false) goto L10;
        int r30 = 4;
    L11:
        r4 = r30 | r39;
        goto L14
    L10:
        r30 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: CenterAlignedTopAppBar-GHTll3U, reason: not valid java name */
    public static final void m2307CenterAlignedTopAppBarGHTll3U(final Function2<? super Composer, ? super Integer, Unit> r27, Modifier r28, Function2<? super Composer, ? super Integer, Unit> r29, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r30, float r31, WindowInsets r32, TopAppBarColors r33, TopAppBarScrollBehavior r34, Composer r35, final int r36, final int r37) {
        Composer r1 = r35.startRestartGroup(-302230691);
        if ((r37 & 1) == 0) goto L6;
        int r3 = r36 | 6;
    L13:
        int r4 = r37 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r37 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r7 = r29;
    L35:
        int r8 = r37 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r11 = r30;
    L46:
        int r12 = r37 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        float r13 = r31;
    L58:
        if ((196608 & r36) == 0) goto L60;
        WindowInsets r14 = r32;
    L69:
        if ((1572864 & r36) == 0) goto L71;
        TopAppBarColors r15 = r33;
    L79:
        int r0 = r37 & 128;
        if (r0 == 0) goto L83;
        r3 = r3 | 12582912;
    L90:
        if ((r3 & 4793491) == 4793490) goto L92;
        boolean r2 = true;
    L94:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L140;
        r1.startDefaults();
        if ((r36 & 1) != 0) goto L98;
    L109:
        if (r4 == 0) goto L111;
        final Modifier r5 = Modifier.Companion;
    L112:
        if (r6 == 0) goto L114;
        r7 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$575301698$material3();
    L114:
        if (r8 == 0) goto L116;
        r11 = ComposableSingletons$AppBarKt.INSTANCE.m2524getLambda$643931612$material3();
    L116:
        if (r12 == 0) goto L119;
        r13 = TopAppBarDefaults.INSTANCE.m3586getTopAppBarExpandedHeightD9Ej5fM();
    L119:
        if ((r37 & 32) == 0) goto L122;
        r3 = r3 & (-458753);
        r14 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L122:
        if ((r37 & 64) == 0) goto L124;
        r3 = r3 & (-3670017);
        r15 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
    L124:
        if (r0 != 0) goto L125;
    L107:
        final TopAppBarScrollBehavior r9 = r34;
    L108:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r10 = r11;
        WindowInsets r16 = r14;
        TopAppBarColors r17 = r15;
        int r18 = r3;
        float r19 = r13;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventStart(-302230691, r18, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:349)");
    L129:
        TextStyle r110 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), r1, 6);
        TextStyle r111 = TextStyle.Companion.getDefault();
        Alignment.Horizontal r112 = Alignment.Companion.getCenterHorizontally();
        Dp.Companion r20 = Dp.Companion;
        if (Dp.equals-impl0(r19, r20.getUnspecified-D9Ej5fM()) == false) goto L132;
    L135:
        float r113 = TopAppBarDefaults.INSTANCE.m3586getTopAppBarExpandedHeightD9Ej5fM();
    L136:
        int r114 = r18 << 12;
        int r24 = ((((((r18 >> 3) & 14) | 224256) | ((r18 << 3) & 112)) | (r114 & 3670016)) | (r114 & 29360128)) | (r114 & 1879048192);
        int r21 = r18 >> 18;
        m2313SingleRowTopAppBarwn8IZOc(r5, r27, r110, null, r111, r112, r7, r10, r113, r16, r17, r9, r1, r24, (r21 & 14) | (r21 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventEnd();
    L139:
        final float r22 = r19;
        final Function2<? super Composer, ? super Integer, Unit> r23 = r7;
        final TopAppBarColors r25 = r17;
        final WindowInsets r26 = r16;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r38 = r10;
    L141:
        ScopeUpdateScope r115 = r1.endRestartGroup();
        if (r115 == null) goto L145;
        r115.updateScope(new u(r27, r5, r23, r38, r22, r26, r25, r9, r36, r37));
        return;
    L145:
        return;
    L132:
        if (Dp.equals-impl0(r19, r20.getInfinity-D9Ej5fM()) == true) goto L135;
        r113 = r19;
        goto L136
    L125:
        r9 = null;
        goto L108
    L111:
        r5 = r28;
        goto L112
    L98:
        if (r1.getDefaultsInvalid() == true) goto L109;
        r1.skipToGroupEnd();
        if ((r37 & 32) == 0) goto L104;
        r3 = r3 & (-458753);
    L104:
        if ((r37 & 64) == 0) goto L106;
        r3 = r3 & (-3670017);
    L106:
        r5 = r28;
        goto L107
    L140:
        r1.skipToGroupEnd();
        r5 = r28;
        r9 = r34;
        r23 = r7;
        r38 = r11;
        r22 = r13;
        r26 = r14;
        r25 = r15;
        goto L141
    L92:
        r2 = false;
        goto L94
    L83:
        if ((r36 & 12582912) != 0) goto L90;
        if (r1.changed(r34) == false) goto L87;
        int r116 = 8388608;
    L88:
        r3 = r3 | r116;
        goto L90
    L87:
        r116 = 4194304;
        goto L88
    L71:
        if ((r37 & 64) != 0) goto L75;
        r15 = r33;
        if (r1.changed(r15) == false) goto L76;
        int r117 = 1048576;
    L77:
        r3 = r3 | r117;
    L76:
        r117 = 524288;
        goto L77
    L75:
        r15 = r33;
        goto L76
    L60:
        if ((r37 & 32) != 0) goto L64;
        r14 = r32;
        if (r1.changed(r14) == false) goto L65;
        int r118 = 131072;
    L66:
        r3 = r3 | r118;
    L65:
        r118 = 65536;
        goto L66
    L64:
        r14 = r32;
        goto L65
    L50:
        if ((r36 & 24576) != 0) goto L56;
        r13 = r31;
        if (r1.changed(r13) == false) goto L54;
        int r119 = 16384;
    L55:
        r3 = r3 | r119;
        goto L58
    L54:
        r119 = 8192;
        goto L55
    L39:
        if ((r36 & 3072) != 0) goto L45;
        r11 = r30;
        if (r1.changedInstance(r11) == false) goto L43;
        int r120 = 2048;
    L44:
        r3 = r3 | r120;
        goto L46
    L43:
        r120 = 1024;
        goto L44
    L28:
        if ((r36 & 384) != 0) goto L34;
        r7 = r29;
        if (r1.changedInstance(r7) == false) goto L32;
        int r39 = 256;
    L33:
        r3 = r3 | r39;
        goto L35
    L32:
        r39 = 128;
        goto L33
    L17:
        if ((r36 & 48) != 0) goto L24;
        if (r1.changed(r28) == false) goto L21;
        int r40 = 32;
    L22:
        r3 = r3 | r40;
        goto L24
    L21:
        r40 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r3 = r36;
        goto L13
    L8:
        if (r1.changedInstance(r27) == false) goto L10;
        int r41 = 4;
    L11:
        r3 = r41 | r36;
        goto L13
    L10:
        r41 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TopAppBar-GHTll3U, reason: not valid java name */
    public static final void m2314TopAppBarGHTll3U(final Function2<? super Composer, ? super Integer, Unit> r27, Modifier r28, Function2<? super Composer, ? super Integer, Unit> r29, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r30, float r31, WindowInsets r32, TopAppBarColors r33, TopAppBarScrollBehavior r34, Composer r35, final int r36, final int r37) {
        Composer r1 = r35.startRestartGroup(1784421840);
        if ((r37 & 1) == 0) goto L6;
        int r3 = r36 | 6;
    L13:
        int r4 = r37 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r37 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r7 = r29;
    L35:
        int r8 = r37 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r11 = r30;
    L46:
        int r12 = r37 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        float r13 = r31;
    L58:
        if ((196608 & r36) == 0) goto L60;
        WindowInsets r14 = r32;
    L69:
        if ((1572864 & r36) == 0) goto L71;
        TopAppBarColors r15 = r33;
    L79:
        int r0 = r37 & 128;
        if (r0 == 0) goto L83;
        r3 = r3 | 12582912;
    L90:
        if ((r3 & 4793491) == 4793490) goto L92;
        boolean r2 = true;
    L94:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L140;
        r1.startDefaults();
        if ((r36 & 1) != 0) goto L98;
    L109:
        if (r4 == 0) goto L111;
        final Modifier r5 = Modifier.Companion;
    L112:
        if (r6 == 0) goto L114;
        r7 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$657782987$material3();
    L114:
        if (r8 == 0) goto L116;
        r11 = ComposableSingletons$AppBarKt.INSTANCE.m2513getLambda$1270442071$material3();
    L116:
        if (r12 == 0) goto L119;
        r13 = TopAppBarDefaults.INSTANCE.m3586getTopAppBarExpandedHeightD9Ej5fM();
    L119:
        if ((r37 & 32) == 0) goto L122;
        r3 = r3 & (-458753);
        r14 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L122:
        if ((r37 & 64) == 0) goto L124;
        r3 = r3 & (-3670017);
        r15 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
    L124:
        if (r0 != 0) goto L125;
    L107:
        final TopAppBarScrollBehavior r9 = r34;
    L108:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r10 = r11;
        WindowInsets r16 = r14;
        TopAppBarColors r17 = r15;
        int r18 = r3;
        float r19 = r13;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventStart(1784421840, r18, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:225)");
    L129:
        TextStyle r110 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), r1, 6);
        TextStyle r111 = TextStyle.Companion.getDefault();
        Alignment.Horizontal r112 = Alignment.Companion.getStart();
        Dp.Companion r20 = Dp.Companion;
        if (Dp.equals-impl0(r19, r20.getUnspecified-D9Ej5fM()) == false) goto L132;
    L135:
        float r113 = TopAppBarDefaults.INSTANCE.m3586getTopAppBarExpandedHeightD9Ej5fM();
    L136:
        int r114 = r18 << 12;
        int r24 = ((((((r18 >> 3) & 14) | 224256) | ((r18 << 3) & 112)) | (r114 & 3670016)) | (r114 & 29360128)) | (r114 & 1879048192);
        int r21 = r18 >> 18;
        m2313SingleRowTopAppBarwn8IZOc(r5, r27, r110, null, r111, r112, r7, r10, r113, r16, r17, r9, r1, r24, (r21 & 14) | (r21 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventEnd();
    L139:
        final float r22 = r19;
        final Function2<? super Composer, ? super Integer, Unit> r23 = r7;
        final TopAppBarColors r25 = r17;
        final WindowInsets r26 = r16;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r38 = r10;
    L141:
        ScopeUpdateScope r115 = r1.endRestartGroup();
        if (r115 == null) goto L145;
        r115.updateScope(new g0(r27, r5, r23, r38, r22, r26, r25, r9, r36, r37));
        return;
    L145:
        return;
    L132:
        if (Dp.equals-impl0(r19, r20.getInfinity-D9Ej5fM()) == true) goto L135;
        r113 = r19;
        goto L136
    L125:
        r9 = null;
        goto L108
    L111:
        r5 = r28;
        goto L112
    L98:
        if (r1.getDefaultsInvalid() == true) goto L109;
        r1.skipToGroupEnd();
        if ((r37 & 32) == 0) goto L104;
        r3 = r3 & (-458753);
    L104:
        if ((r37 & 64) == 0) goto L106;
        r3 = r3 & (-3670017);
    L106:
        r5 = r28;
        goto L107
    L140:
        r1.skipToGroupEnd();
        r5 = r28;
        r9 = r34;
        r23 = r7;
        r38 = r11;
        r22 = r13;
        r26 = r14;
        r25 = r15;
        goto L141
    L92:
        r2 = false;
        goto L94
    L83:
        if ((r36 & 12582912) != 0) goto L90;
        if (r1.changed(r34) == false) goto L87;
        int r116 = 8388608;
    L88:
        r3 = r3 | r116;
        goto L90
    L87:
        r116 = 4194304;
        goto L88
    L71:
        if ((r37 & 64) != 0) goto L75;
        r15 = r33;
        if (r1.changed(r15) == false) goto L76;
        int r117 = 1048576;
    L77:
        r3 = r3 | r117;
    L76:
        r117 = 524288;
        goto L77
    L75:
        r15 = r33;
        goto L76
    L60:
        if ((r37 & 32) != 0) goto L64;
        r14 = r32;
        if (r1.changed(r14) == false) goto L65;
        int r118 = 131072;
    L66:
        r3 = r3 | r118;
    L65:
        r118 = 65536;
        goto L66
    L64:
        r14 = r32;
        goto L65
    L50:
        if ((r36 & 24576) != 0) goto L56;
        r13 = r31;
        if (r1.changed(r13) == false) goto L54;
        int r119 = 16384;
    L55:
        r3 = r3 | r119;
        goto L58
    L54:
        r119 = 8192;
        goto L55
    L39:
        if ((r36 & 3072) != 0) goto L45;
        r11 = r30;
        if (r1.changedInstance(r11) == false) goto L43;
        int r120 = 2048;
    L44:
        r3 = r3 | r120;
        goto L46
    L43:
        r120 = 1024;
        goto L44
    L28:
        if ((r36 & 384) != 0) goto L34;
        r7 = r29;
        if (r1.changedInstance(r7) == false) goto L32;
        int r39 = 256;
    L33:
        r3 = r3 | r39;
        goto L35
    L32:
        r39 = 128;
        goto L33
    L17:
        if ((r36 & 48) != 0) goto L24;
        if (r1.changed(r28) == false) goto L21;
        int r40 = 32;
    L22:
        r3 = r3 | r40;
        goto L24
    L21:
        r40 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r3 = r36;
        goto L13
    L8:
        if (r1.changedInstance(r27) == false) goto L10;
        int r41 = 4;
    L11:
        r3 = r41 | r36;
        goto L13
    L10:
        r41 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: BottomAppBar-qhFBPw4, reason: not valid java name */
    public static final void m2305BottomAppBarqhFBPw4(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r28, Modifier r29, Function2<? super Composer, ? super Integer, Unit> r30, long r31, long r33, float r35, PaddingValues r36, WindowInsets r37, BottomAppBarScrollBehavior r38, Composer r39, final int r40, final int r41) {
        Composer r2 = r39.startRestartGroup(272234465);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L13:
        int r4 = r41 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r41 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r40 & 3072) != 0) goto L47;
        if ((r41 & 8) != 0) goto L43;
        if (r2.changed(r31) == false) goto L43;
        int r10 = 2048;
    L44:
        r3 = r3 | r10;
    L43:
        r10 = 1024;
    L47:
        if ((r40 & 24576) == 0) goto L49;
        long r11 = r33;
    L57:
        int r14 = r41 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        float r15 = r35;
    L68:
        int r16 = r41 & 64;
        if (r16 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r40 & 12582912) != 0) goto L89;
        if ((r41 & 128) != 0) goto L86;
        if (r2.changed(r37) == false) goto L86;
        int r19 = 8388608;
    L87:
        r3 = r3 | r19;
    L86:
        r19 = 4194304;
    L89:
        int r0 = r41 & 256;
        if (r0 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r3 & 38347923) == 38347922) goto L102;
        boolean r5 = true;
    L104:
        if (r2.shouldExecute(r5, r3 & 1) == false) goto L154;
        r2.startDefaults();
        if ((r40 & 1) != 0) goto L108;
    L120:
        if (r4 == 0) goto L122;
        Modifier r7 = Modifier.Companion;
    L123:
        if (r6 == 0) goto L125;
        final Function2<? super Composer, ? super Integer, Unit> r8 = null;
    L127:
        if ((r41 & 8) == 0) goto L129;
        r3 = r3 & (-7169);
        long r9 = BottomAppBarDefaults.INSTANCE.getContainerColor(r2, 6);
    L131:
        if ((r41 & 16) == 0) goto L133;
        r11 = ColorSchemeKt.m2496contentColorForek8zF_U(r9, r2, (r3 >> 9) & 14);
        r3 = r3 & (-57345);
    L133:
        if (r14 == 0) goto L135;
        float r12 = BottomAppBarDefaults.INSTANCE.m2330getContainerElevationD9Ej5fM();
    L136:
        if (r16 == 0) goto L138;
        PaddingValues r17 = BottomAppBarDefaults.INSTANCE.getContentPadding();
    L140:
        if ((r41 & 128) == 0) goto L142;
        WindowInsets r18 = BottomAppBarDefaults.INSTANCE.getWindowInsets(r2, 6);
        r3 = r3 & (-29360129);
    L143:
        if (r0 == 0) goto L145;
        BottomAppBarScrollBehavior r27 = null;
    L146:
        int r110 = r3;
        WindowInsets r13 = r18;
    L147:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L150;
        ComposerKt.traceEventStart(272234465, r110, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1110)");
    L150:
        ComposableLambda r23 = ComposableLambdaKt.rememberComposableLambda(-1943077286, true, new AppBarKt$BottomAppBar$2(r28, r8), r2, 54);
        int r20 = r110 >> 6;
        int r25 = ((((((((r110 >> 3) & 14) | 12582912) | (r20 & 112)) | (r20 & 896)) | (r20 & 7168)) | (57344 & r20)) | (458752 & r20)) | (r20 & 3670016);
        m2304BottomAppBare3WI5M(r7, r9, r11, r12, r17, r13, r27, r23, r2, r25, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventEnd();
    L153:
        PaddingValues r111 = r17;
        WindowInsets r112 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r21 = r8;
    L155:
        ScopeUpdateScope r113 = r2.endRestartGroup();
        if (r113 == null) goto L159;
        final Modifier r22 = r7;
        final long r24 = r9;
        final long r26 = r11;
        final float r32 = r12;
        final PaddingValues r34 = r111;
        final WindowInsets r114 = r112;
        final BottomAppBarScrollBehavior r115 = r27;
        r113.updateScope(new o0(r28, r22, r21, r24, r26, r32, r34, r114, r115, r40, r41));
        return;
    L159:
        return;
    L145:
        r27 = r38;
        goto L146
    L142:
        r18 = r37;
        goto L143
    L138:
        r17 = r36;
        goto L140
    L135:
        r12 = r15;
        goto L136
    L129:
        r9 = r31;
        goto L131
    L125:
        r8 = r30;
        goto L127
    L122:
        r7 = r29;
        goto L123
    L108:
        if (r2.getDefaultsInvalid() == true) goto L120;
        r2.skipToGroupEnd();
        if ((r41 & 8) == 0) goto L114;
        r3 = r3 & (-7169);
    L114:
        if ((r41 & 16) == 0) goto L117;
        r3 = r3 & (-57345);
    L117:
        if ((r41 & 128) == 0) goto L119;
        r3 = r3 & (-29360129);
    L119:
        r7 = r29;
        r8 = r30;
        r9 = r31;
        r17 = r36;
        r27 = r38;
        r110 = r3;
        r12 = r15;
        r13 = r37;
        goto L147
    L154:
        r2.skipToGroupEnd();
        r7 = r29;
        r21 = r30;
        r9 = r31;
        r111 = r36;
        r112 = r37;
        r27 = r38;
        r12 = r15;
        goto L155
    L102:
        r5 = false;
        goto L104
    L93:
        if ((r40 & 100663296) != 0) goto L100;
        if (r2.changed(r38) == false) goto L97;
        int r116 = 67108864;
    L98:
        r3 = r3 | r116;
        goto L100
    L97:
        r116 = 33554432;
        goto L98
    L72:
        if ((r40 & 1572864) != 0) goto L79;
        if (r2.changed(r36) == false) goto L76;
        int r117 = 1048576;
    L77:
        r3 = r3 | r117;
        goto L79
    L76:
        r117 = 524288;
        goto L77
    L61:
        if ((196608 & r40) != 0) goto L67;
        r15 = r35;
        if (r2.changed(r15) == false) goto L65;
        int r118 = 131072;
    L66:
        r3 = r3 | r118;
        goto L68
    L65:
        r118 = 65536;
        goto L66
    L49:
        if ((r41 & 16) != 0) goto L53;
        r11 = r33;
        if (r2.changed(r11) == false) goto L54;
        int r119 = 16384;
    L55:
        r3 = r3 | r119;
    L54:
        r119 = 8192;
        goto L55
    L53:
        r11 = r33;
        goto L54
    L28:
        if ((r40 & 384) != 0) goto L36;
        if (r2.changedInstance(r30) == false) goto L32;
        int r42 = 256;
    L33:
        r3 = r3 | r42;
        goto L36
    L32:
        r42 = 128;
        goto L33
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r2.changed(r29) == false) goto L21;
        int r43 = 32;
    L22:
        r3 = r3 | r43;
        goto L24
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L13
    L8:
        if (r2.changedInstance(r28) == false) goto L10;
        int r44 = 4;
    L11:
        r3 = r44 | r40;
        goto L13
    L10:
        r44 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: FlexibleBottomAppBar-wBhsO_E, reason: not valid java name */
    public static final void m2308FlexibleBottomAppBarwBhsO_E(Modifier r29, long r30, long r32, PaddingValues r34, Arrangement.Horizontal r35, float r36, WindowInsets r37, BottomAppBarScrollBehavior r38, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r39, Composer r40, final int r41, final int r42) {
        Composer r1 = r40.startRestartGroup(-1717957447);
        int r2 = r42 & 1;
        if (r2 == 0) goto L6;
        int r4 = r41 | 6;
    L14:
        if ((r41 & 48) != 0) goto L25;
        if ((r42 & 2) != 0) goto L21;
        if (r1.changed(r30) == false) goto L21;
        int r7 = 32;
    L22:
        r4 = r4 | r7;
    L21:
        r7 = 16;
    L25:
        if ((r41 & 384) == 0) goto L27;
        long r8 = r32;
    L35:
        int r9 = r42 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        PaddingValues r10 = r34;
    L46:
        int r11 = r42 & 16;
        if (r11 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        Arrangement.Horizontal r14 = r35;
    L57:
        int r15 = r42 & 32;
        if (r15 == 0) goto L61;
        r4 = r4 | 196608;
    L68:
        if ((r41 & 1572864) != 0) goto L77;
        if ((r42 & 64) == 0) goto L72;
    L74:
        int r18 = 524288;
    L75:
        r4 = r4 | r18;
        goto L77
    L72:
        if (r1.changed(r37) == false) goto L74;
        r18 = 1048576;
    L77:
        int r0 = r42 & 128;
        if (r0 == 0) goto L81;
        r4 = r4 | 12582912;
    L88:
        if ((r42 & 256) == 0) goto L91;
        r4 = r4 | 100663296;
    L99:
        if ((r4 & 38347923) == 38347922) goto L101;
        boolean r3 = true;
    L103:
        if (r1.shouldExecute(r3, r4 & 1) == false) goto L163;
        r1.startDefaults();
        if ((r41 & 1) != 0) goto L107;
    L119:
        if (r2 == 0) goto L121;
        Modifier r5 = Modifier.Companion;
    L123:
        if ((r42 & 2) == 0) goto L125;
        int r6 = r4 & (-113);
        long r12 = BottomAppBarDefaults.INSTANCE.getContainerColor(r1, 6);
    L127:
        if ((r42 & 4) == 0) goto L129;
        r8 = ColorSchemeKt.m2496contentColorForek8zF_U(r12, r1, (r6 >> 3) & 14);
        r6 = r6 & (-897);
    L129:
        if (r9 == 0) goto L131;
        PaddingValues r13 = BottomAppBarDefaults.INSTANCE.getFlexibleContentPadding$material3();
    L132:
        if (r11 == 0) goto L134;
        Arrangement.Horizontal r16 = BottomAppBarDefaults.INSTANCE.getFlexibleHorizontalArrangement$material3();
    L135:
        if (r15 == 0) goto L137;
        float r17 = BottomAppBarDefaults.INSTANCE.m2331getFlexibleBottomAppBarHeightD9Ej5fM$material3();
    L139:
        if ((r42 & 64) == 0) goto L141;
        WindowInsets r19 = BottomAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
        r6 = r6 & (-3670017);
    L142:
        if (r0 == 0) goto L144;
        BottomAppBarScrollBehavior r20 = null;
    L145:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L149;
        ComposerKt.traceEventStart(-1717957447, r6, -1, "androidx.compose.material3.FlexibleBottomAppBar (AppBar.kt:1297)");
    L149:
        if ((Float.floatToRawIntBits(r17) & Integer.MAX_VALUE) >= 2139095040) goto L151;
        boolean r110 = true;
    L152:
        if (r110 == true) goto L154;
    L158:
        float r111 = BottomAppBarDefaults.INSTANCE.m2331getFlexibleBottomAppBarHeightD9Ej5fM$material3();
    L159:
        int r112 = r6 << 6;
        float r210 = r17;
        int r113 = ((((r112 & 896) | (((r6 >> 9) & 112) | 196608)) | (r112 & 7168)) | (57344 & r112)) | (3670016 & (r6 << 9));
        int r21 = r6 << 3;
        Arrangement.Horizontal r114 = r16;
        Modifier r115 = r5;
        long r116 = r12;
        long r117 = r8;
        m2306BottomAppBarLayoutt5fmz9U(r111, r114, r115, r116, r117, AppBarTokens.INSTANCE.getContainerElevation-D9Ej5fM(), r13, r19, r20, r39, r1, ((r113 | (29360128 & r21)) | (234881024 & r21)) | (r21 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventEnd();
    L162:
        BottomAppBarScrollBehavior r118 = r20;
        WindowInsets r119 = r19;
        final PaddingValues r22 = r13;
        float r23 = r210;
    L164:
        ScopeUpdateScope r120 = r1.endRestartGroup();
        if (r120 == null) goto L168;
        final Modifier r24 = r5;
        final long r25 = r12;
        final long r26 = r8;
        final Arrangement.Horizontal r27 = r16;
        final float r28 = r23;
        final WindowInsets r31 = r119;
        final BottomAppBarScrollBehavior r121 = r118;
        r120.updateScope(new j0(r24, r25, r26, r22, r27, r28, r31, r121, r39, r41, r42));
        return;
    L168:
        return;
    L154:
        if ((!Float.isNaN(r17)) == false) goto L158;
        if (Dp.compareTo-0680j_4(r17, Dp.constructor-impl(0)) <= 0) goto L158;
        r111 = r17;
        goto L159
    L151:
        r110 = false;
        goto L152
    L144:
        r20 = r38;
        goto L145
    L141:
        r19 = r37;
        goto L142
    L137:
        r17 = r36;
        goto L139
    L134:
        r16 = r14;
        goto L135
    L131:
        r13 = r10;
        goto L132
    L125:
        r6 = r4;
        r12 = r30;
        goto L127
    L121:
        r5 = r29;
        goto L123
    L107:
        if (r1.getDefaultsInvalid() == true) goto L119;
        r1.skipToGroupEnd();
        if ((r42 & 2) == 0) goto L113;
        r4 = r4 & (-113);
    L113:
        if ((r42 & 4) == 0) goto L116;
        r4 = r4 & (-897);
    L116:
        if ((r42 & 64) == 0) goto L118;
        r4 = r4 & (-3670017);
    L118:
        r5 = r29;
        r17 = r36;
        r19 = r37;
        r20 = r38;
        r6 = r4;
        r13 = r10;
        r16 = r14;
        r12 = r30;
        goto L145
    L163:
        r1.skipToGroupEnd();
        r5 = r29;
        r12 = r30;
        r23 = r36;
        r119 = r37;
        r118 = r38;
        r22 = r10;
        r16 = r14;
        goto L164
    L101:
        r3 = false;
        goto L103
    L91:
        if ((r41 & 100663296) != 0) goto L99;
        if (r1.changedInstance(r39) == false) goto L95;
        int r122 = 67108864;
    L96:
        r4 = r4 | r122;
        goto L99
    L95:
        r122 = 33554432;
        goto L96
    L81:
        if ((r41 & 12582912) != 0) goto L88;
        if (r1.changed(r38) == false) goto L85;
        int r123 = 8388608;
    L86:
        r4 = r4 | r123;
        goto L88
    L85:
        r123 = 4194304;
        goto L86
    L61:
        if ((r41 & 196608) != 0) goto L68;
        if (r1.changed(r36) == false) goto L65;
        int r124 = 131072;
    L66:
        r4 = r4 | r124;
        goto L68
    L65:
        r124 = 65536;
        goto L66
    L50:
        if ((r41 & 24576) != 0) goto L56;
        r14 = r35;
        if (r1.changed(r14) == false) goto L54;
        int r125 = 16384;
    L55:
        r4 = r4 | r125;
        goto L57
    L54:
        r125 = 8192;
        goto L55
    L39:
        if ((r41 & 3072) != 0) goto L45;
        r10 = r34;
        if (r1.changed(r10) == false) goto L43;
        int r126 = 2048;
    L44:
        r4 = r4 | r126;
        goto L46
    L43:
        r126 = 1024;
        goto L44
    L27:
        if ((r42 & 4) != 0) goto L31;
        r8 = r32;
        if (r1.changed(r8) == false) goto L32;
        int r33 = 256;
    L33:
        r4 = r4 | r33;
    L32:
        r33 = 128;
        goto L33
    L31:
        r8 = r32;
        goto L32
    L6:
        if ((r41 & 6) == 0) goto L8;
        r4 = r41;
        goto L14
    L8:
        if (r1.changed(r29) == false) goto L10;
        int r43 = 4;
    L11:
        r4 = r43 | r41;
        goto L14
    L10:
        r43 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LargeTopAppBar-oKE7A98, reason: not valid java name */
    public static final void m2310LargeTopAppBaroKE7A98(final Function2<? super Composer, ? super Integer, Unit> r35, Modifier r36, Function2<? super Composer, ? super Integer, Unit> r37, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r38, float r39, float r40, WindowInsets r41, TopAppBarColors r42, TopAppBarScrollBehavior r43, Composer r44, final int r45, final int r46) {
        Composer r1 = r44.startRestartGroup(-1406602045);
        if ((r46 & 1) == 0) goto L6;
        int r3 = r45 | 6;
    L13:
        int r4 = r46 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r46 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r7 = r37;
    L35:
        int r8 = r46 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r9 = r38;
    L46:
        int r12 = r46 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        float r13 = r39;
    L57:
        int r14 = r46 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        float r15 = r40;
    L69:
        if ((r45 & 1572864) != 0) goto L79;
        if ((r46 & 64) == 0) goto L73;
    L75:
        int r17 = 524288;
    L76:
        r3 = r3 | r17;
        goto L79
    L73:
        if (r1.changed(r41) == false) goto L75;
        r17 = 1048576;
    L79:
        if ((r45 & 12582912) != 0) goto L89;
        if ((r46 & 128) != 0) goto L86;
        if (r1.changed(r42) == false) goto L86;
        int r18 = 8388608;
    L87:
        r3 = r3 | r18;
    L86:
        r18 = 4194304;
    L89:
        int r0 = r46 & 256;
        if (r0 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r3 & 38347923) == 38347922) goto L102;
        boolean r2 = true;
    L104:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L165;
        r1.startDefaults();
        if ((r45 & 1) != 0) goto L108;
    L118:
        if (r4 == 0) goto L120;
        final Modifier r5 = Modifier.Companion;
    L121:
        if (r6 == 0) goto L123;
        Function2<? super Composer, ? super Integer, Unit> r10 = ComposableSingletons$AppBarKt.INSTANCE.m2512getLambda$1230986050$material3();
    L124:
        if (r8 == 0) goto L126;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r11 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1921811868$material3();
    L127:
        if (r12 == 0) goto L129;
        float r16 = TopAppBarDefaults.INSTANCE.m3578getLargeAppBarCollapsedHeightD9Ej5fM();
    L130:
        if (r14 == 0) goto L132;
        float r19 = TopAppBarDefaults.INSTANCE.m3579getLargeAppBarExpandedHeightD9Ej5fM();
    L134:
        if ((r46 & 64) == 0) goto L136;
        WindowInsets r20 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
        r3 = r3 & (-3670017);
    L138:
        if ((r46 & 128) == 0) goto L140;
        TopAppBarColors r110 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
        r3 = r3 & (-29360129);
    L141:
        if (r0 == 0) goto L143;
        int r34 = r3;
        TopAppBarScrollBehavior r21 = null;
        TopAppBarColors r22 = r110;
        int r111 = r34;
    L144:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventStart(-1406602045, r111, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:763)");
    L147:
        TextStyle r112 = TypographyKt.getValue(AppBarLargeTokens.INSTANCE.getTitleFont(), r1, 6);
        TextStyle r113 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), r1, 6);
        float r114 = LargeTitleBottomPadding;
        TextStyle.Companion r115 = TextStyle.Companion;
        TextStyle r116 = r115.getDefault();
        TextStyle r23 = r115.getDefault();
        Alignment.Horizontal r24 = Alignment.Companion.getStart();
        Dp.Companion r117 = Dp.Companion;
        if (Dp.equals-impl0(r16, r117.getUnspecified-D9Ej5fM()) == false) goto L150;
    L153:
        float r25 = TopAppBarDefaults.INSTANCE.m3578getLargeAppBarCollapsedHeightD9Ej5fM();
    L155:
        if (Dp.equals-impl0(r19, r117.getUnspecified-D9Ej5fM()) == false) goto L157;
    L160:
        float r26 = TopAppBarDefaults.INSTANCE.m3579getLargeAppBarExpandedHeightD9Ej5fM();
    L161:
        int r27 = r111 >> 3;
        m2318TwoRowsTopAppBarpJA5dT0(r5, r35, r112, r114, r35, r113, null, r116, null, r23, r24, r10, r11, r25, r26, r20, r22, r21, r1, (((r27 & 14) | 920128512) | ((r111 << 3) & 112)) | ((r111 << 12) & 57344), (((((r27 & 112) | 6) | (r27 & 896)) | (458752 & r27)) | (3670016 & r27)) | (r27 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
    L164:
        final float r28 = r16;
        final WindowInsets r29 = r20;
        final TopAppBarScrollBehavior r30 = r21;
        final Function2<? super Composer, ? super Integer, Unit> r31 = r10;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r32 = r11;
        final float r33 = r19;
        final TopAppBarColors r47 = r22;
    L166:
        ScopeUpdateScope r118 = r1.endRestartGroup();
        if (r118 == null) goto L170;
        r118.updateScope(new v0(r35, r5, r31, r32, r28, r33, r29, r47, r30, r45, r46));
        return;
    L170:
        return;
    L157:
        if (Dp.equals-impl0(r19, r117.getInfinity-D9Ej5fM()) == true) goto L160;
        r26 = r19;
        goto L161
    L150:
        if (Dp.equals-impl0(r16, r117.getInfinity-D9Ej5fM()) == true) goto L153;
        r25 = r16;
        goto L155
    L143:
        r22 = r110;
        r111 = r3;
    L117:
        r21 = r43;
        goto L144
    L140:
        r110 = r42;
        goto L141
    L136:
        r20 = r41;
        goto L138
    L132:
        r19 = r15;
        goto L134
    L129:
        r16 = r13;
        goto L130
    L126:
        r11 = r9;
        goto L127
    L123:
        r10 = r7;
        goto L124
    L120:
        r5 = r36;
        goto L121
    L108:
        if (r1.getDefaultsInvalid() == true) goto L118;
        r1.skipToGroupEnd();
        if ((r46 & 64) == 0) goto L114;
        r3 = r3 & (-3670017);
    L114:
        if ((r46 & 128) == 0) goto L116;
        r3 = r3 & (-29360129);
    L116:
        r5 = r36;
        r22 = r42;
        r111 = r3;
        r10 = r7;
        r11 = r9;
        r16 = r13;
        r19 = r15;
        r20 = r41;
        goto L117
    L165:
        r1.skipToGroupEnd();
        r5 = r36;
        r47 = r42;
        r31 = r7;
        r32 = r9;
        r28 = r13;
        r33 = r15;
        r29 = r41;
        r30 = r43;
        goto L166
    L102:
        r2 = false;
        goto L104
    L93:
        if ((r45 & 100663296) != 0) goto L100;
        if (r1.changed(r43) == false) goto L97;
        int r119 = 67108864;
    L98:
        r3 = r3 | r119;
        goto L100
    L97:
        r119 = 33554432;
        goto L98
    L61:
        if ((196608 & r45) != 0) goto L67;
        r15 = r40;
        if (r1.changed(r15) == false) goto L65;
        int r120 = 131072;
    L66:
        r3 = r3 | r120;
        goto L69
    L65:
        r120 = 65536;
        goto L66
    L50:
        if ((r45 & 24576) != 0) goto L56;
        r13 = r39;
        if (r1.changed(r13) == false) goto L54;
        int r121 = 16384;
    L55:
        r3 = r3 | r121;
        goto L57
    L54:
        r121 = 8192;
        goto L55
    L39:
        if ((r45 & 3072) != 0) goto L45;
        r9 = r38;
        if (r1.changedInstance(r9) == false) goto L43;
        int r122 = 2048;
    L44:
        r3 = r3 | r122;
        goto L46
    L43:
        r122 = 1024;
        goto L44
    L28:
        if ((r45 & 384) != 0) goto L34;
        r7 = r37;
        if (r1.changedInstance(r7) == false) goto L32;
        int r48 = 256;
    L33:
        r3 = r3 | r48;
        goto L35
    L32:
        r48 = 128;
        goto L33
    L17:
        if ((r45 & 48) != 0) goto L24;
        if (r1.changed(r36) == false) goto L21;
        int r49 = 32;
    L22:
        r3 = r3 | r49;
        goto L24
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r3 = r45;
        goto L13
    L8:
        if (r1.changedInstance(r35) == false) goto L10;
        int r50 = 4;
    L11:
        r3 = r50 | r45;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: MediumTopAppBar-oKE7A98, reason: not valid java name */
    public static final void m2312MediumTopAppBaroKE7A98(final Function2<? super Composer, ? super Integer, Unit> r35, Modifier r36, Function2<? super Composer, ? super Integer, Unit> r37, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r38, float r39, float r40, WindowInsets r41, TopAppBarColors r42, TopAppBarScrollBehavior r43, Composer r44, final int r45, final int r46) {
        Composer r1 = r44.startRestartGroup(-1378129383);
        if ((r46 & 1) == 0) goto L6;
        int r3 = r45 | 6;
    L13:
        int r4 = r46 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r46 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r7 = r37;
    L35:
        int r8 = r46 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r9 = r38;
    L46:
        int r12 = r46 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        float r13 = r39;
    L57:
        int r14 = r46 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        float r15 = r40;
    L69:
        if ((r45 & 1572864) != 0) goto L79;
        if ((r46 & 64) == 0) goto L73;
    L75:
        int r17 = 524288;
    L76:
        r3 = r3 | r17;
        goto L79
    L73:
        if (r1.changed(r41) == false) goto L75;
        r17 = 1048576;
    L79:
        if ((r45 & 12582912) != 0) goto L89;
        if ((r46 & 128) != 0) goto L86;
        if (r1.changed(r42) == false) goto L86;
        int r18 = 8388608;
    L87:
        r3 = r3 | r18;
    L86:
        r18 = 4194304;
    L89:
        int r0 = r46 & 256;
        if (r0 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r3 & 38347923) == 38347922) goto L102;
        boolean r2 = true;
    L104:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L165;
        r1.startDefaults();
        if ((r45 & 1) != 0) goto L108;
    L118:
        if (r4 == 0) goto L120;
        final Modifier r5 = Modifier.Companion;
    L121:
        if (r6 == 0) goto L123;
        Function2<? super Composer, ? super Integer, Unit> r10 = ComposableSingletons$AppBarKt.INSTANCE.m2521getLambda$229000834$material3();
    L124:
        if (r8 == 0) goto L126;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r11 = ComposableSingletons$AppBarKt.INSTANCE.m2514getLambda$1276513184$material3();
    L127:
        if (r12 == 0) goto L129;
        float r16 = TopAppBarDefaults.INSTANCE.m3582getMediumAppBarCollapsedHeightD9Ej5fM();
    L130:
        if (r14 == 0) goto L132;
        float r19 = TopAppBarDefaults.INSTANCE.m3583getMediumAppBarExpandedHeightD9Ej5fM();
    L134:
        if ((r46 & 64) == 0) goto L136;
        WindowInsets r20 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
        r3 = r3 & (-3670017);
    L138:
        if ((r46 & 128) == 0) goto L140;
        TopAppBarColors r110 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
        r3 = r3 & (-29360129);
    L141:
        if (r0 == 0) goto L143;
        int r34 = r3;
        TopAppBarScrollBehavior r21 = null;
        TopAppBarColors r22 = r110;
        int r111 = r34;
    L144:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventStart(-1378129383, r111, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:518)");
    L147:
        TextStyle r112 = TypographyKt.getValue(AppBarMediumTokens.INSTANCE.getTitleFont(), r1, 6);
        TextStyle r113 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), r1, 6);
        float r114 = MediumTitleBottomPadding;
        TextStyle.Companion r115 = TextStyle.Companion;
        TextStyle r116 = r115.getDefault();
        TextStyle r23 = r115.getDefault();
        Alignment.Horizontal r24 = Alignment.Companion.getStart();
        Dp.Companion r117 = Dp.Companion;
        if (Dp.equals-impl0(r16, r117.getUnspecified-D9Ej5fM()) == false) goto L150;
    L153:
        float r25 = TopAppBarDefaults.INSTANCE.m3582getMediumAppBarCollapsedHeightD9Ej5fM();
    L155:
        if (Dp.equals-impl0(r19, r117.getUnspecified-D9Ej5fM()) == false) goto L157;
    L160:
        float r26 = TopAppBarDefaults.INSTANCE.m3583getMediumAppBarExpandedHeightD9Ej5fM();
    L161:
        int r27 = r111 >> 3;
        m2318TwoRowsTopAppBarpJA5dT0(r5, r35, r112, r114, r35, r113, null, r116, null, r23, r24, r10, r11, r25, r26, r20, r22, r21, r1, (((r27 & 14) | 920128512) | ((r111 << 3) & 112)) | ((r111 << 12) & 57344), (((((r27 & 112) | 6) | (r27 & 896)) | (458752 & r27)) | (3670016 & r27)) | (r27 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
    L164:
        final float r28 = r16;
        final WindowInsets r29 = r20;
        final TopAppBarScrollBehavior r30 = r21;
        final Function2<? super Composer, ? super Integer, Unit> r31 = r10;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r32 = r11;
        final float r33 = r19;
        final TopAppBarColors r47 = r22;
    L166:
        ScopeUpdateScope r118 = r1.endRestartGroup();
        if (r118 == null) goto L170;
        r118.updateScope(new t(r35, r5, r31, r32, r28, r33, r29, r47, r30, r45, r46));
        return;
    L170:
        return;
    L157:
        if (Dp.equals-impl0(r19, r117.getInfinity-D9Ej5fM()) == true) goto L160;
        r26 = r19;
        goto L161
    L150:
        if (Dp.equals-impl0(r16, r117.getInfinity-D9Ej5fM()) == true) goto L153;
        r25 = r16;
        goto L155
    L143:
        r22 = r110;
        r111 = r3;
    L117:
        r21 = r43;
        goto L144
    L140:
        r110 = r42;
        goto L141
    L136:
        r20 = r41;
        goto L138
    L132:
        r19 = r15;
        goto L134
    L129:
        r16 = r13;
        goto L130
    L126:
        r11 = r9;
        goto L127
    L123:
        r10 = r7;
        goto L124
    L120:
        r5 = r36;
        goto L121
    L108:
        if (r1.getDefaultsInvalid() == true) goto L118;
        r1.skipToGroupEnd();
        if ((r46 & 64) == 0) goto L114;
        r3 = r3 & (-3670017);
    L114:
        if ((r46 & 128) == 0) goto L116;
        r3 = r3 & (-29360129);
    L116:
        r5 = r36;
        r22 = r42;
        r111 = r3;
        r10 = r7;
        r11 = r9;
        r16 = r13;
        r19 = r15;
        r20 = r41;
        goto L117
    L165:
        r1.skipToGroupEnd();
        r5 = r36;
        r47 = r42;
        r31 = r7;
        r32 = r9;
        r28 = r13;
        r33 = r15;
        r29 = r41;
        r30 = r43;
        goto L166
    L102:
        r2 = false;
        goto L104
    L93:
        if ((r45 & 100663296) != 0) goto L100;
        if (r1.changed(r43) == false) goto L97;
        int r119 = 67108864;
    L98:
        r3 = r3 | r119;
        goto L100
    L97:
        r119 = 33554432;
        goto L98
    L61:
        if ((196608 & r45) != 0) goto L67;
        r15 = r40;
        if (r1.changed(r15) == false) goto L65;
        int r120 = 131072;
    L66:
        r3 = r3 | r120;
        goto L69
    L65:
        r120 = 65536;
        goto L66
    L50:
        if ((r45 & 24576) != 0) goto L56;
        r13 = r39;
        if (r1.changed(r13) == false) goto L54;
        int r121 = 16384;
    L55:
        r3 = r3 | r121;
        goto L57
    L54:
        r121 = 8192;
        goto L55
    L39:
        if ((r45 & 3072) != 0) goto L45;
        r9 = r38;
        if (r1.changedInstance(r9) == false) goto L43;
        int r122 = 2048;
    L44:
        r3 = r3 | r122;
        goto L46
    L43:
        r122 = 1024;
        goto L44
    L28:
        if ((r45 & 384) != 0) goto L34;
        r7 = r37;
        if (r1.changedInstance(r7) == false) goto L32;
        int r48 = 256;
    L33:
        r3 = r3 | r48;
        goto L35
    L32:
        r48 = 128;
        goto L33
    L17:
        if ((r45 & 48) != 0) goto L24;
        if (r1.changed(r36) == false) goto L21;
        int r49 = 32;
    L22:
        r3 = r3 | r49;
        goto L24
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r3 = r45;
        goto L13
    L8:
        if (r1.changedInstance(r35) == false) goto L10;
        int r50 = 4;
    L11:
        r3 = r50 | r45;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: BottomAppBarLayout-t5fmz9U, reason: not valid java name */
    private static final void m2306BottomAppBarLayoutt5fmz9U(final float r31, final Arrangement.Horizontal r32, Modifier r33, final long r34, final long r36, final float r38, final PaddingValues r39, final WindowInsets r40, final BottomAppBarScrollBehavior r41, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r42, Composer r43, final int r44, final int r45) {
        Composer r1 = r43.startRestartGroup(-141162176);
        if ((r45 & 1) == 0) goto L6;
        int r3 = r44 | 6;
    L14:
        if ((r45 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L23:
        int r4 = r45 & 4;
        if (r4 == 0) goto L27;
        r3 = r3 | 384;
    L35:
        if ((r45 & 8) == 0) goto L38;
        r3 = r3 | 3072;
    L45:
        if ((r45 & 16) == 0) goto L48;
        r3 = r3 | 24576;
    L55:
        if ((r45 & 32) == 0) goto L58;
        r3 = r3 | 196608;
    L65:
        if ((r45 & 64) == 0) goto L68;
        r3 = r3 | 1572864;
    L75:
        if ((r45 & 128) == 0) goto L78;
        r3 = r3 | 12582912;
    L86:
        if ((r45 & 256) == 0) goto L89;
        r3 = r3 | 100663296;
    L97:
        if ((r45 & 512) == 0) goto L100;
        r3 = r3 | 805306368;
    L108:
        if ((r3 & 306783379) == 306783378) goto L110;
        boolean r0 = true;
    L112:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L147;
        if (r4 == 0) goto L115;
        Modifier r2 = Modifier.Companion;
    L117:
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventStart(-141162176, r3, -1, "androidx.compose.material3.BottomAppBarLayout (AppBar.kt:1330)");
    L120:
        if (BottomAppBarLayout_t5fmz9U$lambda$17(rememberTouchExplorationService(r1, 0)) == true) goto L122;
        final BottomAppBarScrollBehavior r5 = r41;
    L123:
        if (r5 != null) goto L125;
    L137:
        r1.startReplaceGroup(-587975934);
        r1.endReplaceGroup();
        Modifier r6 = Modifier.Companion;
    L138:
        int r46 = r3;
        Shape r17 = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), r1, 6);
        boolean r7 = r1.changed(r5);
        Object r8 = r1.rememberedValue();
        if (r7 == false) goto L141;
    L142:
        r8 = new a1(r5);
        r1.updateRememberedValue(r8);
    L143:
        Modifier r28 = r2;
        int r9 = r46 >> 3;
        SurfaceKt.m3213SurfaceT9BRK9s(LayoutModifierKt.layout(r2, (Function3) r8).then(r6), r17, r34, r36, r38, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(1054101083, true, new AppBarKt$BottomAppBarLayout$2(r40, r31, r39, r32, r42), r1, 54), r1, (((r9 & 896) | 12582912) | (r9 & 7168)) | (r9 & 57344), 96);
        if (ComposerKt.isTraceInProgress() == false) goto L146;
        ComposerKt.traceEventEnd();
    L146:
        final Modifier r10 = r28;
    L148:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L152;
        r15.updateScope(new b1(r31, r32, r10, r34, r36, r38, r39, r40, r41, r42, r44, r45));
        return;
    L152:
        return;
    L141:
        if (r8 != Composer.Companion.getEmpty()) goto L143;
    L125:
        if (r5.isPinned() == true) goto L137;
        r1.startReplaceGroup(-588583503);
        Modifier.Companion r19 = Modifier.Companion;
        Orientation r21 = Orientation.Vertical;
        boolean r11 = r1.changed(r5);
        Object r12 = r1.rememberedValue();
        if (r11 == false) goto L129;
    L130:
        r12 = new z0(r5);
        r1.updateRememberedValue(r12);
    L131:
        DraggableState r20 = DraggableKt.rememberDraggableState((Function1) r12, r1, 0);
        boolean r13 = r1.changed(r5);
        Object r14 = r1.rememberedValue();
        if (r13 == false) goto L134;
    L135:
        r14 = new AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1(r5, null);
        r1.updateRememberedValue(r14);
    L136:
        r6 = DraggableKt.draggable$default(r19, r20, r21, false, null, false, null, (Function3) r14, false, 188, null);
        r1.endReplaceGroup();
        goto L138
    L134:
        if (r14 != Composer.Companion.getEmpty()) goto L136;
    L129:
        if (r12 != Composer.Companion.getEmpty()) goto L131;
    L122:
        r5 = null;
        goto L123
    L115:
        r2 = r33;
        goto L117
    L147:
        r1.skipToGroupEnd();
        r10 = r33;
        goto L148
    L110:
        r0 = false;
        goto L112
    L100:
        if ((r44 & 805306368) != 0) goto L108;
        if (r1.changedInstance(r42) == false) goto L104;
        int r18 = 536870912;
    L105:
        r3 = r3 | r18;
        goto L108
    L104:
        r18 = 268435456;
        goto L105
    L89:
        if ((r44 & 100663296) != 0) goto L97;
        if (r1.changed(r41) == false) goto L93;
        int r110 = 67108864;
    L94:
        r3 = r3 | r110;
        goto L97
    L93:
        r110 = 33554432;
        goto L94
    L78:
        if ((r44 & 12582912) != 0) goto L86;
        if (r1.changed(r40) == false) goto L82;
        int r111 = 8388608;
    L83:
        r3 = r3 | r111;
        goto L86
    L82:
        r111 = 4194304;
        goto L83
    L68:
        if ((r44 & 1572864) != 0) goto L75;
        if (r1.changed(r39) == false) goto L72;
        int r16 = 1048576;
    L73:
        r3 = r3 | r16;
        goto L75
    L72:
        r16 = 524288;
        goto L73
    L58:
        if ((r44 & 196608) != 0) goto L65;
        if (r1.changed(r38) == false) goto L62;
        int r22 = 131072;
    L63:
        r3 = r3 | r22;
        goto L65
    L62:
        r22 = 65536;
        goto L63
    L48:
        if ((r44 & 24576) != 0) goto L55;
        if (r1.changed(r36) == false) goto L52;
        int r23 = 16384;
    L53:
        r3 = r3 | r23;
        goto L55
    L52:
        r23 = 8192;
        goto L53
    L38:
        if ((r44 & 3072) != 0) goto L45;
        if (r1.changed(r34) == false) goto L42;
        int r24 = 2048;
    L43:
        r3 = r3 | r24;
        goto L45
    L42:
        r24 = 1024;
        goto L43
    L27:
        if ((r44 & 384) != 0) goto L35;
        if (r1.changed(r33) == false) goto L31;
        int r25 = 256;
    L32:
        r3 = r3 | r25;
        goto L35
    L31:
        r25 = 128;
        goto L32
    L17:
        if ((r44 & 48) != 0) goto L23;
        if (r1.changed(r32) == false) goto L21;
        int r26 = 32;
    L22:
        r3 = r3 | r26;
        goto L23
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r44 & 6) == 0) goto L8;
        r3 = r44;
        goto L14
    L8:
        if (r1.changed(r31) == false) goto L10;
        int r27 = 4;
    L11:
        r3 = r27 | r44;
        goto L14
    L10:
        r27 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TopAppBar-cJHQLPU, reason: not valid java name */
    public static final void m2315TopAppBarcJHQLPU(final Function2<? super Composer, ? super Integer, Unit> r29, final Function2<? super Composer, ? super Integer, Unit> r30, Modifier r31, Function2<? super Composer, ? super Integer, Unit> r32, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r33, Alignment.Horizontal r34, float r35, WindowInsets r36, TopAppBarColors r37, TopAppBarScrollBehavior r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(1954772493);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r41 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r31;
    L35:
        int r7 = r41 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function2<? super Composer, ? super Integer, Unit> r8 = r32;
    L46:
        int r9 = r41 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r10 = r33;
    L57:
        int r13 = r41 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Alignment.Horizontal r14 = r34;
    L68:
        int r15 = r41 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r40 & 12582912) != 0) goto L90;
        if ((r41 & 128) != 0) goto L86;
        if (r1.changed(r36) == false) goto L86;
        int r17 = 8388608;
    L87:
        r3 = r3 | r17;
    L86:
        r17 = 4194304;
    L90:
        if ((r40 & 100663296) != 0) goto L100;
        if ((r41 & 256) != 0) goto L97;
        if (r1.changed(r37) == false) goto L97;
        int r18 = 67108864;
    L98:
        r3 = r3 | r18;
    L97:
        r18 = 33554432;
    L100:
        int r0 = r41 & 512;
        if (r0 == 0) goto L104;
        r3 = r3 | 805306368;
    L111:
        if ((r3 & 306783379) == 306783378) goto L113;
        boolean r2 = true;
    L115:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L164;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L119;
    L129:
        if (r5 == 0) goto L131;
        r6 = Modifier.Companion;
    L131:
        if (r7 == 0) goto L133;
        r8 = ComposableSingletons$AppBarKt.INSTANCE.m2511getLambda$1168245838$material3();
    L133:
        if (r9 == 0) goto L135;
        r10 = ComposableSingletons$AppBarKt.INSTANCE.m2515getLambda$1401945836$material3();
    L135:
        if (r13 == 0) goto L137;
        r14 = Alignment.Companion.getStart();
    L137:
        if (r15 == 0) goto L139;
        float r4 = TopAppBarDefaults.INSTANCE.m3586getTopAppBarExpandedHeightD9Ej5fM();
    L141:
        if ((r41 & 128) == 0) goto L143;
        WindowInsets r11 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
        r3 = r3 & (-29360129);
    L145:
        if ((r41 & 256) == 0) goto L147;
        TopAppBarColors r12 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
        r3 = r3 & (-234881025);
    L148:
        if (r0 != 0) goto L149;
    L128:
        int r16 = r3;
        Alignment.Horizontal r19 = r14;
        TopAppBarScrollBehavior r20 = r38;
    L150:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventStart(1954772493, r16, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:383)");
    L153:
        AppBarSmallTokens r110 = AppBarSmallTokens.INSTANCE;
        TextStyle r111 = TypographyKt.getValue(r110.getTitleFont(), r1, 6);
        TextStyle r112 = TypographyKt.getValue(r110.getSubtitleFont(), r1, 6);
        Dp.Companion r21 = Dp.Companion;
        if (Dp.equals-impl0(r4, r21.getUnspecified-D9Ej5fM()) == false) goto L156;
    L159:
        float r22 = TopAppBarDefaults.INSTANCE.m3586getTopAppBarExpandedHeightD9Ej5fM();
    L160:
        int r113 = r16 << 6;
        int r114 = r16 << 9;
        int r26 = (((((((r16 >> 6) & 14) | ((r16 << 3) & 112)) | (r113 & 7168)) | (458752 & r16)) | (r114 & 3670016)) | (r114 & 29360128)) | (r113 & 1879048192);
        int r23 = r16 >> 24;
        m2313SingleRowTopAppBarwn8IZOc(r6, r29, r111, r30, r112, r19, r8, r10, r22, r11, r12, r20, r1, r26, (r23 & 14) | (r23 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L163;
        ComposerKt.traceEventEnd();
    L163:
        final TopAppBarColors r24 = r12;
        final Function2<? super Composer, ? super Integer, Unit> r25 = r8;
        final float r27 = r4;
        final WindowInsets r28 = r11;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r42 = r10;
        final TopAppBarScrollBehavior r115 = r20;
        final Modifier r43 = r6;
        final Alignment.Horizontal r44 = r19;
    L165:
        ScopeUpdateScope r116 = r1.endRestartGroup();
        if (r116 == null) goto L169;
        r116.updateScope(new e0(r29, r30, r43, r25, r42, r44, r27, r28, r24, r115, r40, r41));
        return;
    L169:
        return;
    L156:
        if (Dp.equals-impl0(r4, r21.getInfinity-D9Ej5fM()) == true) goto L159;
        r22 = r4;
        goto L160
    L149:
        r16 = r3;
        r20 = null;
        r19 = r14;
        goto L150
    L147:
        r12 = r37;
        goto L148
    L143:
        r11 = r36;
        goto L145
    L139:
        r4 = r35;
        goto L141
    L119:
        if (r1.getDefaultsInvalid() == true) goto L129;
        r1.skipToGroupEnd();
        if ((r41 & 128) == 0) goto L125;
        r3 = r3 & (-29360129);
    L125:
        if ((r41 & 256) == 0) goto L127;
        r3 = r3 & (-234881025);
    L127:
        r4 = r35;
        r11 = r36;
        r12 = r37;
        goto L128
    L164:
        r1.skipToGroupEnd();
        r27 = r35;
        r24 = r37;
        r43 = r6;
        r25 = r8;
        r42 = r10;
        r44 = r14;
        r28 = r36;
        r115 = r38;
        goto L165
    L113:
        r2 = false;
        goto L115
    L104:
        if ((r40 & 805306368) != 0) goto L111;
        if (r1.changed(r38) == false) goto L108;
        int r117 = 536870912;
    L109:
        r3 = r3 | r117;
        goto L111
    L108:
        r117 = 268435456;
        goto L109
    L72:
        if ((r40 & 1572864) != 0) goto L79;
        if (r1.changed(r35) == false) goto L76;
        int r118 = 1048576;
    L77:
        r3 = r3 | r118;
        goto L79
    L76:
        r118 = 524288;
        goto L77
    L61:
        if ((196608 & r40) != 0) goto L67;
        r14 = r34;
        if (r1.changed(r14) == false) goto L65;
        int r119 = 131072;
    L66:
        r3 = r3 | r119;
        goto L68
    L65:
        r119 = 65536;
        goto L66
    L50:
        if ((r40 & 24576) != 0) goto L56;
        r10 = r33;
        if (r1.changedInstance(r10) == false) goto L54;
        int r120 = 16384;
    L55:
        r3 = r3 | r120;
        goto L57
    L54:
        r120 = 8192;
        goto L55
    L39:
        if ((r40 & 3072) != 0) goto L45;
        r8 = r32;
        if (r1.changedInstance(r8) == false) goto L43;
        int r45 = 2048;
    L44:
        r3 = r3 | r45;
        goto L46
    L43:
        r45 = 1024;
        goto L44
    L28:
        if ((r40 & 384) != 0) goto L34;
        r6 = r31;
        if (r1.changed(r6) == false) goto L32;
        int r46 = 256;
    L33:
        r3 = r3 | r46;
        goto L35
    L32:
        r46 = 128;
        goto L33
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r1.changedInstance(r30) == false) goto L21;
        int r47 = 32;
    L22:
        r3 = r3 | r47;
        goto L24
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L14
    L8:
        if (r1.changedInstance(r29) == false) goto L10;
        int r48 = 4;
    L11:
        r3 = r48 | r40;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LargeFlexibleTopAppBar-eXZ4JBQ, reason: not valid java name */
    public static final void m2309LargeFlexibleTopAppBareXZ4JBQ(final Function2<? super Composer, ? super Integer, Unit> r39, Modifier r40, Function2<? super Composer, ? super Integer, Unit> r41, Function2<? super Composer, ? super Integer, Unit> r42, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r43, Alignment.Horizontal r44, float r45, float r46, WindowInsets r47, TopAppBarColors r48, TopAppBarScrollBehavior r49, Composer r50, final int r51, final int r52, final int r53) {
        Composer r1 = r50.startRestartGroup(1104319839);
        if ((r53 & 1) == 0) goto L6;
        int r5 = r51 | 6;
    L13:
        int r6 = r53 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L23:
        Modifier r7 = r40;
    L24:
        int r8 = r53 & 4;
        if (r8 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r9 = r41;
    L35:
        int r10 = r53 & 8;
        if (r10 == 0) goto L39;
        r5 = r5 | 3072;
    L45:
        Function2<? super Composer, ? super Integer, Unit> r11 = r42;
    L46:
        int r13 = r53 & 16;
        if (r13 == 0) goto L50;
        r5 = r5 | 24576;
    L56:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r15 = r43;
    L57:
        int r16 = r53 & 32;
        if (r16 == 0) goto L61;
        r5 = r5 | 196608;
    L67:
        int r17 = r53 & 64;
        if (r17 == 0) goto L71;
        r5 = r5 | 1572864;
    L78:
        if ((r51 & 12582912) != 0) goto L89;
        if ((r53 & 128) != 0) goto L85;
        if (r1.changed(r46) == false) goto L85;
        int r20 = 8388608;
    L86:
        r5 = r5 | r20;
    L85:
        r20 = 4194304;
    L89:
        if ((r51 & 100663296) != 0) goto L100;
        if ((r53 & 256) != 0) goto L96;
        if (r1.changed(r47) == false) goto L96;
        int r21 = 67108864;
    L97:
        r5 = r5 | r21;
    L96:
        r21 = 33554432;
    L100:
        if ((r51 & 805306368) != 0) goto L110;
        if ((r53 & 512) != 0) goto L107;
        if (r1.changed(r48) == false) goto L107;
        int r22 = 536870912;
    L108:
        r5 = r5 | r22;
    L107:
        r22 = 268435456;
    L110:
        int r0 = r53 & 1024;
        if (r0 == 0) goto L115;
        int r23 = r52 | 6;
    L113:
        int r2 = r23;
    L123:
        if ((r5 & 306783379) == 306783378) goto L125;
    L128:
        boolean r3 = true;
    L130:
        if (r1.shouldExecute(r3, r5 & 1) == false) goto L214;
        r1.startDefaults();
        if ((r51 & 1) != 0) goto L134;
    L147:
        if (r6 == 0) goto L149;
        Modifier r4 = Modifier.Companion;
    L150:
        if (r8 == 0) goto L152;
        r9 = null;
    L152:
        if (r10 == 0) goto L154;
        Function2<? super Composer, ? super Integer, Unit> r12 = ComposableSingletons$AppBarKt.INSTANCE.m2527getLambda$780193532$material3();
    L155:
        if (r13 == 0) goto L157;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r14 = ComposableSingletons$AppBarKt.INSTANCE.m2517getLambda$1846660506$material3();
    L158:
        if (r16 == 0) goto L160;
        Alignment.Horizontal r18 = Alignment.Companion.getStart();
    L161:
        if (r17 == 0) goto L163;
        float r19 = TopAppBarDefaults.INSTANCE.m3578getLargeAppBarCollapsedHeightD9Ej5fM();
    L165:
        if ((r53 & 128) == 0) goto L170;
        if (r9 == null) goto L168;
        float r110 = TopAppBarDefaults.INSTANCE.m3580getLargeFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
    L169:
        r5 = r5 & (-29360129);
    L172:
        if ((r53 & 256) == 0) goto L174;
        WindowInsets r111 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
        r5 = r5 & (-234881025);
    L176:
        if ((r53 & 512) == 0) goto L178;
        TopAppBarColors r24 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
        r5 = r5 & (-1879048193);
    L179:
        if (r0 == 0) goto L181;
        WindowInsets r25 = r111;
        int r112 = r5;
        TopAppBarScrollBehavior r26 = null;
    L182:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventStart(1104319839, r112, r2, "androidx.compose.material3.LargeFlexibleTopAppBar (AppBar.kt:858)");
    L185:
        AppBarLargeFlexibleTokens r27 = AppBarLargeFlexibleTokens.INSTANCE;
        TextStyle r113 = TypographyKt.getValue(r27.getTitleFont(), r1, 6);
        AppBarSmallTokens r114 = AppBarSmallTokens.INSTANCE;
        TopAppBarScrollBehavior r410 = r26;
        TextStyle r28 = TypographyKt.getValue(r114.getTitleFont(), r1, 6);
        float r115 = LargeTitleBottomPadding;
        if (r9 != null) goto L188;
        Function2<? super Composer, ? super Integer, Unit> r29 = ComposableSingletons$AppBarKt.INSTANCE.m2525getLambda$661145402$material3();
    L189:
        TextStyle r210 = TypographyKt.getValue(r27.getSubtitleFont(), r1, 6);
        if (r9 != null) goto L192;
        Function2<? super Composer, ? super Integer, Unit> r211 = ComposableSingletons$AppBarKt.INSTANCE.m2510getLambda$1113422563$material3();
    L193:
        TextStyle r212 = TypographyKt.getValue(r114.getSubtitleFont(), r1, 6);
        Dp.Companion r30 = Dp.Companion;
        if (Dp.equals-impl0(r19, r30.getUnspecified-D9Ej5fM()) == false) goto L196;
    L199:
        float r213 = TopAppBarDefaults.INSTANCE.m3578getLargeAppBarCollapsedHeightD9Ej5fM();
    L201:
        if (Dp.equals-impl0(r110, r30.getUnspecified-D9Ej5fM()) == false) goto L203;
    L206:
        if (r9 == null) goto L208;
        float r31 = TopAppBarDefaults.INSTANCE.m3580getLargeFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
    L209:
        float r214 = r31;
    L210:
        int r34 = ((((r112 >> 3) & 14) | 3072) | ((r112 << 3) & 112)) | ((r112 << 12) & 57344);
        int r32 = r112 >> 6;
        int r33 = (((r112 >> 15) & 14) | (r32 & 112)) | (r32 & 896);
        int r35 = r112 >> 9;
        Modifier r116 = r4;
        Alignment.Horizontal r215 = r18;
        Function2<? super Composer, ? super Integer, Unit> r216 = r12;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r217 = r14;
        WindowInsets r36 = r25;
        TopAppBarColors r37 = r24;
        m2318TwoRowsTopAppBarpJA5dT0(r116, r39, r113, r115, r39, r28, r29, r210, r211, r212, r215, r216, r217, r213, r214, r36, r37, r410, r1, r34, ((r33 | (458752 & r35)) | (r35 & 3670016)) | ((r2 << 21) & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L213;
        ComposerKt.traceEventEnd();
    L213:
        final Modifier r38 = r4;
        final Function2<? super Composer, ? super Integer, Unit> r54 = r12;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r55 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r56 = r9;
        final float r57 = r19;
        final float r58 = r110;
        final TopAppBarScrollBehavior r117 = r410;
        final WindowInsets r59 = r25;
        Alignment.Horizontal r310 = r18;
        final TopAppBarColors r118 = r24;
        final Alignment.Horizontal r60 = r310;
    L215:
        ScopeUpdateScope r119 = r1.endRestartGroup();
        if (r119 == null) goto L219;
        r119.updateScope(new f0(r39, r38, r56, r54, r55, r60, r57, r58, r59, r118, r117, r51, r52, r53));
        return;
    L219:
        return;
    L208:
        r31 = TopAppBarDefaults.INSTANCE.m3581getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
        goto L209
    L203:
        if (Dp.equals-impl0(r110, r30.getInfinity-D9Ej5fM()) == true) goto L206;
        r214 = r110;
        goto L210
    L196:
        if (Dp.equals-impl0(r19, r30.getInfinity-D9Ej5fM()) == true) goto L199;
        r213 = r19;
        goto L201
    L192:
        r211 = r9;
        goto L193
    L188:
        r29 = r9;
        goto L189
    L181:
        r25 = r111;
    L146:
        r112 = r5;
        r26 = r49;
        goto L182
    L178:
        r24 = r48;
        goto L179
    L174:
        r111 = r47;
        goto L176
    L168:
        r110 = TopAppBarDefaults.INSTANCE.m3581getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
        goto L169
    L170:
        r110 = r46;
        goto L172
    L163:
        r19 = r45;
        goto L165
    L160:
        r18 = r44;
        goto L161
    L157:
        r14 = r15;
        goto L158
    L154:
        r12 = r11;
        goto L155
    L149:
        r4 = r7;
        goto L150
    L134:
        if (r1.getDefaultsInvalid() == true) goto L147;
        r1.skipToGroupEnd();
        if ((r53 & 128) == 0) goto L140;
        r5 = r5 & (-29360129);
    L140:
        if ((r53 & 256) == 0) goto L143;
        r5 = r5 & (-234881025);
    L143:
        if ((r53 & 512) == 0) goto L145;
        r5 = r5 & (-1879048193);
    L145:
        r18 = r44;
        r110 = r46;
        r25 = r47;
        r24 = r48;
        r4 = r7;
        r12 = r11;
        r14 = r15;
        r19 = r45;
        goto L146
    L214:
        r1.skipToGroupEnd();
        r60 = r44;
        r58 = r46;
        r118 = r48;
        r38 = r7;
        r56 = r9;
        r54 = r11;
        r55 = r15;
        r57 = r45;
        r59 = r47;
        r117 = r49;
        goto L215
    L125:
        if ((r2 & 3) != 2) goto L128;
        r3 = false;
        goto L130
    L115:
        if ((r52 & 6) == 0) goto L117;
        r2 = r52;
        goto L123
    L117:
        if (r1.changed(r49) == false) goto L119;
        int r218 = 4;
    L120:
        r23 = r52 | r218;
        goto L113
    L119:
        r218 = 2;
        goto L120
    L71:
        if ((r51 & 1572864) != 0) goto L78;
        if (r1.changed(r45) == false) goto L75;
        int r120 = 1048576;
    L76:
        r5 = r5 | r120;
        goto L78
    L75:
        r120 = 524288;
        goto L76
    L61:
        if ((r51 & 196608) != 0) goto L67;
        if (r1.changed(r44) == false) goto L65;
        int r121 = 131072;
    L66:
        r5 = r5 | r121;
        goto L67
    L65:
        r121 = 65536;
        goto L66
    L50:
        if ((r51 & 24576) != 0) goto L56;
        r15 = r43;
        if (r1.changedInstance(r15) == false) goto L54;
        int r122 = 16384;
    L55:
        r5 = r5 | r122;
        goto L57
    L54:
        r122 = 8192;
        goto L55
    L39:
        if ((r51 & 3072) != 0) goto L45;
        r11 = r42;
        if (r1.changedInstance(r11) == false) goto L43;
        int r123 = 2048;
    L44:
        r5 = r5 | r123;
        goto L46
    L43:
        r123 = 1024;
        goto L44
    L28:
        if ((r51 & 384) != 0) goto L34;
        r9 = r41;
        if (r1.changedInstance(r9) == false) goto L32;
        int r124 = 256;
    L33:
        r5 = r5 | r124;
        goto L35
    L32:
        r124 = 128;
        goto L33
    L17:
        if ((r51 & 48) != 0) goto L23;
        r7 = r40;
        if (r1.changed(r7) == false) goto L21;
        int r61 = 32;
    L22:
        r5 = r5 | r61;
        goto L24
    L21:
        r61 = 16;
        goto L22
    L6:
        if ((r51 & 6) == 0) goto L8;
        r5 = r51;
        goto L13
    L8:
        if (r1.changedInstance(r39) == false) goto L10;
        int r62 = 4;
    L11:
        r5 = r62 | r51;
        goto L13
    L10:
        r62 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: MediumFlexibleTopAppBar-eXZ4JBQ, reason: not valid java name */
    public static final void m2311MediumFlexibleTopAppBareXZ4JBQ(final Function2<? super Composer, ? super Integer, Unit> r39, Modifier r40, Function2<? super Composer, ? super Integer, Unit> r41, Function2<? super Composer, ? super Integer, Unit> r42, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r43, Alignment.Horizontal r44, float r45, float r46, WindowInsets r47, TopAppBarColors r48, TopAppBarScrollBehavior r49, Composer r50, final int r51, final int r52, final int r53) {
        Composer r1 = r50.startRestartGroup(-1895470263);
        if ((r53 & 1) == 0) goto L6;
        int r5 = r51 | 6;
    L13:
        int r6 = r53 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L23:
        Modifier r7 = r40;
    L24:
        int r8 = r53 & 4;
        if (r8 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r9 = r41;
    L35:
        int r10 = r53 & 8;
        if (r10 == 0) goto L39;
        r5 = r5 | 3072;
    L45:
        Function2<? super Composer, ? super Integer, Unit> r11 = r42;
    L46:
        int r13 = r53 & 16;
        if (r13 == 0) goto L50;
        r5 = r5 | 24576;
    L56:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r15 = r43;
    L57:
        int r16 = r53 & 32;
        if (r16 == 0) goto L61;
        r5 = r5 | 196608;
    L67:
        int r17 = r53 & 64;
        if (r17 == 0) goto L71;
        r5 = r5 | 1572864;
    L78:
        if ((r51 & 12582912) != 0) goto L89;
        if ((r53 & 128) != 0) goto L85;
        if (r1.changed(r46) == false) goto L85;
        int r20 = 8388608;
    L86:
        r5 = r5 | r20;
    L85:
        r20 = 4194304;
    L89:
        if ((r51 & 100663296) != 0) goto L100;
        if ((r53 & 256) != 0) goto L96;
        if (r1.changed(r47) == false) goto L96;
        int r21 = 67108864;
    L97:
        r5 = r5 | r21;
    L96:
        r21 = 33554432;
    L100:
        if ((r51 & 805306368) != 0) goto L110;
        if ((r53 & 512) != 0) goto L107;
        if (r1.changed(r48) == false) goto L107;
        int r22 = 536870912;
    L108:
        r5 = r5 | r22;
    L107:
        r22 = 268435456;
    L110:
        int r0 = r53 & 1024;
        if (r0 == 0) goto L115;
        int r23 = r52 | 6;
    L113:
        int r2 = r23;
    L123:
        if ((r5 & 306783379) == 306783378) goto L125;
    L128:
        boolean r3 = true;
    L130:
        if (r1.shouldExecute(r3, r5 & 1) == false) goto L214;
        r1.startDefaults();
        if ((r51 & 1) != 0) goto L134;
    L147:
        if (r6 == 0) goto L149;
        Modifier r4 = Modifier.Companion;
    L150:
        if (r8 == 0) goto L152;
        r9 = null;
    L152:
        if (r10 == 0) goto L154;
        Function2<? super Composer, ? super Integer, Unit> r12 = ComposableSingletons$AppBarKt.INSTANCE.m2518getLambda$185842620$material3();
    L155:
        if (r13 == 0) goto L157;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r14 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1113419554$material3();
    L158:
        if (r16 == 0) goto L160;
        Alignment.Horizontal r18 = Alignment.Companion.getStart();
    L161:
        if (r17 == 0) goto L163;
        float r19 = TopAppBarDefaults.INSTANCE.m3582getMediumAppBarCollapsedHeightD9Ej5fM();
    L165:
        if ((r53 & 128) == 0) goto L170;
        if (r9 == null) goto L168;
        float r110 = TopAppBarDefaults.INSTANCE.m3584getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
    L169:
        r5 = r5 & (-29360129);
    L172:
        if ((r53 & 256) == 0) goto L174;
        WindowInsets r111 = TopAppBarDefaults.INSTANCE.getWindowInsets(r1, 6);
        r5 = r5 & (-234881025);
    L176:
        if ((r53 & 512) == 0) goto L178;
        TopAppBarColors r24 = TopAppBarDefaults.INSTANCE.topAppBarColors(r1, 6);
        r5 = r5 & (-1879048193);
    L179:
        if (r0 == 0) goto L181;
        WindowInsets r25 = r111;
        int r112 = r5;
        TopAppBarScrollBehavior r26 = null;
    L182:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventStart(-1895470263, r112, r2, "androidx.compose.material3.MediumFlexibleTopAppBar (AppBar.kt:613)");
    L185:
        AppBarMediumFlexibleTokens r27 = AppBarMediumFlexibleTokens.INSTANCE;
        TextStyle r113 = TypographyKt.getValue(r27.getTitleFont(), r1, 6);
        AppBarSmallTokens r114 = AppBarSmallTokens.INSTANCE;
        TopAppBarScrollBehavior r410 = r26;
        TextStyle r28 = TypographyKt.getValue(r114.getTitleFont(), r1, 6);
        float r115 = MediumTitleBottomPadding;
        if (r9 != null) goto L188;
        Function2<? super Composer, ? super Integer, Unit> r29 = ComposableSingletons$AppBarKt.INSTANCE.m2528getLambda$790317886$material3();
    L189:
        TextStyle r210 = TypographyKt.getValue(r27.getSubtitleFont(), r1, 6);
        if (r9 != null) goto L192;
        Function2<? super Composer, ? super Integer, Unit> r211 = ComposableSingletons$AppBarKt.INSTANCE.m2519getLambda$1926007989$material3();
    L193:
        TextStyle r212 = TypographyKt.getValue(r114.getSubtitleFont(), r1, 6);
        Dp.Companion r30 = Dp.Companion;
        if (Dp.equals-impl0(r19, r30.getUnspecified-D9Ej5fM()) == false) goto L196;
    L199:
        float r213 = TopAppBarDefaults.INSTANCE.m3582getMediumAppBarCollapsedHeightD9Ej5fM();
    L201:
        if (Dp.equals-impl0(r110, r30.getUnspecified-D9Ej5fM()) == false) goto L203;
    L206:
        if (r9 == null) goto L208;
        float r31 = TopAppBarDefaults.INSTANCE.m3584getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
    L209:
        float r214 = r31;
    L210:
        int r34 = ((((r112 >> 3) & 14) | 3072) | ((r112 << 3) & 112)) | ((r112 << 12) & 57344);
        int r32 = r112 >> 6;
        int r33 = (((r112 >> 15) & 14) | (r32 & 112)) | (r32 & 896);
        int r35 = r112 >> 9;
        Modifier r116 = r4;
        Alignment.Horizontal r215 = r18;
        Function2<? super Composer, ? super Integer, Unit> r216 = r12;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r217 = r14;
        WindowInsets r36 = r25;
        TopAppBarColors r37 = r24;
        m2318TwoRowsTopAppBarpJA5dT0(r116, r39, r113, r115, r39, r28, r29, r210, r211, r212, r215, r216, r217, r213, r214, r36, r37, r410, r1, r34, ((r33 | (458752 & r35)) | (r35 & 3670016)) | ((r2 << 21) & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L213;
        ComposerKt.traceEventEnd();
    L213:
        final Modifier r38 = r4;
        final Function2<? super Composer, ? super Integer, Unit> r54 = r12;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r55 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r56 = r9;
        final float r57 = r19;
        final float r58 = r110;
        final TopAppBarScrollBehavior r117 = r410;
        final WindowInsets r59 = r25;
        Alignment.Horizontal r310 = r18;
        final TopAppBarColors r118 = r24;
        final Alignment.Horizontal r60 = r310;
    L215:
        ScopeUpdateScope r119 = r1.endRestartGroup();
        if (r119 == null) goto L219;
        r119.updateScope(new s(r39, r38, r56, r54, r55, r60, r57, r58, r59, r118, r117, r51, r52, r53));
        return;
    L219:
        return;
    L208:
        r31 = TopAppBarDefaults.INSTANCE.m3585getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
        goto L209
    L203:
        if (Dp.equals-impl0(r110, r30.getInfinity-D9Ej5fM()) == true) goto L206;
        r214 = r110;
        goto L210
    L196:
        if (Dp.equals-impl0(r19, r30.getInfinity-D9Ej5fM()) == true) goto L199;
        r213 = r19;
        goto L201
    L192:
        r211 = r9;
        goto L193
    L188:
        r29 = r9;
        goto L189
    L181:
        r25 = r111;
    L146:
        r112 = r5;
        r26 = r49;
        goto L182
    L178:
        r24 = r48;
        goto L179
    L174:
        r111 = r47;
        goto L176
    L168:
        r110 = TopAppBarDefaults.INSTANCE.m3585getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
        goto L169
    L170:
        r110 = r46;
        goto L172
    L163:
        r19 = r45;
        goto L165
    L160:
        r18 = r44;
        goto L161
    L157:
        r14 = r15;
        goto L158
    L154:
        r12 = r11;
        goto L155
    L149:
        r4 = r7;
        goto L150
    L134:
        if (r1.getDefaultsInvalid() == true) goto L147;
        r1.skipToGroupEnd();
        if ((r53 & 128) == 0) goto L140;
        r5 = r5 & (-29360129);
    L140:
        if ((r53 & 256) == 0) goto L143;
        r5 = r5 & (-234881025);
    L143:
        if ((r53 & 512) == 0) goto L145;
        r5 = r5 & (-1879048193);
    L145:
        r18 = r44;
        r110 = r46;
        r25 = r47;
        r24 = r48;
        r4 = r7;
        r12 = r11;
        r14 = r15;
        r19 = r45;
        goto L146
    L214:
        r1.skipToGroupEnd();
        r60 = r44;
        r58 = r46;
        r118 = r48;
        r38 = r7;
        r56 = r9;
        r54 = r11;
        r55 = r15;
        r57 = r45;
        r59 = r47;
        r117 = r49;
        goto L215
    L125:
        if ((r2 & 3) != 2) goto L128;
        r3 = false;
        goto L130
    L115:
        if ((r52 & 6) == 0) goto L117;
        r2 = r52;
        goto L123
    L117:
        if (r1.changed(r49) == false) goto L119;
        int r218 = 4;
    L120:
        r23 = r52 | r218;
        goto L113
    L119:
        r218 = 2;
        goto L120
    L71:
        if ((r51 & 1572864) != 0) goto L78;
        if (r1.changed(r45) == false) goto L75;
        int r120 = 1048576;
    L76:
        r5 = r5 | r120;
        goto L78
    L75:
        r120 = 524288;
        goto L76
    L61:
        if ((r51 & 196608) != 0) goto L67;
        if (r1.changed(r44) == false) goto L65;
        int r121 = 131072;
    L66:
        r5 = r5 | r121;
        goto L67
    L65:
        r121 = 65536;
        goto L66
    L50:
        if ((r51 & 24576) != 0) goto L56;
        r15 = r43;
        if (r1.changedInstance(r15) == false) goto L54;
        int r122 = 16384;
    L55:
        r5 = r5 | r122;
        goto L57
    L54:
        r122 = 8192;
        goto L55
    L39:
        if ((r51 & 3072) != 0) goto L45;
        r11 = r42;
        if (r1.changedInstance(r11) == false) goto L43;
        int r123 = 2048;
    L44:
        r5 = r5 | r123;
        goto L46
    L43:
        r123 = 1024;
        goto L44
    L28:
        if ((r51 & 384) != 0) goto L34;
        r9 = r41;
        if (r1.changedInstance(r9) == false) goto L32;
        int r124 = 256;
    L33:
        r5 = r5 | r124;
        goto L35
    L32:
        r124 = 128;
        goto L33
    L17:
        if ((r51 & 48) != 0) goto L23;
        r7 = r40;
        if (r1.changed(r7) == false) goto L21;
        int r61 = 32;
    L22:
        r5 = r5 | r61;
        goto L24
    L21:
        r61 = 16;
        goto L22
    L6:
        if ((r51 & 6) == 0) goto L8;
        r5 = r51;
        goto L13
    L8:
        if (r1.changedInstance(r39) == false) goto L10;
        int r62 = 4;
    L11:
        r5 = r62 | r51;
        goto L13
    L10:
        r62 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TwoRowsTopAppBar-eXZ4JBQ, reason: not valid java name */
    public static final void m2317TwoRowsTopAppBareXZ4JBQ(final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> r39, Modifier r40, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> r41, Function2<? super Composer, ? super Integer, Unit> r42, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r43, Alignment.Horizontal r44, float r45, float r46, WindowInsets r47, TopAppBarColors r48, TopAppBarScrollBehavior r49, Composer r50, final int r51, final int r52, final int r53) {
        Composer r2 = r50.startRestartGroup(1672878784);
        if ((r53 & 1) == 0) goto L6;
        int r3 = r51 | 6;
    L13:
        int r6 = r53 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r8 = r53 & 4;
        if (r8 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r10 = r53 & 8;
        if (r10 == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        int r13 = r53 & 16;
        if (r13 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r15 = r43;
    L57:
        int r16 = r53 & 32;
        if (r16 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r17 = r53 & 64;
        if (r17 == 0) goto L71;
        r3 = r3 | 1572864;
    L77:
        int r5 = r53 & 128;
        if (r5 == 0) goto L81;
        r3 = r3 | 12582912;
    L88:
        if ((r51 & 100663296) != 0) goto L99;
        if ((r53 & 256) != 0) goto L95;
        if (r2.changed(r47) == false) goto L95;
        int r20 = 67108864;
    L96:
        r3 = r3 | r20;
    L95:
        r20 = 33554432;
    L99:
        if ((r51 & 805306368) != 0) goto L109;
        if ((r53 & 512) != 0) goto L106;
        if (r2.changed(r48) == false) goto L106;
        int r21 = 536870912;
    L107:
        r3 = r3 | r21;
    L106:
        r21 = 268435456;
    L109:
        int r0 = r53 & 1024;
        if (r0 == 0) goto L114;
        int r22 = r52 | 6;
    L112:
        int r4 = r22;
    L122:
        if ((r3 & 306783379) == 306783378) goto L124;
    L127:
        boolean r7 = true;
    L129:
        if (r2.shouldExecute(r7, r3 & 1) == false) goto L199;
        r2.startDefaults();
        if ((r51 & 1) != 0) goto L133;
    L142:
        if (r6 == 0) goto L144;
        Modifier r9 = Modifier.Companion;
    L145:
        if (r8 == 0) goto L147;
        final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> r11 = null;
    L148:
        if (r10 == 0) goto L150;
        Function2<? super Composer, ? super Integer, Unit> r12 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1767216677$material3();
    L151:
        if (r13 == 0) goto L153;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r14 = ComposableSingletons$AppBarKt.INSTANCE.m2522getLambda$470693625$material3();
    L154:
        if (r16 == 0) goto L156;
        Alignment.Horizontal r18 = Alignment.Companion.getStart();
    L157:
        if (r17 == 0) goto L159;
        float r19 = Dp.Companion.getUnspecified-D9Ej5fM();
    L160:
        if (r5 == 0) goto L162;
        float r23 = Dp.Companion.getUnspecified-D9Ej5fM();
    L164:
        if ((r53 & 256) == 0) goto L166;
        WindowInsets r24 = TopAppBarDefaults.INSTANCE.getWindowInsets(r2, 6);
        r3 = r3 & (-234881025);
    L168:
        if ((r53 & 512) == 0) goto L170;
        TopAppBarColors r110 = TopAppBarDefaults.INSTANCE.topAppBarColors(r2, 6);
        r3 = r3 & (-1879048193);
    L171:
        if (r0 == 0) goto L173;
        TopAppBarScrollBehavior r37 = null;
    L174:
        int r111 = r3;
        float r25 = r19;
    L175:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        ComposerKt.traceEventStart(1672878784, r111, r4, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:962)");
    L178:
        AppBarMediumFlexibleTokens r26 = AppBarMediumFlexibleTokens.INSTANCE;
        TextStyle r112 = TypographyKt.getValue(r26.getTitleFont(), r2, 6);
        AppBarSmallTokens r113 = AppBarSmallTokens.INSTANCE;
        TopAppBarColors r410 = r110;
        TextStyle r27 = TypographyKt.getValue(r113.getTitleFont(), r2, 6);
        float r114 = Dp.constructor-impl(0);
        TextStyle r28 = TypographyKt.getValue(r26.getSubtitleFont(), r2, 6);
        TextStyle r29 = TypographyKt.getValue(r113.getSubtitleFont(), r2, 6);
        Dp.Companion r30 = Dp.Companion;
        if (Dp.equals-impl0(r25, r30.getUnspecified-D9Ej5fM()) == false) goto L181;
    L184:
        float r210 = TopAppBarDefaults.INSTANCE.m3582getMediumAppBarCollapsedHeightD9Ej5fM();
    L186:
        if (Dp.equals-impl0(r23, r30.getUnspecified-D9Ej5fM()) == false) goto L188;
    L191:
        if (r11 == null) goto L193;
        float r31 = TopAppBarDefaults.INSTANCE.m3584getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
    L194:
        float r211 = r31;
    L195:
        float r411 = r25;
        int r34 = ((r111 >> 3) & 14) | 102263856;
        int r32 = r111 >> 6;
        int r33 = (((r111 >> 15) & 14) | (r32 & 112)) | (r32 & 896);
        int r35 = r111 >> 9;
        Modifier r115 = r9;
        m2318TwoRowsTopAppBarpJA5dT0(r115, ComposableLambdaKt.rememberComposableLambda(-1674885936, true, new AppBarKt$TwoRowsTopAppBar$1(r39), r2, 54), r112, r114, ComposableLambdaKt.rememberComposableLambda(1295408045, true, new AppBarKt$TwoRowsTopAppBar$2(r39), r2, 54), r27, ComposableLambdaKt.rememberComposableLambda(1843948267, true, new AppBarKt$TwoRowsTopAppBar$3(r11), r2, 54), r28, ComposableLambdaKt.rememberComposableLambda(-1902478807, true, new AppBarKt$TwoRowsTopAppBar$4(r11), r2, 54), r29, r18, r12, r14, r210, r211, r24, r410, r37, r2, r34, ((r33 | (458752 & r35)) | (r35 & 3670016)) | ((r4 << 21) & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L198;
        ComposerKt.traceEventEnd();
    L198:
        TopAppBarColors r116 = r410;
        float r36 = r23;
        final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> r38 = r11;
        final Function2<? super Composer, ? super Integer, Unit> r54 = r12;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r55 = r14;
        float r56 = r411;
        WindowInsets r117 = r24;
        Alignment.Horizontal r57 = r18;
    L200:
        ScopeUpdateScope r118 = r2.endRestartGroup();
        if (r118 == null) goto L204;
        final Modifier r58 = r9;
        final Alignment.Horizontal r59 = r57;
        final float r60 = r56;
        final float r61 = r36;
        final WindowInsets r62 = r117;
        final TopAppBarColors r119 = r116;
        final TopAppBarScrollBehavior r120 = r37;
        r118.updateScope(new k0(r39, r58, r38, r54, r55, r59, r60, r61, r62, r119, r120, r51, r52, r53));
        return;
    L204:
        return;
    L193:
        r31 = TopAppBarDefaults.INSTANCE.m3585getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
        goto L194
    L188:
        if (Dp.equals-impl0(r23, r30.getInfinity-D9Ej5fM()) == true) goto L191;
        r211 = r23;
        goto L195
    L181:
        if (Dp.equals-impl0(r25, r30.getInfinity-D9Ej5fM()) == true) goto L184;
        r210 = r25;
        goto L186
    L173:
        r37 = r49;
        goto L174
    L170:
        r110 = r48;
        goto L171
    L166:
        r24 = r47;
        goto L168
    L162:
        r23 = r46;
        goto L164
    L159:
        r19 = r45;
        goto L160
    L156:
        r18 = r44;
        goto L157
    L153:
        r14 = r15;
        goto L154
    L150:
        r12 = r42;
        goto L151
    L147:
        r11 = r41;
        goto L148
    L144:
        r9 = r40;
        goto L145
    L133:
        if (r2.getDefaultsInvalid() == true) goto L142;
        r2.skipToGroupEnd();
        if ((r53 & 256) == 0) goto L139;
        r3 = r3 & (-234881025);
    L139:
        if ((r53 & 512) == 0) goto L141;
        r3 = r3 & (-1879048193);
    L141:
        r9 = r40;
        r11 = r41;
        r12 = r42;
        r18 = r44;
        r23 = r46;
        r24 = r47;
        r110 = r48;
        r37 = r49;
        r14 = r15;
        r111 = r3;
        r25 = r45;
        goto L175
    L199:
        r2.skipToGroupEnd();
        r9 = r40;
        r38 = r41;
        r54 = r42;
        r57 = r44;
        r56 = r45;
        r36 = r46;
        r117 = r47;
        r116 = r48;
        r37 = r49;
        r55 = r15;
        goto L200
    L124:
        if ((r4 & 3) != 2) goto L127;
        r7 = false;
        goto L129
    L114:
        if ((r52 & 6) == 0) goto L116;
        r4 = r52;
        goto L122
    L116:
        if (r2.changed(r49) == false) goto L118;
        int r212 = 4;
    L119:
        r22 = r52 | r212;
        goto L112
    L118:
        r212 = 2;
        goto L119
    L81:
        if ((r51 & 12582912) != 0) goto L88;
        if (r2.changed(r46) == false) goto L85;
        int r213 = 8388608;
    L86:
        r3 = r3 | r213;
        goto L88
    L85:
        r213 = 4194304;
        goto L86
    L71:
        if ((r51 & 1572864) != 0) goto L77;
        if (r2.changed(r45) == false) goto L75;
        int r121 = 1048576;
    L76:
        r3 = r3 | r121;
        goto L77
    L75:
        r121 = 524288;
        goto L76
    L61:
        if ((r51 & 196608) != 0) goto L67;
        if (r2.changed(r44) == false) goto L65;
        int r122 = 131072;
    L66:
        r3 = r3 | r122;
        goto L67
    L65:
        r122 = 65536;
        goto L66
    L50:
        if ((r51 & 24576) != 0) goto L56;
        r15 = r43;
        if (r2.changedInstance(r15) == false) goto L54;
        int r123 = 16384;
    L55:
        r3 = r3 | r123;
        goto L57
    L54:
        r123 = 8192;
        goto L55
    L39:
        if ((r51 & 3072) != 0) goto L46;
        if (r2.changedInstance(r42) == false) goto L43;
        int r124 = 2048;
    L44:
        r3 = r3 | r124;
        goto L46
    L43:
        r124 = 1024;
        goto L44
    L28:
        if ((r51 & 384) != 0) goto L35;
        if (r2.changedInstance(r41) == false) goto L32;
        int r125 = 256;
    L33:
        r3 = r3 | r125;
        goto L35
    L32:
        r125 = 128;
        goto L33
    L17:
        if ((r51 & 48) != 0) goto L24;
        if (r2.changed(r40) == false) goto L21;
        int r63 = 32;
    L22:
        r3 = r3 | r63;
        goto L24
    L21:
        r63 = 16;
        goto L22
    L6:
        if ((r51 & 6) == 0) goto L8;
        r3 = r51;
        goto L13
    L8:
        if (r2.changedInstance(r39) == false) goto L10;
        int r64 = 4;
    L11:
        r3 = r64 | r51;
        goto L13
    L10:
        r64 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SingleRowTopAppBar-wn8IZOc, reason: not valid java name */
    private static final void m2313SingleRowTopAppBarwn8IZOc(Modifier r32, final Function2<? super Composer, ? super Integer, Unit> r33, final TextStyle r34, final Function2<? super Composer, ? super Integer, Unit> r35, final TextStyle r36, final Alignment.Horizontal r37, final Function2<? super Composer, ? super Integer, Unit> r38, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r39, final float r40, final WindowInsets r41, final TopAppBarColors r42, final TopAppBarScrollBehavior r43, Composer r44, final int r45, final int r46, final int r47) {
        Composer r1 = r44.startRestartGroup(-2033800111);
        int r2 = r47 & 1;
        if (r2 == 0) goto L6;
        int r6 = r45 | 6;
    L14:
        if ((r47 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L25:
        if ((r47 & 4) == 0) goto L28;
        r6 = r6 | 384;
    L36:
        if ((r47 & 8) == 0) goto L39;
        r6 = r6 | 3072;
    L47:
        if ((r47 & 16) == 0) goto L50;
        r6 = r6 | 24576;
    L58:
        if ((r47 & 32) == 0) goto L61;
        r6 = r6 | 196608;
    L69:
        if ((r47 & 64) == 0) goto L72;
        r6 = r6 | 1572864;
    L79:
        if ((r47 & 128) == 0) goto L82;
        r6 = r6 | 12582912;
    L90:
        if ((r47 & 256) == 0) goto L93;
        r6 = r6 | 100663296;
    L101:
        if ((r47 & 512) == 0) goto L104;
        r6 = r6 | 805306368;
    L112:
        if ((r47 & 1024) == 0) goto L115;
        int r16 = r46 | 6;
    L123:
        if ((r47 & 2048) == 0) goto L126;
        r16 = r16 | 48;
    L133:
        int r0 = r16;
        if ((r6 & 306783379) == 306783378) goto L136;
    L139:
        boolean r3 = true;
    L141:
        if (r1.shouldExecute(r3, r6 & 1) == false) goto L151;
        if (r2 == 0) goto L144;
        Modifier r4 = Modifier.Companion;
    L146:
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventStart(-2033800111, r6, r0, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:2484)");
    L148:
        Modifier r17 = r4;
        SingleRowTopAppBarOverrideScope r5 = new SingleRowTopAppBarOverrideScope(r17, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, null);
        ((SingleRowTopAppBarOverride) r1.consume(LocalSingleRowTopAppBarOverride)).SingleRowTopAppBar(r5, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L152;
        ComposerKt.traceEventEnd();
    L152:
        ScopeUpdateScope r7 = r1.endRestartGroup();
        if (r7 == null) goto L156;
        final Modifier r8 = r4;
        r7.updateScope(new i0(r8, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r45, r46, r47));
        return;
    L156:
        return;
    L144:
        r4 = r32;
        goto L146
    L151:
        r1.skipToGroupEnd();
        r4 = r32;
        goto L152
    L136:
        if ((r0 & 19) != 18) goto L139;
        r3 = false;
        goto L141
    L126:
        if ((r46 & 48) != 0) goto L133;
        if (r1.changed(r43) == false) goto L130;
        int r18 = 32;
    L131:
        r16 = r16 | r18;
        goto L133
    L130:
        r18 = 16;
        goto L131
    L115:
        if ((r46 & 6) == 0) goto L117;
        r16 = r46;
        goto L123
    L117:
        if (r1.changed(r42) == false) goto L119;
        int r19 = 4;
    L120:
        r16 = r46 | r19;
        goto L123
    L119:
        r19 = 2;
        goto L120
    L104:
        if ((r45 & 805306368) != 0) goto L112;
        if (r1.changed(r41) == false) goto L108;
        int r110 = 536870912;
    L109:
        r6 = r6 | r110;
        goto L112
    L108:
        r110 = 268435456;
        goto L109
    L93:
        if ((r45 & 100663296) != 0) goto L101;
        if (r1.changed(r40) == false) goto L97;
        int r111 = 67108864;
    L98:
        r6 = r6 | r111;
        goto L101
    L97:
        r111 = 33554432;
        goto L98
    L82:
        if ((r45 & 12582912) != 0) goto L90;
        if (r1.changedInstance(r39) == false) goto L86;
        int r112 = 8388608;
    L87:
        r6 = r6 | r112;
        goto L90
    L86:
        r112 = 4194304;
        goto L87
    L72:
        if ((r45 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r38) == false) goto L76;
        int r113 = 1048576;
    L77:
        r6 = r6 | r113;
        goto L79
    L76:
        r113 = 524288;
        goto L77
    L61:
        if ((r45 & 196608) != 0) goto L69;
        if (r1.changed(r37) == false) goto L65;
        int r114 = 131072;
    L66:
        r6 = r6 | r114;
        goto L69
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r45 & 24576) != 0) goto L58;
        if (r1.changed(r36) == false) goto L54;
        int r14 = 16384;
    L55:
        r6 = r6 | r14;
        goto L58
    L54:
        r14 = 8192;
        goto L55
    L39:
        if ((r45 & 3072) != 0) goto L47;
        if (r1.changedInstance(r35) == false) goto L43;
        int r12 = 2048;
    L44:
        r6 = r6 | r12;
        goto L47
    L43:
        r12 = 1024;
        goto L44
    L28:
        if ((r45 & 384) != 0) goto L36;
        if (r1.changed(r34) == false) goto L32;
        int r11 = 256;
    L33:
        r6 = r6 | r11;
        goto L36
    L32:
        r11 = 128;
        goto L33
    L17:
        if ((r45 & 48) != 0) goto L25;
        if (r1.changedInstance(r33) == false) goto L21;
        int r10 = 32;
    L22:
        r6 = r6 | r10;
        goto L25
    L21:
        r10 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r6 = r45;
        goto L14
    L8:
        if (r1.changed(r32) == false) goto L10;
        int r9 = 4;
    L11:
        r6 = r9 | r45;
        goto L14
    L10:
        r9 = 2;
        goto L11
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v15 ??, still in use, count: 1, list:
          (r1v15 ?? I:java.lang.Object) from 0x0220: INVOKE (r9v5 ?? I:androidx.compose.runtime.Composer), (r1v15 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:352322080)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* JADX INFO: renamed from: TopAppBarLayout-lyUyIHI, reason: not valid java name */
    private static final void m2316TopAppBarLayoutlyUyIHI(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v15 ??, still in use, count: 1, list:
          (r1v15 ?? I:java.lang.Object) from 0x0220: INVOKE (r9v5 ?? I:androidx.compose.runtime.Composer), (r1v15 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:352322080)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r36v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    /* JADX INFO: renamed from: access$TopAppBarLayout-lyUyIHI, reason: not valid java name */
    public static final /* synthetic */ void m2319access$TopAppBarLayoutlyUyIHI(Modifier r0, FloatProducer r1, long r2, long r4, long r6, long r8, Function2 r10, TextStyle r11, Function2 r12, TextStyle r13, Function0 r14, Arrangement.Vertical r15, Alignment.Horizontal r16, int r17, boolean r18, Function2 r19, Function2 r20, float r21, Composer r22, int r23, int r24) {
        m2316TopAppBarLayoutlyUyIHI(r0, r1, r2, r4, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    /* JADX INFO: renamed from: TwoRowsTopAppBar-pJA5dT0, reason: not valid java name */
    private static final void m2318TwoRowsTopAppBarpJA5dT0(Modifier r38, final Function2<? super Composer, ? super Integer, Unit> r39, final TextStyle r40, final float r41, final Function2<? super Composer, ? super Integer, Unit> r42, final TextStyle r43, final Function2<? super Composer, ? super Integer, Unit> r44, final TextStyle r45, final Function2<? super Composer, ? super Integer, Unit> r46, final TextStyle r47, final Alignment.Horizontal r48, final Function2<? super Composer, ? super Integer, Unit> r49, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r50, final float r51, final float r52, final WindowInsets r53, final TopAppBarColors r54, final TopAppBarScrollBehavior r55, Composer r56, final int r57, final int r58, final int r59) {
        Composer r1 = r56.startRestartGroup(1092180406);
        int r2 = r59 & 1;
        if (r2 == 0) goto L6;
        int r6 = r57 | 6;
        Modifier r5 = r38;
    L14:
        if ((r59 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L25:
        if ((r59 & 4) == 0) goto L28;
        r6 = r6 | 384;
    L35:
        int r17 = 2048;
        if ((r59 & 8) == 0) goto L39;
        r6 = r6 | 3072;
    L46:
        int r19 = 16384;
        if ((r59 & 16) == 0) goto L50;
        r6 = r6 | 24576;
    L58:
        if ((r59 & 32) == 0) goto L61;
        r6 = r6 | 196608;
    L68:
        if ((r59 & 64) == 0) goto L71;
        r6 = r6 | 1572864;
    L78:
        if ((r59 & 128) == 0) goto L81;
        r6 = r6 | 12582912;
    L89:
        if ((r59 & 256) == 0) goto L92;
        r6 = r6 | 100663296;
    L100:
        if ((r59 & 512) == 0) goto L103;
        r6 = r6 | 805306368;
    L111:
        if ((r59 & 1024) == 0) goto L114;
        int r16 = r58 | 6;
    L122:
        if ((r59 & 2048) == 0) goto L125;
        r16 = r16 | 48;
    L132:
        int r0 = r16;
        if ((r59 & 4096) == 0) goto L136;
        r0 = r0 | 384;
    L144:
        if ((r59 & 8192) == 0) goto L147;
        r0 = r0 | 3072;
    L155:
        if ((r59 & 16384) == 0) goto L158;
        r0 = r0 | 24576;
    L166:
        if ((r59 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L169;
        r0 = r0 | 196608;
    L176:
        if ((r59 & 65536) == 0) goto L179;
        r0 = r0 | 1572864;
    L186:
        if ((r59 & 131072) == 0) goto L189;
        r0 = r0 | 12582912;
    L196:
        if ((r6 & 306783379) == 306783378) goto L198;
    L201:
        boolean r3 = true;
    L203:
        if (r1.shouldExecute(r3, r6 & 1) == false) goto L213;
        if (r2 == 0) goto L206;
        Modifier r4 = Modifier.Companion;
    L208:
        if (ComposerKt.isTraceInProgress() == false) goto L210;
        ComposerKt.traceEventStart(1092180406, r6, r0, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:2700)");
    L210:
        Modifier r18 = r4;
        TwoRowsTopAppBarOverrideScope r7 = new TwoRowsTopAppBarOverrideScope(r18, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, null);
        ((TwoRowsTopAppBarOverride) r1.consume(LocalTwoRowsTopAppBarOverride)).TwoRowsTopAppBar(r7, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L214;
        ComposerKt.traceEventEnd();
    L214:
        ScopeUpdateScope r8 = r1.endRestartGroup();
        if (r8 == null) goto L218;
        final Modifier r9 = r4;
        r8.updateScope(new n0(r9, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r57, r58, r59));
        return;
    L218:
        return;
    L206:
        r4 = r5;
        goto L208
    L213:
        r1.skipToGroupEnd();
        r4 = r5;
        goto L214
    L198:
        if ((4793491 & r0) != 4793490) goto L201;
        r3 = false;
        goto L203
    L189:
        if ((r58 & 12582912) != 0) goto L196;
        if (r1.changed(r55) == false) goto L193;
        int r110 = 8388608;
    L194:
        r0 = r0 | r110;
        goto L196
    L193:
        r110 = 4194304;
        goto L194
    L179:
        if ((r58 & 1572864) != 0) goto L186;
        if (r1.changed(r54) == false) goto L183;
        int r111 = 1048576;
    L184:
        r0 = r0 | r111;
        goto L186
    L183:
        r111 = 524288;
        goto L184
    L169:
        if ((r58 & 196608) != 0) goto L176;
        if (r1.changed(r53) == false) goto L173;
        int r112 = 131072;
    L174:
        r0 = r0 | r112;
        goto L176
    L173:
        r112 = 65536;
        goto L174
    L158:
        if ((r58 & 24576) != 0) goto L166;
        if (r1.changed(r52) == true) goto L163;
        r19 = 8192;
    L163:
        r0 = r0 | r19;
        goto L166
    L147:
        if ((r58 & 3072) != 0) goto L155;
        if (r1.changed(r51) == true) goto L152;
        r17 = 1024;
    L152:
        r0 = r0 | r17;
        goto L155
    L136:
        if ((r58 & 384) != 0) goto L144;
        if (r1.changedInstance(r50) == false) goto L140;
        int r27 = 256;
    L141:
        r0 = r0 | r27;
        goto L144
    L140:
        r27 = 128;
        goto L141
    L125:
        if ((r58 & 48) != 0) goto L132;
        if (r1.changedInstance(r49) == false) goto L129;
        int r21 = 32;
    L130:
        r16 = r16 | r21;
        goto L132
    L129:
        r21 = 16;
        goto L130
    L114:
        if ((r58 & 6) == 0) goto L116;
        r16 = r58;
        goto L122
    L116:
        if (r1.changed(r48) == false) goto L118;
        int r113 = 4;
    L119:
        r16 = r58 | r113;
        goto L122
    L118:
        r113 = 2;
        goto L119
    L103:
        if ((805306368 & r57) != 0) goto L111;
        if (r1.changed(r47) == false) goto L107;
        int r31 = 536870912;
    L108:
        r6 = r6 | r31;
        goto L111
    L107:
        r31 = 268435456;
        goto L108
    L92:
        if ((100663296 & r57) != 0) goto L100;
        if (r1.changedInstance(r46) == false) goto L96;
        int r30 = 67108864;
    L97:
        r6 = r6 | r30;
        goto L100
    L96:
        r30 = 33554432;
        goto L97
    L81:
        if ((r57 & 12582912) != 0) goto L89;
        if (r1.changed(r45) == false) goto L85;
        int r29 = 8388608;
    L86:
        r6 = r6 | r29;
        goto L89
    L85:
        r29 = 4194304;
        goto L86
    L71:
        if ((r57 & 1572864) != 0) goto L78;
        if (r1.changedInstance(r44) == false) goto L75;
        int r28 = 1048576;
    L76:
        r6 = r6 | r28;
        goto L78
    L75:
        r28 = 524288;
        goto L76
    L61:
        if ((r57 & 196608) != 0) goto L68;
        if (r1.changed(r43) == false) goto L65;
        int r25 = 131072;
    L66:
        r6 = r6 | r25;
        goto L68
    L65:
        r25 = 65536;
        goto L66
    L50:
        if ((r57 & 24576) != 0) goto L58;
        if (r1.changedInstance(r42) == false) goto L54;
        int r22 = 16384;
    L55:
        r6 = r6 | r22;
        goto L58
    L54:
        r22 = 8192;
        goto L55
    L39:
        if ((r57 & 3072) != 0) goto L46;
        if (r1.changed(r41) == false) goto L43;
        int r114 = 2048;
    L44:
        r6 = r6 | r114;
        goto L46
    L43:
        r114 = 1024;
        goto L44
    L28:
        if ((r57 & 384) != 0) goto L35;
        if (r1.changed(r40) == false) goto L32;
        int r115 = 256;
    L33:
        r6 = r6 | r115;
        goto L35
    L32:
        r115 = 128;
        goto L33
    L17:
        if ((r57 & 48) != 0) goto L25;
        if (r1.changedInstance(r39) == false) goto L21;
        int r10 = 32;
    L22:
        r6 = r6 | r10;
        goto L25
    L21:
        r10 = 16;
        goto L22
    L6:
        if ((r57 & 6) != 0) goto L12;
        r5 = r38;
        if (r1.changed(r5) == false) goto L10;
        int r11 = 4;
    L11:
        r6 = r11 | r57;
        goto L14
    L10:
        r11 = 2;
        goto L11
    L12:
        r5 = r38;
        r6 = r57;
        goto L14
    }
}
