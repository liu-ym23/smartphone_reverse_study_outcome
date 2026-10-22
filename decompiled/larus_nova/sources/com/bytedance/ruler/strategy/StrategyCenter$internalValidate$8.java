package com.bytedance.ruler.strategy;

import com.bytedance.express.util.a;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/express/util/a$a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/express/util/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class StrategyCenter$internalValidate$8 extends Lambda implements Function1<a.C3487a, Unit> {
    final /* synthetic */ String $ruleSetName;

    public StrategyCenter$internalValidate$8(String r100) {
        this.$ruleSetName = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a.C3487a r100) {
        r100.f243212a = "[" + r100.getClass().getSimpleName() + "]code:310  msg:ruleSet[" + this.$ruleSetName + "] is not found";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a.C3487a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
