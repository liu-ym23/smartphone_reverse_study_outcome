package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.Map;
import sa7.h;

/* JADX INFO: loaded from: classes22.dex */
public abstract class PlatformChangeBindAdapter extends BaseAccountAdapter implements IPlatformChangeBindAdapter {
    private a mChangeBindCallback;
    private Map<String, String> switchBindExtraParam;
    private boolean verifyTicket;
    private boolean verifyType;

    public class a extends h<ua7.h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlatformChangeBindAdapter f269244a;

        public a(PlatformChangeBindAdapter r100) {
            this.f269244a = r100;
        }

        @Override // sa7.h
        public final void onSuccess(ua7.b r100) {
            PlatformChangeBindAdapter r101 = this.f269244a;
            r101.onChangeBindSuccess((ua7.h) r100);
        }

        @Override // sa7.h
        public final void onError(ua7.b r100, int r101) {
            ua7.h r102 = (ua7.h) r100;
            if (r102.f549253g == 1030) goto L5;
        L7:
            this.f269244a.onChangeBindError(r102);
            return;
        L5:
            if (TextUtils.isEmpty(r102.f549282s) == true) goto L7;
            this.f269244a.onBindExist(r102, r102.f549280q, r102.f549281r, r102.f549282s, new e(this, r102));
        }
    }

    private ua7.h getFailedParseDataResponse() {
        ua7.h r100 = new ua7.h(false, 70004);
        r100.f549253g = -1007;
        r100.f549256j = "fail to parse data auth_code or access_token";
        return r100;
    }

    public void cancelChangeBind() {
        a r100 = this.mChangeBindCallback;
        if (r100 == null) goto L6;
        r100.cancel();
        this.mChangeBindCallback = null;
        return;
    }

    public static /* synthetic */ Map access$100(PlatformChangeBindAdapter r100) {
        return r100.switchBindExtraParam;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "change_bind", 0, r100.platformErrorCode, r100.platformErrorMsg, r100.isCancel);
        onChangeBindError(getErrorResponse(r100));
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle r110) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "bind", 1, null, null, false);
        if (r110 != null) goto L6;
        onChangeBindError(getFailedParseDataResponse());
        return;
    L6:
        String r100 = r110.getString("auth_code");
        String r101 = r110.getString("access_token");
        if (TextUtils.isEmpty(r100) == true) goto L9;
    L12:
        a r102 = new a(this);
        this.mChangeBindCallback = r102;
        this.api.p(this.platform, this.platformId, r100, r101, this.verifyType, this.verifyTicket, this.mExtendParam, r102);
        return;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        onChangeBindError(getFailedParseDataResponse());
    }

    public PlatformChangeBindAdapter setSwitchBindExtraParam(Map<String, String> r100) {
        this.switchBindExtraParam = r100;
        return this;
    }

    public PlatformChangeBindAdapter setVerifyTicket(boolean r100) {
        this.verifyTicket = r100;
        return this;
    }

    public PlatformChangeBindAdapter setVerifyType(boolean r100) {
        this.verifyType = r100;
        return this;
    }

    public PlatformChangeBindAdapter(Context r100, String r101, String r102) {
        super(r100, r101, r102);
    }
}
