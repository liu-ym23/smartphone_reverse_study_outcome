package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public abstract class OneKeyLoginBaseAdapter extends OnekeyBaseAdapter implements IOnekeyLoginAdapter {
    ta7.g accountAPI;
    private volatile boolean isCancel;
    private boolean isLoginOnly;
    private va7.e mCallback;
    private Context mContext;
    private String mFrom;
    private String mProviderAppId;
    private String mToken;

    public class a extends va7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OneKeyLoginBaseAdapter f269235a;

        public a(OneKeyLoginBaseAdapter r100) {
            this.f269235a = r100;
        }

        @Override // sa7.h
        public final void onSuccess(ua7.b r100) {
            OneKeyLoginBaseAdapter r101 = this.f269235a;
            r101.onLoginSuccess((xa7.g) r100);
        }

        @Override // sa7.h
        public final void onError(ua7.b r100, int r101) {
            OneKeyLoginBaseAdapter r102 = this.f269235a;
            r102.onLoginError(com.bytedance.sdk.account.impl.c.d((xa7.g) r100, OneKeyLoginBaseAdapter.access$000(r102)));
        }
    }

    public void cancel() {
        this.isCancel = true;
        va7.e r100 = this.mCallback;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public abstract void doQuickAuthLogin(String r100, String r101, String r102, Map<String, String> r103, va7.e r104);

    public abstract void doQuickAuthLoginOnly(String r100, String r101, Map<String, String> r102, va7.e r103);

    @Override // com.bytedance.sdk.account.platform.base.OneLoginCallback
    public JSONObject onSendEvent() {
        return null;
    }

    public OneKeyLoginBaseAdapter() {
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

    public OneKeyLoginBaseAdapter(Context r100) {
        this.mContext = r100.getApplicationContext();
        this.accountAPI = com.bytedance.sdk.account.impl.d.l();
        this.isCancel = false;
    }

    public static /* synthetic */ String access$000(OneKeyLoginBaseAdapter r100) {
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
        onLoginError(r100);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle r110) {
        if (this.isCancel == false) goto L5;
        return;
    L5:
        parseData(r110);
        this.mCallback = new a(this);
        if (this.isLoginOnly == true) goto L8;
        doQuickAuthLogin(this.mToken, getFrom(), this.mProviderAppId, this.mExtendInfo, this.mCallback);
        return;
    L8:
        if (this.mExtendInfo != null) goto L10;
        this.mExtendInfo = new HashMap();
    L10:
        this.mExtendInfo.put("provider_app_id", this.mProviderAppId);
        doQuickAuthLoginOnly(this.mToken, this.mFrom, this.mExtendInfo, this.mCallback);
    }

    public OneKeyLoginBaseAdapter(Context r100, boolean r101) {
        this.mContext = r100.getApplicationContext();
        this.accountAPI = com.bytedance.sdk.account.impl.d.l();
        this.isCancel = false;
        this.isLoginOnly = r101;
    }
}
