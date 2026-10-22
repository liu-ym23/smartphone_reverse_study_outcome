package com.bytedance.salamander.anniex;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, g5> f268100a;

    public h5() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.f268100a = r100;
        int r101 = g5.f268083b;
        com.bytedance.rts.foundation.m.e(r100, -1, new g8());
        com.bytedance.rts.foundation.m.e(r100, 0, new h8());
    }

    public final void a(g5 r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        com.bytedance.rts.foundation.m.e(this.f268100a, Integer.valueOf(r100.getType()), r100);
    }
}
