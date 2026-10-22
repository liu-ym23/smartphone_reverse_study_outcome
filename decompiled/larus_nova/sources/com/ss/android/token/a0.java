package com.ss.android.token;

import android.text.TextUtils;
import com.bytedance.android.sdk.bdticketguard.j1;
import com.bytedance.android.sdk.bdticketguard.w0;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.ticketguard.AccountTicketGuardManager;
import com.bytedance.sdk.account.time.RealTimeManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f449706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TokenFactory f449707b;

    public class a implements com.bytedance.sdk.account.ticketguard.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f449708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f449709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f449710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f449711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a0 f449712e;

        /* JADX INFO: renamed from: com.ss.android.token.a0$a$a, reason: collision with other inner class name */
        public class RunnableC5447a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f449713a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f449714b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f449715c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f449716d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f449717e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ a f449718f;

            public final void a() {
                Map<String, RealTimeManager> r100 = RealTimeManager.f269490j;
                long r110 = RealTimeManager.a.a().b(this.f449718f.f449712e.f449707b.f449669i, true).f269505a;
                a r101 = this.f449718f;
                String r102 = r101.f449708a;
                String r103 = r101.f449709b;
                String r104 = com.ss.android.account.k.d().S();
                boolean r105 = this.f449713a;
                boolean r111 = this.f449714b;
                boolean r112 = this.f449715c;
                boolean r113 = this.f449716d;
                a r114 = this.f449718f;
                com.bytedance.android.sdk.bdticketguard.j r106 = new com.bytedance.android.sdk.bdticketguard.j(r102, r103, r104, "/passport/safe/get_token/", "x-tt-token", !r105, r105, r111, r110, r112, r113, r114.f449710c, this.f449717e);
                r114.f449712e.f449707b.getClass();
                j1 r107 = w0.f164095a;
                j1 r108 = w0.f164095a;
                if (r108 != null) goto L5;
                tb7.a.e("TokenFactory", "getUseTicketGuardParams, ticket guard service is null");
                com.bytedance.android.sdk.bdticketguard.g r109 = null;
            L6:
                a r115 = this.f449718f;
                TokenFactory r116 = r115.f449712e.f449707b;
                Map r117 = r115.f449711d;
                r116.getClass();
                TokenFactory.d(r117, r106, r109);
                a r118 = this.f449718f;
                r118.f449712e.f449706a.onSuccess(r118.f449711d);
                return;
            L5:
                r109 = r108.h(r106);
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC5447a(a r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
                this.f449718f = r100;
                this.f449713a = r101;
                this.f449714b = r102;
                this.f449715c = r103;
                this.f449716d = r104;
                this.f449717e = r105;
            }
        }

        @Override // com.bytedance.sdk.account.ticketguard.c
        public final void a(boolean r110) {
            int r100 = com.bytedance.sdk.account.ticketguard.f.b("/passport/safe/get_token/");
            if (r100 == 3) goto L7;
            if (r100 == 1) goto L7;
            boolean r101 = false;
        L8:
            if (r100 != 3) goto L10;
        L13:
            boolean r102 = true;
        L14:
            com.bytedance.sdk.account.ticketguard.f.a();
            if (com.bytedance.sdk.account.ticketguard.f.R == false) goto L19;
            com.bytedance.sdk.account.ticketguard.f.a();
            if (com.bytedance.sdk.account.ticketguard.f.d("/passport/safe/get_token/", com.bytedance.sdk.account.ticketguard.f.W, com.bytedance.sdk.account.ticketguard.f.X, com.bytedance.sdk.account.ticketguard.f.Y, com.bytedance.sdk.account.ticketguard.f.Z) == false) goto L19;
            boolean r103 = true;
        L20:
            com.bytedance.sdk.account.ticketguard.f.a();
            if (com.bytedance.sdk.account.ticketguard.f.f269475u == false) goto L25;
            com.bytedance.sdk.account.ticketguard.f.a();
            if (com.bytedance.sdk.account.ticketguard.f.d("/passport/safe/get_token/", com.bytedance.sdk.account.ticketguard.f.f269447b, com.bytedance.sdk.account.ticketguard.f.f269449c, com.bytedance.sdk.account.ticketguard.f.f269451d, com.bytedance.sdk.account.ticketguard.f.f269453e) == false) goto L25;
            boolean r104 = true;
        L26:
            com.bytedance.sdk.account.ticketguard.f.a();
            if (com.bytedance.sdk.account.ticketguard.f.f269448b0 == true) goto L29;
            boolean r111 = false;
        L30:
            ThreadPlus.submitRunnable(new RunnableC5447a(this, r101, r102, r103, r104, r111));
            return;
        L29:
            com.ss.android.account.k.b r105 = com.ss.android.account.k.f406317a;
            r111 = com.bytedance.sdk.account.ticketguard.f.d("/passport/safe/get_token/", com.bytedance.sdk.account.ticketguard.f.f269454e0, com.bytedance.sdk.account.ticketguard.f.f269456f0, com.bytedance.sdk.account.ticketguard.f.f269458g0, com.bytedance.sdk.account.ticketguard.f.f269460h0);
        L25:
            r104 = false;
        L19:
            r103 = false;
            goto L20
        L10:
            if (r100 == 2) goto L13;
            r102 = false;
        L7:
            r101 = true;
            goto L8
        }

        public a(a0 r100, String r101, String r102, String r103, Map r104) {
            this.f449712e = r100;
            this.f449708a = r101;
            this.f449709b = r102;
            this.f449710c = r103;
            this.f449711d = r104;
        }
    }

    public final void a() {
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.f269461i == true) goto L6;
        this.f449706a.onError("not enable token guard");
        return;
    L6:
        AuthTokenMultiProcessSharedProvider.b r100 = this.f449707b.m();
        String r101 = r100.f(LoginVerifyService.X_TT_TOKEN);
        String r102 = r100.f("token_encrypted");
        if (TextUtils.isEmpty(r101) == true) goto L9;
    L12:
        String r103 = r100.f("ts_sign");
        if (TextUtils.isEmpty(r103) == false) goto L16;
        this.f449706a.onError("no ts_sign");
        return;
    L16:
        String r104 = r100.f("attest_ts_sign");
        if (TextUtils.isEmpty(r104) == false) goto L19;
        tb7.a.b("TokenFactory", "no attest_ts_sign");
    L19:
        String r105 = r100.f("mfa_token");
        HashMap r110 = new HashMap();
        if (TextUtils.isEmpty(r101) == true) goto L23;
        r110.put(LoginVerifyService.X_TT_TOKEN, r101);
    L25:
        String r106 = r101;
        if (TextUtils.isEmpty(r105) == true) goto L28;
        r110.put("x-tt-passport-mfa-token", r105);
    L28:
        this.f449707b.getClass();
        r110.put("sdk-version", "2");
        r110.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, String.valueOf(60592));
        AccountTicketGuardManager.f(this.f449707b.f449669i, "group_one_login", new a(this, r103, r106, r104, r110));
        return;
    L23:
        if (TextUtils.isEmpty(r102) == true) goto L25;
        r101 = r.i(r102);
        r110.put(LoginVerifyService.X_TT_TOKEN, r101);
        goto L25
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L12;
        this.f449706a.onError("no token");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a0(TokenFactory r100, b r101) {
        this.f449707b = r100;
        this.f449706a = r101;
    }
}
