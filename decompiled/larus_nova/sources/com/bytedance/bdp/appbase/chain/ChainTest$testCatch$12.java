package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testCatch$12 extends Lambda implements Function2<f, Unit, Unit> {
    final /* synthetic */ Ref.IntRef $cancelDelayTestId3;

    public ChainTest$testCatch$12(Ref.IntRef r100) {
        this.$cancelDelayTestId3 = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100, Unit r101) {
        BdpPool.cancelTask(this.$cancelDelayTestId3.element);
        if (q94.a.f532095a == false) goto L6;
        int r102 = ChainTest.f200670a;
        g94.b.a("CnTest", new Object[]{"testCatch catch error:" + r101 + " success"});
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(f r100, Unit r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
