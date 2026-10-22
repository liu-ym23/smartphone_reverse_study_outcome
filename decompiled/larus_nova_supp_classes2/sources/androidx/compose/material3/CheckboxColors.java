package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0085\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b&\u0010'J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b+\u0010,J%\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b.\u0010,J\u001b\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\u0006\u0010$\u001a\u00020%H\u0003¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00104\u001a\u000205H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00066"}, d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedCheckmarkColor-0d7_KjU", "()J", "J", "getUncheckedCheckmarkColor-0d7_KjU", "getCheckedBoxColor-0d7_KjU", "getUncheckedBoxColor-0d7_KjU", "getDisabledCheckedBoxColor-0d7_KjU", "getDisabledUncheckedBoxColor-0d7_KjU", "getDisabledIndeterminateBoxColor-0d7_KjU", "getCheckedBorderColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getDisabledBorderColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledIndeterminateBorderColor-0d7_KjU", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/CheckboxColors;", "checkmarkColor", "Landroidx/compose/runtime/State;", "state", "Landroidx/compose/ui/state/ToggleableState;", "checkmarkColor$material3", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "enabled", "", "boxColor$material3", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "borderColor", "borderColor$material3", "colorAnimationSpecForState", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/AnimationSpec;", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CheckboxColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBorderColor;
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

    public /* synthetic */ CheckboxColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, DefaultConstructorMarker r25) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.hashCode-impl(this.checkedCheckmarkColor) * 31) + Color.hashCode-impl(this.uncheckedCheckmarkColor)) * 31) + Color.hashCode-impl(this.checkedBoxColor)) * 31) + Color.hashCode-impl(this.uncheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledCheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledIndeterminateBoxColor)) * 31) + Color.hashCode-impl(this.checkedBorderColor)) * 31) + Color.hashCode-impl(this.uncheckedBorderColor)) * 31) + Color.hashCode-impl(this.disabledBorderColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedBorderColor)) * 31) + Color.hashCode-impl(this.disabledIndeterminateBorderColor);
    }

    /* JADX INFO: renamed from: getCheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2379getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* JADX INFO: renamed from: getCheckedBoxColor-0d7_KjU, reason: not valid java name */
    public final long m2380getCheckedBoxColor0d7_KjU() {
        return this.checkedBoxColor;
    }

    /* JADX INFO: renamed from: getCheckedCheckmarkColor-0d7_KjU, reason: not valid java name */
    public final long m2381getCheckedCheckmarkColor0d7_KjU() {
        return this.checkedCheckmarkColor;
    }

    /* JADX INFO: renamed from: getDisabledBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2382getDisabledBorderColor0d7_KjU() {
        return this.disabledBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedBoxColor-0d7_KjU, reason: not valid java name */
    public final long m2383getDisabledCheckedBoxColor0d7_KjU() {
        return this.disabledCheckedBoxColor;
    }

    /* JADX INFO: renamed from: getDisabledIndeterminateBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2384getDisabledIndeterminateBorderColor0d7_KjU() {
        return this.disabledIndeterminateBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledIndeterminateBoxColor-0d7_KjU, reason: not valid java name */
    public final long m2385getDisabledIndeterminateBoxColor0d7_KjU() {
        return this.disabledIndeterminateBoxColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2386getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedBoxColor-0d7_KjU, reason: not valid java name */
    public final long m2387getDisabledUncheckedBoxColor0d7_KjU() {
        return this.disabledUncheckedBoxColor;
    }

    /* JADX INFO: renamed from: getUncheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2388getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* JADX INFO: renamed from: getUncheckedBoxColor-0d7_KjU, reason: not valid java name */
    public final long m2389getUncheckedBoxColor0d7_KjU() {
        return this.uncheckedBoxColor;
    }

    /* JADX INFO: renamed from: getUncheckedCheckmarkColor-0d7_KjU, reason: not valid java name */
    public final long m2390getUncheckedCheckmarkColor0d7_KjU() {
        return this.uncheckedCheckmarkColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L47:
        return false;
    L8:
        if ((r7 instanceof CheckboxColors) == false) goto L47;
        CheckboxColors r8 = (CheckboxColors) r7;
        if (Color.equals-impl0(this.checkedCheckmarkColor, r8.checkedCheckmarkColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.uncheckedCheckmarkColor, r8.uncheckedCheckmarkColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.checkedBoxColor, r8.checkedBoxColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.uncheckedBoxColor, r8.uncheckedBoxColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.disabledCheckedBoxColor, r8.disabledCheckedBoxColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledUncheckedBoxColor, r8.disabledUncheckedBoxColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.disabledIndeterminateBoxColor, r8.disabledIndeterminateBoxColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.checkedBorderColor, r8.checkedBorderColor) == true) goto L35;
        return false;
    L35:
        if (Color.equals-impl0(this.uncheckedBorderColor, r8.uncheckedBorderColor) == true) goto L38;
        return false;
    L38:
        if (Color.equals-impl0(this.disabledBorderColor, r8.disabledBorderColor) == true) goto L41;
        return false;
    L41:
        if (Color.equals-impl0(this.disabledUncheckedBorderColor, r8.disabledUncheckedBorderColor) == true) goto L44;
        return false;
    L44:
        if (Color.equals-impl0(this.disabledIndeterminateBorderColor, r8.disabledIndeterminateBorderColor) == true) goto L46;
        return false;
    L46:
        return true;
    }

    private final AnimationSpec<Color> colorAnimationSpecForState(ToggleableState r4, Composer r5, int r6) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-1075456245, r6, -1, "androidx.compose.material3.CheckboxColors.colorAnimationSpecForState (Checkbox.kt:684)");
    L6:
        if (r4 != ToggleableState.Off) goto L8;
        r5.startReplaceGroup(1539262271);
        FiniteAnimationSpec r7 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r5, 6);
        r5.endReplaceGroup();
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r7;
    L8:
        r5.startReplaceGroup(1539355581);
        r7 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r5, 6);
        r5.endReplaceGroup();
        goto L10
    }

    public final State<Color> checkmarkColor$material3(ToggleableState r11, Composer r12, int r13) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-507585681, r13, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:606)");
    L6:
        if (r11 != ToggleableState.Off) goto L8;
        long r0 = this.uncheckedCheckmarkColor;
    L9:
        long r2 = r0;
        int r1 = r13 & 14;
        State<Color> r14 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r2, colorAnimationSpecForState(r11, r12, (r13 & 112) | r1), null, null, r12, 0, 12);
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r14;
    L8:
        r0 = this.checkedCheckmarkColor;
        goto L9
    }

    public final State<Color> borderColor$material3(boolean r12, ToggleableState r13, Composer r14, int r15) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(1009643462, r15, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:657)");
    L6:
        if (r12 == false) goto L15;
        int r3 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L14;
        if (r3 != 3) goto L13;
        long r0 = this.uncheckedBorderColor;
    L24:
        long r4 = r0;
        if (r12 == false) goto L27;
        r14.startReplaceGroup(633231558);
        int r16 = r15 >> 3;
        int r17 = r16 & 14;
        State<Color> r18 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r4, colorAnimationSpecForState(r13, r14, (r16 & 112) | r17), null, null, r14, 0, 12);
        r14.endReplaceGroup();
    L29:
        if (ComposerKt.isTraceInProgress() == false) goto L31;
        ComposerKt.traceEventEnd();
    L31:
        return r18;
    L27:
        r14.startReplaceGroup(633321768);
        r18 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r4), r14, 0);
        r14.endReplaceGroup();
        goto L29
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r0 = this.checkedBorderColor;
        goto L24
    L15:
        int r5 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L22;
        if (r5 != 3) goto L21;
        r0 = this.disabledUncheckedBorderColor;
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r0 = this.disabledIndeterminateBorderColor;
        goto L24
    L23:
        r0 = this.disabledBorderColor;
        goto L24
    }

    public final State<Color> boxColor$material3(boolean r12, ToggleableState r13, Composer r14, int r15) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(360729865, r15, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:625)");
    L6:
        if (r12 == false) goto L15;
        int r3 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L14;
        if (r3 != 3) goto L13;
        long r0 = this.uncheckedBoxColor;
    L24:
        long r4 = r0;
        if (r12 == false) goto L27;
        r14.startReplaceGroup(496051715);
        int r16 = r15 >> 3;
        int r17 = r16 & 14;
        State<Color> r18 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r4, colorAnimationSpecForState(r13, r14, (r16 & 112) | r17), null, null, r14, 0, 12);
        r14.endReplaceGroup();
    L29:
        if (ComposerKt.isTraceInProgress() == false) goto L31;
        ComposerKt.traceEventEnd();
    L31:
        return r18;
    L27:
        r14.startReplaceGroup(496141925);
        r18 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r4), r14, 0);
        r14.endReplaceGroup();
        goto L29
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r0 = this.checkedBoxColor;
        goto L24
    L15:
        int r5 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L22;
        if (r5 != 3) goto L21;
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

    private CheckboxColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26) {
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
        this.disabledUncheckedBorderColor = r24;
        this.disabledIndeterminateBorderColor = r26;
    }

    /* JADX INFO: renamed from: copy-2qZNXz8, reason: not valid java name */
    public final CheckboxColors m2378copy2qZNXz8(long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56) {
        boolean r1 = true;
        if (r34 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r34;
    L10:
        if (r36 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r36;
    L17:
        if (r38 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r38;
    L24:
        if (r40 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r40;
    L31:
        if (r42 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r42;
    L38:
        if (r44 == 16) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        long r18 = r44;
    L45:
        if (r46 == 16) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L50;
        long r20 = r46;
    L52:
        if (r48 == 16) goto L54;
        boolean r17 = true;
    L55:
        if (r17 == false) goto L57;
        long r22 = r48;
    L59:
        if (r50 == 16) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L64;
        long r24 = r50;
    L66:
        if (r52 == 16) goto L68;
        boolean r21 = true;
    L69:
        if (r21 == false) goto L71;
        long r26 = r52;
    L73:
        if (r54 == 16) goto L75;
        boolean r23 = true;
    L76:
        if (r23 == false) goto L78;
        long r28 = r54;
    L80:
        if (r56 != 16) goto L83;
        r1 = false;
    L83:
        if (r1 == false) goto L85;
        long r30 = r56;
    L87:
        return new CheckboxColors(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, null);
    L85:
        r30 = this.disabledIndeterminateBorderColor;
        goto L87
    L78:
        r28 = this.disabledUncheckedBorderColor;
        goto L80
    L75:
        r23 = false;
        goto L76
    L71:
        r26 = this.disabledBorderColor;
        goto L73
    L68:
        r21 = false;
        goto L69
    L64:
        r24 = this.uncheckedBorderColor;
        goto L66
    L61:
        r19 = false;
        goto L62
    L57:
        r22 = this.checkedBorderColor;
        goto L59
    L54:
        r17 = false;
        goto L55
    L50:
        r20 = this.disabledIndeterminateBoxColor;
        goto L52
    L47:
        r15 = false;
        goto L48
    L43:
        r18 = this.disabledUncheckedBoxColor;
        goto L45
    L40:
        r13 = false;
        goto L41
    L36:
        r16 = this.disabledCheckedBoxColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.uncheckedBoxColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.checkedBoxColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.uncheckedCheckmarkColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.checkedCheckmarkColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ CheckboxColors m2377copy2qZNXz8$default(CheckboxColors r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, int r41, Object r42) {
        if ((r41 & 1) == 0) goto L5;
        long r2 = r16.checkedCheckmarkColor;
    L7:
        if ((r41 & 2) == 0) goto L9;
        long r4 = r16.uncheckedCheckmarkColor;
    L11:
        if ((r41 & 4) == 0) goto L13;
        long r6 = r16.checkedBoxColor;
    L15:
        if ((r41 & 8) == 0) goto L17;
        long r8 = r16.uncheckedBoxColor;
    L19:
        if ((r41 & 16) == 0) goto L21;
        long r10 = r16.disabledCheckedBoxColor;
    L23:
        if ((r41 & 32) == 0) goto L25;
        long r12 = r16.disabledUncheckedBoxColor;
    L27:
        if ((r41 & 64) == 0) goto L29;
        long r14 = r16.disabledIndeterminateBoxColor;
    L30:
        long r210 = r14;
        if ((r41 & 128) == 0) goto L33;
        long r15 = r16.checkedBorderColor;
    L34:
        long r32 = r15;
        if ((r41 & 256) == 0) goto L37;
        long r18 = r16.uncheckedBorderColor;
    L38:
        long r34 = r18;
        if ((r41 & 512) == 0) goto L41;
        long r110 = r16.disabledBorderColor;
    L42:
        long r36 = r110;
        if ((r41 & 1024) == 0) goto L45;
        long r111 = r16.disabledUncheckedBorderColor;
    L46:
        long r38 = r111;
        if ((r41 & 2048) == 0) goto L49;
        long r112 = r16.disabledIndeterminateBorderColor;
    L51:
        return r16.m2378copy2qZNXz8(r2, r4, r6, r8, r10, r12, r210, r32, r34, r36, r38, r112);
    L49:
        r112 = r39;
        goto L51
    L45:
        r111 = r37;
        goto L46
    L41:
        r110 = r35;
        goto L42
    L37:
        r18 = r33;
        goto L38
    L33:
        r15 = r31;
        goto L34
    L29:
        r14 = r29;
        goto L30
    L25:
        r12 = r27;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
