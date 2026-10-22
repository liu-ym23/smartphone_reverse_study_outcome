package com.bytedance.ee.bear.drive.loader.download.platform.api.drive;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import java.io.Serializable;
import java.util.LinkedHashMap;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PreviewGetV1Puller extends BasePuller<Params, Result> {
    private static final String REQUEST_URL = "/api/box/preview/get/";

    public static class Content implements Serializable {

        @JSONField(name = "transcode_urls")
        public LinkedHashMap<String, String> transcodeUrls;
        public int type;

        public Content() {
        }

        public String toString() {
            return "Content{type=" + this.type + ", transcodeUrls=" + this.transcodeUrls + '}';
        }
    }

    public static class Params extends BasePuller.Params {
        public String extra;
        public String file_token;
        public String mount_node_token;
        public String mount_point;
        public int preview_type;
        public int regenerate;
        public String version;

        public String toString() {
            return "Params{file_token='" + c.j(this.file_token) + "', mount_node_token='" + c.j(this.mount_node_token) + "', mount_point='" + this.mount_point + "', preview_type=" + this.preview_type + ", regenerate=" + this.regenerate + ", version='" + this.version + "', extra='" + c.j(this.extra) + "'}";
        }

        public Params(String r1, String r2, String r3, int r4, boolean r5, String r6, String r7) {
            this.file_token = r1;
            this.preview_type = r4;
            this.regenerate = r5 ? 1 : 0;
            this.version = r6;
            if (TextUtils.isEmpty(r2) == true) goto L6;
            this.mount_node_token = r2;
        L6:
            if (TextUtils.isEmpty(r3) == true) goto L9;
            this.mount_point = r3;
        L9:
            if (TextUtils.isEmpty(r7) == true) goto L12;
            this.extra = r7;
            return;
        }
    }

    public static class Result extends BasePuller.Result {
        public Content content;
        public String extra;
        public int interval;
        public boolean linearized;

        @JSONField(name = "long_push_retry_interval")
        public int longPushRetryInterval;

        @JSONField(name = "preview_file_size")
        public long previewFileSize;

        @JSONField(name = "preview_url")
        public String previewUrl;
        public int status;

        public String toString() {
            return "Result{status=" + this.status + ", interval=" + this.interval + ", longPushRetryInterval=" + this.longPushRetryInterval + ", previewUrl='" + c.j(this.previewUrl) + "', content=" + this.content + ", linearized=" + this.linearized + ", previewFileSize=" + this.previewFileSize + ", extra='" + c.j(this.extra) + "'}";
        }

        public Result() {
        }
    }

    public PreviewGetV1Puller(NetService r2) {
        super(r2, REQUEST_URL);
    }
}
