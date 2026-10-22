package com.ss.android.ugc.aweme.common;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/common/GlobalTabGuideExitInfo;", "Ljava/io/Serializable;", "()V", "cycleDayNum", "", "getCycleDayNum", "()I", "onceTabGuideMaxShowNum", "getOnceTabGuideMaxShowNum", "totalClickNum", "getTotalClickNum", "totalShowNum", "getTotalShowNum", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GlobalTabGuideExitInfo implements Serializable {

    @SerializedName("cycle_day_num")
    private final int cycleDayNum;

    @SerializedName("once_tab_guide_max_show_num")
    private final int onceTabGuideMaxShowNum;

    @SerializedName("total_click_num")
    private final int totalClickNum;

    @SerializedName("total_show_num")
    private final int totalShowNum;

    public GlobalTabGuideExitInfo() {
        this.onceTabGuideMaxShowNum = 1;
    }

    public final int getCycleDayNum() {
        return this.cycleDayNum;
    }

    public final int getOnceTabGuideMaxShowNum() {
        return this.onceTabGuideMaxShowNum;
    }

    public final int getTotalClickNum() {
        return this.totalClickNum;
    }

    public final int getTotalShowNum() {
        return this.totalShowNum;
    }
}
