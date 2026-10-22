package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/relax/relaxframework/ListItemInfo;", "", "height", "", "width", "itemKey", "", "isBinding", "", "originX", "originY", "updated", "(DDLjava/lang/String;ZDDZ)V", "getHeight", "()D", "setHeight", "(D)V", "()Z", "setBinding", "(Z)V", "getItemKey", "()Ljava/lang/String;", "setItemKey", "(Ljava/lang/String;)V", "getOriginX", "setOriginX", "getOriginY", "setOriginY", "getUpdated", "setUpdated", "getWidth", "setWidth", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListItemInfo {
    private double height;
    private boolean isBinding;
    private String itemKey;
    private double originX;
    private double originY;
    private boolean updated;
    private double width;

    public final double getHeight() {
        return this.height;
    }

    public final String getItemKey() {
        return this.itemKey;
    }

    public final double getOriginX() {
        return this.originX;
    }

    public final double getOriginY() {
        return this.originY;
    }

    public final boolean getUpdated() {
        return this.updated;
    }

    public final double getWidth() {
        return this.width;
    }

    public final boolean isBinding() {
        return this.isBinding;
    }

    public final void setBinding(boolean r100) {
        this.isBinding = r100;
    }

    public final void setHeight(double r100) {
        this.height = r100;
    }

    public final void setItemKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemKey = r100;
    }

    public final void setOriginX(double r100) {
        this.originX = r100;
    }

    public final void setOriginY(double r100) {
        this.originY = r100;
    }

    public final void setUpdated(boolean r100) {
        this.updated = r100;
    }

    public final void setWidth(double r100) {
        this.width = r100;
    }

    public ListItemInfo(double r100, double r101, String r102, boolean r103, double r104, double r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r102, "itemKey");
        this.height = r100;
        this.width = r101;
        this.itemKey = r102;
        this.isBinding = r103;
        this.originX = r104;
        this.originY = r110;
        this.updated = r111;
    }
}
