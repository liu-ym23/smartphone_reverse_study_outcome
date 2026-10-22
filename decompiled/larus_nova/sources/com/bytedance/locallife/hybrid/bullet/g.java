package com.bytedance.locallife.hybrid.bullet;

import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: classes21.dex */
public final class g extends DefaultLynxDelegate {
    @Override // com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate, com.bytedance.ies.bullet.lynx.a
    public final List<com.lynx.tasm.behavior.a> l() {
        ArrayList r100 = new ArrayList();
        r100.addAll(super.l());
        List<com.lynx.tasm.behavior.a> r101 = HostServiceUtilsKt.P().getBehaviorList();
        if ((!r101.isEmpty()) == false) goto L5;
        r100.addAll(r101);
    L5:
        return r100;
    }

    public g(s26.a r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
