package com.bytedance.sdk.bridge;

import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.bridge.api.BridgeService;
import com.bytedance.sdk.bridge.js.spec.JsBridgeContext;
import com.bytedance.sdk.bridge.model.BridgeResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> f269587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, BridgeMethodInfo> f269588b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<ed7.b> f269589c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BridgeService f269590d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f269591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<String, Class<?>> f269592f = null;

    static {
        f269587a = new ConcurrentHashMap();
        f269588b = new ConcurrentHashMap();
        f269589c = new CopyOnWriteArrayList();
        f269590d = (BridgeService) ServiceManager.getService(BridgeService.class);
        f269591e = true;
        f269592f = new HashMap();
    }

    public static void d() {
        if (f269591e == false) goto L8;
        f269591e = false;
        BridgeService r100 = (BridgeService) ServiceManager.getService(BridgeService.class);
        if (r100 == null) goto L9;
        r100.initBridgeSDK();
        return;
    L9:
        return;
    }

    public static BridgeResult a(JSONObject r100, d[] r101) {
        ArrayList r102 = new ArrayList();
        int r103 = 0;
        if (r101.length != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L13;
        Object[] r105 = r102.toArray(new String[0]);
        if (r105 == null) goto L12;
        String[] r106 = (String[]) r105;
    L27:
        if (r106.length != 0) goto L29;
        boolean r107 = true;
    L31:
        if ((!r107) == false) goto L37;
        JSONObject r108 = new JSONObject();
        JSONArray r109 = new JSONArray();
        int r110 = r106.length;
    L33:
        if (r103 >= r110) goto L35;
        r109.put(r106[r103]);
        r103 = r103 + 1;
        goto L33
    L35:
        r108.put("params", r109);
        Logger.f269563c.getClass();
        Logger.a();
        return BridgeResult.Companion.createParamsErrorResult("params error", r108);
    L37:
        return null;
    L29:
        r107 = false;
        goto L31
    L12:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L13:
        int r111 = r101.length;
        int r112 = 0;
    L14:
        if (r112 >= r111) goto L23;
        d r113 = r101[r112];
        if (r113.f269586e == false) goto L22;
        if (r100 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        if (r100.opt(r113.f269584c) != null) goto L22;
        r102.add(r113.f269584c);
    L22:
        r112 = r112 + 1;
        goto L14
    L23:
        Object[] r114 = r102.toArray(new String[0]);
        if (r114 == null) goto L40;
        r106 = (String[]) r114;
        goto L27
    L40:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L5:
        r104 = false;
        goto L7
    }

    public static ed7.a b(List r100, Lifecycle r101) {
        if (r101 != null) goto L17;
        if (r100 == null) goto L17;
        if ((!r100.isEmpty()) == false) goto L17;
        if (BridgeManager.INSTANCE.getBridgeConfig().isCompatiblePreLoadWebview().booleanValue() == false) goto L16;
        int r102 = r100.size();
    L9:
        r102 = r102 - 1;
        if (r102 < 0) goto L16;
        if (((ed7.a) ListProtector.get(r100, r102)).f472225c == false) goto L9;
        return (ed7.a) ListProtector.get(r100, r102);
    L16:
        return (ed7.a) CollectionsKt.last(r100);
    L17:
        ed7.a r103 = null;
        if (r100 == null) goto L28;
        Iterator r104 = r100.iterator();
    L21:
        if (r104.hasNext() == false) goto L28;
        ed7.a r105 = (ed7.a) r104.next();
        if (Intrinsics.areEqual(r105.f472226d, r101) == true) goto L24;
        if (r105.f472226d != null) goto L21;
        r103 = r105;
        goto L21
    L24:
        return r105;
    L28:
        return r103;
    }

    public static ed7.a c(String r110, Lifecycle r111) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r100 = f269587a;
        if (r100.containsKey(r110) == false) goto L13;
        ed7.a r101 = b(r100.get(r110), r111);
        if (r101 == null) goto L7;
        BridgeMethodInfo r102 = r101.f472224b;
    L8:
        if (r101 == null) goto L13;
        if (r102 == null) goto L13;
        if (r101.f472225c == false) goto L13;
        return r101;
    L7:
        r102 = null;
    L13:
        f.a(r110);
        if (f269592f.isEmpty() == false) goto L21;
        Iterator r103 = ((CopyOnWriteArrayList) f.f269593a).iterator();
    L17:
        if (r103.hasNext() == false) goto L21;
        h r104 = (h) r103.next();
        if (r104 == null) goto L17;
        r104.getSubscriberClassMap(f269592f);
    L21:
        Class<?> r105 = f269592f.get(r110);
        if (r105 == null) goto L58;
        CopyOnWriteArrayList<ed7.b> r106 = f269589c;
        monitor-enter(r106);
        int r107 = r106.size() - 1;     // Catch: Throwable -> L55
        ed7.b r108 = null;
    L26:
        if (r107 < 0) goto L52;
        CopyOnWriteArrayList<ed7.b> r109 = f269589c;     // Catch: Throwable -> L55
        if (r105.isAssignableFrom(r109.get(r107).f472227a.getClass()) == false) goto L51;
        r108 = r109.get(r107);     // Catch: Throwable -> L55
        if (r108 == null) goto L51;
        i r112 = tc7.a.b(r105);     // Catch: Throwable -> L55
        if (r112 == null) goto L51;
        Iterator<BridgeMethodInfo> r113 = r112.a().iterator();     // Catch: Throwable -> L55
    L35:
        if (r113.hasNext() == false) goto L51;
        BridgeMethodInfo r114 = r113.next();     // Catch: Throwable -> L55
        String r115 = r114.getBridgeMethodName();     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r115) == true) goto L49;
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r116 = f269587a;     // Catch: Throwable -> L55
        CopyOnWriteArrayList<ed7.a> r117 = r116.get(r115);     // Catch: Throwable -> L55
        if (r117 != null) goto L41;
        r117 = new CopyOnWriteArrayList();     // Catch: Throwable -> L55
        r116.put(r115, r117);     // Catch: Throwable -> L55
    L41:
        ed7.a r118 = b(r117, r111);     // Catch: Throwable -> L55
        if (r118 == null) goto L43;
        if (BridgeManager.INSTANCE.getBridgeConfig().isCompatiblePreLoadWebview().booleanValue() == false) goto L35;
        if (r118.f472225c == true) goto L35;
        r117.add(new ed7.a(r108.f472227a, r114, r108.f472228b));     // Catch: Throwable -> L55
        goto L35
    L43:
        r117.add(new ed7.a(r108.f472227a, r114, r108.f472228b));     // Catch: Throwable -> L55
        goto L35
    L49:
        Logger.f269563c.getClass();     // Catch: Throwable -> L55
        Logger.b();     // Catch: Throwable -> L55
        throw new IllegalArgumentException("Bridge method name cannot be empty！");     // Catch: Throwable -> L55
    L51:
        r107 = r107 - 1;     // Catch: Throwable -> L55
        goto L26
    L52:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L55
        monitor-exit(r106);
    L59:
        if (r108 != null) goto L95;
        CopyOnWriteArrayList<ed7.b> r120 = f269589c;
        monitor-enter(r120);
        int r121 = r120.size();     // Catch: Throwable -> L92
    L63:
        r121 = r121 - 1;     // Catch: Throwable -> L92
        if (r121 < 0) goto L89;
        i r122 = tc7.a.b(f269589c.get(r121).f472227a.getClass());     // Catch: Throwable -> L92
        if (r122 == null) goto L83;
        Iterator<BridgeMethodInfo> r123 = r122.a().iterator();     // Catch: Throwable -> L92
    L69:
        if (r123.hasNext() == false) goto L83;
        BridgeMethodInfo r124 = r123.next();     // Catch: Throwable -> L92
        String r125 = r124.getBridgeMethodName();     // Catch: Throwable -> L92
        if (TextUtils.equals(r125, r110) == false) goto L69;
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r126 = f269587a;     // Catch: Throwable -> L92
        CopyOnWriteArrayList<ed7.a> r127 = r126.get(r125);     // Catch: Throwable -> L92
        if (r127 != null) goto L75;
        r127 = new CopyOnWriteArrayList();     // Catch: Throwable -> L92
        r126.put(r125, r127);     // Catch: Throwable -> L92
    L75:
        ed7.a r128 = b(r127, r111);     // Catch: Throwable -> L92
        if (r128 == null) goto L77;
        if (BridgeManager.INSTANCE.getBridgeConfig().isCompatiblePreLoadWebview().booleanValue() == false) goto L69;
        if (r128.f472225c == true) goto L69;
        CopyOnWriteArrayList<ed7.b> r129 = f269589c;     // Catch: Throwable -> L92
        r127.add(new ed7.a(r129.get(r121).f472227a, r124, r129.get(r121).f472228b));     // Catch: Throwable -> L92
        goto L69
    L77:
        CopyOnWriteArrayList<ed7.b> r130 = f269589c;     // Catch: Throwable -> L92
        r127.add(new ed7.a(r130.get(r121).f472227a, r124, r130.get(r121).f472228b));     // Catch: Throwable -> L92
    L83:
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r131 = f269587a;     // Catch: Throwable -> L92
        if (r131.containsKey(r110) == false) goto L63;
        if (b(r131.get(r110), r111) == null) goto L63;
    L89:
        Unit r132 = Unit.INSTANCE;     // Catch: Throwable -> L92
        monitor-exit(r120);
    L92:
        th = move-exception;
        throw th;
    L95:
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r133 = f269587a;
        if (r133.containsKey(r110) == false) goto L111;
        ed7.a r134 = b(r133.get(r110), r111);
        if (r134 == null) goto L100;
        BridgeMethodInfo r135 = r134.f472224b;
    L101:
        if (r134 == null) goto L106;
        if (r135 == null) goto L106;
        if (r134.f472225c == false) goto L106;
        return r134;
    L106:
        Logger r136 = Logger.f269563c;
        StringBuilder r137 = new StringBuilder();
        r137.append(r110);
        r137.append(" not found, bridgeInfo:");
        r137.append(r134);
        r137.append(", methodInfo:");
        r137.append(r135);
        r137.append("}, isActive:");
        if (r134 == null) goto L109;
        Boolean r138 = Boolean.valueOf(r134.f472225c);
    L110:
        r137.append(r138);
        String r139 = r137.toString();
        r136.getClass();
        Logger.c(r139);
        goto L111
    L109:
        r138 = null;
        goto L110
    L100:
        r135 = null;
    L111:
        BridgeConfig r140 = BridgeManager.INSTANCE.getBridgeConfig();
        if (r140 == null) goto L114;
        Boolean r141 = r140.isDebug();
    L116:
        if ((!Intrinsics.areEqual(r141, Boolean.TRUE)) == true) goto L123;
        Iterator<T> r142 = r133.keySet().iterator();
    L120:
        if (r142.hasNext() == false) goto L122;
        String r143 = (String) r142.next();
        StringBuilder r144 = new StringBuilder();
        r144.append(r143);
        r144.append("\n");
        goto L120
    L122:
        Logger.f269563c.getClass();
        Logger.a();
    L123:
        Logger r145 = Logger.f269563c;
        String r146 = r110 + " not found, cmic:" + f269587a.size() + ", cbmc:" + f269589c.size() + ", mm:" + f269592f.size();
        r145.getClass();
        Logger.c(r146);
        return null;
    L114:
        r141 = null;
    L55:
        th = move-exception;
        throw th;
    L58:
        r108 = null;
        goto L59
    }

    public static Object[] e(BridgeMethodInfo r100, JSONObject r101, JsBridgeContext r110) {
        d[] r102 = r100.getParamInfos();
        Object[] r103 = new Object[r102.length];
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L115;
        d r106 = r102[r105];
        Object r107 = r106.f269585d;
        String r108 = r106.f269584c;
        int r109 = r106.f269582a;
        if (r109 != 0) goto L7;
        Class<?> r111 = r106.f269583b;
        if (Intrinsics.areEqual(r111, Integer.class) == true) goto L16;
        if (Intrinsics.areEqual(r111, Integer.TYPE) == true) goto L16;
        if (Intrinsics.areEqual(r111, Long.TYPE) == false) goto L42;
        if (r101 != null) goto L34;
        if (r107 == null) goto L33;
        long r112 = ((Long) r107).longValue();
    L38:
        r103[r105] = Long.valueOf(r112);
    L114:
        r105 = r105 + 1;
        goto L3
    L33:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    L34:
        String r113 = r101.optString(r108);
        if (r107 == null) goto L40;
        r112 = ((Long) r107).longValue();
        r112 = CastLongProtector.valueOf(r113).longValue();     // Catch: NumberFormatException -> L116
        goto L38
    L40:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    L42:
        if (Intrinsics.areEqual(r111, Boolean.TYPE) == false) goto L55;
        if (r101 == null) goto L49;
        if (r107 == null) goto L48;
        Boolean r114 = Boolean.valueOf(r101.optBoolean(r108, ((Boolean) r107).booleanValue()));
    L51:
        r103[r105] = r114;
        goto L114
    L48:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L49:
        if (r107 == null) goto L53;
        r114 = (Boolean) r107;
        goto L51
    L53:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L55:
        if (Intrinsics.areEqual(r111, String.class) == false) goto L70;
        if (r101 == null) goto L64;
        if (r107 == null) goto L63;
        String r115 = r101.optString(r108, (String) r107);
        if (r115 == null) goto L64;
    L66:
        r103[r105] = r115;
        goto L114
    L63:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L64:
        if (r107 == null) goto L68;
        r115 = (String) r107;
        goto L66
    L68:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L70:
        if (Intrinsics.areEqual(r111, Double.TYPE) == false) goto L82;
        if (r101 == null) goto L76;
        if (r107 == null) goto L75;
        Double r116 = Double.valueOf(r101.optDouble(r108, ((Double) r107).doubleValue()));
    L78:
        r103[r105] = r116;
        goto L114
    L75:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
    L76:
        if (r107 == null) goto L80;
        r116 = (Double) r107;
        goto L78
    L80:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
    L82:
        if (Intrinsics.areEqual(r111, Float.TYPE) == false) goto L94;
        if (r101 == null) goto L88;
        if (r107 == null) goto L87;
        Object r117 = Double.valueOf(r101.optDouble(r108, ((Double) r107).doubleValue()));
    L90:
        r103[r105] = r117;
        goto L114
    L87:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
    L88:
        if (r107 == null) goto L92;
        r117 = (Float) r107;
        goto L90
    L92:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    L94:
        if (Intrinsics.areEqual(r111, JSONObject.class) == false) goto L106;
        if (r101 != null) goto L98;
        JSONObject r118 = new JSONObject();
    L104:
        r103[r105] = r118;
        goto L114
    L98:
        if (Intrinsics.areEqual(r108, "__all_params__") == false) goto L119;
        r118 = r101;
        goto L104
    L119:
        r118 = r101.optJSONObject(r108);     // Catch: Exception -> L117
        if (r118 != null) goto L104;
    L103:
        r118 = new JSONObject();
        goto L104
    L106:
        if (Intrinsics.areEqual(r111, JSONArray.class) == false) goto L114;
        if (r101 != null) goto L121;
        JSONArray r119 = new JSONArray();
    L113:
        r103[r105] = r119;
        goto L114
    L121:
        r119 = r101.optJSONArray(r108);     // Catch: Exception -> L118
        if (r119 != null) goto L113;
    L112:
        r119 = new JSONArray();
    L16:
        if (r101 == null) goto L21;
        if (r107 == null) goto L20;
        Integer r120 = Integer.valueOf(r101.optInt(r108, ((Integer) r107).intValue()));
    L23:
        r103[r105] = r120;
        goto L114
    L20:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L21:
        if (r107 == null) goto L25;
        r120 = (Integer) r107;
        goto L23
    L25:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L7:
        if (r109 != 1) goto L114;
        r103[r105] = r110;
        goto L114
    L115:
        return r103;
    }

    public static BridgeResult f(ed7.a r100, JSONObject r101, JsBridgeContext r102) {
        Object[] r103 = e(r100.f472224b, r101, r102);     // Catch: Exception -> L4
        BridgeResult r104 = (BridgeResult) r100.f472224b.getMethod().invoke(r100.f472223a, Arrays.copyOf(r103, r103.length));     // Catch: Exception -> L4
        Logger r105 = Logger.f269563c;     // Catch: Exception -> L4
        r100.f472224b.getBridgeMethodName();     // Catch: Exception -> L4
        r105.getClass();     // Catch: Exception -> L4
        Logger.a();     // Catch: Exception -> L4
        return r104;
    L4:
        e = move-exception;
        e.printStackTrace();
        String r106 = Log.getStackTraceString(e);
        BridgeService r107 = f269590d;
        if (r107 == null) goto L12;
        r107.reportErrorInfo("BridgeRegistry", "runBridgeMethod = " + r106);
        return null;
    L12:
        return null;
    }
}
