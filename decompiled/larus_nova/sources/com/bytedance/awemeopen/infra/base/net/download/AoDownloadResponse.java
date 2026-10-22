package com.bytedance.awemeopen.infra.base.net.download;

import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.lynx.tasm.LynxError;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q64.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010%\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/download/AoDownloadResponse;", "", "", "isNetSuccessFul", "isSuccessful", "", "toString", "", "code", "I", "getCode", "()I", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Ljava/io/File;", "targetFile", "Ljava/io/File;", "getTargetFile", "()Ljava/io/File;", "Lq64/c;", "headers", "Lq64/c;", "getHeaders", "()Lq64/c;", "", "contentLength", "J", "getContentLength", "()J", "", LynxError.LYNX_THROWABLE, "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "libType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "getLibType", "()Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkMetric;", "metric", "Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkMetric;", "getMetric", "()Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkMetric;", "<init>", "(ILjava/lang/String;Ljava/io/File;Lq64/c;JLjava/lang/Throwable;Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkMetric;)V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoDownloadResponse {
    private final int code;
    private final long contentLength;
    private final c headers;
    private final AoRequestType libType;
    private final String message;
    private final AoNetworkMetric metric;
    private final File targetFile;
    private final Throwable throwable;

    public final boolean isNetSuccessFul() {
        if (this.throwable != null) goto L13;
        int r100 = this.code;
        if (200 <= r100) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100 >= 300) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    public String toString() {
        return "BdpDownloadResponse(code=" + this.code + ", message='" + this.message + "', targetFile=" + this.targetFile + ", headers=" + this.headers + ", contentLength=" + this.contentLength + ", throwable=" + this.throwable + ", libType=" + this.libType + ", metric=" + this.metric + ')';
    }

    public final boolean isSuccessful() {
        if (isNetSuccessFul() == false) goto L13;
        File r100 = this.targetFile;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.exists() != true) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final c getHeaders() {
        return this.headers;
    }

    public final AoRequestType getLibType() {
        return this.libType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final AoNetworkMetric getMetric() {
        return this.metric;
    }

    public final File getTargetFile() {
        return this.targetFile;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public AoDownloadResponse(int r100, String r101, File r102, c r103, long r104, Throwable r105, AoRequestType r106, AoNetworkMetric r110) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r103, "headers");
        Intrinsics.checkNotNullParameter(r106, "libType");
        Intrinsics.checkNotNullParameter(r110, "metric");
        this.code = r100;
        this.message = r101;
        this.targetFile = r102;
        this.headers = r103;
        this.contentLength = r104;
        this.throwable = r105;
        this.libType = r106;
        this.metric = r110;
    }
}
