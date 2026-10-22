package com.ss.android.lark.forsetiutils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.android.livesdkapi.util.ILivePreInflateService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f424749a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f424750b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f424751c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f424752d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f424753e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f424754f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f424755g = null;

    static {
        f424749a = LazyKt.lazy(ForsetiConfig$PLACE_HOLDER_THRESHOLD_UNDER_LEFT_NAVIGATION$2.INSTANCE);
        f424750b = LazyKt.lazy(ForsetiConfig$THRESHOLD_LEFT_NAVIGATION_APPLYING$2.INSTANCE);
        f424751c = true;
        f424752d = LazyKt.lazy(ForsetiConfig$enableForseti$2.INSTANCE);
        f424753e = LazyKt.lazy(ForsetiConfig$enableLeftNavigation$2.INSTANCE);
        f424754f = LazyKt.lazy(ForsetiConfig$enableUpdateResumedChain$2.INSTANCE);
        f424755g = LazyKt.lazy(ForsetiConfig$isInBlackList$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) f424752d.getValue()).booleanValue();
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof ContextWrapper) == false) goto L7;
        ContextWrapper r101 = (ContextWrapper) r100;
        if ((r101.getBaseContext() instanceof Activity) == false) goto L7;
        boolean r102 = StringsKt.contains$default(r101.getBaseContext().getClass().getName(), ILivePreInflateService.MAIN_ACTIVITY, false, 2, null);
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (b() == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        r102 = StringsKt.contains$default(r100.getClass().getName(), ILivePreInflateService.MAIN_ACTIVITY, false, 2, null);
        goto L8
    }

    public static boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = ForsetiEmbeddedUtils.e(r100);
        b.f424768a.getClass();
        int r102 = b.b(r101, r100);
        if (((Boolean) f424753e.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (r102 < ((Number) f424750b.getValue()).floatValue()) goto L7;
        return true;
    }
}
