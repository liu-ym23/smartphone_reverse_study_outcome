package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0016J\f\u0010,\u001a\u00020**\u00020-H\u0016J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0014HÆ\u0003Jm\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u00109\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020?HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006@"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifierNode;", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "readOnly", "", "enabled", "isPassword", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "<init>", "(Landroidx/compose/ui/text/input/TransformedText;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/LegacyTextFieldState;ZZZLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/ui/focus/FocusRequester;)V", "getTransformedText", "()Landroidx/compose/ui/text/input/TransformedText;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getReadOnly", "()Z", "getEnabled", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getImeOptions", "()Landroidx/compose/ui/text/input/ImeOptions;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CoreTextFieldSemanticsModifier extends ModifierNodeElement<CoreTextFieldSemanticsModifierNode> {
    public static final int $stable = 0;
    private final boolean enabled;
    private final FocusRequester focusRequester;
    private final ImeOptions imeOptions;
    private final boolean isPassword;
    private final TextFieldSelectionManager manager;
    private final OffsetMapping offsetMapping;
    private final boolean readOnly;
    private final LegacyTextFieldState state;
    private final TransformedText transformedText;
    private final TextFieldValue value;

    public static /* synthetic */ CoreTextFieldSemanticsModifier copy$default(CoreTextFieldSemanticsModifier r11, TransformedText r12, TextFieldValue r13, LegacyTextFieldState r14, boolean r15, boolean r16, boolean r17, OffsetMapping r18, TextFieldSelectionManager r19, ImeOptions r20, FocusRequester r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        TransformedText r2 = r11.transformedText;
    L7:
        if ((r22 & 2) == 0) goto L9;
        TextFieldValue r3 = r11.value;
    L11:
        if ((r22 & 4) == 0) goto L13;
        LegacyTextFieldState r4 = r11.state;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r5 = r11.readOnly;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r6 = r11.enabled;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r7 = r11.isPassword;
    L27:
        if ((r22 & 64) == 0) goto L29;
        OffsetMapping r8 = r11.offsetMapping;
    L31:
        if ((r22 & 128) == 0) goto L33;
        TextFieldSelectionManager r9 = r11.manager;
    L35:
        if ((r22 & 256) == 0) goto L37;
        ImeOptions r10 = r11.imeOptions;
    L39:
        if ((r22 & 512) == 0) goto L41;
        FocusRequester r1 = r11.focusRequester;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final TransformedText component1() {
        return this.transformedText;
    }

    public final FocusRequester component10() {
        return this.focusRequester;
    }

    public final TextFieldValue component2() {
        return this.value;
    }

    public final LegacyTextFieldState component3() {
        return this.state;
    }

    public final boolean component4() {
        return this.readOnly;
    }

    public final boolean component5() {
        return this.enabled;
    }

    public final boolean component6() {
        return this.isPassword;
    }

    public final OffsetMapping component7() {
        return this.offsetMapping;
    }

    public final TextFieldSelectionManager component8() {
        return this.manager;
    }

    public final ImeOptions component9() {
        return this.imeOptions;
    }

    public final CoreTextFieldSemanticsModifier copy(TransformedText r13, TextFieldValue r14, LegacyTextFieldState r15, boolean r16, boolean r17, boolean r18, OffsetMapping r19, TextFieldSelectionManager r20, ImeOptions r21, FocusRequester r22) {
        return new CoreTextFieldSemanticsModifier(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CoreTextFieldSemanticsModifier) == true) goto L8;
        return false;
    L8:
        CoreTextFieldSemanticsModifier r6 = (CoreTextFieldSemanticsModifier) r5;
        if (Intrinsics.areEqual(this.transformedText, r6.transformedText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r6.value) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L18;
        return false;
    L18:
        if (this.readOnly == r6.readOnly) goto L21;
        return false;
    L21:
        if (this.enabled == r6.enabled) goto L24;
        return false;
    L24:
        if (this.isPassword == r6.isPassword) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.offsetMapping, r6.offsetMapping) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.manager, r6.manager) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imeOptions, r6.imeOptions) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.focusRequester, r6.focusRequester) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.transformedText.hashCode() * 31) + this.value.hashCode()) * 31) + this.state.hashCode()) * 31;
        int r2 = 1231;
        if (this.readOnly == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.enabled == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.isPassword == true) goto L15;
        r2 = 1237;
    L15:
        return ((((((((r5 + r2) * 31) + this.offsetMapping.hashCode()) * 31) + this.manager.hashCode()) * 31) + this.imeOptions.hashCode()) * 31) + this.focusRequester.hashCode();
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public void inspectableProperties(InspectorInfo r1) {
    }

    public String toString() {
        return "CoreTextFieldSemanticsModifier(transformedText=" + this.transformedText + ", value=" + this.value + ", state=" + this.state + ", readOnly=" + this.readOnly + ", enabled=" + this.enabled + ", isPassword=" + this.isPassword + ", offsetMapping=" + this.offsetMapping + ", manager=" + this.manager + ", imeOptions=" + this.imeOptions + ", focusRequester=" + this.focusRequester + ')';
    }

    public CoreTextFieldSemanticsModifierNode create() {
        return new CoreTextFieldSemanticsModifierNode(this.transformedText, this.value, this.state, this.readOnly, this.enabled, this.isPassword, this.offsetMapping, this.manager, this.imeOptions, this.focusRequester);
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

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m1576create() {
        return create();
    }

    public void update(CoreTextFieldSemanticsModifierNode r12) {
        r12.updateNodeSemantics(this.transformedText, this.value, this.state, this.readOnly, this.enabled, this.isPassword, this.offsetMapping, this.manager, this.imeOptions, this.focusRequester);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((CoreTextFieldSemanticsModifierNode) r1);
    }

    public CoreTextFieldSemanticsModifier(TransformedText r1, TextFieldValue r2, LegacyTextFieldState r3, boolean r4, boolean r5, boolean r6, OffsetMapping r7, TextFieldSelectionManager r8, ImeOptions r9, FocusRequester r10) {
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
    }
}
