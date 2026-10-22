package com.bytedance.awemeopen.infra.base.net.upload;

import com.alipay.sdk.m.p.e;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import q64.d;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001Bq\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020'\u0012\u0006\u0010.\u001a\u00020\u0019\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010 \u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R\u0017\u0010.\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001dR\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/upload/AoUploadRequest;", "", "", "toString", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", e.f25671s, "getMethod", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "from", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "getFrom", "()Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "Lq64/d;", ContainerPosition.BODY, "Lq64/d;", "getBody", "()Lq64/d;", "Lq64/c;", "headers", "Lq64/c;", "getHeaders", "()Lq64/c;", "", "addHostSecurityParams", "Z", "getAddHostSecurityParams", "()Z", "addHostCommonParams", "getAddHostCommonParams", "addAoCommonParams", "getAddAoCommonParams", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "requestLibType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "getRequestLibType", "()Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "", "timeout", "J", "getTimeout", "()J", "maxLength", "getMaxLength", "enableHttp2", "getEnableHttp2", "", "priority", "I", "getPriority", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;Lq64/d;Lq64/c;ZZZLcom/bytedance/awemeopen/infra/base/net/AoRequestType;JJZI)V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoUploadRequest {
    private final boolean addAoCommonParams;
    private final boolean addHostCommonParams;
    private final boolean addHostSecurityParams;
    private final d body;
    private final boolean enableHttp2;
    private final AoFromSource from;
    private final q64.c headers;
    private final long maxLength;
    private final String method;
    private final int priority;
    private final AoRequestType requestLibType;
    private final long timeout;
    private final String url;

    public /* synthetic */ AoUploadRequest(String r100, String r101, AoFromSource r102, d r103, q64.c r104, boolean r105, boolean r106, boolean r107, AoRequestType r108, long r110, long r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113);
    }

    public String toString() {
        return "AoUploadRequest(url='" + this.url + "', method='" + this.method + "', from=" + this.from + ", addHostSecurityParams=" + this.addHostSecurityParams + ", addHostCommonParams=" + this.addHostCommonParams + ", addAoCommonParams=" + this.addAoCommonParams + ", headers=" + this.headers + ", requestLibType=" + this.requestLibType + ", requestBody=" + this.body + ", timeout=" + this.timeout + ", priority=" + this.priority + ", maxLength=" + this.maxLength;
    }

    public final boolean getAddAoCommonParams() {
        return this.addAoCommonParams;
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

    public final q64.c getHeaders() {
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

    public final AoRequestType getRequestLibType() {
        return this.requestLibType;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final String getUrl() {
        return this.url;
    }

    private AoUploadRequest(String r100, String r101, AoFromSource r102, d r103, q64.c r104, boolean r105, boolean r106, boolean r107, AoRequestType r108, long r110, long r111, boolean r112, int r113) {
        this.url = r100;
        this.method = r101;
        this.from = r102;
        this.body = r103;
        this.headers = r104;
        this.addHostSecurityParams = r105;
        this.addHostCommonParams = r106;
        this.addAoCommonParams = r107;
        this.requestLibType = r108;
        this.timeout = r110;
        this.maxLength = r111;
        this.enableHttp2 = r112;
        this.priority = r113;
    }
}
