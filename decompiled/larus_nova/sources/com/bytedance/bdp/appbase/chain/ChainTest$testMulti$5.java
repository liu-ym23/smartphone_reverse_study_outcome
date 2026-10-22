package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "Lcom/bytedance/bdp/appbase/chain/c0;", "", PriorityModule.SCENE_MULTI, AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Lcom/bytedance/bdp/appbase/chain/c0;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testMulti$5 extends Lambda implements Function2<f, c0<String, String, String>, String> {
    public static final ChainTest$testMulti$5 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testMulti$5();
    }

    public ChainTest$testMulti$5() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(f r100, c0<String, String, String> r101) {
        int r102 = ChainTest.f200670a;
        boolean r103 = BdpPool.isOnIOPool();
        StringBuilder r104 = new StringBuilder("thread type error:");
        BdpTask r105 = BdpPool.curThreadTask();
        if (r105 == null) goto L5;
        BdpTask.TaskType r106 = r105.taskType;
    L6:
        r104.append(r106);
        ChainTest.a.a(r103, r104.toString());
        StringBuilder r107 = new StringBuilder();
        r101.getClass();
        String r108 = (String) null;
        r107.append(null);
        r107.append(",");
        r101.getClass();
        String r109 = (String) null;
        r107.append(null);
        r107.append(",");
        r101.getClass();
        String r110 = (String) null;
        r107.append(null);
        return r107.toString();
    L5:
        r106 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(f r100, c0<String, String, String> r101) {
        return invoke2(r100, r101);
    }
}
