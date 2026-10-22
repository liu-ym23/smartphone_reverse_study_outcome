package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q implements Runnable {
    public final /* synthetic */ PromotionJumpDispatcher a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g e;
    public final /* synthetic */ sl.g f;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d g;
    public final /* synthetic */ il2.a h;
    public final /* synthetic */ View i;
    public final /* synthetic */ Pair j;

    public q(PromotionJumpDispatcher r1, Context r2, String r3, int r4, String r5, com.bytedance.android.ec.common.api.jump.model.g r6, sl.g r7, com.bytedance.android.btm.api.model.d r8, il2.a r9, View r10, Pair r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PromotionJumpDispatcher r0 = this.a;     // Catch: Throwable -> L8
        Context r1 = this.b;     // Catch: Throwable -> L8
        String r2 = this.c;     // Catch: Throwable -> L8
        int r3 = this.d;     // Catch: Throwable -> L8
        com.bytedance.android.ec.common.api.jump.model.g r4 = this.e;     // Catch: Throwable -> L8
        sl.g r5 = this.f;     // Catch: Throwable -> L8
        if (r5 == null) goto L5;
        sl.r r6 = r5.f();     // Catch: Throwable -> L8
    L6:
        r0.G(r1, r2, r3, r4, r6, this.g, this.h, this.i, this.j);     // Catch: Throwable -> L8
        return;
    L5:
        r6 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
