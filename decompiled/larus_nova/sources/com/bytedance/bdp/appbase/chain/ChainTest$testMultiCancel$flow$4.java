package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "Lcom/bytedance/bdp/appbase/chain/c0;", "", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Lcom/bytedance/bdp/appbase/chain/c0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testMultiCancel$flow$4 extends Lambda implements Function2<f, c0<Unit, Unit, Unit>, Unit> {
    public static final ChainTest$testMultiCancel$flow$4 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testMultiCancel$flow$4();
    }

    public ChainTest$testMultiCancel$flow$4() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100, c0<Unit, Unit, Unit> r101) {
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(f r100, c0<Unit, Unit, Unit> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
