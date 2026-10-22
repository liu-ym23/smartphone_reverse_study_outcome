package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/Busi_info;", "", "net_speed_limit", "", "(J)V", "getNet_speed_limit", "()J", "setNet_speed_limit", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class Busi_info {
    private long net_speed_limit;

    public Busi_info() {
        long r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ Busi_info copy$default(Busi_info r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.net_speed_limit;
    L6:
        return r100.copy(r101);
    }

    public final long component1() {
        return this.net_speed_limit;
    }

    public final Busi_info copy(long r100) {
        return new Busi_info(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Busi_info) == true) goto L6;
        return false;
    L6:
        if (this.net_speed_limit == ((Busi_info) r100).net_speed_limit) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        long r100 = this.net_speed_limit;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public String toString() {
        return "Busi_info(net_speed_limit=" + this.net_speed_limit + ")";
    }

    public final long getNet_speed_limit() {
        return this.net_speed_limit;
    }

    public Busi_info(long r100) {
        this.net_speed_limit = r100;
    }

    public final void setNet_speed_limit(long r100) {
        this.net_speed_limit = r100;
    }

    public /* synthetic */ Busi_info(long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
