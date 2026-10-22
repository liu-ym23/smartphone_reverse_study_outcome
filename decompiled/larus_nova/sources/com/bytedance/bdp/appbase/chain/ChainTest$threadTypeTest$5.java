package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$threadTypeTest$5 extends Lambda implements Function2<f, String, Unit> {
    public static final ChainTest$threadTypeTest$5 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$threadTypeTest$5();
    }

    public ChainTest$threadTypeTest$5() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100, String r101) {
        int r102 = ChainTest.f200670a;
        ChainTest.a.a(BdpPool.isOnCPUPool(), "must on cpu pool");
        ChainTest.a.a(Intrinsics.areEqual(r101, "4"), "value error");
        if (q94.a.f532095a == false) goto L6;
        g94.b.a("CnTest", new Object[]{"threadTypeTest success"});
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(f r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
