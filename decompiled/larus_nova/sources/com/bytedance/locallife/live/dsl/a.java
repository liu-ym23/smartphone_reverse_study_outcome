package com.bytedance.locallife.live.dsl;

import com.alibaba.gaiax.api.IGXRegisterCenter;
import com.alibaba.gaiax.api.IGXTemplateEngine;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IGXTemplateEngine f259418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IGXRegisterCenter f259419b;

    public a() {
    }

    public static boolean a(int r100) {
        int r101 = i.f259463a;
        if (((it6.h) LiveLifeSaaSUtil.f260667p.getValue()).isPluginReady() == true) goto L6;
        LiveLifeSaaSUtil.t().i("LiveLocalLifeDSLEngine", "尚未成功加载插件");
        qv6.e.a("live_life_dsl_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", "-90"), TuplesKt.to("reason", "plugin_not_ready"), TuplesKt.to("source_tyoe", String.valueOf(r100))}), true, null);
        return false;
    L6:
        return true;
    }
}
