package com.relax.relaxframework;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/relax/relaxframework/ListUpdateAction;", "", "itemKey", "", "from", "", RemoteMessageConst.TO, "reuseIdentifier", "relaxFlags", "estimatedMainAxisSizePx", "", "(Ljava/lang/String;IILjava/lang/String;ID)V", "getEstimatedMainAxisSizePx", "()D", "setEstimatedMainAxisSizePx", "(D)V", "getFrom", "()I", "setFrom", "(I)V", "getItemKey", "()Ljava/lang/String;", "setItemKey", "(Ljava/lang/String;)V", "getRelaxFlags", "setRelaxFlags", "getReuseIdentifier", "setReuseIdentifier", "getTo", "setTo", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListUpdateAction {
    private double estimatedMainAxisSizePx;
    private int from;
    private String itemKey;
    private int relaxFlags;
    private String reuseIdentifier;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    private int f404776to;

    public final double getEstimatedMainAxisSizePx() {
        return this.estimatedMainAxisSizePx;
    }

    public final int getFrom() {
        return this.from;
    }

    public final String getItemKey() {
        return this.itemKey;
    }

    public final int getRelaxFlags() {
        return this.relaxFlags;
    }

    public final String getReuseIdentifier() {
        return this.reuseIdentifier;
    }

    public final int getTo() {
        return this.f404776to;
    }

    public final void setEstimatedMainAxisSizePx(double r100) {
        this.estimatedMainAxisSizePx = r100;
    }

    public final void setFrom(int r100) {
        this.from = r100;
    }

    public final void setItemKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemKey = r100;
    }

    public final void setRelaxFlags(int r100) {
        this.relaxFlags = r100;
    }

    public final void setReuseIdentifier(String r100) {
        this.reuseIdentifier = r100;
    }

    public final void setTo(int r100) {
        this.f404776to = r100;
    }

    public ListUpdateAction(String r100, int r101, int r102, String r103, int r104, double r105) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        this.itemKey = r100;
        this.from = r101;
        this.f404776to = r102;
        this.reuseIdentifier = r103;
        this.relaxFlags = r104;
        this.estimatedMainAxisSizePx = r105;
    }

    public /* synthetic */ ListUpdateAction(String r110, int r111, int r112, String r113, int r114, double r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 8) == 0) goto L5;
        String r100 = null;
    L6:
        this(r110, r111, r112, r100, r114, r115);
        return;
    L5:
        r100 = r113;
        goto L6
    }
}
