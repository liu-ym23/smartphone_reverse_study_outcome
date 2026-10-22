package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l1 f277477b;

    public z0(String r100) {
        this.f277476a = r100;
        this.f277477b = new l1(r100);
        s.c().a(this.f277476a, this.f277477b);
    }

    private s0 b(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return this.f277477b.a();
    L14:
        return this.f277477b.d();
    L16:
        return this.f277477b.b();
    L18:
        return this.f277477b.c();
    }

    private boolean c(int r100) {
        if (r100 == 2) goto L5;
        s0 r101 = b(r100);
        if (r101 != null) goto L13;
    L16:
        String r102 = "verifyURL(): URL check failed. type: " + r100;
    L7:
        v.e("hmsSdk", r102);
        return false;
    L13:
        if (TextUtils.isEmpty(r101.h()) == true) goto L16;
        return true;
    L5:
        if ("_default_config_tag".equals(this.f277476a) == true) goto L9;
        r102 = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        goto L7
    L9:
        return true;
    }

    public void a(int r100) {
        v.d("hmsSdk", "onReport. TAG: " + this.f277476a + ", TYPE: " + r100);
        g0.a().a(this.f277476a, r100);
    }

    public void a(int r100, String r101, LinkedHashMap<String, String> r102) {
        v.d("hmsSdk", "onEvent. TAG: " + this.f277476a + ", TYPE: " + r100 + ", eventId : " + r101);
        if (e1.a(r101) == false) goto L5;
    L12:
        v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f277476a + ", TYPE: " + r100);
        return;
    L5:
        if (c(r100) == false) goto L12;
        if (e1.a(r102) == true) goto L10;
        v.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f277476a + ", TYPE: " + r100);
        r102 = null;
    L10:
        g0.a().a(this.f277476a, r100, r101, r102);
    }

    public void a(Context r100, String r101, String r102) {
        v.d("hmsSdk", "onEvent(context). TAG: " + this.f277476a + ", eventId : " + r101);
        if (r100 != null) goto L7;
        v.e("hmsSdk", "context is null in onevent ");
        return;
    L7:
        if (e1.a(r101) == false) goto L9;
    L16:
        v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f277476a);
        return;
    L9:
        if (c(0) == false) goto L16;
        if (e1.a("value", r102, 65536) == true) goto L14;
        v.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f277476a);
        r102 = "";
    L14:
        g0.a().a(this.f277476a, r100, r101, r102);
    }

    public void a(s0 r100) {
        v.a("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f277476a);
        if (r100 != null) goto L6;
        v.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
        this.f277477b.a(null);
        return;
    L6:
        this.f277477b.a(r100);
    }

    public void b(int r100, String r101, LinkedHashMap<String, String> r102) {
        v.d("hmsSdk", "onStreamEvent. TAG: " + this.f277476a + ", TYPE: " + r100 + ", eventId : " + r101);
        if (e1.a(r101) == false) goto L5;
    L12:
        v.e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f277476a + ", TYPE: " + r100);
        return;
    L5:
        if (c(r100) == false) goto L12;
        if (e1.a(r102) == true) goto L10;
        v.e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f277476a + ", TYPE: " + r100);
        r102 = null;
    L10:
        g0.a().b(this.f277476a, r100, r101, r102);
    }

    public void b(s0 r100) {
        v.a("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f277476a);
        if (r100 != null) goto L6;
        this.f277477b.b(null);
        v.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        return;
    L6:
        this.f277477b.b(r100);
    }
}
