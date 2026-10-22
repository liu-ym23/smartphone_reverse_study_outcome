package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/RadioButtonColors;", "", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedColor-0d7_KjU", "()J", "J", "getUnselectedColor-0d7_KjU", "getDisabledSelectedColor-0d7_KjU", "getDisabledUnselectedColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RadioButtonColors;", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "radioColor$material3", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonColors {
    public static final int $stable = 0;
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ RadioButtonColors(long r1, long r3, long r5, long r7, DefaultConstructorMarker r9) {
        this(r1, r3, r5, r7);
    }

    public int hashCode() {
        return (((((Color.hashCode-impl(this.selectedColor) * 31) + Color.hashCode-impl(this.unselectedColor)) * 31) + Color.hashCode-impl(this.disabledSelectedColor)) * 31) + Color.hashCode-impl(this.disabledUnselectedColor);
    }

    /* JADX INFO: renamed from: getDisabledSelectedColor-0d7_KjU, reason: not valid java name */
    public final long m3017getDisabledSelectedColor0d7_KjU() {
        return this.disabledSelectedColor;
    }

    /* JADX INFO: renamed from: getDisabledUnselectedColor-0d7_KjU, reason: not valid java name */
    public final long m3018getDisabledUnselectedColor0d7_KjU() {
        return this.disabledUnselectedColor;
    }

    /* JADX INFO: renamed from: getSelectedColor-0d7_KjU, reason: not valid java name */
    public final long m3019getSelectedColor0d7_KjU() {
        return this.selectedColor;
    }

    /* JADX INFO: renamed from: getUnselectedColor-0d7_KjU, reason: not valid java name */
    public final long m3020getUnselectedColor0d7_KjU() {
        return this.unselectedColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L23:
        return false;
    L8:
        if ((r7 instanceof RadioButtonColors) == false) goto L23;
        RadioButtonColors r8 = (RadioButtonColors) r7;
        if (Color.equals-impl0(this.selectedColor, r8.selectedColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.unselectedColor, r8.unselectedColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.disabledSelectedColor, r8.disabledSelectedColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.disabledUnselectedColor, r8.disabledUnselectedColor) == true) goto L22;
        return false;
    L22:
        return true;
    }

    private RadioButtonColors(long r1, long r3, long r5, long r7) {
        this.selectedColor = r1;
        this.unselectedColor = r3;
        this.disabledSelectedColor = r5;
        this.disabledUnselectedColor = r7;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final RadioButtonColors m3016copyjRlVdoo(long r18, long r20, long r22, long r24) {
        boolean r1 = true;
        if (r18 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r18;
    L10:
        if (r20 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r20;
    L17:
        if (r22 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r22;
    L24:
        if (r24 != 16) goto L27;
        r1 = false;
    L27:
        if (r1 == false) goto L29;
        long r14 = r24;
    L31:
        return new RadioButtonColors(r8, r10, r12, r14, null);
    L29:
        r14 = this.disabledUnselectedColor;
        goto L31
    L22:
        r12 = this.disabledSelectedColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.unselectedColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.selectedColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public final State<Color> radioColor$material3(boolean r11, boolean r12, Composer r13, int r14) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1840145292, r14, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:223)");
    L5:
        if (r11 == false) goto L9;
        if (r12 == false) goto L9;
        long r0 = this.selectedColor;
    L8:
        long r2 = r0;
        if (r11 == false) goto L18;
        r13.startReplaceGroup(1194696477);
        State<Color> r15 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r2, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r13, 6), null, null, r13, 0, 12);
        r13.endReplaceGroup();
    L20:
        if (ComposerKt.isTraceInProgress() == false) goto L22;
        ComposerKt.traceEventEnd();
    L22:
        return r15;
    L18:
        r13.startReplaceGroup(1194874138);
        r15 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r2), r13, 0);
        r13.endReplaceGroup();
    L9:
        if (r11 == false) goto L12;
        if (r12 == true) goto L12;
        r0 = this.unselectedColor;
    L12:
        if (r11 == true) goto L15;
        if (r12 == false) goto L15;
        r0 = this.disabledSelectedColor;
    L15:
        r0 = this.disabledUnselectedColor;
        goto L8
    }

    /* JADX INFO: renamed from: copy-jRlVdoo$default, reason: not valid java name */
    public static /* synthetic */ RadioButtonColors m3015copyjRlVdoo$default(RadioButtonColors r9, long r10, long r12, long r14, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.selectedColor;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r3 = r9.unselectedColor;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r5 = r9.disabledSelectedColor;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r7 = r9.disabledUnselectedColor;
    L19:
        return r9.m3016copyjRlVdoo(r1, r3, r5, r7);
    L17:
        r7 = r16;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
