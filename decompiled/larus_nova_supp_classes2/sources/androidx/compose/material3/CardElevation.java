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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/CardElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "<init>", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "shadowElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "shadowElevation$material3", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateElevation", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CardElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ CardElevation(float r1, float r2, float r3, float r4, float r5, float r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    public int hashCode() {
        return (((((((Dp.hashCode-impl(this.defaultElevation) * 31) + Dp.hashCode-impl(this.pressedElevation)) * 31) + Dp.hashCode-impl(this.focusedElevation)) * 31) + Dp.hashCode-impl(this.hoveredElevation)) * 31) + Dp.hashCode-impl(this.disabledElevation);
    }

    public static final /* synthetic */ float access$getDraggedElevation$p(CardElevation r0) {
        return r0.draggedElevation;
    }

    public static final /* synthetic */ float access$getFocusedElevation$p(CardElevation r0) {
        return r0.focusedElevation;
    }

    public static final /* synthetic */ float access$getHoveredElevation$p(CardElevation r0) {
        return r0.hoveredElevation;
    }

    public static final /* synthetic */ float access$getPressedElevation$p(CardElevation r0) {
        return r0.pressedElevation;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L26:
        return false;
    L8:
        if ((r5 instanceof CardElevation) == false) goto L26;
        CardElevation r6 = (CardElevation) r5;
        if (Dp.equals-impl0(this.defaultElevation, r6.defaultElevation) == true) goto L14;
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

    private final State<Dp> animateElevation(boolean r19, InteractionSource r20, Composer r21, int r22) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1421890746, r22, -1, "androidx.compose.material3.CardElevation.animateElevation (Card.kt:666)");
    L5:
        Object r2 = r21.rememberedValue();
        Composer.Companion r4 = Composer.Companion;
        if (r2 != r4.getEmpty()) goto L8;
        r2 = SnapshotStateKt.mutableStateListOf();
        r21.updateRememberedValue(r2);
    L8:
        SnapshotStateList r3 = (SnapshotStateList) r2;
        boolean r9 = true;
        if (((r22 & 112) ^ 48) <= 32) goto L13;
        if (r21.changed(r20) == false) goto L13;
    L14:
        boolean r5 = true;
    L16:
        Object r6 = r21.rememberedValue();
        if (r5 == false) goto L19;
    L20:
        r6 = new CardElevation$animateElevation$1$1(r20, r3, null);
        r21.updateRememberedValue(r6);
    L21:
        EffectsKt.LaunchedEffect(r20, (Function2) r6, r21, (r22 >> 3) & 14);
        Interaction r7 = (Interaction) CollectionsKt.lastOrNull(r3);
        if (r19 == true) goto L26;
        float r0 = this.disabledElevation;
    L24:
        float r8 = r0;
        Object r1 = r21.rememberedValue();
        if (r1 != r4.getEmpty()) goto L41;
        r1 = new Animatable(Dp.box-impl(r8), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
        r21.updateRememberedValue(r1);
    L41:
        Animatable r11 = (Animatable) r1;
        Dp r12 = Dp.box-impl(r8);
        boolean r10 = r21.changedInstance(r11) | r21.changed(r8);
        if (((r22 & 14) ^ 6) <= 4) goto L46;
        if (r21.changed(r19) == false) goto L46;
    L47:
        boolean r13 = true;
    L49:
        boolean r14 = r10 | r13;
        if (((r22 & 896) ^ 384) <= 256) goto L54;
        if (r21.changed(this) == false) goto L54;
    L57:
        boolean r15 = (r14 | r9) | r21.changedInstance(r7);
        Object r16 = r21.rememberedValue();
        if (r15 == false) goto L60;
    L61:
        CardElevation$animateElevation$2$1 r17 = new CardElevation$animateElevation$2$1(r11, r8, r19, this, r7, null);
        r21.updateRememberedValue(r17);
        r16 = r17;
    L62:
        EffectsKt.LaunchedEffect(r12, (Function2) r16, r21, 0);
        State<Dp> r18 = r11.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventEnd();
    L65:
        return r18;
    L60:
        if (r16 != r4.getEmpty()) goto L62;
    L54:
        if ((r22 & 384) == 256) goto L57;
        r9 = false;
    L46:
        if ((r22 & 6) == 4) goto L47;
        r13 = false;
        goto L49
    L26:
        if ((r7 instanceof PressInteraction.Press) == false) goto L29;
        r0 = this.pressedElevation;
        goto L24
    L29:
        if ((r7 instanceof HoverInteraction.Enter) == false) goto L32;
        r0 = this.hoveredElevation;
        goto L24
    L32:
        if ((r7 instanceof FocusInteraction.Focus) == false) goto L35;
        r0 = this.focusedElevation;
        goto L24
    L35:
        if ((r7 instanceof DragInteraction.Start) == false) goto L37;
        r0 = this.draggedElevation;
        goto L24
    L37:
        r0 = this.defaultElevation;
        goto L24
    L19:
        if (r6 != r4.getEmpty()) goto L21;
    L13:
        if ((r22 & 48) == 32) goto L14;
        r5 = false;
        goto L16
    }

    public final State<Dp> shadowElevation$material3(boolean r4, InteractionSource r5, Composer r6, int r7) {
        r6.startReplaceGroup(-1763481333);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1763481333, r7, -1, "androidx.compose.material3.CardElevation.shadowElevation (Card.kt:655)");
    L5:
        if (r5 != null) goto L14;
        r6.startReplaceGroup(167751211);
        Object r8 = r6.rememberedValue();
        if (r8 != Composer.Companion.getEmpty()) goto L9;
        r8 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(this.defaultElevation), null, 2, null);
        r6.updateRememberedValue(r8);
    L9:
        MutableState r9 = (MutableState) r8;
        r6.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        r6.endReplaceGroup();
        return r9;
    L14:
        r6.startReplaceGroup(167824247);
        r6.endReplaceGroup();
        int r0 = (r7 & 14) | (r7 & 112);
        State<Dp> r10 = animateElevation(r4, r5, r6, (r7 & 896) | r0);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        r6.endReplaceGroup();
        return r10;
    }

    private CardElevation(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.defaultElevation = r1;
        this.pressedElevation = r2;
        this.focusedElevation = r3;
        this.hoveredElevation = r4;
        this.draggedElevation = r5;
        this.disabledElevation = r6;
    }
}
