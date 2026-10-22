package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public class HttpResponse {
    public final IDownloadHeadHttpConnection connection;
    private long contentLength;
    public final int responseCode;
    private long totalLength;
    public final String url;

    public boolean acceptPartial() {
        return DownloadHelper.canAcceptPartial(this.responseCode, this.connection.getResponseHeaderField(DownloadHelper.ACCEPT_RANGES));
    }

    public String getCacheControl() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Cache-Control");
    }

    public String getContentEncoding() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Content-Encoding");
    }

    public long getContentLength() {
        if (this.contentLength > 0) goto L6;
        this.contentLength = DownloadUtils.getContentLength(this.connection);
    L6:
        return this.contentLength;
    }

    public String getContentRange() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Content-Range");
    }

    public String getContentType() {
        return this.connection.getResponseHeaderField("Content-Type");
    }

    public String getEtag() {
        return this.connection.getResponseHeaderField(DownloadHelper.ETAG);
    }

    public String getLastModified() {
        String r100 = DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "last-modified");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Last-Modified");
    }

    public long getTotalLength() {
        if (this.totalLength > 0) goto L11;
        if (isChunked() == true) goto L9;
        String r100 = getContentRange();
        if (TextUtils.isEmpty(r100) == true) goto L11;
        this.totalLength = DownloadHelper.parseContentRangeOfInstanceLength(r100);
        goto L11
    L9:
        this.totalLength = -1;
    L11:
        return this.totalLength;
    }

    public long getXContentLength() {
        String r100 = DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, DownloadHelper.X_CONTENT_LENGTH);
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L6:
        return -1;
    L9:
        return CastLongProtector.parseLong(r100);
    }

    public boolean isChunked() {
        return DownloadHelper.isChunkedTask(this.connection);
    }

    public boolean isResponseDataFromBegin() {
        return DownloadHelper.isResponseDataFromBegin(this.responseCode);
    }

    public long getMaxAge() {
        return DownloadHelper.parserMaxAge(getCacheControl());
    }

    public HttpResponse(String r100, IDownloadHeadHttpConnection r101) throws IOException {
        this.url = r100;
        this.responseCode = r101.getResponseCode();
        this.connection = r101;
    }

    public HttpResponse(String r100, IDownloadHeadHttpConnection r101, int r102) {
        this.url = r100;
        this.responseCode = r102;
        this.connection = r101;
    }
}
