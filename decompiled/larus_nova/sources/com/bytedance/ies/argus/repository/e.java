package com.bytedance.ies.argus.repository;

import com.bytedance.ies.argus.bean.ArgusContainerAspect;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.q;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.argus.bean.j f246116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ies.argus.bean.j f246117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ies.argus.bean.j f246118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f246119e;

    public static final class a {
        public static e a(String r110, JSONObject r111, JSONObject r112) {
            Intrinsics.checkNotNullParameter(r110, "secCId");
            if (r111 != null) goto L6;
            return null;
        L6:
            com.bytedance.ies.argus.bean.j.a r100 = new com.bytedance.ies.argus.bean.j.a();
            int r101 = r111.optInt("merge_mode");
            if (r101 <= 1) goto L9;
            int r102 = r101 + 1;
        L11:
            return new e(r110, b(r100, r111, r112, "aspect", Integer.valueOf(r102)), b(r100, r111, r112, "strategy_conf", Integer.valueOf(r101)), b(r100, r111, r112, CloudControlInf.PLUGIN, Integer.valueOf(r101)), b(r100, r111, r112, "common", Integer.valueOf(r101)));
        L9:
            r102 = r101;
            goto L11
        }

        public static final com.bytedance.ies.argus.bean.j b(com.bytedance.ies.argus.bean.j.a r100, JSONObject r101, JSONObject r102, String r103, Integer r104) {
            JSONObject r105 = r101.optJSONObject(r103);
            JSONObject r106 = null;
            if (r102 == null) goto L5;
            JSONObject r107 = r102.optJSONObject(r103);
        L7:
            if (r105 == null) goto L9;
            JSONObject r108 = r105.optJSONObject("conf");
        L10:
            if (r108 != null) goto L12;
            r108 = new JSONObject();
        L12:
            if (r107 == null) goto L14;
            r106 = r107.optJSONObject("conf");
        L14:
            if (r106 == null) goto L22;
            if (r104 != null) goto L18;
        L20:
            r108 = com.bytedance.ies.argus.bean.j.a.a(r108, r106, r104);
            goto L22
        L18:
            if (r104.intValue() != 0) goto L20;
        L22:
            return new com.bytedance.ies.argus.bean.j(r108);
        L9:
            r108 = null;
            goto L10
        L5:
            r107 = null;
            goto L7
        }
    }

    public e(String r100, com.bytedance.ies.argus.bean.j r101, com.bytedance.ies.argus.bean.j r110, com.bytedance.ies.argus.bean.j r111, com.bytedance.ies.argus.bean.j r112) {
        Intrinsics.checkNotNullParameter(r100, "secCId");
        Intrinsics.checkNotNullParameter(r101, "aspect");
        Intrinsics.checkNotNullParameter(r110, "strategyConf");
        Intrinsics.checkNotNullParameter(r111, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r112, "common");
        this.f246115a = r100;
        this.f246116b = r101;
        this.f246117c = r110;
        this.f246118d = r111;
        long r113 = System.currentTimeMillis();
        LinkedHashMap r102 = new LinkedHashMap();
        JSONObject r103 = r101.f246040a;
        t06.d r114 = null;
        if (r103 == null) goto L55;
        Iterator<String> r104 = r103.keys();
    L6:
        if (r104.hasNext() == false) goto L55;
        String r105 = r104.next();
        int r106 = q.f246041t1;
        q[] r107 = ArgusContainerAspect.values();
        int r108 = r107.length;
        int r109 = 0;
        int r115 = 0;
    L8:
        if (r115 >= r108) goto L13;
        q r116 = r107[r115];
        if (Intrinsics.areEqual(r116.getStringValue(), r105) == true) goto L14;
        r115 = r115 + 1;
    L14:
        if (r116 != null) goto L38;
        int r117 = q.f246041t1;
        q[] r118 = ArgusWebViewAspect.values();
        int r119 = r118.length;
        int r120 = 0;
    L16:
        if (r120 >= r119) goto L21;
        r116 = r118[r120];
        if (Intrinsics.areEqual(r116.getStringValue(), r105) == true) goto L22;
        r120 = r120 + 1;
    L22:
        if (r116 != null) goto L38;
        int r121 = q.f246041t1;
        q[] r122 = ArgusLynxViewAspect.values();
        int r123 = r122.length;
        int r124 = 0;
    L24:
        if (r124 >= r123) goto L29;
        r116 = r122[r124];
        if (Intrinsics.areEqual(r116.getStringValue(), r105) == true) goto L30;
        r124 = r124 + 1;
    L30:
        if (r116 != null) goto L38;
        int r125 = q.f246041t1;
        q[] r126 = ArgusGlobalAspect.values();
        int r127 = r126.length;
    L32:
        if (r109 >= r127) goto L37;
        r116 = r126[r109];
        if (Intrinsics.areEqual(r116.getStringValue(), r105) == true) goto L38;
        r109 = r109 + 1;
        goto L32
    L37:
        r116 = null;
        goto L38
    L29:
        r116 = null;
        goto L30
    L21:
        r116 = null;
    L38:
        if (r116 == null) goto L39;
        JSONObject r128 = this.f246116b.f246040a.optJSONObject(r105);
        if (r128 == null) goto L6;
        Intrinsics.checkNotNullParameter(r128, "data");
        Lazy r129 = ArgusGsonUtils.f246245a;
        AspectConfigItem r130 = (AspectConfigItem) ArgusGsonUtils.c(r128, AspectConfigItem.class);
        if (r130 == null) goto L53;
        Map<String, AspectConfigItem.a> r131 = r130.b();
        if (r131 == null) goto L53;
        int r132 = r130.c();
        Iterator<Map.Entry<String, AspectConfigItem.a>> r133 = r131.entrySet().iterator();
    L48:
        if (r133.hasNext() == false) goto L52;
        Map.Entry<String, AspectConfigItem.a> r134 = r133.next();
        String r135 = r134.getKey();
        AspectConfigItem.a r136 = r134.getValue();
        r136.f245984a = r135;
        if (r136.d() != null) goto L48;
        r136.f(Integer.valueOf(r132));
        goto L48
    L52:
        List<AspectConfigItem.a> r137 = CollectionsKt.toList(CollectionsKt.sortedWith(r131.values(), new com.bytedance.ies.argus.bean.h()));
        Intrinsics.checkNotNullParameter(r137, "<set-?>");
        r130.f245982a = r137;
    L53:
        if (r130 == null) goto L6;
        r102.put(r116, r130);
        goto L6
    L39:
        int r138 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.b("ContainerConfigProvider", "aspect type not found: " + r105, null, 12);
        goto L6
    L13:
        r116 = null;
    L55:
        JSONObject r139 = this.f246117c.f246040a;
        if (r139 == null) goto L58;
        Lazy r140 = ArgusGsonUtils.f246245a;
        r114 = (t06.d) ArgusGsonUtils.c(r139, t06.d.class);
    L58:
        this.f246119e = new d(MapsKt.toMap(r102), r114);
        long r141 = System.currentTimeMillis() - r113;
        int r142 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("ArgusContainerConfigProvider", "finish update container config cid=" + this.f246115a + ", cost: " + r141);
    }
}
