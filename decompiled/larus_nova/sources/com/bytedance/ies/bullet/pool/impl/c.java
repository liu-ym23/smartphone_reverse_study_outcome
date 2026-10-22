package com.bytedance.ies.bullet.pool.impl;

import android.view.View;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.k;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f247491a;

    public final int b() {
        return this.f247491a.f247490b.size();
    }

    public c(int r100, k r101) {
        this.f247491a = new b(r100, r101);
    }

    public final void a(final String r100, final com.bytedance.ies.bullet.pool.c r101, com.bytedance.ies.bullet.pool.b r102) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "preRenderOp");
        if (this.f247491a.a(r100) == false) goto L26;
        b r103 = this.f247491a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "uniqueSchema");
        com.bytedance.ies.bullet.service.base.e r104 = r103.f247490b.get(r100);
        if (r104 == null) goto L7;
        View r105 = r104.f247887c;
    L9:
        if ((r105 instanceof BulletCardView) == false) goto L11;
        BulletCardView r106 = (BulletCardView) r105;
    L12:
        if (r106 == null) goto L15;
        String r107 = r106.getSessionId();
        if (r107 == null) goto L15;
    L16:
        r101.onSuccess(r107);
        ExecutorService r108 = BulletLogger.f247763a;
        BulletLogger.k("PreRender cacheKey " + r100 + " already exists", null, "XPreRender", 2);
        return;
    L15:
        r107 = "";
        goto L16
    L11:
        r106 = null;
        goto L12
    L7:
        r105 = null;
        goto L9
    L26:
        r102.invoke(r100, new KeyPreRenderPool$preRender$1(this, r100, r101));     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        if (this.f247491a.a(r100) == false) goto L24;
        this.f247491a.c(r100);
    L24:
        r101.a(PoolResult.FAIL_EXCEPTION, e.getMessage());
    }
}
