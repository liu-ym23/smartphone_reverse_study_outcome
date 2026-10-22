package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/task/a;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke", "(Lcom/bytedance/android/shopping/orderlist/common/widgets/task/a;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class BaseLinkedFootHelper$startYataFootRefresh$3 extends Lambda implements Function2<com.bytedance.android.shopping.orderlist.common.widgets.task.a, Object, Unit> {
    final /* synthetic */ String $tag;
    final /* synthetic */ BaseLinkedFootHelper this$0;

    public BaseLinkedFootHelper$startYataFootRefresh$3(BaseLinkedFootHelper r1, String r2) {
        this.this$0 = r1;
        this.$tag = r2;
        super(2);
    }

    public final void invoke(com.bytedance.android.shopping.orderlist.common.widgets.task.a r2, Object r3) {
        BaseLinkedFootHelper r4 = this.this$0;
        if (r4.b != 1) goto L5;
        return;
    L5:
        r4.b = 1;
        Lazy r5 = OrderCommonLog.a;
        OrderCommonLog.a(this.$tag, AnonymousClass1.INSTANCE);
        if (this.this$0.i(new BaseLinkedFootHelper$startYataFootRefresh$3$hasStarted$1(this), new BaseLinkedFootHelper$startYataFootRefresh$3$hasStarted$2(this)) == true) goto L9;
        OrderCommonLog.a(this.$tag, AnonymousClass2.INSTANCE);
        this.this$0.g.b("");
        this.this$0.a();
        this.this$0.b = 0;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.bytedance.android.shopping.orderlist.common.widgets.task.a) r1, r2);
        return Unit.INSTANCE;
    }
}
