package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class u implements ntb.u {
    public u() {
    }

    @Override // ntb.u
    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        com.ss.android.lark.statistics.b.b(r100, r101);
    }
}
