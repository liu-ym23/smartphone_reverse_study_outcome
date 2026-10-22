package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ECMallFragment$initListEngine$6$onFirstScreen$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECMallFragment$initListEngine$6 this$0;

    public ECMallFragment$initListEngine$6$onFirstScreen$6(ECMallFragment$initListEngine$6 r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1171invoke() {
        if (this.this$0.b.w3 == true) goto L8;
        ECMallDeliveryReduceConfig r0 = com.bytedance.android.shopping.mall.homepage.tools.g.a;
        if (com.bytedance.android.shopping.mall.homepage.tools.g.a.getForceLayoutEnable() == false) goto L9;
        this.this$0.b.Ma0(new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1171invoke();
        return Unit.INSTANCE;
    }
}
