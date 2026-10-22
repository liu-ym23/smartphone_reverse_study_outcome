package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"R", "Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Chain$getOrThrow$2 extends Lambda implements Function2<f, Throwable, Unit> {
    final /* synthetic */ Ref.ObjectRef $error;
    final /* synthetic */ CountDownLatch $latch;

    public Chain$getOrThrow$2(Ref.ObjectRef r100, CountDownLatch r101) {
        this.$error = r100;
        this.$latch = r101;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(f r100, Throwable r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100, Throwable r101) {
        this.$error.element = r101;
        this.$latch.countDown();
    }
}
