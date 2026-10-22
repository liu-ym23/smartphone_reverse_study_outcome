package com.ss.android.lark.movable.utils;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.keyframes.model.KFAnimation;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    public static final com.ss.android.lark.movable.attatchment.b a(com.ss.android.lark.movable.attatchment.b r100, Context r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r101 = d(r100.f432627c, r110);
        float r102 = d(r100.f432628d, r110);
        float r103 = d(r100.f432629e, r110);
        float r104 = d(r100.f432630f, r110);
        int r105 = r100.f432625a;
        int r106 = r100.f432626b;
        Map<String, String> r107 = r100.f432631g;
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return new com.ss.android.lark.movable.attatchment.b(r105, r106, r101, r102, r103, r104, r107);
    }

    public static final com.ss.android.lark.movable.attatchment.g b(com.ss.android.lark.movable.attatchment.g r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new com.ss.android.lark.movable.attatchment.g(d(r100.b(), r101), d(r100.a(), r101));
    }

    public static final jsb.a c(jsb.a r100, Context r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r101 = d(r100.f500271b, r110);
        float r102 = d(r100.f500272c, r110);
        float r103 = d(r100.f500273d, r110);
        float r104 = d(r100.f500274e, r110);
        float r105 = d(r100.f500275f, r110);
        float r106 = d(r100.f500276g, r110);
        return new jsb.a(r100.f500270a, r101, r102, r103, r104, r105, r106);
    }

    public static final float d(float r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r101.getResources();
        return r100 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
    }

    public static final int e(int r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r101.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static final float f(float r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r101.getResources();
        return r100 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
    }

    public static final int g(int r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r101.getResources();
        return (int) ((r100 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }
}
