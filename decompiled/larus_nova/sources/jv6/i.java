package jv6;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Ljv6/i;", "", "", "playId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "playStartTime", "Ljava/lang/Long;", "getPlayStartTime", "()Ljava/lang/Long;", "playEndTime", "getPlayEndTime", "shareNeedCount", "getShareNeedCount", "", "Ljv6/b;", "cityInfo", "Ljava/util/List;", "getCityInfo", "()Ljava/util/List;", "lifeAccountId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("city_info")
    private final List<b> cityInfo;

    @SerializedName("merchant_id")
    private final Long lifeAccountId;

    @SerializedName("play_end_time")
    private final Long playEndTime;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName("play_start_time")
    private final Long playStartTime;

    @SerializedName("share_need_count")
    private final Long shareNeedCount;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.playId, r101.playId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.playStartTime, r101.playStartTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.playEndTime, r101.playEndTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shareNeedCount, r101.shareNeedCount) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cityInfo, r101.cityInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lifeAccountId, r101.lifeAccountId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.playId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.playStartTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.playEndTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.shareNeedCount;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<b> r113 = this.cityInfo;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.lifeAccountId;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public final String toString() {
        return "PlayInfo(playId=" + this.playId + ", playStartTime=" + this.playStartTime + ", playEndTime=" + this.playEndTime + ", shareNeedCount=" + this.shareNeedCount + ", cityInfo=" + this.cityInfo + ", lifeAccountId=" + this.lifeAccountId + ')';
    }

    public i() {
        this.playId = null;
        this.playStartTime = 0L;
        this.playEndTime = 0L;
        this.shareNeedCount = 0L;
        this.cityInfo = null;
        this.lifeAccountId = 0L;
    }

    public final Long a() {
        return this.lifeAccountId;
    }

    public final String b() {
        return this.playId;
    }
}
