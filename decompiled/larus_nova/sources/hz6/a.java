package hz6;

import com.bytedance.locallife.biz.fmp.PoiChainDurationMonitor;
import com.bytedance.locallife.biz.utils.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f487703a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<String> f487704b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, PoiChainDurationMonitor> f487705c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, nn6.a> f487706d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, HashMap<String, String>> f487707e = null;

    public a() {
    }

    static {
        f487703a = new a();
        f487704b = new ThreadLocal();
        f487705c = new LinkedHashMap();
        f487706d = new LinkedHashMap();
        f487707e = new LinkedHashMap();
    }

    public static void a() {
        Map<String, PoiChainDurationMonitor> r100 = f487705c;
        String r101 = b();
        if (r100 == null) goto L15;
        TypeIntrinsics.asMutableMap(r100).remove(r101);
        Map<String, nn6.a> r102 = f487706d;
        String r103 = b();
        if (r102 == null) goto L13;
        TypeIntrinsics.asMutableMap(r102).remove(r103);
        Map<String, HashMap<String, String>> r104 = f487707e;
        String r105 = b();
        if (r104 == null) goto L11;
        TypeIntrinsics.asMutableMap(r104).remove(r105);
        f487704b.remove();
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public static String b() {
        return f487704b.get();
    }

    public static void c(PoiChainDurationMonitor r110, nn6.a r111) {
        boolean r100 = false;
        if (r111 == null) goto L9;
        Map<String, String> r101 = r111.f519664c;
        if (r101 == null) goto L9;
        if (((HashMap) r101).containsKey("req_total") != true) goto L9;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L16;
        String r103 = (String) ((HashMap) r111.f519664c).get("req_total");
        if (r103 == null) goto L16;
        String r104 = r103;
    L18:
        if (r111 == null) goto L24;
        Map<String, String> r105 = r111.f519664c;
        if (r105 == null) goto L24;
        if (((HashMap) r105).containsKey("response_content_length") != true) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L30;
        String r107 = (String) ((HashMap) r111.f519664c).get("response_content_length");
        if (r107 == null) goto L30;
        String r108 = r107;
    L32:
        if (r111 == null) goto L38;
        Map<String, String> r109 = r111.f519664c;
        if (r109 == null) goto L38;
        if (((HashMap) r109).containsKey("before_req") != true) goto L38;
        boolean r112 = true;
    L39:
        if (r112 == false) goto L44;
        String r113 = (String) ((HashMap) r111.f519664c).get("before_req");
        if (r113 == null) goto L44;
        String r114 = r113;
    L46:
        if (r111 == null) goto L52;
        Map<String, String> r115 = r111.f519664c;
        if (r115 == null) goto L52;
        if (((HashMap) r115).containsKey("after_req") != true) goto L52;
        r100 = true;
    L52:
        if (r100 == false) goto L57;
        String r116 = (String) ((HashMap) r111.f519664c).get("after_req");
        if (r116 == null) goto L57;
        String r117 = r116;
    L58:
        int r118 = c.f256986a;
        Map<String, HashMap<String, String>> r119 = f487707e;
        LinkedHashMap r120 = (LinkedHashMap) r119;
        HashMap r121 = (HashMap) r120.get(b());
        Intrinsics.checkNotNullParameter(r110, "durationMonitor");
        Intrinsics.checkNotNullParameter(r104, "requestNetworkDuration");
        Intrinsics.checkNotNullParameter(r108, "totalReceivedBytes");
        Intrinsics.checkNotNullParameter(r114, "beforeNetworkDuration");
        Intrinsics.checkNotNullParameter(r117, "afterNetworkDuration");
        c.k(r110, r104, r108, r114, r117, r121, null);
        a();
        return;
    L57:
        r117 = "";
    L44:
        r114 = "";
    L38:
        r112 = false;
    L30:
        r108 = "";
    L24:
        r106 = false;
    L16:
        r104 = "";
    L9:
        r102 = false;
        goto L11
    }
}
