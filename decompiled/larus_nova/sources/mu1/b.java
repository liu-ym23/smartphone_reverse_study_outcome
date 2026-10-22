package mu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.LinkedHashMap;
import java.util.Map;
import ju1.h;
import ju1.j;
import ju1.n;
import ju1.q;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import nu1.c;
import nu1.f;
import ou1.d;
import ou1.e;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Object, h> f515723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final pu1.b f515724b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final pu1.a f515725c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Class<? extends h>, f<? extends h>> f515726d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Class<? extends g>, c<? extends g>> f515727e = null;

    static {
        f515723a = new LinkedHashMap();
        f515724b = new pu1.b();
        f515725c = pu1.a.f530712a;
        nu1.a r100 = nu1.a.f520601a;
        f515726d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(j.class, new e()), TuplesKt.to(q.class, new ou1.g()), TuplesKt.to(ju1.f.class, new d()), TuplesKt.to(com.bytedance.android.livesdk.dynamicstrategy.api.entity.b.class, new ou1.a())});
        f515727e = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e.class, new ou1.b())});
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.dynamicstrategy.api.entity.b c(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "strategyRule");
        f515725c.getClass();
        Intrinsics.checkNotNullParameter(r100, "source");
        String r101 = r100.strategyName;
        if (r101 != null) goto L6;
        k.b("unknown_strategy", "strategy name is null");
    L11:
        return null;
    L6:
        if (r100.defaultResult != null) goto L9;
        k.b(r101, "strategy default result is null");
        goto L11
    L9:
        if (r100.ruleType == 1) goto L13;
        int r102 = k.f510820a;
        k.b(r101, "strategy rule type is " + r100.ruleType);
        goto L11
    L13:
        return new com.bytedance.android.livesdk.dynamicstrategy.api.entity.b(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v10, types: [ju1.a, ju1.j] */
    /* JADX WARN: Type inference failed for: r1v13, types: [ju1.a, ju1.q] */
    /* JADX WARN: Type inference failed for: r1v16, types: [ju1.a, ju1.f] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, ju1.h] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v7, types: [kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [kotlin.Pair[]] */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlin.Pair[]] */
    @JvmStatic
    public static final h d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "strategyStr");
        h r100 = (h) ((LinkedHashMap) f515723a).get(r110);
        if (r100 == null) goto L5;
        return r100;
    L5:
        pu1.b r101 = f515724b;
        r101.getClass();
        ?? r102 = "type";
        Intrinsics.checkNotNullParameter(r110, "strategyStr");
        ?? r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        r103 = 1;
        JsonObject r104 = new JsonParser().parse(r110).getAsJsonObject();     // Catch: Exception -> L50
        if (r104 == null) goto L55;
        JsonElement r105 = r104.get("type");     // Catch: Exception -> L50
        if (r105 == null) goto L55;
        String r106 = r105.getAsString();     // Catch: Exception -> L50
        if (r106 == null) goto L55;
        int r107 = r106.hashCode();     // Catch: Exception -> L50
        if (r107 == (-1039745817)) goto L41;
        if (r107 == (-791592328)) goto L31;
        if (r107 != (-256720530)) goto L55;
        if (r106.equals("speed_formula") == false) goto L55;
        ?? r108 = (ju1.f) GsonProtectorUtils.fromJson(r101.f530713a, r110, ju1.f.class);     // Catch: Exception -> L50
        if (r108 == null) goto L55;
        r102 = r108.h().length();     // Catch: Exception -> L50
        if (r102 == 0) goto L28;
        r103 = 0;
    L28:
        if (r103 != 0) goto L55;
    L56:
        if (r108 == null) goto L59;
        f515723a.put(r110, (h) r108);
        return r108;
    L59:
        return null;
    L31:
        if (r106.equals("weight") == false) goto L55;
        r108 = (q) GsonProtectorUtils.fromJson(r101.f530713a, r110, q.class);     // Catch: Exception -> L50
        if (r108 == null) goto L55;
        r102 = r108.h().length();     // Catch: Exception -> L50
        if (r102 == 0) goto L38;
        r103 = 0;
    L38:
        if (r103 == 0) goto L56;
    L41:
        if (r106.equals("normal") == false) goto L55;
        r108 = (j) GsonProtectorUtils.fromJson(r101.f530713a, r110, j.class);     // Catch: Exception -> L50
        if (r108 == null) goto L55;
        r102 = r108.h().length();     // Catch: Exception -> L50
        if (r102 == 0) goto L48;
        r103 = 0;
    L48:
        if (r103 == 0) goto L56;
    L55:
        r108 = null;
    L50:
        e = move-exception;
        int r109 = k.f510820a;
        String r111 = e.getMessage();
        if (r111 != null) goto L54;
        Intrinsics.checkNotNullParameter("unknown_strategy", BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r111, "info");
        ?? r112 = new Pair[3];
        r112[0] = TuplesKt.to(r102, "json_strategy_parse_error");
        r112[r103] = TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, "unknown_strategy");
        r102 = TuplesKt.to("info", r111);
        r112[2] = r102;
        r103 = MapsKt.mutableMapOf(r112);
        k.h(r103, e);
        goto L55
    L54:
        Intrinsics.checkNotNullParameter("unknown_strategy", BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter("unknown", "info");
        ?? r113 = new Pair[3];
        r113[0] = TuplesKt.to(r102, "json_strategy_parse_error");
        r113[r103] = TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, "unknown_strategy");
        r102 = TuplesKt.to("info", "unknown");
        r113[2] = r102;
        r103 = MapsKt.mutableMapOf(r113);
        k.h(r103, e);
        goto L55
    }

    @JvmStatic
    public static final n b(h r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "stateMap");
        f<? extends h> r102 = f515726d.get(r100.getClass());
        if ((r102 instanceof f) == true) goto L5;
        r102 = null;
    L5:
        f<? extends h> r103 = r102;
        if (r103 == null) goto L10;
        n r104 = r103.a(r100, r101);
        if (r104 == null) goto L10;
        return r104;
    L10:
        return new n(r100.a(), true);
    }

    @JvmStatic
    public static final void a(g r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "nfa");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "eventParams");
        c<? extends g> r103 = f515727e.get(r100.getClass());
        if ((r103 instanceof c) == true) goto L5;
        r103 = null;
    L5:
        c<? extends g> r104 = r103;
        if (r104 == null) goto L9;
        r104.a(r100, r101, r102);
        return;
    }
}
