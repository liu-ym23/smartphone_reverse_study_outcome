package com.bytedance.ug.sdk.luckycat.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/settings/j;", "", "", "startTs", "J", "getStartTs", "()J", "setStartTs", "(J)V", "endTs", "getEndTs", "setEndTs", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class j {

    @SerializedName("activity_end_time_ms")
    private long endTs;

    @SerializedName("activity_start_time_ms")
    private long startTs;

    public j() {
    }
}
