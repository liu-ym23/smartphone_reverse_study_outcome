package com.bytedance.live.livelink.kmp.impl.core.link;

import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import ej6.e;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f255415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f255416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f255417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f255418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f255419e;

    public static final class a {
    }

    static {
    }

    public c() {
        long r100 = 0;
        this.f255415a = r100;
        this.f255416b = r100;
        this.f255417c = r100;
        this.f255418d = r100;
        this.f255419e = r100;
    }

    public final void a(FailCategory r110, String r111) {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("link_result", String.valueOf(1));
        if (r110 == null) goto L6;
        String r101 = r110.getValue();
        if (r101 == null) goto L6;
    L7:
        r100.put("link_failed_category", r101);
        if (r111 != null) goto L10;
        String r102 = "";
    L11:
        r100.put("link_failed_reason", r102);
        int r103 = e.f472877a;
        TraceEvent r104 = TraceEvent.LINK_MANAGER;
        StringBuilder r105 = new StringBuilder("link_failed_category=");
        if (r110 == null) goto L15;
        String r112 = r110.getValue();
        if (r112 == null) goto L15;
    L16:
        r105.append(r112);
        r105.append(" link_failed_reason=");
        if (r111 != null) goto L19;
        r111 = "";
    L19:
        r105.append(r111);
        e.a(r104, "start_link_failed", 0, r105.toString(), null, 20);
        ej6.d.a(r100);
        long r113 = 0;
        this.f255415a = r113;
        this.f255416b = r113;
        this.f255417c = r113;
        this.f255418d = r113;
        this.f255419e = r113;
        return;
    L15:
        r112 = "";
        goto L16
    L10:
        r102 = r111;
    L6:
        r101 = "";
        goto L7
    }
}
