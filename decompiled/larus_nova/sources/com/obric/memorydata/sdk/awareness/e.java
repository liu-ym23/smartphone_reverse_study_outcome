package com.obric.memorydata.sdk.awareness;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.ResultCallback;
import com.obric.sva.sdk.ohr.OhrHandStateBridge$listener$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f397109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile IContextAwarenessService f397110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile h f397111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IBinder f397112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static IBinder.DeathRecipient f397113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<ResultCallback<Boolean>> f397114f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Context f397115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f397116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Set<j<?>>> f397117i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, IFeatureChangeListener> f397118j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Set<i>> f397119k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ConcurrentHashMap<String, IEventChangeListener> f397120l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap<b, Set<k>> f397121m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ConcurrentHashMap<b, IFeatureDurationListener> f397122n = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f397123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ServiceConnection f397124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IBinder f397125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final IBinder.DeathRecipient f397126d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f397123a, r101.f397123a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397124b, r101.f397124b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f397125c, r101.f397125c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f397126d, r101.f397126d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Context r100 = this.f397123a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f397124b.hashCode()) * 31;
            IBinder r104 = this.f397125c;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            IBinder.DeathRecipient r107 = this.f397126d;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "BindingSnapshot(context=" + this.f397123a + ", connection=" + this.f397124b + ", binder=" + this.f397125c + ", deathRecipient=" + this.f397126d + ')';
        }

        public final Context getContext() {
            return this.f397123a;
        }

        public a(Context r100, ServiceConnection r101, IBinder r102, IBinder.DeathRecipient r103) {
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_CONNECTION);
            this.f397123a = r100;
            this.f397124b = r101;
            this.f397125c = r102;
            this.f397126d = r103;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "FeatureDurationKey(featureName=null, targetFeatureValue=null, durationSec=0, oneShot=false)";
        }
    }

    public e() {
    }

    public final synchronized void g() {
        monitor-enter(this);
        tka.c.a("release ContextAwarenessService");     // Catch: Throwable -> L8
        a r100 = i(null, null);     // Catch: Throwable -> L8
        f397110b = null;     // Catch: Throwable -> L8
        f397111c = null;     // Catch: Throwable -> L8
        f397112d = null;     // Catch: Throwable -> L8
        f397113e = null;     // Catch: Throwable -> L8
        f397115g = null;     // Catch: Throwable -> L8
        List<ResultCallback<Boolean>> r101 = f397114f;     // Catch: Throwable -> L8
        List r102 = CollectionsKt.toList(r101);     // Catch: Throwable -> L8
        ((ArrayList) r101).clear();     // Catch: Throwable -> L8
        a(r102, 404, "ContextAwarenessService released");     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        pka.b.a(new com.obric.memorydata.sdk.awareness.a(r100));     // Catch: Throwable -> L8
        pka.b.a(new com.obric.memorydata.sdk.awareness.b(r100));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        f397109a = new e();
        f397114f = new ArrayList();
        f397116h = 64;
        f397117i = new ConcurrentHashMap();
        f397118j = new ConcurrentHashMap();
        f397119k = new ConcurrentHashMap();
        f397120l = new ConcurrentHashMap();
        f397121m = new ConcurrentHashMap();
        f397122n = new ConcurrentHashMap();
    }

    public static boolean e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ServiceInfo r101 = h(r100);
        boolean r102 = false;
        if (r101 != null) goto L5;
        return false;
    L5:
        int r103 = tka.a.f546597a;
        ComponentName r104 = new ComponentName(r101.packageName, r101.name);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "componentName");
        PackageManager r105 = r100.getPackageManager();
        Intrinsics.checkNotNull(r105);
        String r106 = r104.getPackageName();
        Intrinsics.checkNotNullParameter(r105, "pm");
        Intrinsics.checkNotNullParameter(r106, "packageName");
        boolean r107 = !r105.getApplicationInfo(r106, 0).enabled;
    L9:
        if (r107 == true) goto L35;
        int r108 = r105.getComponentEnabledSetting(r104);
        if (r108 == 0) goto L26;
        if (r108 != 1) goto L36;
        return true;
    L36:
        return false;
    L26:
        boolean r109 = r105.getActivityInfo(r104, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L18 Exception -> L25
    L17:
        r102 = r109;
        return r102;
    L18:
        r109 = r105.getServiceInfo(r104, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L20 Exception -> L25
    L20:
        r109 = r105.getReceiverInfo(r104, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L22 Exception -> L25
    L22:
        r109 = r105.getProviderInfo(r104, 0).enabled;     // Catch: Exception -> L25
    L37:
        return r102;
    L35:
        return false;
    L8:
        r107 = true;
        goto L9
    }

    public static ServiceInfo h(Context r100) {
        Iterator<T> r101 = r100.getPackageManager().queryIntentServices(new Intent("com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE").setPackage("com.larus.nova"), 0).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        ServiceInfo r103 = ((ResolveInfo) r102).serviceInfo;
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L14:
        ResolveInfo r105 = (ResolveInfo) r102;
        if (r105 != null) goto L17;
        return null;
    L17:
        return r105.serviceInfo;
    L8:
        if (Intrinsics.areEqual(r103.packageName, "com.larus.nova") == false) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    public static boolean l(e r100) {
        r100.getClass();
        long r101 = System.currentTimeMillis();
    L4:
        if (f397110b != null) goto L12;
        if ((System.currentTimeMillis() - r101) >= 10000) goto L12;
        Thread.sleep(50);     // Catch: InterruptedException -> L10
    L12:
        if (f397110b == null) goto L14;
        return true;
    L14:
        return false;
    }

    public final <T> MemoryResponse<T> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        Context r101 = f397115g;
        if (r101 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", 4);
    L7:
        if (e(r101) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", 4);
    L11:
        if (f397110b != null) goto L29;
        if (l(this) == true) goto L29;
        return new MemoryResponse(406, "Bind service timeout", 4);
    L29:
        IContextAwarenessService r102 = f397110b;     // Catch: RemoteException -> L26
        Intrinsics.checkNotNull(r102);     // Catch: RemoteException -> L26
        MemoryResponse<T> r103 = r102.getFeature(r100);     // Catch: RemoteException -> L26
        if (r103 != null) goto L22;
        return new MemoryResponse(400, "Response is null", 4);
    L22:
        if (r103.a() == false) goto L25;
        return r103;
    L25:
        return new MemoryResponse(r103.f397051a, r103.f397052b, 4);
    L26:
        e = move-exception;
        e.printStackTrace();
        return new MemoryResponse(400, "RemoteException: " + e.getMessage(), 4);
    }

    public final MemoryResponse f(OhrHandStateBridge$listener$1 r110) {
        Intrinsics.checkNotNullParameter("ohr_hand", "featureName");
        Intrinsics.checkNotNullParameter(r110, "listener");
        Context r100 = f397115g;
        if (r100 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", 4);
    L7:
        if (e(r100) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", 4);
    L11:
        if (f397110b == null) goto L13;
    L16:
        ConcurrentHashMap<String, Set<j<?>>> r101 = f397117i;
        Set<j<?>> r102 = r101.get("ohr_hand");
        if (r102 != null) goto L22;
        r102 = new LinkedHashSet();
        Set<j<?>> r103 = r101.putIfAbsent("ohr_hand", r102);
        if (r103 == null) goto L22;
        r102 = r103;
    L22:
        Set<j<?>> r104 = r102;
        r104.add(r110);
        ConcurrentHashMap<String, IFeatureChangeListener> r105 = f397118j;
        boolean r106 = false;
        if (r105.containsKey("ohr_hand") == true) goto L25;
        IFeatureChangeListener.Stub r107 = new ContextAwareness$registerFeature$remoteListener$1();
        IContextAwarenessService r108 = f397110b;     // Catch: RemoteException -> L47
        if (r108 == null) goto L30;
        MemoryResponse r109 = r108.registerFeature("ohr_hand", r107);     // Catch: RemoteException -> L47
    L31:
        if (r109 != null) goto L33;
    L35:
        if (r106 == false) goto L37;
        r105.put("ohr_hand", r107);     // Catch: RemoteException -> L47
        return new MemoryResponse(r109.f397051a, r109.f397052b, 4);
    L37:
        tka.c.b("ContextAwareness", "registerFeature ohr_hand failed, featureName: ", null);     // Catch: RemoteException -> L47
        r104.remove(r110);     // Catch: RemoteException -> L47
        if (r109 == null) goto L40;
        int r111 = r109.f397051a;     // Catch: RemoteException -> L47
    L41:
        if (r109 == null) goto L44;
        String r112 = r109.f397052b;     // Catch: RemoteException -> L47
        if (r112 == null) goto L44;
    L52:
        return new MemoryResponse(r111, r112, 4);
    L44:
        r112 = "registerFeature return null";
        goto L52
    L40:
        r111 = 400;
        goto L41
    L33:
        if (r109.a() != true) goto L35;
        r106 = true;
        goto L35
    L30:
        r109 = null;
    L47:
        e = move-exception;
        e.printStackTrace();
        tka.c.b("ContextAwareness", "registerFeature failed", e);
        r104.remove(r110);
        return new MemoryResponse(400, e.getMessage(), 4);
    L25:
        return new MemoryResponse(0, null, 6);
    L13:
        if (l(this) == true) goto L16;
        return new MemoryResponse(406, "Bind service timeout", 4);
    }

    public final MemoryResponse j(OhrHandStateBridge$listener$1 r100) {
        Intrinsics.checkNotNullParameter("ohr_hand", "featureName");
        Intrinsics.checkNotNullParameter(r100, "listener");
        Context r101 = f397115g;
        if (r101 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", 4);
    L7:
        if (e(r101) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", 4);
    L11:
        if (f397110b == null) goto L13;
    L16:
        Set<j<?>> r102 = f397117i.get("ohr_hand");
        if (r102 == null) goto L19;
        r102.remove(r100);
    L19:
        Set<j<?>> r103 = r102;
        if (r103 != null) goto L22;
    L25:
        boolean r104 = true;
    L26:
        MemoryResponse r105 = null;
        if (r104 == false) goto L39;
        IFeatureChangeListener r106 = f397118j.remove("ohr_hand");
        if (r106 == null) goto L39;
        IContextAwarenessService r107 = f397110b;     // Catch: RemoteException -> L35
        if (r107 == null) goto L33;
        r105 = r107.unregisterFeature("ohr_hand", r106);     // Catch: RemoteException -> L35
    L33:
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.obric.memorydata.sdk.MemoryResponse<java.lang.Void>");     // Catch: RemoteException -> L35
        return r105;
    L35:
        e = move-exception;
        e.printStackTrace();
        tka.c.b("ContextAwareness", "unregisterFeature failed", e);
        return new MemoryResponse(400, e.getMessage(), 4);
    L39:
        return new MemoryResponse(0, null, 6);
    L22:
        if (r103.isEmpty() == true) goto L25;
        r104 = false;
        goto L26
    L13:
        if (l(this) == true) goto L16;
        return new MemoryResponse(406, "Bind service timeout", 4);
    }

    public static void c(ServiceConnection r100, IBinder r101) {
        a r102 = i(r100, r101);
        if (r102 != null) goto L5;
        return;
    L5:
        pka.b.a(new com.obric.memorydata.sdk.awareness.a(r102));
        pka.b.a(new com.obric.memorydata.sdk.awareness.b(r102));
        if (f397115g != null) goto L8;
        tka.c.b("ContextAwareness", "Context is null, cannot reconnect.", null);
        return;
    L8:
        new Handler(Looper.getMainLooper()).postDelayed(new d(), 3000);
    }

    public static a i(ServiceConnection r100, IBinder r101) {
        e r102 = f397109a;
        monitor-enter(r102);
        h r103 = f397111c;     // Catch: Throwable -> L18
        a r104 = null;
        if (r103 == null) goto L16;
        if (r100 == null) goto L10;
        if (r100 != r103) goto L16;
    L10:
        if (r101 != null) goto L12;
    L14:
        a r105 = new a(f397115g, r103, f397112d, f397113e);     // Catch: Throwable -> L18
        f397110b = null;     // Catch: Throwable -> L18
        f397111c = null;     // Catch: Throwable -> L18
        f397112d = null;     // Catch: Throwable -> L18
        f397113e = null;     // Catch: Throwable -> L18
        r104 = r105;
        goto L16
    L12:
        if (r101 == f397112d) goto L14;
    L16:
        monitor-exit(r102);
        return r104;
    L18:
        th = move-exception;
        throw th;
    }

    public static void a(List r100, int r101, String r102) {
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        ResultCallback r104 = (ResultCallback) r103.next();
        if (r101 != 0) goto L8;
        boolean r105 = true;
    L9:
        r104.onResult(r101, r102, Boolean.valueOf(r105));
        goto L4
    L8:
        r105 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.os.Bundle, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static Bundle k(Context r210, Uri r211, Bundle r212) {
        ContentResolver r110 = r210.getContentResolver();
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r211};
        f06.b r113 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(240008);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r114 = r104;
        int r115 = r103;
        f06.a[] r213 = r102;
        f06.d r106 = r105.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r112, "android.content.ContentProviderClient", r113);     // Catch: Exception -> L41
        if (r106.f474982a == true) goto L12;
        r111.add(r105);     // Catch: Exception -> L41
        goto L14
    L12:
        Bundle r107 = 0;
    L17:
        if (r106.f474982a == false) goto L19;
        ContentProviderClient r108 = (ContentProviderClient) r106.f474983b;
    L20:
        ContentProviderClient r109 = r108;
        if (r109 != 0) goto L44;
        tka.c.d("ContextAwareness", "acquire awareness provider client failed method=report_awareness_event");
        return r107;
    L44:
        Bundle r116 = r109.call("report_awareness_event", r107, r212);     // Catch: Throwable -> L27 Exception -> L29 DeadObjectException -> L33
    L26:
        Bundle r117 = r116;
        r109.close();
        return r117;
    L27:
        th = move-exception;
        r109.close();
        throw th;
    L33:
        e = move-exception;
        tka.b r118 = tka.c.f546598a;     // Catch: Throwable -> L27
        tka.c.b("ContextAwareness", "awareness provider died during call method=report_awareness_event", e);     // Catch: Throwable -> L27
        int r119 = l.f397131a;     // Catch: Throwable -> L27
        r116 = l.a(404, "Provider 进程已死亡，请稍后重试");     // Catch: Throwable -> L27
    L29:
        e = move-exception;
        tka.b r120 = tka.c.f546598a;     // Catch: Throwable -> L27
        tka.c.b("ContextAwareness", "awareness provider call failed method=report_awareness_event", e);     // Catch: Throwable -> L27
        r109.close();
        return r107;
    L19:
        r108 = r110.acquireUnstableContentProviderClient(r211);
    L14:
        r104 = r114 + 1;
        r103 = r115;
        r102 = r213;
        goto L8
    L15:
        r107 = 0;
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void d(e r100, final Context r101, ResultCallback r102, int r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r110 = 64;
    L9:
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L59
        f397115g = r101.getApplicationContext();     // Catch: Throwable -> L59
        f397116h = r110;     // Catch: Throwable -> L59
        Context r103 = f397115g;     // Catch: Throwable -> L59
        boolean r104 = false;
        if (r103 == null) goto L15;
        ApplicationInfo r105 = r103.getApplicationInfo();     // Catch: Throwable -> L59
        if (r105 == null) goto L15;
        int r106 = r105.flags;     // Catch: Throwable -> L59
    L17:
        if ((r106 & 2) == 0) goto L19;
        boolean r107 = true;
    L20:
        tka.b r108 = tka.c.f546598a;     // Catch: Throwable -> L59
        if ((tka.c.f546598a instanceof tka.b) == false) goto L24;
        tka.c.f546598a = new tka.b(r107);     // Catch: Throwable -> L59
    L24:
        if (e(r101) == true) goto L31;
        tka.c.b("ContextAwareness", "ContextAwarenessService is disabled", null);     // Catch: Throwable -> L59
        if (r102 == null) goto L28;
        r102.onResult(407, "ContextAwarenessService is disabled", Boolean.FALSE);     // Catch: Throwable -> L59
    L28:
        monitor-exit(r100);
        return;
    L31:
        if (f397110b == null) goto L37;
        tka.c.a("service already connected");     // Catch: Throwable -> L59
        if (r102 == null) goto L35;
        r102.onResult(0, "ContextAwarenessService is ready", Boolean.TRUE);     // Catch: Throwable -> L59
    L35:
        monitor-exit(r100);
        return;
    L37:
        if (r102 == null) goto L40;
        ((ArrayList) f397114f).add(r102);     // Catch: Throwable -> L59
    L40:
        if (f397111c != null) goto L56;
        f397111c = new h();     // Catch: Throwable -> L59
        ServiceInfo r109 = h(r101);     // Catch: Throwable -> L59
        if (r109 != null) goto L46;
        tka.c.b("ContextAwareness", "No service found for action: com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE in com.larus.nova", null);     // Catch: Throwable -> L59
        f397111c = null;     // Catch: Throwable -> L59
        List<ResultCallback<Boolean>> r112 = f397114f;     // Catch: Throwable -> L59
        List r113 = CollectionsKt.toList(r112);     // Catch: Throwable -> L59
        ((ArrayList) r112).clear();     // Catch: Throwable -> L59
        a(r113, 404, "No service found for action");     // Catch: Throwable -> L59
        monitor-exit(r100);
        return;
    L46:
        final Intent r114 = new Intent("com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE").setPackage(r109.packageName);     // Catch: Throwable -> L59
        final h r115 = f397111c;     // Catch: Throwable -> L59
        if (r115 == null) goto L54;
        final int r116 = r110 | 1;     // Catch: Throwable -> L59
        Boolean r117 = (Boolean) pka.b.a(new c(r101, r114, r115, r116));     // Catch: Throwable -> L59
        if (r117 == null) goto L51;
        r104 = r117.booleanValue();     // Catch: Throwable -> L59
    L51:
        tka.c.a("bindService result: " + r104 + ", flags=" + r116 + ", component=" + r114.getComponent() + ", package=" + r109.packageName);     // Catch: Throwable -> L59
        if (r104 == true) goto L54;
        tka.c.b("ContextAwareness", "bindService failed, package=" + r109.packageName, null);     // Catch: Throwable -> L59
        f397111c = null;     // Catch: Throwable -> L59
        f397109a.getClass();     // Catch: Throwable -> L59
        List<ResultCallback<Boolean>> r118 = f397114f;     // Catch: Throwable -> L59
        List r119 = CollectionsKt.toList(r118);     // Catch: Throwable -> L59
        ((ArrayList) r118).clear();     // Catch: Throwable -> L59
        a(r119, 404, "bindService failed");     // Catch: Throwable -> L59
    L54:
        monitor-exit(r100);
        return;
    L56:
        tka.c.a("service binding in progress, callback queued");     // Catch: Throwable -> L59
        monitor-exit(r100);
        return;
    L19:
        r107 = false;
    L15:
        r106 = 0;
    L59:
        th = move-exception;
        throw th;
    }
}
