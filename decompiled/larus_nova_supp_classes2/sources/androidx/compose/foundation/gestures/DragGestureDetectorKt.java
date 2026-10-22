package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0080\u0001\u0010\u0018\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aè\u0001\u0010\u0018\u001a\u00020\f*\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!2M\b\u0002\u0010\u001a\u001aG\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\f0\"2#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010'\u001a\u0080\u0001\u0010(\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aV\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b+\u0010\u000e\u001a^\u0010,\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.26\u0010/\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b0\u00101\u001a0\u00102\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b3\u0010\u0014\u001a\u001e\u00104\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b5\u0010\u0017\u001a\u0080\u0001\u00106\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u00107\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aV\u00108\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b9\u0010\u000e\u001a^\u0010:\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.26\u0010/\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b;\u00101\u001a0\u0010<\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b=\u0010\u0014\u001a\u001e\u0010>\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b?\u0010\u0017\u001a\u0080\u0001\u0010@\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010A\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u00122\b\u0010B\u001a\u0004\u0018\u00010!2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0080H¢\u0006\u0004\bD\u0010E\u001a2\u0010F\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0082H¢\u0006\u0004\bH\u0010\u0014\u001aT\u0010I\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010J\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0006H\u0080H¢\u0006\u0004\bK\u0010L\u001a$\u0010M\u001a\u00020\u0010*\u00020\u00022\u0006\u0010J\u001a\u00020\u00012\b\b\u0002\u0010N\u001a\u00020OH\u0080@¢\u0006\u0002\u0010P\u001a\u001e\u0010Q\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bR\u0010\u0017\u001a\u001b\u0010S\u001a\u00020\u0010*\u00020T2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\bU\u0010V\u001a\u001b\u0010\\\u001a\u00020**\u00020]2\u0006\u0010-\u001a\u00020.H\u0000¢\u0006\u0004\b^\u0010_\"\u0010\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Y\"\u0010\u0010Z\u001a\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Y\"\u000e\u0010[\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"awaitTouchSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onTouchSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "change", "Landroidx/compose/ui/geometry/Offset;", "overSlop", "", "awaitTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drag", "", "onDrag", "Lkotlin/Function1;", "drag-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrCancellation", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "awaitVerticalTouchSlopOrCancellation", "", "awaitVerticalTouchSlopOrCancellation-jO51t88", "awaitVerticalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verticalDrag", "verticalDrag-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "detectVerticalDragGestures", "onVerticalDrag", "awaitHorizontalTouchSlopOrCancellation", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "awaitHorizontalPointerSlopOrCancellation", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "horizontalDrag", "horizontalDrag-jO51t88", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "detectHorizontalDragGestures", "onHorizontalDrag", "orientation", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "awaitDragOrUp-jO51t88", "awaitPointerSlopOrCancellation", "initialPositionChange", "awaitPointerSlopOrCancellation-6ksA65w", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAllPointersUpWithSlopDetection", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop = 0.0f;
    private static final float mouseSlop = 0.0f;
    private static final float mouseToTouchSlopRatio = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0}, l = {895}, m = "awaitAllPointersUpWithSlopDetection", n = {"$this$awaitAllPointersUpWithSlopDetection", "pass", "pointer", "touchSlopDetector", "pointerSlopReached", "touchSlop"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "F$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return DragGestureDetectorKt.awaitAllPointersUpWithSlopDetection(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$13, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$13", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7}, l = {249, 255, 1105, 1142, 282, 1181, 1219, 1231}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "initialDown", "awaitTouchSlop", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "drag", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$drag_u2dVnAYq1g$iv", "orientation$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$2", "L$3", "L$4"})
    public static final class AnonymousClass13 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
        final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
        final /* synthetic */ Orientation $orientationLock;
        final /* synthetic */ Ref.LongRef $overSlop;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        float F$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;

        public AnonymousClass13(Function0<Boolean> r1, Ref.LongRef r2, Orientation r3, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> r4, Function2<? super PointerInputChange, ? super Offset, Unit> r5, Function0<Unit> r6, Function1<? super PointerInputChange, Unit> r7, Continuation<? super AnonymousClass13> r8) {
            this.$shouldAwaitTouchSlop = r1;
            this.$overSlop = r2;
            this.$orientationLock = r3;
            this.$onDragStart = r4;
            this.$onDrag = r5;
            this.$onDragCancel = r6;
            this.$onDragEnd = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            AnonymousClass13 r9 = new AnonymousClass13(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, r12);
            r9.L$0 = r11;
            return r9;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:170:0x0474 -> B:180:0x04ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:176:0x049b -> B:177:0x04a1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:183:0x04b6 -> B:86:0x02a5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x051d -> B:196:0x0520). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0186 -> B:77:0x0285). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01f4 -> B:76:0x0284). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0255 -> B:77:0x0285). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x0278 -> B:73:0x027d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x029f -> B:31:0x01a1). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r21) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = 0;
            int r13 = 1;
            PointerInputChange r14 = null;
            switch(this.label) {
                case 0: goto L14;
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            Ref.LongRef r0 = (Ref.LongRef) this.L$4;
            AwaitPointerEventScope r1 = (AwaitPointerEventScope) this.L$3;
            Orientation r2 = (Orientation) this.L$2;
            Function2<PointerInputChange, Offset, Unit> r3 = (Function2) this.L$1;
            AwaitPointerEventScope r4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            Object r9 = r21;
            AwaitPointerEventScope r5 = r4;
            Function2<PointerInputChange, Offset, Unit> r6 = r3;
            AnonymousClass13 r8 = this;
        L196:
            PointerEvent r10 = (PointerEvent) r9;
            List r11 = r10.getChanges();
            int r15 = r11.size();
            int r16 = 0;
        L197:
            if (r16 >= r15) goto L202;
            Object r17 = ListProtector.get(r11, r16);
            Object r22 = r7;
            if (PointerId.equals-impl0(((PointerInputChange) r17).getId-J3iCeTQ(), r0.element) == true) goto L203;
            r16 = r16 + 1;
            r7 = r22;
        L203:
            PointerInputChange r18 = (PointerInputChange) r17;
            if (r18 != null) goto L208;
            r18 = null;
        L234:
            if (r18 != null) goto L237;
        L235:
            PointerInputChange r19 = null;
        L242:
            if (r19 != null) goto L244;
            r8.$onDragCancel.invoke();
        L248:
            return Unit.INSTANCE;
        L244:
            r8.$onDragEnd.invoke(r19);
            goto L248
        L237:
            if (r18.isConsumed() == true) goto L235;
            if (PointerEventKt.changedToUpIgnoreConsumed(r18) == false) goto L245;
            r19 = r18;
            goto L242
        L245:
            r6.invoke(r18, Offset.box-impl(PointerEventKt.positionChange(r18)));
            r18.consume();
            long r20 = r18.getId-J3iCeTQ();
            r7 = r22;
            AwaitPointerEventScope r110 = r5;
            Orientation r23 = r2;
            AwaitPointerEventScope r24 = r110;
        L192:
            Ref.LongRef r25 = new Ref.LongRef();
            r25.element = r20;
            r1 = r24;
            r0 = r25;
            r2 = r23;
            r5 = r1;
        L193:
            r8.L$0 = r5;
            r8.L$1 = r6;
            r8.L$2 = r2;
            r8.L$3 = r1;
            r8.L$4 = r0;
            r8.L$5 = null;
            r8.L$6 = null;
            r8.label = 8;
            r9 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r1, null, r8, 1, null);
            if (r9 != r7) goto L196;
            return r7;
        L208:
            if (PointerEventKt.changedToUpIgnoreConsumed(r18) == false) goto L220;
            List r26 = r10.getChanges();
            int r27 = r26.size();
            int r28 = 0;
        L210:
            if (r28 >= r27) goto L215;
            Object r111 = ListProtector.get(r26, r28);
            if (((PointerInputChange) r111).getPressed() == true) goto L216;
            r28 = r28 + 1;
        L216:
            PointerInputChange r112 = (PointerInputChange) r111;
            if (r112 == null) goto L234;
            r0.element = r112.getId-J3iCeTQ();
        L246:
            r7 = r22;
            goto L193
        L215:
            r111 = null;
            goto L216
        L220:
            long r29 = PointerEventKt.positionChangeIgnoreConsumed(r18);
            if (r2 != null) goto L224;
            float r30 = Offset.getDistance-impl(r29);
        L229:
            if (r30 != MenuKt.ClosedAlphaTarget) goto L231;
            boolean r31 = true;
        L233:
            if ((!r31) == false) goto L246;
        L231:
            r31 = false;
            goto L233
        L224:
            if (r2 != Orientation.Vertical) goto L226;
            long r32 = r29 & 4294967295L;
        L227:
            r30 = Float.intBitsToFloat((int) r32);
            goto L229
        L226:
            r32 = r29 >> 32;
            goto L227
        L202:
            r22 = r7;
            r17 = null;
            goto L203
        L7:
            float r33 = this.F$0;
            PointerInputChange r34 = (PointerInputChange) this.L$6;
            TouchSlopDetector r35 = (TouchSlopDetector) this.L$5;
            Ref.LongRef r36 = (Ref.LongRef) this.L$4;
            Ref.LongRef r37 = (Ref.LongRef) this.L$3;
            AwaitPointerEventScope r38 = (AwaitPointerEventScope) this.L$2;
            PointerInputChange r113 = (PointerInputChange) this.L$1;
            AwaitPointerEventScope r39 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            Ref.LongRef r114 = r36;
            Ref.LongRef r115 = r37;
            AnonymousClass13 r40 = this;
            AwaitPointerEventScope r41 = r39;
            TouchSlopDetector r42 = r35;
            PointerInputChange r43 = r113;
        L178:
            if (r34.isConsumed() == false) goto L181;
            PointerInputChange r44 = r43;
            r24 = r41;
            r8 = r40;
            PointerInputChange r45 = null;
        L87:
            if (ComposeFoundationFlags.DragGesturePickUpEnabled == false) goto L184;
            if (r45 != null) goto L184;
            List r46 = r24.getCurrentEvent().getChanges();
            int r47 = r46.size();
            int r48 = 0;
        L90:
            if (r48 >= r47) goto L95;
            if (((PointerInputChange) ListProtector.get(r46, r48)).getPressed() == true) goto L93;
            r48 = r48 + 1;
            goto L90
        L93:
            boolean r49 = true;
        L96:
            if (r49 == false) goto L184;
            PointerInputChange r116 = r45;
            PointerInputChange r50 = r44;
            PointerInputChange r51 = r116;
        L98:
            PointerEventPass r52 = PointerEventPass.Final;
            r8.L$0 = r24;
            r8.L$1 = r50;
            r8.L$2 = r51;
            r8.L$3 = null;
            r8.L$4 = null;
            r8.L$5 = null;
            r8.L$6 = null;
            r8.label = 5;
            Object r53 = r24.awaitPointerEvent(r52, r8);
            if (r53 != r7) goto L101;
            return r7;
        L101:
            PointerEvent r54 = (PointerEvent) r53;
            List r55 = r54.getChanges();
            int r56 = r55.size();
            int r57 = 0;
        L102:
            if (r57 >= r56) goto L107;
            if (((PointerInputChange) ListProtector.get(r55, r57)).isConsumed() == true) goto L105;
            r57 = r57 + 1;
            goto L102
        L105:
            boolean r58 = true;
        L108:
            if (r58 == false) goto L117;
            List r59 = r54.getChanges();
            int r60 = r59.size();
            int r61 = 0;
        L110:
            if (r61 >= r60) goto L249;
            if (((PointerInputChange) ListProtector.get(r59, r61)).getPressed() == true) goto L116;
            r61 = r61 + 1;
            goto L110
        L116:
            if (1 != 0) goto L98;
        L249:
            if (0 != 0) goto L98;
        L117:
            List r62 = r54.getChanges();
            int r63 = r62.size();
            int r64 = 0;
        L118:
            if (r64 >= r63) goto L123;
            if (((PointerInputChange) ListProtector.get(r62, r64)).getPressed() == true) goto L121;
            r64 = r64 + 1;
            goto L118
        L121:
            boolean r65 = true;
        L124:
            if (r65 == false) goto L183;
            PointerInputChange r66 = (PointerInputChange) CollectionsKt.firstOrNull(r54.getChanges());
            if (r66 == null) goto L128;
            long r67 = r66.getPosition-F1C5BW0();
        L129:
            long r68 = Offset.minus-MK-Hz9U(r67, r50.getPosition-F1C5BW0());
            long r69 = r50.getId-J3iCeTQ();
            int r70 = r50.getType-T8wyACA();
            Orientation r117 = r8.$orientationLock;
            r115 = r8.$overSlop;
            if (DragGestureDetectorKt.m568access$isPointerUpDmW0f2w(r24.getCurrentEvent(), r69) == false) goto L132;
            r44 = r50;
            r45 = null;
            goto L87
        L132:
            r33 = DragGestureDetectorKt.m587pointerSlopE8SPZFQ(r24.getViewConfiguration(), r70);
            r114 = new Ref.LongRef();
            r114.element = r69;
            PointerEventPass r71 = null;
            r42 = new TouchSlopDetector(r117, r68, null);
            r40 = r8;
            r41 = r24;
        L133:
            r40.L$0 = r41;
            r40.L$1 = r50;
            r40.L$2 = r24;
            r40.L$3 = r115;
            r40.L$4 = r114;
            r40.L$5 = r42;
            r40.L$6 = r71;
            r40.F$0 = r33;
            r40.label = 6;
            Object r118 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r24, r71, r40, 1, r71);
            if (r118 != r7) goto L136;
            return r7;
        L136:
            PointerEvent r119 = (PointerEvent) r118;
            List r72 = r119.getChanges();
            int r73 = r72.size();
            int r120 = 0;
        L137:
            if (r120 >= r73) goto L142;
            Object r121 = ListProtector.get(r72, r120);
            List r210 = r72;
            if (PointerId.equals-impl0(((PointerInputChange) r121).getId-J3iCeTQ(), r114.element) == true) goto L140;
            r120 = r120 + 1;
            r72 = r210;
            goto L137
        L140:
            Object r74 = r121;
        L143:
            PointerInputChange r75 = (PointerInputChange) r74;
            if (r75 != null) goto L148;
        L145:
            r44 = r50;
            r24 = r41;
            r8 = r40;
            r45 = null;
            goto L87
        L148:
            if (r75.isConsumed() == true) goto L145;
            if (PointerEventKt.changedToUpIgnoreConsumed(r75) == false) goto L164;
            List r76 = r119.getChanges();
            int r77 = r76.size();
            int r78 = 0;
        L153:
            if (r78 >= r77) goto L158;
            Object r122 = ListProtector.get(r76, r78);
            if (((PointerInputChange) r122).getPressed() == true) goto L156;
            r78 = r78 + 1;
            goto L153
        L156:
            Object r79 = r122;
        L159:
            PointerInputChange r80 = (PointerInputChange) r79;
            if (r80 == null) goto L145;
            r114.element = r80.getId-J3iCeTQ();
        L182:
            r71 = null;
            goto L133
        L158:
            r79 = null;
            goto L159
        L164:
            if ((r42.m716addPointerInputChangedBAh8RU(r75, r33) & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L166;
            boolean r81 = true;
        L167:
            if (r81 == false) goto L173;
            r75.consume();
            r115.element = PointerEventKt.positionChange(r75);
            if (r75.isConsumed() == false) goto L171;
            r44 = r50;
            r24 = r41;
            r8 = r40;
            r45 = r75;
            goto L87
        L171:
            r42.reset();
            goto L182
        L173:
            PointerEventPass r82 = PointerEventPass.Final;
            r40.L$0 = r41;
            r40.L$1 = r50;
            r40.L$2 = r24;
            r40.L$3 = r115;
            r40.L$4 = r114;
            r40.L$5 = r42;
            r40.L$6 = r75;
            r40.F$0 = r33;
            r40.label = 7;
            if (r24.awaitPointerEvent(r82, r40) != r7) goto L176;
            return r7;
        L176:
            AwaitPointerEventScope r123 = r24;
            r43 = r50;
            r34 = r75;
            r38 = r123;
            goto L178
        L166:
            r81 = false;
            goto L167
        L142:
            r74 = null;
            goto L143
        L128:
            r67 = Offset.Companion.getZero-F1C5BW0();
            goto L129
        L183:
            PointerInputChange r124 = r50;
            r45 = r51;
            r44 = r124;
            goto L87
        L123:
            r65 = false;
            goto L124
        L107:
            r58 = false;
            goto L108
        L95:
            r49 = false;
        L184:
            if (r45 == null) goto L248;
            r8.$onDragStart.invoke(r44, r45, Offset.box-impl(r8.$overSlop.element));
            r8.$onDrag.invoke(r45, Offset.box-impl(r8.$overSlop.element));
            r20 = r45.getId-J3iCeTQ();
            r6 = r8.$onDrag;
            if (ComposeFoundationFlags.DragGesturePickUpEnabled == false) goto L188;
            r23 = null;
        L190:
            if (DragGestureDetectorKt.m568access$isPointerUpDmW0f2w(r24.getCurrentEvent(), r20) == false) goto L192;
        L188:
            r23 = r8.$orientationLock;
            goto L190
        L181:
            r50 = r43;
            r24 = r38;
            r71 = null;
            goto L133
        L8:
            r33 = this.F$0;
            TouchSlopDetector r83 = (TouchSlopDetector) this.L$5;
            Ref.LongRef r84 = (Ref.LongRef) this.L$4;
            Ref.LongRef r85 = (Ref.LongRef) this.L$3;
            AwaitPointerEventScope r86 = (AwaitPointerEventScope) this.L$2;
            PointerInputChange r87 = (PointerInputChange) this.L$1;
            AwaitPointerEventScope r88 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            r118 = r21;
            r114 = r84;
            r115 = r85;
            r24 = r86;
            r40 = this;
            r41 = r88;
            r42 = r83;
            r50 = r87;
            goto L136
        L9:
            r51 = (PointerInputChange) this.L$2;
            r50 = (PointerInputChange) this.L$1;
            r24 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            r53 = r21;
            r8 = this;
            goto L101
        L10:
            float r89 = this.F$0;
            PointerInputChange r90 = (PointerInputChange) this.L$6;
            TouchSlopDetector r91 = (TouchSlopDetector) this.L$5;
            Ref.LongRef r92 = (Ref.LongRef) this.L$4;
            Ref.LongRef r93 = (Ref.LongRef) this.L$3;
            AwaitPointerEventScope r94 = (AwaitPointerEventScope) this.L$2;
            PointerInputChange r95 = (PointerInputChange) this.L$1;
            AwaitPointerEventScope r96 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            Ref.LongRef r125 = r92;
            AwaitPointerEventScope r97 = r96;
            Ref.LongRef r98 = r93;
            TouchSlopDetector r99 = r91;
            AnonymousClass13 r100 = this;
            float r101 = r89;
            r44 = r95;
            Object r102 = r7;
        L74:
            if (r90.isConsumed() == false) goto L83;
            r7 = r102;
        L76:
            r45 = null;
        L77:
            if (r45 != null) goto L79;
        L82:
            AwaitPointerEventScope r126 = r97;
            r8 = r100;
            r24 = r126;
            goto L87
        L79:
            if (r45.isConsumed() == true) goto L82;
            AnonymousClass13 r103 = r100;
            r24 = r97;
            r12 = 0;
            r13 = 1;
            r14 = null;
        L27:
            long r104 = r44.getId-J3iCeTQ();
            int r105 = r44.getType-T8wyACA();
            Orientation r106 = r103.$orientationLock;
            r98 = r103.$overSlop;
            long r127 = Offset.Companion.getZero-F1C5BW0();
            if (DragGestureDetectorKt.m568access$isPointerUpDmW0f2w(r24.getCurrentEvent(), r104) == false) goto L30;
            r97 = r24;
            r100 = r103;
            r45 = r14;
            goto L77
        L30:
            float r107 = DragGestureDetectorKt.m587pointerSlopE8SPZFQ(r24.getViewConfiguration(), r105);
            r125 = new Ref.LongRef();
            r125.element = r104;
            r99 = new TouchSlopDetector(r106, r127, r14);
            r97 = r24;
        L31:
            r103.L$0 = r97;
            r103.L$1 = r44;
            r103.L$2 = r24;
            r103.L$3 = r98;
            r103.L$4 = r125;
            r103.L$5 = r99;
            r103.L$6 = r14;
            r103.F$0 = r107;
            r103.label = 3;
            Object r108 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r24, r14, r103, r13, r14);
            if (r108 != r7) goto L34;
            return r7;
        L34:
            PointerEvent r109 = (PointerEvent) r108;
            List r128 = r109.getChanges();
            int r129 = r128.size();
        L35:
            if (r12 >= r129) goto L40;
            Object r130 = ListProtector.get(r128, r12);
            List r211 = r128;
            int r131 = r129;
            if (PointerId.equals-impl0(((PointerInputChange) r130).getId-J3iCeTQ(), r125.element) == true) goto L41;
            r12 = r12 + 1;
            r128 = r211;
            r129 = r131;
        L41:
            PointerInputChange r132 = (PointerInputChange) r130;
            if (r132 != null) goto L45;
        L43:
            r100 = r103;
            goto L76
        L45:
            if (r132.isConsumed() == true) goto L43;
            if (PointerEventKt.changedToUpIgnoreConsumed(r132) == false) goto L60;
            List r133 = r109.getChanges();
            int r134 = r133.size();
            int r135 = 0;
        L50:
            if (r135 >= r134) goto L55;
            Object r136 = ListProtector.get(r133, r135);
            if (((PointerInputChange) r136).getPressed() == true) goto L56;
            r135 = r135 + 1;
        L56:
            PointerInputChange r137 = (PointerInputChange) r136;
            if (r137 == null) goto L43;
            r125.element = r137.getId-J3iCeTQ();
        L84:
            r12 = 0;
            r13 = 1;
            r14 = null;
            goto L31
        L55:
            r136 = null;
            goto L56
        L60:
            long r138 = r99.m716addPointerInputChangedBAh8RU(r132, r107);
            if ((r138 & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L63;
            boolean r139 = true;
        L64:
            if (r139 == false) goto L69;
            r132.consume();
            r98.element = r138;
            if (r132.isConsumed() == false) goto L68;
            r100 = r103;
            r45 = r132;
            goto L77
        L68:
            r99.reset();
            goto L84
        L69:
            PointerEventPass r140 = PointerEventPass.Final;
            r103.L$0 = r97;
            r103.L$1 = r44;
            r103.L$2 = r24;
            r103.L$3 = r98;
            r103.L$4 = r125;
            r103.L$5 = r99;
            r103.L$6 = r132;
            r103.F$0 = r107;
            r103.label = 4;
            if (r24.awaitPointerEvent(r140, r103) != r7) goto L72;
            return r7;
        L72:
            r102 = r7;
            r101 = r107;
            r94 = r24;
            r100 = r103;
            r90 = r132;
            goto L74
        L63:
            r139 = false;
            goto L64
        L40:
            r130 = null;
            goto L41
        L83:
            r103 = r100;
            r24 = r94;
            r107 = r101;
            r7 = r102;
            goto L84
        L11:
            float r141 = this.F$0;
            TouchSlopDetector r142 = (TouchSlopDetector) this.L$5;
            Ref.LongRef r143 = (Ref.LongRef) this.L$4;
            Ref.LongRef r144 = (Ref.LongRef) this.L$3;
            AwaitPointerEventScope r145 = (AwaitPointerEventScope) this.L$2;
            PointerInputChange r146 = (PointerInputChange) this.L$1;
            AwaitPointerEventScope r147 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            r125 = r143;
            r98 = r144;
            r24 = r145;
            r97 = r147;
            r108 = r21;
            r99 = r142;
            r103 = this;
            r107 = r141;
            r44 = r146;
            goto L34
        L12:
            boolean r148 = this.Z$0;
            r45 = (PointerInputChange) this.L$1;
            r24 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            boolean r149 = r148;
            Object r150 = r21;
        L24:
            r44 = (PointerInputChange) r150;
            this.$overSlop.element = Offset.Companion.getZero-F1C5BW0();
            if (r149 == false) goto L85;
            r103 = this;
            goto L27
        L85:
            r8 = this;
            goto L87
        L13:
            AwaitPointerEventScope r151 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            Object r152 = r21;
        L17:
            AwaitPointerEventScope r153 = r151;
            PointerInputChange r154 = (PointerInputChange) r152;
            r149 = ((Boolean) this.$shouldAwaitTouchSlop.invoke()).booleanValue();
            if (r149 == true) goto L20;
            r154.consume();
        L20:
            this.L$0 = r153;
            this.L$1 = r154;
            this.Z$0 = r149;
            this.label = 2;
            r150 = TapGestureDetectorKt.awaitFirstDown$default(r153, false, null, this, 2, null);
            if (r150 != r7) goto L23;
            return r7;
        L23:
            r24 = r153;
            r45 = r154;
            goto L24
        L14:
            ResultKt.throwOnFailure(r21);
            r151 = (AwaitPointerEventScope) this.L$0;
            PointerEventPass r155 = PointerEventPass.Initial;
            this.L$0 = r151;
            this.label = 1;
            r152 = TapGestureDetectorKt.awaitFirstDown(r151, false, r155, this);
            if (r152 != r7) goto L17;
            return r7;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {0, 1, 2}, l = {362, 363, 368}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "L$0"})
    public static final class AnonymousClass5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass5(Function1<? super Offset, Unit> r1, Function0<Unit> r2, Function0<Unit> r3, Function2<? super PointerInputChange, ? super Offset, Unit> r4, Continuation<? super AnonymousClass5> r5) {
            this.$onDragStart = r1;
            this.$onDragEnd = r2;
            this.$onDragCancel = r3;
            this.$onDrag = r4;
            super(2, r5);
        }

        public static /* synthetic */ Unit a(Function2 r0, PointerInputChange r1) {
            return invokeSuspend$lambda$0(r0, r1);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass5 r6 = new AnonymousClass5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, r9);
            r6.L$0 = r8;
            return r6;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L20;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L12;
            if (r1 != 3) goto L11;
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L18
        L34:
            if (((Boolean) r12).booleanValue() == false) goto L42;
            List r13 = r2.getCurrentEvent().getChanges();     // Catch: CancellationException -> L18
            int r3 = r13.size();     // Catch: CancellationException -> L18
            int r4 = 0;
        L36:
            if (r4 >= r3) goto L41;
            PointerInputChange r5 = (PointerInputChange) ListProtector.get(r13, r4);     // Catch: CancellationException -> L18
            if (PointerEventKt.changedToUp(r5) == false) goto L40;
            r5.consume();     // Catch: CancellationException -> L18
        L40:
            r4 = r4 + 1;     // Catch: CancellationException -> L18
            goto L36
        L41:
            this.$onDragEnd.invoke();     // Catch: CancellationException -> L18
        L44:
            return Unit.INSTANCE;
        L42:
            this.$onDragCancel.invoke();     // Catch: CancellationException -> L18
            goto L44
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            AwaitPointerEventScope r6 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L18
        L27:
            PointerInputChange r14 = (PointerInputChange) r12;     // Catch: CancellationException -> L18
            if (r14 == null) goto L44;
            this.$onDragStart.invoke(Offset.box-impl(r14.getPosition-F1C5BW0()));     // Catch: CancellationException -> L18
            long r7 = r14.getId-J3iCeTQ();     // Catch: CancellationException -> L18
            final Function2<PointerInputChange, Offset, Unit> r15 = this.$onDrag;     // Catch: CancellationException -> L18
            Function1 r8 = new z0(r15);     // Catch: CancellationException -> L18
            this.L$0 = r6;     // Catch: CancellationException -> L18
            this.label = 3;     // Catch: CancellationException -> L18
            r12 = DragGestureDetectorKt.m584dragjO51t88(r6, r7, r8, this);     // Catch: CancellationException -> L18
            if (r12 != r0) goto L32;
            return r0;
        L32:
            r2 = r6;
            goto L34
        L15:
            r6 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L18
        L24:
            long r9 = ((PointerInputChange) r12).getId-J3iCeTQ();     // Catch: CancellationException -> L18
            this.L$0 = r6;     // Catch: CancellationException -> L18
            this.label = 2;     // Catch: CancellationException -> L18
            r12 = DragGestureDetectorKt.m574awaitLongPressOrCancellationrnUCldI(r6, r9, this);     // Catch: CancellationException -> L18
            if (r12 != r0) goto L27;
            return r0;
        L20:
            ResultKt.throwOnFailure(r12);
            r6 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = r6;     // Catch: CancellationException -> L18
            this.label = 1;     // Catch: CancellationException -> L18
            r12 = TapGestureDetectorKt.awaitFirstDown$default(r6, false, null, this, 2, null);     // Catch: CancellationException -> L18
            if (r12 != r0) goto L24;
            return r0;
        L18:
            e = move-exception;
            this.$onDragCancel.invoke();
            throw e;
        }

        private static final Unit invokeSuspend$lambda$0(Function2 r2, PointerInputChange r3) {
            r2.invoke(r3, Offset.box-impl(PointerEventKt.positionChange(r3)));
            r3.consume();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {705, 708, 716}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, s = {"L$0", "L$0", "L$1"})
    public static final class C01355 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public C01355(Function1<? super Offset, Unit> r1, Function2<? super PointerInputChange, ? super Float, Unit> r2, Function0<Unit> r3, Function0<Unit> r4, Continuation<? super C01355> r5) {
            this.$onDragStart = r1;
            this.$onHorizontalDrag = r2;
            this.$onDragEnd = r3;
            this.$onDragCancel = r4;
            super(2, r5);
        }

        public static /* synthetic */ Unit a(Function2 r0, PointerInputChange r1) {
            return invokeSuspend$lambda$1(r0, r1);
        }

        public static /* synthetic */ Unit c(Ref.FloatRef r0, PointerInputChange r1, float r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C01355 r6 = new C01355(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, r9);
            r6.L$0 = r8;
            return r6;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r13);
        L26:
            if (((Boolean) r13).booleanValue() == false) goto L28;
            this.$onDragEnd.invoke();
        L30:
            return Unit.INSTANCE;
        L28:
            this.$onDragCancel.invoke();
            goto L30
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            Ref.FloatRef r2 = (Ref.FloatRef) this.L$1;
            AwaitPointerEventScope r3 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L20:
            PointerInputChange r14 = (PointerInputChange) r13;
            if (r14 == null) goto L30;
            this.$onDragStart.invoke(Offset.box-impl(r14.getPosition-F1C5BW0()));
            this.$onHorizontalDrag.invoke(r14, Boxing.boxFloat(r2.element));
            long r4 = r14.getId-J3iCeTQ();
            final Function2<PointerInputChange, Float, Unit> r15 = this.$onHorizontalDrag;
            Function1 r5 = new b1(r15);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            r13 = DragGestureDetectorKt.m585horizontalDragjO51t88(r3, r4, r5, this);
            if (r13 != r0) goto L26;
            return r0;
        L11:
            AwaitPointerEventScope r6 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L16:
            PointerInputChange r16 = (PointerInputChange) r13;
            final Ref.FloatRef r10 = new Ref.FloatRef();
            long r7 = r16.getId-J3iCeTQ();
            int r8 = r16.getType-T8wyACA();
            Function2 r9 = new a1(r10);
            this.L$0 = r6;
            this.L$1 = r10;
            this.label = 2;
            r13 = DragGestureDetectorKt.m572awaitHorizontalPointerSlopOrCancellationgDDlDlE(r6, r7, r8, r9, this);
            if (r13 != r0) goto L19;
            return r0;
        L19:
            r3 = r6;
            r2 = r10;
            goto L20
        L12:
            ResultKt.throwOnFailure(r13);
            AwaitPointerEventScope r17 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = r17;
            this.label = 1;
            Object r11 = TapGestureDetectorKt.awaitFirstDown$default(r17, false, null, this, 2, null);
            if (r11 != r0) goto L15;
            return r0;
        L15:
            r6 = r17;
            r13 = r11;
            goto L16
        }

        private static final Unit invokeSuspend$lambda$1(Function2 r3, PointerInputChange r4) {
            r3.invoke(r4, Float.valueOf(Float.intBitsToFloat((int) (PointerEventKt.positionChange(r4) >> 32))));
            r4.consume();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$0(Ref.FloatRef r0, PointerInputChange r1, float r2) {
            r1.consume();
            r0.element = r2;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {536, 539, 547}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, s = {"L$0", "L$0", "L$1"})
    public static final class C01365 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onVerticalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public C01365(Function1<? super Offset, Unit> r1, Function2<? super PointerInputChange, ? super Float, Unit> r2, Function0<Unit> r3, Function0<Unit> r4, Continuation<? super C01365> r5) {
            this.$onDragStart = r1;
            this.$onVerticalDrag = r2;
            this.$onDragEnd = r3;
            this.$onDragCancel = r4;
            super(2, r5);
        }

        public static /* synthetic */ Unit a(Ref.FloatRef r0, PointerInputChange r1, float r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public static /* synthetic */ Unit c(Function2 r0, PointerInputChange r1) {
            return invokeSuspend$lambda$1(r0, r1);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C01365 r6 = new C01365(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, r9);
            r6.L$0 = r8;
            return r6;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r13);
        L26:
            if (((Boolean) r13).booleanValue() == false) goto L28;
            this.$onDragEnd.invoke();
        L30:
            return Unit.INSTANCE;
        L28:
            this.$onDragCancel.invoke();
            goto L30
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            Ref.FloatRef r2 = (Ref.FloatRef) this.L$1;
            AwaitPointerEventScope r3 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L20:
            PointerInputChange r14 = (PointerInputChange) r13;
            if (r14 == null) goto L30;
            this.$onDragStart.invoke(Offset.box-impl(r14.getPosition-F1C5BW0()));
            this.$onVerticalDrag.invoke(r14, Boxing.boxFloat(r2.element));
            long r4 = r14.getId-J3iCeTQ();
            final Function2<PointerInputChange, Float, Unit> r15 = this.$onVerticalDrag;
            Function1 r5 = new d1(r15);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            r13 = DragGestureDetectorKt.m588verticalDragjO51t88(r3, r4, r5, this);
            if (r13 != r0) goto L26;
            return r0;
        L11:
            AwaitPointerEventScope r6 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L16:
            PointerInputChange r16 = (PointerInputChange) r13;
            final Ref.FloatRef r10 = new Ref.FloatRef();
            long r7 = r16.getId-J3iCeTQ();
            int r8 = r16.getType-T8wyACA();
            Function2 r9 = new c1(r10);
            this.L$0 = r6;
            this.L$1 = r10;
            this.label = 2;
            r13 = DragGestureDetectorKt.m580awaitVerticalPointerSlopOrCancellationgDDlDlE(r6, r7, r8, r9, this);
            if (r13 != r0) goto L19;
            return r0;
        L19:
            r3 = r6;
            r2 = r10;
            goto L20
        L12:
            ResultKt.throwOnFailure(r13);
            AwaitPointerEventScope r17 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = r17;
            this.label = 1;
            Object r11 = TapGestureDetectorKt.awaitFirstDown$default(r17, false, null, this, 2, null);
            if (r11 != r0) goto L15;
            return r0;
        L15:
            r6 = r17;
            r13 = r11;
            goto L16
        }

        private static final Unit invokeSuspend$lambda$1(Function2 r4, PointerInputChange r5) {
            r4.invoke(r5, Float.valueOf(Float.intBitsToFloat((int) (PointerEventKt.positionChange(r5) & 4294967295L))));
            r5.consume();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$0(Ref.FloatRef r0, PointerInputChange r1, float r2) {
            r1.consume();
            r0.element = r2;
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Unit a() {
        return detectDragGesturesAfterLongPress$lambda$12();
    }

    public static /* synthetic */ Unit b(PointerInputChange r0, PointerInputChange r1, Offset r2) {
        return detectDragGestures$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ Unit c(Function1 r0, PointerInputChange r1, PointerInputChange r2, Offset r3) {
        return detectDragGestures$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit d() {
        return detectDragGestures$lambda$9();
    }

    private static final boolean detectDragGestures$lambda$10() {
        return true;
    }

    private static final boolean detectDragGestures$lambda$6() {
        return true;
    }

    public static /* synthetic */ Unit e() {
        return detectDragGesturesAfterLongPress$lambda$13();
    }

    public static /* synthetic */ Unit f(Function0 r0, PointerInputChange r1) {
        return detectDragGestures$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit g() {
        return detectDragGestures$lambda$3();
    }

    public static /* synthetic */ boolean h() {
        return detectDragGestures$lambda$6();
    }

    public static /* synthetic */ Unit i(Offset r0) {
        return detectVerticalDragGestures$lambda$18(r0);
    }

    public static /* synthetic */ Unit j() {
        return detectVerticalDragGestures$lambda$20();
    }

    public static /* synthetic */ Unit k() {
        return detectHorizontalDragGestures$lambda$26();
    }

    public static /* synthetic */ Unit l(Offset r0) {
        return detectHorizontalDragGestures$lambda$25(r0);
    }

    public static /* synthetic */ boolean m() {
        return detectDragGestures$lambda$10();
    }

    public static /* synthetic */ Unit n(PointerInputChange r0) {
        return detectDragGestures$lambda$8(r0);
    }

    public static /* synthetic */ Unit o(Offset r0) {
        return detectDragGesturesAfterLongPress$lambda$11(r0);
    }

    public static /* synthetic */ Unit p() {
        return detectVerticalDragGestures$lambda$19();
    }

    public static /* synthetic */ Unit q(Offset r0) {
        return detectDragGestures$lambda$1(r0);
    }

    public static /* synthetic */ Unit r() {
        return detectDragGestures$lambda$2();
    }

    public static /* synthetic */ Unit s() {
        return detectHorizontalDragGestures$lambda$27();
    }

    static {
        float r0 = Dp.constructor-impl((float) 0.125d);
        mouseSlop = r0;
        float r1 = Dp.constructor-impl(18);
        defaultTouchSlop = r1;
        mouseToTouchSlopRatio = r0 / r1;
    }

    private static final Unit detectDragGestures$lambda$2() {
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGestures$lambda$3() {
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGestures$lambda$9() {
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesAfterLongPress$lambda$12() {
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesAfterLongPress$lambda$13() {
        return Unit.INSTANCE;
    }

    private static final Unit detectHorizontalDragGestures$lambda$26() {
        return Unit.INSTANCE;
    }

    private static final Unit detectHorizontalDragGestures$lambda$27() {
        return Unit.INSTANCE;
    }

    private static final Unit detectVerticalDragGestures$lambda$19() {
        return Unit.INSTANCE;
    }

    private static final Unit detectVerticalDragGestures$lambda$20() {
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGestures$lambda$1(Offset r0) {
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGestures$lambda$8(PointerInputChange r0) {
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesAfterLongPress$lambda$11(Offset r0) {
        return Unit.INSTANCE;
    }

    private static final Unit detectHorizontalDragGestures$lambda$25(Offset r0) {
        return Unit.INSTANCE;
    }

    private static final Unit detectVerticalDragGestures$lambda$18(Offset r0) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$isPointerUp-DmW0f2w, reason: not valid java name */
    public static final /* synthetic */ boolean m568access$isPointerUpDmW0f2w(PointerEvent r0, long r1) {
        return m586isPointerUpDmW0f2w(r0, r1);
    }

    private static final Unit detectDragGestures$lambda$5(Function0 r0, PointerInputChange r1) {
        r0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m586isPointerUpDmW0f2w(PointerEvent r6, long r7) {
        List r8 = r6.getChanges();
        int r0 = r8.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Object r3 = ListProtector.get(r8, r2);
        if (PointerId.equals-impl0(((PointerInputChange) r3).getId-J3iCeTQ(), r7) == true) goto L9;
        r2 = r2 + 1;
    L9:
        PointerInputChange r4 = (PointerInputChange) r3;
        if (r4 == null) goto L15;
        if (r4.getPressed() != true) goto L15;
        r1 = true;
    L15:
        return true ^ r1;
    L8:
        r3 = null;
        goto L9
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m587pointerSlopE8SPZFQ(ViewConfiguration r1, int r2) {
        if (PointerType.equals-impl0(r2, PointerType.Companion.getMouse-T8wyACA()) == false) goto L6;
        return r1.getTouchSlop() * mouseToTouchSlopRatio;
    L6:
        return r1.getTouchSlop();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final Object m569awaitDragOrCancellationrnUCldI(AwaitPointerEventScope r17, long r18, Continuation<? super PointerInputChange> r20) {
        if ((r20 instanceof DragGestureDetectorKt$awaitDragOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = (DragGestureDetectorKt$awaitDragOrCancellation$1) r20;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        Ref.LongRef r0 = (Ref.LongRef) r3.L$1;
        AwaitPointerEventScope r1 = (AwaitPointerEventScope) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Ref.LongRef r8 = r0;
        AwaitPointerEventScope r9 = r1;
    L22:
        PointerEvent r10 = (PointerEvent) r2;
        List r11 = r10.getChanges();
        int r12 = r11.size();
        int r13 = 0;
    L23:
        if (r13 >= r12) goto L28;
        Object r14 = ListProtector.get(r11, r13);
        if (PointerId.equals-impl0(((PointerInputChange) r14).getId-J3iCeTQ(), r8.element) == true) goto L29;
        r13 = r13 + 1;
    L29:
        PointerInputChange r15 = (PointerInputChange) r14;
        if (r15 != null) goto L33;
        r15 = null;
    L47:
        if (r15 != null) goto L49;
    L51:
        r7 = false;
    L52:
        if (r7 == true) goto L54;
        return null;
    L54:
        return r15;
    L49:
        if (r15.isConsumed() == true) goto L51;
    L33:
        if (PointerEventKt.changedToUpIgnoreConsumed(r15) == false) goto L46;
        List r16 = r10.getChanges();
        int r19 = r16.size();
        int r21 = 0;
    L35:
        if (r21 >= r19) goto L40;
        Object r110 = ListProtector.get(r16, r21);
        if (((PointerInputChange) r110).getPressed() == true) goto L41;
        r21 = r21 + 1;
    L41:
        PointerInputChange r111 = (PointerInputChange) r110;
        if (r111 == null) goto L47;
        r8.element = r111.getId-J3iCeTQ();
    L55:
        Ref.LongRef r22 = r8;
    L18:
        r3.L$0 = r9;
        r3.L$1 = r22;
        r3.label = 1;
        Object r23 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r9, null, r3, 1, null);
        if (r23 != r5) goto L21;
        return r5;
    L21:
        Ref.LongRef r112 = r22;
        r2 = r23;
        r8 = r112;
        goto L22
    L40:
        r110 = null;
        goto L41
    L46:
        if (PointerEventKt.positionChangedIgnoreConsumed(r15) == false) goto L55;
    L28:
        r14 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        if (m586isPointerUpDmW0f2w(r17.getCurrentEvent(), r18) == false) goto L17;
        return null;
    L17:
        r22 = new Ref.LongRef();
        r22.element = r18;
        r9 = r17;
    L7:
        r3 = new DragGestureDetectorKt$awaitDragOrCancellation$1(r20);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final Object m571awaitHorizontalDragOrCancellationrnUCldI(AwaitPointerEventScope r17, long r18, Continuation<? super PointerInputChange> r20) {
        if ((r20 instanceof DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = (DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) r20;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        Ref.LongRef r0 = (Ref.LongRef) r3.L$1;
        AwaitPointerEventScope r1 = (AwaitPointerEventScope) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Ref.LongRef r8 = r0;
        AwaitPointerEventScope r9 = r1;
    L22:
        PointerEvent r10 = (PointerEvent) r2;
        List r11 = r10.getChanges();
        int r12 = r11.size();
        int r13 = 0;
    L23:
        if (r13 >= r12) goto L28;
        Object r14 = ListProtector.get(r11, r13);
        if (PointerId.equals-impl0(((PointerInputChange) r14).getId-J3iCeTQ(), r8.element) == true) goto L29;
        r13 = r13 + 1;
    L29:
        PointerInputChange r15 = (PointerInputChange) r14;
        if (r15 != null) goto L33;
        r15 = null;
    L51:
        if (r15 != null) goto L53;
    L55:
        r7 = false;
    L56:
        if (r7 == true) goto L58;
        return null;
    L58:
        return r15;
    L53:
        if (r15.isConsumed() == true) goto L55;
    L33:
        if (PointerEventKt.changedToUpIgnoreConsumed(r15) == false) goto L46;
        List r16 = r10.getChanges();
        int r19 = r16.size();
        int r21 = 0;
    L35:
        if (r21 >= r19) goto L40;
        Object r110 = ListProtector.get(r16, r21);
        if (((PointerInputChange) r110).getPressed() == true) goto L41;
        r21 = r21 + 1;
    L41:
        PointerInputChange r111 = (PointerInputChange) r110;
        if (r111 == null) goto L51;
        r8.element = r111.getId-J3iCeTQ();
    L59:
        Ref.LongRef r22 = r8;
    L18:
        r3.L$0 = r9;
        r3.L$1 = r22;
        r3.label = 1;
        Object r23 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r9, null, r3, 1, null);
        if (r23 != r5) goto L21;
        return r5;
    L21:
        Ref.LongRef r112 = r22;
        r2 = r23;
        r8 = r112;
        goto L22
    L40:
        r110 = null;
        goto L41
    L46:
        if (Float.intBitsToFloat((int) (PointerEventKt.positionChangeIgnoreConsumed(r15) >> 32)) != MenuKt.ClosedAlphaTarget) goto L48;
        boolean r24 = true;
    L50:
        if ((!r24) == false) goto L59;
    L48:
        r24 = false;
        goto L50
    L28:
        r14 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        if (m586isPointerUpDmW0f2w(r17.getCurrentEvent(), r18) == false) goto L17;
        return null;
    L17:
        r22 = new Ref.LongRef();
        r22.element = r18;
        r9 = r17;
    L7:
        r3 = new DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(r20);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX INFO: renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    public static final Object m574awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope r9, Ref.ObjectRef r10, Continuation<? super PointerInputChange> r12) {
        if ((r12 instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) r12;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        Ref.BooleanRef r11 = (Ref.BooleanRef) r0.L$2;
        Ref.ObjectRef r14 = (Ref.ObjectRef) r0.L$1;
        PointerInputChange r15 = (PointerInputChange) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: PointerEventTimeoutCancellationException -> L14
        r10 = r14;
    L36:
        if (r11.element == false) goto L49;
        PointerInputChange r4 = (PointerInputChange) ((Ref.ObjectRef) r10).element;     // Catch: PointerEventTimeoutCancellationException -> L14
        if (r4 == null) goto L51;
        return r4;
    L51:
        return r15;
    L49:
        return null;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);
        if (m586isPointerUpDmW0f2w(r9.getCurrentEvent(), r10) == false) goto L20;
        return null;
    L20:
        List r16 = r9.getCurrentEvent().getChanges();
        int r5 = r16.size();
        int r6 = 0;
    L21:
        if (r6 >= r5) goto L26;
        Object r7 = ListProtector.get(r16, r6);
        if (PointerId.equals-impl0(((PointerInputChange) r7).getId-J3iCeTQ(), r10) == true) goto L27;
        r6 = r6 + 1;
    L27:
        r15 = (PointerInputChange) r7;
        if (r15 != null) goto L30;
        return null;
    L30:
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        r18.element = r15;
        long r8 = r9.getViewConfiguration().getLongPressTimeoutMillis();
        Ref.BooleanRef r19 = new Ref.BooleanRef();     // Catch: PointerEventTimeoutCancellationException -> L14
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 r20 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(r19, r18, r17, null);     // Catch: PointerEventTimeoutCancellationException -> L14
        r0.L$0 = r15;     // Catch: PointerEventTimeoutCancellationException -> L14
        r0.L$1 = r17;     // Catch: PointerEventTimeoutCancellationException -> L14
        r0.L$2 = r19;     // Catch: PointerEventTimeoutCancellationException -> L14
        r0.label = 1;     // Catch: PointerEventTimeoutCancellationException -> L14
        if (r9.withTimeout(r8, r20, r0) != r2) goto L34;
        return r2;
    L34:
        r11 = r19;
        r10 = r17;
        goto L36
    L26:
        r7 = null;
    L40:
        PointerInputChange r21 = (PointerInputChange) r10.element;
        if (r21 == null) goto L51;
        return r21;
    L7:
        r0 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final Object m579awaitVerticalDragOrCancellationrnUCldI(AwaitPointerEventScope r17, long r18, Continuation<? super PointerInputChange> r20) {
        if ((r20 instanceof DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = (DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) r20;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        Ref.LongRef r0 = (Ref.LongRef) r3.L$1;
        AwaitPointerEventScope r1 = (AwaitPointerEventScope) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Ref.LongRef r8 = r0;
        AwaitPointerEventScope r9 = r1;
    L22:
        PointerEvent r10 = (PointerEvent) r2;
        List r11 = r10.getChanges();
        int r12 = r11.size();
        int r13 = 0;
    L23:
        if (r13 >= r12) goto L28;
        Object r14 = ListProtector.get(r11, r13);
        if (PointerId.equals-impl0(((PointerInputChange) r14).getId-J3iCeTQ(), r8.element) == true) goto L29;
        r13 = r13 + 1;
    L29:
        PointerInputChange r15 = (PointerInputChange) r14;
        if (r15 != null) goto L33;
        r15 = null;
    L51:
        if (r15 != null) goto L53;
    L55:
        r7 = false;
    L56:
        if (r7 == true) goto L58;
        return null;
    L58:
        return r15;
    L53:
        if (r15.isConsumed() == true) goto L55;
    L33:
        if (PointerEventKt.changedToUpIgnoreConsumed(r15) == false) goto L46;
        List r16 = r10.getChanges();
        int r19 = r16.size();
        int r21 = 0;
    L35:
        if (r21 >= r19) goto L40;
        Object r110 = ListProtector.get(r16, r21);
        if (((PointerInputChange) r110).getPressed() == true) goto L41;
        r21 = r21 + 1;
    L41:
        PointerInputChange r111 = (PointerInputChange) r110;
        if (r111 == null) goto L51;
        r8.element = r111.getId-J3iCeTQ();
    L59:
        Ref.LongRef r22 = r8;
    L18:
        r3.L$0 = r9;
        r3.L$1 = r22;
        r3.label = 1;
        Object r23 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r9, null, r3, 1, null);
        if (r23 != r5) goto L21;
        return r5;
    L21:
        Ref.LongRef r112 = r22;
        r2 = r23;
        r8 = r112;
        goto L22
    L40:
        r110 = null;
        goto L41
    L46:
        if (Float.intBitsToFloat((int) (PointerEventKt.positionChangeIgnoreConsumed(r15) & 4294967295L)) != MenuKt.ClosedAlphaTarget) goto L48;
        boolean r24 = true;
    L50:
        if ((!r24) == false) goto L59;
    L48:
        r24 = false;
        goto L50
    L28:
        r14 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        if (m586isPointerUpDmW0f2w(r17.getCurrentEvent(), r18) == false) goto L17;
        return null;
    L17:
        r22 = new Ref.LongRef();
        r22.element = r18;
        r9 = r17;
    L7:
        r3 = new DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(r20);
        goto L8
    }

    private static final Unit detectDragGestures$lambda$7(PointerInputChange r0, PointerInputChange r1, Offset r2) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009c -> B:23:0x009e). Please report as a decompilation issue!!! */
    public static final Object awaitAllPointersUpWithSlopDetection(AwaitPointerEventScope r17, PointerInputChange r18, PointerEventPass r19, Continuation<? super Boolean> r20) {
        if ((r20 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) r20;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        int r5 = 1;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        float r6 = r1.F$0;
        int r7 = r1.I$0;
        TouchSlopDetector r8 = (TouchSlopDetector) r1.L$3;
        Ref.LongRef r9 = (Ref.LongRef) r1.L$2;
        PointerEventPass r10 = (PointerEventPass) r1.L$1;
        AwaitPointerEventScope r11 = (AwaitPointerEventScope) r1.L$0;
        ResultKt.throwOnFailure(r0);
        TouchSlopDetector r12 = r8;
        int r13 = r7;
        float r14 = r6;
        Object r15 = r3;
        AnonymousClass1 r16 = r1;
        PointerEventPass r21 = r10;
    L23:
        PointerEvent r22 = (PointerEvent) r0;
        List r23 = r22.getChanges();
        int r110 = r23.size();
        int r111 = 0;
    L24:
        if (r111 >= r110) goto L29;
        Object r112 = ListProtector.get(r23, r111);
        if (PointerId.equals-impl0(((PointerInputChange) r112).getId-J3iCeTQ(), r9.element) == true) goto L27;
        r111 = r111 + 1;
        goto L24
    L27:
        Object r113 = r112;
    L30:
        PointerInputChange r114 = (PointerInputChange) r113;
        if (r114 != null) goto L33;
    L41:
        List r24 = r22.getChanges();
        int r25 = r24.size();
        int r26 = 0;
    L42:
        if (r26 >= r25) goto L47;
        Object r115 = ListProtector.get(r24, r26);
        if (((PointerInputChange) r115).getPressed() == true) goto L45;
        r26 = r26 + 1;
        goto L42
    L45:
        Object r116 = r115;
    L48:
        PointerInputChange r117 = (PointerInputChange) r116;
        if (r117 != null) goto L55;
        if (r13 == 0) goto L52;
        boolean r27 = true;
    L54:
        return Boxing.boxBoolean(r27);
    L52:
        r27 = false;
        goto L54
    L55:
        r9.element = r117.getId-J3iCeTQ();
    L56:
        List r28 = r22.getChanges();
        int r29 = r28.size();
        int r30 = 0;
    L57:
        if (r30 >= r29) goto L62;
        if (((PointerInputChange) ListProtector.get(r28, r30)).getPressed() == true) goto L60;
        r30 = r30 + 1;
        goto L57
    L60:
        boolean r31 = true;
    L63:
        if (r31 == true) goto L69;
        if (r13 == 0) goto L66;
        boolean r32 = true;
    L68:
        return Boxing.boxBoolean(r32);
    L66:
        r32 = false;
        goto L68
    L69:
        AwaitPointerEventScope r33 = r11;
        r5 = 1;
    L19:
        r16.L$0 = r33;
        r16.L$1 = r21;
        r16.L$2 = r9;
        r16.L$3 = r12;
        r16.I$0 = r13;
        r16.F$0 = r14;
        r16.label = r5;
        Object r34 = r33.awaitPointerEvent(r21, r16);
        if (r34 != r15) goto L22;
        return r15;
    L22:
        r11 = r33;
        r0 = r34;
        goto L23
    L62:
        r31 = false;
        goto L63
    L47:
        r116 = null;
        goto L48
    L33:
        if (PointerEventKt.changedToUpIgnoreConsumed(r114) == true) goto L41;
        if ((r12.m716addPointerInputChangedBAh8RU(r114, r14) & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L38;
        boolean r35 = true;
    L39:
        if (r35 == false) goto L56;
        r13 = 1;
        goto L56
    L38:
        r35 = false;
        goto L39
    L29:
        r113 = null;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (ForEachGestureKt.allPointersUp(r17) == true) goto L17;
        Ref.LongRef r36 = new Ref.LongRef();
        r36.element = r18.getId-J3iCeTQ();
        float r37 = m587pointerSlopE8SPZFQ(r17.getViewConfiguration(), r18.getType-T8wyACA());
        r12 = new TouchSlopDetector(null, 0, 3, null);
        r9 = r36;
        r14 = r37;
        r13 = 0;
        r33 = r17;
        r15 = r3;
        r16 = r1;
        r21 = r19;
        goto L19
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r1 = new AnonymousClass1(r20);
        goto L8
    }

    /* JADX INFO: renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m570awaitDragOrUpjO51t88(AwaitPointerEventScope r10, long r11, Function1<? super PointerInputChange, Boolean> r13, Continuation<? super PointerInputChange> r14) {
        Ref.LongRef r0 = new Ref.LongRef();
        r0.element = r11;
    L3:
        int r12 = 0;
        InlineMarker.mark(0);
        Object r15 = null;
        Object r2 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r10, null, r14, 1, null);
        InlineMarker.mark(1);
        PointerEvent r3 = (PointerEvent) r2;
        List r1 = r3.getChanges();
        int r4 = r1.size();
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L9;
        Object r6 = ListProtector.get(r1, r5);
        if (Boolean.valueOf(PointerId.equals-impl0(((PointerInputChange) r6).getId-J3iCeTQ(), r0.element)).booleanValue() == true) goto L10;
        r5 = r5 + 1;
    L10:
        PointerInputChange r7 = (PointerInputChange) r6;
        if (r7 == null) goto L27;
        if (PointerEventKt.changedToUpIgnoreConsumed(r7) == true) goto L14;
        if (((Boolean) r13.invoke(r7)).booleanValue() == false) goto L3;
        return r7;
    L14:
        List r8 = r3.getChanges();
        int r9 = r8.size();
    L15:
        if (r12 >= r9) goto L20;
        Object r16 = ListProtector.get(r8, r12);
        if (Boolean.valueOf(((PointerInputChange) r16).getPressed()).booleanValue() == true) goto L18;
        r12 = r12 + 1;
        goto L15
    L18:
        r15 = r16;
    L20:
        PointerInputChange r17 = (PointerInputChange) r15;
        if (r17 == null) goto L22;
        r0.element = r17.getId-J3iCeTQ();
        goto L3
    L22:
        return r7;
    L27:
        return null;
    L9:
        r6 = null;
        goto L10
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x018b -> B:64:0x0192). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final Object m573awaitHorizontalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope r20, long r21, Function2<? super PointerInputChange, ? super Float, Unit> r23, Continuation<? super PointerInputChange> r24) {
        if ((r24 instanceof DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = (DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) r24;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 1;
        PointerEventPass r8 = null;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        float r0 = r3.F$0;
        PointerInputChange r1 = (PointerInputChange) r3.L$4;
        TouchSlopDetector r9 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r10 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r11 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r12 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        TouchSlopDetector r13 = r9;
        Object r14 = r5;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r15 = r3;
        float r16 = r0;
        AwaitPointerEventScope r17 = r11;
    L65:
        if (r1.isConsumed() == false) goto L68;
    L66:
        return null;
    L68:
        Function2<? super PointerInputChange, ? super Float, Unit> r18 = r12;
        r7 = 1;
        r8 = null;
        Ref.LongRef r19 = r10;
    L20:
        r15.L$0 = r18;
        r15.L$1 = r17;
        r15.L$2 = r19;
        r15.L$3 = r13;
        r15.L$4 = r8;
        r15.F$0 = r16;
        r15.label = r7;
        Object r22 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r17, r8, r15, r7, r8);
        if (r22 != r14) goto L23;
        return r14;
    L23:
        float r110 = r16;
        TouchSlopDetector r25 = r13;
        r2 = r22;
        Object r26 = r14;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r27 = r15;
        float r28 = r110;
    L24:
        PointerEvent r29 = (PointerEvent) r2;
        List r111 = r29.getChanges();
        int r112 = r111.size();
        int r113 = 0;
    L25:
        if (r113 >= r112) goto L30;
        Object r114 = ListProtector.get(r111, r113);
        long r30 = ((PointerInputChange) r114).getId-J3iCeTQ();
        int r115 = r113;
        if (PointerId.equals-impl0(r30, r19.element) == true) goto L31;
        r113 = r115 + 1;
    L31:
        PointerInputChange r31 = (PointerInputChange) r114;
        if (r31 == null) goto L66;
        if (r31.isConsumed() == true) goto L66;
        if (PointerEventKt.changedToUpIgnoreConsumed(r31) == false) goto L50;
        List r32 = r29.getChanges();
        int r33 = r32.size();
        int r116 = 0;
    L40:
        if (r116 >= r33) goto L45;
        Object r34 = ListProtector.get(r32, r116);
        if (((PointerInputChange) r34).getPressed() == true) goto L46;
        r116 = r116 + 1;
    L46:
        PointerInputChange r35 = (PointerInputChange) r34;
        if (r35 == null) goto L66;
        r19.element = r35.getId-J3iCeTQ();
        r13 = r25;
        r16 = r28;
        r15 = r27;
        r14 = r26;
        r7 = 1;
        r8 = null;
        goto L20
    L45:
        r34 = null;
        goto L46
    L50:
        long r117 = r25.m716addPointerInputChangedBAh8RU(r31, r28);
        if ((SieveCacheKt.InvalidMapping & r117) == 9205357640488583168L) goto L53;
        boolean r36 = true;
    L54:
        if (r36 == false) goto L60;
        r18.invoke(r31, Boxing.boxFloat(Float.intBitsToFloat((int) (r117 >> 32))));
        if (r31.isConsumed() == true) goto L74;
        r25.reset();
        r13 = r25;
        r16 = r28;
        r15 = r27;
        r14 = r26;
        r7 = 1;
        r8 = null;
        goto L20
    L74:
        return r31;
    L60:
        PointerEventPass r37 = PointerEventPass.Final;
        r27.L$0 = r18;
        r27.L$1 = r17;
        r27.L$2 = r19;
        r27.L$3 = r25;
        r27.L$4 = r31;
        r27.F$0 = r28;
        r27.label = 2;
        if (r17.awaitPointerEvent(r37, r27) != r26) goto L63;
        return r26;
    L63:
        r13 = r25;
        r16 = r28;
        r15 = r27;
        r14 = r26;
        r10 = r19;
        r12 = r18;
        r1 = r31;
        goto L65
    L53:
        r36 = false;
        goto L54
    L30:
        r114 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r38 = r3.F$0;
        TouchSlopDetector r39 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r40 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r41 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r118 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r19 = r40;
        r27 = r3;
        r25 = r39;
        r18 = r118;
        r28 = r38;
        r17 = r41;
        r26 = r5;
        goto L24
    L16:
        ResultKt.throwOnFailure(r2);
        int r42 = PointerType.Companion.getTouch-T8wyACA();
        Orientation r43 = Orientation.Horizontal;
        long r44 = Offset.Companion.getZero-F1C5BW0();
        if (m568access$isPointerUpDmW0f2w(r20.getCurrentEvent(), r21) == true) goto L75;
        float r45 = m587pointerSlopE8SPZFQ(r20.getViewConfiguration(), r42);
        r19 = new Ref.LongRef();
        r19.element = r21;
        TouchSlopDetector r46 = new TouchSlopDetector(r43, r44, null);
        r18 = r23;
        r14 = r5;
        r15 = r3;
        r16 = r45;
        r13 = r46;
        r17 = r20;
        goto L20
    L75:
        return null;
    L7:
        r3 = new DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(r24);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0184 -> B:64:0x018b). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final Object m578awaitTouchSlopOrCancellationjO51t88(AwaitPointerEventScope r19, long r20, Function2<? super PointerInputChange, ? super Offset, Unit> r22, Continuation<? super PointerInputChange> r23) {
        if ((r23 instanceof DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r3 = (DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) r23;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 1;
        PointerEventPass r8 = null;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        float r0 = r3.F$0;
        PointerInputChange r1 = (PointerInputChange) r3.L$4;
        TouchSlopDetector r9 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r10 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r11 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Offset, Unit> r12 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        TouchSlopDetector r13 = r9;
        Object r14 = r5;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r15 = r3;
        float r16 = r0;
        AwaitPointerEventScope r17 = r11;
    L65:
        if (r1.isConsumed() == false) goto L68;
    L66:
        return null;
    L68:
        Function2<? super PointerInputChange, ? super Offset, Unit> r18 = r12;
    L69:
        r7 = 1;
        r8 = null;
    L20:
        r15.L$0 = r18;
        r15.L$1 = r17;
        r15.L$2 = r10;
        r15.L$3 = r13;
        r15.L$4 = r8;
        r15.F$0 = r16;
        r15.label = r7;
        Object r110 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r17, r8, r15, r7, r8);
        if (r110 != r14) goto L23;
        return r14;
    L23:
        float r111 = r16;
        TouchSlopDetector r21 = r13;
        r2 = r110;
        Ref.LongRef r112 = r10;
        Object r24 = r14;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r25 = r15;
        float r26 = r111;
    L24:
        PointerEvent r27 = (PointerEvent) r2;
        List r113 = r27.getChanges();
        int r114 = r113.size();
        int r115 = 0;
    L25:
        if (r115 >= r114) goto L30;
        Object r116 = ListProtector.get(r113, r115);
        long r28 = ((PointerInputChange) r116).getId-J3iCeTQ();
        int r117 = r115;
        if (PointerId.equals-impl0(r28, r112.element) == true) goto L31;
        r115 = r117 + 1;
    L31:
        PointerInputChange r29 = (PointerInputChange) r116;
        if (r29 == null) goto L66;
        if (r29.isConsumed() == true) goto L66;
        if (PointerEventKt.changedToUpIgnoreConsumed(r29) == false) goto L50;
        List r30 = r27.getChanges();
        int r31 = r30.size();
        int r118 = 0;
    L40:
        if (r118 >= r31) goto L45;
        Object r32 = ListProtector.get(r30, r118);
        if (((PointerInputChange) r32).getPressed() == true) goto L46;
        r118 = r118 + 1;
    L46:
        PointerInputChange r33 = (PointerInputChange) r32;
        if (r33 == null) goto L66;
        r112.element = r33.getId-J3iCeTQ();
        r13 = r21;
        r16 = r26;
        r15 = r25;
        r14 = r24;
        r10 = r112;
        goto L69
    L45:
        r32 = null;
        goto L46
    L50:
        long r119 = r21.m716addPointerInputChangedBAh8RU(r29, r26);
        if ((SieveCacheKt.InvalidMapping & r119) == 9205357640488583168L) goto L53;
        boolean r120 = true;
    L54:
        if (r120 == false) goto L60;
        r18.invoke(r29, Offset.box-impl(r119));
        if (r29.isConsumed() == true) goto L75;
        r21.reset();
        r13 = r21;
        r16 = r26;
        r15 = r25;
        r14 = r24;
        r10 = r112;
        goto L69
    L75:
        return r29;
    L60:
        PointerEventPass r34 = PointerEventPass.Final;
        r25.L$0 = r18;
        r25.L$1 = r17;
        r25.L$2 = r112;
        r25.L$3 = r21;
        r25.L$4 = r29;
        r25.F$0 = r26;
        r25.label = 2;
        if (r17.awaitPointerEvent(r34, r25) != r24) goto L63;
        return r24;
    L63:
        r12 = r18;
        r13 = r21;
        r16 = r26;
        r15 = r25;
        r1 = r29;
        r14 = r24;
        r10 = r112;
        goto L65
    L53:
        r120 = false;
        goto L54
    L30:
        r116 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r35 = r3.F$0;
        TouchSlopDetector r36 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r37 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r38 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Offset, Unit> r121 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r26 = r35;
        r17 = r38;
        r24 = r5;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r122 = r3;
        r21 = r36;
        r18 = r121;
        r112 = r37;
        r25 = r122;
        goto L24
    L16:
        ResultKt.throwOnFailure(r2);
        int r39 = PointerType.Companion.getTouch-T8wyACA();
        long r40 = Offset.Companion.getZero-F1C5BW0();
        if (m568access$isPointerUpDmW0f2w(r19.getCurrentEvent(), r20) == true) goto L76;
        float r41 = m587pointerSlopE8SPZFQ(r19.getViewConfiguration(), r39);
        Ref.LongRef r42 = new Ref.LongRef();
        r42.element = r20;
        TouchSlopDetector r43 = new TouchSlopDetector(null, r40, null);
        r18 = r22;
        r10 = r42;
        r14 = r5;
        r15 = r3;
        r16 = r41;
        r13 = r43;
        r17 = r19;
        goto L20
    L76:
        return null;
    L7:
        r3 = new DragGestureDetectorKt$awaitTouchSlopOrCancellation$1(r23);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x018e -> B:64:0x0195). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final Object m581awaitVerticalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope r20, long r21, Function2<? super PointerInputChange, ? super Float, Unit> r23, Continuation<? super PointerInputChange> r24) {
        if ((r24 instanceof DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = (DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) r24;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 1;
        PointerEventPass r8 = null;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        float r0 = r3.F$0;
        PointerInputChange r1 = (PointerInputChange) r3.L$4;
        TouchSlopDetector r9 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r10 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r11 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r12 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        TouchSlopDetector r13 = r9;
        Object r14 = r5;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r15 = r3;
        float r16 = r0;
        AwaitPointerEventScope r17 = r11;
    L65:
        if (r1.isConsumed() == false) goto L68;
    L66:
        return null;
    L68:
        Function2<? super PointerInputChange, ? super Float, Unit> r18 = r12;
        r7 = 1;
        r8 = null;
        Ref.LongRef r19 = r10;
    L20:
        r15.L$0 = r18;
        r15.L$1 = r17;
        r15.L$2 = r19;
        r15.L$3 = r13;
        r15.L$4 = r8;
        r15.F$0 = r16;
        r15.label = r7;
        Object r22 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r17, r8, r15, r7, r8);
        if (r22 != r14) goto L23;
        return r14;
    L23:
        float r110 = r16;
        TouchSlopDetector r25 = r13;
        r2 = r22;
        Object r26 = r14;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r27 = r15;
        float r28 = r110;
    L24:
        PointerEvent r29 = (PointerEvent) r2;
        List r111 = r29.getChanges();
        int r112 = r111.size();
        int r113 = 0;
    L25:
        if (r113 >= r112) goto L30;
        Object r114 = ListProtector.get(r111, r113);
        long r30 = ((PointerInputChange) r114).getId-J3iCeTQ();
        int r115 = r113;
        if (PointerId.equals-impl0(r30, r19.element) == true) goto L31;
        r113 = r115 + 1;
    L31:
        PointerInputChange r31 = (PointerInputChange) r114;
        if (r31 == null) goto L66;
        if (r31.isConsumed() == true) goto L66;
        if (PointerEventKt.changedToUpIgnoreConsumed(r31) == false) goto L50;
        List r32 = r29.getChanges();
        int r33 = r32.size();
        int r116 = 0;
    L40:
        if (r116 >= r33) goto L45;
        Object r34 = ListProtector.get(r32, r116);
        if (((PointerInputChange) r34).getPressed() == true) goto L46;
        r116 = r116 + 1;
    L46:
        PointerInputChange r35 = (PointerInputChange) r34;
        if (r35 == null) goto L66;
        r19.element = r35.getId-J3iCeTQ();
        r13 = r25;
        r16 = r28;
        r15 = r27;
        r14 = r26;
        r7 = 1;
        r8 = null;
        goto L20
    L45:
        r34 = null;
        goto L46
    L50:
        long r117 = r25.m716addPointerInputChangedBAh8RU(r31, r28);
        if ((SieveCacheKt.InvalidMapping & r117) == 9205357640488583168L) goto L53;
        boolean r36 = true;
    L54:
        if (r36 == false) goto L60;
        r18.invoke(r31, Boxing.boxFloat(Float.intBitsToFloat((int) (r117 & 4294967295L))));
        if (r31.isConsumed() == true) goto L74;
        r25.reset();
        r13 = r25;
        r16 = r28;
        r15 = r27;
        r14 = r26;
        r7 = 1;
        r8 = null;
        goto L20
    L74:
        return r31;
    L60:
        PointerEventPass r37 = PointerEventPass.Final;
        r27.L$0 = r18;
        r27.L$1 = r17;
        r27.L$2 = r19;
        r27.L$3 = r25;
        r27.L$4 = r31;
        r27.F$0 = r28;
        r27.label = 2;
        if (r17.awaitPointerEvent(r37, r27) != r26) goto L63;
        return r26;
    L63:
        r13 = r25;
        r16 = r28;
        r15 = r27;
        r14 = r26;
        r10 = r19;
        r12 = r18;
        r1 = r31;
        goto L65
    L53:
        r36 = false;
        goto L54
    L30:
        r114 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r38 = r3.F$0;
        TouchSlopDetector r39 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r40 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r41 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r118 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r19 = r40;
        r27 = r3;
        r25 = r39;
        r18 = r118;
        r28 = r38;
        r17 = r41;
        r26 = r5;
        goto L24
    L16:
        ResultKt.throwOnFailure(r2);
        int r42 = PointerType.Companion.getTouch-T8wyACA();
        Orientation r43 = Orientation.Vertical;
        long r44 = Offset.Companion.getZero-F1C5BW0();
        if (m568access$isPointerUpDmW0f2w(r20.getCurrentEvent(), r21) == true) goto L75;
        float r45 = m587pointerSlopE8SPZFQ(r20.getViewConfiguration(), r42);
        r19 = new Ref.LongRef();
        r19.element = r21;
        TouchSlopDetector r46 = new TouchSlopDetector(r43, r44, null);
        r18 = r23;
        r14 = r5;
        r15 = r3;
        r16 = r45;
        r13 = r46;
        r17 = r20;
        goto L20
    L75:
        return null;
    L7:
        r3 = new DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(r24);
        goto L8
    }

    private static final Unit detectDragGestures$lambda$4(Function1 r0, PointerInputChange r1, PointerInputChange r2, Offset r3) {
        r0.invoke(Offset.box-impl(r2.getPosition-F1C5BW0()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:18:0x004b). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: drag-jO51t88, reason: not valid java name */
    public static final Object m584dragjO51t88(AwaitPointerEventScope r4, long r5, Function1<? super PointerInputChange, Unit> r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof DragGestureDetectorKt$drag$1) == false) goto L7;
        DragGestureDetectorKt$drag$1 r0 = (DragGestureDetectorKt$drag$1) r8;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Function1<? super PointerInputChange, Unit> r6 = (Function1) r0.L$1;
        AwaitPointerEventScope r10 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r9);
        r7 = r6;
        r4 = r10;
    L18:
        PointerInputChange r11 = (PointerInputChange) r9;
        if (r11 != null) goto L23;
        return Boxing.boxBoolean(false);
    L23:
        if (PointerEventKt.changedToUpIgnoreConsumed(r11) == true) goto L25;
        r7.invoke(r11);
        r5 = r11.getId-J3iCeTQ();
    L15:
        r0.L$0 = r4;
        r0.L$1 = r7;
        r0.label = 1;
        r9 = m569awaitDragOrCancellationrnUCldI(r4, r5, r0);
        if (r9 != r2) goto L18;
        return r2;
    L25:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
    L7:
        r0 = new DragGestureDetectorKt$drag$1(r8);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0085 -> B:23:0x008b). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    public static final Object m585horizontalDragjO51t88(AwaitPointerEventScope r17, long r18, Function1<? super PointerInputChange, Unit> r20, Continuation<? super Boolean> r21) {
        if ((r21 instanceof DragGestureDetectorKt$horizontalDrag$1) == false) goto L7;
        DragGestureDetectorKt$horizontalDrag$1 r1 = (DragGestureDetectorKt$horizontalDrag$1) r21;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        PointerInputChange r5 = null;
        int r6 = 1;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Ref.LongRef r7 = (Ref.LongRef) r1.L$4;
        AwaitPointerEventScope r8 = (AwaitPointerEventScope) r1.L$3;
        Orientation r9 = (Orientation) r1.L$2;
        AwaitPointerEventScope r10 = (AwaitPointerEventScope) r1.L$1;
        Function1<? super PointerInputChange, Unit> r11 = (Function1) r1.L$0;
        ResultKt.throwOnFailure(r0);
        DragGestureDetectorKt$horizontalDrag$1 r12 = r1;
        Function1<? super PointerInputChange, Unit> r13 = r11;
        Ref.LongRef r14 = r7;
    L23:
        PointerEvent r15 = (PointerEvent) r0;
        List r16 = r15.getChanges();
        int r19 = r16.size();
        int r110 = 0;
    L24:
        if (r110 >= r19) goto L29;
        Object r111 = ListProtector.get(r16, r110);
        AwaitPointerEventScope r112 = r8;
        if (PointerId.equals-impl0(((PointerInputChange) r111).getId-J3iCeTQ(), r14.element) == true) goto L30;
        r110 = r110 + 1;
        r8 = r112;
    L30:
        PointerInputChange r113 = (PointerInputChange) r111;
        if (r113 != null) goto L34;
        boolean r22 = true;
        r113 = null;
    L60:
        if (r113 != null) goto L63;
    L61:
        r5 = null;
    L68:
        if (r5 != null) goto L72;
        r22 = false;
    L72:
        return Boxing.boxBoolean(r22);
    L63:
        if (r113.isConsumed() == true) goto L61;
        if (PointerEventKt.changedToUpIgnoreConsumed(r113) == false) goto L73;
        r5 = r113;
        goto L68
    L73:
        r13.invoke(r113);
        AwaitPointerEventScope r23 = r10;
        Object r24 = r3;
        Orientation r25 = r9;
        long r26 = r113.getId-J3iCeTQ();
        r5 = null;
        r6 = 1;
    L18:
        r14 = new Ref.LongRef();
        r14.element = r26;
        r8 = r23;
        r9 = r25;
    L19:
        r12.L$0 = r13;
        r12.L$1 = r23;
        r12.L$2 = r9;
        r12.L$3 = r8;
        r12.L$4 = r14;
        r12.label = r6;
        Object r27 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r8, r5, r12, r6, r5);
        if (r27 != r24) goto L22;
        return r24;
    L22:
        Object r114 = r24;
        r10 = r23;
        r0 = r27;
        r3 = r114;
        goto L23
    L34:
        if (PointerEventKt.changedToUpIgnoreConsumed(r113) == false) goto L46;
        List r28 = r15.getChanges();
        int r29 = r28.size();
        int r30 = 0;
    L36:
        if (r30 >= r29) goto L41;
        Object r31 = ListProtector.get(r28, r30);
        if (((PointerInputChange) r31).getPressed() == true) goto L42;
        r30 = r30 + 1;
    L42:
        PointerInputChange r32 = (PointerInputChange) r31;
        if (r32 != null) goto L45;
        r22 = true;
        goto L60
    L45:
        r14.element = r32.getId-J3iCeTQ();
    L74:
        r8 = r112;
        r23 = r10;
        r5 = null;
        r6 = 1;
        r24 = r3;
        goto L19
    L41:
        r31 = null;
        goto L42
    L46:
        long r33 = PointerEventKt.positionChangeIgnoreConsumed(r113);
        if (r9 != null) goto L50;
        float r34 = Offset.getDistance-impl(r33);
    L55:
        if (r34 != MenuKt.ClosedAlphaTarget) goto L57;
        boolean r35 = true;
    L58:
        r22 = true;
        if ((!r35) == false) goto L74;
    L57:
        r35 = false;
        goto L58
    L50:
        if (r9 != Orientation.Vertical) goto L52;
        long r36 = r33 & 4294967295L;
    L53:
        r34 = Float.intBitsToFloat((int) r36);
        goto L55
    L52:
        r36 = r33 >> 32;
        goto L53
    L29:
        r112 = r8;
        r111 = null;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Orientation r37 = Orientation.Horizontal;
        r26 = r18;
        if (m568access$isPointerUpDmW0f2w(r17.getCurrentEvent(), r26) == false) goto L17;
        r22 = true;
        goto L68
    L17:
        r12 = r1;
        r24 = r3;
        r13 = r20;
        r25 = r37;
        r23 = r17;
    L7:
        r1 = new DragGestureDetectorKt$horizontalDrag$1(r21);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0085 -> B:23:0x008b). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: verticalDrag-jO51t88, reason: not valid java name */
    public static final Object m588verticalDragjO51t88(AwaitPointerEventScope r17, long r18, Function1<? super PointerInputChange, Unit> r20, Continuation<? super Boolean> r21) {
        if ((r21 instanceof DragGestureDetectorKt$verticalDrag$1) == false) goto L7;
        DragGestureDetectorKt$verticalDrag$1 r1 = (DragGestureDetectorKt$verticalDrag$1) r21;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        PointerInputChange r5 = null;
        int r6 = 1;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Ref.LongRef r7 = (Ref.LongRef) r1.L$4;
        AwaitPointerEventScope r8 = (AwaitPointerEventScope) r1.L$3;
        Orientation r9 = (Orientation) r1.L$2;
        AwaitPointerEventScope r10 = (AwaitPointerEventScope) r1.L$1;
        Function1<? super PointerInputChange, Unit> r11 = (Function1) r1.L$0;
        ResultKt.throwOnFailure(r0);
        DragGestureDetectorKt$verticalDrag$1 r12 = r1;
        Function1<? super PointerInputChange, Unit> r13 = r11;
        Ref.LongRef r14 = r7;
    L23:
        PointerEvent r15 = (PointerEvent) r0;
        List r16 = r15.getChanges();
        int r19 = r16.size();
        int r110 = 0;
    L24:
        if (r110 >= r19) goto L29;
        Object r111 = ListProtector.get(r16, r110);
        AwaitPointerEventScope r112 = r8;
        if (PointerId.equals-impl0(((PointerInputChange) r111).getId-J3iCeTQ(), r14.element) == true) goto L30;
        r110 = r110 + 1;
        r8 = r112;
    L30:
        PointerInputChange r113 = (PointerInputChange) r111;
        if (r113 != null) goto L34;
        boolean r22 = true;
        r113 = null;
    L60:
        if (r113 != null) goto L63;
    L61:
        r5 = null;
    L68:
        if (r5 != null) goto L72;
        r22 = false;
    L72:
        return Boxing.boxBoolean(r22);
    L63:
        if (r113.isConsumed() == true) goto L61;
        if (PointerEventKt.changedToUpIgnoreConsumed(r113) == false) goto L73;
        r5 = r113;
        goto L68
    L73:
        r13.invoke(r113);
        AwaitPointerEventScope r23 = r10;
        Object r24 = r3;
        Orientation r25 = r9;
        long r26 = r113.getId-J3iCeTQ();
        r5 = null;
        r6 = 1;
    L18:
        r14 = new Ref.LongRef();
        r14.element = r26;
        r8 = r23;
        r9 = r25;
    L19:
        r12.L$0 = r13;
        r12.L$1 = r23;
        r12.L$2 = r9;
        r12.L$3 = r8;
        r12.L$4 = r14;
        r12.label = r6;
        Object r27 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r8, r5, r12, r6, r5);
        if (r27 != r24) goto L22;
        return r24;
    L22:
        Object r114 = r24;
        r10 = r23;
        r0 = r27;
        r3 = r114;
        goto L23
    L34:
        if (PointerEventKt.changedToUpIgnoreConsumed(r113) == false) goto L46;
        List r28 = r15.getChanges();
        int r29 = r28.size();
        int r30 = 0;
    L36:
        if (r30 >= r29) goto L41;
        Object r31 = ListProtector.get(r28, r30);
        if (((PointerInputChange) r31).getPressed() == true) goto L42;
        r30 = r30 + 1;
    L42:
        PointerInputChange r32 = (PointerInputChange) r31;
        if (r32 != null) goto L45;
        r22 = true;
        goto L60
    L45:
        r14.element = r32.getId-J3iCeTQ();
    L74:
        r8 = r112;
        r23 = r10;
        r5 = null;
        r6 = 1;
        r24 = r3;
        goto L19
    L41:
        r31 = null;
        goto L42
    L46:
        long r33 = PointerEventKt.positionChangeIgnoreConsumed(r113);
        if (r9 != null) goto L50;
        float r34 = Offset.getDistance-impl(r33);
    L55:
        if (r34 != MenuKt.ClosedAlphaTarget) goto L57;
        boolean r35 = true;
    L58:
        r22 = true;
        if ((!r35) == false) goto L74;
    L57:
        r35 = false;
        goto L58
    L50:
        if (r9 != Orientation.Vertical) goto L52;
        long r36 = r33 & 4294967295L;
    L53:
        r34 = Float.intBitsToFloat((int) r36);
        goto L55
    L52:
        r36 = r33 >> 32;
        goto L53
    L29:
        r112 = r8;
        r111 = null;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Orientation r37 = Orientation.Vertical;
        r26 = r18;
        if (m568access$isPointerUpDmW0f2w(r17.getCurrentEvent(), r26) == false) goto L17;
        r22 = true;
        goto L68
    L17:
        r12 = r1;
        r24 = r3;
        r13 = r20;
        r25 = r37;
        r23 = r17;
    L7:
        r1 = new DragGestureDetectorKt$verticalDrag$1(r21);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0182 -> B:64:0x0189). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final Object m572awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope r20, long r21, int r23, Function2<? super PointerInputChange, ? super Float, Unit> r24, Continuation<? super PointerInputChange> r25) {
        if ((r25 instanceof DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) r25;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 1;
        PointerEventPass r8 = null;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        float r0 = r3.F$0;
        PointerInputChange r1 = (PointerInputChange) r3.L$4;
        TouchSlopDetector r9 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r10 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r11 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r12 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        TouchSlopDetector r13 = r9;
        float r14 = r0;
        AwaitPointerEventScope r15 = r11;
    L65:
        if (r1.isConsumed() == false) goto L68;
    L66:
        return null;
    L68:
        Function2<? super PointerInputChange, ? super Float, Unit> r16 = r12;
        r7 = 1;
        r8 = null;
        Ref.LongRef r17 = r10;
    L20:
        r3.L$0 = r16;
        r3.L$1 = r15;
        r3.L$2 = r17;
        r3.L$3 = r13;
        r3.L$4 = r8;
        r3.F$0 = r14;
        r3.label = r7;
        Object r18 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r15, r8, r3, r7, r8);
        if (r18 != r5) goto L23;
        return r5;
    L23:
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r19 = r3;
        TouchSlopDetector r22 = r13;
        r2 = r18;
        float r26 = r14;
        Object r27 = r5;
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r28 = r19;
    L24:
        PointerEvent r29 = (PointerEvent) r2;
        List r110 = r29.getChanges();
        int r111 = r110.size();
        int r112 = 0;
    L25:
        if (r112 >= r111) goto L30;
        Object r113 = ListProtector.get(r110, r112);
        long r30 = ((PointerInputChange) r113).getId-J3iCeTQ();
        int r114 = r112;
        if (PointerId.equals-impl0(r30, r17.element) == true) goto L31;
        r112 = r114 + 1;
    L31:
        PointerInputChange r31 = (PointerInputChange) r113;
        if (r31 == null) goto L66;
        if (r31.isConsumed() == true) goto L66;
        if (PointerEventKt.changedToUpIgnoreConsumed(r31) == false) goto L50;
        List r32 = r29.getChanges();
        int r33 = r32.size();
        int r115 = 0;
    L40:
        if (r115 >= r33) goto L45;
        Object r34 = ListProtector.get(r32, r115);
        if (((PointerInputChange) r34).getPressed() == true) goto L46;
        r115 = r115 + 1;
    L46:
        PointerInputChange r35 = (PointerInputChange) r34;
        if (r35 == null) goto L66;
        r17.element = r35.getId-J3iCeTQ();
        r13 = r22;
        r3 = r28;
        r5 = r27;
        r14 = r26;
        r7 = 1;
        r8 = null;
        goto L20
    L45:
        r34 = null;
        goto L46
    L50:
        long r116 = r22.m716addPointerInputChangedBAh8RU(r31, r26);
        if ((SieveCacheKt.InvalidMapping & r116) == 9205357640488583168L) goto L53;
        boolean r36 = true;
    L54:
        if (r36 == false) goto L60;
        r16.invoke(r31, Boxing.boxFloat(Float.intBitsToFloat((int) (r116 >> 32))));
        if (r31.isConsumed() == true) goto L74;
        r22.reset();
        r13 = r22;
        r3 = r28;
        r5 = r27;
        r14 = r26;
        r7 = 1;
        r8 = null;
        goto L20
    L74:
        return r31;
    L60:
        PointerEventPass r37 = PointerEventPass.Final;
        r28.L$0 = r16;
        r28.L$1 = r15;
        r28.L$2 = r17;
        r28.L$3 = r22;
        r28.L$4 = r31;
        r28.F$0 = r26;
        r28.label = 2;
        if (r15.awaitPointerEvent(r37, r28) != r27) goto L63;
        return r27;
    L63:
        r13 = r22;
        r3 = r28;
        r5 = r27;
        r14 = r26;
        r10 = r17;
        r12 = r16;
        r1 = r31;
        goto L65
    L53:
        r36 = false;
        goto L54
    L30:
        r113 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r38 = r3.F$0;
        TouchSlopDetector r39 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r40 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r41 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r117 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r17 = r40;
        r27 = r5;
        r28 = r3;
        r22 = r39;
        r16 = r117;
        r26 = r38;
        r15 = r41;
        goto L24
    L16:
        ResultKt.throwOnFailure(r2);
        Orientation r42 = Orientation.Horizontal;
        long r43 = Offset.Companion.getZero-F1C5BW0();
        if (m568access$isPointerUpDmW0f2w(r20.getCurrentEvent(), r21) == true) goto L75;
        r14 = m587pointerSlopE8SPZFQ(r20.getViewConfiguration(), r23);
        r17 = new Ref.LongRef();
        r17.element = r21;
        r16 = r24;
        r13 = new TouchSlopDetector(r42, r43, null);
        r15 = r20;
        goto L20
    L75:
        return null;
    L7:
        r3 = new DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1(r25);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0185 -> B:64:0x018c). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final Object m580awaitVerticalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope r20, long r21, int r23, Function2<? super PointerInputChange, ? super Float, Unit> r24, Continuation<? super PointerInputChange> r25) {
        if ((r25 instanceof DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = (DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) r25;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 1;
        PointerEventPass r8 = null;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        float r0 = r3.F$0;
        PointerInputChange r1 = (PointerInputChange) r3.L$4;
        TouchSlopDetector r9 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r10 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r11 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r12 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        TouchSlopDetector r13 = r9;
        float r14 = r0;
        AwaitPointerEventScope r15 = r11;
    L65:
        if (r1.isConsumed() == false) goto L68;
    L66:
        return null;
    L68:
        Function2<? super PointerInputChange, ? super Float, Unit> r16 = r12;
        r7 = 1;
        r8 = null;
        Ref.LongRef r17 = r10;
    L20:
        r3.L$0 = r16;
        r3.L$1 = r15;
        r3.L$2 = r17;
        r3.L$3 = r13;
        r3.L$4 = r8;
        r3.F$0 = r14;
        r3.label = r7;
        Object r18 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r15, r8, r3, r7, r8);
        if (r18 != r5) goto L23;
        return r5;
    L23:
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r19 = r3;
        TouchSlopDetector r22 = r13;
        r2 = r18;
        float r26 = r14;
        Object r27 = r5;
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r28 = r19;
    L24:
        PointerEvent r29 = (PointerEvent) r2;
        List r110 = r29.getChanges();
        int r111 = r110.size();
        int r112 = 0;
    L25:
        if (r112 >= r111) goto L30;
        Object r113 = ListProtector.get(r110, r112);
        long r30 = ((PointerInputChange) r113).getId-J3iCeTQ();
        int r114 = r112;
        if (PointerId.equals-impl0(r30, r17.element) == true) goto L31;
        r112 = r114 + 1;
    L31:
        PointerInputChange r31 = (PointerInputChange) r113;
        if (r31 == null) goto L66;
        if (r31.isConsumed() == true) goto L66;
        if (PointerEventKt.changedToUpIgnoreConsumed(r31) == false) goto L50;
        List r32 = r29.getChanges();
        int r33 = r32.size();
        int r115 = 0;
    L40:
        if (r115 >= r33) goto L45;
        Object r34 = ListProtector.get(r32, r115);
        if (((PointerInputChange) r34).getPressed() == true) goto L46;
        r115 = r115 + 1;
    L46:
        PointerInputChange r35 = (PointerInputChange) r34;
        if (r35 == null) goto L66;
        r17.element = r35.getId-J3iCeTQ();
        r13 = r22;
        r3 = r28;
        r5 = r27;
        r14 = r26;
        r7 = 1;
        r8 = null;
        goto L20
    L45:
        r34 = null;
        goto L46
    L50:
        long r116 = r22.m716addPointerInputChangedBAh8RU(r31, r26);
        if ((SieveCacheKt.InvalidMapping & r116) == 9205357640488583168L) goto L53;
        boolean r36 = true;
    L54:
        if (r36 == false) goto L60;
        r16.invoke(r31, Boxing.boxFloat(Float.intBitsToFloat((int) (r116 & 4294967295L))));
        if (r31.isConsumed() == true) goto L74;
        r22.reset();
        r13 = r22;
        r3 = r28;
        r5 = r27;
        r14 = r26;
        r7 = 1;
        r8 = null;
        goto L20
    L74:
        return r31;
    L60:
        PointerEventPass r37 = PointerEventPass.Final;
        r28.L$0 = r16;
        r28.L$1 = r15;
        r28.L$2 = r17;
        r28.L$3 = r22;
        r28.L$4 = r31;
        r28.F$0 = r26;
        r28.label = 2;
        if (r15.awaitPointerEvent(r37, r28) != r27) goto L63;
        return r27;
    L63:
        r13 = r22;
        r3 = r28;
        r5 = r27;
        r14 = r26;
        r10 = r17;
        r12 = r16;
        r1 = r31;
        goto L65
    L53:
        r36 = false;
        goto L54
    L30:
        r113 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r38 = r3.F$0;
        TouchSlopDetector r39 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r40 = (Ref.LongRef) r3.L$2;
        AwaitPointerEventScope r41 = (AwaitPointerEventScope) r3.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r117 = (Function2) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r17 = r40;
        r27 = r5;
        r28 = r3;
        r22 = r39;
        r16 = r117;
        r26 = r38;
        r15 = r41;
        goto L24
    L16:
        ResultKt.throwOnFailure(r2);
        Orientation r42 = Orientation.Vertical;
        long r43 = Offset.Companion.getZero-F1C5BW0();
        if (m568access$isPointerUpDmW0f2w(r20.getCurrentEvent(), r21) == true) goto L75;
        r14 = m587pointerSlopE8SPZFQ(r20.getViewConfiguration(), r23);
        r17 = new Ref.LongRef();
        r17.element = r21;
        r16 = r24;
        r13 = new TouchSlopDetector(r42, r43, null);
        r15 = r20;
        goto L20
    L75:
        return null;
    L7:
        r3 = new DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(r25);
        goto L8
    }

    public static /* synthetic */ Object awaitAllPointersUpWithSlopDetection$default(AwaitPointerEventScope r0, PointerInputChange r1, PointerEventPass r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = PointerEventPass.Main;
    L6:
        return awaitAllPointersUpWithSlopDetection(r0, r1, r2, r3);
    }

    public static final Object detectDragGestures(PointerInputScope r8, final Function1<? super Offset, Unit> r9, final Function0<Unit> r10, Function0<Unit> r11, Function2<? super PointerInputChange, ? super Offset, Unit> r12, Continuation<? super Unit> r13) {
        Object r14 = detectDragGestures(r8, null, new n0(r9), new o0(r10), r11, new p0(), r12, r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope r7, Function1<? super Offset, Unit> r8, Function0<Unit> r9, Function0<Unit> r10, Function2<? super PointerInputChange, ? super Offset, Unit> r11, Continuation<? super Unit> r12) {
        Object r13 = ForEachGestureKt.awaitEachGesture(r7, new AnonymousClass5(r8, r9, r10, r11, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope r7, Function1<? super Offset, Unit> r8, Function0<Unit> r9, Function0<Unit> r10, Function2<? super PointerInputChange, ? super Float, Unit> r11, Continuation<? super Unit> r12) {
        Object r13 = ForEachGestureKt.awaitEachGesture(r7, new C01355(r8, r11, r9, r10, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object detectVerticalDragGestures(PointerInputScope r7, Function1<? super Offset, Unit> r8, Function0<Unit> r9, Function0<Unit> r10, Function2<? super PointerInputChange, ? super Float, Unit> r11, Continuation<? super Unit> r12) {
        Object r13 = ForEachGestureKt.awaitEachGesture(r7, new C01365(r8, r11, r9, r10, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008f -> B:23:0x0095). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: drag-VnAYq1g, reason: not valid java name */
    public static final Object m582dragVnAYq1g(AwaitPointerEventScope r19, long r20, Function1<? super PointerInputChange, Unit> r22, Orientation r23, Function1<? super PointerInputChange, Boolean> r24, Continuation<? super PointerInputChange> r25) {
        if ((r25 instanceof DragGestureDetectorKt$drag$2) == false) goto L7;
        DragGestureDetectorKt$drag$2 r1 = (DragGestureDetectorKt$drag$2) r25;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        PointerEventPass r5 = null;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Ref.LongRef r6 = (Ref.LongRef) r1.L$5;
        AwaitPointerEventScope r7 = (AwaitPointerEventScope) r1.L$4;
        Function1<? super PointerInputChange, Boolean> r8 = (Function1) r1.L$3;
        Orientation r9 = (Orientation) r1.L$2;
        Function1<? super PointerInputChange, Unit> r10 = (Function1) r1.L$1;
        AwaitPointerEventScope r11 = (AwaitPointerEventScope) r1.L$0;
        ResultKt.throwOnFailure(r0);
        DragGestureDetectorKt$drag$2 r12 = r1;
        Function1<? super PointerInputChange, Unit> r13 = r10;
        Object r14 = r3;
        Orientation r15 = r9;
        Ref.LongRef r16 = r6;
        Function1<? super PointerInputChange, Boolean> r17 = r8;
    L23:
        PointerEvent r18 = (PointerEvent) r0;
        List r110 = r18.getChanges();
        int r111 = r110.size();
        int r112 = 0;
    L24:
        if (r112 >= r111) goto L29;
        Object r113 = ListProtector.get(r110, r112);
        AwaitPointerEventScope r114 = r7;
        int r115 = r112;
        if (PointerId.equals-impl0(((PointerInputChange) r113).getId-J3iCeTQ(), r16.element) == true) goto L30;
        r112 = r115 + 1;
        r7 = r114;
    L30:
        PointerInputChange r116 = (PointerInputChange) r113;
        if (r116 != null) goto L34;
        r116 = null;
    L60:
        if (r116 != null) goto L64;
        return null;
    L64:
        if (((Boolean) r17.invoke(r116)).booleanValue() == false) goto L67;
        return null;
    L67:
        if (PointerEventKt.changedToUpIgnoreConsumed(r116) == false) goto L69;
        return r116;
    L69:
        r13.invoke(r116);
        long r21 = r116.getId-J3iCeTQ();
        r5 = null;
        AwaitPointerEventScope r26 = r11;
    L18:
        Ref.LongRef r117 = new Ref.LongRef();
        r117.element = r21;
        r7 = r26;
    L19:
        r12.L$0 = r26;
        r12.L$1 = r13;
        r12.L$2 = r15;
        r12.L$3 = r17;
        r12.L$4 = r7;
        r12.L$5 = r117;
        r12.label = 1;
        Object r27 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r7, r5, r12, 1, r5);
        if (r27 != r14) goto L22;
        return r14;
    L22:
        Ref.LongRef r118 = r117;
        r11 = r26;
        r0 = r27;
        r16 = r118;
        goto L23
    L34:
        if (PointerEventKt.changedToUpIgnoreConsumed(r116) == false) goto L47;
        List r28 = r18.getChanges();
        int r29 = r28.size();
        int r119 = 0;
    L36:
        if (r119 >= r29) goto L41;
        Object r30 = ListProtector.get(r28, r119);
        if (((PointerInputChange) r30).getPressed() == true) goto L42;
        r119 = r119 + 1;
    L42:
        PointerInputChange r31 = (PointerInputChange) r30;
        if (r31 == null) goto L60;
        r16.element = r31.getId-J3iCeTQ();
    L70:
        r7 = r114;
        r5 = null;
        r26 = r11;
        r117 = r16;
        goto L19
    L41:
        r30 = null;
        goto L42
    L47:
        long r32 = PointerEventKt.positionChangeIgnoreConsumed(r116);
        if (r15 != null) goto L51;
        float r33 = Offset.getDistance-impl(r32);
    L55:
        if (r33 != MenuKt.ClosedAlphaTarget) goto L57;
        boolean r120 = true;
    L59:
        if ((!r120) == false) goto L70;
    L57:
        r120 = false;
        goto L59
    L51:
        if (r15 != Orientation.Vertical) goto L53;
        r33 = Float.intBitsToFloat((int) (r32 & 4294967295L));
        goto L55
    L53:
        r33 = Float.intBitsToFloat((int) (r32 >> 32));
        goto L55
    L29:
        r114 = r7;
        r113 = null;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r21 = r20;
        if (m568access$isPointerUpDmW0f2w(r19.getCurrentEvent(), r21) == false) goto L17;
        return null;
    L17:
        r26 = r19;
        r17 = r24;
        r12 = r1;
        r14 = r3;
        r13 = r22;
        r15 = r23;
    L7:
        r1 = new DragGestureDetectorKt$drag$2(r25);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m583dragVnAYq1g$$forInline(AwaitPointerEventScope r16, long r17, Function1<? super PointerInputChange, Unit> r19, Orientation r20, Function1<? super PointerInputChange, Boolean> r21, Continuation<? super PointerInputChange> r22) {
        long r2 = r17;
        if (m568access$isPointerUpDmW0f2w(r16.getCurrentEvent(), r2) == false) goto L5;
        return null;
    L5:
        Ref.LongRef r1 = new Ref.LongRef();
        r1.element = r2;
    L6:
        int r3 = 0;
        InlineMarker.mark(0);
        Object r7 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r16, null, r22, 1, null);
        InlineMarker.mark(1);
        PointerEvent r8 = (PointerEvent) r7;
        List r9 = r8.getChanges();
        int r10 = r9.size();
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L12;
        Object r12 = ListProtector.get(r9, r11);
        if (Boolean.valueOf(PointerId.equals-impl0(((PointerInputChange) r12).getId-J3iCeTQ(), r1.element)).booleanValue() == true) goto L13;
        r11 = r11 + 1;
    L13:
        PointerInputChange r13 = (PointerInputChange) r12;
        if (r13 == null) goto L41;
        if (PointerEventKt.changedToUpIgnoreConsumed(r13) == true) goto L17;
        long r14 = PointerEventKt.positionChangeIgnoreConsumed(r13);
        if (r20 != null) goto L32;
        float r15 = Offset.getDistance-impl(r14);
    L36:
        if (r15 != MenuKt.ClosedAlphaTarget) goto L39;
        r3 = 1;
    L39:
        if (Boolean.valueOf(r3 ^ 1).booleanValue() == false) goto L6;
    L42:
        if (r13 == null) goto L50;
        if (((Boolean) r21.invoke(r13)).booleanValue() == true) goto L45;
        if (PointerEventKt.changedToUpIgnoreConsumed(r13) == true) goto L48;
        r19.invoke(r13);
        r2 = r13.getId-J3iCeTQ();
        goto L5
    L48:
        return r13;
    L45:
        return null;
    L50:
        return null;
    L32:
        if (r20 != Orientation.Vertical) goto L34;
        r15 = Float.intBitsToFloat((int) (r14 & 4294967295L));
        goto L36
    L34:
        r15 = Float.intBitsToFloat((int) (r14 >> 32));
        goto L36
    L17:
        List r4 = r8.getChanges();
        int r18 = r4.size();
    L18:
        if (r3 >= r18) goto L23;
        Object r23 = ListProtector.get(r4, r3);
        if (Boolean.valueOf(((PointerInputChange) r23).getPressed()).booleanValue() == true) goto L24;
        r3 = r3 + 1;
    L24:
        PointerInputChange r24 = (PointerInputChange) r23;
        if (r24 == null) goto L42;
        r1.element = r24.getId-J3iCeTQ();
        goto L6
    L23:
        r23 = null;
        goto L24
    L41:
        r13 = null;
        goto L42
    L12:
        r12 = null;
        goto L13
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0185 -> B:65:0x018c). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w, reason: not valid java name */
    public static final Object m575awaitPointerSlopOrCancellation6ksA65w(AwaitPointerEventScope r18, long r19, int r21, Orientation r22, long r23, Function2<? super PointerInputChange, ? super Offset, Unit> r25, Continuation<? super PointerInputChange> r26) {
        if ((r26 instanceof DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) == false) goto L7;
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r3 = (DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) r26;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 1;
        PointerEventPass r8 = null;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        float r0 = r3.F$0;
        PointerInputChange r1 = (PointerInputChange) r3.L$4;
        TouchSlopDetector r9 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r10 = (Ref.LongRef) r3.L$2;
        Function2<? super PointerInputChange, ? super Offset, Unit> r11 = (Function2) r3.L$1;
        AwaitPointerEventScope r12 = (AwaitPointerEventScope) r3.L$0;
        ResultKt.throwOnFailure(r2);
        TouchSlopDetector r13 = r9;
        Object r14 = r5;
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r15 = r3;
        float r16 = r0;
        AwaitPointerEventScope r17 = r12;
    L66:
        if (r1.isConsumed() == false) goto L69;
        return null;
    L69:
        Function2<? super PointerInputChange, ? super Offset, Unit> r20 = r11;
        r7 = 1;
        r8 = null;
    L20:
        r15.L$0 = r17;
        r15.L$1 = r20;
        r15.L$2 = r10;
        r15.L$3 = r13;
        r15.L$4 = r8;
        r15.F$0 = r16;
        r15.label = r7;
        Object r110 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r17, r8, r15, r7, r8);
        if (r110 != r14) goto L23;
        return r14;
    L23:
        float r111 = r16;
        TouchSlopDetector r24 = r13;
        r2 = r110;
        Ref.LongRef r112 = r10;
        Object r27 = r14;
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r28 = r15;
        float r29 = r111;
    L24:
        PointerEvent r30 = (PointerEvent) r2;
        List r113 = r30.getChanges();
        int r114 = r113.size();
        int r115 = 0;
        int r116 = 0;
    L25:
        if (r116 >= r114) goto L30;
        Object r117 = ListProtector.get(r113, r116);
        Object r118 = r27;
        if (PointerId.equals-impl0(((PointerInputChange) r117).getId-J3iCeTQ(), r112.element) == true) goto L31;
        r116 = r116 + 1;
        r27 = r118;
    L31:
        PointerInputChange r31 = (PointerInputChange) r117;
        if (r31 != null) goto L36;
        return null;
    L36:
        if (r31.isConsumed() == false) goto L39;
        return null;
    L39:
        if (PointerEventKt.changedToUpIgnoreConsumed(r31) == false) goto L52;
        List r32 = r30.getChanges();
        int r33 = r32.size();
    L41:
        if (r115 >= r33) goto L46;
        Object r34 = ListProtector.get(r32, r115);
        if (((PointerInputChange) r34).getPressed() == true) goto L47;
        r115 = r115 + 1;
    L47:
        PointerInputChange r35 = (PointerInputChange) r34;
        if (r35 != null) goto L51;
        return null;
    L51:
        r112.element = r35.getId-J3iCeTQ();
        r13 = r24;
        r16 = r29;
        r15 = r28;
        r10 = r112;
        r7 = 1;
        r8 = null;
        r14 = r118;
        goto L20
    L46:
        r34 = null;
        goto L47
    L52:
        long r36 = r24.m716addPointerInputChangedBAh8RU(r31, r29);
        if ((SieveCacheKt.InvalidMapping & r36) == 9205357640488583168L) goto L55;
        r115 = 1;
    L55:
        if (r115 == 0) goto L61;
        r20.invoke(r31, Offset.box-impl(r36));
        if (r31.isConsumed() == false) goto L59;
        return r31;
    L59:
        r24.reset();
        r13 = r24;
        r16 = r29;
        r15 = r28;
        r10 = r112;
        r7 = 1;
        r8 = null;
        r14 = r118;
        goto L20
    L61:
        PointerEventPass r37 = PointerEventPass.Final;
        r28.L$0 = r17;
        r28.L$1 = r20;
        r28.L$2 = r112;
        r28.L$3 = r24;
        r28.L$4 = r31;
        r28.F$0 = r29;
        r28.label = 2;
        Object r38 = r118;
        if (r17.awaitPointerEvent(r37, r28) != r38) goto L64;
        return r38;
    L64:
        r13 = r24;
        r16 = r29;
        r15 = r28;
        r14 = r38;
        r10 = r112;
        r11 = r20;
        r1 = r31;
        goto L66
    L30:
        r118 = r27;
        r117 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r39 = r3.F$0;
        TouchSlopDetector r40 = (TouchSlopDetector) r3.L$3;
        Ref.LongRef r41 = (Ref.LongRef) r3.L$2;
        Function2<? super PointerInputChange, ? super Offset, Unit> r42 = (Function2) r3.L$1;
        AwaitPointerEventScope r119 = (AwaitPointerEventScope) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r29 = r39;
        r17 = r119;
        r112 = r41;
        r28 = r3;
        r24 = r40;
        r20 = r42;
        r27 = r5;
        goto L24
    L16:
        ResultKt.throwOnFailure(r2);
        if (m568access$isPointerUpDmW0f2w(r18.getCurrentEvent(), r19) == false) goto L19;
        return null;
    L19:
        float r43 = m587pointerSlopE8SPZFQ(r18.getViewConfiguration(), r21);
        Ref.LongRef r44 = new Ref.LongRef();
        r44.element = r19;
        r20 = r25;
        r10 = r44;
        r14 = r5;
        r15 = r3;
        r16 = r43;
        r13 = new TouchSlopDetector(r22, r23, null);
        r17 = r18;
    L7:
        r3 = new DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(r26);
        goto L8
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w$$forInline, reason: not valid java name */
    private static final Object m576awaitPointerSlopOrCancellation6ksA65w$$forInline(AwaitPointerEventScope r15, long r16, int r18, Orientation r19, long r20, Function2<? super PointerInputChange, ? super Offset, Unit> r22, Continuation<? super PointerInputChange> r23) {
        Continuation<? super PointerInputChange> r3 = r23;
        if (m568access$isPointerUpDmW0f2w(r15.getCurrentEvent(), r16) == false) goto L5;
        return null;
    L5:
        float r4 = m587pointerSlopE8SPZFQ(r15.getViewConfiguration(), r18);
        Ref.LongRef r6 = new Ref.LongRef();
        r6.element = r16;
        TouchSlopDetector r1 = new TouchSlopDetector(r19, r20, null);
    L6:
        InlineMarker.mark(0);
        Object r8 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r15, null, r3, 1, null);
        InlineMarker.mark(1);
        PointerEvent r9 = (PointerEvent) r8;
        List r10 = r9.getChanges();
        int r11 = r10.size();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L12;
        Object r13 = ListProtector.get(r10, r12);
        if (Boolean.valueOf(PointerId.equals-impl0(((PointerInputChange) r13).getId-J3iCeTQ(), r6.element)).booleanValue() == true) goto L13;
        r12 = r12 + 1;
    L13:
        PointerInputChange r14 = (PointerInputChange) r13;
        if (r14 == null) goto L45;
        if (r14.isConsumed() == true) goto L17;
        if (PointerEventKt.changedToUpIgnoreConsumed(r14) == false) goto L32;
        List r2 = r9.getChanges();
        int r5 = r2.size();
        int r7 = 0;
    L21:
        if (r7 >= r5) goto L26;
        Object r17 = ListProtector.get(r2, r7);
        if (Boolean.valueOf(((PointerInputChange) r17).getPressed()).booleanValue() == true) goto L27;
        r7 = r7 + 1;
    L27:
        PointerInputChange r21 = (PointerInputChange) r17;
        if (r21 == null) goto L29;
        r6.element = r21.getId-J3iCeTQ();
    L31:
        Continuation<? super PointerInputChange> r24 = r23;
    L44:
        r3 = r24;
        goto L6
    L29:
        return null;
    L26:
        r17 = null;
        goto L27
    L32:
        long r25 = r1.m716addPointerInputChangedBAh8RU(r14, r4);
        if ((SieveCacheKt.InvalidMapping & r25) == 9205357640488583168L) goto L35;
        boolean r26 = true;
    L36:
        if (r26 == false) goto L41;
        r22.invoke(r14, Offset.box-impl(r25));
        if (r14.isConsumed() == true) goto L39;
        r1.reset();
        goto L31
    L39:
        return r14;
    L41:
        PointerEventPass r27 = PointerEventPass.Final;
        InlineMarker.mark(0);
        r24 = r23;
        r15.awaitPointerEvent(r27, r24);
        InlineMarker.mark(1);
        if (r14.isConsumed() == false) goto L44;
        return null;
    L35:
        r26 = false;
        goto L36
    L17:
        return null;
    L45:
        return null;
    L12:
        r13 = null;
        goto L13
    }

    public static final Object detectDragGestures(PointerInputScope r10, Orientation r11, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> r12, Function1<? super PointerInputChange, Unit> r13, Function0<Unit> r14, Function0<Boolean> r15, Function2<? super PointerInputChange, ? super Offset, Unit> r16, Continuation<? super Unit> r17) {
        Object r0 = ForEachGestureKt.awaitEachGesture(r10, new AnonymousClass13(r15, new Ref.LongRef(), r11, r12, r16, r14, r13, null), r17);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope r6, Function1 r7, Function0 r8, Function0 r9, Function2 r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = new k0();
    L5:
        Function1 r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = new l0();
    L8:
        Function0 r2 = r8;
        if ((r12 & 4) == 0) goto L12;
        r9 = new m0();
    L12:
        return detectDragGestures(r6, r1, r2, r9, r10, r11);
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope r6, Function1 r7, Function0 r8, Function0 r9, Function2 r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = new g0();
    L5:
        Function1 r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = new q0();
    L8:
        Function0 r2 = r8;
        if ((r12 & 4) == 0) goto L12;
        r9 = new r0();
    L12:
        return detectDragGesturesAfterLongPress(r6, r1, r2, r9, r10, r11);
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope r6, Function1 r7, Function0 r8, Function0 r9, Function2 r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = new v0();
    L5:
        Function1 r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = new w0();
    L8:
        Function0 r2 = r8;
        if ((r12 & 4) == 0) goto L12;
        r9 = new x0();
    L12:
        return detectHorizontalDragGestures(r6, r1, r2, r9, r10, r11);
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope r6, Function1 r7, Function0 r8, Function0 r9, Function2 r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = new s0();
    L5:
        Function1 r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = new t0();
    L8:
        Function0 r2 = r8;
        if ((r12 & 4) == 0) goto L12;
        r9 = new u0();
    L12:
        return detectVerticalDragGestures(r6, r1, r2, r9, r10, r11);
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w$default, reason: not valid java name */
    public static /* synthetic */ Object m577awaitPointerSlopOrCancellation6ksA65w$default(AwaitPointerEventScope r17, long r18, int r20, Orientation r21, long r22, Function2 r24, Continuation r25, int r26, Object r27) {
        if ((r26 & 8) == 0) goto L5;
        long r2 = Offset.Companion.getZero-F1C5BW0();
    L6:
        long r5 = r18;
        if (m568access$isPointerUpDmW0f2w(r17.getCurrentEvent(), r5) == false) goto L9;
        return null;
    L9:
        float r4 = m587pointerSlopE8SPZFQ(r17.getViewConfiguration(), r20);
        TouchSlopDetector r8 = new TouchSlopDetector(r21, r2, null);
    L10:
        int r3 = 0;
        InlineMarker.mark(0);
        Object r9 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r17, null, r25, 1, null);
        InlineMarker.mark(1);
        PointerEvent r10 = (PointerEvent) r9;
        List r11 = r10.getChanges();
        int r12 = r11.size();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L16;
        Object r14 = ListProtector.get(r11, r13);
        if (PointerId.equals-impl0(((PointerInputChange) r14).getId-J3iCeTQ(), r5) == true) goto L17;
        r13 = r13 + 1;
    L17:
        PointerInputChange r15 = (PointerInputChange) r14;
        if (r15 == null) goto L46;
        if (r15.isConsumed() == true) goto L21;
        if (PointerEventKt.changedToUpIgnoreConsumed(r15) == true) goto L24;
        long r16 = r8.m716addPointerInputChangedBAh8RU(r15, r4);
        if ((SieveCacheKt.InvalidMapping & r16) == 9205357640488583168L) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == true) goto L40;
        PointerEventPass r110 = PointerEventPass.Final;
        InlineMarker.mark(0);
        r17.awaitPointerEvent(r110, r25);
        InlineMarker.mark(1);
        if (r15.isConsumed() == false) goto L10;
    L40:
        r24.invoke(r15, Offset.box-impl(r16));
        if (r15.isConsumed() == true) goto L42;
        r8.reset();
        goto L10
    L42:
        return r15;
    L38:
        r19 = false;
        goto L39
    L24:
        List r6 = r10.getChanges();
        int r7 = r6.size();
    L25:
        if (r3 >= r7) goto L30;
        Object r23 = ListProtector.get(r6, r3);
        if (((PointerInputChange) r23).getPressed() == true) goto L31;
        r3 = r3 + 1;
    L31:
        PointerInputChange r28 = (PointerInputChange) r23;
        if (r28 == null) goto L33;
        r5 = r28.getId-J3iCeTQ();
        goto L10
    L33:
        return null;
    L30:
        r23 = null;
        goto L31
    L21:
        return null;
    L46:
        return null;
    L16:
        r14 = null;
        goto L17
    L5:
        r2 = r22;
        goto L6
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope r9, Orientation r10, Function3 r11, Function1 r12, Function0 r13, Function0 r14, Function2 r15, Continuation r16, int r17, Object r18) {
        if ((r17 & 2) == 0) goto L5;
        Function3 r3 = new y0();
    L7:
        if ((r17 & 4) == 0) goto L9;
        Function1 r4 = new h0();
    L11:
        if ((r17 & 8) == 0) goto L13;
        Function0 r5 = new i0();
    L15:
        if ((r17 & 16) == 0) goto L17;
        Function0 r6 = new j0();
    L19:
        return detectDragGestures(r9, r10, r3, r4, r5, r6, r15, r16);
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }
}
