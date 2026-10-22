package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "Lcom/bytedance/bdp/appbase/chain/Chain;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)Lcom/bytedance/bdp/appbase/chain/Chain;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testMultiCancel$flow$2 extends Lambda implements Function2<f, Object, Chain<Unit>> {
    public static final ChainTest$testMultiCancel$flow$2 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testMultiCancel$flow$2();
    }

    public ChainTest$testMultiCancel$flow$2() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Chain<Unit> invoke2(f r100, Object r101) {
        AtomicInteger r102 = Chain.f200668k;
        Chain r103 = Chain.Companion.a();
        m<?, ?> r104 = r103.l();
        r104.f200752h = i0.a.f200742a;
        r103.l().f200751g = 300;
        r103.l().i().onLogic();
        return r103.o(AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Chain<Unit> invoke(f r100, Object r101) {
        return invoke2(r100, r101);
    }
}
