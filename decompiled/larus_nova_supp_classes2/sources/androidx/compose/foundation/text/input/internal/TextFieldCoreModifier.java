package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\f\u0010\u001d\u001a\u00020\u001b*\u00020\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0004HÂ\u0003J\t\u0010 \u001a\u00020\u0004HÂ\u0003J\t\u0010!\u001a\u00020\u0007HÂ\u0003J\t\u0010\"\u001a\u00020\tHÂ\u0003J\t\u0010#\u001a\u00020\u000bHÂ\u0003J\t\u0010$\u001a\u00020\rHÂ\u0003J\t\u0010%\u001a\u00020\u0004HÂ\u0003J\t\u0010&\u001a\u00020\u0010HÂ\u0003J\t\u0010'\u001a\u00020\u0012HÂ\u0003J\t\u0010(\u001a\u00020\u0014HÂ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0016HÂ\u0003Jy\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010+\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "<init>", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldCoreModifier extends ModifierNodeElement<TextFieldCoreModifierNode> {
    public static final int $stable = 0;
    private final Brush cursorBrush;
    private final boolean isDragHovered;
    private final boolean isFocused;
    private final Orientation orientation;
    private final PlatformSelectionBehaviors platformSelectionBehaviors;
    private final ScrollState scrollState;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final ToolbarRequester toolbarRequester;
    private final boolean writeable;

    private final boolean component1() {
        return this.isFocused;
    }

    private final ToolbarRequester component10() {
        return this.toolbarRequester;
    }

    private final PlatformSelectionBehaviors component11() {
        return this.platformSelectionBehaviors;
    }

    private final boolean component2() {
        return this.isDragHovered;
    }

    private final TextLayoutState component3() {
        return this.textLayoutState;
    }

    private final TransformedTextFieldState component4() {
        return this.textFieldState;
    }

    private final TextFieldSelectionState component5() {
        return this.textFieldSelectionState;
    }

    private final Brush component6() {
        return this.cursorBrush;
    }

    private final boolean component7() {
        return this.writeable;
    }

    private final ScrollState component8() {
        return this.scrollState;
    }

    private final Orientation component9() {
        return this.orientation;
    }

    public static /* synthetic */ TextFieldCoreModifier copy$default(TextFieldCoreModifier r12, boolean r13, boolean r14, TextLayoutState r15, TransformedTextFieldState r16, TextFieldSelectionState r17, Brush r18, boolean r19, ScrollState r20, Orientation r21, ToolbarRequester r22, PlatformSelectionBehaviors r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        boolean r2 = r12.isFocused;
    L7:
        if ((r24 & 2) == 0) goto L9;
        boolean r3 = r12.isDragHovered;
    L11:
        if ((r24 & 4) == 0) goto L13;
        TextLayoutState r4 = r12.textLayoutState;
    L15:
        if ((r24 & 8) == 0) goto L17;
        TransformedTextFieldState r5 = r12.textFieldState;
    L19:
        if ((r24 & 16) == 0) goto L21;
        TextFieldSelectionState r6 = r12.textFieldSelectionState;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Brush r7 = r12.cursorBrush;
    L27:
        if ((r24 & 64) == 0) goto L29;
        boolean r8 = r12.writeable;
    L31:
        if ((r24 & 128) == 0) goto L33;
        ScrollState r9 = r12.scrollState;
    L35:
        if ((r24 & 256) == 0) goto L37;
        Orientation r10 = r12.orientation;
    L39:
        if ((r24 & 512) == 0) goto L41;
        ToolbarRequester r11 = r12.toolbarRequester;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        PlatformSelectionBehaviors r1 = r12.platformSelectionBehaviors;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final TextFieldCoreModifier copy(boolean r14, boolean r15, TextLayoutState r16, TransformedTextFieldState r17, TextFieldSelectionState r18, Brush r19, boolean r20, ScrollState r21, Orientation r22, ToolbarRequester r23, PlatformSelectionBehaviors r24) {
        return new TextFieldCoreModifier(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextFieldCoreModifier) == true) goto L8;
        return false;
    L8:
        TextFieldCoreModifier r6 = (TextFieldCoreModifier) r5;
        if (this.isFocused == r6.isFocused) goto L12;
        return false;
    L12:
        if (this.isDragHovered == r6.isDragHovered) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textLayoutState, r6.textLayoutState) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textFieldState, r6.textFieldState) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textFieldSelectionState, r6.textFieldSelectionState) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cursorBrush, r6.cursorBrush) == true) goto L27;
        return false;
    L27:
        if (this.writeable == r6.writeable) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.scrollState, r6.scrollState) == true) goto L33;
        return false;
    L33:
        if (this.orientation == r6.orientation) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.toolbarRequester, r6.toolbarRequester) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.platformSelectionBehaviors, r6.platformSelectionBehaviors) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isFocused == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isDragHovered == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((((((((r2 + r3) * 31) + this.textLayoutState.hashCode()) * 31) + this.textFieldState.hashCode()) * 31) + this.textFieldSelectionState.hashCode()) * 31) + this.cursorBrush.hashCode()) * 31;
        if (this.writeable == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (((((((r4 + r1) * 31) + this.scrollState.hashCode()) * 31) + this.orientation.hashCode()) * 31) + this.toolbarRequester.hashCode()) * 31;
        PlatformSelectionBehaviors r6 = this.platformSelectionBehaviors;
        if (r6 != null) goto L17;
        int r7 = 0;
    L19:
        return r5 + r7;
    L17:
        r7 = r6.hashCode();
        goto L19
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public void inspectableProperties(InspectorInfo r1) {
    }

    public String toString() {
        return "TextFieldCoreModifier(isFocused=" + this.isFocused + ", isDragHovered=" + this.isDragHovered + ", textLayoutState=" + this.textLayoutState + ", textFieldState=" + this.textFieldState + ", textFieldSelectionState=" + this.textFieldSelectionState + ", cursorBrush=" + this.cursorBrush + ", writeable=" + this.writeable + ", scrollState=" + this.scrollState + ", orientation=" + this.orientation + ", toolbarRequester=" + this.toolbarRequester + ", platformSelectionBehaviors=" + this.platformSelectionBehaviors + ')';
    }

    public TextFieldCoreModifierNode create() {
        return new TextFieldCoreModifierNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation, this.toolbarRequester, this.platformSelectionBehaviors);
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m1628create() {
        return create();
    }

    public void update(TextFieldCoreModifierNode r13) {
        r13.updateNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation, this.toolbarRequester, this.platformSelectionBehaviors);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((TextFieldCoreModifierNode) r1);
    }

    public TextFieldCoreModifier(boolean r1, boolean r2, TextLayoutState r3, TransformedTextFieldState r4, TextFieldSelectionState r5, Brush r6, boolean r7, ScrollState r8, Orientation r9, ToolbarRequester r10, PlatformSelectionBehaviors r11) {
        this.isFocused = r1;
        this.isDragHovered = r2;
        this.textLayoutState = r3;
        this.textFieldState = r4;
        this.textFieldSelectionState = r5;
        this.cursorBrush = r6;
        this.writeable = r7;
        this.scrollState = r8;
        this.orientation = r9;
        this.toolbarRequester = r10;
        this.platformSelectionBehaviors = r11;
    }
}
