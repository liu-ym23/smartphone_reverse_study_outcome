package com.bytedance.bdp.appbase.network.download;

import com.bytedance.bdp.appbase.network.BdpRequestType;
import com.lynx.tasm.LynxError;
import gb4.c;
import gb4.d;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u0004\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/bytedance/bdp/appbase/network/download/BdpDownloadResponse;", "", "", "isNetSuccessFul", "isSuccessful", "", "toString", "", "code", "I", "getCode", "()I", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Ljava/io/File;", "targetFile", "Ljava/io/File;", "getTargetFile", "()Ljava/io/File;", "Lgb4/c;", "headers", "Lgb4/c;", "getHeaders", "()Lgb4/c;", "contentType", "getContentType", "", "contentLength", "J", "getContentLength", "()J", "", LynxError.LYNX_THROWABLE, "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "libType", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "getLibType", "()Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "Lgb4/d;", "metric", "Lgb4/d;", "getMetric", "()Lgb4/d;", "<init>", "(ILjava/lang/String;Ljava/io/File;Lgb4/c;Ljava/lang/String;JLjava/lang/Throwable;Lcom/bytedance/bdp/appbase/network/BdpRequestType;Lgb4/d;)V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpDownloadResponse {
    private final int code;
    private final long contentLength;
    private final String contentType;
    private final c headers;
    private final BdpRequestType libType;
    private final String message;
    private final d metric;
    private final File targetFile;
    private final Throwable throwable;

    public final boolean isNetSuccessFul() {
        if (this.throwable != null) goto L10;
        int r100 = this.code;
        if (200 > r100) goto L10;
        if (299 < r100) goto L10;
        return true;
    L10:
        return false;
    }

    public String toString() {
        return "BdpDownloadResponse(code=" + this.code + ", message='" + this.message + "', targetFile=" + this.targetFile + ", headers=" + this.headers + ", contentType=" + this.contentType + ", contentLength=" + this.contentLength + ", throwable=" + this.throwable + ", libType=" + this.libType + ", metric=" + this.metric + ')';
    }

    public final boolean isSuccessful() {
        if (isNetSuccessFul() == false) goto L9;
        File r100 = this.targetFile;
        if (r100 == null) goto L9;
        if (r100.exists() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final String getContentType() {
        return this.contentType;
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

    public final File getTargetFile() {
        return this.targetFile;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public BdpDownloadResponse(int r100, String r101, File r102, c r103, String r104, long r105, Throwable r106, BdpRequestType r107, d r110) {
        this.code = r100;
        this.message = r101;
        this.targetFile = r102;
        this.headers = r103;
        this.contentType = r104;
        this.contentLength = r105;
        this.throwable = r106;
        this.libType = r107;
        this.metric = r110;
    }
}
