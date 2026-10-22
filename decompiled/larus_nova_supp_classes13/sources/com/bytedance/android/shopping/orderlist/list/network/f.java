package com.bytedance.android.shopping.orderlist.list.network;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ OrderListRequestViewModel a;
    public final /* synthetic */ b b;

    public f(OrderListRequestViewModel r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        final Throwable r4 = (Throwable) r3;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.b("OrderListRequestViewModel", new OrderListRequestViewModel$doChunkRequest$3$1(r4));
        new Handler(Looper.getMainLooper()).post(new e(this, r4));
    }
}
