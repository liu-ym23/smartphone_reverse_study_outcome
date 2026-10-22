package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/relax/relaxframework/ListWrapperVisibleCellsDict;", "", "id", "", "position", "", "top", "bottom", "left", "right", "(Ljava/lang/String;IIIII)V", "getBottom", "()I", "setBottom", "(I)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getLeft", "setLeft", "getPosition", "setPosition", "getRight", "setRight", "getTop", "setTop", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListWrapperVisibleCellsDict {
    private int bottom;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f404779id;
    private int left;
    private int position;
    private int right;
    private int top;

    public final int getBottom() {
        return this.bottom;
    }

    public final String getId() {
        return this.f404779id;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final void setBottom(int r100) {
        this.bottom = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f404779id = r100;
    }

    public final void setLeft(int r100) {
        this.left = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setRight(int r100) {
        this.right = r100;
    }

    public final void setTop(int r100) {
        this.top = r100;
    }

    public ListWrapperVisibleCellsDict(String r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f404779id = r100;
        this.position = r101;
        this.top = r102;
        this.bottom = r103;
        this.left = r104;
        this.right = r105;
    }
}
