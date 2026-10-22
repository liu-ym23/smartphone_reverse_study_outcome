package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/ObricDeepThinkModeRestTimeConfig;", "", "intervalTime", "", "<init>", "(Ljava/lang/Long;)V", "getIntervalTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/obric/assistant/ObricDeepThinkModeRestTimeConfig;", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDeepThinkModeRestTimeConfig {

    @SerializedName("interval_time")
    private final Long intervalTime;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricDeepThinkModeRestTimeConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ObricDeepThinkModeRestTimeConfig copy$default(ObricDeepThinkModeRestTimeConfig r100, Long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.intervalTime;
    L6:
        return r100.copy(r101);
    }

    public final Long component1() {
        return this.intervalTime;
    }

    public final ObricDeepThinkModeRestTimeConfig copy(Long r100) {
        return new ObricDeepThinkModeRestTimeConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricDeepThinkModeRestTimeConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.intervalTime, ((ObricDeepThinkModeRestTimeConfig) r100).intervalTime) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Long r100 = this.intervalTime;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ObricDeepThinkModeRestTimeConfig(intervalTime=" + this.intervalTime + ')';
    }

    public final Long getIntervalTime() {
        return this.intervalTime;
    }

    public ObricDeepThinkModeRestTimeConfig(Long r100) {
        this.intervalTime = r100;
    }

    public /* synthetic */ ObricDeepThinkModeRestTimeConfig(Long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
