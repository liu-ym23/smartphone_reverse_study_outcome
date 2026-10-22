package m93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lm93/b;", "", "", "launchID", "Ljava/lang/String;", "getLaunchID", "()Ljava/lang/String;", "Lm93/x;", "periodInfo", "Lm93/x;", "getPeriodInfo", "()Lm93/x;", "jumpSchema", "getJumpSchema", "styleConf", "getStyleConf", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "", "Lm93/c;", "couponList", "Ljava/util/List;", "getCouponList", "()Ljava/util/List;", "Lm93/a;", "baseResp", "Lm93/a;", "getBaseResp", "()Lm93/a;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {
    public final List<f> a;
    public final String b;

    @SerializedName("base_resp")
    private final a baseResp;
    public final e c;

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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L26;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.launchID, r4.launchID) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.periodInfo, r4.periodInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpSchema, r4.jumpSchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.styleConf, r4.styleConf) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hasMore, r4.hasMore) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.couponList, r4.couponList) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.baseResp, r4.baseResp) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r0 = this.launchID;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        x r4 = this.periodInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.jumpSchema;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.styleConf;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<f> r13 = this.a;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.hasMore;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<c> r19 = this.couponList;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.b;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        e r25 = this.c;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        a r28 = this.baseResp;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
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
        return "BizData(launchID=" + this.launchID + ", periodInfo=" + this.periodInfo + ", jumpSchema=" + this.jumpSchema + ", styleConf=" + this.styleConf + ", feed=" + this.a + ", hasMore=" + this.hasMore + ", couponList=" + this.couponList + ", postback=" + this.b + ", extra=" + this.c + ", baseResp=" + this.baseResp + ")";
    }

    public b() {
        this.launchID = null;
        this.periodInfo = null;
        this.jumpSchema = null;
        this.styleConf = null;
        this.a = null;
        this.hasMore = null;
        this.couponList = null;
        this.b = null;
        this.c = null;
        this.baseResp = null;
    }
}
