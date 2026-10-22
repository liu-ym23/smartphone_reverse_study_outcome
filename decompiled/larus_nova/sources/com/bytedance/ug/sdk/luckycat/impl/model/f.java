package com.bytedance.ug.sdk.luckycat.impl.model;

import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.utils.LuckyCatALogHelper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<ti7.c> f271396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f271397b;

    static {
        f271396a = new CopyOnWriteArrayList();
        f271397b = false;
    }

    public static void a() {
        if (f271397b == true) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<ti7.c> r100 = f271396a;
        monitor-enter(r100);
        f271397b = false;     // Catch: Throwable -> L22
        if (r100.size() > 0) goto L12;
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L12:
        Iterator<ti7.c> r101 = r100.iterator();     // Catch: Throwable -> L22
        if (r101 != null) goto L17;
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L17:
        if (r101.hasNext() == false) goto L19;
        c(r101.next());     // Catch: Throwable -> L22
        goto L17
    L19:
        f271396a.clear();     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public static void c(ti7.c r100) {
        if (r100 != null) goto L37;
        return;
    L37:
        m r101 = m.a.f271349a;     // Catch: Throwable -> L18
        if (r101.f271344l == false) goto L35;
        JSONObject r102 = r100.f546227f;     // Catch: Throwable -> L18
        JSONObject r103 = r100.f546223b;     // Catch: Throwable -> L18
        JSONObject r104 = r100.f546224c;     // Catch: Throwable -> L18
        JSONObject r105 = r100.f546226e;     // Catch: Throwable -> L18
        if (r103 == null) goto L10;
        r103.toString();     // Catch: Throwable -> L18
    L10:
        if (r104 == null) goto L12;
        r104.toString();     // Catch: Throwable -> L18
    L12:
        if (r102 == null) goto L14;
        r102.toString();     // Catch: Throwable -> L18
    L14:
        if (r105 == null) goto L16;
        r105.toString();     // Catch: Throwable -> L18
    L16:
        r101.i();     // Catch: Throwable -> L18
    L35:
        ApmAgent.monitorStatusAndEvent(r100.f546222a, r100.f546225d, com.bytedance.ug.sdk.luckycat.utils.e.a(r100.f546223b), com.bytedance.ug.sdk.luckycat.utils.e.a(r100.f546224c), com.bytedance.ug.sdk.luckycat.utils.e.a(r100.f546226e));     // Catch: Exception -> L22
    L24:
        String r106 = r100.f546222a;
        JSONObject r107 = com.bytedance.ug.sdk.luckycat.utils.e.a(r100.f546223b);
        JSONObject r108 = com.bytedance.ug.sdk.luckycat.utils.e.a(r100.f546224c);
        JSONObject r109 = com.bytedance.ug.sdk.luckycat.utils.e.a(r100.f546226e);
        if (h.f271399b == true) goto L27;
        return;
    L27:
        if (h.f271398a == null) goto L40;
        LuckyCatALogHelper.f271505e.getClass();
        LuckyCatALogHelper.a(2, "SlardarSDKMonitor", "[Monitor] " + r106 + ", " + r107 + ", " + r108 + ", " + r109);
        if (TextUtils.isEmpty(r106) == true) goto L41;
        SDKMonitor r110 = h.f271398a;
        if (r110 != null) goto L33;
        Intrinsics.throwNpe();
    L33:
        r110.monitorEvent(r106, r107, r108, r109);
        return;
    L41:
        return;
    L40:
        return;
    L22:
        e = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("luckycat_monitor", "apm agent monitor error, e=" + e.getLocalizedMessage());
    L18:
        th = move-exception;
        th.getMessage();
        goto L35
    }

    public static void b(String r100, int r101, JSONObject r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        ti7.c r106 = new ti7.c();
        r106.f546222a = r100;
        r106.f546225d = r101;
        r106.f546223b = r103;
        r106.f546227f = r102;
        r106.f546226e = r105;
        r106.f546224c = r104;
        if (TextUtils.isEmpty(m.a.f271349a.i()) == false) goto L5;
        f271396a.add(r106);
        f271397b = true;
        return;
    L5:
        c(r106);
        a();
    }
}
