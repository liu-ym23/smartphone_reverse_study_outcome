package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.impl.p;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.HashMap;
import java.util.Map;
import ta7.i;
import ua7.h;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAccountAdapter implements AuthorizeCallback {
    public static final int APP_AUTH_0 = 0;
    public static final int APP_AUTH_1 = 1;
    public static final int APP_AUTH_2 = 2;
    public static Map<String, f.a> delegateMap;
    protected i api;
    protected int appAuth;
    protected Map<String, String> mExtendParam;
    protected String platform;
    protected String platformId;

    static {
        HashMap r100 = new HashMap();
        delegateMap = r100;
        r100.put("google", new b.a());
        delegateMap.put("facebook", new a.C3764a());
        delegateMap.put("twitter", new g.a());
        delegateMap.put("line", new d.a());
        delegateMap.put("kakaotalk", new c.a());
        delegateMap.put("vk", new VKPlatformDelegate.a());
        delegateMap.put("tiktok", new TiktokPlatformDelegate.a());
    }

    public h getErrorResponse(AuthorizeErrorResponse r100) {
        h r101 = new h(false, 10047);
        setAuthorizeErrorInfo(r101, r100);
        return r101;
    }

    public void setAppAuth(int r100) {
        this.appAuth = r100;
    }

    public void setExtendParam(Map<String, String> r100) {
        this.mExtendParam = r100;
    }

    public void setAuthorizeErrorInfo(ua7.b r100, AuthorizeErrorResponse r101) {
        if (r101.isCancel == false) goto L5;
        int r102 = -1001;
    L6:
        r100.f549253g = r102;
        r100.f549255i = r101.platformErrorMsg;
        r100.f549254h = r102;
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        if (TextUtils.isEmpty(r101.platformErrorMsg) == false) goto L16;
        String r103 = r101.platformErrorDetail;
    L17:
        r100.f549256j = r103;
        return;
    L16:
        r103 = r101.platformErrorMsg;
        goto L17
    L8:
        if (TextUtils.isEmpty(r101.platformErrorCode) == true) goto L14;
        r100.f549254h = CastIntegerProtector.parseInt(r101.platformErrorCode);     // Catch: Exception -> L11
        goto L14
    L5:
        r102 = -1004;
        goto L6
    }

    public BaseAccountAdapter(Context r100, String r101, String r102) {
        this.api = p.t();
        this.platformId = r101;
        this.platform = r102;
        this.appAuth = 0;
    }

    public BaseAccountAdapter(Context r100, String r101, String r102, int r103) {
        this.api = p.t();
        this.platformId = r101;
        this.platform = r102;
        this.appAuth = r103;
    }
}
