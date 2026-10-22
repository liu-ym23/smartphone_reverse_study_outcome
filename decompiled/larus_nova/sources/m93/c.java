package m93;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000eR\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010-\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000e¨\u0006/"}, d2 = {"Lm93/c;", "", "", "leftSeconds", "Ljava/lang/Long;", "getLeftSeconds", "()Ljava/lang/Long;", "h", "getType", "type", "", "couponMetaId", "Ljava/lang/String;", "getCouponMetaId", "()Ljava/lang/String;", DyPayConstant.KEY_START_TIME, "getStartTime", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "getExpireTime", "couponBizType", "getCouponBizType", "activityId", "getActivityId", "bizSceneKey", "getBizSceneKey", "applyStatus", "getApplyStatus", "applyRangeLabel", "getApplyRangeLabel", "typeStr", "getTypeStr", "subType", "getSubType", "categoryText", "getCategoryText", "startTimeStamp", "getStartTimeStamp", "endTimeStamp", "getEndTimeStamp", "validPeriod", "getValidPeriod", "periodType", "getPeriodType", "applyTimeStamp", "getApplyTimeStamp", "couponId", "getCouponId", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512595a;

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName("apply_range_label")
    private final String applyRangeLabel;

    @SerializedName("apply_status")
    private final Long applyStatus;

    @SerializedName("apply_time_stamp")
    private final Long applyTimeStamp;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512596b;

    @SerializedName("biz_scene_key")
    private final String bizSceneKey;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f512597c;

    @SerializedName("category_text")
    private final String categoryText;

    @SerializedName("coupon_biz_type")
    private final Long couponBizType;

    @SerializedName("coupon_id")
    private final String couponId;

    @SerializedName("coupon_meta_id")
    private final String couponMetaId;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f512598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f512599e;

    @SerializedName("end_time_stamp")
    private final Long endTimeStamp;

    @SerializedName("expire_time")
    private final String expireTime;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Object> f512600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f512601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f512602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f512603i;

    @SerializedName("left_seconds")
    private final Long leftSeconds;

    @SerializedName("period_type")
    private final Long periodType;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final String startTime;

    @SerializedName("start_time_stamp")
    private final Long startTimeStamp;

    @SerializedName("sub_type")
    private final Long subType;

    @SerializedName("type_str")
    private final String typeStr;

    @SerializedName("valid_period")
    private final Long validPeriod;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L60;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f512595a, r101.f512595a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512596b, r101.f512596b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f512597c, r101.f512597c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512598d, r101.f512598d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f512599e, r101.f512599e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.leftSeconds, r101.leftSeconds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512600f, r101.f512600f) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f512601g, r101.f512601g) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f512602h, r101.f512602h) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.couponMetaId, r101.couponMetaId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.expireTime, r101.expireTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.couponBizType, r101.couponBizType) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.activityId, r101.activityId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.bizSceneKey, r101.bizSceneKey) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.applyStatus, r101.applyStatus) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.applyRangeLabel, r101.applyRangeLabel) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f512603i, r101.f512603i) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.typeStr, r101.typeStr) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.categoryText, r101.categoryText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.startTimeStamp, r101.startTimeStamp) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.endTimeStamp, r101.endTimeStamp) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.validPeriod, r101.validPeriod) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.periodType, r101.periodType) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.applyTimeStamp, r101.applyTimeStamp) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.couponId, r101.couponId) == true) goto L91;
        return false;
    L91:
        return true;
    L60:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f512595a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f512596b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f512597c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f512598d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f512599e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.leftSeconds;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<Object> r119 = this.f512600f;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.f512601g;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.f512602h;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.couponMetaId;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.startTime;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.expireTime;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Long r137 = this.couponBizType;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.activityId;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.bizSceneKey;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Long r146 = this.applyStatus;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.applyRangeLabel;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.f512603i;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.typeStr;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        Long r158 = this.subType;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.categoryText;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        Long r164 = this.startTimeStamp;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        Long r167 = this.endTimeStamp;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        Long r170 = this.validPeriod;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        Long r173 = this.periodType;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (r172 + r174) * 31;
        Long r176 = this.applyTimeStamp;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        String r179 = this.couponId;
        if (r179 == null) goto L110;
        r101 = r179.hashCode();
    L110:
        return r178 + r101;
    L105:
        r177 = 0;
        goto L106
    L101:
        r174 = 0;
        goto L102
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "CouponList(id=" + this.f512595a + ", name=" + this.f512596b + ", desc=" + this.f512597c + ", amount=" + this.f512598d + ", threshold=" + this.f512599e + ", leftSeconds=" + this.leftSeconds + ", tags=" + this.f512600f + ", discount=" + this.f512601g + ", type=" + this.f512602h + ", couponMetaId=" + this.couponMetaId + ", startTime=" + this.startTime + ", expireTime=" + this.expireTime + ", couponBizType=" + this.couponBizType + ", activityId=" + this.activityId + ", bizSceneKey=" + this.bizSceneKey + ", applyStatus=" + this.applyStatus + ", applyRangeLabel=" + this.applyRangeLabel + ", url=" + this.f512603i + ", typeStr=" + this.typeStr + ", subType=" + this.subType + ", categoryText=" + this.categoryText + ", startTimeStamp=" + this.startTimeStamp + ", endTimeStamp=" + this.endTimeStamp + ", validPeriod=" + this.validPeriod + ", periodType=" + this.periodType + ", applyTimeStamp=" + this.applyTimeStamp + ", couponId=" + this.couponId + ")";
    }

    public c() {
        this.f512595a = null;
        this.f512596b = null;
        this.f512597c = null;
        this.f512598d = null;
        this.f512599e = null;
        this.leftSeconds = null;
        this.f512600f = null;
        this.f512601g = null;
        this.f512602h = null;
        this.couponMetaId = null;
        this.startTime = null;
        this.expireTime = null;
        this.couponBizType = null;
        this.activityId = null;
        this.bizSceneKey = null;
        this.applyStatus = null;
        this.applyRangeLabel = null;
        this.f512603i = null;
        this.typeStr = null;
        this.subType = null;
        this.categoryText = null;
        this.startTimeStamp = null;
        this.endTimeStamp = null;
        this.validPeriod = null;
        this.periodType = null;
        this.applyTimeStamp = null;
        this.couponId = null;
    }

    public final Long getType() {
        return this.f512602h;
    }
}
