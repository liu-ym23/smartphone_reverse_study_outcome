package com.larus.login.impl;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.AccountTrackService;
import com.larus.login.api.IAccountTrackApi;
import com.larus.login.api.TouristManager;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f2 implements n38.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhoneLoginFragment f357674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f357675b;

    public f2(PhoneLoginFragment r100, View r101) {
        this.f357674a = r100;
        this.f357675b = r101;
    }

    @Override // n38.h
    public final void b(LoginPlatform r110, String r111, Boolean r112) {
        AccountUtils r113 = AccountUtils.f357130a;
        AccountUtils.s("WeixinLogin");
        TouristManager.f357001a.g();
        IAccountTrackApi.a.c(AccountTrackService.f356934a, "wechat", 1, this.f357674a.k(), this.f357674a.getEnterMethod(), null, null, null, null, null, null, 960);
    }

    @Override // n38.h
    public final void a(LoginPlatform r110, int r111, String r112, String r210, String r211, Integer r212, String r213, Map r214) {
        View r100 = this.f357675b;
        if (r100 == null) goto L5;
        r100.setClickable(true);
    L5:
        PhoneLoginFragment r101 = this.f357674a;
        r101.fa0(r101.getActivity(), this.f357674a.f357174h);
        IAccountTrackApi.a.c(AccountTrackService.f356934a, "wechat", 0, this.f357674a.k(), this.f357674a.getEnterMethod(), String.valueOf(r111), r112, null, null, null, null, 960);
        if (r112 == null) goto L13;
        PhoneLoginFragment r102 = this.f357674a;
        t19.s r103 = t19.s.f544207a;
        Application r104 = AppHost.f326268a.getApplication();
        if (TextUtils.isEmpty(r112) == false) goto L10;
        String r105 = r102.getString(R.string.larus_log_in_internet_error);
    L11:
        Intrinsics.checkNotNull(r105);
        r103.getClass();
        t19.s.c(r104, r105);
        return;
    L10:
        r105 = r112;
        goto L11
    }
}
