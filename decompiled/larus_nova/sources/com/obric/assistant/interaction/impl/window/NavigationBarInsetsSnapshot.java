package com.obric.assistant.interaction.impl.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;", "", "left", "", "top", "right", "bottom", "visible", "", "source", "", "<init>", "(IIIIZLjava/lang/String;)V", "getLeft", "()I", "getTop", "getRight", "getBottom", "getVisible", "()Z", "getSource", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavigationBarInsetsSnapshot {
    private final int bottom;
    private final int left;
    private final int right;
    private final String source;
    private final int top;
    private final boolean visible;

    public NavigationBarInsetsSnapshot() {
        this(0, 0, 0, 0, false, null, 63, null);
    }

    public static /* synthetic */ NavigationBarInsetsSnapshot copy$default(NavigationBarInsetsSnapshot r100, int r101, int r102, int r103, int r104, boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.left;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.top;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.right;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.bottom;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.visible;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.source;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.top;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.bottom;
    }

    public final boolean component5() {
        return this.visible;
    }

    public final String component6() {
        return this.source;
    }

    public final NavigationBarInsetsSnapshot copy(int r100, int r110, int r111, int r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r114, "source");
        return new NavigationBarInsetsSnapshot(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NavigationBarInsetsSnapshot) == true) goto L8;
        return false;
    L8:
        NavigationBarInsetsSnapshot r101 = (NavigationBarInsetsSnapshot) r100;
        if (this.left == r101.left) goto L12;
        return false;
    L12:
        if (this.top == r101.top) goto L15;
        return false;
    L15:
        if (this.right == r101.right) goto L18;
        return false;
    L18:
        if (this.bottom == r101.bottom) goto L21;
        return false;
    L21:
        if (this.visible == r101.visible) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom) * 31;
        if (this.visible == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.source.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "NavigationBarInsetsSnapshot(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", visible=" + this.visible + ", source=" + this.source + ')';
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final String getSource() {
        return this.source;
    }

    public final int getTop() {
        return this.top;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public NavigationBarInsetsSnapshot(int r100, int r101, int r102, int r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r105, "source");
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
        this.visible = r104;
        this.source = r105;
    }

    public /* synthetic */ NavigationBarInsetsSnapshot(int r100, int r101, int r102, int r103, boolean r104, String r110, int r111, DefaultConstructorMarker r112) {
        boolean r105 = false;
        if ((r111 & 1) == 0) goto L5;
        int r113 = 0;
    L7:
        if ((r111 & 2) == 0) goto L9;
        int r106 = 0;
    L11:
        if ((r111 & 4) == 0) goto L13;
        int r107 = 0;
    L15:
        if ((r111 & 8) == 0) goto L17;
        int r108 = 0;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = "";
    L25:
        String r114 = r110;
        this(r113, r106, r107, r108, r105, r114);
        return;
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
