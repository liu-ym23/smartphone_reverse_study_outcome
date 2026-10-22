package com.bytedance.locallife.groupon.struct.guesslike;

import com.bytedance.locallife.groupon.struct.FrequencyInfo;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/locallife/groupon/struct/guesslike/FeedMotivationalTaskData;", "", "taskType", "", "uncertainTaskConfig", "Lcom/bytedance/locallife/groupon/struct/guesslike/UncertainTaskConfig;", "certainTaskConfig", "Lcom/bytedance/locallife/groupon/struct/guesslike/CertainTaskConfig;", "frequencyInfo", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "(Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/struct/guesslike/UncertainTaskConfig;Lcom/bytedance/locallife/groupon/struct/guesslike/CertainTaskConfig;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;)V", "getCertainTaskConfig", "()Lcom/bytedance/locallife/groupon/struct/guesslike/CertainTaskConfig;", "setCertainTaskConfig", "(Lcom/bytedance/locallife/groupon/struct/guesslike/CertainTaskConfig;)V", "getFrequencyInfo", "()Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "setFrequencyInfo", "(Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;)V", "getTaskType", "()Ljava/lang/Integer;", "setTaskType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUncertainTaskConfig", "()Lcom/bytedance/locallife/groupon/struct/guesslike/UncertainTaskConfig;", "setUncertainTaskConfig", "(Lcom/bytedance/locallife/groupon/struct/guesslike/UncertainTaskConfig;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/struct/guesslike/UncertainTaskConfig;Lcom/bytedance/locallife/groupon/struct/guesslike/CertainTaskConfig;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;)Lcom/bytedance/locallife/groupon/struct/guesslike/FeedMotivationalTaskData;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FeedMotivationalTaskData {

    @SerializedName("certain_task_config")
    private CertainTaskConfig certainTaskConfig;

    @SerializedName("frequency_info")
    private FrequencyInfo frequencyInfo;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private Integer taskType;

    @SerializedName("uncertain_task_config")
    private UncertainTaskConfig uncertainTaskConfig;

    public FeedMotivationalTaskData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FeedMotivationalTaskData copy$default(FeedMotivationalTaskData r100, Integer r101, UncertainTaskConfig r102, CertainTaskConfig r103, FrequencyInfo r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.taskType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.uncertainTaskConfig;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.certainTaskConfig;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.frequencyInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.taskType;
    }

    public final UncertainTaskConfig component2() {
        return this.uncertainTaskConfig;
    }

    public final CertainTaskConfig component3() {
        return this.certainTaskConfig;
    }

    public final FrequencyInfo component4() {
        return this.frequencyInfo;
    }

    public final FeedMotivationalTaskData copy(Integer r100, UncertainTaskConfig r101, CertainTaskConfig r102, FrequencyInfo r103) {
        return new FeedMotivationalTaskData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedMotivationalTaskData) == true) goto L8;
        return false;
    L8:
        FeedMotivationalTaskData r101 = (FeedMotivationalTaskData) r100;
        if (Intrinsics.areEqual(this.taskType, r101.taskType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uncertainTaskConfig, r101.uncertainTaskConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.certainTaskConfig, r101.certainTaskConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.frequencyInfo, r101.frequencyInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.taskType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UncertainTaskConfig r104 = this.uncertainTaskConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CertainTaskConfig r107 = this.certainTaskConfig;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        FrequencyInfo r110 = this.frequencyInfo;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FeedMotivationalTaskData(taskType=" + this.taskType + ", uncertainTaskConfig=" + this.uncertainTaskConfig + ", certainTaskConfig=" + this.certainTaskConfig + ", frequencyInfo=" + this.frequencyInfo + ')';
    }

    public final CertainTaskConfig getCertainTaskConfig() {
        return this.certainTaskConfig;
    }

    public final FrequencyInfo getFrequencyInfo() {
        return this.frequencyInfo;
    }

    public final Integer getTaskType() {
        return this.taskType;
    }

    public final UncertainTaskConfig getUncertainTaskConfig() {
        return this.uncertainTaskConfig;
    }

    public final void setCertainTaskConfig(CertainTaskConfig r100) {
        this.certainTaskConfig = r100;
    }

    public final void setFrequencyInfo(FrequencyInfo r100) {
        this.frequencyInfo = r100;
    }

    public final void setTaskType(Integer r100) {
        this.taskType = r100;
    }

    public final void setUncertainTaskConfig(UncertainTaskConfig r100) {
        this.uncertainTaskConfig = r100;
    }

    public FeedMotivationalTaskData(Integer r100, UncertainTaskConfig r101, CertainTaskConfig r102, FrequencyInfo r103) {
        this.taskType = r100;
        this.uncertainTaskConfig = r101;
        this.certainTaskConfig = r102;
        this.frequencyInfo = r103;
    }

    public /* synthetic */ FeedMotivationalTaskData(Integer r100, UncertainTaskConfig r101, CertainTaskConfig r102, FrequencyInfo r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
