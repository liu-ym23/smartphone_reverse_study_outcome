package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import b8a.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements com.bytedance.lynx.service.reporter.performance.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Object> f264927a;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final void onInitialize(Context r100) {
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final Map<String, Object> a(l r110) {
        Intrinsics.checkNotNullParameter(r110, "entry");
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = r110.f18215b;
        if (Intrinsics.areEqual(r101, "pipeline") == false) goto L61;
        String r102 = r110.f18214a;
        int r103 = r102.hashCode();
        if (r103 == (-701686520)) goto L18;
        if (r103 == 521646652) goto L15;
        if (r103 == 1904924252) goto L12;
    L21:
        r100 = new LinkedHashMap();
        Number r104 = null;
        r100.putAll(e.c(r110.f18217d, null));
        LinkedHashMap r105 = new LinkedHashMap();
        HashMap<String, Object> r111 = r110.f18217d;
        Object r106 = r111.get("frameworkRenderingTiming");
        if ((r106 instanceof Map) == false) goto L24;
        Map r107 = (Map) r106;
    L25:
        if (r107 == null) goto L27;
        Object r108 = r107.get("packChangesEnd");
    L29:
        if ((r108 instanceof Number) == false) goto L31;
        Number r109 = (Number) r108;
    L32:
        Object r112 = r111.get("mtsRenderStart");
        if ((r112 instanceof Number) == false) goto L35;
        Number r113 = (Number) r112;
    L36:
        Object r114 = r111.get("pipelineStart");
        if ((r114 instanceof Number) == false) goto L39;
        Number r115 = (Number) r114;
    L40:
        Object r116 = r111.get("layoutUiOperationExecuteEnd");
        if ((r116 instanceof Number) == false) goto L43;
        Number r117 = (Number) r116;
    L44:
        Object r118 = r111.get("paintEnd");
        if ((r118 instanceof Number) == false) goto L47;
        Number r119 = (Number) r118;
    L48:
        HashMap<String, Object> r120 = this.f264927a;
        if (r120 == null) goto L51;
        Object r121 = r120.get("paintEnd");
    L53:
        if ((r121 instanceof Number) == false) goto L55;
        r104 = (Number) r121;
    L55:
        r105.put("updateWaiting", e.a(r104, r115));
        r105.put("paintWaiting", e.a(r117, r119));
        r105.put("triggerWaiting", e.a(r115, r113));
        r105.put("mtsRenderScheduleWaiting", e.a(r109, r113));
        Object r122 = r111.get("paintEnd");
        if (r122 == null) goto L59;
        r105.put("paintEnd", (Number) r122);
        r100.putAll(r105);
    L79:
        return r100;
    L59:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
    L51:
        r121 = null;
        goto L53
    L47:
        r119 = null;
        goto L48
    L43:
        r117 = null;
        goto L44
    L39:
        r115 = null;
        goto L40
    L35:
        r113 = null;
        goto L36
    L31:
        r109 = null;
        goto L32
    L27:
        r108 = null;
        goto L29
    L24:
        r107 = null;
        goto L25
    L12:
        if (r102.equals("reloadBundleFromBts") == false) goto L21;
    L20:
        this.f264927a = r110.f18217d;
        goto L21
    L15:
        if (r102.equals("reloadBundleFromNative") == false) goto L21;
    L18:
        if (r102.equals("loadBundle") == true) goto L20;
    L61:
        if (Intrinsics.areEqual(r101, "metric") == false) goto L79;
        r100 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r123 = r110.f18217d.entrySet().iterator();
    L64:
        if (r123.hasNext() == false) goto L79;
        Map.Entry<String, Object> r124 = r123.next();
        String r125 = r124.getKey();
        Object r126 = r124.getValue();
        if (r125 == null) goto L78;
        if ((r126 instanceof HashMap) == false) goto L78;
        Map r127 = (Map) r126;
        Object r128 = r127.get("duration");
        if (r128 == null) goto L72;
        r100.put(r125, r128);
    L72:
        Object r129 = r127.get("startTimestampName");
        if (r129 == null) goto L75;
        r100.put(r125.concat("StartTimestampName"), r129);
    L75:
        Object r130 = r127.get("endTimestampName");
        if (r130 == null) goto L64;
        r100.put(r125.concat("EndTimestampName"), r130);
    L78:
        r100.put(r125, r126);
        goto L64
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final boolean b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        if (r100.f18216c == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f18215b, "pipeline") == false) goto L7;
    L8:
        return true;
    L7:
        if (Intrinsics.areEqual(r100.f18215b, "metric") == false) goto L9;
        goto L8
    }
}
