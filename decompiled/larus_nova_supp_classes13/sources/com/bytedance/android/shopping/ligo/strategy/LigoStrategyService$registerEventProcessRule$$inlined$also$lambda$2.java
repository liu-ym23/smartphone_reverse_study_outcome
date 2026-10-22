package com.bytedance.android.shopping.ligo.strategy;

import d93.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/shopping/ligo/strategy/LigoStrategyService$registerEventProcessRule$1$2"}, k = 3, mv = {1, 4, 3})
final class LigoStrategyService$registerEventProcessRule$$inlined$also$lambda$2 extends Lambda implements Function0<String> {
    final /* synthetic */ f $rule$inlined;
    final /* synthetic */ LigoStrategyService this$0;

    public LigoStrategyService$registerEventProcessRule$$inlined$also$lambda$2(LigoStrategyService r1, f r2) {
        this.this$0 = r1;
        this.$rule$inlined = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m942invoke() {
        return "register rule fail: rule=" + this.$rule$inlined;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m942invoke();
    }
}
