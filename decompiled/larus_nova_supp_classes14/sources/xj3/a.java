package xj3;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final SlcExprContext a = null;
    public static Map<String, Object> b;

    static {
        a = new SlcExprContext(0);
        b = new LinkedHashMap();
    }

    public static void a(HybridPageViewModel r4) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        boolean r0 = ECServiceManager.a;
        String r1 = ((g) ECServiceManager.c(g.class)).getCurrentBcmChain();
        if (k.c(r1) == true) goto L6;
        r1 = null;
    L6:
        LinkedHashMap r2 = new LinkedHashMap();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r2.put("search_bcm_chain", r1);
        r2.put("personal_recommend_switch_params", "");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("router_query", r4.getRouterQuery());
        r3.put("custom", r2);
        b = r3;
    }

    public static void b(JSONObject r6) {
        if (r6 == null) goto L33;
        JSONObject r7 = r6.optJSONObject("api_config");
        if (r7 == null) goto L50;
        JSONObject r8 = r7.optJSONObject("apis");
        if (r8 == null) goto L51;
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = r8.keys();
    L10:
        if (r1.hasNext() == false) goto L12;
        r0.add(r1.next());
        goto L10
    L12:
        Iterator r2 = r0.iterator();
    L14:
        if (r2.hasNext() == false) goto L52;
        JSONObject r3 = r8.optJSONObject((String) r2.next());
        if (r3 == null) goto L14;
        JSONObject r4 = r3.optJSONObject("params");
        if (r4 == null) goto L14;
        ArrayList r5 = new ArrayList();
        Iterator<String> r9 = r4.keys();
    L22:
        if (r9.hasNext() == false) goto L24;
        r5.add(r9.next());
        goto L22
    L24:
        Iterator r10 = r5.iterator();
    L26:
        if (r10.hasNext() == false) goto L14;
        String r11 = (String) r10.next();
        Object r12 = r4.opt(r11);
        if ((r12 instanceof JSONObject) == true) goto L29;
        if ((r12 instanceof JSONArray) == false) goto L26;
        r4.put(r11, r12.toString());
        goto L26
    L29:
        r4.put(r11, r12.toString());
        goto L26
    L52:
        return;
    L51:
        return;
    L50:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v14, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r0v15, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Object] */
    public static Object c(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "obj");
        if ((r5 instanceof Map) == false) goto L15;
        ?? r0 = new LinkedHashMap();
        Iterator r6 = ((Map) r5).entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L75;
        Map.Entry r2 = (Map.Entry) r6.next();
        Object r3 = r2.getKey();
        Object r4 = r2.getValue();
        String r7 = String.valueOf(r3);
        if (r4 == null) goto L10;
        Object r8 = c(r4);
    L11:
        if (r8 == null) goto L6;
        r0.put(r7, r8);
        goto L6
    L10:
        r8 = null;
    L75:
        return r0;
    L15:
        if ((r5 instanceof JSONObject) == false) goto L25;
        r0 = new JSONObject();
        JSONObject r9 = (JSONObject) r5;
        Iterator<String> r10 = r9.keys();
    L18:
        if (r10.hasNext() == false) goto L75;
        String r11 = r10.next();
        if (r9.get(r11) == null) goto L22;
        Object r12 = c(r9.get(r11));
    L23:
        if (r12 == null) goto L18;
        r0.putOpt(r11, r12);
        goto L18
    L22:
        r12 = null;
        goto L23
    L25:
        int r13 = 0;
        if ((r5 instanceof JSONArray) == false) goto L34;
        r0 = new JSONArray();
        JSONArray r14 = (JSONArray) r5;
        int r1 = r14.length();
    L28:
        if (r13 >= r1) goto L75;
        Object r15 = r14.get(r13);
        if (r15 == null) goto L32;
        r0.put(c(r15));
    L32:
        r13 = r13 + 1;
        goto L28
    L34:
        if ((r5 instanceof List) == false) goto L42;
        r0 = new ArrayList();
        Iterator r16 = ((Iterable) r5).iterator();
    L37:
        if (r16.hasNext() == false) goto L75;
        Object r17 = r16.next();
        if (r17 == null) goto L37;
        r0.add(c(r17));
        goto L37
    L42:
        if ((r5 instanceof String) == false) goto L76;
        String r18 = (String) r5;
        Intrinsics.checkNotNullParameter(r18, "input");
        String r19 = StringsKt.trim(r18).toString();
        if (StringsKt.startsWith$default(r19, "{{", false, 2, null) == true) goto L46;
        return r18;
    L46:
        if (StringsKt.endsWith$default(r19, "}}", false, 2, null) == false) goto L79;
        String r20 = r19.substring(2, r19.length() - 2);
        if (r20.length() <= 0) goto L51;
        r13 = 1;
    L51:
        if (r13 == 0) goto L56;
        r0 = a.a(StringsKt.trim(r20).toString(), b, null);
        if (r0 != 0) goto L75;
        return StringsKt.trim(r20).toString();
    L56:
        return StringsKt.trim(r20).toString();
    L79:
        return r18;
    L76:
        return r5;
    }
}
