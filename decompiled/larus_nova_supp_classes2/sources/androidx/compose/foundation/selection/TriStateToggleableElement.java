package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0010*\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/selection/TriStateToggleableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/selection/TriStateToggleableNode;", "state", "Landroidx/compose/ui/state/ToggleableState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TriStateToggleableElement extends ModifierNodeElement<TriStateToggleableNode> {
    private final boolean enabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final Role role;
    private final ToggleableState state;
    private final boolean useLocalIndication;

    public /* synthetic */ TriStateToggleableElement(ToggleableState r1, MutableInteractionSource r2, IndicationNodeFactory r3, boolean r4, boolean r5, Role r6, Function0 r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    public TriStateToggleableNode create() {
        return new TriStateToggleableNode(this.state, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.role, this.onClick, null);
    }

    public int hashCode() {
        int r0 = this.state.hashCode() * 31;
        MutableInteractionSource r1 = this.interactionSource;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        IndicationNodeFactory r5 = this.indicationNodeFactory;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        int r8 = 1231;
        if (this.useLocalIndication == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.enabled == true) goto L18;
        r8 = 1237;
    L18:
        int r11 = (r10 + r8) * 31;
        Role r12 = this.role;
        if (r12 == null) goto L22;
        r2 = Role.hashCode-impl(r12.unbox-impl());
    L22:
        return ((r11 + r2) * 31) + this.onClick.hashCode();
    L13:
        r9 = 1237;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m1310create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (TriStateToggleableElement.class == r5.getClass()) goto L11;
        return false;
    L11:
        TriStateToggleableElement r6 = (TriStateToggleableElement) r5;
        if (this.state == r6.state) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.indicationNodeFactory, r6.indicationNodeFactory) == true) goto L21;
        return false;
    L21:
        if (this.useLocalIndication == r6.useLocalIndication) goto L24;
        return false;
    L24:
        if (this.enabled == r6.enabled) goto L27;
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
        r4.setName("triStateToggleable");
        r4.getProperties().set("state", this.state);
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("role", this.role);
        r4.getProperties().set("onClick", this.onClick);
    }

    public void update(TriStateToggleableNode r9) {
        r9.m1311updateO2vRcR0(this.state, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.role, this.onClick);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((TriStateToggleableNode) r1);
    }

    private TriStateToggleableElement(ToggleableState r1, MutableInteractionSource r2, IndicationNodeFactory r3, boolean r4, boolean r5, Role r6, Function0<Unit> r7) {
        this.state = r1;
        this.interactionSource = r2;
        this.indicationNodeFactory = r3;
        this.useLocalIndication = r4;
        this.enabled = r5;
        this.role = r6;
        this.onClick = r7;
    }
}
