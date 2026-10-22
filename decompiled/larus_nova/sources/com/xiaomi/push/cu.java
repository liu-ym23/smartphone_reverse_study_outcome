package com.xiaomi.push;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f463293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f463294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f463295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f463296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f463297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f463298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f463299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f463300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f463301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f463302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f463303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f463304l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f463305m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f463306n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f463307o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f463308p;

    public cu() {
        this.f463293a = "power_consumption_stats";
        this.f463294b = "off_up_ct";
        this.f463295c = "off_dn_ct";
        this.f463296d = "off_ping_ct";
        this.f463297e = "off_pong_ct";
        this.f463298f = "off_dur";
        this.f463299g = "on_up_ct";
        this.f463300h = "on_dn_ct";
        this.f463301i = "on_ping_ct";
        this.f463302j = "on_pong_ct";
        this.f463303k = "on_dur";
        this.f463304l = ILoadStallMonitor.START_TIME;
        this.f463305m = "end_time";
        this.f463306n = "xmsf_vc";
        this.f463307o = "android_vc";
        this.f463308p = ST.UUID_DEVICE;
    }

    public void a(Context r100, ct r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        HashMap r102 = new HashMap();
        r102.put("off_up_ct", Integer.valueOf(r101.a()));
        r102.put("off_dn_ct", Integer.valueOf(r101.b()));
        r102.put("off_ping_ct", Integer.valueOf(r101.c()));
        r102.put("off_pong_ct", Integer.valueOf(r101.d()));
        r102.put("off_dur", Long.valueOf(r101.m8922a()));
        r102.put("on_up_ct", Integer.valueOf(r101.e()));
        r102.put("on_dn_ct", Integer.valueOf(r101.f()));
        r102.put("on_ping_ct", Integer.valueOf(r101.g()));
        r102.put("on_pong_ct", Integer.valueOf(r101.h()));
        r102.put("on_dur", Long.valueOf(r101.m8923b()));
        r102.put(ILoadStallMonitor.START_TIME, Long.valueOf(r101.m8924c()));
        r102.put("end_time", Long.valueOf(r101.m8925d()));
        r102.put("xmsf_vc", Integer.valueOf(r101.i()));
        r102.put("android_vc", Integer.valueOf(r101.j()));
        r102.put(ST.UUID_DEVICE, com.xiaomi.push.service.q.m9410a(r100));
        eg.a().a("power_consumption_stats", r102);
    }
}
