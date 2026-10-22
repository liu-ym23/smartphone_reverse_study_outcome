package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "o", "Lcom/bytedance/bdp/appbase/chain/Chain;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;I)Lcom/bytedance/bdp/appbase/chain/Chain;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$chainLockStressTest$2 extends Lambda implements Function2<f, Integer, Chain<Unit>> {
    final /* synthetic */ ChainTest this$0;

    public ChainTest$chainLockStressTest$2(ChainTest r100) {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Chain<Unit> invoke(f r100, Integer r101) {
        return invoke(r100, r101.intValue());
    }

    public final Chain<Unit> invoke(f r100, int r101) {
        int r102 = ChainTest.f200670a;
        throw null;
    }
}
