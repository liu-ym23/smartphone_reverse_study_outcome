package com.bytedance.lark.policy.manager;

import com.bytedance.lark.policy.model.ErrorCode;
import com.bytedance.lark.policy.model.k;
import com.bytedance.lark.policy.model.n;
import com.bytedance.lark.policy.model.v;
import com.bytedance.lark.policy.model.w;
import com.bytedance.lark.policy.model.y;
import com.bytedance.lark.policy.network.NetworkService;
import com.bytedance.lark.policy.utils.EventTrace;
import com.bytedance.lark.policy.utils.Logger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class FactorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f253806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static k f253807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static w f253808c;

    public FactorManager() {
    }

    static {
        f253806a = CollectionsKt.listOf("-404");
        f253807b = new k(0);
        f253808c = new w(null);
    }

    public static void c() {
        y r100 = a.f253814a;
        boolean r101 = d.f253827a;
        if (a.d(d.f253829c) == false) goto L6;
        Logger.c("FactorManager", "getIPFactorFromNet: fetch ip start");
        int r102 = NetworkService.f253874a;
        NetworkService.a("/lark/scs/guardian/policy_engine/ip/query", new JSONObject(), FactorManager$getIPFactorFromNet$1.INSTANCE);
        return;
    }

    public static void a(boolean r100) {
        c();
        LinkedHashSet r101 = new LinkedHashSet();
        Map<String, List<String>> r102 = com.bytedance.lark.policy.utils.c.c().l();
        y r103 = a.f253814a;
        Iterator<T> r104 = a.f253816c.a().values().iterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        n r105 = (n) r104.next();
        Iterator<Map.Entry<String, List<String>>> r106 = r102.entrySet().iterator();
    L7:
        if (r106.hasNext() == false) goto L4;
        Map.Entry<String, List<String>> r107 = r106.next();
        String r108 = r107.getKey();
        List<String> r109 = r107.getValue();
        if (r105.e().contains(r108) == false) goto L7;
        Iterator<T> r110 = r105.f().iterator();
    L12:
        if (r110.hasNext() == false) goto L7;
        r101.addAll(b(((v) r110.next()).a().a(), r109));
        goto L12
    L14:
        List r111 = CollectionsKt.toList(r101);
        if ((!r111.isEmpty()) == true) goto L17;
        if (r100 == false) goto L17;
        return;
    L17:
        d(r111);
    }

    public static void d(List r100) {
        Intrinsics.checkNotNullParameter(r100, "variables");
        y r101 = a.f253814a;
        boolean r102 = d.f253827a;
        if (a.d(d.f253829c) == false) goto L17;
        Logger.c("FactorManager", "getCommonFactorFromNet: fetch factor start");
        JSONObject r103 = new JSONObject();
        if ((!r100.isEmpty()) == true) goto L7;
    L13:
        int r104 = NetworkService.f253874a;
        NetworkService.a("/lark/scs/guardian/policy_engine/subject_factor/query", r103, FactorManager$getSubjectFactorFromNet$1.INSTANCE);
        return;
    L7:
        if (com.bytedance.lark.policy.utils.c.a() == false) goto L13;
        r103.put("variables", r100);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        int r105 = Logger.f253883a;
        Logger.b("FactorManager", "getSubjectFactorFromNet:jsonObject put error, " + e.getMessage());
        int r106 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.FACTOR_FETCH_ERROR, "fetch factor error, jsonObject put error", null, 12);
        return;
    }

    public static List b(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "expression");
        Intrinsics.checkNotNullParameter(r101, "regexStringList");
        LinkedHashSet r102 = new LinkedHashSet();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        String r104 = (String) r103.next();
        Intrinsics.checkNotNullParameter(r100, "expression");
        Intrinsics.checkNotNullParameter(r104, "regexString");
        LinkedHashSet r105 = new LinkedHashSet();
        Iterator r106 = Regex.findAll$default(new Regex(r104), r100, 0, 2, null).iterator();     // Catch: Exception -> L11
    L8:
        if (r106.hasNext() == false) goto L13;
        r105.add(((MatchResult) r106.next()).getValue());     // Catch: Exception -> L11
    L13:
        r102.addAll(CollectionsKt.toList(r105));
    L11:
        e = move-exception;
        int r107 = Logger.f253883a;
        Logger.b("FactorManager", "extractExpression error e = " + e);
        goto L13
    L15:
        return CollectionsKt.toList(r102);
    }
}
