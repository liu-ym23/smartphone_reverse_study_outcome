package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/model/chat/MessageListLimitConfig;", "", "maxLimit", "", "initialLoadLimit", "loadMoreLimit", "monitorRequestCountThreshold", "monitorRequestWindowMs", "", "<init>", "(IIIIJ)V", "getMaxLimit", "()I", "getInitialLoadLimit", "getLoadMoreLimit", "getMonitorRequestCountThreshold", "getMonitorRequestWindowMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c0 {

    @SerializedName("initial_load_limit")
    private final int initialLoadLimit;

    @SerializedName("load_more_limit")
    private final int loadMoreLimit;

    @SerializedName("max_limit")
    private final int maxLimit;

    @SerializedName("monitor_request_count_threshold")
    private final int monitorRequestCountThreshold;

    @SerializedName("monitor_request_window_ms")
    private final long monitorRequestWindowMs;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.maxLimit == r101.maxLimit) goto L12;
        return false;
    L12:
        if (this.initialLoadLimit == r101.initialLoadLimit) goto L15;
        return false;
    L15:
        if (this.loadMoreLimit == r101.loadMoreLimit) goto L18;
        return false;
    L18:
        if (this.monitorRequestCountThreshold == r101.monitorRequestCountThreshold) goto L21;
        return false;
    L21:
        if (this.monitorRequestWindowMs == r101.monitorRequestWindowMs) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.maxLimit * 31) + this.initialLoadLimit) * 31) + this.loadMoreLimit) * 31) + this.monitorRequestCountThreshold) * 31;
        long r101 = this.monitorRequestWindowMs;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "MessageListLimitConfig(maxLimit=" + this.maxLimit + ", initialLoadLimit=" + this.initialLoadLimit + ", loadMoreLimit=" + this.loadMoreLimit + ", monitorRequestCountThreshold=" + this.monitorRequestCountThreshold + ", monitorRequestWindowMs=" + this.monitorRequestWindowMs + ')';
    }

    public final int a() {
        return this.initialLoadLimit;
    }

    public final int b() {
        return this.loadMoreLimit;
    }

    public final int c() {
        return this.maxLimit;
    }

    public final int d() {
        return this.monitorRequestCountThreshold;
    }

    public final long e() {
        return this.monitorRequestWindowMs;
    }

    public c0(int r100) {
        this.maxLimit = 50;
        this.initialLoadLimit = 20;
        this.loadMoreLimit = 20;
        this.monitorRequestCountThreshold = 20;
        this.monitorRequestWindowMs = 10000;
    }
}
