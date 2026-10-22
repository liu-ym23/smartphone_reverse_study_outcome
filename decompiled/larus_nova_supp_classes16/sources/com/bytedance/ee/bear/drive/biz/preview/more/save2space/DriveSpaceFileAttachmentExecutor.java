package com.bytedance.ee.bear.drive.biz.preview.more.save2space;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveSpaceFileAttachmentExecutor {
    public final NetService.d<Result<AttachSaveResponse>> a;

    public static class AttachSaveResponse implements Serializable {

        @JSONField(name = "file_token")
        private String fileToken;
        private String version;

        public AttachSaveResponse() {
        }

        public String toString() {
            return "AttachSaveResponse{fileToken='" + yu5.c.j(this.fileToken) + "', version='" + this.version + "'}";
        }

        public String getFileToken() {
            return this.fileToken;
        }

        public String getVersion() {
            return this.version;
        }

        public void setFileToken(String r1) {
            this.fileToken = r1;
        }

        public void setVersion(String r1) {
            this.version = r1;
        }
    }

    public static class a implements NetService.c<Result<AttachSaveResponse>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor$a$a, reason: collision with other inner class name */
        public class C0149a extends TypeToken<Result<AttachSaveResponse>> {
            public C0149a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AttachSaveResponse> parse(String r3) throws NetService.ParseException {
            return (Result) new Gson().fromJson(r3, new C0149a().getType());
        L4:
            e = move-exception;
            tt5.a.d("AttachmentExecutor", "Parser fail: " + e);
            throw new NetService.ParseException();
        }
    }

    public DriveSpaceFileAttachmentExecutor(NetService r2) {
        this.a = r2.Vc(new a());
    }

    public final Flowable<AttachSaveResponse> a(final String r3, final String r4, final String r5, String r6) {
        tt5.a.h("TAG_ATTACH_FLOW", "saveAttachFileToCloudSpace: starting...");
        HashMap r0 = new HashMap();
        r0.put("file_token", r3);
        if (TextUtils.isEmpty(r4) == true) goto L6;
        r0.put(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN, r4);
    L6:
        if (TextUtils.isEmpty(r6) == true) goto L8;
        r0.put("extra", r6);
    L8:
        r0.put("name", r5);
        r0.put("size_checker", Boolean.valueOf(((t) org.koin.java.a.a(t.class)).e()));
        final NetService.f r7 = new NetService.f("/api/box/file/save/");
        r7.j = JSON.toJSONString(r0);
        r7.c = 1;
        return this.a.a(r7).map(new b(r7)).onErrorResumeNext(new c(r3, r4, r5));
    }
}
