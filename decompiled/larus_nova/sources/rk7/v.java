package rk7;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y f538396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f538397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, SharedPreferences> f538398c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Long> f538399d = null;

    static {
        LinkedHashSet r100 = new LinkedHashSet();
        r100.add("web_x_prefetch_config");
        r100.add("luckycat_container_local_storage");
        r100.add("luckydog_sdk_config.prefs");
        r100.add("luckycat_product_configs.prefs");
        r100.add("token_union_sdk_config.prefs");
        r100.add("luckydog_cross_over_guide");
        r100.add("luckydog_tab_prefs");
        r100.add("luckydog_task_union.prefs");
        r100.add("luckydog_debug_local_config");
        r100.add("luckydog_task_full_path_config");
        r100.add("action_task_prefs_config");
        f538398c = new ConcurrentHashMap();
        f538399d = new ConcurrentHashMap();
    }

    public static SharedPreferences a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return null;
    L12:
        ConcurrentHashMap r102 = (ConcurrentHashMap) f538398c;
        if (r102.containsKey(r100) == true) goto L15;
        Context r103 = m.f538361o.e();
        if (r103 != null) goto L19;
        return null;
    L19:
        SharedPreferences r104 = r103.getSharedPreferences(r100, 0);
        if (r104 == null) goto L22;
        r102.put(r100, r104);
    L22:
        return r104;
    L15:
        return (SharedPreferences) r102.get(r100);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }

    public static void b(x r110) {
        if (r110.f538402a == null) goto L5;
        return;
    L5:
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        List<String> r101 = r110.b();
        if (r101 == null) goto L17;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L17;
        w r103 = new w((String) r102.next());
        if (r103.a() == false) goto L9;
        SharedPreferences r104 = a(r103.f538400a);
        if (r104 == null) goto L9;
        if (r104.contains(r103.f538401b) != true) goto L9;
        r100.put(r103.f538400a + '.' + r103.f538401b, r103);
    L17:
        List<String> r105 = r110.a();
        if (r105 == null) goto L42;
        Iterator<T> r106 = r105.iterator();
    L21:
        if (r106.hasNext() == false) goto L42;
        w r107 = new w((String) r106.next());
        if (r107.a() == false) goto L21;
        SharedPreferences r108 = a(r107.f538400a);
        if (r108 == null) goto L29;
        Map<String, ?> r109 = r108.getAll();
        if (r109 == null) goto L29;
        Set<String> r111 = r109.keySet();
    L30:
        if (r111 == null) goto L21;
        Iterator<T> r112 = r111.iterator();
    L33:
        if (r112.hasNext() == false) goto L21;
        String r113 = (String) r112.next();
        String r114 = r107.f538401b;
        if (r114 == null) goto L33;
        if (StringsKt.contains$default(r113, r114, false, 2, null) == false) goto L33;
        String r115 = r107.f538400a + '.' + r113;
        if (r100.containsKey(r115) == true) goto L33;
        r100.put(r115, new w(r115));
    L29:
        r111 = null;
    L42:
        r110.f538402a = r100;
    }

    public static boolean c(String r100, String r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L57;
        if (r101 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L57;
        y r104 = f538396a;
        if (r104 != null) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r104.a(), Boolean.FALSE) == false) goto L24;
        return false;
    L24:
        y r105 = f538396a;
        if (r105 == null) goto L35;
        a0 r106 = r105.b();
        if (r106 == null) goto L35;
        x r107 = r106.c();
        if (r107 == null) goto L35;
        b(r107);
        Map<String, w> r108 = r107.f538402a;
        if (r108 == null) goto L35;
        if (r108.containsKey(r100 + '.' + r101) != true) goto L35;
        return true;
    L35:
        y r109 = f538396a;
        if (r109 == null) goto L46;
        a0 r110 = r109.b();
        if (r110 == null) goto L46;
        x r111 = r110.b();
        if (r111 == null) goto L46;
        b(r111);
        Map<String, w> r112 = r111.f538402a;
        if (r112 == null) goto L46;
        if (r112.containsKey(r100 + '.' + r101) != true) goto L46;
        return true;
    L46:
        y r113 = f538396a;
        if (r113 == null) goto L57;
        a0 r114 = r113.b();
        if (r114 == null) goto L57;
        x r115 = r114.a();
        if (r115 == null) goto L57;
        b(r115);
        Map<String, w> r116 = r115.f538402a;
        if (r116 == null) goto L57;
        if (r116.containsKey(r100 + '.' + r101) != true) goto L57;
        return true;
    L12:
        if (StringsKt.isBlank(r101) == true) goto L15;
        r103 = false;
    L57:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }
}
