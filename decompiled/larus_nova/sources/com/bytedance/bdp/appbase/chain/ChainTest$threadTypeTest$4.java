package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "Lcom/bytedance/bdp/appbase/chain/Chain;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/String;)Lcom/bytedance/bdp/appbase/chain/Chain;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$threadTypeTest$4 extends Lambda implements Function2<f, String, Chain<String>> {
    public static final ChainTest$threadTypeTest$4 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$threadTypeTest$4();
    }

    public ChainTest$threadTypeTest$4() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Chain<String> invoke2(f r100, String r101) {
        AtomicInteger r102 = Chain.f200668k;
        Chain r103 = Chain.Companion.a();
        r103.q();
        return r103.o(AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Chain<String> invoke(f r100, String r101) {
        return invoke2(r100, r101);
    }
}
