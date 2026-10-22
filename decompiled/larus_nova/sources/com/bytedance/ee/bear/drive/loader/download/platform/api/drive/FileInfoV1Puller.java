package com.bytedance.ee.bear.drive.loader.download.platform.api.drive;

import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoMeta;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoMetaParser;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoOptionConstants;
import du5.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
public class FileInfoV1Puller extends BasePuller<Params, Result> {
    private static final String REQUEST_URL = "/api/box/file/info/";
    private static final String TAG = "FileInfoV1Puller";

    public static class Params extends BasePuller.Params {
        public String caller;
        public String extra;
        public String file_token;
        public String mount_node_token;
        public String mount_point;
        public ArrayList<String> option_params;
        public String risk_detection_extra;
        public String version;

        public String toString() {
            return "Params{file_token='" + c.j(this.file_token) + "', mount_node_token='" + c.j(this.mount_node_token) + "', mount_point='" + this.mount_point + "', caller='" + this.caller + "', version='" + this.version + "', extra='" + c.j(this.extra) + "', option_params='" + this.option_params + "', risk_detection_extra='" + this.risk_detection_extra + "'}";
        }

        public Params(String r100, String r101, String r102, String r103, String r104, String r105) {
            this.option_params = new ArrayList();
            this.file_token = r100;
            this.mount_node_token = r101;
            this.mount_point = r102;
            this.caller = r103;
            this.version = r104;
            this.extra = r105;
            JSONObject r106 = new JSONObject();
            Locale r107 = Locale.getDefault();
            r106.put2("locale", r107.getLanguage() + "_" + r107.getCountry().toUpperCase());
            r106.put2("source_terminal", 3);
            r106.put2("file_operate_usage", 0);
            this.risk_detection_extra = r106.toJSONString();
            this.option_params.add(FileInfoOptionConstants.OPTION_PREVIEW_META);
            this.option_params.add(FileInfoOptionConstants.OPTION_CHECK_CIPHER);
        }
    }

    public static class Result extends BasePuller.Result {

        @JSONField(name = "available_preview_type")
        public int[] availablePreviewType;

        @JSONField(name = "comment_flag")
        public int commentFlag;

        @JSONField(name = "creator_tenant_id")
        public String creatorTenantId;

        @JSONField(name = "data_version")
        public String dataVersion;

        @JSONField(name = "mime_type")
        public String mimeType;
        public String name;

        @JSONField(name = "num_blocks")
        public int numBlocks;

        @JSONField(name = "permission_status_code")
        public int permissionStatusCode;

        @JSONField(name = FileInfoOptionConstants.OPTION_PREVIEW_META)
        public String previewMeta;

        @JSONField(name = "preview_status")
        public int previewStatus;

        @JSONField(name = "risk_status")
        public int riskStatus;
        public long size;
        public String type;
        public String version;

        @JSONField(name = "weboffice")
        public boolean webOffice;

        public SparseArray<PreviewMeta> getPreviewMetaMap() {
            SparseArray<FileInfoMeta> r100 = FileInfoMetaParser.parse(this.previewMeta);
            int r101 = r100.size();
            SparseArray<PreviewMeta> r102 = new SparseArray(r101);
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L5;
            r102.put(r100.keyAt(r103), new PreviewMeta(r100.valueAt(r103)));
            r103 = r103 + 1;
            goto L3
        L5:
            return r102;
        }

        public String toString() {
            return "Result{name='" + this.name + "', size='" + this.size + ", numBlocks='" + this.numBlocks + ", type='" + this.type + "', availablePreviewType='" + Arrays.toString(this.availablePreviewType) + ", version='" + this.version + "', dataVersion='" + this.dataVersion + "', mimeType='" + this.mimeType + "', previewStatus='" + this.previewStatus + ", permissionStatusCode='" + this.permissionStatusCode + ", creatorTenantId='" + this.creatorTenantId + "', commentFlag='" + this.commentFlag + "', webOffice='" + this.webOffice + "', previewMeta='" + b.h(this.previewMeta) + "', riskStatus='" + this.riskStatus + "'}";
        }

        public Result() {
        }
    }

    public FileInfoV1Puller(NetService r100) {
        super(r100, REQUEST_URL);
    }
}
