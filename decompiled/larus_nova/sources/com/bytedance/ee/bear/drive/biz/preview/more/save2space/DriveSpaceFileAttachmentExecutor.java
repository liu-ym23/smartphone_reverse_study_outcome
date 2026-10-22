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

/* JADX INFO: loaded from: classes16.dex */
public final class DriveSpaceFileAttachmentExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService.d<Result<AttachSaveResponse>> f223639a;

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

        public void setFileToken(String r100) {
            this.fileToken = r100;
        }

        public void setVersion(String r100) {
            this.version = r100;
        }
    }

    public static class a implements NetService.c<Result<AttachSaveResponse>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor$a$a, reason: collision with other inner class name */
        public class C3205a extends TypeToken<Result<AttachSaveResponse>> {
            public C3205a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AttachSaveResponse> parse(String r100) throws NetService.ParseException {
            return (Result) new Gson().fromJson(r100, new C3205a().getType());
        L4:
            e = move-exception;
            tt5.a.d("AttachmentExecutor", "Parser fail: " + e);
            throw new NetService.ParseException();
        }
    }

    public DriveSpaceFileAttachmentExecutor(NetService r100) {
        this.f223639a = r100.Vc(new a());
    }

    public final Flowable<AttachSaveResponse> a(final String r100, final String r101, final String r102, String r103) {
        tt5.a.h("TAG_ATTACH_FLOW", "saveAttachFileToCloudSpace: starting...");
        HashMap r104 = new HashMap();
        r104.put("file_token", r100);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r104.put(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN, r101);
    L6:
        if (TextUtils.isEmpty(r103) == true) goto L8;
        r104.put("extra", r103);
    L8:
        r104.put("name", r102);
        r104.put("size_checker", Boolean.valueOf(((t) org.koin.java.a.a(t.class)).e()));
        final NetService.f r105 = new NetService.f("/api/box/file/save/");
        r105.f216913j = JSON.toJSONString(r104);
        r105.f216906c = 1;
        return this.f223639a.a(r105).map(new b(r105)).onErrorResumeNext(new c(r100, r101, r102));
    }
}
