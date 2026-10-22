package com.ss.android.lark.forsetiutils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f424768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f424769b = false;

    public b() {
    }

    static {
        f424768a = new b();
        f424769b = ForsetiConfig.b();
    }

    public static ForsetiViewMode a(FragmentActivity r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        tua.b r102 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100);     // Catch: Throwable -> L7
        if (r102 == null) goto L14;
        return r102.H();
    L14:
        return null;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Throwable r104 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r104 == null) goto L11;
        Log.e("getCurrentViewMode failed " + r104);
    L11:
        return null;
    }

    public static void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f424769b == true) goto L5;
        return;
    L5:
        sua.a r101 = (sua.a) ApiUtils.getApi(sua.a.class);
        Activity r102 = Contexts.findActivity(r100);
        if ((r102 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r103 = (FragmentActivity) r102;
    L9:
        tua.b r104 = r101.tryGetChainManager(r103);
        if (r104 == null) goto L15;
        ForsetiNormalChainDraggingView r105 = r104.m();
        if (r105 == null) goto L16;
        r105.setVisibility(0);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r103 = null;
        goto L9
    }

    public static int b(int r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r101.getResources();
        return (int) ((r100 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }
}
