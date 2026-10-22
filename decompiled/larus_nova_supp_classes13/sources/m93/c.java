package m93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000eR\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010-\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000e¨\u0006/"}, d2 = {"Lm93/c;", "", "", "leftSeconds", "Ljava/lang/Long;", "getLeftSeconds", "()Ljava/lang/Long;", "h", "getType", "type", "", "couponMetaId", "Ljava/lang/String;", "getCouponMetaId", "()Ljava/lang/String;", "startTime", "getStartTime", "expireTime", "getExpireTime", "couponBizType", "getCouponBizType", "activityId", "getActivityId", "bizSceneKey", "getBizSceneKey", "applyStatus", "getApplyStatus", "applyRangeLabel", "getApplyRangeLabel", "typeStr", "getTypeStr", "subType", "getSubType", "categoryText", "getCategoryText", "startTimeStamp", "getStartTimeStamp", "endTimeStamp", "getEndTimeStamp", "validPeriod", "getValidPeriod", "periodType", "getPeriodType", "applyTimeStamp", "getApplyTimeStamp", "couponId", "getCouponId", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {
    public final String a;

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName("apply_range_label")
    private final String applyRangeLabel;

    @SerializedName("apply_status")
    private final Long applyStatus;

    @SerializedName("apply_time_stamp")
    private final Long applyTimeStamp;
    public final String b;

    @SerializedName("biz_scene_key")
    private final String bizSceneKey;
    public final String c;

    @SerializedName("category_text")
    private final String categoryText;

    @SerializedName("coupon_biz_type")
    private final Long couponBizType;

    @SerializedName("coupon_id")
    private final String couponId;

    @SerializedName("coupon_meta_id")
    private final String couponMetaId;
    public final Long d;
    public final Long e;

    @SerializedName("end_time_stamp")
    private final Long endTimeStamp;

    @SerializedName("expire_time")
    private final String expireTime;
    public final List<Object> f;
    public final Long g;
    public final Long h;
    public final String i;

    @SerializedName("left_seconds")
    private final Long leftSeconds;

    @SerializedName("period_type")
    private final Long periodType;

    @SerializedName("start_time")
    private final String startTime;

    @SerializedName("start_time_stamp")
    private final Long startTimeStamp;

    @SerializedName("sub_type")
    private final Long subType;

    @SerializedName("type_str")
    private final String typeStr;

    @SerializedName("valid_period")
    private final Long validPeriod;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L60;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.leftSeconds, r4.leftSeconds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.couponMetaId, r4.couponMetaId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.startTime, r4.startTime) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.expireTime, r4.expireTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.couponBizType, r4.couponBizType) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.activityId, r4.activityId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.bizSceneKey, r4.bizSceneKey) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.applyStatus, r4.applyStatus) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.applyRangeLabel, r4.applyRangeLabel) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.typeStr, r4.typeStr) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.subType, r4.subType) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.categoryText, r4.categoryText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.startTimeStamp, r4.startTimeStamp) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.endTimeStamp, r4.endTimeStamp) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.validPeriod, r4.validPeriod) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.periodType, r4.periodType) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.applyTimeStamp, r4.applyTimeStamp) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.couponId, r4.couponId) == true) goto L91;
        return false;
    L91:
        return true;
    L60:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.leftSeconds;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<Object> r19 = this.f;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.g;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.h;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.couponMetaId;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.startTime;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.expireTime;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        Long r37 = this.couponBizType;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.activityId;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.bizSceneKey;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        Long r46 = this.applyStatus;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.applyRangeLabel;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.i;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.typeStr;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        Long r58 = this.subType;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        String r61 = this.categoryText;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        Long r64 = this.startTimeStamp;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        Long r67 = this.endTimeStamp;
        if (r67 == null) goto L93;
        int r68 = r67.hashCode();
    L94:
        int r69 = (r66 + r68) * 31;
        Long r70 = this.validPeriod;
        if (r70 == null) goto L97;
        int r71 = r70.hashCode();
    L98:
        int r72 = (r69 + r71) * 31;
        Long r73 = this.periodType;
        if (r73 == null) goto L101;
        int r74 = r73.hashCode();
    L102:
        int r75 = (r72 + r74) * 31;
        Long r76 = this.applyTimeStamp;
        if (r76 == null) goto L105;
        int r77 = r76.hashCode();
    L106:
        int r78 = (r75 + r77) * 31;
        String r79 = this.couponId;
        if (r79 == null) goto L110;
        r1 = r79.hashCode();
    L110:
        return r78 + r1;
    L105:
        r77 = 0;
        goto L106
    L101:
        r74 = 0;
        goto L102
    L97:
        r71 = 0;
        goto L98
    L93:
        r68 = 0;
        goto L94
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CouponList(id=" + this.a + ", name=" + this.b + ", desc=" + this.c + ", amount=" + this.d + ", threshold=" + this.e + ", leftSeconds=" + this.leftSeconds + ", tags=" + this.f + ", discount=" + this.g + ", type=" + this.h + ", couponMetaId=" + this.couponMetaId + ", startTime=" + this.startTime + ", expireTime=" + this.expireTime + ", couponBizType=" + this.couponBizType + ", activityId=" + this.activityId + ", bizSceneKey=" + this.bizSceneKey + ", applyStatus=" + this.applyStatus + ", applyRangeLabel=" + this.applyRangeLabel + ", url=" + this.i + ", typeStr=" + this.typeStr + ", subType=" + this.subType + ", categoryText=" + this.categoryText + ", startTimeStamp=" + this.startTimeStamp + ", endTimeStamp=" + this.endTimeStamp + ", validPeriod=" + this.validPeriod + ", periodType=" + this.periodType + ", applyTimeStamp=" + this.applyTimeStamp + ", couponId=" + this.couponId + ")";
    }

    public c() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.leftSeconds = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.couponMetaId = null;
        this.startTime = null;
        this.expireTime = null;
        this.couponBizType = null;
        this.activityId = null;
        this.bizSceneKey = null;
        this.applyStatus = null;
        this.applyRangeLabel = null;
        this.i = null;
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
        return this.h;
    }
}
