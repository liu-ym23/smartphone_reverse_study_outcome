package com.xiaomi.push;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f463261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f463262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f463263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f463264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f463265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f463266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f463267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f463268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f463269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f463270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f463271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f463272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f463273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f463274n;

    public co() {
        this.f463261a = "disconnection_event";
        this.f463262b = "count";
        this.f463263c = "host";
        this.f463264d = WsConstants.KEY_NETWORK_STATE;
        this.f463265e = "reason";
        this.f463266f = "ping_interval";
        this.f463267g = "network_type";
        this.f463268h = "wifi_digest";
        this.f463269i = "duration";
        this.f463270j = "disconnect_time";
        this.f463271k = MonitorConstants.CONNECT_TIME;
        this.f463272l = "xmsf_vc";
        this.f463273m = "android_vc";
        this.f463274n = ST.UUID_DEVICE;
    }

    public void a(Context r100, List<cn> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.size() == 0) goto L12;
        cm.a("upload size = " + r101.size());
        String r102 = com.xiaomi.push.service.q.m9410a(r100);
        Iterator<cn> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        cn r104 = r103.next();
        HashMap r105 = new HashMap();
        r105.put("count", Integer.valueOf(r104.a()));
        r105.put("host", r104.m8912a());
        r105.put(WsConstants.KEY_NETWORK_STATE, Integer.valueOf(r104.b()));
        r105.put("reason", Integer.valueOf(r104.c()));
        r105.put("ping_interval", Long.valueOf(r104.m8911a()));
        r105.put("network_type", Integer.valueOf(r104.d()));
        r105.put("wifi_digest", r104.m8914b());
        r105.put("connected_network_type", Integer.valueOf(r104.e()));
        r105.put("duration", Long.valueOf(r104.m8913b()));
        r105.put("disconnect_time", Long.valueOf(r104.m8915c()));
        r105.put(MonitorConstants.CONNECT_TIME, Long.valueOf(r104.m8916d()));
        r105.put("xmsf_vc", Integer.valueOf(r104.f()));
        r105.put("android_vc", Integer.valueOf(r104.g()));
        r105.put(ST.UUID_DEVICE, r102);
        eg.a().a("disconnection_event", r105);
        goto L8
    L13:
        return;
    }
}
