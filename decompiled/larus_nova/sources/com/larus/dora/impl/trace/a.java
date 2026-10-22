package com.larus.dora.impl.trace;

import com.google.gson.Gson;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.utils.t0;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import g49.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f338084a = null;

    static {
        f338084a = LazyKt.lazy(new p69.a());
    }

    public static void a(final DarEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "doraEvent");
        final b r100 = (b) f338084a.getValue();
        if (r100 == null) goto L31;
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(r110, "doraEvent");     // Catch: Throwable -> L28
        d.d("【DarLite】", r110.getEvent());     // Catch: Throwable -> L28
        final String r101 = r100.f338090c;     // Catch: Exception -> L13 Throwable -> L28
        if (r101 == null) goto L26;
        p69.b r102 = new p69.b(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r110.ordinal()), Integer.valueOf(r110.getType()), r110.getEvent(), r110.getMessage(), r110.getExtra());     // Catch: Exception -> L13 Throwable -> L28
        JSONArray r103 = r100.f338089b.get(r101);     // Catch: Exception -> L13 Throwable -> L28
        if (r103 == null) goto L16;
        if (r103.length() >= 100) goto L16;
        r103.put(((Gson) r100.f338088a.getValue()).toJson(r102));     // Catch: Exception -> L13 Throwable -> L28
    L16:
        if (r110 != DarEvent.OtaUpdatePreCheck) goto L18;
    L23:
        t0.c(new p69.d(r100, r110, r101));     // Catch: Exception -> L13 Throwable -> L28
    L18:
        if (r110 == DarEvent.OtaUpdateCheck) goto L23;
        if (r110 == DarEvent.OtaUpdateEnd) goto L23;
        if (r110 == DarEvent.DoraLinkStateChanged) goto L23;
    L26:
        monitor-exit(r100);
        return;
    L13:
        e = move-exception;
        d.b("【DarLite】", e.getMessage());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(FlowDoraWifiScene.OTA, "scene");
        b r101 = (b) f338084a.getValue();
        if (r101 == null) goto L11;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(FlowDoraWifiScene.OTA, "scene");     // Catch: Throwable -> L8
        r101.f338090c = r100;     // Catch: Throwable -> L8
        r101.f338091d = FlowDoraWifiScene.OTA;     // Catch: Throwable -> L8
        monitor-exit(r101);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
