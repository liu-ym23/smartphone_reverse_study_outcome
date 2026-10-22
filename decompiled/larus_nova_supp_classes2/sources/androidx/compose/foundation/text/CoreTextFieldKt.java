package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifier;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aú\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00020(H\u0002\u001a \u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0013H\u0000\u001a0\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002\u001a2\u00108\u001a\u00020\u0001*\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0080@¢\u0006\u0002\u0010=\u001a\u001d\u0010>\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010@\u001a\u0015\u0010A\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\u0010B\u001a \u0010C\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0002\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00072\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020GH\u0002¨\u0006H²\u0006\n\u0010I\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "textScrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/text/TextFieldScrollerPosition;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "previewKeyEventToDeselectOnBack", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "endInputSession", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "addContextMenuComponents", "textFieldSelectionManager", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release", "writeable"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CoreTextFieldKt {
    private static final Unit CoreTextField$lambda$41(TextFieldValue r21, Function1 r22, Modifier r23, TextStyle r24, VisualTransformation r25, Function1 r26, MutableInteractionSource r27, Brush r28, boolean r29, int r30, int r31, ImeOptions r32, KeyboardActions r33, boolean r34, boolean r35, Function3 r36, TextFieldScrollerPosition r37, int r38, int r39, int r40, Composer r41, int r42) {
        CoreTextField(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r41, RecomposeScopeImplKt.updateChangedFlags(r38 | 1), RecomposeScopeImplKt.updateChangedFlags(r39), r40);
        return Unit.INSTANCE;
    }

    private static final Unit CoreTextFieldRootBox$lambda$43(Modifier r0, TextFieldSelectionManager r1, Function2 r2, int r3, Composer r4, int r5) {
        CoreTextFieldRootBox(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SelectionToolbarAndHandles$lambda$49(TextFieldSelectionManager r0, boolean r1, int r2, Composer r3, int r4) {
        SelectionToolbarAndHandles(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TextFieldCursorHandle$lambda$55(TextFieldSelectionManager r0, int r1, Composer r2, int r3) {
        TextFieldCursorHandle(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(long r0, SemanticsPropertyReceiver r2) {
        return TextFieldCursorHandle$lambda$54$lambda$53(r0, r2);
    }

    public static /* synthetic */ Unit b(TextFieldSelectionManager r0, int r1, Composer r2, int r3) {
        return TextFieldCursorHandle$lambda$55(r0, r1, r2, r3);
    }

    public static /* synthetic */ DisposableEffectResult c(LegacyTextFieldState r0, TextInputService r1, TextFieldValue r2, ImeOptions r3, DisposableEffectScope r4) {
        return CoreTextField$lambda$36$lambda$35(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit d(LegacyTextFieldState r0, long r1, DrawScope r3) {
        return CoreTextField$lambda$40$lambda$39(r0, r1, r3);
    }

    public static /* synthetic */ Unit e(LegacyTextFieldState r0, boolean r1) {
        return CoreTextField$lambda$19$lambda$18(r0, r1);
    }

    public static /* synthetic */ Unit f(Modifier r0, TextFieldSelectionManager r1, Function2 r2, int r3, Composer r4, int r5) {
        return CoreTextFieldRootBox$lambda$43(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit g(LegacyTextFieldState r0, FocusRequester r1, boolean r2, boolean r3, TextFieldSelectionManager r4, OffsetMapping r5, Offset r6) {
        return CoreTextField$lambda$22$lambda$21(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit h(LegacyTextFieldState r0, TextFieldValue r1, OffsetMapping r2, DrawScope r3) {
        return CoreTextField$lambda$26$lambda$25(r0, r1, r2, r3);
    }

    public static /* synthetic */ DisposableEffectResult i(TextFieldSelectionManager r0, DisposableEffectScope r1) {
        return CoreTextField$lambda$33$lambda$32(r0, r1);
    }

    public static /* synthetic */ TextFieldScrollerPosition j(Orientation r0) {
        return CoreTextField$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit k(TextFieldValue r1, Function1 r2, Modifier r3, TextStyle r4, VisualTransformation r5, Function1 r6, MutableInteractionSource r7, Brush r8, boolean r9, int r10, int r11, ImeOptions r12, KeyboardActions r13, boolean r14, boolean r15, Function3 r16, TextFieldScrollerPosition r17, int r18, int r19, int r20, Composer r21, int r22) {
        return CoreTextField$lambda$41(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public static /* synthetic */ Unit l(TextFieldSelectionManager r0, boolean r1, int r2, Composer r3, int r4) {
        return SelectionToolbarAndHandles$lambda$49(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit m(boolean r0, LegacyPlatformTextInputServiceAdapter r1) {
        return CoreTextField$lambda$38$lambda$37(r0, r1);
    }

    public static /* synthetic */ Unit n(TextLayoutResult r0) {
        return CoreTextField$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ Unit o(LegacyTextFieldState r0, boolean r1, boolean r2, TextInputService r3, TextFieldValue r4, ImeOptions r5, OffsetMapping r6, TextFieldSelectionManager r7, CoroutineScope r8, BringIntoViewRequester r9, FocusState r10) {
        return CoreTextField$lambda$15$lambda$14(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit p(LegacyTextFieldState r0, boolean r1, WindowInfo r2, TextFieldSelectionManager r3, TextFieldValue r4, OffsetMapping r5, LayoutCoordinates r6) {
        return CoreTextField$lambda$30$lambda$29(r0, r1, r2, r3, r4, r5, r6);
    }

    private static final Unit CoreTextField$lambda$1$lambda$0(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final boolean CoreTextField$lambda$16(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final TextFieldScrollerPosition CoreTextField$lambda$6$lambda$5(Orientation r4) {
        return new TextFieldScrollerPosition(r4, MenuKt.ClosedAlphaTarget, 2, null);
    }

    public static final /* synthetic */ boolean access$CoreTextField$lambda$16(State r0) {
        return CoreTextField$lambda$16(r0);
    }

    public static final /* synthetic */ void access$endInputSession(LegacyTextFieldState r0) {
        endInputSession(r0);
    }

    private static final void endInputSession(LegacyTextFieldState r4) {
        TextInputSession r0 = r4.getInputSession();
        if (r0 == null) goto L5;
        TextFieldDelegate.Companion.onBlur$foundation_release(r0, r4.getProcessor(), r4.getOnValueChange());
    L5:
        r4.setInputSession(null);
    }

    private static final Unit CoreTextField$lambda$19$lambda$18(LegacyTextFieldState r0, boolean r1) {
        r0.setInTouchMode(r1);
        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult CoreTextField$lambda$33$lambda$32(final TextFieldSelectionManager r0, DisposableEffectScope r1) {
        return new CoreTextFieldKt$CoreTextField$lambda$33$lambda$32$$inlined$onDispose$1(r0);
    }

    private static final Unit CoreTextField$lambda$38$lambda$37(boolean r0, LegacyPlatformTextInputServiceAdapter r1) {
        if (r0 == false) goto L5;
        r1.startStylusHandwriting();
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit TextFieldCursorHandle$lambda$54$lambda$53(long r9, SemanticsPropertyReceiver r11) {
        r11.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, r9, SelectionHandleAnchor.Middle, true, null));
        return Unit.INSTANCE;
    }

    private static final Unit CoreTextField$lambda$40$lambda$39(LegacyTextFieldState r14, long r15, DrawScope r17) {
        if (r14.getAutofillHighlightOn() == false) goto L5;
    L6:
        DrawScope.-CC.drawRect-n-J9OG0$default(r17, r15, 0, 0, MenuKt.ClosedAlphaTarget, null, null, 0, 126, null);
    L8:
        return Unit.INSTANCE;
    L5:
        if (r14.getJustAutofilled() == false) goto L8;
        goto L6
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager r9, Composer r10, final int r11) {
        Composer r12 = r10.startRestartGroup(-1436003720);
        if ((r11 & 6) == 0) goto L5;
        int r1 = r11;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r12.shouldExecute(r2, r1 & 1) == true) goto L17;
        r12.skipToGroupEnd();
    L62:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L66;
        r13.updateScope(new e2(r9, r11));
        return;
    L66:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1436003720, r1, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1081)");
    L19:
        LegacyTextFieldState r0 = r9.getState$foundation_release();
        if (r0 != null) goto L22;
    L24:
        boolean r3 = false;
    L25:
        if (r3 == false) goto L57;
        AnnotatedString r4 = r9.getTransformedText$foundation_release();
        if (r4 != null) goto L29;
    L34:
        boolean r5 = false;
    L35:
        if (r5 == false) goto L57;
        r12.startReplaceGroup(-2112330600);
        boolean r6 = r12.changed(r9);
        Object r7 = r12.rememberedValue();
        if (r6 == false) goto L39;
    L40:
        r7 = r9.cursorDragObserver$foundation_release();
        r12.updateRememberedValue(r7);
    L41:
        final TextDragObserver r8 = (TextDragObserver) r7;
        final long r14 = r9.m1902getCursorPositiontuRUvjQ$foundation_release((Density) r12.consume(CompositionLocalsKt.getLocalDensity()));
        boolean r15 = r12.changed(r14);
        Object r16 = r12.rememberedValue();
        if (r15 == false) goto L44;
    L45:
        r16 = new CoreTextFieldKt$TextFieldCursorHandle$1$1(r14);
        r12.updateRememberedValue(r16);
    L46:
        OffsetProvider r17 = (OffsetProvider) r16;
        Modifier.Companion r18 = Modifier.Companion;
        boolean r19 = r12.changedInstance(r8) | r12.changedInstance(r9);
        Object r20 = r12.rememberedValue();
        if (r19 == false) goto L49;
    L50:
        r20 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(r8, r9);
        r12.updateRememberedValue(r20);
    L51:
        Modifier r21 = SuspendingPointerInputFilterKt.pointerInput(r18, r8, (PointerInputEventHandler) r20);
        boolean r22 = r12.changed(r14);
        Object r23 = r12.rememberedValue();
        if (r22 == false) goto L54;
    L55:
        r23 = new d2(r14);
        r12.updateRememberedValue(r23);
    L56:
        AndroidCursorHandle_androidKt.m1337CursorHandleUSBMPiE(r17, SemanticsModifierKt.semantics$default(r21, false, (Function1) r23, 1, null), 0, r12, 0, 4);
        r12.endReplaceGroup();
    L59:
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
        goto L62
    L54:
        if (r23 != Composer.Companion.getEmpty()) goto L56;
    L49:
        if (r20 != Composer.Companion.getEmpty()) goto L51;
    L44:
        if (r16 != Composer.Companion.getEmpty()) goto L46;
    L39:
        if (r7 != Composer.Companion.getEmpty()) goto L41;
    L29:
        if (r4.length() <= 0) goto L31;
        boolean r24 = true;
    L32:
        if (r24 != true) goto L34;
        r5 = true;
        goto L35
    L31:
        r24 = false;
    L57:
        r12.startReplaceGroup(-2111021718);
        r12.endReplaceGroup();
        goto L59
    L22:
        if (r0.getShowCursorHandle() != true) goto L24;
        r3 = true;
        goto L25
    L13:
        r2 = false;
        goto L15
    L5:
        if (r12.changedInstance(r9) == false) goto L7;
        int r25 = 4;
    L8:
        r1 = r25 | r11;
        goto L11
    L7:
        r25 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$notifyFocusedRect(LegacyTextFieldState r0, TextFieldValue r1, OffsetMapping r2) {
        notifyFocusedRect(r0, r1, r2);
    }

    private static final Modifier addContextMenuComponents(Modifier r1, TextFieldSelectionManager r2, CoroutineScope r3) {
        if (ComposeFoundationFlags.isNewContextMenuEnabled == true) goto L5;
        return r1;
    L5:
        return TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents(r1, r2, r3);
    }

    private static final void notifyFocusedRect(LegacyTextFieldState r13, TextFieldValue r14, OffsetMapping r15) {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
        TextLayoutResultProxy r4 = r13.getLayoutResult();     // Catch: Throwable -> L22
        if (r4 != null) goto L11;
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L11:
        TextInputSession r10 = r13.getInputSession();     // Catch: Throwable -> L22
        if (r10 != null) goto L15;
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L15:
        LayoutCoordinates r9 = r13.getLayoutCoordinates();     // Catch: Throwable -> L22
        if (r9 != null) goto L19;
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L19:
        TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(r14, r13.getTextDelegate(), r4.getValue(), r9, r10, r13.getHasFocus(), r15);     // Catch: Throwable -> L22
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L22:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L5:
        r2 = null;
        goto L6
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier r1, final LegacyTextFieldState r2, final TextFieldSelectionManager r3) {
        return KeyInputModifierKt.onPreviewKeyEvent(r1, new AnonymousClass1(r2, r3));
    }

    public static final void tapToFocus(LegacyTextFieldState r1, FocusRequester r2, boolean r3) {
        if (r1.getHasFocus() == true) goto L5;
        FocusRequester.requestFocus-3ESFkO8$default(r2, 0, 1, null);
        return;
    L5:
        if (r3 == false) goto L11;
        SoftwareKeyboardController r4 = r1.getKeyboardController();
        if (r4 == null) goto L12;
        r4.show();
        return;
    L12:
        return;
    }

    private static final Unit CoreTextField$lambda$26$lambda$25(LegacyTextFieldState r14, TextFieldValue r15, OffsetMapping r16, DrawScope r17) {
        TextLayoutResultProxy r0 = r14.getLayoutResult();
        if (r0 == null) goto L6;
        Canvas r3 = r17.getDrawContext().getCanvas();
        TextFieldDelegate.Companion.m1458drawQ1vqE60$foundation_release(r3, r15, r14.m1391getSelectionPreviewHighlightRanged9O1mEE(), r14.m1388getDeletionPreviewHighlightRanged9O1mEE(), r16, r0.getValue(), r14.getHighlightPaint(), r14.m1390getSelectionBackgroundColor0d7_KjU());
    L6:
        return Unit.INSTANCE;
    }

    private static final void SelectionToolbarAndHandles(final TextFieldSelectionManager r8, final boolean r9, Composer r10, final int r11) {
        Composer r12 = r10.startRestartGroup(626339208);
        if ((r11 & 6) == 0) goto L5;
        int r1 = r11;
    L11:
        if ((r11 & 48) == 0) goto L13;
    L17:
        boolean r5 = true;
        if ((r1 & 19) == 18) goto L20;
        boolean r2 = true;
    L22:
        if (r12.shouldExecute(r2, r1 & 1) == true) goto L24;
        r12.skipToGroupEnd();
    L83:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L87;
        r13.updateScope(new f2(r8, r9, r11));
        return;
    L87:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(626339208, r1, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1034)");
    L26:
        if (r9 == false) goto L78;
        r12.startReplaceGroup(1529773841);
        LegacyTextFieldState r0 = r8.getState$foundation_release();
        TextLayoutResult r3 = null;
        if (r0 == null) goto L40;
        TextLayoutResultProxy r4 = r0.getLayoutResult();
        if (r4 == null) goto L40;
        TextLayoutResult r6 = r4.getValue();
        if (r6 == null) goto L40;
        LegacyTextFieldState r7 = r8.getState$foundation_release();
        if (r7 == null) goto L36;
        boolean r14 = r7.isLayoutResultStale();
    L38:
        if ((!r14) == false) goto L40;
        r3 = r6;
        goto L40
    L36:
        r14 = true;
    L40:
        if (r3 != null) goto L43;
        r12.startReplaceGroup(1530097387);
    L42:
        r12.endReplaceGroup();
        r12.endReplaceGroup();
    L80:
        if (ComposerKt.isTraceInProgress() == false) goto L83;
        ComposerKt.traceEventEnd();
        goto L83
    L43:
        r12.startReplaceGroup(1530097388);
        if (TextRange.getCollapsed-impl(r8.getValue$foundation_release().getSelection-d9O1mEE()) == true) goto L64;
        r12.startReplaceGroup(2109807302);
        int r15 = r8.getOffsetMapping$foundation_release().originalToTransformed(TextRange.getStart-impl(r8.getValue$foundation_release().getSelection-d9O1mEE()));
        int r16 = r8.getOffsetMapping$foundation_release().originalToTransformed(TextRange.getEnd-impl(r8.getValue$foundation_release().getSelection-d9O1mEE()));
        ResolvedTextDirection r17 = r3.getBidiRunDirection(r15);
        ResolvedTextDirection r18 = r3.getBidiRunDirection(Math.max(r16 - 1, 0));
        LegacyTextFieldState r19 = r8.getState$foundation_release();
        if (r19 != null) goto L48;
    L50:
        boolean r20 = false;
    L51:
        if (r20 == false) goto L53;
        r12.startReplaceGroup(2110225306);
        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, r17, r8, r12, ((r1 << 6) & 896) | 6);
        r12.endReplaceGroup();
    L54:
        LegacyTextFieldState r21 = r8.getState$foundation_release();
        if (r21 != null) goto L57;
    L59:
        r5 = false;
    L60:
        if (r5 == false) goto L62;
        r12.startReplaceGroup(2110574459);
        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, r18, r8, r12, ((r1 << 6) & 896) | 6);
        r12.endReplaceGroup();
    L63:
        r12.endReplaceGroup();
    L65:
        LegacyTextFieldState r22 = r8.getState$foundation_release();
        if (r22 == null) goto L42;
        if (r8.isTextChanged$foundation_release() == false) goto L71;
        r22.setShowFloatingToolbar(false);
    L71:
        if (r22.getHasFocus() == true) goto L73;
    L76:
        Unit r23 = Unit.INSTANCE;
        goto L42
    L73:
        if (r22.getShowFloatingToolbar() == false) goto L75;
        r8.showSelectionToolbar$foundation_release();
        goto L76
    L75:
        r8.hideSelectionToolbar$foundation_release();
        goto L76
    L62:
        r12.startReplaceGroup(2110838734);
        r12.endReplaceGroup();
        goto L63
    L57:
        if (r21.getShowSelectionHandleEnd() != true) goto L59;
    L53:
        r12.startReplaceGroup(2110490542);
        r12.endReplaceGroup();
        goto L54
    L48:
        if (r19.getShowSelectionHandleStart() != true) goto L50;
        r20 = true;
        goto L51
    L64:
        r12.startReplaceGroup(2110860558);
        r12.endReplaceGroup();
        goto L65
    L78:
        r12.startReplaceGroup(1989076778);
        r12.endReplaceGroup();
        r8.hideSelectionToolbar$foundation_release();
        goto L80
    L20:
        r2 = false;
        goto L22
    L13:
        if (r12.changed(r9) == false) goto L15;
        int r24 = 32;
    L16:
        r1 = r1 | r24;
        goto L17
    L15:
        r24 = 16;
        goto L16
    L5:
        if (r12.changedInstance(r8) == false) goto L7;
        int r25 = 4;
    L8:
        r1 = r25 | r11;
        goto L11
    L7:
        r25 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$SelectionToolbarAndHandles(TextFieldSelectionManager r0, boolean r1, Composer r2, int r3) {
        SelectionToolbarAndHandles(r0, r1, r2, r3);
    }

    private static final DisposableEffectResult CoreTextField$lambda$36$lambda$35(LegacyTextFieldState r7, TextInputService r8, TextFieldValue r9, ImeOptions r10, DisposableEffectScope r11) {
        if (r7.getHasFocus() == false) goto L6;
        r7.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(r8, r9, r7.getProcessor(), r10, r7.getOnValueChange(), r7.getOnImeActionPerformed()));
    L6:
        return new CoreTextFieldKt$CoreTextField$lambda$36$lambda$35$$inlined$onDispose$1();
    }

    private static final void CoreTextFieldRootBox(final Modifier r8, final TextFieldSelectionManager r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(2036174316);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changedInstance(r9) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r12 & 384) != 0) goto L25;
        if (r13.changedInstance(r10) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r13.shouldExecute(r4, r1 & 1) == true) goto L31;
        r13.skipToGroupEnd();
    L49:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L53;
        r14.updateScope(new w1(r8, r9, r10, r12));
        return;
    L53:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(2036174316, r1, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:681)");
    L33:
        MeasurePolicy r0 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
        long r5 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r6 = (int) ((r5 >>> 32) ^ r5);
        CompositionLocalMap r7 = r13.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r13, r8);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r17 = r16.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L36;
        ComposablesKt.invalidApplier();
    L36:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L39;
        r13.createNode(r17);
    L40:
        Composer r18 = Updater.constructor-impl(r13);
        Updater.set-impl(r18, r0, r16.getSetMeasurePolicy());
        Updater.set-impl(r18, r7, r16.getSetResolvedCompositionLocals());
        Function2 r19 = r16.getSetCompositeKeyHash();
        if (r18.getInserting() == false) goto L43;
    L44:
        r18.updateRememberedValue(Integer.valueOf(r6));
        r18.apply(Integer.valueOf(r6), r19);
    L45:
        Updater.set-impl(r18, r15, r16.getSetModifier());
        BoxScopeInstance r20 = BoxScopeInstance.INSTANCE;
        int r21 = r1 >> 3;
        int r22 = r21 & 14;
        ContextMenu_androidKt.ContextMenuArea(r9, r10, r13, (r21 & 112) | r22);
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
        goto L49
    L43:
        if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r6)) == true) goto L45;
    L39:
        r13.useNode();
        goto L40
    L27:
        r4 = false;
        goto L29
    L5:
        if (r13.changed(r8) == false) goto L7;
        int r23 = 4;
    L8:
        r1 = r23 | r12;
        goto L11
    L7:
        r23 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$startInputSession(TextInputService r0, LegacyTextFieldState r1, TextFieldValue r2, ImeOptions r3, OffsetMapping r4) {
        startInputSession(r0, r1, r2, r3, r4);
    }

    private static final void startInputSession(TextInputService r7, LegacyTextFieldState r8, TextFieldValue r9, ImeOptions r10, OffsetMapping r11) {
        r8.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(r7, r9, r8.getProcessor(), r10, r8.getOnValueChange(), r8.getOnImeActionPerformed()));
        notifyFocusedRect(r8, r9, r11);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester r7, TextFieldValue r8, TextDelegate r9, TextLayoutResult r10, OffsetMapping r11, Continuation<? super Unit> r12) {
        int r13 = r11.originalToTransformed(TextRange.getMax-impl(r8.getSelection-d9O1mEE()));
        if (r13 >= r10.getLayoutInput().getText().length()) goto L5;
        Rect r14 = r10.getBoundingBox(r13);
    L8:
        Object r15 = r7.bringIntoView(r14, r12);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r15;
    L12:
        return Unit.INSTANCE;
    L5:
        if (r13 == 0) goto L7;
        r14 = r10.getBoundingBox(r13 - 1);
        goto L8
    L7:
        r14 = new Rect(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText$default(r9.getStyle(), r9.getDensity(), r9.getFontFamilyResolver(), null, 0, 24, null) & 4294967295L));
        goto L8
    }

    private static final Unit CoreTextField$lambda$22$lambda$21(LegacyTextFieldState r8, FocusRequester r9, boolean r10, boolean r11, TextFieldSelectionManager r12, OffsetMapping r13, Offset r14) {
        boolean r0 = true;
        tapToFocus(r8, r9, !r10);
        if (r8.getHasFocus() == false) goto L17;
        if (r11 == false) goto L17;
        if (r8.getHandleState() == HandleState.Selection) goto L15;
        TextLayoutResultProxy r4 = r8.getLayoutResult();
        if (r4 == null) goto L17;
        TextFieldDelegate.Companion.m1460setCursorOffsetULxng0E$foundation_release(r14.unbox-impl(), r4, r8.getProcessor(), r13, r8.getOnValueChange());
        if (r8.getTextDelegate().getText().length() > 0) goto L13;
        r0 = false;
    L13:
        if (r0 == false) goto L17;
        r8.setHandleState(HandleState.Cursor);
        goto L17
    L15:
        r12.m1900deselect_kEHs6E$foundation_release(r14);
    L17:
        return Unit.INSTANCE;
    }

    private static final Unit CoreTextField$lambda$30$lambda$29(LegacyTextFieldState r1, boolean r2, WindowInfo r3, TextFieldSelectionManager r4, TextFieldValue r5, OffsetMapping r6, LayoutCoordinates r7) {
        r1.setLayoutCoordinates(r7);
        TextLayoutResultProxy r0 = r1.getLayoutResult();
        if (r0 == null) goto L5;
        r0.setInnerTextFieldCoordinates(r7);
    L5:
        if (r2 == false) goto L26;
        if (r1.getHandleState() != HandleState.Selection) goto L16;
        if (r1.getShowFloatingToolbar() == true) goto L11;
    L13:
        r4.hideSelectionToolbar$foundation_release();
    L14:
        r1.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(r4, true));
        r1.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(r4, false));
        r1.setShowCursorHandle(TextRange.getCollapsed-impl(r5.getSelection-d9O1mEE()));
    L18:
        notifyFocusedRect(r1, r5, r6);
        TextLayoutResultProxy r8 = r1.getLayoutResult();
        if (r8 == null) goto L26;
        TextInputSession r9 = r1.getInputSession();
        if (r9 == null) goto L26;
        if (r1.getHasFocus() == false) goto L26;
        TextFieldDelegate.Companion.updateTextLayoutResult$foundation_release(r9, r5, r6, r8);
        goto L26
    L11:
        if (r3.isWindowFocused() == false) goto L13;
        r4.showSelectionToolbar$foundation_release();
        goto L14
    L16:
        if (r1.getHandleState() != HandleState.Cursor) goto L18;
        r1.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(r4, true));
    L26:
        return Unit.INSTANCE;
    }

    private static final Unit CoreTextField$lambda$15$lambda$14(LegacyTextFieldState r10, boolean r11, boolean r12, TextInputService r13, TextFieldValue r14, ImeOptions r15, OffsetMapping r16, TextFieldSelectionManager r17, CoroutineScope r18, BringIntoViewRequester r19, FocusState r20) {
        if (r10.getHasFocus() == r20.isFocused()) goto L5;
        r10.setHasFocus(r20.isFocused());
        if (r10.getHasFocus() == false) goto L11;
        if (r11 == false) goto L11;
        if (r12 == true) goto L11;
        startInputSession(r13, r10, r14, r15, r16);
    L13:
        if (r20.isFocused() == false) goto L18;
        TextLayoutResultProxy r4 = r10.getLayoutResult();
        if (r4 == null) goto L18;
        BuildersKt.launch$default(r18, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(r19, r14, r10, r4, r16, null), 3, null);
    L18:
        if (r20.isFocused() == true) goto L21;
        TextFieldSelectionManager.m1896deselect_kEHs6E$foundation_release$default(r17, null, 1, null);
    L21:
        return Unit.INSTANCE;
    L11:
        endInputSession(r10);
        goto L13
    L5:
        return Unit.INSTANCE;
    }

    public static final void CoreTextField(final TextFieldValue r52, final Function1<? super TextFieldValue, Unit> r53, Modifier r54, TextStyle r55, VisualTransformation r56, Function1<? super TextLayoutResult, Unit> r57, MutableInteractionSource r58, Brush r59, boolean r60, int r61, int r62, ImeOptions r63, KeyboardActions r64, boolean r65, boolean r66, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r67, TextFieldScrollerPosition r68, Composer r69, final int r70, final int r71, final int r72) {
        Composer r11 = r69.startRestartGroup(31062401);
        if ((r72 & 1) == 0) goto L6;
        int r1 = r70 | 6;
    L14:
        if ((r72 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r4 = r72 & 4;
        if (r4 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r16 = r72 & 8;
        int r17 = 1024;
        if (r16 == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        int r19 = r72 & 16;
        int r20 = 8192;
        if (r19 == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        int r23 = r72 & 32;
        if (r23 == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        int r27 = r72 & 64;
        if (r27 == 0) goto L70;
        r1 = r1 | 1572864;
    L76:
        int r8 = r72 & 128;
        if (r8 == 0) goto L80;
        r1 = r1 | 12582912;
    L86:
        int r0 = r72 & 256;
        if (r0 == 0) goto L90;
        r1 = r1 | 100663296;
    L96:
        int r2 = r72 & 512;
        if (r2 == 0) goto L100;
        r1 = r1 | 805306368;
    L106:
        int r3 = r72 & 1024;
        if (r3 == 0) goto L110;
        int r33 = r71 | 6;
    L118:
        if ((r71 & 48) != 0) goto L128;
        if ((r72 & 2048) != 0) goto L125;
        if (r11.changed(r63) == false) goto L125;
        int r34 = 32;
    L126:
        r33 = r33 | r34;
    L125:
        r34 = 16;
    L128:
        int r5 = r33;
        int r6 = r72 & 4096;
        if (r6 == 0) goto L132;
        r5 = r5 | 384;
    L139:
        int r7 = r72 & 8192;
        if (r7 == 0) goto L143;
        r5 = r5 | 3072;
    L149:
        int r9 = r72 & 16384;
        if (r9 == 0) goto L153;
        r5 = r5 | 24576;
    L159:
        int r18 = r72 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r18 == 0) goto L163;
        r5 = r5 | 196608;
    L169:
        int r110 = r72 & 65536;
        if (r110 == 0) goto L173;
        r5 = r5 | 1572864;
    L180:
        if ((r1 & 306783379) == 306783378) goto L182;
    L185:
        boolean r10 = true;
    L187:
        if (r11.shouldExecute(r10, r1 & 1) == false) goto L485;
        r11.startDefaults();
        if ((r70 & 1) != 0) goto L191;
    L197:
        if (r4 == 0) goto L199;
        Modifier r12 = Modifier.Companion;
    L200:
        if (r16 == 0) goto L202;
        TextStyle r13 = TextStyle.Companion.getDefault();
    L203:
        if (r19 == 0) goto L205;
        VisualTransformation r111 = VisualTransformation.Companion.getNone();
    L206:
        if (r23 == 0) goto L211;
        Object r15 = r11.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L210;
        r15 = new g2();
        r11.updateRememberedValue(r15);
    L210:
        Function1<? super TextLayoutResult, Unit> r14 = (Function1) r15;
    L212:
        if (r27 == 0) goto L214;
        MutableInteractionSource r112 = null;
    L215:
        if (r8 == 0) goto L217;
        Brush r21 = new SolidColor(Color.Companion.getUnspecified-0d7_KjU(), null);
    L218:
        if (r0 == 0) goto L220;
        boolean r22 = true;
    L221:
        if (r2 == 0) goto L223;
        int r24 = Integer.MAX_VALUE;
    L224:
        if (r3 == 0) goto L226;
        int r25 = 1;
    L228:
        if ((r72 & 2048) == 0) goto L230;
        ImeOptions r26 = ImeOptions.Companion.getDefault();
        r5 = r5 & (-113);
    L231:
        if (r6 == 0) goto L233;
        KeyboardActions r28 = KeyboardActions.Companion.getDefault();
    L234:
        if (r7 == 0) goto L236;
        boolean r29 = true;
    L237:
        if (r9 == 0) goto L239;
        boolean r30 = false;
    L240:
        if (r18 == 0) goto L242;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r113 = ComposableSingletons$CoreTextFieldKt.INSTANCE.getLambda$559628295$foundation_release();
    L243:
        Function1<? super TextLayoutResult, Unit> r210 = r14;
        if (r110 == 0) goto L246;
        TextFieldScrollerPosition r35 = null;
    L247:
        ImeOptions r31 = r26;
        boolean r32 = r29;
        TextStyle r211 = r13;
        int r114 = r24;
    L248:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L251;
        ComposerKt.traceEventStart(31062401, r1, r5, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:211)");
    L251:
        Object r36 = r11.rememberedValue();
        Composer.Companion r37 = Composer.Companion;
        if (r36 != r37.getEmpty()) goto L254;
        r36 = new FocusRequester();
        r11.updateRememberedValue(r36);
    L254:
        final FocusRequester r38 = (FocusRequester) r36;
        Object r39 = r11.rememberedValue();
        if (r39 != r37.getEmpty()) goto L257;
        r39 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
        r11.updateRememberedValue(r39);
    L257:
        final LegacyPlatformTextInputServiceAdapter r40 = (LegacyPlatformTextInputServiceAdapter) r39;
        Object r41 = r11.rememberedValue();
        if (r41 != r37.getEmpty()) goto L260;
        r41 = new TextInputService(r40);
        r11.updateRememberedValue(r41);
    L260:
        final TextInputService r42 = (TextInputService) r41;
        final Density r310 = (Density) r11.consume(CompositionLocalsKt.getLocalDensity());
        FontFamily.Resolver r43 = (FontFamily.Resolver) r11.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        long r115 = ((TextSelectionColors) r11.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m1910getBackgroundColor0d7_KjU();
        FocusManager r44 = (FocusManager) r11.consume(CompositionLocalsKt.getLocalFocusManager());
        final WindowInfo r116 = (WindowInfo) r11.consume(CompositionLocalsKt.getLocalWindowInfo());
        Modifier r117 = r12;
        SoftwareKeyboardController r118 = (SoftwareKeyboardController) r11.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (r114 != 1) goto L266;
        if (r22 == true) goto L266;
        if (r31.getSingleLine() == false) goto L266;
        boolean r45 = true;
    L267:
        if (r45 == false) goto L269;
        final Orientation r46 = Orientation.Horizontal;
    L270:
        if (r35 != null) goto L277;
        r11.startReplaceGroup(-213743954);
        Object[] r119 = {r46};
        Saver<TextFieldScrollerPosition, Object> r120 = TextFieldScrollerPosition.Companion.getSaver();
        boolean r121 = r11.changed(r46.ordinal());
        Object r47 = r11.rememberedValue();
        if (r121 == false) goto L274;
    L275:
        r47 = new j2(r46);
        r11.updateRememberedValue(r47);
    L276:
        TextFieldScrollerPosition r48 = (TextFieldScrollerPosition) RememberSaveableKt.rememberSaveable(r119, r120, (Function0) r47, r11, 0);
        r11.endReplaceGroup();
    L279:
        if (r48.getOrientation() != r46) goto L281;
        int r49 = r1 & 14;
        if (r49 != 4) goto L289;
        boolean r122 = true;
    L291:
        if ((r1 & 57344) != 16384) goto L293;
        boolean r50 = true;
    L294:
        boolean r51 = r50 | r122;
        Object r123 = r11.rememberedValue();
        if (r51 == false) goto L297;
    L298:
        TransformedText r73 = ValidatingOffsetMappingKt.filterWithValidation(r111, r52.getAnnotatedString());
        TextRange r124 = r52.getComposition-MzsxiRA();
        if (r124 == null) goto L302;
        r123 = TextFieldDelegate.Companion.m1457applyCompositionDecoration72CqOWE(r124.unbox-impl(), r73);
        if (r123 == null) goto L302;
    L303:
        r11.updateRememberedValue(r123);
    L304:
        TransformedText r74 = (TransformedText) r123;
        AnnotatedString r125 = r74.getText();
        final OffsetMapping r126 = r74.getOffsetMapping();
        final TextFieldScrollerPosition r610 = r48;
        RecomposeScope r75 = ComposablesKt.getCurrentRecomposeScope(r11, 0);
        boolean r311 = r11.changed(r118);
        Object r127 = r11.rememberedValue();
        if (r311 == true) goto L309;
        TransformedText r312 = r74;
        if (r127 == r37.getEmpty()) goto L310;
    L311:
        final LegacyTextFieldState r76 = (LegacyTextFieldState) r127;
        r76.m1396updatefnh65Uc(r52.getAnnotatedString(), r125, r211, r22, r310, r43, r53, r28, r44, r115);
        r76.getProcessor().reset(r52, r76.getInputSession());
        Object r77 = r11.rememberedValue();
        if (r77 != r37.getEmpty()) goto L314;
        r77 = new UndoManager(0, 1, null);
        r11.updateRememberedValue(r77);
    L314:
        UndoManager r78 = (UndoManager) r77;
        UndoManager.snapshotIfNeeded$default(r78, r52, 0, 2, null);
        Object r79 = r11.rememberedValue();
        if (r79 != r37.getEmpty()) goto L317;
        r79 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r11);
        r11.updateRememberedValue(r79);
    L317:
        final CoroutineScope r80 = (CoroutineScope) r79;
        Object r128 = r11.rememberedValue();
        if (r128 != r37.getEmpty()) goto L320;
        r128 = BringIntoViewRequesterKt.BringIntoViewRequester();
        r11.updateRememberedValue(r128);
    L320:
        final BringIntoViewRequester r129 = (BringIntoViewRequester) r128;
        Object r130 = r11.rememberedValue();
        if (r130 != r37.getEmpty()) goto L323;
        r130 = new TextFieldSelectionManager(r78);
        r11.updateRememberedValue(r130);
    L323:
        final TextFieldSelectionManager r131 = (TextFieldSelectionManager) r130;
        r131.setOffsetMapping$foundation_release(r126);
        r131.setVisualTransformation$foundation_release(r111);
        r131.setOnValueChange$foundation_release(r76.getOnValueChange());
        r131.setState$foundation_release(r76);
        r131.setValue$foundation_release(r52);
        r131.setClipboard$foundation_release((Clipboard) r11.consume(CompositionLocalsKt.getLocalClipboard()));
        r131.setCoroutineScope$foundation_release(r80);
        r131.setTextToolbar((TextToolbar) r11.consume(CompositionLocalsKt.getLocalTextToolbar()));
        r131.setHapticFeedBack((HapticFeedback) r11.consume(CompositionLocalsKt.getLocalHapticFeedback()));
        r131.setFocusRequester(r38);
        r131.setEditable(!r30);
        r131.setEnabled(r32);
        if (ComposeFoundationFlags.isSmartSelectionEnabled == false) goto L326;
        r11.startReplaceGroup(1966776937);
        r131.setPlatformSelectionBehaviors$foundation_release(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, r211.getLocaleList(), r11, 6));
        r11.endReplaceGroup();
    L327:
        Modifier r81 = Modifier.Companion;
        boolean r132 = r11.changedInstance(r76);
        int r82 = r5 & 7168;
        if (r82 != 2048) goto L330;
        boolean r133 = true;
    L331:
        boolean r134 = r133 | r132;
        int r135 = 57344 & r5;
        if (r135 != 16384) goto L334;
        boolean r83 = true;
    L335:
        boolean r84 = (r83 | r134) | r11.changedInstance(r42);
        if (r49 != 4) goto L338;
        boolean r136 = true;
    L339:
        boolean r85 = r84 | r136;
        int r137 = (r5 & 112) ^ 48;
        if (r137 <= 32) goto L345;
        final ImeOptions r86 = r31;
        if (r11.changed(r86) == false) goto L346;
        int r410 = r5;
        int r313 = r135;
    L348:
        boolean r87 = true;
    L350:
        boolean r88 = ((((r85 | r87) | r11.changedInstance(r126)) | r11.changedInstance(r80)) | r11.changedInstance(r129)) | r11.changedInstance(r131);
        Object r89 = r11.rememberedValue();
        if (r88 == false) goto L353;
    L354:
        final boolean r510 = r32;
        final boolean r511 = r30;
        final ImeOptions r611 = r86;
        r89 = new k2(r76, r510, r511, r42, r52, r611, r126, r131, r80, r129);
        r11.updateRememberedValue(r89);
    L355:
        MutableInteractionSource r138 = r112;
        Modifier r90 = TextFieldGestureModifiersKt.textFieldFocusModifier(r81, r32, r38, r138, (Function1) r89);
        if (r32 == false) goto L359;
        if (r30 == true) goto L359;
        boolean r91 = true;
    L360:
        State r92 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(r91), r11, 0);
        Unit r139 = Unit.INSTANCE;
        boolean r411 = ((r11.changed(r92) | r11.changedInstance(r76)) | r11.changedInstance(r42)) | r11.changedInstance(r131);
        if (r137 > 32) goto L363;
    L366:
        Modifier r412 = r90;
        if ((r410 & 48) != 32) goto L369;
    L368:
        boolean r93 = true;
    L370:
        boolean r94 = r411 | r93;
        Object r95 = r11.rememberedValue();
        if (r94 == false) goto L373;
    L374:
        r95 = new CoreTextFieldKt$CoreTextField$2$1(r76, r92, r42, r131, r86, null);
        r11.updateRememberedValue(r95);
    L375:
        EffectsKt.LaunchedEffect(r139, (Function2) r95, r11, 6);
        boolean r96 = r11.changedInstance(r76);
        Object r97 = r11.rememberedValue();
        if (r96 == false) goto L378;
    L379:
        r97 = new l2(r76);
        r11.updateRememberedValue(r97);
    L380:
        Modifier r98 = SelectionGesturesKt.updateSelectionTouchMode(r81, (Function1) r97);
        boolean r99 = r11.changedInstance(r76);
        if (r313 != 16384) goto L383;
        boolean r140 = true;
    L384:
        boolean r100 = r99 | r140;
        if (r82 != 2048) goto L387;
        boolean r141 = true;
    L388:
        boolean r101 = ((r100 | r141) | r11.changedInstance(r126)) | r11.changedInstance(r131);
        Object r142 = r11.rememberedValue();
        if (r101 == false) goto L391;
    L392:
        final boolean r512 = r30;
        final boolean r513 = r32;
        r142 = new x1(r76, r38, r512, r513, r131, r126);
        r11.updateRememberedValue(r142);
    L393:
        Modifier r102 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(r98, r138, r32, (Function1) r142), r131.getMouseSelectionObserver$foundation_release(), r131.getTouchSelectionObserver$foundation_release()), PointerIcon.Companion.getText(), false, 2, null);
        boolean r103 = r11.changedInstance(r76);
        if (r49 != 4) goto L396;
        boolean r143 = true;
    L397:
        boolean r104 = (r103 | r143) | r11.changedInstance(r126);
        Object r144 = r11.rememberedValue();
        if (r104 == false) goto L400;
    L403:
        final TextFieldValue r145 = r52;
        r144 = new y1(r76, r145, r126);
        r11.updateRememberedValue(r144);
    L404:
        final Modifier r146 = DrawModifierKt.drawBehind(r81, (Function1) r144);
        boolean r105 = r11.changedInstance(r76);
        if (r82 != 2048) goto L407;
        boolean r106 = true;
    L408:
        boolean r107 = ((r105 | r106) | r11.changed(r116)) | r11.changedInstance(r131);
        if (r49 != 4) goto L411;
        boolean r147 = true;
    L412:
        boolean r108 = (r107 | r147) | r11.changedInstance(r126);
        Object r148 = r11.rememberedValue();
        if (r108 == false) goto L415;
    L416:
        final boolean r514 = r32;
        r148 = new z1(r76, r514, r116, r131, r52, r126);
        r11.updateRememberedValue(r148);
    L417:
        final Modifier r149 = OnGloballyPositionedModifierKt.onGloballyPositioned(r81, (Function1) r148);
        CoreTextFieldSemanticsModifier r109 = new CoreTextFieldSemanticsModifier(r312, r52, r76, r30, r32, r111 instanceof PasswordVisualTransformation, r126, r131, r86, r38);
        if (r32 == false) goto L425;
        if (r30 == true) goto L425;
        if (r116.isWindowFocused() == false) goto L425;
        if (r76.hasHighlight() == true) goto L425;
        boolean r150 = true;
    L426:
        final Modifier r151 = TextFieldCursorKt.cursor(r81, r76, r52, r126, r21, r150);
        boolean r152 = r11.changedInstance(r131);
        Object r153 = r11.rememberedValue();
        if (r152 == false) goto L429;
    L430:
        r153 = new a2(r131);
        r11.updateRememberedValue(r153);
    L431:
        EffectsKt.DisposableEffect(r131, (Function1) r153, r11, 0);
        boolean r154 = r11.changedInstance(r76) | r11.changedInstance(r42);
        if (r49 != 4) goto L434;
        boolean r155 = true;
    L435:
        boolean r156 = r155 | r154;
        if (r137 <= 32) goto L440;
        if (r11.changed(r86) == false) goto L440;
    L441:
        boolean r157 = true;
    L443:
        boolean r158 = r156 | r157;
        Object r159 = r11.rememberedValue();
        if (r158 == false) goto L446;
    L447:
        r159 = new b2(r76, r42, r145, r86);
        r11.updateRememberedValue(r159);
    L448:
        EffectsKt.DisposableEffect(r86, (Function1) r159, r11, (r410 >> 3) & 14);
        Function1<TextFieldValue, Unit> r160 = r76.getOnValueChange();
        boolean r161 = !r30;
        final int r162 = r114;
        if (r162 != 1) goto L451;
        boolean r163 = true;
    L452:
        Modifier r164 = TextFieldKeyInputKt.m1467textFieldKeyInput2WJ9YEU(r81, r76, r131, r52, r160, r161, r163, r126, r78, r86.getImeAction-eUduSuo());
        int r165 = r86.getKeyboardType-PjHm6EE();
        KeyboardType.Companion r166 = KeyboardType.Companion;
        if (KeyboardType.equals-impl0(r165, r166.getPassword-PjHm6EE()) == false) goto L455;
    L457:
        final boolean r167 = false;
    L458:
        boolean r168 = CoreTextField$lambda$16(r92);
        ImeOptions r212 = r86;
        boolean r169 = r11.changed(r167) | r11.changedInstance(r40);
        Object r170 = r11.rememberedValue();
        if (r169 == false) goto L461;
    L462:
        r170 = new c2(r167, r40);
        r11.updateRememberedValue(r170);
    L463:
        Modifier r171 = StylusHandwritingKt.stylusHandwriting(r81, r168, r167, (Function0) r170);
        final long r172 = ((Color) r11.consume(AutofillHighlightKt.getLocalAutofillHighlightColor())).unbox-impl();
        boolean r173 = r11.changedInstance(r76) | r11.changed(r172);
        Object r174 = r11.rememberedValue();
        if (r173 == false) goto L466;
    L467:
        r174 = new h2(r76, r172);
        r11.updateRememberedValue(r174);
    L468:
        Modifier r175 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(r117.then(DrawModifierKt.drawBehind(r81, (Function1) r174)), r40, r76, r131).then(r171).then(r412), r76, r44), r76, r131).then(r164), r610, r138, r32).then(r102).then(r109), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(r76)), r131, r80);
        if (r32 == true) goto L471;
    L477:
        boolean r314 = false;
    L478:
        if (r314 == false) goto L480;
        Modifier r176 = TextFieldSelectionManager_androidKt.textFieldMagnifier(r81, r131);
    L481:
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r177 = r113;
        final TextStyle r178 = r211;
        final int r179 = r25;
        boolean r213 = r32;
        final VisualTransformation r180 = r111;
        final Modifier r181 = r176;
        VisualTransformation r315 = r111;
        final boolean r182 = r314;
        final boolean r183 = r30;
        final Function1<? super TextLayoutResult, Unit> r184 = r210;
        Composer r185 = r11;
        CoreTextFieldRootBox(r175, r131, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new AnonymousClass5(r177, r76, r178, r179, r162, r610, r52, r180, r151, r146, r149, r181, r129, r131, r182, r183, r184, r126, r310), r185, 54), r185, 384);
        if (ComposerKt.isTraceInProgress() == false) goto L484;
        ComposerKt.traceEventEnd();
    L484:
        final TextStyle r186 = r211;
        final boolean r187 = r213;
        final ImeOptions r188 = r212;
        final Function1<? super TextLayoutResult, Unit> r189 = r210;
        final Brush r190 = r21;
        final boolean r191 = r22;
        final int r192 = r162;
        final int r193 = r25;
        final KeyboardActions r194 = r28;
        final MutableInteractionSource r195 = r138;
        final VisualTransformation r196 = r315;
        final Modifier r197 = r117;
        final boolean r198 = r30;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r199 = r113;
        final TextFieldScrollerPosition r1100 = r35;
    L486:
        ScopeUpdateScope r200 = r185.endRestartGroup();
        if (r200 == null) goto L490;
        r200.updateScope(new i2(r52, r53, r197, r186, r196, r189, r195, r190, r191, r192, r193, r188, r194, r187, r198, r199, r1100, r70, r71, r72));
        return;
    L490:
        return;
    L480:
        r176 = r81;
        goto L481
    L471:
        if (r76.getHasFocus() == false) goto L477;
        if (r76.isInTouchMode() == false) goto L477;
        if (r116.isWindowFocused() == false) goto L477;
        r314 = true;
        goto L478
    L466:
        if (r174 != r37.getEmpty()) goto L468;
    L461:
        if (r170 != r37.getEmpty()) goto L463;
    L455:
        if (KeyboardType.equals-impl0(r86.getKeyboardType-PjHm6EE(), r166.getNumberPassword-PjHm6EE()) == true) goto L457;
        r167 = true;
        goto L458
    L451:
        r163 = false;
        goto L452
    L446:
        if (r159 != r37.getEmpty()) goto L448;
    L440:
        if ((r410 & 48) == 32) goto L441;
        r157 = false;
        goto L443
    L434:
        r155 = false;
        goto L435
    L429:
        if (r153 != r37.getEmpty()) goto L431;
    L425:
        r150 = false;
        goto L426
    L415:
        if (r148 != r37.getEmpty()) goto L417;
    L411:
        r147 = false;
        goto L412
    L407:
        r106 = false;
        goto L408
    L400:
        if (r144 == r37.getEmpty()) goto L403;
        r145 = r52;
        goto L404
    L396:
        r143 = false;
        goto L397
    L391:
        if (r142 != r37.getEmpty()) goto L393;
    L387:
        r141 = false;
        goto L388
    L383:
        r140 = false;
        goto L384
    L378:
        if (r97 != r37.getEmpty()) goto L380;
    L373:
        if (r95 != r37.getEmpty()) goto L375;
    L369:
        r93 = false;
        goto L370
    L363:
        if (r11.changed(r86) == false) goto L366;
        r412 = r90;
    L359:
        r91 = false;
        goto L360
    L353:
        if (r89 != r37.getEmpty()) goto L355;
    L346:
        r313 = r135;
        r410 = r5;
        if ((r5 & 48) == 32) goto L348;
        r87 = false;
        goto L350
    L345:
        r86 = r31;
        goto L346
    L338:
        r136 = false;
        goto L339
    L334:
        r83 = false;
        goto L335
    L330:
        r133 = false;
        goto L331
    L326:
        r11.startReplaceGroup(1966923009);
        r11.endReplaceGroup();
    L310:
        r127 = new LegacyTextFieldState(new TextDelegate(r125, r211, 0, 0, r22, 0, r310, r43, null, 300, null), r75, r118);
        r11.updateRememberedValue(r127);
        goto L311
    L309:
        r312 = r74;
    L302:
        r123 = r73;
        goto L303
    L297:
        if (r123 != r37.getEmpty()) goto L304;
    L293:
        r50 = false;
        goto L294
    L289:
        r122 = false;
        goto L291
    L281:
        if (r46 != Orientation.Vertical) goto L283;
        String r201 = "only single-line, non-wrap text fields can scroll horizontally";
    L285:
        throw new IllegalArgumentException("Mismatching scroller orientation; ".concat(r201));
    L283:
        r201 = "single-line, non-wrap text fields can only scroll horizontally";
        goto L285
    L274:
        if (r47 != r37.getEmpty()) goto L276;
    L277:
        r11.startReplaceGroup(-213745070);
        r11.endReplaceGroup();
        r48 = r35;
        goto L279
    L269:
        r46 = Orientation.Vertical;
    L266:
        r45 = false;
        goto L267
    L246:
        r35 = r68;
        goto L247
    L242:
        r113 = r67;
        goto L243
    L239:
        r30 = r66;
        goto L240
    L236:
        r29 = r65;
        goto L237
    L233:
        r28 = r64;
        goto L234
    L230:
        r26 = r63;
        goto L231
    L226:
        r25 = r62;
        goto L228
    L223:
        r24 = r61;
        goto L224
    L220:
        r22 = r60;
        goto L221
    L217:
        r21 = r59;
        goto L218
    L214:
        r112 = r58;
        goto L215
    L211:
        r14 = r57;
        goto L212
    L205:
        r111 = r56;
        goto L206
    L202:
        r13 = r55;
        goto L203
    L199:
        r12 = r54;
        goto L200
    L191:
        if (r11.getDefaultsInvalid() == true) goto L197;
        r11.skipToGroupEnd();
        if ((r72 & 2048) == 0) goto L196;
        r5 = r5 & (-113);
    L196:
        r12 = r54;
        r211 = r55;
        r111 = r56;
        r210 = r57;
        r112 = r58;
        r21 = r59;
        r22 = r60;
        r114 = r61;
        r25 = r62;
        r31 = r63;
        r28 = r64;
        r32 = r65;
        r30 = r66;
        r113 = r67;
        r35 = r68;
        goto L248
    L485:
        r185 = r11;
        r185.skipToGroupEnd();
        r197 = r54;
        r186 = r55;
        r196 = r56;
        r189 = r57;
        r195 = r58;
        r190 = r59;
        r191 = r60;
        r192 = r61;
        r193 = r62;
        r188 = r63;
        r194 = r64;
        r187 = r65;
        r198 = r66;
        r199 = r67;
        r1100 = r68;
        goto L486
    L182:
        if ((599187 & r5) != 599186) goto L185;
        r10 = false;
        goto L187
    L173:
        if ((r71 & 1572864) != 0) goto L180;
        if (r11.changed(r68) == false) goto L177;
        int r214 = 1048576;
    L178:
        r5 = r5 | r214;
        goto L180
    L177:
        r214 = 524288;
        goto L178
    L163:
        if ((r71 & 196608) != 0) goto L169;
        if (r11.changedInstance(r67) == false) goto L167;
        int r1101 = 131072;
    L168:
        r5 = r5 | r1101;
        goto L169
    L167:
        r1101 = 65536;
        goto L168
    L153:
        if ((r71 & 24576) != 0) goto L159;
        if (r11.changed(r66) == false) goto L157;
        r20 = 16384;
    L157:
        r5 = r5 | r20;
        goto L159
    L143:
        if ((r71 & 3072) != 0) goto L149;
        if (r11.changed(r65) == false) goto L147;
        r17 = 2048;
    L147:
        r5 = r5 | r17;
        goto L149
    L132:
        if ((r71 & 384) != 0) goto L139;
        if (r11.changed(r64) == false) goto L136;
        int r1102 = 256;
    L137:
        r5 = r5 | r1102;
        goto L139
    L136:
        r1102 = 128;
        goto L137
    L110:
        if ((r71 & 6) == 0) goto L112;
        r33 = r71;
        goto L118
    L112:
        if (r11.changed(r62) == false) goto L114;
        int r316 = 4;
    L115:
        r33 = r71 | r316;
        goto L118
    L114:
        r316 = 2;
        goto L115
    L100:
        if ((r70 & 805306368) != 0) goto L106;
        if (r11.changed(r61) == false) goto L104;
        int r317 = 536870912;
    L105:
        r1 = r1 | r317;
        goto L106
    L104:
        r317 = 268435456;
        goto L105
    L90:
        if ((r70 & 100663296) != 0) goto L96;
        if (r11.changed(r60) == false) goto L94;
        int r318 = 67108864;
    L95:
        r1 = r1 | r318;
        goto L96
    L94:
        r318 = 33554432;
        goto L95
    L80:
        if ((r70 & 12582912) != 0) goto L86;
        if (r11.changed(r59) == false) goto L84;
        int r319 = 8388608;
    L85:
        r1 = r1 | r319;
        goto L86
    L84:
        r319 = 4194304;
        goto L85
    L70:
        if ((r70 & 1572864) != 0) goto L76;
        if (r11.changed(r58) == false) goto L74;
        int r320 = 1048576;
    L75:
        r1 = r1 | r320;
        goto L76
    L74:
        r320 = 524288;
        goto L75
    L60:
        if ((r70 & 196608) != 0) goto L66;
        if (r11.changedInstance(r57) == false) goto L64;
        int r215 = 131072;
    L65:
        r1 = r1 | r215;
        goto L66
    L64:
        r215 = 65536;
        goto L65
    L49:
        if ((r70 & 24576) != 0) goto L56;
        if (r11.changed(r56) == false) goto L53;
        int r216 = 16384;
    L54:
        r1 = r1 | r216;
        goto L56
    L53:
        r216 = 8192;
        goto L54
    L38:
        if ((r70 & 3072) != 0) goto L45;
        if (r11.changed(r55) == false) goto L42;
        int r1103 = 2048;
    L43:
        r1 = r1 | r1103;
        goto L45
    L42:
        r1103 = 1024;
        goto L43
    L27:
        if ((r70 & 384) != 0) goto L34;
        if (r11.changed(r54) == false) goto L31;
        int r1104 = 256;
    L32:
        r1 = r1 | r1104;
        goto L34
    L31:
        r1104 = 128;
        goto L32
    L17:
        if ((r70 & 48) != 0) goto L23;
        if (r11.changedInstance(r53) == false) goto L21;
        int r202 = 32;
    L22:
        r1 = r1 | r202;
        goto L23
    L21:
        r202 = 16;
        goto L22
    L6:
        if ((r70 & 6) == 0) goto L8;
        r1 = r70;
        goto L14
    L8:
        if (r11.changed(r52) == false) goto L10;
        int r203 = 4;
    L11:
        r1 = r203 | r70;
        goto L14
    L10:
        r203 = 2;
        goto L11
    }
}
