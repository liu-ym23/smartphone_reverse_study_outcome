package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000e¨\u0006$"}, d2 = {"Landroidx/compose/material3/DefaultDrawerItemsColor;", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedContainerColor", "unselectedContainerColor", "selectedBadgeColor", "unselectedBadgeColor", "<init>", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedIconColor-0d7_KjU", "()J", "J", "getUnselectedIconColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "getSelectedContainerColor-0d7_KjU", "getUnselectedContainerColor-0d7_KjU", "getSelectedBadgeColor-0d7_KjU", "getUnselectedBadgeColor-0d7_KjU", "iconColor", "Landroidx/compose/runtime/State;", "selected", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor", "containerColor", "badgeColor", "equals", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultDrawerItemsColor implements NavigationDrawerItemColors {
    private final long selectedBadgeColor;
    private final long selectedContainerColor;
    private final long selectedIconColor;
    private final long selectedTextColor;
    private final long unselectedBadgeColor;
    private final long unselectedContainerColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ DefaultDrawerItemsColor(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, DefaultConstructorMarker r17) {
        this(r1, r3, r5, r7, r9, r11, r13, r15);
    }

    public int hashCode() {
        return (((((((((((((Color.hashCode-impl(this.selectedIconColor) * 31) + Color.hashCode-impl(this.unselectedIconColor)) * 31) + Color.hashCode-impl(this.selectedTextColor)) * 31) + Color.hashCode-impl(this.unselectedTextColor)) * 31) + Color.hashCode-impl(this.selectedContainerColor)) * 31) + Color.hashCode-impl(this.unselectedContainerColor)) * 31) + Color.hashCode-impl(this.selectedBadgeColor)) * 31) + Color.hashCode-impl(this.unselectedBadgeColor);
    }

    /* JADX INFO: renamed from: getSelectedBadgeColor-0d7_KjU, reason: not valid java name */
    public final long m2610getSelectedBadgeColor0d7_KjU() {
        return this.selectedBadgeColor;
    }

    /* JADX INFO: renamed from: getSelectedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2611getSelectedContainerColor0d7_KjU() {
        return this.selectedContainerColor;
    }

    /* JADX INFO: renamed from: getSelectedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2612getSelectedIconColor0d7_KjU() {
        return this.selectedIconColor;
    }

    /* JADX INFO: renamed from: getSelectedTextColor-0d7_KjU, reason: not valid java name */
    public final long m2613getSelectedTextColor0d7_KjU() {
        return this.selectedTextColor;
    }

    /* JADX INFO: renamed from: getUnselectedBadgeColor-0d7_KjU, reason: not valid java name */
    public final long m2614getUnselectedBadgeColor0d7_KjU() {
        return this.unselectedBadgeColor;
    }

    /* JADX INFO: renamed from: getUnselectedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2615getUnselectedContainerColor0d7_KjU() {
        return this.unselectedContainerColor;
    }

    /* JADX INFO: renamed from: getUnselectedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2616getUnselectedIconColor0d7_KjU() {
        return this.unselectedIconColor;
    }

    /* JADX INFO: renamed from: getUnselectedTextColor-0d7_KjU, reason: not valid java name */
    public final long m2617getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if ((r7 instanceof DefaultDrawerItemsColor) == true) goto L8;
        return false;
    L8:
        DefaultDrawerItemsColor r8 = (DefaultDrawerItemsColor) r7;
        if (Color.equals-impl0(this.selectedIconColor, r8.selectedIconColor) == true) goto L12;
        return false;
    L12:
        if (Color.equals-impl0(this.unselectedIconColor, r8.unselectedIconColor) == true) goto L15;
        return false;
    L15:
        if (Color.equals-impl0(this.selectedTextColor, r8.selectedTextColor) == true) goto L18;
        return false;
    L18:
        if (Color.equals-impl0(this.unselectedTextColor, r8.unselectedTextColor) == true) goto L21;
        return false;
    L21:
        if (Color.equals-impl0(this.selectedContainerColor, r8.selectedContainerColor) == true) goto L24;
        return false;
    L24:
        if (Color.equals-impl0(this.unselectedContainerColor, r8.unselectedContainerColor) == true) goto L27;
        return false;
    L27:
        if (Color.equals-impl0(this.selectedBadgeColor, r8.selectedBadgeColor) == true) goto L30;
        return false;
    L30:
        return Color.equals-impl0(this.unselectedBadgeColor, r8.unselectedBadgeColor);
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State<Color> badgeColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(-561675044);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-561675044, r6, -1, "androidx.compose.material3.DefaultDrawerItemsColor.badgeColor (NavigationDrawer.kt:1249)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.selectedBadgeColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.unselectedBadgeColor;
        goto L8
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State<Color> containerColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(-433512770);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-433512770, r6, -1, "androidx.compose.material3.DefaultDrawerItemsColor.containerColor (NavigationDrawer.kt:1242)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.selectedContainerColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.unselectedContainerColor;
        goto L8
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State<Color> iconColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(1141354218);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1141354218, r6, -1, "androidx.compose.material3.DefaultDrawerItemsColor.iconColor (NavigationDrawer.kt:1232)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.selectedIconColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.unselectedIconColor;
        goto L8
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State<Color> textColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(1275109558);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1275109558, r6, -1, "androidx.compose.material3.DefaultDrawerItemsColor.textColor (NavigationDrawer.kt:1237)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.selectedTextColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.unselectedTextColor;
        goto L8
    }

    private DefaultDrawerItemsColor(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18) {
        this.selectedIconColor = r4;
        this.unselectedIconColor = r6;
        this.selectedTextColor = r8;
        this.unselectedTextColor = r10;
        this.selectedContainerColor = r12;
        this.unselectedContainerColor = r14;
        this.selectedBadgeColor = r16;
        this.unselectedBadgeColor = r18;
    }
}
