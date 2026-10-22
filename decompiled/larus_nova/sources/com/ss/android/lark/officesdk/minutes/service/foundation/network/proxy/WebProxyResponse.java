package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyResponse;", "Ljava/io/Serializable;", "proxyRequestId", "", "success", "", "responseBase64", "clientError", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyClientError;", "errorBase64", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyClientError;Ljava/lang/String;)V", "getProxyRequestId", "()Ljava/lang/String;", "getSuccess", "()Z", "getResponseBase64", "getClientError", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyClientError;", "getErrorBase64", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebProxyResponse implements Serializable {
    public static final a Companion = null;

    @SerializedName("clientError")
    private final WebProxyClientError clientError;

    @SerializedName("errorBase64")
    private final String errorBase64;

    @SerializedName("proxyRequestId")
    private final String proxyRequestId;

    @SerializedName("responseBase64")
    private final String responseBase64;

    @SerializedName("success")
    private final boolean success;

    public static final class a {
        public a() {
        }

        public static WebProxyResponse a(String r100, WebProxyClientError r110) {
            Intrinsics.checkNotNullParameter(r100, "proxyRequestId");
            Intrinsics.checkNotNullParameter(r110, "error");
            return new WebProxyResponse(r100, false, null, r110, null, 20, null);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ WebProxyResponse copy$default(WebProxyResponse r100, String r101, boolean r102, String r103, WebProxyClientError r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.proxyRequestId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.success;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.responseBase64;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.clientError;
    L14:
        WebProxyClientError r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.errorBase64;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.proxyRequestId;
    }

    public final boolean component2() {
        return this.success;
    }

    public final String component3() {
        return this.responseBase64;
    }

    public final WebProxyClientError component4() {
        return this.clientError;
    }

    public final String component5() {
        return this.errorBase64;
    }

    public final WebProxyResponse copy(String r100, boolean r101, String r110, WebProxyClientError r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "proxyRequestId");
        return new WebProxyResponse(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WebProxyResponse) == true) goto L8;
        return false;
    L8:
        WebProxyResponse r101 = (WebProxyResponse) r100;
        if (Intrinsics.areEqual(this.proxyRequestId, r101.proxyRequestId) == true) goto L12;
        return false;
    L12:
        if (this.success == r101.success) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.responseBase64, r101.responseBase64) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clientError, r101.clientError) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.errorBase64, r101.errorBase64) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.proxyRequestId.hashCode() * 31;
        if (this.success == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.responseBase64;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        WebProxyClientError r107 = this.clientError;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.errorBase64;
        if (r110 == null) goto L19;
        r104 = r110.hashCode();
    L19:
        return r109 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "WebProxyResponse(proxyRequestId=" + this.proxyRequestId + ", success=" + this.success + ", responseBase64=" + this.responseBase64 + ", clientError=" + this.clientError + ", errorBase64=" + this.errorBase64 + ')';
    }

    public final WebProxyClientError getClientError() {
        return this.clientError;
    }

    public final String getErrorBase64() {
        return this.errorBase64;
    }

    public final String getProxyRequestId() {
        return this.proxyRequestId;
    }

    public final String getResponseBase64() {
        return this.responseBase64;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public WebProxyResponse(String r100, boolean r101, String r102, WebProxyClientError r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "proxyRequestId");
        this.proxyRequestId = r100;
        this.success = r101;
        this.responseBase64 = r102;
        this.clientError = r103;
        this.errorBase64 = r104;
    }

    public /* synthetic */ WebProxyResponse(String r100, boolean r101, String r110, WebProxyClientError r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        WebProxyClientError r103 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        String r104 = null;
    L14:
        this(r100, r101, r102, r103, r104);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
