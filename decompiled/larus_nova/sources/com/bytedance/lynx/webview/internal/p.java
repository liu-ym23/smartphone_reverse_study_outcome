package com.bytedance.lynx.webview.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes21.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f265346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static q f265347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f265348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Map<Integer, Vector<String>> f265349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f265350e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f265351f = null;

    public static class a implements q {
        @Override // com.bytedance.lynx.webview.internal.q
        public final void a(String r100, String r101) {
        }

        @Override // com.bytedance.lynx.webview.internal.q
        public final void b(String r100, String r101) {
        }

        @Override // com.bytedance.lynx.webview.internal.q
        public final void c(String r100, String r101) {
        }

        public a() {
        }
    }

    public p() {
    }

    static {
        f265346a = new Object();
        f265347b = null;
        f265348c = null;
        f265349d = new ConcurrentHashMap();
        f265350e = new AtomicBoolean(false);
        f265351f = new AtomicBoolean(false);
    }

    public static boolean b() {
        if (f265350e.get() == true) goto L6;
        return false;
    L6:
        Object r100 = f265346a;
        monitor-enter(r100);
    L23:
        th = move-exception;
        throw th;
    L9:
        if (((ConcurrentHashMap) f265349d).size() > 0) goto L11;
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L23
        return true;
    L11:
        if (f265348c == null) goto L13;
    L14:
        Iterator r101 = ((ConcurrentHashMap) f265349d).entrySet().iterator();     // Catch: Throwable -> L23
        if (r101.hasNext() == false) goto L20;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Throwable -> L23
        Iterator r103 = ((Vector) r102.getValue()).iterator();     // Catch: Throwable -> L23
        if (r103.hasNext() == false) goto L19;
        c(((Integer) r102.getKey()).intValue(), (String) r103.next());     // Catch: Throwable -> L23
        r103.remove();     // Catch: Throwable -> L23
        goto L20
    L19:
        r101.remove();     // Catch: Throwable -> L23
        goto L20
    L13:
        if (f265347b == null) goto L20;
        goto L14
    }

    public static void d() {
        monitor-enter(p.class);
        AtomicBoolean r100 = f265350e;     // Catch: Throwable -> L22
        if (r100.get() == false) goto L9;
        monitor-exit(p.class);     // Catch: Throwable -> L22
        return;
    L9:
        if (Setting.c().b("sdk_enable_normal_write", false) == false) goto L11;
    L12:
        f265348c = new a();     // Catch: Throwable -> L22
    L14:
        if (Setting.c().b("sdk_enable_alog_write", true) == true) goto L17;
        f265347b = null;     // Catch: Throwable -> L22
    L17:
        if (r100.compareAndSet(false, true) == false) goto L20;
        monitor-exit(p.class);     // Catch: Throwable -> L22
        return;
    L20:
        monitor-exit(p.class);     // Catch: Throwable -> L22
        return;
    L11:
        if (l17.d.f506995a == false) goto L14;
    L22:
        th = move-exception;
        throw th;
    }

    public static void a(int r100, String r101) {
        Object r102 = f265346a;
        monitor-enter(r102);
        AtomicBoolean r103 = f265351f;     // Catch: Throwable -> L18
        if (r103.get() == false) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L8:
        Map<Integer, Vector<String>> r104 = f265349d;     // Catch: Throwable -> L18
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L18
        Vector r106 = (Vector) r105.get(Integer.valueOf(r100));     // Catch: Throwable -> L18
        if (r106 != null) goto L11;
        r106 = new Vector();     // Catch: Throwable -> L18
    L11:
        r106.add(r101);     // Catch: Throwable -> L18
        Map<Integer, Vector<String>> r107 = f265349d;     // Catch: Throwable -> L18
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;     // Catch: Throwable -> L18
        r108.put(Integer.valueOf(r100), r106);     // Catch: Throwable -> L18
        if (r106.size() >= 200) goto L15;
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L15:
        r103.compareAndSet(false, true);     // Catch: Throwable -> L18
        ((ConcurrentHashMap) f265349d).clear();     // Catch: Throwable -> L18
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static void c(int r100, String r101) {
        if (r100 != 1) goto L5;
        q r102 = f265347b;
        if (r102 == null) goto L30;
        r102.a("LYNX_TT_WEBVIEW_BACKEND", r101);
        return;
    L30:
        return;
    L5:
        if (r100 != 2) goto L7;
        q r103 = f265347b;
        if (r103 == null) goto L28;
        r103.b("LYNX_TT_WEBVIEW_BACKEND", r101);
        return;
    L28:
        return;
    L7:
        if (r100 != 3) goto L9;
        q r104 = f265347b;
        if (r104 == null) goto L26;
        r104.c("LYNX_TT_WEBVIEW_BACKEND", r101);
        return;
    L26:
        return;
    L9:
        if (r100 != 4) goto L31;
        q r105 = f265347b;
        if (r105 == null) goto L24;
        r105.a("LYNX_TT_WEBVIEW_BACKEND", r101);
        return;
    L24:
        return;
    }
}
