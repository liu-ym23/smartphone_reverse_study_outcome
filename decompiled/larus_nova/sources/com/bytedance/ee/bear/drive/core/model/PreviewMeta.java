package com.bytedance.ee.bear.drive.core.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoMeta;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
public class PreviewMeta implements NonProguard {
    private final Content content;
    private final String extra;
    private final int interval;
    private boolean linearized;
    private final int longPushRetryInterval;
    private MetaInfo metaInfo;
    private final long previewFileSize;
    private final int status;

    public static class Content implements Serializable {
        public final LinkedHashMap<String, String> transcodeUrls;
        public final int type;

        public String toString() {
            return "Content{type=" + this.type + ", transcodeUrls=" + this.transcodeUrls + '}';
        }

        public Content(int r100, LinkedHashMap<String, String> r101) {
            this.type = r100;
            this.transcodeUrls = r101;
        }
    }

    public static class MetaInfo implements Serializable {

        @SerializedName("streams")
        public ArrayList<HashMap<String, String>> streams;

        public MetaInfo() {
        }
    }

    public String toString() {
        return "Result{status=" + this.status + ", interval=" + this.interval + ", longPushRetryInterval=" + this.longPushRetryInterval + ", content=" + this.content + ", linearized=" + this.linearized + ", previewFileSize=" + this.previewFileSize + ", extra='" + c.j(this.extra) + "'}";
    }

    public Content getContent() {
        return this.content;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getLongPushRetryInterval() {
        return this.longPushRetryInterval;
    }

    public MetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    public long getPreviewFileSize() {
        return this.previewFileSize;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isLinearized() {
        return this.linearized;
    }

    public PreviewMeta(FileInfoMeta r100) {
        this.status = r100.status;
        this.interval = r100.interval;
        this.longPushRetryInterval = r100.longPushRetryInterval;
        FileInfoMeta.Content r101 = r100.content;
        if (r101 != null) goto L5;
        Content r102 = null;
    L6:
        this.content = r102;
        this.linearized = r100.linearized;
        this.previewFileSize = r100.previewFileSize;
        String r103 = r100.extra;
        this.extra = r103;
        this.metaInfo = parseMetaInfo(r103);
        return;
    L5:
        r102 = new Content(r101.type, r101.transcodeUrls);
        goto L6
    }

    private MetaInfo parseMetaInfo(String r100) {
        String r101 = new JSONObject(r100).optString("meta_info");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return new MetaInfo();
    L7:
        return (MetaInfo) new Gson().fromJson(r101, MetaInfo.class);
    L9:
        return new MetaInfo();
    }

    public void setLinearized(boolean r100) {
        this.linearized = r100;
    }
}
