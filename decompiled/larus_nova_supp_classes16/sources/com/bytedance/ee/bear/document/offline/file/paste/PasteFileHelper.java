package com.bytedance.ee.bear.document.offline.file.paste;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.offline.file.FileResultModel;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.util.io.NonProguard;
import fo5.d;
import io.reactivex.Flowable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class PasteFileHelper {
    public final NetService a;
    public final ConnectionService b;

    public static class CopyFileException extends Exception {
        public CopyFileException(String r1) {
            super(r1);
        }
    }

    public static class CopyFileResult extends Result<InnerData> {
        private CopyFileResult() {
        }
    }

    public static class InnerData implements NonProguard {
        private Map<String, String> succ_files;

        private InnerData() {
        }

        public Map<String, String> getSucc_files() {
            return this.succ_files;
        }

        public void setSucc_files(Map<String, String> r1) {
            this.succ_files = r1;
        }
    }

    public static class a implements NetService.c<CopyFileResult> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r2) throws NetService.ParseException {
            return (CopyFileResult) JSON.parseObject(r2, CopyFileResult.class);
        }
    }

    public final Flowable<FileResultModel> a(final FileUploadModel r6) {
        if (r6 == null) goto L21;
        if (this.b.getNetworkState() == null) goto L21;
        if (this.b.getNetworkState().a() == false) goto L21;
        NetService.f r0 = new NetService.f("/api/box/file/multi_copy/");
        r0.c = 1;
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        r2.put("file_token", r6.getDriveToken());
        r1.add(r2);
        if (TextUtils.isEmpty(r6.getPencilKitToken()) == true) goto L11;
        JSONObject r3 = new JSONObject();
        r3.put("file_token", r6.getPencilKitToken());
        r1.add(r3);
    L11:
        if (r6.getToken() != null) goto L13;
    L15:
        JSONObject r4 = new JSONObject();
        r4.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r6.getMountPoint());
        r4.put("mount_key", r6.getMountNodeToken());
        String r5 = r6.getUploadParams().get(FileUploadModel.EXTRA_PARAMS_KEY);
        if (TextUtils.isEmpty(r5) == true) goto L18;
        r4.put("ext", r5);
    L18:
        JSONObject r7 = new JSONObject();
        r7.put("files", r1);
        r7.put("dest_mount_info", r4);
        r0.j = r7.toJSONString();
        return this.a.Vc(new a()).a(r0).map(new com.bytedance.ee.bear.document.offline.file.paste.a(r6)).observeOn(d.e()).map(new b(r6));
    L13:
        if (r6.getToken().contains("fake") == false) goto L15;
        tt5.a.d("PasteFileHelper", "fake token !!! = " + r6.getToken());
    L21:
        return Flowable.just(new FileResultModel());
    }

    public PasteFileHelper(NetService r1, ConnectionService r2) {
        this.a = r1;
        this.b = r2;
    }
}
