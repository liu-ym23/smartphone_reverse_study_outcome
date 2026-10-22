package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.dto.SaveTemplateResult;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements td5.d {
    public Context a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final ShareFolderUserPermission f;
    public td5.b g;
    public Disposable h;
    public com.bytedance.ee.bear.widgets.q i;

    public static class a implements NetService.c<SaveTemplateResult> {
        public a() {
        }

        public final Result parse(String r5) throws NetService.ParseException {
            SaveTemplateResult r0 = new SaveTemplateResult("", "", "", "");
            JSONObject r6 = new JSONObject(r5).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L7
            if (r6 == null) goto L12;
            return new SaveTemplateResult(r6.optString("folder_url"), r6.optString("folder_token"), r6.optString("token_list"), "");
        L12:
            return r0;
        L7:
            e = move-exception;
            tt5.a.e("SaveTemplateCommand", "parse json exception ...", e, false);
            return new SaveTemplateResult("", "", "", "");
        }
    }

    @Override // td5.d
    public final void destroy() {
        Disposable r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        com.bytedance.ee.bear.widgets.q r1 = this.i;
        if (r1 != null) goto L10;
    L12:
        this.i = null;
        this.a = null;
        this.g = null;
        return;
    L10:
        if (r1.c() == false) goto L12;
        this.i.a();
        goto L12
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.h.dispose();
        goto L7
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("SaveTemplateCommand", "execute()...");
        Disposable r1 = this.h;
        if (r1 == null) goto L8;
        if (r1.isDisposed() == true) goto L8;
        this.h.dispose();
    L8:
        if ((!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()) == false) goto L12;
        tt5.a.h("SaveTemplateCommand", "execute()...failed, offline");
        Context r0 = this.a;
        Toast.showFailureText(r0, r0.getString(2131887951));
        return;
    L12:
        if (this.f != null) goto L14;
    L23:
        tt5.a.h("SaveTemplateCommand", "execute()...has no permission.");
        Context r2 = this.a;
        Toast.showFailureText(r2, r2.getString(2131887803));
        return;
    L14:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.f, "MOVE_TO_HERE").booleanValue() == false) goto L23;
        this.i.e();
        NetService r3 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r4 = new NetService.f("/space/api/platform/template/use_template_collection/");
        ((NetService.e) r4).c = 1;
        HashMap r5 = new HashMap();
        r5.put("collection_id", "" + this.c);
        r5.put("parent_folder_token", this.b);
        r5.put("space_version", "" + this.d);
        JSONObject r6 = new JSONObject();
        r6.put("time_zone", zu5.b.c());     // Catch: JSONException -> L19
    L21:
        r5.put("extra_info", r6.toString());
        r4.d(r5);
        this.h = r3.Vc(new a()).a(r4).subscribe(new d(this), new e(this));
        return;
    L19:
        e = move-exception;
        tt5.a.d("SaveTemplateCommand", "buildRequestParams()...error = " + e);
        goto L21
    }

    public f(Context r1, String r2, int r3, ShareFolderUserPermission r4, Bundle r5, td5.b r6) {
        this.a = r1;
        this.b = r2;
        this.e = r3;
        this.f = r4;
        this.g = r6;
        this.c = r5.getString("extra_collection_id");
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r3)) == false) goto L5;
        int r7 = 2;
    L6:
        this.d = r7;
        this.i = new com.bytedance.ee.bear.widgets.q(this.a);
        return;
    L5:
        r7 = 1;
        goto L6
    }
}
