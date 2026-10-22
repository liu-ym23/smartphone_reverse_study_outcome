package com.ss.android.account.group_onekey;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.obric.assistant.onelogin.b0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements AuthorizeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthorizeCallback f406284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f406285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f406286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f406287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f406288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ yqa.a f406289f;

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r100) {
        this.f406284a.onError(r100);
        JSONObject r101 = new JSONObject();
        r101.put("enter_from", this.f406285b);
        r101.put("enter_method", this.f406286c);
        r101.put("duration", System.currentTimeMillis() - this.f406287d);
        r101.put("status", "fail");
        if (r100 == null) goto L7;
        String r102 = r100.platformErrorCode;
        if (r102 == null) goto L7;
    L8:
        r101.put("error", r102);
        if (r100 == null) goto L13;
        String r103 = r100.platformErrorMsg;
        if (r103 == null) goto L13;
    L14:
        r101.put("fail_info", r103);
        r101.put("is_enable_pre_get_token", this.f406288e ? 1 : 0);
        if (r100 == null) goto L19;
        Bundle r104 = r100.extras;
        if (r104 == null) goto L19;
        Bundle r105 = r104.getBundle("server_app_original_result");
    L20:
        a(r101, r105);
        com.bytedance.sdk.account.monitor.a.a("uc_share_login_auth_result", r101);
        return;
    L19:
        r105 = null;
    L13:
        r103 = "";
    L7:
        r102 = "-1";
        goto L8
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r100) {
        this.f406284a.onSuccess(r100);
        JSONObject r101 = new JSONObject();
        r101.put("enter_from", this.f406285b);
        r101.put("enter_method", this.f406286c);
        r101.put("duration", System.currentTimeMillis() - this.f406287d);
        if (r100 != null) goto L5;
        r101.put("status", "fail");
        r101.put("error", "-1");
        r101.put("fail_info", "unknown error, bundle is null");
    L6:
        r101.put("is_enable_pre_get_token", this.f406288e ? 1 : 0);
        if (r100 == null) goto L9;
        Bundle r102 = r100.getBundle("server_app_original_result");
    L10:
        a(r101, r102);
        com.bytedance.sdk.account.monitor.a.a("uc_share_login_auth_result", r101);
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        r101.put("status", "success");
        goto L6
    }

    public final void a(JSONObject r110, Bundle r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        if (r111.isEmpty() == true) goto L20;
        r110.put("is_server_app_enable_group_one_login_opt", r111.getInt("server_app_enable_group_one_login_opt", 0));
        boolean r100 = true;
        r110.put("server_app_auth_version", r111.getInt("server_auth_version", 1));
        long r101 = r111.getLong("server_app_auth_activity_on_create_time", 0);
        if (r101 <= 0) goto L9;
        r110.put("duration_from_start_activity_to_on_create", r101 - this.f406289f.f568877a);
    L9:
        String r102 = r111.getString("callback_result_scene");
        if (r102 != null) goto L12;
    L15:
        if (r100 == true) goto L17;
        r110.put("callback_result_scene", r102);
    L17:
        r110.put("duration_wait_get_token", r111.getLong("duration_wait_get_token", 0));
        r110.put("is_server_app_cold_start", r111.getInt("server_app_is_cold_launch", 0));
        r110.put("is_cold_boot_landing_page", r111.getInt("is_cold_boot_landing_page", 0));
        return;
    L12:
        if (r102.length() == 0) goto L15;
        r100 = false;
        goto L15
    }

    public b(b0 r100, long r101, boolean r102, yqa.a r103) {
        this.f406284a = r100;
        this.f406285b = "";
        this.f406286c = "";
        this.f406287d = r101;
        this.f406288e = r102;
        this.f406289f = r103;
    }
}
