package fs2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.room.Task.LiveTaskException;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdk.room.Task.base.LiveTask;
import com.bytedance.android.livesdk.room.Task.execute.e;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public a() {
    }

    public static void a(String r110, List r111, com.bytedance.android.livesdk.room.a.b r112) {
        Intrinsics.checkNotNullParameter(r110, "nodeName");
        Intrinsics.checkNotNullParameter(r111, "list");
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L114:
        int r113 = hs2.b.f486950a;
        hs2.b.b("the node  " + r110 + " tasks was empty");
        return;
    L5:
        if (r111.isEmpty() == true) goto L114;
        com.bytedance.android.livesdk.room.Task.base.b.a r100 = new com.bytedance.android.livesdk.room.Task.base.b.a();
        Intrinsics.checkNotNullParameter(r110, "groupName");
        r100.f157581a = r110;
        Intrinsics.checkNotNullParameter(r111, "tasks");
        Iterator r114 = r111.iterator();
    L9:
        if (r114.hasNext() == false) goto L11;
        LiveTask r115 = (LiveTask) r114.next();
        Intrinsics.checkNotNullParameter(r115, "liveTask");
        ((ArrayList) r100.f157582b).add(r115);
        r115.c();
        r100.f157588h.incrementAndGet();
        goto L9
    L11:
        r100.f157590j.add(r112);
        int r116 = e.f157606a;
        List<LiveTask> r117 = r100.f157582b;
        Map<String, LiveTask> r118 = r100.f157583c;
        Map<String, ArrayList<LiveTask>> r119 = r100.f157584d;
        Intrinsics.checkNotNullParameter(r117, "list");
        Intrinsics.checkNotNullParameter(r118, "taskMap");
        Intrinsics.checkNotNullParameter(r119, "taskChildMap");
        ArrayList r101 = new ArrayList();
        ArrayDeque r102 = new ArrayDeque();
        HashMap r103 = new HashMap();
        ArrayList r104 = new ArrayList();
        if (c.a().b() == true) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L21;
        ArrayList r106 = (ArrayList) r117;
        if (r106.size() <= 1) goto L21;
        CollectionsKt.sortWith(r106, new com.bytedance.android.livesdk.room.Task.execute.d());
    L21:
        ArrayList r120 = (ArrayList) r117;
        Iterator r107 = r120.iterator();
    L23:
        if (r107.hasNext() == false) goto L35;
        LiveTask r108 = (LiveTask) r107.next();
        String r109 = r108.taskID();
        if (r103.containsKey(r109) == true) goto L34;
        r104.add(r109);
        List<String> r121 = r108.f();
        if (r121 == null) goto L29;
        Integer r122 = Integer.valueOf(r121.size());
    L30:
        int r123 = r122.intValue();
        r103.put(r109, Integer.valueOf(r123));
        ((HashMap) r118).put(r109, r108);
        if (r123 != 0) goto L23;
        r102.offer(r108);
        goto L23
    L29:
        r122 = null;
        goto L30
    L34:
        throw new LiveTaskException("task is repeat, the task ID： " + r109);
    L35:
        Iterator r124 = r120.iterator();
    L37:
        if (r124.hasNext() == false) goto L52;
        LiveTask r125 = (LiveTask) r124.next();
        List<String> r126 = r125.f();
        if (r126 == null) goto L37;
        Iterator<T> r127 = r126.iterator();
    L42:
        if (r127.hasNext() == false) goto L37;
        String r128 = (String) r127.next();
        if (r104.contains(r128) == false) goto L50;
        HashMap r129 = (HashMap) r119;
        ArrayList r130 = (ArrayList) r129.get(r128);
        if (r130 != null) goto L48;
        r130 = new ArrayList();
    L48:
        r130.add(r125);
        r129.put(r128, r130);
        goto L42
    L50:
        throw new LiveTaskException("the task " + r125.taskID() + " depends " + r128 + " not found！");
    L52:
        if (r102.isEmpty() == true) goto L66;
        LiveTask r131 = (LiveTask) r102.pop();
        r101.add(r131);
        ArrayList r132 = (ArrayList) ((HashMap) r119).get(r131.taskID());
        if (r132 == null) goto L52;
        Iterator r133 = r132.iterator();
    L57:
        if (r133.hasNext() == false) goto L52;
        LiveTask r134 = (LiveTask) r133.next();
        String r135 = r134.taskID();
        Integer r136 = (Integer) r103.get(r135);
        if (r136 != null) goto L61;
        r136 = 0;
    L61:
        int r137 = r136.intValue() - 1;
        if (r137 != 0) goto L64;
        r102.offer(r134);
    L64:
        r103.put(r135, Integer.valueOf(r137));
        goto L57
    L66:
        if (r120.size() != r101.size()) goto L113;
        StringBuilder r138 = new StringBuilder("Node:::  " + r100.f157581a + " ，拓扑排序后 :  ");
        Iterator r139 = r101.iterator();
    L69:
        if (r139.hasNext() == false) goto L71;
        r138.append(((LiveTask) r139.next()).taskID() + " -> ");
        goto L69
    L71:
        int r140 = hs2.b.f486950a;
        String r141 = r138.toString();
        Intrinsics.checkNotNullParameter(r141, "logMsg");
        pm0.b r142 = om0.c.f();
        if (r142 == null) goto L74;
        r142.i("LIVE_TASK_LOG", r141);
    L74:
        Iterator r143 = r101.iterator();
    L76:
        if (r143.hasNext() == false) goto L82;
        LiveTask r144 = (LiveTask) r143.next();
        if (r144.d() != LiveTaskType.ASYNC) goto L80;
        ((ArrayList) r100.f157586f).add(r144);
    L81:
        ((HashMap) r100.f157589i).put(r144.taskID(), new AtomicInteger(r144.f().size()));
        goto L76
    L80:
        ((ArrayList) r100.f157585e).add(r144);
        goto L81
    L82:
        r100.f157587g = new CountDownLatch(r100.f157588h.get());
        com.bytedance.android.livesdk.room.Task.base.b r145 = new com.bytedance.android.livesdk.room.Task.base.b(r100);
        hs2.c r146 = r145.f157575j;
        r146.getClass();
        r146.f486952b = System.currentTimeMillis();
        int r147 = hs2.b.f486950a;
        hs2.b.a("Group: " + r146.f486954d + ":::::   group start execute time  :  " + r146.f486952b);
        Iterator<gs2.d> r148 = r145.f157574i.iterator();
    L84:
        if (r148.hasNext() == false) goto L87;
        r148.next().b();
        goto L84
    L87:
        if (r145.f157576k == false) goto L103;
        List<LiveTask> r149 = r145.f157580o.f157582b;
        ArrayList r150 = new ArrayList();
        Iterator r151 = ((ArrayList) r149).iterator();
    L90:
        if (r151.hasNext() == false) goto L99;
        Object r152 = r151.next();
        AtomicInteger r153 = (AtomicInteger) ((HashMap) r145.f157577l).get(((LiveTask) r152).taskID());
        if (r153 != null) goto L94;
    L96:
        boolean r154 = false;
    L97:
        if (r154 == false) goto L90;
        r150.add(r152);
        goto L90
    L94:
        if (r153.get() != 0) goto L96;
        r154 = true;
        goto L97
    L99:
        Iterator r155 = r150.iterator();
    L101:
        if (r155.hasNext() == false) goto L111;
        r145.a((LiveTask) r155.next());
        goto L101
    L111:
        return;
    L103:
        Iterator r156 = ((ArrayList) r145.f157571f).iterator();
    L105:
        if (r156.hasNext() == false) goto L107;
        r145.f157566a.execute(new com.bytedance.android.livesdk.room.Task.execute.b(r145, (LiveTask) r156.next()));
        goto L105
    L107:
        Iterator r157 = ((ArrayList) r145.f157570e).iterator();
    L109:
        if (r157.hasNext() == false) goto L151;
        new com.bytedance.android.livesdk.room.Task.execute.b(r145, (LiveTask) r157.next()).run();
        goto L109
    L151:
        return;
    L113:
        throw new LiveTaskException("Ring appeared，Please check! list is " + r120 + ",  result is " + r101);
    L14:
        if (c.a().e() == false) goto L16;
        r105 = true;
        goto L17
    }
}
