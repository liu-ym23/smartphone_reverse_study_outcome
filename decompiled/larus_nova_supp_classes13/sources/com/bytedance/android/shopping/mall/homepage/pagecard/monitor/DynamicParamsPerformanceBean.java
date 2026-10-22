package com.bytedance.android.shopping.mall.homepage.pagecard.monitor;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/pagecard/monitor/DynamicParamsPerformanceBean;", "", "()V", "result", "", "getResult", "()Ljava/lang/Long;", "setResult", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "tPullDynamicParamsFinish", "getTPullDynamicParamsFinish", "setTPullDynamicParamsFinish", "tPullDynamicParamsStart", "getTPullDynamicParamsStart", "setTPullDynamicParamsStart", "useWhiteBoard", "getUseWhiteBoard", "setUseWhiteBoard", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicParamsPerformanceBean {

    @SerializedName("result")
    private Long result;

    @SerializedName("t_pull_dynamic_params_finish")
    private Long tPullDynamicParamsFinish;

    @SerializedName("t_pull_dynamic_params_start")
    private Long tPullDynamicParamsStart;

    @SerializedName("use_white_board")
    private Long useWhiteBoard;

    public DynamicParamsPerformanceBean() {
        this.tPullDynamicParamsStart = 0L;
        this.tPullDynamicParamsFinish = 0L;
        this.useWhiteBoard = 0L;
        this.result = 0L;
    }

    public final Long getResult() {
        return this.result;
    }

    public final Long getTPullDynamicParamsFinish() {
        return this.tPullDynamicParamsFinish;
    }

    public final Long getTPullDynamicParamsStart() {
        return this.tPullDynamicParamsStart;
    }

    public final Long getUseWhiteBoard() {
        return this.useWhiteBoard;
    }

    public final void setResult(Long r1) {
        this.result = r1;
    }

    public final void setTPullDynamicParamsFinish(Long r1) {
        this.tPullDynamicParamsFinish = r1;
    }

    public final void setTPullDynamicParamsStart(Long r1) {
        this.tPullDynamicParamsStart = r1;
    }

    public final void setUseWhiteBoard(Long r1) {
        this.useWhiteBoard = r1;
    }
}
