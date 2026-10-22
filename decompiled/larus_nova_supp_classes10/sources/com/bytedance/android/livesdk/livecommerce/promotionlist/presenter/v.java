package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements Runnable {
    public final /* synthetic */ LivePromotionListListingPresenter a;
    public final /* synthetic */ List b;

    public v(LivePromotionListListingPresenter r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Iterator r1 = this.b.iterator();     // Catch: Throwable -> L8
    L4:
        if (r1.hasNext() == false) goto L6;
        cf.x r2 = (cf.x) r1.next();     // Catch: Throwable -> L8
        LivePromotionListListingPresenter.h0(this.a).notifyItemChanged(r2.a, r2.getType());     // Catch: Throwable -> L8
        goto L4
    L6:
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L17;
        ECExceptionMonitor.e(r4);
        return;
    L17:
        return;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
