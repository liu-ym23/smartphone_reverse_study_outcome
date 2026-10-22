package com.larus.home.impl.sdk;

import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g0 implements com.larus.platform.api.s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f346178a = null;

    static {
        f346178a = new g0();
    }

    public g0() {
    }

    @Override // com.larus.platform.api.s0
    public final void a(LottieAdapterView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof LottieAdapterView) == false) goto L5;
        r100.setMaxFrameRate(30.0f);
        return;
    L5:
        FLogger.f375446a.w("LottieCompatServiceImpl", "setMaxFrameRate skipped, view is not LottieAdapterView: ".concat(r100.getClass().getName()));
    }
}
