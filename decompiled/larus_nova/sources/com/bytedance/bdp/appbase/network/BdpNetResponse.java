package com.bytedance.bdp.appbase.network;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.lynx.tasm.LynxError;
import gb4.c;
import gb4.d;
import gb4.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010.\u001a\u00020-\u0012\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000102¢\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u0002H\u0016R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010$\u001a\u0004\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R%\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpNetResponse;", "", "", "contentType", "", "contentLength", "", HTTP.CONTENT_RANGE_BYTES, "stringBody", "Lorg/json/JSONObject;", "jsonBody", "", "isSuccessful", "toString", "", "code", "I", "getCode", "()I", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "url", "getUrl", "Lgb4/c;", "headers", "Lgb4/c;", "getHeaders", "()Lgb4/c;", "Lgb4/g;", ContainerPosition.BODY, "Lgb4/g;", "getBody", "()Lgb4/g;", "", LynxError.LYNX_THROWABLE, "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "libType", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "getLibType", "()Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "Lgb4/d;", "metric", "Lgb4/d;", "getMetric", "()Lgb4/d;", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lgb4/c;Lgb4/g;Ljava/lang/Throwable;Lcom/bytedance/bdp/appbase/network/BdpRequestType;Lgb4/d;Ljava/util/Map;)V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpNetResponse {
    private final g body;
    private final int code;
    private final Map<String, Object> extraInfo;
    private final c headers;
    private final BdpRequestType libType;
    private final String message;
    private final d metric;
    private final Throwable throwable;
    private final String url;

    public final byte[] bytes() {
        g r100 = this.body;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public final long contentLength() {
        g r100 = this.body;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.b();
    }

    public final String contentType() {
        g r100 = this.body;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    public final boolean isSuccessful() {
        if (this.throwable != null) goto L10;
        int r100 = this.code;
        if (200 > r100) goto L10;
        if (299 < r100) goto L10;
        return true;
    L10:
        return false;
    }

    public final JSONObject jsonBody() {
        g r100 = this.body;
        if (r100 == null) goto L14;
        String r101 = r100.f480719f;     // Catch: Throwable -> L11
        if (r101 != null) goto L8;
        String r102 = new String(r100.a(), Charsets.UTF_8);     // Catch: Throwable -> L11
        r100.f480719f = r102;     // Catch: Throwable -> L11
        r101 = r102;
    L8:
        return new JSONObject(r101);
    L15:
        return null;
    L14:
        return null;
    }

    public final String stringBody() {
        g r100 = this.body;
        if (r100 == null) goto L8;
        String r101 = r100.f480719f;
        if (r101 != null) goto L11;
        String r102 = new String(r100.a(), Charsets.UTF_8);
        r100.f480719f = r102;
        return r102;
    L11:
        return r101;
    L8:
        return "";
    }

    public String toString() {
        return "BdpResponse(code=" + this.code + ", message='" + this.message + "', headers=" + this.headers + ", body=" + this.body + ", throwable=" + this.throwable + ", libType=" + this.libType + ", metric=" + this.metric + ", extraInfo=" + this.extraInfo + ')';
    }

    public final g getBody() {
        return this.body;
    }

    public final int getCode() {
        return this.code;
    }

    public final Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final c getHeaders() {
        return this.headers;
    }

    public final BdpRequestType getLibType() {
        return this.libType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final d getMetric() {
        return this.metric;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final String getUrl() {
        return this.url;
    }

    public BdpNetResponse(int r100, String r101, String r102, c r103, g r104, Throwable r105, BdpRequestType r106, d r107, Map<String, ? extends Object> r108) {
        this.code = r100;
        this.message = r101;
        this.url = r102;
        this.headers = r103;
        this.body = r104;
        this.throwable = r105;
        this.libType = r106;
        this.metric = r107;
        this.extraInfo = r108;
    }
}
