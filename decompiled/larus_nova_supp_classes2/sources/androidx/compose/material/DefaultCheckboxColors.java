package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0019J#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0019R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001b"}, d2 = {"Landroidx/compose/material/DefaultCheckboxColors;", "Landroidx/compose/material/CheckboxColors;", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledIndeterminateBorderColor", "<init>", "(JJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "checkmarkColor", "Landroidx/compose/runtime/State;", "state", "Landroidx/compose/ui/state/ToggleableState;", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "enabled", "", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "borderColor", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultCheckboxColors implements CheckboxColors {
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ToggleableState.values().length];
            r0[ToggleableState.On.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ToggleableState.Indeterminate.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ToggleableState.Off.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public /* synthetic */ DefaultCheckboxColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, DefaultConstructorMarker r23) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21);
    }

    @Override // androidx.compose.material.CheckboxColors
    public State<Color> checkmarkColor(ToggleableState r11, Composer r12, int r13) {
        r12.startReplaceGroup(544656267);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(544656267, r13, -1, "androidx.compose.material.DefaultCheckboxColors.checkmarkColor (Checkbox.kt:405)");
    L5:
        ToggleableState r14 = ToggleableState.Off;
        if (r11 != r14) goto L8;
        long r0 = this.uncheckedCheckmarkColor;
    L9:
        long r2 = r0;
        if (r11 != r14) goto L12;
        int r15 = 100;
    L13:
        State<Color> r16 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r2, AnimationSpecKt.tween$default(r15, 0, null, 6, null), null, null, r12, 0, 12);
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        r12.endReplaceGroup();
        return r16;
    L12:
        r15 = 50;
        goto L13
    L8:
        r0 = this.checkedCheckmarkColor;
        goto L9
    }

    @Override // androidx.compose.material.CheckboxColors
    public State<Color> borderColor(boolean r11, ToggleableState r12, Composer r13, int r14) {
        r13.startReplaceGroup(-1568341342);
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-1568341342, r14, -1, "androidx.compose.material.DefaultCheckboxColors.borderColor (Checkbox.kt:445)");
    L6:
        if (r11 == false) goto L15;
        int r2 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L13;
        long r0 = this.uncheckedBorderColor;
    L24:
        long r3 = r0;
        if (r11 == false) goto L31;
        r13.startReplaceGroup(-1801872468);
        if (r12 != ToggleableState.Off) goto L29;
        int r15 = 100;
    L30:
        State<Color> r16 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r3, AnimationSpecKt.tween$default(r15, 0, null, 6, null), null, null, r13, 0, 12);
        r13.endReplaceGroup();
    L33:
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
    L35:
        r13.endReplaceGroup();
        return r16;
    L29:
        r15 = 50;
        goto L30
    L31:
        r13.startReplaceGroup(-1801691924);
        r16 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r3), r13, 0);
        r13.endReplaceGroup();
        goto L33
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r0 = this.checkedBorderColor;
        goto L24
    L15:
        int r4 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L22;
        if (r4 == 3) goto L23;
        throw new NoWhenBranchMatchedException();
    L22:
        r0 = this.disabledIndeterminateBorderColor;
    L23:
        r0 = this.disabledBorderColor;
        goto L24
    }

    @Override // androidx.compose.material.CheckboxColors
    public State<Color> boxColor(boolean r11, ToggleableState r12, Composer r13, int r14) {
        r13.startReplaceGroup(840901029);
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(840901029, r14, -1, "androidx.compose.material.DefaultCheckboxColors.boxColor (Checkbox.kt:418)");
    L6:
        if (r11 == false) goto L15;
        int r2 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L13;
        long r0 = this.uncheckedBoxColor;
    L24:
        long r3 = r0;
        if (r11 == false) goto L31;
        r13.startReplaceGroup(-1260861623);
        if (r12 != ToggleableState.Off) goto L29;
        int r15 = 100;
    L30:
        State<Color> r16 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r3, AnimationSpecKt.tween$default(r15, 0, null, 6, null), null, null, r13, 0, 12);
        r13.endReplaceGroup();
    L33:
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
    L35:
        r13.endReplaceGroup();
        return r16;
    L29:
        r15 = 50;
        goto L30
    L31:
        r13.startReplaceGroup(-1260681079);
        r16 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r3), r13, 0);
        r13.endReplaceGroup();
        goto L33
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r0 = this.checkedBoxColor;
        goto L24
    L15:
        int r4 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L22;
        if (r4 != 3) goto L21;
        r0 = this.disabledUncheckedBoxColor;
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r0 = this.disabledIndeterminateBoxColor;
        goto L24
    L23:
        r0 = this.disabledCheckedBoxColor;
        goto L24
    }

    private DefaultCheckboxColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24) {
        this.checkedCheckmarkColor = r4;
        this.uncheckedCheckmarkColor = r6;
        this.checkedBoxColor = r8;
        this.uncheckedBoxColor = r10;
        this.disabledCheckedBoxColor = r12;
        this.disabledUncheckedBoxColor = r14;
        this.disabledIndeterminateBoxColor = r16;
        this.checkedBorderColor = r18;
        this.uncheckedBorderColor = r20;
        this.disabledBorderColor = r22;
        this.disabledIndeterminateBorderColor = r24;
    }
}
