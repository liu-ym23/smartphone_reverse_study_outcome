package com.bytedance.android.window.shop.home;

import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
import com.bytedance.android.ec.window.shop.prefetch.ECWindowPreCreate4LynxCard;
import com.bytedance.android.window.shop.prefetch.ECWindowPreCreate4AnnieX;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<V> implements Callable {
    public final /* synthetic */ ECWindowActivity a;

    public d(ECWindowActivity r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        if (ECLynxAnnieXService.b() == false) goto L5;
        ECWindowActivity r1 = this.a;
        int r2 = ECWindowActivity.s;
        new ECWindowPreCreate4AnnieX(r1, r1.B1()).run();
        return;
    L5:
        ECWindowActivity r3 = this.a;
        int r4 = ECWindowActivity.s;
        new ECWindowPreCreate4LynxCard(r3, r3.B1()).run();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
