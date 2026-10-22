package androidx.compose.foundation.text.input.internal.selection;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__DistinctKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001:\u0006Ç\u0001È\u0001É\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\tH\u0000¢\u0006\u0002\bmJ\b\u0010n\u001a\u00020\tH\u0002J\u0006\u0010o\u001a\u00020pJ>\u0010q\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010r\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u0012\u0010s\u001a\u00020)*\u00020tH\u0086@¢\u0006\u0002\u0010uJ\u001a\u0010v\u001a\u00020)*\u00020t2\u0006\u0010w\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010xJ\u000e\u0010y\u001a\u00020)H\u0086@¢\u0006\u0002\u0010zJ\u000e\u0010{\u001a\u00020)2\u0006\u0010T\u001a\u00020SJ\u0006\u0010|\u001a\u00020)J\u0012\u0010}\u001a\u00020)*\u00020tH\u0086@¢\u0006\u0002\u0010uJ<\u0010~\u001a\u00020)*\u00020t2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020)0(2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020)0(H\u0086@¢\u0006\u0003\u0010\u0083\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u000202H\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0013\u0010\u0088\u0001\u001a\u00020)*\u00020tH\u0082@¢\u0006\u0002\u0010uJ#\u0010\u0089\u0001\u001a\u00020)*\u00020t2\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020)0(H\u0086@¢\u0006\u0003\u0010\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020)J\u001b\u0010\u008c\u0001\u001a\u00020)*\u00020t2\u0006\u0010w\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010xJ\u000f\u0010\u008d\u0001\u001a\u00020)H\u0082@¢\u0006\u0002\u0010zJ\u000f\u0010\u008e\u0001\u001a\u00020)H\u0082@¢\u0006\u0002\u0010zJ\t\u0010\u0094\u0001\u001a\u00020pH\u0002J\u001f\u0010\u0095\u0001\u001a\u00020k2\u0006\u0010w\u001a\u00020\t2\u0006\u0010l\u001a\u00020\tH\u0000¢\u0006\u0003\b\u0096\u0001J\u001a\u0010\u0097\u0001\u001a\u0002022\u0006\u0010w\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\"\u0010\u009a\u0001\u001a\u00020)2\u0007\u0010\u009b\u0001\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u000202¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\t\u0010\u009f\u0001\u001a\u00020)H\u0002J\u0007\u0010 \u0001\u001a\u00020)J\u0007\u0010¡\u0001\u001a\u00020\tJ\u000f\u0010¢\u0001\u001a\u00020)H\u0086@¢\u0006\u0002\u0010zJ\u0007\u0010£\u0001\u001a\u00020\tJ\u001b\u0010¤\u0001\u001a\u00020)2\t\b\u0002\u0010¥\u0001\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010¦\u0001J\u000f\u0010©\u0001\u001a\u00020)H\u0086@¢\u0006\u0002\u0010zJ\u0007\u0010ª\u0001\u001a\u00020\tJ\u000f\u0010«\u0001\u001a\u00020)H\u0086@¢\u0006\u0002\u0010zJ\u000f\u0010¬\u0001\u001a\u00020)H\u0082@¢\u0006\u0002\u0010zJ\u0007\u0010\u00ad\u0001\u001a\u00020\tJ\u0007\u0010®\u0001\u001a\u00020)J\u0007\u0010¯\u0001\u001a\u00020\tJ\u0007\u0010°\u0001\u001a\u00020)J\u0018\u0010r\u001a\u00020)2\u0007\u0010±\u0001\u001a\u00020pH\u0082@¢\u0006\u0003\u0010²\u0001J\u0007\u0010³\u0001\u001a\u00020)J\t\u0010´\u0001\u001a\u00020)H\u0002JW\u0010µ\u0001\u001a\u00030¶\u00012\b\u0010·\u0001\u001a\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020g2\u0007\u0010º\u0001\u001a\u00020g2\u0006\u0010w\u001a\u00020\t2\b\u0010»\u0001\u001a\u00030¼\u00012\t\b\u0002\u0010½\u0001\u001a\u00020\t2\t\b\u0002\u0010¾\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b¿\u0001\u0010À\u0001JC\u0010Á\u0001\u001a\u00030¶\u00012\u0007\u0010Â\u0001\u001a\u00020g2\u0007\u0010Ã\u0001\u001a\u00020g2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010¶\u00012\u0006\u0010w\u001a\u00020\t2\b\u0010»\u0001\u001a\u00030¼\u0001H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R+\u00103\u001a\u0002022\u0006\u0010\"\u001a\u0002028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010&\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u00109\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u00105R+\u0010;\u001a\u0002022\u0006\u0010\"\u001a\u0002028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010&\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u0011\u0010?\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b@\u00105R/\u0010B\u001a\u0004\u0018\u00010A2\b\u0010\"\u001a\u0004\u0018\u00010A8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010&\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR+\u0010I\u001a\u00020H2\u0006\u0010\"\u001a\u00020H8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010&\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR+\u0010O\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010&\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010\u001bR+\u0010T\u001a\u00020S2\u0006\u0010\"\u001a\u00020S8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010&\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR+\u0010Z\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010&\u001a\u0004\b[\u0010\u0019\"\u0004\b\\\u0010\u001bR\u0016\u0010^\u001a\u0004\u0018\u00010_8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\u0019R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008f\u0001\u001a\u0004\u0018\u00010p8@X\u0080\u0084\u0002¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0010\u0010§\u0001\u001a\u00030¨\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ê\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZLandroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;Landroidx/compose/ui/platform/Clipboard;)V", "getTextFieldState$foundation_release", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "()Z", "setFocused", "(Z)V", "getPlatformSelectionBehaviors$foundation_release", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "textToolbarHandler", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "<set-?>", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "Landroidx/compose/runtime/MutableState;", "requestAutofillAction", "Lkotlin/Function0;", "", "getRequestAutofillAction", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction", "(Lkotlin/jvm/functions/Function0;)V", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "setReceiveContentConfiguration", "Landroidx/compose/ui/geometry/Offset;", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "()J", "setStartTextLayoutPositionInWindow-k-4lQ0M", "(J)V", "startTextLayoutPositionInWindow$delegate", "currentTextLayoutPositionInWindow", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "rawHandleDragPosition$delegate", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "textToolbarShown", "getTextToolbarShown", "setTextToolbarShown$foundation_release", "textToolbarShown$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "editable", "getEditable$foundation_release", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "previousRawDragOffset", "", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation_release", "isCursorHandleInVisibleBounds", "getCursorRect", "Landroidx/compose/ui/geometry/Rect;", "update", "showTextToolbar", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionHandleGestures", "isStartHandle", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startToolbarAndHandlesVisibilityObserver", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTextToolbarState", "dispose", "detectTouchMode", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeCursorAtNearestOffset", "offset", "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "detectCursorHandleDragGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "maybeSuggestSelectionRange", "detectSelectionHandleDragGestures", "observeTextChanges", "observeTextToolbarVisibility", "derivedVisibleContentBounds", "getDerivedVisibleContentBounds$foundation_release", "()Landroidx/compose/ui/geometry/Rect;", "derivedVisibleContentBounds$delegate", "Landroidx/compose/runtime/State;", "getContentRect", "getSelectionHandleState", "getSelectionHandleState$foundation_release", "getHandlePosition", "getHandlePosition-tuRUvjQ", "(Z)J", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "markStartContentVisibleOffset", "clearHandleDragging", "canCut", "cut", "canCopy", "copy", "cancelSelection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clipboardPasteState", "Landroidx/compose/foundation/text/input/internal/selection/ClipboardPasteState;", "updateClipboardEntry", "canPaste", "paste", "pasteAsPlainText", "canSelectAll", "selectAll", "canAutofill", "autofill", "contentRect", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deselect", "hideTextToolbar", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "textFieldCharSequence", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "startOffset", "endOffset", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "allowPreviousSelectionCollapsed", "isStartOfSelection", "updateSelection-SsL-Rf8", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "getTextFieldSelection", "rawStartOffset", "rawEndOffset", "previousSelection", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private ClipboardPasteState clipboardPasteState;
    private final CoroutineScope coroutineScope;
    private Density density;
    private final State derivedVisibleContentBounds$delegate;
    private final MutableState directDragGestureInitiator$delegate;
    private final MutableState draggingHandle$delegate;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private final MutableState isInTouchMode$delegate;
    private boolean isPassword;
    private final PlatformSelectionBehaviors platformSelectionBehaviors;
    private PressInteraction.Press pressInteraction;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private final MutableState rawHandleDragPosition$delegate;
    private boolean readOnly;
    private Function0<? extends ReceiveContentConfiguration> receiveContentConfiguration;
    private Function0<Unit> requestAutofillAction;
    private final MutableState showCursorHandle$delegate;
    private final MutableState startTextLayoutPositionInWindow$delegate;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbarHandler textToolbarHandler;
    private final MutableState textToolbarShown$delegate;
    private final MutableState textToolbarState$delegate;
    private final ToolbarRequester toolbarRequester;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum InputType extends Enum<InputType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ InputType[] $VALUES = null;
        public static final InputType Mouse = null;
        public static final InputType None = null;
        public static final InputType Touch = null;

        private static final /* synthetic */ InputType[] $values() {
            return new InputType[]{None, Touch, Mouse};
        }

        public static EnumEntries<InputType> getEntries() {
            return $ENTRIES;
        }

        static {
            None = new InputType("None", 0);
            Touch = new InputType("Touch", 1);
            Mouse = new InputType("Mouse", 2);
            InputType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static InputType[] values() {
            return (InputType[]) $VALUES.clone();
        }

        public static InputType valueOf(String r1) {
            return (InputType) r27.a.a(InputType.class, r1);
        }

        private InputType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0016J\u0017\u0010!\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010#R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "isDoubleOrTripleClickOnly", "", "onStart", "downPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "clickCount", "onStart-9KIMszo", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;I)Z", "onDrag", "dragPosition", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isStartOfSelection", "updateSelection-12glfjA", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/ui/text/TextLayoutResult;Z)J", "onDragDone", "onExtend", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText;
        private long dragBeginPosition;
        private boolean isDoubleOrTripleClickOnly;
        private final Function0<Unit> requestFocus;
        final /* synthetic */ TextFieldSelectionState this$0;

        public static /* synthetic */ String a(long r0) {
            return onDrag_3MmeM6k$lambda$1(r0);
        }

        public static /* synthetic */ String b() {
            return onExtend_k_4lQ0M$lambda$3();
        }

        public static /* synthetic */ String c() {
            return onDragDone$lambda$2();
        }

        public static /* synthetic */ String d() {
            return onStart_9KIMszo$lambda$0();
        }

        public static /* synthetic */ String e() {
            return onExtendDrag_k_4lQ0M$lambda$4();
        }

        private static final String onDragDone$lambda$2() {
            return "Mouse.onDragDone";
        }

        private static final String onExtendDrag_k_4lQ0M$lambda$4() {
            return "Mouse.onExtendDrag";
        }

        private static final String onExtend_k_4lQ0M$lambda$3() {
            return "Mouse.onExtend";
        }

        private static final String onStart_9KIMszo$lambda$0() {
            return "Mouse.onStart";
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void onDragDone() {
            TextFieldSelectionStateKt.access$logDebug(new u());
            this.this$0.setDirectDragGestureInitiator(InputType.None);
            if (this.isDoubleOrTripleClickOnly == false) goto L6;
            this.this$0.maybeSuggestSelectionRange();
            return;
        }

        private static final String onDrag_3MmeM6k$lambda$1(long r2) {
            return "Mouse.onDrag " + Offset.toString-impl(r2);
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onExtend-k-4lQ0M, reason: not valid java name */
        public boolean mo1727onExtendk4lQ0M(long r1) {
            TextFieldSelectionStateKt.access$logDebug(new w());
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
        public boolean mo1728onExtendDragk4lQ0M(long r1) {
            TextFieldSelectionStateKt.access$logDebug(new s());
            return true;
        }

        public TextFieldMouseSelectionObserver(TextFieldSelectionState r1, Function0<Unit> r2) {
            this.this$0 = r1;
            this.requestFocus = r2;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = Offset.Companion.getUnspecified-F1C5BW0();
            this.isDoubleOrTripleClickOnly = true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onDrag-3MmeM6k, reason: not valid java name */
        public boolean mo1726onDrag3MmeM6k(final long r12, SelectionAdjustment r14) {
            TextLayoutResult r5 = TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).getLayoutResult();
            if (TextFieldSelectionState.access$getEnabled$p(this.this$0) == false) goto L15;
            if (r5 == null) goto L15;
            if (this.this$0.getTextFieldState$foundation_release().getVisualText().length() != 0) goto L8;
            boolean r0 = true;
        L9:
            if (r0 == true) goto L15;
            TextFieldSelectionStateKt.access$logDebug(new t(r12));
            if (TextRange.equals-impl0(this.this$0.getTextFieldState$foundation_release().getVisualText().m1535getSelectiond9O1mEE(), m1725updateSelection12glfjA(r12, r14, r5, false)) == true) goto L14;
            this.isDoubleOrTripleClickOnly = false;
        L14:
            return true;
        L8:
            r0 = false;
        L15:
            return false;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onStart-9KIMszo, reason: not valid java name */
        public boolean mo1729onStart9KIMszo(long r9, SelectionAdjustment r11, int r12) {
            TextLayoutResult r5 = TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).getLayoutResult();
            boolean r1 = false;
            if (TextFieldSelectionState.access$getEnabled$p(this.this$0) == false) goto L16;
            if (r5 == null) goto L16;
            if (this.this$0.getTextFieldState$foundation_release().getVisualText().length() != 0) goto L8;
            boolean r0 = true;
        L9:
            if (r0 == true) goto L16;
            if (r12 < 2) goto L14;
            r1 = true;
        L14:
            this.isDoubleOrTripleClickOnly = r1;
            TextFieldSelectionStateKt.access$logDebug(new v());
            this.this$0.setDirectDragGestureInitiator(InputType.Mouse);
            this.requestFocus.invoke();
            TextFieldSelectionState.access$setPreviousRawDragOffset$p(this.this$0, -1);
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = r9;
            this.dragBeginOffsetInText = TextRange.getStart-impl(m1725updateSelection12glfjA(r9, r11, r5, true));
            return true;
        L8:
            r0 = false;
        L16:
            return false;
        }

        /* JADX INFO: renamed from: updateSelection-12glfjA, reason: not valid java name */
        private final long m1725updateSelection12glfjA(long r11, SelectionAdjustment r13, TextLayoutResult r14, boolean r15) {
            int r16 = r14.getLayoutInput().getText().length();
            int r0 = this.dragBeginOffsetInText;
            if (r0 < 0) goto L6;
            if (r0 > r16) goto L6;
        L7:
            int r5 = TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).m1662getOffsetForPosition3MmeM6k(r11, false);
            TextFieldSelectionState r2 = this.this$0;
            TextFieldCharSequence r3 = r2.getTextFieldState$foundation_release().getVisualText();
            long r12 = TextFieldSelectionState.m1712access$updateSelectionSsLRf8(r2, r3, r0, r5, false, r13, false, r15);
            if (this.dragBeginOffsetInText != (-1)) goto L13;
            if (TextRange.getCollapsed-impl(r12) == true) goto L13;
            this.dragBeginOffsetInText = TextRange.getStart-impl(r12);
        L13:
            if (TextRange.getReversed-impl(r12) == false) goto L15;
            r12 = TextFieldSelectionStateKt.m1731access$reverse5zctL8(r12);
        L15:
            this.this$0.getTextFieldState$foundation_release().m1679selectCharsIn5zctL8(r12);
            this.this$0.updateTextToolbarState(TextToolbarState.Selection);
            return r12;
        L6:
            r0 = TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).m1662getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            goto L7
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "isLongPressSelectionOnly", "", "onDragStop", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onUp", "onStop", "onCancel", "onStart", "startPoint", "onStart-k-4lQ0M", "onDrag", "delta", "onDrag-k-4lQ0M", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class TextFieldTextDragObserver implements TextDragObserver {
        private Handle actingHandle;
        private int dragBeginOffsetInText;
        private long dragBeginPosition;
        private long dragTotalDistance;
        private boolean isLongPressSelectionOnly;
        private final Function0<Unit> requestFocus;
        final /* synthetic */ TextFieldSelectionState this$0;

        public static /* synthetic */ String a(long r0) {
            return onStart_k_4lQ0M$lambda$1(r0);
        }

        public static /* synthetic */ String b() {
            return onDragStop$lambda$0();
        }

        public static /* synthetic */ String c(long r0) {
            return onDrag_k_4lQ0M$lambda$2(r0);
        }

        private static final String onDragStop$lambda$0() {
            return "Touch.onDragStop";
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onDown-k-4lQ0M */
        public void mo1449onDownk4lQ0M(long r1) {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onUp() {
        }

        private final void onDragStop() {
            if ((this.dragBeginPosition & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L11;
            TextFieldSelectionStateKt.access$logDebug(new z());
            this.this$0.clearHandleDragging();
            this.dragBeginOffsetInText = -1;
            Offset.Companion r1 = Offset.Companion;
            this.dragBeginPosition = r1.getUnspecified-F1C5BW0();
            this.dragTotalDistance = r1.getZero-F1C5BW0();
            TextFieldSelectionState.access$setPreviousRawDragOffset$p(this.this$0, -1);
            this.this$0.setDirectDragGestureInitiator(InputType.None);
            this.requestFocus.invoke();
            if (this.isLongPressSelectionOnly == false) goto L12;
            this.this$0.maybeSuggestSelectionRange();
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onCancel() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStop() {
            onDragStop();
        }

        private static final String onDrag_k_4lQ0M$lambda$2(long r2) {
            return "Touch.onDrag at " + Offset.toString-impl(r2);
        }

        private static final String onStart_k_4lQ0M$lambda$1(long r2) {
            return "Touch.onDragStart after longPress at " + Offset.toString-impl(r2);
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onDrag-k-4lQ0M */
        public void mo1450onDragk4lQ0M(long r20) {
            if (TextFieldSelectionState.access$getEnabled$p(this.this$0) == true) goto L5;
            return;
        L5:
            if (TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).getLayoutResult() == null) goto L69;
            boolean r2 = true;
            if (this.this$0.getTextFieldState$foundation_release().getVisualText().length() != 0) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == true) goto L70;
            long r4 = Offset.plus-MK-Hz9U(this.dragTotalDistance, r20);
            this.dragTotalDistance = r4;
            final long r5 = Offset.plus-MK-Hz9U(this.dragBeginPosition, r4);
            TextFieldSelectionStateKt.access$logDebug(new x(r5));
            if (this.dragBeginOffsetInText < 0) goto L15;
        L21:
            Integer r3 = Integer.valueOf(this.dragBeginOffsetInText);
            if (r3.intValue() >= 0) goto L25;
            r2 = false;
        L25:
            if (r2 == true) goto L28;
            r3 = null;
        L28:
            if (r3 == null) goto L30;
            int r6 = r3.intValue();
        L31:
            int r7 = TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).m1662getOffsetForPosition3MmeM6k(r5, false);
            if (this.dragBeginOffsetInText >= 0) goto L35;
            if (r6 != r7) goto L35;
            return;
        L35:
            SelectionAdjustment r8 = SelectionAdjustment.Companion.getWord();
            this.this$0.updateTextToolbarState(TextToolbarState.Selection);
        L20:
            int r11 = r6;
            int r12 = r7;
            SelectionAdjustment r14 = r8;
            long r9 = this.this$0.getTextFieldState$foundation_release().getVisualText().m1535getSelectiond9O1mEE();
            TextFieldSelectionState r10 = this.this$0;
            long r13 = TextFieldSelectionState.m1722updateSelectionSsLRf8$default(r10, r10.getTextFieldState$foundation_release().getVisualText(), r11, r12, false, r14, false, false, 64, null);
            if (this.dragBeginOffsetInText != (-1)) goto L42;
            if (TextRange.getCollapsed-impl(r13) == true) goto L42;
            this.dragBeginOffsetInText = TextRange.getStart-impl(r13);
        L42:
            if (TextRange.getReversed-impl(r13) == false) goto L45;
            r13 = TextFieldSelectionStateKt.m1731access$reverse5zctL8(r13);
        L45:
            if (TextRange.equals-impl0(r13, r9) == true) goto L62;
            if (TextRange.getStart-impl(r13) == TextRange.getStart-impl(r9)) goto L52;
            if (TextRange.getEnd-impl(r13) != TextRange.getEnd-impl(r9)) goto L52;
            Handle r15 = Handle.SelectionStart;
        L60:
            this.actingHandle = r15;
            this.isLongPressSelectionOnly = false;
        L52:
            if (TextRange.getStart-impl(r13) != TextRange.getStart-impl(r9)) goto L57;
            if (TextRange.getEnd-impl(r13) == TextRange.getEnd-impl(r9)) goto L57;
            r15 = Handle.SelectionEnd;
        L57:
            if (((TextRange.getStart-impl(r13) + TextRange.getEnd-impl(r13)) / 2.0f) <= ((TextRange.getStart-impl(r9) + TextRange.getEnd-impl(r9)) / 2.0f)) goto L59;
            r15 = Handle.SelectionEnd;
            goto L60
        L59:
            r15 = Handle.SelectionStart;
        L62:
            if (TextRange.getCollapsed-impl(r9) == false) goto L64;
        L65:
            this.this$0.getTextFieldState$foundation_release().m1679selectCharsIn5zctL8(r13);
        L66:
            this.this$0.m1724updateHandleDraggingUv8p0NA(this.actingHandle, r5);
            return;
        L64:
            if (TextRange.getCollapsed-impl(r13) == true) goto L66;
        L30:
            r6 = TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).m1662getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            goto L31
        L15:
            if (TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).m1663isPositionOnTextk4lQ0M(r5) == true) goto L21;
            r6 = TextLayoutState.m1659getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.access$getTextLayoutState$p(this.this$0), this.dragBeginPosition, false, 2, null);
            r7 = TextLayoutState.m1659getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.access$getTextLayoutState$p(this.this$0), r5, false, 2, null);
            if (r6 != r7) goto L19;
            r8 = SelectionAdjustment.Companion.getNone();
            goto L20
        L19:
            r8 = SelectionAdjustment.Companion.getWord();
            goto L20
        L70:
            return;
        L9:
            r1 = false;
            goto L10
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onStart-k-4lQ0M */
        public void mo1451onStartk4lQ0M(final long r22) {
            if (TextFieldSelectionState.access$getEnabled$p(this.this$0) == true) goto L5;
            return;
        L5:
            TextFieldSelectionStateKt.access$logDebug(new y(r22));
            this.this$0.m1724updateHandleDraggingUv8p0NA(this.actingHandle, r22);
            boolean r7 = false;
            TextFieldSelectionState.access$setShowCursorHandle(this.this$0, false);
            this.this$0.setDirectDragGestureInitiator(InputType.Touch);
            this.dragBeginPosition = r22;
            this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
            TextFieldSelectionState.access$setPreviousRawDragOffset$p(this.this$0, -1);
            this.isLongPressSelectionOnly = true;
            if (TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).getLayoutResult() != null) goto L9;
            return;
        L9:
            if (TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).m1663isPositionOnTextk4lQ0M(r22) == true) goto L15;
            int r1 = TextLayoutState.m1659getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.access$getTextLayoutState$p(this.this$0), r22, false, 2, null);
            HapticFeedback r2 = TextFieldSelectionState.access$getHapticFeedBack$p(this.this$0);
            if (r2 == null) goto L13;
            r2.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
        L13:
            this.this$0.getTextFieldState$foundation_release().placeCursorBeforeCharAt(r1);
            TextFieldSelectionState.access$setShowCursorHandle(this.this$0, true);
            this.isLongPressSelectionOnly = false;
            this.this$0.updateTextToolbarState(TextToolbarState.Cursor);
            return;
        L15:
            if (this.this$0.getTextFieldState$foundation_release().getVisualText().length() != 0) goto L17;
            r7 = true;
        L17:
            if (r7 == false) goto L19;
            return;
        L19:
            int r10 = TextLayoutState.m1659getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.access$getTextLayoutState$p(this.this$0), r22, false, 2, null);
            TextFieldSelectionState r8 = this.this$0;
            long r3 = TextFieldSelectionState.m1722updateSelectionSsLRf8$default(r8, new TextFieldCharSequence(r8.getTextFieldState$foundation_release().getVisualText(), TextRange.Companion.getZero-d9O1mEE(), null, null, null, null, 60, null), r10, r10, false, SelectionAdjustment.Companion.getWord(), false, false, 96, null);
            this.this$0.getTextFieldState$foundation_release().m1679selectCharsIn5zctL8(r3);
            this.this$0.updateTextToolbarState(TextToolbarState.Selection);
            this.dragBeginOffsetInText = TextRange.getStart-impl(r3);
        }

        public TextFieldTextDragObserver(TextFieldSelectionState r3, Function0<Unit> r4) {
            this.this$0 = r3;
            this.requestFocus = r4;
            this.dragBeginOffsetInText = -1;
            Offset.Companion r5 = Offset.Companion;
            this.dragBeginPosition = r5.getUnspecified-F1C5BW0();
            this.dragTotalDistance = r5.getZero-F1C5BW0();
            this.actingHandle = Handle.SelectionEnd;
            this.isLongPressSelectionOnly = true;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[IndexTransformationType.values().length];
            r0[IndexTransformationType.Untransformed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[IndexTransformationType.Deletion.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[IndexTransformationType.Insertion.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[IndexTransformationType.Replacement.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {0}, l = {1399}, m = "copy", n = {"cancelSelection"}, s = {"Z$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TextFieldSelectionState this$0;

        public AnonymousClass1(TextFieldSelectionState r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.copy(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2", f = "TextFieldSelectionState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1", f = "TextFieldSelectionState.kt", i = {}, l = {395}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            public AnonymousClass1(TextFieldSelectionState r1, PointerInputScope r2, Continuation<? super AnonymousClass1> r3) {
                this.this$0 = r1;
                this.$this_cursorHandleGestures = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.this$0, this.$this_cursorHandleGestures, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                TextFieldSelectionState r5 = this.this$0;
                PointerInputScope r2 = this.$this_cursorHandleGestures;
                this.label = 1;
                if (r5.detectTouchMode(r2, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2", f = "TextFieldSelectionState.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            public C00412(TextFieldSelectionState r1, PointerInputScope r2, Continuation<? super C00412> r3) {
                this.this$0 = r1;
                this.$this_cursorHandleGestures = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00412(this.this$0, this.$this_cursorHandleGestures, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                TextFieldSelectionState r5 = this.this$0;
                PointerInputScope r2 = this.$this_cursorHandleGestures;
                this.label = 1;
                if (TextFieldSelectionState.access$detectCursorHandleDragGestures(r5, r2, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3", f = "TextFieldSelectionState.kt", i = {}, l = {398}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            public AnonymousClass3(PointerInputScope r1, TextFieldSelectionState r2, Continuation<? super AnonymousClass3> r3) {
                this.$this_cursorHandleGestures = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public static /* synthetic */ Unit a(TextFieldSelectionState r0, Offset r1) {
                return invokeSuspend$lambda$0(r0, r1);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass3(this.$this_cursorHandleGestures, this.this$0, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r10);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r10);
                PointerInputScope r2 = this.$this_cursorHandleGestures;
                final TextFieldSelectionState r5 = this.this$0;
                Function1 r6 = new a0(r5);
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures$default(r2, null, null, null, r6, this, 7, null) != r0) goto L12;
                return r0;
            }

            private static final Unit invokeSuspend$lambda$0(TextFieldSelectionState r1, Offset r2) {
                TextToolbarState r3 = TextFieldSelectionState.access$getTextToolbarState(r1);
                TextToolbarState r0 = TextToolbarState.Cursor;
                if (r3 != r0) goto L5;
                r0 = TextToolbarState.None;
            L5:
                TextFieldSelectionState.access$setTextToolbarState(r1, r0);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(TextFieldSelectionState r1, PointerInputScope r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$this_cursorHandleGestures = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$this_cursorHandleGestures, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Job> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r9);
            CoroutineScope r10 = (CoroutineScope) this.L$0;
            CoroutineStart r6 = CoroutineStart.UNDISPATCHED;
            BuildersKt.launch$default(r10, null, r6, new AnonymousClass1(this.this$0, this.$this_cursorHandleGestures, null), 1, null);
            BuildersKt.launch$default(r10, null, r6, new C00412(this.this$0, this.$this_cursorHandleGestures, null), 1, null);
            return BuildersKt.launch$default(r10, null, r6, new AnonymousClass3(this.$this_cursorHandleGestures, this.this$0, null), 1, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {}, l = {1375}, m = "cut", n = {}, s = {})
    public static final class C02151 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02151(TextFieldSelectionState r1, Continuation<? super C02151> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.cut(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {0, 0}, l = {625}, m = "detectCursorHandleDragGestures", n = {"cursorDragStart", "cursorDragDelta"}, s = {"L$0", "L$1"})
    public static final class C02161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02161(TextFieldSelectionState r1, Continuation<? super C02161> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TextFieldSelectionState.access$detectCursorHandleDragGestures(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {0, 0, 0}, l = {1067}, m = "detectSelectionHandleDragGestures", n = {"dragBeginPosition", "dragTotalDistance", "handle"}, s = {"L$0", "L$1", "L$2"})
    public static final class C02171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02171(TextFieldSelectionState r1, Continuation<? super C02171> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TextFieldSelectionState.access$detectSelectionHandleDragGestures(this.this$0, null, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2", f = "TextFieldSelectionState.kt", i = {}, l = {503}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02182 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02182(MutableInteractionSource r1, TextFieldSelectionState r2, Continuation<? super C02182> r3) {
            this.$interactionSource = r1;
            this.this$0 = r2;
            super(3, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
            return m1730invoked4ec7I((PressGestureScope) r3, ((Offset) r4).unbox-impl(), (Continuation) r5);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m1730invoked4ec7I(PressGestureScope r4, long r5, Continuation<? super Unit> r7) {
            C02182 r0 = new C02182(this.$interactionSource, this.this$0, r7);
            r0.L$0 = r4;
            r0.J$0 = r5;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            PressGestureScope r4 = (PressGestureScope) this.L$0;
            long r6 = this.J$0;
            MutableInteractionSource r8 = this.$interactionSource;
            if (r8 == null) goto L14;
            TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 r12 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(r4, this.this$0, r6, r8, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(r12, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2", f = "TextFieldSelectionState.kt", i = {0}, l = {467}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    public static final class C02192 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02192(TextFieldSelectionState r1, Continuation<? super C02192> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02192 r0 = new C02192(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r7);
            AwaitPointerEventScope r3 = r2;
            Object r4 = r0;
            C02192 r5 = this;
        L13:
            r5.this$0.setInTouchMode(!SelectionGesturesKt.isPrecisePointer((PointerEvent) r7));
            C02192 r8 = r5;
            r0 = r4;
            AwaitPointerEventScope r6 = r3;
        L9:
            PointerEventPass r9 = PointerEventPass.Initial;
            r8.L$0 = r6;
            r8.label = 1;
            Object r10 = r6.awaitPointerEvent(r9, r8);
            if (r10 != r0) goto L12;
            return r0;
        L12:
            Object r11 = r0;
            r5 = r8;
            r7 = r10;
            r3 = r6;
            r4 = r11;
            goto L13
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            r6 = (AwaitPointerEventScope) this.L$0;
            r8 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$maybeSuggestSelectionRange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$maybeSuggestSelectionRange$1", f = "TextFieldSelectionState.kt", i = {}, l = {1025}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlatformSelectionBehaviors $platformSelectionBehaviors;
        final /* synthetic */ long $selection;
        final /* synthetic */ CharSequence $text;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02201(PlatformSelectionBehaviors r1, CharSequence r2, long r3, TextFieldSelectionState r5, Continuation<? super C02201> r6) {
            this.$platformSelectionBehaviors = r1;
            this.$text = r2;
            this.$selection = r3;
            this.this$0 = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C02201(this.$platformSelectionBehaviors, this.$text, this.$selection, this.this$0, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            TextRange r7 = (TextRange) r6;
            if (TextFieldSelectionState.access$isPassword$p(this.this$0) == true) goto L22;
            if (r7 == null) goto L22;
            if (Intrinsics.areEqual(this.this$0.getTextFieldState$foundation_release().getVisualText().getText(), this.$text) == false) goto L22;
            if (TextRange.equals-impl0(this.this$0.getTextFieldState$foundation_release().getVisualText().m1535getSelectiond9O1mEE(), this.$selection) == false) goto L22;
            long r2 = this.this$0.getTextFieldState$foundation_release().getVisualText().m1535getSelectiond9O1mEE();
            if (TextRange.equals-impl0(r7.unbox-impl(), r2) == true) goto L22;
            this.this$0.getTextFieldState$foundation_release().m1679selectCharsIn5zctL8(r7.unbox-impl());
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            PlatformSelectionBehaviors r8 = this.$platformSelectionBehaviors;
            CharSequence r3 = this.$text;
            long r4 = this.$selection;
            this.label = 1;
            r6 = r8.mo1837suggestSelectionForLongPressOrDoubleClickpYaCww(r3, r4, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<TextFieldCharSequence, CharSequence, Boolean> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(2, TextFieldCharSequence.class, "contentEquals", "contentEquals(Ljava/lang/CharSequence;)Z", 0);
        }

        public final Boolean invoke(TextFieldCharSequence r1, CharSequence r2) {
            return Boolean.valueOf(r1.contentEquals(r2));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((TextFieldCharSequence) r1, (CharSequence) r2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$paste$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {1}, l = {1429, 1431, 1431}, m = "paste", n = {"receiveContentConfiguration"}, s = {"L$0"})
    public static final class C02221 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02221(TextFieldSelectionState r1, Continuation<? super C02221> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.paste(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {}, l = {1462, 1462}, m = "pasteAsPlainText", n = {}, s = {})
    public static final class C02231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02231(TextFieldSelectionState r1, Continuation<? super C02231> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TextFieldSelectionState.access$pasteAsPlainText(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2", f = "TextFieldSelectionState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02242 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ boolean $isStartHandle;
        final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1", f = "TextFieldSelectionState.kt", i = {}, l = {408}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            public AnonymousClass1(TextFieldSelectionState r1, PointerInputScope r2, Continuation<? super AnonymousClass1> r3) {
                this.this$0 = r1;
                this.$this_selectionHandleGestures = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.this$0, this.$this_selectionHandleGestures, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                TextFieldSelectionState r5 = this.this$0;
                PointerInputScope r2 = this.$this_selectionHandleGestures;
                this.label = 1;
                if (r5.detectTouchMode(r2, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2", f = "TextFieldSelectionState.kt", i = {}, l = {410}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00422 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            public C00422(PointerInputScope r1, TextFieldSelectionState r2, boolean r3, Continuation<? super C00422> r4) {
                this.$this_selectionHandleGestures = r1;
                this.this$0 = r2;
                this.$isStartHandle = r3;
                super(2, r4);
            }

            public static /* synthetic */ Unit a(TextFieldSelectionState r0) {
                return invokeSuspend$lambda$0(r0);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00422(this.$this_selectionHandleGestures, this.this$0, this.$isStartHandle, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            private static final Unit invokeSuspend$lambda$0(TextFieldSelectionState r0) {
                r0.clearHandleDragging();
                return Unit.INSTANCE;
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                PointerInputScope r7 = this.$this_selectionHandleGestures;
                final TextFieldSelectionState r3 = this.this$0;
                final boolean r4 = this.$isStartHandle;
                TapOnPosition r2 = new AnonymousClass1(r3, r4);
                final TextFieldSelectionState r5 = this.this$0;
                Function0 r8 = new b0(r5);
                this.label = 1;
                if (PressDownGestureKt.detectPressDownGesture(r7, r2, r8, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3", f = "TextFieldSelectionState.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            public AnonymousClass3(TextFieldSelectionState r1, PointerInputScope r2, boolean r3, Continuation<? super AnonymousClass3> r4) {
                this.this$0 = r1;
                this.$this_selectionHandleGestures = r2;
                this.$isStartHandle = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new AnonymousClass3(this.this$0, this.$this_selectionHandleGestures, this.$isStartHandle, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                TextFieldSelectionState r6 = this.this$0;
                PointerInputScope r2 = this.$this_selectionHandleGestures;
                boolean r3 = this.$isStartHandle;
                this.label = 1;
                if (TextFieldSelectionState.access$detectSelectionHandleDragGestures(r6, r2, r3, this) != r0) goto L12;
                return r0;
            }
        }

        public C02242(TextFieldSelectionState r1, PointerInputScope r2, boolean r3, Continuation<? super C02242> r4) {
            this.this$0 = r1;
            this.$this_selectionHandleGestures = r2;
            this.$isStartHandle = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C02242 r0 = new C02242(this.this$0, this.$this_selectionHandleGestures, this.$isStartHandle, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Job> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r9);
            CoroutineScope r10 = (CoroutineScope) this.L$0;
            CoroutineStart r6 = CoroutineStart.UNDISPATCHED;
            BuildersKt.launch$default(r10, null, r6, new AnonymousClass1(this.this$0, this.$this_selectionHandleGestures, null), 1, null);
            BuildersKt.launch$default(r10, null, r6, new C00422(this.$this_selectionHandleGestures, this.this$0, this.$isStartHandle, null), 1, null);
            return BuildersKt.launch$default(r10, null, r6, new AnonymousClass3(this.this$0, this.$this_selectionHandleGestures, this.$isStartHandle, null), 1, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {}, l = {438}, m = "startToolbarAndHandlesVisibilityObserver", n = {}, s = {})
    public static final class C02251 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TextFieldSelectionState this$0;

        public C02251(TextFieldSelectionState r1, Continuation<? super C02251> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.startToolbarAndHandlesVisibilityObserver(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2", f = "TextFieldSelectionState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02262 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2$1", f = "TextFieldSelectionState.kt", i = {}, l = {439}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            public AnonymousClass1(TextFieldSelectionState r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                TextFieldSelectionState r5 = this.this$0;
                this.label = 1;
                if (TextFieldSelectionState.access$observeTextChanges(r5, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2$2", f = "TextFieldSelectionState.kt", i = {}, l = {440}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00432 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            public C00432(TextFieldSelectionState r1, Continuation<? super C00432> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00432(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                TextFieldSelectionState r5 = this.this$0;
                this.label = 1;
                if (TextFieldSelectionState.access$observeTextToolbarVisibility(r5, this) != r0) goto L12;
                return r0;
            }
        }

        public C02262(TextFieldSelectionState r1, Continuation<? super C02262> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02262 r0 = new C02262(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Job> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            CoroutineScope r9 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r9, null, null, new AnonymousClass1(this.this$0, null), 3, null);
            return BuildersKt.launch$default(r9, null, null, new C00432(this.this$0, null), 3, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ String a() {
        return detectTextFieldTapGestures$lambda$5$lambda$4();
    }

    public static /* synthetic */ Unit b(Ref.LongRef r0, TextFieldSelectionState r1, Ref.LongRef r2) {
        return detectSelectionHandleDragGestures$lambda$14(r0, r1, r2);
    }

    public static /* synthetic */ Rect c(TextFieldSelectionState r0) {
        return observeTextToolbarVisibility$lambda$19(r0);
    }

    public static /* synthetic */ Unit d(Ref.LongRef r0, TextFieldSelectionState r1, Ref.LongRef r2, PointerInputChange r3, Offset r4) {
        return detectCursorHandleDragGestures$lambda$11(r0, r1, r2, r3, r4);
    }

    private static final String detectTextFieldTapGestures$lambda$5$lambda$4() {
        return "onTapTextField";
    }

    public static /* synthetic */ boolean e(Rect r0) {
        return observeTextToolbarVisibility$lambda$21$lambda$20(r0);
    }

    public static /* synthetic */ Unit f(Ref.LongRef r0, TextFieldSelectionState r1, Handle r2, Ref.LongRef r3, boolean r4, PointerInputChange r5, Offset r6) {
        return detectSelectionHandleDragGestures$lambda$16(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit g(Ref.LongRef r0, TextFieldSelectionState r1, Ref.LongRef r2, Offset r3) {
        return detectCursorHandleDragGestures$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit h(Ref.LongRef r0, TextFieldSelectionState r1, boolean r2, Handle r3, Ref.LongRef r4, Offset r5) {
        return detectSelectionHandleDragGestures$lambda$13(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ String i(TextFieldSelectionState r0, Handle r1) {
        return detectSelectionHandleDragGestures$lambda$17(r0, r1);
    }

    public static /* synthetic */ Unit j(Ref.LongRef r0, Ref.LongRef r1, TextFieldSelectionState r2) {
        return detectCursorHandleDragGestures$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ Unit k(Function0 r0, TextFieldSelectionState r1, Function0 r2, Offset r3) {
        return detectTextFieldTapGestures$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ Rect l(TextFieldSelectionState r0) {
        return derivedVisibleContentBounds_delegate$lambda$22(r0);
    }

    public static /* synthetic */ Unit m(Ref.LongRef r0, Ref.LongRef r1, TextFieldSelectionState r2) {
        return detectCursorHandleDragGestures$lambda$10(r0, r1, r2);
    }

    public static /* synthetic */ Unit n(Ref.LongRef r0, TextFieldSelectionState r1, Ref.LongRef r2) {
        return detectSelectionHandleDragGestures$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ TextFieldCharSequence o(TextFieldSelectionState r0) {
        return observeTextChanges$lambda$18(r0);
    }

    private static final boolean observeTextToolbarVisibility$lambda$21$lambda$20(Rect r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        return false;
    }

    public final void clearHandleDragging() {
        setDraggingHandle(null);
        Offset.Companion r0 = Offset.Companion;
        m1719setRawHandleDragPositionk4lQ0M(r0.getUnspecified-F1C5BW0());
        m1720setStartTextLayoutPositionInWindowk4lQ0M(r0.getUnspecified-F1C5BW0());
    }

    private final Rect getContentRect() {
        LayoutCoordinates r1 = getTextLayoutCoordinates();
        if (r1 == null) goto L14;
        TextFieldCharSequence r2 = this.textFieldState.getVisualText();
        if (TextRange.getCollapsed-impl(r2.m1535getSelectiond9O1mEE()) == false) goto L8;
        Rect r3 = getCursorRect();
        return RectKt.Rect-tz77jQw(r1.localToRoot-MK-Hz9U(r3.getTopLeft-F1C5BW0()), r3.getSize-NH-jbRc());
    L8:
        long r4 = r1.localToRoot-MK-Hz9U(m1714getHandlePositiontuRUvjQ(true));
        long r5 = r1.localToRoot-MK-Hz9U(m1714getHandlePositiontuRUvjQ(false));
        TextLayoutResult r7 = this.textLayoutState.getLayoutResult();
        if (r7 == null) goto L11;
        float r8 = r7.getCursorRect(TextRange.getStart-impl(r2.m1535getSelectiond9O1mEE())).getTop();
        float r10 = Float.intBitsToFloat((int) (r1.localToRoot-MK-Hz9U(Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r8)) & 4294967295L))) & 4294967295L));
        float r6 = r7.getCursorRect(TextRange.getEnd-impl(r2.m1535getSelectiond9O1mEE())).getTop();
        long r11 = Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget);
        float r9 = Float.intBitsToFloat((int) (r1.localToRoot-MK-Hz9U(Offset.constructor-impl((((long) Float.floatToRawIntBits(r6)) & 4294967295L) | (r11 << 32))) & 4294967295L));
        int r12 = (int) (r4 >> 32);
        int r13 = (int) (r5 >> 32);
        return new Rect(Math.min(Float.intBitsToFloat(r12), Float.intBitsToFloat(r13)), Math.min(r10, r9), Math.max(Float.intBitsToFloat(r12), Float.intBitsToFloat(r13)), Math.max(Float.intBitsToFloat((int) (r4 & 4294967295L)), Float.intBitsToFloat((int) (r5 & 4294967295L))));
    L11:
        return Rect.Companion.getZero();
    L14:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("textLayoutCoordinates should not be null.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m1715getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition$delegate.getValue()).unbox-impl();
    }

    private final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getStartTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m1716getStartTextLayoutPositionInWindowF1C5BW0() {
        return ((Offset) this.startTextLayoutPositionInWindow$delegate.getValue()).unbox-impl();
    }

    private final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates r0 = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (r0 == null) goto L8;
        if (r0.isAttached() == false) goto L8;
        return r0;
    L8:
        return null;
    }

    private final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState$delegate.getValue();
    }

    private final void hideTextToolbar() {
        if (ComposeFoundationFlags.isNewContextMenuEnabled == false) goto L5;
        this.toolbarRequester.hide();
        return;
    L5:
        TextToolbarHandler r0 = this.textToolbarHandler;
        if (r0 == null) goto L10;
        r0.hideTextToolbar();
        return;
    }

    private final boolean isCursorHandleInVisibleBounds() {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
        long r4 = getCursorRect().getBottomCenter-F1C5BW0();     // Catch: Throwable -> L15
        r0.restoreNonObservable(r1, r3, r2);
        LayoutCoordinates r5 = getTextLayoutCoordinates();
        if (r5 == null) goto L13;
        Rect r6 = SelectionManagerKt.visibleBounds(r5);
        if (r6 == null) goto L13;
        return SelectionManagerKt.m1878containsInclusiveUv8p0NA(r6, r4);
    L13:
        return false;
    L15:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L5:
        r2 = null;
        goto L6
    }

    public final void autofill() {
        Function0<Unit> r0 = this.requestAutofillAction;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final boolean canCopy() {
        if (TextRange.getCollapsed-impl(this.textFieldState.getVisualText().m1535getSelectiond9O1mEE()) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.isPassword == true) goto L7;
        return true;
    }

    public final boolean canCut() {
        if (TextRange.getCollapsed-impl(this.textFieldState.getVisualText().m1535getSelectiond9O1mEE()) == false) goto L5;
    L9:
        return false;
    L5:
        if (getEditable$foundation_release() == false) goto L9;
        if (this.isPassword == true) goto L9;
        return true;
    }

    public final boolean canSelectAll() {
        if (TextRange.getLength-impl(this.textFieldState.getVisualText().m1535getSelectiond9O1mEE()) == this.textFieldState.getVisualText().length()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void deselect() {
        if (TextRange.getCollapsed-impl(this.textFieldState.getVisualText().m1535getSelectiond9O1mEE()) == true) goto L5;
        this.textFieldState.collapseSelectionToEnd();
    L5:
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    public final Rect getCursorRect() {
        TextLayoutResult r0 = this.textLayoutState.getLayoutResult();
        if (r0 == null) goto L5;
        TextFieldCharSequence r1 = this.textFieldState.getVisualText();
        if (TextRange.getCollapsed-impl(r1.m1535getSelectiond9O1mEE()) == false) goto L9;
        Rect r2 = r0.getCursorRect(TextRange.getStart-impl(r1.m1535getSelectiond9O1mEE()));
        float r3 = RangesKt.coerceAtLeast((float) Math.floor(this.density.toPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
        if (r0.getLayoutInput().getLayoutDirection() != LayoutDirection.Ltr) goto L13;
        float r4 = r2.getLeft() + (r3 / 2);
    L14:
        float r5 = r3 / 2;
        float r6 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r4, ((int) (r0.getSize-YbymL2g() >> 32)) - r5), r5);
        if ((((int) r3) % 2) != 1) goto L17;
        float r7 = ((float) Math.floor(r6)) + 0.5f;
    L19:
        return new Rect(r7 - r5, r2.getTop(), r7 + r5, r2.getBottom());
    L17:
        r7 = (float) Math.rint(r6);
        goto L19
    L13:
        r4 = r2.getRight() - (r3 / 2);
        goto L14
    L9:
        return Rect.Companion.getZero();
    L5:
        return Rect.Companion.getZero();
    }

    public final Rect getDerivedVisibleContentBounds$foundation_release() {
        return (Rect) this.derivedVisibleContentBounds$delegate.getValue();
    }

    public final InputType getDirectDragGestureInitiator() {
        return (InputType) this.directDragGestureInitiator$delegate.getValue();
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    public final boolean getEditable$foundation_release() {
        if (this.enabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.readOnly == true) goto L7;
        return true;
    }

    public final boolean getTextToolbarShown() {
        return ((Boolean) this.textToolbarShown$delegate.getValue()).booleanValue();
    }

    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode$delegate.getValue()).booleanValue();
    }

    public final void maybeSuggestSelectionRange() {
        PlatformSelectionBehaviors r1 = this.platformSelectionBehaviors;
        if (r1 != null) goto L5;
        return;
    L5:
        CharSequence r2 = this.textFieldState.getVisualText().getText();
        long r3 = this.textFieldState.getVisualText().m1535getSelectiond9O1mEE();
        if (r2.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return;
    L11:
        if (TextRange.getCollapsed-impl(r3) == true) goto L15;
        BuildersKt.launch$default(this.coroutineScope, null, CoroutineStart.UNDISPATCHED, new C02201(r1, r2, r3, this, null), 1, null);
        return;
    L15:
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    /* JADX INFO: renamed from: getCurrentTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m1713getCurrentTextLayoutPositionInWindowF1C5BW0() {
        LayoutCoordinates r0 = getTextLayoutCoordinates();
        if (r0 == null) goto L6;
        return LayoutCoordinatesKt.positionInWindow(r0);
    L6:
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    private final void markStartContentVisibleOffset() {
        m1720setStartTextLayoutPositionInWindowk4lQ0M(m1713getCurrentTextLayoutPositionInWindowF1C5BW0());
    }

    public final boolean canAutofill() {
        if (getEditable$foundation_release() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextRange.getCollapsed-impl(this.textFieldState.getVisualText().m1535getSelectiond9O1mEE()) == false) goto L7;
        return true;
    }

    public final boolean canPaste() {
        if (getEditable$foundation_release() == true) goto L6;
        return false;
    L6:
        if (this.clipboardPasteState.getHasText() == false) goto L8;
        return true;
    L8:
        Function0<? extends ReceiveContentConfiguration> r0 = this.receiveContentConfiguration;
        if (r0 == null) goto L11;
        ReceiveContentConfiguration r1 = (ReceiveContentConfiguration) r0.invoke();
    L12:
        if (r1 != null) goto L14;
        return false;
    L14:
        if (this.clipboardPasteState.getHasClip() == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r1 = null;
        goto L12
    }

    public final void dispose() {
        hideTextToolbar();
        this.hapticFeedBack = null;
    }

    /* JADX INFO: renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m1723getHandleDragPositionF1C5BW0() {
        boolean r4 = true;
        if ((m1715getRawHandleDragPositionF1C5BW0() & SieveCacheKt.InvalidMapping) != 9205357640488583168L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return Offset.Companion.getUnspecified-F1C5BW0();
    L9:
        if ((m1716getStartTextLayoutPositionInWindowF1C5BW0() & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L12;
        r4 = false;
    L12:
        if (r4 == false) goto L15;
        return TextLayoutStateKt.m1667fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1715getRawHandleDragPositionF1C5BW0());
    L15:
        return Offset.plus-MK-Hz9U(m1715getRawHandleDragPositionF1C5BW0(), Offset.minus-MK-Hz9U(m1716getStartTextLayoutPositionInWindowF1C5BW0(), m1713getCurrentTextLayoutPositionInWindowF1C5BW0()));
    L5:
        r0 = false;
        goto L6
    }

    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors$foundation_release() {
        return this.platformSelectionBehaviors;
    }

    public final Function0<ReceiveContentConfiguration> getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    public final Function0<Unit> getRequestAutofillAction() {
        return this.requestAutofillAction;
    }

    public final TransformedTextFieldState getTextFieldState$foundation_release() {
        return this.textFieldState;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public static final /* synthetic */ boolean access$getEnabled$p(TextFieldSelectionState r0) {
        return r0.enabled;
    }

    public static final /* synthetic */ HapticFeedback access$getHapticFeedBack$p(TextFieldSelectionState r0) {
        return r0.hapticFeedBack;
    }

    public static final /* synthetic */ PressInteraction.Press access$getPressInteraction$p(TextFieldSelectionState r0) {
        return r0.pressInteraction;
    }

    public static final /* synthetic */ TextLayoutState access$getTextLayoutState$p(TextFieldSelectionState r0) {
        return r0.textLayoutState;
    }

    public static final /* synthetic */ TextToolbarState access$getTextToolbarState(TextFieldSelectionState r0) {
        return r0.getTextToolbarState();
    }

    public static final /* synthetic */ void access$hideTextToolbar(TextFieldSelectionState r0) {
        r0.hideTextToolbar();
    }

    public static final /* synthetic */ boolean access$isPassword$p(TextFieldSelectionState r0) {
        return r0.isPassword;
    }

    public static final /* synthetic */ void access$markStartContentVisibleOffset(TextFieldSelectionState r0) {
        r0.markStartContentVisibleOffset();
    }

    private static final Rect derivedVisibleContentBounds_delegate$lambda$22(TextFieldSelectionState r5) {
        boolean r0 = TextRange.getCollapsed-impl(r5.textFieldState.getVisualText().m1535getSelectiond9O1mEE());
        boolean r1 = true;
        if (r0 == true) goto L5;
    L6:
        if (r0 == false) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
    L17:
        r1 = false;
    L19:
        if (r1 == true) goto L21;
        return null;
    L21:
        LayoutCoordinates r3 = r5.getTextLayoutCoordinates();
        if (r3 != null) goto L24;
        return null;
    L24:
        Rect r4 = SelectionManagerKt.visibleBounds(r3);
        Rect r6 = RectKt.Rect-tz77jQw(r3.localToRoot-MK-Hz9U(r4.getTopLeft-F1C5BW0()), r4.getSize-NH-jbRc());
        Rect r7 = r5.getContentRect();
        if (r7.overlaps(r6) == true) goto L28;
        return null;
    L28:
        return r7.intersect(r6);
    L13:
        if (r5.getDraggingHandle() != null) goto L17;
        if (r5.isInTouchMode() == false) goto L17;
    L8:
        if (r5.getTextToolbarState() != TextToolbarState.Selection) goto L10;
    L9:
        r2 = true;
        goto L11
    L5:
        if (r5.getTextToolbarState() == TextToolbarState.Cursor) goto L9;
        goto L6
    }

    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    private final long m1714getHandlePositiontuRUvjQ(boolean r5) {
        TextLayoutResult r0 = this.textLayoutState.getLayoutResult();
        if (r0 == null) goto L5;
        long r1 = this.textFieldState.getVisualText().m1535getSelectiond9O1mEE();
        if (r5 == false) goto L9;
        int r3 = TextRange.getStart-impl(r1);
    L11:
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(r0, r3, r5, TextRange.getReversed-impl(r1));
    L9:
        r3 = TextRange.getEnd-impl(r1);
        goto L11
    L5:
        return Offset.Companion.getZero-F1C5BW0();
    }

    private final Object observeTextChanges(Continuation<? super Unit> r3) {
        Object r4 = kotlinx.coroutines.flow.e.p(kotlinx.coroutines.flow.e.o(SnapshotStateKt.snapshotFlow(new r(this)), AnonymousClass3.INSTANCE), 1).collect(new AnonymousClass4(this), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    private static final TextFieldCharSequence observeTextChanges$lambda$18(TextFieldSelectionState r0) {
        return r0.textFieldState.getVisualText();
    }

    private final Object observeTextToolbarVisibility(Continuation<? super Unit> r4) {
        Flow r0 = SnapshotStateKt.snapshotFlow(new k(this));
        if (ComposeFoundationFlags.isNewContextMenuEnabled == false) goto L5;
        r0 = FlowKt__DistinctKt.a(r0, new l(), FlowKt__DistinctKt.b);
    L5:
        Object r5 = r0.collect(new C02214(this), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r5;
    L9:
        return Unit.INSTANCE;
    }

    private static final Rect observeTextToolbarVisibility$lambda$19(TextFieldSelectionState r0) {
        return r0.getDerivedVisibleContentBounds$foundation_release();
    }

    private final Object pasteAsPlainText(Continuation<? super Unit> r8) {
        if ((r8 instanceof C02231) == false) goto L7;
        C02231 r0 = (C02231) r8;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L24:
        String r4 = (String) r9;
        if (r4 == null) goto L30;
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, r4, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
        return Unit.INSTANCE;
    L30:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
    L19:
        ClipEntry r10 = (ClipEntry) r9;
        if (r10 == null) goto L30;
        r0.label = 2;
        r9 = ClipboardUtils_androidKt.readText(r10, r0);
        if (r9 != r2) goto L24;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        Clipboard r11 = this.clipboard;
        r0.label = 1;
        r9 = r11.getClipEntry(r0);
        if (r9 != r2) goto L19;
        return r2;
    L7:
        r0 = new C02231(this, r8);
        goto L8
    }

    /* JADX INFO: renamed from: placeCursorAtNearestOffset-k-4lQ0M, reason: not valid java name */
    private final boolean m1718placeCursorAtNearestOffsetk4lQ0M(long r11) {
        TextLayoutResult r0 = this.textLayoutState.getLayoutResult();
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0.getOffsetForPosition-k-4lQ0M(r11);
        if (r2 != (-1)) goto L8;
        return false;
    L8:
        TransformedTextFieldState r3 = this.textFieldState;
        long r4 = r3.m1674mapFromTransformedjx7JFs(r2);
        long r5 = r3.m1677mapToTransformedGEjPoXI(r4);
        if (TextRange.getCollapsed-impl(r4) == false) goto L14;
        if (TextRange.getCollapsed-impl(r5) == false) goto L14;
        IndexTransformationType r6 = IndexTransformationType.Untransformed;
    L24:
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        SelectionWedgeAffinity r8 = null;
        if (r7 != 1) goto L27;
        int r12 = TextRange.getStart-impl(r4);
    L45:
        long r13 = TextRangeKt.TextRange(r12);
        if (TextRange.equals-impl0(r13, this.textFieldState.getUntransformedText().m1535getSelectiond9O1mEE()) == false) goto L51;
        if (r8 != null) goto L49;
    L50:
        return false;
    L49:
        if (Intrinsics.areEqual(r8, this.textFieldState.getSelectionWedgeAffinity()) == true) goto L50;
    L51:
        this.textFieldState.m1680selectUntransformedCharsIn5zctL8(r13);
        if (r8 == null) goto L54;
        this.textFieldState.setSelectionWedgeAffinity(r8);
    L54:
        return true;
    L27:
        if (r7 != 2) goto L29;
        r12 = TextRange.getStart-impl(r4);
        goto L45
    L29:
        if (r7 == 3) goto L39;
        if (r7 != 4) goto L37;
        if (MathUtilsKt.m1610findClosestRect9KIMszo(r11, r0.getCursorRect(TextRange.getStart-impl(r5)), r0.getCursorRect(TextRange.getEnd-impl(r5))) >= 0) goto L35;
        r12 = TextRange.getStart-impl(r4);
        goto L45
    L35:
        r12 = TextRange.getEnd-impl(r4);
        goto L45
    L37:
        throw new NoWhenBranchMatchedException();
    L39:
        if (MathUtilsKt.m1610findClosestRect9KIMszo(r11, r0.getCursorRect(TextRange.getStart-impl(r5)), r0.getCursorRect(TextRange.getEnd-impl(r5))) >= 0) goto L41;
        SelectionWedgeAffinity r14 = new SelectionWedgeAffinity(WedgeAffinity.Start);
    L42:
        r8 = r14;
        r12 = TextRange.getStart-impl(r4);
        goto L45
    L41:
        r14 = new SelectionWedgeAffinity(WedgeAffinity.End);
    L14:
        if (TextRange.getCollapsed-impl(r4) == true) goto L19;
        if (TextRange.getCollapsed-impl(r5) == true) goto L19;
        r6 = IndexTransformationType.Replacement;
    L19:
        if (TextRange.getCollapsed-impl(r4) == true) goto L21;
    L23:
        r6 = IndexTransformationType.Deletion;
        goto L24
    L21:
        if (TextRange.getCollapsed-impl(r5) == true) goto L23;
        r6 = IndexTransformationType.Insertion;
        goto L24
    }

    /* JADX INFO: renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m1719setRawHandleDragPositionk4lQ0M(long r2) {
        this.rawHandleDragPosition$delegate.setValue(Offset.box-impl(r2));
    }

    private final void setShowCursorHandle(boolean r2) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(r2));
    }

    /* JADX INFO: renamed from: setStartTextLayoutPositionInWindow-k-4lQ0M, reason: not valid java name */
    private final void m1720setStartTextLayoutPositionInWindowk4lQ0M(long r2) {
        this.startTextLayoutPositionInWindow$delegate.setValue(Offset.box-impl(r2));
    }

    private final void setTextToolbarState(TextToolbarState r2) {
        this.textToolbarState$delegate.setValue(r2);
    }

    public final Object cut(Continuation<? super Unit> r7) {
        if ((r7 instanceof C02151) == false) goto L7;
        C02151 r0 = (C02151) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L21:
        this.textFieldState.deleteSelectedText();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        TextFieldCharSequence r9 = this.textFieldState.getVisualText();
        if (TextRange.getCollapsed-impl(r9.m1535getSelectiond9O1mEE()) == true) goto L17;
        AnnotatedString r4 = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(r9).toString(), null, 2, null);
        Clipboard r10 = this.clipboard;
        ClipEntry r5 = ClipboardUtils_androidKt.toClipEntry(r4);
        r0.label = 1;
        if (r10.setClipEntry(r5, r0) != r2) goto L21;
        return r2;
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new C02151(this, r7);
        goto L8
    }

    public final TextFieldHandleState getCursorHandleState$foundation_release(boolean r10) {
        TextFieldCharSequence r0 = this.textFieldState.getVisualText();
        boolean r1 = getShowCursorHandle();
        boolean r4 = true;
        if (getDirectDragGestureInitiator() != InputType.None) goto L5;
        boolean r2 = true;
    L6:
        Handle r3 = getDraggingHandle();
        if (r1 == false) goto L23;
        if (r2 == false) goto L23;
        if (TextRange.getCollapsed-impl(r0.m1535getSelectiond9O1mEE()) == false) goto L23;
        if (r0.shouldShowSelection() == false) goto L23;
        if (r0.length() <= 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L23;
        if (r3 != Handle.Cursor) goto L21;
    L24:
        if (r4 == true) goto L28;
        return TextFieldHandleState.Companion.getHidden();
    L28:
        if (r10 == false) goto L30;
        long r6 = getCursorRect().getBottomCenter-F1C5BW0();
    L32:
        return new TextFieldHandleState(true, r6, MenuKt.ClosedAlphaTarget, ResolvedTextDirection.Ltr, false, null);
    L30:
        r6 = Offset.Companion.getUnspecified-F1C5BW0();
        goto L32
    L21:
        if (isCursorHandleInVisibleBounds() == false) goto L23;
    L16:
        r5 = false;
    L23:
        r4 = false;
        goto L24
    L5:
        r2 = false;
        goto L6
    }

    public final Object paste(Continuation<? super Unit> r12) {
        if ((r12 instanceof C02221) == false) goto L7;
        C02221 r0 = (C02221) r12;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r13);
    L32:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ReceiveContentConfiguration r4 = (ReceiveContentConfiguration) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L26:
        ClipEntry r5 = (ClipEntry) r13;
        if (r5 != null) goto L33;
        r0.L$0 = null;
        r0.label = 3;
        if (pasteAsPlainText(r0) != r2) goto L32;
        return r2;
    L33:
        ClipMetadata r6 = r5.getClipMetadata();
        TransferableContent r14 = r4.getReceiveContentListener().onReceive(new TransferableContent(r5, r6, TransferableContent.Source.Companion.m464getClipboardkB6V9T0(), null, 8, null));
        if (r14 == null) goto L41;
        ClipEntry r15 = r14.getClipEntry();
        if (r15 == null) goto L41;
        String r7 = TransferableContent_androidKt.readPlainText(r15);
        if (r7 == null) goto L41;
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, r7, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
    L41:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r13);
    L46:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r13);
        Function0<? extends ReceiveContentConfiguration> r16 = this.receiveContentConfiguration;
        if (r16 == null) goto L42;
        r4 = (ReceiveContentConfiguration) r16.invoke();
        if (r4 == null) goto L42;
        Clipboard r17 = this.clipboard;
        r0.L$0 = r4;
        r0.label = 2;
        r13 = r17.getClipEntry(r0);
        if (r13 != r2) goto L26;
        return r2;
    L42:
        r0.label = 1;
        if (pasteAsPlainText(r0) != r2) goto L46;
        return r2;
    L7:
        r0 = new C02221(this, r12);
        goto L8
    }

    public final void setDirectDragGestureInitiator(InputType r2) {
        this.directDragGestureInitiator$delegate.setValue(r2);
    }

    public final void setDraggingHandle(Handle r2) {
        this.draggingHandle$delegate.setValue(r2);
    }

    public final void setFocused(boolean r1) {
        this.isFocused = r1;
    }

    public final void setInTouchMode(boolean r2) {
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setReceiveContentConfiguration(Function0<? extends ReceiveContentConfiguration> r1) {
        this.receiveContentConfiguration = r1;
    }

    public final void setRequestAutofillAction(Function0<Unit> r1) {
        this.requestAutofillAction = r1;
    }

    public final void setTextToolbarShown$foundation_release(boolean r2) {
        this.textToolbarShown$delegate.setValue(Boolean.valueOf(r2));
    }

    public final Object startToolbarAndHandlesVisibilityObserver(Continuation<? super Unit> r6) {
        if ((r6 instanceof C02251) == false) goto L7;
        C02251 r0 = (C02251) r6;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13
    L21:
        Job r8 = (Job) r7;     // Catch: Throwable -> L13
        setShowCursorHandle(false);
        if (getTextToolbarState() == TextToolbarState.None) goto L26;
        hideTextToolbar();
    L26:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r7);
        C02262 r9 = new C02262(this, null);     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r7 = CoroutineScopeKt.coroutineScope(r9, r0);     // Catch: Throwable -> L13
        if (r7 != r2) goto L21;
        return r2;
    L13:
        th = move-exception;
        setShowCursorHandle(false);
        if (getTextToolbarState() == TextToolbarState.None) goto L30;
        hideTextToolbar();
    L30:
        throw th;
    L7:
        r0 = new C02251(this, r6);
        goto L8
    }

    public final Object updateClipboardEntry(Continuation<? super Unit> r2) {
        Object r3 = this.clipboardPasteState.update(r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public final void updateTextToolbarState(TextToolbarState r1) {
        setTextToolbarState(r1);
    }

    /* JADX INFO: renamed from: access$getHandlePosition-tuRUvjQ, reason: not valid java name */
    public static final /* synthetic */ long m1711access$getHandlePositiontuRUvjQ(TextFieldSelectionState r0, boolean r1) {
        return r0.m1714getHandlePositiontuRUvjQ(r1);
    }

    public static final /* synthetic */ Object access$observeTextChanges(TextFieldSelectionState r0, Continuation r1) {
        return r0.observeTextChanges(r1);
    }

    public static final /* synthetic */ Object access$observeTextToolbarVisibility(TextFieldSelectionState r0, Continuation r1) {
        return r0.observeTextToolbarVisibility(r1);
    }

    public static final /* synthetic */ Object access$pasteAsPlainText(TextFieldSelectionState r0, Continuation r1) {
        return r0.pasteAsPlainText(r1);
    }

    public static final /* synthetic */ void access$setPressInteraction$p(TextFieldSelectionState r0, PressInteraction.Press r1) {
        r0.pressInteraction = r1;
    }

    public static final /* synthetic */ void access$setPreviousRawDragOffset$p(TextFieldSelectionState r0, int r1) {
        r0.previousRawDragOffset = r1;
    }

    public static final /* synthetic */ void access$setShowCursorHandle(TextFieldSelectionState r0, boolean r1) {
        r0.setShowCursorHandle(r1);
    }

    public static final /* synthetic */ void access$setTextToolbarState(TextFieldSelectionState r0, TextToolbarState r1) {
        r0.setTextToolbarState(r1);
    }

    private final Object detectCursorHandleDragGestures(PointerInputScope r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C02161) == false) goto L7;
        C02161 r0 = (C02161) r11;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        C02161 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Ref.LongRef r13 = (Ref.LongRef) r6.L$1;
        Ref.LongRef r4 = (Ref.LongRef) r6.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L23:
        detectCursorHandleDragGestures$onDragStop(r4, r13, this);
        return Unit.INSTANCE;
    L14:
        Throwable th = th;
    L27:
        detectCursorHandleDragGestures$onDragStop(r4, r13, this);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        final Ref.LongRef r14 = new Ref.LongRef();
        Offset.Companion r5 = Offset.Companion;
        r14.element = r5.getUnspecified-F1C5BW0();
        final Ref.LongRef r7 = new Ref.LongRef();
        r7.element = r5.getUnspecified-F1C5BW0();
        Function1 r8 = new e(r14, this, r7);     // Catch: Throwable -> L25
        Function0 r9 = new f(r14, r7, this);     // Catch: Throwable -> L25
        Function0 r15 = new g(r14, r7, this);     // Catch: Throwable -> L25
        Function2 r16 = new h(r7, this, r14);     // Catch: Throwable -> L25
        r6.L$0 = r14;     // Catch: Throwable -> L25
        r6.L$1 = r7;     // Catch: Throwable -> L25
        r6.label = 1;     // Catch: Throwable -> L25
        if (DragGestureDetectorKt.detectDragGestures(r10, r8, r9, r15, r16, r6) != r2) goto L22;
        return r2;
    L22:
        r4 = r14;
        r13 = r7;
    L25:
        th = move-exception;
        r4 = r14;
        th = th;
        r13 = r7;
    L7:
        r0 = new C02161(this, r11);
        goto L8
    }

    private static final String detectSelectionHandleDragGestures$lambda$17(TextFieldSelectionState r2, Handle r3) {
        return "Selection Handle drag cancelled for draggingHandle: " + r2.getDraggingHandle() + " definedOn: " + r3;
    }

    private final Object showTextToolbar(Rect r2, Continuation<? super Unit> r3) {
        if (ComposeFoundationFlags.isNewContextMenuEnabled == false) goto L5;
        this.toolbarRequester.show();
    L13:
        return Unit.INSTANCE;
    L5:
        TextToolbarHandler r0 = this.textToolbarHandler;
        if (r0 == null) goto L13;
        Object r4 = r0.showTextToolbar(this, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        return r4;
    L11:
        return Unit.INSTANCE;
    }

    public final Object copy(boolean r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.Z$0;
        ResultKt.throwOnFailure(r9);
    L21:
        if (r7 == false) goto L23;
        this.textFieldState.collapseSelectionToMax();
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        TextFieldCharSequence r10 = this.textFieldState.getVisualText();
        if (TextRange.getCollapsed-impl(r10.m1535getSelectiond9O1mEE()) == true) goto L17;
        AnnotatedString r4 = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(r10).toString(), null, 2, null);
        Clipboard r11 = this.clipboard;
        ClipEntry r5 = ClipboardUtils_androidKt.toClipEntry(r4);
        r0.Z$0 = r7;
        r0.label = 1;
        if (r11.setClipEntry(r5, r0) != r2) goto L21;
        return r2;
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    public final Object cursorHandleGestures(PointerInputScope r3, Continuation<? super Unit> r4) {
        Object r5 = CoroutineScopeKt.coroutineScope(new AnonymousClass2(this, r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final Object detectTouchMode(PointerInputScope r3, Continuation<? super Unit> r4) {
        Object r5 = r3.awaitPointerEventScope(new C02192(this, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final TextFieldHandleState getSelectionHandleState$foundation_release(boolean r16, boolean r17) {
        if (r16 == false) goto L5;
        Handle r1 = Handle.SelectionStart;
    L6:
        TextLayoutResult r2 = this.textLayoutState.getLayoutResult();
        if (r2 == null) goto L9;
        long r3 = this.textFieldState.getVisualText().m1535getSelectiond9O1mEE();
        if (TextRange.getCollapsed-impl(r3) == true) goto L13;
        long r5 = m1714getHandlePositiontuRUvjQ(r16);
        if (getDirectDragGestureInitiator() == InputType.None) goto L17;
    L26:
        boolean r4 = false;
    L27:
        if (r4 == true) goto L31;
        return TextFieldHandleState.Companion.getHidden();
    L31:
        if (this.textFieldState.getVisualText().shouldShowSelection() == false) goto L33;
        if (r16 == false) goto L36;
        int r6 = TextRange.getStart-impl(r3);
    L37:
        ResolvedTextDirection r12 = r2.getBidiRunDirection(r6);
        boolean r13 = TextRange.getReversed-impl(r3);
        if (r17 == false) goto L44;
        LayoutCoordinates r7 = getTextLayoutCoordinates();
        if (r7 == null) goto L45;
        Rect r8 = SelectionManagerKt.visibleBounds(r7);
        if (r8 == null) goto L45;
        r5 = TextLayoutStateKt.m1666coerceIn3MmeM6k(r5, r8);
    L45:
        long r9 = r5;
        if (r16 == false) goto L48;
        int r10 = TextRange.getStart-impl(r3);
    L50:
        return new TextFieldHandleState(true, r9, TextLayoutHelperKt.getLineHeight(r2, r10), r12, r13, null);
    L48:
        r10 = TextRange.getEnd-impl(r3);
        goto L50
    L44:
        r5 = Offset.Companion.getUnspecified-F1C5BW0();
        goto L45
    L36:
        r6 = Math.max(TextRange.getEnd-impl(r3) - 1, 0);
        goto L37
    L33:
        return TextFieldHandleState.Companion.getHidden();
    L17:
        if (getDraggingHandle() == r1) goto L25;
        LayoutCoordinates r11 = getTextLayoutCoordinates();
        if (r11 == null) goto L23;
        Rect r14 = SelectionManagerKt.visibleBounds(r11);
        if (r14 == null) goto L23;
        boolean r15 = SelectionManagerKt.m1878containsInclusiveUv8p0NA(r14, r5);
    L24:
        if (r15 == false) goto L26;
    L23:
        r15 = false;
    L25:
        r4 = true;
        goto L27
    L13:
        return TextFieldHandleState.Companion.getHidden();
    L9:
        return TextFieldHandleState.Companion.getHidden();
    L5:
        r1 = Handle.SelectionEnd;
        goto L6
    }

    /* JADX INFO: renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m1724updateHandleDraggingUv8p0NA(Handle r1, long r2) {
        setDraggingHandle(r1);
        m1719setRawHandleDragPositionk4lQ0M(r2);
    }

    public static final /* synthetic */ Object access$detectCursorHandleDragGestures(TextFieldSelectionState r0, PointerInputScope r1, Continuation r2) {
        return r0.detectCursorHandleDragGestures(r1, r2);
    }

    public static final /* synthetic */ Object access$showTextToolbar(TextFieldSelectionState r0, Rect r1, Continuation r2) {
        return r0.showTextToolbar(r1, r2);
    }

    private static final Unit detectCursorHandleDragGestures$lambda$10(Ref.LongRef r0, Ref.LongRef r1, TextFieldSelectionState r2) {
        detectCursorHandleDragGestures$onDragStop(r0, r1, r2);
        return Unit.INSTANCE;
    }

    private static final Unit detectCursorHandleDragGestures$lambda$9(Ref.LongRef r0, Ref.LongRef r1, TextFieldSelectionState r2) {
        detectCursorHandleDragGestures$onDragStop(r0, r1, r2);
        return Unit.INSTANCE;
    }

    private static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef r5, Ref.LongRef r6, TextFieldSelectionState r7) {
        if ((r5.element & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        Offset.Companion r1 = Offset.Companion;
        r5.element = r1.getUnspecified-F1C5BW0();
        r6.element = r1.getUnspecified-F1C5BW0();
        r7.clearHandleDragging();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final Object detectSelectionHandleDragGestures(PointerInputScope r19, boolean r20, Continuation<? super Unit> r21) {
        if ((r21 instanceof C02171) == false) goto L7;
        C02171 r1 = (C02171) r21;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        C02171 r13 = r1;
        Object r0 = r13.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r13.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        final Handle r4 = (Handle) r13.L$2;
        Ref.LongRef r5 = (Ref.LongRef) r13.L$1;
        Ref.LongRef r6 = (Ref.LongRef) r13.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
    L35:
        TextFieldSelectionStateKt.access$logDebug(new q(this, r4));
        if (getDraggingHandle() != r4) goto L39;
        detectSelectionHandleDragGestures$onDragStop$12(r6, this, r5);
    L39:
        return Unit.INSTANCE;
    L14:
        th = th;
    L45:
        TextFieldSelectionStateKt.access$logDebug(new q(this, r4));
        if (getDraggingHandle() != r4) goto L48;
        detectSelectionHandleDragGestures$onDragStop$12(r6, this, r5);
    L48:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        final Ref.LongRef r15 = new Ref.LongRef();
        Offset.Companion r7 = Offset.Companion;
        r15.element = r7.getUnspecified-F1C5BW0();
        final Ref.LongRef r12 = new Ref.LongRef();
        r12.element = r7.getZero-F1C5BW0();
        if (r20 == false) goto L21;
        Handle r8 = Handle.SelectionStart;
    L22:
        final Handle r11 = r8;
        boolean r9 = false;
        if (r20 == false) goto L25;
        final boolean r10 = true;
    L51:
        Function1 r16 = new m(r15, this, r10, r11, r12);     // Catch: Throwable -> L42
        Function0 r17 = new n(r15, this, r12);     // Catch: Throwable -> L42
        Function0 r18 = new o(r15, this, r12);     // Catch: Throwable -> L42
        if (r20 == false) goto L29;
        r9 = true;
    L29:
        final boolean r22 = r9;
        Function2 r110 = new p(r12, this, r11, r15, r22);     // Catch: Throwable -> L42
        r13.L$0 = r15;     // Catch: Throwable -> L42
        r13.L$1 = r12;     // Catch: Throwable -> L42
        r13.L$2 = r11;     // Catch: Throwable -> L42
        r13.label = 1;     // Catch: Throwable -> L42
        r4 = r11;
        r5 = r12;
        if (DragGestureDetectorKt.detectDragGestures(r19, r16, r17, r18, r110, r13) != r14) goto L34;
        return r14;
    L34:
        r6 = r15;
    L40:
        th = th;
    L44:
        r6 = r15;
    L42:
        th = th;
        r4 = r11;
        r5 = r12;
        goto L44
    L25:
        r10 = false;
        goto L51
    L21:
        r8 = Handle.SelectionEnd;
    L7:
        r1 = new C02171(this, r21);
        goto L8
    }

    private static final Unit detectSelectionHandleDragGestures$lambda$14(Ref.LongRef r0, TextFieldSelectionState r1, Ref.LongRef r2) {
        detectSelectionHandleDragGestures$onDragStop$12(r0, r1, r2);
        return Unit.INSTANCE;
    }

    private static final Unit detectSelectionHandleDragGestures$lambda$15(Ref.LongRef r0, TextFieldSelectionState r1, Ref.LongRef r2) {
        detectSelectionHandleDragGestures$onDragStop$12(r0, r1, r2);
        return Unit.INSTANCE;
    }

    private static final void detectSelectionHandleDragGestures$onDragStop$12(Ref.LongRef r5, TextFieldSelectionState r6, Ref.LongRef r7) {
        if ((r5.element & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r6.clearHandleDragging();
        Offset.Companion r1 = Offset.Companion;
        r5.element = r1.getUnspecified-F1C5BW0();
        r7.element = r1.getZero-F1C5BW0();
        r6.previousRawDragOffset = -1;
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final Object selectionHandleGestures(PointerInputScope r3, boolean r4, Continuation<? super Unit> r5) {
        Object r6 = CoroutineScopeKt.coroutineScope(new C02242(this, r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final Object textFieldSelectionGestures(PointerInputScope r3, Function0<Unit> r4, Continuation<? super Unit> r5) {
        Object r6 = SelectionGesturesKt.selectionGesturePointerInputBtf2(r3, new TextFieldMouseSelectionObserver(this, r4), new TextFieldTextDragObserver(this, r4), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$detectSelectionHandleDragGestures(TextFieldSelectionState r0, PointerInputScope r1, boolean r2, Continuation r3) {
        return r0.detectSelectionHandleDragGestures(r1, r2, r3);
    }

    private static final Unit detectCursorHandleDragGestures$lambda$8(Ref.LongRef r2, TextFieldSelectionState r3, Ref.LongRef r4, Offset r5) {
        r2.element = SelectionHandlesKt.m1850getAdjustedCoordinatesk4lQ0M(r3.getCursorRect().getBottomCenter-F1C5BW0());
        r4.element = Offset.Companion.getZero-F1C5BW0();
        r3.setInTouchMode(true);
        r3.markStartContentVisibleOffset();
        r3.m1724updateHandleDraggingUv8p0NA(Handle.Cursor, r2.element);
        return Unit.INSTANCE;
    }

    private static final Unit detectTextFieldTapGestures$lambda$5(Function0 r1, TextFieldSelectionState r2, Function0 r3, Offset r4) {
        TextFieldSelectionStateKt.access$logDebug(new d());
        r1.invoke();
        if (r2.enabled == false) goto L16;
        if (r2.isFocused == false) goto L16;
        if (r2.readOnly == true) goto L14;
        r3.invoke();
        if (r2.textFieldState.getVisualText().length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        r2.setShowCursorHandle(true);
        goto L14
    L11:
        r5 = false;
    L14:
        r2.updateTextToolbarState(TextToolbarState.None);
        long r6 = r2.textLayoutState.m1660coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(r4.unbox-impl());
        r2.m1718placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m1667fromDecorationToTextLayoutUv8p0NA(r2.textLayoutState, r6));
    L16:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object copy$default(TextFieldSelectionState r0, boolean r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.copy(r1, r2);
    }

    private static final Unit detectCursorHandleDragGestures$lambda$11(Ref.LongRef r4, TextFieldSelectionState r5, Ref.LongRef r6, PointerInputChange r7, Offset r8) {
        long r0 = Offset.plus-MK-Hz9U(r4.element, r8.unbox-impl());
        r4.element = r0;
        r5.m1724updateHandleDraggingUv8p0NA(Handle.Cursor, Offset.plus-MK-Hz9U(r6.element, r0));
        if (r5.m1718placeCursorAtNearestOffsetk4lQ0M(r5.m1723getHandleDragPositionF1C5BW0()) == false) goto L8;
        r7.consume();
        HapticFeedback r9 = r5.hapticFeedBack;
        if (r9 == null) goto L8;
        r9.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
    L8:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m1717getTextFieldSelectionqeG_v_k(int r10, int r11, TextRange r12, boolean r13, SelectionAdjustment r14) {
        TextLayoutResult r1 = this.textLayoutState.getLayoutResult();
        if (r1 == null) goto L5;
        if (r12 == null) goto L8;
    L11:
        int r4 = this.previousRawDragOffset;
        if (r12 == null) goto L14;
        long r2 = r12.unbox-impl();
    L15:
        long r5 = r2;
        if (r12 != null) goto L18;
        boolean r7 = true;
    L19:
        SelectionLayout r0 = SelectionLayoutKt.m1853getTextFieldSelectionLayoutRcvTLA(r1, r10, r11, r4, r5, r7, r13);
        if (r12 != null) goto L22;
    L25:
        long r3 = r14.adjust(r0).m1845toTextRanged9O1mEE();
        this.previousSelectionLayout = r0;
        if (r13 == true) goto L29;
        r10 = r11;
    L29:
        this.previousRawDragOffset = r10;
        return r3;
    L22:
        if (r0.shouldRecomputeSelection(this.previousSelectionLayout) == true) goto L25;
        return r12.unbox-impl();
    L18:
        r7 = false;
        goto L19
    L14:
        r2 = TextRange.Companion.getZero-d9O1mEE();
        goto L15
    L8:
        if (Intrinsics.areEqual(r14, SelectionAdjustment.Companion.getCharacter()) == false) goto L11;
        return TextRangeKt.TextRange(r10, r11);
    L5:
        return TextRange.Companion.getZero-d9O1mEE();
    }

    public final Object detectTextFieldTapGestures(PointerInputScope r3, MutableInteractionSource r4, final Function0<Unit> r5, final Function0<Unit> r6, Continuation<? super Unit> r7) {
        Object r8 = TapGestureDetectorKt.detectTapAndPress(r3, new C02182(r4, this, null), new j(r5, this, r6), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit detectSelectionHandleDragGestures$lambda$13(Ref.LongRef r2, TextFieldSelectionState r3, boolean r4, Handle r5, Ref.LongRef r6, Offset r7) {
        long r0 = SelectionHandlesKt.m1850getAdjustedCoordinatesk4lQ0M(r3.m1714getHandlePositiontuRUvjQ(r4));
        r2.element = r0;
        r3.m1724updateHandleDraggingUv8p0NA(r5, r0);
        r6.element = Offset.Companion.getZero-F1C5BW0();
        r3.previousRawDragOffset = -1;
        return Unit.INSTANCE;
    }

    private static final Unit detectSelectionHandleDragGestures$lambda$16(Ref.LongRef r13, TextFieldSelectionState r14, Handle r15, Ref.LongRef r16, boolean r17, PointerInputChange r18, Offset r19) {
        r13.element = Offset.plus-MK-Hz9U(r13.element, r19.unbox-impl());
        TextLayoutResult r1 = r14.textLayoutState.getLayoutResult();
        if (r1 == null) goto L5;
        r14.m1724updateHandleDraggingUv8p0NA(r15, Offset.plus-MK-Hz9U(r16.element, r13.element));
        if (r17 == false) goto L9;
        int r0 = r1.getOffsetForPosition-k-4lQ0M(r14.m1723getHandleDragPositionF1C5BW0());
    L10:
        int r2 = r0;
        if (r17 == false) goto L13;
        int r3 = TextRange.getEnd-impl(r14.textFieldState.getVisualText().m1535getSelectiond9O1mEE());
    L14:
        int r4 = r3;
        long r11 = r14.textFieldState.getVisualText().m1535getSelectiond9O1mEE();
        long r5 = m1722updateSelectionSsLRf8$default(r14, r14.textFieldState.getVisualText(), r2, r4, r17, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), false, false, 96, null);
        if (TextRange.getCollapsed-impl(r11) == false) goto L17;
    L18:
        r14.textFieldState.m1679selectCharsIn5zctL8(r5);
    L20:
        return Unit.INSTANCE;
    L17:
        if (TextRange.getCollapsed-impl(r5) == true) goto L20;
    L13:
        r3 = r1.getOffsetForPosition-k-4lQ0M(r14.m1723getHandleDragPositionF1C5BW0());
        goto L14
    L9:
        r0 = TextRange.getStart-impl(r14.textFieldState.getVisualText().m1535getSelectiond9O1mEE());
        goto L10
    L5:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: updateSelection-SsL-Rf8, reason: not valid java name */
    private final long m1721updateSelectionSsLRf8(TextFieldCharSequence r12, int r13, int r14, boolean r15, SelectionAdjustment r16, boolean r17, boolean r18) {
        TextRange r0 = TextRange.box-impl(r12.m1535getSelectiond9O1mEE());
        long r1 = r0.unbox-impl();
        boolean r3 = true;
        if (r18 == true) goto L8;
        if (r17 == false) goto L6;
    L7:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r0 = null;
    L12:
        long r4 = m1717getTextFieldSelectionqeG_v_k(r13, r14, r0, r15, r16);
        if (TextRange.equals-impl0(r4, r12.m1535getSelectiond9O1mEE()) == false) goto L16;
        return r4;
    L16:
        if (TextRange.getReversed-impl(r4) != TextRange.getReversed-impl(r12.m1535getSelectiond9O1mEE())) goto L18;
    L20:
        r3 = false;
    L22:
        if (isInTouchMode() == false) goto L28;
        if (r3 == true) goto L28;
        HapticFeedback r5 = this.hapticFeedBack;
        if (r5 == null) goto L28;
        r5.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
    L28:
        return r4;
    L18:
        if (TextRange.equals-impl0(TextRangeKt.TextRange(TextRange.getEnd-impl(r4), TextRange.getStart-impl(r4)), r12.m1535getSelectiond9O1mEE()) == false) goto L20;
    L6:
        if (TextRange.getCollapsed-impl(r1) == false) goto L7;
    L8:
        r2 = false;
        goto L9
    }

    public final void update(HapticFeedback r1, Clipboard r2, TextToolbarHandler r3, Density r4, boolean r5, boolean r6, boolean r7) {
        if (r5 == true) goto L4;
        hideTextToolbar();
    L4:
        this.hapticFeedBack = r1;
        this.clipboard = r2;
        this.textToolbarHandler = r3;
        this.density = r4;
        this.enabled = r5;
        this.readOnly = r6;
        this.isPassword = r7;
    }

    /* JADX INFO: renamed from: access$updateSelection-SsL-Rf8, reason: not valid java name */
    public static final /* synthetic */ long m1712access$updateSelectionSsLRf8(TextFieldSelectionState r0, TextFieldCharSequence r1, int r2, int r3, boolean r4, SelectionAdjustment r5, boolean r6, boolean r7) {
        return r0.m1721updateSelectionSsLRf8(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: updateSelection-SsL-Rf8$default, reason: not valid java name */
    public static /* synthetic */ long m1722updateSelectionSsLRf8$default(TextFieldSelectionState r10, TextFieldCharSequence r11, int r12, int r13, boolean r14, SelectionAdjustment r15, boolean r16, boolean r17, int r18, Object r19) {
        if ((r18 & 32) == 0) goto L5;
        boolean r8 = false;
    L7:
        if ((r18 & 64) == 0) goto L9;
        boolean r9 = false;
    L11:
        return r10.m1721updateSelectionSsLRf8(r11, r12, r13, r14, r15, r8, r9);
    L9:
        r9 = r17;
        goto L11
    L5:
        r8 = r16;
        goto L7
    }

    public TextFieldSelectionState(TransformedTextFieldState r1, TextLayoutState r2, Density r3, boolean r4, boolean r5, boolean r6, boolean r7, ToolbarRequester r8, CoroutineScope r9, PlatformSelectionBehaviors r10, Clipboard r11) {
        this.textFieldState = r1;
        this.textLayoutState = r2;
        this.density = r3;
        this.enabled = r4;
        this.readOnly = r5;
        this.isFocused = r6;
        this.isPassword = r7;
        this.toolbarRequester = r8;
        this.coroutineScope = r9;
        this.platformSelectionBehaviors = r10;
        this.clipboard = r11;
        this.isInTouchMode$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        Offset.Companion r12 = Offset.Companion;
        this.startTextLayoutPositionInWindow$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(r12.getUnspecified-F1C5BW0()), null, 2, null);
        this.rawHandleDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(r12.getUnspecified-F1C5BW0()), null, 2, null);
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.directDragGestureInitiator$delegate = SnapshotStateKt.mutableStateOf$default(InputType.None, null, 2, null);
        Boolean r13 = Boolean.FALSE;
        this.showCursorHandle$delegate = SnapshotStateKt.mutableStateOf$default(r13, null, 2, null);
        this.textToolbarState$delegate = SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
        this.textToolbarShown$delegate = SnapshotStateKt.mutableStateOf$default(r13, null, 2, null);
        this.previousRawDragOffset = -1;
        this.derivedVisibleContentBounds$delegate = SnapshotStateKt.derivedStateOf(new i(this));
        this.clipboardPasteState = new ClipboardPasteState(this.clipboard);
    }
}
