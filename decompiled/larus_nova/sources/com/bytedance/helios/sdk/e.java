package com.bytedance.helios.sdk;

import com.bytedance.helios.sdk.anchor.CustomAnchorMonitor;
import com.bytedance.helios.sdk.detector.s;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, com.bytedance.helios.sdk.detector.b> f245557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f245558b = null;

    public e() {
    }

    static {
        f245558b = new e();
        f245557a = new HashMap();
        hz5.g r100 = hz5.g.f487690b;
        r100.b(zz5.c.f574095b, false);
        r100.b(a06.a.f1317b, false);
        r100.b(sz5.c.f543947a, true);
        r100.b(new sz5.a(new sz5.b()), true);
        b(s.f245549c);
        com.bytedance.helios.sdk.detector.d r101 = com.bytedance.helios.sdk.detector.d.f245520e;
        b(r101);
        com.bytedance.helios.sdk.detector.g r102 = com.bytedance.helios.sdk.detector.g.f245525e;
        b(r102);
        Map<Integer, Map<String, hz5.c>> r103 = CustomAnchorMonitor.f245484a;
        r102.f245532c = new nz5.d();
        if ((r101 instanceof com.bytedance.helios.sdk.detector.g) == false) goto L5;
        r101.f245532c = new nz5.d();
        return;
    L5:
        r101.f245532c = new nz5.e();
    }

    public static com.bytedance.helios.sdk.detector.b a(int r100) {
        com.bytedance.helios.sdk.detector.b r101 = f245557a.get(Integer.valueOf(r100));
        if (r101 == null) goto L6;
        return r101;
    L6:
        return com.bytedance.helios.sdk.detector.p.f245545b;
    }

    public static void b(com.bytedance.helios.sdk.detector.b r100) {
        int[] r101 = r100.e();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r104 = r101[r103];
        f245557a.put(Integer.valueOf(r104), r100);
        r103 = r103 + 1;
        goto L3
    }
}
