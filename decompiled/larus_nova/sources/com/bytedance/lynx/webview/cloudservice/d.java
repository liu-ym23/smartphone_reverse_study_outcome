package com.bytedance.lynx.webview.cloudservice;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f265092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f265093b = null;

    public d() {
    }

    static {
        f265093b = new AtomicBoolean(true);
    }

    public static void onEvent(JSONObject r100) {
        monitor-enter(d.class);
        a r101 = f265092a;     // Catch: Throwable -> L11
        if (r101 != null) goto L8;
        monitor-exit(d.class);     // Catch: Throwable -> L11
        return;
    L8:
        r101.onEvent(r100);     // Catch: Throwable -> L11
        monitor-exit(d.class);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
