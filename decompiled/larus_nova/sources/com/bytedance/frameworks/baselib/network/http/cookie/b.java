package com.bytedance.frameworks.baselib.network.http.cookie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f244692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f244693b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CountDownLatch f244694c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f244695d = null;

    public class a implements SSCookieHandler.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC3502b f244696a;

        @Override // com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler.a
        public final ArrayList<String> getCookieFlushPathList() {
            return this.f244696a.getCookieFlushPathList();
        }

        public a(InterfaceC3502b r100) {
            this.f244696a = r100;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler.a
        public final void onEvent(String r100, JSONObject r101) {
            if (ix5.b.f496367f == false) goto L6;
            this.f244696a.OnReportEvent("TTNET-COOKIE", r100, r101);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cookie.b$b, reason: collision with other inner class name */
    public interface InterfaceC3502b {
        void OnReportEvent(String r100, String r101, JSONObject r102);

        ArrayList<String> getCookieFlushPathList();

        void onInitClientKeyAndSessionInfo(boolean r100);

        void onSetCookieInitCompleted();
    }

    public b() {
    }

    static {
        f244692a = new Object();
        f244693b = new AtomicBoolean(false);
        f244694c = new CountDownLatch(1);
        f244695d = new AtomicBoolean(false);
    }

    public static CookieManager b() {
        Object r100 = f244692a;
        monitor-enter(r100);
        CountDownLatch r101 = f244694c;     // Catch: Throwable -> L6 Exception -> L20
        r101.await(5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L6 Exception -> L20
        r101.countDown();     // Catch: Throwable -> L6 Exception -> L20
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L6
        CookieManager r102 = null;
        if (f244693b.get() == false) goto L13;
        return null;
    L13:
        if (f244695d.get() == false) goto L24;
    L17:
        return r102;
    L24:
        r102 = CookieManager.getInstance();     // Catch: Throwable -> L21
        if (r102.acceptCookie() == true) goto L17;
        r102.setAcceptCookie(true);     // Catch: Throwable -> L21
        goto L17
    }

    public static void c(SSCookieHandler r100) {
        if (f244693b.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L13;
        Logger.d("CookieInitializer", "CookieInitV2 set cookieHandler:" + r100);
    L13:
        CookieHandler.setDefault(r100);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        f244693b.set(false);
        Logger.e("CookieInitializer", "CookieInitV2 set cookieHandler error", e);
    }

    public static void a(String r100, InterfaceC3502b r101) {
        if (ix5.b.f496367f == true) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        r102.put("init", "failed");     // Catch: JSONException -> L8
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r100);     // Catch: JSONException -> L8
    L10:
        r101.OnReportEvent("TTNET-COOKIE", "init", r102);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static void d(Context r100, InterfaceC3502b r101) {
    L21:
        th = move-exception;
        a(th.getMessage(), r101);
        th.printStackTrace();
        return;
    L3:
        if ((CookieHandler.getDefault() instanceof SSCookieHandler) == false) goto L7;
        f244694c.countDown();     // Catch: Throwable -> L21
        r101.onSetCookieInitCompleted();     // Catch: Throwable -> L21
        return;
    L7:
        if (TTNetInitMetrics.g().f244615i != 0) goto L9;
        TTNetInitMetrics r102 = TTNetInitMetrics.g();     // Catch: Throwable -> L21
        r102.f244615i = System.nanoTime();     // Catch: Throwable -> L21
    L9:
        boolean r103 = f244695d.get();     // Catch: Throwable -> L21
        if (r103 == false) goto L24;
    L15:
        CookieManager r104 = null;
    L16:
        if (r103 == false) goto L18;
        SSCookieHandler.CookieInitType r105 = SSCookieHandler.CookieInitType.INIT_V2_DISABLE_COOKIE_MGR;     // Catch: Throwable -> L21
    L19:
        CookieHandler.setDefault(new SSCookieHandler(r100, r104, r105, new a(r101)));     // Catch: Throwable -> L21
        f244694c.countDown();     // Catch: Throwable -> L21
        r101.onSetCookieInitCompleted();     // Catch: Throwable -> L21
        TTNetInitMetrics r106 = TTNetInitMetrics.g();     // Catch: Throwable -> L21
        r106.f244616j = System.nanoTime();     // Catch: Throwable -> L21
        return;
    L18:
        r105 = SSCookieHandler.CookieInitType.INIT_V1;     // Catch: Throwable -> L21
        goto L19
    L24:
        r104 = CookieManager.getInstance();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        a(th.getMessage(), r101);     // Catch: Throwable -> L21
        goto L15
    }

    public static void e(final Context r100, final boolean r101, final InterfaceC3502b r102) {
    L14:
        th = move-exception;
        th.printStackTrace();
        if (com.bytedance.frameworks.baselib.network.http.util.i.d(r100) == true) goto L18;
    L20:
        r102.onInitClientKeyAndSessionInfo(r101);
        return;
    L18:
        if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L20;
        new Handler(Looper.getMainLooper()).post(new com.bytedance.frameworks.baselib.network.http.cookie.a(r100, r101, r102));
        a(th.getMessage(), r102);
        goto L20
    L4:
        if (TTNetInitMetrics.g().f244615i != 0) goto L7;
        TTNetInitMetrics.g().f244615i = System.nanoTime();     // Catch: Throwable -> L14
    L7:
        if (f244695d.get() == true) goto L9;
        CookieSyncManager.createInstance(r100);     // Catch: Throwable -> L14
        CookieManager r103 = CookieManager.getInstance();     // Catch: Throwable -> L14
        r103.setAcceptCookie(true);     // Catch: Throwable -> L14
    L10:
        d(r100, r102);     // Catch: Throwable -> L14
        if (Logger.debug() == false) goto L20;
        Logger.d("Process", " CookieManager = " + r103 + " pid = " + Process.myPid());     // Catch: Throwable -> L14
        goto L20
    L9:
        r103 = null;
        goto L10
    }
}
