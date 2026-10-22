package com.bytedance.locallife.hybrid.bullet;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements com.bytedance.ies.bullet.lynx.e {
    public h() {
    }

    @Override // com.bytedance.ies.bullet.lynx.e
    public final com.bytedance.ies.bullet.lynx.a a(s26.a r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new g(r100, r101);
    }
}
