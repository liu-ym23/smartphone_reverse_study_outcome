package com.bytedance.lynx.webview.internal;

import android.os.Bundle;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f265323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Bundle f265324b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f265325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f265326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f265327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f265328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f265329g;

    static {
        f265324b = new Bundle();
    }

    public static void a() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_check_sdk_to_glue_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_construct_sdk_to_glue_wrapper_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_get_provider_instance_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void e() {
        if (f265323a == false) goto L12;
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_init_ttwebview_end", System.currentTimeMillis());     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        Bundle r101 = f265324b;
        monitor-enter(r101);
        r101.putLong("tick_render_init_ttwebview_end", System.currentTimeMillis());     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static void g() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_load_check_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void h() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_render_apply_setting_to_engine_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void i() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_render_init_shm_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void j() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_render_init_ttwebview_classloader_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void k() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_render_load_library_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void l() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_render_sdk_to_glue_wrapper_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void m() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L14
        Bundle r101 = f265324b;     // Catch: Throwable -> L14
        monitor-enter(r101);     // Catch: Throwable -> L14
        r101.putLong("tick_start_impl_end", System.currentTimeMillis());     // Catch: Throwable -> L11
        Iterator<String> r102 = r101.keySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();     // Catch: Throwable -> L11
        r100.put(r103, f265324b.get(r103));     // Catch: Throwable -> L11
        goto L6
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L11
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_HOOK, Long.valueOf(f265327e - f265326d));     // Catch: Throwable -> L14
        EventStatistics.f(EventType.INIT_TT_WEBVIEW_TIMING.getEventCode(), r100);     // Catch: Throwable -> L14
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        l17.k.b(new String[]{"TT_WEBVIEW", "onStartImplEnd with expception" + th.toString()});
    }

    public static void n() {
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_render_start_render_process_end", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void d() {
        f265328f = System.currentTimeMillis();
        Bundle r100 = f265324b;
        monitor-enter(r100);
        r100.putLong("tick_get_type_cross_process_start", System.currentTimeMillis());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void f(boolean r100) {
        f265323a = r100;
        if (r100 == false) goto L12;
        Bundle r101 = f265324b;
        monitor-enter(r101);
        r101.putLong("tick_init_ttwebview_start", System.currentTimeMillis());     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        Bundle r102 = f265324b;
        monitor-enter(r102);
        r102.putLong("tick_render_init_ttwebview_start", System.currentTimeMillis());     // Catch: Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
