package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming;

import a95.a;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.vfs.VFSFile;
import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class StreamingCache implements NonProguard {
    private DriveFilePath filePath;

    @SerializedName("is_limited")
    private boolean isLimit;
    private long previewFileSize;
    private String streamingUrl;

    public String toString() {
        return "StreamingCache{streamingUrl='" + b.g(this.streamingUrl) + "', filePath='" + b.f(this.filePath) + "', previewFileSize=" + this.previewFileSize + ", isLimit=" + this.isLimit + '}';
    }

    public StreamingCache() {
    }

    public DriveFilePath getFilePath() {
        return this.filePath;
    }

    public long getPreviewFileSize() {
        return this.previewFileSize;
    }

    public String getStreamingUrl() {
        return this.streamingUrl;
    }

    public boolean isLimit() {
        return this.isLimit;
    }

    public boolean check(a r7) {
        DriveFilePath r0 = this.filePath;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r0.getFileName()) == true) goto L22;
        VFSFile r1 = z75.b.e(this.filePath, r7.b);
        if (URLUtil.isNetworkUrl(this.streamingUrl) == true) goto L10;
        return false;
    L10:
        if (z75.b.d(this.filePath, r7.b) == false) goto L19;
        long r2 = this.previewFileSize;
        if (r2 > 0) goto L14;
        return false;
    L14:
        if (r2 != r1.length()) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L22:
        return false;
    }

    public void setFilePath(DriveFilePath r1) {
        this.filePath = r1;
    }

    public void setLimit(boolean r1) {
        this.isLimit = r1;
    }

    public void setPreviewFileSize(long r1) {
        this.previewFileSize = r1;
    }

    public void setStreamingUrl(String r1) {
        this.streamingUrl = r1;
    }

    public StreamingCache(String r1, DriveFilePath r2, long r3) {
        this.streamingUrl = r1;
        this.filePath = r2;
        this.previewFileSize = r3;
    }
}
