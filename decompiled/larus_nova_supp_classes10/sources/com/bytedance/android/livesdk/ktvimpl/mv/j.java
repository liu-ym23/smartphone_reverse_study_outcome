package com.bytedance.android.livesdk.ktvimpl.mv;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements x {
    public final /* synthetic */ KtvMvWidget a;

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.x
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.x
    public final void a() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L8;
        KtvMvWidget r0 = this.a;
        ViewGroup r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setBackground(r0.i);
        return;
    L9:
        return;
    }

    public j(KtvMvWidget r1) {
        this.a = r1;
    }
}
