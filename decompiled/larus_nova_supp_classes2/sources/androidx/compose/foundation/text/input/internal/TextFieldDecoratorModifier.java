package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bs\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\f\u0010\u001e\u001a\u00020\u0018*\u00020\u001fH\u0016J\t\u0010 \u001a\u00020\u0004HÂ\u0003J\t\u0010!\u001a\u00020\u0006HÂ\u0003J\t\u0010\"\u001a\u00020\bHÂ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÂ\u0003J\t\u0010$\u001a\u00020\fHÂ\u0003J\t\u0010%\u001a\u00020\fHÂ\u0003J\t\u0010&\u001a\u00020\u000fHÂ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0011HÂ\u0003J\t\u0010(\u001a\u00020\fHÂ\u0003J\t\u0010)\u001a\u00020\u0014HÂ\u0003J\t\u0010*\u001a\u00020\fHÂ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÂ\u0003J\u008d\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\f2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0001J\u0013\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPassword", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlinx/coroutines/flow/MutableSharedFlow;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDecoratorModifier extends ModifierNodeElement<TextFieldDecoratorModifierNode> {
    public static final int $stable = 0;
    private final boolean enabled;
    private final InputTransformation filter;
    private final MutableInteractionSource interactionSource;
    private final boolean isPassword;
    private final KeyboardActionHandler keyboardActionHandler;
    private final KeyboardOptions keyboardOptions;
    private final boolean readOnly;
    private final boolean singleLine;
    private final MutableSharedFlow<Unit> stylusHandwritingTrigger;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;

    private final TransformedTextFieldState component1() {
        return this.textFieldState;
    }

    private final MutableInteractionSource component10() {
        return this.interactionSource;
    }

    private final boolean component11() {
        return this.isPassword;
    }

    private final MutableSharedFlow<Unit> component12() {
        return this.stylusHandwritingTrigger;
    }

    private final TextLayoutState component2() {
        return this.textLayoutState;
    }

    private final TextFieldSelectionState component3() {
        return this.textFieldSelectionState;
    }

    private final InputTransformation component4() {
        return this.filter;
    }

    private final boolean component5() {
        return this.enabled;
    }

    private final boolean component6() {
        return this.readOnly;
    }

    private final KeyboardOptions component7() {
        return this.keyboardOptions;
    }

    private final KeyboardActionHandler component8() {
        return this.keyboardActionHandler;
    }

    private final boolean component9() {
        return this.singleLine;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextFieldDecoratorModifier copy$default(TextFieldDecoratorModifier r13, TransformedTextFieldState r14, TextLayoutState r15, TextFieldSelectionState r16, InputTransformation r17, boolean r18, boolean r19, KeyboardOptions r20, KeyboardActionHandler r21, boolean r22, MutableInteractionSource r23, boolean r24, MutableSharedFlow r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        TransformedTextFieldState r2 = r13.textFieldState;
    L7:
        if ((r26 & 2) == 0) goto L9;
        TextLayoutState r3 = r13.textLayoutState;
    L11:
        if ((r26 & 4) == 0) goto L13;
        TextFieldSelectionState r4 = r13.textFieldSelectionState;
    L15:
        if ((r26 & 8) == 0) goto L17;
        InputTransformation r5 = r13.filter;
    L19:
        if ((r26 & 16) == 0) goto L21;
        boolean r6 = r13.enabled;
    L23:
        if ((r26 & 32) == 0) goto L25;
        boolean r7 = r13.readOnly;
    L27:
        if ((r26 & 64) == 0) goto L29;
        KeyboardOptions r8 = r13.keyboardOptions;
    L31:
        if ((r26 & 128) == 0) goto L33;
        KeyboardActionHandler r9 = r13.keyboardActionHandler;
    L35:
        if ((r26 & 256) == 0) goto L37;
        boolean r10 = r13.singleLine;
    L39:
        if ((r26 & 512) == 0) goto L41;
        MutableInteractionSource r11 = r13.interactionSource;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        boolean r12 = r13.isPassword;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        MutableSharedFlow r1 = r13.stylusHandwritingTrigger;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final TextFieldDecoratorModifier copy(TransformedTextFieldState r15, TextLayoutState r16, TextFieldSelectionState r17, InputTransformation r18, boolean r19, boolean r20, KeyboardOptions r21, KeyboardActionHandler r22, boolean r23, MutableInteractionSource r24, boolean r25, MutableSharedFlow<Unit> r26) {
        return new TextFieldDecoratorModifier(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextFieldDecoratorModifier) == true) goto L8;
        return false;
    L8:
        TextFieldDecoratorModifier r6 = (TextFieldDecoratorModifier) r5;
        if (Intrinsics.areEqual(this.textFieldState, r6.textFieldState) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textLayoutState, r6.textLayoutState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textFieldSelectionState, r6.textFieldSelectionState) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.filter, r6.filter) == true) goto L21;
        return false;
    L21:
        if (this.enabled == r6.enabled) goto L24;
        return false;
    L24:
        if (this.readOnly == r6.readOnly) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.keyboardOptions, r6.keyboardOptions) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.keyboardActionHandler, r6.keyboardActionHandler) == true) goto L33;
        return false;
    L33:
        if (this.singleLine == r6.singleLine) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L39;
        return false;
    L39:
        if (this.isPassword == r6.isPassword) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.stylusHandwritingTrigger, r6.stylusHandwritingTrigger) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.textFieldState.hashCode() * 31) + this.textLayoutState.hashCode()) * 31) + this.textFieldSelectionState.hashCode()) * 31;
        InputTransformation r1 = this.filter;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.enabled == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.readOnly == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (((r7 + r8) * 31) + this.keyboardOptions.hashCode()) * 31;
        KeyboardActionHandler r10 = this.keyboardActionHandler;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.singleLine == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (((r12 + r13) * 31) + this.interactionSource.hashCode()) * 31;
        if (this.isPassword == true) goto L26;
        r5 = 1237;
    L26:
        int r15 = (r14 + r5) * 31;
        MutableSharedFlow<Unit> r16 = this.stylusHandwritingTrigger;
        if (r16 == null) goto L31;
        r2 = r16.hashCode();
    L31:
        return r15 + r2;
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public void inspectableProperties(InspectorInfo r1) {
    }

    public String toString() {
        return "TextFieldDecoratorModifier(textFieldState=" + this.textFieldState + ", textLayoutState=" + this.textLayoutState + ", textFieldSelectionState=" + this.textFieldSelectionState + ", filter=" + this.filter + ", enabled=" + this.enabled + ", readOnly=" + this.readOnly + ", keyboardOptions=" + this.keyboardOptions + ", keyboardActionHandler=" + this.keyboardActionHandler + ", singleLine=" + this.singleLine + ", interactionSource=" + this.interactionSource + ", isPassword=" + this.isPassword + ", stylusHandwritingTrigger=" + this.stylusHandwritingTrigger + ')';
    }

    public TextFieldDecoratorModifierNode create() {
        return new TextFieldDecoratorModifierNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActionHandler, this.singleLine, this.interactionSource, this.isPassword, this.stylusHandwritingTrigger);
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m1635create() {
        return create();
    }

    public void update(TextFieldDecoratorModifierNode r14) {
        r14.updateNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActionHandler, this.singleLine, this.interactionSource, this.isPassword, this.stylusHandwritingTrigger);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((TextFieldDecoratorModifierNode) r1);
    }

    public TextFieldDecoratorModifier(TransformedTextFieldState r1, TextLayoutState r2, TextFieldSelectionState r3, InputTransformation r4, boolean r5, boolean r6, KeyboardOptions r7, KeyboardActionHandler r8, boolean r9, MutableInteractionSource r10, boolean r11, MutableSharedFlow<Unit> r12) {
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
    }
}
