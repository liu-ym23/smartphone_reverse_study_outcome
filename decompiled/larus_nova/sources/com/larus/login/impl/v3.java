package com.larus.login.impl;

import android.app.Application;
import android.text.TextUtils;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.SeparatedEditText;
import com.larus.login.api.TouristManager;
import com.larus.login.impl.databinding.LarusAccountVerificationCodePageBinding;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class v3 implements n38.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f358342a;

    public v3(VerificationCodeFragment r100) {
        this.f358342a = r100;
    }

    @Override // n38.h
    public final void b(LoginPlatform r100, String r101, Boolean r102) {
        AccountUtils r103 = AccountUtils.f357130a;
        AccountUtils.s("WeixinBindLogin");
        TouristManager.f357001a.g();
        VerificationCodeFragment.X90(this.f358342a, "wechat");
        this.f358342a.ba0(true, null);
    }

    @Override // n38.h
    public final void a(LoginPlatform r100, int r101, String r102, String r103, String r104, Integer r105, String r106, Map r107) {
        VerificationCodeFragment r108 = this.f358342a;
        r108.da0(r108.getActivity(), this.f358342a.f357226g);
        AccountUtils r109 = AccountUtils.f357130a;
        if (AccountUtils.e(this.f358342a) == true) goto L5;
        return;
    L5:
        LarusAccountVerificationCodePageBinding r110 = this.f358342a.f357224e;
        if (r110 == null) goto L11;
        SeparatedEditText r111 = r110.f357472c;
        if (r111 == null) goto L11;
        r111.c();
    L11:
        if (r101 == (-1008)) goto L18;
        if (r102 == null) goto L18;
        VerificationCodeFragment r112 = this.f358342a;
        t19.s r113 = t19.s.f544207a;
        Application r114 = AppHost.f326268a.getApplication();
        if (TextUtils.isEmpty(r102) == false) goto L16;
        String r115 = r112.getString(R.string.larus_log_in_internet_error);
    L17:
        Intrinsics.checkNotNull(r115);
        r113.getClass();
        t19.s.c(r114, r115);
        goto L18
    L16:
        r115 = r102;
    L18:
        VerificationCodeFragment.W90(this.f358342a, Integer.valueOf(r101), r102);
        this.f358342a.ba0(false, String.valueOf(r101));
    }
}
