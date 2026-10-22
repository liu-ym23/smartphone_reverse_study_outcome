package com.larus.init.task.imsdk;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.larus.im.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f351359b = null;

    static {
        f351359b = new b();
    }

    public b() {
    }

    @Override // com.larus.im.g
    public final Pair a(com.larus.im.l r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        android.util.Pair<String, String> r101 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a(r100));
        return TuplesKt.to(r101.first, r101.second);
    }
}
