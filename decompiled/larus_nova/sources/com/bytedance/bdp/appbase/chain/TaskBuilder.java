package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.base.bdptask.TaskLifecycle;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
public abstract class TaskBuilder {
    public TaskBuilder() {
    }

    public abstract void b(f r100);

    /* JADX WARN: Type inference failed for: r5v0, types: [T, com.bytedance.bdp.appbase.base.bdptask.BdpTask$Stage] */
    public final BdpTask a(final f r110) {
        BdpTask.Builder r100 = r110.f200707m;
        if (r100 == null) goto L124;
        BdpTask r101 = r100.build();
        if (r101 == null) goto L129;
        BdpTask.Builder r102 = r101.newBuilder();
        Long r103 = Long.valueOf(r110.f200709o);
        boolean r104 = false;
        if (r103.longValue() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L16;
        r102.delayedMillis(r103.longValue());
        r110.f200709o = 0;
    L16:
        final Ref.IntRef r106 = new Ref.IntRef();
        r106.element = 0;
        final Ref.ObjectRef r107 = new Ref.ObjectRef();
        r107.element = BdpTask.Stage.CREATE;
        if (r101.isDefTaskType == false) goto L33;
        BdpTask r108 = BdpPool.curThreadTask();
        if (r108 == null) goto L23;
        BdpTask.TaskType r109 = r108.taskType;
        if (r109 == null) goto L23;
    L32:
        r102.taskType(r109);
    L23:
        if (BdpPool.isOnMain() == false) goto L26;
        r109 = BdpTask.TaskType.MAIN;
        goto L32
    L26:
        if (BdpPool.isOnLogic() == false) goto L29;
        r109 = BdpTask.TaskType.LOGIC;
        goto L32
    L29:
        if (BdpPool.isOnIOPool() == false) goto L31;
        r109 = BdpTask.TaskType.IO;
        goto L32
    L31:
        r109 = BdpTask.TaskType.CPU;
    L33:
        TaskLifecycle r111 = r101.lifecycle;
        if (r111 == null) goto L38;
        r111.refreshState();
        if (Intrinsics.areEqual(r111.getCurState(), TaskLifecycle.State.Destroy.INSTANCE) == false) goto L38;
        r110.f200699e = new e(new CancelEvent("task lifecycle already destroy"));
        r102.lifecycle(null);
    L38:
        final Function1<BdpTask.Stage, Unit> r112 = r101.stageListener;
        r102.stageListener(new TaskBuilder$buildTask$4(r110, r106, r107, r112));
        r102.runnable(new TaskBuilder$checkNeedPostTask$1(this, r110));
        BdpTask r113 = r102.build();
        TaskLifecycle r114 = r113.lifecycle;
        if (r114 == null) goto L42;
        r114.refreshState();
    L108:
        if (r113 == null) goto L127;
        int r115 = r113.taskId;
        r106.element = r115;
        ArrayList<Integer> r116 = r110.f200701g;
        monitor-enter(r116);
    L121:
        th = move-exception;
        throw th;
    L112:
        if (r110.f200705k == false) goto L114;
    L116:
        boolean r117 = r110.f200705k;     // Catch: Throwable -> L121
        monitor-exit(r116);
        if (r117 == false) goto L128;
        BdpPool.cancelTask(r115);
    L128:
        return r113;
    L114:
        if (r110.f200701g.contains(Integer.valueOf(r115)) == true) goto L116;
        r110.f200701g.add(Integer.valueOf(r115));     // Catch: Throwable -> L121
        goto L116
    L127:
        return null;
    L42:
        if (Intrinsics.areEqual(r110.f200708n, i0.a.f200742a) == true) goto L108;
        if (r113.delayMillis > 0) goto L108;
        if (Intrinsics.areEqual(r110.f200708n, i0.c.f200744a) == true) goto L49;
        int r118 = h0.f200741b[r113.taskType.ordinal()];
        if (r118 == 1) goto L86;
        if (r118 == 2) goto L83;
        if (r118 == 3) goto L80;
        if (r118 == 4) goto L77;
        if (r118 != 5) goto L75;
        if (BdpPool.isOnIOPool() == false) goto L87;
    L88:
        boolean r119 = false;
    L89:
        if (r119 == true) goto L108;
    L92:
        if (r113.group != null) goto L94;
    L102:
        BdpTask r120 = BdpPool.curThreadTask();
        if (r120 == null) goto L105;
        r104 = !Intrinsics.areEqual(r113.group, r120.group);
    L105:
        if (r104 == true) goto L108;
        r113 = null;
        goto L108
    L94:
        if (r113.taskType != BdpTask.TaskType.MAIN) goto L98;
        if (BdpPool.isOnMain() == true) goto L102;
    L98:
        if (r113.taskType == BdpTask.TaskType.LOGIC) goto L100;
    L101:
        r104 = true;
        goto L102
    L100:
        if (BdpPool.isOnLogic() == true) goto L102;
    L87:
        r119 = true;
        goto L89
    L75:
        throw new NoWhenBranchMatchedException();
    L77:
        if (BdpPool.isOnCPUPool() == true) goto L88;
    L80:
        if (BdpPool.isOnOWNPool() == true) goto L88;
    L83:
        if (BdpPool.isOnLogic() == true) goto L88;
    L86:
        if (BdpPool.isOnMain() == true) goto L88;
    L49:
        if (h0.f200740a[r113.taskType.ordinal()] == 1) goto L56;
        if (BdpPool.isOnMain() == false) goto L53;
    L57:
        boolean r121 = true;
    L59:
        if (r121 == false) goto L92;
    L53:
        if (BdpPool.curThreadTask() == null) goto L57;
    L58:
        r121 = false;
        goto L59
    L56:
        if (BdpPool.isOnMain() == true) goto L58;
    L10:
        r105 = false;
        goto L11
    L129:
        return null;
    L124:
        return null;
    }
}
