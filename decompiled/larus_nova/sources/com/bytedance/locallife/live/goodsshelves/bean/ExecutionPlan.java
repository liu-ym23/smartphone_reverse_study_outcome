package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/ExecutionPlan;", "Ljava/io/Serializable;", "()V", "activityId", "", "getActivityId", "()J", "setActivityId", "(J)V", "awemeActivityId", "getAwemeActivityId", "setAwemeActivityId", "goodId", "getGoodId", "setGoodId", "tagUrl", "", "getTagUrl", "()Ljava/lang/String;", "setTagUrl", "(Ljava/lang/String;)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ExecutionPlan implements Serializable {

    @SerializedName("activityId")
    private long activityId;

    @SerializedName("awemeActivityId")
    private long awemeActivityId;

    @SerializedName("goodId")
    private long goodId;

    @SerializedName("tagUrl")
    private String tagUrl;

    public ExecutionPlan() {
    }

    public final long getActivityId() {
        return this.activityId;
    }

    public final long getAwemeActivityId() {
        return this.awemeActivityId;
    }

    public final long getGoodId() {
        return this.goodId;
    }

    public final String getTagUrl() {
        return this.tagUrl;
    }

    public final void setActivityId(long r100) {
        this.activityId = r100;
    }

    public final void setAwemeActivityId(long r100) {
        this.awemeActivityId = r100;
    }

    public final void setGoodId(long r100) {
        this.goodId = r100;
    }

    public final void setTagUrl(String r100) {
        this.tagUrl = r100;
    }
}
