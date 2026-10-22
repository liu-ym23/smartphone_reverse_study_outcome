package androidx.compose.foundation.text.selection;

import androidx.autofill.HintConstants;
import androidx.collection.LongIntMapKt;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.collection.MutableLongObjectMap;
import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0097\u0001\u001a\u00020\u0017H\u0082@¢\u0006\u0003\u0010\u0098\u0001J\t\u0010\u0099\u0001\u001a\u00020\u0017H\u0002J\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u009e\u0001J\t\u0010\u009f\u0001\u001a\u00020\u0017H\u0002J\u000f\u0010 \u0001\u001a\u00020PH\u0000¢\u0006\u0003\b¡\u0001J:\u0010¢\u0001\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\b0¤\u00010£\u00012\b\u0010¥\u0001\u001a\u00030¦\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0003\b¨\u0001J\u000f\u0010©\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\bª\u0001J\u000f\u0010«\u0001\u001a\u00020\u0017H\u0000¢\u0006\u0003\b¬\u0001J\u000f\u0010\u00ad\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b®\u0001J\u000f\u0010¯\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b°\u0001J\u0011\u0010±\u0001\u001a\u0004\u0018\u00010$H\u0000¢\u0006\u0003\b²\u0001J\u001f\u0010³\u0001\u001a\u0012\u0012\u0004\u0012\u00020$\u0012\u0005\u0012\u00030´\u0001\u0018\u00010£\u0001H\u0000¢\u0006\u0003\bµ\u0001J\u0083\u0001\u0010¶\u0001\u001a\u00020\u00172q\b\u0004\u0010·\u0001\u001aj\u0012\u0017\u0012\u00150¦\u0001¢\u0006\u000f\b¹\u0001\u0012\n\bº\u0001\u0012\u0005\b\b(¥\u0001\u0012\u0016\u0012\u00140$¢\u0006\u000f\b¹\u0001\u0012\n\bº\u0001\u0012\u0005\b\b(»\u0001\u0012\u0016\u0012\u00140´\u0001¢\u0006\u000e\b¹\u0001\u0012\t\bº\u0001\u0012\u0004\b\b(\n\u0012\u0016\u0012\u00140\u0010¢\u0006\u000f\b¹\u0001\u0012\n\bº\u0001\u0012\u0005\b\b(¼\u0001\u0012\u0004\u0012\u00020\u00100¸\u0001H\u0080\b¢\u0006\u0003\b½\u0001J\u000f\u0010¾\u0001\u001a\u00020\u0017H\u0000¢\u0006\u0003\b¿\u0001J\t\u0010Ã\u0001\u001a\u00020\u0017H\u0002J\t\u0010Ä\u0001\u001a\u00020\u0017H\u0002J\t\u0010Å\u0001\u001a\u00020\u0017H\u0002J\u000b\u0010Æ\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0007\u0010Ç\u0001\u001a\u00020\u0017J\u0011\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010Ê\u0001\u001a\u00020\u0010J\r\u0010Ë\u0001\u001a\u00020C*\u00020CH\u0002J\u001d\u0010Ì\u0001\u001a\u00020C*\u00020C2\u000e\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170Í\u0001H\u0002J$\u0010Î\u0001\u001a\u00020O2\u0007\u0010Ï\u0001\u001a\u00020P2\u0007\u0010Ð\u0001\u001a\u00020OH\u0002¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J.\u0010Ó\u0001\u001a\u00020\u00172\u0007\u0010Ô\u0001\u001a\u00020O2\u0007\u0010Ê\u0001\u001a\u00020\u00102\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002¢\u0006\u0006\b×\u0001\u0010Ø\u0001J8\u0010Ù\u0001\u001a\u00020\u00102\t\u0010Ú\u0001\u001a\u0004\u0018\u00010O2\u0006\u0010N\u001a\u00020O2\u0007\u0010Ê\u0001\u001a\u00020\u00102\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J7\u0010Ù\u0001\u001a\u00020\u00102\u0007\u0010Ô\u0001\u001a\u00020O2\u0007\u0010Ý\u0001\u001a\u00020O2\u0007\u0010Ê\u0001\u001a\u00020\u00102\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0000¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J0\u0010à\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u0007\u0010Ô\u0001\u001a\u00020O2\u0007\u0010Ý\u0001\u001a\u00020O2\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0006\bá\u0001\u0010â\u0001J\u001c\u0010ã\u0001\u001a\u00020\u00172\b\u0010ä\u0001\u001a\u00030\u0084\u00012\u0007\u0010å\u0001\u001a\u00020\bH\u0002J\u000f\u0010æ\u0001\u001a\u00020\u0010H\u0001¢\u0006\u0003\bç\u0001J\u0018\u0010è\u0001\u001a\u00020\u00172\u0007\u0010Ô\u0001\u001a\u00020O¢\u0006\u0005\bé\u0001\u0010`R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R@\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00170\u00162\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00170\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u00020.8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R+\u0010<\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R\u0014\u0010A\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0012R\u0011\u0010B\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bH\u0010IR\u0011\u0010L\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bM\u0010ER\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010\t\u001a\u0004\u0018\u00010P@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR+\u0010V\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00178B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010@\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR+\u0010\\\u001a\u00020O2\u0006\u0010;\u001a\u00020O8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010@\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R+\u0010b\u001a\u00020O2\u0006\u0010;\u001a\u00020O8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\be\u0010@\u001a\u0004\bc\u0010^\"\u0004\bd\u0010`R/\u0010f\u001a\u0004\u0018\u00010O2\b\u0010;\u001a\u0004\u0018\u00010O8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bk\u0010@\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR/\u0010l\u001a\u0004\u0018\u00010O2\b\u0010;\u001a\u0004\u0018\u00010O8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bo\u0010@\u001a\u0004\bm\u0010h\"\u0004\bn\u0010jR/\u0010q\u001a\u0004\u0018\u00010p2\b\u0010;\u001a\u0004\u0018\u00010p8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bv\u0010@\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0011\u0010w\u001a\u00020x8F¢\u0006\u0006\u001a\u0004\by\u0010zR\u0011\u0010{\u001a\u00020x8F¢\u0006\u0006\u001a\u0004\b|\u0010zR0\u0010}\u001a\u0004\u0018\u00010O2\b\u0010;\u001a\u0004\u0018\u00010O8F@BX\u0086\u008e\u0002¢\u0006\u0013\n\u0005\b\u0080\u0001\u0010@\u001a\u0004\b~\u0010h\"\u0004\b\u007f\u0010jR\u0016\u0010\u0081\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u0012R-\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u0085\u0001\u00100\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u000f\u0010\u008a\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\"\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R'\u0010À\u0001\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@@X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010\u0012\"\u0005\bÂ\u0001\u0010\u0014¨\u0006ê\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "<init>", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_selection", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/selection/Selection;", "value", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "_isInTouchMode", "", "isInTouchMode", "()Z", "setInTouchMode", "(Z)V", "newOnSelectionChange", "Lkotlin/Function1;", "", "onSelectionChange", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "onCopyHandler", "Landroidx/compose/ui/text/AnnotatedString;", "getOnCopyHandler", "setOnCopyHandler", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "getToolbarRequester$foundation_release$annotations", "()V", "getToolbarRequester$foundation_release", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setToolbarRequester$foundation_release", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "hasFocus", "getHasFocus", "setHasFocus", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "isDraggingInProgress", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "derivedContentRect", "Landroidx/compose/ui/geometry/Rect;", "getDerivedContentRect", "()Landroidx/compose/ui/geometry/Rect;", "derivedContentRect$delegate", "Landroidx/compose/runtime/State;", "contextMenuAreaModifier", "getContextMenuAreaModifier", "previousPosition", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "positionChangeState", "getPositionChangeState", "()Lkotlin/Unit;", "setPositionChangeState", "(Lkotlin/Unit;)V", "positionChangeState$delegate", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setStartHandlePosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "startHandlePosition$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "startHandleLineHeight", "", "getStartHandleLineHeight", "()F", "endHandleLineHeight", "getEndHandleLineHeight", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "setCurrentDragPosition-_kEHs6E", "currentDragPosition$delegate", "shouldShowMagnifier", "getShouldShowMagnifier", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getPreviousSelectionLayout$foundation_release$annotations", "getPreviousSelectionLayout$foundation_release", "()Landroidx/compose/foundation/text/selection/SelectionLayout;", "setPreviousSelectionLayout$foundation_release", "(Landroidx/compose/foundation/text/selection/SelectionLayout;)V", "isLongPressOrClickSelection", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation_release", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviors$foundation_release", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "setPlatformSelectionBehaviors$foundation_release", "(Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "notifyPlatformSelectionBehaviorsOnShowContextMenu", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suggestSelectionForLongPressOrDoubleClick", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation_release", "updateHandleOffsets", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAllInSelectable", "Lkotlin/Pair;", "Landroidx/collection/LongObjectMap;", "selectableId", "", "previousSelection", "selectAllInSelectable$foundation_release", "isEntireContainerSelected", "isEntireContainerSelected$foundation_release", "selectAll", "selectAll$foundation_release", "isTriviallyCollapsedSelection", "isTriviallyCollapsedSelection$foundation_release", "isNonEmptySelection", "isNonEmptySelection$foundation_release", "getSelectedText", "getSelectedText$foundation_release", "getContextTextAndSelection", "Landroidx/compose/ui/text/TextRange;", "getContextTextAndSelection$foundation_release", "forEachSelectableWithSelection", "block", "Lkotlin/Function4;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "text", "isLastSelectable", "forEachSelectableWithSelection$foundation_release", "copy", "copy$foundation_release", "showToolbar", "getShowToolbar$foundation_release", "setShowToolbar$foundation_release", "toolbarCopy", "updateSelectionToolbar", "updateSelectionTextToolbar", "getContentRect", "onRelease", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isStartHandle", "addContextMenuComponents", "onClearSelectionRequested", "Lkotlin/Function0;", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "startSelection", "position", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "updateSelection", "newPosition", "updateSelection-qNKwrvQ$foundation_release", "(Landroidx/compose/ui/geometry/Offset;JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "previousHandlePosition", "updateSelection-jyLRC_s$foundation_release", "(JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "getSelectionLayout", "getSelectionLayout-Wko1d7g", "(JJZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectionChanged", "selectionLayout", "newSelection", "shouldPerformHaptics", "shouldPerformHaptics$foundation_release", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectionManager {
    public static final int $stable = 8;
    private final MutableState<Boolean> _isInTouchMode;
    private final MutableState<Selection> _selection;
    private LayoutCoordinates containerLayoutCoordinates;
    private CoroutineScope coroutineScope;
    private final MutableState currentDragPosition$delegate;
    private final State derivedContentRect$delegate;
    private final MutableState dragBeginPosition$delegate;
    private final MutableState dragTotalDistance$delegate;
    private final MutableState draggingHandle$delegate;
    private final MutableState endHandlePosition$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MutableState hasFocus$delegate;
    private boolean isLongPressOrClickSelection;
    private Function1<? super AnnotatedString, Unit> onCopyHandler;
    private Function1<? super Selection, Unit> onSelectionChange;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private final MutableState positionChangeState$delegate;
    private Offset previousPosition;
    private SelectionLayout previousSelectionLayout;
    private final SelectionRegistrarImpl selectionRegistrar;
    private boolean showToolbar;
    private final MutableState startHandlePosition$delegate;
    private TextToolbar textToolbar;
    private ToolbarRequester toolbarRequester;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$suggestSelectionForLongPressOrDoubleClick$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$suggestSelectionForLongPressOrDoubleClick$2", f = "SelectionManager.kt", i = {}, l = {436}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<TextRange> $selectionInSelectable;
        final /* synthetic */ Ref.LongRef $targetSelectableId;
        final /* synthetic */ Ref.ObjectRef<CharSequence> $textInSelectable;
        int label;
        final /* synthetic */ SelectionManager this$0;

        public AnonymousClass2(SelectionManager r1, Ref.ObjectRef<CharSequence> r2, Ref.ObjectRef<TextRange> r3, Ref.LongRef r4, Continuation<? super AnonymousClass2> r5) {
            this.this$0 = r1;
            this.$textInSelectable = r2;
            this.$selectionInSelectable = r3;
            this.$targetSelectableId = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass2(this.this$0, this.$textInSelectable, this.$selectionInSelectable, this.$targetSelectableId, r8);
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
        L13:
            TextRange r11 = (TextRange) r10;
        L15:
            if (r11 == null) goto L28;
            if (Intrinsics.areEqual(r11, this.$selectionInSelectable.element) == true) goto L28;
            Selectable r2 = SelectionManager.access$getSelectionRegistrar$p(this.this$0).getSelectableMap$foundation_release().get(this.$targetSelectableId.element);
            if (r2 == null) goto L28;
            if (r2.getText() != this.$textInSelectable.element) goto L28;
            TextLayoutResult r3 = r2.textLayoutResult();
            if (r3 == null) goto L25;
            Selection r4 = new Selection(new Selection.AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(r3, TextRange.getStart-impl(r11.unbox-impl())), TextRange.getStart-impl(r11.unbox-impl()), this.$targetSelectableId.element), new Selection.AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(r3, TextRange.getEnd-impl(r11.unbox-impl())), TextRange.getEnd-impl(r11.unbox-impl()), this.$targetSelectableId.element), false, 4, null);
            SelectionManager.access$getSelectionRegistrar$p(this.this$0).setSubselections(LongObjectMapKt.mutableLongObjectMapOf(this.$targetSelectableId.element, r4));
            this.this$0.getOnSelectionChange().invoke(r4);
            this.this$0.setPreviousSelectionLayout$foundation_release(null);
            goto L28
        L25:
            return Unit.INSTANCE;
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            PlatformSelectionBehaviors r12 = this.this$0.getPlatformSelectionBehaviors$foundation_release();
            if (r12 == null) goto L14;
            CharSequence r5 = (CharSequence) this.$textInSelectable.element;
            long r6 = ((TextRange) this.$selectionInSelectable.element).unbox-impl();
            this.label = 1;
            r10 = r12.mo1837suggestSelectionForLongPressOrDoubleClickpYaCww(r5, r6, this);
            if (r10 != r0) goto L13;
            return r0;
        L14:
            r11 = null;
            goto L15
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$updateSelectionTextToolbar$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C02351 extends FunctionReferenceImpl implements Function0<Unit> {
        public C02351(Object r8) {
            super(0, r8, SelectionManager.class, "toolbarCopy", "toolbarCopy()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1875invoke() {
            SelectionManager.access$toolbarCopy((SelectionManager) ((CallableReference) this).receiver);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1875invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$updateSelectionTextToolbar$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C02362 extends FunctionReferenceImpl implements Function0<Unit> {
        public C02362(Object r8) {
            super(0, r8, SelectionManager.class, "selectAll", "selectAll$foundation_release()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1876invoke() {
            ((SelectionManager) ((CallableReference) this).receiver).selectAll$foundation_release();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1876invoke();
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Unit a(SelectionManager r0) {
        return _init_$lambda$14(r0);
    }

    public static /* synthetic */ Unit b(SelectionManager r0, long r1) {
        return _init_$lambda$15(r0, r1);
    }

    public static /* synthetic */ Unit c(SelectionManager r0, Function1 r1, Selection r2) {
        return _set_onSelectionChange_$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(SelectionManager r0, long r1) {
        return _init_$lambda$16(r0, r1);
    }

    public static /* synthetic */ Unit e(SelectionManager r0, boolean r1) {
        return _get_modifier_$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit f(SelectionManager r0, long r1) {
        return _init_$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit g(SelectionManager r0, LayoutCoordinates r1) {
        return _get_modifier_$lambda$3(r0, r1);
    }

    public static /* synthetic */ void getPreviousSelectionLayout$foundation_release$annotations() {
    }

    public static /* synthetic */ void getToolbarRequester$foundation_release$annotations() {
    }

    public static /* synthetic */ Unit h(SelectionManager r0, boolean r1, long r2) {
        return _init_$lambda$12(r0, r1, r2);
    }

    public static /* synthetic */ boolean i(SelectionManager r0, boolean r1, LayoutCoordinates r2, Offset r3, Offset r4, boolean r5, SelectionAdjustment r6) {
        return _init_$lambda$13(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit j(SelectionManager r0, FocusState r1) {
        return _get_modifier_$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit k(SelectionManager r0) {
        return _get_modifier_$lambda$2(r0);
    }

    public static /* synthetic */ Rect l(SelectionManager r0) {
        return derivedContentRect_delegate$lambda$6(r0);
    }

    public static /* synthetic */ Rect m(SelectionManager r0, LayoutCoordinates r1) {
        return _get_contextMenuAreaModifier_$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit n(SelectionManager r0, boolean r1, LayoutCoordinates r2, Offset r3, SelectionAdjustment r4) {
        return _init_$lambda$11(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit o(SelectionManager r0, Selection r1) {
        return onSelectionChange$lambda$0(r0, r1);
    }

    private final Rect getDerivedContentRect() {
        return (Rect) this.derivedContentRect$delegate.getValue();
    }

    private final Unit getPositionChangeState() {
        this.positionChangeState$delegate.getValue();
        return Unit.INSTANCE;
    }

    private final void suggestSelectionForLongPressOrDoubleClick() {
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        Ref.LongRef r4 = new Ref.LongRef();
        List<Selectable> r0 = access$getSelectionRegistrar$p(this).sort(requireContainerCoordinates$foundation_release());
        ListIterator<Selectable> r1 = r0.listIterator(r0.size());
    L3:
        boolean r7 = true;
        if (r1.hasPrevious() == false) goto L13;
        Selectable r5 = r1.previous();
        Selection r6 = access$getSelectionRegistrar$p(this).getSubselections().get(r5.getSelectableId());
        if (r6 != null) goto L8;
    L10:
        boolean r8 = false;
    L11:
        if (r8 == false) goto L3;
        int r9 = r1.nextIndex();
    L14:
        if (r9 == (-1)) goto L27;
        int r10 = r0.size();
        int r11 = 0;
    L16:
        if (r11 >= r10) goto L27;
        Selectable r12 = (Selectable) ListProtector.get(r0, r11);
        Selection r13 = access$getSelectionRegistrar$p(this).getSubselections().get(r12.getSelectableId());
        if (r13 != null) goto L19;
        r11 = r11 + 1;
        goto L16
    L19:
        AnnotatedString r14 = r12.getText();
        long r15 = TextRangeKt.TextRange(r13.getStart().getOffset(), r13.getEnd().getOffset());
        if (r11 < r9) goto L22;
        boolean r16 = true;
    L23:
        long r17 = r12.getSelectableId();
        if (r16 == false) goto L27;
        r2.element = r14;
        r3.element = TextRange.box-impl(r15);
        r4.element = r17;
        goto L27
    L22:
        r16 = false;
    L27:
        Object r18 = r2.element;
        if (r18 != null) goto L30;
        return;
    L30:
        if (r3.element != null) goto L32;
        return;
    L32:
        if (r4.element != 0) goto L34;
        return;
    L34:
        if (((CharSequence) r18).length() > 0) goto L37;
        r7 = false;
    L37:
        if (r7 == false) goto L52;
        CoroutineScope r19 = this.coroutineScope;
        if (r19 == null) goto L53;
        BuildersKt.launch$default(r19, null, null, new AnonymousClass2(this, r2, r3, r4, null), 3, null);
        return;
    L53:
        return;
    L52:
        return;
    L8:
        if (r6.getStart().getOffset() == r6.getEnd().getOffset()) goto L10;
        r8 = true;
        goto L11
    L13:
        r9 = -1;
        goto L14
    }

    private final void updateHandleOffsets() {
        Selection r1 = getSelection();
        LayoutCoordinates r2 = this.containerLayoutCoordinates;
        if (r1 == null) goto L7;
        Selection.AnchorInfo r4 = r1.getStart();
        if (r4 == null) goto L7;
        Selectable r5 = getAnchorSelectable$foundation_release(r4);
    L8:
        if (r1 == null) goto L12;
        Selection.AnchorInfo r6 = r1.getEnd();
        if (r6 == null) goto L12;
        Selectable r7 = getAnchorSelectable$foundation_release(r6);
    L13:
        if (r5 == null) goto L15;
        LayoutCoordinates r8 = r5.getLayoutCoordinates();
    L16:
        if (r7 == null) goto L18;
        LayoutCoordinates r9 = r7.getLayoutCoordinates();
    L19:
        if (r1 == null) goto L62;
        if (r2 == null) goto L62;
        if (r2.isAttached() == false) goto L62;
        if (r8 != null) goto L26;
        if (r9 == null) goto L62;
    L26:
        Rect r10 = SelectionManagerKt.visibleBounds(r2);
        boolean r13 = false;
        if (r8 == null) goto L43;
        long r3 = r5.mo1830getHandlePositiondBAh8RU(r1, true);
        if ((r3 & SieveCacheKt.InvalidMapping) != 9205357640488583168L) goto L31;
        boolean r16 = true;
    L32:
        if (r16 == true) goto L43;
        Offset r11 = Offset.box-impl(r2.localPositionOf-R5De75A(r8, r3));
        long r14 = r11.unbox-impl();
        if (getDraggingHandle() != Handle.SelectionStart) goto L37;
    L40:
        boolean r12 = true;
    L41:
        if (r12 == false) goto L43;
    L44:
        m1864setStartHandlePosition_kEHs6E(r11);
        if (r9 == null) goto L59;
        long r15 = r7.mo1830getHandlePositiondBAh8RU(r1, false);
        if ((r15 & SieveCacheKt.InvalidMapping) != 9205357640488583168L) goto L49;
        boolean r17 = true;
    L50:
        if (r17 == true) goto L59;
        Offset r18 = Offset.box-impl(r2.localPositionOf-R5De75A(r9, r15));
        long r19 = r18.unbox-impl();
        if (getDraggingHandle() != Handle.SelectionEnd) goto L55;
    L56:
        r13 = true;
    L57:
        if (r13 == false) goto L59;
        Offset r20 = r18;
    L60:
        m1863setEndHandlePosition_kEHs6E(r20);
        return;
    L55:
        if (SelectionManagerKt.m1878containsInclusiveUv8p0NA(r10, r19) == false) goto L57;
    L49:
        r17 = false;
    L59:
        r20 = null;
        goto L60
    L37:
        if (SelectionManagerKt.m1878containsInclusiveUv8p0NA(r10, r14) == true) goto L40;
        r12 = false;
        goto L41
    L31:
        r16 = false;
    L43:
        r11 = null;
    L62:
        m1864setStartHandlePosition_kEHs6E(null);
        m1863setEndHandlePosition_kEHs6E(null);
        return;
    L18:
        r9 = null;
        goto L19
    L15:
        r8 = null;
    L12:
        r7 = null;
    L7:
        r5 = null;
        goto L8
    }

    private final void updateSelectionTextToolbar() {
        TextToolbar r0 = this.textToolbar;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.showToolbar == false) goto L22;
        if (isInTouchMode() == false) goto L22;
        Rect r1 = getContentRect();
        if (r1 != null) goto L12;
        return;
    L12:
        C02362 r3 = null;
        if (isNonEmptySelection$foundation_release() == false) goto L15;
        C02351 r2 = new C02351(this);
    L17:
        if (isEntireContainerSelected$foundation_release() == true) goto L20;
        r3 = new C02362(this);
    L20:
        TextToolbar.-CC.showMenu$default(r0, r1, r2, null, null, r3, null, 12, null);
        return;
    L15:
        r2 = null;
    L22:
        if (r0.getStatus() != TextToolbarStatus.Shown) goto L26;
        r0.hide();
        return;
    }

    public final Modifier getContextMenuAreaModifier() {
        return TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler$default(TextContextMenuGesturesModifierKt.textContextMenuGestures(Modifier.Companion, new SelectionManager$contextMenuAreaModifier$1(this, null)), this.toolbarRequester, new SelectionManager$contextMenuAreaModifier$2(this, null), null, new x0(this), 4, null);
    }

    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m1866getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    /* JADX INFO: renamed from: getDragBeginPosition-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m1867getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getDragTotalDistance-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m1868getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance$delegate.getValue()).unbox-impl();
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* JADX INFO: renamed from: getEndHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m1869getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final Modifier getModifier() {
        Modifier r0 = Modifier.Companion;
        Modifier r1 = KeyInputModifierKt.onKeyEvent(SelectionGesturesKt.updateSelectionTouchMode(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(r0, new o0(this)), new u0(this)), this.focusRequester), new v0(this)), false, null, 3, null), new w0(this)), new SelectionManager$modifier$5(this));
        if (getShouldShowMagnifier() == false) goto L6;
        r0 = SelectionManager_androidKt.selectionMagnifier(r0, this);
    L6:
        return addContextMenuComponents(r1.then(r0));
    }

    public final Selection getSelection() {
        return (Selection) this._selection.getValue();
    }

    /* JADX INFO: renamed from: getStartHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m1870getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    public final boolean isEntireContainerSelected$foundation_release() {
        List<Selectable> r0 = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        if (r0.isEmpty() == false) goto L5;
        return true;
    L5:
        int r1 = r0.size();
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L25;
        Selectable r5 = (Selectable) ListProtector.get(r0, r4);
        AnnotatedString r6 = r5.getText();
        if (r6.length() != 0) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
    L12:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L20;
        r4 = r4 + 1;
        goto L6
    L20:
        return false;
    L13:
        Selection r9 = this.selectionRegistrar.getSubselections().get(r5.getSelectableId());
        if (r9 != null) goto L17;
    L15:
        r8 = false;
        goto L19
    L17:
        if (Math.abs(r9.getStart().getOffset() - r9.getEnd().getOffset()) != r6.length()) goto L15;
    L10:
        r7 = false;
        goto L11
    L25:
        return true;
    }

    public final boolean isInTouchMode() {
        return ((Boolean) this._isInTouchMode.getValue()).booleanValue();
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(LongObjectMapKt.emptyLongObjectMap());
        setShowToolbar$foundation_release(false);
        if (getSelection() == null) goto L10;
        this.onSelectionChange.invoke(null);
        if (isInTouchMode() == false) goto L11;
        HapticFeedback r0 = this.hapticFeedBack;
        if (r0 == null) goto L12;
        r0.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates r0 = this.containerLayoutCoordinates;
        if (r0 != null) goto L5;
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null coordinates");
        throw new KotlinNothingValueException();
    L5:
        if (r0.isAttached() == true) goto L7;
        InlineClassHelperKt.throwIllegalArgumentException("unattached coordinates");
    L7:
        return r0;
    }

    public final void selectAll$foundation_release() {
        List<Selectable> r0 = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        MutableLongObjectMap r1 = LongObjectMapKt.mutableLongObjectMapOf();
        int r2 = r0.size();
        Selection r6 = null;
        Selection r7 = null;
        int r5 = 0;
    L6:
        if (r5 >= r2) goto L15;
        Selectable r8 = (Selectable) ListProtector.get(r0, r5);
        Selection r9 = r8.getSelectAllSelection();
        if (r9 == null) goto L13;
        if (r6 != null) goto L12;
        r6 = r9;
    L12:
        r1.put(r8.getSelectableId(), r9);
        r7 = r9;
    L13:
        r5 = r5 + 1;
        goto L6
    L15:
        if (r1.isEmpty() == false) goto L17;
        return;
    L17:
        if (r6 == r7) goto L20;
        Intrinsics.checkNotNull(r6);
        Selection.AnchorInfo r3 = r6.getStart();
        Intrinsics.checkNotNull(r7);
        r6 = new Selection(r3, r7.getEnd(), false);
    L20:
        this.selectionRegistrar.setSubselections(r1);
        this.onSelectionChange.invoke(r6);
        this.previousSelectionLayout = null;
    }

    private final Rect getContentRect() {
        getPositionChangeState();
        if (getSelection() != null) goto L5;
        return null;
    L5:
        LayoutCoordinates r0 = this.containerLayoutCoordinates;
        if (r0 != null) goto L9;
        return null;
    L9:
        if (r0.isAttached() == true) goto L11;
        return null;
    L11:
        List<Selectable> r2 = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        ArrayList r3 = new ArrayList(r2.size());
        int r4 = r2.size();
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L20;
        Selectable r6 = (Selectable) ListProtector.get(r2, r5);
        Selection r7 = this.selectionRegistrar.getSubselections().get(r6.getSelectableId());
        if (r7 == null) goto L16;
        Pair r8 = TuplesKt.to(r6, r7);
    L17:
        if (r8 == null) goto L19;
        r3.add(r8);
    L19:
        r5 = r5 + 1;
        goto L12
    L16:
        r8 = null;
        goto L17
    L20:
        List r9 = SelectionManagerKt.access$firstAndLast(r3);
        if (r9.isEmpty() == false) goto L23;
        return null;
    L23:
        Rect r10 = SelectionManagerKt.getSelectedRegionRect(r9, r0);
        if (Intrinsics.areEqual(r10, SelectionManagerKt.access$getInvertedInfiniteRect$p()) == false) goto L26;
        return null;
    L26:
        Rect r11 = SelectionManagerKt.visibleBounds(r0).intersect(r10);
        if ((r11.getRight() - r11.getLeft()) >= MenuKt.ClosedAlphaTarget) goto L29;
    L33:
        return null;
    L29:
        if ((r11.getBottom() - r11.getTop()) < MenuKt.ClosedAlphaTarget) goto L33;
        Rect r12 = r11.translate-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(r0));
        return Rect.copy$default(r12, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r12.getBottom() + (SelectionHandlesKt.getHandleHeight() * 4), 7, null);
    }

    private final boolean getShouldShowMagnifier() {
        if (isDraggingInProgress() == true) goto L5;
    L9:
        return false;
    L5:
        if (isInTouchMode() == false) goto L9;
        if (isTriviallyCollapsedSelection$foundation_release() == true) goto L9;
        return true;
    }

    private final boolean isDraggingInProgress() {
        if (getDraggingHandle() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void toolbarCopy() {
        copy$foundation_release();
        onRelease();
    }

    private final void updateSelectionToolbar() {
        if (getHasFocus() == true) goto L6;
        return;
    L6:
        if (ComposeFoundationFlags.isNewContextMenuEnabled == true) goto L8;
        updateSelectionTextToolbar();
        return;
    L8:
        if (this.showToolbar == true) goto L10;
    L15:
        this.toolbarRequester.hide();
        return;
    L10:
        if (isInTouchMode() == false) goto L15;
        if (getDerivedContentRect() != null) goto L14;
        return;
    L14:
        this.toolbarRequester.show();
    }

    public final void copy$foundation_release() {
        AnnotatedString r0 = getSelectedText$foundation_release();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L17;
        Function1<? super AnnotatedString, Unit> r2 = this.onCopyHandler;
        if (r2 == null) goto L18;
        r2.invoke(r0);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final Pair<AnnotatedString, TextRange> getContextTextAndSelection$foundation_release() {
        if (getSelection() == null) goto L44;
        if (this.selectionRegistrar.getSelectables$foundation_release().isEmpty() == true) goto L44;
        int r3 = 0;
        AnnotatedString.Builder r2 = new AnnotatedString.Builder(0, 1, null);
        List<Selectable> r5 = access$getSelectionRegistrar$p(this).sort(requireContainerCoordinates$foundation_release());
        ListIterator<Selectable> r6 = r5.listIterator(r5.size());
    L9:
        if (r6.hasPrevious() == false) goto L18;
        Selectable r7 = r6.previous();
        Selection r8 = access$getSelectionRegistrar$p(this).getSubselections().get(r7.getSelectableId());
        if (r8 != null) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L9;
        int r10 = r6.nextIndex();
    L19:
        if (r10 == (-1)) goto L36;
        int r11 = r5.size();
        int r12 = 0;
        int r13 = -1;
        int r14 = -1;
    L21:
        if (r12 >= r11) goto L37;
        Selectable r15 = (Selectable) ListProtector.get(r5, r12);
        Selection r16 = access$getSelectionRegistrar$p(this).getSubselections().get(r15.getSelectableId());
        if (r16 == null) goto L35;
        AnnotatedString r17 = r15.getText();
        long r18 = TextRangeKt.TextRange(r16.getStart().getOffset(), r16.getEnd().getOffset());
        if (r12 < r10) goto L27;
        boolean r19 = true;
    L28:
        r15.getSelectableId();
        if (r13 != (-1)) goto L31;
        r13 = TextRange.getMin-impl(r18);
        r2.append(r17, r3, TextRange.getMin-impl(r18));
    L31:
        r2.append(r17, TextRange.getMin-impl(r18), TextRange.getMax-impl(r18));
        if (r19 == true) goto L34;
        r2.append('\n');
        goto L35
    L34:
        r14 = r2.getLength();
        r2.append(r17, TextRange.getMax-impl(r18), r17.length());
        goto L35
    L27:
        r19 = false;
    L35:
        r12 = r12 + 1;
        r3 = 0;
    L37:
        AnnotatedString r4 = r2.toAnnotatedString();
        if (r13 == (-1)) goto L54;
        if (r14 != (-1)) goto L42;
        return null;
    L42:
        return new Pair(r4, TextRange.box-impl(TextRangeKt.TextRange(r13, r14)));
    L54:
        return null;
    L36:
        r13 = -1;
        r14 = -1;
        goto L37
    L13:
        if (r8.getStart().getOffset() == r8.getEnd().getOffset()) goto L15;
        r9 = true;
        goto L16
    L18:
        r10 = -1;
    L44:
        return null;
    }

    public final float getEndHandleLineHeight() {
        Selection r0 = getSelection();
        if (r0 != null) goto L5;
        return MenuKt.ClosedAlphaTarget;
    L5:
        Selectable r2 = getAnchorSelectable$foundation_release(r0.getEnd());
        if (r2 != null) goto L9;
        return MenuKt.ClosedAlphaTarget;
    L9:
        return r2.getLineHeight(r0.getEnd().getOffset());
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        if (getSelection() != null) goto L5;
    L34:
        return null;
    L5:
        if (this.selectionRegistrar.getSubselections().isEmpty() == true) goto L34;
        AnnotatedString.Builder r0 = new AnnotatedString.Builder(0, 1, null);
        List<Selectable> r1 = access$getSelectionRegistrar$p(this).sort(requireContainerCoordinates$foundation_release());
        ListIterator<Selectable> r4 = r1.listIterator(r1.size());
    L9:
        if (r4.hasPrevious() == false) goto L18;
        Selectable r5 = r4.previous();
        Selection r6 = access$getSelectionRegistrar$p(this).getSubselections().get(r5.getSelectableId());
        if (r6 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L9;
        int r8 = r4.nextIndex();
    L19:
        if (r8 == (-1)) goto L33;
        int r9 = r1.size();
        int r10 = 0;
    L21:
        if (r10 >= r9) goto L33;
        Selectable r11 = (Selectable) ListProtector.get(r1, r10);
        Selection r12 = access$getSelectionRegistrar$p(this).getSubselections().get(r11.getSelectableId());
        if (r12 == null) goto L31;
        AnnotatedString r13 = r11.getText();
        long r14 = TextRangeKt.TextRange(r12.getStart().getOffset(), r12.getEnd().getOffset());
        if (r10 < r8) goto L27;
        boolean r15 = true;
    L28:
        r11.getSelectableId();
        r0.append(r13, TextRange.getMin-impl(r14), TextRange.getMax-impl(r14));
        if (r15 == true) goto L31;
        r0.append('\n');
        goto L31
    L27:
        r15 = false;
    L31:
        r10 = r10 + 1;
    L33:
        return r0.toAnnotatedString();
    L13:
        if (r6.getStart().getOffset() == r6.getEnd().getOffset()) goto L15;
        r7 = true;
        goto L16
    L18:
        r8 = -1;
        goto L19
    }

    public final float getStartHandleLineHeight() {
        Selection r0 = getSelection();
        if (r0 != null) goto L5;
        return MenuKt.ClosedAlphaTarget;
    L5:
        Selectable r2 = getAnchorSelectable$foundation_release(r0.getStart());
        if (r2 != null) goto L9;
        return MenuKt.ClosedAlphaTarget;
    L9:
        return r2.getLineHeight(r0.getStart().getOffset());
    }

    public final boolean isNonEmptySelection$foundation_release() {
        Selection r0 = getSelection();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r0.getStart(), r0.getEnd()) == false) goto L9;
        return false;
    L9:
        if (r0.getStart().getSelectableId() != r0.getEnd().getSelectableId()) goto L11;
        return true;
    L11:
        List<Selectable> r2 = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int r3 = r2.size();
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L25;
        Selectable r5 = (Selectable) ListProtector.get(r2, r4);
        Selection r6 = this.selectionRegistrar.getSubselections().get(r5.getSelectableId());
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == true) goto L20;
        r4 = r4 + 1;
        goto L12
    L20:
        return true;
    L16:
        if (r6.getStart().getOffset() == r6.getEnd().getOffset()) goto L18;
        r7 = true;
        goto L19
    L25:
        return false;
    }

    public final boolean isTriviallyCollapsedSelection$foundation_release() {
        Selection r0 = getSelection();
        if (r0 != null) goto L7;
        return true;
    L7:
        return Intrinsics.areEqual(r0.getStart(), r0.getEnd());
    }

    public final boolean shouldPerformHaptics$foundation_release() {
        if (isInTouchMode() == false) goto L20;
        List<Selectable> r0 = this.selectionRegistrar.getSelectables$foundation_release();
        int r2 = r0.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L14;
        if (((Selectable) ListProtector.get(r0, r3)).getText().length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L12;
        r3 = r3 + 1;
        goto L6
    L12:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L21;
        return true;
    L21:
        return false;
    L10:
        r5 = false;
        goto L11
    L14:
        r1 = false;
        goto L15
    L20:
        return false;
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
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

    public final Function1<AnnotatedString, Unit> getOnCopyHandler() {
        return this.onCopyHandler;
    }

    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors$foundation_release() {
        return this.platformSelectionBehaviors;
    }

    public final SelectionLayout getPreviousSelectionLayout$foundation_release() {
        return this.previousSelectionLayout;
    }

    public final boolean getShowToolbar$foundation_release() {
        return this.showToolbar;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final ToolbarRequester getToolbarRequester$foundation_release() {
        return this.toolbarRequester;
    }

    public SelectionManager(SelectionRegistrarImpl r6) {
        this.selectionRegistrar = r6;
        this._selection = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._isInTouchMode = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.onSelectionChange = new z0(this);
        this.toolbarRequester = new ToolbarRequesterImpl();
        this.focusRequester = new FocusRequester();
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.derivedContentRect$delegate = SnapshotStateKt.derivedStateOf(new a1(this));
        this.positionChangeState$delegate = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        Offset.Companion r2 = Offset.Companion;
        this.dragBeginPosition$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(r2.getZero-F1C5BW0()), null, 2, null);
        this.dragTotalDistance$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(r2.getZero-F1C5BW0()), null, 2, null);
        this.startHandlePosition$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.endHandlePosition$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r6.setOnPositionChangeCallback$foundation_release(new b1(this));
        r6.setOnSelectionUpdateStartCallback$foundation_release(new c1(this));
        r6.setOnSelectionUpdateSelectAll$foundation_release(new p0(this));
        r6.setOnSelectionUpdateCallback$foundation_release(new q0(this));
        r6.setOnSelectionUpdateEndCallback$foundation_release(new r0(this));
        r6.setOnSelectableChangeCallback$foundation_release(new s0(this));
        r6.setAfterSelectableUnsubscribe$foundation_release(new t0(this));
    }

    private static final Unit _get_modifier_$lambda$2(SelectionManager r0) {
        r0.onRelease();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$14(SelectionManager r1) {
        r1.setShowToolbar$foundation_release(true);
        r1.setDraggingHandle(null);
        r1.m1860setCurrentDragPosition_kEHs6E(null);
        if (r1.isLongPressOrClickSelection == true) goto L5;
    L7:
        r1.isLongPressOrClickSelection = false;
        return Unit.INSTANCE;
    L5:
        if (r1.isNonEmptySelection$foundation_release() == false) goto L7;
        r1.suggestSelectionForLongPressOrDoubleClick();
        goto L7
    }

    public static final /* synthetic */ SelectionRegistrarImpl access$getSelectionRegistrar$p(SelectionManager r0) {
        return r0.selectionRegistrar;
    }

    public static final /* synthetic */ boolean access$isDraggingInProgress(SelectionManager r0) {
        return r0.isDraggingInProgress();
    }

    public static final /* synthetic */ void access$toolbarCopy(SelectionManager r0) {
        r0.toolbarCopy();
    }

    private final Modifier addContextMenuComponents(Modifier r2) {
        if (ComposeFoundationFlags.isNewContextMenuEnabled == true) goto L5;
        return r2;
    L5:
        return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents(r2, this);
    }

    private static final Rect derivedContentRect_delegate$lambda$6(SelectionManager r0) {
        return r0.getContentRect();
    }

    private final Object notifyPlatformSelectionBehaviorsOnShowContextMenu(Continuation<? super Unit> r5) {
        Pair<AnnotatedString, TextRange> r0 = getContextTextAndSelection$foundation_release();
        if (r0 == null) goto L5;
        CharSequence r1 = (AnnotatedString) r0.component1();
        long r2 = ((TextRange) r0.component2()).unbox-impl();
        PlatformSelectionBehaviors r3 = this.platformSelectionBehaviors;
        if (r3 == null) goto L14;
        Object r6 = r3.mo1836onShowContextMenuSbBc2M(r1, r2, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r6;
    L12:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    private final void m1860setCurrentDragPosition_kEHs6E(Offset r2) {
        this.currentDragPosition$delegate.setValue(r2);
    }

    /* JADX INFO: renamed from: setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    private final void m1861setDragBeginPositionk4lQ0M(long r2) {
        this.dragBeginPosition$delegate.setValue(Offset.box-impl(r2));
    }

    /* JADX INFO: renamed from: setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    private final void m1862setDragTotalDistancek4lQ0M(long r2) {
        this.dragTotalDistance$delegate.setValue(Offset.box-impl(r2));
    }

    private final void setDraggingHandle(Handle r2) {
        this.draggingHandle$delegate.setValue(r2);
    }

    /* JADX INFO: renamed from: setEndHandlePosition-_kEHs6E, reason: not valid java name */
    private final void m1863setEndHandlePosition_kEHs6E(Offset r2) {
        this.endHandlePosition$delegate.setValue(r2);
    }

    private final void setPositionChangeState(Unit r2) {
        this.positionChangeState$delegate.setValue(r2);
    }

    /* JADX INFO: renamed from: setStartHandlePosition-_kEHs6E, reason: not valid java name */
    private final void m1864setStartHandlePosition_kEHs6E(Offset r2) {
        this.startHandlePosition$delegate.setValue(r2);
    }

    public final void forEachSelectableWithSelection$foundation_release(Function4<? super Long, ? super AnnotatedString, ? super TextRange, ? super Boolean, Boolean> r14) {
        List<Selectable> r0 = access$getSelectionRegistrar$p(this).sort(requireContainerCoordinates$foundation_release());
        ListIterator<Selectable> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L13;
        Selectable r2 = r1.previous();
        Selection r3 = access$getSelectionRegistrar$p(this).getSubselections().get(r2.getSelectableId());
        if (r3 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L4;
        int r5 = r1.nextIndex();
    L14:
        if (r5 != (-1)) goto L16;
        return;
    L16:
        int r6 = r0.size();
        int r7 = 0;
    L17:
        if (r7 >= r6) goto L28;
        Selectable r8 = (Selectable) ListProtector.get(r0, r7);
        Selection r9 = access$getSelectionRegistrar$p(this).getSubselections().get(r8.getSelectableId());
        if (r9 == null) goto L27;
        AnnotatedString r10 = r8.getText();
        long r11 = TextRangeKt.TextRange(r9.getStart().getOffset(), r9.getEnd().getOffset());
        if (r7 < r5) goto L23;
        boolean r12 = true;
    L25:
        if (((Boolean) r14.invoke(Long.valueOf(r8.getSelectableId()), r10, TextRange.box-impl(r11), Boolean.valueOf(r12))).booleanValue() == true) goto L27;
        return;
    L23:
        r12 = false;
    L27:
        r7 = r7 + 1;
        goto L17
    L28:
        return;
    L8:
        if (r3.getStart().getOffset() == r3.getEnd().getOffset()) goto L10;
        r4 = true;
        goto L11
    L13:
        r5 = -1;
        goto L14
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo r4) {
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(r4.getSelectableId());
    }

    public final TextDragObserver handleDragObserver(final boolean r2) {
        return new AnonymousClass1(r2, this);
    }

    /* JADX INFO: renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M, reason: not valid java name */
    public final void m1871selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long r13) {
        LayoutCoordinates r0 = this.containerLayoutCoordinates;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isAttached() == true) goto L8;
        return;
    L8:
        List<Selectable> r1 = this.selectionRegistrar.getSelectables$foundation_release();
        int r2 = r1.size();
        boolean r3 = false;
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L24;
        Selectable r6 = (Selectable) ListProtector.get(r1, r4);
        Selection r7 = this.selectionRegistrar.getSubselections().get(r6.getSelectableId());
        if (r7 != null) goto L14;
    L13:
        boolean r8 = false;
    L21:
        if (r8 == true) goto L22;
        r4 = r4 + 1;
        goto L10
    L22:
        r3 = true;
        goto L24
    L14:
        LayoutCoordinates r9 = r6.getLayoutCoordinates();
        if (r9 == null) goto L13;
        long r10 = r9.localPositionOf-R5De75A(r0, r13);
        TextLayoutResult r11 = r6.textLayoutResult();
        if (r11 == null) goto L13;
        r8 = TextLayoutHelperKt.m1478isPositionInsideSelectionuaM50fQ(r11, r10, TextRange.box-impl(r7.m1845toTextRanged9O1mEE()));
    L24:
        if (r3 == true) goto L29;
        m1865startSelection9KIMszo(r13, true, SelectionAdjustment.Companion.getWord());
        return;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates r3) {
        this.containerLayoutCoordinates = r3;
        if (getHasFocus() == true) goto L5;
        return;
    L5:
        if (getSelection() == null) goto L14;
        if (r3 == null) goto L8;
        Offset r4 = Offset.box-impl(LayoutCoordinatesKt.positionInWindow(r3));
    L10:
        if (Intrinsics.areEqual(this.previousPosition, r4) == true) goto L15;
        this.previousPosition = r4;
        updateHandleOffsets();
        updateSelectionToolbar();
        return;
    L15:
        return;
    L8:
        r4 = null;
        goto L10
    }

    public final void setCoroutineScope$foundation_release(CoroutineScope r1) {
        this.coroutineScope = r1;
    }

    public final void setFocusRequester(FocusRequester r1) {
        this.focusRequester = r1;
    }

    public final void setHapticFeedBack(HapticFeedback r1) {
        this.hapticFeedBack = r1;
    }

    public final void setHasFocus(boolean r2) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setInTouchMode(boolean r2) {
        if (((Boolean) this._isInTouchMode.getValue()).booleanValue() == r2) goto L6;
        this._isInTouchMode.setValue(Boolean.valueOf(r2));
        updateSelectionToolbar();
        return;
    }

    public final void setOnCopyHandler(Function1<? super AnnotatedString, Unit> r1) {
        this.onCopyHandler = r1;
    }

    public final void setOnSelectionChange(final Function1<? super Selection, Unit> r2) {
        this.onSelectionChange = new y0(this, r2);
    }

    public final void setPlatformSelectionBehaviors$foundation_release(PlatformSelectionBehaviors r1) {
        this.platformSelectionBehaviors = r1;
    }

    public final void setPreviousSelectionLayout$foundation_release(SelectionLayout r1) {
        this.previousSelectionLayout = r1;
    }

    public final void setSelection(Selection r2) {
        this._selection.setValue(r2);
        if (r2 == null) goto L6;
        updateHandleOffsets();
        return;
    }

    public final void setShowToolbar$foundation_release(boolean r1) {
        this.showToolbar = r1;
        updateSelectionToolbar();
    }

    public final void setTextToolbar(TextToolbar r1) {
        this.textToolbar = r1;
    }

    public final void setToolbarRequester$foundation_release(ToolbarRequester r1) {
        this.toolbarRequester = r1;
    }

    private static final Rect _get_contextMenuAreaModifier_$lambda$7(SelectionManager r1, LayoutCoordinates r2) {
        Rect r0 = r1.getDerivedContentRect();
        if (r0 != null) goto L6;
        return null;
    L6:
        LayoutCoordinates r3 = r1.containerLayoutCoordinates;
        if (r3 != null) goto L9;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    L9:
        return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(r0, r3, r2);
    }

    private static final Unit _get_modifier_$lambda$3(SelectionManager r0, LayoutCoordinates r1) {
        r0.setContainerLayoutCoordinates(r1);
        return Unit.INSTANCE;
    }

    private static final Unit _get_modifier_$lambda$4(SelectionManager r1, FocusState r2) {
        if (r2.getHasFocus() == false) goto L5;
    L7:
        r1.setHasFocus(r2.getHasFocus());
        return Unit.INSTANCE;
    L5:
        if (r1.getHasFocus() == false) goto L7;
        r1.onRelease();
        goto L7
    }

    private static final Unit _get_modifier_$lambda$5(SelectionManager r0, boolean r1) {
        r0.setInTouchMode(r1);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$15(SelectionManager r1, long r2) {
        if (r1.selectionRegistrar.getSubselections().containsKey(r2) == false) goto L6;
        r1.onRelease();
        r1.setSelection(null);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$16(SelectionManager r6, long r7) {
        Selection r0 = r6.getSelection();
        boolean r1 = true;
        if (r0 == null) goto L9;
        Selection.AnchorInfo r2 = r0.getStart();
        if (r2 == null) goto L9;
        if (r7 != r2.getSelectableId()) goto L9;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        r6.m1864setStartHandlePosition_kEHs6E(null);
    L13:
        Selection r4 = r6.getSelection();
        if (r4 == null) goto L20;
        Selection.AnchorInfo r5 = r4.getEnd();
        if (r5 == null) goto L20;
        if (r7 != r5.getSelectableId()) goto L20;
    L21:
        if (r1 == false) goto L24;
        r6.m1863setEndHandlePosition_kEHs6E(null);
    L24:
        if (r6.selectionRegistrar.getSubselections().containsKey(r7) == false) goto L27;
        r6.updateSelectionToolbar();
    L27:
        return Unit.INSTANCE;
    L20:
        r1 = false;
    L9:
        r3 = false;
        goto L11
    }

    private static final Unit _init_$lambda$9(SelectionManager r1, long r2) {
        if (r1.selectionRegistrar.getSubselections().containsKey(r2) == false) goto L6;
        r1.setPositionChangeState(Unit.INSTANCE);
        r1.updateHandleOffsets();
        r1.updateSelectionToolbar();
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$notifyPlatformSelectionBehaviorsOnShowContextMenu(SelectionManager r0, Continuation r1) {
        return r0.notifyPlatformSelectionBehaviorsOnShowContextMenu(r1);
    }

    /* JADX INFO: renamed from: access$setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public static final /* synthetic */ void m1855access$setCurrentDragPosition_kEHs6E(SelectionManager r0, Offset r1) {
        r0.m1860setCurrentDragPosition_kEHs6E(r1);
    }

    /* JADX INFO: renamed from: access$setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    public static final /* synthetic */ void m1856access$setDragBeginPositionk4lQ0M(SelectionManager r0, long r1) {
        r0.m1861setDragBeginPositionk4lQ0M(r1);
    }

    /* JADX INFO: renamed from: access$setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    public static final /* synthetic */ void m1857access$setDragTotalDistancek4lQ0M(SelectionManager r0, long r1) {
        r0.m1862setDragTotalDistancek4lQ0M(r1);
    }

    public static final /* synthetic */ void access$setDraggingHandle(SelectionManager r0, Handle r1) {
        r0.setDraggingHandle(r1);
    }

    /* JADX INFO: renamed from: convertToContainerCoordinates-R5De75A, reason: not valid java name */
    private final long m1858convertToContainerCoordinatesR5De75A(LayoutCoordinates r2, long r3) {
        LayoutCoordinates r0 = this.containerLayoutCoordinates;
        if (r0 == null) goto L10;
        if (r0.isAttached() == false) goto L10;
        return requireContainerCoordinates$foundation_release().localPositionOf-R5De75A(r2, r3);
    L10:
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    private final Modifier onClearSelectionRequested(Modifier r3, final Function0<Unit> r4) {
        return SuspendingPointerInputFilterKt.pointerInput(r3, Unit.INSTANCE, new C02341(this, r4));
    }

    private static final Unit onSelectionChange$lambda$0(SelectionManager r0, Selection r1) {
        r0.setSelection(r1);
        return Unit.INSTANCE;
    }

    private final void selectionChanged(SelectionLayout r3, Selection r4) {
        if (shouldPerformHaptics$foundation_release() == false) goto L7;
        HapticFeedback r0 = this.hapticFeedBack;
        if (r0 == null) goto L7;
        r0.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
    L7:
        this.selectionRegistrar.setSubselections(r3.createSubSelections(r4));
        this.onSelectionChange.invoke(r4);
    }

    public final Pair<Selection, LongObjectMap<Selection>> selectAllInSelectable$foundation_release(long r11, Selection r13) {
        MutableLongObjectMap r0 = LongObjectMapKt.mutableLongObjectMapOf();
        List<Selectable> r1 = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int r2 = r1.size();
        int r4 = 0;
        Selection r5 = null;
    L3:
        if (r4 >= r2) goto L12;
        Selectable r6 = (Selectable) ListProtector.get(r1, r4);
        if (r6.getSelectableId() != r11) goto L7;
        Selection r7 = r6.getSelectAllSelection();
    L8:
        if (r7 == null) goto L10;
        r0.set(r6.getSelectableId(), r7);
    L10:
        r5 = SelectionManagerKt.merge(r5, r7);
        r4 = r4 + 1;
        goto L3
    L7:
        r7 = null;
        goto L8
    L12:
        if (isInTouchMode() == false) goto L19;
        if (Intrinsics.areEqual(r5, r13) == true) goto L19;
        HapticFeedback r12 = this.hapticFeedBack;
        if (r12 == null) goto L19;
        r12.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
    L19:
        return new Pair(r5, r0);
    }

    private static final Unit _init_$lambda$12(SelectionManager r1, boolean r2, long r3) {
        Pair<Selection, LongObjectMap<Selection>> r4 = r1.selectAllInSelectable$foundation_release(r3, r1.getSelection());
        Selection r5 = (Selection) r4.component1();
        LongObjectMap<Selection> r6 = (LongObjectMap) r4.component2();
        if (Intrinsics.areEqual(r5, r1.getSelection()) == true) goto L5;
        r1.selectionRegistrar.setSubselections(r6);
        r1.onSelectionChange.invoke(r5);
    L5:
        r1.setInTouchMode(r2);
        FocusRequester.requestFocus-3ESFkO8$default(r1.focusRequester, 0, 1, null);
        r1.setShowToolbar$foundation_release(false);
        return Unit.INSTANCE;
    }

    private static final Unit _set_onSelectionChange_$lambda$1(SelectionManager r0, Function1 r1, Selection r2) {
        r0.setSelection(r2);
        r1.invoke(r2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getSelectionLayout-Wko1d7g, reason: not valid java name */
    private final SelectionLayout m1859getSelectionLayoutWko1d7g(long r16, long r18, boolean r20) {
        LayoutCoordinates r5 = requireContainerCoordinates$foundation_release();
        List<Selectable> r11 = this.selectionRegistrar.sort(r5);
        final MutableLongIntMap r0 = LongIntMapKt.mutableLongIntMapOf();
        List<Selectable> r12 = r11;
        int r1 = r12.size();
        int r13 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.set(((Selectable) ListProtector.get(r11, r2)).getSelectableId(), r2);
        r2 = r2 + 1;
        goto L3
    L5:
        Comparator r8 = new SelectionManager$getSelectionLayoutWko1d7g$$inlined$compareBy$1(r0);
        if ((r18 & SieveCacheKt.InvalidMapping) != 9205357640488583168L) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        Selection r4 = null;
    L12:
        SelectionLayoutBuilder r14 = new SelectionLayoutBuilder(r16, r18, r5, r20, r4, r8, null);
        int r6 = r12.size();
    L13:
        if (r13 >= r6) goto L16;
        ((Selectable) ListProtector.get(r11, r13)).appendSelectableInfoToBuilder(r14);
        r13 = r13 + 1;
        goto L13
    L16:
        return r14.build();
    L11:
        r4 = getSelection();
        goto L12
    L8:
        r3 = false;
        goto L9
    }

    /* JADX INFO: renamed from: startSelection-9KIMszo, reason: not valid java name */
    private final void m1865startSelection9KIMszo(long r9, boolean r11, SelectionAdjustment r12) {
        this.previousSelectionLayout = null;
        m1872updateSelectionjyLRC_s$foundation_release(r9, Offset.Companion.getUnspecified-F1C5BW0(), r11, r12);
    }

    /* JADX INFO: renamed from: updateSelection-jyLRC_s$foundation_release, reason: not valid java name */
    public final boolean m1872updateSelectionjyLRC_s$foundation_release(long r2, long r4, boolean r6, SelectionAdjustment r7) {
        if (r6 == false) goto L4;
        Handle r0 = Handle.SelectionStart;
    L5:
        setDraggingHandle(r0);
        m1860setCurrentDragPosition_kEHs6E(Offset.box-impl(r2));
        SelectionLayout r3 = m1859getSelectionLayoutWko1d7g(r2, r4, r6);
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.shouldRecomputeSelection(this.previousSelectionLayout) == true) goto L11;
        return false;
    L11:
        Selection r5 = r7.adjust(r3);
        if (Intrinsics.areEqual(r5, getSelection()) == true) goto L14;
        selectionChanged(r3, r5);
        this.isLongPressOrClickSelection = false;
    L14:
        this.previousSelectionLayout = r3;
        return true;
    L4:
        r0 = Handle.SelectionEnd;
        goto L5
    }

    /* JADX INFO: renamed from: updateSelection-qNKwrvQ$foundation_release, reason: not valid java name */
    public final boolean m1873updateSelectionqNKwrvQ$foundation_release(Offset r8, long r9, boolean r11, SelectionAdjustment r12) {
        if (r8 != null) goto L6;
        return false;
    L6:
        return m1872updateSelectionjyLRC_s$foundation_release(r8.unbox-impl(), r9, r11, r12);
    }

    private static final Unit _init_$lambda$11(SelectionManager r7, boolean r8, LayoutCoordinates r9, Offset r10, SelectionAdjustment r11) {
        long r0 = r9.getSize-YbymL2g();
        Rect r2 = new Rect(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, (int) (r0 >> 32), (int) (r0 & 4294967295L));
        if (SelectionManagerKt.m1878containsInclusiveUv8p0NA(r2, r10.unbox-impl()) == false) goto L5;
        long r1 = r10.unbox-impl();
    L6:
        long r12 = r7.m1858convertToContainerCoordinatesR5De75A(r9, r1);
        if ((SieveCacheKt.InvalidMapping & r12) == 9205357640488583168L) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        r7.setInTouchMode(r8);
        r7.m1865startSelection9KIMszo(r12, false, r11);
        FocusRequester.requestFocus-3ESFkO8$default(r7.focusRequester, 0, 1, null);
        r7.setShowToolbar$foundation_release(false);
        r7.isLongPressOrClickSelection = true;
    L13:
        return Unit.INSTANCE;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = TextLayoutStateKt.m1666coerceIn3MmeM6k(r10.unbox-impl(), r2);
        goto L6
    }

    private static final boolean _init_$lambda$13(SelectionManager r8, boolean r9, LayoutCoordinates r10, Offset r11, Offset r12, boolean r13, SelectionAdjustment r14) {
        long r0 = r8.m1858convertToContainerCoordinatesR5De75A(r10, r11.unbox-impl());
        long r4 = r8.m1858convertToContainerCoordinatesR5De75A(r10, r12.unbox-impl());
        r8.setInTouchMode(r9);
        return r8.m1873updateSelectionqNKwrvQ$foundation_release(Offset.box-impl(r0), r4, r13, r14);
    }
}
