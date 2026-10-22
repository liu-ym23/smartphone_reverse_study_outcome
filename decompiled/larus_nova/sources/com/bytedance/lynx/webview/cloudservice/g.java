package com.bytedance.lynx.webview.cloudservice;

import com.bytedance.lynx.webview.internal.Setting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements com.bytedance.lynx.webview.internal.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f265096a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f265097a = null;

        static {
            f265097a = new g();
        }
    }

    @Override // com.bytedance.lynx.webview.internal.g.b
    public final void a(JSONObject r100) {
    }

    public static void c() {
        g r100 = a.f265097a;
        if (f265096a == true) goto L19;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f265096a == false) goto L10;
        monitor-exit(r100);     // Catch: Throwable -> L13
    L16:
        return;
    L10:
        f265096a = true;     // Catch: Throwable -> L13
        n07.b.c(new e());     // Catch: Throwable -> L13
        Setting.c();     // Catch: Throwable -> L13
        com.bytedance.lynx.webview.internal.g.e().b(r100);     // Catch: Throwable -> L13
        n07.b.d(new f());     // Catch: Throwable -> L13
        Setting r101 = Setting.c();     // Catch: Throwable -> L13
        n07.e r102 = n07.b.f516587d;     // Catch: Throwable -> L13
        r102.f516599a = r101.b("scc_cs_sys_enable", false);     // Catch: Throwable -> L13
        r102.f516600b = r101.b("scc_cs_sys_enable_prefetch", false);     // Catch: Throwable -> L13
        r102.f516601c = r101.d("scc_cs_sys_max_wait_time", 3000);     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        goto L16
    }

    public g() {
    }

    @Override // com.bytedance.lynx.webview.internal.g.b
    public final void b(JSONObject r100, boolean r101) {
        if (r101 == false) goto L7;
        boolean r102 = Setting.c().b("scc_cs_sys_enable", false);
        n07.e r103 = n07.b.f516587d;
        if (r103.f516599a == r102) goto L8;
        r103.f516599a = r102;
        return;
    L8:
        return;
    }
}
