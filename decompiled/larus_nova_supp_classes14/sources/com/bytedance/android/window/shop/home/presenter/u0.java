package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u0 implements View.OnClickListener {
    public final /* synthetic */ ECWindowFloatCartEntryPresenter.c a;
    public final /* synthetic */ WindowCartEntryConfig b;

    public u0(ECWindowFloatCartEntryPresenter.c r1, WindowCartEntryConfig r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        ((h2) this.a.a.g.getValue()).onClick();
        com.bytedance.android.ec.sdk.helper.p r7 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r0 = this.a.a.u().c();
        int r1 = zq3.f.a;
        WindowCartEntryConfig r2 = this.b;
        if (r2 == null) goto L5;
        String r3 = r2.getJumpUrl();
    L6:
        Intrinsics.checkNotNull(r3);
        r7.openSchema(r0, zq3.f.c(r3, "a1.b7635.c0697.d7518", PageFinder.via(this.a.a.y()), null));
        return;
    L5:
        r3 = null;
        goto L6
    }
}
