package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.platform.OnekeyForceBindAdapter;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements ta7.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f268978b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f268979a;

    public static ta7.g l() {
        if (f268978b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f268978b != null) goto L9;
        f268978b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f268978b;
    }

    public d() {
        this.f268979a = com.ss.android.account.k.d().getApplicationContext();
    }

    public final void k(p38.e r100) {
        Context r101 = this.f268979a;
        int r102 = rb7.e.f536951l;
        lb7.a.C6671a r103 = new lb7.a.C6671a();
        r103.f508360a = ta7.d.a("/passport/auth/available_ways/");
        HashMap r104 = new HashMap();
        r104.put("need_limit_platform", "0");
        if (TextUtils.isEmpty(null) == true) goto L5;
        r104.put("not_login_ticket", null);
    L5:
        r103.f(r104);
        new rb7.e(r101, r103.h(), r100).m();
    }

    public final void j(String r100, p38.a r101) {
        Context r102 = this.f268979a;
        int r103 = rb7.b.f536940o;
        lb7.a.C6671a r104 = new lb7.a.C6671a();
        HashMap r105 = new HashMap();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r105.put("mobile", StringUtils.encryptWithXor(r100));
    L6:
        if (TextUtils.isEmpty(null) == true) goto L9;
        r105.put(ITwitterService.ResponseConstants.AUTH_TOKEN, null);
    L9:
        if (TextUtils.isEmpty(null) == true) goto L11;
        r105.put("not_login_ticket", null);
    L11:
        r105.put("mix_mode", "1");
        r104.f(r105);
        r104.f508360a = ta7.d.a("/passport/mobile/check_unusable/");
        new rb7.b(r102, r104.h(), r101).m();
    }

    public final void p(String r100, com.larus.account.base.impl.i r101) {
        Context r102 = this.f268979a;
        int r103 = xb7.m.f563156l;
        xb7.m.a r104 = new xb7.m.a(r100);
        lb7.a.C6671a r105 = new lb7.a.C6671a();
        r105.f508360a = ta7.d.a("/passport/mobile/validate_code/v1/");
        HashMap r106 = new HashMap();
        r106.put("mix_mode", "1");
        r106.put("fixed_mix_mode", "1");
        r106.put("code", StringUtils.encryptWithXor(Uri.encode(r100)));
        r106.put("type", StringUtils.encryptWithXor(String.valueOf(28)));
        r106.put("need_ticket", "1");
        if (TextUtils.isEmpty(null) == true) goto L5;
        r106.put("shark_ticket", null);
    L5:
        r105.f(r106);
        new xb7.m(r102, r105.h(), r104, r101).m();
    }

    public final void h(String r100, String r101, com.larus.account.base.impl.j r102) {
        Context r103 = this.f268979a;
        int r104 = xb7.b.f563132l;
        wb7.b r105 = new wb7.b(r100, r101);
        lb7.a.C6671a r106 = new lb7.a.C6671a();
        r106.f508360a = ta7.d.a("/passport/mobile/bind/v1/");
        HashMap r107 = new HashMap();
        if (TextUtils.isEmpty(null) == true) goto L5;
        r107.put("captcha", null);
    L5:
        r107.put("code", StringUtils.encryptWithXor(r101));
        r107.put("mobile", StringUtils.encryptWithXor(r100));
        r107.put("password", StringUtils.encryptWithXor(null));
        r107.put("unbind_exist", StringUtils.encryptWithXor(String.valueOf(0)));
        if (TextUtils.isEmpty(null) == true) goto L9;
        r107.put("not_login_ticket", null);
    L9:
        if (TextUtils.isEmpty(null) == true) goto L11;
        r107.put("verify_ticket", null);
    L11:
        r107.put("mix_mode", "1");
        r106.f(r107);
        new xb7.b(r103, r106.h(), r105, r102).m();
    }

    public final void q(String r100, String r101, com.obric.assistant.onelogin.a0.a r102) {
        gc7.d.f480866a = 8;
        gc7.d.f480867b = "share_login";
        Context r103 = this.f268979a;
        int r104 = xb7.j.f563148n;
        lb7.a.C6671a r105 = new lb7.a.C6671a();
        r105.f508360a = ta7.d.a("/passport/safe/one_login/");
        HashMap r106 = new HashMap();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r106.put("sec_user_id", r100);
    L5:
        TextUtils.isEmpty("device_login");
        r106.put("login_scene", "device_login");
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r106.put("d_ticket", StringUtils.encryptWithXor(r101));
    L8:
        r105.g(r106, null);
        new xb7.j(r103, r105.h(), r102).m();
    }

    public final void t(String r100, Map r101, yz8.h r102) {
        Context r103 = this.f268979a;
        int r104 = xb7.l.f563154l;
        wb7.k r105 = new wb7.k(r100);
        lb7.a.C6671a r106 = new lb7.a.C6671a();
        r106.f508360a = ta7.d.a("/passport/mobile/send_voice_code/");
        HashMap r107 = new HashMap();
        r107.put("mobile", StringUtils.encryptWithXor(r100));
        if (TextUtils.isEmpty("") == true) goto L5;
        r107.put("old_mobile", StringUtils.encryptWithXor(""));
    L5:
        r107.put("captcha", null);
        r107.put("type", StringUtils.encryptWithXor(String.valueOf(24)));
        r107.put("unbind_exist", StringUtils.encryptWithXor(String.valueOf(0)));
        r107.put("mix_mode", "1");
        r106.g(r107, r101);
        new xb7.l(r103, r106.h(), r105, r102).m();
    }

    public final void b(String r100, String r101, String r102, com.larus.account.base.impl.g r110) {
        gc7.d.f480866a = 2;
        gc7.d.f480867b = r100;
        Context r103 = this.f268979a;
        int r104 = xb7.a.f563130l;
        wb7.a r105 = new wb7.a(r100, r101, r102);
        lb7.a.C6671a r106 = new lb7.a.C6671a();
        r106.f508360a = ta7.d.a("/passport/mobile/bind_login/");
        HashMap r107 = new HashMap();
        if (TextUtils.isEmpty("") == true) goto L5;
        r107.put("captcha", "");
    L5:
        r107.put("code", StringUtils.encryptWithXor(r101));
        r107.put("mobile", StringUtils.encryptWithXor(r100));
        r107.put("profile_key", r102);
        r107.put("mix_mode", "1");
        r106.f(r107);
        new xb7.a(r103, r106.h(), r105, r110).m();
    }

    @Override // ta7.g
    public final void c(String r100, String r101, Map<String, String> r102, va7.e r103) {
        gc7.d.f480866a = 1;
        gc7.d.f480867b = null;
        Context r104 = this.f268979a;
        int r105 = rb7.g.f536956m;
        lb7.a.C6671a r106 = new lb7.a.C6671a();
        r106.f508360a = ta7.d.a("/passport/auth/one_login_only/");
        r106.g(rb7.g.p(r100, r101, null, Boolean.FALSE), r102);
        new rb7.g(r104, r106.h(), r103).m();
    }

    public final void n(String r100, String r101, Map r102, yz8.i r103) {
        gc7.d.f480866a = 2;
        gc7.d.f480867b = r100;
        Context r104 = this.f268979a;
        int r105 = xb7.h.f563144l;
        wb7.h r106 = new wb7.h(r100, r101);
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = ta7.d.a("/passport/mobile/sms_login_continue/");
        HashMap r108 = new HashMap();
        r108.put("mobile", StringUtils.encryptWithXor(r100));
        r108.put("sms_code_key", StringUtils.encryptWithXor(String.valueOf(r101)));
        r108.put("mix_mode", "1");
        r107.g(r108, r102);
        new xb7.h(r104, r107.h(), r106, r103).m();
    }

    public final void o(String r100, String r101, Map r102, com.larus.common.account.phone.a r103) {
        gc7.d.f480866a = 2;
        gc7.d.f480867b = r100;
        Context r104 = this.f268979a;
        int r105 = xb7.i.f563146l;
        wb7.i r106 = new wb7.i(r100, r101);
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = ta7.d.a("/passport/mobile/sms_login_only/");
        HashMap r108 = new HashMap();
        r108.put("mobile", StringUtils.encryptWithXor(r100));
        if (TextUtils.isEmpty(null) == true) goto L5;
        r108.put("captcha", null);
    L5:
        r108.put("code", StringUtils.encryptWithXor(String.valueOf(r101)));
        r108.put("mix_mode", "1");
        r107.g(r108, r102);
        new xb7.i(r104, r107.h(), r106, r103).m();
    }

    public final void r(String r100, String r101, String r102, va7.f r103) {
        Context r104 = this.f268979a;
        int r105 = rb7.i.f536962n;
        lb7.a.C6671a r106 = new lb7.a.C6671a();
        r106.f508360a = ta7.d.a("/passport/shark/safe_verify/");
        HashMap r107 = new HashMap();
        if (TextUtils.isEmpty(null) == true) goto L6;
        r107.put("not_login_ticket", null);
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        r107.put(PickerReporterConstants.KEY.TARGET, r100);
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        r107.put("scene", r101);
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r107.put("old_mobile", StringUtils.encryptWithXor(r102));
    L14:
        r107.put("mix_mode", "1");
        r106.g(r107, null);
        new rb7.i(r104, r106.h(), r103).m();
    }

    public final void s(String r100, int r110, Map<String, String> r111, yb7.j r112) {
        Context r101 = this.f268979a;
        int r102 = xb7.k.f563152l;
        wb7.k r103 = new wb7.k(r100, r110, r111);
        lb7.a.C6671a r104 = new lb7.a.C6671a();
        HashMap r105 = new HashMap();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r105.put("mobile", StringUtils.encryptWithXor(r100));
    L6:
        if (TextUtils.isEmpty("") == true) goto L9;
        r105.put("old_mobile", StringUtils.encryptWithXor(""));
    L9:
        if (TextUtils.isEmpty(null) == true) goto L11;
        r105.put("captcha", null);
    L11:
        r105.put("type", StringUtils.encryptWithXor(String.valueOf(r110)));
        r105.put("unbind_exist", StringUtils.encryptWithXor(String.valueOf(0)));
        r105.put("mix_mode", "1");
        int r106 = r103.f559027f;
        if (r106 != 1) goto L14;
        r105.put("check_register", "1");
    L17:
        if (TextUtils.isEmpty(null) == true) goto L19;
        r105.put("ticket", null);
    L19:
        r105.put("auto_read", String.valueOf(0));
        if (TextUtils.isEmpty(null) == true) goto L23;
        r105.put("shark_ticket", null);
    L23:
        if (TextUtils.isEmpty(null) == true) goto L26;
        r105.put(ITwitterService.ResponseConstants.AUTH_TOKEN, null);
    L26:
        if (TextUtils.isEmpty(null) == true) goto L28;
        r105.put("unusable_mobile_ticket", null);
    L28:
        r104.g(r105, r111);
        r104.f508360a = ta7.d.a("/passport/mobile/send_code/v1/");
        new xb7.k(r101, r104.h(), r103, r112).m();
        return;
    L14:
        if (r106 != 0) goto L17;
        r105.put("check_register", "0");
        goto L17
    }

    @Override // ta7.g
    public final void e(String r100, String r101, String r102, Map<String, String> r103, va7.e r104) {
        gc7.d.f480866a = 1;
        gc7.d.f480867b = null;
        Context r105 = this.f268979a;
        int r106 = rb7.g.f536956m;
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = ta7.d.a("/passport/auth/one_login/");
        r107.g(rb7.g.p(r100, r101, r102, Boolean.FALSE), r103);
        new rb7.g(r105, r107.h(), r104).m();
    }

    public final void i(String r100, String r101, String r102, Map r103, com.larus.account.base.impl.h r110) {
        Context r104 = this.f268979a;
        int r105 = xb7.c.f563134l;
        wb7.c r106 = new wb7.c(r100, r101, r102, r103);
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = ta7.d.a("/passport/mobile/change/v1/");
        HashMap r108 = new HashMap();
        r108.put("mobile", StringUtils.encryptWithXor(r100));
        if (TextUtils.isEmpty(null) == true) goto L5;
        r108.put("captcha", null);
    L5:
        r108.put("code", StringUtils.encryptWithXor(r101));
        r108.put("mix_mode", "1");
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r108.put("ticket", r102);
    L8:
        r107.g(r108, r103);
        new xb7.c(r104, r107.h(), r106, r110).m();
    }

    @Override // ta7.g
    public final void a(String r100, String r101, String r102, int r103, Map<String, String> r110, yb7.d r111) {
        Context r104 = this.f268979a;
        int r105 = xb7.e.f563138l;
        wb7.f r106 = new wb7.f(r100, r101, r102, r103);
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        if (TextUtils.isEmpty(r102) == false) goto L5;
        String r108 = ta7.d.a("/passport/auth/one_bind_mobile/");
    L6:
        r107.f508360a = r108;
        HashMap r109 = new HashMap();
        r109.put("token", StringUtils.encryptWithXor(r100));
        r109.put("from", StringUtils.encryptWithXor(r101));
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r109.put("password", StringUtils.encryptWithXor(r102));
    L9:
        r109.put("unbind_exist", StringUtils.encryptWithXor(String.valueOf(r103)));
        r109.put("mix_mode", "1");
        r107.g(r109, r110);
        new xb7.e(r104, r107.h(), r106, r111).m();
        return;
    L5:
        r108 = ta7.d.a("/passport/auth/one_bind_mobile/v2/");
        goto L6
    }

    @Override // ta7.g
    public final void d(String r100, String r101, String r102, String r103, Map r110, OnekeyForceBindAdapter.a r111) {
        Context r104 = this.f268979a;
        int r105 = xb7.f.f563140l;
        wb7.g r106 = new wb7.g(r100, r101, r102);
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = ta7.d.a("/passport/mobile/bind_login/");
        HashMap r108 = new HashMap();
        r108.put("token", StringUtils.encryptWithXor(r100));
        r108.put("from", StringUtils.encryptWithXor(r101));
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r108.put("profile_key", r102);
    L5:
        r108.put("bind_logic_type", String.valueOf(1));
        r108.put("mix_mode", "1");
        r108.put("provider_app_id", r103);
        r107.g(r108, r110);
        new xb7.f(r104, r107.h(), r106, r111).m();
    }

    @Override // ta7.g
    public final void f(String r100, String r101, String r102, Boolean r103, Map<String, String> r104, va7.e r105) {
        gc7.d.f480866a = 1;
        gc7.d.f480867b = null;
        Context r106 = this.f268979a;
        int r107 = rb7.g.f536956m;
        lb7.a.C6671a r108 = new lb7.a.C6671a();
        r108.f508360a = ta7.d.a("/passport/auth/one_login_with_mask_mobile/");
        r108.g(rb7.g.p(r100, r101, r102, r103), r104);
        new rb7.g(r106, r108.h(), r105).m();
    }

    @Override // ta7.g
    public final void g(String r100, String r101, String r102, String r103, Map<String, String> r104, sa7.h<ua7.h> r110) {
        gc7.d.f480866a = 1;
        gc7.d.f480867b = null;
        Context r105 = this.f268979a;
        int r106 = rb7.h.f536959m;
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = ta7.d.a("/passport/auth/validate_mobile_login/");
        HashMap r108 = new HashMap();
        r108.put("from", r103);
        r108.put("token", r102);
        r108.put("mobile", StringUtils.encryptWithXor(r101));
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r108.put("mask_mobile", StringUtils.encryptWithXor(r100));
    L5:
        r108.put("mix_mode", "1");
        r107.g(r108, r104);
        new rb7.h(r105, r107.h(), r110).m();
    }

    public final void m(String r100, String r101, Integer r102, String r103, Map<String, String> r110, yb7.f r111) {
        gc7.d.f480866a = 2;
        gc7.d.f480867b = r100;
        Context r104 = this.f268979a;
        int r105 = xb7.g.f563142l;
        wb7.j r106 = new wb7.j(r100, r101, r102, r103);
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = ta7.d.a("/passport/mobile/sms_login/");
        HashMap r108 = new HashMap();
        r108.put("mobile", StringUtils.encryptWithXor(r100));
        if (TextUtils.isEmpty(r103) == true) goto L5;
        r108.put("captcha", r103);
    L5:
        r108.put("code", StringUtils.encryptWithXor(String.valueOf(r101)));
        r108.put("mix_mode", "1");
        if (r102 == null) goto L8;
        r108.put("auth_opposite", String.valueOf(r102));
    L8:
        r107.g(r108, r110);
        r107.d();
        new xb7.g(r104, r107.h(), r106, r111).m();
    }
}
