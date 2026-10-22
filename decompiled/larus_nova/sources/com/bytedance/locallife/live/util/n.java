package com.bytedance.locallife.live.util;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f260724a;

    static {
    }

    public static void a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (com.bytedance.locallife.live.experiment.d0.a() == true) goto L5;
        return;
    L5:
        if (f260724a != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r100, "enter_room") == false) goto L12;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r102.put("order", "1");
        if (r101 == null) goto L11;
        r102.putAll(r101);
    L11:
        LiveLifeSaaSUtil.t().d("LSLIVE", r102.toString());
        boolean r103 = true;
    L13:
        if (r103 == true) goto L23;
        m r104 = f260724a;
        if (r104 == null) goto L24;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r105.put("room_id", r104.f260722a);
        r105.put("order", String.valueOf(r104.f260723b.incrementAndGet()));
        if (r101 == null) goto L19;
        r105.putAll(r101);
    L19:
        LiveLifeSaaSUtil.t().d("LSLIVE", r105.toString());
        return;
    L24:
        return;
    L23:
        return;
    L12:
        r103 = false;
        goto L13
    }
}
