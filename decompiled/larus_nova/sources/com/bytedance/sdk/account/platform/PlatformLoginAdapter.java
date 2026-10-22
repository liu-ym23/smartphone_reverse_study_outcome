package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.Map;
import sa7.h;

/* JADX INFO: loaded from: classes22.dex */
public abstract class PlatformLoginAdapter extends BaseAccountAdapter implements IPlatformLoginAdapter {
    boolean isChangeBind;
    boolean isLoginAndBindThirdMobileMode;
    boolean isLoginNeedBindMobile;
    boolean isRegisterNeedThirdMobile;
    boolean isShareLogin;
    private f mPlatformDelegate;

    public class LoginCallback extends h<ua7.h> {
        final /* synthetic */ PlatformLoginAdapter this$0;

        public LoginCallback(PlatformLoginAdapter r100) {
            this.this$0 = r100;
        }

        @Override // sa7.h
        public /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
            onSuccess((ua7.h) r100);
        }

        public void onSuccess(ua7.h r100) {
            this.this$0.onLoginSuccess(r100);
        }

        @Override // sa7.h
        public /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
            onError((ua7.h) r100, r101);
        }

        public void onError(ua7.h r100, int r101) {
            this.this$0.onLoginError(r100);
        }
    }

    public void cancelLogin() {
        f r100 = this.mPlatformDelegate;
        if (r100 == null) goto L6;
        r100.cancelLogin();
        this.mPlatformDelegate = null;
        return;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "login", 0, r100.platformErrorCode, r100.platformErrorMsg, r100.isCancel);
        onLoginError(getErrorResponse(r100));
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "login", 1, null, null, false);
        f.a r101 = BaseAccountAdapter.delegateMap.get(this.platform);
        if (r101 == null) goto L6;
        f r102 = r101.createLogin(this);
        this.mPlatformDelegate = r102;
        r102.requestLogin(r100);
        return;
    }

    public PlatformLoginAdapter setChangeBind(boolean r100) {
        this.isChangeBind = r100;
        return this;
    }

    public PlatformLoginAdapter setLoginAndBindThirdMobileMode(boolean r100) {
        this.isLoginAndBindThirdMobileMode = r100;
        return this;
    }

    public PlatformLoginAdapter setLoginMustBindMobile(boolean r100) {
        if (r100 == false) goto L4;
        this.isRegisterNeedThirdMobile = true;
        this.isLoginNeedBindMobile = true;
    L4:
        return this;
    }

    public PlatformLoginAdapter setLoginNeedBindMobile(boolean r100) {
        this.isLoginNeedBindMobile = r100;
        return this;
    }

    public PlatformLoginAdapter setRegisterNeedThirdMobile(boolean r100) {
        this.isRegisterNeedThirdMobile = r100;
        return this;
    }

    public PlatformLoginAdapter setShareLogin(boolean r100) {
        this.isShareLogin = r100;
        return this;
    }

    public PlatformLoginAdapter(Context r100, String r101, String r102) {
        super(r100, r101, r102);
        this.isLoginAndBindThirdMobileMode = false;
    }

    public PlatformLoginAdapter(Context r100, String r101, String r102, Map<String, String> r103) {
        this(r100, r101, r102);
        this.mExtendParam = r103;
    }

    public PlatformLoginAdapter(Context r100, String r101, String r102, boolean r103, boolean r104) {
        super(r100, r101, r102);
        this.isLoginAndBindThirdMobileMode = true;
        this.isRegisterNeedThirdMobile = r103;
        this.isChangeBind = r104;
    }
}
