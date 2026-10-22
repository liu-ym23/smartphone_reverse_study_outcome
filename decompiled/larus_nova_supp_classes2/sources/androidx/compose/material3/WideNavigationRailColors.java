package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/WideNavigationRailColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "modalContainerColor", "modalScrimColor", "modalContentColor", "<init>", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getModalContainerColor-0d7_KjU", "getModalScrimColor-0d7_KjU", "getModalContentColor-0d7_KjU", "copy", "copy-t635Npw", "(JJJJJ)Landroidx/compose/material3/WideNavigationRailColors;", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long contentColor;
    private final long modalContainerColor;
    private final long modalContentColor;
    private final long modalScrimColor;

    public /* synthetic */ WideNavigationRailColors(long r1, long r3, long r5, long r7, long r9, DefaultConstructorMarker r11) {
        this(r1, r3, r5, r7, r9);
    }

    public int hashCode() {
        return (((((((Color.hashCode-impl(this.containerColor) * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.modalContainerColor)) * 31) + Color.hashCode-impl(this.modalScrimColor)) * 31) + Color.hashCode-impl(this.modalContentColor);
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3608getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m3609getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getModalContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3610getModalContainerColor0d7_KjU() {
        return this.modalContainerColor;
    }

    /* JADX INFO: renamed from: getModalContentColor-0d7_KjU, reason: not valid java name */
    public final long m3611getModalContentColor0d7_KjU() {
        return this.modalContentColor;
    }

    /* JADX INFO: renamed from: getModalScrimColor-0d7_KjU, reason: not valid java name */
    public final long m3612getModalScrimColor0d7_KjU() {
        return this.modalScrimColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L23:
        return false;
    L8:
        if ((r7 instanceof WideNavigationRailColors) == false) goto L23;
        WideNavigationRailColors r8 = (WideNavigationRailColors) r7;
        if (Color.equals-impl0(this.containerColor, r8.containerColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.contentColor, r8.contentColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.modalContainerColor, r8.modalContainerColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.modalScrimColor, r8.modalScrimColor) == true) goto L22;
        return false;
    L22:
        return true;
    }

    private WideNavigationRailColors(long r1, long r3, long r5, long r7, long r9) {
        this.containerColor = r1;
        this.contentColor = r3;
        this.modalContainerColor = r5;
        this.modalScrimColor = r7;
        this.modalContentColor = r9;
    }

    /* JADX INFO: renamed from: copy-t635Npw, reason: not valid java name */
    public final WideNavigationRailColors m3607copyt635Npw(long r20, long r22, long r24, long r26, long r28) {
        boolean r1 = true;
        if (r20 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r20;
    L10:
        if (r22 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r22;
    L17:
        if (r24 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r24;
    L24:
        if (r26 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r26;
    L31:
        if (r28 != 16) goto L34;
        r1 = false;
    L34:
        if (r1 == false) goto L36;
        long r16 = r28;
    L38:
        return new WideNavigationRailColors(r8, r10, r12, r14, r16, null);
    L36:
        r16 = this.modalContentColor;
        goto L38
    L29:
        r14 = this.modalScrimColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.modalContainerColor;
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

    /* JADX INFO: renamed from: copy-t635Npw$default, reason: not valid java name */
    public static /* synthetic */ WideNavigationRailColors m3606copyt635Npw$default(WideNavigationRailColors r11, long r12, long r14, long r16, long r18, long r20, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r1 = r11.containerColor;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r3 = r11.contentColor;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r5 = r11.modalContainerColor;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r7 = r11.modalScrimColor;
    L19:
        if ((r22 & 16) == 0) goto L21;
        long r9 = r11.modalContentColor;
    L23:
        return r11.m3607copyt635Npw(r1, r3, r5, r7, r9);
    L21:
        r9 = r20;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
