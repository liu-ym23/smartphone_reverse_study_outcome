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
import com.bytedance.mira.log.MiraMonitor;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
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
import org.xmlpull.v1.XmlPullParser;
import v48.e;
import v48.h;
import w48.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static v48.a a;
    public static final List<e> b = null;
    public static final Map<String, Function0<Object>> c = null;
    public static final ConcurrentHashMap<String, Object> d = null;
    public static final CopyOnWriteArrayList<v48.d> e = null;
    public static final List<ow3.b> f = null;
    public static final List<l> g = null;
    public static final List<h> h = null;
    public static final C0005a i = null;
    public static final b j = null;
    public static final c k = null;
    public static final w48.a l = null;
    public static final d m = null;

    /* JADX INFO: renamed from: com.larus.applog.impl.a$a, reason: collision with other inner class name */
    public static final class C0005a implements g0 {
        public final n a;

        public C0005a() {
            this.a = new n();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.bdinstall.g0
        public final String get(String r5, Map<String, String> r6) {
            HashMap r0 = new HashMap();     // Catch: Exception -> L7
            Pair r1 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a());     // Catch: Exception -> L7
            r0.put(r1.first, r1.second);     // Catch: Exception -> L7
            if (r6 != null) goto L5;
            r6 = new LinkedHashMap();     // Catch: Exception -> L7
        L5:
            Map r7 = MapsKt.toMutableMap(r6);     // Catch: Exception -> L7
            r7.put(r1.first, r1.second);     // Catch: Exception -> L7
            String r8 = this.a.get(r5, r7, null);     // Catch: Exception -> L7
            Intrinsics.checkNotNull(r8);     // Catch: Exception -> L7
            return r8;
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
        public final String post(String r5, byte[] r6, Map<String, String> r7) {
            HashMap r0 = new HashMap();     // Catch: CommonHttpException -> L4
            Pair r1 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new b());     // Catch: CommonHttpException -> L4
            r0.put(r1.first, r1.second);     // Catch: CommonHttpException -> L4
            Map r8 = MapsKt.toMutableMap(r7);     // Catch: CommonHttpException -> L4
            r8.put(r1.first, r1.second);     // Catch: CommonHttpException -> L4
            String r9 = this.a.post(r5, r6, r8, null);     // Catch: CommonHttpException -> L4
            Intrinsics.checkNotNull(r9);     // Catch: CommonHttpException -> L4
            return r9;
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
        public final byte[] postStream(String r5, byte[] r6, Map<String, String> r7) {
            HashMap r0 = new HashMap();     // Catch: CommonHttpException -> L4
            Pair r1 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new c());     // Catch: CommonHttpException -> L4
            r0.put(r1.first, r1.second);     // Catch: CommonHttpException -> L4
            Map r8 = MapsKt.toMutableMap(r7);     // Catch: CommonHttpException -> L4
            r8.put(r1.first, r1.second);     // Catch: CommonHttpException -> L4
            byte[] r9 = this.a.postDataStream(r5, r6, r8, null);     // Catch: CommonHttpException -> L4
            Intrinsics.checkNotNull(r9);     // Catch: CommonHttpException -> L4
            return r9;
        L4:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }

    public static final class b implements com.bytedance.applog.h {
        public b() {
        }

        @Override // com.bytedance.applog.h
        public final void a(boolean r4, JSONObject r5) {
            FLogger.a.d("AppLogHelper", "onRemoteConfigGet: changed = " + r4 + ", config = " + r5);
        }

        @Override // com.bytedance.applog.h
        public final void onIdLoaded(String r7, String r8, String r9) {
            v48.a r0 = a.a;
            if (SetsKt.setOf(new String[]{"debug", "inhouse", "local_test", "auto_test"}).contains(AppHost.a.getBuildChannel()) == false) goto L5;
            FLogger.a.w("AppLogHelper", "onIdLoaded: did = " + r7 + ", iid = " + r8 + ", ssid = " + r9, new RuntimeException());
        L6:
            if (r7 != null) goto L8;
        L11:
            boolean r1 = true;
        L12:
            if (r1 == false) goto L14;
        L28:
            a.f(r7, r8, "onIdLoaded");
            return;
        L14:
            if (ObricFeatureServiceDelegate.b.c() == true) goto L16;
        L17:
            Iterator r2 = ((CopyOnWriteArrayList) a.b).iterator();
        L19:
            if (r2.hasNext() == false) goto L28;
            e r3 = (e) r2.next();
            String r4 = XmlPullParser.NO_NAMESPACE;
            if (r8 != null) goto L23;
            String r5 = XmlPullParser.NO_NAMESPACE;
        L24:
            if (r9 == null) goto L27;
            r4 = r9;
        L27:
            r3.onGetId(r7, r5, r4);
            goto L19
        L23:
            r5 = r8;
            goto L24
        L16:
            if (Intrinsics.areEqual(r7, MiraMonitor.VALUE_DEFAULT) == true) goto L28;
        L8:
            if (r7.length() == 0) goto L11;
            r1 = false;
            goto L12
        L5:
            FLogger.a.i("AppLogHelper", "onIdLoaded: did = " + r7 + ", iid = " + r8 + ", ssid = " + r9);
            goto L6
        }

        @Override // com.bytedance.applog.h
        public final void onRemoteIdGet(boolean r18, String r19, String r20, String r21, String r22, String r23, String r24) {
            v48.a r7 = a.a;
            if (SetsKt.setOf(new String[]{"debug", "inhouse", "local_test", "auto_test"}).contains(AppHost.a.getBuildChannel()) == false) goto L5;
            FLogger.a.w("AppLogHelper", "onRemoteIdGet: called, changed = " + r18 + ", oldDid = " + r19 + ", newDid = " + r20 + ", oldIid = " + r21 + ", newIid = " + r22 + ", oldSsid = " + r23 + ", newSsid = " + r24, new RuntimeException());
        L6:
            if (r18 == false) goto L34;
            if (r20 != null) goto L9;
        L12:
            boolean r0 = true;
        L13:
            if (r0 == false) goto L15;
            return;
        L15:
            if (ObricFeatureServiceDelegate.b.c() == true) goto L17;
        L18:
            Iterator r1 = ((CopyOnWriteArrayList) a.b).iterator();
        L20:
            if (r1.hasNext() == false) goto L29;
            e r2 = (e) r1.next();
            String r3 = XmlPullParser.NO_NAMESPACE;
            if (r22 != null) goto L24;
            String r5 = XmlPullParser.NO_NAMESPACE;
        L25:
            if (r24 == null) goto L28;
            r3 = r24;
        L28:
            r2.onGetId(r20, r5, r3);
            goto L20
        L24:
            r5 = r22;
            goto L25
        L29:
            a.f(r20, r22, "onRemoteIdGet");
            return;
        L17:
            if (Intrinsics.areEqual(r20, MiraMonitor.VALUE_DEFAULT) == false) goto L18;
            return;
        L9:
            if (r20.length() == 0) goto L12;
            r0 = false;
            goto L13
        L34:
            return;
        L5:
            FLogger.a.i("AppLogHelper", "onRemoteIdGet: called, changed = " + r18 + ", oldDid = " + r19 + ", newDid = " + r20 + ", oldIid = " + r21 + ", newIid = " + r22 + ", oldSsid = " + r23 + ", newSsid = " + r24);
            goto L6
        }
    }

    public static final class c implements ow3.b {
        public c() {
        }

        @Override // ow3.b
        public final void a(String r3, JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "flatParams");
            Iterator r0 = ((CopyOnWriteArrayList) a.f).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((ow3.b) r0.next()).a(r3, r4);
            goto L4
        }

        @Override // ow3.b
        public final void b(String r3, JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "flatParams");
            Iterator r0 = ((CopyOnWriteArrayList) a.f).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((ow3.b) r0.next()).b(r3, r4);
            goto L4
        }
    }

    public static final class d implements p {
        public d() {
        }

        @Override // com.bytedance.applog.p
        public final void onSessionStart(long r3, String r5) {
            Iterator r0 = ((CopyOnWriteArrayList) a.h).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((h) r0.next()).onSessionStart(r3, r5);
            goto L4
        }

        @Override // com.bytedance.applog.p
        public final void a(long r2, String r4, JSONObject r5) {
            Iterator r6 = ((CopyOnWriteArrayList) a.h).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ((h) r6.next()).onSessionTerminate(r2, r4);
            goto L4
        }

        @Override // com.bytedance.applog.p
        public final void b(long r2, String r4, JSONObject r5) {
            Iterator r6 = ((CopyOnWriteArrayList) a.h).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ((h) r6.next()).onSessionBatchEvent(r2, r4);
            goto L4
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [w48.a] */
    static {
        b = new CopyOnWriteArrayList();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new CopyOnWriteArrayList();
        f = new CopyOnWriteArrayList();
        g = new CopyOnWriteArrayList();
        h = new CopyOnWriteArrayList();
        i = new C0005a();
        j = new b();
        k = new c();
        l = new w48.a();
        m = new d();
    }

    public static void c() {
        v48.a r0 = a;
        if (r0 == null) goto L6;
        EventsSenderUtils.setEventsSenderEnable(String.valueOf(r0.a), true, AppHost.a.getApplication());
        EventsSenderUtils.setEventVerifyHost(String.valueOf(r0.a), "https://log.snssdk.com");
        return;
    }

    public static void d(String r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        FLogger.a.d("AppLogHelper", r5 + ": " + r6);
        if (r6 != null) goto L5;
        Bundle r0 = new Bundle();
    L28:
        Iterator<v48.d> r1 = e.iterator();     // Catch: Exception -> L24
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().a(r5, r6);     // Catch: Exception -> L24
        goto L8
    L10:
        Iterator r7 = ((ConcurrentHashMap) c).entrySet().iterator();     // Catch: Exception -> L24
    L12:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) r7.next();     // Catch: Exception -> L24
        String r3 = (String) r2.getKey();     // Catch: Exception -> L24
        Object r4 = ((Function0) r2.getValue()).invoke();     // Catch: Exception -> L24
        if (r0.containsKey(r3) == true) goto L12;
        if (r4 == null) goto L12;
        if ((r4 instanceof String) == false) goto L12;
        r0.putString(r3, (String) r4);     // Catch: Exception -> L24
        goto L12
    L19:
        Iterator<Map.Entry<String, Object>> r8 = d.entrySet().iterator();     // Catch: Exception -> L24
    L20:
        if (r8.hasNext() == false) goto L26;
        Map.Entry<String, Object> r9 = r8.next();     // Catch: Exception -> L24
        a(r0, r9.getKey(), r9.getValue());     // Catch: Exception -> L24
    L26:
        AppLog.onEventV3(r5, r0);
        return;
    L24:
        e = move-exception;
        FLogger.a.e("AppLogHelper", "reportEvent: Bundle Params error: ", e);
        goto L26
    L5:
        r0 = r6;
        goto L28
    }

    public static void e(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r6 != null) goto L5;
        r6 = new JSONObject();
    L5:
        FLogger.a.i("AppLogHelper", r5 + ": " + r6);
        Iterator<v48.d> r0 = e.iterator();     // Catch: Exception -> L22
    L8:
        if (r0.hasNext() == false) goto L10;
        r0.next().intercept(r5, r6);     // Catch: Exception -> L22
        goto L8
    L10:
        Iterator r1 = ((ConcurrentHashMap) c).entrySet().iterator();     // Catch: Exception -> L22
    L12:
        if (r1.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r1.next();     // Catch: Exception -> L22
        String r3 = (String) r2.getKey();     // Catch: Exception -> L22
        Object r4 = ((Function0) r2.getValue()).invoke();     // Catch: Exception -> L22
        if (r6.has(r3) == true) goto L12;
        if (r4 == null) goto L12;
        r6.put(r3, r4);     // Catch: Exception -> L22
        goto L12
    L17:
        Iterator<Map.Entry<String, Object>> r7 = d.entrySet().iterator();     // Catch: Exception -> L22
    L18:
        if (r7.hasNext() == false) goto L24;
        Map.Entry<String, Object> r8 = r7.next();     // Catch: Exception -> L22
        b(r6, r8.getKey(), r8.getValue());     // Catch: Exception -> L22
    L24:
        AppLog.onEventV3(r5, r6);
        return;
    L22:
        e = move-exception;
        FLogger.a.e("AppLogHelper", "reportEvent: JSONObject Params error: ", e);
        goto L24
    }

    public static void a(Bundle r2, String r3, Object r4) {
        if (r2.containsKey(r3) == false) goto L6;
        return;
    L6:
        if ((r4 instanceof String) == false) goto L9;
        r2.putString(r3, (String) r4);
        return;
    L9:
        if ((r4 instanceof Integer) == false) goto L12;
        r2.putInt(r3, ((Number) r4).intValue());
        return;
    L12:
        if ((r4 instanceof Long) == false) goto L15;
        r2.putLong(r3, ((Number) r4).longValue());
        return;
    L15:
        if ((r4 instanceof Boolean) == false) goto L18;
        r2.putBoolean(r3, ((Boolean) r4).booleanValue());
        return;
    L18:
        if (AppHost.a.isTestChannel() == true) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("addToBundle -> unsupported type: ".concat(r4.getClass().getName()));
    }

    public static void b(JSONObject r2, String r3, Object r4) {
        if (r2.has(r3) == false) goto L6;
        return;
    L6:
        if ((r4 instanceof String) == false) goto L9;
        r2.put(r3, r4);
        return;
    L9:
        if ((r4 instanceof Integer) == false) goto L12;
        r2.put(r3, ((Number) r4).intValue());
        return;
    L12:
        if ((r4 instanceof Long) == false) goto L15;
        r2.put(r3, ((Number) r4).longValue());
        return;
    L15:
        if ((r4 instanceof Boolean) == false) goto L18;
        r2.put(r3, ((Boolean) r4).booleanValue());
        return;
    L18:
        if (AppHost.a.isTestChannel() == true) goto L22;
        Unit r5 = Unit.INSTANCE;
        return;
    L22:
        throw new IllegalArgumentException("addToJSONObject -> unsupported type: ".concat(r4.getClass().getName()));
    }

    public static void f(String r4, String r5, String r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("updateBdTuringId: ");
        r1.append(r6);
        r1.append(", did empty? ");
        boolean r7 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        r1.append(r3);
        r1.append(", iid empty? ");
        if (r5 != null) goto L12;
    L15:
        r1.append(r7);
        r0.i("AppLogHelper", r1.toString());
        qb4.b r8 = qb4.b.c.a;
        BdTuringConfig r2 = r8.a;
        if (r2 == null) goto L18;
        r2.setDeviceId(r4);
    L18:
        BdTuringConfig r9 = r8.a;
        if (r9 == null) goto L22;
        r9.setInstallId(r5);
        return;
    L22:
        return;
    L12:
        if (r5.length() == 0) goto L15;
        r7 = false;
        goto L15
    L5:
        if (r4.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
