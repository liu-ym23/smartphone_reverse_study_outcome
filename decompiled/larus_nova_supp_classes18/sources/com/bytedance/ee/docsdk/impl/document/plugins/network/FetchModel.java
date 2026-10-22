package com.bytedance.ee.docsdk.impl.document.plugins.network;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/network/FetchModel;", "", "()V", "body", "getBody", "()Ljava/lang/Object;", "setBody", "(Ljava/lang/Object;)V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "method", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", ResourceData.KEY_URL, "getUrl", "setUrl", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FetchModel {

    @SerializedName("body")
    private Object body;

    @SerializedName("headers")
    private Map<String, String> headers;

    @SerializedName("method")
    private String method;

    @SerializedName(ResourceData.KEY_URL)
    private String url;

    public FetchModel() {
        this.url = "";
        this.method = "";
        this.headers = new LinkedHashMap();
    }

    public final Object getBody() {
        return this.body;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setBody(Object r1) {
        this.body = r1;
    }

    public final void setHeaders(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.headers = r2;
    }

    public final void setMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.method = r2;
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }
}
