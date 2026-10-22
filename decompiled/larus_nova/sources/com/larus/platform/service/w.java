package com.larus.platform.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w implements com.larus.platform.api.u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f365817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365818b = null;

    public w() {
    }

    static {
        f365817a = new w();
        f365818b = LazyKt.lazy(new v());
    }

    public static com.larus.platform.api.u1 e() {
        return (com.larus.platform.api.u1) f365818b.getValue();
    }

    @Override // com.larus.platform.api.u1
    public final void b(Context r100, Map r101, com.larus.camera.impl.utils.n r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.x.d.D);
        com.larus.platform.api.u1 r103 = e();
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.u1
    public final void a(FragmentActivity r100, String r101, int r102, com.bytedance.applet.impl.e0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.platform.api.u1 r104 = e();
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.platform.api.u1
    public final void c(FragmentActivity r100, String r101, Map r102, com.bytedance.applet.impl.f0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.x.d.D);
        Intrinsics.checkNotNullParameter(r102, "extraInfo");
        com.larus.platform.api.u1 r104 = e();
        if (r104 == null) goto L6;
        r104.c(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.platform.api.u1
    public final void d(Context r100, String r101, String r102, com.larus.camera.impl.utils.o r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.platform.api.u1 r104 = e();
        if (r104 == null) goto L6;
        r104.d(r100, r101, r102, r103);
        return;
    }
}
