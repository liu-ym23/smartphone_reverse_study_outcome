package com.bytedance.sdk.account.impl;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements jb7.a.InterfaceC6411a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f268949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ua7.b f268950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f268951c;

    public b0(c0 r100, boolean r101, ua7.b r102) {
        this.f268951c = r100;
        this.f268949a = r101;
        this.f268950b = r102;
    }

    public final void a(boolean r110, boolean r111, Map<String, String> r112) {
        if (r110 == false) goto L6;
        if (r111 == false) goto L6;
        int r113 = 2;
    L8:
        if (this.f268949a == true) goto L10;
        c0 r114 = this.f268951c;
        com.bytedance.sdk.account.monitor.c.f(r114.f268953b.f508352a, this.f268950b, r114.f268959h.f268977o, r113);
    L10:
        c0 r115 = this.f268951c;
        b r100 = r115.f268957f;
        boolean r101 = r100.f268940a;
        if (r101 == false) goto L14;
        r100.f268947h = true;
    L14:
        if (r113 != 2) goto L39;
        if (r101 == false) goto L18;
        r100.f268948i = true;
    L18:
        if (r112 != null) goto L20;
    L37:
        c0 r116 = this.f268951c;
        r116.f268954c = new lb7.b(r116.f268953b);
        r116.m();
        return;
    L20:
        if (r112.isEmpty() == true) goto L37;
        c0 r117 = this.f268951c;
        lb7.a r118 = r117.f268953b;
        Map<String, String> r102 = r118.f508354c;
        if (r102 == null) goto L24;
        r102.putAll(r112);
        goto L37
    L24:
        String r103 = r118.f508352a;
        String r104 = r118.f508353b;
        List<wqa.i> r105 = r118.f508355d;
        String r106 = r118.f508356e;
        String r107 = r118.f508357f;
        boolean r108 = r118.f508358g;
        int r109 = r118.f508359h;
        if (r102 != null) goto L27;
        Map<String, String> r119 = r112;
    L33:
        if (TextUtils.isEmpty(r104) == false) goto L35;
        String r120 = MonitorConstants.CONNECT_TYPE_GET;
    L36:
        r117.f268953b = new lb7.a(r103, r120, r119, r105, r106, r107, r108, r109);
        goto L37
    L35:
        r120 = r104;
        goto L36
    L27:
        Iterator<Map.Entry<String, String>> r121 = r112.entrySet().iterator();
    L29:
        if (r121.hasNext() == false) goto L31;
        Map.Entry<String, String> r122 = r121.next();
        r102.put(r122.getKey(), r122.getValue());
        goto L29
    L31:
        r119 = r102;
        goto L33
    L39:
        if (r113 != 3) goto L46;
        if (r115.f268954c != null) goto L44;
        r115.f268954c = new lb7.b(r115.f268953b);
    L44:
        throw null;
    L46:
        if (this.f268949a == false) goto L48;
    L50:
        ua7.b r123 = this.f268950b;
        r123.f549253g = -1008;
        r123.f549255i = "";
        this.f268951c.g(r123);
        return;
    L48:
        if (r115.o(this.f268950b, true) == false) goto L50;
        return;
    L6:
        r113 = 1;
        goto L8
    }
}
