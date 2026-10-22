package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFragment$appStateSwitch$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECMallFragment this$0;

    public ECMallFragment$appStateSwitch$1(ECMallFragment r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1134invoke() {
        DataEngineWrapper r0 = this.this$0.L0;
        if (r0 == null) goto L8;
        ECHybridDataEngine r1 = r0.a;
        if (r1 == null) goto L9;
        r1.v();
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1134invoke();
        return Unit.INSTANCE;
    }
}
