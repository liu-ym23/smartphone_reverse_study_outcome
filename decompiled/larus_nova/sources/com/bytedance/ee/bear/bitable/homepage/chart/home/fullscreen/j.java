package com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f212572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f212573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f212574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f212575d;

    public static final class a {
    }

    public interface b {
        void a(int r100, boolean r101);
    }

    static {
    }

    public j(BitableChartFullscreenActivity r100, BitableChartFullscreenActivity$orientationHelper$2.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "orientationChangedListener");
        this.f212572a = r100;
        this.f212573b = r101;
        this.f212574c = -1;
        this.f212575d = new k(this, r100);
    }
}
