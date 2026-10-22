package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Lcom/bytedance/bdp/appbase/chain/f;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Chain$getOrThrow$1 extends Lambda implements Function2<f, Object, Unit> {
    final /* synthetic */ CountDownLatch $latch;
    final /* synthetic */ Ref.ObjectRef $result;

    public Chain$getOrThrow$1(Ref.ObjectRef r100, CountDownLatch r101) {
        this.$result = r100;
        this.$latch = r101;
        super(2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.bdp.appbase.chain.g0] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100, Object r101) {
        Ref.ObjectRef r102 = this.$result;
        r102.element = new g0(r101);
        this.$latch.countDown();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(f r100, Object r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
