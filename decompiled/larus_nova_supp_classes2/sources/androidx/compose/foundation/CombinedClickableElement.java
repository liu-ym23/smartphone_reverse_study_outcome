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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u007f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\f\u0010\u001a\u001a\u00020\u0010*\u00020\u001bH\u0016J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/foundation/CombinedClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/CombinedClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CombinedClickableElement extends ModifierNodeElement<CombinedClickableNode> {
    private final boolean enabled;
    private final boolean hapticFeedbackEnabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Function0<Unit> onDoubleClick;
    private final Function0<Unit> onLongClick;
    private final String onLongClickLabel;
    private final Role role;
    private final boolean useLocalIndication;

    public /* synthetic */ CombinedClickableElement(MutableInteractionSource r1, IndicationNodeFactory r2, boolean r3, boolean r4, String r5, Role r6, Function0 r7, String r8, Function0 r9, Function0 r10, boolean r11, DefaultConstructorMarker r12) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public CombinedClickableNode create() {
        return new CombinedClickableNode(this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, this.hapticFeedbackEnabled, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.onClickLabel, this.role, null);
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
        if (this.enabled == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        String r12 = this.onClickLabel;
        if (r12 == null) goto L21;
        int r13 = r12.hashCode();
    L22:
        int r14 = (r11 + r13) * 31;
        Role r15 = this.role;
        if (r15 == null) goto L25;
        int r16 = Role.hashCode-impl(r15.unbox-impl());
    L26:
        int r17 = (((r14 + r16) * 31) + this.onClick.hashCode()) * 31;
        String r18 = this.onLongClickLabel;
        if (r18 == null) goto L29;
        int r19 = r18.hashCode();
    L30:
        int r20 = (r17 + r19) * 31;
        Function0<Unit> r21 = this.onLongClick;
        if (r21 == null) goto L33;
        int r22 = r21.hashCode();
    L34:
        int r23 = (r20 + r22) * 31;
        Function0<Unit> r24 = this.onDoubleClick;
        if (r24 == null) goto L37;
        r1 = r24.hashCode();
    L37:
        int r25 = (r23 + r1) * 31;
        if (this.hapticFeedbackEnabled == true) goto L42;
        r7 = 1237;
    L42:
        return r25 + r7;
    L33:
        r22 = 0;
        goto L34
    L29:
        r19 = 0;
        goto L30
    L25:
        r16 = 0;
        goto L26
    L21:
        r13 = 0;
        goto L22
    L17:
        r10 = 1237;
        goto L18
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
    public /* bridge */ /* synthetic */ Modifier.Node m396create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (CombinedClickableElement.class == r5.getClass()) goto L11;
        return false;
    L11:
        CombinedClickableElement r6 = (CombinedClickableElement) r5;
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
        if (this.onClick == r6.onClick) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.onLongClickLabel, r6.onLongClickLabel) == true) goto L36;
        return false;
    L36:
        if (this.onLongClick == r6.onLongClick) goto L39;
        return false;
    L39:
        if (this.onDoubleClick == r6.onDoubleClick) goto L42;
        return false;
    L42:
        if (this.hapticFeedbackEnabled == r6.hapticFeedbackEnabled) goto L44;
        return false;
    L44:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("combinedClickable");
        r4.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("onClickLabel", this.onClickLabel);
        r4.getProperties().set("role", this.role);
        r4.getProperties().set("onClick", this.onClick);
        r4.getProperties().set("onDoubleClick", this.onDoubleClick);
        r4.getProperties().set("onLongClick", this.onLongClick);
        r4.getProperties().set("onLongClickLabel", this.onLongClickLabel);
        r4.getProperties().set("hapticFeedbackEnabled", Boolean.valueOf(this.hapticFeedbackEnabled));
    }

    public void update(CombinedClickableNode r13) {
        r13.setHapticFeedbackEnabled(this.hapticFeedbackEnabled);
        r13.m397update2tQrsxU(this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.onClickLabel, this.role);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((CombinedClickableNode) r1);
    }

    private CombinedClickableElement(MutableInteractionSource r1, IndicationNodeFactory r2, boolean r3, boolean r4, String r5, Role r6, Function0<Unit> r7, String r8, Function0<Unit> r9, Function0<Unit> r10, boolean r11) {
        this.interactionSource = r1;
        this.indicationNodeFactory = r2;
        this.useLocalIndication = r3;
        this.enabled = r4;
        this.onClickLabel = r5;
        this.role = r6;
        this.onClick = r7;
        this.onLongClickLabel = r8;
        this.onLongClick = r9;
        this.onDoubleClick = r10;
        this.hapticFeedbackEnabled = r11;
    }
}
