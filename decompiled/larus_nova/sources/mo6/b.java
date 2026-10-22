package mo6;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.locallife.biz.btm.ErrorUploader;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import g66.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ko6.d0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514593a = 0;

    static {
    }

    public static JSONObject b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L41;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();     // Catch: Exception -> L39
        if ((r105 instanceof Long) == true) goto L8;
        if ((r105 instanceof Float) == true) goto L11;
        if ((r105 instanceof Integer) == true) goto L14;
        if ((r105 instanceof Double) == true) goto L17;
        if ((r105 instanceof String) == true) goto L20;
        if ((r105 instanceof Boolean) == true) goto L23;
        if ((r105 instanceof JSONObject) == true) goto L26;
        if ((r105 instanceof JSONArray) == true) goto L29;
        if ((r105 instanceof Map) == true) goto L32;
        if ((r105 instanceof List) == true) goto L35;
        if (r105 != null) goto L4;
        r101.put(r104, JSONObject.NULL);     // Catch: Exception -> L39
        goto L4
    L35:
        r101.put(r104, ConvertUtils.listToJSON$default(ConvertUtils.INSTANCE, (List) r105, 0, 2, null));     // Catch: Exception -> L39
        goto L4
    L32:
        r101.put(r104, b((Map) r105));     // Catch: Exception -> L39
        goto L4
    L29:
        r101.put(r104, r105);     // Catch: Exception -> L39
        goto L4
    L26:
        r101.put(r104, r105);     // Catch: Exception -> L39
        goto L4
    L23:
        r101.put(r104, ((Boolean) r105).booleanValue());     // Catch: Exception -> L39
        goto L4
    L20:
        r101.put(r104, r105);     // Catch: Exception -> L39
        goto L4
    L17:
        r101.put(r104, ((Number) r105).doubleValue());     // Catch: Exception -> L39
        goto L4
    L14:
        r101.put(r104, ((Number) r105).intValue());     // Catch: Exception -> L39
        goto L4
    L11:
        r101.put(r104, ((Number) r105).floatValue());     // Catch: Exception -> L39
        goto L4
    L8:
        r101.put(r104, ((Number) r105).longValue());     // Catch: Exception -> L39
    L39:
        e = move-exception;
        HostServiceUtilsKt.c().a(e);
        goto L4
    L41:
        return r101;
    }

    public static boolean a(d0.b r100, View r101, c r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r102 = r100.getEventName();
        JSONObject r103 = b(r100.getParams());
        boolean r104 = false;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return false;
    L5:
        Uri r105 = null;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L49
        Boolean r107 = r100.getEnterNewPage();     // Catch: Throwable -> L49
        String r108 = "c0.d0";
        if (r111 == true) goto L32;
        Boolean r112 = Boolean.TRUE;     // Catch: Throwable -> L49
        if (Intrinsics.areEqual(r107, r112) == false) goto L32;
        String r109 = r100.getBtm();     // Catch: Throwable -> L49
        if (r109 == null) goto L16;
        r108 = r109;
    L16:
        if (TextUtils.isEmpty(r108) == true) goto L31;
        vs6.a r113 = HostServiceUtilsKt.p();     // Catch: Throwable -> L49
        String r114 = r113.k(r108, r100.toJSON(), r110, r101);     // Catch: Throwable -> L49
        if (Intrinsics.areEqual(r100.getAddBtmChain(), r112) == false) goto L23;
        Number r115 = r100.getChainLength();     // Catch: Throwable -> L49
        if (r115 == null) goto L22;
        int r116 = r115.intValue();     // Catch: Throwable -> L49
    L24:
        Map<String, Object> r117 = r113.e(r114, r116);     // Catch: Throwable -> L49
        if (r117.isEmpty() == false) goto L27;
        ErrorUploader.a(r108, r101, null);     // Catch: Throwable -> L49
    L27:
        Iterator<Map.Entry<String, Object>> r118 = r117.entrySet().iterator();     // Catch: Throwable -> L49
    L29:
        if (r118.hasNext() == false) goto L31;
        Map.Entry<String, Object> r119 = r118.next();     // Catch: Throwable -> L49
        r103.putOpt(r119.getKey(), r119.getValue());     // Catch: Throwable -> L49
        goto L29
    L22:
        r116 = 10;
        goto L24
    L23:
        r116 = 0;
    L31:
        Object r120 = Unit.INSTANCE;     // Catch: Throwable -> L49
    L47:
        Result.m9449constructorimpl(r120);     // Catch: Throwable -> L49
    L51:
        String r121 = "";
        if (HostServiceUtilsKt.u().l() == false) goto L75;
        if (r110 == null) goto L61;
        g66.a r122 = r110.a(m16.b.class);
        if (r122 == null) goto L61;
        m16.b r123 = (m16.b) r122.provideInstance();
        if (r123 == null) goto L61;
        m16.c r124 = r123.a(Uri.class);
        if (r124 == null) goto L61;
        r105 = (Uri) r124.provideInstance();
    L61:
        ys6.a r125 = HostServiceUtilsKt.u();
        if (r105 == null) goto L67;
        String r126 = r105.toString();
        if (r126 == null) goto L67;
        r121 = r126;
    L67:
        r125.e(r121);
        if (r105 != null) goto L70;
    L72:
        if (r104 == true) goto L91;
        HostServiceUtilsKt.u().j();
    L91:
        int r127 = com.bytedance.locallife.biz.mob.a.f256703c;
        LinkedHashMap r128 = new LinkedHashMap();
        Iterator<String> r129 = r103.keys();
    L93:
        if (r129.hasNext() == false) goto L95;
        String r130 = r129.next();
        String r131 = r103.optString(r130);
        r129.remove();
        r128.put(r130, r131);
        goto L93
    L95:
        com.bytedance.locallife.biz.mob.a.C3646a.c(r102, r128);
        return true;
    L70:
        if (r105.getPort() != (-1)) goto L72;
        r104 = true;
        goto L72
    L75:
        if (HostServiceUtilsKt.a0().D() == false) goto L91;
        if (r110 == null) goto L84;
        g66.a r132 = r110.a(m16.b.class);
        if (r132 == null) goto L84;
        m16.b r133 = (m16.b) r132.provideInstance();
        if (r133 == null) goto L84;
        m16.c r134 = r133.a(Uri.class);
        if (r134 == null) goto L84;
        r105 = (Uri) r134.provideInstance();
    L84:
        yt6.a r135 = HostServiceUtilsKt.a0();
        if (r105 == null) goto L90;
        String r136 = r105.toString();
        if (r136 == null) goto L90;
        r121 = r136;
    L90:
        r135.U(r121);
    L32:
        String r137 = r100.getBtm();     // Catch: Throwable -> L49
        if (r137 == null) goto L36;
        r108 = r137;
    L36:
        if (r101 == null) goto L38;
        Intrinsics.checkNotNullParameter(r101, "<this>");     // Catch: Throwable -> L49
        Map<String, Object> r138 = com.bytedance.locallife.biz.btm.c.f(r101, r108);     // Catch: Throwable -> L49
    L39:
        if (r138 == null) goto L46;
        Iterator<Map.Entry<String, Object>> r139 = r138.entrySet().iterator();     // Catch: Throwable -> L49
    L42:
        if (r139.hasNext() == false) goto L46;
        Map.Entry<String, Object> r140 = r139.next();     // Catch: Throwable -> L49
        Object r141 = r140.getValue();     // Catch: Throwable -> L49
        if (r141 == null) goto L42;
        r103.putOpt(r140.getKey(), r141);     // Catch: Throwable -> L49
    L46:
        r120 = r108;
        goto L47
    L38:
        r138 = null;
    L49:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    }
}
