package com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "paramsData", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class WhiteBoardDynamicParamsController$subscribeWhiteBoardParams$5 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ a this$0;

    public WhiteBoardDynamicParamsController$subscribeWhiteBoardParams$5(a r1) {
        this.this$0 = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1392invoke(Object r3) {
        a.c(this.this$0, DynamicParamsType.COMMON_PARAMS, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m1392invoke(r1);
        return Unit.INSTANCE;
    }
}
