package com.larus.account.saas.security.risk;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0006R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/larus/account/saas/security/risk/j;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "code", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setCode", "(I)V", "", "msg", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "data", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", WsConstants.KEY_PAYLOAD, "getPayload", "setPayload", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
public final class j<T> {

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private T data;

    @SerializedName("msg")
    private String msg;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    private String payload;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
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

    public final int hashCode() {
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

    public final String toString() {
        return "CommonResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", payload=" + this.payload + ')';
    }

    public j() {
        this.code = -999;
        this.msg = "";
        this.data = null;
        this.payload = null;
    }

    public final int a() {
        return this.code;
    }

    public final T b() {
        return this.data;
    }

    public final String c() {
        return this.msg;
    }
}
