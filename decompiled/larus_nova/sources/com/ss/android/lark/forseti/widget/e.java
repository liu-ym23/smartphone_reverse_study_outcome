package com.ss.android.lark.forseti.widget;

import android.content.Context;
import cib.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f424744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f424745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f424746c;

    public static final class a {
    }

    static {
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = f.a(r100, 60.0f);
        this.f424744a = r101;
        this.f424745b = f.a(r100, 636.0f) - (r101 * 2);
        this.f424746c = f.a(r100, 600.0f);
    }
}
