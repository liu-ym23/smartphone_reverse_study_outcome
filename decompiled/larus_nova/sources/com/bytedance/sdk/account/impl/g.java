package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.dialog.Gravity;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements ta7.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f268994b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f268995a;

    public static g a() {
        Context r100 = com.ss.android.account.k.d().getApplicationContext();
        if (f268994b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f268994b != null) goto L9;
        f268994b = new g(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f268994b;
    }

    public g(Context r100) {
        wqa.f r101 = com.ss.android.account.k.f406318b;
        if (r101 != null) goto L5;
        this.f268995a = r100.getApplicationContext();
        return;
    L5:
        this.f268995a = r101.getApplicationContext();
    }

    public final void d(ua7.a r100) {
        c("user_logout", null, new com.ss.android.token.d("user_logout"), r100);
    }

    @Override // ta7.h
    public final void b(String r110, va7.c r111) {
        Context r100 = this.f268995a;
        int r101 = rb7.d.f536949l;
        ArrayList r102 = null;
        if (com.ss.android.account.k.f406320d != null) goto L5;
        wqa.i r103 = null;
    L12:
        HashMap r104 = new HashMap();
        r104.put("scene", r110);
        String r105 = ta7.d.a("/passport/account/info/v2/");
        if (r103 != null) goto L15;
    L14:
        ArrayList r106 = r102;
        TextUtils.isEmpty(MonitorConstants.CONNECT_TYPE_GET);
        new rb7.d(r100, new lb7.a(r105, MonitorConstants.CONNECT_TYPE_GET, r104, r106, null, null, false, 0), r111).m();
        return;
    L15:
        r102 = new ArrayList();
        r102.add(r103);
        goto L14
    L5:
        if ("wap_login".equalsIgnoreCase(r110) == false) goto L7;
    L9:
        boolean r107 = false;
    L10:
        r103 = com.ss.android.account.k.f406320d.getRequestTagHeader(r107);
        goto L12
    L7:
        if ("normal".equalsIgnoreCase(r110) == true) goto L9;
        r107 = true;
        goto L10
    }

    public final void c(String r110, Object r111, com.ss.android.token.d r112, ua7.a r113) {
        if (r112 != null) goto L4;
        r112 = new com.ss.android.token.d(r110);
    L4:
        e r100 = new e(this, r110, r113, r112);
        if (com.ss.android.token.p.b() == null) goto L8;
        com.ss.android.token.p.b().b(r112, r111, r100);
        return;
    L8:
        String r101 = "";
        if ("frontier".equals(r110) == false) goto L11;
    L16:
        i0 r114 = r112.f449723a;
        if (r114 != null) goto L19;
        String r102 = this.f268995a.getString(R.string.logged_out_title_new);
        String r115 = this.f268995a.getString(R.string.logged_out_content_new);
    L31:
        String r103 = r102;
        r101 = r115;
    L33:
        if (TextUtils.isEmpty(r103) == true) goto L41;
        Gravity r116 = Gravity.CENTER;
        hb7.a r104 = new hb7.a(this.f268995a.getString(R.string.dialog_ok_new), new f(r100, r111));
        if (TextUtils.isEmpty(r101) == true) goto L37;
        String r105 = r101;
    L39:
        if (com.bytedance.sdk.account.utils.b.f269536a.a(new hb7.b(r103, r105, r104, null, false)) == false) goto L41;
        return;
    L37:
        r105 = null;
    L41:
        r100.a(null, r111);
        return;
    L19:
        if (r114.f269008f == true) goto L21;
        String r117 = this.f268995a.getString(R.string.logged_out_title_new);
        if (TextUtils.isEmpty(r114.f269003a) == false) goto L28;
        r115 = this.f268995a.getString(R.string.logged_out_content_new);
    L29:
        r102 = r117;
        goto L31
    L28:
        r115 = r114.f269003a;
        goto L29
    L21:
        if (TextUtils.isEmpty(r114.f269003a) == false) goto L23;
        String r118 = this.f268995a.getString(R.string.logged_out_content_new);
    L24:
        r102 = r118;
        r115 = "";
        goto L31
    L23:
        r118 = r114.f269003a;
        goto L24
    L11:
        if ("sdk_expired_logout".equals(r110) == true) goto L16;
        if ("device_transfer".equals(r110) == true) goto L16;
        r103 = "";
        goto L33
    }
}
