package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\f¨\u0006 ²\u0006\f\u0010!\u001a\u0004\u0018\u00010\"X\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/material3/ChipElevation;", "", "elevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "<init>", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getElevation-D9Ej5fM", "()F", "F", "getPressedElevation-D9Ej5fM", "getFocusedElevation-D9Ej5fM", "getHoveredElevation-D9Ej5fM", "getDraggedElevation-D9Ej5fM", "getDisabledElevation-D9Ej5fM", "shadowElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "shadowElevation$material3", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateElevation", "equals", "other", "hashCode", "", "material3", "lastInteraction", "Landroidx/compose/foundation/interaction/Interaction;"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChipElevation {
    public static final int $stable = 0;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float elevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ ChipElevation(float r1, float r2, float r3, float r4, float r5, float r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    public int hashCode() {
        return (((((((Dp.hashCode-impl(this.elevation) * 31) + Dp.hashCode-impl(this.pressedElevation)) * 31) + Dp.hashCode-impl(this.focusedElevation)) * 31) + Dp.hashCode-impl(this.hoveredElevation)) * 31) + Dp.hashCode-impl(this.disabledElevation);
    }

    /* JADX INFO: renamed from: getDisabledElevation-D9Ej5fM, reason: not valid java name */
    public final float m2409getDisabledElevationD9Ej5fM() {
        return this.disabledElevation;
    }

    /* JADX INFO: renamed from: getDraggedElevation-D9Ej5fM, reason: not valid java name */
    public final float m2410getDraggedElevationD9Ej5fM() {
        return this.draggedElevation;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2411getElevationD9Ej5fM() {
        return this.elevation;
    }

    /* JADX INFO: renamed from: getFocusedElevation-D9Ej5fM, reason: not valid java name */
    public final float m2412getFocusedElevationD9Ej5fM() {
        return this.focusedElevation;
    }

    /* JADX INFO: renamed from: getHoveredElevation-D9Ej5fM, reason: not valid java name */
    public final float m2413getHoveredElevationD9Ej5fM() {
        return this.hoveredElevation;
    }

    /* JADX INFO: renamed from: getPressedElevation-D9Ej5fM, reason: not valid java name */
    public final float m2414getPressedElevationD9Ej5fM() {
        return this.pressedElevation;
    }

    public static final /* synthetic */ Interaction access$animateElevation$lambda$2(MutableState r0) {
        return animateElevation$lambda$2(r0);
    }

    private static final Interaction animateElevation$lambda$2(MutableState<Interaction> r0) {
        return (Interaction) r0.getValue();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L26:
        return false;
    L8:
        if ((r5 instanceof ChipElevation) == false) goto L26;
        ChipElevation r6 = (ChipElevation) r5;
        if (Dp.equals-impl0(this.elevation, r6.elevation) == true) goto L14;
        return false;
    L14:
        if (Dp.equals-impl0(this.pressedElevation, r6.pressedElevation) == true) goto L17;
        return false;
    L17:
        if (Dp.equals-impl0(this.focusedElevation, r6.focusedElevation) == true) goto L20;
        return false;
    L20:
        if (Dp.equals-impl0(this.hoveredElevation, r6.hoveredElevation) == true) goto L23;
        return false;
    L23:
        if (Dp.equals-impl0(this.disabledElevation, r6.disabledElevation) == true) goto L25;
        return false;
    L25:
        return true;
    }

    public static final /* synthetic */ void access$animateElevation$lambda$3(MutableState r0, Interaction r1) {
        animateElevation$lambda$3(r0, r1);
    }

    private static final void animateElevation$lambda$3(MutableState<Interaction> r0, Interaction r1) {
        r0.setValue(r1);
    }

    private final State<Dp> animateElevation(boolean r21, InteractionSource r22, Composer r23, int r24) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2071499570, r24, -1, "androidx.compose.material3.ChipElevation.animateElevation (Chip.kt:2361)");
    L5:
        Object r3 = r23.rememberedValue();
        Composer.Companion r5 = Composer.Companion;
        if (r3 != r5.getEmpty()) goto L8;
        r3 = SnapshotStateKt.mutableStateListOf();
        r23.updateRememberedValue(r3);
    L8:
        SnapshotStateList r4 = (SnapshotStateList) r3;
        Object r6 = r23.rememberedValue();
        if (r6 != r5.getEmpty()) goto L11;
        r6 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r23.updateRememberedValue(r6);
    L11:
        MutableState r7 = (MutableState) r6;
        boolean r10 = true;
        if (((r24 & 112) ^ 48) <= 32) goto L16;
        if (r23.changed(r22) == false) goto L16;
    L17:
        boolean r8 = true;
    L19:
        Object r11 = r23.rememberedValue();
        if (r8 == false) goto L22;
    L23:
        r11 = new ChipElevation$animateElevation$1$1(r22, r4, null);
        r23.updateRememberedValue(r11);
    L24:
        EffectsKt.LaunchedEffect(r22, (Function2) r11, r23, (r24 >> 3) & 14);
        Interaction r9 = (Interaction) CollectionsKt.lastOrNull(r4);
        if (r21 == true) goto L29;
        float r1 = this.disabledElevation;
    L27:
        float r12 = r1;
        Object r2 = r23.rememberedValue();
        if (r2 != r5.getEmpty()) goto L44;
        r2 = new Animatable(Dp.box-impl(r12), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
        r23.updateRememberedValue(r2);
    L44:
        Animatable r13 = (Animatable) r2;
        Dp r14 = Dp.box-impl(r12);
        boolean r15 = r23.changedInstance(r13) | r23.changed(r12);
        if (((r24 & 14) ^ 6) <= 4) goto L49;
        if (r23.changed(r21) == false) goto L49;
    L52:
        boolean r16 = (r15 | r10) | r23.changedInstance(r9);
        Object r17 = r23.rememberedValue();
        if (r16 == false) goto L55;
    L56:
        ChipElevation$animateElevation$2$1 r18 = new ChipElevation$animateElevation$2$1(r13, r12, r21, r9, r7, null);
        r23.updateRememberedValue(r18);
        r17 = r18;
    L57:
        EffectsKt.LaunchedEffect(r14, (Function2) r17, r23, 0);
        State<Dp> r19 = r13.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventEnd();
    L60:
        return r19;
    L55:
        if (r17 != r5.getEmpty()) goto L57;
    L49:
        if ((r24 & 6) == 4) goto L52;
        r10 = false;
        goto L52
    L29:
        if ((r9 instanceof PressInteraction.Press) == false) goto L32;
        r1 = this.pressedElevation;
        goto L27
    L32:
        if ((r9 instanceof HoverInteraction.Enter) == false) goto L35;
        r1 = this.hoveredElevation;
        goto L27
    L35:
        if ((r9 instanceof FocusInteraction.Focus) == false) goto L38;
        r1 = this.focusedElevation;
        goto L27
    L38:
        if ((r9 instanceof DragInteraction.Start) == false) goto L40;
        r1 = this.draggedElevation;
        goto L27
    L40:
        r1 = this.elevation;
        goto L27
    L22:
        if (r11 != r5.getEmpty()) goto L24;
    L16:
        if ((r24 & 48) == 32) goto L17;
        r8 = false;
        goto L19
    }

    public final State<Dp> shadowElevation$material3(boolean r4, InteractionSource r5, Composer r6, int r7) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1881877139, r7, -1, "androidx.compose.material3.ChipElevation.shadowElevation (Chip.kt:2353)");
    L5:
        int r0 = (r7 & 14) | (r7 & 112);
        State<Dp> r8 = animateElevation(r4, r5, r6, (r7 & 896) | r0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r8;
    }

    private ChipElevation(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.elevation = r1;
        this.pressedElevation = r2;
        this.focusedElevation = r3;
        this.hoveredElevation = r4;
        this.draggedElevation = r5;
        this.disabledElevation = r6;
    }
}
