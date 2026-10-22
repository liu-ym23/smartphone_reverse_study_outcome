package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017¢\u0006\u0002\u0010\u0013J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0017¢\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0017¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/DefaultSliderColors;", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "<init>", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "active", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tickColor", "equals", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultSliderColors implements SliderColors {
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ DefaultSliderColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, DefaultConstructorMarker r21) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19);
    }

    public int hashCode() {
        return (((((((((((((((((Color.hashCode-impl(this.thumbColor) * 31) + Color.hashCode-impl(this.disabledThumbColor)) * 31) + Color.hashCode-impl(this.activeTrackColor)) * 31) + Color.hashCode-impl(this.inactiveTrackColor)) * 31) + Color.hashCode-impl(this.disabledActiveTrackColor)) * 31) + Color.hashCode-impl(this.disabledInactiveTrackColor)) * 31) + Color.hashCode-impl(this.activeTickColor)) * 31) + Color.hashCode-impl(this.inactiveTickColor)) * 31) + Color.hashCode-impl(this.disabledActiveTickColor)) * 31) + Color.hashCode-impl(this.disabledInactiveTickColor);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L41:
        return false;
    L8:
        if (DefaultSliderColors.class != r7.getClass()) goto L41;
        DefaultSliderColors r8 = (DefaultSliderColors) r7;
        if (Color.equals-impl0(this.thumbColor, r8.thumbColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.disabledThumbColor, r8.disabledThumbColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.activeTrackColor, r8.activeTrackColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.inactiveTrackColor, r8.inactiveTrackColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.disabledActiveTrackColor, r8.disabledActiveTrackColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledInactiveTrackColor, r8.disabledInactiveTrackColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.activeTickColor, r8.activeTickColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.inactiveTickColor, r8.inactiveTickColor) == true) goto L35;
        return false;
    L35:
        if (Color.equals-impl0(this.disabledActiveTickColor, r8.disabledActiveTickColor) == true) goto L38;
        return false;
    L38:
        if (Color.equals-impl0(this.disabledInactiveTickColor, r8.disabledInactiveTickColor) == true) goto L40;
        return false;
    L40:
        return true;
    }

    @Override // androidx.compose.material.SliderColors
    public State<Color> thumbColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(-1733795637);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1733795637, r6, -1, "androidx.compose.material.DefaultSliderColors.thumbColor (Slider.kt:1186)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.thumbColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.disabledThumbColor;
        goto L8
    }

    @Override // androidx.compose.material.SliderColors
    public State<Color> tickColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(-1491563694);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1491563694, r7, -1, "androidx.compose.material.DefaultSliderColors.tickColor (Slider.kt:1202)");
    L5:
        if (r4 == false) goto L9;
        if (r5 == false) goto L8;
        long r8 = this.activeTickColor;
    L12:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        r6.endReplaceGroup();
        return r9;
    L8:
        r8 = this.inactiveTickColor;
        goto L12
    L9:
        if (r5 == false) goto L11;
        r8 = this.disabledActiveTickColor;
        goto L12
    L11:
        r8 = this.disabledInactiveTickColor;
        goto L12
    }

    @Override // androidx.compose.material.SliderColors
    public State<Color> trackColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(1575395620);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1575395620, r7, -1, "androidx.compose.material.DefaultSliderColors.trackColor (Slider.kt:1191)");
    L5:
        if (r4 == false) goto L9;
        if (r5 == false) goto L8;
        long r8 = this.activeTrackColor;
    L12:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        r6.endReplaceGroup();
        return r9;
    L8:
        r8 = this.inactiveTrackColor;
        goto L12
    L9:
        if (r5 == false) goto L11;
        r8 = this.disabledActiveTrackColor;
        goto L12
    L11:
        r8 = this.disabledInactiveTrackColor;
        goto L12
    }

    private DefaultSliderColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22) {
        this.thumbColor = r4;
        this.disabledThumbColor = r6;
        this.activeTrackColor = r8;
        this.inactiveTrackColor = r10;
        this.disabledActiveTrackColor = r12;
        this.disabledInactiveTrackColor = r14;
        this.activeTickColor = r16;
        this.inactiveTickColor = r18;
        this.disabledActiveTickColor = r20;
        this.disabledInactiveTickColor = r22;
    }
}
