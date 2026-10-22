package com.obric.assistant.interaction.impl.window;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowHostLayoutSpec;", "", "width", "", "height", GXTemplateKey.GAIAX_LAYER_GRAVITY, "x", "y", "isLandscapeWindow", "", "<init>", "(IIIIIZ)V", "getWidth", "()I", "getHeight", "getGravity", "getX", "getY", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHostLayoutSpec {
    private final int gravity;
    private final int height;
    private final boolean isLandscapeWindow;
    private final int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f389734x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f389735y;

    public static /* synthetic */ WindowHostLayoutSpec copy$default(WindowHostLayoutSpec r100, int r101, int r102, int r103, int r104, int r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.height;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.gravity;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.f389734x;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.f389735y;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.isLandscapeWindow;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.gravity;
    }

    public final int component4() {
        return this.f389734x;
    }

    public final int component5() {
        return this.f389735y;
    }

    public final boolean component6() {
        return this.isLandscapeWindow;
    }

    public final WindowHostLayoutSpec copy(int r100, int r110, int r111, int r112, int r113, boolean r114) {
        return new WindowHostLayoutSpec(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WindowHostLayoutSpec) == true) goto L8;
        return false;
    L8:
        WindowHostLayoutSpec r101 = (WindowHostLayoutSpec) r100;
        if (this.width == r101.width) goto L12;
        return false;
    L12:
        if (this.height == r101.height) goto L15;
        return false;
    L15:
        if (this.gravity == r101.gravity) goto L18;
        return false;
    L18:
        if (this.f389734x == r101.f389734x) goto L21;
        return false;
    L21:
        if (this.f389735y == r101.f389735y) goto L24;
        return false;
    L24:
        if (this.isLandscapeWindow == r101.isLandscapeWindow) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.width * 31) + this.height) * 31) + this.gravity) * 31) + this.f389734x) * 31) + this.f389735y) * 31;
        if (this.isLandscapeWindow == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "WindowHostLayoutSpec(width=" + this.width + ", height=" + this.height + ", gravity=" + this.gravity + ", x=" + this.f389734x + ", y=" + this.f389735y + ", isLandscapeWindow=" + this.isLandscapeWindow + ')';
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.f389734x;
    }

    public final int getY() {
        return this.f389735y;
    }

    public final boolean isLandscapeWindow() {
        return this.isLandscapeWindow;
    }

    public WindowHostLayoutSpec(int r100, int r101, int r102, int r103, int r104, boolean r105) {
        this.width = r100;
        this.height = r101;
        this.gravity = r102;
        this.f389734x = r103;
        this.f389735y = r104;
        this.isLandscapeWindow = r105;
    }

    public /* synthetic */ WindowHostLayoutSpec(int r100, int r101, int r110, int r111, int r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        boolean r102 = false;
    L6:
        this(r100, r101, r110, r111, r112, r102);
        return;
    L5:
        r102 = r113;
        goto L6
    }
}
