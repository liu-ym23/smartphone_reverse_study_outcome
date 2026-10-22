package com.bytedance.awemeopen.infra.base.net;

import com.alipay.sdk.m.p.e;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q64.c;
import q64.d;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001CB±\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00102\u001a\u00020-\u0012\u0006\u00104\u001a\u00020-\u0012\u0006\u00106\u001a\u00020\u000f\u0012\b\u00108\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010:\u001a\u00020\u000f\u0012\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010<¢\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010)\u001a\u0004\u0018\u00010(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00102\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b3\u00101R\u0017\u00104\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00101R\u0017\u00106\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013R\u0019\u00108\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010\u0007R\u0017\u0010:\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b:\u0010\u0011\u001a\u0004\b;\u0010\u0013R%\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoNetRequest;", "", "", "toString", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", e.f25671s, "getMethod", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "from", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "getFrom", "()Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "", "responseStreaming", "Z", "getResponseStreaming", "()Z", "addHostSecurityParams", "getAddHostSecurityParams", "addHostCommonParams", "getAddHostCommonParams", "addHostMd5Stub", "getAddHostMd5Stub", "addCommonParams", "getAddCommonParams", "Lq64/c;", "headers", "Lq64/c;", "getHeaders", "()Lq64/c;", "reportMonitor", "getReportMonitor", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "requestLibType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "getRequestLibType", "()Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "Lq64/d;", "requestBody", "Lq64/d;", "getRequestBody", "()Lq64/d;", "", "connectTimeOut", "J", "getConnectTimeOut", "()J", "readTimeOut", "getReadTimeOut", "writeTimeOut", "getWriteTimeOut", "httpDns", "getHttpDns", "cacheAppId", "getCacheAppId", "enableHttp2", "getEnableHttp2", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;ZZZZZLq64/c;ZLcom/bytedance/awemeopen/infra/base/net/AoRequestType;Lq64/d;JJJZLjava/lang/String;ZLjava/util/Map;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoNetRequest {
    private final boolean addCommonParams;
    private final boolean addHostCommonParams;
    private final boolean addHostMd5Stub;
    private final boolean addHostSecurityParams;
    private final String cacheAppId;
    private final long connectTimeOut;
    private final boolean enableHttp2;
    private final Map<String, Object> extraInfo;
    private final AoFromSource from;
    private final c headers;
    private final boolean httpDns;
    private final String method;
    private final long readTimeOut;
    private final boolean reportMonitor;
    private final d requestBody;
    private final AoRequestType requestLibType;
    private final boolean responseStreaming;
    private final String url;
    private final long writeTimeOut;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f198672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f198673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AoFromSource f198674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f198675d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f198676e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f198677f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f198678g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f198679h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f198680i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f198681j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f198682k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public c.a f198683l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f198684m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public AoRequestType f198685n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public d f198686o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f198687p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f198688q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Map<String, Object> f198689r;

        public final AoNetRequest a() {
            String r100 = this.f198672a;
            String r101 = this.f198673b;
            AoFromSource r102 = this.f198674c;
            boolean r103 = this.f198675d;
            boolean r104 = this.f198677f;
            boolean r105 = this.f198678g;
            boolean r106 = this.f198679h;
            c.a r107 = this.f198683l;
            r107.getClass();
            return new AoNetRequest(r100, r101, r102, r103, r104, r105, false, r106, new c(r107.f531791a), this.f198684m, this.f198685n, this.f198686o, this.f198680i, this.f198682k, this.f198681j, this.f198676e, this.f198687p, this.f198688q, this.f198689r);
        }

        public final void b(d r100) {
            Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
            Intrinsics.checkNotNullParameter("POST", e.f25671s);
            this.f198673b = "POST";
            this.f198686o = r100;
        }

        public final void c(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "headers");
            c.a r101 = this.f198683l;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "map");
            ((ArrayList) r101.f531791a).clear();
            Iterator r102 = r100.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            Map.Entry r103 = (Map.Entry) r102.next();
            String r104 = (String) r103.getKey();
            String r105 = (String) r103.getValue();
            Intrinsics.checkNotNullParameter(r104, "key");
            Intrinsics.checkNotNullParameter(r105, "value");
            List<c.C7284c> r106 = r101.f531791a;
            ArrayList r107 = (ArrayList) r106;
            r107.add(new c.C7284c(r104, r105));
            goto L4
        }

        public final a delete(d r100) {
            Intrinsics.checkNotNullParameter("DELETE", e.f25671s);
            this.f198673b = "DELETE";
            this.f198686o = r100;
            return this;
        }

        public a(String r100, AoFromSource r101) {
            Intrinsics.checkNotNullParameter(r100, "httpUrl");
            Intrinsics.checkNotNullParameter(r101, "fromSource");
            this.f198672a = r100;
            this.f198674c = r101;
            this.f198673b = "GET";
            this.f198680i = 60000;
            this.f198681j = 60000;
            this.f198682k = 60000;
            this.f198675d = false;
            this.f198676e = true;
            this.f198677f = true;
            this.f198678g = false;
            this.f198679h = false;
            this.f198683l = new c.a();
            this.f198684m = true;
            this.f198685n = AoRequestType.HOST;
            this.f198686o = null;
            this.f198687p = null;
            this.f198688q = false;
            this.f198689r = new HashMap();
        }
    }

    public String toString() {
        return "BdpRequest(url='" + this.url + "', method='" + this.method + "', from=" + this.from + ", responseStreaming=" + this.responseStreaming + ", addHostSecurityParams=" + this.addHostSecurityParams + ", addHostCommonParams=" + this.addHostCommonParams + ", addHostMd5Stub=" + this.addHostMd5Stub + ", addBdpCommonParams=" + this.addCommonParams + ", headers=" + this.headers + ", reportMonitor=" + this.reportMonitor + ", requestLibType=" + this.requestLibType + ", requestBody=" + this.requestBody + ", connectTimeOut=" + this.connectTimeOut + ", readTimeOut=" + this.readTimeOut + ", writeTimeOut=" + this.writeTimeOut + ", httpDns=" + this.httpDns + ", cacheAppId=" + this.cacheAppId + ", enableHttp2=" + this.enableHttp2 + ", extraInfo=" + this.extraInfo + ')';
    }

    public final boolean getAddCommonParams() {
        return this.addCommonParams;
    }

    public final boolean getAddHostCommonParams() {
        return this.addHostCommonParams;
    }

    public final boolean getAddHostMd5Stub() {
        return this.addHostMd5Stub;
    }

    public final boolean getAddHostSecurityParams() {
        return this.addHostSecurityParams;
    }

    public final String getCacheAppId() {
        return this.cacheAppId;
    }

    public final long getConnectTimeOut() {
        return this.connectTimeOut;
    }

    public final boolean getEnableHttp2() {
        return this.enableHttp2;
    }

    public final Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final AoFromSource getFrom() {
        return this.from;
    }

    public final c getHeaders() {
        return this.headers;
    }

    public final boolean getHttpDns() {
        return this.httpDns;
    }

    public final String getMethod() {
        return this.method;
    }

    public final long getReadTimeOut() {
        return this.readTimeOut;
    }

    public final boolean getReportMonitor() {
        return this.reportMonitor;
    }

    public final d getRequestBody() {
        return this.requestBody;
    }

    public final AoRequestType getRequestLibType() {
        return this.requestLibType;
    }

    public final boolean getResponseStreaming() {
        return this.responseStreaming;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getWriteTimeOut() {
        return this.writeTimeOut;
    }

    public AoNetRequest(String r100, String r110, AoFromSource r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, c r117, boolean r118, AoRequestType r119, d r210, long r211, long r212, long r213, boolean r214, String r215, boolean r216, Map<String, ? extends Object> r310) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r110, e.f25671s);
        Intrinsics.checkNotNullParameter(r111, "from");
        Intrinsics.checkNotNullParameter(r117, "headers");
        Intrinsics.checkNotNullParameter(r119, "requestLibType");
        Intrinsics.checkNotNullParameter(r310, "extraInfo");
        this.url = r100;
        this.method = r110;
        this.from = r111;
        this.responseStreaming = r112;
        this.addHostSecurityParams = r113;
        this.addHostCommonParams = r114;
        this.addHostMd5Stub = r115;
        this.addCommonParams = r116;
        this.headers = r117;
        this.reportMonitor = r118;
        this.requestLibType = r119;
        this.requestBody = r210;
        this.connectTimeOut = r211;
        this.readTimeOut = r212;
        this.writeTimeOut = r213;
        this.httpDns = r214;
        this.cacheAppId = r215;
        this.enableHttp2 = r216;
        this.extraInfo = r310;
    }
}
