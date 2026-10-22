package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.AutofillHighlightKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.ui.platform.PlatformTextInputSessionScope;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000ÿ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001]\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000bBs\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\f\u0010l\u001a\u00020!*\u00020mH\u0016J\u000e\u0010n\u001a\u00020!H\u0082@¢\u0006\u0002\u0010oJr\u0010p\u001a\u00020!2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 J\f\u0010s\u001a\u00020!*\u00020tH\u0016J\b\u0010u\u001a\u00020!H\u0002J\b\u0010v\u001a\u00020!H\u0002J\b\u0010w\u001a\u00020!H\u0016J\b\u0010x\u001a\u00020!H\u0016J\u0010\u0010y\u001a\u00020!2\u0006\u0010z\u001a\u00020{H\u0016J,\u0010|\u001a\u00020!2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020!H\u0016J\u001c\u0010\u0086\u0001\u001a\u00020\u00152\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001c\u0010\u008b\u0001\u001a\u00020\u00152\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008a\u0001J\t\u0010\u008d\u0001\u001a\u00020!H\u0016J\t\u0010\u008e\u0001\u001a\u00020!H\u0002J\u0011\u0010\u008f\u0001\u001a\u00020!2\u0006\u0010z\u001a\u00020{H\u0016J\u001c\u0010\u0090\u0001\u001a\u00020!2\b\u0010\u0091\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0012\u0010\u0094\u0001\u001a\u00020!2\u0007\u0010\u0095\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0096\u0001\u001a\u00020!H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J\t\u0010\u0099\u0001\u001a\u00020!H\u0002J\u001c\u0010\u009a\u0001\u001a\u00020\u00152\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u001c\u0010\u009f\u0001\u001a\u00020\u00152\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0006\b \u0001\u0010\u009e\u0001R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\u001b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\u001e\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u00105\"\u0004\bH\u00107R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u00105R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0004\n\u0002\u0010^R\u0010\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u0010\u0010b\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0dX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010g\u001a\u00020\u00152\u0006\u0010f\u001a\u00020\u00158B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bh\u00105\"\u0004\bi\u00107R\u0014\u0010q\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u00105¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPassword", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlinx/coroutines/flow/MutableSharedFlow;)V", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "getTextLayoutState", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;)V", "getFilter", "()Landroidx/compose/foundation/text/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text/input/InputTransformation;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getReadOnly", "setReadOnly", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "setKeyboardOptions", "(Landroidx/compose/foundation/text/KeyboardOptions;)V", "getKeyboardActionHandler", "()Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "setKeyboardActionHandler", "(Landroidx/compose/foundation/text/input/KeyboardActionHandler;)V", "getSingleLine", "setSingleLine", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "setPassword", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "setStylusHandwritingTrigger", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "dragEnterEvent", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "isFocused", "toolbarAndHandlesVisibilityObserverJob", "Lkotlinx/coroutines/Job;", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "keyboardActionScope", "androidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "Lkotlin/jvm/functions/Function1;", "inputSessionJob", "receiveContentConfigurationProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "<set-?>", "autofillHighlightOn", "getAutofillHighlightOn", "setAutofillHighlightOn", "autofillHighlightOn$delegate", "Landroidx/compose/runtime/MutableState;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "observeUntransformedTextChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNode", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "requestFocus", "onIsFocusedUpdated", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onPreKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onPreKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onKeyEvent", "onKeyEvent-ZmokQxo", "onObservedReadsChanged", "updateWindowFocus", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "startInputSession", "fromTap", "disposeInputSession", "requireKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "emitDragExitEvent", "onImeActionPerformed", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed-KlQnJC8", "(I)Z", "defaultKeyboardActionWithResult", "defaultKeyboardActionWithResult-KlQnJC8", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements DrawModifierNode, PlatformTextInputModifierNode, SemanticsModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ModifierLocalModifierNode, ObserverModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private final MutableState autofillHighlightOn$delegate;
    private final Function1<? super KeyCommand, ? extends Unit> clipboardKeyCommandsHandler;
    private final DragAndDropTargetModifierNode dragAndDropNode;
    private HoverInteraction.Enter dragEnterEvent;
    private boolean enabled;
    private InputTransformation filter;
    private final FocusableNode focusableNode;
    private Job inputSessionJob;
    private MutableInteractionSource interactionSource;
    private boolean isPassword;
    private KeyboardActionHandler keyboardActionHandler;
    private final TextFieldDecoratorModifierNode$keyboardActionScope$1 keyboardActionScope;
    private KeyboardOptions keyboardOptions;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private boolean readOnly;
    private final Function0<ReceiveContentConfiguration> receiveContentConfigurationProvider;
    private boolean singleLine;
    private MutableSharedFlow<Unit> stylusHandwritingTrigger;
    private final TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private Job toolbarAndHandlesVisibilityObserverJob;
    private WindowInfo windowInfo;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onIsFocusedUpdated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onIsFocusedUpdated$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {672}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TextFieldDecoratorModifierNode this$0;

        public AnonymousClass1(TextFieldDecoratorModifierNode r1, Continuation<? super AnonymousClass1> r2) {
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
            TextFieldSelectionState r5 = this.this$0.getTextFieldSelectionState();
            this.label = 1;
            if (r5.startToolbarAndHandlesVisibilityObserver(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {771}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
        int label;
        final /* synthetic */ TextFieldDecoratorModifierNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {772}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00381 extends SuspendLambda implements Function2<PlatformTextInputSessionScope, Continuation<?>, Object> {
            final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TextFieldDecoratorModifierNode this$0;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class C00391 extends AdaptedFunctionReference implements Function1<ImeAction, Unit> {
                public C00391(Object r8) {
                    super(1, r8, TextFieldDecoratorModifierNode.class, "onImeActionPerformed", "onImeActionPerformed-KlQnJC8(I)Z", 8);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                    m1645invokeKlQnJC8(((ImeAction) r1).unbox-impl());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
                public final void m1645invokeKlQnJC8(int r2) {
                    TextFieldDecoratorModifierNode.m1637access$onImeActionPerformedKlQnJC8((TextFieldDecoratorModifierNode) ((AdaptedFunctionReference) this).receiver, r2);
                }
            }

            public C00381(TextFieldDecoratorModifierNode r1, ReceiveContentConfiguration r2, Continuation<? super C00381> r3) {
                this.this$0 = r1;
                this.$receiveContentConfiguration = r2;
                super(2, r3);
            }

            public static /* synthetic */ Unit a(TextFieldDecoratorModifierNode r0) {
                return invokeSuspend$lambda$0(r0);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                C00381 r0 = new C00381(this.this$0, this.$receiveContentConfiguration, r5);
                r0.L$0 = r4;
                return r0;
            }

            public final Object invoke(PlatformTextInputSessionScope r1, Continuation<?> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((PlatformTextInputSessionScope) r1, (Continuation) r2);
            }

            private static final Unit invokeSuspend$lambda$0(TextFieldDecoratorModifierNode r1) {
                r1.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.Selection);
                return Unit.INSTANCE;
            }

            public final Object invokeSuspend(Object r14) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r14);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r14);
                PlatformTextInputSessionScope r3 = (PlatformTextInputSessionScope) this.L$0;
                TransformedTextFieldState r4 = this.this$0.getTextFieldState();
                TextLayoutState r5 = this.this$0.getTextLayoutState();
                ImeOptions r6 = this.this$0.getKeyboardOptions().toImeOptions$foundation_release(this.this$0.getSingleLine());
                ReceiveContentConfiguration r7 = this.$receiveContentConfiguration;
                C00391 r8 = new C00391(this.this$0);
                final TextFieldDecoratorModifierNode r15 = this.this$0;
                Function0 r9 = new u1(r15);
                MutableSharedFlow<Unit> r10 = r15.getStylusHandwritingTrigger();
                ViewConfiguration r11 = (ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalViewConfiguration());
                this.label = 1;
                if (AndroidTextInputSession_androidKt.platformSpecificTextInputSession(r3, r4, r5, r6, r7, r8, r9, r10, r11, this) != r0) goto L12;
                return r0;
            }
        }

        public C02131(TextFieldDecoratorModifierNode r1, ReceiveContentConfiguration r2, Continuation<? super C02131> r3) {
            this.this$0 = r1;
            this.$receiveContentConfiguration = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02131(this.this$0, this.$receiveContentConfiguration, r4);
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            TextFieldDecoratorModifierNode r7 = this.this$0;
            C00381 r2 = new C00381(r7, this.$receiveContentConfiguration, null);
            this.label = 1;
            if (PlatformTextInputModifierNodeKt.establishTextInputSession(r7, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$updateNode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$updateNode$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {496}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextFieldSelectionState $textFieldSelectionState;
        int label;

        public C02141(TextFieldSelectionState r1, Continuation<? super C02141> r2) {
            this.$textFieldSelectionState = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02141(this.$textFieldSelectionState, r3);
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
            TextFieldSelectionState r5 = this.$textFieldSelectionState;
            this.label = 1;
            if (r5.startToolbarAndHandlesVisibilityObserver(this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Unit A(TextFieldDecoratorModifierNode r0) {
        return updateWindowFocus$lambda$31(r0);
    }

    public static /* synthetic */ boolean a(boolean r0, TextFieldDecoratorModifierNode r1, AnnotatedString r2) {
        return applySemantics$lambda$19(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(TextFieldDecoratorModifierNode r0, Offset r1) {
        return dragAndDropNode$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit c(TextFieldDecoratorModifierNode r0, DragAndDropEvent r1) {
        return dragAndDropNode$lambda$7(r0, r1);
    }

    public static /* synthetic */ boolean d(TextFieldDecoratorModifierNode r0, ClipEntry r1, ClipMetadata r2) {
        return dragAndDropNode$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ boolean e(TextFieldDecoratorModifierNode r0, int r1) {
        return applySemantics$lambda$21(r0, r1);
    }

    public static /* synthetic */ Unit f(TextFieldDecoratorModifierNode r0, DragAndDropEvent r1) {
        return dragAndDropNode$lambda$9(r0, r1);
    }

    public static /* synthetic */ ReceiveContentConfiguration g(TextFieldDecoratorModifierNode r0) {
        return receiveContentConfigurationProvider$lambda$12(r0);
    }

    public static /* synthetic */ boolean h(TextFieldDecoratorModifierNode r0) {
        return applySemantics$lambda$25(r0);
    }

    public static /* synthetic */ Unit i(TextFieldDecoratorModifierNode r0, KeyCommand r1) {
        return clipboardKeyCommandsHandler$lambda$11(r0, r1);
    }

    public static /* synthetic */ Unit j(TextFieldDecoratorModifierNode r0, DragAndDropEvent r1) {
        return dragAndDropNode$lambda$10(r0, r1);
    }

    public static /* synthetic */ boolean k(boolean r0, TextFieldDecoratorModifierNode r1, AnnotatedString r2) {
        return applySemantics$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ Unit l(TextFieldDecoratorModifierNode r0, DragAndDropEvent r1) {
        return dragAndDropNode$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit m(TextFieldDecoratorModifierNode r0, int r1) {
        return onImeActionPerformed_KlQnJC8$lambda$33(r0, r1);
    }

    public static /* synthetic */ Unit n(TextFieldDecoratorModifierNode r0, boolean r1) {
        return focusableNode$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit o(TextFieldDecoratorModifierNode r0) {
        return updateNode$lambda$14(r0);
    }

    public static /* synthetic */ Unit p(TextFieldDecoratorModifierNode r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ Set q(TextFieldDecoratorModifierNode r0) {
        return dragAndDropNode$lambda$3(r0);
    }

    public static /* synthetic */ String r(TextFieldDecoratorModifierNode r0) {
        return observeUntransformedTextChanges$lambda$13(r0);
    }

    public static /* synthetic */ boolean s(TextFieldDecoratorModifierNode r0, List r1) {
        return applySemantics$lambda$17(r0, r1);
    }

    public static /* synthetic */ boolean t(TextFieldDecoratorModifierNode r0) {
        return applySemantics$lambda$26(r0);
    }

    public static /* synthetic */ boolean u(TextFieldDecoratorModifierNode r0) {
        return onKeyEvent_ZmokQxo$lambda$30(r0);
    }

    public static /* synthetic */ boolean v(TextFieldDecoratorModifierNode r0) {
        return applySemantics$lambda$23(r0);
    }

    public static /* synthetic */ boolean w(TextFieldDecoratorModifierNode r0) {
        return applySemantics$lambda$24(r0);
    }

    public static /* synthetic */ boolean x(TextFieldDecoratorModifierNode r0) {
        return applySemantics$lambda$22(r0);
    }

    public static /* synthetic */ boolean y(boolean r0, TextFieldDecoratorModifierNode r1, AnnotatedString r2) {
        return applySemantics$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ boolean z(TextFieldDecoratorModifierNode r0, int r1, int r2, boolean r3) {
        return applySemantics$lambda$20(r0, r1, r2, r3);
    }

    public final /* synthetic */ Object getCurrent(ModifierLocal r1) {
        return ModifierLocalModifierNode.-CC.$default$getCurrent(this, r1);
    }

    public final /* synthetic */ ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNode.-CC.$default$getProvidedValues(this);
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final /* synthetic */ long m1640getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.-CC.$default$getTouchBoundsExpansion-RZrCHBk(this);
    }

    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.-CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    public final /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.-CC.$default$onDensityChange(this);
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.-CC.$default$onViewConfigurationChange(this);
    }

    public final /* synthetic */ void provide(ModifierLocal r1, Object r2) {
        ModifierLocalModifierNode.-CC.$default$provide(this, r1, r2);
    }

    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.-CC.$default$sharePointerInputWithSiblings(this);
    }

    private final void disposeInputSession() {
        Job r0 = this.inputSessionJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.inputSessionJob = null;
        MutableSharedFlow<Unit> r1 = this.stylusHandwritingTrigger;
        if (r1 == null) goto L9;
        r1.resetReplayCache();
        return;
    }

    private final void emitDragExitEvent() {
        HoverInteraction.Enter r0 = this.dragEnterEvent;
        if (r0 == null) goto L6;
        this.interactionSource.tryEmit(new HoverInteraction.Exit(r0));
        this.dragEnterEvent = null;
        return;
    }

    private final boolean getAutofillHighlightOn() {
        return ((Boolean) this.autofillHighlightOn$delegate.getValue()).booleanValue();
    }

    private final boolean isFocused() {
        if (this.focusableNode.getFocusState().isFocused() == false) goto L13;
        WindowInfo r0 = this.windowInfo;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.isWindowFocused() != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    private final void onIsFocusedUpdated() {
        this.textFieldSelectionState.setFocused(isFocused());
        if (isFocused() == false) goto L8;
        if (this.toolbarAndHandlesVisibilityObserverJob != null) goto L8;
        this.toolbarAndHandlesVisibilityObserverJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L8:
        if (isFocused() == true) goto L15;
        Job r0 = this.toolbarAndHandlesVisibilityObserverJob;
        if (r0 == null) goto L12;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L12:
        this.toolbarAndHandlesVisibilityObserverJob = null;
        return;
    }

    private final void requestFocus() {
        if (this.focusableNode.isAttached() == false) goto L6;
        this.focusableNode.requestFocus();
        return;
    }

    private final void updateWindowFocus() {
        ObserverModifierNodeKt.observeReads(this, new j1(this));
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    private final SoftwareKeyboardController requireKeyboardController() {
        SoftwareKeyboardController r0 = (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("No software keyboard controller".toString());
    }

    public void onAttach() {
        onObservedReadsChanged();
        this.textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
        if (this.enabled == false) goto L6;
        delegate(this.focusableNode);
        return;
    }

    public void onDetach() {
        disposeInputSession();
        this.textFieldSelectionState.setReceiveContentConfiguration(null);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final InputTransformation getFilter() {
        return this.filter;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final KeyboardActionHandler getKeyboardActionHandler() {
        return this.keyboardActionHandler;
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final MutableSharedFlow<Unit> getStylusHandwritingTrigger() {
        return this.stylusHandwritingTrigger;
    }

    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    public final boolean isPassword() {
        return this.isPassword;
    }

    public void onObservedReadsChanged() {
        updateWindowFocus();
    }

    private static final Unit _init_$lambda$0(TextFieldDecoratorModifierNode r0) {
        DelegatableNodeKt.requestAutofill(r0);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Job access$getInputSessionJob$p(TextFieldDecoratorModifierNode r0) {
        return r0.inputSessionJob;
    }

    public static final /* synthetic */ void access$requestFocus(TextFieldDecoratorModifierNode r0) {
        r0.requestFocus();
    }

    public static final /* synthetic */ SoftwareKeyboardController access$requireKeyboardController(TextFieldDecoratorModifierNode r0) {
        return r0.requireKeyboardController();
    }

    private static final boolean applySemantics$lambda$22(TextFieldDecoratorModifierNode r1) {
        if (r1.isFocused() == true) goto L6;
        r1.requestFocus();
        return true;
    L6:
        if (r1.readOnly == true) goto L11;
        r1.requireKeyboardController().show();
        return true;
    L11:
        return true;
    }

    private static final boolean applySemantics$lambda$23(TextFieldDecoratorModifierNode r1) {
        if (r1.isFocused() == true) goto L5;
        r1.requestFocus();
    L5:
        r1.textFieldSelectionState.updateTextToolbarState(TextToolbarState.Selection);
        return true;
    }

    private static final boolean applySemantics$lambda$24(TextFieldDecoratorModifierNode r6) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$9$1(r6, null), 3, null);
        return true;
    }

    private static final boolean applySemantics$lambda$25(TextFieldDecoratorModifierNode r6) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$10$1(r6, null), 3, null);
        return true;
    }

    private static final boolean applySemantics$lambda$26(TextFieldDecoratorModifierNode r6) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$11$1(r6, null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: defaultKeyboardActionWithResult-KlQnJC8, reason: not valid java name */
    private final boolean m1638defaultKeyboardActionWithResultKlQnJC8(int r4) {
        ImeAction.Companion r0 = ImeAction.Companion;
        if (ImeAction.equals-impl0(r4, r0.getNext-eUduSuo()) == false) goto L6;
        ((FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager())).moveFocus-3ESFkO8(FocusDirection.Companion.getNext-dhqQ-8s());
        return true;
    L6:
        if (ImeAction.equals-impl0(r4, r0.getPrevious-eUduSuo()) == false) goto L9;
        ((FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager())).moveFocus-3ESFkO8(FocusDirection.Companion.getPrevious-dhqQ-8s());
        return true;
    L9:
        if (ImeAction.equals-impl0(r4, r0.getDone-eUduSuo()) == false) goto L11;
        requireKeyboardController().hide();
        return true;
    L11:
        return false;
    }

    private static final Set dragAndDropNode$lambda$3(TextFieldDecoratorModifierNode r0) {
        if (ReceiveContentConfigurationKt.getReceiveContentConfiguration(r0) == null) goto L6;
        return TextFieldDecoratorModifierKt.access$getMediaTypesAll$p();
    L6:
        return TextFieldDecoratorModifierKt.access$getMediaTypesText$p();
    }

    private final Object observeUntransformedTextChanges(Continuation<? super Unit> r3) {
        Object r4 = new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(kotlinx.coroutines.flow.e.p(SnapshotStateKt.snapshotFlow(new k1(this)), 1)).collect(new AnonymousClass3(this), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    private static final String observeUntransformedTextChanges$lambda$13(TextFieldDecoratorModifierNode r0) {
        return r0.textFieldState.getUntransformedText().toString();
    }

    /* JADX INFO: renamed from: onImeActionPerformed-KlQnJC8, reason: not valid java name */
    private final boolean m1639onImeActionPerformedKlQnJC8(final int r3) {
        ImeAction.Companion r0 = ImeAction.Companion;
        if (ImeAction.equals-impl0(r3, r0.getNone-eUduSuo()) == true) goto L14;
        if (ImeAction.equals-impl0(r3, r0.getDefault-eUduSuo()) == true) goto L14;
        KeyboardActionHandler r1 = this.keyboardActionHandler;
        if (r1 == null) goto L14;
        if (r1 == null) goto L15;
        r1.onKeyboardAction(new w0(this, r3));
        return true;
    L15:
        return true;
    L14:
        return m1638defaultKeyboardActionWithResultKlQnJC8(r3);
    }

    private static final boolean onKeyEvent_ZmokQxo$lambda$30(TextFieldDecoratorModifierNode r1) {
        return r1.m1639onImeActionPerformedKlQnJC8(r1.keyboardOptions.m1386getImeActionOrDefaulteUduSuo$foundation_release());
    }

    private static final ReceiveContentConfiguration receiveContentConfigurationProvider$lambda$12(TextFieldDecoratorModifierNode r0) {
        return ReceiveContentConfigurationKt.getReceiveContentConfiguration(r0);
    }

    private final void setAutofillHighlightOn(boolean r2) {
        this.autofillHighlightOn$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void startInputSession(boolean r7) {
        if (r7 == false) goto L4;
    L6:
        ReceiveContentConfiguration r8 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(this);
        this.inputSessionJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new C02131(this, r8, null), 3, null);
        return;
    L4:
        if (this.keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release() == true) goto L6;
    }

    private static final Unit updateNode$lambda$14(TextFieldDecoratorModifierNode r0) {
        DelegatableNodeKt.requestAutofill(r0);
        return Unit.INSTANCE;
    }

    private static final Unit updateWindowFocus$lambda$31(TextFieldDecoratorModifierNode r1) {
        r1.windowInfo = (WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(r1, CompositionLocalsKt.getLocalWindowInfo());
        r1.onIsFocusedUpdated();
        return Unit.INSTANCE;
    }

    public void applySemantics(SemanticsPropertyReceiver r13) {
        TextFieldCharSequence r0 = this.textFieldState.getOutputText();
        long r1 = r0.m1535getSelectiond9O1mEE();
        SemanticsPropertiesKt.setInputText(r13, new AnnotatedString(this.textFieldState.getUntransformedText().toString(), null, 2, null));
        SemanticsPropertiesKt.setEditableText(r13, new AnnotatedString(r0.toString(), null, 2, null));
        SemanticsPropertiesKt.setTextSelectionRange-FDrldGo(r13, r1);
        if (this.enabled == true) goto L6;
        SemanticsPropertiesKt.disabled(r13);
    L6:
        if (this.isPassword == false) goto L9;
        SemanticsPropertiesKt.password(r13);
    L9:
        if (this.enabled == true) goto L11;
    L13:
        final boolean r2 = false;
    L14:
        SemanticsPropertiesKt.setEditable(r13, r2);
        SemanticsPropertiesKt.setContentDataType(r13, ContentDataType.Companion.getText());
        SemanticsPropertiesKt.onAutofillText$default(r13, null, new x0(r2, this), 1, null);
        SemanticsPropertiesKt.getTextLayoutResult$default(r13, null, new z0(this), 1, null);
        if (r2 == false) goto L17;
        SemanticsPropertiesKt.setText$default(r13, null, new a1(r2, this), 1, null);
        SemanticsPropertiesKt.insertTextAtCursor$default(r13, null, new b1(r2, this), 1, null);
    L17:
        SemanticsPropertiesKt.setSelection$default(r13, null, new d1(this), 1, null);
        final int r7 = this.keyboardOptions.m1386getImeActionOrDefaulteUduSuo$foundation_release();
        SemanticsPropertiesKt.onImeAction-9UiTYpY$default(r13, r7, null, new e1(this, r7), 2, null);
        SemanticsPropertiesKt.onClick$default(r13, null, new f1(this), 1, null);
        SemanticsPropertiesKt.onLongClick$default(r13, null, new g1(this), 1, null);
        if (TextRange.getCollapsed-impl(r1) == false) goto L20;
    L26:
        if (r2 == false) goto L28;
        SemanticsPropertiesKt.pasteText$default(r13, null, new y0(this), 1, null);
    L28:
        InputTransformation r3 = this.filter;
        if (r3 == null) goto L32;
        r3.applySemantics(r13);
    L32:
        if (this.enabled == false) goto L35;
        this.focusableNode.applySemantics(r13);
        return;
    L35:
        return;
    L20:
        if (this.isPassword == true) goto L26;
        SemanticsPropertiesKt.copyText$default(r13, null, new h1(this), 1, null);
        if (this.enabled == false) goto L26;
        if (this.readOnly == true) goto L26;
        SemanticsPropertiesKt.cutText$default(r13, null, new i1(this), 1, null);
        goto L26
    L11:
        if (this.readOnly == true) goto L13;
        r2 = true;
        goto L14
    }

    public void draw(ContentDrawScope r15) {
        r15.drawContent();
        if (getAutofillHighlightOn() == false) goto L6;
        DrawScope.-CC.drawRect-n-J9OG0$default(r15, ((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, AutofillHighlightKt.getLocalAutofillHighlightColor())).unbox-impl(), 0, 0, MenuKt.ClosedAlphaTarget, null, null, 0, 126, null);
        return;
    }

    public void onGloballyPositioned(LayoutCoordinates r2) {
        this.textLayoutState.setDecoratorNodeCoordinates(r2);
        if (this.enabled == false) goto L6;
        this.focusableNode.onGloballyPositioned(r2);
        return;
    }

    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean m1641onKeyEventZmokQxo(KeyEvent r11) {
        TextFieldKeyEventHandler r0 = this.textFieldKeyEventHandler;
        TransformedTextFieldState r2 = this.textFieldState;
        TextLayoutState r3 = this.textLayoutState;
        TextFieldSelectionState r4 = this.textFieldSelectionState;
        Function1<? super KeyCommand, ? extends Unit> r5 = this.clipboardKeyCommandsHandler;
        SoftwareKeyboardController r6 = requireKeyboardController();
        if (this.enabled == true) goto L5;
    L7:
        boolean r7 = false;
    L9:
        return r0.mo1564onKeyEvent8zsqlwg(r11, r2, r3, r4, r5, r6, r7, this.singleLine, new r0(this));
    L5:
        if (this.readOnly == true) goto L7;
        r7 = true;
        goto L9
    }

    public void onPlaced(LayoutCoordinates r2) {
        this.dragAndDropNode.onPlaced(r2);
    }

    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean m1643onPreKeyEventZmokQxo(KeyEvent r7) {
        return this.textFieldKeyEventHandler.mo1565onPreKeyEventMyFupTE(r7, this.textFieldState, this.textFieldSelectionState, (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager()), requireKeyboardController());
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void m1644onRemeasuredozmzZPI(long r2) {
        this.dragAndDropNode.onRemeasured-ozmzZPI(r2);
    }

    public final void setEnabled(boolean r1) {
        this.enabled = r1;
    }

    public final void setFilter(InputTransformation r1) {
        this.filter = r1;
    }

    public final void setInteractionSource(MutableInteractionSource r1) {
        this.interactionSource = r1;
    }

    public final void setKeyboardActionHandler(KeyboardActionHandler r1) {
        this.keyboardActionHandler = r1;
    }

    public final void setKeyboardOptions(KeyboardOptions r1) {
        this.keyboardOptions = r1;
    }

    public final void setPassword(boolean r1) {
        this.isPassword = r1;
    }

    public final void setReadOnly(boolean r1) {
        this.readOnly = r1;
    }

    public final void setSingleLine(boolean r1) {
        this.singleLine = r1;
    }

    public final void setStylusHandwritingTrigger(MutableSharedFlow<Unit> r1) {
        this.stylusHandwritingTrigger = r1;
    }

    public final void setTextFieldSelectionState(TextFieldSelectionState r1) {
        this.textFieldSelectionState = r1;
    }

    public final void setTextFieldState(TransformedTextFieldState r1) {
        this.textFieldState = r1;
    }

    public final void setTextLayoutState(TextLayoutState r1) {
        this.textLayoutState = r1;
    }

    /* JADX INFO: renamed from: access$defaultKeyboardActionWithResult-KlQnJC8, reason: not valid java name */
    public static final /* synthetic */ boolean m1636access$defaultKeyboardActionWithResultKlQnJC8(TextFieldDecoratorModifierNode r0, int r1) {
        return r0.m1638defaultKeyboardActionWithResultKlQnJC8(r1);
    }

    public static final /* synthetic */ Object access$observeUntransformedTextChanges(TextFieldDecoratorModifierNode r0, Continuation r1) {
        return r0.observeUntransformedTextChanges(r1);
    }

    /* JADX INFO: renamed from: access$onImeActionPerformed-KlQnJC8, reason: not valid java name */
    public static final /* synthetic */ boolean m1637access$onImeActionPerformedKlQnJC8(TextFieldDecoratorModifierNode r0, int r1) {
        return r0.m1639onImeActionPerformedKlQnJC8(r1);
    }

    public static final /* synthetic */ void access$setAutofillHighlightOn(TextFieldDecoratorModifierNode r0, boolean r1) {
        r0.setAutofillHighlightOn(r1);
    }

    public static final /* synthetic */ void access$startInputSession(TextFieldDecoratorModifierNode r0, boolean r1) {
        r0.startInputSession(r1);
    }

    private static final boolean applySemantics$lambda$17(TextFieldDecoratorModifierNode r0, List r1) {
        TextLayoutResult r2 = r0.textLayoutState.getLayoutResult();
        if (r2 != null) goto L7;
        return false;
    L7:
        return r1.add(r2);
    }

    private static final boolean applySemantics$lambda$21(TextFieldDecoratorModifierNode r0, int r1) {
        r0.m1639onImeActionPerformedKlQnJC8(r1);
        return true;
    }

    private static final Unit clipboardKeyCommandsHandler$lambda$11(TextFieldDecoratorModifierNode r6, KeyCommand r7) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1(r7, r6, null), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit dragAndDropNode$lambda$10(TextFieldDecoratorModifierNode r0, DragAndDropEvent r1) {
        r0.emitDragExitEvent();
        return Unit.INSTANCE;
    }

    private static final Unit dragAndDropNode$lambda$5(TextFieldDecoratorModifierNode r1, DragAndDropEvent r2) {
        if (ReceiveContentConfigurationKt.getReceiveContentConfiguration(r1) == null) goto L6;
        DragAndDropRequestPermission_androidKt.dragAndDropRequestPermission(r1, r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit dragAndDropNode$lambda$7(TextFieldDecoratorModifierNode r1, DragAndDropEvent r2) {
        HoverInteraction.Enter r3 = new HoverInteraction.Enter();
        r1.interactionSource.tryEmit(r3);
        r1.dragEnterEvent = r3;
        ReceiveContentConfiguration r4 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(r1);
        if (r4 == null) goto L8;
        ReceiveContentListener r5 = r4.getReceiveContentListener();
        if (r5 == null) goto L8;
        r5.onDragEnter();
    L8:
        return Unit.INSTANCE;
    }

    private static final Unit dragAndDropNode$lambda$8(TextFieldDecoratorModifierNode r9, Offset r10) {
        long r0 = TextLayoutStateKt.m1669fromWindowToDecorationUv8p0NA(r9.textLayoutState, r10.unbox-impl());
        int r11 = TextLayoutState.m1659getOffsetForPosition3MmeM6k$default(r9.textLayoutState, r0, false, 2, null);
        if (r11 < 0) goto L5;
        r9.textFieldState.m1679selectCharsIn5zctL8(TextRangeKt.TextRange(r11));
    L5:
        r9.textFieldSelectionState.m1724updateHandleDraggingUv8p0NA(Handle.Cursor, r0);
        return Unit.INSTANCE;
    }

    private static final Unit dragAndDropNode$lambda$9(TextFieldDecoratorModifierNode r0, DragAndDropEvent r1) {
        r0.emitDragExitEvent();
        r0.textFieldSelectionState.clearHandleDragging();
        ReceiveContentConfiguration r2 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(r0);
        if (r2 == null) goto L8;
        ReceiveContentListener r3 = r2.getReceiveContentListener();
        if (r3 == null) goto L8;
        r3.onDragExit();
    L8:
        return Unit.INSTANCE;
    }

    private static final Unit focusableNode$lambda$2(TextFieldDecoratorModifierNode r5, boolean r6) {
        if (r5.enabled == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r6 == false) goto L11;
        if (r0 == false) goto L12;
        r5.startInputSession(false);
    L12:
        r5.updateWindowFocus();
        return Unit.INSTANCE;
    L11:
        r5.disposeInputSession();
        TransformedTextFieldState r7 = r5.textFieldState;
        TextFieldState r1 = TransformedTextFieldState.access$getTextFieldState$p(r7);
        InputTransformation r2 = TransformedTextFieldState.access$getInputTransformation$p(r7);
        TextFieldEditUndoBehavior r3 = TextFieldEditUndoBehavior.MergeIfPossible;
        r1.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r4 = r1.getMainBuffer$foundation_release();
        r4.commitComposition$foundation_release();
        TransformedTextFieldState.access$updateWedgeAffinity(r7, r4);
        TextFieldState.access$commitEditAsUser(r1, r2, true, r3);
        r5.textFieldState.collapseSelectionToMax();
        goto L12
    L5:
        if (r5.readOnly == true) goto L7;
        r0 = true;
        goto L8
    }

    private static final Unit onImeActionPerformed_KlQnJC8$lambda$33(TextFieldDecoratorModifierNode r0, int r1) {
        r0.keyboardActionScope.mo1372defaultKeyboardActionKlQnJC8(r1);
        return Unit.INSTANCE;
    }

    private static final boolean applySemantics$lambda$15(boolean r6, TextFieldDecoratorModifierNode r7, AnnotatedString r8) {
        if (r6 == true) goto L5;
        return false;
    L5:
        r7.textFieldState.replaceAll(r8);
        r7.setAutofillHighlightOn(true);
        BuildersKt.launch$default(r7.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$1$1(r7, null), 3, null);
        return true;
    }

    private static final boolean applySemantics$lambda$18(boolean r0, TextFieldDecoratorModifierNode r1, AnnotatedString r2) {
        if (r0 == true) goto L5;
        return false;
    L5:
        r1.textFieldState.replaceAll(r2);
        return true;
    }

    private static final boolean applySemantics$lambda$19(boolean r7, TextFieldDecoratorModifierNode r8, AnnotatedString r9) {
        if (r7 == true) goto L5;
        return false;
    L5:
        TransformedTextFieldState.replaceSelectedText$default(r8.textFieldState, r9, true, null, false, 12, null);
        return true;
    }

    private static final boolean dragAndDropNode$lambda$4(TextFieldDecoratorModifierNode r9, ClipEntry r10, ClipMetadata r11) {
        r9.emitDragExitEvent();
        r9.textFieldSelectionState.clearHandleDragging();
        String r0 = TransferableContent_androidKt.readPlainText(r10);
        ReceiveContentConfiguration r1 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(r9);
        if (r1 == null) goto L11;
        TransferableContent r2 = new TransferableContent(r10, r11, TransferableContent.Source.Companion.m465getDragAndDropkB6V9T0(), null, 8, null);
        TransferableContent r12 = r1.getReceiveContentListener().onReceive(r2);
        if (r12 == null) goto L9;
        ClipEntry r13 = r12.getClipEntry();
        if (r13 == null) goto L9;
        String r14 = TransferableContent_androidKt.readPlainText(r13);
    L10:
        r0 = r14;
    L9:
        r14 = null;
    L11:
        String r3 = r0;
        if (r3 == null) goto L16;
        TransformedTextFieldState.replaceSelectedText$default(r9.textFieldState, r3, false, null, false, 14, null);
        return true;
    L16:
        return true;
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m1642onPointerEventH0pRuoY(PointerEvent r2, PointerEventPass r3, long r4) {
        this.pointerInputNode.onPointerEvent-H0pRuoY(r2, r3, r4);
    }

    private static final boolean applySemantics$lambda$20(TextFieldDecoratorModifierNode r4, int r5, int r6, boolean r7) {
        if (r7 == false) goto L4;
        TextFieldCharSequence r0 = r4.textFieldState.getUntransformedText();
    L5:
        long r1 = r0.m1535getSelectiond9O1mEE();
        if (r4.enabled == true) goto L8;
        return false;
    L8:
        if (Math.min(r5, r6) >= 0) goto L10;
        return false;
    L10:
        if (Math.max(r5, r6) <= r0.length()) goto L13;
        return false;
    L13:
        if (r5 == TextRange.getStart-impl(r1)) goto L15;
    L17:
        long r2 = TextRangeKt.TextRange(r5, r6);
        if (r7 == true) goto L22;
        if (r5 == r6) goto L22;
        r4.textFieldSelectionState.updateTextToolbarState(TextToolbarState.Selection);
    L23:
        if (r7 == false) goto L25;
        r4.textFieldState.m1680selectUntransformedCharsIn5zctL8(r2);
    L26:
        return true;
    L25:
        r4.textFieldState.m1679selectCharsIn5zctL8(r2);
    L22:
        r4.textFieldSelectionState.updateTextToolbarState(TextToolbarState.None);
        goto L23
    L15:
        if (r6 != TextRange.getEnd-impl(r1)) goto L17;
        return true;
    L4:
        r0 = r4.textFieldState.getVisualText();
        goto L5
    }

    public TextFieldDecoratorModifierNode(TransformedTextFieldState r1, TextLayoutState r2, TextFieldSelectionState r3, InputTransformation r4, boolean r5, boolean r6, KeyboardOptions r7, KeyboardActionHandler r8, boolean r9, MutableInteractionSource r10, boolean r11, MutableSharedFlow<Unit> r12) {
        this.textFieldState = r1;
        this.textLayoutState = r2;
        this.textFieldSelectionState = r3;
        this.filter = r4;
        this.enabled = r5;
        this.readOnly = r6;
        this.keyboardOptions = r7;
        this.keyboardActionHandler = r8;
        this.singleLine = r9;
        this.interactionSource = r10;
        this.isPassword = r11;
        this.stylusHandwritingTrigger = r12;
        r3.setRequestAutofillAction(new l1(this));
        this.focusableNode = new FocusableNode(this.interactionSource, 0, new n1(this), 2, null);
        this.pointerInputNode = delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TextFieldDecoratorModifierNode$pointerInputNode$1(this)));
        this.dragAndDropNode = delegate(TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode$default(new o1(this), new p1(this), new q1(this), null, new r1(this), new s0(this), null, new t0(this), new u0(this), 72, null));
        this.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        this.keyboardActionScope = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.clipboardKeyCommandsHandler = ClipboardKeyCommandsHandler.m1570constructorimpl(new v0(this));
        this.receiveContentConfigurationProvider = new m1(this);
        this.autofillHighlightOn$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    public final void updateNode(TransformedTextFieldState r20, TextLayoutState r21, TextFieldSelectionState r22, InputTransformation r23, boolean r24, boolean r25, KeyboardOptions r26, KeyboardActionHandler r27, boolean r28, MutableInteractionSource r29, boolean r30, MutableSharedFlow<Unit> r31) {
        boolean r9 = this.enabled;
        if (r9 == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        TransformedTextFieldState r13 = this.textFieldState;
        KeyboardOptions r14 = this.keyboardOptions;
        TextFieldSelectionState r15 = this.textFieldSelectionState;
        MutableInteractionSource r10 = this.interactionSource;
        boolean r11 = this.isPassword;
        MutableSharedFlow<Unit> r16 = this.stylusHandwritingTrigger;
        if (r24 == false) goto L12;
        if (r25 == true) goto L12;
        boolean r17 = true;
    L13:
        this.textFieldState = r20;
        this.textLayoutState = r21;
        this.textFieldSelectionState = r22;
        this.filter = r23;
        this.enabled = r24;
        this.readOnly = r25;
        this.keyboardOptions = r26;
        this.keyboardActionHandler = r27;
        this.singleLine = r28;
        this.interactionSource = r29;
        this.isPassword = r30;
        this.stylusHandwritingTrigger = r31;
        if (r17 == r12) goto L16;
    L21:
        if (r17 == true) goto L23;
    L25:
        if (r17 == true) goto L27;
        disposeInputSession();
    L27:
        if (r24 != r9) goto L33;
        if (r17 != r12) goto L33;
        if (ImeAction.equals-impl0(r26.m1386getImeActionOrDefaulteUduSuo$foundation_release(), r14.m1386getImeActionOrDefaulteUduSuo$foundation_release()) == false) goto L33;
        if (r30 != r11) goto L33;
    L35:
        if (Intrinsics.areEqual(r22, r15) == true) goto L48;
        this.pointerInputNode.resetPointerInputHandler();
        if (isAttached() == false) goto L46;
        r22.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
        if (isFocused() == false) goto L46;
        Job r1 = this.toolbarAndHandlesVisibilityObserverJob;
        if (r1 == null) goto L46;
        if (r1 == null) goto L45;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L45:
        this.toolbarAndHandlesVisibilityObserverJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new C02141(r22, null), 3, null);
    L46:
        r22.setRequestAutofillAction(new c1(this));
    L48:
        if (Intrinsics.areEqual(r29, r10) == true) goto L52;
        this.pointerInputNode.resetPointerInputHandler();
        if (this.focusableNode.isAttached() == false) goto L52;
        this.focusableNode.update(r29);
    L52:
        if (r24 == r9) goto L57;
        if (r24 == false) goto L55;
        delegate(this.focusableNode);
        this.focusableNode.update(r29);
        return;
    L55:
        undelegate(this.focusableNode);
        return;
    L57:
        return;
    L33:
        SemanticsModifierNodeKt.invalidateSemantics(this);
        goto L35
    L23:
        if (isFocused() == false) goto L25;
        startInputSession(false);
        goto L27
    L16:
        if (Intrinsics.areEqual(r20, r13) == false) goto L21;
        if (Intrinsics.areEqual(r26, r14) == false) goto L21;
        if (Intrinsics.areEqual(r31, r16) == true) goto L27;
    L12:
        r17 = false;
        goto L13
    L5:
        if (this.readOnly == true) goto L7;
        r12 = true;
        goto L8
    }
}
