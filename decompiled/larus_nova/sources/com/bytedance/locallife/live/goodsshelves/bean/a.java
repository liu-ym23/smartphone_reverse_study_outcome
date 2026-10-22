package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u0012\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/a;", "", "", "resultCode", "I", "b", "()I", "", "resultMsg", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "extraLog", "Ljava/util/Map;", "getExtraLog", "()Ljava/util/Map;", "", "autoDrawExtraLog", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "toast", "d", "statusCode", "getStatusCode", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "getStatusMsg", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("auto_draw_extra_log")
    private final List<Map<String, String>> autoDrawExtraLog;

    @SerializedName("extra_log")
    private final Map<String, String> extraLog;

    @SerializedName("result_code")
    private final int resultCode;

    @SerializedName("result_msg")
    private final String resultMsg;

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    @SerializedName("toast")
    private final String toast;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.resultCode == r101.resultCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resultMsg, r101.resultMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraLog, r101.extraLog) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.autoDrawExtraLog, r101.autoDrawExtraLog) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.toast, r101.toast) == true) goto L24;
        return false;
    L24:
        if (this.statusCode == r101.statusCode) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.resultCode * 31;
        String r101 = this.resultMsg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, String> r105 = this.extraLog;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<Map<String, String>> r108 = this.autoDrawExtraLog;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.toast;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + this.statusCode) * 31;
        String r114 = this.statusMsg;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AutoCollectCouponResponseV2(resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", extraLog=" + this.extraLog + ", autoDrawExtraLog=" + this.autoDrawExtraLog + ", toast=" + this.toast + ", statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ')';
    }

    public final List<Map<String, String>> a() {
        return this.autoDrawExtraLog;
    }

    public final int b() {
        return this.resultCode;
    }

    public final String c() {
        return this.resultMsg;
    }

    public final String d() {
        return this.toast;
    }
}
