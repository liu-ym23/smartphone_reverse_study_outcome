package com.ss.android.lark.base.embedded;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.math.MathUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f409753c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f409754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f409755b;

    public static final class a {
        public static int a(Context r100, float r101) {
            Resources r102 = r100.getResources();
            return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
        }

        @JvmStatic
        public static e b(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r101 < a(r100, 854.0f)) goto L7;
            float r102 = r101;
            MathUtils.clamp(a(r100, 420.0f), MathKt.roundToInt(0.3f * r102), MathKt.roundToInt(r102 * 0.375f));
            return new e(a(r100, 854.0f), a(r100, 600.0f));
        L7:
            return new e(a(r100, 636.0f), a(r100, 600.0f));
        }
    }

    static {
    }

    public e(int r100, int r101) {
        this.f409754a = r100;
        this.f409755b = r101;
    }
}
