package com.bytedance.badger.y;

import com.bytedance.badger.data.EventReportEnum;
import com.bytedance.badger.utils.m;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f199442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f199443b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f199444c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f199445d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f199446e = null;

    static {
        f199446e = new g();
        f199442a = CollectionsKt.listOf(new Integer[]{4001, 4002, 4003, 4004, 4005, 4006, 4007, 4008, 4009, 4010, 4011, 4012});
        f199443b = new Object();
        f199444c = new LinkedHashMap();
        f199445d = new LinkedHashMap();
    }

    public g() {
    }

    public static Map g(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = r100.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L9
        r101.put((String) r103.getKey(), f(r103.getValue(), 0));     // Catch: Throwable -> L9
        goto L5
    L8:
        return r101;
    L9:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "snapshotValues failed: " + th.getMessage());
        return MapsKt.emptyMap();
    }

    public final List b(List r100, int r101) {
        if (r101 <= 20) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        if (r104 == null) goto L10;
        Object r105 = a(r104, r101 + 1);
        if (r105 == null) goto L7;
        r102.add(r105);
        goto L7
    L10:
        r102.add(null);
        goto L7
    L14:
        return r102;
    }

    public final Map c(Map r100, int r101) {
        if (r101 <= 20) goto L5;
        return null;
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r100.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L28;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getKey();
        Object r106 = r104.getValue();
        if ((r105 instanceof String) == true) goto L11;
        r105 = null;
    L11:
        String r107 = (String) r105;
        if (r107 == null) goto L7;
        String r108 = StringsKt.trim(r107).toString();
        if (r108 == null) goto L7;
        if (r108.length() != 0) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == true) goto L7;
        if (r108.length() > 128) goto L7;
        if (r106 == null) goto L24;
        Object r110 = a(r106, 1 + r101);
        if (r110 == null) goto L7;
        r102.put(r108, r110);
        goto L7
    L24:
        r102.put(r108, null);
        goto L7
    L18:
        r109 = false;
        goto L19
    L28:
        return r102;
    }

    public static JSONArray d(EventReportEnum r100) {
        JSONArray r101 = new JSONArray();
        Object r102 = f199443b;
        monitor-enter(r102);
        ArrayDeque r103 = (ArrayDeque) f199444c.get(r100);     // Catch: Throwable -> L45
        if (r103 == null) goto L8;
        List r104 = CollectionsKt.toList(r103);     // Catch: Throwable -> L45
    L9:
        monitor-exit(r102);
        if (r104 != null) goto L13;
        r104 = CollectionsKt.emptyList();
    L13:
        Iterator r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L44;
        b r106 = (b) r105.next();
        JSONObject r107 = new JSONObject();
        r107.put("key", r106.f199434a);
        Object r108 = r106.f199435b;
        if (r108 != null) goto L20;
        r107.put("value", JSONObject.NULL);
    L43:
        r107.put("create_time", r106.f199436c);
        r101.put(r107);
        goto L15
    L20:
        if ((r108 instanceof JSONObject) == false) goto L23;
    L42:
        r107.put("value", r108);
        goto L43
    L23:
        if ((r108 instanceof JSONArray) == true) goto L42;
        if ((r108 instanceof Map) == false) goto L30;
        Object r109 = new JSONObject((Map) r108);
    L28:
        r108 = r109;
        goto L42
    L30:
        if ((r108 instanceof List) == false) goto L33;
        r109 = new JSONArray((Collection) r108);
        goto L28
    L33:
        if ((r108 instanceof Boolean) == true) goto L42;
        if ((r108 instanceof Number) == true) goto L42;
        if ((r108 instanceof String) == true) goto L42;
        r108 = r108.toString();
        goto L42
    L44:
        return r101;
    L8:
        r104 = null;
    L45:
        th = move-exception;
        throw th;
    }

    public static JSONObject h(EventReportEnum r100) {
        JSONArray r101 = d(r100);
        Object r102 = f199443b;
        monitor-enter(r102);
        a r103 = (a) f199445d.get(r100);     // Catch: Throwable -> L15
        monitor-exit(r102);
        JSONObject r104 = new JSONObject();
        r104.putOpt("value", r101);
        long r105 = 0;
        if (r103 == null) goto L9;
        long r106 = Long.valueOf(r103.f199432a);
    L10:
        r104.putOpt("create_time", r106);
        if (r103 == null) goto L13;
        r105 = r103.f199433b;
    L13:
        r104.putOpt("update_time", Long.valueOf(r105));
        return r104;
    L9:
        r106 = 0L;
    L15:
        th = move-exception;
        throw th;
    }

    public static void e(EventReportEnum r100, Map r101) {
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.f r102 = com.bytedance.badger.v.d.W;
        KProperty r103 = com.bytedance.badger.v.d.f199311a[49];
        if (((Boolean) r102.a()).booleanValue() == true) goto L14;
        return;
    L14:
        Map r104 = g(r101);     // Catch: Throwable -> L7
    L16:
        m.a().b(new e(r100, r104));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        com.bytedance.badger.e.c("event_behavior# ", "record failed: " + th.getMessage(), th);
        return;
    L7:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "record ignored: snapshot failed: " + th.getMessage());
        r104 = MapsKt.emptyMap();
        goto L16
    }

    public static Object f(Object r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r101 <= 20) goto L9;
        return null;
    L9:
        if ((r100 instanceof Boolean) == true) goto L55;
        if ((r100 instanceof Number) == true) goto L55;
        if ((r100 instanceof String) == true) goto L55;
        if ((r100 instanceof JSONObject) == true) goto L55;
        if ((r100 instanceof JSONArray) == true) goto L55;
        if ((r100 instanceof Map) == false) goto L44;
        Map r102 = (Map) r100;
        int r103 = r101 + 1;
        if (r103 > 20) goto L42;
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r102.entrySet().iterator();     // Catch: Throwable -> L40
    L31:
        if (r105.hasNext() == false) goto L39;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L40
        Object r107 = r106.getKey();     // Catch: Throwable -> L40
        Object r108 = r106.getValue();     // Catch: Throwable -> L40
        if ((r107 instanceof String) == true) goto L35;
        r107 = null;
    L35:
        String r109 = (String) r107;     // Catch: Throwable -> L40
        if (r109 == null) goto L31;
        r104.put(r109, f(r108, r103 + 1));     // Catch: Throwable -> L40
        goto L31
    L39:
        r100 = r104;
    L40:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "snapshotMap failed: " + th.getMessage());
    L42:
        r100 = null;
        goto L55
    L44:
        if ((r100 instanceof List) == false) goto L55;
        List r110 = (List) r100;
        int r111 = r101 + 1;
        if (r111 > 20) goto L71;
        int r112 = r110.size();     // Catch: Throwable -> L57
        ArrayList r113 = new ArrayList(r112);
        int r114 = 0;
    L50:
        if (r114 >= r112) goto L70;
        r113.add(f(r110.get(r114), r111 + 1));
        r114 = r114 + 1;
    L70:
        return r113;
    L72:
        return null;
    L71:
        return null;
    L55:
        return r100;
    }

    public final Object a(Object r100, int r101) {
        if (r101 <= 20) goto L6;
        return null;
    L6:
        if ((r100 instanceof Boolean) == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof Number) == false) goto L12;
        return r100;
    L12:
        if ((r100 instanceof String) == false) goto L15;
        return r100;
    L15:
        if ((r100 instanceof JSONObject) == false) goto L22;
        JSONObject r102 = (JSONObject) r100;
        Map r103 = new LinkedHashMap();
        Iterator<String> r104 = r102.keys();
    L18:
        if (r104.hasNext() == false) goto L37;
        String r105 = r104.next();
        r103.put(r105, r102.opt(r105));
        goto L18
    L37:
        return c(r103, r101 + 1);
    L22:
        if ((r100 instanceof JSONArray) == false) goto L28;
        JSONArray r106 = (JSONArray) r100;
        ArrayList r107 = new ArrayList();
        int r108 = r106.length();
        int r109 = 0;
    L24:
        if (r109 >= r108) goto L38;
        r107.add(r106.opt(r109));
        r109 = r109 + 1;
        goto L24
    L38:
        return b(r107, r101 + 1);
    L28:
        if ((r100 instanceof Map) == false) goto L31;
        return c((Map) r100, r101 + 1);
    L31:
        if ((r100 instanceof List) == false) goto L34;
        return b((List) r100, r101 + 1);
    L34:
        return null;
    }
}
