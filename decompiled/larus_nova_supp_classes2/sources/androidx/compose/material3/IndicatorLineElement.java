package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0016J\f\u0010!\u001a\u00020\u001f*\u00020\"H\u0016J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010(\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b)\u0010\u001aJ\u0010\u0010*\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b+\u0010\u001aJZ\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u00020\r¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a¨\u00066"}, d2 = {"Landroidx/compose/material3/IndicatorLineElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/IndicatorLineNode;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "textFieldShape", "Landroidx/compose/ui/graphics/Shape;", "focusedIndicatorLineThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedIndicatorLineThickness", "<init>", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "getColors", "()Landroidx/compose/material3/TextFieldColors;", "getTextFieldShape", "()Landroidx/compose/ui/graphics/Shape;", "getFocusedIndicatorLineThickness-D9Ej5fM", "()F", "F", "getUnfocusedIndicatorLineThickness-D9Ej5fM", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component6-D9Ej5fM", "component7", "component7-D9Ej5fM", "copy", "copy-gv0btCI", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)Landroidx/compose/material3/IndicatorLineElement;", "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IndicatorLineElement extends ModifierNodeElement<IndicatorLineNode> {
    public static final int $stable = 0;
    private final TextFieldColors colors;
    private final boolean enabled;
    private final float focusedIndicatorLineThickness;
    private final InteractionSource interactionSource;
    private final boolean isError;
    private final Shape textFieldShape;
    private final float unfocusedIndicatorLineThickness;

    public /* synthetic */ IndicatorLineElement(boolean r1, boolean r2, InteractionSource r3, TextFieldColors r4, Shape r5, float r6, float r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: copy-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ IndicatorLineElement m2785copygv0btCI$default(IndicatorLineElement r5, boolean r6, boolean r7, InteractionSource r8, TextFieldColors r9, Shape r10, float r11, float r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.enabled;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.isError;
    L8:
        boolean r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.interactionSource;
    L11:
        InteractionSource r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.colors;
    L14:
        TextFieldColors r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.textFieldShape;
    L17:
        Shape r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.focusedIndicatorLineThickness;
    L20:
        float r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.unfocusedIndicatorLineThickness;
    L23:
        boolean r16 = r6;
        return r5.m2788copygv0btCI(r16, r15, r0, r1, r2, r3, r12);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final boolean component2() {
        return this.isError;
    }

    public final InteractionSource component3() {
        return this.interactionSource;
    }

    public final TextFieldColors component4() {
        return this.colors;
    }

    public final Shape component5() {
        return this.textFieldShape;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name */
    public final float m2786component6D9Ej5fM() {
        return this.focusedIndicatorLineThickness;
    }

    /* JADX INFO: renamed from: component7-D9Ej5fM, reason: not valid java name */
    public final float m2787component7D9Ej5fM() {
        return this.unfocusedIndicatorLineThickness;
    }

    /* JADX INFO: renamed from: copy-gv0btCI, reason: not valid java name */
    public final IndicatorLineElement m2788copygv0btCI(boolean r11, boolean r12, InteractionSource r13, TextFieldColors r14, Shape r15, float r16, float r17) {
        return new IndicatorLineElement(r11, r12, r13, r14, r15, r16, r17, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IndicatorLineElement) == true) goto L8;
        return false;
    L8:
        IndicatorLineElement r6 = (IndicatorLineElement) r5;
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (this.isError == r6.isError) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.colors, r6.colors) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textFieldShape, r6.textFieldShape) == true) goto L24;
        return false;
    L24:
        if (Dp.equals-impl0(this.focusedIndicatorLineThickness, r6.focusedIndicatorLineThickness) == true) goto L27;
        return false;
    L27:
        if (Dp.equals-impl0(this.unfocusedIndicatorLineThickness, r6.unfocusedIndicatorLineThickness) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enabled == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isError == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (((r2 + r1) * 31) + this.interactionSource.hashCode()) * 31;
        TextFieldColors r4 = this.colors;
        int r5 = 0;
        if (r4 != null) goto L13;
        int r6 = 0;
    L14:
        int r7 = (r3 + r6) * 31;
        Shape r8 = this.textFieldShape;
        if (r8 == null) goto L19;
        r5 = r8.hashCode();
    L19:
        return ((((r7 + r5) * 31) + Dp.hashCode-impl(this.focusedIndicatorLineThickness)) * 31) + Dp.hashCode-impl(this.unfocusedIndicatorLineThickness);
    L13:
        r6 = r4.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "IndicatorLineElement(enabled=" + this.enabled + ", isError=" + this.isError + ", interactionSource=" + this.interactionSource + ", colors=" + this.colors + ", textFieldShape=" + this.textFieldShape + ", focusedIndicatorLineThickness=" + Dp.toString-impl(this.focusedIndicatorLineThickness) + ", unfocusedIndicatorLineThickness=" + Dp.toString-impl(this.unfocusedIndicatorLineThickness) + ')';
    }

    public IndicatorLineNode create() {
        return new IndicatorLineNode(this.enabled, this.isError, this.interactionSource, this.colors, this.textFieldShape, this.focusedIndicatorLineThickness, this.unfocusedIndicatorLineThickness, null);
    }

    public final TextFieldColors getColors() {
        return this.colors;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: getFocusedIndicatorLineThickness-D9Ej5fM, reason: not valid java name */
    public final float m2789getFocusedIndicatorLineThicknessD9Ej5fM() {
        return this.focusedIndicatorLineThickness;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final Shape getTextFieldShape() {
        return this.textFieldShape;
    }

    /* JADX INFO: renamed from: getUnfocusedIndicatorLineThickness-D9Ej5fM, reason: not valid java name */
    public final float m2790getUnfocusedIndicatorLineThicknessD9Ej5fM() {
        return this.unfocusedIndicatorLineThickness;
    }

    public final boolean isError() {
        return this.isError;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m2791create() {
        return create();
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("indicatorLine");
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("isError", Boolean.valueOf(this.isError));
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("colors", this.colors);
        r4.getProperties().set("textFieldShape", this.textFieldShape);
        r4.getProperties().set("focusedIndicatorLineThickness", Dp.box-impl(this.focusedIndicatorLineThickness));
        r4.getProperties().set("unfocusedIndicatorLineThickness", Dp.box-impl(this.unfocusedIndicatorLineThickness));
    }

    public void update(IndicatorLineNode r9) {
        r9.m2792updategv0btCI(this.enabled, this.isError, this.interactionSource, this.colors, this.textFieldShape, this.focusedIndicatorLineThickness, this.unfocusedIndicatorLineThickness);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((IndicatorLineNode) r1);
    }

    private IndicatorLineElement(boolean r1, boolean r2, InteractionSource r3, TextFieldColors r4, Shape r5, float r6, float r7) {
        this.enabled = r1;
        this.isError = r2;
        this.interactionSource = r3;
        this.colors = r4;
        this.textFieldShape = r5;
        this.focusedIndicatorLineThickness = r6;
        this.unfocusedIndicatorLineThickness = r7;
    }
}
