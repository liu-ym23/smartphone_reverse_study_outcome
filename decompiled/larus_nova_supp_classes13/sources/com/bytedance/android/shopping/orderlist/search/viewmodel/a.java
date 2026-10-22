package com.bytedance.android.shopping.orderlist.search.viewmodel;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.n;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function0 b;

    public a(Function1 r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        final e r4 = (e) r3;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultRequestUseCase", new OrderSearchResultRequestUseCase$doQuery$4$1(r4));
        if (f.d(r4) == false) goto L7;
        int r1 = n.a;
        n.a(r4.c(), false, false);
        Function1 r2 = this.a;
        if (r2 == null) goto L11;
        Unit r5 = (Unit) r2.invoke(r4);
        return;
    L11:
        return;
    L7:
        int r6 = n.a;
        n.a(r4.b(), false, false);
        Function0 r7 = this.b;
        if (r7 == null) goto L13;
        Unit r8 = (Unit) r7.invoke();
        return;
    }
}
