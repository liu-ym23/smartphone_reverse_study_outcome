package com.bytedance.ee.bear.drive.loader.download.platform.api.imfile;

import android.util.SparseArray;
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
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileInfoV2Puller extends BasePuller<Params, Result> {
    private static final String REQUEST_URL = "/api/box/sdk/file/info/";
    private static final String TAG = "FileInfoV2Puller";

    public static class Params extends BasePuller.Params {
        public String app_file_id;
        public String app_id;
        public String auth_extra;
        public String mount_point;
        public ArrayList<String> option_params;

        public String toString() {
            return "Params{app_id='" + c.j(this.app_id) + "', app_file_id='" + c.j(this.app_file_id) + "', auth_extra='" + c.j(this.auth_extra) + "', mount_point='" + this.mount_point + "', option_params='" + this.option_params + "'}";
        }

        public Params(String r2, String r3, String r4, String r5) {
            ArrayList<String> r0 = new ArrayList();
            this.option_params = r0;
            this.app_id = r2;
            this.app_file_id = r3;
            this.auth_extra = r4;
            this.mount_point = r5;
            r0.add(FileInfoOptionConstants.OPTION_SAVE_STATUS);
            this.option_params.add(FileInfoOptionConstants.OPTION_PREVIEW_META);
            this.option_params.add(FileInfoOptionConstants.OPTION_CHECK_CIPHER);
        }
    }

    public static class Result extends BasePuller.Result {

        @JSONField(name = "available_preview_type")
        public int[] availablePreviewType;

        @JSONField(name = "file_token")
        public String fileToken;

        @JSONField(name = "mime_type")
        public String mimeType;
        public String name;

        @JSONField(name = "permission_status_code")
        public int permissionStatusCode;

        @JSONField(name = FileInfoOptionConstants.OPTION_PREVIEW_META)
        public String previewMeta;

        @JSONField(name = "preview_status")
        public int previewStatus;

        @JSONField(name = FileInfoOptionConstants.OPTION_SAVE_STATUS)
        public int saveStatus;
        public long size;

        @JSONField(name = "weboffice")
        public boolean webOffice;

        public SparseArray<PreviewMeta> getPreviewMetaMap() {
            SparseArray<FileInfoMeta> r0 = FileInfoMetaParser.parse(this.previewMeta);
            int r1 = r0.size();
            SparseArray<PreviewMeta> r2 = new SparseArray(r1);
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r2.put(r0.keyAt(r3), new PreviewMeta(r0.valueAt(r3)));
            r3 = r3 + 1;
            goto L3
        L5:
            return r2;
        }

        public String toString() {
            return "Result{name='" + this.name + "', size='" + this.size + "', availablePreviewType='" + Arrays.toString(this.availablePreviewType) + "', previewStatus='" + this.previewStatus + "', permissionStatusCode='" + this.permissionStatusCode + "', saveStatus='" + this.saveStatus + "', fileToken='" + this.fileToken + "', webOffice='" + this.webOffice + "', mimeType='" + this.mimeType + "', previewMeta='" + b.h(this.previewMeta) + "'}";
        }

        public Result() {
        }
    }

    public FileInfoV2Puller(NetService r2) {
        super(r2, REQUEST_URL);
    }
}
