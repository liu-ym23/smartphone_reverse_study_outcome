package com.bytedance.lynx.webview.internal;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;

/* JADX INFO: loaded from: classes21.dex */
public final class b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b0 f265269b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f265270a;

    public static b0 a() {
        if (f265269b != null) goto L15;
        monitor-enter(b0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f265269b != null) goto L9;
        f265269b = new b0(TTWebContext.h().getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(b0.class);     // Catch: Throwable -> L11
    L15:
        return f265269b;
    }

    public b0(Context r100) {
        this.f265270a = null;
        KevaBuilder.getInstance().setContext(r100);
        this.f265270a = Keva.getRepo("WebViewBytedanceKeva", 1);
    }
}
