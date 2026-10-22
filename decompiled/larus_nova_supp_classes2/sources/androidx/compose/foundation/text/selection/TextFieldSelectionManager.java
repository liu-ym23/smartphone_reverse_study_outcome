package androidx.compose.foundation.text.selection;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u009c\u0001\u001a\u00020\u00112\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010hH\u0002¢\u0006\u0003\b\u009e\u0001J\u0019\u0010\u009f\u0001\u001a\u00030\u0095\u00012\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¡\u0001J\u0010\u0010¢\u0001\u001a\u00030\u0095\u0001H\u0000¢\u0006\u0003\b£\u0001J\u001a\u0010¤\u0001\u001a\u00020\u00112\t\b\u0002\u0010¥\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¦\u0001J\u000f\u0010§\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b¨\u0001J\u001c\u0010©\u0001\u001a\u00020\u00112\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010eH\u0000¢\u0006\u0003\b«\u0001J\u001b\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020hH\u0000¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u001b\u0010°\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020hH\u0000¢\u0006\u0006\b±\u0001\u0010¯\u0001J\u000f\u0010²\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b³\u0001J\u000f\u0010½\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¾\u0001J\u0013\u0010¿\u0001\u001a\u00020\u0011H\u0080@¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0010\u0010Â\u0001\u001a\u00020\u0011H\u0082@¢\u0006\u0003\u0010Á\u0001J\u000f\u0010Ã\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÄ\u0001J\u000f\u0010Å\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÆ\u0001J\u000f\u0010Ç\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÈ\u0001J\u000f\u0010É\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÊ\u0001J\u001d\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u00012\t\b\u0002\u0010Í\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÎ\u0001J\u0012\u0010Ï\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0000¢\u0006\u0003\bÐ\u0001J\u0012\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0000¢\u0006\u0003\bÒ\u0001J\u000f\u0010Ó\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bÔ\u0001J\u000f\u0010Õ\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bÖ\u0001J\u001b\u0010×\u0001\u001a\u00020e2\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J\u0019\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÜ\u0001J\u001c\u0010Ý\u0001\u001a\u00020e2\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0000¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0012\u0010â\u0001\u001a\u00020\u00112\u0007\u0010ã\u0001\u001a\u00020XH\u0002J\u000f\u0010ä\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bå\u0001J\f\u0010æ\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0002J\u000f\u0010ç\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bè\u0001J\u0019\u0010é\u0001\u001a\u00020\u00112\u0007\u0010ª\u0001\u001a\u00020e¢\u0006\u0006\bê\u0001\u0010¯\u0001J\u000f\u0010ë\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bì\u0001J\n\u0010í\u0001\u001a\u00030î\u0001H\u0002JH\u0010ï\u0001\u001a\u00020h2\u0006\u0010\u001e\u001a\u00020\u00102\u0007\u0010ð\u0001\u001a\u00020e2\u0007\u0010ñ\u0001\u001a\u00020X2\u0007\u0010 \u0001\u001a\u00020X2\b\u0010ò\u0001\u001a\u00030ó\u00012\u0007\u0010ô\u0001\u001a\u00020XH\u0002¢\u0006\u0006\bõ\u0001\u0010ö\u0001J\u0013\u0010÷\u0001\u001a\u00020\u00112\b\u0010ø\u0001\u001a\u00030ù\u0001H\u0002J$\u0010ú\u0001\u001a\u00020\u00102\u0007\u0010û\u0001\u001a\u00020$2\u0007\u0010\u009d\u0001\u001a\u00020hH\u0002¢\u0006\u0006\bü\u0001\u0010ý\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00108@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR+\u0010Y\u001a\u00020X2\u0006\u0010W\u001a\u00020X8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R+\u0010`\u001a\u00020X2\u0006\u0010W\u001a\u00020X8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010_\u001a\u0004\ba\u0010[\"\u0004\bb\u0010]R\u0010\u0010d\u001a\u00020eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u00020eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR/\u0010k\u001a\u0004\u0018\u00010j2\b\u0010W\u001a\u0004\u0018\u00010j8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bp\u0010_\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR/\u0010q\u001a\u0004\u0018\u00010e2\b\u0010W\u001a\u0004\u0018\u00010e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bv\u0010_\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u000e\u0010w\u001a\u00020xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010|\u001a\u0004\u0018\u00010hX\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R7\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\t\u0010W\u001a\u0005\u0018\u00010\u0081\u00018B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0005\b\u0087\u0001\u0010_\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R,\u0010\u0088\u0001\u001a\u00030\u0089\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u001a\n\u0000\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0015\u0010\u0090\u0001\u001a\u00030\u0091\u00018F¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0099\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001d\u0010´\u0001\u001a\u00020XX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010[\"\u0005\b¶\u0001\u0010]R\u001e\u0010·\u0001\u001a\u00020X8@X\u0080\u0004¢\u0006\u000f\u0012\u0006\b¸\u0001\u0010\u008b\u0001\u001a\u0005\b¹\u0001\u0010[R\u0016\u0010º\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bº\u0001\u0010[R\u0016\u0010»\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010[¨\u0006þ\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/UndoManager;)V", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "onValueChange", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "requestAutofillAction", "Lkotlin/Function0;", "getRequestAutofillAction$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "getClipboard$foundation_release", "()Landroidx/compose/ui/platform/Clipboard;", "setClipboard$foundation_release", "(Landroidx/compose/ui/platform/Clipboard;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation_release", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviors$foundation_release", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "setPlatformSelectionBehaviors$foundation_release", "(Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "Landroidx/compose/runtime/MutableState;", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragBeginSelection", "Landroidx/compose/ui/text/TextRange;", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "previousRawDragOffset", "", "oldValue", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "latestSelection", "getLatestSelection-MzsxiRA$foundation_release", "()Landroidx/compose/ui/text/TextRange;", "setLatestSelection-OEnZFl4$foundation_release", "(Landroidx/compose/ui/text/TextRange;)V", "Landroidx/compose/ui/platform/ClipEntry;", "clipEntry", "getClipEntry", "()Landroidx/compose/ui/platform/ClipEntry;", "setClipEntry", "(Landroidx/compose/ui/platform/ClipEntry;)V", "clipEntry$delegate", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "getToolbarRequester$foundation_release$annotations", "()V", "getToolbarRequester$foundation_release", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setToolbarRequester$foundation_release", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "contextMenuAreaModifier", "Landroidx/compose/ui/Modifier;", "getContextMenuAreaModifier", "()Landroidx/compose/ui/Modifier;", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "maybeSuggestSelection", "selection", "maybeSuggestSelection-OEnZFl4", "handleDragObserver", "isStartHandle", "handleDragObserver$foundation_release", "cursorDragObserver", "cursorDragObserver$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "deselect", "position", "deselect-_kEHs6E$foundation_release", "setSelectionPreviewHighlight", "range", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "(J)V", "setDeletionPreviewHighlight", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "clearPreviewHighlight", "clearPreviewHighlight$foundation_release", "textToolbarShownViaProvider", "getTextToolbarShownViaProvider$foundation_release", "setTextToolbarShownViaProvider$foundation_release", "textToolbarShown", "getTextToolbarShown$foundation_release$annotations", "getTextToolbarShown$foundation_release", "isPassword", "hasSelection", "getHasSelection", "canCopy", "canCopy$foundation_release", "updateClipboardEntry", "updateClipboardEntry$foundation_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyPlatformSelectionBehaviorsOnShowContextMenu", "canPaste", "canPaste$foundation_release", "canCut", "canCut$foundation_release", "canSelectAll", "canSelectAll$foundation_release", "canAutofill", "canAutofill$foundation_release", "copy", "Lkotlinx/coroutines/Job;", "cancelSelection", "copy$foundation_release", "paste", "paste$foundation_release", "cut", "cut$foundation_release", "selectAll", "selectAll$foundation_release", "autofill", "autofill$foundation_release", "getHandlePosition", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "getHandleLineHeight", "", "getHandleLineHeight$foundation_release", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "updateFloatingToolbar", "show", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "showSelectionToolbarViaTextToolbar", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "isTextChanged", "isTextChanged$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "createTextFieldValue", "annotatedString", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private final MutableState clipEntry$delegate;
    private Clipboard clipboard;
    private CoroutineScope coroutineScope;
    private final MutableState currentDragPosition$delegate;
    private long dragBeginPosition;
    private TextRange dragBeginSelection;
    private long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private final MutableState enabled$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private TextRange latestSelection;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private Function0<Unit> requestAutofillAction;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private boolean textToolbarShownViaProvider;
    private ToolbarRequester toolbarRequester;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState<TextFieldValue> valueState;
    private VisualTransformation visualTransformation;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager", f = "TextFieldSelectionManager.kt", i = {}, l = {783}, m = "notifyPlatformSelectionBehaviorsOnShowContextMenu", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TextFieldSelectionManager this$0;

        public AnonymousClass1(TextFieldSelectionManager r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TextFieldSelectionManager.access$notifyPlatformSelectionBehaviorsOnShowContextMenu(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1", f = "TextFieldSelectionManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {992}, m = "invokeSuspend", n = {"this_$iv", "previousSnapshot$iv", "observer$iv", "newSnapshot$iv", "copy", "cut"}, s = {"L$0", "L$2", "L$3", "L$4", "L$5", "L$6"})
    public static final class C02371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ TextFieldSelectionManager this$0;

        public C02371(TextFieldSelectionManager r1, Continuation<? super C02371> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public static /* synthetic */ Unit a(TextFieldSelectionManager r0) {
            return invokeSuspend$lambda$5$lambda$0(r0);
        }

        public static /* synthetic */ Unit c(TextFieldSelectionManager r0) {
            return invokeSuspend$lambda$5$lambda$1(r0);
        }

        public static /* synthetic */ Unit e(TextFieldSelectionManager r0) {
            return invokeSuspend$lambda$5$lambda$4(r0);
        }

        public static /* synthetic */ Unit g(TextFieldSelectionManager r0) {
            return invokeSuspend$lambda$5$lambda$2(r0);
        }

        public static /* synthetic */ Unit j(TextFieldSelectionManager r0) {
            return invokeSuspend$lambda$5$lambda$3(r0);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02371(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final Unit invokeSuspend$lambda$5$lambda$0(TextFieldSelectionManager r6) {
            CoroutineScope r0 = r6.getCoroutineScope$foundation_release();
            if (r0 == null) goto L5;
            BuildersKt.launch$default(r0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$copy$1$1(r6, null), 1, null);
        L5:
            r6.hideSelectionToolbar$foundation_release();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$5$lambda$1(TextFieldSelectionManager r6) {
            CoroutineScope r0 = r6.getCoroutineScope$foundation_release();
            if (r0 == null) goto L5;
            BuildersKt.launch$default(r0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$cut$1$1(r6, null), 1, null);
        L5:
            r6.hideSelectionToolbar$foundation_release();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$5$lambda$2(TextFieldSelectionManager r6) {
            CoroutineScope r0 = r6.getCoroutineScope$foundation_release();
            if (r0 == null) goto L5;
            BuildersKt.launch$default(r0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$paste$1$1(r6, null), 1, null);
        L5:
            r6.hideSelectionToolbar$foundation_release();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$5$lambda$3(TextFieldSelectionManager r0) {
            r0.selectAll$foundation_release();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$5$lambda$4(TextFieldSelectionManager r0) {
            r0.autofill$foundation_release();
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend(Object r19) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            Function0 r4 = null;
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L11;
            Function0 r1 = (Function0) this.L$6;
            Function0 r3 = (Function0) this.L$5;
            Snapshot r5 = (Snapshot) this.L$4;
            Function1 r6 = (Function1) this.L$3;
            Snapshot r7 = (Snapshot) this.L$2;
            final TextFieldSelectionManager r8 = (TextFieldSelectionManager) this.L$1;
            Snapshot.Companion r9 = (Snapshot.Companion) this.L$0;
            ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L8
            Function0 r15 = r1;
            Function0 r13 = r3;
        L30:
            if (r8.canPaste$foundation_release() == false) goto L32;
            Function0 r14 = new b2(r8);     // Catch: Throwable -> L8
        L34:
            if (r8.canSelectAll$foundation_release() == false) goto L36;
            Function0 r16 = new c2(r8);     // Catch: Throwable -> L8
        L38:
            if (r8.canAutofill$foundation_release() == false) goto L40;
            r4 = new d2(r8);     // Catch: Throwable -> L8
        L40:
            Function0 r17 = r4;
            TextToolbar r11 = r8.getTextToolbar();     // Catch: Throwable -> L8
            if (r11 == null) goto L43;
            r11.showMenu(TextFieldSelectionManager.access$getContentRect(r8), r13, r14, r15, r16, r17);     // Catch: Throwable -> L8
        L43:
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8
            r9.restoreNonObservable(r7, r5, r6);
            return Unit.INSTANCE;
        L36:
            r16 = null;
            goto L38
        L32:
            r14 = null;
        L8:
            th = th;
        L48:
            r9.restoreNonObservable(r7, r5, r6);
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r19);
            r9 = Snapshot.Companion;
            r8 = this.this$0;
            r7 = r9.getCurrentThreadSnapshot();
            if (r7 == null) goto L15;
            r6 = r7.getReadObserver();
        L16:
            Snapshot r12 = r9.makeCurrentNonObservable(r7);
        L46:
            th = th;
            r5 = r12;
            goto L48
        L18:
            if (r8.canCopy$foundation_release() == false) goto L20;
            Function0 r18 = new z1(r8);     // Catch: Throwable -> L46
        L22:
            if (r8.canCut$foundation_release() == false) goto L24;
            Function0 r110 = new a2(r8);     // Catch: Throwable -> L46
        L25:
            this.L$0 = r9;     // Catch: Throwable -> L46
            this.L$1 = r8;     // Catch: Throwable -> L46
            this.L$2 = r7;     // Catch: Throwable -> L46
            this.L$3 = r6;     // Catch: Throwable -> L46
            this.L$4 = r12;     // Catch: Throwable -> L46
            this.L$5 = r18;     // Catch: Throwable -> L46
            this.L$6 = r110;     // Catch: Throwable -> L46
            this.label = 1;     // Catch: Throwable -> L46
            if (r8.updateClipboardEntry$foundation_release(this) != r0) goto L28;
            return r0;
        L28:
            r5 = r12;
            r13 = r18;
            r15 = r110;
            goto L30
        L24:
            r110 = null;
            goto L25
        L20:
            r18 = null;
            goto L22
        L15:
            r6 = null;
            goto L16
        }
    }

    public TextFieldSelectionManager() {
        UndoManager r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ Unit a(TextFieldValue r0) {
        return onValueChange$lambda$0(r0);
    }

    public static /* synthetic */ Rect b(TextFieldSelectionManager r0, LayoutCoordinates r1) {
        return _get_contextMenuAreaModifier_$lambda$1(r0, r1);
    }

    public static /* synthetic */ void getTextToolbarShown$foundation_release$annotations() {
    }

    public static /* synthetic */ void getToolbarRequester$foundation_release$annotations() {
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    private final ClipEntry getClipEntry() {
        return (ClipEntry) this.clipEntry$delegate.getValue();
    }

    private final Rect getContentRect() {
        LegacyTextFieldState r1 = this.state;
        if (r1 == null) goto L51;
        if ((!r1.isLayoutResultStale()) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L51;
        int r2 = this.offsetMapping.originalToTransformed(TextRange.getStart-impl(getValue$foundation_release().getSelection-d9O1mEE()));
        int r4 = this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(getValue$foundation_release().getSelection-d9O1mEE()));
        LegacyTextFieldState r5 = this.state;
        if (r5 == null) goto L14;
        LayoutCoordinates r6 = r5.getLayoutCoordinates();
        if (r6 == null) goto L14;
        long r7 = r6.localToRoot-MK-Hz9U(m1903getHandlePositiontuRUvjQ$foundation_release(true));
    L15:
        LegacyTextFieldState r3 = this.state;
        if (r3 == null) goto L20;
        LayoutCoordinates r8 = r3.getLayoutCoordinates();
        if (r8 == null) goto L20;
        long r9 = r8.localToRoot-MK-Hz9U(m1903getHandlePositiontuRUvjQ$foundation_release(false));
    L21:
        LegacyTextFieldState r10 = this.state;
        float r12 = MenuKt.ClosedAlphaTarget;
        if (r10 == null) goto L34;
        LayoutCoordinates r11 = r10.getLayoutCoordinates();
        if (r11 == null) goto L34;
        TextLayoutResultProxy r13 = r1.getLayoutResult();
        if (r13 == null) goto L32;
        TextLayoutResult r14 = r13.getValue();
        if (r14 == null) goto L32;
        Rect r15 = r14.getCursorRect(r2);
        if (r15 == null) goto L32;
        float r16 = r15.getTop();
    L33:
        long r17 = Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget);
        float r18 = Float.intBitsToFloat((int) (r11.localToRoot-MK-Hz9U(Offset.constructor-impl((((long) Float.floatToRawIntBits(r16)) & 4294967295L) | (r17 << 32))) & 4294967295L));
    L35:
        LegacyTextFieldState r19 = this.state;
        if (r19 == null) goto L48;
        LayoutCoordinates r20 = r19.getLayoutCoordinates();
        if (r20 == null) goto L48;
        TextLayoutResultProxy r21 = r1.getLayoutResult();
        if (r21 == null) goto L46;
        TextLayoutResult r22 = r21.getValue();
        if (r22 == null) goto L46;
        Rect r23 = r22.getCursorRect(r4);
        if (r23 == null) goto L46;
        float r24 = r23.getTop();
    L47:
        r12 = Float.intBitsToFloat((int) (r20.localToRoot-MK-Hz9U(Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r24)) & 4294967295L))) & 4294967295L));
    L46:
        r24 = MenuKt.ClosedAlphaTarget;
    L48:
        int r25 = (int) (r7 >> 32);
        int r26 = (int) (r9 >> 32);
        return new Rect(Math.min(Float.intBitsToFloat(r25), Float.intBitsToFloat(r26)), Math.min(r18, r12), Math.max(Float.intBitsToFloat(r25), Float.intBitsToFloat(r26)), Math.max(Float.intBitsToFloat((int) (r7 & 4294967295L)), Float.intBitsToFloat((int) (r9 & 4294967295L))) + (Dp.constructor-impl(25) * r1.getTextDelegate().getDensity().getDensity()));
    L32:
        r16 = MenuKt.ClosedAlphaTarget;
    L34:
        r18 = MenuKt.ClosedAlphaTarget;
    L20:
        r9 = Offset.Companion.getZero-F1C5BW0();
    L14:
        r7 = Offset.Companion.getZero-F1C5BW0();
    L51:
        return Rect.Companion.getZero();
    }

    private final boolean isPassword() {
        return this.visualTransformation instanceof PasswordVisualTransformation;
    }

    private final Job showSelectionToolbarViaTextToolbar() {
        CoroutineScope r0 = this.coroutineScope;
        if (r0 != null) goto L5;
        return null;
    L5:
        return BuildersKt.launch$default(r0, null, CoroutineStart.UNDISPATCHED, new C02371(this, null), 1, null);
    }

    public final void autofill$foundation_release() {
        Function0<Unit> r0 = this.requestAutofillAction;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L5;
        r0.m1392setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.getZero-d9O1mEE());
    L5:
        LegacyTextFieldState r1 = this.state;
        if (r1 == null) goto L9;
        r1.m1395setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.getZero-d9O1mEE());
        return;
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextFieldSelectionManager$cursorDragObserver$1(this);
    }

    public final Job cut$foundation_release() {
        CoroutineScope r0 = this.coroutineScope;
        if (r0 != null) goto L5;
        return null;
    L5:
        return BuildersKt.launch$default(r0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$cut$1(this, null), 1, null);
    }

    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m1901getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final boolean getEnabled() {
        return ((Boolean) this.enabled$delegate.getValue()).booleanValue();
    }

    public final boolean getTextToolbarShown$foundation_release() {
        if (ComposeFoundationFlags.isNewContextMenuEnabled == true) goto L14;
        TextToolbar r0 = this.textToolbar;
        if (r0 == null) goto L8;
        TextToolbarStatus r1 = r0.getStatus();
    L10:
        if (r1 != TextToolbarStatus.Shown) goto L12;
        return true;
    L12:
        return false;
    L8:
        r1 = null;
        goto L10
    L14:
        return this.textToolbarShownViaProvider;
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L7;
        TextDelegate r1 = r0.getTextDelegate();
        if (r1 == null) goto L7;
        return r1.getText();
    L7:
        return null;
    }

    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.valueState.getValue();
    }

    public final void hideSelectionToolbar$foundation_release() {
        if (ComposeFoundationFlags.isNewContextMenuEnabled == false) goto L5;
        this.toolbarRequester.hide();
        return;
    L5:
        TextToolbar r0 = this.textToolbar;
        if (r0 == null) goto L8;
        TextToolbarStatus r1 = r0.getStatus();
    L10:
        if (r1 != TextToolbarStatus.Shown) goto L16;
        TextToolbar r2 = this.textToolbar;
        if (r2 == null) goto L17;
        r2.hide();
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L10
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    public final Job paste$foundation_release() {
        CoroutineScope r0 = this.coroutineScope;
        if (r0 != null) goto L5;
        return null;
    L5:
        return BuildersKt.launch$default(r0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$paste$1(this, null), 1, null);
    }

    public final void showSelectionToolbar$foundation_release() {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
    L24:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L8:
        if (getEnabled() == false) goto L22;
        LegacyTextFieldState r4 = this.state;     // Catch: Throwable -> L24
        boolean r5 = false;
        if (r4 != null) goto L12;
    L14:
        if (r5 == true) goto L22;
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r0.restoreNonObservable(r1, r3, r2);
        if (ComposeFoundationFlags.isNewContextMenuEnabled == false) goto L20;
        this.toolbarRequester.show();
        return;
    L20:
        showSelectionToolbarViaTextToolbar();
        return;
    L12:
        if (r4.isInTouchMode() == true) goto L14;
        r5 = true;
    L22:
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final boolean getHasSelection() {
        return !TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE());
    }

    public final boolean canAutofill$foundation_release() {
        if (getEditable() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE()) == false) goto L7;
        return true;
    }

    public final boolean canCopy$foundation_release() {
        if (getHasSelection() == true) goto L5;
    L7:
        return false;
    L5:
        if (isPassword() == true) goto L7;
        return true;
    }

    public final boolean canCut$foundation_release() {
        if (getHasSelection() == true) goto L5;
    L9:
        return false;
    L5:
        if (getEditable() == false) goto L9;
        if (isPassword() == true) goto L9;
        return true;
    }

    public final boolean canPaste$foundation_release() {
        if (getEditable() == false) goto L13;
        ClipEntry r0 = getClipEntry();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (ClipboardUtils_androidKt.hasText(r0) != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public final boolean canSelectAll$foundation_release() {
        if (TextRange.getLength-impl(getValue$foundation_release().getSelection-d9O1mEE()) == getValue$foundation_release().getText().length()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Modifier getContextMenuAreaModifier() {
        if (getEnabled() == true) goto L6;
        return Modifier.Companion;
    L6:
        return TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler(TextContextMenuGesturesModifierKt.textContextMenuGestures(Modifier.Companion, new TextFieldSelectionManager$contextMenuAreaModifier$1(this, null)), this.toolbarRequester, new TextFieldSelectionManager$contextMenuAreaModifier$2(this, null), new TextFieldSelectionManager$contextMenuAreaModifier$3(this, null), new y1(this));
    }

    public final void selectAll$foundation_release() {
        TextFieldValue r0 = m1895createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(r0);
        this.latestSelection = TextRange.box-impl(r0.getSelection-d9O1mEE());
        this.oldValue = TextFieldValue.copy-3r_uNRQ$default(this.oldValue, null, r0.getSelection-d9O1mEE(), null, 5, null);
        enterSelectionMode$foundation_release(true);
    }

    public final Clipboard getClipboard$foundation_release() {
        return this.clipboard;
    }

    public final CoroutineScope getCoroutineScope$foundation_release() {
        return this.coroutineScope;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    /* JADX INFO: renamed from: getLatestSelection-MzsxiRA$foundation_release, reason: not valid java name */
    public final TextRange m1904getLatestSelectionMzsxiRA$foundation_release() {
        return this.latestSelection;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors$foundation_release() {
        return this.platformSelectionBehaviors;
    }

    public final Function0<Unit> getRequestAutofillAction$foundation_release() {
        return this.requestAutofillAction;
    }

    public final LegacyTextFieldState getState$foundation_release() {
        return this.state;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final boolean getTextToolbarShownViaProvider$foundation_release() {
        return this.textToolbarShownViaProvider;
    }

    public final ToolbarRequester getToolbarRequester$foundation_release() {
        return this.toolbarRequester;
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    public TextFieldSelectionManager(UndoManager r10) {
        this.undoManager = r10;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new x1();
        this.valueState = SnapshotStateKt.mutableStateOf$default(new TextFieldValue(null, 0, null, 7, null), null, 2, null);
        this.visualTransformation = VisualTransformation.Companion.getNone();
        Boolean r11 = Boolean.TRUE;
        this.editable$delegate = SnapshotStateKt.mutableStateOf$default(r11, null, 2, null);
        this.enabled$delegate = SnapshotStateKt.mutableStateOf$default(r11, null, 2, null);
        Offset.Companion r12 = Offset.Companion;
        this.dragBeginPosition = r12.getZero-F1C5BW0();
        this.dragTotalDistance = r12.getZero-F1C5BW0();
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue(null, 0, null, 7, null);
        this.clipEntry$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.toolbarRequester = new ToolbarRequesterImpl();
        this.touchSelectionObserver = new TextFieldSelectionManager$touchSelectionObserver$1(this);
        this.mouseSelectionObserver = new TextFieldSelectionManager$mouseSelectionObserver$1(this);
    }

    public static final /* synthetic */ Rect access$getContentRect(TextFieldSelectionManager r0) {
        return r0.getContentRect();
    }

    public static final /* synthetic */ long access$getDragBeginPosition$p(TextFieldSelectionManager r2) {
        return r2.dragBeginPosition;
    }

    public static final /* synthetic */ TextRange access$getDragBeginSelection$p(TextFieldSelectionManager r0) {
        return r0.dragBeginSelection;
    }

    public static final /* synthetic */ long access$getDragTotalDistance$p(TextFieldSelectionManager r2) {
        return r2.dragTotalDistance;
    }

    /* JADX INFO: renamed from: maybeSuggestSelection-OEnZFl4, reason: not valid java name */
    private final void m1897maybeSuggestSelectionOEnZFl4(TextRange r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        PlatformSelectionBehaviors r1 = this.platformSelectionBehaviors;
        if (r1 != null) goto L7;
        return;
    L7:
        AnnotatedString r0 = getTransformedText$foundation_release();
        if (r0 == null) goto L23;
        String r2 = r0.getText();
        if (r2 == null) goto L27;
        OffsetMapping r7 = this.offsetMapping;
        long r3 = TextRangeKt.TextRange(r7.originalToTransformed(TextRange.getStart-impl(r15.unbox-impl())), r7.originalToTransformed(TextRange.getEnd-impl(r15.unbox-impl())));
        if (r2.length() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L18;
        return;
    L18:
        if (TextRange.getCollapsed-impl(r3) == true) goto L25;
        CoroutineScope r9 = this.coroutineScope;
        if (r9 == null) goto L26;
        BuildersKt.launch$default(r9, null, null, new TextFieldSelectionManager$maybeSuggestSelection$1(r1, r2, r3, r15, this, r7, null), 3, null);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r4 = false;
        goto L16
    L27:
        return;
    }

    private final Object notifyPlatformSelectionBehaviorsOnShowContextMenu(Continuation<? super Unit> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L26:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        AnnotatedString r11 = getTransformedText$foundation_release();
        if (r11 == null) goto L26;
        String r12 = r11.getText();
        if (r12 == null) goto L26;
        TextRange r4 = this.latestSelection;
        if (r4 == null) goto L26;
        long r5 = r4.unbox-impl();
        PlatformSelectionBehaviors r6 = this.platformSelectionBehaviors;
        if (r6 == null) goto L26;
        long r7 = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.getStart-impl(r5)), this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(r5)));
        r0.label = 1;
        if (r6.mo1836onShowContextMenuSbBc2M(r12, r7, r0) != r2) goto L26;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    private static final Unit onValueChange$lambda$0(TextFieldValue r0) {
        return Unit.INSTANCE;
    }

    private final void setClipEntry(ClipEntry r2) {
        this.clipEntry$delegate.setValue(r2);
    }

    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    private final void m1898setCurrentDragPosition_kEHs6E(Offset r2) {
        this.currentDragPosition$delegate.setValue(r2);
    }

    private final void setDraggingHandle(Handle r2) {
        this.draggingHandle$delegate.setValue(r2);
    }

    private final void setHandleState(HandleState r3) {
        LegacyTextFieldState r0 = this.state;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getHandleState() != r3) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        r0.setHandleState(r3);
        return;
    L15:
        return;
    L7:
        r1 = false;
        goto L8
    }

    private final void updateFloatingToolbar(boolean r2) {
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L5;
        r0.setShowFloatingToolbar(r2);
    L5:
        if (r2 == false) goto L7;
        showSelectionToolbar$foundation_release();
        return;
    L7:
        hideSelectionToolbar$foundation_release();
    }

    public final Job copy$foundation_release(boolean r7) {
        CoroutineScope r0 = this.coroutineScope;
        if (r0 != null) goto L5;
        return null;
    L5:
        return BuildersKt.launch$default(r0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$copy$1(this, r7, null), 1, null);
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m1900deselect_kEHs6E$foundation_release(Offset r9) {
        if (TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE()) == true) goto L15;
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L7;
        TextLayoutResultProxy r1 = r0.getLayoutResult();
    L8:
        TextLayoutResultProxy r2 = r1;
        if (r9 == null) goto L12;
        if (r2 == null) goto L12;
        int r3 = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1480getOffsetForPosition3MmeM6k$default(r2, r9.unbox-impl(), false, 2, null));
    L13:
        TextFieldValue r4 = TextFieldValue.copy-3r_uNRQ$default(getValue$foundation_release(), null, TextRangeKt.TextRange(r3), null, 5, null);
        this.onValueChange.invoke(r4);
        this.latestSelection = TextRange.box-impl(r4.getSelection-d9O1mEE());
    L12:
        r3 = TextRange.getMax-impl(getValue$foundation_release().getSelection-d9O1mEE());
        goto L13
    L7:
        r1 = null;
    L15:
        if (r9 != null) goto L17;
    L22:
        HandleState r10 = HandleState.None;
    L23:
        setHandleState(r10);
        updateFloatingToolbar(false);
        return;
    L17:
        if (getValue$foundation_release().getText().length() <= 0) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L22;
        r10 = HandleState.Cursor;
        goto L23
    L19:
        r11 = false;
        goto L20
    }

    public final void enterSelectionMode$foundation_release(boolean r5) {
        LegacyTextFieldState r0 = this.state;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        FocusRequester r2 = this.focusRequester;
        if (r2 == null) goto L12;
        FocusRequester.requestFocus-3ESFkO8$default(r2, 0, 1, null);
    L12:
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(r5);
        setHandleState(HandleState.Selection);
        return;
    L5:
        if (r0.getHasFocus() == true) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX INFO: renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1902getCursorPositiontuRUvjQ$foundation_release(Density r7) {
        int r0 = this.offsetMapping.originalToTransformed(TextRange.getStart-impl(getValue$foundation_release().getSelection-d9O1mEE()));
        LegacyTextFieldState r1 = this.state;
        if (r1 == null) goto L5;
        TextLayoutResultProxy r2 = r1.getLayoutResult();
    L6:
        Intrinsics.checkNotNull(r2);
        TextLayoutResult r3 = r2.getValue();
        Rect r4 = r3.getCursorRect(RangesKt.coerceIn(r0, 0, r3.getLayoutInput().getText().length()));
        float r5 = r4.getLeft() + (r7.toPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness()) / 2);
        float r8 = r4.getBottom();
        return Offset.constructor-impl((Float.floatToRawIntBits(r5) << 32) | (((long) Float.floatToRawIntBits(r8)) & 4294967295L));
    L5:
        r2 = null;
        goto L6
    }

    public final float getHandleLineHeight$foundation_release(boolean r3) {
        if (r3 == false) goto L4;
        int r4 = TextRange.getStart-impl(getValue$foundation_release().getSelection-d9O1mEE());
    L5:
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L13;
        TextLayoutResultProxy r1 = r0.getLayoutResult();
        if (r1 == null) goto L15;
        TextLayoutResult r2 = r1.getValue();
        if (r2 != null) goto L12;
        return MenuKt.ClosedAlphaTarget;
    L12:
        return TextLayoutHelperKt.getLineHeight(r2, r4);
    L15:
        return MenuKt.ClosedAlphaTarget;
    L13:
        return MenuKt.ClosedAlphaTarget;
    L4:
        r4 = TextRange.getEnd-impl(getValue$foundation_release().getSelection-d9O1mEE());
        goto L5
    }

    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1903getHandlePositiontuRUvjQ$foundation_release(boolean r5) {
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L24;
        TextLayoutResultProxy r1 = r0.getLayoutResult();
        if (r1 == null) goto L24;
        TextLayoutResult r2 = r1.getValue();
        if (r2 == null) goto L24;
        AnnotatedString r3 = getTransformedText$foundation_release();
        if (r3 == null) goto L12;
        String r4 = r2.getLayoutInput().getText().getText();
        if (Intrinsics.areEqual(r3.getText(), r4) == false) goto L16;
        long r6 = getValue$foundation_release().getSelection-d9O1mEE();
        if (r5 == false) goto L20;
        int r7 = TextRange.getStart-impl(r6);
    L22:
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(r2, this.offsetMapping.originalToTransformed(r7), r5, TextRange.getReversed-impl(getValue$foundation_release().getSelection-d9O1mEE()));
    L20:
        r7 = TextRange.getEnd-impl(r6);
        goto L22
    L16:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L12:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L24:
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean r2) {
        return new TextFieldSelectionManager$handleDragObserver$1(this, r2);
    }

    /* JADX INFO: renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M, reason: not valid java name */
    public final void m1905selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long r10) {
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L11;
        TextLayoutResultProxy r1 = r0.getLayoutResult();
        if (r1 != null) goto L8;
        return;
    L8:
        if (TextLayoutHelperKt.m1478isPositionInsideSelectionuaM50fQ(r1.getValue(), r1.m1483translateDecorationToInnerCoordinatesMKHz9U$foundation_release(r10), TextRange.box-impl(getValue$foundation_release().getSelection-d9O1mEE())) == true) goto L12;
        m1899updateSelection8UEBfa8(getValue$foundation_release(), r10, true, false, SelectionAdjustment.Companion.getWord(), false);
        return;
    L12:
        return;
    }

    public final void setClipboard$foundation_release(Clipboard r1) {
        this.clipboard = r1;
    }

    public final void setCoroutineScope$foundation_release(CoroutineScope r1) {
        this.coroutineScope = r1;
    }

    /* JADX INFO: renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m1906setDeletionPreviewHighlight5zctL8$foundation_release(long r4) {
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L5;
        r0.m1392setDeletionPreviewHighlightRange5zctL8(r4);
    L5:
        LegacyTextFieldState r1 = this.state;
        if (r1 == null) goto L9;
        r1.m1395setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.getZero-d9O1mEE());
    L9:
        if (TextRange.getCollapsed-impl(r4) == true) goto L12;
        exitSelectionMode$foundation_release();
        return;
    }

    public final void setEditable(boolean r2) {
        this.editable$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setEnabled(boolean r2) {
        this.enabled$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setFocusRequester(FocusRequester r1) {
        this.focusRequester = r1;
    }

    public final void setHapticFeedBack(HapticFeedback r1) {
        this.hapticFeedBack = r1;
    }

    /* JADX INFO: renamed from: setLatestSelection-OEnZFl4$foundation_release, reason: not valid java name */
    public final void m1907setLatestSelectionOEnZFl4$foundation_release(TextRange r1) {
        this.latestSelection = r1;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping r1) {
        this.offsetMapping = r1;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> r1) {
        this.onValueChange = r1;
    }

    public final void setPlatformSelectionBehaviors$foundation_release(PlatformSelectionBehaviors r1) {
        this.platformSelectionBehaviors = r1;
    }

    public final void setRequestAutofillAction$foundation_release(Function0<Unit> r1) {
        this.requestAutofillAction = r1;
    }

    /* JADX INFO: renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m1908setSelectionPreviewHighlight5zctL8$foundation_release(long r4) {
        LegacyTextFieldState r0 = this.state;
        if (r0 == null) goto L5;
        r0.m1395setSelectionPreviewHighlightRange5zctL8(r4);
    L5:
        LegacyTextFieldState r1 = this.state;
        if (r1 == null) goto L9;
        r1.m1392setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.getZero-d9O1mEE());
    L9:
        if (TextRange.getCollapsed-impl(r4) == true) goto L12;
        exitSelectionMode$foundation_release();
        return;
    }

    public final void setState$foundation_release(LegacyTextFieldState r1) {
        this.state = r1;
    }

    public final void setTextToolbar(TextToolbar r1) {
        this.textToolbar = r1;
    }

    public final void setTextToolbarShownViaProvider$foundation_release(boolean r1) {
        this.textToolbarShownViaProvider = r1;
    }

    public final void setToolbarRequester$foundation_release(ToolbarRequester r1) {
        this.toolbarRequester = r1;
    }

    public final void setValue$foundation_release(TextFieldValue r3) {
        this.valueState.setValue(r3);
        this.latestSelection = TextRange.box-impl(r3.getSelection-d9O1mEE());
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation r1) {
        this.visualTransformation = r1;
    }

    public final Object updateClipboardEntry$foundation_release(Continuation<? super Unit> r5) {
        if ((r5 instanceof TextFieldSelectionManager$updateClipboardEntry$1) == false) goto L7;
        TextFieldSelectionManager$updateClipboardEntry$1 r0 = (TextFieldSelectionManager$updateClipboardEntry$1) r5;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        TextFieldSelectionManager r4 = (TextFieldSelectionManager) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L20:
        ClipEntry r7 = (ClipEntry) r6;
    L22:
        r4.setClipEntry(r7);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        Clipboard r8 = this.clipboard;
        if (r8 == null) goto L21;
        r0.L$0 = this;
        r0.label = 1;
        r6 = r8.getClipEntry(r0);
        if (r6 != r2) goto L19;
        return r2;
    L19:
        r4 = this;
        goto L20
    L21:
        r7 = null;
        r4 = this;
    L7:
        r0 = new TextFieldSelectionManager$updateClipboardEntry$1(this, r5);
        goto L8
    }

    private static final Rect _get_contextMenuAreaModifier_$lambda$1(TextFieldSelectionManager r1, LayoutCoordinates r2) {
        Rect r0 = r1.getContentRect();
        LegacyTextFieldState r3 = r1.state;
        if (r3 == null) goto L5;
        LayoutCoordinates r4 = r3.getLayoutCoordinates();
    L6:
        if (r4 != null) goto L8;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    L8:
        return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(r0, r4, r2);
    L5:
        r4 = null;
        goto L6
    }

    /* JADX INFO: renamed from: access$maybeSuggestSelection-OEnZFl4, reason: not valid java name */
    public static final /* synthetic */ void m1892access$maybeSuggestSelectionOEnZFl4(TextFieldSelectionManager r0, TextRange r1) {
        r0.m1897maybeSuggestSelectionOEnZFl4(r1);
    }

    public static final /* synthetic */ Object access$notifyPlatformSelectionBehaviorsOnShowContextMenu(TextFieldSelectionManager r0, Continuation r1) {
        return r0.notifyPlatformSelectionBehaviorsOnShowContextMenu(r1);
    }

    /* JADX INFO: renamed from: access$setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public static final /* synthetic */ void m1893access$setCurrentDragPosition_kEHs6E(TextFieldSelectionManager r0, Offset r1) {
        r0.m1898setCurrentDragPosition_kEHs6E(r1);
    }

    public static final /* synthetic */ void access$setDragBeginPosition$p(TextFieldSelectionManager r0, long r1) {
        r0.dragBeginPosition = r1;
    }

    public static final /* synthetic */ void access$setDragBeginSelection$p(TextFieldSelectionManager r0, TextRange r1) {
        r0.dragBeginSelection = r1;
    }

    public static final /* synthetic */ void access$setDragTotalDistance$p(TextFieldSelectionManager r0, long r1) {
        r0.dragTotalDistance = r1;
    }

    public static final /* synthetic */ void access$setDraggingHandle(TextFieldSelectionManager r0, Handle r1) {
        r0.setDraggingHandle(r1);
    }

    public static final /* synthetic */ void access$setHandleState(TextFieldSelectionManager r0, HandleState r1) {
        r0.setHandleState(r1);
    }

    public static final /* synthetic */ void access$setPreviousRawDragOffset$p(TextFieldSelectionManager r0, int r1) {
        r0.previousRawDragOffset = r1;
    }

    public static final /* synthetic */ void access$updateFloatingToolbar(TextFieldSelectionManager r0, boolean r1) {
        r0.updateFloatingToolbar(r1);
    }

    /* JADX INFO: renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    private final TextFieldValue m1895createTextFieldValueFDrldGo(AnnotatedString r9, long r10) {
        return new TextFieldValue(r9, r10, null, 4, null);
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    /* JADX INFO: renamed from: access$createTextFieldValue-FDrldGo, reason: not valid java name */
    public static final /* synthetic */ TextFieldValue m1891access$createTextFieldValueFDrldGo(TextFieldSelectionManager r0, AnnotatedString r1, long r2) {
        return r0.m1895createTextFieldValueFDrldGo(r1, r2);
    }

    public static /* synthetic */ Job copy$foundation_release$default(TextFieldSelectionManager r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.copy$foundation_release(r1);
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m1896deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager r0, Offset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.m1900deselect_kEHs6E$foundation_release(r1);
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.enterSelectionMode$foundation_release(r1);
    }

    /* JADX INFO: renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    private final long m1899updateSelection8UEBfa8(TextFieldValue r14, long r15, boolean r17, boolean r18, SelectionAdjustment r19, boolean r20) {
        LegacyTextFieldState r1 = this.state;
        if (r1 == null) goto L90;
        TextLayoutResultProxy r2 = r1.getLayoutResult();
        if (r2 == null) goto L90;
        long r5 = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.getStart-impl(r14.getSelection-d9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(r14.getSelection-d9O1mEE())));
        boolean r10 = false;
        int r11 = r2.m1481getOffsetForPosition3MmeM6k(r15, false);
        if (r18 == true) goto L12;
        if (r17 == true) goto L12;
        int r3 = TextRange.getStart-impl(r5);
    L13:
        if (r18 == false) goto L17;
        if (r17 == true) goto L17;
        int r4 = TextRange.getEnd-impl(r5);
    L18:
        SelectionLayout r12 = this.previousSelectionLayout;
        int r6 = -1;
        if (r17 == true) goto L25;
        if (r12 == null) goto L25;
        int r7 = this.previousRawDragOffset;
        if (r7 == (-1)) goto L25;
        r6 = r7;
    L25:
        SelectionLayout r8 = SelectionLayoutKt.m1853getTextFieldSelectionLayoutRcvTLA(r2.getValue(), r3, r4, r6, r5, r17, r18);
        if (r8.shouldRecomputeSelection(r12) == false) goto L28;
        this.previousSelectionLayout = r8;
        this.previousRawDragOffset = r11;
        Selection r9 = r19.adjust(r8);
        long r13 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(r9.getStart().getOffset()), this.offsetMapping.transformedToOriginal(r9.getEnd().getOffset()));
        if (TextRange.equals-impl0(r13, r14.getSelection-d9O1mEE()) == false) goto L34;
        return r14.getSelection-d9O1mEE();
    L34:
        if (TextRange.getReversed-impl(r13) != TextRange.getReversed-impl(r14.getSelection-d9O1mEE())) goto L36;
    L38:
        boolean r16 = false;
    L40:
        if (TextRange.getCollapsed-impl(r13) == true) goto L42;
    L44:
        boolean r21 = false;
    L45:
        if (r20 == true) goto L47;
    L56:
        this.onValueChange.invoke(m1895createTextFieldValueFDrldGo(r14.getAnnotatedString(), r13));
        this.latestSelection = TextRange.box-impl(r13);
        if (r20 == true) goto L59;
        updateFloatingToolbar(!TextRange.getCollapsed-impl(r13));
    L59:
        LegacyTextFieldState r22 = this.state;
        if (r22 == null) goto L62;
        r22.setInTouchMode(r20);
    L62:
        LegacyTextFieldState r23 = this.state;
        if (r23 != null) goto L65;
    L71:
        LegacyTextFieldState r24 = this.state;
        if (r24 != null) goto L74;
    L80:
        LegacyTextFieldState r25 = this.state;
        if (r25 != null) goto L83;
    L88:
        return r13;
    L83:
        if (TextRange.getCollapsed-impl(r13) == true) goto L85;
    L87:
        r25.setShowCursorHandle(r10);
        goto L88
    L85:
        if (TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true) == false) goto L87;
        r10 = true;
        goto L87
    L74:
        if (TextRange.getCollapsed-impl(r13) == false) goto L76;
    L78:
        boolean r26 = false;
    L79:
        r24.setShowSelectionHandleEnd(r26);
        goto L80
    L76:
        if (TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false) == false) goto L78;
        r26 = true;
        goto L79
    L65:
        if (TextRange.getCollapsed-impl(r13) == false) goto L67;
    L69:
        boolean r27 = false;
    L70:
        r23.setShowSelectionHandleStart(r27);
        goto L71
    L67:
        if (TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true) == false) goto L69;
        r27 = true;
        goto L70
    L47:
        if (r14.getText().length() <= 0) goto L49;
        boolean r28 = true;
    L50:
        if (r28 == false) goto L56;
        if (r16 == true) goto L56;
        if (r21 == true) goto L56;
        HapticFeedback r29 = this.hapticFeedBack;
        if (r29 == null) goto L56;
        r29.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
        goto L56
    L49:
        r28 = false;
        goto L50
    L42:
        if (TextRange.getCollapsed-impl(r14.getSelection-d9O1mEE()) == false) goto L44;
        r21 = true;
        goto L45
    L36:
        if (TextRange.equals-impl0(TextRangeKt.TextRange(TextRange.getEnd-impl(r13), TextRange.getStart-impl(r13)), r14.getSelection-d9O1mEE()) == false) goto L38;
        r16 = true;
        goto L40
    L28:
        return r14.getSelection-d9O1mEE();
    L17:
        r4 = r11;
    L12:
        r3 = r11;
    L90:
        return TextRange.Companion.getZero-d9O1mEE();
    }

    /* JADX INFO: renamed from: access$updateSelection-8UEBfa8, reason: not valid java name */
    public static final /* synthetic */ long m1894access$updateSelection8UEBfa8(TextFieldSelectionManager r0, TextFieldValue r1, long r2, boolean r4, boolean r5, SelectionAdjustment r6, boolean r7) {
        return r0.m1899updateSelection8UEBfa8(r1, r2, r4, r5, r6, r7);
    }
}
