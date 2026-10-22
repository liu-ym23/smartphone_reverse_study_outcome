package com.bytedance.bdp.appbase.network;

import com.alipay.sdk.m.p.e;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import gb4.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001TBí\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010,\u001a\u00020\u000f\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010=\u001a\u000208\u0012\u0006\u0010?\u001a\u000208\u0012\u0006\u0010A\u001a\u00020\u000f\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010E\u001a\u00020\u000f\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010K\u001a\u0004\u0018\u00010\u000f\u0012\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010M¢\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R\u0019\u0010&\u001a\u0004\u0018\u00010%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010*\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0007R\u0017\u0010,\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013R\u0017\u0010/\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0019\u00104\u001a\u0004\u0018\u0001038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u00109\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010=\u001a\u0002088\u0006¢\u0006\f\n\u0004\b=\u0010:\u001a\u0004\b>\u0010<R\u0017\u0010?\u001a\u0002088\u0006¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010<R\u0017\u0010A\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\bA\u0010\u0011\u001a\u0004\bB\u0010\u0013R\u0019\u0010C\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010\u0007R\u0017\u0010E\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bF\u0010\u0013R\u0019\u0010G\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0019\u0010K\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\bK\u0010H\u001a\u0004\bL\u0010JR%\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010M8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpNetRequest;", "", "", "toString", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", e.f25671s, "getMethod", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "from", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "getFrom", "()Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "", "responseStreaming", "Z", "getResponseStreaming", "()Z", "addHostSecurityParams", "getAddHostSecurityParams", "addHostCommonParams", "getAddHostCommonParams", "addHostMd5Stub", "getAddHostMd5Stub", "addBdpCommonParams", "getAddBdpCommonParams", "withRequestEncrypt", "getWithRequestEncrypt", "Lgb4/c;", "headers", "Lgb4/c;", "getHeaders", "()Lgb4/c;", "uniqueId", "getUniqueId", "Lcom/bytedance/bdp/appbase/core/a;", "appInfo", "Lcom/bytedance/bdp/appbase/core/a;", "getAppInfo", "()Lcom/bytedance/bdp/appbase/core/a;", "appId", "getAppId", "reportMonitor", "getReportMonitor", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "requestLibType", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "getRequestLibType", "()Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "Lgb4/e;", "requestBody", "Lgb4/e;", "getRequestBody", "()Lgb4/e;", "", "connectTimeOut", "J", "getConnectTimeOut", "()J", "readTimeOut", "getReadTimeOut", "writeTimeOut", "getWriteTimeOut", "httpDns", "getHttpDns", "cacheAppId", "getCacheAppId", "enableHttp2", "getEnableHttp2", "dyeTagType", "Ljava/lang/Boolean;", "getDyeTagType", "()Ljava/lang/Boolean;", "fromWebView", "getFromWebView", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/bdp/appbase/network/BdpFromSource;ZZZZZZLgb4/c;Ljava/lang/String;Lcom/bytedance/bdp/appbase/core/a;Ljava/lang/String;ZLcom/bytedance/bdp/appbase/network/BdpRequestType;Lgb4/e;JJJZLjava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpNetRequest {
    private final boolean addBdpCommonParams;
    private final boolean addHostCommonParams;
    private final boolean addHostMd5Stub;
    private final boolean addHostSecurityParams;
    private final String appId;
    private final com.bytedance.bdp.appbase.core.a appInfo;
    private final String cacheAppId;
    private final long connectTimeOut;
    private final Boolean dyeTagType;
    private final boolean enableHttp2;
    private final Map<String, Object> extraInfo;
    private final BdpFromSource from;
    private final Boolean fromWebView;
    private final c headers;
    private final boolean httpDns;
    private final String method;
    private final long readTimeOut;
    private final boolean reportMonitor;
    private final gb4.e requestBody;
    private final BdpRequestType requestLibType;
    private final boolean responseStreaming;
    private final String uniqueId;
    private final String url;
    private final boolean withRequestEncrypt;
    private final long writeTimeOut;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f200855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f200856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.bdp.appbase.core.a f200857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f200858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f200859e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final BdpFromSource f200860f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f200861g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f200862h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f200863i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f200864j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f200865k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f200866l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f200867m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f200868n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public c.a f200869o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f200870p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public BdpRequestType f200871q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public gb4.e f200872r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f200873s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f200874t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Boolean f200875u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Boolean f200876v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final Map<String, Object> f200877w;

        public final BdpNetRequest a() {
            return new BdpNetRequest(this.f200855a, this.f200859e, this.f200860f, this.f200861g, this.f200863i, this.f200864j, false, this.f200865k, false, this.f200869o.b(), this.f200856b, this.f200857c, this.f200858d, this.f200870p, this.f200871q, this.f200872r, this.f200866l, this.f200868n, this.f200867m, this.f200862h, this.f200873s, this.f200874t, this.f200875u, this.f200876v, this.f200877w);
        }

        public final void b(Map r100) {
            c.a r101 = this.f200869o;
            ((ArrayList) r101.f480685a).clear();
            Iterator r102 = r100.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            Map.Entry r103 = (Map.Entry) r102.next();
            r101.a((String) r103.getKey(), (String) r103.getValue());
            goto L4
        }

        public final a delete(gb4.e r100) {
            this.f200859e = "DELETE";
            this.f200872r = r100;
            return this;
        }

        public a(BdpAppContext r100, String r101, BdpFromSource r102) {
            com.bytedance.bdp.appbase.core.a r103 = null;
            if (r100 == null) goto L5;
            String r104 = r100.f200762b;
        L6:
            if (r100 == null) goto L8;
            r103 = r100.b();
        L8:
            this(r101, r102, r104, r103);
            return;
        L5:
            r104 = null;
            goto L6
        }

        public a(String r100, BdpFromSource r101, String r102, com.bytedance.bdp.appbase.core.a r103) {
            this.f200856b = r102;
            this.f200857c = r103;
            if (r103 == null) goto L5;
            r103.getAppId();
        L5:
            this.f200858d = null;
            this.f200855a = r100;
            this.f200860f = r101;
            this.f200859e = "GET";
            this.f200866l = 60000;
            this.f200867m = 60000;
            this.f200868n = 60000;
            this.f200861g = false;
            this.f200862h = true;
            this.f200863i = true;
            this.f200864j = false;
            this.f200865k = false;
            this.f200869o = new c.a();
            this.f200870p = true;
            this.f200871q = BdpRequestType.HOST;
            this.f200872r = null;
            this.f200873s = null;
            this.f200874t = false;
            this.f200875u = null;
            this.f200876v = Boolean.FALSE;
            this.f200877w = new HashMap();
        }
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("BdpRequest(url='");
        r100.append(this.url);
        r100.append("', method='");
        r100.append(this.method);
        r100.append("', from=");
        r100.append(this.from);
        r100.append(", responseStreaming=");
        r100.append(this.responseStreaming);
        r100.append(", addHostSecurityParams=");
        r100.append(this.addHostSecurityParams);
        r100.append(", addHostCommonParams=");
        r100.append(this.addHostCommonParams);
        r100.append(", addHostMd5Stub=");
        r100.append(this.addHostMd5Stub);
        r100.append(", addBdpCommonParams=");
        r100.append(this.addBdpCommonParams);
        r100.append(", withRequestEncrypt=");
        r100.append(this.withRequestEncrypt);
        r100.append(", headers=");
        r100.append(this.headers);
        r100.append(", reportMonitor=");
        r100.append(this.reportMonitor);
        r100.append(", requestLibType=");
        r100.append(this.requestLibType);
        r100.append(", requestBody=");
        r100.append(this.requestBody);
        r100.append(", connectTimeOut=");
        r100.append(this.connectTimeOut);
        r100.append(", readTimeOut=");
        r100.append(this.readTimeOut);
        r100.append(", writeTimeOut=");
        r100.append(this.writeTimeOut);
        r100.append(", httpDns=");
        r100.append(this.httpDns);
        r100.append(", cacheAppId=");
        r100.append(this.cacheAppId);
        r100.append(", enableHttp2=");
        r100.append(this.enableHttp2);
        r100.append(", dyeTagType=");
        r100.append(this.dyeTagType);
        r100.append(", fromWebView=");
        r100.append(this.fromWebView);
        r100.append(", context=(");
        r100.append(this.uniqueId);
        r100.append(", ");
        String r101 = this.appId;
        if (r101 != null) goto L8;
        com.bytedance.bdp.appbase.core.a r102 = this.appInfo;
        if (r102 == null) goto L7;
        r102.getAppId();
    L7:
        r101 = null;
    L8:
        r100.append(r101);
        r100.append(")extraInfo=");
        r100.append(this.extraInfo);
        r100.append(')');
        return r100.toString();
    }

    public final boolean getAddBdpCommonParams() {
        return this.addBdpCommonParams;
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

    public final String getAppId() {
        return this.appId;
    }

    public final com.bytedance.bdp.appbase.core.a getAppInfo() {
        return this.appInfo;
    }

    public final String getCacheAppId() {
        return this.cacheAppId;
    }

    public final long getConnectTimeOut() {
        return this.connectTimeOut;
    }

    public final Boolean getDyeTagType() {
        return this.dyeTagType;
    }

    public final boolean getEnableHttp2() {
        return this.enableHttp2;
    }

    public final Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final BdpFromSource getFrom() {
        return this.from;
    }

    public final Boolean getFromWebView() {
        return this.fromWebView;
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

    public final gb4.e getRequestBody() {
        return this.requestBody;
    }

    public final BdpRequestType getRequestLibType() {
        return this.requestLibType;
    }

    public final boolean getResponseStreaming() {
        return this.responseStreaming;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getWithRequestEncrypt() {
        return this.withRequestEncrypt;
    }

    public final long getWriteTimeOut() {
        return this.writeTimeOut;
    }

    public BdpNetRequest(String r100, String r101, BdpFromSource r102, boolean r103, boolean r104, boolean r105, boolean r110, boolean r111, boolean r112, c r113, String r114, com.bytedance.bdp.appbase.core.a r115, String r116, boolean r117, BdpRequestType r118, gb4.e r119, long r210, long r211, long r212, boolean r213, String r214, boolean r215, Boolean r216, Boolean r310, Map<String, ? extends Object> r311) {
        this.url = r100;
        this.method = r101;
        this.from = r102;
        this.responseStreaming = r103;
        this.addHostSecurityParams = r104;
        this.addHostCommonParams = r105;
        this.addHostMd5Stub = r110;
        this.addBdpCommonParams = r111;
        this.withRequestEncrypt = r112;
        this.headers = r113;
        this.uniqueId = r114;
        this.appInfo = r115;
        this.appId = r116;
        this.reportMonitor = r117;
        this.requestLibType = r118;
        this.requestBody = r119;
        this.connectTimeOut = r210;
        this.readTimeOut = r211;
        this.writeTimeOut = r212;
        this.httpDns = r213;
        this.cacheAppId = r214;
        this.enableHttp2 = r215;
        this.dyeTagType = r216;
        this.fromWebView = r310;
        this.extraInfo = r311;
    }

    public /* synthetic */ BdpNetRequest(String r310, String r311, BdpFromSource r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, c r410, String r411, com.bytedance.bdp.appbase.core.a r412, String r413, boolean r414, BdpRequestType r415, gb4.e r416, long r417, long r418, long r510, boolean r511, String r512, boolean r513, Boolean r514, Boolean r515, Map r516, int r517, DefaultConstructorMarker r610) {
        if ((r517 & 4194304) == 0) goto L5;
        Boolean r210 = null;
    L6:
        this(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r210, r515, r516);
        return;
    L5:
        r210 = r514;
        goto L6
    }
}
