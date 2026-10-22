package com.ss.android.lark.chameleon.basewebview.interfaces;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/interfaces/LarkWebViewMenuItem;", "", "titleId", "", "id", "order", "groupId", "(IIII)V", "getGroupId", "()I", "setGroupId", "(I)V", "getId", "setId", "getOrder", "setOrder", "getTitleId", "setTitleId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LarkWebViewMenuItem {
    private int groupId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f411080id;
    private int order;
    private int titleId;

    public static /* synthetic */ LarkWebViewMenuItem copy$default(LarkWebViewMenuItem r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.titleId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f411080id;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.order;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.groupId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.titleId;
    }

    public final int component2() {
        return this.f411080id;
    }

    public final int component3() {
        return this.order;
    }

    public final int component4() {
        return this.groupId;
    }

    public final LarkWebViewMenuItem copy(int r100, int r101, int r102, int r103) {
        return new LarkWebViewMenuItem(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkWebViewMenuItem) == true) goto L8;
        return false;
    L8:
        LarkWebViewMenuItem r101 = (LarkWebViewMenuItem) r100;
        if (this.titleId == r101.titleId) goto L12;
        return false;
    L12:
        if (this.f411080id == r101.f411080id) goto L15;
        return false;
    L15:
        if (this.order == r101.order) goto L18;
        return false;
    L18:
        if (this.groupId == r101.groupId) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.titleId * 31) + this.f411080id) * 31) + this.order) * 31) + this.groupId;
    }

    public String toString() {
        return "LarkWebViewMenuItem(titleId=" + this.titleId + ", id=" + this.f411080id + ", order=" + this.order + ", groupId=" + this.groupId + ')';
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.f411080id;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getTitleId() {
        return this.titleId;
    }

    public final void setGroupId(int r100) {
        this.groupId = r100;
    }

    public final void setId(int r100) {
        this.f411080id = r100;
    }

    public final void setOrder(int r100) {
        this.order = r100;
    }

    public final void setTitleId(int r100) {
        this.titleId = r100;
    }

    public LarkWebViewMenuItem(int r100, int r101, int r102, int r103) {
        this.titleId = r100;
        this.f411080id = r101;
        this.order = r102;
        this.groupId = r103;
    }
}
