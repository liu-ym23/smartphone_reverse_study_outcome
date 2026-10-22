package com.obric.assistant.complex_task;

import com.larus.business.multitask_management.api.IMultiTaskService;
import com.larus.multitask_management.api.CancelFrom;
import com.larus.multitask_management.api.IMultiTaskHostAbility;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kl9.u;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MultiComplexTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f387912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f387913b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f387914c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f387915d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Job f387916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f387917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MultiComplexTaskManager$dmStateListener$1 f387918g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MultiComplexTaskManager$sourceListener$1 f387919h = null;

    public static final class a implements il9.f {
        public a() {
        }

        @Override // il9.f
        public final void a() {
            pd6.b r100 = pd6.c.f528682a;
            il9.a r101 = (il9.a) pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));
            if (r101 == null) goto L6;
            r101.j3("omni", "complextask", MultiComplexTaskManager.f387919h);
            return;
        }
    }

    public MultiComplexTaskManager() {
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.obric.assistant.complex_task.MultiComplexTaskManager$sourceListener$1] */
    static {
        f387912a = new ConcurrentHashMap();
        f387913b = new ConcurrentHashMap();
        f387914c = new ConcurrentHashMap();
        f387915d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f387918g = new MultiComplexTaskManager$dmStateListener$1();
        f387919h = new MultiComplexTaskManager$sourceListener$1();
    }

    public static void c() {
        FLogger.f375446a.i("MultiComplexTaskManager", "MultiComplexTaskManager init");
        IMultiTaskService r100 = (IMultiTaskService) ServiceManager.get().getService(IMultiTaskService.class);
        if (r100 == null) goto L5;
        r100.init();
    L5:
        pd6.b r101 = pd6.c.f528682a;
        il9.a r102 = (il9.a) pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));
        if (r102 == null) goto L8;
        r102.C(new a());
    L8:
        il9.a r103 = (il9.a) pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));
        if (r103 == null) goto L11;
        r103.j3("omni", "complextask", f387919h);
    L11:
        com.obric.aiagent.assistant.idl.f.b(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class), new q());
        BuildersKt.launch$default(f387915d, null, null, new MultiComplexTaskManager$init$3(null), 3, null);
    }

    public static final boolean a(String r100) {
        if (Intrinsics.areEqual(r100, "fail_task") == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "stop_task") == true) goto L12;
        if (Intrinsics.areEqual(r100, "finish_task") == true) goto L12;
        if (Intrinsics.areEqual(r100, "cancel_queue") == true) goto L12;
        return false;
    }

    public static DMTaskInfo b(u r100) {
        if (r100 == null) goto L5;
        String r101 = r100.f503981c;
    L6:
        if (r100 == null) goto L10;
        Map<String, String> r102 = r100.f503997s;
        if (r102 == null) goto L10;
        String r103 = r102.get("original_msg_id");
    L11:
        IAgentDMStateManagerIDL r104 = com.obric.aiagent.assistant.idl.f.a(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class));
        if (r104 == null) goto L16;
        DMStateInfo r105 = r104.getCurrentDMSteate();
        if (r105 == null) goto L16;
        List<DMTaskState> r106 = r105.getActiveTasks();
    L18:
        if (r106 == null) goto L37;
        Iterator<T> r107 = r106.iterator();
    L21:
        if (r107.hasNext() == false) goto L30;
        Object r108 = r107.next();
        DMTaskState r109 = (DMTaskState) r108;
        if (r101 != null) goto L25;
    L27:
        boolean r110 = false;
    L28:
        if (r110 == false) goto L21;
    L31:
        DMTaskState r111 = (DMTaskState) r108;
        if (r111 == null) goto L37;
        DMTaskInfo r112 = r111.getTaskInfo();
        if (r112 == null) goto L37;
        return r112;
    L25:
        if (Intrinsics.areEqual(com.obric.assistant.utils.l.d(r109), r101) == false) goto L27;
        r110 = true;
        goto L28
    L30:
        r108 = null;
    L37:
        if (r106 == null) goto L71;
        Iterator<T> r113 = r106.iterator();
    L40:
        if (r113.hasNext() == false) goto L55;
        Object r114 = r113.next();
        DMTaskState r115 = (DMTaskState) r114;
        if (r103 == null) goto L52;
        DMTaskInfo r116 = r115.getTaskInfo();
        if (r116 == null) goto L48;
        IMMessage r117 = r116.getMessage();
        if (r117 == null) goto L48;
        String r118 = r117.getMessageId();
    L50:
        if (Intrinsics.areEqual(r118, r103) == false) goto L52;
        boolean r119 = true;
    L53:
        if (r119 == false) goto L40;
    L56:
        DMTaskState r120 = (DMTaskState) r114;
        if (r120 != null) goto L59;
        return null;
    L59:
        return r120.getTaskInfo();
    L48:
        r118 = null;
    L52:
        r119 = false;
        goto L53
    L55:
        r114 = null;
        goto L56
    L71:
        return null;
    L16:
        r106 = null;
    L10:
        r103 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public static boolean d(u r110, DMTaskInfo r111, CancelFrom r112) {
        Intrinsics.checkNotNullParameter(r112, "cancelFrom");
        if (r110 == null) goto L43;
        if (r111 != null) goto L43;
        if (r110.f503992n <= 0) goto L43;
        String r113 = r110.f503981c;
        if (r113 != null) goto L11;
    L14:
        boolean r114 = true;
    L15:
        if (r114 == false) goto L28;
        Map<String, String> r115 = r110.f503997s;
        if (r115 == null) goto L19;
        String r116 = r115.get("original_msg_id");
    L20:
        if (r116 != null) goto L22;
    L25:
        boolean r117 = true;
    L26:
        if (r117 == false) goto L28;
    L22:
        if (r116.length() == 0) goto L25;
        r117 = false;
        goto L26
    L19:
        r116 = null;
    L28:
        pd6.b r118 = pd6.c.f528682a;
        IMultiTaskHostAbility r119 = (IMultiTaskHostAbility) pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r119 == null) goto L39;
        Long r120 = Long.valueOf(r119.getServerTime());
        if (r120.longValue() <= 0) goto L33;
        boolean r100 = true;
    L34:
        if (r100 == true) goto L37;
        r120 = null;
    L37:
        if (r120 == null) goto L39;
        long r101 = r120.longValue();
    L41:
        if ((r101 - (r110.f503992n / 1000)) < 300000) goto L43;
        boolean r121 = true;
    L44:
        if (r121 == true) goto L46;
        return false;
    L46:
        if (r110 != null) goto L49;
        return false;
    L49:
        if (f387914c.putIfAbsent(r110.f503979a, Boolean.TRUE) == null) goto L51;
        return true;
    L51:
        ((ConcurrentHashMap) f387913b).remove(r110.f503979a);
        ((ConcurrentHashMap) f387912a).remove(r110.f503979a);
        FLogger.f375446a.w("MultiComplexTaskManager", "remove timeout task, taskId=" + r110.f503979a + ", referenceId=" + r110.f503981c + ", status=" + r110.f503985g + ", createTimeUs=" + r110.f503992n + ", cancelFrom=" + r112);
        BuildersKt.launch$default(f387915d, null, null, new MultiComplexTaskManager$removeTimeoutTaskIfNeeded$1(r110, r112, null), 3, null);
        return true;
    L33:
        r100 = false;
    L39:
        r101 = System.currentTimeMillis();
        goto L41
    L11:
        if (r113.length() == 0) goto L14;
        r114 = false;
    L43:
        r121 = false;
        goto L44
    }
}
