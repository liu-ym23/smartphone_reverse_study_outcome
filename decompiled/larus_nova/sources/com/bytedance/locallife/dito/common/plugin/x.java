package com.bytedance.locallife.dito.common.plugin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\nR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\nR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\nR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/dito/common/plugin/x;", "", "", "createTs", "J", "getCreateTs", "()J", "initialDuration", "getInitialDuration", "setInitialDuration", "(J)V", "loadDuration", "getLoadDuration", "setLoadDuration", "pageReplaceDuration", "getPageReplaceDuration", "setPageReplaceDuration", "totalDuration", "getTotalDuration", "setTotalDuration", "initTs", "getInitTs", "setInitTs", "onPageReadyTs", "getOnPageReadyTs", "setOnPageReadyTs", "taskFinishTs", "getTaskFinishTs", "setTaskFinishTs", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class x {

    @Expose
    private final transient long createTs;

    @Expose
    private transient long initTs;

    @SerializedName("initial_duration")
    private long initialDuration;

    @SerializedName("load_duration")
    private long loadDuration;

    @Expose
    private transient long onPageReadyTs;

    @SerializedName("page_replace_duration")
    private long pageReplaceDuration;

    @Expose
    private transient long taskFinishTs;

    @SerializedName("total_duration")
    private long totalDuration;

    public x() {
        this(0);
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
        this.initTs = r100;
        this.initialDuration = r100 - this.createTs;
    }

    public final void b() {
        long r100 = System.currentTimeMillis();
        this.onPageReadyTs = r100;
        this.loadDuration = r100 - this.initTs;
    }

    public final void c() {
        long r100 = System.currentTimeMillis();
        this.taskFinishTs = r100;
        this.pageReplaceDuration = r100 - this.onPageReadyTs;
        this.totalDuration = r100 - this.createTs;
    }

    public x(int r100) {
        this.createTs = System.currentTimeMillis();
    }
}
