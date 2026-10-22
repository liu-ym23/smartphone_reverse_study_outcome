package m93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lm93/b;", "", "", "launchID", "Ljava/lang/String;", "getLaunchID", "()Ljava/lang/String;", "Lm93/x;", "periodInfo", "Lm93/x;", "getPeriodInfo", "()Lm93/x;", "jumpSchema", "getJumpSchema", "styleConf", "getStyleConf", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "", "Lm93/c;", "couponList", "Ljava/util/List;", "getCouponList", "()Ljava/util/List;", "Lm93/a;", "baseResp", "Lm93/a;", "getBaseResp", "()Lm93/a;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f512592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512593b;

    @SerializedName("base_resp")
    private final a baseResp;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f512594c;

    @SerializedName("coupon_list")
    private final List<c> couponList;

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("jump_schema")
    private final String jumpSchema;

    @SerializedName("launch_i_d")
    private final String launchID;

    @SerializedName("period_info")
    private final x periodInfo;

    @SerializedName("style_conf")
    private final String styleConf;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L26;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.launchID, r101.launchID) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.periodInfo, r101.periodInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpSchema, r101.jumpSchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.styleConf, r101.styleConf) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f512592a, r101.f512592a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.couponList, r101.couponList) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f512593b, r101.f512593b) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f512594c, r101.f512594c) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.baseResp, r101.baseResp) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.launchID;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        x r104 = this.periodInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.jumpSchema;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.styleConf;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<f> r113 = this.f512592a;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.hasMore;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<c> r119 = this.couponList;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f512593b;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        e r125 = this.f512594c;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        a r128 = this.baseResp;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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
        return "BizData(launchID=" + this.launchID + ", periodInfo=" + this.periodInfo + ", jumpSchema=" + this.jumpSchema + ", styleConf=" + this.styleConf + ", feed=" + this.f512592a + ", hasMore=" + this.hasMore + ", couponList=" + this.couponList + ", postback=" + this.f512593b + ", extra=" + this.f512594c + ", baseResp=" + this.baseResp + ")";
    }

    public b() {
        this.launchID = null;
        this.periodInfo = null;
        this.jumpSchema = null;
        this.styleConf = null;
        this.f512592a = null;
        this.hasMore = null;
        this.couponList = null;
        this.f512593b = null;
        this.f512594c = null;
        this.baseResp = null;
    }
}
