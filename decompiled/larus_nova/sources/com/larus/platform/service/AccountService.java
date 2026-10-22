package com.larus.platform.service;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.platform.api.g4;
import com.larus.platform.api.m4;
import com.larus.platform.api.n4;
import com.obric.assistant.component.ObricSkillComponent;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AccountService implements com.larus.platform.api.m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AccountService f365697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365698b = null;

    public AccountService() {
    }

    static {
        f365697a = new AccountService();
        f365698b = LazyKt.lazy(new c());
    }

    public static com.larus.platform.api.m1 L() {
        return (com.larus.platform.api.m1) f365698b.getValue();
    }

    @Override // com.larus.platform.api.m1
    public final MutableLiveData<List<String>> A() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L7;
        MutableLiveData<List<String>> r101 = r100.A();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new MutableLiveData();
    }

    @Override // com.larus.platform.api.m1
    public final String B() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.B();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final boolean F() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.F();
    }

    @Override // com.larus.platform.api.m1
    public final String G() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.G();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final boolean I() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.I();
    }

    @Override // com.larus.platform.api.m1
    public final String J() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.J();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final boolean a() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.a() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m1
    public final String b() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.b();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final String getNickname() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.getNickname();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final String getPrivacyPolicyUrl() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.getPrivacyPolicyUrl();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final String getSecUserId() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.getSecUserId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final String getTenantId() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTenantId();
    }

    @Override // com.larus.platform.api.m1
    public final String getTenantName() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTenantName();
    }

    @Override // com.larus.platform.api.m1
    public final String getUserId() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.getUserId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final String getUserName() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.getUserName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final String getXTTToken() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getXTTToken();
    }

    @Override // com.larus.platform.api.m1
    public final boolean isEnterpriseAccount() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isEnterpriseAccount();
    }

    @Override // com.larus.platform.api.m1
    public final Boolean isLogin() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L7;
        Boolean r101 = r100.isLogin();
        if (r101 == null) goto L7;
        boolean r102 = r101.booleanValue();
    L9:
        return Boolean.valueOf(r102);
    L7:
        r102 = false;
        goto L9
    }

    @Override // com.larus.platform.api.m1
    public final boolean isMuted() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isMuted();
    }

    @Override // com.larus.platform.api.m1
    public final boolean isNewUser() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isNewUser();
    }

    @Override // com.larus.platform.api.m1
    public final boolean k() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.k();
    }

    @Override // com.larus.platform.api.m1
    public final String m() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.m();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final String n() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.n();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final List<String> q() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L7;
        List<String> r101 = r100.q();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.platform.api.m1
    public final String r() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.r();
    }

    @Override // com.larus.platform.api.m1
    public final String s() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.s();
    }

    @Override // com.larus.platform.api.m1
    public final String t() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.t();
    }

    @Override // com.larus.platform.api.m1
    public final int v() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.v();
    }

    @Override // com.larus.platform.api.m1
    public final boolean w() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.w();
    }

    @Override // com.larus.platform.api.m1
    public final String x() {
        com.larus.platform.api.m1 r100 = L();
        if (r100 == null) goto L6;
        String r101 = r100.x();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.m1
    public final void C(ObricSkillComponent.c r100) {
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.C(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void D(com.larus.platform.api.b r100) {
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.D(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void E(com.larus.platform.api.b r100) {
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.E(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void H(m4 r100) {
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.H(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void K(String r100) {
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.K(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scanResult");
        com.larus.platform.api.m1 r101 = L();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.d(r100);
    }

    @Override // com.larus.platform.api.m1
    public final void f(com.larus.platform.api.r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final n4 h(CommonSettingFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        com.larus.platform.api.m1 r101 = L();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.h(r100);
    }

    @Override // com.larus.platform.api.m1
    public final boolean i(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        com.larus.platform.api.m1 r101 = L();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.i(r100);
    }

    @Override // com.larus.platform.api.m1
    public final void j(com.larus.platform.api.r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void u(com.larus.platform.api.a r100) {
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r100, "callback");
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.u(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void y(boolean r100) {
        com.larus.platform.api.m1 r101 = L();
        if (r101 == null) goto L6;
        r101.y(r100);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final Object e(String r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof AccountService$queryUserInfoWhenCacheEmpty$1) == false) goto L7;
        AccountService$queryUserInfoWhenCacheEmpty$1 r102 = (AccountService$queryUserInfoWhenCacheEmpty$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L19:
        boolean r107 = ((Boolean) r104).booleanValue();
    L22:
        return Boxing.boxBoolean(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        com.larus.platform.api.m1 r108 = L();
        if (r108 == null) goto L20;
        r102.label = 1;
        r104 = r108.e(r100, r102);
        if (r104 != r105) goto L19;
        return r105;
    L20:
        r107 = false;
    L7:
        r102 = new AccountService$queryUserInfoWhenCacheEmpty$1(this, r101);
        goto L8
    }

    @Override // com.larus.platform.api.m1
    public final void z(String r100, g4 r101) {
        com.larus.platform.api.m1 r102 = L();
        if (r102 == null) goto L6;
        r102.z(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final boolean c(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        com.larus.platform.api.m1 r103 = L();
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.c(r100, r101, r102) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m1
    public final void g(int r100, com.larus.platform.api.d r101, boolean r102) {
        com.larus.platform.api.m1 r103 = L();
        if (r103 == null) goto L6;
        r103.g(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void l(String r100, com.larus.profile.impl.o1 r101, com.larus.profile.impl.p1 r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFail");
        com.larus.platform.api.m1 r103 = L();
        if (r103 == null) goto L6;
        r103.l(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void o(FragmentActivity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        com.larus.platform.api.m1 r103 = L();
        if (r103 == null) goto L6;
        r103.o(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void p(String r100, long r101, Map<String, String> r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r110, "extra");
        com.larus.platform.api.m1 r102 = L();
        if (r102 == null) goto L6;
        r102.p(r100, r101, r110, r111);
        return;
    }
}
