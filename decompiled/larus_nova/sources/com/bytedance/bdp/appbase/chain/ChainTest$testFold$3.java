package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;I)Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testFold$3 extends Lambda implements Function2<f, Integer, ArrayList<Integer>> {
    final /* synthetic */ Ref.IntRef $count;

    public ChainTest$testFold$3(Ref.IntRef r100) {
        this.$count = r100;
        super(2);
    }

    public final ArrayList<Integer> invoke(f r100, int r101) {
        int r102 = ChainTest.f200670a;
        if (r101 != 15) goto L5;
        boolean r103 = true;
    L6:
        ChainTest.a.a(r103, "result:" + r101 + " error");
        this.$count.element = 0;
        boolean r104 = BdpPool.isOnOWNPool();
        StringBuilder r105 = new StringBuilder("thread type error:");
        BdpTask r106 = BdpPool.curThreadTask();
        if (r106 == null) goto L9;
        BdpTask.TaskType r107 = r106.taskType;
    L10:
        r105.append(r107);
        ChainTest.a.a(r104, r105.toString());
        return CollectionsKt.arrayListOf(new Integer[]{1, 2, 3, 4, 5});
    L9:
        r107 = null;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ArrayList<Integer> invoke(f r100, Integer r101) {
        return invoke(r100, r101.intValue());
    }
}
