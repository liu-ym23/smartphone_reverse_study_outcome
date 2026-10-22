package ng2;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lng2/i;", "", "", "enable", "Ljava/lang/Boolean;", "getEnable", "()Ljava/lang/Boolean;", "", "corePoolSize", "Ljava/lang/Integer;", "getCorePoolSize", "()Ljava/lang/Integer;", "maxPoolSize", "getMaxPoolSize", VideoThumbInfo.KEY_INTERVAL, "getInterval", "delayTime", "getDelayTime", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("corePoolSize")
    private final Integer corePoolSize;

    @SerializedName("delayTime")
    private final Integer delayTime;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final Integer interval;

    @SerializedName("maxPoolSize")
    private final Integer maxPoolSize;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.corePoolSize, r101.corePoolSize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maxPoolSize, r101.maxPoolSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interval, r101.interval) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.delayTime, r101.delayTime) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.corePoolSize;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.maxPoolSize;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.interval;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.delayTime;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TobSuperThreadConfig(enable=" + this.enable + ", corePoolSize=" + this.corePoolSize + ", maxPoolSize=" + this.maxPoolSize + ", interval=" + this.interval + ", delayTime=" + this.delayTime + ")";
    }

    public i() {
        this.enable = Boolean.TRUE;
        this.corePoolSize = 30;
        this.maxPoolSize = 50;
        this.interval = 100;
        this.delayTime = 0;
    }
}
