package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0010*\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/ClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ClickableElement extends ModifierNodeElement<ClickableNode> {
    private final boolean enabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Role role;
    private final boolean useLocalIndication;

    public /* synthetic */ ClickableElement(MutableInteractionSource r1, IndicationNodeFactory r2, boolean r3, boolean r4, String r5, Role r6, Function0 r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    public ClickableNode create() {
        return new ClickableNode(this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.onClickLabel, this.role, this.onClick, null);
    }

    public int hashCode() {
        MutableInteractionSource r0 = this.interactionSource;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        IndicationNodeFactory r4 = this.indicationNodeFactory;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.useLocalIndication == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.enabled == true) goto L18;
        r7 = 1237;
    L18:
        int r10 = (r9 + r7) * 31;
        String r11 = this.onClickLabel;
        if (r11 == null) goto L21;
        int r12 = r11.hashCode();
    L22:
        int r13 = (r10 + r12) * 31;
        Role r14 = this.role;
        if (r14 == null) goto L26;
        r1 = Role.hashCode-impl(r14.unbox-impl());
    L26:
        return ((r13 + r1) * 31) + this.onClick.hashCode();
    L21:
        r12 = 0;
        goto L22
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m371create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ClickableElement.class == r5.getClass()) goto L11;
        return false;
    L11:
        ClickableElement r6 = (ClickableElement) r5;
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.indicationNodeFactory, r6.indicationNodeFactory) == true) goto L18;
        return false;
    L18:
        if (this.useLocalIndication == r6.useLocalIndication) goto L21;
        return false;
    L21:
        if (this.enabled == r6.enabled) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.onClickLabel, r6.onClickLabel) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.role, r6.role) == true) goto L30;
        return false;
    L30:
        if (this.onClick == r6.onClick) goto L32;
        return false;
    L32:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("clickable");
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("onClick", this.onClick);
        r4.getProperties().set("onClickLabel", this.onClickLabel);
        r4.getProperties().set("role", this.role);
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
    }

    public void update(ClickableNode r9) {
        r9.m394updateO2vRcR0(this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.onClickLabel, this.role, this.onClick);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((ClickableNode) r1);
    }

    private ClickableElement(MutableInteractionSource r1, IndicationNodeFactory r2, boolean r3, boolean r4, String r5, Role r6, Function0<Unit> r7) {
        this.interactionSource = r1;
        this.indicationNodeFactory = r2;
        this.useLocalIndication = r3;
        this.enabled = r4;
        this.onClickLabel = r5;
        this.role = r6;
        this.onClick = r7;
    }
}
