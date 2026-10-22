package com.bytedance.ee.bear.basesdk.config;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.e4;
import dn5.n;
import dn5.r;
import dn5.t;
import dn5.u;
import dn5.x;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zy4.m;
import zy4.o;
import zy4.p;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f206601a = null;

    static {
        f206601a = MapsKt.mapOf(TuplesKt.to("mobile_doc_badge_test", 3));
    }

    @JvmStatic
    public static final i a(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        return new i(CollectionsKt.listOf(new com.bytedance.ee.bear.document.onboarding.b[]{new zy4.a(), new o(fx4.a.g(((e4) r100.getHostAbility(e4.class)).getDocumentMetadata().getOriginBearUrl())), new zy4.j(), new zy4.f(), new zy4.d(), new zy4.g(), new az4.b(), new p(), new zy4.e(), new zy4.c(), new zy4.i(), new m(), new dn5.j(), new dn5.h(), new t(), new dn5.l(), new n(), new u(), new r(), new x(), new dn5.p(), new dn5.d(), new dn5.g(), new dn5.c()}));
    }
}
