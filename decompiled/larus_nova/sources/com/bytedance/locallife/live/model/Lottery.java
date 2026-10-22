package com.bytedance.locallife.live.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR \u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/live/model/Lottery;", "Ljava/io/Serializable;", "()V", "candidateStatus", "", "getCandidateStatus", "()I", "setCandidateStatus", "(I)V", "drawTime", "", "getDrawTime", "()J", "setDrawTime", "(J)V", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "lotteryId", "getLotteryId", "setLotteryId", "predictPrice", "getPredictPrice", "setPredictPrice", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "taskPageSchema", "getTaskPageSchema", "setTaskPageSchema", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Lottery implements Serializable {

    @SerializedName("candidate_status")
    private int candidateStatus;

    @SerializedName("draw_time")
    private long drawTime;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("lottery_id")
    private String lotteryId;

    @SerializedName("predict_price")
    private String predictPrice;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    @SerializedName("task_page_schema")
    private String taskPageSchema;

    public Lottery() {
        this.lotteryId = "";
        this.predictPrice = "";
        this.iconUrl = "";
        this.taskPageSchema = "";
    }

    public final int getCandidateStatus() {
        return this.candidateStatus;
    }

    public final long getDrawTime() {
        return this.drawTime;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getLotteryId() {
        return this.lotteryId;
    }

    public final String getPredictPrice() {
        return this.predictPrice;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getTaskPageSchema() {
        return this.taskPageSchema;
    }

    public final void setCandidateStatus(int r100) {
        this.candidateStatus = r100;
    }

    public final void setDrawTime(long r100) {
        this.drawTime = r100;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public final void setLotteryId(String r100) {
        this.lotteryId = r100;
    }

    public final void setPredictPrice(String r100) {
        this.predictPrice = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setTaskPageSchema(String r100) {
        this.taskPageSchema = r100;
    }
}
