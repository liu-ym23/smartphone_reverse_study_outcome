package com.bytedance.locallife.live.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012(\b\u0002\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0017J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0019\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0019\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0013HÆ\u0003Jä\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062(\b\u0002\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR:\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b.\u0010(R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001c¨\u0006C"}, d2 = {"Lcom/bytedance/locallife/live/model/CollectCouponResponse;", "Ljava/io/Serializable;", "resultCode", "", "couponInfo", "", "", "", "canUseNow", "", "userInfo", "couponPopWindow", "Lcom/bytedance/locallife/live/model/CouponPopWindow;", "shelfPopWindow", "Lcom/bytedance/locallife/live/model/ShelfPopWindow;", "statusCode", a.KEY_STATUS_MSG, "lynxData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "noMoreRequest", "resultMsg", "extraLog", "(Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Map;Lcom/bytedance/locallife/live/model/CouponPopWindow;Lcom/bytedance/locallife/live/model/ShelfPopWindow;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)V", "getCanUseNow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCouponInfo", "()Ljava/util/Map;", "getCouponPopWindow", "()Lcom/bytedance/locallife/live/model/CouponPopWindow;", "getExtraLog", "getLynxData", "()Ljava/util/HashMap;", "setLynxData", "(Ljava/util/HashMap;)V", "getNoMoreRequest", "setNoMoreRequest", "(Ljava/lang/Boolean;)V", "getResultCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResultMsg", "()Ljava/lang/String;", "getShelfPopWindow", "()Lcom/bytedance/locallife/live/model/ShelfPopWindow;", "getStatusCode", "getStatusMsg", "getUserInfo", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Map;Lcom/bytedance/locallife/live/model/CouponPopWindow;Lcom/bytedance/locallife/live/model/ShelfPopWindow;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/locallife/live/model/CollectCouponResponse;", "equals", "other", "hashCode", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CollectCouponResponse implements Serializable {

    @SerializedName("can_use_now")
    private final Boolean canUseNow;

    @SerializedName(a.KEY_COUPON_INFO)
    private final Map<String, Object> couponInfo;

    @SerializedName("coupon_pop_window")
    private final CouponPopWindow couponPopWindow;

    @SerializedName("extra_log")
    private final Map<String, String> extraLog;
    private HashMap<String, Object> lynxData;
    private Boolean noMoreRequest;

    @SerializedName("result_code")
    private final Integer resultCode;

    @SerializedName("result_msg")
    private final String resultMsg;

    @SerializedName("shelf_pop_window")
    private final ShelfPopWindow shelfPopWindow;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    @SerializedName("user_info")
    private final Map<String, Object> userInfo;

    public CollectCouponResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollectCouponResponse copy$default(CollectCouponResponse r110, Integer r111, Map r112, Boolean r113, Map r114, CouponPopWindow r115, ShelfPopWindow r116, Integer r210, String r211, HashMap r212, Boolean r213, String r214, Map r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        Integer r100 = r110.resultCode;
    L7:
        if ((r216 & 2) == 0) goto L9;
        Map r101 = r110.couponInfo;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Boolean r102 = r110.canUseNow;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Map r103 = r110.userInfo;
    L19:
        if ((r216 & 16) == 0) goto L21;
        CouponPopWindow r104 = r110.couponPopWindow;
    L23:
        if ((r216 & 32) == 0) goto L25;
        ShelfPopWindow r105 = r110.shelfPopWindow;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r106 = r110.statusCode;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.statusMsg;
    L35:
        if ((r216 & 256) == 0) goto L37;
        HashMap r117 = r110.lynxData;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r118 = r110.noMoreRequest;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.resultMsg;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Map r108 = r110.extraLog;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Integer component1() {
        return this.resultCode;
    }

    public final Boolean component10() {
        return this.noMoreRequest;
    }

    public final String component11() {
        return this.resultMsg;
    }

    public final Map<String, String> component12() {
        return this.extraLog;
    }

    public final Map<String, Object> component2() {
        return this.couponInfo;
    }

    public final Boolean component3() {
        return this.canUseNow;
    }

    public final Map<String, Object> component4() {
        return this.userInfo;
    }

    public final CouponPopWindow component5() {
        return this.couponPopWindow;
    }

    public final ShelfPopWindow component6() {
        return this.shelfPopWindow;
    }

    public final Integer component7() {
        return this.statusCode;
    }

    public final String component8() {
        return this.statusMsg;
    }

    public final HashMap<String, Object> component9() {
        return this.lynxData;
    }

    public final CollectCouponResponse copy(Integer r110, Map<String, ? extends Object> r111, Boolean r112, Map<String, ? extends Object> r113, CouponPopWindow r114, ShelfPopWindow r210, Integer r211, String r212, HashMap<String, Object> r213, Boolean r214, String r215, Map<String, String> r216) {
        return new CollectCouponResponse(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CollectCouponResponse) == true) goto L8;
        return false;
    L8:
        CollectCouponResponse r101 = (CollectCouponResponse) r100;
        if (Intrinsics.areEqual(this.resultCode, r101.resultCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.couponInfo, r101.couponInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.canUseNow, r101.canUseNow) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userInfo, r101.userInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.couponPopWindow, r101.couponPopWindow) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shelfPopWindow, r101.shelfPopWindow) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.noMoreRequest, r101.noMoreRequest) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.resultMsg, r101.resultMsg) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extraLog, r101.extraLog) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.resultCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.couponInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.canUseNow;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.userInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        CouponPopWindow r113 = this.couponPopWindow;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ShelfPopWindow r116 = this.shelfPopWindow;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.statusCode;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.statusMsg;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        HashMap<String, Object> r125 = this.lynxData;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.noMoreRequest;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.resultMsg;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, String> r134 = this.extraLog;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public String toString() {
        return "CollectCouponResponse(resultCode=" + this.resultCode + ", couponInfo=" + this.couponInfo + ", canUseNow=" + this.canUseNow + ", userInfo=" + this.userInfo + ", couponPopWindow=" + this.couponPopWindow + ", shelfPopWindow=" + this.shelfPopWindow + ", statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", lynxData=" + this.lynxData + ", noMoreRequest=" + this.noMoreRequest + ", resultMsg=" + this.resultMsg + ", extraLog=" + this.extraLog + ')';
    }

    public final Boolean getCanUseNow() {
        return this.canUseNow;
    }

    public final Map<String, Object> getCouponInfo() {
        return this.couponInfo;
    }

    public final CouponPopWindow getCouponPopWindow() {
        return this.couponPopWindow;
    }

    public final Map<String, String> getExtraLog() {
        return this.extraLog;
    }

    public final HashMap<String, Object> getLynxData() {
        return this.lynxData;
    }

    public final Boolean getNoMoreRequest() {
        return this.noMoreRequest;
    }

    public final Integer getResultCode() {
        return this.resultCode;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final ShelfPopWindow getShelfPopWindow() {
        return this.shelfPopWindow;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final Map<String, Object> getUserInfo() {
        return this.userInfo;
    }

    public final void setLynxData(HashMap<String, Object> r100) {
        this.lynxData = r100;
    }

    public final void setNoMoreRequest(Boolean r100) {
        this.noMoreRequest = r100;
    }

    public CollectCouponResponse(Integer r100, Map<String, ? extends Object> r101, Boolean r102, Map<String, ? extends Object> r103, CouponPopWindow r104, ShelfPopWindow r105, Integer r106, String r107, HashMap<String, Object> r108, Boolean r110, String r111, Map<String, String> r112) {
        this.resultCode = r100;
        this.couponInfo = r101;
        this.canUseNow = r102;
        this.userInfo = r103;
        this.couponPopWindow = r104;
        this.shelfPopWindow = r105;
        this.statusCode = r106;
        this.statusMsg = r107;
        this.lynxData = r108;
        this.noMoreRequest = r110;
        this.resultMsg = r111;
        this.extraLog = r112;
    }

    public /* synthetic */ CollectCouponResponse(Integer r110, Map r111, Boolean r112, Map r113, CouponPopWindow r114, ShelfPopWindow r115, Integer r210, String r211, HashMap r212, Boolean r213, String r214, Map r215, int r216, DefaultConstructorMarker r217) {
        Map r100 = null;
        if ((r216 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        Map r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Boolean r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Map r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        CouponPopWindow r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        ShelfPopWindow r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        HashMap r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r117 = Boolean.FALSE;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
