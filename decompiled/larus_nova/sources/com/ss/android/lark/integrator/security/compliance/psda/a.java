package com.ss.android.lark.integrator.security.compliance.psda;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import okhttp3.Request;
import w4c.c;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f428098a = 0;

    static {
    }

    public static void b(Request r100) {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("scs.scs_infra.sla") == true) goto L5;
        return;
    L5:
        List<String> r101 = c.a().m0();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L13;
        return;
    L13:
        String r103 = u4c.a.f548750a;
        u4c.a.a("scs_network_state_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("path", r100.url().url().getPath()), TuplesKt.to("domain", r100.url().url().getHost()), TuplesKt.to("event_type", "REPORTNETREQUESTSTART")}), null, null, 0, 28);
        return;
    L8:
        if (r101.contains(r100.url().url().getPath()) != true) goto L10;
        r102 = true;
        goto L11
    }

    public static void a(String r100, String r101, int r102, String r110) {
        String r103 = u4c.a.f548750a;
        u4c.a.a("scs_network_state_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("domain", r100), TuplesKt.to("path", r101), TuplesKt.to("error_code", Integer.valueOf(r102)), TuplesKt.to("error_msg", r110)}), null, null, 0, 28);
    }
}
