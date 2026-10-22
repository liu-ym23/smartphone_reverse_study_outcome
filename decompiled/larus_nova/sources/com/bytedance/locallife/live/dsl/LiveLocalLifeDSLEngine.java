package com.bytedance.locallife.live.dsl;

import android.content.Context;
import com.alibaba.gaiax.api.IGXRegisterCenter;
import com.alibaba.gaiax.api.IGXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.locallife.live.experiment.a0;
import com.bytedance.locallife.live.experiment.w;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class LiveLocalLifeDSLEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f259406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IGXTemplateEngine f259407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IGXRegisterCenter f259408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f259409d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f259410e = null;

    static {
        f259409d = LazyKt.lazy(LiveLocalLifeDSLEngine$liveLifeEngineHelper$2.INSTANCE);
        f259410e = LazyKt.lazy(LiveLocalLifeDSLEngine$useReport$2.INSTANCE);
    }

    public static void a(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a0.a() == false) goto L5;
    L7:
        final a r101 = (a) f259409d.getValue();
        final Function0<Unit> r102 = new LiveLocalLifeDSLEngine$initDslEnv$1(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "block");
        int r103 = i.f259463a;
        final Function0<Unit> r104 = new LiveLifeEngineHelper$checkAndRun$1(r101, r102);
        Intrinsics.checkNotNullParameter(r104, "callback");
        LiveLifeSaaSUtil.t().i("DslContainerPluginChecker", "检查插件加载");
        ((it6.h) LiveLifeSaaSUtil.f260667p.getValue()).d(new LocalLifeTemplatePluginUtil$asyncLoadPlugin$1(r104), LocalLifeTemplatePluginUtil$asyncLoadPlugin$2.INSTANCE);
        return;
    L5:
        if (w.a() == true) goto L7;
    }

    public static boolean b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "oriTemplateId");
        if (a0.a() == false) goto L5;
    L7:
        ((a) f259409d.getValue()).getClass();
        if (a.a(-10) == true) goto L10;
        return false;
    L10:
        List<String> r102 = h.f259460a;
        Intrinsics.checkNotNullParameter(r100, "oriTemplateId");
        Lazy<GXFastPreviewSource> r103 = GXFastPreviewSource.f259395f;
        GXFastPreviewSource r104 = GXFastPreviewSource.a.a();
        String r105 = h.a(r100);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.GAIAX_TEMPLATE_ID);
        if (((LinkedHashMap) r104.f259397b).get(r105) == null) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L33;
        Lazy<GeckoBinarySource> r107 = GeckoBinarySource.f259402d;
        GeckoBinarySource r108 = GeckoBinarySource.a.a();
        String r109 = h.a(r100);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, GXTemplateKey.GAIAX_TEMPLATE_ID);
        if (r101 != null) goto L18;
    L21:
        boolean r110 = true;
    L22:
        if (r110 == false) goto L24;
        String r111 = h.c();
    L26:
        if (r108.f259403a.get(r109 + r111) == null) goto L28;
        boolean r112 = true;
    L29:
        LiveLifeSaaSUtil.t().i("GeckoBinarySource", "template cache state id:" + r109 + " version:" + r111 + " loaded: " + r112);
        if (r112 == true) goto L32;
        qv6.e.a("live_life_dsl_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", "-90"), TuplesKt.to("reason", "template_failed"), TuplesKt.to("is_in_cache", String.valueOf(r112)), TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r109), TuplesKt.to("version", r111), TuplesKt.to("ori_version", String.valueOf(r101))}), true, null);
    L32:
        if (r112 == true) goto L33;
        return false;
    L28:
        r112 = false;
        goto L29
    L24:
        r111 = r101;
        goto L26
    L18:
        if (r101.length() == 0) goto L21;
        r110 = false;
    L33:
        return true;
    L13:
        r106 = false;
        goto L14
    L5:
        if (w.a() == true) goto L7;
        return false;
    }
}
