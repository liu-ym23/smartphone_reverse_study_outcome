package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/DefaultChipColors;", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultChipColors implements ChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconContentColor;
    private final long leadingIconContentColor;

    public /* synthetic */ DefaultChipColors(long r1, long r3, long r5, long r7, long r9, long r11, DefaultConstructorMarker r13) {
        this(r1, r3, r5, r7, r9, r11);
    }

    public int hashCode() {
        return (((((((((Color.hashCode-impl(this.backgroundColor) * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.leadingIconContentColor)) * 31) + Color.hashCode-impl(this.disabledBackgroundColor)) * 31) + Color.hashCode-impl(this.disabledContentColor)) * 31) + Color.hashCode-impl(this.disabledLeadingIconContentColor);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L29:
        return false;
    L8:
        if (DefaultChipColors.class != r7.getClass()) goto L29;
        DefaultChipColors r8 = (DefaultChipColors) r7;
        if (Color.equals-impl0(this.backgroundColor, r8.backgroundColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.contentColor, r8.contentColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.leadingIconContentColor, r8.leadingIconContentColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.disabledBackgroundColor, r8.disabledBackgroundColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.disabledContentColor, r8.disabledContentColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledLeadingIconContentColor, r8.disabledLeadingIconContentColor) == true) goto L28;
        return false;
    L28:
        return true;
    }

    @Override // androidx.compose.material.ChipColors
    public State<Color> backgroundColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(-1593588247);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1593588247, r6, -1, "androidx.compose.material.DefaultChipColors.backgroundColor (Chip.kt:576)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.backgroundColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.disabledBackgroundColor;
        goto L8
    }

    @Override // androidx.compose.material.ChipColors
    public State<Color> contentColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(483145880);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(483145880, r6, -1, "androidx.compose.material.DefaultChipColors.contentColor (Chip.kt:581)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.contentColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.disabledContentColor;
        goto L8
    }

    @Override // androidx.compose.material.ChipColors
    public State<Color> leadingIconContentColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(1955749013);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1955749013, r6, -1, "androidx.compose.material.DefaultChipColors.leadingIconContentColor (Chip.kt:586)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.leadingIconContentColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.disabledLeadingIconContentColor;
        goto L8
    }

    private DefaultChipColors(long r1, long r3, long r5, long r7, long r9, long r11) {
        this.backgroundColor = r1;
        this.contentColor = r3;
        this.leadingIconContentColor = r5;
        this.disabledBackgroundColor = r7;
        this.disabledContentColor = r9;
        this.disabledLeadingIconContentColor = r11;
    }
}
