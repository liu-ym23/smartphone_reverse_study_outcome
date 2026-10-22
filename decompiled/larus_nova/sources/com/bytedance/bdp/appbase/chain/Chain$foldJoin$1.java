package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"N", "C", "R", "Lcom/bytedance/bdp/appbase/chain/f;", "input", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Chain$foldJoin$1 extends Lambda implements Function2<f, Object, Object> {
    final /* synthetic */ Function3 $block;
    final /* synthetic */ Object $initial;

    public Chain$foldJoin$1(Object r100, Function3 r101) {
        this.$initial = r100;
        this.$block = r101;
        super(2);
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [T, com.bytedance.bdp.appbase.chain.Chain] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(final f r100, final Object r101) {
        final b r102 = new b(this.$initial);
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = null;
        AtomicInteger r104 = Chain.f200668k;
        ?? r105 = Chain.Companion.a().o(new AnonymousClass1(this, r100, r101, r102)).m(new CatchChain(FoldEvent.class, new Chain$catchJava$1(new c(new AnonymousClass2(r102))))).o(new AnonymousClass3(r102, r103));
        r103.element = r105;
        r100.a(r105);
        return null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(f r100, Object r101) {
        return invoke2(r100, r101);
    }
}
