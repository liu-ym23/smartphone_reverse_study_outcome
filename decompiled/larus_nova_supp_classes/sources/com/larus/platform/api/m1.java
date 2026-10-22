package com.larus.platform.api;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.profile.impl.o1;
import com.larus.profile.impl.p1;
import com.obric.assistant.component.ObricSkillComponent;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface m1 {
    MutableLiveData<List<String>> A();

    String B();

    void C(ObricSkillComponent.c r1);

    void D(b r1);

    void E(b r1);

    boolean F();

    String G();

    void H(m4 r1);

    boolean I();

    String J();

    void K(String r1);

    boolean a();

    String b();

    boolean c(int r1, int r2, String r3);

    String d(String r1);

    Object e(String r1, Continuation<? super Boolean> r2);

    void f(r0 r1);

    void g(int r1, d r2, boolean r3);

    String getNickname();

    String getPrivacyPolicyUrl();

    String getSecUserId();

    String getTenantId();

    String getTenantName();

    String getUserId();

    String getUserName();

    String getXTTToken();

    n4 h(CommonSettingFragment r1);

    boolean i(Fragment r1);

    boolean isEnterpriseAccount();

    Boolean isLogin();

    boolean isMuted();

    boolean isNewUser();

    void j(r0 r1);

    boolean k();

    void l(String r1, o1 r2, p1 r3);

    String m();

    String n();

    void o(FragmentActivity r1, String r2, String r3);

    void p(String r1, long r2, Map<String, String> r4, String r5);

    List<String> q();

    String r();

    String s();

    String t();

    void u(a r1);

    int v();

    boolean w();

    String x();

    void y(boolean r1);

    void z(String r1, g4 r2);
}
