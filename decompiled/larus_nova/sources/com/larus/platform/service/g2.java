package com.larus.platform.service;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g2 implements com.larus.platform.api.f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g2 f365742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365743b = null;

    public g2() {
    }

    static {
        f365742a = new g2();
        f365743b = LazyKt.lazy(new f2());
    }

    @Override // com.larus.platform.api.f1
    public final int a() {
        com.larus.platform.api.f1 r100 = (com.larus.platform.api.f1) f365743b.getValue();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.f1
    public final int c() {
        com.larus.platform.api.f1 r100 = (com.larus.platform.api.f1) f365743b.getValue();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.f1
    public final hq9.q0 d() {
        com.larus.platform.api.f1 r100 = (com.larus.platform.api.f1) f365743b.getValue();
        if (r100 == null) goto L7;
        hq9.q0 r101 = r100.d();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new hq9.q0(-1.0d);
    }

    @Override // com.larus.platform.api.f1
    public final float e() {
        com.larus.platform.api.f1 r100 = (com.larus.platform.api.f1) f365743b.getValue();
        if (r100 != null) goto L7;
        return -1.0f;
    L7:
        return r100.e();
    }

    @Override // com.larus.platform.api.f1
    public final hq9.g3 b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.platform.api.f1 r101 = (com.larus.platform.api.f1) f365743b.getValue();
        if (r101 == null) goto L7;
        hq9.g3 r102 = r101.b(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new hq9.g3(0, 0, 0);
    }
}
