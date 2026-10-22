package com.larus.home.impl.sdk;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.caijing_pay.api.ICJPayService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g1 implements com.larus.platform.api.u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f346179a = null;

    static {
        f346179a = new g1();
    }

    public g1() {
    }

    @Override // com.larus.platform.api.u1
    public final void b(Context r100, Map r101, com.larus.camera.impl.utils.n r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.x.d.D);
        ICJPayService r103 = (ICJPayService) ServiceManager.get().getService(ICJPayService.class);
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.u1
    public final void a(FragmentActivity r100, String r101, int r102, com.bytedance.applet.impl.e0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ICJPayService r104 = (ICJPayService) ServiceManager.get().getService(ICJPayService.class);
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.platform.api.u1
    public final void c(FragmentActivity r100, String r101, Map r102, com.bytedance.applet.impl.f0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.x.d.D);
        Intrinsics.checkNotNullParameter(r102, "extraInfo");
        ICJPayService r104 = (ICJPayService) ServiceManager.get().getService(ICJPayService.class);
        if (r104 == null) goto L5;
        r104.c(r100, r101, r102, r103);
        return;
    L5:
        r103.invoke(-3, "Host payment service is unavailable");
    }

    @Override // com.larus.platform.api.u1
    public final void d(Context r100, String r101, String r102, com.larus.camera.impl.utils.o r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ICJPayService r103 = (ICJPayService) ServiceManager.get().getService(ICJPayService.class);
        if (r103 == null) goto L6;
        r103.e(r100, 20, r101, r102, r110);
        return;
    }
}
