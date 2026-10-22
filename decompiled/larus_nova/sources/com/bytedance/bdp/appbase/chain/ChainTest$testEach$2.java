package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/util/ArrayList;)Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testEach$2 extends Lambda implements Function2<f, ArrayList<Integer>, ArrayList<Integer>> {
    public static final ChainTest$testEach$2 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testEach$2();
    }

    public ChainTest$testEach$2() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ArrayList<Integer> invoke2(f r100, ArrayList<Integer> r101) {
        int r102 = ChainTest.f200670a;
        boolean r103 = BdpPool.isOnIOPool();
        StringBuilder r104 = new StringBuilder("thread type error:");
        BdpTask r105 = BdpPool.curThreadTask();
        if (r105 == null) goto L5;
        BdpTask.TaskType r106 = r105.taskType;
    L6:
        r104.append(r106);
        ChainTest.a.a(r103, r104.toString());
        return r101;
    L5:
        r106 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ArrayList<Integer> invoke(f r100, ArrayList<Integer> r101) {
        return invoke2(r100, r101);
    }
}
