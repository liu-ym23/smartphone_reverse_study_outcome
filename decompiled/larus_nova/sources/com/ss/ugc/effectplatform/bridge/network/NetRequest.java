package com.ss.ugc.effectplatform.bridge.network;

import com.alipay.sdk.m.p.e;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/ugc/effectplatform/bridge/network/NetRequest;", "", "url", "", "backupUrl", "", e.f25671s, "Lcom/ss/ugc/effectplatform/bridge/network/HTTPMethod;", "headers", "", "bodyParams", "contentType", "useCommParam", "", "extraParms", "(Ljava/lang/String;Ljava/util/List;Lcom/ss/ugc/effectplatform/bridge/network/HTTPMethod;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;ZLjava/util/Map;)V", "getBackupUrl", "()Ljava/util/List;", "getBodyParams", "()Ljava/util/Map;", "getContentType", "()Ljava/lang/String;", "getExtraParms", "getHeaders", "getMethod", "()Lcom/ss/ugc/effectplatform/bridge/network/HTTPMethod;", "getUrl", "getUseCommParam", "()Z", "effect_bridge_release"}, k = 1, mv = {1, 1, 16})
public final class NetRequest {
    private final List<String> backupUrl;
    private final Map<String, Object> bodyParams;
    private final String contentType;
    private final Map<String, Object> extraParms;
    private final Map<String, String> headers;
    private final HTTPMethod method;
    private final String url;
    private final boolean useCommParam;

    public final List<String> getBackupUrl() {
        return this.backupUrl;
    }

    public final Map<String, Object> getBodyParams() {
        return this.bodyParams;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final Map<String, Object> getExtraParms() {
        return this.extraParms;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final HTTPMethod getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getUseCommParam() {
        return this.useCommParam;
    }

    public NetRequest(String r100, List<String> r101, HTTPMethod r102, Map<String, String> r103, Map<String, ? extends Object> r104, String r105, boolean r106, Map<String, ? extends Object> r107) {
        this.url = r100;
        this.backupUrl = r101;
        this.method = r102;
        this.headers = r103;
        this.bodyParams = r104;
        this.contentType = r105;
        this.useCommParam = r106;
        this.extraParms = r107;
    }

    public /* synthetic */ NetRequest(String r100, List r110, HTTPMethod r111, Map r112, Map r113, String r114, boolean r115, Map r116, int r117, DefaultConstructorMarker r118) {
        Map r101 = null;
        if ((r117 & 2) == 0) goto L5;
        List r102 = null;
    L7:
        if ((r117 & 4) == 0) goto L9;
        HTTPMethod r103 = HTTPMethod.GET;
    L11:
        if ((r117 & 8) == 0) goto L13;
        Map r104 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        Map r105 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        String r106 = "application/x-www-form-urlencoded";
    L23:
        if ((r117 & 64) == 0) goto L25;
        boolean r107 = true;
    L27:
        if ((r117 & 128) != 0) goto L30;
        r101 = r116;
    L30:
        this(r100, r102, r103, r104, r105, r106, r107, r101);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
