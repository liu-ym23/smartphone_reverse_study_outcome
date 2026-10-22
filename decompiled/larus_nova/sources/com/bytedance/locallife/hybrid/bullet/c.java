package com.bytedance.locallife.hybrid.bullet;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.p0;
import com.bytedance.ies.bullet.service.base.q;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements p0 {
    public c() {
    }

    @Override // com.bytedance.ies.bullet.service.base.p0
    public final FrameLayout.LayoutParams c0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.p0
    public final i n(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        return null;
    }

    @Override // q26.c
    public final void onRegister(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
    }

    @Override // q26.c
    public final void onUnRegister() {
    }

    @Override // com.bytedance.ies.bullet.service.base.p0
    public final FrameLayout.LayoutParams B0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        r101.gravity = 17;
        return r101;
    }

    @Override // com.bytedance.ies.bullet.service.base.p0
    public final void R(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    @Override // com.bytedance.ies.bullet.service.base.p0
    public final q b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        return new LifeLoadingView(r100);
    }
}
