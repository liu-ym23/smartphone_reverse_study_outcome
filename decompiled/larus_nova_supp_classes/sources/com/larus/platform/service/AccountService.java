package com.larus.platform.service;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.platform.api.a;
import com.larus.platform.api.b;
import com.larus.platform.api.d;
import com.larus.platform.api.g4;
import com.larus.platform.api.m1;
import com.larus.platform.api.m4;
import com.larus.platform.api.n4;
import com.larus.platform.api.r0;
import com.larus.profile.impl.o1;
import com.larus.profile.impl.p1;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class AccountService implements m1 {
    public static final AccountService a = null;
    public static final Lazy b = null;

    public AccountService() {
    }

    static {
        a = new AccountService();
        b = LazyKt.lazy(new c());
    }

    public static m1 L() {
        return (m1) b.getValue();
    }

    @Override // com.larus.platform.api.m1
    public final MutableLiveData<List<String>> A() {
        m1 r0 = L();
        if (r0 == null) goto L7;
        MutableLiveData<List<String>> r1 = r0.A();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new MutableLiveData();
    }

    @Override // com.larus.platform.api.m1
    public final String B() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.B();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final boolean F() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.F();
    }

    @Override // com.larus.platform.api.m1
    public final String G() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.G();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final boolean I() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.I();
    }

    @Override // com.larus.platform.api.m1
    public final String J() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.J();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final boolean a() {
        m1 r0 = L();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m1
    public final String b() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.b();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final String getNickname() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.getNickname();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final String getPrivacyPolicyUrl() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.getPrivacyPolicyUrl();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final String getSecUserId() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.getSecUserId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final String getTenantId() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTenantId();
    }

    @Override // com.larus.platform.api.m1
    public final String getTenantName() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTenantName();
    }

    @Override // com.larus.platform.api.m1
    public final String getUserId() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.getUserId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final String getUserName() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.getUserName();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final String getXTTToken() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getXTTToken();
    }

    @Override // com.larus.platform.api.m1
    public final boolean isEnterpriseAccount() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEnterpriseAccount();
    }

    @Override // com.larus.platform.api.m1
    public final Boolean isLogin() {
        m1 r0 = L();
        if (r0 == null) goto L7;
        Boolean r1 = r0.isLogin();
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L9:
        return Boolean.valueOf(r2);
    L7:
        r2 = false;
        goto L9
    }

    @Override // com.larus.platform.api.m1
    public final boolean isMuted() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isMuted();
    }

    @Override // com.larus.platform.api.m1
    public final boolean isNewUser() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isNewUser();
    }

    @Override // com.larus.platform.api.m1
    public final boolean k() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.k();
    }

    @Override // com.larus.platform.api.m1
    public final String m() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.m();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final String n() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.n();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final List<String> q() {
        m1 r0 = L();
        if (r0 == null) goto L7;
        List<String> r1 = r0.q();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.platform.api.m1
    public final String r() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.r();
    }

    @Override // com.larus.platform.api.m1
    public final String s() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.s();
    }

    @Override // com.larus.platform.api.m1
    public final String t() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.t();
    }

    @Override // com.larus.platform.api.m1
    public final int v() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.v();
    }

    @Override // com.larus.platform.api.m1
    public final boolean w() {
        m1 r0 = L();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.w();
    }

    @Override // com.larus.platform.api.m1
    public final String x() {
        m1 r0 = L();
        if (r0 == null) goto L6;
        String r1 = r0.x();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m1
    public final void C(ObricSkillComponent.c r2) {
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.C(r2);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void D(b r2) {
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.D(r2);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void E(b r2) {
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.E(r2);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void H(m4 r2) {
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.H(r2);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void K(String r2) {
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.K(r2);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scanResult");
        m1 r0 = L();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d(r2);
    }

    @Override // com.larus.platform.api.m1
    public final void f(r0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final n4 h(CommonSettingFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        m1 r0 = L();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h(r2);
    }

    @Override // com.larus.platform.api.m1
    public final boolean i(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        m1 r0 = L();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.i(r2);
    }

    @Override // com.larus.platform.api.m1
    public final void j(r0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void u(a r3) {
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", "template");
        Intrinsics.checkNotNullParameter(r3, "callback");
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.u(r3);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void y(boolean r2) {
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.y(r2);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final Object e(String r5, Continuation<? super Boolean> r6) {
        if ((r6 instanceof queryUserInfoWhenCacheEmpty.1) == false) goto L7;
        queryUserInfoWhenCacheEmpty.1 r0 = (queryUserInfoWhenCacheEmpty.1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L19:
        boolean r8 = ((Boolean) r7).booleanValue();
    L22:
        return Boxing.boxBoolean(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        m1 r9 = L();
        if (r9 == null) goto L20;
        r0.label = 1;
        r7 = r9.e(r5, r0);
        if (r7 != r2) goto L19;
        return r2;
    L20:
        r8 = false;
    L7:
        r0 = new queryUserInfoWhenCacheEmpty.1(this, r6);
        goto L8
    }

    @Override // com.larus.platform.api.m1
    public final void z(String r2, g4 r3) {
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.z(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final boolean c(int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "payload");
        m1 r0 = L();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c(r2, r3, r4) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m1
    public final void g(int r2, d r3, boolean r4) {
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.g(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void l(String r2, o1 r3, p1 r4) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "onSuccess");
        Intrinsics.checkNotNullParameter(r4, "onFail");
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.l(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void o(FragmentActivity r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        m1 r0 = L();
        if (r0 == null) goto L6;
        r0.o(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.m1
    public final void p(String r8, long r9, Map<String, String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "eventType");
        Intrinsics.checkNotNullParameter(r11, "extra");
        m1 r1 = L();
        if (r1 == null) goto L6;
        r1.p(r8, r9, r11, r12);
        return;
    }
}
