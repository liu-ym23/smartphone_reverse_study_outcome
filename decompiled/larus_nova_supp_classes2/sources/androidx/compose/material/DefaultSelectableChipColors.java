package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0013J#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0013J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/compose/material/DefaultSelectableChipColors;", "Landroidx/compose/material/SelectableChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "<init>", "(JJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultSelectableChipColors implements SelectableChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconColor;
    private final long leadingIconColor;
    private final long selectedBackgroundColor;
    private final long selectedContentColor;
    private final long selectedLeadingIconColor;

    public /* synthetic */ DefaultSelectableChipColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, DefaultConstructorMarker r19) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17);
    }

    public int hashCode() {
        return (((((((((((((((Color.hashCode-impl(this.backgroundColor) * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.leadingIconColor)) * 31) + Color.hashCode-impl(this.disabledBackgroundColor)) * 31) + Color.hashCode-impl(this.disabledContentColor)) * 31) + Color.hashCode-impl(this.disabledLeadingIconColor)) * 31) + Color.hashCode-impl(this.selectedBackgroundColor)) * 31) + Color.hashCode-impl(this.selectedContentColor)) * 31) + Color.hashCode-impl(this.selectedLeadingIconColor);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L38:
        return false;
    L8:
        if (DefaultSelectableChipColors.class != r7.getClass()) goto L38;
        DefaultSelectableChipColors r8 = (DefaultSelectableChipColors) r7;
        if (Color.equals-impl0(this.backgroundColor, r8.backgroundColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.contentColor, r8.contentColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.leadingIconColor, r8.leadingIconColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.disabledBackgroundColor, r8.disabledBackgroundColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.disabledContentColor, r8.disabledContentColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledLeadingIconColor, r8.disabledLeadingIconColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.selectedBackgroundColor, r8.selectedBackgroundColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.selectedContentColor, r8.selectedContentColor) == true) goto L35;
        return false;
    L35:
        if (Color.equals-impl0(this.selectedLeadingIconColor, r8.selectedLeadingIconColor) == true) goto L37;
        return false;
    L37:
        return true;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> backgroundColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(-403836585);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-403836585, r7, -1, "androidx.compose.material.DefaultSelectableChipColors.backgroundColor (Chip.kt:636)");
    L5:
        if (r4 == true) goto L7;
        long r8 = this.disabledBackgroundColor;
    L10:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r6.endReplaceGroup();
        return r9;
    L7:
        if (r5 == true) goto L9;
        r8 = this.backgroundColor;
        goto L10
    L9:
        r8 = this.selectedBackgroundColor;
        goto L10
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> contentColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(2025240134);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(2025240134, r7, -1, "androidx.compose.material.DefaultSelectableChipColors.contentColor (Chip.kt:647)");
    L5:
        if (r4 == true) goto L7;
        long r8 = this.disabledContentColor;
    L10:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r6.endReplaceGroup();
        return r9;
    L7:
        if (r5 == true) goto L9;
        r8 = this.contentColor;
        goto L10
    L9:
        r8 = this.selectedContentColor;
        goto L10
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> leadingIconColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(189838188);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(189838188, r7, -1, "androidx.compose.material.DefaultSelectableChipColors.leadingIconColor (Chip.kt:658)");
    L5:
        if (r4 == true) goto L7;
        long r8 = this.disabledLeadingIconColor;
    L10:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r6.endReplaceGroup();
        return r9;
    L7:
        if (r5 == true) goto L9;
        r8 = this.leadingIconColor;
        goto L10
    L9:
        r8 = this.selectedLeadingIconColor;
        goto L10
    }

    private DefaultSelectableChipColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20) {
        this.backgroundColor = r4;
        this.contentColor = r6;
        this.leadingIconColor = r8;
        this.disabledBackgroundColor = r10;
        this.disabledContentColor = r12;
        this.disabledLeadingIconColor = r14;
        this.selectedBackgroundColor = r16;
        this.selectedContentColor = r18;
        this.selectedLeadingIconColor = r20;
    }
}
