package com.bytedance.ee.bear.drive.biz.permission;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import io.reactivex.Flowable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final NetService.d<Result<ThirdPartyAttachmentPermission>> a;

    public static class a implements NetService.c<Result<ThirdPartyAttachmentPermission>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.permission.f$a$a, reason: collision with other inner class name */
        public class C0132a extends TypeReference<Result<ThirdPartyAttachmentPermission>> {
            public C0132a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<ThirdPartyAttachmentPermission> parse(String r6) throws NetService.ParseException {
            Result<ThirdPartyAttachmentPermission> r0 = (Result) JSON.parseObject(r6, new C0132a(), new Feature[0]);
            ThirdPartyAttachmentPermission r2 = (ThirdPartyAttachmentPermission) r0.getData();
            if (r2 != null) goto L15;
        L14:
            return r0;
        L15:
            JSONObject r7 = new JSONObject(r6).optJSONObject("data");     // Catch: JSONException -> L10
            if (r7 == null) goto L12;
            JSONObject r8 = r7.optJSONObject("perm_v2");     // Catch: JSONException -> L10
            if (r8 == null) goto L12;
            String r9 = r8.toString();     // Catch: JSONException -> L10
        L13:
            r2.setPermV2Json(r9);
        L12:
            r9 = null;
        L10:
            e = move-exception;
            tt5.a.e("ThirdPartyAttachmentPermissionExecutor", "getThirdPartyAttachmentPerm err.", e, false);
            goto L12
        }
    }

    public f(NetService r2) {
        this.a = r2.Vc(new a());
    }

    public final Flowable a(final String r3, String r4, String r5) {
        tt5.a.h("TAG_ATTACH_FLOW", "saveAttachFileToCloudSpace: starting...");
        HashMap r0 = new HashMap();
        r0.put("file_token", r3);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.put("extra", r4);
    L5:
        final NetService.f r6 = new NetService.f("/api/box/file/permission/");
        r6.j = JSON.toJSONString(r0);
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r6.b(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r5);
    L8:
        r6.c = 1;
        return this.a.a(r6).observeOn(fo5.d.e()).map(new d(r6)).observeOn(fo5.d.d()).onErrorResumeNext(new e(r3));
    }
}
