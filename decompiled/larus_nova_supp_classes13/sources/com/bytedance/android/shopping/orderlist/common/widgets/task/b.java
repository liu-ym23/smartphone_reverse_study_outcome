package com.bytedance.android.shopping.orderlist.common.widgets.task;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import kotlin.Lazy;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends a {
    public final /* synthetic */ String b;
    public final /* synthetic */ Function2 c;

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.task.a
    public final void a(e r3) {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderCommonBaseTask", new BaseTaskKt$newTask$1$doTask$1(this));
        this.c.invoke(this.a, r3);
    }

    public b(String r1, Function2 r2) {
        this.b = r1;
        this.c = r2;
    }
}
