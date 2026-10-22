package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "shadowElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "shadowElevation$material3", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tonalElevation", "tonalElevation-D9Ej5fM$material3", "()F", "animateElevation", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class FloatingActionButtonElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ FloatingActionButtonElevation(float r1, float r2, float r3, float r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public int hashCode() {
        return (((((Dp.hashCode-impl(this.defaultElevation) * 31) + Dp.hashCode-impl(this.pressedElevation)) * 31) + Dp.hashCode-impl(this.focusedElevation)) * 31) + Dp.hashCode-impl(this.hoveredElevation);
    }

    /* JADX INFO: renamed from: tonalElevation-D9Ej5fM$material3, reason: not valid java name */
    public final float m2723tonalElevationD9Ej5fM$material3() {
        return this.defaultElevation;
    }

    public static final /* synthetic */ float access$getDefaultElevation$p(FloatingActionButtonElevation r0) {
        return r0.defaultElevation;
    }

    public static final /* synthetic */ float access$getFocusedElevation$p(FloatingActionButtonElevation r0) {
        return r0.focusedElevation;
    }

    public static final /* synthetic */ float access$getHoveredElevation$p(FloatingActionButtonElevation r0) {
        return r0.hoveredElevation;
    }

    public static final /* synthetic */ float access$getPressedElevation$p(FloatingActionButtonElevation r0) {
        return r0.pressedElevation;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L21:
        return false;
    L8:
        if ((r4 instanceof FloatingActionButtonElevation) == false) goto L21;
        FloatingActionButtonElevation r5 = (FloatingActionButtonElevation) r4;
        if (Dp.equals-impl0(this.defaultElevation, r5.defaultElevation) == true) goto L14;
        return false;
    L14:
        if (Dp.equals-impl0(this.pressedElevation, r5.pressedElevation) == true) goto L17;
        return false;
    L17:
        if (Dp.equals-impl0(this.focusedElevation, r5.focusedElevation) == true) goto L20;
        return false;
    L20:
        return Dp.equals-impl0(this.hoveredElevation, r5.hoveredElevation);
    }

    private final State<Dp> animateElevation(InteractionSource r18, Composer r19, int r20) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1845106002, r20, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:628)");
    L5:
        int r4 = r20 & 14;
        int r5 = r4 ^ 6;
        boolean r6 = false;
        if (r5 <= 4) goto L10;
        if (r19.changed(r18) == false) goto L10;
    L11:
        boolean r9 = true;
    L13:
        Object r10 = r19.rememberedValue();
        if (r9 == false) goto L16;
    L17:
        r10 = new FloatingActionButtonElevationAnimatable(this.defaultElevation, this.pressedElevation, this.hoveredElevation, this.focusedElevation, null);
        r19.updateRememberedValue(r10);
    L18:
        FloatingActionButtonElevationAnimatable r11 = (FloatingActionButtonElevationAnimatable) r10;
        boolean r12 = r19.changedInstance(r11);
        if (((r20 & 112) ^ 48) <= 32) goto L23;
        if (r19.changed(this) == false) goto L23;
    L24:
        boolean r13 = true;
    L26:
        boolean r14 = r12 | r13;
        Object r15 = r19.rememberedValue();
        if (r14 == false) goto L29;
    L30:
        r15 = new FloatingActionButtonElevation$animateElevation$1$1(r11, this, null);
        r19.updateRememberedValue(r15);
    L31:
        EffectsKt.LaunchedEffect(this, (Function2) r15, r19, (r20 >> 3) & 14);
        if (r5 <= 4) goto L36;
        if (r19.changed(r18) == false) goto L36;
    L37:
        r6 = true;
    L38:
        boolean r3 = r19.changedInstance(r11) | r6;
        Object r7 = r19.rememberedValue();
        if (r3 == false) goto L41;
    L42:
        r7 = new FloatingActionButtonElevation$animateElevation$2$1(r18, r11, null);
        r19.updateRememberedValue(r7);
    L43:
        EffectsKt.LaunchedEffect(r18, (Function2) r7, r19, r4);
        State<Dp> r1 = r11.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
    L46:
        return r1;
    L41:
        if (r7 != Composer.Companion.getEmpty()) goto L43;
    L36:
        if ((r20 & 6) != 4) goto L38;
    L29:
        if (r15 != Composer.Companion.getEmpty()) goto L31;
    L23:
        if ((r20 & 48) == 32) goto L24;
        r13 = false;
        goto L26
    L16:
        if (r10 != Composer.Companion.getEmpty()) goto L18;
    L10:
        if ((r20 & 6) == 4) goto L11;
        r9 = false;
        goto L13
    }

    public final State<Dp> shadowElevation$material3(InteractionSource r4, Composer r5, int r6) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-424810125, r6, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:619)");
    L5:
        int r0 = r6 & 14;
        State<Dp> r7 = animateElevation(r4, r5, (r6 & 112) | r0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r7;
    }

    private FloatingActionButtonElevation(float r1, float r2, float r3, float r4) {
        this.defaultElevation = r1;
        this.pressedElevation = r2;
        this.focusedElevation = r3;
        this.hoveredElevation = r4;
    }
}
