package com.larus.im;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f350570b = null;

    static {
        f350570b = new k();
    }

    public k() {
    }

    @Override // com.larus.im.g
    public final Pair a(l r110) {
        Intrinsics.checkNotNullParameter(r110, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        ArrayList r100 = new ArrayList();
        r100.add("t=" + r110.triggerType().getValue());
        r100.add("n=" + (r110.markAsNewUser() ? 1 : 0));
        return TuplesKt.to(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG, CollectionsKt.joinToString$default(r100, com.alipay.sdk.m.u.i.f25853b, null, null, 0, null, null, 62, null));
    }
}
