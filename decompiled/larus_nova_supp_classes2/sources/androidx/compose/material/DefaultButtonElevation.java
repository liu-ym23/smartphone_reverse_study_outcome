package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0011R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/DefaultButtonElevation;", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "disabledElevation", "hoveredElevation", "focusedElevation", "<init>", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultButtonElevation implements ButtonElevation {
    private final float defaultElevation;
    private final float disabledElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ DefaultButtonElevation(float r1, float r2, float r3, float r4, float r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ float access$getFocusedElevation$p(DefaultButtonElevation r0) {
        return r0.focusedElevation;
    }

    public static final /* synthetic */ float access$getHoveredElevation$p(DefaultButtonElevation r0) {
        return r0.hoveredElevation;
    }

    public static final /* synthetic */ float access$getPressedElevation$p(DefaultButtonElevation r0) {
        return r0.pressedElevation;
    }

    @Override // androidx.compose.material.ButtonElevation
    public State<Dp> elevation(boolean r19, InteractionSource r20, Composer r21, int r22) {
        r21.startReplaceGroup(-1588756907);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1588756907, r22, -1, "androidx.compose.material.DefaultButtonElevation.elevation (Button.kt:500)");
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
        r6 = new DefaultButtonElevation$elevation$1$1(r20, r3, null);
        r21.updateRememberedValue(r6);
    L21:
        EffectsKt.LaunchedEffect(r20, (Function2) r6, r21, (r22 >> 3) & 14);
        Interaction r7 = (Interaction) CollectionsKt.lastOrNull(r3);
        if (r19 == true) goto L26;
        float r0 = this.disabledElevation;
    L24:
        float r8 = r0;
        Object r1 = r21.rememberedValue();
        if (r1 != r4.getEmpty()) goto L38;
        r1 = new Animatable(Dp.box-impl(r8), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
        r21.updateRememberedValue(r1);
    L38:
        Animatable r11 = (Animatable) r1;
        Dp r12 = Dp.box-impl(r8);
        boolean r10 = r21.changedInstance(r11) | r21.changed(r8);
        if (((r22 & 14) ^ 6) <= 4) goto L43;
        if (r21.changed(r19) == false) goto L43;
    L44:
        boolean r13 = true;
    L46:
        boolean r14 = r10 | r13;
        if (((r22 & 896) ^ 384) <= 256) goto L51;
        if (r21.changed(this) == false) goto L51;
    L54:
        boolean r15 = (r14 | r9) | r21.changedInstance(r7);
        Object r16 = r21.rememberedValue();
        if (r15 == false) goto L57;
    L58:
        DefaultButtonElevation$elevation$2$1 r17 = new DefaultButtonElevation$elevation$2$1(r11, r8, r19, this, r7, null);
        r21.updateRememberedValue(r17);
        r16 = r17;
    L59:
        EffectsKt.LaunchedEffect(r12, (Function2) r16, r21, 0);
        State<Dp> r18 = r11.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
    L62:
        r21.endReplaceGroup();
        return r18;
    L57:
        if (r16 != r4.getEmpty()) goto L59;
    L51:
        if ((r22 & 384) == 256) goto L54;
        r9 = false;
    L43:
        if ((r22 & 6) == 4) goto L44;
        r13 = false;
        goto L46
    L26:
        if ((r7 instanceof PressInteraction.Press) == false) goto L29;
        r0 = this.pressedElevation;
        goto L24
    L29:
        if ((r7 instanceof HoverInteraction.Enter) == false) goto L32;
        r0 = this.hoveredElevation;
        goto L24
    L32:
        if ((r7 instanceof FocusInteraction.Focus) == false) goto L34;
        r0 = this.focusedElevation;
        goto L24
    L34:
        r0 = this.defaultElevation;
        goto L24
    L19:
        if (r6 != r4.getEmpty()) goto L21;
    L13:
        if ((r22 & 48) == 32) goto L14;
        r5 = false;
        goto L16
    }

    private DefaultButtonElevation(float r1, float r2, float r3, float r4, float r5) {
        this.defaultElevation = r1;
        this.pressedElevation = r2;
        this.disabledElevation = r3;
        this.hoveredElevation = r4;
        this.focusedElevation = r5;
    }
}
