package mv6;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nv6.t0;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lmv6/e;", "", "", "updateType", "I", "f", "()I", "", "pushTime", "J", "d", "()J", "Lmv6/g;", "refreshGrouponInfo", "Lmv6/g;", "getRefreshGrouponInfo", "()Lmv6/g;", "Lnv6/t0;", "updatedGrouponInfoV2", "Lnv6/t0;", ce.f26391f, "()Lnv6/t0;", "Lmv6/c;", "drawLotteryResult", "Lmv6/c;", "getDrawLotteryResult", "()Lmv6/c;", "lifeLotteryDraw", "c", "Lmv6/b;", "atmosphereInfo", "Lmv6/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lmv6/b;", "Lmv6/a;", "aggCardOperateInfo", "Lmv6/a;", "getAggCardOperateInfo", "()Lmv6/a;", "", "", "cardIds", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "refreshSingleCard", "Z", "e", "()Z", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f515894a;

    @SerializedName("agg_card_operate_info")
    private final a aggCardOperateInfo;

    @SerializedName("atmosphere_info")
    private final b atmosphereInfo;

    @SerializedName("card_ids")
    private final List<String> cardIds;

    @SerializedName("draw_lottery_result")
    private final c drawLotteryResult;

    @SerializedName("life_lottery_draw")
    private final c lifeLotteryDraw;

    @SerializedName("push_time")
    private final long pushTime;

    @SerializedName("refresh_groupon_info")
    private final g refreshGrouponInfo;

    @SerializedName("refresh_single_card")
    private final boolean refreshSingleCard;

    @SerializedName(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE)
    private final int updateType;

    @SerializedName("updated_groupon_info_v2")
    private final t0 updatedGrouponInfoV2;

    public e() {
        this(0, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.updateType == r101.updateType) goto L12;
        return false;
    L12:
        if (this.pushTime == r101.pushTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refreshGrouponInfo, r101.refreshGrouponInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.updatedGrouponInfoV2, r101.updatedGrouponInfoV2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.drawLotteryResult, r101.drawLotteryResult) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lifeLotteryDraw, r101.lifeLotteryDraw) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.atmosphereInfo, r101.atmosphereInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.aggCardOperateInfo, r101.aggCardOperateInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.cardIds, r101.cardIds) == true) goto L36;
        return false;
    L36:
        if (this.refreshSingleCard == r101.refreshSingleCard) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.updateType * 31;
        long r101 = this.pushTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        g r103 = this.refreshGrouponInfo;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        t0 r107 = this.updatedGrouponInfoV2;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        c r110 = this.drawLotteryResult;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        c r113 = this.lifeLotteryDraw;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (r112 + r114) * 31;
        b r116 = this.atmosphereInfo;
        if (r116 != null) goto L21;
        int r117 = 0;
    L22:
        int r118 = (r115 + r117) * 31;
        a r119 = this.aggCardOperateInfo;
        if (r119 != null) goto L25;
        int r120 = 0;
    L26:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.cardIds;
        if (r122 == null) goto L30;
        r104 = r122.hashCode();
    L30:
        int r123 = (r121 + r104) * 31;
        if (this.refreshSingleCard == false) goto L33;
        int r124 = 1231;
    L35:
        return r123 + r124;
    L33:
        r124 = 1237;
        goto L35
    L25:
        r120 = r119.hashCode();
        goto L26
    L21:
        r117 = r116.hashCode();
        goto L22
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "MessageBody(updateType=" + this.updateType + ", pushTime=" + this.pushTime + ", refreshGrouponInfo=" + this.refreshGrouponInfo + ", updatedGrouponInfoV2=" + this.updatedGrouponInfoV2 + ", drawLotteryResult=" + this.drawLotteryResult + ", lifeLotteryDraw=" + this.lifeLotteryDraw + ", atmosphereInfo=" + this.atmosphereInfo + ", aggCardOperateInfo=" + this.aggCardOperateInfo + ", cardIds=" + this.cardIds + ", refreshSingleCard=" + this.refreshSingleCard + ')';
    }

    public final b a() {
        return this.atmosphereInfo;
    }

    public final List<String> b() {
        return this.cardIds;
    }

    public final c c() {
        return this.lifeLotteryDraw;
    }

    public final long d() {
        return this.pushTime;
    }

    public final boolean e() {
        return this.refreshSingleCard;
    }

    public final int f() {
        return this.updateType;
    }

    public final t0 g() {
        return this.updatedGrouponInfoV2;
    }

    public e(int r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r101 & 2) == 0) goto L8;
        long r102 = -1;
    L9:
        this.updateType = r100;
        this.pushTime = r102;
        this.refreshGrouponInfo = null;
        this.updatedGrouponInfoV2 = null;
        this.drawLotteryResult = null;
        this.lifeLotteryDraw = null;
        this.atmosphereInfo = null;
        this.aggCardOperateInfo = null;
        this.cardIds = null;
        this.refreshSingleCard = false;
        this.f515894a = "";
        return;
    L8:
        r102 = 0;
        goto L9
    }
}
