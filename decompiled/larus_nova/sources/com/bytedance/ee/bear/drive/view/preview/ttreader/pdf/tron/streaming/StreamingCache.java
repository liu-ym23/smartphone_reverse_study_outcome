package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming;

import a95.a;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.vfs.VFSFile;
import du5.b;

/* JADX INFO: loaded from: classes16.dex */
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

    public boolean check(a r100) {
        DriveFilePath r101 = this.filePath;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101.getFileName()) == true) goto L22;
        VFSFile r102 = z75.b.e(this.filePath, r100.f2278b);
        if (URLUtil.isNetworkUrl(this.streamingUrl) == true) goto L10;
        return false;
    L10:
        if (z75.b.d(this.filePath, r100.f2278b) == false) goto L19;
        long r103 = this.previewFileSize;
        if (r103 > 0) goto L14;
        return false;
    L14:
        if (r103 != r102.length()) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L22:
        return false;
    }

    public void setFilePath(DriveFilePath r100) {
        this.filePath = r100;
    }

    public void setLimit(boolean r100) {
        this.isLimit = r100;
    }

    public void setPreviewFileSize(long r100) {
        this.previewFileSize = r100;
    }

    public void setStreamingUrl(String r100) {
        this.streamingUrl = r100;
    }

    public StreamingCache(String r100, DriveFilePath r101, long r102) {
        this.streamingUrl = r100;
        this.filePath = r101;
        this.previewFileSize = r102;
    }
}
