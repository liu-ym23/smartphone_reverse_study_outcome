package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.CoreTextFieldKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextFieldDelegate;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\f\u0010<\u001a\u00020=*\u00020>H\u0016JV\u0010?\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J(\u0010@\u001a\u00020=2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010A\u001a\u00020B2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010$\"\u0004\b)\u0010&R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010$¨\u0006C"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "readOnly", "", "enabled", "isPassword", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "<init>", "(Landroidx/compose/ui/text/input/TransformedText;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/LegacyTextFieldState;ZZZLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/ui/focus/FocusRequester;)V", "getTransformedText", "()Landroidx/compose/ui/text/input/TransformedText;", "setTransformedText", "(Landroidx/compose/ui/text/input/TransformedText;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "getReadOnly", "()Z", "setReadOnly", "(Z)V", "getEnabled", "setEnabled", "setPassword", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "getManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "setManager", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "getImeOptions", "()Landroidx/compose/ui/text/input/ImeOptions;", "setImeOptions", "(Landroidx/compose/ui/text/input/ImeOptions;)V", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateNodeSemantics", "handleTextUpdateFromSemantics", "text", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CoreTextFieldSemanticsModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private boolean enabled;
    private FocusRequester focusRequester;
    private ImeOptions imeOptions;
    private boolean isPassword;
    private TextFieldSelectionManager manager;
    private OffsetMapping offsetMapping;
    private boolean readOnly;
    private LegacyTextFieldState state;
    private TransformedText transformedText;
    private TextFieldValue value;

    public static /* synthetic */ boolean a(CoreTextFieldSemanticsModifierNode r0) {
        return applySemantics$lambda$10(r0);
    }

    public static /* synthetic */ boolean b(CoreTextFieldSemanticsModifierNode r0, List r1) {
        return applySemantics$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit c(CoreTextFieldSemanticsModifierNode r0) {
        return updateNodeSemantics$lambda$14(r0);
    }

    public static /* synthetic */ boolean d(CoreTextFieldSemanticsModifierNode r0) {
        return applySemantics$lambda$13(r0);
    }

    public static /* synthetic */ boolean e(CoreTextFieldSemanticsModifierNode r0, int r1, int r2, boolean r3) {
        return applySemantics$lambda$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean f(CoreTextFieldSemanticsModifierNode r0) {
        return applySemantics$lambda$12(r0);
    }

    public static /* synthetic */ boolean g(CoreTextFieldSemanticsModifierNode r0) {
        return applySemantics$lambda$8(r0);
    }

    public static /* synthetic */ Unit h(CoreTextFieldSemanticsModifierNode r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ boolean i(CoreTextFieldSemanticsModifierNode r0) {
        return applySemantics$lambda$11(r0);
    }

    public static /* synthetic */ boolean j(CoreTextFieldSemanticsModifierNode r0, SemanticsPropertyReceiver r1, AnnotatedString r2) {
        return applySemantics$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ boolean k(CoreTextFieldSemanticsModifierNode r0, AnnotatedString r1) {
        return applySemantics$lambda$3(r0, r1);
    }

    public static /* synthetic */ boolean l(CoreTextFieldSemanticsModifierNode r0, AnnotatedString r1) {
        return applySemantics$lambda$1(r0, r1);
    }

    public static /* synthetic */ boolean m(CoreTextFieldSemanticsModifierNode r0) {
        return applySemantics$lambda$9(r0);
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final ImeOptions getImeOptions() {
        return this.imeOptions;
    }

    public final TextFieldSelectionManager getManager() {
        return this.manager;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    public final boolean isPassword() {
        return this.isPassword;
    }

    private static final Unit _init_$lambda$0(CoreTextFieldSemanticsModifierNode r0) {
        DelegatableNodeKt.requestAutofill(r0);
        return Unit.INSTANCE;
    }

    private static final boolean applySemantics$lambda$10(CoreTextFieldSemanticsModifierNode r3) {
        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(r3.manager, false, 1, null);
        return true;
    }

    private static final boolean applySemantics$lambda$11(CoreTextFieldSemanticsModifierNode r3) {
        TextFieldSelectionManager.copy$foundation_release$default(r3.manager, false, 1, null);
        return true;
    }

    private static final boolean applySemantics$lambda$12(CoreTextFieldSemanticsModifierNode r0) {
        r0.manager.cut$foundation_release();
        return true;
    }

    private static final boolean applySemantics$lambda$13(CoreTextFieldSemanticsModifierNode r0) {
        r0.manager.paste$foundation_release();
        return true;
    }

    private static final boolean applySemantics$lambda$8(CoreTextFieldSemanticsModifierNode r1) {
        r1.state.getOnImeActionPerformed().invoke(ImeAction.box-impl(r1.imeOptions.getImeAction-eUduSuo()));
        return true;
    }

    private static final boolean applySemantics$lambda$9(CoreTextFieldSemanticsModifierNode r3) {
        CoreTextFieldKt.tapToFocus(r3.state, r3.focusRequester, !r3.readOnly);
        return true;
    }

    private static final Unit updateNodeSemantics$lambda$14(CoreTextFieldSemanticsModifierNode r0) {
        DelegatableNodeKt.requestAutofill(r0);
        return Unit.INSTANCE;
    }

    public void applySemantics(final SemanticsPropertyReceiver r10) {
        SemanticsPropertiesKt.setInputText(r10, this.value.getAnnotatedString());
        SemanticsPropertiesKt.setEditableText(r10, this.transformedText.getText());
        SemanticsPropertiesKt.setTextSelectionRange-FDrldGo(r10, this.value.getSelection-d9O1mEE());
        SemanticsPropertiesKt.setContentDataType(r10, ContentDataType.Companion.getText());
        SemanticsPropertiesKt.onAutofillText$default(r10, null, new o(this), 1, null);
        if (this.enabled == true) goto L6;
        SemanticsPropertiesKt.disabled(r10);
    L6:
        if (this.isPassword == false) goto L9;
        SemanticsPropertiesKt.password(r10);
    L9:
        if (this.enabled == true) goto L11;
    L13:
        boolean r0 = false;
    L14:
        SemanticsPropertiesKt.setEditable(r10, r0);
        SemanticsPropertiesKt.getTextLayoutResult$default(r10, null, new q(this), 1, null);
        if (r0 == false) goto L17;
        SemanticsPropertiesKt.setText$default(r10, null, new r(this), 1, null);
        SemanticsPropertiesKt.insertTextAtCursor$default(r10, null, new s(this, r10), 1, null);
    L17:
        SemanticsPropertiesKt.setSelection$default(r10, null, new t(this), 1, null);
        SemanticsPropertiesKt.onImeAction-9UiTYpY$default(r10, this.imeOptions.getImeAction-eUduSuo(), null, new u(this), 2, null);
        SemanticsPropertiesKt.onClick$default(r10, null, new v(this), 1, null);
        SemanticsPropertiesKt.onLongClick$default(r10, null, new k(this), 1, null);
        if (TextRange.getCollapsed-impl(this.value.getSelection-d9O1mEE()) == true) goto L27;
        if (this.isPassword == true) goto L27;
        SemanticsPropertiesKt.copyText$default(r10, null, new l(this), 1, null);
        if (this.enabled == false) goto L27;
        if (this.readOnly == true) goto L27;
        SemanticsPropertiesKt.cutText$default(r10, null, new m(this), 1, null);
    L27:
        if (this.enabled == true) goto L29;
        return;
    L29:
        if (this.readOnly == true) goto L33;
        SemanticsPropertiesKt.pasteText$default(r10, null, new p(this), 1, null);
        return;
    L33:
        return;
    L11:
        if (this.readOnly == true) goto L13;
        r0 = true;
        goto L14
    }

    public final void setEnabled(boolean r1) {
        this.enabled = r1;
    }

    public final void setFocusRequester(FocusRequester r1) {
        this.focusRequester = r1;
    }

    public final void setImeOptions(ImeOptions r1) {
        this.imeOptions = r1;
    }

    public final void setManager(TextFieldSelectionManager r1) {
        this.manager = r1;
    }

    public final void setOffsetMapping(OffsetMapping r1) {
        this.offsetMapping = r1;
    }

    public final void setPassword(boolean r1) {
        this.isPassword = r1;
    }

    public final void setReadOnly(boolean r1) {
        this.readOnly = r1;
    }

    public final void setState(LegacyTextFieldState r1) {
        this.state = r1;
    }

    public final void setTransformedText(TransformedText r1) {
        this.transformedText = r1;
    }

    public final void setValue(TextFieldValue r1) {
        this.value = r1;
    }

    private static final boolean applySemantics$lambda$1(CoreTextFieldSemanticsModifierNode r4, AnnotatedString r5) {
        r4.state.setJustAutofilled(true);
        r4.state.setAutofillHighlightOn(true);
        r4.handleTextUpdateFromSemantics(r4.state, r5.getText(), r4.readOnly, r4.enabled);
        return true;
    }

    private static final boolean applySemantics$lambda$2(CoreTextFieldSemanticsModifierNode r1, List r2) {
        if (r1.state.getLayoutResult() == null) goto L5;
        TextLayoutResultProxy r3 = r1.state.getLayoutResult();
        Intrinsics.checkNotNull(r3);
        r2.add(r3.getValue());
        return true;
    L5:
        return false;
    }

    private static final boolean applySemantics$lambda$3(CoreTextFieldSemanticsModifierNode r3, AnnotatedString r4) {
        r3.handleTextUpdateFromSemantics(r3.state, r4.getText(), r3.readOnly, r3.enabled);
        return true;
    }

    private static final boolean applySemantics$lambda$6(CoreTextFieldSemanticsModifierNode r9, SemanticsPropertyReceiver r10, AnnotatedString r11) {
        if (r9.readOnly == false) goto L5;
    L12:
        return false;
    L5:
        if (r9.enabled == false) goto L12;
        androidx.compose.ui.text.input.TextInputSession r12 = r9.state.getInputSession();
        if (r12 == null) goto L10;
        TextFieldDelegate.Companion.onEditCommand$foundation_release(CollectionsKt.listOf(new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(r11, 1)}), r9.state.getProcessor(), r9.state.getOnValueChange(), r12);
    L11:
        return true;
    L10:
        r9.state.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(r9.value.getText(), TextRange.getStart-impl(r9.value.getSelection-d9O1mEE()), TextRange.getEnd-impl(r9.value.getSelection-d9O1mEE()), r11).toString(), TextRangeKt.TextRange(TextRange.getStart-impl(r9.value.getSelection-d9O1mEE()) + r11.length()), null, 4, null));
        goto L11
    }

    private static final boolean applySemantics$lambda$7(CoreTextFieldSemanticsModifierNode r9, int r10, int r11, boolean r12) {
        if (r12 == true) goto L5;
        r10 = r9.offsetMapping.transformedToOriginal(r10);
    L5:
        if (r12 == true) goto L9;
        r11 = r9.offsetMapping.transformedToOriginal(r11);
    L9:
        if (r9.enabled == true) goto L12;
        return false;
    L12:
        if (r10 != TextRange.getStart-impl(r9.value.getSelection-d9O1mEE())) goto L17;
        if (r11 != TextRange.getEnd-impl(r9.value.getSelection-d9O1mEE())) goto L17;
        return false;
    L17:
        if (Math.min(r10, r11) >= 0) goto L19;
    L27:
        r9.manager.exitSelectionMode$foundation_release();
        return false;
    L19:
        if (Math.max(r10, r11) > r9.value.getAnnotatedString().length()) goto L27;
        if (r12 == true) goto L25;
        if (r10 == r11) goto L25;
        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(r9.manager, false, 1, null);
    L26:
        r9.state.getOnValueChange().invoke(new TextFieldValue(r9.value.getAnnotatedString(), TextRangeKt.TextRange(r10, r11), null, 4, null));
        return true;
    L25:
        r9.manager.exitSelectionMode$foundation_release();
        goto L26
    }

    private final void handleTextUpdateFromSemantics(LegacyTextFieldState r8, String r9, boolean r10, boolean r11) {
        if (r10 == true) goto L10;
        if (r11 == false) goto L12;
        androidx.compose.ui.text.input.TextInputSession r12 = r8.getInputSession();
        if (r12 == null) goto L8;
        TextFieldDelegate.Companion.onEditCommand$foundation_release(CollectionsKt.listOf(new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(r9, 1)}), r8.getProcessor(), r8.getOnValueChange(), r12);
        return;
    L8:
        r8.getOnValueChange().invoke(new TextFieldValue(r9, TextRangeKt.TextRange(r9.length()), null, 4, null));
        return;
    L12:
        return;
    }

    public CoreTextFieldSemanticsModifierNode(TransformedText r1, TextFieldValue r2, LegacyTextFieldState r3, boolean r4, boolean r5, boolean r6, OffsetMapping r7, TextFieldSelectionManager r8, ImeOptions r9, FocusRequester r10) {
        this.transformedText = r1;
        this.value = r2;
        this.state = r3;
        this.readOnly = r4;
        this.enabled = r5;
        this.isPassword = r6;
        this.offsetMapping = r7;
        this.manager = r8;
        this.imeOptions = r9;
        this.focusRequester = r10;
        r8.setRequestAutofillAction$foundation_release(new j(this));
    }

    public final void updateNodeSemantics(TransformedText r14, TextFieldValue r15, LegacyTextFieldState r16, boolean r17, boolean r18, boolean r19, OffsetMapping r20, TextFieldSelectionManager r21, ImeOptions r22, FocusRequester r23) {
        boolean r5 = this.enabled;
        boolean r6 = true;
        if (r5 == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        boolean r9 = this.isPassword;
        ImeOptions r10 = this.imeOptions;
        TextFieldSelectionManager r11 = this.manager;
        if (r18 == false) goto L12;
        if (r17 == true) goto L12;
    L13:
        this.transformedText = r14;
        this.value = r15;
        this.state = r16;
        this.readOnly = r17;
        this.enabled = r18;
        this.offsetMapping = r20;
        this.manager = r21;
        this.imeOptions = r22;
        this.focusRequester = r23;
        if (r18 != r5) goto L22;
        if (r6 != r8) goto L22;
        if (Intrinsics.areEqual(r22, r10) == false) goto L22;
        if (r19 != r9) goto L22;
        if (TextRange.getCollapsed-impl(r15.getSelection-d9O1mEE()) == false) goto L22;
    L24:
        if (Intrinsics.areEqual(r21, r11) == true) goto L27;
        r21.setRequestAutofillAction$foundation_release(new n(this));
        return;
    L27:
        return;
    L22:
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L12:
        r6 = false;
        goto L13
    L5:
        if (this.readOnly == true) goto L7;
        r8 = true;
        goto L8
    }
}
