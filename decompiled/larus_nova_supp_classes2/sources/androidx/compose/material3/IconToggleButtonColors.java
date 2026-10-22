package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJI\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001c\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Landroidx/compose/material3/IconToggleButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "getCheckedContainerColor-0d7_KjU", "getCheckedContentColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/IconToggleButtonColors;", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "containerColor$material3", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IconToggleButtonColors {
    public static final int $stable = 0;
    private final long checkedContainerColor;
    private final long checkedContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ IconToggleButtonColors(long r1, long r3, long r5, long r7, long r9, long r11, DefaultConstructorMarker r13) {
        this(r1, r3, r5, r7, r9, r11);
    }

    public int hashCode() {
        return (((((((((Color.hashCode-impl(this.containerColor) * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.disabledContainerColor)) * 31) + Color.hashCode-impl(this.disabledContentColor)) * 31) + Color.hashCode-impl(this.checkedContainerColor)) * 31) + Color.hashCode-impl(this.checkedContentColor);
    }

    /* JADX INFO: renamed from: getCheckedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2779getCheckedContainerColor0d7_KjU() {
        return this.checkedContainerColor;
    }

    /* JADX INFO: renamed from: getCheckedContentColor-0d7_KjU, reason: not valid java name */
    public final long m2780getCheckedContentColor0d7_KjU() {
        return this.checkedContentColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2781getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m2782getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2783getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledContentColor-0d7_KjU, reason: not valid java name */
    public final long m2784getDisabledContentColor0d7_KjU() {
        return this.disabledContentColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L29:
        return false;
    L8:
        if ((r7 instanceof IconToggleButtonColors) == false) goto L29;
        IconToggleButtonColors r8 = (IconToggleButtonColors) r7;
        if (Color.equals-impl0(this.containerColor, r8.containerColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.contentColor, r8.contentColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.disabledContainerColor, r8.disabledContainerColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.disabledContentColor, r8.disabledContentColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.checkedContainerColor, r8.checkedContainerColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.checkedContentColor, r8.checkedContentColor) == true) goto L28;
        return false;
    L28:
        return true;
    }

    public final State<Color> containerColor$material3(boolean r4, boolean r5, Composer r6, int r7) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1175394478, r7, -1, "androidx.compose.material3.IconToggleButtonColors.containerColor (IconButton.kt:882)");
    L5:
        if (r4 == true) goto L7;
        long r8 = this.disabledContainerColor;
    L10:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r9;
    L7:
        if (r5 == true) goto L9;
        r8 = this.containerColor;
        goto L10
    L9:
        r8 = this.checkedContainerColor;
        goto L10
    }

    public final State<Color> contentColor$material3(boolean r4, boolean r5, Composer r6, int r7) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1340854054, r7, -1, "androidx.compose.material3.IconToggleButtonColors.contentColor (IconButton.kt:899)");
    L5:
        if (r4 == true) goto L7;
        long r8 = this.disabledContentColor;
    L10:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r9;
    L7:
        if (r5 == true) goto L9;
        r8 = this.contentColor;
        goto L10
    L9:
        r8 = this.checkedContentColor;
        goto L10
    }

    private IconToggleButtonColors(long r1, long r3, long r5, long r7, long r9, long r11) {
        this.containerColor = r1;
        this.contentColor = r3;
        this.disabledContainerColor = r5;
        this.disabledContentColor = r7;
        this.checkedContainerColor = r9;
        this.checkedContentColor = r11;
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final IconToggleButtonColors m2778copytNS2XkQ(long r22, long r24, long r26, long r28, long r30, long r32) {
        boolean r1 = true;
        if (r22 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r22;
    L10:
        if (r24 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r24;
    L17:
        if (r26 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r26;
    L24:
        if (r28 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r28;
    L31:
        if (r30 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r30;
    L38:
        if (r32 != 16) goto L41;
        r1 = false;
    L41:
        if (r1 == false) goto L43;
        long r18 = r32;
    L45:
        return new IconToggleButtonColors(r8, r10, r12, r14, r16, r18, null);
    L43:
        r18 = this.checkedContentColor;
        goto L45
    L36:
        r16 = this.checkedContainerColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.disabledContentColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.disabledContainerColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.contentColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.containerColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ$default, reason: not valid java name */
    public static /* synthetic */ IconToggleButtonColors m2777copytNS2XkQ$default(IconToggleButtonColors r13, long r14, long r16, long r18, long r20, long r22, long r24, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        long r1 = r13.containerColor;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r3 = r13.contentColor;
    L11:
        if ((r26 & 4) == 0) goto L13;
        long r5 = r13.disabledContainerColor;
    L15:
        if ((r26 & 8) == 0) goto L17;
        long r7 = r13.disabledContentColor;
    L19:
        if ((r26 & 16) == 0) goto L21;
        long r9 = r13.checkedContainerColor;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r11 = r13.checkedContentColor;
    L27:
        return r13.m2778copytNS2XkQ(r1, r3, r5, r7, r9, r11);
    L25:
        r11 = r24;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
