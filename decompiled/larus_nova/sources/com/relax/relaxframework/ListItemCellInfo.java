package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rR\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Lcom/relax/relaxframework/ListItemCellInfo;", "", "id", "", "itemKey", "", "index", "position", "left", "", "top", "right", "bottom", "(ILjava/lang/String;IIDDDD)V", "getBottom", "()D", "setBottom", "(D)V", "getId", "()I", "setId", "(I)V", "getIndex", "setIndex", "getItemKey", "()Ljava/lang/String;", "setItemKey", "(Ljava/lang/String;)V", "getLeft", "setLeft", "getPosition", "setPosition", "getRight", "setRight", "getTop", "setTop", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListItemCellInfo {
    private double bottom;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f404772id;
    private int index;
    private String itemKey;
    private double left;
    private int position;
    private double right;
    private double top;

    public final double getBottom() {
        return this.bottom;
    }

    public final int getId() {
        return this.f404772id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getItemKey() {
        return this.itemKey;
    }

    public final double getLeft() {
        return this.left;
    }

    public final int getPosition() {
        return this.position;
    }

    public final double getRight() {
        return this.right;
    }

    public final double getTop() {
        return this.top;
    }

    public final void setBottom(double r100) {
        this.bottom = r100;
    }

    public final void setId(int r100) {
        this.f404772id = r100;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setItemKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemKey = r100;
    }

    public final void setLeft(double r100) {
        this.left = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setRight(double r100) {
        this.right = r100;
    }

    public final void setTop(double r100) {
        this.top = r100;
    }

    public ListItemCellInfo(int r100, String r101, int r102, int r103, double r104, double r105, double r110, double r111) {
        Intrinsics.checkNotNullParameter(r101, "itemKey");
        this.f404772id = r100;
        this.itemKey = r101;
        this.index = r102;
        this.position = r103;
        this.left = r104;
        this.top = r105;
        this.right = r110;
        this.bottom = r111;
    }
}
