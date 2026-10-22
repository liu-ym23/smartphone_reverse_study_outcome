package com.larus.home.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.api.UserAction;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.security.api.IAccountSecurityService;
import com.larus.account.saas.security.model.AccountSecurityEventType;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.AccountTrackService;
import com.larus.login.api.ILoginApi;
import com.larus.login.api.LoginService;
import com.larus.login.api.TouristManager;
import com.larus.minor.api.IMinorService;
import com.larus.platform.api.AccountState;
import com.larus.platform.api.g4;
import com.larus.platform.api.m4;
import com.larus.platform.api.n4;
import com.larus.platform.service.AccountService;
import com.larus.profile.api.IProfileApi;
import com.obric.assistant.component.ObricSkillComponent;
import com.ss.android.account.PassportExtraHeaderManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.larus.platform.api.m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f346150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f346151b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<com.larus.platform.api.b, n38.j> f346152c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<m4, com.larus.minor.api.c> f346153d = null;

    /* JADX INFO: loaded from: classes29.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries<AccountSecurityEventType> f346154a = null;

        static {
            f346154a = EnumEntriesKt.enumEntries(AccountSecurityEventType.values());
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f346155a = null;

        static {
            int[] r100 = new int[UserAction.values().length];
            r100[UserAction.USER_LOGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[UserAction.USER_LOGOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[UserAction.ACCOUNT_SWITCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f346155a = r100;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    public static final class c implements n38.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g4 f346156a;

        public c(g4 r100) {
            this.f346156a = r100;
        }

        @Override // n38.h
        public final void b(LoginPlatform r100, String r101, Boolean r102) {
            g4 r103 = this.f346156a;
            if (r103 == null) goto L6;
            r103.a();
            return;
        }

        @Override // n38.h
        public final void a(LoginPlatform r100, int r101, String r102, String r103, String r104, Integer r105, String r106, Map r107) {
            g4 r108 = this.f346156a;
            if (r108 == null) goto L6;
            r108.b();
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.home.impl.sdk.d$d, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class C4331d implements n38.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.larus.platform.api.b f346157a;

        public C4331d(com.larus.platform.api.b r100) {
            this.f346157a = r100;
        }

        @Override // n38.j
        public final void a(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            com.larus.platform.api.b r101 = this.f346157a;
            AccountState r102 = AccountState.OFFLINE;
            n38.c r103 = r100.f516979b;
            String r104 = r103.f516993a;
            String r105 = r103.f516994b;
            d r106 = d.f346150a;
            r101.b(new com.larus.platform.api.c(r102, r104, r105, d.L(r100.f516980c), r100.f516981d));
        }

        @Override // n38.j
        public final void b(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            com.larus.platform.api.b r101 = this.f346157a;
            AccountState r102 = AccountState.ONLINE;
            n38.c r103 = r100.f516979b;
            String r104 = r103.f516993a;
            String r105 = r103.f516994b;
            d r106 = d.f346150a;
            r101.a(new com.larus.platform.api.c(r102, r104, r105, d.L(r100.f516980c), r100.f516981d));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class e implements com.larus.minor.api.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m4 f346158a;

        @Override // com.larus.minor.api.c
        public final void AT() {
        }

        @Override // com.larus.minor.api.c
        public final void S1() {
            m4 r100 = this.f346158a;
            if (r100 == null) goto L6;
            r100.S1();
            return;
        }

        @Override // com.larus.minor.api.c
        public final void b1() {
            m4 r100 = this.f346158a;
            if (r100 == null) goto L6;
            r100.b1();
            return;
        }

        public e(m4 r100) {
            this.f346158a = r100;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    public static final class f implements n38.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.larus.platform.api.d f346159a;

        public f(com.larus.platform.api.d r100) {
            this.f346159a = r100;
        }

        @Override // n38.l
        public final void a(String r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "token");
            com.larus.platform.api.d r102 = this.f346159a;
            if (r102 == null) goto L6;
            r102.a(r100);
            return;
        }

        @Override // n38.l
        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "errorMsg");
            com.larus.platform.api.d r102 = this.f346159a;
            if (r102 == null) goto L6;
            r102.b(r100);
            return;
        }
    }

    public d() {
    }

    @Override // com.larus.platform.api.m1
    public final List<String> q() {
        return uj9.d.a(false, false);
    }

    static {
        f346150a = new d();
        f346151b = new MutableLiveData(Boolean.FALSE);
        f346152c = new ConcurrentHashMap();
        f346153d = new ConcurrentHashMap();
    }

    @Override // com.larus.platform.api.m1
    public final MutableLiveData<List<String>> A() {
        MutableLiveData<List<String>> r100 = com.larus.home.api.block.a.f344082a;
        return com.larus.home.api.block.a.f344082a;
    }

    @Override // com.larus.platform.api.m1
    public final String B() {
        return ILoginService.f286097a.getAccountInfo().f531533f;
    }

    @Override // com.larus.platform.api.m1
    public final boolean F() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.i();
    }

    @Override // com.larus.platform.api.m1
    public final String G() {
        List<Integer> r100 = com.larus.login.api.i0.f357057a;
        return "15210";
    }

    @Override // com.larus.platform.api.m1
    public final boolean I() {
        if (ILoginService.f286097a.p(LoginPlatform.DOUYIN) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.platform.api.m1
    public final String J() {
        List<Integer> r100 = com.larus.login.api.i0.f357057a;
        return "8943";
    }

    public final boolean M() {
        return LoginService.f356989a.O();
    }

    public final boolean N() {
        return IAccountService.f286094a.p();
    }

    public final boolean O() {
        ILoginApi r100 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.P();
    }

    @Override // com.larus.platform.api.m1
    public final boolean a() {
        return IMinorService.f359156a.a();
    }

    @Override // com.larus.platform.api.m1
    public final String b() {
        return IAccountService.f286094a.b();
    }

    @Override // com.larus.platform.api.m1
    public final String getNickname() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        if (r100 == null) goto L6;
        String r101 = r100.d();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final String getPrivacyPolicyUrl() {
        return IAccountService.f286094a.getPrivacyPolicyUrl();
    }

    @Override // com.larus.platform.api.m1
    public final String getSecUserId() {
        if (TouristManager.f357001a.t() == false) goto L13;
        com.larus.bmhome.auth.c1<com.larus.bmhome.auth.h0> r100 = AuthModelDelegate.f297134b.a().getValue();
        if (r100 == null) goto L9;
        com.larus.bmhome.auth.h0 r101 = r100.f295753d;
        if (r101 == null) goto L9;
        String r102 = r101.h();
    L10:
        if (r102 != null) goto L14;
        return "";
    L14:
        return r102;
    L9:
        r102 = null;
        goto L10
    L13:
        return ILoginService.f286097a.getAccountInfo().f531531d;
    }

    @Override // com.larus.platform.api.m1
    public final String getTenantId() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        if (r100 == null) goto L7;
        r38.a r101 = r100.e();
        if (r101 == null) goto L7;
        return r101.a();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.m1
    public final String getTenantName() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        if (r100 == null) goto L7;
        r38.a r101 = r100.e();
        if (r101 == null) goto L7;
        return r101.b();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.m1
    public final String getUserId() {
        return ILoginService.f286097a.getAccountInfo().f531530c;
    }

    @Override // com.larus.platform.api.m1
    public final String getUserName() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        if (r100 == null) goto L6;
        String r101 = r100.g();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final boolean isEnterpriseAccount() {
        return ILoginService.f286097a.getAccountInfo().f531534g;
    }

    @Override // com.larus.platform.api.m1
    public final Boolean isLogin() {
        return Boolean.valueOf(ILoginService.f286097a.getAccountInfo().f531528a);
    }

    @Override // com.larus.platform.api.m1
    public final boolean isMuted() {
        Boolean r100 = f346151b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    @Override // com.larus.platform.api.m1
    public final boolean isNewUser() {
        return ILoginService.f286097a.isNewUser();
    }

    @Override // com.larus.platform.api.m1
    public final boolean k() {
        return LoginService.f356989a.k();
    }

    @Override // com.larus.platform.api.m1
    public final String m() {
        List<Integer> r100 = com.larus.login.api.i0.f357057a;
        return "2198";
    }

    @Override // com.larus.platform.api.m1
    public final String n() {
        List<Integer> r100 = com.larus.login.api.i0.f357057a;
        return "2195";
    }

    @Override // com.larus.platform.api.m1
    public final String r() {
        if (com.ss.android.token.p.f449778b == true) goto L5;
    L13:
        return "";
    L5:
        if (TextUtils.isEmpty("x-tt-token-supplement") == true) goto L13;
        PassportExtraHeaderManager.f406212m.getClass();
        PassportExtraHeaderManager r100 = PassportExtraHeaderManager.f406211l;
        if (r100 == null) goto L13;
        r100.h();
        String r101 = r100.f406213a.get("x-tt-token-supplement");
        if (r101 == null) goto L13;
        return r101;
    }

    @Override // com.larus.platform.api.m1
    public final String s() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        if (r100 == null) goto L7;
        AvatarInfo r101 = r100.a();
        if (r101 == null) goto L7;
        return r101.a();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.m1
    public final String t() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        if (r100 == null) goto L7;
        AvatarInfo r101 = r100.a();
        if (r101 == null) goto L7;
        return r101.c();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.m1
    public final int v() {
        return IMultiAccountService.f286100a.g().size();
    }

    @Override // com.larus.platform.api.m1
    public final boolean w() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.j();
    }

    @Override // com.larus.platform.api.m1
    public final String x() {
        List<Integer> r100 = com.larus.login.api.i0.f357057a;
        return "2089";
    }

    @Override // com.larus.platform.api.m1
    public final String getXTTToken() {
        return com.ss.android.token.p.d();
    }

    public static final com.larus.platform.api.UserAction L(UserAction r100) {
        int r101 = b.f346155a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return com.larus.platform.api.UserAction.ACCOUNT_SWITCH;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return com.larus.platform.api.UserAction.USER_LOGOUT;
    L13:
        return com.larus.platform.api.UserAction.USER_LOGIN;
    }

    @Override // com.larus.platform.api.m1
    public final void C(ObricSkillComponent.c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<m4, com.larus.minor.api.c> r101 = f346153d;
        com.larus.minor.api.c r102 = r101.get(r100);
        if (r102 != null) goto L7;
        return;
    L7:
        r101.remove(r100);
        IMinorService.f359156a.i(r102);
    }

    @Override // com.larus.platform.api.m1
    public final void D(com.larus.platform.api.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<com.larus.platform.api.b, n38.j> r101 = f346152c;
        n38.j r102 = r101.get(r100);
        if (r102 != null) goto L7;
        return;
    L7:
        r101.remove(r100);
        ILoginService.f286097a.Q(r102);
    }

    @Override // com.larus.platform.api.m1
    public final void E(com.larus.platform.api.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        C4331d r101 = new C4331d(r100);
        f346152c.put(r100, r101);
        ILoginService.a.c(ILoginService.f286097a, r101);
    }

    @Override // com.larus.platform.api.m1
    public final void H(m4 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        e r101 = new e(r100);
        f346153d.put(r100, r101);
        IMinorService.a.a(IMinorService.f359156a, r101);
    }

    @Override // com.larus.platform.api.m1
    public final void K(String r100) {
        AccountTrackService.f356934a.b(AccountService.f365697a.getSecUserId(), 31L);
        LoginService.f356989a.t();
        t19.s r101 = t19.s.f544207a;
        Application r102 = AppHost.f326268a.getApplication();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.getClass();
        t19.s.t(r102, r100);
    }

    public final boolean P(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ILoginApi r101 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.a(r100);
    }

    @Override // com.larus.platform.api.m1
    public final String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scanResult");
        return IAccountService.f286094a.d(r100);
    }

    @Override // com.larus.platform.api.m1
    public final void f(com.larus.platform.api.r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LoginService.f356989a.f(r100);
    }

    @Override // com.larus.platform.api.m1
    public final n4 h(CommonSettingFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        return LoginService.f356989a.h(r100);
    }

    @Override // com.larus.platform.api.m1
    public final boolean i(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ILoginApi r101 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.i(r100);
    }

    @Override // com.larus.platform.api.m1
    public final void j(com.larus.platform.api.r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LoginService.f356989a.j(r100);
    }

    @Override // com.larus.platform.api.m1
    public final void u(com.larus.platform.api.a r100) {
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r100, "callback");
        int r101 = com.larus.home.impl.sdk.c.f346146a;
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r100, "callback");
        FlowAccountSdk.d().a(new com.larus.home.impl.sdk.b(r100));
    }

    @Override // com.larus.platform.api.m1
    public final void y(boolean r100) {
        f346151b.postValue(Boolean.valueOf(r100));
    }

    @Override // com.larus.platform.api.m1
    public final Object e(String r100, Continuation<? super Boolean> r101) {
        return IProfileApi.f365981a.e(r100, r101);
    }

    @Override // com.larus.platform.api.m1
    public final void z(String r100, g4 r101) {
        ILoginService.f286097a.x(false, new c(r101), r100);
    }

    public final void Q(Fragment r100, Bundle r101, com.larus.bmhome.chat.i0 r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "doAfterBind");
        ILoginApi r103 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r103 == null) goto L6;
        r103.D(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final boolean c(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        return IAccountService.f286094a.c(r100, r101, r102);
    }

    @Override // com.larus.platform.api.m1
    public final void g(int r100, com.larus.platform.api.d r101, boolean r110) {
        if (r100 != 1) goto L5;
        LoginPlatform r102 = LoginPlatform.DOUYIN;
    L18:
        LoginPlatform r103 = r102;
        if (r103 != null) goto L21;
        return;
    L21:
        ILoginService.a.d(ILoginService.f286097a, r103, new f(r101), "", r110, null, 16);
        return;
    L5:
        if (r100 != 2) goto L7;
        r102 = LoginPlatform.GOOGLE;
        goto L18
    L7:
        if (r100 != 3) goto L9;
        r102 = LoginPlatform.FACEBOOK;
        goto L18
    L9:
        if (r100 != 4) goto L11;
        r102 = LoginPlatform.LINE;
        goto L18
    L11:
        if (r100 == 5) goto L13;
        r102 = null;
        goto L18
    L13:
        r102 = LoginPlatform.WEIXIN;
        goto L18
    }

    @Override // com.larus.platform.api.m1
    public final void l(String r100, com.larus.profile.impl.o1 r101, com.larus.profile.impl.p1 r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFail");
        ILoginService.f286097a.s(r100, r101, r102);
    }

    @Override // com.larus.platform.api.m1
    public final void o(FragmentActivity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        IProfileApi.f365981a.c(r100, r101, r102, true);
    }

    @Override // com.larus.platform.api.m1
    public final void p(String r110, long r111, Map<String, String> r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "eventType");
        Intrinsics.checkNotNullParameter(r112, "extra");
        Iterator<AccountSecurityEventType> r100 = a.f346154a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        AccountSecurityEventType r101 = r100.next();
        if (Intrinsics.areEqual(r101.getValue(), r110) == false) goto L4;
    L9:
        AccountSecurityEventType r102 = r101;
        if (r102 != null) goto L12;
        return;
    L12:
        IAccountSecurityService.Companion r114 = IAccountSecurityService.f286489a;
        String r103 = getSecUserId();
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        r114.h(new e48.d(r102, r103, r111, r112, r113));
        return;
    L8:
        r101 = null;
        goto L9
    }
}
