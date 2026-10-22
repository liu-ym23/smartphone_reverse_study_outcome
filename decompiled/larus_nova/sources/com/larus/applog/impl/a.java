package com.larus.applog.impl;

import android.os.Bundle;
import android.util.Pair;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.l;
import com.bytedance.applog.p;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.g0;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.utility.CommonHttpException;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v48.e;
import v48.h;
import w48.n;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static v48.a f287058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<e> f287059b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Function0<Object>> f287060c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f287061d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArrayList<v48.d> f287062e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<ow3.b> f287063f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<l> f287064g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<h> f287065h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C3947a f287066i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f287067j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f287068k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final w48.a f287069l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f287070m = null;

    /* JADX INFO: renamed from: com.larus.applog.impl.a$a, reason: collision with other inner class name */
    public static final class C3947a implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f287071a;

        /* JADX INFO: renamed from: com.larus.applog.impl.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes24.dex */
        public static final class C3948a extends BDNetworkTagContextProviderAdapter {
            @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
            public final int triggerType() {
                return 0;
            }

            public C3948a() {
            }
        }

        /* JADX INFO: renamed from: com.larus.applog.impl.a$a$b */
        /* JADX INFO: loaded from: classes4.dex */
        public static final class b extends BDNetworkTagContextProviderAdapter {
            @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
            public final int triggerType() {
                return 0;
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.larus.applog.impl.a$a$c */
        /* JADX INFO: loaded from: classes4.dex */
        public static final class c extends BDNetworkTagContextProviderAdapter {
            @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
            public final int triggerType() {
                return 0;
            }

            public c() {
            }
        }

        public C3947a() {
            this.f287071a = new n();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.bdinstall.g0
        public final String get(String r100, Map<String, String> r101) {
            HashMap r102 = new HashMap();     // Catch: Exception -> L7
            Pair<String, String> r103 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new C3948a());     // Catch: Exception -> L7
            r102.put(r103.first, r103.second);     // Catch: Exception -> L7
            if (r101 != null) goto L5;
            r101 = new LinkedHashMap();     // Catch: Exception -> L7
        L5:
            Map r104 = MapsKt.toMutableMap(r101);     // Catch: Exception -> L7
            r104.put(r103.first, r103.second);     // Catch: Exception -> L7
            String r105 = this.f287071a.get(r100, r104, null);     // Catch: Exception -> L7
            Intrinsics.checkNotNull(r105);     // Catch: Exception -> L7
            return r105;
        L7:
            e = move-exception;
            if ((e instanceof CommonHttpException) == false) goto L13;
            throw new RangersHttpException(((CommonHttpException) e).getResponseCode(), e.getCause());
        L13:
            throw new RangersHttpException(400, e.getCause());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.bdinstall.g0
        public final String post(String r100, byte[] r101, Map<String, String> r102) {
            HashMap r103 = new HashMap();     // Catch: CommonHttpException -> L4
            Pair<String, String> r104 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new b());     // Catch: CommonHttpException -> L4
            r103.put(r104.first, r104.second);     // Catch: CommonHttpException -> L4
            Map r105 = MapsKt.toMutableMap(r102);     // Catch: CommonHttpException -> L4
            r105.put(r104.first, r104.second);     // Catch: CommonHttpException -> L4
            String r106 = this.f287071a.post(r100, r101, r105, null);     // Catch: CommonHttpException -> L4
            Intrinsics.checkNotNull(r106);     // Catch: CommonHttpException -> L4
            return r106;
        L4:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.bdinstall.g0
        public final byte[] postStream(String r100, byte[] r101, Map<String, String> r102) {
            HashMap r103 = new HashMap();     // Catch: CommonHttpException -> L4
            Pair<String, String> r104 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new c());     // Catch: CommonHttpException -> L4
            r103.put(r104.first, r104.second);     // Catch: CommonHttpException -> L4
            Map r105 = MapsKt.toMutableMap(r102);     // Catch: CommonHttpException -> L4
            r105.put(r104.first, r104.second);     // Catch: CommonHttpException -> L4
            byte[] r106 = this.f287071a.postDataStream(r100, r101, r105, null);     // Catch: CommonHttpException -> L4
            Intrinsics.checkNotNull(r106);     // Catch: CommonHttpException -> L4
            return r106;
        L4:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }

    public static final class b implements com.bytedance.applog.h {
        public b() {
        }

        @Override // com.bytedance.applog.h
        public final void a(boolean r100, JSONObject r101) {
            FLogger.f375446a.d("AppLogHelper", "onRemoteConfigGet: changed = " + r100 + ", config = " + r101);
        }

        @Override // com.bytedance.applog.h
        public final void onIdLoaded(String r100, String r101, String r102) {
            v48.a r103 = a.f287058a;
            if (SetsKt.setOf(new String[]{"debug", "inhouse", "local_test", "auto_test"}).contains(AppHost.f326268a.getBuildChannel()) == false) goto L5;
            FLogger.f375446a.w("AppLogHelper", "onIdLoaded: did = " + r100 + ", iid = " + r101 + ", ssid = " + r102, new RuntimeException());
        L6:
            if (r100 != null) goto L8;
        L11:
            boolean r104 = true;
        L12:
            if (r104 == false) goto L14;
        L28:
            a.f(r100, r101, "onIdLoaded");
            return;
        L14:
            if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L16;
        L17:
            Iterator r105 = ((CopyOnWriteArrayList) a.f287059b).iterator();
        L19:
            if (r105.hasNext() == false) goto L28;
            e r106 = (e) r105.next();
            String r107 = "";
            if (r101 != null) goto L23;
            String r108 = "";
        L24:
            if (r102 == null) goto L27;
            r107 = r102;
        L27:
            r106.onGetId(r100, r108, r107);
            goto L19
        L23:
            r108 = r101;
            goto L24
        L16:
            if (Intrinsics.areEqual(r100, "0") == true) goto L28;
        L8:
            if (r100.length() == 0) goto L11;
            r104 = false;
            goto L12
        L5:
            FLogger.f375446a.i("AppLogHelper", "onIdLoaded: did = " + r100 + ", iid = " + r101 + ", ssid = " + r102);
            goto L6
        }

        @Override // com.bytedance.applog.h
        public final void onRemoteIdGet(boolean r110, String r111, String r210, String r211, String r212, String r213, String r214) {
            v48.a r100 = a.f287058a;
            if (SetsKt.setOf(new String[]{"debug", "inhouse", "local_test", "auto_test"}).contains(AppHost.f326268a.getBuildChannel()) == false) goto L5;
            FLogger.f375446a.w("AppLogHelper", "onRemoteIdGet: called, changed = " + r110 + ", oldDid = " + r111 + ", newDid = " + r210 + ", oldIid = " + r211 + ", newIid = " + r212 + ", oldSsid = " + r213 + ", newSsid = " + r214, new RuntimeException());
        L6:
            if (r110 == false) goto L34;
            if (r210 != null) goto L9;
        L12:
            boolean r101 = true;
        L13:
            if (r101 == false) goto L15;
            return;
        L15:
            if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L17;
        L18:
            Iterator r102 = ((CopyOnWriteArrayList) a.f287059b).iterator();
        L20:
            if (r102.hasNext() == false) goto L29;
            e r103 = (e) r102.next();
            String r104 = "";
            if (r212 != null) goto L24;
            String r105 = "";
        L25:
            if (r214 == null) goto L28;
            r104 = r214;
        L28:
            r103.onGetId(r210, r105, r104);
            goto L20
        L24:
            r105 = r212;
            goto L25
        L29:
            a.f(r210, r212, "onRemoteIdGet");
            return;
        L17:
            if (Intrinsics.areEqual(r210, "0") == false) goto L18;
            return;
        L9:
            if (r210.length() == 0) goto L12;
            r101 = false;
            goto L13
        L34:
            return;
        L5:
            FLogger.f375446a.i("AppLogHelper", "onRemoteIdGet: called, changed = " + r110 + ", oldDid = " + r111 + ", newDid = " + r210 + ", oldIid = " + r211 + ", newIid = " + r212 + ", oldSsid = " + r213 + ", newSsid = " + r214);
            goto L6
        }
    }

    public static final class c implements ow3.b {
        public c() {
        }

        @Override // ow3.b
        public final void a(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "flatParams");
            Iterator r102 = ((CopyOnWriteArrayList) a.f287063f).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((ow3.b) r102.next()).a(r100, r101);
            goto L4
        }

        @Override // ow3.b
        public final void b(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "flatParams");
            Iterator r102 = ((CopyOnWriteArrayList) a.f287063f).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((ow3.b) r102.next()).b(r100, r101);
            goto L4
        }
    }

    public static final class d implements p {
        public d() {
        }

        @Override // com.bytedance.applog.p
        public final void onSessionStart(long r100, String r101) {
            Iterator r102 = ((CopyOnWriteArrayList) a.f287065h).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((h) r102.next()).onSessionStart(r100, r101);
            goto L4
        }

        @Override // com.bytedance.applog.p
        public final void a(long r100, String r101, JSONObject r102) {
            Iterator r103 = ((CopyOnWriteArrayList) a.f287065h).iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((h) r103.next()).onSessionTerminate(r100, r101);
            goto L4
        }

        @Override // com.bytedance.applog.p
        public final void b(long r100, String r101, JSONObject r102) {
            Iterator r103 = ((CopyOnWriteArrayList) a.f287065h).iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((h) r103.next()).onSessionBatchEvent(r100, r101);
            goto L4
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [w48.a] */
    static {
        f287059b = new CopyOnWriteArrayList();
        f287060c = new ConcurrentHashMap();
        f287061d = new ConcurrentHashMap();
        f287062e = new CopyOnWriteArrayList();
        f287063f = new CopyOnWriteArrayList();
        f287064g = new CopyOnWriteArrayList();
        f287065h = new CopyOnWriteArrayList();
        f287066i = new C3947a();
        f287067j = new b();
        f287068k = new c();
        f287069l = new w48.a();
        f287070m = new d();
    }

    public static void c() {
        v48.a r100 = f287058a;
        if (r100 == null) goto L6;
        EventsSenderUtils.setEventsSenderEnable(String.valueOf(r100.f553111a), true, AppHost.f326268a.getApplication());
        EventsSenderUtils.setEventVerifyHost(String.valueOf(r100.f553111a), "https://log.snssdk.com");
        return;
    }

    public static void d(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FLogger.f375446a.d("AppLogHelper", r100 + ": " + r101);
        if (r101 != null) goto L5;
        Bundle r102 = new Bundle();
    L28:
        Iterator<v48.d> r103 = f287062e.iterator();     // Catch: Exception -> L24
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().a(r100, r101);     // Catch: Exception -> L24
        goto L8
    L10:
        Iterator r104 = ((ConcurrentHashMap) f287060c).entrySet().iterator();     // Catch: Exception -> L24
    L12:
        if (r104.hasNext() == false) goto L19;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Exception -> L24
        String r106 = (String) r105.getKey();     // Catch: Exception -> L24
        Object r107 = ((Function0) r105.getValue()).invoke();     // Catch: Exception -> L24
        if (r102.containsKey(r106) == true) goto L12;
        if (r107 == null) goto L12;
        if ((r107 instanceof String) == false) goto L12;
        r102.putString(r106, (String) r107);     // Catch: Exception -> L24
        goto L12
    L19:
        Iterator<Map.Entry<String, Object>> r108 = f287061d.entrySet().iterator();     // Catch: Exception -> L24
    L20:
        if (r108.hasNext() == false) goto L26;
        Map.Entry<String, Object> r109 = r108.next();     // Catch: Exception -> L24
        a(r102, r109.getKey(), r109.getValue());     // Catch: Exception -> L24
    L26:
        AppLog.onEventV3(r100, r102);
        return;
    L24:
        e = move-exception;
        FLogger.f375446a.e("AppLogHelper", "reportEvent: Bundle Params error: ", e);
        goto L26
    L5:
        r102 = r101;
        goto L28
    }

    public static void e(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        FLogger.f375446a.i("AppLogHelper", r100 + ": " + r101);
        Iterator<v48.d> r102 = f287062e.iterator();     // Catch: Exception -> L22
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().intercept(r100, r101);     // Catch: Exception -> L22
        goto L8
    L10:
        Iterator r103 = ((ConcurrentHashMap) f287060c).entrySet().iterator();     // Catch: Exception -> L22
    L12:
        if (r103.hasNext() == false) goto L17;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Exception -> L22
        String r105 = (String) r104.getKey();     // Catch: Exception -> L22
        Object r106 = ((Function0) r104.getValue()).invoke();     // Catch: Exception -> L22
        if (r101.has(r105) == true) goto L12;
        if (r106 == null) goto L12;
        r101.put(r105, r106);     // Catch: Exception -> L22
        goto L12
    L17:
        Iterator<Map.Entry<String, Object>> r107 = f287061d.entrySet().iterator();     // Catch: Exception -> L22
    L18:
        if (r107.hasNext() == false) goto L24;
        Map.Entry<String, Object> r108 = r107.next();     // Catch: Exception -> L22
        b(r101, r108.getKey(), r108.getValue());     // Catch: Exception -> L22
    L24:
        AppLog.onEventV3(r100, r101);
        return;
    L22:
        e = move-exception;
        FLogger.f375446a.e("AppLogHelper", "reportEvent: JSONObject Params error: ", e);
        goto L24
    }

    public static void a(Bundle r100, String r101, Object r102) {
        if (r100.containsKey(r101) == false) goto L6;
        return;
    L6:
        if ((r102 instanceof String) == false) goto L9;
        r100.putString(r101, (String) r102);
        return;
    L9:
        if ((r102 instanceof Integer) == false) goto L12;
        r100.putInt(r101, ((Number) r102).intValue());
        return;
    L12:
        if ((r102 instanceof Long) == false) goto L15;
        r100.putLong(r101, ((Number) r102).longValue());
        return;
    L15:
        if ((r102 instanceof Boolean) == false) goto L18;
        r100.putBoolean(r101, ((Boolean) r102).booleanValue());
        return;
    L18:
        if (AppHost.f326268a.isTestChannel() == true) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("addToBundle -> unsupported type: ".concat(r102.getClass().getName()));
    }

    public static void b(JSONObject r100, String r101, Object r102) {
        if (r100.has(r101) == false) goto L6;
        return;
    L6:
        if ((r102 instanceof String) == false) goto L9;
        r100.put(r101, r102);
        return;
    L9:
        if ((r102 instanceof Integer) == false) goto L12;
        r100.put(r101, ((Number) r102).intValue());
        return;
    L12:
        if ((r102 instanceof Long) == false) goto L15;
        r100.put(r101, ((Number) r102).longValue());
        return;
    L15:
        if ((r102 instanceof Boolean) == false) goto L18;
        r100.put(r101, ((Boolean) r102).booleanValue());
        return;
    L18:
        if (AppHost.f326268a.isTestChannel() == true) goto L22;
        Unit r103 = Unit.INSTANCE;
        return;
    L22:
        throw new IllegalArgumentException("addToJSONObject -> unsupported type: ".concat(r102.getClass().getName()));
    }

    public static void f(String r100, String r101, String r102) {
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("updateBdTuringId: ");
        r104.append(r102);
        r104.append(", did empty? ");
        boolean r105 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        r104.append(r106);
        r104.append(", iid empty? ");
        if (r101 != null) goto L12;
    L15:
        r104.append(r105);
        r103.i("AppLogHelper", r104.toString());
        qb4.b r107 = qb4.b.c.f532315a;
        BdTuringConfig r108 = r107.f532302a;
        if (r108 == null) goto L18;
        r108.setDeviceId(r100);
    L18:
        BdTuringConfig r109 = r107.f532302a;
        if (r109 == null) goto L22;
        r109.setInstallId(r101);
        return;
    L22:
        return;
    L12:
        if (r101.length() == 0) goto L15;
        r105 = false;
        goto L15
    L5:
        if (r100.length() == 0) goto L8;
        r106 = false;
        goto L9
    }
}
