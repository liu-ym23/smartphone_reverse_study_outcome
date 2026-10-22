package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "input", "Lcom/bytedance/bdp/appbase/chain/Chain;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)Lcom/bytedance/bdp/appbase/chain/Chain;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testMultiThrowable$2 extends Lambda implements Function2<f, Object, Chain> {
    public static final ChainTest$testMultiThrowable$2 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testMultiThrowable$2();
    }

    public ChainTest$testMultiThrowable$2() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Chain invoke2(f r100, Object r101) {
        int r102 = ChainTest.f200670a;
        boolean r103 = BdpPool.isOnIOPool();
        StringBuilder r104 = new StringBuilder("thread type error:");
        BdpTask r105 = BdpPool.curThreadTask();
        if (r105 == null) goto L5;
        BdpTask.TaskType r106 = r105.taskType;
    L6:
        r104.append(r106);
        ChainTest.a.a(r103, r104.toString());
        AtomicInteger r107 = Chain.f200668k;
        Chain r108 = Chain.Companion.a();
        r108.q();
        return r108.o(AnonymousClass1.INSTANCE);
    L5:
        r106 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Chain invoke(f r100, Object r101) {
        return invoke2(r100, r101);
    }
}
