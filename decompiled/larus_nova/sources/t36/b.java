package t36;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.schema.SchemaMonitorEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544440a;

    public static final class a {
    }

    /* JADX INFO: renamed from: t36.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C7682b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f544441a = null;

        static {
            int[] r100 = new int[SchemaMonitorEvent.values().length];
            r100[SchemaMonitorEvent.CONVERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SchemaMonitorEvent.GENERATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f544441a = r100;
        }
    }

    static {
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.f544440a = r100;
    }

    @Override // t36.g
    public final void log(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ExecutorService r101 = BulletLogger.f247763a;
        BulletLogger.j(r100, LogLevel.I, "XSchema");
    }

    @Override // t36.g
    public final void a(SchemaMonitorEvent r110, d r111, Map<String, String> r112, Map<String, String> r113, Map<String, Long> r210) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, "schemaData");
        Intrinsics.checkNotNullParameter(r112, "info");
        int r100 = C7682b.f544441a[r110.ordinal()];
        boolean r101 = true;
        if (r100 == 1) goto L8;
        if (r100 != 2) goto L7;
        String r102 = "bdx_monitor_schema_generate";
    L9:
        s26.d r103 = s26.d.f540305c;
        r r114 = (r) s26.d.f540305c.d(this.f544440a, r.class);
        if (r114 == null) goto L36;
        c1 r115 = new c1(r102, null, null, null, null, 254);
        r115.f247792b = r111.getOriginUrl().toString();
        String r104 = r111.getHost();
        if (r104 != null) goto L14;
    L16:
        r101 = false;
    L17:
        if (r101 == false) goto L19;
        String r105 = "web";
    L20:
        r115.f247793c = r105;
        JSONObject r106 = new JSONObject();
        Iterator<Map.Entry<String, String>> r107 = r112.entrySet().iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        Map.Entry<String, String> r108 = r107.next();
        r106.put(r108.getKey(), r108.getValue());
        goto L22
    L24:
        if (r113 == null) goto L29;
        Iterator<Map.Entry<String, String>> r109 = r113.entrySet().iterator();
    L27:
        if (r109.hasNext() == false) goto L29;
        Map.Entry<String, String> r116 = r109.next();
        r106.put(r116.getKey(), r116.getValue());
    L29:
        r115.f247794d = r106;
        JSONObject r117 = new JSONObject();
        if (r210 == null) goto L35;
        Iterator<Map.Entry<String, Long>> r118 = r210.entrySet().iterator();
    L33:
        if (r118.hasNext() == false) goto L35;
        Map.Entry<String, Long> r119 = r118.next();
        r117.put(r119.getKey(), r119.getValue().longValue());
    L35:
        r115.f247795e = r117;
        r114.S(r115);
        goto L36
    L19:
        r105 = "lynx";
        goto L20
    L14:
        if (StringsKt.contains$default(r104, "webview", false, 2, null) != true) goto L16;
    L36:
        StringBuilder r120 = new StringBuilder(r102);
        r120.append('{');
        if (r113 == null) goto L42;
        Iterator<Map.Entry<String, String>> r121 = r113.entrySet().iterator();
    L40:
        if (r121.hasNext() == false) goto L42;
        Map.Entry<String, String> r122 = r121.next();
        r120.append(r122.getKey());
        r120.append(':');
        r120.append(r122.getValue());
        r120.append(';');
    L42:
        if (r210 == null) goto L47;
        Iterator<Map.Entry<String, Long>> r123 = r210.entrySet().iterator();
    L45:
        if (r123.hasNext() == false) goto L47;
        Map.Entry<String, Long> r124 = r123.next();
        r120.append(r124.getKey());
        r120.append(':');
        r120.append(r124.getValue().longValue());
        r120.append(';');
    L47:
        r120.append('}');
        log(r120.toString());
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r102 = "bdx_monitor_schema_convert";
        goto L9
    }
}
