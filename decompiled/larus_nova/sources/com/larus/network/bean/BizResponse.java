package com.larus.network.bean;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001&B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0014J\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0014J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0011JB\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017¨\u0006'"}, d2 = {"Lcom/larus/network/bean/BizResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "msg", "", WsConstants.KEY_PAYLOAD, "data", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()J", "getMsg", "()Ljava/lang/String;", "getPayload", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "isSuccess", "", "()Z", "setupSSResponse", "", "getSSResponse", "component1", "component2", "component3", "component4", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/larus/network/bean/BizResponse;", "equals", "other", "hashCode", "", "toString", "Companion", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BizResponse<T> {
    private static final long[] CODE_RISK_CONTROL = null;
    public static final long CODE_UNKNOWN = -999;
    public static final a Companion = null;

    @SerializedName("code")
    private final long code;

    @SerializedName("data")
    private final T data;

    @SerializedName("msg")
    private final String msg;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    private final String payload;
    private transient SsResponse<String> ssResponse;

    public static final class a {
        public a() {
        }
    }

    public BizResponse() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BizResponse copy$default(BizResponse r100, long r101, String r102, String r110, Object r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.code;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.msg;
    L8:
        String r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.payload;
    L11:
        String r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = r100.data;
    L15:
        return r100.copy(r103, r104, r105, r111);
    }

    public final long component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.payload;
    }

    public final T component4() {
        return this.data;
    }

    public final BizResponse<T> copy(long r100, String r110, String r111, T r112) {
        return new BizResponse(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BizResponse) == true) goto L8;
        return false;
    L8:
        BizResponse r101 = (BizResponse) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.code;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.msg;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.payload;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        T r109 = this.data;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        return r108 + r103;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "BizResponse(code=" + this.code + ", msg=" + this.msg + ", payload=" + this.payload + ", data=" + this.data + ')';
    }

    static {
        Companion = new a();
        CODE_RISK_CONTROL = new long[]{710012005, 710012021};
    }

    public final boolean isSuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ long[] access$getCODE_RISK_CONTROL$cp() {
        return CODE_RISK_CONTROL;
    }

    public final long getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final SsResponse<String> getSSResponse() {
        return this.ssResponse;
    }

    public final void setupSSResponse(SsResponse<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ssResponse");
        this.ssResponse = r100;
    }

    public BizResponse(long r100, String r101, String r102, T r103) {
        this.code = r100;
        this.msg = r101;
        this.payload = r102;
        this.data = r103;
    }

    public /* synthetic */ BizResponse(long r100, String r101, String r110, Object r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r102 = r100;
        if ((r112 & 2) == 0) goto L8;
        String r103 = "";
    L10:
        if ((r112 & 4) == 0) goto L12;
        String r104 = "";
    L14:
        if ((r112 & 8) == 0) goto L16;
        r111 = null;
    L16:
        this(r102, r103, r104, r111);
        return;
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }
}
