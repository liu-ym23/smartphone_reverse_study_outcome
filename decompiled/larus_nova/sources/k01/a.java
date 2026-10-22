package k01;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import j01.b;
import j01.c;
import j01.d;
import j01.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements j01.a, b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bs2.a f501245a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public a(bs2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "traceService");
        this.f501245a = r100;
    }

    @Override // j01.a
    public final void monitor(c r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        j01.a.InterfaceC6375a r100 = r110.getMeta();
        if (r100 == null) goto L88;
        String r101 = r100.getEventName();
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        String r102 = r100.getBusinessType();
        if (r102 != null) goto L10;
        r102 = "revenue";
    L10:
        e r103 = new e(r101, r102);
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "metaBuilder");
        Intrinsics.checkNotNullParameter(r105, "category");
        Intrinsics.checkNotNullParameter(r106, "metric");
        Intrinsics.checkNotNullParameter(r104, "extra");
        String r107 = r100.getTraceId();
        if (r107 == null) goto L13;
        r103.h(r107);
    L13:
        String r108 = r100.getLogId();
        if (r108 == null) goto L16;
        r103.c(r108);
    L16:
        String r109 = r100.getProductId();
        if (r109 == null) goto L19;
        Intrinsics.checkNotNullParameter(r109, "idString");
        r103.f496788a.f522477e = r109;
    L19:
        String r111 = r100.getStep();
        if (r111 == null) goto L22;
        r103.g(r111);
    L22:
        String r112 = r100.getRoomId();
        if (r112 == null) goto L25;
        r103.e(r112);
    L25:
        String r113 = r100.getAnchorId();
        if (r113 == null) goto L28;
        r103.a(r113);
    L28:
        String r114 = r100.getUserId();
        if (r114 == null) goto L31;
        r103.i(r114);
    L31:
        r103.f(r100.getStatusCode());
        String r115 = r100.k6();
        if (r115 == null) goto L34;
        Intrinsics.checkNotNullParameter(r115, "msg");
        r103.f496788a.f522483k = r115;
    L34:
        Iterator<Map.Entry<String, String>> r116 = r100.getIndex().entrySet().iterator();
    L36:
        if (r116.hasNext() == false) goto L43;
        Map.Entry<String, String> r117 = r116.next();
        String r118 = r117.getKey();
        String r119 = r117.getValue();
        Intrinsics.checkNotNullParameter(r118, "key");
        o97.a r120 = r103.f496788a;
        if (r120.f522484l != null) goto L40;
        r120.f522484l = new LinkedHashMap();
        Unit r121 = Unit.INSTANCE;
    L40:
        Map<String, Object> r122 = r103.f496788a.f522484l;
        if (r122 == null) goto L36;
        r122.put(r118, r119);
        goto L36
    L43:
        JsonOrBytesJvm r123 = r110.getCategory();
        boolean r124 = false;
        if (r123 != null) goto L46;
    L48:
        boolean r125 = false;
    L49:
        JsonOrBytesJvm r126 = null;
        if (r125 == true) goto L54;
        r123 = null;
    L54:
        if (r123 == null) goto L59;
        Intrinsics.checkNotNullParameter(r105, "json");
        JsonObject r127 = r123.b().getAsJsonObject();
        Iterator<T> r128 = r127.keySet().iterator();
    L57:
        if (r128.hasNext() == false) goto L59;
        String r129 = (String) r128.next();
        JsonElement r130 = r127.get(r129);
        Intrinsics.checkNotNullParameter(r129, "key");
        Intrinsics.checkNotNullParameter(r130, "value");
        d.b(r105, r129, r130);
    L59:
        JsonOrBytesJvm r131 = r110.y6();
        if (r131 != null) goto L62;
    L64:
        boolean r132 = false;
    L65:
        if (r132 == true) goto L68;
        r131 = null;
    L68:
        if (r131 == null) goto L73;
        Intrinsics.checkNotNullParameter(r106, "json");
        JsonObject r133 = r131.b().getAsJsonObject();
        Iterator<T> r134 = r133.keySet().iterator();
    L71:
        if (r134.hasNext() == false) goto L73;
        String r135 = (String) r134.next();
        JsonElement r136 = r133.get(r135);
        Intrinsics.checkNotNullParameter(r135, "key");
        Intrinsics.checkNotNullParameter(r136, "value");
        d.b(r106, r135, r136);
    L73:
        JsonOrBytesJvm r137 = r110.getExtra();
        if (r137 != null) goto L76;
    L78:
        if (r124 == false) goto L80;
        r126 = r137;
    L80:
        if (r126 == null) goto L85;
        Intrinsics.checkNotNullParameter(r104, "json");
        JsonObject r138 = r126.b().getAsJsonObject();
        Iterator<T> r139 = r138.keySet().iterator();
    L83:
        if (r139.hasNext() == false) goto L85;
        String r140 = (String) r139.next();
        JsonElement r141 = r138.get(r140);
        Intrinsics.checkNotNullParameter(r140, "key");
        Intrinsics.checkNotNullParameter(r141, "value");
        d.b(r104, r140, r141);
    L85:
        ((b) f.a(b.class)).R4(r103.f496788a, r105, r106, r104);
        return;
    L76:
        if (r137.a() != true) goto L78;
        r124 = true;
        goto L78
    L62:
        if (r131.a() != true) goto L64;
        r132 = true;
        goto L65
    L46:
        if (r123.a() != true) goto L48;
        r125 = true;
        goto L49
    L88:
        throw new IllegalStateException("meta is null".toString());
    }

    @Override // j01.b
    public final void R4(o97.a r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "traceMeta");
        int r104 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r105 = com.bytedance.android.live.core.monitor.trace.e.b.a(r100.f522473a, r100.f522474b);
        String r106 = r100.f522475c;
        if (r106 == null) goto L5;
        r105.f65010a = r106;
    L5:
        String r107 = r100.f522476d;
        if (r107 == null) goto L8;
        r105.f65011b = r107;
    L8:
        String r108 = r100.f522477e;
        if (r108 == null) goto L11;
        r105.f65012c = r108;
    L11:
        String r109 = r100.f522478f;
        if (r109 == null) goto L14;
        r105.f65013d = r109;
    L14:
        String r110 = r100.f522479g;
        if (r110 == null) goto L17;
        r105.f65014e = r110;
    L17:
        String r111 = r100.f522480h;
        if (r111 == null) goto L20;
        r105.f65015f = r111;
    L20:
        String r112 = r100.f522481i;
        if (r112 == null) goto L23;
        r105.f65016g = r112;
    L23:
        Integer r113 = r100.f522482j;
        if (r113 == null) goto L26;
        r105.f65017h = r113;
    L26:
        String r114 = r100.f522483k;
        if (r114 == null) goto L29;
        r105.f65018i = r114;
    L29:
        Map<String, Object> r115 = r100.f522484l;
        if (r115 == null) goto L35;
        Iterator<Map.Entry<String, Object>> r116 = r115.entrySet().iterator();
    L33:
        if (r116.hasNext() == false) goto L35;
        Map.Entry<String, Object> r117 = r116.next();
        r105.b(r117.getKey(), r117.getValue());
    L35:
        this.f501245a.t2(r105.a(), r101, r102, r103);
    }
}
