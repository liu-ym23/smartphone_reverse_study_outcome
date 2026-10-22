package com.larus.login.impl;

import android.app.Application;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 implements n38.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f357249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f357250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AuthVerifyFragment f357251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LoginPlatform f357252d;

    public static final class a implements n38.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuthVerifyFragment f357253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoginPlatform f357254b;

        @Override // n38.m
        public final void onSuccess(String r100) {
            t19.s r101 = t19.s.f544207a;
            Application r102 = AppHost.f326268a.getApplication();
            r101.getClass();
            t19.s.o(r102, R.string.larus_mobile_verification_passed_cn, false);
            com.bytedance.router.i r103 = SmartRouter.buildRoute(this.f357253a.getContext(), "//flow/phone_login");
            Pair[] r104 = new Pair[4];
            r104[0] = TuplesKt.to("phoneLoginTitle", this.f357253a.getString(R.string.larus_change_phone_new_number));
            r104[1] = TuplesKt.to("phoneTicket", r100);
            r104[2] = TuplesKt.to("unusableMobileTicket", this.f357253a.f357142f);
            Bundle r105 = this.f357253a.getArguments();
            if (r105 == null) goto L6;
            String r106 = r105.getString("key_trigger_app_id");
            if (r106 == null) goto L6;
        L7:
            r104[3] = TuplesKt.to("key_trigger_app_id", r106);
            Bundle r107 = com.larus.utils.f.c(r104);
            r103.f267554c.putExtras(r107);
            this.f357253a.getClass();
            r103.f267554c.putExtra("account_previous_page", "third_party_authorization");
            boolean r108 = this.f357253a.f357144h;
            r103.f267554c.putExtra("key_bind_phone_from_h5", r108);
            r103.f267555d = R.anim.larus_router_slide_in_right;
            r103.f267556e = R.anim.larus_router_no_anim;
            r103.d();
            return;
        L6:
            r106 = "";
            goto L7
        }

        public a(AuthVerifyFragment r100, LoginPlatform r101) {
            this.f357253a = r100;
            this.f357254b = r101;
        }

        @Override // n38.m
        public final void a(int r110, String r111, String r112, String r113) {
            t19.s r114 = t19.s.f544207a;
            Application r115 = AppHost.f326268a.getApplication();
            if (r111 != null) goto L5;
        L8:
            boolean r100 = true;
        L9:
            if (r100 == false) goto L11;
            r111 = this.f357253a.getString(R.string.larus_third_authorization_failed_cn);
        L11:
            Intrinsics.checkNotNull(r111);
            r114.getClass();
            t19.s.c(r115, r111);
            this.f357253a.getClass();
            String r101 = String.valueOf(r110);
            if (this.f357254b != LoginPlatform.DOUYIN) goto L14;
            String r116 = "douyin_verify";
        L15:
            tx9.s1.a("third_party_authorization", null, false, r101, r116, "phone_verify_code", "shutdown_or_unavailable", this.f357253a, 130);
            return;
        L14:
            r116 = "weixin_verify";
            goto L15
        L5:
            if (r111.length() == 0) goto L8;
            r100 = false;
            goto L9
        }
    }

    public a0(AuthVerifyFragment r100, LoginPlatform r101) {
        this.f357249a = "8943";
        this.f357250b = "aweme_v2";
        this.f357251c = r100;
        this.f357252d = r101;
    }

    @Override // n38.l
    public final void a(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        ILoginService.f286097a.S(r100, this.f357249a, this.f357250b, new a(this.f357251c, this.f357252d));
    }

    @Override // n38.l
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        t19.s r102 = t19.s.f544207a;
        Application r103 = AppHost.f326268a.getApplication();
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r100 = this.f357251c.getString(R.string.larus_third_authorization_failed_cn);
    L8:
        Intrinsics.checkNotNull(r100);
        r102.getClass();
        t19.s.c(r103, r100);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
