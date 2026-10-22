package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"N", "R", "Lcom/bytedance/bdp/appbase/chain/f;", "", "list", "Lcom/bytedance/bdp/appbase/chain/Chain;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/util/List;)Lcom/bytedance/bdp/appbase/chain/Chain;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ListOptional$eachJoin$1 extends Lambda implements Function2<f, List<Object>, Chain<List<Object>>> {
    final /* synthetic */ Function2 $block;

    public ListOptional$eachJoin$1(Function2 r100) {
        this.$block = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Chain<List<Object>> invoke2(f r100, final List<Object> r101) {
        AtomicInteger r102 = Chain.f200668k;
        return Chain.Companion.a().o(new AnonymousClass1(r101)).m(new FlatChain(new AnonymousClass2(this)));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Chain<List<Object>> invoke(f r100, List<Object> r101) {
        return invoke2(r100, r101);
    }
}
