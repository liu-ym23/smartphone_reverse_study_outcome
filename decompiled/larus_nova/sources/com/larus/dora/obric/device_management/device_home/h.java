package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f339239a = 0;

    static {
    }

    public static int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_12, r100, R.dimen.larus_dp_12));
    }
}
