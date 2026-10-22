package com.bytedance.ee.bear.drive.loader.download.platform.api.imfile;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import java.io.Serializable;
import java.util.LinkedHashMap;
import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
public class PreviewGetV2Puller extends BasePuller<Params, Result> {
    private static final String REQUEST_URL = "/api/box/sdk/preview/get/";

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
        public String app_file_id;
        public String app_id;
        public String auth_extra;
        public int preview_type;

        public String toString() {
            return "Params{app_id='" + c.j(this.app_id) + "', app_file_id='" + c.j(this.app_file_id) + "', auth_extra='" + c.j(this.auth_extra) + "', preview_type=" + this.preview_type + '}';
        }

        public Params(String r100, String r101, int r102, String r103) {
            this.app_id = r100;
            this.app_file_id = r101;
            this.preview_type = r102;
            this.auth_extra = r103;
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

    public PreviewGetV2Puller(NetService r100) {
        super(r100, REQUEST_URL);
    }
}
