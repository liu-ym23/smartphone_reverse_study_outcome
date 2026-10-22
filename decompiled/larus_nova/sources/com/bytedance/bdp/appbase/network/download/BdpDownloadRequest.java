package com.bytedance.bdp.appbase.network.download;

import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.BdpRequestType;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import gb4.c;
import gb4.e;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u009b\u0001\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020#\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00106\u001a\u000201\u0012\b\u00108\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010:\u001a\u00020#\u0012\u0006\u0010<\u001a\u00020#\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R\u0017\u0010*\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b6\u00103\u001a\u0004\b7\u00105R\u0019\u00108\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b8\u0010\n\u001a\u0004\b9\u0010\fR\u0017\u0010:\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b:\u0010%\u001a\u0004\b;\u0010'R\u0017\u0010<\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b<\u0010%\u001a\u0004\b=\u0010'R\u0017\u0010?\u001a\u00020>8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/bytedance/bdp/appbase/network/download/BdpDownloadRequest;", "", "", "toString", "Lcom/bytedance/bdp/appbase/core/a;", "appInfo", "Lcom/bytedance/bdp/appbase/core/a;", "getAppInfo", "()Lcom/bytedance/bdp/appbase/core/a;", "uniqueId", "Ljava/lang/String;", "getUniqueId", "()Ljava/lang/String;", "url", "getUrl", "Ljava/io/File;", "targetFile", "Ljava/io/File;", "getTargetFile", "()Ljava/io/File;", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "from", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "getFrom", "()Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "Lgb4/e;", ContainerPosition.BODY, "Lgb4/e;", "getBody", "()Lgb4/e;", "Lgb4/c;", "headers", "Lgb4/c;", "getHeaders", "()Lgb4/c;", "", "addHostSecurityParams", "Z", "getAddHostSecurityParams", "()Z", "addHostCommonParams", "getAddHostCommonParams", "addBdpCommonParams", "getAddBdpCommonParams", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "requestLibType", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "getRequestLibType", "()Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "", "timeout", "J", "getTimeout", "()J", "maxLength", "getMaxLength", "md5", "getMd5", "verifyHttpCode", "getVerifyHttpCode", "enableHttp2", "getEnableHttp2", "", "priority", "I", "getPriority", "()I", "<init>", "(Lcom/bytedance/bdp/appbase/core/a;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lcom/bytedance/bdp/appbase/network/BdpFromSource;Lgb4/e;Lgb4/c;ZZZLcom/bytedance/bdp/appbase/network/BdpRequestType;JJLjava/lang/String;ZZI)V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpDownloadRequest {
    private final boolean addBdpCommonParams;
    private final boolean addHostCommonParams;
    private final boolean addHostSecurityParams;
    private final com.bytedance.bdp.appbase.core.a appInfo;
    private final e body;
    private final boolean enableHttp2;
    private final BdpFromSource from;
    private final c headers;
    private final long maxLength;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private final String f200884md5;
    private final int priority;
    private final BdpRequestType requestLibType;
    private final File targetFile;
    private final long timeout;
    private final String uniqueId;
    private final String url;
    private final boolean verifyHttpCode;

    public String toString() {
        StringBuilder r100 = new StringBuilder("BdpDownloadRequest(appInfo=");
        com.bytedance.bdp.appbase.core.a r101 = this.appInfo;
        if (r101 == null) goto L5;
        r101.getAppId();
    L5:
        r100.append(null);
        r100.append(", uniqueId=");
        r100.append(this.uniqueId);
        r100.append(", url='");
        r100.append(this.url);
        r100.append("', targetFile=");
        r100.append(this.targetFile);
        r100.append(", from=");
        r100.append(this.from);
        r100.append(", body=");
        r100.append(this.body);
        r100.append(", headers=");
        r100.append(this.headers);
        r100.append(", addHostSecurityParams=");
        r100.append(this.addHostSecurityParams);
        r100.append(", addHostCommonParams=");
        r100.append(this.addHostCommonParams);
        r100.append(", addBdpCommonParams=");
        r100.append(this.addBdpCommonParams);
        r100.append(", requestLibType=");
        r100.append(this.requestLibType);
        r100.append(", timeout=");
        r100.append(this.timeout);
        r100.append(", maxLength=");
        r100.append(this.maxLength);
        r100.append(", md5=");
        r100.append(this.f200884md5);
        r100.append(", verifyHttpCode=");
        r100.append(this.verifyHttpCode);
        r100.append(", priority=");
        r100.append(this.priority);
        r100.append(')');
        return r100.toString();
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

    public final com.bytedance.bdp.appbase.core.a getAppInfo() {
        return this.appInfo;
    }

    public final e getBody() {
        return this.body;
    }

    public final boolean getEnableHttp2() {
        return this.enableHttp2;
    }

    public final BdpFromSource getFrom() {
        return this.from;
    }

    public final c getHeaders() {
        return this.headers;
    }

    public final long getMaxLength() {
        return this.maxLength;
    }

    public final String getMd5() {
        return this.f200884md5;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final BdpRequestType getRequestLibType() {
        return this.requestLibType;
    }

    public final File getTargetFile() {
        return this.targetFile;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getVerifyHttpCode() {
        return this.verifyHttpCode;
    }

    private BdpDownloadRequest(com.bytedance.bdp.appbase.core.a r100, String r101, String r102, File r103, BdpFromSource r104, e r105, c r110, boolean r111, boolean r112, boolean r113, BdpRequestType r114, long r115, long r116, String r117, boolean r210, boolean r211, int r212) {
        this.appInfo = r100;
        this.uniqueId = r101;
        this.url = r102;
        this.targetFile = r103;
        this.from = r104;
        this.body = r105;
        this.headers = r110;
        this.addHostSecurityParams = r111;
        this.addHostCommonParams = r112;
        this.addBdpCommonParams = r113;
        this.requestLibType = r114;
        this.timeout = r115;
        this.maxLength = r116;
        this.f200884md5 = r117;
        this.verifyHttpCode = r210;
        this.enableHttp2 = r211;
        this.priority = r212;
    }

    public /* synthetic */ BdpDownloadRequest(com.bytedance.bdp.appbase.core.a r100, String r101, String r102, File r103, BdpFromSource r104, e r105, c r106, boolean r107, boolean r108, boolean r110, BdpRequestType r111, long r112, long r113, String r114, boolean r115, boolean r116, int r117, DefaultConstructorMarker r210) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
