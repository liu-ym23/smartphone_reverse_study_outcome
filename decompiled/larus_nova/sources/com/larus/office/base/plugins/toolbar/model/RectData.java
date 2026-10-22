package com.larus.office.base.plugins.toolbar.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/RectData;", "", "<init>", "()V", "bottom", "", "getBottom", "()Ljava/lang/Float;", "setBottom", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "top", "getTop", "setTop", "equals", "", "other", "hashCode", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RectData {

    @SerializedName("bottom")
    private Float bottom;

    @SerializedName("left")
    private Float left;

    @SerializedName("right")
    private Float right;

    @SerializedName("top")
    private Float top;

    public RectData() {
    }

    public int hashCode() {
        Float r100 = this.bottom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.left;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.right;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.top;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final Float getBottom() {
        return this.bottom;
    }

    public final Float getLeft() {
        return this.left;
    }

    public final Float getRight() {
        return this.right;
    }

    public final Float getTop() {
        return this.top;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RectData) == true) goto L8;
        return false;
    L8:
        RectData r101 = (RectData) r100;
        if (Intrinsics.areEqual(this.bottom, r101.bottom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.left, r101.left) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.top, r101.top) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final void setBottom(Float r100) {
        this.bottom = r100;
    }

    public final void setLeft(Float r100) {
        this.left = r100;
    }

    public final void setRight(Float r100) {
        this.right = r100;
    }

    public final void setTop(Float r100) {
        this.top = r100;
    }
}
