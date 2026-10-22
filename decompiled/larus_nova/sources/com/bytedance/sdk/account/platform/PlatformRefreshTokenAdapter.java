package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import org.json.JSONException;
import org.json.JSONObject;
import sa7.h;
import xa7.k;

/* JADX INFO: loaded from: classes22.dex */
public abstract class PlatformRefreshTokenAdapter extends BaseAccountAdapter implements IPlatformRefreshTokenAdapter {
    private final String mClientKey;
    private RefreshTokenCallback mRefreshTokenCallback;

    public class RefreshTokenCallback extends h<k> {
        final /* synthetic */ PlatformRefreshTokenAdapter this$0;

        public RefreshTokenCallback(PlatformRefreshTokenAdapter r100) {
            this.this$0 = r100;
        }

        public void onSuccess(k r100) {
            this.this$0.onRefreshTokenSuccess(r100);
            JSONObject r101 = new JSONObject();
            r101.put("trigger_scene", "foreground_switch");     // Catch: JSONException -> L6
            r101.put("enter_from", "foreground_switch");     // Catch: JSONException -> L6
            r101.put("trigger_path", "refresh_oauth");     // Catch: JSONException -> L6
            r101.put("client_key", PlatformRefreshTokenAdapter.access$000(this.this$0));     // Catch: JSONException -> L6
            r101.put("status", "success");     // Catch: JSONException -> L6
        L4:
            com.bytedance.sdk.account.monitor.a.a("passport_update_authorize_info_request_response", r101);
            com.bytedance.sdk.account.monitor.a.a("passport_update_authorize_result", r101);
        }

        @Override // sa7.h
        public /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
            onSuccess((k) r100);
        }

        public void onError(k r100, int r101) {
            this.this$0.onRefreshTokenError(r100);
            JSONObject r102 = new JSONObject();
            r102.put("trigger_scene", "foreground_switch");     // Catch: JSONException -> L6
            r102.put("enter_from", "foreground_switch");     // Catch: JSONException -> L6
            r102.put("trigger_path", "refresh_oauth");     // Catch: JSONException -> L6
            r102.put("client_key", PlatformRefreshTokenAdapter.access$000(this.this$0));     // Catch: JSONException -> L6
            r102.put("status", "fail");     // Catch: JSONException -> L6
            r102.put("error_code", r101);     // Catch: JSONException -> L6
            r102.put("fail_info", r100.f549255i);     // Catch: JSONException -> L6
        L4:
            com.bytedance.sdk.account.monitor.a.a("passport_update_authorize_info_request_response", r102);
            com.bytedance.sdk.account.monitor.a.a("passport_update_authorize_result", r102);
        }

        @Override // sa7.h
        public /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
            onError((k) r100, r101);
        }
    }

    private k getFailedParseDataResponse() {
        k r100 = new k(this.platform, this.platformId);
        r100.f549253g = -1007;
        r100.f549256j = "fail to parse data auth_code";
        return r100;
    }

    public void cancelRefreshToken() {
        RefreshTokenCallback r100 = this.mRefreshTokenCallback;
        if (r100 == null) goto L6;
        r100.cancel();
        this.mRefreshTokenCallback = null;
        return;
    }

    public static /* synthetic */ String access$000(PlatformRefreshTokenAdapter r100) {
        return r100.mClientKey;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "refresh_token", 0, r100.platformErrorCode, r100.platformErrorMsg, r100.isCancel);
        k r101 = new k(this.platform, this.platformId);
        setAuthorizeErrorInfo(r101, r100);
        onRefreshTokenError(r101);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "refresh_token", 1, null, null, false);
        if (r100 != null) goto L6;
        onRefreshTokenError(getFailedParseDataResponse());
        return;
    L6:
        String r101 = r100.getString("auth_code");
        if (TextUtils.isEmpty(r101) == false) goto L10;
        onRefreshTokenError(getFailedParseDataResponse());
        return;
    L10:
        RefreshTokenCallback r102 = new RefreshTokenCallback(this);
        this.mRefreshTokenCallback = r102;
        this.api.d(r101, this.platformId, this.platform, this.mExtendParam, r102);
    }

    public PlatformRefreshTokenAdapter(Context r100, String r101, String r102, String r103) {
        super(r100, r101, r103);
        this.mClientKey = r102;
    }
}
