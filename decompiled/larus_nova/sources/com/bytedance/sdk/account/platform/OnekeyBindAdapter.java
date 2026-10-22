package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public abstract class OnekeyBindAdapter extends OnekeyBaseAdapter implements IOnekeyBindAdapter {
    protected ta7.g accountAPI;
    private volatile boolean isCancel;
    private yb7.d mCallback;
    private Context mContext;
    private String mFrom;
    private String mPassWord;
    private String mProviderAppId;
    private String mToken;
    private int mUnbindExits;

    public class a extends yb7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnekeyBindAdapter f269237a;

        public a(OnekeyBindAdapter r100) {
            this.f269237a = r100;
        }

        public final void b(ua7.e<wb7.f> r100) {
            this.f269237a.onBindSuccess(r100);
        }

        @Override // sa7.h
        public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
            b((ua7.e) r100);
        }

        public final void a(ua7.e<wb7.f> r100, int r101) {
            OnekeyBindAdapter r102 = this.f269237a;
            r102.onBindError(r102.getBindErrorResponse(r100, OnekeyBindAdapter.access$000(r102)));
        }

        @Override // sa7.h
        public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
            a((ua7.e) r100, r101);
        }
    }

    public void cancel() {
        this.isCancel = true;
        yb7.d r100 = this.mCallback;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bytedance.sdk.account.platform.base.OneLoginCallback
    public JSONObject onSendEvent() {
        return null;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getProviderAppId() {
        return this.mProviderAppId;
    }

    public String getToken() {
        return this.mToken;
    }

    public OnekeyBindAdapter(Context r100) {
        this.mContext = r100.getApplicationContext();
        this.accountAPI = com.bytedance.sdk.account.impl.d.l();
        this.isCancel = false;
        this.mPassWord = "";
        this.mUnbindExits = 0;
    }

    public static /* synthetic */ String access$000(OnekeyBindAdapter r100) {
        return r100.mFrom;
    }

    private void parseData(Bundle r100) {
        this.mToken = r100.getString("access_token");
        this.mFrom = r100.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        this.mProviderAppId = r100.getString("carrier_app_id");
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r100) {
        if (this.isCancel == false) goto L5;
        return;
    L5:
        handleAuthorizeErrorResponse(r100);
        onBindError(r100);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r110) {
        if (this.isCancel == false) goto L5;
        return;
    L5:
        parseData(r110);
        this.mCallback = new a(this);
        if (this.mExtendInfo != null) goto L8;
        this.mExtendInfo = new HashMap();
    L8:
        this.mExtendInfo.put("provider_app_id", this.mProviderAppId);
        this.accountAPI.a(this.mToken, this.mFrom, this.mPassWord, this.mUnbindExits, this.mExtendInfo, this.mCallback);
    }

    public void setExtraParams(String r100, int r101, Map<String, String> r102) {
        this.mPassWord = r100;
        this.mUnbindExits = r101;
        this.mExtendInfo = r102;
    }
}
