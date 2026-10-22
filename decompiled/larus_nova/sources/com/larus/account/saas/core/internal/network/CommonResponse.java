package com.larus.account.saas.core.internal.network;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0081\b\u0018\u0000 **\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001+B5\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b(\u0010)J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003JD\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\"R$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u0012\u0010'\u001a\u00020\u00138Æ\u0002¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/larus/account/saas/core/internal/network/CommonResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "component1", "", "component2", "component3", "()Ljava/lang/Object;", "component4", "code", "msg", "data", WsConstants.KEY_PAYLOAD, "copy", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/larus/account/saas/core/internal/network/CommonResponse;", "toString", "hashCode", "other", "", "equals", "I", "getCode", "()I", "setCode", "(I)V", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "Ljava/lang/Object;", "getData", "setData", "(Ljava/lang/Object;)V", "getPayload", "setPayload", "getSuccess", "()Z", "success", "<init>", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class CommonResponse<T> {
    public static final int CODE_RISK_CONTROL = 710012005;
    public static final int CODE_UNKNOWN = -999;
    public static final a Companion = null;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private T data;

    @SerializedName("msg")
    private String msg;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    private String payload;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommonResponse() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonResponse copy$default(CommonResponse r100, int r101, String r102, Object r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.payload;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final T component3() {
        return this.data;
    }

    public final String component4() {
        return this.payload;
    }

    public final CommonResponse<T> copy(int r100, String r101, T r102, String r103) {
        return new CommonResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonResponse) == true) goto L8;
        return false;
    L8:
        CommonResponse r101 = (CommonResponse) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.msg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        T r105 = this.data;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.payload;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", payload=" + this.payload + ')';
    }

    public final boolean getSuccess() {
        if (getCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getCode() {
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

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setData(T r100) {
        this.data = r100;
    }

    public final void setMsg(String r100) {
        this.msg = r100;
    }

    public final void setPayload(String r100) {
        this.payload = r100;
    }

    public CommonResponse(int r100, String r101, T r102, String r103) {
        this.code = r100;
        this.msg = r101;
        this.data = r102;
        this.payload = r103;
    }

    public /* synthetic */ CommonResponse(int r100, String r101, Object r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = -999;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
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
