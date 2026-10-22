package com.ss.android.lark.chameleonv2.lkapi.net;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.sdk.m.p.e;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010'Jv\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b\r\u0010'\"\u0004\b(\u0010)R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b0\u0010'¨\u0006A"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "url", "", e.f25671s, "Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;", "headers", "", ContainerPosition.BODY, "Lcom/alibaba/fastjson/JSONObject;", "bodyString", "credentialsX", "requestTagUserTriggeredValue", "isUserTriggered", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;Ljava/util/Map;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getMethod", "()Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;", "setMethod", "(Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getBody", "()Lcom/alibaba/fastjson/JSONObject;", "setBody", "(Lcom/alibaba/fastjson/JSONObject;)V", "getBodyString", "setBodyString", "getCredentialsX", "setCredentialsX", "getRequestTagUserTriggeredValue", "setRequestTagUserTriggeredValue", "()Ljava/lang/Boolean;", "setUserTriggered", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "credentials", "Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$Credentials;", "getCredentials", "()Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$Credentials;", "requestTagUserTriggered", "getRequestTagUserTriggered", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;Ljava/util/Map;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpRequest;", "equals", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class INet$Internal$HttpRequest implements NonProguard {
    private JSONObject body;
    private String bodyString;
    private String credentialsX;
    private Map<String, String> headers;
    private Boolean isUserTriggered;
    private INet$Internal$HttpMethod method;
    private String requestTagUserTriggeredValue;
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ INet$Internal$HttpRequest copy$default(INet$Internal$HttpRequest r100, String r110, INet$Internal$HttpMethod r111, Map r112, JSONObject r113, String r114, String r115, String r116, Boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.url;
    L7:
        if ((r118 & 2) == 0) goto L9;
        INet$Internal$HttpMethod r102 = r100.method;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Map r103 = r100.headers;
    L15:
        if ((r118 & 8) == 0) goto L17;
        JSONObject r104 = r100.body;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.bodyString;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.credentialsX;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.requestTagUserTriggeredValue;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Boolean r108 = r100.isUserTriggered;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
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

    public final String component1() {
        return this.url;
    }

    public final INet$Internal$HttpMethod component2() {
        return this.method;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final JSONObject component4() {
        return this.body;
    }

    public final String component5() {
        return this.bodyString;
    }

    public final String component6() {
        return this.credentialsX;
    }

    public final String component7() {
        return this.requestTagUserTriggeredValue;
    }

    public final Boolean component8() {
        return this.isUserTriggered;
    }

    public final INet$Internal$HttpRequest copy(String r110, INet$Internal$HttpMethod r111, Map<String, String> r112, JSONObject r113, String r114, @JSONField(name = "credentials") String r115, @JSONField(name = "t") String r116, Boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, e.f25671s);
        return new INet$Internal$HttpRequest(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof INet$Internal$HttpRequest) == true) goto L8;
        return false;
    L8:
        INet$Internal$HttpRequest r101 = (INet$Internal$HttpRequest) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.method == r101.method) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headers, r101.headers) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bodyString, r101.bodyString) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.credentialsX, r101.credentialsX) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.requestTagUserTriggeredValue, r101.requestTagUserTriggeredValue) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isUserTriggered, r101.isUserTriggered) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.url.hashCode() * 31) + this.method.hashCode()) * 31;
        Map<String, String> r101 = this.headers;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JSONObject r105 = this.body;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.bodyString;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.credentialsX;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.requestTagUserTriggeredValue;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Boolean r117 = this.isUserTriggered;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
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

    public String toString() {
        return "HttpRequest(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", body=" + this.body + ", bodyString=" + this.bodyString + ", credentialsX=" + this.credentialsX + ", requestTagUserTriggeredValue=" + this.requestTagUserTriggeredValue + ", isUserTriggered=" + this.isUserTriggered + ')';
    }

    public final INet$Internal$Credentials getCredentials() {
        INet$Internal$Credentials.a r100 = INet$Internal$Credentials.Companion;
        String r101 = this.credentialsX;
        r100.getClass();
        INet$Internal$Credentials[] r102 = INet$Internal$Credentials.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        INet$Internal$Credentials r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getValue(), r101) == true) goto L9;
        r104 = r104 + 1;
    L9:
        if (r105 == null) goto L12;
        return r105;
    L12:
        return INet$Internal$Credentials.Omit;
    L8:
        r105 = null;
        goto L9
    }

    public final Boolean getRequestTagUserTriggered() {
        Boolean r100 = this.isUserTriggered;
        if (r100 != null) goto L12;
        String r101 = this.requestTagUserTriggeredValue;
        if (Intrinsics.areEqual(r101, "1") == false) goto L8;
        return Boolean.TRUE;
    L8:
        if (Intrinsics.areEqual(r101, "0") == true) goto L14;
        return null;
    L14:
        return Boolean.FALSE;
    L12:
        return r100;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final String getBodyString() {
        return this.bodyString;
    }

    public final String getCredentialsX() {
        return this.credentialsX;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final INet$Internal$HttpMethod getMethod() {
        return this.method;
    }

    public final String getRequestTagUserTriggeredValue() {
        return this.requestTagUserTriggeredValue;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean isUserTriggered() {
        return this.isUserTriggered;
    }

    public final void setBody(JSONObject r100) {
        this.body = r100;
    }

    public final void setBodyString(String r100) {
        this.bodyString = r100;
    }

    public final void setCredentialsX(String r100) {
        this.credentialsX = r100;
    }

    public final void setHeaders(Map<String, String> r100) {
        this.headers = r100;
    }

    public final void setMethod(INet$Internal$HttpMethod r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.method = r100;
    }

    public final void setRequestTagUserTriggeredValue(String r100) {
        this.requestTagUserTriggeredValue = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public final void setUserTriggered(Boolean r100) {
        this.isUserTriggered = r100;
    }

    public INet$Internal$HttpRequest(String r100, INet$Internal$HttpMethod r101, Map<String, String> r102, JSONObject r103, String r104, @JSONField(name = "credentials") String r105, @JSONField(name = "t") String r106, Boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        this.url = r100;
        this.method = r101;
        this.headers = r102;
        this.body = r103;
        this.bodyString = r104;
        this.credentialsX = r105;
        this.requestTagUserTriggeredValue = r106;
        this.isUserTriggered = r107;
    }
}
