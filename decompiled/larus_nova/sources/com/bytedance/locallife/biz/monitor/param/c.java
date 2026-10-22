package com.bytedance.locallife.biz.monitor.param;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f256721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f256722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f256723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f256724d;

    public c(List r100, List r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "reportKeyParamList");
        Intrinsics.checkNotNullParameter(r101, "ignoreCheckKeyList");
        Intrinsics.checkNotNullParameter(r102, "recursiveCheckKeys");
        this.f256721a = r100;
        this.f256722b = r101;
        this.f256723c = r102;
        this.f256724d = true;
    }

    public final List<Conflict> a(Map<String, ? extends Object> r100, Map<String, ? extends Object> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "map1");
        Intrinsics.checkNotNullParameter(r110, "map2");
        ArrayList r101 = new ArrayList();
        if (r111 == false) goto L5;
        List<String> r112 = this.f256723c;
    L6:
        b(r112, r100, r110, "", r101, 0);
        return r101;
    L5:
        r112 = CollectionsKt.emptyList();
        goto L6
    }

    public final void b(List r110, Map r111, Map r210, String r211, List r212, int r213) {
        if (r213 <= 3) goto L5;
        return;
    L5:
        Iterator r112 = CollectionsKt.intersect(r111.keySet(), r210.keySet()).iterator();
    L7:
        if (r112.hasNext() == false) goto L80;
        String r113 = (String) r112.next();
        Object r114 = r111.get(r113);
        Object r115 = r210.get(r113);
        if (r211.length() != 0) goto L11;
        boolean r100 = true;
    L12:
        char r101 = '.';
        if (r100 == false) goto L15;
        String r102 = r113;
    L17:
        if (r110.contains(r113) == false) goto L60;
        if ((r114 instanceof Map) == false) goto L34;
        if ((r115 instanceof Map) == false) goto L34;
        Map r116 = (Map) r114;
        Map r117 = (Map) r115;
        Iterator r103 = CollectionsKt.intersect(r116.keySet(), r117.keySet()).iterator();
    L24:
        if (r103.hasNext() == false) goto L7;
        String r104 = (String) r103.next();
        Object r105 = r116.get(r104);
        Object r106 = r117.get(r104);
        String r118 = r102 + r101 + r104;
        if (Intrinsics.areEqual(r105, r106) == true) goto L32;
        if (this.f256721a.contains(r104) == false) goto L30;
    L31:
        ((ArrayList) r212).add(new Conflict(r118, r105, r106));
        goto L32
    L30:
        if (this.f256721a.isEmpty() == true) goto L31;
    L32:
        r101 = '.';
    L34:
        if ((r114 instanceof String) == true) goto L36;
    L50:
        Iterator r119 = r112;
        String r120 = r102;
        if (this.f256724d == false) goto L56;
        if (Intrinsics.areEqual(String.valueOf(r114), String.valueOf(r115)) == false) goto L56;
    L79:
        r112 = r119;
    L56:
        if (this.f256721a.contains(r113) == false) goto L58;
    L59:
        ((ArrayList) r212).add(new Conflict(r120, r114, r115));
        goto L79
    L58:
        if (this.f256721a.isEmpty() == false) goto L79;
    L36:
        if ((r115 instanceof String) == false) goto L50;
        Gson r107 = com.bytedance.locallife.biz.common.utils.b.f256637a;     // Catch: Exception -> L43
        r119 = r112;
        b(CollectionsKt.emptyList(), com.bytedance.locallife.biz.common.utils.b.b(new JSONObject((String) r114)), com.bytedance.locallife.biz.common.utils.b.b(new JSONObject((String) r115)), r102, r212, r213 + 1);     // Catch: Exception -> L41
    L41:
        e = e;
    L45:
        com.bytedance.locallife.biz.common.utils.c.c("LifePageParamTrace", "MapConflictDetector detectConflictsRecursive error keyPath=" + r102, e);
        if (this.f256721a.contains(r113) == false) goto L48;
    L49:
        ((ArrayList) r212).add(new Conflict(r102, r114, r115));
        goto L79
    L48:
        if (this.f256721a.isEmpty() == false) goto L79;
    L43:
        e = e;
        r119 = r112;
        goto L45
    L60:
        r119 = r112;
        String r121 = r102;
        if ((r114 instanceof Map) == false) goto L66;
        if ((r115 instanceof Map) == false) goto L66;
        b(CollectionsKt.emptyList(), (Map) r114, (Map) r115, r121, r212, r213 + 1);
    L66:
        if (Intrinsics.areEqual(r114, r115) == true) goto L79;
        if (this.f256724d == false) goto L72;
        if (Intrinsics.areEqual(String.valueOf(r114), String.valueOf(r115)) == true) goto L79;
    L72:
        if (this.f256722b.contains(r113) == true) goto L79;
        if (this.f256721a.contains(r113) == false) goto L77;
    L78:
        ((ArrayList) r212).add(new Conflict(r121, r114, r115));
        goto L79
    L77:
        if (this.f256721a.isEmpty() == false) goto L79;
    L15:
        r102 = r211 + '.' + r113;
        goto L17
    L11:
        r100 = false;
        goto L12
    }
}
