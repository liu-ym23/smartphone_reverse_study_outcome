package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\f\u0010\u0013\u001a\u00020\u0011*\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÂ\u0003J\u0010\u0010\u0017\u001a\u00020\bHÂ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÂ\u0003J>\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/material3/ClockDialModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ClockDialNode;", "state", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component3-yecRtBI", "()I", "component4", "copy", "copy-JwYzU44", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;)Landroidx/compose/material3/ClockDialModifier;", "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClockDialModifier extends ModifierNodeElement<ClockDialNode> {
    public static final int $stable = 0;
    private final AnimationSpec<Float> animationSpec;
    private final boolean autoSwitchToMinute;
    private final int selection;
    private final AnalogTimePickerState state;

    public /* synthetic */ ClockDialModifier(AnalogTimePickerState r1, boolean r2, int r3, AnimationSpec r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    private final AnalogTimePickerState component1() {
        return this.state;
    }

    private final boolean component2() {
        return this.autoSwitchToMinute;
    }

    /* JADX INFO: renamed from: component3-yecRtBI, reason: not valid java name */
    private final int m2426component3yecRtBI() {
        return this.selection;
    }

    private final AnimationSpec<Float> component4() {
        return this.animationSpec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-JwYzU44$default, reason: not valid java name */
    public static /* synthetic */ ClockDialModifier m2427copyJwYzU44$default(ClockDialModifier r0, AnalogTimePickerState r1, boolean r2, int r3, AnimationSpec r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.autoSwitchToMinute;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.selection;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.animationSpec;
    L15:
        return r0.m2428copyJwYzU44(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: copy-JwYzU44, reason: not valid java name */
    public final ClockDialModifier m2428copyJwYzU44(AnalogTimePickerState r8, boolean r9, int r10, AnimationSpec<Float> r11) {
        return new ClockDialModifier(r8, r9, r10, r11, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClockDialModifier) == true) goto L8;
        return false;
    L8:
        ClockDialModifier r6 = (ClockDialModifier) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L12;
        return false;
    L12:
        if (this.autoSwitchToMinute == r6.autoSwitchToMinute) goto L15;
        return false;
    L15:
        if (TimePickerSelectionMode.m3435equalsimpl0(this.selection, r6.selection) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.animationSpec, r6.animationSpec) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.state.hashCode() * 31;
        if (this.autoSwitchToMinute == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + TimePickerSelectionMode.m3436hashCodeimpl(this.selection)) * 31) + this.animationSpec.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public void inspectableProperties(InspectorInfo r1) {
    }

    public String toString() {
        return "ClockDialModifier(state=" + this.state + ", autoSwitchToMinute=" + this.autoSwitchToMinute + ", selection=" + TimePickerSelectionMode.m3437toStringimpl(this.selection) + ", animationSpec=" + this.animationSpec + ')';
    }

    public ClockDialNode create() {
        return new ClockDialNode(this.state, this.autoSwitchToMinute, this.selection, this.animationSpec, null);
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m2429create() {
        return create();
    }

    public void update(ClockDialNode r5) {
        r5.m2436updateNodeJwYzU44(this.state, this.autoSwitchToMinute, this.selection, this.animationSpec);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((ClockDialNode) r1);
    }

    private ClockDialModifier(AnalogTimePickerState r1, boolean r2, int r3, AnimationSpec<Float> r4) {
        this.state = r1;
        this.autoSwitchToMinute = r2;
        this.selection = r3;
        this.animationSpec = r4;
    }
}
