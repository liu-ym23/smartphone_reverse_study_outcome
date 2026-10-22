package androidx.compose.material3;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.DragGestureDetectorCopyKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a³\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010\u0019\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001b\u001a}\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001aä\u0001\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\b\b\u0003\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010&\u001a\u0098\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020$2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010'\u001a_\u0010(\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010)\u001a`\u0010*\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002\u001a\u0080\u0001\u0010-\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010.\u001a(\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0002\u001a2\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0003\u0018\u000106*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0082@¢\u0006\u0004\b=\u0010>\u001a\u0010\u0010?\u001a\u0002022\u0006\u0010\f\u001a\u00020\rH\u0002\u001a0\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002\u001a?\u0010@\u001a\u00020F2\u0006\u0010G\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010H\u001a\u00020F2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002¢\u0006\u0004\bI\u0010J\u001a \u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0002\u001a\u001c\u0010O\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010P\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010Q\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010R\u001a\u00020S*\u00020\u0003H\u0002\u001a$\u0010T\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0003\u001a,\u0010U\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0003\u001aC\u0010d\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010e\u001aM\u0010f\u001a\u00020$2\b\b\u0002\u0010g\u001a\u00020\u00032\b\b\u0002\u0010h\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010i\u001a\u001d\u0010j\u001a\u00020F2\u0006\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010m\u001a\u001b\u0010j\u001a\u00020F2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0001¢\u0006\u0002\u0010o\"\u0016\u0010V\u001a\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010Y\"\u0016\u0010[\u001a\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b\\\u0010Y\"\u0010\u0010]\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010a\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010b\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010c\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u001e\u0010p\u001a\u00020\t*\u00020F8@X\u0081\u0004¢\u0006\f\u0012\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0014\u0010u\u001a\u00020vX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010x¨\u0006y"}, d2 = {"Slider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "thumb", "Landroidx/compose/material3/SliderState;", "Landroidx/compose/runtime/Composable;", "track", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "state", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "VerticalSlider", "reverseDirection", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "RangeSlider", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "startInteractionSource", "endInteractionSource", "startThumb", "Landroidx/compose/material3/RangeSliderState;", "endThumb", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "slideOnKeyEvents", "onValueChangeState", "onValueChangeFinishedState", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stepsToTickFractions", "scale", "a1", "b1", "x1", "a2", "b2", "Landroidx/compose/material3/SliderRange;", "isStart", "x", "scale-2geJ7wY", "(ZFFJFF)J", "calcFraction", "a", "b", "pos", "sliderSemantics", "rangeSliderStartThumbSemantics", "rangeSliderEndThumbSemantics", "formatForSemantics", "", "sliderTapModifier", "rangeSliderPressDragModifier", "TrackHeight", "Landroidx/compose/ui/unit/Dp;", "getTrackHeight", "()F", "F", "ThumbWidth", "getThumbWidth", "ThumbHeight", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "VerticalThumbSize", "ThumbTrackGapSize", "TrackInsideCornerSize", "rememberSliderState", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SliderState;", "rememberRangeSliderState", "activeRangeStart", "activeRangeEnd", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RangeSliderState;", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "isSpecified", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "CornerSizeAlignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "getCornerSizeAlignmentLine", "()Landroidx/compose/ui/layout/VerticalAlignmentLine;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SliderKt {
    private static final VerticalAlignmentLine CornerSizeAlignmentLine = null;
    private static final float ThumbHeight = 0.0f;
    private static final long ThumbSize = 0;
    private static final float ThumbTrackGapSize = 0.0f;
    private static final float ThumbWidth = 0.0f;
    private static final float TrackHeight = 0.0f;
    private static final float TrackInsideCornerSize = 0.0f;
    private static final long VerticalThumbSize = 0;

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C02791 implements PointerInputEventHandler {
        final /* synthetic */ SliderState $state;

        /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00731 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
            final /* synthetic */ SliderState $state;
            /* synthetic */ long J$0;
            int label;

            public C00731(SliderState r1, Continuation<? super C00731> r2) {
                this.$state = r1;
                super(3, r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
                return m3181invoked4ec7I((PressGestureScope) r3, ((Offset) r4).unbox-impl(), (Continuation) r5);
            }

            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m3181invoked4ec7I(PressGestureScope r2, long r3, Continuation<? super Unit> r5) {
                C00731 r4 = new C00731(this.$state, r5);
                r4.J$0 = r3;
                return r4.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                long r0 = this.J$0;
                this.$state.m3193onPressk4lQ0M$material3(r0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C02791(SliderState r1) {
            this.$state = r1;
        }

        public static /* synthetic */ Unit a(SliderState r0, Offset r1) {
            return invoke$lambda$0(r0, r1);
        }

        private static final Unit invoke$lambda$0(SliderState r0, Offset r1) {
            r0.dispatchRawDelta(MenuKt.ClosedAlphaTarget);
            r0.getGestureEndAction$material3().invoke();
            return Unit.INSTANCE;
        }

        public final Object invoke(PointerInputScope r9, Continuation<? super Unit> r10) {
            C00731 r3 = new C00731(this.$state, null);
            final SliderState r0 = this.$state;
            Object r11 = TapGestureDetectorKt.detectTapGestures$default(r9, null, null, r3, new mq(r0), r10, 3, null);
            if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r11;
        L6:
            return Unit.INSTANCE;
        }
    }

    private static final Unit RangeSlider$lambda$13(ClosedFloatingPointRange r12, Function1 r13, Modifier r14, boolean r15, ClosedFloatingPointRange r16, int r17, Function0 r18, SliderColors r19, int r20, int r21, Composer r22, int r23) {
        RangeSlider(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit RangeSlider$lambda$19(ClosedFloatingPointRange r17, Function1 r18, Modifier r19, boolean r20, ClosedFloatingPointRange r21, Function0 r22, SliderColors r23, MutableInteractionSource r24, MutableInteractionSource r25, Function3 r26, Function3 r27, Function3 r28, int r29, int r30, int r31, int r32, Composer r33, int r34) {
        RangeSlider(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    private static final Unit RangeSlider$lambda$23(RangeSliderState r13, Modifier r14, boolean r15, SliderColors r16, MutableInteractionSource r17, MutableInteractionSource r18, Function3 r19, Function3 r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        RangeSlider(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit RangeSliderImpl$lambda$46(Modifier r11, RangeSliderState r12, boolean r13, MutableInteractionSource r14, MutableInteractionSource r15, Function3 r16, Function3 r17, Function3 r18, int r19, Composer r20, int r21) {
        RangeSliderImpl(r11, r12, r13, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Slider$lambda$1(float r13, Function1 r14, Modifier r15, boolean r16, ClosedFloatingPointRange r17, int r18, Function0 r19, SliderColors r20, MutableInteractionSource r21, int r22, int r23, Composer r24, int r25) {
        Slider(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit Slider$lambda$4(float r16, Function1 r17, Modifier r18, boolean r19, Function0 r20, SliderColors r21, MutableInteractionSource r22, int r23, Function3 r24, Function3 r25, ClosedFloatingPointRange r26, int r27, int r28, int r29, Composer r30, int r31) {
        Slider(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit Slider$lambda$7(SliderState r11, Modifier r12, boolean r13, SliderColors r14, MutableInteractionSource r15, Function3 r16, Function3 r17, int r18, int r19, Composer r20, int r21) {
        Slider(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit SliderImpl$lambda$31(Modifier r9, SliderState r10, boolean r11, MutableInteractionSource r12, Function3 r13, Function3 r14, int r15, Composer r16, int r17) {
        SliderImpl(r9, r10, r11, r12, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit VerticalSlider$lambda$10(SliderState r12, Modifier r13, boolean r14, boolean r15, SliderColors r16, MutableInteractionSource r17, Function3 r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        VerticalSlider(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SliderState r0, Modifier r1, boolean r2, SliderColors r3, MutableInteractionSource r4, Function3 r5, Function3 r6, int r7, int r8, Composer r9, int r10) {
        return Slider$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit b(float r0, Function1 r1, Modifier r2, boolean r3, Function0 r4, SliderColors r5, MutableInteractionSource r6, int r7, Function3 r8, Function3 r9, ClosedFloatingPointRange r10, int r11, int r12, int r13, Composer r14, int r15) {
        return Slider$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit c(RangeSliderState r0, IntSize r1) {
        return RangeSliderImpl$lambda$44$lambda$34$lambda$33(r0, r1);
    }

    public static /* synthetic */ boolean d(ClosedFloatingPointRange r0, RangeSliderState r1, float r2) {
        return rangeSliderEndThumbSemantics$lambda$58$lambda$57(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(RangeSliderState r0, Modifier r1, boolean r2, SliderColors r3, MutableInteractionSource r4, MutableInteractionSource r5, Function3 r6, Function3 r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return RangeSlider$lambda$23(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ boolean f(SliderState r0, float r1) {
        return sliderSemantics$lambda$52$lambda$51(r0, r1);
    }

    public static /* synthetic */ Unit g(Modifier r0, RangeSliderState r1, boolean r2, MutableInteractionSource r3, MutableInteractionSource r4, Function3 r5, Function3 r6, Function3 r7, int r8, Composer r9, int r10) {
        return RangeSliderImpl$lambda$46(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ SliderState h(float r0, int r1, Function0 r2, ClosedFloatingPointRange r3) {
        return rememberSliderState$lambda$60$lambda$59(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit i(boolean r0, SliderState r1, SemanticsPropertyReceiver r2) {
        return sliderSemantics$lambda$52(r0, r1, r2);
    }

    /* JADX INFO: renamed from: isSpecified-If1S1O4$annotations, reason: not valid java name */
    public static /* synthetic */ void m3176isSpecifiedIf1S1O4$annotations(long r0) {
    }

    public static /* synthetic */ RangeSliderState j(float r0, float r1, int r2, Function0 r3, ClosedFloatingPointRange r4) {
        return rememberRangeSliderState$lambda$62$lambda$61(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit k(ClosedFloatingPointRange r1, Function1 r2, Modifier r3, boolean r4, ClosedFloatingPointRange r5, Function0 r6, SliderColors r7, MutableInteractionSource r8, MutableInteractionSource r9, Function3 r10, Function3 r11, Function3 r12, int r13, int r14, int r15, int r16, Composer r17, int r18) {
        return RangeSlider$lambda$19(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit l(RangeSliderState r0, IntSize r1) {
        return RangeSliderImpl$lambda$44$lambda$39$lambda$38(r0, r1);
    }

    public static /* synthetic */ Unit m(SliderState r0, IntSize r1) {
        return SliderImpl$lambda$29$lambda$26$lambda$25(r0, r1);
    }

    public static /* synthetic */ boolean n(ClosedFloatingPointRange r0, RangeSliderState r1, float r2) {
        return rangeSliderStartThumbSemantics$lambda$55$lambda$54(r0, r1, r2);
    }

    public static /* synthetic */ Unit o(float r0, Function1 r1, Modifier r2, boolean r3, ClosedFloatingPointRange r4, int r5, Function0 r6, SliderColors r7, MutableInteractionSource r8, int r9, int r10, Composer r11, int r12) {
        return Slider$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit p(String r0, SemanticsPropertyReceiver r1) {
        return RangeSliderImpl$lambda$44$lambda$36$lambda$35(r0, r1);
    }

    public static /* synthetic */ Unit q(SliderState r0, Modifier r1, boolean r2, boolean r3, SliderColors r4, MutableInteractionSource r5, Function3 r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return VerticalSlider$lambda$10(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit r(boolean r0, RangeSliderState r1, ClosedFloatingPointRange r2, SemanticsPropertyReceiver r3) {
        return rangeSliderEndThumbSemantics$lambda$58(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit s(boolean r0, RangeSliderState r1, ClosedFloatingPointRange r2, SemanticsPropertyReceiver r3) {
        return rangeSliderStartThumbSemantics$lambda$55(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit t(Ref.FloatRef r0, PointerInputChange r1, float r2) {
        return awaitSlop_8vUncbI$lambda$49(r0, r1, r2);
    }

    public static /* synthetic */ Unit u(Function1 r0, SliderRange r1) {
        return RangeSlider$lambda$18$lambda$17(r0, r1);
    }

    public static /* synthetic */ Unit v(String r0, SemanticsPropertyReceiver r1) {
        return RangeSliderImpl$lambda$44$lambda$41$lambda$40(r0, r1);
    }

    public static /* synthetic */ Unit w(ClosedFloatingPointRange r0, Function1 r1, Modifier r2, boolean r3, ClosedFloatingPointRange r4, int r5, Function0 r6, SliderColors r7, int r8, int r9, Composer r10, int r11) {
        return RangeSlider$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit x(Modifier r0, SliderState r1, boolean r2, MutableInteractionSource r3, Function3 r4, Function3 r5, int r6, Composer r7, int r8) {
        return SliderImpl$lambda$31(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    static {
        SliderTokens r0 = SliderTokens.INSTANCE;
        TrackHeight = r0.getInactiveTrackHeight-D9Ej5fM();
        float r1 = r0.getHandleWidth-D9Ej5fM();
        ThumbWidth = r1;
        float r2 = r0.getHandleHeight-D9Ej5fM();
        ThumbHeight = r2;
        ThumbSize = DpKt.DpSize-YgX7TsA(r1, r2);
        VerticalThumbSize = DpKt.DpSize-YgX7TsA(r2, r1);
        ThumbTrackGapSize = r0.getActiveHandleLeadingSpace-D9Ej5fM();
        TrackInsideCornerSize = Dp.constructor-impl(2);
        CornerSizeAlignmentLine = new VerticalAlignmentLine(SliderKt$CornerSizeAlignmentLine$1.INSTANCE);
    }

    public static final /* synthetic */ long access$getThumbSize$p() {
        return ThumbSize;
    }

    public static final /* synthetic */ float access$getThumbTrackGapSize$p() {
        return ThumbTrackGapSize;
    }

    public static final /* synthetic */ float access$getTrackInsideCornerSize$p() {
        return TrackInsideCornerSize;
    }

    public static final /* synthetic */ long access$getVerticalThumbSize$p() {
        return VerticalThumbSize;
    }

    public static final VerticalAlignmentLine getCornerSizeAlignmentLine() {
        return CornerSizeAlignmentLine;
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> r6) {
        float r0 = ((Number) r6.getStart()).floatValue();
        float r7 = ((Number) r6.getEndInclusive()).floatValue();
        boolean r2 = true;
        if (Float.isNaN(r0) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
    L13:
        if (r2 == false) goto L17;
        return SliderRange.m3183constructorimpl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L));
    L17:
        throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + r0 + ") must be <= ClosedFloatingPoint.endInclusive(" + r7 + ')').toString());
    L10:
        if (r0 <= r7) goto L13;
        r2 = false;
        goto L13
    L5:
        if (Float.isNaN(r7) == false) goto L7;
        r1 = true;
        goto L8
    }

    public static final /* synthetic */ float[] access$stepsToTickFractions(int r0) {
        return stepsToTickFractions(r0);
    }

    private static final String formatForSemantics(float r1) {
        return String.valueOf(MathKt.roundToInt(r1 * 100) / 100.0f);
    }

    /* JADX INFO: renamed from: isSpecified-If1S1O4, reason: not valid java name */
    public static final boolean m3175isSpecifiedIf1S1O4(long r3) {
        if (r3 == SliderRange.Companion.m3192getUnspecifiedFYbKRX4()) goto L5;
        return true;
    L5:
        return false;
    }

    private static final float[] stepsToTickFractions(int r5) {
        int r0 = 0;
        if (r5 == 0) goto L11;
        int r1 = r5 + 2;
        float[] r2 = new float[r1];
    L6:
        if (r0 >= r1) goto L9;
        r2[r0] = r0 / (r5 + 1);
        r0 = r0 + 1;
        goto L6
    L9:
        return r2;
    L11:
        return new float[0];
    }

    private static final Unit RangeSlider$lambda$18$lambda$17(Function1 r3, SliderRange r4) {
        r3.invoke(RangesKt.rangeTo(SliderRange.m3187getStartimpl(r4.m3190unboximpl()), SliderRange.m3186getEndInclusiveimpl(r4.m3190unboximpl())));
        return Unit.INSTANCE;
    }

    private static final Unit RangeSliderImpl$lambda$44$lambda$34$lambda$33(RangeSliderState r4, IntSize r5) {
        r4.setStartThumbWidth$material3((int) (r5.unbox-impl() >> 32));
        r4.setStartThumbHeight$material3((int) (r5.unbox-impl() & 4294967295L));
        return Unit.INSTANCE;
    }

    private static final Unit RangeSliderImpl$lambda$44$lambda$36$lambda$35(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    private static final Unit RangeSliderImpl$lambda$44$lambda$39$lambda$38(RangeSliderState r4, IntSize r5) {
        r4.setEndThumbWidth$material3((int) (r5.unbox-impl() >> 32));
        r4.setEndThumbHeight$material3((int) (r5.unbox-impl() & 4294967295L));
        return Unit.INSTANCE;
    }

    private static final Unit RangeSliderImpl$lambda$44$lambda$41$lambda$40(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    private static final Unit SliderImpl$lambda$29$lambda$26$lambda$25(SliderState r4, IntSize r5) {
        r4.setThumbWidth$material3((int) (r5.unbox-impl() >> 32));
        r4.setThumbHeight$material3((int) (r5.unbox-impl() & 4294967295L));
        return Unit.INSTANCE;
    }

    public static final long SliderRange(float r4, float r5) {
        boolean r1 = true;
        if (Float.isNaN(r4) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
    L13:
        if (r1 == false) goto L17;
        long r2 = Float.floatToRawIntBits(r4);
        return SliderRange.m3183constructorimpl((((long) Float.floatToRawIntBits(r5)) & 4294967295L) | (r2 << 32));
    L17:
        throw new IllegalArgumentException(("start(" + r4 + ") must be <= endInclusive(" + r5 + ')').toString());
    L10:
        if (r4 <= r5) goto L13;
        r1 = false;
        goto L13
    L5:
        if (Float.isNaN(r5) == false) goto L7;
        r0 = true;
        goto L8
    }

    private static final boolean sliderSemantics$lambda$52$lambda$51(SliderState r10, float r11) {
        float r12 = RangesKt.coerceIn(r11, ((Number) r10.getValueRange().getStart()).floatValue(), ((Number) r10.getValueRange().getEndInclusive()).floatValue());
        boolean r1 = false;
        if (r10.getSteps() <= 0) goto L14;
        int r0 = r10.getSteps() + 1;
        if (r0 < 0) goto L14;
        float r4 = r12;
        float r5 = r4;
        int r3 = 0;
    L7:
        float r6 = MathHelpersKt.lerp(((Number) r10.getValueRange().getStart()).floatValue(), ((Number) r10.getValueRange().getEndInclusive()).floatValue(), r3 / (r10.getSteps() + 1));
        float r7 = r6 - r12;
        if (Math.abs(r7) > r4) goto L10;
        r4 = Math.abs(r7);
        r5 = r6;
    L10:
        if (r3 == r0) goto L12;
        r3 = r3 + 1;
        goto L7
    L12:
        r12 = r5;
    L14:
        if (r12 != r10.getValue()) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L20;
        return false;
    L20:
        if (r12 != r10.getValue()) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
    L29:
        Function0<Unit> r13 = r10.getOnValueChangeFinished();
        if (r13 == null) goto L32;
        r13.invoke();
    L32:
        return true;
    L24:
        if (r10.getOnValueChange() == null) goto L28;
        Function1<Float, Unit> r8 = r10.getOnValueChange();
        if (r8 == null) goto L29;
        r8.invoke(Float.valueOf(r12));
        goto L29
    L28:
        r10.setValue(r12);
        goto L29
    L16:
        r2 = false;
        goto L17
    }

    public static final /* synthetic */ float access$calcFraction(float r0, float r1, float r2) {
        return calcFraction(r0, r1, r2);
    }

    private static final Unit awaitSlop_8vUncbI$lambda$49(Ref.FloatRef r0, PointerInputChange r1, float r2) {
        r1.consume();
        r0.element = r2;
        return Unit.INSTANCE;
    }

    private static final float calcFraction(float r2, float r3, float r4) {
        float r5 = r3 - r2;
        if (r5 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        float r6 = MenuKt.ClosedAlphaTarget;
    L10:
        return RangesKt.coerceIn(r6, MenuKt.ClosedAlphaTarget, 1.0f);
    L8:
        r6 = (r4 - r2) / r5;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier r4, final RangeSliderState r5, final boolean r6) {
        final ClosedFloatingPointRange r0 = RangesKt.rangeTo(r5.getActiveRangeStart(), ((Number) r5.getValueRange().getEndInclusive()).floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(r4, false, new bq(r6, r5, r0), 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), r5.getActiveRangeEnd(), r0, r5.getEndSteps$material3());
    }

    private static final boolean rangeSliderEndThumbSemantics$lambda$58$lambda$57(ClosedFloatingPointRange r10, RangeSliderState r11, float r12) {
        float r13 = RangesKt.coerceIn(r12, ((Number) r10.getStart()).floatValue(), ((Number) r10.getEndInclusive()).floatValue());
        if (r11.getEndSteps$material3() <= 0) goto L14;
        int r0 = r11.getEndSteps$material3() + 1;
        if (r0 < 0) goto L14;
        float r4 = r13;
        float r5 = r4;
        int r3 = 0;
    L7:
        float r6 = MathHelpersKt.lerp(((Number) r10.getStart()).floatValue(), ((Number) r10.getEndInclusive()).floatValue(), r3 / (r11.getEndSteps$material3() + 1));
        float r7 = r6 - r13;
        if (Math.abs(r7) > r4) goto L10;
        r4 = Math.abs(r7);
        r5 = r6;
    L10:
        if (r3 == r0) goto L12;
        r3 = r3 + 1;
        goto L7
    L12:
        r13 = r5;
    L14:
        if (r13 != r11.getActiveRangeEnd()) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == true) goto L33;
        long r1 = SliderRange(r11.getActiveRangeStart(), r13);
        if (SliderRange.m3185equalsimpl0(r1, SliderRange(r11.getActiveRangeStart(), r11.getActiveRangeEnd())) == false) goto L22;
    L27:
        Function0<Unit> r15 = r11.getOnValueChangeFinished();
        if (r15 == null) goto L30;
        r15.invoke();
    L30:
        return true;
    L22:
        if (r11.getOnValueChange$material3() == null) goto L26;
        Function1<SliderRange, Unit> r16 = r11.getOnValueChange$material3();
        if (r16 == null) goto L27;
        r16.invoke(SliderRange.m3182boximpl(r1));
        goto L27
    L26:
        r11.setActiveRangeStart(SliderRange.m3187getStartimpl(r1));
        r11.setActiveRangeEnd(SliderRange.m3186getEndInclusiveimpl(r1));
        goto L27
    L33:
        return false;
    L16:
        r14 = false;
        goto L17
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier r4, final RangeSliderState r5, final boolean r6) {
        final ClosedFloatingPointRange r0 = RangesKt.rangeTo(((Number) r5.getValueRange().getStart()).floatValue(), r5.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(r4, false, new vp(r6, r5, r0), 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), r5.getActiveRangeStart(), r0, r5.getStartSteps$material3());
    }

    private static final boolean rangeSliderStartThumbSemantics$lambda$55$lambda$54(ClosedFloatingPointRange r10, RangeSliderState r11, float r12) {
        float r13 = RangesKt.coerceIn(r12, ((Number) r10.getStart()).floatValue(), ((Number) r10.getEndInclusive()).floatValue());
        if (r11.getStartSteps$material3() <= 0) goto L14;
        int r0 = r11.getStartSteps$material3() + 1;
        if (r0 < 0) goto L14;
        float r4 = r13;
        float r5 = r4;
        int r3 = 0;
    L7:
        float r6 = MathHelpersKt.lerp(((Number) r10.getStart()).floatValue(), ((Number) r10.getEndInclusive()).floatValue(), r3 / (r11.getStartSteps$material3() + 1));
        float r7 = r6 - r13;
        if (Math.abs(r7) > r4) goto L10;
        r4 = Math.abs(r7);
        r5 = r6;
    L10:
        if (r3 == r0) goto L12;
        r3 = r3 + 1;
        goto L7
    L12:
        r13 = r5;
    L14:
        if (r13 != r11.getActiveRangeStart()) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == true) goto L33;
        long r1 = SliderRange(r13, r11.getActiveRangeEnd());
        if (SliderRange.m3185equalsimpl0(r1, SliderRange(r11.getActiveRangeStart(), r11.getActiveRangeEnd())) == false) goto L22;
    L27:
        Function0<Unit> r15 = r11.getOnValueChangeFinished();
        if (r15 == null) goto L30;
        r15.invoke();
    L30:
        return true;
    L22:
        if (r11.getOnValueChange$material3() == null) goto L26;
        Function1<SliderRange, Unit> r16 = r11.getOnValueChange$material3();
        if (r16 == null) goto L27;
        r16.invoke(SliderRange.m3182boximpl(r1));
        goto L27
    L26:
        r11.setActiveRangeStart(SliderRange.m3187getStartimpl(r1));
        r11.setActiveRangeEnd(SliderRange.m3186getEndInclusiveimpl(r1));
        goto L27
    L33:
        return false;
    L16:
        r14 = false;
        goto L17
    }

    private static final Modifier sliderSemantics(Modifier r3, final SliderState r4, final boolean r5) {
        Modifier r6 = SemanticsModifierKt.semantics$default(r3, false, new zp(r5, r4), 1, null);
        if (r4.getOrientation$material3() != Orientation.Vertical) goto L5;
        Modifier r7 = AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds();
    L7:
        return ProgressSemanticsKt.progressSemantics(r6.then(r7), r4.getValue(), RangesKt.rangeTo(((Number) r4.getValueRange().getStart()).floatValue(), ((Number) r4.getValueRange().getEndInclusive()).floatValue()), r4.getSteps());
    L5:
        r7 = AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds();
        goto L7
    }

    private static final Unit sliderSemantics$lambda$52(boolean r1, final SliderState r2, SemanticsPropertyReceiver r3) {
        if (r1 == true) goto L4;
        SemanticsPropertiesKt.disabled(r3);
    L4:
        SemanticsPropertiesKt.setStateDescription(r3, formatForSemantics(r2.getValue()));
        SemanticsPropertiesKt.setProgress$default(r3, null, new fq(r2), 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$awaitSlop-8vUncbI, reason: not valid java name */
    public static final /* synthetic */ Object m3172access$awaitSlop8vUncbI(AwaitPointerEventScope r0, long r1, int r3, Continuation r4) {
        return m3174awaitSlop8vUncbI(r0, r1, r3, r4);
    }

    public static final /* synthetic */ float access$snapValueToTick(float r0, float[] r1, float r2, float r3) {
        return snapValueToTick(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    private static final Object m3174awaitSlop8vUncbI(AwaitPointerEventScope r8, long r9, int r11, Continuation<? super Pair<PointerInputChange, Float>> r12) {
        if ((r12 instanceof SliderKt$awaitSlop$1) == false) goto L7;
        SliderKt$awaitSlop$1 r0 = (SliderKt$awaitSlop$1) r12;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        SliderKt$awaitSlop$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.FloatRef r10 = (Ref.FloatRef) r6.L$0;
        ResultKt.throwOnFailure(r13);
    L18:
        PointerInputChange r14 = (PointerInputChange) r13;
        if (r14 != null) goto L23;
        return null;
    L23:
        return TuplesKt.to(r14, Boxing.boxFloat(r10.element));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        final Ref.FloatRef r15 = new Ref.FloatRef();
        Function2 r5 = new up(r15);
        r6.L$0 = r15;
        r6.label = 1;
        Object r16 = DragGestureDetectorCopyKt.awaitHorizontalPointerSlopOrCancellation-gDDlDlE(r8, r9, r11, r5, r6);
        if (r16 != r2) goto L17;
        return r2;
    L17:
        r13 = r16;
        r10 = r15;
    L7:
        r0 = new SliderKt$awaitSlop$1(r12);
        goto L8
    }

    private static final Unit rangeSliderEndThumbSemantics$lambda$58(boolean r0, final RangeSliderState r1, final ClosedFloatingPointRange r2, SemanticsPropertyReceiver r3) {
        if (r0 == true) goto L4;
        SemanticsPropertiesKt.disabled(r3);
    L4:
        SemanticsPropertiesKt.setStateDescription(r3, formatForSemantics(r1.getActiveRangeEnd()));
        SemanticsPropertiesKt.setProgress$default(r3, null, new op(r2, r1), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit rangeSliderStartThumbSemantics$lambda$55(boolean r0, final RangeSliderState r1, final ClosedFloatingPointRange r2, SemanticsPropertyReceiver r3) {
        if (r0 == true) goto L4;
        SemanticsPropertiesKt.disabled(r3);
    L4:
        SemanticsPropertiesKt.setStateDescription(r3, formatForSemantics(r1.getActiveRangeStart()));
        SemanticsPropertiesKt.setProgress$default(r3, null, new cq(r2, r1), 1, null);
        return Unit.INSTANCE;
    }

    private static final SliderState rememberSliderState$lambda$60$lambda$59(float r1, int r2, Function0 r3, ClosedFloatingPointRange r4) {
        return new SliderState(r1, r2, r3, r4);
    }

    private static final Modifier sliderTapModifier(Modifier r0, SliderState r1, MutableInteractionSource r2, boolean r3) {
        if (r3 == true) goto L4;
        return r0;
    L4:
        return SuspendingPointerInputFilterKt.pointerInput(r0, r1, r2, new C02791(r1));
    }

    private static final float snapValueToTick(float r7, float[] r8, float r9, float r10) {
        int r2 = 1;
        if (r8.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Float r11 = null;
    L19:
        if (r11 != null) goto L21;
        return r7;
    L21:
        return MathHelpersKt.lerp(r9, r10, r11.floatValue());
    L8:
        float r1 = r8[0];
        int r3 = ArraysKt.getLastIndex(r8);
        if (r3 != 0) goto L11;
        r11 = Float.valueOf(r1);
        goto L19
    L11:
        float r4 = Math.abs(MathHelpersKt.lerp(r9, r10, r1) - r7);
        if (1 > r3) goto L18;
    L13:
        float r5 = r8[r2];
        float r6 = Math.abs(MathHelpersKt.lerp(r9, r10, r5) - r7);
        if (Float.compare(r4, r6) <= 0) goto L16;
        r1 = r5;
        r4 = r6;
    L16:
        if (r2 == r3) goto L18;
        r2 = r2 + 1;
    L18:
        r11 = Float.valueOf(r1);
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    public static final /* synthetic */ float access$scale(float r0, float r1, float r2, float r3, float r4) {
        return scale(r0, r1, r2, r3, r4);
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier r1, final RangeSliderState r2, final MutableInteractionSource r3, final MutableInteractionSource r4, boolean r5) {
        if (r5 == true) goto L4;
        return r1;
    L4:
        return SuspendingPointerInputFilterKt.pointerInput(r1, new Object[]{r3, r4, r2}, new C02771(r2, r3, r4));
    }

    private static final RangeSliderState rememberRangeSliderState$lambda$62$lambda$61(float r7, float r8, int r9, Function0 r10, ClosedFloatingPointRange r11) {
        return new RangeSliderState(r7, r8, r9, r10, r11);
    }

    private static final float scale(float r0, float r1, float r2, float r3, float r4) {
        return MathHelpersKt.lerp(r3, r4, calcFraction(r0, r1, r2));
    }

    /* JADX INFO: renamed from: access$scale-2geJ7wY, reason: not valid java name */
    public static final /* synthetic */ long m3173access$scale2geJ7wY(boolean r0, float r1, float r2, long r3, float r5, float r6) {
        return m3177scale2geJ7wY(r0, r1, r2, r3, r5, r6);
    }

    /* JADX INFO: renamed from: scale-2geJ7wY, reason: not valid java name */
    private static final long m3177scale2geJ7wY(boolean r1, float r2, float r3, long r4, float r6, float r7) {
        float r0 = scale(r2, r3, SliderRange.m3187getStartimpl(r4), r6, r7);
        float r5 = scale(r2, r3, SliderRange.m3186getEndInclusiveimpl(r4), r6, r7);
        if (r1 == false) goto L6;
        return SliderRange(RangesKt.coerceAtMost(r0, r5), r5);
    L6:
        return SliderRange(r0, RangesKt.coerceAtLeast(r5, r0));
    }

    public static final SliderState rememberSliderState(final float r6, final int r7, final Function0<Unit> r8, final ClosedFloatingPointRange<Float> r9, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r6 = MenuKt.ClosedAlphaTarget;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r7 = 0;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r8 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r9 = RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f);
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(1193499219, r11, -1, "androidx.compose.material3.rememberSliderState (Slider.kt:2911)");
    L17:
        Object[] r13 = new Object[0];
        Saver<SliderState, ?> r0 = SliderState.Companion.Saver(r8, r9);
        boolean r4 = true;
        if (((r11 & 14) ^ 6) <= 4) goto L22;
        if (r10.changed(r6) == false) goto L22;
    L23:
        boolean r1 = true;
    L26:
        if (((r11 & 112) ^ 48) <= 32) goto L30;
        if (r10.changed(r7) == false) goto L30;
    L31:
        boolean r3 = true;
    L33:
        boolean r2 = r1 | r3;
        if (((r11 & 896) ^ 384) <= 256) goto L38;
        if (r10.changed(r8) == false) goto L38;
    L39:
        boolean r5 = true;
    L41:
        boolean r14 = r2 | r5;
        if (((r11 & 7168) ^ 3072) <= 2048) goto L46;
        if (r10.changed(r9) == false) goto L46;
    L49:
        boolean r15 = r14 | r4;
        Object r16 = r10.rememberedValue();
        if (r15 == false) goto L52;
    L53:
        r16 = new xp(r6, r7, r8, r9);
        r10.updateRememberedValue(r16);
    L54:
        SliderState r17 = (SliderState) RememberSaveableKt.rememberSaveable(r13, r0, (Function0) r16, r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventEnd();
    L57:
        return r17;
    L52:
        if (r16 != Composer.Companion.getEmpty()) goto L54;
    L46:
        if ((r11 & 3072) == 2048) goto L49;
        r4 = false;
    L38:
        if ((r11 & 384) == 256) goto L39;
        r5 = false;
    L30:
        if ((r11 & 48) == 32) goto L31;
        r3 = false;
    L22:
        if ((r11 & 6) == 4) goto L23;
        r1 = false;
        goto L26
    }

    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    private static final void SliderImpl(final Modifier r33, final SliderState r34, final boolean r35, final MutableInteractionSource r36, final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r37, final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40) {
        Composer r9 = r39.startRestartGroup(898172835);
        if ((r40 & 6) == 0) goto L5;
        int r1 = r40;
    L11:
        if ((r40 & 48) != 0) goto L18;
        if (r9.changedInstance(r34) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r40 & 384) != 0) goto L25;
        if (r9.changed(r35) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r40 & 3072) != 0) goto L32;
        if (r9.changed(r36) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r40 & 24576) != 0) goto L39;
        if (r9.changedInstance(r37) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r40) == 0) goto L41;
    L45:
        int r7 = r1;
        if ((74899 & r7) == 74898) goto L48;
        boolean r6 = true;
    L50:
        if (r9.shouldExecute(r6, r7 & 1) == true) goto L52;
        Composer r8 = r9;
        r8.skipToGroupEnd();
    L135:
        ScopeUpdateScope r10 = r8.endRestartGroup();
        if (r10 == null) goto L139;
        r10.updateScope(new np(r33, r34, r35, r36, r37, r38, r40));
        return;
    L139:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventStart(898172835, r7, -1, "androidx.compose.material3.SliderImpl (Slider.kt:750)");
    L55:
        if (r9.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L57;
        boolean r0 = true;
    L58:
        r34.setRtl$material3(r0);
        if (r34.getOrientation$material3() != Orientation.Horizontal) goto L63;
        if (r34.isRtl$material3() == false) goto L63;
    L66:
        boolean r16 = true;
    L68:
        Modifier r11 = Modifier.Companion;
        Modifier r12 = sliderTapModifier(r11, r34, r36, r35);
        Orientation r13 = r34.getOrientation$material3();
        boolean r17 = r34.isDragging();
        boolean r14 = r9.changedInstance(r34);
        Object r15 = r9.rememberedValue();
        if (r14 == false) goto L71;
    L72:
        r15 = new SliderKt$SliderImpl$drag$1$1(r34, null);
        r9.updateRememberedValue(r15);
    L73:
        Modifier r18 = DraggableKt.draggable$default(r11, r34, r13, r35, r36, r17, null, (Function3) r15, r16, 32, null);
        Orientation r19 = r34.getOrientation$material3();
        Orientation r20 = Orientation.Vertical;
        if (r19 != r20) goto L76;
        Modifier r21 = r11;
        ?? r110 = 0;
        Modifier r22 = SizeKt.wrapContentHeight$default(LayoutIdKt.layoutId(r21, SliderComponents.THUMB), null, false, 3, null);
    L77:
        Modifier r23 = r22;
        Modifier r25 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(r33);
        if (r34.getOrientation$material3() != r20) goto L80;
        float r24 = TrackHeight;
    L81:
        float r26 = r24;
        if (r34.getOrientation$material3() != r20) goto L84;
        float r27 = ThumbWidth;
    L85:
        boolean r28 = r16;
        Modifier r29 = slideOnKeyEvents(FocusableKt.focusable(sliderSemantics(SizeKt.m1010requiredSizeInqDBjuR0$default(r25, r26, r27, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 12, null), r34, r35), r35, r36), r35, r34.getSteps(), r34.getValueRange(), r34.getValue(), r28, r34.getOnValueChange(), r34.getOnValueChangeFinished()).then(r12).then(r18);
        r8 = r9;
        boolean r30 = r8.changedInstance(r34);
        Object r31 = r8.rememberedValue();
        if (r30 == false) goto L88;
    L89:
        r31 = new SliderKt$SliderImpl$2$1(r34);
        r8.updateRememberedValue(r31);
    L90:
        MeasurePolicy r32 = (MeasurePolicy) r31;
        int r41 = ComposablesKt.getCurrentCompositeKeyHash(r8, r110);
        CompositionLocalMap r42 = r8.getCurrentCompositionLocalMap();
        Modifier r43 = ComposedModifierKt.materializeModifier(r8, r29);
        ComposeUiNode.Companion r44 = ComposeUiNode.Companion;
        Function0 r45 = r44.getConstructor();
        if ((r8.getApplier() instanceof Applier) == true) goto L93;
        ComposablesKt.invalidApplier();
    L93:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L96;
        r8.createNode(r45);
    L97:
        Composer r46 = Updater.constructor-impl(r8);
        Updater.set-impl(r46, r32, r44.getSetMeasurePolicy());
        Updater.set-impl(r46, r42, r44.getSetResolvedCompositionLocals());
        Function2 r47 = r44.getSetCompositeKeyHash();
        if (r46.getInserting() == false) goto L100;
    L101:
        r46.updateRememberedValue(Integer.valueOf(r41));
        r46.apply(Integer.valueOf(r41), r47);
    L102:
        Updater.set-impl(r46, r43, r44.getSetModifier());
        boolean r48 = r8.changedInstance(r34);
        Object r49 = r8.rememberedValue();
        if (r48 == false) goto L105;
    L106:
        r49 = new mp(r34);
        r8.updateRememberedValue(r49);
    L107:
        Modifier r50 = OnRemeasuredModifierKt.onSizeChanged(r23, (Function1) r49);
        Alignment.Companion r51 = Alignment.Companion;
        MeasurePolicy r52 = BoxKt.maybeCachedBoxMeasurePolicy(r51.getTopStart(), r110);
        int r53 = ComposablesKt.getCurrentCompositeKeyHash(r8, r110);
        CompositionLocalMap r54 = r8.getCurrentCompositionLocalMap();
        Modifier r55 = ComposedModifierKt.materializeModifier(r8, r50);
        Function0 r56 = r44.getConstructor();
        if ((r8.getApplier() instanceof Applier) == true) goto L110;
        ComposablesKt.invalidApplier();
    L110:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L113;
        r8.createNode(r56);
    L114:
        Composer r57 = Updater.constructor-impl(r8);
        Updater.set-impl(r57, r52, r44.getSetMeasurePolicy());
        Updater.set-impl(r57, r54, r44.getSetResolvedCompositionLocals());
        Function2 r58 = r44.getSetCompositeKeyHash();
        if (r57.getInserting() == false) goto L117;
    L118:
        r57.updateRememberedValue(Integer.valueOf(r53));
        r57.apply(Integer.valueOf(r53), r58);
    L119:
        Updater.set-impl(r57, r55, r44.getSetModifier());
        BoxScopeInstance r59 = BoxScopeInstance.INSTANCE;
        int r60 = (r7 >> 3) & 14;
        r37.invoke(r34, r8, Integer.valueOf(((r7 >> 9) & 112) | r60));
        r8.endNode();
        Modifier r61 = LayoutIdKt.layoutId(r21, SliderComponents.TRACK);
        MeasurePolicy r62 = BoxKt.maybeCachedBoxMeasurePolicy(r51.getTopStart(), r110);
        int r63 = ComposablesKt.getCurrentCompositeKeyHash(r8, r110);
        CompositionLocalMap r64 = r8.getCurrentCompositionLocalMap();
        Modifier r65 = ComposedModifierKt.materializeModifier(r8, r61);
        Function0 r66 = r44.getConstructor();
        if ((r8.getApplier() instanceof Applier) == true) goto L122;
        ComposablesKt.invalidApplier();
    L122:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L125;
        r8.createNode(r66);
    L126:
        Composer r67 = Updater.constructor-impl(r8);
        Updater.set-impl(r67, r62, r44.getSetMeasurePolicy());
        Updater.set-impl(r67, r64, r44.getSetResolvedCompositionLocals());
        Function2 r68 = r44.getSetCompositeKeyHash();
        if (r67.getInserting() == false) goto L129;
    L130:
        r67.updateRememberedValue(Integer.valueOf(r63));
        r67.apply(Integer.valueOf(r63), r68);
    L131:
        Updater.set-impl(r67, r65, r44.getSetModifier());
        r38.invoke(r34, r8, Integer.valueOf(r60 | ((r7 >> 12) & 112)));
        r8.endNode();
        r8.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventEnd();
        goto L135
    L129:
        if (Intrinsics.areEqual(r67.rememberedValue(), Integer.valueOf(r63)) == true) goto L131;
    L125:
        r8.useNode();
        goto L126
    L117:
        if (Intrinsics.areEqual(r57.rememberedValue(), Integer.valueOf(r53)) == true) goto L119;
    L113:
        r8.useNode();
        goto L114
    L105:
        if (r49 != Composer.Companion.getEmpty()) goto L107;
    L100:
        if (Intrinsics.areEqual(r46.rememberedValue(), Integer.valueOf(r41)) == true) goto L102;
    L96:
        r8.useNode();
        goto L97
    L88:
        if (r31 != Composer.Companion.getEmpty()) goto L90;
    L84:
        r27 = TrackHeight;
        goto L85
    L80:
        r24 = ThumbWidth;
        goto L81
    L76:
        r21 = r11;
        r110 = 0;
        r22 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(r21, SliderComponents.THUMB), null, false, 3, null);
        goto L77
    L71:
        if (r15 != Composer.Companion.getEmpty()) goto L73;
    L63:
        if (r34.getOrientation$material3() == Orientation.Vertical) goto L65;
    L67:
        r16 = false;
        goto L68
    L65:
        if (r34.getReverseVerticalDirection$material3() == false) goto L67;
    L57:
        r0 = false;
        goto L58
    L48:
        r6 = false;
        goto L50
    L41:
        if (r9.changedInstance(r38) == false) goto L43;
        int r69 = 131072;
    L44:
        r1 = r1 | r69;
        goto L45
    L43:
        r69 = 65536;
        goto L44
    L5:
        if (r9.changed(r33) == false) goto L7;
        int r70 = 4;
    L8:
        r1 = r70 | r40;
        goto L11
    L7:
        r70 = 2;
        goto L8
    }

    public static final RangeSliderState rememberRangeSliderState(float r8, float r9, int r10, Function0<Unit> r11, ClosedFloatingPointRange<Float> r12, Composer r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        final float r3 = MenuKt.ClosedAlphaTarget;
    L7:
        if ((r15 & 2) == 0) goto L9;
        final float r4 = 1.0f;
    L11:
        if ((r15 & 4) == 0) goto L13;
        final int r5 = 0;
    L15:
        if ((r15 & 8) == 0) goto L17;
        r11 = null;
    L17:
        final Function0<Unit> r6 = r11;
        if ((r15 & 16) == 0) goto L20;
        r12 = RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f);
    L20:
        final ClosedFloatingPointRange<Float> r7 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(756708139, r14, -1, "androidx.compose.material3.rememberRangeSliderState (Slider.kt:3125)");
    L23:
        Object[] r16 = new Object[0];
        Saver<RangeSliderState, ?> r17 = RangeSliderState.Companion.Saver(r6, r7);
        boolean r18 = true;
        if (((r14 & 14) ^ 6) <= 4) goto L28;
        if (r13.changed(r3) == false) goto L28;
    L29:
        boolean r19 = true;
    L32:
        if (((r14 & 112) ^ 48) <= 32) goto L36;
        if (r13.changed(r4) == false) goto L36;
    L37:
        boolean r110 = true;
    L39:
        boolean r111 = r19 | r110;
        if (((r14 & 896) ^ 384) <= 256) goto L44;
        if (r13.changed(r5) == false) goto L44;
    L45:
        boolean r112 = true;
    L47:
        boolean r113 = r111 | r112;
        if (((r14 & 7168) ^ 3072) <= 2048) goto L52;
        if (r13.changed(r6) == false) goto L52;
    L53:
        boolean r114 = true;
    L55:
        boolean r115 = r113 | r114;
        if (((57344 & r14) ^ 24576) <= 16384) goto L60;
        if (r13.changed(r7) == false) goto L60;
    L63:
        boolean r116 = r115 | r18;
        Object r117 = r13.rememberedValue();
        if (r116 == false) goto L66;
    L67:
        r117 = new aq(r3, r4, r5, r6, r7);
        r13.updateRememberedValue(r117);
    L68:
        RangeSliderState r20 = (RangeSliderState) RememberSaveableKt.rememberSaveable(r16, r17, (Function0) r117, r13, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventEnd();
    L71:
        return r20;
    L66:
        if (r117 != Composer.Companion.getEmpty()) goto L68;
    L60:
        if ((r14 & 24576) == 16384) goto L63;
        r18 = false;
    L52:
        if ((r14 & 3072) == 2048) goto L53;
        r114 = false;
    L44:
        if ((r14 & 384) == 256) goto L45;
        r112 = false;
    L36:
        if ((r14 & 48) == 32) goto L37;
        r110 = false;
    L28:
        if ((r14 & 6) == 4) goto L29;
        r19 = false;
        goto L32
    L13:
        r5 = r10;
        goto L15
    L9:
        r4 = r9;
        goto L11
    L5:
        r3 = r8;
        goto L7
    }

    private static final Modifier slideOnKeyEvents(Modifier r9, final boolean r10, final int r11, final ClosedFloatingPointRange<Float> r12, final float r13, final boolean r14, final Function1<? super Float, Unit> r15, final Function0<Unit> r16) {
        if (r11 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        return KeyInputModifierKt.onKeyEvent(r9, new C02782(r10, r15, r12, r11, r14, r13, r16));
    L9:
        throw new IllegalArgumentException("steps should be >= 0".toString());
    L4:
        r0 = false;
        goto L5
    }

    private static final void RangeSliderImpl(final Modifier r23, final RangeSliderState r24, final boolean r25, final MutableInteractionSource r26, final MutableInteractionSource r27, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r28, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r29, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32) {
        Composer r1 = r31.startRestartGroup(-287468326);
        if ((r32 & 6) == 0) goto L5;
        int r11 = r32;
    L11:
        if ((r32 & 48) != 0) goto L18;
        if (r1.changedInstance(r24) == false) goto L15;
        int r12 = 32;
    L16:
        r11 = r11 | r12;
        goto L18
    L15:
        r12 = 16;
    L18:
        if ((r32 & 384) != 0) goto L25;
        if (r1.changed(r25) == false) goto L22;
        int r13 = 256;
    L23:
        r11 = r11 | r13;
        goto L25
    L22:
        r13 = 128;
    L25:
        if ((r32 & 3072) != 0) goto L32;
        if (r1.changed(r26) == false) goto L29;
        int r14 = 2048;
    L30:
        r11 = r11 | r14;
        goto L32
    L29:
        r14 = 1024;
    L32:
        if ((r32 & 24576) != 0) goto L39;
        if (r1.changed(r27) == false) goto L36;
        int r15 = 16384;
    L37:
        r11 = r11 | r15;
        goto L39
    L36:
        r15 = 8192;
    L39:
        if ((196608 & r32) != 0) goto L46;
        if (r1.changedInstance(r28) == false) goto L43;
        int r16 = 131072;
    L44:
        r11 = r11 | r16;
        goto L46
    L43:
        r16 = 65536;
    L46:
        if ((1572864 & r32) != 0) goto L53;
        if (r1.changedInstance(r29) == false) goto L50;
        int r17 = 1048576;
    L51:
        r11 = r11 | r17;
        goto L53
    L50:
        r17 = 524288;
    L53:
        if ((12582912 & r32) != 0) goto L60;
        if (r1.changedInstance(r30) == false) goto L57;
        int r18 = 8388608;
    L58:
        r11 = r11 | r18;
        goto L60
    L57:
        r18 = 4194304;
    L60:
        if ((4793491 & r11) == 4793490) goto L62;
        boolean r19 = true;
    L64:
        if (r1.shouldExecute(r19, r11 & 1) == true) goto L66;
        r1.skipToGroupEnd();
    L149:
        ScopeUpdateScope r10 = r1.endRestartGroup();
        if (r10 == null) goto L153;
        r10.updateScope(new tp(r23, r24, r25, r26, r27, r28, r29, r30, r32));
        return;
    L153:
        return;
    L66:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventStart(-287468326, r11, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:970)");
    L69:
        if (r1.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L71;
        boolean r0 = true;
    L72:
        r24.setRtl$material3(r0);
        Modifier.Companion r2 = Modifier.Companion;
        Modifier r110 = rangeSliderPressDragModifier(r2, r24, r26, r27, r25);
        final String r111 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131913590), r1, 0);
        final String r112 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131913589), r1, 0);
        Modifier r113 = SizeKt.m1010requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(r23), ThumbWidth, TrackHeight, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 12, null).then(r110);
        boolean r114 = r1.changedInstance(r24);
        Object r9 = r1.rememberedValue();
        if (r114 == false) goto L75;
    L76:
        r9 = new SliderKt$RangeSliderImpl$2$1(r24);
        r1.updateRememberedValue(r9);
    L77:
        MeasurePolicy r20 = (MeasurePolicy) r9;
        int r115 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r116 = r1.getCurrentCompositionLocalMap();
        Modifier r117 = ComposedModifierKt.materializeModifier(r1, r113);
        ComposeUiNode.Companion r118 = ComposeUiNode.Companion;
        Function0 r119 = r118.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L80;
        ComposablesKt.invalidApplier();
    L80:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L83;
        r1.createNode(r119);
    L84:
        Composer r8 = Updater.constructor-impl(r1);
        Updater.set-impl(r8, r20, r118.getSetMeasurePolicy());
        Updater.set-impl(r8, r116, r118.getSetResolvedCompositionLocals());
        Function2 r21 = r118.getSetCompositeKeyHash();
        if (r8.getInserting() == false) goto L87;
    L88:
        r8.updateRememberedValue(Integer.valueOf(r115));
        r8.apply(Integer.valueOf(r115), r21);
    L89:
        Updater.set-impl(r8, r117, r118.getSetModifier());
        Modifier r22 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(r2, RangeSliderComponents.STARTTHUMB), null, false, 3, null);
        boolean r120 = r1.changedInstance(r24);
        Object r121 = r1.rememberedValue();
        if (r120 == false) goto L92;
    L93:
        r121 = new pp(r24);
        r1.updateRememberedValue(r121);
    L94:
        Modifier r33 = rangeSliderStartThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(r22, (Function1) r121), r24, r25);
        boolean r122 = r1.changed(r111);
        Object r123 = r1.rememberedValue();
        if (r122 == false) goto L97;
    L98:
        r123 = new qp(r111);
        r1.updateRememberedValue(r123);
    L99:
        Modifier r34 = FocusableKt.focusable(SemanticsModifierKt.semantics(r33, true, (Function1) r123), r25, r26);
        Alignment.Companion r124 = Alignment.Companion;
        MeasurePolicy r125 = BoxKt.maybeCachedBoxMeasurePolicy(r124.getTopStart(), false);
        int r126 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r127 = r1.getCurrentCompositionLocalMap();
        Modifier r35 = ComposedModifierKt.materializeModifier(r1, r34);
        Function0 r36 = r118.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L102;
        ComposablesKt.invalidApplier();
    L102:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L105;
        r1.createNode(r36);
    L106:
        Composer r37 = Updater.constructor-impl(r1);
        Updater.set-impl(r37, r125, r118.getSetMeasurePolicy());
        Updater.set-impl(r37, r127, r118.getSetResolvedCompositionLocals());
        Function2 r128 = r118.getSetCompositeKeyHash();
        if (r37.getInserting() == false) goto L109;
    L110:
        r37.updateRememberedValue(Integer.valueOf(r126));
        r37.apply(Integer.valueOf(r126), r128);
    L111:
        Updater.set-impl(r37, r35, r118.getSetModifier());
        BoxScopeInstance r38 = BoxScopeInstance.INSTANCE;
        int r39 = (r11 >> 3) & 14;
        r28.invoke(r24, r1, Integer.valueOf(((r11 >> 12) & 112) | r39));
        r1.endNode();
        Modifier r40 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(r2, RangeSliderComponents.ENDTHUMB), null, false, 3, null);
        boolean r129 = r1.changedInstance(r24);
        Object r130 = r1.rememberedValue();
        if (r129 == false) goto L114;
    L115:
        r130 = new rp(r24);
        r1.updateRememberedValue(r130);
    L116:
        Modifier r41 = rangeSliderEndThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(r40, (Function1) r130), r24, r25);
        boolean r131 = r1.changed(r112);
        Object r132 = r1.rememberedValue();
        if (r131 == false) goto L119;
    L120:
        r132 = new sp(r112);
        r1.updateRememberedValue(r132);
    L121:
        Modifier r42 = FocusableKt.focusable(SemanticsModifierKt.semantics(r41, true, (Function1) r132), r25, r27);
        MeasurePolicy r133 = BoxKt.maybeCachedBoxMeasurePolicy(r124.getTopStart(), false);
        int r134 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r135 = r1.getCurrentCompositionLocalMap();
        Modifier r43 = ComposedModifierKt.materializeModifier(r1, r42);
        Function0 r136 = r118.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L124;
        ComposablesKt.invalidApplier();
    L124:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L127;
        r1.createNode(r136);
    L128:
        Composer r3 = Updater.constructor-impl(r1);
        Updater.set-impl(r3, r133, r118.getSetMeasurePolicy());
        Updater.set-impl(r3, r135, r118.getSetResolvedCompositionLocals());
        Function2 r137 = r118.getSetCompositeKeyHash();
        if (r3.getInserting() == false) goto L131;
    L132:
        r3.updateRememberedValue(Integer.valueOf(r134));
        r3.apply(Integer.valueOf(r134), r137);
    L133:
        Updater.set-impl(r3, r43, r118.getSetModifier());
        r29.invoke(r24, r1, Integer.valueOf(((r11 >> 15) & 112) | r39));
        r1.endNode();
        Modifier r4 = LayoutIdKt.layoutId(r2, RangeSliderComponents.TRACK);
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(r124.getTopStart(), false);
        int r44 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r138 = r1.getCurrentCompositionLocalMap();
        Modifier r6 = ComposedModifierKt.materializeModifier(r1, r4);
        Function0 r139 = r118.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L136;
        ComposablesKt.invalidApplier();
    L136:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L139;
        r1.createNode(r139);
    L140:
        Composer r140 = Updater.constructor-impl(r1);
        Updater.set-impl(r140, r5, r118.getSetMeasurePolicy());
        Updater.set-impl(r140, r138, r118.getSetResolvedCompositionLocals());
        Function2 r7 = r118.getSetCompositeKeyHash();
        if (r140.getInserting() == false) goto L143;
    L144:
        r140.updateRememberedValue(Integer.valueOf(r44));
        r140.apply(Integer.valueOf(r44), r7);
    L145:
        Updater.set-impl(r140, r6, r118.getSetModifier());
        r30.invoke(r24, r1, Integer.valueOf(((r11 >> 18) & 112) | r39));
        r1.endNode();
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L149;
        ComposerKt.traceEventEnd();
        goto L149
    L143:
        if (Intrinsics.areEqual(r140.rememberedValue(), Integer.valueOf(r44)) == true) goto L145;
    L139:
        r1.useNode();
        goto L140
    L131:
        if (Intrinsics.areEqual(r3.rememberedValue(), Integer.valueOf(r134)) == true) goto L133;
    L127:
        r1.useNode();
        goto L128
    L119:
        if (r132 != Composer.Companion.getEmpty()) goto L121;
    L114:
        if (r130 != Composer.Companion.getEmpty()) goto L116;
    L109:
        if (Intrinsics.areEqual(r37.rememberedValue(), Integer.valueOf(r126)) == true) goto L111;
    L105:
        r1.useNode();
        goto L106
    L97:
        if (r123 != Composer.Companion.getEmpty()) goto L99;
    L92:
        if (r121 != Composer.Companion.getEmpty()) goto L94;
    L87:
        if (Intrinsics.areEqual(r8.rememberedValue(), Integer.valueOf(r115)) == true) goto L89;
    L83:
        r1.useNode();
        goto L84
    L75:
        if (r9 != Composer.Companion.getEmpty()) goto L77;
    L71:
        r0 = false;
        goto L72
    L62:
        r19 = false;
        goto L64
    L5:
        if (r1.changed(r23) == false) goto L7;
        int r141 = 4;
    L8:
        r11 = r141 | r32;
        goto L11
    L7:
        r141 = 2;
        goto L8
    }

    public static final void Slider(final SliderState r17, Modifier r18, boolean r19, SliderColors r20, MutableInteractionSource r21, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r22, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25, final int r26) {
        Composer r1 = r24.startRestartGroup(409861960);
        if ((r26 & 1) == 0) goto L6;
        int r3 = r25 | 6;
    L13:
        int r4 = r26 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r26 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        final boolean r7 = r19;
    L36:
        if ((r25 & 3072) == 0) goto L38;
        final SliderColors r9 = r20;
    L46:
        int r10 = r26 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        final MutableInteractionSource r11 = r21;
    L57:
        int r12 = r26 & 32;
        if (r12 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r13 = r22;
    L68:
        int r14 = r26 & 64;
        if (r14 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r15 = r23;
    L79:
        boolean r16 = false;
        if ((r3 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L127;
        r1.startDefaults();
        if ((r25 & 1) != 0) goto L88;
    L96:
        if (r4 == 0) goto L98;
        Modifier r2 = Modifier.Companion;
    L99:
        if (r6 == 0) goto L102;
        r7 = true;
    L102:
        if ((r26 & 8) == 0) goto L104;
        r3 = r3 & (-7169);
        r9 = SliderDefaults.INSTANCE.colors(r1, 6);
    L104:
        if (r10 == 0) goto L110;
        Object r5 = r1.rememberedValue();
        if (r5 != Composer.Companion.getEmpty()) goto L108;
        r5 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r5);
    L108:
        r11 = (MutableInteractionSource) r5;
    L110:
        if (r12 == 0) goto L112;
        r13 = ComposableLambdaKt.rememberComposableLambda(-2100927368, true, new AnonymousClass10(r11, r9, r7), r1, 54);
    L112:
        if (r14 != 0) goto L113;
    L94:
        SliderColors r8 = r9;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r27 = r13;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r28 = r15;
    L95:
        int r29 = r3;
        MutableInteractionSource r30 = r11;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventStart(409861960, r29, -1, "androidx.compose.material3.Slider (Slider.kt:371)");
    L118:
        if (r17.getSteps() < 0) goto L120;
        r16 = true;
    L120:
        if (r16 == false) goto L126;
        int r31 = r29 >> 3;
        int r110 = (r31 & 14) | ((r29 << 3) & 112);
        int r111 = ((((r29 & 896) | r110) | (r31 & 7168)) | (57344 & r31)) | (r31 & 458752);
        SliderImpl(r2, r17, r7, r30, r27, r28, r1, r111);
        if (ComposerKt.isTraceInProgress() == false) goto L124;
        ComposerKt.traceEventEnd();
    L124:
        final MutableInteractionSource r32 = r30;
        final boolean r33 = r7;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r34 = r28;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r35 = r27;
        final SliderColors r36 = r8;
        final Modifier r37 = r2;
    L128:
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L132;
        r112.updateScope(new gq(r17, r37, r33, r36, r32, r35, r34, r25, r26));
        return;
    L132:
        return;
    L126:
        throw new IllegalArgumentException("steps should be >= 0".toString());
    L113:
        r28 = ComposableLambdaKt.rememberComposableLambda(-81224541, true, new AnonymousClass11(r7, r9), r1, 54);
        r8 = r9;
        r27 = r13;
        goto L95
    L98:
        r2 = r18;
        goto L99
    L88:
        if (r1.getDefaultsInvalid() == true) goto L96;
        r1.skipToGroupEnd();
        if ((r26 & 8) == 0) goto L93;
        r3 = r3 & (-7169);
    L93:
        r2 = r18;
        goto L94
    L127:
        r1.skipToGroupEnd();
        r37 = r18;
        r33 = r7;
        r36 = r9;
        r32 = r11;
        r35 = r13;
        r34 = r15;
        goto L128
    L82:
        r0 = false;
        goto L84
    L72:
        if ((1572864 & r25) != 0) goto L78;
        r15 = r23;
        if (r1.changedInstance(r15) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L79
    L76:
        r113 = 524288;
        goto L77
    L61:
        if ((196608 & r25) != 0) goto L67;
        r13 = r22;
        if (r1.changedInstance(r13) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L68
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r25 & 24576) != 0) goto L56;
        r11 = r21;
        if (r1.changed(r11) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
        goto L57
    L54:
        r115 = 8192;
        goto L55
    L38:
        if ((r26 & 8) != 0) goto L42;
        r9 = r20;
        if (r1.changed(r9) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
    L43:
        r116 = 1024;
        goto L44
    L42:
        r9 = r20;
        goto L43
    L28:
        if ((r25 & 384) != 0) goto L34;
        r7 = r19;
        if (r1.changed(r7) == false) goto L32;
        int r38 = 256;
    L33:
        r3 = r3 | r38;
        goto L36
    L32:
        r38 = 128;
        goto L33
    L17:
        if ((r25 & 48) != 0) goto L24;
        if (r1.changed(r18) == false) goto L21;
        int r39 = 32;
    L22:
        r3 = r3 | r39;
        goto L24
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r25 & 6) == 0) goto L8;
        r3 = r25;
        goto L13
    L8:
        if (r1.changedInstance(r17) == false) goto L10;
        int r40 = 4;
    L11:
        r3 = r40 | r25;
        goto L13
    L10:
        r40 = 2;
        goto L11
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> r28, final Function1<? super ClosedFloatingPointRange<Float>, Unit> r29, Modifier r30, boolean r31, ClosedFloatingPointRange<Float> r32, int r33, Function0<Unit> r34, SliderColors r35, Composer r36, final int r37, final int r38) {
        Composer r1 = r36.startRestartGroup(-743091416);
        if ((r38 & 1) == 0) goto L6;
        int r3 = r37 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r38 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r30;
    L35:
        int r7 = r38 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        final boolean r8 = r31;
    L47:
        if ((r37 & 24576) == 0) goto L49;
        ClosedFloatingPointRange<Float> r11 = r32;
    L57:
        int r12 = r38 & 32;
        if (r12 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r13 = r33;
    L68:
        int r14 = r38 & 64;
        if (r14 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        Function0<Unit> r15 = r34;
    L80:
        if ((r37 & 12582912) != 0) goto L91;
        if ((r38 & 128) != 0) goto L87;
        if (r1.changed(r35) == false) goto L87;
        int r17 = 8388608;
    L88:
        r3 = r3 | r17;
    L87:
        r17 = 4194304;
    L91:
        if ((r3 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L136;
        r1.startDefaults();
        if ((r37 & 1) != 0) goto L99;
    L109:
        if (r5 == 0) goto L111;
        r6 = Modifier.Companion;
    L111:
        if (r7 == 0) goto L114;
        r8 = true;
    L114:
        if ((r38 & 16) == 0) goto L116;
        r3 = r3 & (-57345);
        r11 = RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f);
    L116:
        if (r12 == 0) goto L118;
        r13 = 0;
    L118:
        if (r14 == 0) goto L121;
        r15 = null;
    L121:
        if ((r38 & 128) != 0) goto L122;
    L107:
        final SliderColors r9 = r35;
    L108:
        int r10 = r3;
        ClosedFloatingPointRange<Float> r2 = r11;
        int r4 = r13;
        Function0<Unit> r16 = r15;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventStart(-743091416, r10, -1, "androidx.compose.material3.RangeSlider (Slider.kt:498)");
    L126:
        Object r18 = r1.rememberedValue();
        Composer.Companion r19 = Composer.Companion;
        if (r18 != r19.getEmpty()) goto L129;
        r18 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r18);
    L129:
        final MutableInteractionSource r110 = (MutableInteractionSource) r18;
        Object r111 = r1.rememberedValue();
        if (r111 != r19.getEmpty()) goto L132;
        r111 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r111);
    L132:
        final MutableInteractionSource r112 = (MutableInteractionSource) r111;
        RangeSlider(r28, r29, r6, r8, r2, r16, null, r110, r112, ComposableLambdaKt.rememberComposableLambda(-811582901, true, new AnonymousClass1(r110, r9, r8), r1, 54), ComposableLambdaKt.rememberComposableLambda(-1832060001, true, new AnonymousClass2(r112, r9, r8), r1, 54), ComposableLambdaKt.rememberComposableLambda(377064480, true, new AnonymousClass3(r8, r9), r1, 54), r4, r1, ((((((r10 & 14) | 918552576) | (r10 & 112)) | (r10 & 896)) | (r10 & 7168)) | (57344 & r10)) | ((r10 >> 3) & 458752), ((r10 >> 9) & 896) | 54, 64);
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventEnd();
    L135:
        final Function0<Unit> r20 = r16;
        final Modifier r21 = r6;
        final boolean r22 = r8;
        final int r23 = r4;
        final SliderColors r24 = r9;
        final ClosedFloatingPointRange<Float> r25 = r2;
    L137:
        ScopeUpdateScope r113 = r1.endRestartGroup();
        if (r113 == null) goto L141;
        r113.updateScope(new lp(r28, r29, r21, r22, r25, r23, r20, r24, r37, r38));
        return;
    L141:
        return;
    L122:
        r3 = r3 & (-29360129);
        r9 = SliderDefaults.INSTANCE.colors(r1, 6);
        goto L108
    L99:
        if (r1.getDefaultsInvalid() == true) goto L109;
        r1.skipToGroupEnd();
        if ((r38 & 16) == 0) goto L105;
        r3 = r3 & (-57345);
    L105:
        if ((r38 & 128) == 0) goto L107;
        r3 = r3 & (-29360129);
        goto L107
    L136:
        r1.skipToGroupEnd();
        r21 = r6;
        r22 = r8;
        r25 = r11;
        r23 = r13;
        r20 = r15;
        r24 = r35;
        goto L137
    L93:
        r0 = false;
        goto L95
    L72:
        if ((1572864 & r37) != 0) goto L78;
        r15 = r34;
        if (r1.changedInstance(r15) == false) goto L76;
        int r114 = 1048576;
    L77:
        r3 = r3 | r114;
        goto L80
    L76:
        r114 = 524288;
        goto L77
    L61:
        if ((196608 & r37) != 0) goto L67;
        r13 = r33;
        if (r1.changed(r13) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
        goto L68
    L65:
        r115 = 65536;
        goto L66
    L49:
        if ((r38 & 16) != 0) goto L53;
        r11 = r32;
        if (r1.changed(r11) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
    L54:
        r116 = 8192;
        goto L55
    L53:
        r11 = r32;
        goto L54
    L39:
        if ((r37 & 3072) != 0) goto L45;
        r8 = r31;
        if (r1.changed(r8) == false) goto L43;
        int r117 = 2048;
    L44:
        r3 = r3 | r117;
        goto L47
    L43:
        r117 = 1024;
        goto L44
    L28:
        if ((r37 & 384) != 0) goto L34;
        r6 = r30;
        if (r1.changed(r6) == false) goto L32;
        int r26 = 256;
    L33:
        r3 = r3 | r26;
        goto L35
    L32:
        r26 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r1.changedInstance(r29) == false) goto L21;
        int r27 = 32;
    L22:
        r3 = r3 | r27;
        goto L24
    L21:
        r27 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r3 = r37;
        goto L14
    L8:
        if (r1.changed(r28) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r37;
        goto L14
    L10:
        r39 = 2;
        goto L11
    }

    public static final void VerticalSlider(final SliderState r18, Modifier r19, boolean r20, boolean r21, SliderColors r22, MutableInteractionSource r23, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r24, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r25, Composer r26, final int r27, final int r28) {
        Composer r2 = r26.startRestartGroup(-1841025790);
        if ((r28 & 1) == 0) goto L6;
        int r3 = r27 | 6;
    L13:
        int r4 = r28 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r28 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r8 = r28 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L47:
        if ((r27 & 24576) == 0) goto L49;
        SliderColors r12 = r22;
    L57:
        int r13 = r28 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        MutableInteractionSource r14 = r23;
    L68:
        int r15 = r28 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r0 = r28 & 128;
        if (r0 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        boolean r17 = false;
        if ((r3 & 4793491) == 4793490) goto L91;
        boolean r5 = true;
    L93:
        if (r2.shouldExecute(r5, r3 & 1) == false) goto L142;
        r2.startDefaults();
        if ((r27 & 1) != 0) goto L97;
    L103:
        if (r4 == 0) goto L105;
        Modifier r7 = Modifier.Companion;
    L106:
        if (r6 == 0) goto L108;
        final boolean r9 = true;
    L109:
        if (r8 == 0) goto L111;
        boolean r10 = false;
    L113:
        if ((r28 & 16) == 0) goto L115;
        final SliderColors r11 = SliderDefaults.INSTANCE.colors(r2, 6);
        r3 = r3 & (-57345);
    L116:
        if (r13 == 0) goto L121;
        Object r16 = r2.rememberedValue();
        if (r16 != Composer.Companion.getEmpty()) goto L120;
        r16 = InteractionSourceKt.MutableInteractionSource();
        r2.updateRememberedValue(r16);
    L120:
        final MutableInteractionSource r29 = (MutableInteractionSource) r16;
    L123:
        if (r15 == 0) goto L125;
        boolean r110 = true;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r111 = ComposableLambdaKt.rememberComposableLambda(1896624690, true, new C02752(r29, r11, r9), r2, 54);
    L126:
        if (r0 == 0) goto L128;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r1 = ComposableLambdaKt.rememberComposableLambda(-1702448035, r110, new C02763(r9, r11), r2, 54);
    L129:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L133;
        ComposerKt.traceEventStart(-1841025790, r3, -1, "androidx.compose.material3.VerticalSlider (Slider.kt:438)");
    L133:
        if (r18.getSteps() < 0) goto L135;
        r17 = true;
    L135:
        if (r17 == false) goto L141;
        r18.setOrientation$material3(Orientation.Vertical);
        r18.setReverseVerticalDirection$material3(r10);
        int r112 = (((r3 >> 3) & 14) | ((r3 << 3) & 112)) | (r3 & 896);
        int r30 = r3 >> 6;
        int r113 = ((r30 & 7168) | r112) | (57344 & r30);
        Modifier r114 = r7;
        boolean r210 = r9;
        MutableInteractionSource r211 = r29;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r212 = r111;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r213 = r1;
        SliderImpl(r114, r18, r210, r211, r212, r213, r2, (r30 & 458752) | r113);
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventEnd();
    L139:
        final boolean r31 = r9;
        final SliderColors r32 = r11;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r33 = r1;
    L143:
        ScopeUpdateScope r115 = r2.endRestartGroup();
        if (r115 == null) goto L147;
        final Modifier r34 = r7;
        final boolean r35 = r10;
        final MutableInteractionSource r36 = r29;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r37 = r111;
        r115.updateScope(new wp(r18, r34, r31, r35, r32, r36, r37, r33, r27, r28));
        return;
    L147:
        return;
    L141:
        throw new IllegalArgumentException("steps should be >= 0".toString());
    L128:
        r1 = r25;
        goto L129
    L125:
        r110 = true;
        r111 = r24;
        goto L126
    L121:
        r29 = r14;
        goto L123
    L115:
        r11 = r12;
        goto L116
    L111:
        r10 = r21;
        goto L113
    L108:
        r9 = r20;
        goto L109
    L105:
        r7 = r19;
        goto L106
    L97:
        if (r2.getDefaultsInvalid() == true) goto L103;
        r2.skipToGroupEnd();
        if ((r28 & 16) == 0) goto L102;
        r3 = r3 & (-57345);
    L102:
        r7 = r19;
        r9 = r20;
        r10 = r21;
        r111 = r24;
        r1 = r25;
        r11 = r12;
        r29 = r14;
        goto L129
    L142:
        r2.skipToGroupEnd();
        r7 = r19;
        r31 = r20;
        r10 = r21;
        r111 = r24;
        r33 = r25;
        r32 = r12;
        r29 = r14;
        goto L143
    L91:
        r5 = false;
        goto L93
    L82:
        if ((r27 & 12582912) != 0) goto L88;
        if (r2.changedInstance(r25) == false) goto L86;
        int r116 = 8388608;
    L87:
        r3 = r3 | r116;
        goto L88
    L86:
        r116 = 4194304;
        goto L87
    L72:
        if ((r27 & 1572864) != 0) goto L78;
        if (r2.changedInstance(r24) == false) goto L76;
        int r117 = 1048576;
    L77:
        r3 = r3 | r117;
        goto L78
    L76:
        r117 = 524288;
        goto L77
    L61:
        if ((196608 & r27) != 0) goto L67;
        r14 = r23;
        if (r2.changed(r14) == false) goto L65;
        int r118 = 131072;
    L66:
        r3 = r3 | r118;
        goto L68
    L65:
        r118 = 65536;
        goto L66
    L49:
        if ((r28 & 16) != 0) goto L53;
        r12 = r22;
        if (r2.changed(r12) == false) goto L54;
        int r119 = 16384;
    L55:
        r3 = r3 | r119;
    L54:
        r119 = 8192;
        goto L55
    L53:
        r12 = r22;
        goto L54
    L39:
        if ((r27 & 3072) != 0) goto L47;
        if (r2.changed(r21) == false) goto L43;
        int r120 = 2048;
    L44:
        r3 = r3 | r120;
        goto L47
    L43:
        r120 = 1024;
        goto L44
    L28:
        if ((r27 & 384) != 0) goto L35;
        if (r2.changed(r20) == false) goto L32;
        int r38 = 256;
    L33:
        r3 = r3 | r38;
        goto L35
    L32:
        r38 = 128;
        goto L33
    L17:
        if ((r27 & 48) != 0) goto L24;
        if (r2.changed(r19) == false) goto L21;
        int r39 = 32;
    L22:
        r3 = r3 | r39;
        goto L24
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r27 & 6) == 0) goto L8;
        r3 = r27;
        goto L13
    L8:
        if (r2.changedInstance(r18) == false) goto L10;
        int r40 = 4;
    L11:
        r3 = r40 | r27;
        goto L13
    L10:
        r40 = 2;
        goto L11
    }

    public static final void RangeSlider(final RangeSliderState r22, Modifier r23, boolean r24, SliderColors r25, MutableInteractionSource r26, MutableInteractionSource r27, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r28, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r29, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(-781154979);
        if ((r33 & 1) == 0) goto L6;
        int r3 = r32 | 6;
    L13:
        int r4 = r33 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r33 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r32 & 3072) != 0) goto L46;
        if ((r33 & 8) != 0) goto L43;
        if (r1.changed(r25) == false) goto L43;
        int r9 = 2048;
    L44:
        r3 = r3 | r9;
    L43:
        r9 = 1024;
    L46:
        int r10 = r33 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        MutableInteractionSource r12 = r26;
    L57:
        int r13 = r33 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        MutableInteractionSource r14 = r27;
    L68:
        int r15 = r33 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r0 = r33 & 128;
        if (r0 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        int r2 = r33 & 256;
        if (r2 == 0) goto L92;
        r3 = r3 | 100663296;
    L98:
        boolean r17 = false;
        if ((r3 & 38347923) == 38347922) goto L101;
        boolean r5 = true;
    L103:
        if (r1.shouldExecute(r5, r3 & 1) == false) goto L159;
        r1.startDefaults();
        if ((r32 & 1) != 0) goto L107;
    L114:
        if (r4 == 0) goto L116;
        Modifier r7 = Modifier.Companion;
    L117:
        if (r6 == 0) goto L119;
        final boolean r8 = true;
    L121:
        if ((r33 & 8) == 0) goto L123;
        final SliderColors r11 = SliderDefaults.INSTANCE.colors(r1, 6);
        r3 = r3 & (-7169);
    L124:
        if (r10 == 0) goto L129;
        Object r16 = r1.rememberedValue();
        if (r16 != Composer.Companion.getEmpty()) goto L128;
        r16 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r16);
    L128:
        final MutableInteractionSource r18 = (MutableInteractionSource) r16;
    L130:
        if (r13 == 0) goto L135;
        Object r19 = r1.rememberedValue();
        if (r19 != Composer.Companion.getEmpty()) goto L134;
        r19 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r19);
    L134:
        final MutableInteractionSource r20 = (MutableInteractionSource) r19;
    L137:
        if (r15 == 0) goto L139;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r110 = ComposableLambdaKt.rememberComposableLambda(1597255314, true, new AnonymousClass14(r18, r11, r8), r1, 54);
    L140:
        if (r0 == 0) goto L142;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r21 = ComposableLambdaKt.rememberComposableLambda(1348023737, true, new AnonymousClass15(r20, r11, r8), r1, 54);
    L143:
        if (r2 == 0) goto L145;
        int r111 = r3;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r34 = ComposableLambdaKt.rememberComposableLambda(-453269015, true, new AnonymousClass16(r8, r11), r1, 54);
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r35 = r21;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r36 = r110;
    L146:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L150;
        ComposerKt.traceEventStart(-781154979, r111, -1, "androidx.compose.material3.RangeSlider (Slider.kt:726)");
    L150:
        if (r22.getSteps() < 0) goto L152;
        r17 = true;
    L152:
        if (r17 == false) goto L158;
        int r37 = r111 >> 3;
        int r112 = (r37 & 14) | ((r111 << 3) & 112);
        int r210 = ((((((r111 & 896) | r112) | (r37 & 7168)) | (57344 & r37)) | (458752 & r37)) | (3670016 & r37)) | (r37 & 29360128);
        RangeSliderImpl(r7, r22, r8, r18, r20, r36, r35, r34, r1, r210);
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventEnd();
    L156:
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r38 = r35;
        final Modifier r39 = r7;
        final SliderColors r40 = r11;
        final MutableInteractionSource r41 = r20;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r42 = r34;
        final boolean r43 = r8;
        final MutableInteractionSource r44 = r18;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r45 = r36;
    L160:
        ScopeUpdateScope r113 = r1.endRestartGroup();
        if (r113 == null) goto L164;
        r113.updateScope(new eq(r22, r39, r43, r40, r44, r41, r45, r38, r42, r32, r33));
        return;
    L164:
        return;
    L158:
        throw new IllegalArgumentException("steps should be >= 0".toString());
    L145:
        r35 = r21;
        r111 = r3;
        r36 = r110;
    L113:
        r34 = r30;
        goto L146
    L142:
        r21 = r29;
        goto L143
    L139:
        r110 = r28;
        goto L140
    L135:
        r20 = r14;
        goto L137
    L129:
        r18 = r12;
        goto L130
    L123:
        r11 = r25;
        goto L124
    L119:
        r8 = r24;
        goto L121
    L116:
        r7 = r23;
        goto L117
    L107:
        if (r1.getDefaultsInvalid() == true) goto L114;
        r1.skipToGroupEnd();
        if ((r33 & 8) == 0) goto L112;
        r3 = r3 & (-7169);
    L112:
        r7 = r23;
        r8 = r24;
        r11 = r25;
        r36 = r28;
        r35 = r29;
        r18 = r12;
        r20 = r14;
        r111 = r3;
        goto L113
    L159:
        r1.skipToGroupEnd();
        r39 = r23;
        r43 = r24;
        r40 = r25;
        r45 = r28;
        r38 = r29;
        r42 = r30;
        r44 = r12;
        r41 = r14;
        goto L160
    L101:
        r5 = false;
        goto L103
    L92:
        if ((r32 & 100663296) != 0) goto L98;
        if (r1.changedInstance(r30) == false) goto L96;
        int r114 = 67108864;
    L97:
        r3 = r3 | r114;
        goto L98
    L96:
        r114 = 33554432;
        goto L97
    L82:
        if ((r32 & 12582912) != 0) goto L88;
        if (r1.changedInstance(r29) == false) goto L86;
        int r115 = 8388608;
    L87:
        r3 = r3 | r115;
        goto L88
    L86:
        r115 = 4194304;
        goto L87
    L72:
        if ((r32 & 1572864) != 0) goto L78;
        if (r1.changedInstance(r28) == false) goto L76;
        int r116 = 1048576;
    L77:
        r3 = r3 | r116;
        goto L78
    L76:
        r116 = 524288;
        goto L77
    L61:
        if ((196608 & r32) != 0) goto L67;
        r14 = r27;
        if (r1.changed(r14) == false) goto L65;
        int r117 = 131072;
    L66:
        r3 = r3 | r117;
        goto L68
    L65:
        r117 = 65536;
        goto L66
    L50:
        if ((r32 & 24576) != 0) goto L56;
        r12 = r26;
        if (r1.changed(r12) == false) goto L54;
        int r118 = 16384;
    L55:
        r3 = r3 | r118;
        goto L57
    L54:
        r118 = 8192;
        goto L55
    L28:
        if ((r32 & 384) != 0) goto L36;
        if (r1.changed(r24) == false) goto L32;
        int r46 = 256;
    L33:
        r3 = r3 | r46;
        goto L36
    L32:
        r46 = 128;
        goto L33
    L17:
        if ((r32 & 48) != 0) goto L24;
        if (r1.changed(r23) == false) goto L21;
        int r47 = 32;
    L22:
        r3 = r3 | r47;
        goto L24
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r3 = r32;
        goto L13
    L8:
        if (r1.changedInstance(r22) == false) goto L10;
        int r48 = 4;
    L11:
        r3 = r48 | r32;
        goto L13
    L10:
        r48 = 2;
        goto L11
    }

    public static final void Slider(final float r27, final Function1<? super Float, Unit> r28, Modifier r29, boolean r30, ClosedFloatingPointRange<Float> r31, int r32, Function0<Unit> r33, SliderColors r34, MutableInteractionSource r35, Composer r36, final int r37, final int r38) {
        Composer r1 = r36.startRestartGroup(-202044027);
        if ((r38 & 1) == 0) goto L6;
        int r3 = r37 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r38 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r7 = r38 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        final boolean r8 = r30;
    L47:
        if ((r37 & 24576) == 0) goto L49;
        ClosedFloatingPointRange<Float> r9 = r31;
    L57:
        int r12 = r38 & 32;
        if (r12 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r13 = r32;
    L68:
        int r14 = r38 & 64;
        if (r14 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        Function0<Unit> r15 = r33;
    L80:
        if ((r37 & 12582912) != 0) goto L90;
        if ((r38 & 128) != 0) goto L87;
        if (r1.changed(r34) == false) goto L87;
        int r17 = 8388608;
    L88:
        r3 = r3 | r17;
    L87:
        r17 = 4194304;
    L90:
        int r0 = r38 & 256;
        if (r0 == 0) goto L94;
        r3 = r3 | 100663296;
    L101:
        if ((r3 & 38347923) == 38347922) goto L103;
        boolean r2 = true;
    L105:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L150;
        r1.startDefaults();
        if ((r37 & 1) != 0) goto L109;
    L119:
        if (r5 == 0) goto L121;
        Modifier r4 = Modifier.Companion;
    L122:
        if (r7 == 0) goto L125;
        r8 = true;
    L125:
        if ((r38 & 16) == 0) goto L127;
        final ClosedFloatingPointRange<Float> r6 = RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f);
        r3 = r3 & (-57345);
    L128:
        if (r12 == 0) goto L130;
        r13 = 0;
    L130:
        if (r14 == 0) goto L132;
        final Function0<Unit> r10 = null;
    L134:
        if ((r38 & 128) == 0) goto L136;
        final SliderColors r11 = SliderDefaults.INSTANCE.colors(r1, 6);
        r3 = r3 & (-29360129);
    L137:
        if (r0 == 0) goto L142;
        Object r16 = r1.rememberedValue();
        if (r16 != Composer.Companion.getEmpty()) goto L141;
        r16 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r16);
    L141:
        int r18 = r3;
        final MutableInteractionSource r19 = (MutableInteractionSource) r16;
        int r20 = r13;
    L143:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L146;
        ComposerKt.traceEventStart(-202044027, r18, -1, "androidx.compose.material3.Slider (Slider.kt:191)");
    L146:
        ComposableLambda r21 = ComposableLambdaKt.rememberComposableLambda(308249025, true, new C02722(r19, r11, r8), r1, 54);
        ComposableLambda r22 = ComposableLambdaKt.rememberComposableLambda(-1843234110, true, new C02733(r8, r11), r1, 54);
        int r23 = ((((r18 & 14) | 905969664) | (r18 & 112)) | (r18 & 896)) | (r18 & 7168);
        int r110 = r18 >> 6;
        Modifier r111 = r4;
        boolean r112 = r8;
        Function0<Unit> r113 = r10;
        SliderColors r114 = r11;
        MutableInteractionSource r115 = r19;
        int r116 = r20;
        ClosedFloatingPointRange<Float> r24 = r6;
        Slider(r27, r28, r111, r112, r113, r114, r115, r116, r21, r22, r24, r1, (((r23 | (57344 & r110)) | (458752 & r110)) | (r110 & 3670016)) | ((r18 << 6) & 29360128), (r18 >> 12) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L149;
        ComposerKt.traceEventEnd();
    L149:
        final int r25 = r20;
        final boolean r26 = r8;
        final SliderColors r39 = r11;
        final MutableInteractionSource r40 = r19;
        final Modifier r41 = r4;
    L151:
        ScopeUpdateScope r117 = r1.endRestartGroup();
        if (r117 == null) goto L155;
        r117.updateScope(new yp(r27, r28, r41, r26, r6, r25, r10, r39, r40, r37, r38));
        return;
    L155:
        return;
    L142:
        r18 = r3;
        r20 = r13;
    L118:
        r19 = r35;
        goto L143
    L136:
        r11 = r34;
        goto L137
    L132:
        r10 = r15;
        goto L134
    L127:
        r6 = r9;
        goto L128
    L121:
        r4 = r29;
        goto L122
    L109:
        if (r1.getDefaultsInvalid() == true) goto L119;
        r1.skipToGroupEnd();
        if ((r38 & 16) == 0) goto L115;
        r3 = r3 & (-57345);
    L115:
        if ((r38 & 128) == 0) goto L117;
        r3 = r3 & (-29360129);
    L117:
        r4 = r29;
        r18 = r3;
        r6 = r9;
        r20 = r13;
        r10 = r15;
        r11 = r34;
        goto L118
    L150:
        r1.skipToGroupEnd();
        r41 = r29;
        r26 = r8;
        r6 = r9;
        r25 = r13;
        r10 = r15;
        r39 = r34;
        r40 = r35;
        goto L151
    L103:
        r2 = false;
        goto L105
    L94:
        if ((r37 & 100663296) != 0) goto L101;
        if (r1.changed(r35) == false) goto L98;
        int r118 = 67108864;
    L99:
        r3 = r3 | r118;
        goto L101
    L98:
        r118 = 33554432;
        goto L99
    L72:
        if ((1572864 & r37) != 0) goto L78;
        r15 = r33;
        if (r1.changedInstance(r15) == false) goto L76;
        int r119 = 1048576;
    L77:
        r3 = r3 | r119;
        goto L80
    L76:
        r119 = 524288;
        goto L77
    L61:
        if ((196608 & r37) != 0) goto L67;
        r13 = r32;
        if (r1.changed(r13) == false) goto L65;
        int r120 = 131072;
    L66:
        r3 = r3 | r120;
        goto L68
    L65:
        r120 = 65536;
        goto L66
    L49:
        if ((r38 & 16) != 0) goto L53;
        r9 = r31;
        if (r1.changed(r9) == false) goto L54;
        int r121 = 16384;
    L55:
        r3 = r3 | r121;
    L54:
        r121 = 8192;
        goto L55
    L53:
        r9 = r31;
        goto L54
    L39:
        if ((r37 & 3072) != 0) goto L45;
        r8 = r30;
        if (r1.changed(r8) == false) goto L43;
        int r42 = 2048;
    L44:
        r3 = r3 | r42;
        goto L47
    L43:
        r42 = 1024;
        goto L44
    L28:
        if ((r37 & 384) != 0) goto L35;
        if (r1.changed(r29) == false) goto L32;
        int r43 = 256;
    L33:
        r3 = r3 | r43;
        goto L35
    L32:
        r43 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r1.changedInstance(r28) == false) goto L21;
        int r44 = 32;
    L22:
        r3 = r3 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r3 = r37;
        goto L14
    L8:
        if (r1.changed(r27) == false) goto L10;
        int r45 = 4;
    L11:
        r3 = r45 | r37;
        goto L14
    L10:
        r45 = 2;
        goto L11
    }

    public static final void Slider(final float r24, final Function1<? super Float, Unit> r25, Modifier r26, boolean r27, Function0<Unit> r28, SliderColors r29, MutableInteractionSource r30, int r31, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r32, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r33, ClosedFloatingPointRange<Float> r34, Composer r35, final int r36, final int r37, final int r38) {
        Composer r3 = r35.startRestartGroup(985901935);
        if ((r38 & 1) == 0) goto L6;
        int r4 = r36 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r7 = r38 & 4;
        if (r7 == 0) goto L27;
        r4 = r4 | 384;
    L34:
        int r9 = r38 & 8;
        if (r9 == 0) goto L38;
        r4 = r4 | 3072;
    L45:
        int r11 = r38 & 16;
        if (r11 == 0) goto L49;
        r4 = r4 | 24576;
    L57:
        if ((196608 & r36) == 0) goto L59;
        SliderColors r15 = r29;
    L67:
        int r16 = r38 & 64;
        if (r16 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r0 = r38 & 128;
        if (r0 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r5 = r38 & 256;
        if (r5 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r6 = r38 & 512;
        if (r6 == 0) goto L101;
        r4 = r4 | 805306368;
    L108:
        if ((r37 & 6) == 0) goto L110;
        int r19 = r37;
    L118:
        boolean r20 = false;
        if ((r4 & 306783379) == 306783378) goto L121;
    L124:
        boolean r8 = true;
    L126:
        if (r3.shouldExecute(r8, r4 & 1) == false) goto L196;
        r3.startDefaults();
        if ((r36 & 1) != 0) goto L130;
    L139:
        if (r7 == 0) goto L141;
        Modifier r10 = Modifier.Companion;
    L142:
        if (r9 == 0) goto L144;
        final boolean r12 = true;
    L145:
        if (r11 == 0) goto L147;
        Function0<Unit> r13 = null;
    L149:
        if ((r38 & 32) == 0) goto L151;
        final SliderColors r14 = SliderDefaults.INSTANCE.colors(r3, 6);
        r4 = r4 & (-458753);
    L152:
        if (r16 == 0) goto L157;
        Object r17 = r3.rememberedValue();
        if (r17 != Composer.Companion.getEmpty()) goto L156;
        r17 = InteractionSourceKt.MutableInteractionSource();
        r3.updateRememberedValue(r17);
    L156:
        final MutableInteractionSource r18 = (MutableInteractionSource) r17;
    L158:
        if (r0 == 0) goto L160;
        int r1 = 0;
    L161:
        if (r5 == 0) goto L163;
        boolean r2 = true;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r21 = ComposableLambdaKt.rememberComposableLambda(-1689130945, true, new AnonymousClass6(r18, r14, r12), r3, 54);
    L164:
        if (r6 == 0) goto L166;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r22 = ComposableLambdaKt.rememberComposableLambda(-294493388, r2, new C02747(r12, r14), r3, 54);
    L168:
        if ((r38 & 1024) == 0) goto L170;
        ClosedFloatingPointRange<Float> r110 = RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f);
        r19 = r19 & (-15);
    L171:
        int r111 = r4;
        int r23 = r19;
        int r39 = r1;
    L172:
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L177;
        ComposerKt.traceEventStart(985901935, r111, r23, "androidx.compose.material3.Slider (Slider.kt:292)");
    L177:
        if ((29360128 & r111) != 8388608) goto L179;
        boolean r112 = true;
    L181:
        if (((r23 & 14) ^ 6) <= 4) goto L185;
        if (r3.changed(r110) == false) goto L185;
    L186:
        r20 = true;
    L187:
        boolean r40 = r112 | r20;
        Object r113 = r3.rememberedValue();
        if (r40 == false) goto L190;
    L191:
        r113 = new SliderState(r24, r39, r13, r110);
        r3.updateRememberedValue(r113);
    L192:
        SliderState r41 = (SliderState) r113;
        r41.setOnValueChangeFinished(r13);
        r41.setOnValueChange(r25);
        r41.setValue(r24);
        int r114 = r111 >> 3;
        int r115 = r114 & 112;
        int r116 = ((r114 & 896) | r115) | ((r111 >> 6) & 57344);
        int r117 = r111 >> 9;
        Modifier r210 = r10;
        boolean r211 = r12;
        MutableInteractionSource r310 = r18;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r311 = r21;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r312 = r22;
        Slider(r41, r210, r211, null, r310, r311, r312, r3, (r116 | (458752 & r117)) | (r117 & 3670016), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L195;
        ComposerKt.traceEventEnd();
    L195:
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r118 = r22;
        final SliderColors r42 = r14;
        boolean r212 = r12;
        final int r43 = r39;
        final boolean r44 = r212;
        Function0<Unit> r213 = r13;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r45 = r21;
        final Function0<Unit> r46 = r213;
    L197:
        ScopeUpdateScope r119 = r3.endRestartGroup();
        if (r119 == null) goto L201;
        final Modifier r47 = r10;
        final MutableInteractionSource r48 = r18;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> r120 = r118;
        final ClosedFloatingPointRange<Float> r121 = r110;
        r119.updateScope(new dq(r24, r25, r47, r44, r46, r42, r48, r43, r45, r120, r121, r36, r37, r38));
        return;
    L201:
        return;
    L190:
        if (r113 != Composer.Companion.getEmpty()) goto L192;
    L185:
        if ((r23 & 6) != 4) goto L187;
    L179:
        r112 = false;
        goto L181
    L170:
        r110 = r34;
        goto L171
    L166:
        r22 = r33;
        goto L168
    L163:
        r2 = true;
        r21 = r32;
        goto L164
    L160:
        r1 = r31;
        goto L161
    L157:
        r18 = r30;
        goto L158
    L151:
        r14 = r15;
        goto L152
    L147:
        r13 = r28;
        goto L149
    L144:
        r12 = r27;
        goto L145
    L141:
        r10 = r26;
        goto L142
    L130:
        if (r3.getDefaultsInvalid() == true) goto L139;
        r3.skipToGroupEnd();
        if ((r38 & 32) == 0) goto L136;
        r4 = r4 & (-458753);
    L136:
        if ((r38 & 1024) == 0) goto L138;
        r19 = r19 & (-15);
    L138:
        r10 = r26;
        r12 = r27;
        r13 = r28;
        r18 = r30;
        r21 = r32;
        r22 = r33;
        r110 = r34;
        r14 = r15;
        r23 = r19;
        r111 = r4;
        r39 = r31;
        goto L172
    L196:
        r3.skipToGroupEnd();
        r10 = r26;
        r44 = r27;
        r46 = r28;
        r18 = r30;
        r43 = r31;
        r45 = r32;
        r118 = r33;
        r110 = r34;
        r42 = r15;
        goto L197
    L121:
        if ((r19 & 3) != 2) goto L124;
        r8 = false;
        goto L126
    L110:
        if ((r38 & 1024) != 0) goto L115;
        if (r3.changed(r34) == false) goto L115;
        int r122 = 4;
    L116:
        r19 = r37 | r122;
    L115:
        r122 = 2;
        goto L116
    L101:
        if ((r36 & 805306368) != 0) goto L108;
        if (r3.changedInstance(r33) == false) goto L105;
        int r123 = 536870912;
    L106:
        r4 = r4 | r123;
        goto L108
    L105:
        r123 = 268435456;
        goto L106
    L91:
        if ((r36 & 100663296) != 0) goto L97;
        if (r3.changedInstance(r32) == false) goto L95;
        int r124 = 67108864;
    L96:
        r4 = r4 | r124;
        goto L97
    L95:
        r124 = 33554432;
        goto L96
    L81:
        if ((r36 & 12582912) != 0) goto L87;
        if (r3.changed(r31) == false) goto L85;
        int r125 = 8388608;
    L86:
        r4 = r4 | r125;
        goto L87
    L85:
        r125 = 4194304;
        goto L86
    L71:
        if ((r36 & 1572864) != 0) goto L77;
        if (r3.changed(r30) == false) goto L75;
        int r126 = 1048576;
    L76:
        r4 = r4 | r126;
        goto L77
    L75:
        r126 = 524288;
        goto L76
    L59:
        if ((r38 & 32) != 0) goto L63;
        r15 = r29;
        if (r3.changed(r15) == false) goto L64;
        int r127 = 131072;
    L65:
        r4 = r4 | r127;
    L64:
        r127 = 65536;
        goto L65
    L63:
        r15 = r29;
        goto L64
    L49:
        if ((r36 & 24576) != 0) goto L57;
        if (r3.changedInstance(r28) == false) goto L53;
        int r128 = 16384;
    L54:
        r4 = r4 | r128;
        goto L57
    L53:
        r128 = 8192;
        goto L54
    L38:
        if ((r36 & 3072) != 0) goto L45;
        if (r3.changed(r27) == false) goto L42;
        int r129 = 2048;
    L43:
        r4 = r4 | r129;
        goto L45
    L42:
        r129 = 1024;
        goto L43
    L27:
        if ((r36 & 384) != 0) goto L34;
        if (r3.changed(r26) == false) goto L31;
        int r49 = 256;
    L32:
        r4 = r4 | r49;
        goto L34
    L31:
        r49 = 128;
        goto L32
    L17:
        if ((r36 & 48) != 0) goto L23;
        if (r3.changedInstance(r25) == false) goto L21;
        int r50 = 32;
    L22:
        r4 = r4 | r50;
        goto L23
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r4 = r36;
        goto L14
    L8:
        if (r3.changed(r24) == false) goto L10;
        int r51 = 4;
    L11:
        r4 = r51 | r36;
        goto L14
    L10:
        r51 = 2;
        goto L11
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> r28, final Function1<? super ClosedFloatingPointRange<Float>, Unit> r29, Modifier r30, boolean r31, ClosedFloatingPointRange<Float> r32, Function0<Unit> r33, SliderColors r34, MutableInteractionSource r35, MutableInteractionSource r36, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r37, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r38, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r39, int r40, Composer r41, final int r42, final int r43, final int r44) {
        Composer r1 = r41.startRestartGroup(1924256162);
        if ((r44 & 1) == 0) goto L6;
        int r6 = r42 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L23:
        int r7 = r44 & 4;
        if (r7 == 0) goto L27;
        r6 = r6 | 384;
    L34:
        int r16 = r44 & 8;
        if (r16 == 0) goto L38;
        r6 = r6 | 3072;
    L46:
        if ((r42 & 24576) != 0) goto L56;
        if ((r44 & 16) != 0) goto L53;
        if (r1.changed(r32) == false) goto L53;
        int r19 = 16384;
    L54:
        r6 = r6 | r19;
    L53:
        r19 = 8192;
    L56:
        int r110 = r44 & 32;
        if (r110 == 0) goto L60;
        r6 = r6 | 196608;
    L67:
        if ((r42 & 1572864) != 0) goto L76;
        if ((r44 & 64) == 0) goto L71;
    L73:
        int r22 = 524288;
    L74:
        r6 = r6 | r22;
        goto L76
    L71:
        if (r1.changed(r34) == false) goto L73;
        r22 = 1048576;
    L76:
        int r9 = r44 & 128;
        if (r9 == 0) goto L80;
        r6 = r6 | 12582912;
    L86:
        int r0 = r44 & 256;
        if (r0 == 0) goto L90;
        r6 = r6 | 100663296;
    L96:
        int r3 = r44 & 512;
        if (r3 == 0) goto L100;
        r6 = r6 | 805306368;
    L106:
        int r4 = r44 & 1024;
        if (r4 == 0) goto L110;
        int r17 = r43 | 6;
    L117:
        int r5 = r44 & 2048;
        if (r5 == 0) goto L121;
        r17 = r17 | 48;
    L127:
        int r8 = r17;
        int r10 = r44 & 4096;
        if (r10 == 0) goto L131;
        r8 = r8 | 384;
    L138:
        boolean r18 = false;
        if ((r6 & 306783379) == 306783378) goto L141;
    L144:
        boolean r11 = true;
    L146:
        if (r1.shouldExecute(r11, r6 & 1) == false) goto L236;
        r1.startDefaults();
        if ((r42 & 1) != 0) goto L150;
    L159:
        if (r7 == 0) goto L161;
        Modifier r12 = Modifier.Companion;
    L162:
        if (r16 == 0) goto L164;
        final boolean r13 = true;
    L166:
        if ((r44 & 16) == 0) goto L168;
        ClosedFloatingPointRange<Float> r14 = RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f);
        r6 = r6 & (-57345);
    L169:
        if (r110 == 0) goto L171;
        Function0<Unit> r15 = null;
    L172:
        Modifier r310 = r12;
        if ((r44 & 64) == 0) goto L175;
        final SliderColors r20 = SliderDefaults.INSTANCE.colors(r1, 6);
        r6 = r6 & (-3670017);
    L176:
        if (r9 == 0) goto L181;
        Object r21 = r1.rememberedValue();
        if (r21 != Composer.Companion.getEmpty()) goto L180;
        r21 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r21);
    L180:
        final MutableInteractionSource r23 = (MutableInteractionSource) r21;
    L182:
        if (r0 == 0) goto L187;
        Object r2 = r1.rememberedValue();
        if (r2 != Composer.Companion.getEmpty()) goto L186;
        r2 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r2);
    L186:
        final MutableInteractionSource r24 = (MutableInteractionSource) r2;
    L189:
        if (r3 == 0) goto L191;
        Function3<RangeSliderState, Composer, Integer, Unit> r25 = new AnonymousClass7(r23, r20, r13);
        boolean r26 = true;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r27 = ComposableLambdaKt.rememberComposableLambda(-743960051, true, r25, r1, 54);
    L192:
        if (r4 == 0) goto L194;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r45 = ComposableLambdaKt.rememberComposableLambda(1306751174, r26, new AnonymousClass8(r24, r20, r13), r1, 54);
    L195:
        if (r5 == 0) goto L197;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r46 = ComposableLambdaKt.rememberComposableLambda(-1234185578, r26, new AnonymousClass9(r13, r20), r1, 54);
    L198:
        int r47 = r6;
        if (r10 == 0) goto L201;
        int r111 = 0;
    L202:
        MutableInteractionSource r48 = r24;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r49 = r27;
        Modifier r50 = r310;
        ClosedFloatingPointRange<Float> r51 = r14;
    L203:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L208;
        ComposerKt.traceEventStart(1924256162, r47, r8, "androidx.compose.material3.RangeSlider (Slider.kt:624)");
    L208:
        if ((r8 & 896) != 256) goto L210;
        boolean r52 = true;
    L212:
        if (((57344 & r47) ^ 24576) <= 16384) goto L216;
        if (r1.changed(r51) == false) goto L216;
    L217:
        boolean r112 = true;
    L219:
        boolean r53 = r52 | r112;
        Object r113 = r1.rememberedValue();
        if (r53 == false) goto L222;
    L223:
        r113 = new RangeSliderState(((Number) r28.getStart()).floatValue(), ((Number) r28.getEndInclusive()).floatValue(), r111, r15, r51);
        r1.updateRememberedValue(r113);
    L224:
        RangeSliderState r54 = (RangeSliderState) r113;
        r54.setOnValueChangeFinished(r15);
        if ((r47 & 112) != 32) goto L227;
        r18 = true;
    L227:
        Object r114 = r1.rememberedValue();
        if (r18 == false) goto L230;
    L231:
        r114 = new hq(r29);
        r1.updateRememberedValue(r114);
    L232:
        r54.setOnValueChange$material3((Function1) r114);
        r54.setActiveRangeStart(((Number) r28.getStart()).floatValue());
        r54.setActiveRangeEnd(((Number) r28.getEndInclusive()).floatValue());
        int r115 = r47 >> 3;
        int r55 = r47 >> 9;
        int r116 = (((r115 & 112) | (r115 & 896)) | (r55 & 57344)) | (r55 & 458752);
        int r56 = r8 << 21;
        int r57 = ((r55 & 3670016) | r116) | (29360128 & r56);
        Modifier r311 = r50;
        boolean r312 = r13;
        MutableInteractionSource r313 = r23;
        MutableInteractionSource r314 = r48;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r315 = r49;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r316 = r45;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r317 = r46;
        RangeSlider(r54, r311, r312, null, r313, r314, r315, r316, r317, r1, (r56 & 234881024) | r57, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L235;
        ComposerKt.traceEventEnd();
    L235:
        final MutableInteractionSource r58 = r48;
        final boolean r59 = r13;
        final int r117 = r111;
        final MutableInteractionSource r60 = r23;
        final SliderColors r61 = r20;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r118 = r45;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r119 = r46;
        final Function0<Unit> r62 = r15;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> r120 = r49;
        final ClosedFloatingPointRange<Float> r63 = r51;
        final Modifier r64 = r50;
    L237:
        ScopeUpdateScope r121 = r1.endRestartGroup();
        if (r121 == null) goto L241;
        r121.updateScope(new iq(r28, r29, r64, r59, r63, r62, r61, r60, r58, r120, r118, r119, r117, r42, r43, r44));
        return;
    L241:
        return;
    L230:
        if (r114 != Composer.Companion.getEmpty()) goto L232;
    L222:
        if (r113 != Composer.Companion.getEmpty()) goto L224;
    L216:
        if ((r47 & 24576) == 16384) goto L217;
        r112 = false;
        goto L219
    L210:
        r52 = false;
        goto L212
    L201:
        r111 = r40;
        goto L202
    L197:
        r46 = r39;
        goto L198
    L194:
        r45 = r38;
        goto L195
    L191:
        r26 = true;
        r27 = r37;
        goto L192
    L187:
        r24 = r36;
        goto L189
    L181:
        r23 = r35;
        goto L182
    L175:
        r20 = r34;
        goto L176
    L171:
        r15 = r33;
        goto L172
    L168:
        r14 = r32;
        goto L169
    L164:
        r13 = r31;
        goto L166
    L161:
        r12 = r30;
        goto L162
    L150:
        if (r1.getDefaultsInvalid() == true) goto L159;
        r1.skipToGroupEnd();
        if ((r44 & 16) == 0) goto L156;
        r6 = r6 & (-57345);
    L156:
        if ((r44 & 64) == 0) goto L158;
        r6 = r6 & (-3670017);
    L158:
        r50 = r30;
        r13 = r31;
        r51 = r32;
        r15 = r33;
        r20 = r34;
        r23 = r35;
        r48 = r36;
        r49 = r37;
        r46 = r39;
        r111 = r40;
        r47 = r6;
        r45 = r38;
        goto L203
    L236:
        r1.skipToGroupEnd();
        r64 = r30;
        r59 = r31;
        r63 = r32;
        r62 = r33;
        r61 = r34;
        r60 = r35;
        r58 = r36;
        r120 = r37;
        r118 = r38;
        r119 = r39;
        r117 = r40;
        goto L237
    L141:
        if ((r8 & 147) != 146) goto L144;
        r11 = false;
        goto L146
    L131:
        if ((r43 & 384) != 0) goto L138;
        if (r1.changed(r40) == false) goto L135;
        int r210 = 256;
    L136:
        r8 = r8 | r210;
        goto L138
    L135:
        r210 = 128;
        goto L136
    L121:
        if ((r43 & 48) != 0) goto L127;
        if (r1.changedInstance(r39) == false) goto L125;
        int r122 = 32;
    L126:
        r17 = r17 | r122;
        goto L127
    L125:
        r122 = 16;
        goto L126
    L110:
        if ((r43 & 6) == 0) goto L112;
        r17 = r43;
        goto L117
    L112:
        if (r1.changedInstance(r38) == false) goto L114;
        int r123 = 4;
    L115:
        r17 = r43 | r123;
        goto L117
    L114:
        r123 = 2;
        goto L115
    L100:
        if ((r42 & 805306368) != 0) goto L106;
        if (r1.changedInstance(r37) == false) goto L104;
        int r211 = 536870912;
    L105:
        r6 = r6 | r211;
        goto L106
    L104:
        r211 = 268435456;
        goto L105
    L90:
        if ((r42 & 100663296) != 0) goto L96;
        if (r1.changed(r36) == false) goto L94;
        int r212 = 67108864;
    L95:
        r6 = r6 | r212;
        goto L96
    L94:
        r212 = 33554432;
        goto L95
    L80:
        if ((r42 & 12582912) != 0) goto L86;
        if (r1.changed(r35) == false) goto L84;
        int r213 = 8388608;
    L85:
        r6 = r6 | r213;
        goto L86
    L84:
        r213 = 4194304;
        goto L85
    L60:
        if ((r42 & 196608) != 0) goto L67;
        if (r1.changedInstance(r33) == false) goto L64;
        int r214 = 131072;
    L65:
        r6 = r6 | r214;
        goto L67
    L64:
        r214 = 65536;
        goto L65
    L38:
        if ((r42 & 3072) != 0) goto L46;
        if (r1.changed(r31) == false) goto L42;
        int r124 = 2048;
    L43:
        r6 = r6 | r124;
        goto L46
    L42:
        r124 = 1024;
        goto L43
    L27:
        if ((r42 & 384) != 0) goto L34;
        if (r1.changed(r30) == false) goto L31;
        int r125 = 256;
    L32:
        r6 = r6 | r125;
        goto L34
    L31:
        r125 = 128;
        goto L32
    L17:
        if ((r42 & 48) != 0) goto L23;
        if (r1.changedInstance(r29) == false) goto L21;
        int r65 = 32;
    L22:
        r6 = r6 | r65;
        goto L23
    L21:
        r65 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r6 = r42;
        goto L14
    L8:
        if (r1.changed(r28) == false) goto L10;
        int r66 = 4;
    L11:
        r6 = r66 | r42;
        goto L14
    L10:
        r66 = 2;
        goto L11
    }
}
