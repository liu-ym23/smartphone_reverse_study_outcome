package com.bytedance.helios.sdk;

import android.util.Pair;
import com.bytedance.helios.api.consumer.ControlExtra;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.detector.ApiConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Integer> f245579a = null;

    static {
        f245579a = CollectionsKt.arrayListOf(new Integer[]{102701, 102700});
    }

    @JvmStatic
    public static final Pair<Boolean, Object> a(PrivacyEvent r110) {
        if (HeliosEnvImpl.get().e() == true) goto L5;
    L27:
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", "triggerInterceptAction: not enabled, return id=" + r110.f245366c + " calledTime=" + r110.f245376m);
        return new Pair(Boolean.FALSE, null);
    L5:
        if (c(r110) == false) goto L27;
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", "handleIntercept: eventId=" + r110.f245366c + " calledTime=" + r110.f245376m + " eventSource=" + r110.f245364a);
        long r100 = System.currentTimeMillis();
        int r101 = xz5.b.f565522a;
        r110.f245382s = ThreadMethodProxy.currentThread().getName();
        hz5.g r102 = hz5.g.f487690b;
        r102.a(0, r110);
        hz5.k.d("Helios-Intercept-Api", "handleIntercept id=" + r110.f245366c + " name=" + (r110.f245363J + "." + r110.K) + " returnType=" + r110.f245389z.getReturnType() + " calledTime=" + r110.f245376m + " reflection=" + r110.f245381r);
        if (com.bytedance.helios.sdk.engine.a.f245566d.a(r110, true) == false) goto L16;
        r110.f245379p = "SensitiveApiInterceptException";
        ControlExtra r103 = r110.f245389z;
        Object r104 = r103.getInterceptResult().second;
        if (r104 == null) goto L12;
        r110.f245377n.put("returnResult", r104.toString());
    L12:
        String r105 = r103.getReturnType();
        if (r105 == null) goto L15;
        r110.f245377n.put("returnType", r105);
    L15:
        hz5.k.d("Helios-Intercept-Api", "actionIntercept id=" + r110.f245366c + " calledTime=" + r110.f245376m + " returnType=" + r110.f245389z.getReturnType() + " returnResult=" + r110.f245389z.getInterceptResult().second);
        Pair<Boolean, Object> r106 = r110.f245389z.getInterceptResult();
        Triple r107 = new Triple(Boolean.TRUE, r106.first, r106.second);
    L18:
        if (((Boolean) r107.getFirst()).booleanValue() == false) goto L20;
        com.bytedance.helios.common.utils.d.f().post(new xz5.a(r110, new Throwable("SensitiveApiInterceptException")));
    L20:
        r102.a(2, r110);
        Pair<Boolean, Object> r108 = new Pair(r107.getSecond(), r107.getThird());
        long r109 = System.currentTimeMillis() - r100;
        if (HeliosEnvImpl.get().f245470m.u() == true) goto L26;
        hz5.a r111 = hz5.a.c("handleIntercept", r109);
        r111.a("eventSource", r110.f245364a);
        r111.a(com.heytap.mcssdk.constant.b.f276361k, Integer.valueOf(r110.f245366c));
        int r112 = rz5.a.f539962a;
        if (HeliosEnvImpl.get().f245470m.u() == true) goto L26;
        hz5.l.b(r111);
    L26:
        return r108;
    L16:
        Boolean r113 = Boolean.FALSE;
        r107 = new Triple(r113, r113, null);
        goto L18
    }

    public static boolean b(int r100) {
        if (HeliosEnvImpl.get().e() == false) goto L25;
        d06.c r101 = d06.e.f466215b;
        if (r101 == null) goto L22;
        Map<Integer, d06.a> r102 = d06.e.f466217d;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        d06.a r104 = (d06.a) r103.get(Integer.valueOf(r100));
        if (r104 != null) goto L13;
        HashMap<Integer, com.bytedance.helios.sdk.detector.b> r105 = e.f245557a;
        ApiConfig r106 = e.a(r100).d(r100);
        if (r106 == null) goto L11;
        String r107 = r106.f245512a;
    L12:
        r104 = (d06.a) ((LinkedHashMap) d06.e.f466216c).get(r107);
        goto L13
    L11:
        r107 = null;
    L13:
        if (r104 != null) goto L16;
        r104 = r101.f466208g;
    L16:
        if (r104.f466197a == false) goto L18;
    L21:
        boolean r108 = true;
    L23:
        if (r108 == false) goto L25;
    L26:
        return true;
    L18:
        if (r104.f466198b == true) goto L21;
        if (r104.f466200d == true) goto L21;
    L22:
        r108 = false;
    L25:
        if (f245579a.contains(Integer.valueOf(r100)) == true) goto L26;
        return false;
    }

    public static boolean c(PrivacyEvent r100) {
        if (Intrinsics.areEqual(r100.f245364a, "binder") == true) goto L5;
        return true;
    L5:
        if (HeliosEnvImpl.get().f245474q.contains(Integer.valueOf(r100.f245366c)) == true) goto L10;
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", "this event only support bytex: id=" + r100.f245366c);
        return false;
    L10:
        return true;
    }
}
