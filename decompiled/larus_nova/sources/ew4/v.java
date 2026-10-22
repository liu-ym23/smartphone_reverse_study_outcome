package ew4;

import android.content.Context;
import com.ss.android.lark.integrator.ccm.dependency.di.s0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f474600a = null;

    static {
        f474600a = new v();
    }

    public v() {
    }

    @Override // ew4.c0
    public final void I0(Context r100, int[] r101, s0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "formats");
        Intrinsics.checkNotNullParameter(r102, "handler");
    }
}
