package com.bytedance.locallife.live.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\bHÆ\u0003JP\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R*\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/live/model/AutoCollectCouponResponse;", "Ljava/io/Serializable;", "statusCode", "", a.KEY_STATUS_MSG, "", "toastMsg", "logExtraList", "", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getLogExtraList", "()Ljava/util/List;", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusMsg", "()Ljava/lang/String;", "getToastMsg", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/bytedance/locallife/live/model/AutoCollectCouponResponse;", "equals", "", "other", "", "hashCode", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AutoCollectCouponResponse implements Serializable {

    @SerializedName("log_extra")
    private final List<Map<String, String>> logExtraList;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    @SerializedName("toast")
    private final String toastMsg;

    public AutoCollectCouponResponse() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoCollectCouponResponse copy$default(AutoCollectCouponResponse r100, Integer r101, String r102, String r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.statusCode;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.statusMsg;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.toastMsg;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.logExtraList;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.statusMsg;
    }

    public final String component3() {
        return this.toastMsg;
    }

    public final List<Map<String, String>> component4() {
        return this.logExtraList;
    }

    public final AutoCollectCouponResponse copy(Integer r100, String r101, String r102, List<? extends Map<String, String>> r103) {
        return new AutoCollectCouponResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AutoCollectCouponResponse) == true) goto L8;
        return false;
    L8:
        AutoCollectCouponResponse r101 = (AutoCollectCouponResponse) r100;
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.toastMsg, r101.toastMsg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.logExtraList, r101.logExtraList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.statusCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.statusMsg;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.toastMsg;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Map<String, String>> r110 = this.logExtraList;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "AutoCollectCouponResponse(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", toastMsg=" + this.toastMsg + ", logExtraList=" + this.logExtraList + ')';
    }

    public final List<Map<String, String>> getLogExtraList() {
        return this.logExtraList;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final String getToastMsg() {
        return this.toastMsg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutoCollectCouponResponse(Integer r100, String r101, String r102, List<? extends Map<String, String>> r103) {
        this.statusCode = r100;
        this.statusMsg = r101;
        this.toastMsg = r102;
        this.logExtraList = r103;
    }

    public /* synthetic */ AutoCollectCouponResponse(Integer r100, String r101, String r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
