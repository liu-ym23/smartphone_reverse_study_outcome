package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* JADX INFO: loaded from: classes22.dex */
public abstract class OnekeyForceBindAdapter extends OnekeyBaseAdapter implements IOneKeyForceBindAdapter {
    private static final int BIND_LOGIC_TYPE = 1;
    protected ta7.g accountAPI;
    private volatile boolean isCancel;
    private yb7.e mCallback;
    private Context mContext;
    private String mFrom;
    private String mProfileKey;
    private String mProviderAppId;
    private String mToken;

    public class a extends yb7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnekeyForceBindAdapter f269238a;

        public a(OnekeyForceBindAdapter r100) {
            this.f269238a = r100;
        }

        public final void b(ua7.e<wb7.g> r100) {
            this.f269238a.onBindSuccess(r100);
        }

        @Override // sa7.h
        public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
            b((ua7.e) r100);
        }

        public final void a(ua7.e<wb7.g> r100, int r101) {
            OnekeyForceBindAdapter r102 = this.f269238a;
            r102.onBindError(r102.getForceBindErrorResponse(r100, OnekeyForceBindAdapter.access$000(r102)));
        }

        @Override // sa7.h
        public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
            a((ua7.e) r100, r101);
        }
    }

    public void cancel() {
        this.isCancel = true;
        yb7.e r100 = this.mCallback;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public static /* synthetic */ String access$000(OnekeyForceBindAdapter r100) {
        return r100.mFrom;
    }

    private void parseData(Bundle r100) {
        this.mToken = r100.getString("access_token");
        this.mFrom = r100.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        this.mProviderAppId = r100.getString("carrier_app_id");
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse r100) {
        if (this.isCancel == false) goto L5;
        return;
    L5:
        handleAuthorizeErrorResponse(r100);
        onBindError(r100);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle r100) {
        if (this.isCancel == false) goto L5;
        return;
    L5:
        parseData(r100);
        a r101 = new a(this);
        this.mCallback = r101;
        this.accountAPI.d(this.mToken, this.mFrom, this.mProfileKey, this.mProviderAppId, this.mExtendInfo, r101);
    }

    public OnekeyForceBindAdapter(Context r100, String r101) {
        this.mContext = r100;
        this.accountAPI = com.bytedance.sdk.account.impl.d.l();
        this.isCancel = false;
        this.mProfileKey = r101;
    }
}
