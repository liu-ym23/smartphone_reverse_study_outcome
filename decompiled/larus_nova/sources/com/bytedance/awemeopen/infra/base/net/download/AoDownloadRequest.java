package com.bytedance.awemeopen.infra.base.net.download;

import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import q64.c;
import q64.d;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0001\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020*\u0012\b\u00101\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00103\u001a\u00020\u001c\u0012\u0006\u00105\u001a\u00020\u001c\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010#\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 R\u0017\u0010&\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R\u0019\u00101\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0007R\u0017\u00103\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b3\u0010\u001e\u001a\u0004\b4\u0010 R\u0017\u00105\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010 R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/download/AoDownloadRequest;", "", "", "toString", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "Ljava/io/File;", "targetFile", "Ljava/io/File;", "getTargetFile", "()Ljava/io/File;", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "from", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "getFrom", "()Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "Lq64/d;", ContainerPosition.BODY, "Lq64/d;", "getBody", "()Lq64/d;", "Lq64/c;", "headers", "Lq64/c;", "getHeaders", "()Lq64/c;", "", "addHostSecurityParams", "Z", "getAddHostSecurityParams", "()Z", "addHostCommonParams", "getAddHostCommonParams", "addBdpCommonParams", "getAddBdpCommonParams", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "requestLibType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "getRequestLibType", "()Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "", "timeout", "J", "getTimeout", "()J", "maxLength", "getMaxLength", "md5", "getMd5", "verifyHttpCode", "getVerifyHttpCode", "enableHttp2", "getEnableHttp2", "", "priority", "I", "getPriority", "()I", "<init>", "(Ljava/lang/String;Ljava/io/File;Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;Lq64/d;Lq64/c;ZZZLcom/bytedance/awemeopen/infra/base/net/AoRequestType;JJLjava/lang/String;ZZI)V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoDownloadRequest {
    private final boolean addBdpCommonParams;
    private final boolean addHostCommonParams;
    private final boolean addHostSecurityParams;
    private final d body;
    private final boolean enableHttp2;
    private final AoFromSource from;
    private final c headers;
    private final long maxLength;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private final String f198691md5;
    private final int priority;
    private final AoRequestType requestLibType;
    private final File targetFile;
    private final long timeout;
    private final String url;
    private final boolean verifyHttpCode;

    public /* synthetic */ AoDownloadRequest(String r100, File r101, AoFromSource r102, d r103, c r104, boolean r105, boolean r106, boolean r107, AoRequestType r108, long r110, long r111, String r112, boolean r113, boolean r114, int r115, DefaultConstructorMarker r116) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115);
    }

    public String toString() {
        return "BdpDownloadRequest(url='" + this.url + "', targetFile=" + this.targetFile + ", from=" + this.from + ", body=" + this.body + ", headers=" + this.headers + ", addHostSecurityParams=" + this.addHostSecurityParams + ", addHostCommonParams=" + this.addHostCommonParams + ", addBdpCommonParams=" + this.addBdpCommonParams + ", requestLibType=" + this.requestLibType + ", timeout=" + this.timeout + ", maxLength=" + this.maxLength + ", md5=" + this.f198691md5 + ", verifyHttpCode=" + this.verifyHttpCode + ", priority=" + this.priority + ')';
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

    public final d getBody() {
        return this.body;
    }

    public final boolean getEnableHttp2() {
        return this.enableHttp2;
    }

    public final AoFromSource getFrom() {
        return this.from;
    }

    public final c getHeaders() {
        return this.headers;
    }

    public final long getMaxLength() {
        return this.maxLength;
    }

    public final String getMd5() {
        return this.f198691md5;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final AoRequestType getRequestLibType() {
        return this.requestLibType;
    }

    public final File getTargetFile() {
        return this.targetFile;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getVerifyHttpCode() {
        return this.verifyHttpCode;
    }

    private AoDownloadRequest(String r100, File r101, AoFromSource r102, d r103, c r104, boolean r105, boolean r110, boolean r111, AoRequestType r112, long r113, long r114, String r115, boolean r116, boolean r117, int r210) {
        this.url = r100;
        this.targetFile = r101;
        this.from = r102;
        this.body = r103;
        this.headers = r104;
        this.addHostSecurityParams = r105;
        this.addHostCommonParams = r110;
        this.addBdpCommonParams = r111;
        this.requestLibType = r112;
        this.timeout = r113;
        this.maxLength = r114;
        this.f198691md5 = r115;
        this.verifyHttpCode = r116;
        this.enableHttp2 = r117;
        this.priority = r210;
    }
}
