package com.larus.home.impl.sdk;

import android.content.Context;
import com.larus.map.api.IMapApi;
import com.larus.platform.api.y2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q0 implements y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f346224a = null;

    static {
        f346224a = new q0();
    }

    public q0() {
    }

    @Override // com.larus.platform.api.y2
    public final String c() {
        return IMapApi.f358881a.c();
    }

    @Override // com.larus.platform.api.y2
    public final boolean d() {
        return IMapApi.f358881a.d();
    }

    @Override // com.larus.platform.api.y2
    public final wq9.e a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return IMapApi.f358881a.a(r100);
    }

    @Override // com.larus.platform.api.y2
    public final void b(Context r100, com.larus.bmhome.chat.map.p r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IMapApi.f358881a.b(r100, r101);
    }
}
