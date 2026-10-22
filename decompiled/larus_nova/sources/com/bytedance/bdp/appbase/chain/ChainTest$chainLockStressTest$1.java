package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "Ljava/util/ArrayList;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$chainLockStressTest$1 extends Lambda implements Function2<f, Object, ArrayList<Integer>> {
    public static final ChainTest$chainLockStressTest$1 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$chainLockStressTest$1();
    }

    public ChainTest$chainLockStressTest$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ArrayList<Integer> invoke2(f r100, Object r101) {
        ArrayList<Integer> r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (r103 >= 50) goto L6;
        r102.add(Integer.valueOf(r103));
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ArrayList<Integer> invoke(f r100, Object r101) {
        return invoke2(r100, r101);
    }
}
