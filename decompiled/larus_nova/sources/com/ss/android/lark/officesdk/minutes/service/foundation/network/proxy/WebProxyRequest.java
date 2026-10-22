package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import android.util.Base64;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyRequest;", "Ljava/io/Serializable;", "proxyRequestId", "", "command", "", "requestBase64", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getProxyRequestId", "()Ljava/lang/String;", "getCommand", "()I", "getRequestBase64", "decodeRequest", "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebProxyRequest implements Serializable {

    @SerializedName("command")
    private final int command;

    @SerializedName("proxyRequestId")
    private final String proxyRequestId;

    @SerializedName("requestBase64")
    private final String requestBase64;

    public static /* synthetic */ WebProxyRequest copy$default(WebProxyRequest r100, String r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.proxyRequestId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.command;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.requestBase64;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.proxyRequestId;
    }

    public final int component2() {
        return this.command;
    }

    public final String component3() {
        return this.requestBase64;
    }

    public final WebProxyRequest copy(String r100, int r101, String r102) {
        return new WebProxyRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WebProxyRequest) == true) goto L8;
        return false;
    L8:
        WebProxyRequest r101 = (WebProxyRequest) r100;
        if (Intrinsics.areEqual(this.proxyRequestId, r101.proxyRequestId) == true) goto L12;
        return false;
    L12:
        if (this.command == r101.command) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.requestBase64, r101.requestBase64) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.proxyRequestId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.command) * 31;
        String r104 = this.requestBase64;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "WebProxyRequest(proxyRequestId=" + this.proxyRequestId + ", command=" + this.command + ", requestBase64=" + this.requestBase64 + ')';
    }

    public final byte[] decodeRequest() {
        String r100 = this.requestBase64;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return Base64.decode(r100, 2);
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getProxyRequestId() {
        return this.proxyRequestId;
    }

    public final String getRequestBase64() {
        return this.requestBase64;
    }

    public WebProxyRequest(String r100, int r101, String r102) {
        this.proxyRequestId = r100;
        this.command = r101;
        this.requestBase64 = r102;
    }
}
