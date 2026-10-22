package com.larus.home.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.security.api.IAccountSecurityService;
import com.larus.account.saas.security.model.AccountSecurityEventType;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.h0;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.block.a;
import com.larus.login.api.AccountTrackService;
import com.larus.login.api.ILoginApi;
import com.larus.login.api.LoginService;
import com.larus.login.api.TouristManager;
import com.larus.login.api.i0;
import com.larus.minor.api.IMinorService;
import com.larus.minor.api.c;
import com.larus.platform.api.UserAction;
import com.larus.platform.api.b;
import com.larus.platform.api.g4;
import com.larus.platform.api.m1;
import com.larus.platform.api.m4;
import com.larus.platform.api.n4;
import com.larus.platform.api.r0;
import com.larus.platform.service.AccountService;
import com.larus.profile.api.IProfileApi;
import com.larus.profile.impl.p1;
import com.obric.assistant.component.ObricSkillComponent;
import com.ss.android.account.PassportExtraHeaderManager;
import com.ss.android.token.p;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d implements m1 {
    public static final d a = null;
    public static final MutableLiveData<Boolean> b = null;
    public static final ConcurrentHashMap<b, n38.j> c = null;
    public static final ConcurrentHashMap<m4, c> d = null;

    public d() {
    }

    @Override // com.larus.platform.api.m1
    public final List<String> q() {
        return uj9.d.a(false, false);
    }

    static {
        a = new d();
        b = new MutableLiveData(Boolean.FALSE);
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    @Override // com.larus.platform.api.m1
    public final MutableLiveData<List<String>> A() {
        MutableLiveData r0 = a.a;
        return a.a;
    }

    @Override // com.larus.platform.api.m1
    public final String B() {
        return ILoginService.a.getAccountInfo().f;
    }

    @Override // com.larus.platform.api.m1
    public final boolean F() {
        r38.b r0 = IAccountService.a.getUserInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.i();
    }

    @Override // com.larus.platform.api.m1
    public final String G() {
        List r0 = i0.a;
        return "15210";
    }

    @Override // com.larus.platform.api.m1
    public final boolean I() {
        if (ILoginService.a.p(LoginPlatform.DOUYIN) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.platform.api.m1
    public final String J() {
        List r0 = i0.a;
        return "8943";
    }

    public final boolean M() {
        return LoginService.a.O();
    }

    public final boolean N() {
        return IAccountService.a.p();
    }

    public final boolean O() {
        ILoginApi r0 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.P();
    }

    @Override // com.larus.platform.api.m1
    public final boolean a() {
        return IMinorService.a.a();
    }

    @Override // com.larus.platform.api.m1
    public final String b() {
        return IAccountService.a.b();
    }

    @Override // com.larus.platform.api.m1
    public final String getNickname() {
        r38.b r0 = IAccountService.a.getUserInfo();
        if (r0 == null) goto L6;
        String r1 = r0.d();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final String getPrivacyPolicyUrl() {
        return IAccountService.a.getPrivacyPolicyUrl();
    }

    @Override // com.larus.platform.api.m1
    public final String getSecUserId() {
        if (TouristManager.a.t() == false) goto L13;
        c1 r0 = (c1) AuthModelDelegate.b.a().getValue();
        if (r0 == null) goto L9;
        h0 r1 = (h0) r0.d;
        if (r1 == null) goto L9;
        String r2 = r1.h();
    L10:
        if (r2 != null) goto L14;
        return XmlPullParser.NO_NAMESPACE;
    L14:
        return r2;
    L9:
        r2 = null;
        goto L10
    L13:
        return ILoginService.a.getAccountInfo().d;
    }

    @Override // com.larus.platform.api.m1
    public final String getTenantId() {
        r38.b r0 = IAccountService.a.getUserInfo();
        if (r0 == null) goto L7;
        r38.a r1 = r0.e();
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.m1
    public final String getTenantName() {
        r38.b r0 = IAccountService.a.getUserInfo();
        if (r0 == null) goto L7;
        r38.a r1 = r0.e();
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.m1
    public final String getUserId() {
        return ILoginService.a.getAccountInfo().c;
    }

    @Override // com.larus.platform.api.m1
    public final String getUserName() {
        r38.b r0 = IAccountService.a.getUserInfo();
        if (r0 == null) goto L6;
        String r1 = r0.g();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final boolean isEnterpriseAccount() {
        return ILoginService.a.getAccountInfo().g;
    }

    @Override // com.larus.platform.api.m1
    public final Boolean isLogin() {
        return Boolean.valueOf(ILoginService.a.getAccountInfo().a);
    }

    @Override // com.larus.platform.api.m1
    public final boolean isMuted() {
        Boolean r0 = b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // com.larus.platform.api.m1
    public final boolean isNewUser() {
        return ILoginService.a.isNewUser();
    }

    @Override // com.larus.platform.api.m1
    public final boolean k() {
        return LoginService.a.k();
    }

    @Override // com.larus.platform.api.m1
    public final String m() {
        List r0 = i0.a;
        return "2198";
    }

    @Override // com.larus.platform.api.m1
    public final String n() {
        List r0 = i0.a;
        return "2195";
    }

    @Override // com.larus.platform.api.m1
    public final String r() {
        if (p.b == true) goto L5;
    L13:
        return XmlPullParser.NO_NAMESPACE;
    L5:
        if (TextUtils.isEmpty("x-tt-token-supplement") == true) goto L13;
        PassportExtraHeaderManager.m.getClass();
        PassportExtraHeaderManager r1 = PassportExtraHeaderManager.l;
        if (r1 == null) goto L13;
        r1.h();
        String r0 = (String) r1.a.get("x-tt-token-supplement");
        if (r0 == null) goto L13;
        return r0;
    }

    @Override // com.larus.platform.api.m1
    public final String s() {
        r38.b r0 = IAccountService.a.getUserInfo();
        if (r0 == null) goto L7;
        AvatarInfo r1 = r0.a();
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.m1
    public final String t() {
        r38.b r0 = IAccountService.a.getUserInfo();
        if (r0 == null) goto L7;
        AvatarInfo r1 = r0.a();
        if (r1 == null) goto L7;
        return r1.c();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.m1
    public final int v() {
        return IMultiAccountService.a.g().size();
    }

    @Override // com.larus.platform.api.m1
    public final boolean w() {
        r38.b r0 = IAccountService.a.getUserInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.j();
    }

    @Override // com.larus.platform.api.m1
    public final String x() {
        List r0 = i0.a;
        return "2089";
    }

    @Override // com.larus.platform.api.m1
    public final String getXTTToken() {
        return p.d();
    }

    public static final UserAction L(com.larus.account.base.api.UserAction r1) {
        int r2 = b.a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return UserAction.ACCOUNT_SWITCH;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return UserAction.USER_LOGOUT;
    L13:
        return UserAction.USER_LOGIN;
    }

    @Override // com.larus.platform.api.m1
    public final void C(ObricSkillComponent.c r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<m4, c> r0 = d;
        c r1 = r0.get(r3);
        if (r1 != null) goto L7;
        return;
    L7:
        r0.remove(r3);
        IMinorService.a.i(r1);
    }

    @Override // com.larus.platform.api.m1
    public final void D(b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<b, n38.j> r0 = c;
        n38.j r1 = r0.get(r3);
        if (r1 != null) goto L7;
        return;
    L7:
        r0.remove(r3);
        ILoginService.a.Q(r1);
    }

    @Override // com.larus.platform.api.m1
    public final void E(b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        n38.j r0 = new d(r3);
        c.put(r3, r0);
        ILoginService.a.c(ILoginService.a, r0);
    }

    @Override // com.larus.platform.api.m1
    public final void H(m4 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        c r0 = new e(r3);
        d.put(r3, r0);
        IMinorService.a.a(IMinorService.a, r0);
    }

    @Override // com.larus.platform.api.m1
    public final void K(String r5) {
        AccountTrackService.a.b(AccountService.a.getSecUserId(), 31L);
        LoginService.a.t();
        s r0 = s.a;
        Application r1 = AppHost.a.getApplication();
        if (r5 != null) goto L5;
        r5 = XmlPullParser.NO_NAMESPACE;
    L5:
        r0.getClass();
        s.t(r1, r5);
    }

    public final boolean P(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        ILoginApi r0 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r3);
    }

    @Override // com.larus.platform.api.m1
    public final String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scanResult");
        return IAccountService.a.d(r2);
    }

    @Override // com.larus.platform.api.m1
    public final void f(r0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        LoginService.a.f(r2);
    }

    @Override // com.larus.platform.api.m1
    public final n4 h(CommonSettingFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        return LoginService.a.h(r2);
    }

    @Override // com.larus.platform.api.m1
    public final boolean i(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        ILoginApi r0 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.i(r3);
    }

    @Override // com.larus.platform.api.m1
    public final void j(r0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        LoginService.a.j(r2);
    }

    @Override // com.larus.platform.api.m1
    public final void u(com.larus.platform.api.a r7) {
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", "template");
        Intrinsics.checkNotNullParameter(r7, "callback");
        int r5 = c.a;
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", "template");
        Intrinsics.checkNotNullParameter(r7, "callback");
        FlowAccountSdk.d().a(new b(r7));
    }

    @Override // com.larus.platform.api.m1
    public final void y(boolean r2) {
        b.postValue(Boolean.valueOf(r2));
    }

    @Override // com.larus.platform.api.m1
    public final Object e(String r2, Continuation<? super Boolean> r3) {
        return IProfileApi.a.e(r2, r3);
    }

    @Override // com.larus.platform.api.m1
    public final void z(String r3, g4 r4) {
        ILoginService.a.x(false, new c(r4), r3);
    }

    public final void Q(Fragment r3, Bundle r4, com.larus.bmhome.chat.i0 r5) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r5, "doAfterBind");
        ILoginApi r0 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r0 == null) goto L6;
        r0.D(r3, r4, r5);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final boolean c(int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "payload");
        return IAccountService.a.c(r2, r3, r4);
    }

    @Override // com.larus.platform.api.m1
    public final void g(int r8, com.larus.platform.api.d r9, boolean r10) {
        if (r8 != 1) goto L5;
        LoginPlatform r11 = LoginPlatform.DOUYIN;
    L18:
        LoginPlatform r1 = r11;
        if (r1 != null) goto L21;
        return;
    L21:
        ILoginService.a.d(ILoginService.a, r1, new f(r9), XmlPullParser.NO_NAMESPACE, r10, null, 16);
        return;
    L5:
        if (r8 != 2) goto L7;
        r11 = LoginPlatform.GOOGLE;
        goto L18
    L7:
        if (r8 != 3) goto L9;
        r11 = LoginPlatform.FACEBOOK;
        goto L18
    L9:
        if (r8 != 4) goto L11;
        r11 = LoginPlatform.LINE;
        goto L18
    L11:
        if (r8 == 5) goto L13;
        r11 = null;
        goto L18
    L13:
        r11 = LoginPlatform.WEIXIN;
        goto L18
    }

    @Override // com.larus.platform.api.m1
    public final void l(String r2, com.larus.profile.impl.o1 r3, p1 r4) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "onSuccess");
        Intrinsics.checkNotNullParameter(r4, "onFail");
        ILoginService.a.s(r2, r3, r4);
    }

    @Override // com.larus.platform.api.m1
    public final void o(FragmentActivity r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "avatarUrl");
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        IProfileApi.a.c(r3, r4, r5, true);
    }

    @Override // com.larus.platform.api.m1
    public final void p(String r10, long r11, Map<String, String> r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "eventType");
        Intrinsics.checkNotNullParameter(r13, "extra");
        Iterator<E> r0 = a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((AccountSecurityEventType) r1).getValue(), r10) == false) goto L4;
    L9:
        AccountSecurityEventType r3 = (AccountSecurityEventType) r1;
        if (r3 != null) goto L12;
        return;
    L12:
        IAccountSecurityService.Companion r12 = IAccountSecurityService.a;
        String r2 = getSecUserId();
        if (r2 != null) goto L15;
        r2 = XmlPullParser.NO_NAMESPACE;
    L15:
        r12.h(new e48.d(r3, r2, r11, r13, r14));
        return;
    L8:
        r1 = null;
        goto L9
    }
}
