package com.bytedance.lynx.webview.internal;

import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes21.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f265355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static q f265356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f265357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<String> f265358d = null;

    static {
        f265358d = new ConcurrentLinkedQueue();
    }

    public static void a(String r100) {
        if (f265357c == false) goto L5;
        f265356b.b(f265355a, r100);
        return;
    L5:
        f265358d.add(r100);
    }

    public static void b(String r100) {
        if (f265357c == false) goto L5;
        f265356b.a(f265355a, r100);
        return;
    L5:
        f265358d.add(r100);
    }

    public static void d(String r100) {
        if (f265357c == false) goto L5;
        f265356b.c(f265355a, r100);
        return;
    L5:
        f265358d.add(r100);
    }

    public static void c(String r100, Throwable r101) {
        b(r100 + ' ' + Log.getStackTraceString(r101));
    }
}
