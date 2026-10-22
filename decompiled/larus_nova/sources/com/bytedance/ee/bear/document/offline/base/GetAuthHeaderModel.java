package com.bytedance.ee.bear.document.offline.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.sdk.m.p.e;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/base/GetAuthHeaderModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", e.f25671s, "", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAuthHeaderModel implements NonProguard {

    @SerializedName(e.f25671s)
    @JSONField(name = e.f25671s)
    private String method;

    @SerializedName("url")
    @JSONField(name = "url")
    private String url;

    public String toString() {
        return "GetAuthHeaderModel{method: " + this.method + ", url: " + this.url + '}';
    }

    public GetAuthHeaderModel() {
        this.method = "";
        this.url = "";
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setMethod(String r100) {
        this.method = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
