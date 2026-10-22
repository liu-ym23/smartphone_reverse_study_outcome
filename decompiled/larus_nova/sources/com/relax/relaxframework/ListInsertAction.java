package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/relax/relaxframework/ListInsertAction;", "", "itemKey", "", "position", "", "reuseIdentifier", "relaxFlags", "estimatedMainAxisSizePx", "", "(Ljava/lang/String;ILjava/lang/String;ID)V", "getEstimatedMainAxisSizePx", "()D", "setEstimatedMainAxisSizePx", "(D)V", "getItemKey", "()Ljava/lang/String;", "setItemKey", "(Ljava/lang/String;)V", "getPosition", "()I", "setPosition", "(I)V", "getRelaxFlags", "setRelaxFlags", "getReuseIdentifier", "setReuseIdentifier", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListInsertAction {
    private double estimatedMainAxisSizePx;
    private String itemKey;
    private int position;
    private int relaxFlags;
    private String reuseIdentifier;

    public final double getEstimatedMainAxisSizePx() {
        return this.estimatedMainAxisSizePx;
    }

    public final String getItemKey() {
        return this.itemKey;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getRelaxFlags() {
        return this.relaxFlags;
    }

    public final String getReuseIdentifier() {
        return this.reuseIdentifier;
    }

    public final void setEstimatedMainAxisSizePx(double r100) {
        this.estimatedMainAxisSizePx = r100;
    }

    public final void setItemKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemKey = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setRelaxFlags(int r100) {
        this.relaxFlags = r100;
    }

    public final void setReuseIdentifier(String r100) {
        this.reuseIdentifier = r100;
    }

    public ListInsertAction(String r100, int r101, String r102, int r103, double r104) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        this.itemKey = r100;
        this.position = r101;
        this.reuseIdentifier = r102;
        this.relaxFlags = r103;
        this.estimatedMainAxisSizePx = r104;
    }

    public /* synthetic */ ListInsertAction(String r100, int r101, String r110, int r111, double r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r110, r111, r112);
    }
}
