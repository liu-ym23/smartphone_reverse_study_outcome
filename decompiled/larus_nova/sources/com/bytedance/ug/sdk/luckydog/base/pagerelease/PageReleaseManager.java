package com.bytedance.ug.sdk.luckydog.base.pagerelease;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class PageReleaseManager extends uo7.c implements tl7.a, zl7.e, ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f271780b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, c> f271781c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f271782d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, am7.a> f271783e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f271784f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, ScheduledFuture<?>> f271785g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ScheduledFuture<?> f271786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicBoolean f271787i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final PageReleaseManager f271788j = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageReleaseManager f271789a;

        public a(PageReleaseManager r100) {
            this.f271789a = r100;
        }

        public final void a() {
            this.f271789a.getClass();
            com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "checkAllPageMemory()");
            Map<String, c> r100 = PageReleaseManager.f271781c;
            if (r100.isEmpty() == true) goto L14;
            Iterator r101 = ((LinkedHashMap) r100).entrySet().iterator();
        L7:
            if (r101.hasNext() == false) goto L21;
            c r102 = (c) ((Map.Entry) r101.next()).getValue();
            HashMap<String, f> r103 = PageReleaseManager.f271780b.f271816e;
            r102.getClass();
            f r104 = r103.get(null);
            if (r104 == null) goto L7;
            if (PageReleaseManager.q(new b(r104.f271804a, r104.f271805b, r104.f271806c, r104.f271807d, r104.f271808e, r104.f271809f)).f271790a == false) goto L7;
            throw null;
        L21:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f271779a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PageReleaseManager.class), "scheduledExecutorService", "getScheduledExecutorService()Ljava/util/concurrent/ScheduledExecutorService;"))};
        f271788j = new PageReleaseManager();
        f271780b = new g();
        f271781c = new LinkedHashMap();
        f271782d = new ConcurrentHashMap();
        f271783e = new ConcurrentHashMap();
        f271784f = LazyKt.lazy(PageReleaseManager$scheduledExecutorService$2.INSTANCE);
        f271785g = new LinkedHashMap();
        f271787i = new AtomicBoolean(false);
    }

    @Override // zl7.e
    public final void J(String r100, Bundle r101) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public static void l() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "destroyGlobalMemoryCheckTask()");
        if (f271780b.a() == true) goto L13;
        return;
    L13:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        ScheduledFuture<?> r101 = f271786h;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        r101.cancel(true);     // Catch: Throwable -> L10
    L8:
        f271786h = null;     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void p() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "initGlobalMemoryCheckTask()");
        g r100 = f271780b;
        if (r100.a() == true) goto L13;
        return;
    L13:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        ScheduledFuture<?> r102 = f271786h;     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        r102.cancel(true);     // Catch: Throwable -> L10
    L8:
        Lazy r103 = f271784f;     // Catch: Throwable -> L10
        KProperty r104 = f271779a[0];     // Catch: Throwable -> L10
        f271786h = ((ScheduledExecutorService) r103.getValue()).scheduleAtFixedRate(new a(this), 0, r100.f271813b, TimeUnit.SECONDS);     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public PageReleaseManager() {
    }

    public static com.bytedance.ug.sdk.luckydog.base.pagerelease.a q(b r110) {
        com.bytedance.ug.sdk.luckydog.base.pagerelease.a r100 = new com.bytedance.ug.sdk.luckydog.base.pagerelease.a(0);
        int r101 = r110.f271795a;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L10;
        long r102 = vl7.a.b();
        r100.f271791b = r102;
        if (r102 > r110.f271796b) goto L10;
    L9:
        boolean r103 = true;
    L11:
        String r104 = "force";
        if (r103 == false) goto L18;
        r100.f271790a = true;
        if (r110.f271795a != 2) goto L16;
        r104 = "java";
    L16:
        r100.f271794e = r104;
        return r100;
    L18:
        int r105 = r110.f271797c;
        if (r105 == 0) goto L76;
        if (r105 == 1) goto L75;
        if (r105 != 2) goto L76;
        sl7.b r106 = sl7.b.a.f542478a;
        Context r107 = m.f538361o.e();
        ActivityManager.MemoryInfo r108 = new ActivityManager.MemoryInfo();
        ActivityManager r109 = (ActivityManager) r107.getSystemService("activity");
        if (r109 == null) goto L26;
        r109.getMemoryInfo(r108);
        long r111 = r108.availMem;
    L28:
        if (r111 != (-1)) goto L73;
        PolarisFileInputStreamWrapper r112 = null;
        PolarisFileInputStreamWrapper r113 = new PolarisFileInputStreamWrapper("/proc/meminfo");     // Catch: Throwable -> L60 Exception -> L99
        byte[] r114 = new byte[1024];     // Catch: Throwable -> L57 Exception -> L59
        int r115 = r113.read(r114);     // Catch: Throwable -> L98 Throwable -> L57 Exception -> L59
        int r116 = 0;
    L33:
        if (r116 >= r115) goto L50;
        byte r117 = r114[r116];     // Catch: Throwable -> L98 Throwable -> L57 Exception -> L59
        if (r117 == 10) goto L37;
        if (r116 == 0) goto L37;
    L49:
        r116 = r116 + 1;
    L37:
        if (r117 != 10) goto L39;
        r116 = r116 + 1;     // Catch: Throwable -> L98 Throwable -> L57 Exception -> L59
    L39:
        int r118 = r116;
    L40:
        if (r118 >= r115) goto L49;
        int r119 = r118 - r116;     // Catch: Throwable -> L98 Throwable -> L57 Exception -> L59
        if (r114[r118] != "MemAvailable".charAt(r119)) goto L49;
        if (r119 == 11) goto L46;
        r118 = r118 + 1;
        goto L40
    L46:
        int r120 = vl7.a.a(r114, r118);     // Catch: Throwable -> L98 Throwable -> L57 Exception -> L59
    L51:
        long r121 = ((long) r120) * 1024;
        r113.close();     // Catch: Exception -> L54
    L56:
        r111 = r121;
    L54:
        e = move-exception;
        e.printStackTrace();
        goto L56
    L50:
        r120 = -1;
    L59:
        r112 = r113;
    L57:
        th = move-exception;
        Throwable r122 = th;
        r112 = r113;
    L62:
        if (r112 == null) goto L117;
        r112.close();     // Catch: Exception -> L65
        throw r122;
    L65:
        e = move-exception;
        e.printStackTrace();
        throw r122;
    L117:
        throw r122;
    L60:
        th = move-exception;
        r122 = th;
    L68:
        if (r112 == null) goto L73;
        r112.close();     // Catch: Exception -> L71
    L71:
        e = move-exception;
        e.printStackTrace();
    L73:
        long r123 = (r111 / 1024) / 1024;
        r100.f271792c = r123;
        if (r123 > r110.f271798d) goto L76;
    L26:
        r111 = -1;
    L75:
        boolean r124 = true;
    L77:
        if (r124 == false) goto L83;
        r100.f271790a = true;
        if (r110.f271797c != 2) goto L81;
        r104 = "physics";
    L81:
        r100.f271794e = r104;
        return r100;
    L83:
        int r125 = r110.f271799e;
        if (r125 == 0) goto L91;
        if (r125 == 1) goto L90;
        if (r125 != 2) goto L91;
        long r126 = vl7.a.c();
        r100.f271793d = r126;
        if (r126 > r110.f271800f) goto L91;
    L90:
        boolean r127 = true;
    L92:
        if (r127 == false) goto L97;
        r100.f271790a = true;
        if (r110.f271799e != 2) goto L96;
        r104 = "virtual";
    L96:
        r100.f271794e = r104;
    L97:
        return r100;
    L91:
        r127 = false;
    L76:
        r124 = false;
    L10:
        r103 = false;
        goto L11
    }

    public static void s(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "releaseAllPageMemory()");
        Iterator r101 = ((LinkedHashMap) f271781c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Map.Entry r102 = (Map.Entry) r101.next();
        ((c) r102.getValue()).getClass();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "releaseAllPageMemory, path = null");
        if (Intrinsics.areEqual(r100, "page_appear") == false) goto L11;
        g r103 = f271780b;
        ((c) r102.getValue()).getClass();
        if (r103.f271816e.size() == 0) goto L4;
        throw null;
    L11:
        ((c) r102.getValue()).getClass();
        throw null;
    }

    public static void t(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "stopPageFutureTask()");
        ScheduledFuture<?> r101 = f271785g.remove(r100);
        if (r101 == null) goto L16;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        if (r101.isDone() == false) goto L7;
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L7:
        if (r101.isCancelled() == true) goto L9;
        r101.cancel(true);     // Catch: Throwable -> L11
        f271782d.put(r100, Boolean.FALSE);     // Catch: Throwable -> L11
        f271783e.remove(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }

    @Override // tl7.a
    public final void i(Activity r100) {
        g r101 = f271780b;
        boolean r102 = false;
        if (r101.f271816e.size() != 0) goto L5;
        boolean r103 = false;
    L15:
        if (r103 == true) goto L17;
        return;
    L17:
        String r104 = r100.getIntent().getStringExtra("lucky_schema");
        if (r104 != null) goto L21;
        r104 = "";
    L21:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "onActivityBeCreating()..className = " + r100.getComponentName().getClassName() + " url = " + r104);
        String r105 = o(r104);
        if (r105.length() != 0) goto L24;
        r102 = true;
    L24:
        if (r102 == false) goto L26;
        com.bytedance.ug.sdk.luckydog.api.log.d.e("PageReleaseManager", "onPageDestroy()...path is empty");
        b r106 = f271780b.f271815d.f271803b.get(r100.getComponentName().getClassName());
    L27:
        if (r106 != null) goto L31;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("PageReleaseManager", "onActivityBeCreating strategy is empty");
        return;
    L31:
        if (q(r106).f271790a == false) goto L39;
        s("page_appear");
        return;
    L39:
        return;
    L26:
        r106 = f271780b.f271815d.f271802a.get(r105);
        goto L27
    L5:
        HashMap<String, f> r107 = r101.f271816e;
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<Map.Entry<String, f>> r109 = r107.entrySet().iterator();
    L7:
        if (r109.hasNext() == false) goto L14;
        Map.Entry<String, f> r110 = r109.next();
        if (r110.getValue().f271811h != 1) goto L11;
        boolean r111 = true;
    L12:
        if (r111 == false) goto L7;
        r108.put(r110.getKey(), r110.getValue());
        goto L7
    L11:
        r111 = false;
        goto L12
    L14:
        r103 = !r108.isEmpty();
        goto L15
    }

    public final String o(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return "";
    L12:
        Uri r103 = UriProtector.parse(r100);
        String r104 = UriProtector.getQueryParameter(r103, "surl");
        if (r104 != null) goto L17;
        r104 = "";
    L17:
        if (TextUtils.equals(r103.getHost(), "flower") == true) goto L19;
    L21:
        boolean r105 = false;
    L22:
        if (r105 == false) goto L28;
        r104 = UriProtector.getQueryParameter(r103, "url");
        if (r104 != null) goto L28;
        r104 = "";
    L28:
        if (r104.length() == 0) goto L31;
        r101 = false;
    L31:
        if (r101 == false) goto L35;
        String r106 = r103.getPath();
        if (r106 != null) goto L39;
        return "";
    L39:
        return r106;
    L35:
        r106 = UriProtector.parse(r104).getPath();
        if (r106 != null) goto L39;
        return "";
    L19:
        if (TextUtils.equals(r103.getPath(), "/lynxview") == false) goto L21;
        r105 = true;
        goto L22
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    @Override // tl7.a
    public final void onActivityCreate(Activity r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "onActivityStart()..className =" + r100.getComponentName().getClassName());
        i(r100);
        return;
    }

    @Override // uo7.c, uo7.b
    public final void onEnterBackground(Activity r100) {
        super.onEnterBackground(r100);
        l();
    }

    @Override // uo7.c, uo7.b
    public final void onEnterForeground(Activity r100) {
        super.onEnterForeground(r100);
        p();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "onTrimMemory()..level = " + r100);
        if (r100 >= 15) goto L5;
        return;
    L5:
        if (q(f271780b.f271814c).f271790a == false) goto L9;
        s("memory_warning");
        return;
    }

    public final void r(Application r100) {
        AtomicBoolean r101 = f271787i;
        if (r101.get() == false) goto L5;
        return;
    L5:
        tl7.b r102 = tl7.b.f546640c;
        r102.getClass();
        AtomicBoolean r103 = tl7.b.f546639b;
        if (r103.get() == false) goto L8;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyRouteMonitor", "has already init");
    L9:
        r102.getClass();
        LinkedList<tl7.a> r104 = tl7.b.f546638a;
        monitor-enter(r104);
    L22:
        th = move-exception;
        throw th;
    L12:
        if (r104.contains(this) == false) goto L15;
        monitor-exit(r104);
    L17:
        zl7.f r105 = (zl7.f) hn7.d.b(zl7.f.class);
        if (r105 == null) goto L20;
        r105.T(this);
    L20:
        to7.c.d(this);
        r100.registerComponentCallbacks(this);
        r101.set(true);
        return;
    L15:
        r104.add(this);     // Catch: Throwable -> L22
        monitor-exit(r104);
        goto L17
    L8:
        r103.set(true);
        r100.registerActivityLifecycleCallbacks(r102);
        goto L9
    }

    @Override // zl7.e
    public final void b0(String r100, Bundle r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "onPageDestroy()");
        String r102 = o(r100);
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.e("PageReleaseManager", "onPageDestroy()...path is empty");
        return;
    L9:
        t(r102);
        f271781c.remove(r102);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // zl7.e
    public final void m(String r110, Bundle r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "onPageHide()");
        String r112 = o(r110);
        boolean r100 = true;
        if (r112.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.e("PageReleaseManager", "onPageHide()...path is empty");
        return;
    L9:
        Map<String, c> r102 = f271781c;
        c r103 = (c) ((LinkedHashMap) r102).get(r112);
        if (r103 == null) goto L12;
        r103.f271801a = false;
    L12:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "startPageFutureTask()");
        f r104 = f271780b.f271816e.get(r112);
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.f271810g > 0) goto L18;
        r100 = false;
    L18:
        if (r100 == true) goto L30;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "startPageFutureTask()...delay = " + r104.f271810g);
        return;
    L30:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L27
        c r114 = (c) ((LinkedHashMap) r102).get(r112);     // Catch: Throwable -> L27
        if (r114 != null) goto L23;
        return;
    L23:
        if (q(new b(r104.f271804a, r104.f271805b, r104.f271806c, r104.f271807d, r104.f271808e, r104.f271809f)).f271790a == false) goto L25;
        f271782d.put(r112, Boolean.TRUE);     // Catch: Throwable -> L27
        Lazy r105 = f271784f;     // Catch: Throwable -> L27
        KProperty r106 = f271779a[0];     // Catch: Throwable -> L27
        f271785g.put(r112, ((ScheduledExecutorService) r105.getValue()).schedule(new h(this, r114, r112, r104), r104.f271810g, TimeUnit.MILLISECONDS));     // Catch: Throwable -> L27
    L25:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void n(Application r110, JSONObject r210) {
        g r100 = f271780b;
        r100.getClass();
        if (r210.optInt("page_release_enable") != 1) goto L5;
        boolean r101 = true;
    L6:
        r100.f271812a = r101;
        JSONObject r102 = r210.optJSONObject("memory_checker_setting");
        if (r102 == null) goto L9;
        int r103 = r102.optInt("memory_polling_interval", 0);
    L10:
        r100.f271813b = r103;
        JSONObject r104 = r210.optJSONObject("memory_warning_strategy");
        if (r104 != null) goto L14;
        r104 = new JSONObject();
    L14:
        r100.f271814c = g.b(r104);
        JSONObject r105 = r210.optJSONObject("other_page_appear_strategy");
        if (r105 != null) goto L18;
        r105 = new JSONObject();
    L18:
        JSONObject r106 = r105.optJSONObject("frontend_scenes");
        if (r106 != null) goto L22;
        r106 = new JSONObject();
    L22:
        JSONObject r107 = r105.optJSONObject("native_scenes");
        if (r107 != null) goto L26;
        r107 = new JSONObject();
    L26:
        r100.f271815d = new e(g.c(r106), g.c(r107));
        JSONObject r108 = r210.optJSONObject("page_hide_strategy");
        if (r108 != null) goto L30;
        r108 = new JSONObject();
    L30:
        HashMap<String, f> r109 = new HashMap();
        Iterator<String> r111 = r108.keys();
    L32:
        if (r111.hasNext() == false) goto L38;
        String r112 = r111.next();
        JSONObject r113 = r108.optJSONObject(r112);
        if (r113 != null) goto L37;
        r113 = new JSONObject();
    L37:
        r109.put(r112, new f(r113.optInt("java_release_strategy"), r113.optInt("java_available_memory"), r113.optInt("physics_release_strategy"), r113.optInt("physics_available_memory"), r113.optInt("virtual_release_strategy"), r113.optInt("virtual_available_memory"), r113.optInt("delay", 0), r113.optInt("other_page_appear_enabled")));
        goto L32
    L38:
        r100.f271816e = r109;
        StringBuilder r114 = new StringBuilder("int()... pageReleaseEnable = ");
        g r115 = f271780b;
        r114.append(r115.f271812a);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", r114.toString());
        if (r115.f271812a == false) goto L41;
        r(r110);
        p();
        return;
    L41:
        AtomicBoolean r116 = f271787i;
        if (r116.get() == false) goto L52;
        tl7.b.f546640c.getClass();
        LinkedList<tl7.a> r117 = tl7.b.f546638a;
        monitor-enter(r117);
        r117.remove(this);     // Catch: Throwable -> L66
        monitor-exit(r117);
        zl7.f r118 = (zl7.f) hn7.d.b(zl7.f.class);
        if (r118 == null) goto L51;
        r118.u(this);
    L51:
        to7.c.e(this);
        r110.unregisterComponentCallbacks(this);
        r116.set(false);
    L66:
        th = move-exception;
        throw th;
    L52:
        l();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "stopAllPageFutureTask()");
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L63
        Iterator r120 = ((LinkedHashMap) f271785g).entrySet().iterator();     // Catch: Throwable -> L63
    L55:
        if (r120.hasNext() == false) goto L61;
        ScheduledFuture r121 = (ScheduledFuture) ((Map.Entry) r120.next()).getValue();     // Catch: Throwable -> L63
        if (r121.isDone() == true) goto L55;
        if (r121.isCancelled() == true) goto L55;
        r121.cancel(true);     // Catch: Throwable -> L63
        goto L55
    L61:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L63
        return;
    L63:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    @Override // zl7.e
    public final void x(String r100, Bundle r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageReleaseManager", "onPageShow()");
        String r102 = o(r100);
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.e("PageReleaseManager", "onPageShow()...path is empty");
        return;
    L9:
        c r104 = (c) ((LinkedHashMap) f271781c).get(r102);
        if (r104 == null) goto L12;
        r104.f271801a = true;
    L12:
        t(r102);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
