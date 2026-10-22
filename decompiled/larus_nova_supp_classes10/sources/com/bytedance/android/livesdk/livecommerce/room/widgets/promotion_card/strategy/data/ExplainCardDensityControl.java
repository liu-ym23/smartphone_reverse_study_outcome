package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/data/ExplainCardDensityControl;", "Ljava/io/Serializable;", "timeCycleDuration", "", "exposureTimeThreshold", "(JJ)V", "getExposureTimeThreshold", "()J", "getTimeCycleDuration", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardDensityControl implements Serializable {

    @SerializedName("exposure_time")
    private final long exposureTimeThreshold;

    @SerializedName("judgement_cycle")
    private final long timeCycleDuration;

    public ExplainCardDensityControl() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ ExplainCardDensityControl copy$default(ExplainCardDensityControl r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.timeCycleDuration;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.exposureTimeThreshold;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.timeCycleDuration;
    }

    public final long component2() {
        return this.exposureTimeThreshold;
    }

    public final ExplainCardDensityControl copy(long r2, long r4) {
        return new ExplainCardDensityControl(r2, r4);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ExplainCardDensityControl) == false) goto L10;
        ExplainCardDensityControl r7 = (ExplainCardDensityControl) r6;
        if (this.timeCycleDuration == r7.timeCycleDuration) goto L8;
        return false;
    L8:
        if (this.exposureTimeThreshold == r7.exposureTimeThreshold) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r0 = this.timeCycleDuration;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.exposureTimeThreshold;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        return "ExplainCardDensityControl(timeCycleDuration=" + this.timeCycleDuration + ", exposureTimeThreshold=" + this.exposureTimeThreshold + ")";
    }

    public final long getExposureTimeThreshold() {
        return this.exposureTimeThreshold;
    }

    public final long getTimeCycleDuration() {
        return this.timeCycleDuration;
    }

    public ExplainCardDensityControl(long r1, long r3) {
        this.timeCycleDuration = r1;
        this.exposureTimeThreshold = r3;
    }

    public /* synthetic */ ExplainCardDensityControl(long r3, long r5, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r5 = 0;
    L8:
        this(r3, r5);
    }
}
