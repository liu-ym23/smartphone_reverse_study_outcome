package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Lcom/bytedance/bdp/appbase/chain/f;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Chain$getOrThrow$3 extends Lambda implements Function1<f, Unit> {
    public static final Chain$getOrThrow$3 INSTANCE = null;

    static {
        INSTANCE = new Chain$getOrThrow$3();
    }

    public Chain$getOrThrow$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100) {
        BdpTask r101 = BdpPool.curThreadTask();
        if (r101 == null) goto L5;
    L8:
        r100.f200715u = r101;
        r100.f200717w = Math.min(6, Math.max(0, 0));
        return;
    L5:
        if (BdpPool.isOnMain() == false) goto L7;
        r101 = new BdpTask.Builder().onMain().runnable(Chain$getOrThrow$3$1$1.INSTANCE).build();
        goto L8
    L7:
        r101 = null;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
