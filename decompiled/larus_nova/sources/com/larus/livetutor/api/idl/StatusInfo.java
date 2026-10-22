package com.larus.livetutor.api.idl;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0019\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000bHÆ\u0003Jd\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/larus/livetutor/api/idl/StatusInfo;", "Ljava/io/Serializable;", "statusCode", "", a.KEY_STATUS_MSG, "", "toastMsg", "errTips", "serverTime", "", "extra", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "getStatusCode", "()Ljava/lang/Integer;", "setStatusCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "getToastMsg", "setToastMsg", "getErrTips", "setErrTips", "getServerTime", "()Ljava/lang/Long;", "setServerTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lcom/larus/livetutor/api/idl/StatusInfo;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StatusInfo implements Serializable {

    @SerializedName("err_tips")
    private String errTips;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("server_time")
    private Long serverTime;

    @SerializedName("status_code")
    private Integer statusCode;

    @SerializedName("status_msg")
    private String statusMsg;

    @SerializedName(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
    private String toastMsg;

    public StatusInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StatusInfo copy$default(StatusInfo r100, Integer r101, String r102, String r103, String r104, Long r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.statusCode;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.statusMsg;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.toastMsg;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.errTips;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.serverTime;
    L17:
        Long r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.extra;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
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

    public final String component4() {
        return this.errTips;
    }

    public final Long component5() {
        return this.serverTime;
    }

    public final Map<String, String> component6() {
        return this.extra;
    }

    public final StatusInfo copy(Integer r100, String r110, String r111, String r112, Long r113, Map<String, String> r114) {
        return new StatusInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StatusInfo) == true) goto L8;
        return false;
    L8:
        StatusInfo r101 = (StatusInfo) r100;
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.toastMsg, r101.toastMsg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errTips, r101.errTips) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.serverTime, r101.serverTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L26;
        return false;
    L26:
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
        String r110 = this.errTips;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.serverTime;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.extra;
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

    public String toString() {
        return "StatusInfo(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", toastMsg=" + this.toastMsg + ", errTips=" + this.errTips + ", serverTime=" + this.serverTime + ", extra=" + this.extra + ')';
    }

    public final String getErrTips() {
        return this.errTips;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Long getServerTime() {
        return this.serverTime;
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

    public final void setErrTips(String r100) {
        this.errTips = r100;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setServerTime(Long r100) {
        this.serverTime = r100;
    }

    public final void setStatusCode(Integer r100) {
        this.statusCode = r100;
    }

    public final void setStatusMsg(String r100) {
        this.statusMsg = r100;
    }

    public final void setToastMsg(String r100) {
        this.toastMsg = r100;
    }

    public StatusInfo(Integer r100, String r101, String r102, String r103, Long r104, Map<String, String> r105) {
        this.statusCode = r100;
        this.statusMsg = r101;
        this.toastMsg = r102;
        this.errTips = r103;
        this.serverTime = r104;
        this.extra = r105;
    }

    public /* synthetic */ StatusInfo(Integer r100, String r101, String r102, String r103, Long r110, Map r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Integer r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Long r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Map r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
