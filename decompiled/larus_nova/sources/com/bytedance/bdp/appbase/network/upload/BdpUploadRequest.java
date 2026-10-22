package com.bytedance.bdp.appbase.network.upload;

import com.alipay.sdk.m.p.e;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.BdpRequestType;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B{\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\u001e\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u00103\u001a\u00020\u001e\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010%\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u00101\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u0017\u00103\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b3\u0010 \u001a\u0004\b4\u0010\"R\u0017\u00106\u001a\u0002058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/bytedance/bdp/appbase/network/upload/BdpUploadRequest;", "", "", "toString", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "appContext", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "getAppContext", "()Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", e.f25671s, "getMethod", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "from", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "getFrom", "()Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "Lgb4/e;", ContainerPosition.BODY, "Lgb4/e;", "getBody", "()Lgb4/e;", "Lgb4/c;", "headers", "Lgb4/c;", "getHeaders", "()Lgb4/c;", "", "addHostSecurityParams", "Z", "getAddHostSecurityParams", "()Z", "addHostCommonParams", "getAddHostCommonParams", "addBdpCommonParams", "getAddBdpCommonParams", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "requestLibType", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "getRequestLibType", "()Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "", "timeout", "J", "getTimeout", "()J", "maxLength", "getMaxLength", "enableHttp2", "getEnableHttp2", "", "priority", "I", "getPriority", "()I", "<init>", "(Lcom/bytedance/bdp/appbase/context/BdpAppContext;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/bdp/appbase/network/BdpFromSource;Lgb4/e;Lgb4/c;ZZZLcom/bytedance/bdp/appbase/network/BdpRequestType;JJZI)V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpUploadRequest {
    private final boolean addBdpCommonParams;
    private final boolean addHostCommonParams;
    private final boolean addHostSecurityParams;
    private final BdpAppContext appContext;
    private final gb4.e body;
    private final boolean enableHttp2;
    private final BdpFromSource from;
    private final gb4.c headers;
    private final long maxLength;
    private final String method;
    private final int priority;
    private final BdpRequestType requestLibType;
    private final long timeout;
    private final String url;

    public String toString() {
        StringBuilder r100 = new StringBuilder("BdpUploadRequest(url='");
        r100.append(this.url);
        r100.append("', method='");
        r100.append(this.method);
        r100.append("', from=");
        r100.append(this.from);
        r100.append(", addHostSecurityParams=");
        r100.append(this.addHostSecurityParams);
        r100.append(", addHostCommonParams=");
        r100.append(this.addHostCommonParams);
        r100.append(", addBdpCommonParams=");
        r100.append(this.addBdpCommonParams);
        r100.append(", headers=");
        r100.append(this.headers);
        r100.append(", requestLibType=");
        r100.append(this.requestLibType);
        r100.append(", requestBody=");
        r100.append(this.body);
        r100.append(", timeout=");
        r100.append(this.timeout);
        r100.append(", context=(");
        BdpAppContext r101 = this.appContext;
        if (r101 == null) goto L5;
        String r102 = r101.f200762b;
    L6:
        r100.append(r102);
        r100.append(", ");
        BdpAppContext r103 = this.appContext;
        if (r103 == null) goto L11;
        com.bytedance.bdp.appbase.core.a r104 = r103.b();
        if (r104 == null) goto L11;
        r104.getAppId();
    L11:
        r100.append(null);
        r100.append("), priority=");
        r100.append(this.priority);
        r100.append(", maxLength=");
        r100.append(this.maxLength);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean getAddBdpCommonParams() {
        return this.addBdpCommonParams;
    }

    public final boolean getAddHostCommonParams() {
        return this.addHostCommonParams;
    }

    public final boolean getAddHostSecurityParams() {
        return this.addHostSecurityParams;
    }

    public final BdpAppContext getAppContext() {
        return this.appContext;
    }

    public final gb4.e getBody() {
        return this.body;
    }

    public final boolean getEnableHttp2() {
        return this.enableHttp2;
    }

    public final BdpFromSource getFrom() {
        return this.from;
    }

    public final gb4.c getHeaders() {
        return this.headers;
    }

    public final long getMaxLength() {
        return this.maxLength;
    }

    public final String getMethod() {
        return this.method;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final BdpRequestType getRequestLibType() {
        return this.requestLibType;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final String getUrl() {
        return this.url;
    }

    private BdpUploadRequest(BdpAppContext r100, String r101, String r102, BdpFromSource r103, gb4.e r104, gb4.c r105, boolean r110, boolean r111, boolean r112, BdpRequestType r113, long r114, long r115, boolean r116, int r117) {
        this.appContext = r100;
        this.url = r101;
        this.method = r102;
        this.from = r103;
        this.body = r104;
        this.headers = r105;
        this.addHostSecurityParams = r110;
        this.addHostCommonParams = r111;
        this.addBdpCommonParams = r112;
        this.requestLibType = r113;
        this.timeout = r114;
        this.maxLength = r115;
        this.enableHttp2 = r116;
        this.priority = r117;
    }

    public /* synthetic */ BdpUploadRequest(BdpAppContext r100, String r101, String r102, BdpFromSource r103, gb4.e r104, gb4.c r105, boolean r106, boolean r107, boolean r108, BdpRequestType r110, long r111, long r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114);
    }
}
