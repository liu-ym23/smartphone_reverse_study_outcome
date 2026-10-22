package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.TaskInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2TaskInfo;", "", "", "taskType", "I", "taskStatus", "", "reportEvent", "Ljava/lang/String;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2BrowseInfo;", "browseInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2BrowseInfo;", "", "cumulativeDuration", "J", "getCumulativeDuration", "()J", "setCumulativeDuration", "(J)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2TaskInfo {

    @SerializedName("browse_task_info")
    public ECV2BrowseInfo browseInfo;
    private long cumulativeDuration;

    @SerializedName("report_event")
    public String reportEvent;

    @SerializedName("task_status")
    public int taskStatus;

    @SerializedName("task_type")
    public int taskType;

    public ECV2TaskInfo() {
        this.reportEvent = "";
    }

    public final long getCumulativeDuration() {
        return this.cumulativeDuration;
    }

    public final void setCumulativeDuration(long r1) {
        this.cumulativeDuration = r1;
    }
}
