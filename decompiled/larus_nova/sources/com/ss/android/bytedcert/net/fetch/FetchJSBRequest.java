package com.ss.android.bytedcert.net.fetch;

import com.alipay.sdk.m.p.e;
import com.ss.android.cert.manager.utils.net.ParserUrl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000eR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/ss/android/bytedcert/net/fetch/FetchJSBRequest;", "Lcom/ss/android/bytedcert/net/fetch/BaseRequest;", "url", "", e.f25671s, "requestType", "headerMap", "queryMapStr", "postData", "timeout", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "commonRequestParams", "", "getCommonRequestParams", "()Ljava/util/Map;", "setCommonRequestParams", "(Ljava/util/Map;)V", "getHeaderMap", "getMethod", "path", "getPath", "getPostData", "getQueryMapStr", "getRequestType", "requestUseUrl", "", "getRequestUseUrl", "()Z", "setRequestUseUrl", "(Z)V", "getTimeout", "()Ljava/lang/Long;", "Ljava/lang/Long;", "byted_cert_core_release"}, k = 1, mv = {1, 1, 16})
public final class FetchJSBRequest extends BaseRequest {
    private final String baseUrl;
    private Map<String, String> commonRequestParams;
    private final String headerMap;
    private final String method;
    private final String path;
    private final String postData;
    private final String queryMapStr;
    private final String requestType;
    private boolean requestUseUrl;
    private final Long timeout;

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final Map<String, String> getCommonRequestParams() {
        return this.commonRequestParams;
    }

    public final String getHeaderMap() {
        return this.headerMap;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPostData() {
        return this.postData;
    }

    public final String getQueryMapStr() {
        return this.queryMapStr;
    }

    public final String getRequestType() {
        return this.requestType;
    }

    public final boolean getRequestUseUrl() {
        return this.requestUseUrl;
    }

    public final Long getTimeout() {
        return this.timeout;
    }

    public final void setCommonRequestParams(Map<String, String> r100) {
        this.commonRequestParams = r100;
    }

    public final void setRequestUseUrl(boolean r100) {
        this.requestUseUrl = r100;
    }

    public FetchJSBRequest(String r100, String r101, String r102, String r103, String r104, String r105, Long r106) {
        this.method = r101;
        this.requestType = r102;
        this.headerMap = r103;
        this.queryMapStr = r104;
        this.postData = r105;
        this.timeout = r106;
        this.mUrl = r100;
        ParserUrl r107 = new ParserUrl(r100).invoke();
        this.baseUrl = r107.getBaseUrl();
        this.path = r107.getPath();
    }

    public /* synthetic */ FetchJSBRequest(String r110, String r111, String r112, String r113, String r114, String r115, Long r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r117 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r117 & 64) == 0) goto L21;
        Long r104 = -1L;
    L22:
        this(r110, r111, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
