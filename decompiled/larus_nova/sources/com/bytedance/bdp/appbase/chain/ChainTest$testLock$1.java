package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testLock$1 extends Lambda implements Function1<f, Unit> {
    final /* synthetic */ int $i;
    final /* synthetic */ String $idKey;

    public ChainTest$testLock$1(String r100, int r101) {
        this.$idKey = r100;
        this.$i = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100) {
        String r101 = this.$idKey;
        Integer r102 = Integer.valueOf(this.$i);
        HashMap<String, Object> r103 = r100.e();
        monitor-enter(r103);
        r103.put(r101, r102);     // Catch: Throwable -> L7
        monitor-exit(r103);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
