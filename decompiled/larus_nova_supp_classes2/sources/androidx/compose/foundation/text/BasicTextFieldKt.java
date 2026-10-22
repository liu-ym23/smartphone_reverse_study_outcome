package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001228\b\u0002\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u0010&\u001añ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001228\b\u0002\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0005*\u00020\u00052\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002\u001a\u0015\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020-H\u0001¢\u0006\u0002\u00102\u001a\u0015\u00103\u001a\u00020\u00012\u0006\u00101\u001a\u00020-H\u0001¢\u0006\u0002\u00102\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010G\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u00020H2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010I\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010J\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u00020H2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010K\"\u000e\u00104\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107¨\u0006L²\u0006\n\u0010M\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010O\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010P\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010R\u001a\u000209X\u008a\u008e\u0002"}, d2 = {"BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "addContextMenuComponents", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "TextFieldCursorHandle", "selectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "DefaultTextFieldDecorator", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "value", "", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "cursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = null;
    private static final long MinTouchTargetSizeForHandles = 0;

    private static final Unit BasicTextField$lambda$0(TextFieldState r19, Modifier r20, boolean r21, boolean r22, InputTransformation r23, TextStyle r24, KeyboardOptions r25, KeyboardActionHandler r26, TextFieldLineLimits r27, Function2 r28, MutableInteractionSource r29, Brush r30, OutputTransformation r31, TextFieldDecorator r32, ScrollState r33, int r34, int r35, int r36, Composer r37, int r38) {
        BasicTextField(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$17(TextFieldState r21, Modifier r22, boolean r23, boolean r24, InputTransformation r25, TextStyle r26, KeyboardOptions r27, KeyboardActionHandler r28, TextFieldLineLimits r29, Function2 r30, MutableInteractionSource r31, Brush r32, CodepointTransformation r33, OutputTransformation r34, TextFieldDecorator r35, ScrollState r36, boolean r37, int r38, int r39, int r40, Composer r41, int r42) {
        BasicTextField(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r41, RecomposeScopeImplKt.updateChangedFlags(r38 | 1), RecomposeScopeImplKt.updateChangedFlags(r39), r40);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$47(String r20, Function1 r21, Modifier r22, boolean r23, boolean r24, TextStyle r25, KeyboardOptions r26, KeyboardActions r27, boolean r28, int r29, int r30, VisualTransformation r31, Function1 r32, MutableInteractionSource r33, Brush r34, Function3 r35, int r36, int r37, int r38, Composer r39, int r40) {
        BasicTextField(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r39, RecomposeScopeImplKt.updateChangedFlags(r36 | 1), RecomposeScopeImplKt.updateChangedFlags(r37), r38);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$52(TextFieldValue r20, Function1 r21, Modifier r22, boolean r23, boolean r24, TextStyle r25, KeyboardOptions r26, KeyboardActions r27, boolean r28, int r29, int r30, VisualTransformation r31, Function1 r32, MutableInteractionSource r33, Brush r34, Function3 r35, int r36, int r37, int r38, Composer r39, int r40) {
        BasicTextField(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r39, RecomposeScopeImplKt.updateChangedFlags(r36 | 1), RecomposeScopeImplKt.updateChangedFlags(r37), r38);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$56(String r19, Function1 r20, Modifier r21, boolean r22, boolean r23, TextStyle r24, KeyboardOptions r25, KeyboardActions r26, boolean r27, int r28, VisualTransformation r29, Function1 r30, MutableInteractionSource r31, Brush r32, Function3 r33, int r34, int r35, int r36, Composer r37, int r38) {
        BasicTextField(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$60(TextFieldValue r19, Function1 r20, Modifier r21, boolean r22, boolean r23, TextStyle r24, KeyboardOptions r25, KeyboardActions r26, boolean r27, int r28, VisualTransformation r29, Function1 r30, MutableInteractionSource r31, Brush r32, Function3 r33, int r34, int r35, int r36, Composer r37, int r38) {
        BasicTextField(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    private static final Unit TextFieldCursorHandle$lambda$23(TextFieldSelectionState r0, int r1, Composer r2, int r3) {
        TextFieldCursorHandle(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TextFieldSelectionHandles$lambda$34(TextFieldSelectionState r0, int r1, Composer r2, int r3) {
        TextFieldSelectionHandles(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ TextFieldHandleState a(TextFieldSelectionState r0) {
        return TextFieldSelectionHandles$lambda$25$lambda$24(r0);
    }

    public static /* synthetic */ Unit b(TextFieldSelectionState r0, int r1, Composer r2, int r3) {
        return TextFieldSelectionHandles$lambda$34(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit c(Function1 r0, MutableState r1, MutableState r2, TextFieldValue r3) {
        return BasicTextField$lambda$46$lambda$45(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit d(TextFieldValue r0, Function1 r1, TextFieldValue r2) {
        return BasicTextField$lambda$51$lambda$50(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(TextFieldValue r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, KeyboardOptions r7, KeyboardActions r8, boolean r9, int r10, int r11, VisualTransformation r12, Function1 r13, MutableInteractionSource r14, Brush r15, Function3 r16, int r17, int r18, int r19, Composer r20, int r21) {
        return BasicTextField$lambda$52(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ Unit f(TextLayoutResult r0) {
        return BasicTextField$lambda$54$lambda$53(r0);
    }

    public static /* synthetic */ Unit g(TextLayoutResult r0) {
        return BasicTextField$lambda$58$lambda$57(r0);
    }

    public static /* synthetic */ TextFieldHandleState h(TextFieldSelectionState r0) {
        return TextFieldCursorHandle$lambda$19$lambda$18(r0);
    }

    public static /* synthetic */ DisposableEffectResult i(TextFieldSelectionState r0, DisposableEffectScope r1) {
        return BasicTextField$lambda$13$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit j(TextFieldValue r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, KeyboardOptions r7, KeyboardActions r8, boolean r9, int r10, VisualTransformation r11, Function1 r12, MutableInteractionSource r13, Brush r14, Function3 r15, int r16, int r17, int r18, Composer r19, int r20) {
        return BasicTextField$lambda$60(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ Unit k(String r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, KeyboardOptions r7, KeyboardActions r8, boolean r9, int r10, VisualTransformation r11, Function1 r12, MutableInteractionSource r13, Brush r14, Function3 r15, int r16, int r17, int r18, Composer r19, int r20) {
        return BasicTextField$lambda$56(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ Unit l(String r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, KeyboardOptions r7, KeyboardActions r8, boolean r9, int r10, int r11, VisualTransformation r12, Function1 r13, MutableInteractionSource r14, Brush r15, Function3 r16, int r17, int r18, int r19, Composer r20, int r21) {
        return BasicTextField$lambda$47(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ Unit m(TextFieldState r1, Modifier r2, boolean r3, boolean r4, InputTransformation r5, TextStyle r6, KeyboardOptions r7, KeyboardActionHandler r8, TextFieldLineLimits r9, Function2 r10, MutableInteractionSource r11, Brush r12, OutputTransformation r13, TextFieldDecorator r14, ScrollState r15, int r16, int r17, int r18, Composer r19, int r20) {
        return BasicTextField$lambda$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ Unit n(TextFieldSelectionState r0, int r1, Composer r2, int r3) {
        return TextFieldCursorHandle$lambda$23(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit o(TextFieldState r1, Modifier r2, boolean r3, boolean r4, InputTransformation r5, TextStyle r6, KeyboardOptions r7, KeyboardActionHandler r8, TextFieldLineLimits r9, Function2 r10, MutableInteractionSource r11, Brush r12, CodepointTransformation r13, OutputTransformation r14, TextFieldDecorator r15, ScrollState r16, boolean r17, int r18, int r19, int r20, Composer r21, int r22) {
        return BasicTextField$lambda$17(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public static /* synthetic */ Unit p(TransformedTextFieldState r0, InputTransformation r1, TextFieldSelectionState r2, HapticFeedback r3, Clipboard r4, BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 r5, Density r6, boolean r7, boolean r8, boolean r9) {
        return BasicTextField$lambda$10$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit q(boolean r0, MutableSharedFlow r1) {
        return BasicTextField$lambda$15$lambda$14(r0, r1);
    }

    public static /* synthetic */ Unit r(TextFieldValue r0, MutableState r1) {
        return BasicTextField$lambda$41$lambda$40(r0, r1);
    }

    public static /* synthetic */ Unit s(TextLayoutResult r0) {
        return BasicTextField$lambda$49$lambda$48(r0);
    }

    public static /* synthetic */ Unit t(TextLayoutResult r0) {
        return BasicTextField$lambda$36$lambda$35(r0);
    }

    public static /* synthetic */ TextFieldHandleState u(TextFieldSelectionState r0) {
        return TextFieldSelectionHandles$lambda$30$lambda$29(r0);
    }

    static {
        DefaultTextFieldDecorator = BasicTextFieldKt$DefaultTextFieldDecorator$1.INSTANCE;
        float r0 = 40;
        MinTouchTargetSizeForHandles = DpKt.DpSize-YgX7TsA(Dp.constructor-impl(r0), Dp.constructor-impl(r0));
    }

    public static final /* synthetic */ TextFieldDecorator access$getDefaultTextFieldDecorator$p() {
        return DefaultTextFieldDecorator;
    }

    private static final Unit BasicTextField$lambda$36$lambda$35(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final TextFieldValue BasicTextField$lambda$38(MutableState<TextFieldValue> r0) {
        return (TextFieldValue) r0.getValue();
    }

    private static final String BasicTextField$lambda$43(MutableState<String> r0) {
        return (String) r0.getValue();
    }

    private static final Unit BasicTextField$lambda$49$lambda$48(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$54$lambda$53(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$58$lambda$57(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$19$lambda$18(TextFieldSelectionState r1) {
        return r1.getCursorHandleState$foundation_release(false);
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$20(State<TextFieldHandleState> r0) {
        return (TextFieldHandleState) r0.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$25$lambda$24(TextFieldSelectionState r2) {
        return r2.getSelectionHandleState$foundation_release(true, false);
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$26(State<TextFieldHandleState> r0) {
        return (TextFieldHandleState) r0.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$30$lambda$29(TextFieldSelectionState r1) {
        return r1.getSelectionHandleState$foundation_release(false, false);
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$31(State<TextFieldHandleState> r0) {
        return (TextFieldHandleState) r0.getValue();
    }

    private static final DisposableEffectResult BasicTextField$lambda$13$lambda$12(final TextFieldSelectionState r0, DisposableEffectScope r1) {
        return new BasicTextFieldKt$BasicTextField$lambda$13$lambda$12$$inlined$onDispose$1(r0);
    }

    private static final Unit BasicTextField$lambda$15$lambda$14(boolean r0, MutableSharedFlow r1) {
        if (r0 == false) goto L5;
        r1.tryEmit(Unit.INSTANCE);
    L5:
        return Unit.INSTANCE;
    }

    private static final void BasicTextField$lambda$39(MutableState<TextFieldValue> r0, TextFieldValue r1) {
        r0.setValue(r1);
    }

    private static final Unit BasicTextField$lambda$41$lambda$40(TextFieldValue r4, MutableState r5) {
        if (TextRange.equals-impl0(r4.getSelection-d9O1mEE(), BasicTextField$lambda$38(r5).getSelection-d9O1mEE()) == true) goto L5;
    L6:
        BasicTextField$lambda$39(r5, r4);
    L8:
        return Unit.INSTANCE;
    L5:
        if (Intrinsics.areEqual(r4.getComposition-MzsxiRA(), BasicTextField$lambda$38(r5).getComposition-MzsxiRA()) == true) goto L8;
        goto L6
    }

    private static final void BasicTextField$lambda$44(MutableState<String> r0, String r1) {
        r0.setValue(r1);
    }

    private static final Unit BasicTextField$lambda$51$lambda$50(TextFieldValue r0, Function1 r1, TextFieldValue r2) {
        if (Intrinsics.areEqual(r0, r2) == true) goto L6;
        r1.invoke(r2);
    L6:
        return Unit.INSTANCE;
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionState r8, Composer r9, final int r10) {
        Composer r11 = r9.startRestartGroup(1991581797);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r11.shouldExecute(r2, r1 & 1) == true) goto L17;
        r11.skipToGroupEnd();
    L42:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L46;
        r12.updateScope(new i0(r8, r10));
        return;
    L46:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1991581797, r1, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:529)");
    L19:
        boolean r0 = r11.changed(r8);
        Object r3 = r11.rememberedValue();
        if (r0 == false) goto L22;
    L23:
        r3 = SnapshotStateKt.derivedStateOf(new h0(r8));
        r11.updateRememberedValue(r3);
    L25:
        if (TextFieldCursorHandle$lambda$20((State) r3).getVisible() == false) goto L37;
        r11.startReplaceGroup(535453998);
        boolean r4 = r11.changedInstance(r8);
        Object r5 = r11.rememberedValue();
        if (r4 == false) goto L29;
    L30:
        r5 = new BasicTextFieldKt$TextFieldCursorHandle$1$1(r8);
        r11.updateRememberedValue(r5);
    L31:
        OffsetProvider r6 = (OffsetProvider) r5;
        Modifier.Companion r7 = Modifier.Companion;
        boolean r13 = r11.changedInstance(r8);
        Object r14 = r11.rememberedValue();
        if (r13 == false) goto L34;
    L35:
        r14 = new BasicTextFieldKt$TextFieldCursorHandle$2$1(r8);
        r11.updateRememberedValue(r14);
    L36:
        AndroidCursorHandle_androidKt.m1337CursorHandleUSBMPiE(r6, SuspendingPointerInputFilterKt.pointerInput(r7, r8, (PointerInputEventHandler) r14), MinTouchTargetSizeForHandles, r11, 384, 0);
        r11.endReplaceGroup();
    L39:
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventEnd();
        goto L42
    L34:
        if (r14 != Composer.Companion.getEmpty()) goto L36;
    L29:
        if (r5 != Composer.Companion.getEmpty()) goto L31;
    L37:
        r11.startReplaceGroup(535837437);
        r11.endReplaceGroup();
        goto L39
    L22:
        if (r3 != Composer.Companion.getEmpty()) goto L25;
    L13:
        r2 = false;
        goto L15
    L5:
        if (r11.changedInstance(r8) == false) goto L7;
        int r15 = 4;
    L8:
        r1 = r15 | r10;
        goto L11
    L7:
        r15 = 2;
        goto L8
    }

    public static final void TextFieldSelectionHandles(final TextFieldSelectionState r12, Composer r13, final int r14) {
        Composer r15 = r13.startRestartGroup(2025287684);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r15.shouldExecute(r2, r1 & 1) == true) goto L17;
        r15.skipToGroupEnd();
    L61:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L65;
        r16.updateScope(new c0(r12, r14));
        return;
    L65:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(2025287684, r1, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:550)");
    L19:
        boolean r0 = r15.changed(r12);
        Object r3 = r15.rememberedValue();
        if (r0 == false) goto L22;
    L23:
        r3 = SnapshotStateKt.derivedStateOf(new p(r12));
        r15.updateRememberedValue(r3);
    L24:
        State r4 = (State) r3;
        if (TextFieldSelectionHandles$lambda$26(r4).getVisible() == false) goto L37;
        r15.startReplaceGroup(-354691912);
        boolean r5 = r15.changedInstance(r12);
        Object r6 = r15.rememberedValue();
        if (r5 == false) goto L29;
    L30:
        r6 = new BasicTextFieldKt$TextFieldSelectionHandles$1$1(r12);
        r15.updateRememberedValue(r6);
    L31:
        OffsetProvider r7 = (OffsetProvider) r6;
        ResolvedTextDirection r8 = TextFieldSelectionHandles$lambda$26(r4).getDirection();
        boolean r9 = TextFieldSelectionHandles$lambda$26(r4).getHandlesCrossed();
        Modifier.Companion r10 = Modifier.Companion;
        boolean r11 = r15.changedInstance(r12);
        Object r17 = r15.rememberedValue();
        if (r11 == false) goto L34;
    L35:
        r17 = new BasicTextFieldKt$TextFieldSelectionHandles$2$1(r12);
        r15.updateRememberedValue(r17);
    L36:
        Modifier r18 = SuspendingPointerInputFilterKt.pointerInput(r10, r12, (PointerInputEventHandler) r17);
        float r19 = TextFieldSelectionHandles$lambda$26(r4).getLineHeight();
        AndroidSelectionHandles_androidKt.m1824SelectionHandlewLIcFTc(r7, true, r8, r9, MinTouchTargetSizeForHandles, r19, r18, r15, 24624, 0);
        r15.endReplaceGroup();
    L38:
        boolean r20 = r15.changed(r12);
        Object r21 = r15.rememberedValue();
        if (r20 == false) goto L41;
    L42:
        r21 = SnapshotStateKt.derivedStateOf(new a0(r12));
        r15.updateRememberedValue(r21);
    L43:
        State r22 = (State) r21;
        if (TextFieldSelectionHandles$lambda$31(r22).getVisible() == false) goto L56;
        r15.startReplaceGroup(-353646437);
        boolean r23 = r15.changedInstance(r12);
        Object r24 = r15.rememberedValue();
        if (r23 == false) goto L48;
    L49:
        r24 = new BasicTextFieldKt$TextFieldSelectionHandles$3$1(r12);
        r15.updateRememberedValue(r24);
    L50:
        OffsetProvider r25 = (OffsetProvider) r24;
        ResolvedTextDirection r26 = TextFieldSelectionHandles$lambda$31(r22).getDirection();
        boolean r27 = TextFieldSelectionHandles$lambda$31(r22).getHandlesCrossed();
        Modifier.Companion r28 = Modifier.Companion;
        boolean r29 = r15.changedInstance(r12);
        Object r30 = r15.rememberedValue();
        if (r29 == false) goto L53;
    L54:
        r30 = new BasicTextFieldKt$TextFieldSelectionHandles$4$1(r12);
        r15.updateRememberedValue(r30);
    L55:
        Modifier r31 = SuspendingPointerInputFilterKt.pointerInput(r28, r12, (PointerInputEventHandler) r30);
        float r32 = TextFieldSelectionHandles$lambda$31(r22).getLineHeight();
        AndroidSelectionHandles_androidKt.m1824SelectionHandlewLIcFTc(r25, false, r26, r27, MinTouchTargetSizeForHandles, r32, r31, r15, 24624, 0);
        r15.endReplaceGroup();
    L58:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
        goto L61
    L53:
        if (r30 != Composer.Companion.getEmpty()) goto L55;
    L48:
        if (r24 != Composer.Companion.getEmpty()) goto L50;
    L56:
        r15.startReplaceGroup(-352997762);
        r15.endReplaceGroup();
        goto L58
    L41:
        if (r21 != Composer.Companion.getEmpty()) goto L43;
    L34:
        if (r17 != Composer.Companion.getEmpty()) goto L36;
    L29:
        if (r6 != Composer.Companion.getEmpty()) goto L31;
    L37:
        r15.startReplaceGroup(-354040354);
        r15.endReplaceGroup();
        goto L38
    L22:
        if (r3 != Composer.Companion.getEmpty()) goto L24;
    L13:
        r2 = false;
        goto L15
    L5:
        if (r15.changedInstance(r12) == false) goto L7;
        int r33 = 4;
    L8:
        r1 = r33 | r14;
        goto L11
    L7:
        r33 = 2;
        goto L8
    }

    private static final Modifier addContextMenuComponents(Modifier r1, TextFieldSelectionState r2, CoroutineScope r3) {
        if (ComposeFoundationFlags.isNewContextMenuEnabled == true) goto L5;
        return r1;
    L5:
        return TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents(r1, r2, r3);
    }

    private static final Unit BasicTextField$lambda$46$lambda$45(Function1 r1, MutableState r2, MutableState r3, TextFieldValue r4) {
        BasicTextField$lambda$39(r2, r4);
        boolean r5 = !Intrinsics.areEqual(BasicTextField$lambda$43(r3), r4.getText());
        BasicTextField$lambda$44(r3, r4.getText());
        if (r5 == false) goto L6;
        r1.invoke(r4.getText());
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$10$lambda$9(TransformedTextFieldState r0, InputTransformation r1, TextFieldSelectionState r2, HapticFeedback r3, Clipboard r4, BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 r5, Density r6, boolean r7, boolean r8, boolean r9) {
        r0.update(r1);
        r2.update(r3, r4, r5, r6, r7, r8, r9);
        return Unit.INSTANCE;
    }

    public static final void BasicTextField(final TextFieldState r40, Modifier r41, boolean r42, boolean r43, InputTransformation r44, TextStyle r45, KeyboardOptions r46, KeyboardActionHandler r47, TextFieldLineLimits r48, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r49, MutableInteractionSource r50, Brush r51, OutputTransformation r52, TextFieldDecorator r53, ScrollState r54, Composer r55, final int r56, final int r57, final int r58) {
        Composer r2 = r55.startRestartGroup(469439921);
        if ((r58 & 1) == 0) goto L6;
        int r6 = r56 | 6;
    L13:
        int r7 = r58 & 2;
        if (r7 == 0) goto L17;
        r6 = r6 | 48;
    L24:
        int r11 = r58 & 4;
        int r16 = 128;
        if (r11 == 0) goto L28;
        r6 = r6 | 384;
    L35:
        int r17 = r58 & 8;
        int r18 = 2048;
        if (r17 == 0) goto L39;
        r6 = r6 | 3072;
    L46:
        int r21 = r58 & 16;
        int r22 = 8192;
        if (r21 == 0) goto L50;
        r6 = r6 | 24576;
    L57:
        int r25 = r58 & 32;
        if (r25 == 0) goto L61;
        r6 = r6 | 196608;
    L67:
        int r27 = r58 & 64;
        if (r27 == 0) goto L71;
        r6 = r6 | 1572864;
    L77:
        int r1 = r58 & 128;
        if (r1 == 0) goto L81;
        r6 = r6 | 12582912;
    L87:
        int r3 = r58 & 256;
        if (r3 == 0) goto L91;
        r6 = r6 | 100663296;
    L97:
        int r4 = r58 & 512;
        if (r4 == 0) goto L101;
        r6 = r6 | 805306368;
    L107:
        int r5 = r58 & 1024;
        if (r5 == 0) goto L111;
        int r20 = r57 | 6;
    L118:
        int r8 = r58 & 2048;
        if (r8 == 0) goto L122;
        r20 = r20 | 48;
    L128:
        int r9 = r20;
        int r10 = r58 & 4096;
        if (r10 == 0) goto L132;
        r9 = r9 | 384;
    L138:
        int r12 = r58 & 8192;
        if (r12 == 0) goto L141;
        r9 = r9 | 3072;
        int r19 = r12;
    L152:
        if ((r57 & 24576) != 0) goto L162;
        if ((r58 & 16384) != 0) goto L159;
        if (r2.changed(r54) == false) goto L159;
        r22 = 16384;
    L159:
        r9 = r9 | r22;
    L162:
        if ((r6 & 306783379) == 306783378) goto L164;
    L167:
        boolean r0 = true;
    L169:
        if (r2.shouldExecute(r0, r6 & 1) == false) goto L232;
        r2.startDefaults();
        if ((r56 & 1) != 0) goto L173;
    L179:
        if (r7 == 0) goto L181;
        Modifier r13 = Modifier.Companion;
    L182:
        if (r11 == 0) goto L184;
        boolean r14 = true;
    L185:
        if (r17 == 0) goto L187;
        boolean r15 = false;
    L188:
        TextFieldDecorator r110 = null;
        if (r21 == 0) goto L191;
        InputTransformation r111 = null;
    L192:
        if (r25 == 0) goto L194;
        TextStyle r112 = TextStyle.Companion.getDefault();
    L195:
        if (r27 == 0) goto L197;
        KeyboardOptions r113 = KeyboardOptions.Companion.getDefault();
    L198:
        if (r1 == 0) goto L200;
        KeyboardActionHandler r23 = null;
    L201:
        if (r3 == 0) goto L203;
        TextFieldLineLimits r24 = TextFieldLineLimits.Companion.getDefault();
    L204:
        if (r4 == 0) goto L206;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r26 = null;
    L207:
        if (r5 == 0) goto L209;
        MutableInteractionSource r28 = null;
    L210:
        if (r8 == 0) goto L212;
        Brush r29 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
    L213:
        if (r10 == 0) goto L215;
        OutputTransformation r114 = null;
    L216:
        if (r19 != 0) goto L219;
        r110 = r53;
    L219:
        Modifier r410 = r13;
        if ((r58 & 16384) == 0) goto L222;
        ScrollState r38 = ScrollKt.rememberScrollState(0, r2, 0, 1);
        int r115 = r9 & (-57345);
    L223:
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r30 = r26;
        MutableInteractionSource r116 = r28;
        final Brush r117 = r29;
        KeyboardOptions r31 = r113;
        KeyboardActionHandler r32 = r23;
        TextFieldLineLimits r33 = r24;
        InputTransformation r34 = r111;
        TextStyle r35 = r112;
    L224:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L228;
        ComposerKt.traceEventStart(469439921, r6, r115, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:201)");
    L228:
        int r36 = r115 << 3;
        Modifier r118 = r410;
        boolean r119 = r14;
        boolean r120 = r15;
        InputTransformation r210 = r34;
        TextStyle r211 = r35;
        KeyboardOptions r212 = r31;
        KeyboardActionHandler r213 = r32;
        TextFieldLineLimits r214 = r33;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r215 = r30;
        MutableInteractionSource r216 = r116;
        Brush r217 = r117;
        OutputTransformation r218 = r114;
        TextFieldDecorator r37 = r110;
        ScrollState r39 = r38;
        BasicTextField(r40, r118, r119, r120, r210, r211, r212, r213, r214, r215, r216, r217, null, r218, r37, r39, false, r2, (((((((((r6 & 14) | (r6 & 112)) | (r6 & 896)) | (r6 & 7168)) | (57344 & r6)) | (458752 & r6)) | (3670016 & r6)) | (29360128 & r6)) | (234881024 & r6)) | (r6 & 1879048192), (((((r115 & 14) | 384) | (r115 & 112)) | (r36 & 7168)) | (57344 & r36)) | (r36 & 458752), 65536);
        if (ComposerKt.isTraceInProgress() == false) goto L231;
        ComposerKt.traceEventEnd();
    L231:
        final Modifier r59 = r410;
        final TextStyle r60 = r35;
        final boolean r61 = r14;
        final OutputTransformation r121 = r114;
        final TextFieldDecorator r122 = r110;
        final ScrollState r123 = r38;
        final KeyboardOptions r62 = r31;
        final boolean r63 = r15;
        final MutableInteractionSource r124 = r116;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r125 = r30;
        final TextFieldLineLimits r64 = r33;
        final KeyboardActionHandler r65 = r32;
        final InputTransformation r66 = r34;
    L233:
        ScopeUpdateScope r67 = r2.endRestartGroup();
        if (r67 == null) goto L237;
        r67.updateScope(new r(r40, r59, r61, r63, r66, r60, r62, r65, r64, r125, r124, r117, r121, r122, r123, r56, r57, r58));
        return;
    L237:
        return;
    L222:
        r38 = r54;
        r115 = r9;
        goto L223
    L215:
        r114 = r52;
        goto L216
    L212:
        r29 = r51;
        goto L213
    L209:
        r28 = r50;
        goto L210
    L206:
        r26 = r49;
        goto L207
    L203:
        r24 = r48;
        goto L204
    L200:
        r23 = r47;
        goto L201
    L197:
        r113 = r46;
        goto L198
    L194:
        r112 = r45;
        goto L195
    L191:
        r111 = r44;
        goto L192
    L187:
        r15 = r43;
        goto L188
    L184:
        r14 = r42;
        goto L185
    L181:
        r13 = r41;
        goto L182
    L173:
        if (r2.getDefaultsInvalid() == true) goto L179;
        r2.skipToGroupEnd();
        if ((r58 & 16384) == 0) goto L178;
        r9 = r9 & (-57345);
    L178:
        r410 = r41;
        r14 = r42;
        r15 = r43;
        r34 = r44;
        r35 = r45;
        r31 = r46;
        r32 = r47;
        r33 = r48;
        r116 = r50;
        r117 = r51;
        r114 = r52;
        r110 = r53;
        r38 = r54;
        r115 = r9;
        r30 = r49;
        goto L224
    L232:
        r2 = r2;
        r2.skipToGroupEnd();
        r59 = r41;
        r61 = r42;
        r63 = r43;
        r66 = r44;
        r60 = r45;
        r62 = r46;
        r65 = r47;
        r64 = r48;
        r125 = r49;
        r124 = r50;
        r117 = r51;
        r121 = r52;
        r122 = r53;
        r123 = r54;
        goto L233
    L164:
        if ((r9 & 9363) != 9362) goto L167;
        r0 = false;
        goto L169
    L141:
        r19 = r12;
        if ((r57 & 3072) != 0) goto L152;
        if ((r57 & 4096) != 0) goto L146;
        boolean r126 = r2.changed(r53);
    L147:
        if (r126 == true) goto L150;
        r18 = 1024;
    L150:
        r9 = r9 | r18;
        goto L152
    L146:
        r126 = r2.changedInstance(r53);
        goto L147
    L132:
        if ((r57 & 384) != 0) goto L138;
        if (r2.changed(r52) == false) goto L136;
        r16 = 256;
    L136:
        r9 = r9 | r16;
        goto L138
    L122:
        if ((r57 & 48) != 0) goto L128;
        if (r2.changed(r51) == false) goto L126;
        int r219 = 32;
    L127:
        r20 = r20 | r219;
        goto L128
    L126:
        r219 = 16;
        goto L127
    L111:
        if ((r57 & 6) == 0) goto L113;
        r20 = r57;
        goto L118
    L113:
        if (r2.changed(r50) == false) goto L115;
        int r220 = 4;
    L116:
        r20 = r57 | r220;
        goto L118
    L115:
        r220 = 2;
        goto L116
    L101:
        if ((r56 & 805306368) != 0) goto L107;
        if (r2.changedInstance(r49) == false) goto L105;
        int r310 = 536870912;
    L106:
        r6 = r6 | r310;
        goto L107
    L105:
        r310 = 268435456;
        goto L106
    L91:
        if ((r56 & 100663296) != 0) goto L97;
        if (r2.changed(r48) == false) goto L95;
        int r311 = 67108864;
    L96:
        r6 = r6 | r311;
        goto L97
    L95:
        r311 = 33554432;
        goto L96
    L81:
        if ((r56 & 12582912) != 0) goto L87;
        if (r2.changed(r47) == false) goto L85;
        int r312 = 8388608;
    L86:
        r6 = r6 | r312;
        goto L87
    L85:
        r312 = 4194304;
        goto L86
    L71:
        if ((r56 & 1572864) != 0) goto L77;
        if (r2.changed(r46) == false) goto L75;
        int r221 = 1048576;
    L76:
        r6 = r6 | r221;
        goto L77
    L75:
        r221 = 524288;
        goto L76
    L61:
        if ((r56 & 196608) != 0) goto L67;
        if (r2.changed(r45) == false) goto L65;
        int r222 = 131072;
    L66:
        r6 = r6 | r222;
        goto L67
    L65:
        r222 = 65536;
        goto L66
    L50:
        if ((r56 & 24576) != 0) goto L57;
        if (r2.changed(r44) == false) goto L54;
        int r223 = 16384;
    L55:
        r6 = r6 | r223;
        goto L57
    L54:
        r223 = 8192;
        goto L55
    L39:
        if ((r56 & 3072) != 0) goto L46;
        if (r2.changed(r43) == false) goto L43;
        int r224 = 2048;
    L44:
        r6 = r6 | r224;
        goto L46
    L43:
        r224 = 1024;
        goto L44
    L28:
        if ((r56 & 384) != 0) goto L35;
        if (r2.changed(r42) == false) goto L32;
        int r127 = 256;
    L33:
        r6 = r6 | r127;
        goto L35
    L32:
        r127 = 128;
        goto L33
    L17:
        if ((r56 & 48) != 0) goto L24;
        if (r2.changed(r41) == false) goto L21;
        int r128 = 32;
    L22:
        r6 = r6 | r128;
        goto L24
    L21:
        r128 = 16;
        goto L22
    L6:
        if ((r56 & 6) == 0) goto L8;
        r6 = r56;
        goto L13
    L8:
        if (r2.changed(r40) == false) goto L10;
        int r68 = 4;
    L11:
        r6 = r68 | r56;
        goto L13
    L10:
        r68 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(final TextFieldValue r41, final Function1 r42, Modifier r43, boolean r44, boolean r45, TextStyle r46, KeyboardOptions r47, KeyboardActions r48, boolean r49, int r50, VisualTransformation r51, Function1 r52, MutableInteractionSource r53, Brush r54, Function3 r55, Composer r56, final int r57, final int r58, final int r59) {
        Composer r1 = r56.startRestartGroup(1742344466);
        if ((r59 & 1) == 0) goto L6;
        int r5 = r57 | 6;
    L14:
        if ((r59 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r9 = r59 & 4;
        if (r9 == 0) goto L28;
        r5 = r5 | 384;
    L35:
        int r16 = r59 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r5 = r5 | 3072;
    L46:
        int r19 = r59 & 16;
        int r20 = 16384;
        if (r19 == 0) goto L50;
        r5 = r5 | 24576;
    L57:
        int r23 = r59 & 32;
        if (r23 == 0) goto L61;
        r5 = r5 | 196608;
    L67:
        int r25 = r59 & 64;
        if (r25 == 0) goto L71;
        r5 = r5 | 1572864;
    L77:
        int r10 = r59 & 128;
        if (r10 == 0) goto L81;
        r5 = r5 | 12582912;
    L87:
        int r0 = r59 & 256;
        if (r0 == 0) goto L91;
        r5 = r5 | 100663296;
    L97:
        int r2 = r59 & 512;
        if (r2 == 0) goto L101;
        r5 = r5 | 805306368;
    L107:
        int r3 = r59 & 1024;
        if (r3 == 0) goto L111;
        int r22 = r58 | 6;
    L118:
        int r4 = r59 & 2048;
        if (r4 == 0) goto L122;
        r22 = r22 | 48;
    L128:
        int r6 = r22;
        int r7 = r59 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L139:
        int r8 = r59 & 8192;
        if (r8 == 0) goto L143;
        r6 = r6 | 3072;
    L150:
        int r11 = r59 & 16384;
        if (r11 == 0) goto L154;
        r6 = r6 | 24576;
    L162:
        if ((r5 & 306783379) == 306783378) goto L164;
    L167:
        boolean r12 = true;
    L169:
        if (r1.shouldExecute(r12, r5 & 1) == false) goto L222;
        if (r9 == 0) goto L172;
        Modifier r13 = Modifier.Companion;
    L173:
        if (r16 == 0) goto L175;
        boolean r14 = true;
    L176:
        if (r19 == 0) goto L178;
        boolean r15 = false;
    L179:
        if (r23 == 0) goto L181;
        TextStyle r36 = TextStyle.Companion.getDefault();
    L182:
        if (r25 == 0) goto L184;
        KeyboardOptions r37 = KeyboardOptions.Companion.getDefault();
    L185:
        if (r10 == 0) goto L187;
        KeyboardActions r18 = KeyboardActions.Companion.getDefault();
    L188:
        if (r0 == 0) goto L190;
        boolean r21 = false;
    L191:
        if (r2 == 0) goto L193;
        int r24 = Integer.MAX_VALUE;
    L194:
        if (r3 == 0) goto L196;
        VisualTransformation r26 = VisualTransformation.Companion.getNone();
    L197:
        if (r4 == 0) goto L202;
        Object r27 = r1.rememberedValue();
        if (r27 != Composer.Companion.getEmpty()) goto L201;
        r27 = new s();
        r1.updateRememberedValue(r27);
    L201:
        Function1 r28 = (Function1) r27;
    L203:
        if (r7 == 0) goto L208;
        Object r29 = r1.rememberedValue();
        if (r29 != Composer.Companion.getEmpty()) goto L207;
        r29 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r29);
    L207:
        MutableInteractionSource r30 = (MutableInteractionSource) r29;
    L209:
        if (r8 == 0) goto L211;
        Brush r31 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
    L212:
        if (r11 == 0) goto L214;
        Function3 r32 = ComposableSingletons$BasicTextFieldKt.INSTANCE.m1362getLambda$665310900$foundation_release();
    L216:
        if (ComposerKt.isTraceInProgress() == false) goto L218;
        ComposerKt.traceEventStart(1742344466, r5, r6, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:978)");
    L218:
        int r33 = (((((((((r5 & 14) | (r5 & 112)) | (r5 & 896)) | (r5 & 7168)) | (57344 & r5)) | (458752 & r5)) | (3670016 & r5)) | (29360128 & r5)) | (234881024 & r5)) | (r5 & 1879048192);
        int r34 = r6 << 3;
        Modifier r110 = r13;
        boolean r111 = r14;
        boolean r210 = r15;
        TextStyle r211 = r36;
        KeyboardOptions r212 = r37;
        KeyboardActions r213 = r18;
        boolean r214 = r21;
        int r215 = r24;
        VisualTransformation r216 = r26;
        Function1 r217 = r28;
        MutableInteractionSource r218 = r30;
        Brush r35 = r31;
        Function3 r38 = r32;
        BasicTextField(r41, r42, r110, r111, r210, r211, r212, r213, r214, r215, 1, r216, r217, r218, r35, r38, r1, r33, (((((r34 & 112) | 6) | (r34 & 896)) | (r34 & 7168)) | (57344 & r34)) | (r34 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L221;
        ComposerKt.traceEventEnd();
    L221:
        final Function3 r112 = r32;
        final VisualTransformation r113 = r26;
        final Brush r114 = r31;
        final Modifier r39 = r13;
        final KeyboardActions r40 = r18;
        final boolean r60 = r15;
        final TextStyle r61 = r36;
        final boolean r62 = r21;
        final int r115 = r24;
        final MutableInteractionSource r116 = r30;
        final KeyboardOptions r63 = r37;
        boolean r410 = r14;
        final Function1 r117 = r28;
        final boolean r64 = r410;
    L223:
        ScopeUpdateScope r65 = r1.endRestartGroup();
        if (r65 == null) goto L227;
        r65.updateScope(new t(r41, r42, r39, r64, r60, r61, r63, r40, r62, r115, r113, r117, r116, r114, r112, r57, r58, r59));
        return;
    L227:
        return;
    L214:
        r32 = r55;
        goto L216
    L211:
        r31 = r54;
        goto L212
    L208:
        r30 = r53;
        goto L209
    L202:
        r28 = r52;
        goto L203
    L196:
        r26 = r51;
        goto L197
    L193:
        r24 = r50;
        goto L194
    L190:
        r21 = r49;
        goto L191
    L187:
        r18 = r48;
        goto L188
    L184:
        r37 = r47;
        goto L185
    L181:
        r36 = r46;
        goto L182
    L178:
        r15 = r45;
        goto L179
    L175:
        r14 = r44;
        goto L176
    L172:
        r13 = r43;
        goto L173
    L222:
        r1 = r1;
        r1.skipToGroupEnd();
        r39 = r43;
        r64 = r44;
        r60 = r45;
        r61 = r46;
        r63 = r47;
        r40 = r48;
        r62 = r49;
        r115 = r50;
        r113 = r51;
        r117 = r52;
        r116 = r53;
        r114 = r54;
        r112 = r55;
        goto L223
    L164:
        if ((r6 & 9363) != 9362) goto L167;
        r12 = false;
        goto L169
    L154:
        if ((r58 & 24576) != 0) goto L162;
        if (r1.changedInstance(r55) == true) goto L159;
        r20 = 8192;
    L159:
        r6 = r6 | r20;
        goto L162
    L143:
        if ((r58 & 3072) != 0) goto L150;
        if (r1.changed(r54) == true) goto L148;
        r17 = 1024;
    L148:
        r6 = r6 | r17;
        goto L150
    L132:
        if ((r58 & 384) != 0) goto L139;
        if (r1.changed(r53) == false) goto L136;
        int r219 = 256;
    L137:
        r6 = r6 | r219;
        goto L139
    L136:
        r219 = 128;
        goto L137
    L122:
        if ((r58 & 48) != 0) goto L128;
        if (r1.changedInstance(r52) == false) goto L126;
        int r220 = 32;
    L127:
        r22 = r22 | r220;
        goto L128
    L126:
        r220 = 16;
        goto L127
    L111:
        if ((r58 & 6) == 0) goto L113;
        r22 = r58;
        goto L118
    L113:
        if (r1.changed(r51) == false) goto L115;
        int r221 = 4;
    L116:
        r22 = r58 | r221;
        goto L118
    L115:
        r221 = 2;
        goto L116
    L101:
        if ((r57 & 805306368) != 0) goto L107;
        if (r1.changed(r50) == false) goto L105;
        int r310 = 536870912;
    L106:
        r5 = r5 | r310;
        goto L107
    L105:
        r310 = 268435456;
        goto L106
    L91:
        if ((r57 & 100663296) != 0) goto L97;
        if (r1.changed(r49) == false) goto L95;
        int r311 = 67108864;
    L96:
        r5 = r5 | r311;
        goto L97
    L95:
        r311 = 33554432;
        goto L96
    L81:
        if ((r57 & 12582912) != 0) goto L87;
        if (r1.changed(r48) == false) goto L85;
        int r222 = 8388608;
    L86:
        r5 = r5 | r222;
        goto L87
    L85:
        r222 = 4194304;
        goto L86
    L71:
        if ((r57 & 1572864) != 0) goto L77;
        if (r1.changed(r47) == false) goto L75;
        int r223 = 1048576;
    L76:
        r5 = r5 | r223;
        goto L77
    L75:
        r223 = 524288;
        goto L76
    L61:
        if ((r57 & 196608) != 0) goto L67;
        if (r1.changed(r46) == false) goto L65;
        int r224 = 131072;
    L66:
        r5 = r5 | r224;
        goto L67
    L65:
        r224 = 65536;
        goto L66
    L50:
        if ((r57 & 24576) != 0) goto L57;
        if (r1.changed(r45) == false) goto L54;
        int r225 = 16384;
    L55:
        r5 = r5 | r225;
        goto L57
    L54:
        r225 = 8192;
        goto L55
    L39:
        if ((r57 & 3072) != 0) goto L46;
        if (r1.changed(r44) == false) goto L43;
        int r118 = 2048;
    L44:
        r5 = r5 | r118;
        goto L46
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r57 & 384) != 0) goto L35;
        if (r1.changed(r43) == false) goto L32;
        int r119 = 256;
    L33:
        r5 = r5 | r119;
        goto L35
    L32:
        r119 = 128;
        goto L33
    L17:
        if ((r57 & 48) != 0) goto L24;
        if (r1.changedInstance(r42) == false) goto L21;
        int r66 = 32;
    L22:
        r5 = r5 | r66;
        goto L24
    L21:
        r66 = 16;
        goto L22
    L6:
        if ((r57 & 6) == 0) goto L8;
        r5 = r57;
        goto L14
    L8:
        if (r1.changed(r41) == false) goto L10;
        int r67 = 4;
    L11:
        r5 = r67 | r57;
        goto L14
    L10:
        r67 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(final String r41, final Function1 r42, Modifier r43, boolean r44, boolean r45, TextStyle r46, KeyboardOptions r47, KeyboardActions r48, boolean r49, int r50, VisualTransformation r51, Function1 r52, MutableInteractionSource r53, Brush r54, Function3 r55, Composer r56, final int r57, final int r58, final int r59) {
        Composer r1 = r56.startRestartGroup(74291967);
        if ((r59 & 1) == 0) goto L6;
        int r5 = r57 | 6;
    L14:
        if ((r59 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r9 = r59 & 4;
        if (r9 == 0) goto L28;
        r5 = r5 | 384;
    L35:
        int r16 = r59 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r5 = r5 | 3072;
    L46:
        int r19 = r59 & 16;
        int r20 = 16384;
        if (r19 == 0) goto L50;
        r5 = r5 | 24576;
    L57:
        int r23 = r59 & 32;
        if (r23 == 0) goto L61;
        r5 = r5 | 196608;
    L67:
        int r25 = r59 & 64;
        if (r25 == 0) goto L71;
        r5 = r5 | 1572864;
    L77:
        int r10 = r59 & 128;
        if (r10 == 0) goto L81;
        r5 = r5 | 12582912;
    L87:
        int r0 = r59 & 256;
        if (r0 == 0) goto L91;
        r5 = r5 | 100663296;
    L97:
        int r2 = r59 & 512;
        if (r2 == 0) goto L101;
        r5 = r5 | 805306368;
    L107:
        int r3 = r59 & 1024;
        if (r3 == 0) goto L111;
        int r22 = r58 | 6;
    L118:
        int r4 = r59 & 2048;
        if (r4 == 0) goto L122;
        r22 = r22 | 48;
    L128:
        int r6 = r22;
        int r7 = r59 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L139:
        int r8 = r59 & 8192;
        if (r8 == 0) goto L143;
        r6 = r6 | 3072;
    L150:
        int r11 = r59 & 16384;
        if (r11 == 0) goto L154;
        r6 = r6 | 24576;
    L162:
        if ((r5 & 306783379) == 306783378) goto L164;
    L167:
        boolean r12 = true;
    L169:
        if (r1.shouldExecute(r12, r5 & 1) == false) goto L222;
        if (r9 == 0) goto L172;
        Modifier r13 = Modifier.Companion;
    L173:
        if (r16 == 0) goto L175;
        boolean r14 = true;
    L176:
        if (r19 == 0) goto L178;
        boolean r15 = false;
    L179:
        if (r23 == 0) goto L181;
        TextStyle r36 = TextStyle.Companion.getDefault();
    L182:
        if (r25 == 0) goto L184;
        KeyboardOptions r37 = KeyboardOptions.Companion.getDefault();
    L185:
        if (r10 == 0) goto L187;
        KeyboardActions r18 = KeyboardActions.Companion.getDefault();
    L188:
        if (r0 == 0) goto L190;
        boolean r21 = false;
    L191:
        if (r2 == 0) goto L193;
        int r24 = Integer.MAX_VALUE;
    L194:
        if (r3 == 0) goto L196;
        VisualTransformation r26 = VisualTransformation.Companion.getNone();
    L197:
        if (r4 == 0) goto L202;
        Object r27 = r1.rememberedValue();
        if (r27 != Composer.Companion.getEmpty()) goto L201;
        r27 = new j0();
        r1.updateRememberedValue(r27);
    L201:
        Function1 r28 = (Function1) r27;
    L203:
        if (r7 == 0) goto L208;
        Object r29 = r1.rememberedValue();
        if (r29 != Composer.Companion.getEmpty()) goto L207;
        r29 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r29);
    L207:
        MutableInteractionSource r30 = (MutableInteractionSource) r29;
    L209:
        if (r8 == 0) goto L211;
        Brush r31 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
    L212:
        if (r11 == 0) goto L214;
        Function3 r32 = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$444370233$foundation_release();
    L216:
        if (ComposerKt.isTraceInProgress() == false) goto L218;
        ComposerKt.traceEventStart(74291967, r5, r6, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:938)");
    L218:
        int r33 = (((((((((r5 & 14) | (r5 & 112)) | (r5 & 896)) | (r5 & 7168)) | (57344 & r5)) | (458752 & r5)) | (3670016 & r5)) | (29360128 & r5)) | (234881024 & r5)) | (r5 & 1879048192);
        int r34 = r6 << 3;
        Modifier r110 = r13;
        boolean r111 = r14;
        boolean r210 = r15;
        TextStyle r211 = r36;
        KeyboardOptions r212 = r37;
        KeyboardActions r213 = r18;
        boolean r214 = r21;
        int r215 = r24;
        VisualTransformation r216 = r26;
        Function1 r217 = r28;
        MutableInteractionSource r218 = r30;
        Brush r35 = r31;
        Function3 r38 = r32;
        BasicTextField(r41, r42, r110, r111, r210, r211, r212, r213, r214, r215, 1, r216, r217, r218, r35, r38, r1, r33, (((((r34 & 112) | 6) | (r34 & 896)) | (r34 & 7168)) | (57344 & r34)) | (r34 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L221;
        ComposerKt.traceEventEnd();
    L221:
        final Function3 r112 = r32;
        final VisualTransformation r113 = r26;
        final Brush r114 = r31;
        final Modifier r39 = r13;
        final KeyboardActions r40 = r18;
        final boolean r60 = r15;
        final TextStyle r61 = r36;
        final boolean r62 = r21;
        final int r115 = r24;
        final MutableInteractionSource r116 = r30;
        final KeyboardOptions r63 = r37;
        boolean r410 = r14;
        final Function1 r117 = r28;
        final boolean r64 = r410;
    L223:
        ScopeUpdateScope r65 = r1.endRestartGroup();
        if (r65 == null) goto L227;
        r65.updateScope(new q(r41, r42, r39, r64, r60, r61, r63, r40, r62, r115, r113, r117, r116, r114, r112, r57, r58, r59));
        return;
    L227:
        return;
    L214:
        r32 = r55;
        goto L216
    L211:
        r31 = r54;
        goto L212
    L208:
        r30 = r53;
        goto L209
    L202:
        r28 = r52;
        goto L203
    L196:
        r26 = r51;
        goto L197
    L193:
        r24 = r50;
        goto L194
    L190:
        r21 = r49;
        goto L191
    L187:
        r18 = r48;
        goto L188
    L184:
        r37 = r47;
        goto L185
    L181:
        r36 = r46;
        goto L182
    L178:
        r15 = r45;
        goto L179
    L175:
        r14 = r44;
        goto L176
    L172:
        r13 = r43;
        goto L173
    L222:
        r1 = r1;
        r1.skipToGroupEnd();
        r39 = r43;
        r64 = r44;
        r60 = r45;
        r61 = r46;
        r63 = r47;
        r40 = r48;
        r62 = r49;
        r115 = r50;
        r113 = r51;
        r117 = r52;
        r116 = r53;
        r114 = r54;
        r112 = r55;
        goto L223
    L164:
        if ((r6 & 9363) != 9362) goto L167;
        r12 = false;
        goto L169
    L154:
        if ((r58 & 24576) != 0) goto L162;
        if (r1.changedInstance(r55) == true) goto L159;
        r20 = 8192;
    L159:
        r6 = r6 | r20;
        goto L162
    L143:
        if ((r58 & 3072) != 0) goto L150;
        if (r1.changed(r54) == true) goto L148;
        r17 = 1024;
    L148:
        r6 = r6 | r17;
        goto L150
    L132:
        if ((r58 & 384) != 0) goto L139;
        if (r1.changed(r53) == false) goto L136;
        int r219 = 256;
    L137:
        r6 = r6 | r219;
        goto L139
    L136:
        r219 = 128;
        goto L137
    L122:
        if ((r58 & 48) != 0) goto L128;
        if (r1.changedInstance(r52) == false) goto L126;
        int r220 = 32;
    L127:
        r22 = r22 | r220;
        goto L128
    L126:
        r220 = 16;
        goto L127
    L111:
        if ((r58 & 6) == 0) goto L113;
        r22 = r58;
        goto L118
    L113:
        if (r1.changed(r51) == false) goto L115;
        int r221 = 4;
    L116:
        r22 = r58 | r221;
        goto L118
    L115:
        r221 = 2;
        goto L116
    L101:
        if ((r57 & 805306368) != 0) goto L107;
        if (r1.changed(r50) == false) goto L105;
        int r310 = 536870912;
    L106:
        r5 = r5 | r310;
        goto L107
    L105:
        r310 = 268435456;
        goto L106
    L91:
        if ((r57 & 100663296) != 0) goto L97;
        if (r1.changed(r49) == false) goto L95;
        int r311 = 67108864;
    L96:
        r5 = r5 | r311;
        goto L97
    L95:
        r311 = 33554432;
        goto L96
    L81:
        if ((r57 & 12582912) != 0) goto L87;
        if (r1.changed(r48) == false) goto L85;
        int r222 = 8388608;
    L86:
        r5 = r5 | r222;
        goto L87
    L85:
        r222 = 4194304;
        goto L86
    L71:
        if ((r57 & 1572864) != 0) goto L77;
        if (r1.changed(r47) == false) goto L75;
        int r223 = 1048576;
    L76:
        r5 = r5 | r223;
        goto L77
    L75:
        r223 = 524288;
        goto L76
    L61:
        if ((r57 & 196608) != 0) goto L67;
        if (r1.changed(r46) == false) goto L65;
        int r224 = 131072;
    L66:
        r5 = r5 | r224;
        goto L67
    L65:
        r224 = 65536;
        goto L66
    L50:
        if ((r57 & 24576) != 0) goto L57;
        if (r1.changed(r45) == false) goto L54;
        int r225 = 16384;
    L55:
        r5 = r5 | r225;
        goto L57
    L54:
        r225 = 8192;
        goto L55
    L39:
        if ((r57 & 3072) != 0) goto L46;
        if (r1.changed(r44) == false) goto L43;
        int r118 = 2048;
    L44:
        r5 = r5 | r118;
        goto L46
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r57 & 384) != 0) goto L35;
        if (r1.changed(r43) == false) goto L32;
        int r119 = 256;
    L33:
        r5 = r5 | r119;
        goto L35
    L32:
        r119 = 128;
        goto L33
    L17:
        if ((r57 & 48) != 0) goto L24;
        if (r1.changedInstance(r42) == false) goto L21;
        int r66 = 32;
    L22:
        r5 = r5 | r66;
        goto L24
    L21:
        r66 = 16;
        goto L22
    L6:
        if ((r57 & 6) == 0) goto L8;
        r5 = r57;
        goto L14
    L8:
        if (r1.changed(r41) == false) goto L10;
        int r67 = 4;
    L11:
        r5 = r67 | r57;
        goto L14
    L10:
        r67 = 2;
        goto L11
    }

    public static final void BasicTextField(final String r41, final Function1<? super String, Unit> r42, Modifier r43, boolean r44, boolean r45, TextStyle r46, KeyboardOptions r47, KeyboardActions r48, boolean r49, int r50, int r51, VisualTransformation r52, Function1<? super TextLayoutResult, Unit> r53, MutableInteractionSource r54, Brush r55, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r56, Composer r57, final int r58, final int r59, final int r60) {
        Composer r3 = r57.startRestartGroup(2026950908);
        if ((r60 & 1) == 0) goto L6;
        int r4 = r58 | 6;
    L14:
        if ((r60 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r7 = r60 & 4;
        if (r7 == 0) goto L27;
        r4 = r4 | 384;
    L34:
        int r16 = r60 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L38;
        r4 = r4 | 3072;
    L45:
        int r19 = r60 & 16;
        int r20 = 16384;
        if (r19 == 0) goto L49;
        r4 = r4 | 24576;
    L56:
        int r23 = r60 & 32;
        if (r23 == 0) goto L60;
        r4 = r4 | 196608;
    L66:
        int r26 = r60 & 64;
        if (r26 == 0) goto L70;
        r4 = r4 | 1572864;
    L76:
        int r5 = r60 & 128;
        if (r5 == 0) goto L80;
        r4 = r4 | 12582912;
    L86:
        int r0 = r60 & 256;
        if (r0 == 0) goto L90;
        r4 = r4 | 100663296;
    L97:
        if ((r58 & 805306368) != 0) goto L107;
        if ((r60 & 512) != 0) goto L104;
        if (r3.changed(r50) == false) goto L104;
        int r31 = 536870912;
    L105:
        r4 = r4 | r31;
    L104:
        r31 = 268435456;
    L107:
        int r6 = r60 & 1024;
        if (r6 == 0) goto L111;
        int r32 = r59 | 6;
    L118:
        int r8 = r60 & 2048;
        if (r8 == 0) goto L122;
        r32 = r32 | 48;
    L128:
        int r9 = r32;
        int r10 = r60 & 4096;
        if (r10 == 0) goto L132;
        r9 = r9 | 384;
    L139:
        int r11 = r60 & 8192;
        if (r11 == 0) goto L143;
        r9 = r9 | 3072;
    L150:
        int r12 = r60 & 16384;
        if (r12 == 0) goto L154;
        r9 = r9 | 24576;
    L161:
        int r18 = r60 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r18 == 0) goto L165;
        r9 = r9 | 196608;
    L171:
        boolean r110 = true;
        if ((r4 & 306783379) == 306783378) goto L174;
    L177:
        boolean r2 = true;
    L179:
        if (r3.shouldExecute(r2, r4 & 1) == false) goto L284;
        r3.startDefaults();
        if ((r58 & 1) != 0) goto L183;
    L189:
        if (r7 == 0) goto L191;
        Modifier r13 = Modifier.Companion;
    L192:
        if (r16 == 0) goto L194;
        boolean r14 = true;
    L195:
        if (r19 == 0) goto L197;
        boolean r111 = false;
    L198:
        if (r23 == 0) goto L200;
        TextStyle r112 = TextStyle.Companion.getDefault();
    L201:
        if (r26 == 0) goto L203;
        KeyboardOptions r21 = KeyboardOptions.Companion.getDefault();
    L204:
        if (r5 == 0) goto L206;
        KeyboardActions r15 = KeyboardActions.Companion.getDefault();
    L207:
        if (r0 == 0) goto L209;
        boolean r1 = false;
    L211:
        if ((r60 & 512) == 0) goto L216;
        if (r1 == false) goto L214;
        r50 = 1;
    L215:
        r4 = r4 & (-1879048193);
    L217:
        if (r6 == 0) goto L219;
        int r22 = 1;
    L220:
        if (r8 == 0) goto L222;
        VisualTransformation r24 = VisualTransformation.Companion.getNone();
    L223:
        if (r10 == 0) goto L228;
        Object r113 = r3.rememberedValue();
        if (r113 != Composer.Companion.getEmpty()) goto L227;
        r113 = new d0();
        r3.updateRememberedValue(r113);
    L227:
        Function1<? super TextLayoutResult, Unit> r114 = (Function1) r113;
    L229:
        if (r11 == 0) goto L231;
        MutableInteractionSource r115 = null;
    L232:
        if (r12 == 0) goto L234;
        Brush r116 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
    L235:
        if (r18 == 0) goto L237;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r38 = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$759698998$foundation_release();
    L238:
        MutableInteractionSource r117 = r115;
        Brush r37 = r116;
        boolean r25 = r111;
        TextStyle r27 = r112;
        VisualTransformation r118 = r24;
        Function1<? super TextLayoutResult, Unit> r119 = r114;
        int r28 = r4;
        int r120 = r22;
        KeyboardOptions r29 = r21;
        boolean r30 = r1;
    L239:
        r3.endDefaults();
        int r510 = r120;
        if (ComposerKt.isTraceInProgress() == false) goto L242;
        ComposerKt.traceEventStart(2026950908, r28, r9, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:737)");
    L242:
        Object r121 = r3.rememberedValue();
        Composer.Companion r122 = Composer.Companion;
        if (r121 != r122.getEmpty()) goto L246;
        r121 = SnapshotStateKt.mutableStateOf$default(new TextFieldValue(r41, 0, null, 6, null), null, 2, null);
        r3.updateRememberedValue(r121);
    L246:
        final MutableState r123 = (MutableState) r121;
        final TextFieldValue r33 = TextFieldValue.copy-3r_uNRQ$default(BasicTextField$lambda$38(r123), r41, 0, null, 6, null);
        boolean r124 = r3.changed(r33);
        boolean r410 = r14;
        Object r34 = r3.rememberedValue();
        if (r124 == false) goto L249;
    L250:
        r34 = new e0(r33, r123);
        r3.updateRememberedValue(r34);
    L251:
        EffectsKt.SideEffect((Function0) r34, r3, 0);
        if ((r28 & 14) != 4) goto L254;
        boolean r35 = true;
    L255:
        Object r125 = r3.rememberedValue();
        if (r35 == false) goto L258;
    L261:
        Object r36 = SnapshotStateKt.mutableStateOf$default(r41, null, 2, null);
        r3.updateRememberedValue(r36);
    L262:
        final MutableState r39 = (MutableState) r36;
        ImeOptions r40 = r29.toImeOptions$foundation_release(r30);
        boolean r210 = !r30;
        if (r30 == false) goto L265;
        int r211 = 1;
    L266:
        if (r30 == false) goto L268;
        int r212 = 1;
    L269:
        boolean r126 = r3.changed(r39);
        KeyboardOptions r411 = r29;
        boolean r412 = r30;
        if ((r28 & 112) == 32) goto L273;
        r110 = false;
    L273:
        boolean r61 = r126 | r110;
        Object r62 = r3.rememberedValue();
        if (r61 == false) goto L276;
    L279:
        r62 = new f0(r42, r123, r39);
        r3.updateRememberedValue(r62);
    L280:
        int r63 = r9 << 9;
        Modifier r127 = r13;
        TextStyle r128 = r27;
        VisualTransformation r213 = r118;
        Function1<? super TextLayoutResult, Unit> r214 = r119;
        MutableInteractionSource r215 = r117;
        Brush r216 = r37;
        KeyboardActions r217 = r15;
        boolean r310 = r25;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r311 = r38;
        CoreTextFieldKt.CoreTextField(r33, (Function1) r62, r127, r128, r213, r214, r215, r216, r210, r212, r211, r40, r217, r410, r310, r311, null, r3, (((((r28 & 896) | ((r28 >> 6) & 7168)) | (57344 & r63)) | (458752 & r63)) | (3670016 & r63)) | (r63 & 29360128), ((((r28 >> 15) & 896) | (r28 & 7168)) | (57344 & r28)) | (458752 & r9), 65536);
        if (ComposerKt.isTraceInProgress() == false) goto L283;
        ComposerKt.traceEventEnd();
    L283:
        boolean r64 = r410;
        KeyboardActions r129 = r15;
        KeyboardOptions r65 = r411;
        int r130 = r510;
        boolean r66 = r25;
        TextStyle r67 = r27;
        Modifier r68 = r13;
        Function1<? super TextLayoutResult, Unit> r131 = r119;
        MutableInteractionSource r132 = r117;
        int r133 = r50;
        VisualTransformation r134 = r118;
        boolean r135 = r412;
    L285:
        ScopeUpdateScope r69 = r3.endRestartGroup();
        if (r69 == null) goto L289;
        final Modifier r70 = r68;
        final boolean r71 = r64;
        final boolean r72 = r66;
        final TextStyle r73 = r67;
        final KeyboardOptions r74 = r65;
        final KeyboardActions r75 = r129;
        final boolean r76 = r135;
        final int r136 = r133;
        final int r137 = r130;
        final VisualTransformation r138 = r134;
        final Function1<? super TextLayoutResult, Unit> r139 = r131;
        final MutableInteractionSource r140 = r132;
        final Brush r141 = r37;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r142 = r38;
        r69.updateScope(new g0(r41, r42, r70, r71, r72, r73, r74, r75, r76, r136, r137, r138, r139, r140, r141, r142, r58, r59, r60));
        return;
    L289:
        return;
    L276:
        if (r62 != r122.getEmpty()) goto L280;
    L268:
        r212 = r50;
        goto L269
    L265:
        r211 = r510;
        goto L266
    L258:
        if (r125 == r122.getEmpty()) goto L261;
        r36 = r125;
        goto L262
    L254:
        r35 = false;
        goto L255
    L249:
        if (r34 != r122.getEmpty()) goto L251;
    L237:
        r38 = r56;
        goto L238
    L234:
        r116 = r55;
        goto L235
    L231:
        r115 = r54;
        goto L232
    L228:
        r114 = r53;
        goto L229
    L222:
        r24 = r52;
        goto L223
    L219:
        r22 = r51;
        goto L220
    L214:
        r50 = Integer.MAX_VALUE;
        goto L215
    L216:
        r50 = r50;
        goto L217
    L209:
        r1 = r49;
        goto L211
    L206:
        r15 = r48;
        goto L207
    L203:
        r21 = r47;
        goto L204
    L200:
        r112 = r46;
        goto L201
    L197:
        r111 = r45;
        goto L198
    L194:
        r14 = r44;
        goto L195
    L191:
        r13 = r43;
        goto L192
    L183:
        if (r3.getDefaultsInvalid() == true) goto L189;
        r3.skipToGroupEnd();
        if ((r60 & 512) == 0) goto L188;
        r4 = r4 & (-1879048193);
    L188:
        r13 = r43;
        r14 = r44;
        r25 = r45;
        r27 = r46;
        r15 = r48;
        r30 = r49;
        r120 = r51;
        r118 = r52;
        r119 = r53;
        r117 = r54;
        r37 = r55;
        r38 = r56;
        r28 = r4;
        r29 = r47;
        goto L239
    L284:
        r3.skipToGroupEnd();
        r68 = r43;
        r64 = r44;
        r66 = r45;
        r67 = r46;
        r65 = r47;
        r129 = r48;
        r135 = r49;
        r133 = r50;
        r130 = r51;
        r134 = r52;
        r131 = r53;
        r132 = r54;
        r37 = r55;
        r38 = r56;
        goto L285
    L174:
        if ((74899 & r9) != 74898) goto L177;
        r2 = false;
        goto L179
    L165:
        if ((r59 & 196608) != 0) goto L171;
        if (r3.changedInstance(r56) == false) goto L169;
        int r143 = 131072;
    L170:
        r9 = r9 | r143;
        goto L171
    L169:
        r143 = 65536;
        goto L170
    L154:
        if ((r59 & 24576) != 0) goto L161;
        if (r3.changed(r55) == true) goto L159;
        r20 = 8192;
    L159:
        r9 = r9 | r20;
        goto L161
    L143:
        if ((r59 & 3072) != 0) goto L150;
        if (r3.changed(r54) == true) goto L148;
        r17 = 1024;
    L148:
        r9 = r9 | r17;
        goto L150
    L132:
        if ((r59 & 384) != 0) goto L139;
        if (r3.changedInstance(r53) == false) goto L136;
        int r218 = 256;
    L137:
        r9 = r9 | r218;
        goto L139
    L136:
        r218 = 128;
        goto L137
    L122:
        if ((r59 & 48) != 0) goto L128;
        if (r3.changed(r52) == false) goto L126;
        int r312 = 32;
    L127:
        r32 = r32 | r312;
        goto L128
    L126:
        r312 = 16;
        goto L127
    L111:
        if ((r59 & 6) == 0) goto L113;
        r32 = r59;
        goto L118
    L113:
        if (r3.changed(r51) == false) goto L115;
        int r313 = 4;
    L116:
        r32 = r59 | r313;
        goto L118
    L115:
        r313 = 2;
        goto L116
    L90:
        if ((r58 & 100663296) != 0) goto L97;
        if (r3.changed(r49) == false) goto L94;
        int r314 = 67108864;
    L95:
        r4 = r4 | r314;
        goto L97
    L94:
        r314 = 33554432;
        goto L95
    L80:
        if ((r58 & 12582912) != 0) goto L86;
        if (r3.changed(r48) == false) goto L84;
        int r315 = 8388608;
    L85:
        r4 = r4 | r315;
        goto L86
    L84:
        r315 = 4194304;
        goto L85
    L70:
        if ((r58 & 1572864) != 0) goto L76;
        if (r3.changed(r47) == false) goto L74;
        int r219 = 1048576;
    L75:
        r4 = r4 | r219;
        goto L76
    L74:
        r219 = 524288;
        goto L75
    L60:
        if ((r58 & 196608) != 0) goto L66;
        if (r3.changed(r46) == false) goto L64;
        int r220 = 131072;
    L65:
        r4 = r4 | r220;
        goto L66
    L64:
        r220 = 65536;
        goto L65
    L49:
        if ((r58 & 24576) != 0) goto L56;
        if (r3.changed(r45) == false) goto L53;
        int r221 = 16384;
    L54:
        r4 = r4 | r221;
        goto L56
    L53:
        r221 = 8192;
        goto L54
    L38:
        if ((r58 & 3072) != 0) goto L45;
        if (r3.changed(r44) == false) goto L42;
        int r144 = 2048;
    L43:
        r4 = r4 | r144;
        goto L45
    L42:
        r144 = 1024;
        goto L43
    L27:
        if ((r58 & 384) != 0) goto L34;
        if (r3.changed(r43) == false) goto L31;
        int r145 = 256;
    L32:
        r4 = r4 | r145;
        goto L34
    L31:
        r145 = 128;
        goto L32
    L17:
        if ((r58 & 48) != 0) goto L23;
        if (r3.changedInstance(r42) == false) goto L21;
        int r77 = 32;
    L22:
        r4 = r4 | r77;
        goto L23
    L21:
        r77 = 16;
        goto L22
    L6:
        if ((r58 & 6) == 0) goto L8;
        r4 = r58;
        goto L14
    L8:
        if (r3.changed(r41) == false) goto L10;
        int r78 = 4;
    L11:
        r4 = r78 | r58;
        goto L14
    L10:
        r78 = 2;
        goto L11
    }

    public static final void BasicTextField(final TextFieldValue r38, final Function1<? super TextFieldValue, Unit> r39, Modifier r40, boolean r41, boolean r42, TextStyle r43, KeyboardOptions r44, KeyboardActions r45, boolean r46, int r47, int r48, VisualTransformation r49, Function1<? super TextLayoutResult, Unit> r50, MutableInteractionSource r51, Brush r52, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r53, Composer r54, final int r55, final int r56, final int r57) {
        Composer r10 = r54.startRestartGroup(-971111025);
        if ((r57 & 1) == 0) goto L6;
        int r1 = r55 | 6;
    L14:
        if ((r57 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r4 = r57 & 4;
        if (r4 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r16 = r57 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        int r19 = r57 & 16;
        int r20 = 16384;
        if (r19 == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        int r23 = r57 & 32;
        int r24 = 65536;
        if (r23 == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        int r27 = r57 & 64;
        if (r27 == 0) goto L70;
        r1 = r1 | 1572864;
    L76:
        int r6 = r57 & 128;
        if (r6 == 0) goto L80;
        r1 = r1 | 12582912;
    L86:
        int r0 = r57 & 256;
        if (r0 == 0) goto L90;
        r1 = r1 | 100663296;
    L97:
        if ((r55 & 805306368) != 0) goto L107;
        if ((r57 & 512) != 0) goto L104;
        if (r10.changed(r47) == false) goto L104;
        int r32 = 536870912;
    L105:
        r1 = r1 | r32;
    L104:
        r32 = 268435456;
    L107:
        int r2 = r57 & 1024;
        if (r2 == 0) goto L111;
        int r33 = r56 | 6;
    L118:
        int r3 = r57 & 2048;
        if (r3 == 0) goto L122;
        r33 = r33 | 48;
    L128:
        int r5 = r33;
        int r7 = r57 & 4096;
        if (r7 == 0) goto L132;
        r5 = r5 | 384;
    L139:
        int r8 = r57 & 8192;
        if (r8 == 0) goto L143;
        r5 = r5 | 3072;
    L150:
        int r9 = r57 & 16384;
        if (r9 == 0) goto L154;
        r5 = r5 | 24576;
    L161:
        int r18 = r57 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r18 == 0) goto L165;
        r5 = r5 | 196608;
    L170:
        boolean r110 = false;
        if ((r1 & 306783379) == 306783378) goto L173;
    L176:
        boolean r12 = true;
    L178:
        if (r10.shouldExecute(r12, r1 & 1) == false) goto L265;
        r10.startDefaults();
        if ((r55 & 1) != 0) goto L182;
    L188:
        if (r4 == 0) goto L190;
        Modifier r11 = Modifier.Companion;
    L191:
        if (r16 == 0) goto L193;
        boolean r13 = true;
    L194:
        if (r19 == 0) goto L196;
        boolean r14 = false;
    L197:
        if (r23 == 0) goto L199;
        TextStyle r111 = TextStyle.Companion.getDefault();
    L200:
        if (r27 == 0) goto L202;
        KeyboardOptions r112 = KeyboardOptions.Companion.getDefault();
    L203:
        if (r6 == 0) goto L205;
        KeyboardActions r15 = KeyboardActions.Companion.getDefault();
    L206:
        if (r0 == 0) goto L208;
        boolean r21 = false;
    L209:
        Modifier r410 = r11;
        if ((r57 & 512) == 0) goto L215;
        if (r21 == false) goto L213;
        int r22 = 1;
    L214:
        r1 = r1 & (-1879048193);
    L216:
        if (r2 == 0) goto L218;
        int r25 = 1;
    L219:
        if (r3 == 0) goto L221;
        VisualTransformation r26 = VisualTransformation.Companion.getNone();
    L222:
        if (r7 == 0) goto L227;
        Object r28 = r10.rememberedValue();
        if (r28 != Composer.Companion.getEmpty()) goto L226;
        r28 = new y();
        r10.updateRememberedValue(r28);
    L226:
        Function1<? super TextLayoutResult, Unit> r29 = (Function1) r28;
    L228:
        if (r8 == 0) goto L230;
        MutableInteractionSource r30 = null;
    L231:
        if (r9 == 0) goto L233;
        Brush r31 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
    L234:
        if (r18 == 0) goto L236;
        Modifier r210 = r410;
        Function1<? super TextLayoutResult, Unit> r34 = r29;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r35 = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$486633673$foundation_release();
        int r211 = r25;
        VisualTransformation r212 = r26;
        int r213 = r22;
        KeyboardActions r214 = r15;
        MutableInteractionSource r36 = r30;
        Brush r37 = r31;
        boolean r215 = r13;
        boolean r216 = r14;
        TextStyle r217 = r111;
        KeyboardOptions r113 = r112;
        boolean r114 = r21;
        int r58 = r1;
    L237:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L240;
        ComposerKt.traceEventStart(-971111025, r58, r5, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:894)");
    L240:
        ImeOptions r115 = r113.toImeOptions$foundation_release(r114);
        boolean r59 = !r114;
        if (r114 == false) goto L243;
        int r310 = 1;
    L244:
        if (r114 == false) goto L246;
        int r60 = 1;
    L247:
        int r61 = r58 & 14;
        if (r61 != 4) goto L250;
        boolean r62 = true;
    L252:
        if ((r58 & 112) != 32) goto L254;
        r110 = true;
    L254:
        boolean r63 = r62 | r110;
        Object r64 = r10.rememberedValue();
        if (r63 == false) goto L257;
    L260:
        r64 = new z(r38, r39);
        r10.updateRememberedValue(r64);
    L261:
        Function1 r65 = (Function1) r64;
        int r66 = r5 << 9;
        Composer r218 = r10;
        boolean r311 = r114;
        KeyboardOptions r312 = r113;
        CoreTextFieldKt.CoreTextField(r38, r65, r210, r217, r212, r34, r36, r37, r59, r60, r310, r115, r214, r215, r216, r35, null, r218, (((((r61 | (r58 & 896)) | ((r58 >> 6) & 7168)) | (57344 & r66)) | (458752 & r66)) | (3670016 & r66)) | (r66 & 29360128), ((r58 & 57344) | (((r58 >> 15) & 896) | (r58 & 7168))) | (458752 & r5), 65536);
        if (ComposerKt.isTraceInProgress() == false) goto L264;
        ComposerKt.traceEventEnd();
    L264:
        final Modifier r67 = r210;
        final boolean r68 = r215;
        final boolean r69 = r216;
        final TextStyle r70 = r217;
        final KeyboardActions r71 = r214;
        final int r116 = r213;
        final int r117 = r211;
        final VisualTransformation r118 = r212;
        final boolean r72 = r311;
        final KeyboardOptions r73 = r312;
        final Function1<? super TextLayoutResult, Unit> r119 = r34;
        final MutableInteractionSource r120 = r36;
        final Brush r121 = r37;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r122 = r35;
    L266:
        ScopeUpdateScope r74 = r218.endRestartGroup();
        if (r74 == null) goto L270;
        r74.updateScope(new b0(r38, r39, r67, r68, r69, r70, r73, r71, r72, r116, r117, r118, r119, r120, r121, r122, r55, r56, r57));
        return;
    L270:
        return;
    L257:
        if (r64 != Composer.Companion.getEmpty()) goto L261;
    L250:
        r62 = false;
        goto L252
    L246:
        r60 = r213;
        goto L247
    L243:
        r310 = r211;
        goto L244
    L236:
        r210 = r410;
        r58 = r1;
        r34 = r29;
        r35 = r53;
        r211 = r25;
        r212 = r26;
        r213 = r22;
        r214 = r15;
        r36 = r30;
        r37 = r31;
        r215 = r13;
        r216 = r14;
        r217 = r111;
        r113 = r112;
        r114 = r21;
        goto L237
    L233:
        r31 = r52;
        goto L234
    L230:
        r30 = r51;
        goto L231
    L227:
        r29 = r50;
        goto L228
    L221:
        r26 = r49;
        goto L222
    L218:
        r25 = r48;
        goto L219
    L213:
        r22 = Integer.MAX_VALUE;
        goto L214
    L215:
        r22 = r47;
        goto L216
    L208:
        r21 = r46;
        goto L209
    L205:
        r15 = r45;
        goto L206
    L202:
        r112 = r44;
        goto L203
    L199:
        r111 = r43;
        goto L200
    L196:
        r14 = r42;
        goto L197
    L193:
        r13 = r41;
        goto L194
    L190:
        r11 = r40;
        goto L191
    L182:
        if (r10.getDefaultsInvalid() == true) goto L188;
        r10.skipToGroupEnd();
        if ((r57 & 512) == 0) goto L187;
        r1 = r1 & (-1879048193);
    L187:
        r210 = r40;
        r215 = r41;
        r216 = r42;
        r217 = r43;
        r113 = r44;
        r214 = r45;
        r114 = r46;
        r213 = r47;
        r211 = r48;
        r212 = r49;
        r34 = r50;
        r36 = r51;
        r37 = r52;
        r35 = r53;
        r58 = r1;
        goto L237
    L265:
        r218 = r10;
        r218.skipToGroupEnd();
        r67 = r40;
        r68 = r41;
        r69 = r42;
        r70 = r43;
        r73 = r44;
        r71 = r45;
        r72 = r46;
        r116 = r47;
        r117 = r48;
        r118 = r49;
        r119 = r50;
        r120 = r51;
        r121 = r52;
        r122 = r53;
        goto L266
    L173:
        if ((74899 & r5) != 74898) goto L176;
        r12 = false;
        goto L178
    L165:
        if ((r56 & 196608) != 0) goto L170;
        if (r10.changedInstance(r53) == false) goto L169;
        r24 = 131072;
    L169:
        r5 = r5 | r24;
        goto L170
    L154:
        if ((r56 & 24576) != 0) goto L161;
        if (r10.changed(r52) == true) goto L159;
        r20 = 8192;
    L159:
        r5 = r5 | r20;
        goto L161
    L143:
        if ((r56 & 3072) != 0) goto L150;
        if (r10.changed(r51) == true) goto L148;
        r17 = 1024;
    L148:
        r5 = r5 | r17;
        goto L150
    L132:
        if ((r56 & 384) != 0) goto L139;
        if (r10.changedInstance(r50) == false) goto L136;
        int r219 = 256;
    L137:
        r5 = r5 | r219;
        goto L139
    L136:
        r219 = 128;
        goto L137
    L122:
        if ((r56 & 48) != 0) goto L128;
        if (r10.changed(r49) == false) goto L126;
        int r220 = 32;
    L127:
        r33 = r33 | r220;
        goto L128
    L126:
        r220 = 16;
        goto L127
    L111:
        if ((r56 & 6) == 0) goto L113;
        r33 = r56;
        goto L118
    L113:
        if (r10.changed(r48) == false) goto L115;
        int r313 = 4;
    L116:
        r33 = r56 | r313;
        goto L118
    L115:
        r313 = 2;
        goto L116
    L90:
        if ((r55 & 100663296) != 0) goto L97;
        if (r10.changed(r46) == false) goto L94;
        int r314 = 67108864;
    L95:
        r1 = r1 | r314;
        goto L97
    L94:
        r314 = 33554432;
        goto L95
    L80:
        if ((r55 & 12582912) != 0) goto L86;
        if (r10.changed(r45) == false) goto L84;
        int r315 = 8388608;
    L85:
        r1 = r1 | r315;
        goto L86
    L84:
        r315 = 4194304;
        goto L85
    L70:
        if ((r55 & 1572864) != 0) goto L76;
        if (r10.changed(r44) == false) goto L74;
        int r221 = 1048576;
    L75:
        r1 = r1 | r221;
        goto L76
    L74:
        r221 = 524288;
        goto L75
    L60:
        if ((r55 & 196608) != 0) goto L66;
        if (r10.changed(r43) == false) goto L64;
        int r222 = 131072;
    L65:
        r1 = r1 | r222;
        goto L66
    L64:
        r222 = 65536;
        goto L65
    L49:
        if ((r55 & 24576) != 0) goto L56;
        if (r10.changed(r42) == false) goto L53;
        int r223 = 16384;
    L54:
        r1 = r1 | r223;
        goto L56
    L53:
        r223 = 8192;
        goto L54
    L38:
        if ((r55 & 3072) != 0) goto L45;
        if (r10.changed(r41) == false) goto L42;
        int r123 = 2048;
    L43:
        r1 = r1 | r123;
        goto L45
    L42:
        r123 = 1024;
        goto L43
    L27:
        if ((r55 & 384) != 0) goto L34;
        if (r10.changed(r40) == false) goto L31;
        int r124 = 256;
    L32:
        r1 = r1 | r124;
        goto L34
    L31:
        r124 = 128;
        goto L32
    L17:
        if ((r55 & 48) != 0) goto L23;
        if (r10.changedInstance(r39) == false) goto L21;
        int r75 = 32;
    L22:
        r1 = r1 | r75;
        goto L23
    L21:
        r75 = 16;
        goto L22
    L6:
        if ((r55 & 6) == 0) goto L8;
        r1 = r55;
        goto L14
    L8:
        if (r10.changed(r38) == false) goto L10;
        int r76 = 4;
    L11:
        r1 = r76 | r55;
        goto L14
    L10:
        r76 = 2;
        goto L11
    }

    public static final void BasicTextField(final TextFieldState r55, Modifier r56, boolean r57, boolean r58, InputTransformation r59, TextStyle r60, KeyboardOptions r61, KeyboardActionHandler r62, TextFieldLineLimits r63, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r64, MutableInteractionSource r65, Brush r66, CodepointTransformation r67, OutputTransformation r68, TextFieldDecorator r69, ScrollState r70, boolean r71, Composer r72, final int r73, final int r74, final int r75) {
        Composer r2 = r72.startRestartGroup(965149429);
        if ((r75 & 1) == 0) goto L6;
        int r3 = r73 | 6;
    L13:
        int r6 = r75 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r10 = r75 & 4;
        if (r10 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r16 = r75 & 8;
        int r17 = 1024;
        if (r16 == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        int r20 = r75 & 16;
        int r21 = 8192;
        if (r20 == 0) goto L50;
        r3 = r3 | 24576;
    L57:
        int r23 = r75 & 32;
        if (r23 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r27 = r75 & 64;
        if (r27 == 0) goto L71;
        r3 = r3 | 1572864;
    L77:
        int r5 = r75 & 128;
        if (r5 == 0) goto L81;
        r3 = r3 | 12582912;
    L87:
        int r4 = r75 & 256;
        if (r4 == 0) goto L91;
        r3 = r3 | 100663296;
    L97:
        int r7 = r75 & 512;
        if (r7 == 0) goto L101;
        r3 = r3 | 805306368;
    L107:
        int r8 = r75 & 1024;
        if (r8 == 0) goto L111;
        int r31 = r74 | 6;
    L118:
        int r9 = r75 & 2048;
        if (r9 == 0) goto L122;
        r31 = r31 | 48;
    L128:
        int r11 = r31;
        int r12 = r75 & 4096;
        if (r12 == 0) goto L132;
        r11 = r11 | 384;
    L139:
        int r1 = r75 & 8192;
        if (r1 == 0) goto L142;
        r11 = r11 | 3072;
        int r18 = r1;
    L149:
        int r13 = r75 & 16384;
        if (r13 == 0) goto L152;
        r11 = r11 | 24576;
        int r32 = r13;
    L162:
        if ((r74 & 196608) != 0) goto L172;
        if ((r75 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) != 0) goto L169;
        if (r2.changed(r70) == false) goto L169;
        int r22 = 131072;
    L170:
        r11 = r11 | r22;
    L169:
        r22 = 65536;
    L172:
        int r24 = r75 & 65536;
        if (r24 == 0) goto L176;
        r11 = r11 | 1572864;
    L183:
        if ((r3 & 306783379) == 306783378) goto L185;
    L188:
        boolean r0 = true;
    L190:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L390;
        r2.startDefaults();
        if ((r73 & 1) != 0) goto L194;
    L200:
        if (r6 == 0) goto L202;
        Modifier r14 = Modifier.Companion;
    L203:
        if (r10 == 0) goto L205;
        boolean r15 = true;
    L206:
        if (r16 == 0) goto L208;
        boolean r19 = false;
    L209:
        if (r20 == 0) goto L211;
        InputTransformation r110 = null;
    L212:
        if (r23 == 0) goto L214;
        TextStyle r25 = TextStyle.Companion.getDefault();
    L215:
        if (r27 == 0) goto L217;
        KeyboardOptions r26 = KeyboardOptions.Companion.getDefault();
    L218:
        if (r5 == 0) goto L220;
        KeyboardActionHandler r28 = null;
    L221:
        if (r4 == 0) goto L223;
        TextFieldLineLimits r29 = TextFieldLineLimits.Companion.getDefault();
    L224:
        if (r7 == 0) goto L226;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r30 = null;
    L227:
        if (r8 == 0) goto L229;
        MutableInteractionSource r33 = null;
    L230:
        if (r9 == 0) goto L232;
        Brush r34 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
    L233:
        if (r12 == 0) goto L235;
        CodepointTransformation r111 = null;
    L236:
        if (r18 == 0) goto L238;
        OutputTransformation r112 = null;
    L239:
        if (r32 == 0) goto L241;
        TextFieldDecorator r210 = null;
    L243:
        if ((r75 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L245;
        ScrollState r211 = ScrollKt.rememberScrollState(0, r2, 0, 1);
        r11 = r11 & (-458753);
    L246:
        int r113 = r11;
        InputTransformation r35 = r110;
        OutputTransformation r50 = r112;
        if (r24 == 0) goto L249;
        boolean r114 = false;
    L250:
        Brush r115 = r34;
        MutableInteractionSource r36 = r33;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r37 = r30;
        TextFieldLineLimits r38 = r29;
        KeyboardOptions r39 = r26;
    L251:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L254;
        ComposerKt.traceEventStart(965149429, r3, r113, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:251)");
    L254:
        final Density r116 = (Density) r2.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection r117 = (LayoutDirection) r2.consume(CompositionLocalsKt.getLocalLayoutDirection());
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r610 = r37;
        final boolean r47 = Intrinsics.areEqual(r38, TextFieldLineLimits.SingleLine.INSTANCE);
        if (r36 != null) goto L260;
        r2.startReplaceGroup(-2038064986);
        Object r40 = r2.rememberedValue();
        MutableInteractionSource r76 = r36;
        if (r40 != Composer.Companion.getEmpty()) goto L259;
        r40 = InteractionSourceKt.MutableInteractionSource();
        r2.updateRememberedValue(r40);
    L259:
        MutableInteractionSource r41 = (MutableInteractionSource) r40;
        r2.endReplaceGroup();
    L261:
        if (r47 == false) goto L263;
        Orientation r42 = Orientation.Horizontal;
    L264:
        final Brush r77 = r115;
        boolean r212 = ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r41, r2, 0).getValue()).booleanValue();
        final boolean r310 = ((Boolean) HoverInteractionKt.collectIsHoveredAsState(r41, r2, 0).getValue()).booleanValue();
        if (r212 == false) goto L267;
        r2.startReplaceGroup(-204274364);
        boolean r118 = ((WindowInfo) r2.consume(CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused();
        r2.endReplaceGroup();
        final boolean r311 = r118;
    L268:
        Object r119 = r2.rememberedValue();
        Composer.Companion r213 = Composer.Companion;
        final TextFieldLineLimits r214 = r38;
        if (r119 != r213.getEmpty()) goto L272;
        MutableSharedFlow r43 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, null);
        r2.updateRememberedValue(r43);
        r119 = r43;
    L272:
        final MutableSharedFlow r44 = (MutableSharedFlow) r119;
        if ((r3 & 14) != 4) goto L275;
        boolean r45 = true;
    L277:
        if ((r113 & 896) != 256) goto L279;
        boolean r46 = true;
    L280:
        boolean r48 = r45 | r46;
        if ((r113 & 7168) != 2048) goto L283;
        boolean r49 = true;
    L284:
        boolean r51 = r48 | r49;
        Object r52 = r2.rememberedValue();
        if (r51 == false) goto L287;
    L290:
        if (r111 != null) goto L295;
        CodepointTransformation r53 = SingleLineCodepointTransformation.INSTANCE;
        if (r47 == true) goto L296;
        r53 = null;
    L296:
        OutputTransformation r120 = r50;
        TransformedTextFieldState r54 = new TransformedTextFieldState(r55, r35, r53, r120);
        r2.updateRememberedValue(r54);
        r52 = r54;
    L297:
        final TransformedTextFieldState r78 = (TransformedTextFieldState) r52;
        boolean r79 = r2.changed(r78);
        Object r121 = r2.rememberedValue();
        if (r79 == false) goto L300;
    L301:
        r121 = new TextLayoutState();
        r2.updateRememberedValue(r121);
    L302:
        final TextLayoutState r312 = (TextLayoutState) r121;
        if (r35 == null) goto L305;
        KeyboardOptions r80 = r35.getKeyboardOptions();
    L306:
        final KeyboardOptions r410 = r39.fillUnspecifiedValuesWith$foundation_release(r80);
        Object r81 = r2.rememberedValue();
        if (r81 != r213.getEmpty()) goto L309;
        r81 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r2);
        r2.updateRememberedValue(r81);
    L309:
        CoroutineScope r82 = (CoroutineScope) r81;
        if (ComposeFoundationFlags.isSmartSelectionEnabled == false) goto L315;
        r2.startReplaceGroup(-2035764848);
        LocaleList r122 = r25.getLocaleList();
        if (r122 != null) goto L314;
        r122 = LocaleList.Companion.getCurrent();
    L314:
        PlatformSelectionBehaviors r123 = PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, r122, r2, 6);
        r2.endReplaceGroup();
        final PlatformSelectionBehaviors r411 = r123;
    L316:
        Object r124 = r2.rememberedValue();
        if (r124 != r213.getEmpty()) goto L319;
        r124 = new ToolbarRequesterImpl();
        r2.updateRememberedValue(r124);
    L319:
        final ToolbarRequesterImpl r412 = (ToolbarRequesterImpl) r124;
        final Clipboard r125 = (Clipboard) r2.consume(CompositionLocalsKt.getLocalClipboard());
        boolean r126 = r2.changed(r78);
        Object r127 = r2.rememberedValue();
        if (r126 == false) goto L322;
    L323:
        r127 = new TextFieldSelectionState(r78, r312, r116, r15, r19, r311, r114, r412, r82, r411, r125);
        r2.updateRememberedValue(r127);
    L324:
        final TextFieldSelectionState r128 = (TextFieldSelectionState) r127;
        final HapticFeedback r129 = (HapticFeedback) r2.consume(CompositionLocalsKt.getLocalHapticFeedback());
        KeyboardActionHandler r510 = r28;
        TextToolbar r83 = (TextToolbar) r2.consume(CompositionLocalsKt.getLocalTextToolbar());
        boolean r313 = r2.changed(r82) | r2.changed(r83);
        Modifier r511 = r14;
        Object r84 = r2.rememberedValue();
        if (r313 == false) goto L327;
    L328:
        r84 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(r83, r82);
        r2.updateRememberedValue(r84);
    L329:
        final BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 r85 = (BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1) r84;
        boolean r86 = r2.changed(r78);
        if ((57344 & r3) != 16384) goto L332;
        boolean r87 = true;
    L333:
        boolean r88 = (((((r86 | r87) | r2.changedInstance(r128)) | r2.changedInstance(r129)) | r2.changedInstance(r125)) | r2.changed(r85)) | r2.changed(r116);
        if ((r3 & 896) != 256) goto L336;
        boolean r89 = true;
    L337:
        boolean r90 = r88 | r89;
        if ((r3 & 7168) != 2048) goto L340;
        boolean r91 = true;
    L341:
        boolean r92 = r90 | r91;
        if ((3670016 & r113) != 1048576) goto L344;
        boolean r93 = true;
    L345:
        boolean r94 = r92 | r93;
        Object r95 = r2.rememberedValue();
        if (r94 == false) goto L348;
    L349:
        final InputTransformation r512 = r35;
        final boolean r611 = r15;
        final boolean r612 = r19;
        final boolean r613 = r114;
        r95 = new u(r78, r512, r128, r129, r125, r85, r116, r611, r612, r613);
        r2.updateRememberedValue(r95);
    L350:
        EffectsKt.SideEffect((Function0) r95, r2, 0);
        boolean r96 = r2.changedInstance(r128);
        Object r97 = r2.rememberedValue();
        if (r96 == false) goto L353;
    L354:
        r97 = new v(r128);
        r2.updateRememberedValue(r97);
    L355:
        EffectsKt.DisposableEffect(r128, (Function1) r97, r2, 0);
        if (r114 == true) goto L362;
        int r98 = r39.m1387getKeyboardTypePjHm6EE();
        KeyboardType.Companion r99 = KeyboardType.Companion;
        if (KeyboardType.equals-impl0(r98, r99.getPassword-PjHm6EE()) == true) goto L362;
        if (KeyboardType.equals-impl0(r39.m1387getKeyboardTypePjHm6EE(), r99.getNumberPassword-PjHm6EE()) == true) goto L362;
        final boolean r100 = true;
    L363:
        boolean r101 = r2.changed(r100) | r2.changedInstance(r44);
        Object r102 = r2.rememberedValue();
        if (r101 == false) goto L366;
    L367:
        r102 = new w(r100, r44);
        r2.updateRememberedValue(r102);
    L368:
        Modifier r103 = r511;
        Modifier r104 = StylusHandwritingKt.stylusHandwriting(r103, r15, r100, (Function0) r102).then(new TextFieldDecoratorModifier(r78, r312, r128, r35, r15, r19, r410, r510, r47, r41, r114, r44));
        if (r15 == true) goto L371;
    L373:
        boolean r105 = false;
    L374:
        final Orientation r130 = r42;
        ScrollState r513 = r211;
        boolean r514 = r105;
        Modifier r106 = addContextMenuComponents(PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(r104, r513, r130, r514, ScrollableDefaults.INSTANCE.reverseDirection(r117, r130, false), null, r41, 16, null), PointerIcon.Companion.getText(), false, 2, null), r128, r82);
        MeasurePolicy r107 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
        long r131 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r108 = (int) (r131 ^ (r131 >>> 32));
        CompositionLocalMap r132 = r2.getCurrentCompositionLocalMap();
        Modifier r109 = ComposedModifierKt.materializeModifier(r2, r106);
        ComposeUiNode.Companion r133 = ComposeUiNode.Companion;
        Function0 r134 = r133.getConstructor();
        InputTransformation r135 = r35;
        if ((r2.getApplier() instanceof Applier) == true) goto L377;
        ComposablesKt.invalidApplier();
    L377:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L380;
        r2.createNode(r134);
    L381:
        Composer r136 = Updater.constructor-impl(r2);
        Updater.set-impl(r136, r107, r133.getSetMeasurePolicy());
        Updater.set-impl(r136, r132, r133.getSetResolvedCompositionLocals());
        Function2 r137 = r133.getSetCompositeKeyHash();
        if (r136.getInserting() == false) goto L384;
    L385:
        r136.updateRememberedValue(Integer.valueOf(r108));
        r136.apply(Integer.valueOf(r108), r137);
    L386:
        Updater.set-impl(r136, r109, r133.getSetModifier());
        BoxScopeInstance r138 = BoxScopeInstance.INSTANCE;
        final TextFieldDecorator r314 = r210;
        final TextStyle r315 = r25;
        final boolean r413 = r15;
        final boolean r414 = r19;
        final ScrollState r415 = r211;
        ContextMenu_androidKt.ContextMenuArea(r128, r15, ComposableLambdaKt.rememberComposableLambda(-673241599, true, new BasicTextFieldKt$BasicTextField$4$1(r314, r214, r312, r315, r311, r310, r78, r128, r77, r413, r414, r415, r130, r412, r411, r47, r610, r410), r2, 54), r2, ((r3 >> 3) & 112) | 384);
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L389;
        ComposerKt.traceEventEnd();
    L389:
        final MutableInteractionSource r139 = r76;
        final Brush r140 = r77;
        final KeyboardOptions r141 = r39;
        final boolean r142 = r15;
        final boolean r143 = r19;
        boolean r144 = r114;
        final TextStyle r145 = r25;
        final TextFieldLineLimits r146 = r214;
        final TextFieldDecorator r147 = r210;
        final ScrollState r148 = r211;
        final CodepointTransformation r149 = r111;
        final OutputTransformation r150 = r120;
        final KeyboardActionHandler r151 = r510;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r152 = r610;
    L391:
        ScopeUpdateScope r153 = r2.endRestartGroup();
        if (r153 == null) goto L395;
        final Modifier r154 = r103;
        final InputTransformation r155 = r135;
        final boolean r156 = r144;
        r153.updateScope(new x(r55, r154, r142, r143, r155, r145, r141, r151, r146, r152, r139, r140, r149, r150, r147, r148, r156, r73, r74, r75));
        return;
    L395:
        return;
    L384:
        if (Intrinsics.areEqual(r136.rememberedValue(), Integer.valueOf(r108)) == true) goto L386;
    L380:
        r2.useNode();
        goto L381
    L371:
        if (r128.getDirectDragGestureInitiator() != TextFieldSelectionState.InputType.None) goto L373;
        r105 = true;
        goto L374
    L366:
        if (r102 != r213.getEmpty()) goto L368;
    L362:
        r100 = false;
        goto L363
    L353:
        if (r97 != r213.getEmpty()) goto L355;
    L348:
        if (r95 != r213.getEmpty()) goto L350;
    L344:
        r93 = false;
        goto L345
    L340:
        r91 = false;
        goto L341
    L336:
        r89 = false;
        goto L337
    L332:
        r87 = false;
        goto L333
    L327:
        if (r84 != r213.getEmpty()) goto L329;
    L322:
        if (r127 != r213.getEmpty()) goto L324;
    L315:
        r2.startReplaceGroup(-2035576399);
        r2.endReplaceGroup();
        r411 = null;
        goto L316
    L305:
        r80 = null;
        goto L306
    L300:
        if (r121 != r213.getEmpty()) goto L302;
    L295:
        r53 = r111;
        goto L296
    L287:
        if (r52 == r213.getEmpty()) goto L290;
        r120 = r50;
        goto L297
    L283:
        r49 = false;
        goto L284
    L279:
        r46 = false;
        goto L280
    L275:
        r45 = false;
        goto L277
    L267:
        r2.startReplaceGroup(-2037536751);
        r2.endReplaceGroup();
        r311 = false;
        goto L268
    L263:
        r42 = Orientation.Vertical;
        goto L264
    L260:
        r76 = r36;
        r2.startReplaceGroup(-204292015);
        r2.endReplaceGroup();
        r41 = r76;
        goto L261
    L249:
        r114 = r71;
        goto L250
    L245:
        r211 = r70;
        goto L246
    L241:
        r210 = r69;
        goto L243
    L238:
        r112 = r68;
        goto L239
    L235:
        r111 = r67;
        goto L236
    L232:
        r34 = r66;
        goto L233
    L229:
        r33 = r65;
        goto L230
    L226:
        r30 = r64;
        goto L227
    L223:
        r29 = r63;
        goto L224
    L220:
        r28 = r62;
        goto L221
    L217:
        r26 = r61;
        goto L218
    L214:
        r25 = r60;
        goto L215
    L211:
        r110 = r59;
        goto L212
    L208:
        r19 = r58;
        goto L209
    L205:
        r15 = r57;
        goto L206
    L202:
        r14 = r56;
        goto L203
    L194:
        if (r2.getDefaultsInvalid() == true) goto L200;
        r2.skipToGroupEnd();
        if ((r75 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L199;
        r11 = r11 & (-458753);
    L199:
        r14 = r56;
        r15 = r57;
        r19 = r58;
        r35 = r59;
        r25 = r60;
        r39 = r61;
        r28 = r62;
        r38 = r63;
        r37 = r64;
        r36 = r65;
        r111 = r67;
        r50 = r68;
        r210 = r69;
        r211 = r70;
        r114 = r71;
        r113 = r11;
        r115 = r66;
        goto L251
    L390:
        r2.skipToGroupEnd();
        r103 = r56;
        r142 = r57;
        r143 = r58;
        r135 = r59;
        r145 = r60;
        r141 = r61;
        r151 = r62;
        r146 = r63;
        r152 = r64;
        r139 = r65;
        r140 = r66;
        r149 = r67;
        r150 = r68;
        r147 = r69;
        r148 = r70;
        r144 = r71;
        goto L391
    L185:
        if ((599187 & r11) != 599186) goto L188;
        r0 = false;
        goto L190
    L176:
        if ((r74 & 1572864) != 0) goto L183;
        if (r2.changed(r71) == false) goto L180;
        int r215 = 1048576;
    L181:
        r11 = r11 | r215;
        goto L183
    L180:
        r215 = 524288;
        goto L181
    L152:
        r32 = r13;
        if ((r74 & 24576) != 0) goto L162;
        if ((r74 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) != 0) goto L157;
        boolean r157 = r2.changed(r69);
    L158:
        if (r157 == false) goto L160;
        r21 = 16384;
    L160:
        r11 = r11 | r21;
        goto L162
    L157:
        r157 = r2.changedInstance(r69);
        goto L158
    L142:
        r18 = r1;
        if ((r74 & 3072) != 0) goto L149;
        if (r2.changed(r68) == false) goto L147;
        r17 = 2048;
    L147:
        r11 = r11 | r17;
        goto L149
    L132:
        if ((r74 & 384) != 0) goto L139;
        if (r2.changed(r67) == false) goto L136;
        int r158 = 256;
    L137:
        r11 = r11 | r158;
        goto L139
    L136:
        r158 = 128;
        goto L137
    L122:
        if ((r74 & 48) != 0) goto L128;
        if (r2.changed(r66) == false) goto L126;
        int r316 = 32;
    L127:
        r31 = r31 | r316;
        goto L128
    L126:
        r316 = 16;
        goto L127
    L111:
        if ((r74 & 6) == 0) goto L113;
        r31 = r74;
        goto L118
    L113:
        if (r2.changed(r65) == false) goto L115;
        int r317 = 4;
    L116:
        r31 = r74 | r317;
        goto L118
    L115:
        r317 = 2;
        goto L116
    L101:
        if ((r73 & 805306368) != 0) goto L107;
        if (r2.changedInstance(r64) == false) goto L105;
        int r318 = 536870912;
    L106:
        r3 = r3 | r318;
        goto L107
    L105:
        r318 = 268435456;
        goto L106
    L91:
        if ((r73 & 100663296) != 0) goto L97;
        if (r2.changed(r63) == false) goto L95;
        int r319 = 67108864;
    L96:
        r3 = r3 | r319;
        goto L97
    L95:
        r319 = 33554432;
        goto L96
    L81:
        if ((r73 & 12582912) != 0) goto L87;
        if (r2.changed(r62) == false) goto L85;
        int r320 = 8388608;
    L86:
        r3 = r3 | r320;
        goto L87
    L85:
        r320 = 4194304;
        goto L86
    L71:
        if ((r73 & 1572864) != 0) goto L77;
        if (r2.changed(r61) == false) goto L75;
        int r321 = 1048576;
    L76:
        r3 = r3 | r321;
        goto L77
    L75:
        r321 = 524288;
        goto L76
    L61:
        if ((r73 & 196608) != 0) goto L67;
        if (r2.changed(r60) == false) goto L65;
        int r216 = 131072;
    L66:
        r3 = r3 | r216;
        goto L67
    L65:
        r216 = 65536;
        goto L66
    L50:
        if ((r73 & 24576) != 0) goto L57;
        if (r2.changed(r59) == false) goto L54;
        int r217 = 16384;
    L55:
        r3 = r3 | r217;
        goto L57
    L54:
        r217 = 8192;
        goto L55
    L39:
        if ((r73 & 3072) != 0) goto L46;
        if (r2.changed(r58) == false) goto L43;
        int r218 = 2048;
    L44:
        r3 = r3 | r218;
        goto L46
    L43:
        r218 = 1024;
        goto L44
    L28:
        if ((r73 & 384) != 0) goto L35;
        if (r2.changed(r57) == false) goto L32;
        int r159 = 256;
    L33:
        r3 = r3 | r159;
        goto L35
    L32:
        r159 = 128;
        goto L33
    L17:
        if ((r73 & 48) != 0) goto L24;
        if (r2.changed(r56) == false) goto L21;
        int r160 = 32;
    L22:
        r3 = r3 | r160;
        goto L24
    L21:
        r160 = 16;
        goto L22
    L6:
        if ((r73 & 6) == 0) goto L8;
        r3 = r73;
        goto L13
    L8:
        if (r2.changed(r55) == false) goto L10;
        int r161 = 4;
    L11:
        r3 = r161 | r73;
        goto L13
    L10:
        r161 = 2;
        goto L11
    }
}
