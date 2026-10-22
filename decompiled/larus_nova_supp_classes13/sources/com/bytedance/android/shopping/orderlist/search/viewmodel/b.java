package com.bytedance.android.shopping.orderlist.search.viewmodel;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public b(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        final Throwable r3 = (Throwable) r2;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.b("OrderSearchResultRequestUseCase", new OrderSearchResultRequestUseCase$doQuery$5$1(r3));
        Function0 r4 = this.a;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke();
        return;
    }
}
