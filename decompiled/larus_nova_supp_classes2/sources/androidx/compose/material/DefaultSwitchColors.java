package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0013J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/material/DefaultSwitchColors;", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "uncheckedThumbColor", "uncheckedTrackColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "<init>", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "thumbColor", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "equals", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultSwitchColors implements SwitchColors {
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ DefaultSwitchColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, DefaultConstructorMarker r17) {
        this(r1, r3, r5, r7, r9, r11, r13, r15);
    }

    public int hashCode() {
        return (((((((((((((Color.hashCode-impl(this.checkedThumbColor) * 31) + Color.hashCode-impl(this.checkedTrackColor)) * 31) + Color.hashCode-impl(this.uncheckedThumbColor)) * 31) + Color.hashCode-impl(this.uncheckedTrackColor)) * 31) + Color.hashCode-impl(this.disabledCheckedThumbColor)) * 31) + Color.hashCode-impl(this.disabledCheckedTrackColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedThumbColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedTrackColor);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L35:
        return false;
    L8:
        if (DefaultSwitchColors.class != r7.getClass()) goto L35;
        DefaultSwitchColors r8 = (DefaultSwitchColors) r7;
        if (Color.equals-impl0(this.checkedThumbColor, r8.checkedThumbColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.checkedTrackColor, r8.checkedTrackColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.uncheckedThumbColor, r8.uncheckedThumbColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.uncheckedTrackColor, r8.uncheckedTrackColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.disabledCheckedThumbColor, r8.disabledCheckedThumbColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledCheckedTrackColor, r8.disabledCheckedTrackColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.disabledUncheckedThumbColor, r8.disabledUncheckedThumbColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.disabledUncheckedTrackColor, r8.disabledUncheckedTrackColor) == true) goto L34;
        return false;
    L34:
        return true;
    }

    @Override // androidx.compose.material.SwitchColors
    public State<Color> thumbColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(-66424183);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-66424183, r7, -1, "androidx.compose.material.DefaultSwitchColors.thumbColor (Switch.kt:367)");
    L5:
        if (r4 == false) goto L9;
        if (r5 == false) goto L8;
        long r8 = this.checkedThumbColor;
    L12:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        r6.endReplaceGroup();
        return r9;
    L8:
        r8 = this.uncheckedThumbColor;
        goto L12
    L9:
        if (r5 == false) goto L11;
        r8 = this.disabledCheckedThumbColor;
        goto L12
    L11:
        r8 = this.disabledUncheckedThumbColor;
        goto L12
    }

    @Override // androidx.compose.material.SwitchColors
    public State<Color> trackColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(-1176343362);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1176343362, r7, -1, "androidx.compose.material.DefaultSwitchColors.trackColor (Switch.kt:378)");
    L5:
        if (r4 == false) goto L9;
        if (r5 == false) goto L8;
        long r8 = this.checkedTrackColor;
    L12:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        r6.endReplaceGroup();
        return r9;
    L8:
        r8 = this.uncheckedTrackColor;
        goto L12
    L9:
        if (r5 == false) goto L11;
        r8 = this.disabledCheckedTrackColor;
        goto L12
    L11:
        r8 = this.disabledUncheckedTrackColor;
        goto L12
    }

    private DefaultSwitchColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18) {
        this.checkedThumbColor = r4;
        this.checkedTrackColor = r6;
        this.uncheckedThumbColor = r8;
        this.uncheckedTrackColor = r10;
        this.disabledCheckedThumbColor = r12;
        this.disabledCheckedTrackColor = r14;
        this.disabledUncheckedThumbColor = r16;
        this.disabledUncheckedTrackColor = r18;
    }
}
