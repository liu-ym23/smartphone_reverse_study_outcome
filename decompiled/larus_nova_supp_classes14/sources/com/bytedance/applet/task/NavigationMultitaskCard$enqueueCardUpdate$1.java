package com.bytedance.applet.task;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskKey;
import com.larus.multitask_management.api.data.TaskPriority;
import com.larus.multitask_management.api.data.TaskReplaceStrategy;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.multitask_management.api.data.TaskType;
import com.larus.multitask_management.api.data.TaskUITemplate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kl9.l0;
import kl9.p0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.task.NavigationMultitaskCard$enqueueCardUpdate$1", f = "NavigationMultitaskCard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NavigationMultitaskCard$enqueueCardUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavigationMultitaskCard.b $data;
    final /* synthetic */ NavigationCardSessionState.a $owner;
    final /* synthetic */ boolean $preserveIcon;
    final /* synthetic */ boolean $transition;
    int label;

    public NavigationMultitaskCard$enqueueCardUpdate$1(NavigationCardSessionState.a r1, boolean r2, boolean r3, NavigationMultitaskCard.b r4, Continuation<? super NavigationMultitaskCard$enqueueCardUpdate$1> r5) {
        this.$owner = r1;
        this.$transition = r2;
        this.$preserveIcon = r3;
        this.$data = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new NavigationMultitaskCard$enqueueCardUpdate$1(this.$owner, this.$transition, this.$preserveIcon, this.$data, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r41) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L160;
        ResultKt.throwOnFailure(r41);
        NavigationCardSessionState r2 = NavigationMultitaskCard.e;
        if (r2.a(this.$owner) == false) goto L158;
        boolean r3 = true;
        if (this.$transition == true) goto L22;
        NavigationCardSessionState.a r0 = this.$owner;
        monitor-enter(r2);
        Intrinsics.checkNotNullParameter(r0, "expected");     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(r2.b, r0) == false) goto L15;
        if (r2.c != NavigationCardSessionState.Phase.ACTIVE) goto L15;
        boolean r1 = true;
    L16:
        monitor-exit(r2);
        if (r1 == true) goto L22;
    L15:
        r1 = false;
    L19:
        th = move-exception;
        throw th;
    L22:
        String r4 = NavigationMultitaskCard.d;
        if (r4 != null) goto L25;
    L28:
        boolean r5 = true;
    L30:
        if (this.$transition == false) goto L35;
        if (r5 == false) goto L35;
        return Unit.INSTANCE;
    L35:
        if (this.$preserveIcon == false) goto L44;
        NavigationMultitaskCard.b r6 = this.$data;
        NavigationMultitaskCard.b r7 = NavigationMultitaskCard.h;
        if (r7 == null) goto L39;
        String r8 = r7.c;
    L40:
        if (r7 == null) goto L42;
        String r9 = r7.d;
    L43:
        String r10 = r6.a;
        String r11 = r6.b;
        Intrinsics.checkNotNullParameter(r10, "title");
        NavigationMultitaskCard.b r12 = new NavigationMultitaskCard.b(r10, r11, r8, r9);
    L45:
        int r13 = com.larus.navigation.api.c.a;
        StringBuilder r14 = new StringBuilder("updateNavigation: enter firstCall=");
        r14.append(r5);
        r14.append(" currentTaskId=");
        String r15 = NavigationMultitaskCard.d;
        if (r15 != null) goto L48;
        r15 = "null";
    L48:
        r14.append(r15);
        r14.append(" title=");
        r14.append(this.$data.a);
        r14.append(" content=");
        r14.append(this.$data.b);
        r14.append(" iconUrl=");
        r14.append(this.$data.c);
        com.larus.navigation.api.c.d("nav_multitask_map", r14.toString());
        NavigationMultitaskCard.a.getClass();
        if (NavigationMultitaskCard.k != null) goto L52;
        x r16 = new x();
        gd9.i r17 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r17);
        r17.a().a(r16);
        NavigationMultitaskCard.k = r16;
    L52:
        AppletAppManagerService r18 = AppletAppManagerService.INSTANCE;
        r18.getClass();
        AppletApplication r19 = AppletAppManagerService.a("db_1GFLTGc");
        NavigationMultitaskCard.g(r19);
        if (NavigationMultitaskCard.j == null) goto L58;
        if (r19 == null) goto L56;
        AppletAppActivity r20 = r19.d;
    L57:
        NavigationMultitaskCard.c(r20);
        com.larus.navigation.api.c.d("nav_multitask_map", "registerLifecycleCallbacks: already registered, skip");
    L64:
        if (NavigationMultitaskCard.n == null) goto L66;
        com.larus.navigation.api.c.d("nav_multitask_map", "registerLegacyTaskObserver: already registered, skip");
    L71:
        if (Intrinsics.areEqual(NavigationMultitaskCard.h, r12) == false) goto L74;
        com.larus.navigation.api.c.d("nav_multitask_map", "updateNavigation: data unchanged, skipping IPC");
        return Unit.INSTANCE;
    L74:
        if (r5 == true) goto L76;
    L121:
        String r21 = NavigationMultitaskCard.d;
        if (r21 != null) goto L124;
    L127:
        boolean r22 = true;
    L128:
        if (r22 == false) goto L131;
        com.larus.navigation.api.c.b("nav_multitask_map", "updateNavigation: taskId went null after creation guard, aborting");
        return Unit.INSTANCE;
    L131:
        com.larus.navigation.api.c.d("nav_multitask_map", "updateNavigation: pushing updateLocalTask taskId=" + r21);
        NavigationMultitaskCard.a.getClass();
        il9.a r23 = NavigationMultitaskCard.k("updateNavigation");
        if (r23 == null) goto L134;
        String r24 = r12.c;
        if (r24 != null) goto L138;
        r24 = "";
    L138:
        String r110 = r24;
        String r25 = r12.d;
        if (r25 != null) goto L142;
        r25 = "";
    L142:
        if (r25.length() == 0) goto L145;
        r3 = false;
    L145:
        if (r3 == false) goto L147;
        String r111 = r110;
    L149:
        if (NavigationMultitaskCard.i == false) goto L151;
        TaskDisplayStatus r26 = TaskDisplayStatus.DISPLAYED;
    L152:
        TaskStatus r27 = TaskStatus.RUNNING;
        String r112 = r12.a;
        String r28 = r12.b;
        if (r28 != null) goto L155;
        r28 = "";
    L155:
        il9.a.a.a(r23, new p0(r21, null, new l0(r27, r26, new kl9.x(r112, r28, r110, r111, Boxing.boxDouble(6.0d), "#0000000F", "#FFFFFF14", TaskUITemplate.DEFAULT.getValue(), 256), null, 4088)));
        NavigationMultitaskCard.h = r12;
        com.larus.navigation.api.c.d("nav_multitask_map", "updateNavigation: updateLocalTask issued, lastUpdateData cached");
        return Unit.INSTANCE;
    L151:
        r26 = TaskDisplayStatus.HIDDEN;
        goto L152
    L147:
        r111 = r25;
        goto L149
    L134:
        return Unit.INSTANCE;
    L124:
        if (r21.length() == 0) goto L127;
        r22 = false;
        goto L128
    L76:
        if (r2.a(this.$owner) == false) goto L78;
        NavigationMultitaskCard.h("before_task_create");
        com.larus.navigation.api.c.d("nav_multitask_map", "updateNavigation: first call in this session, running Direction-1 preempt + createTask");
        com.larus.navigation.api.c.d("nav_multitask_map", "cancelLegacyIfRunning: enter — querying IMultiTaskManager for legacy slot 1/com.flow.locallife");
        il9.a r29 = NavigationMultitaskCard.k("cancelLegacyIfRunning");
        if (r29 != null) goto L82;
        com.larus.navigation.api.c.b("nav_multitask_map", "cancelLegacyIfRunning: Direction-1 preempt SKIPPED (SPI unavailable); legacy may run concurrently");
    L99:
        NavigationMultitaskCard r30 = NavigationMultitaskCard.a;
        r30.getClass();
        il9.a r31 = NavigationMultitaskCard.k("createTask");
        String r32 = "";
        if (r31 == null) goto L114;
        w r33 = new w();
        String r34 = r31.o0(new kl9.i("flow_navigation_db_1GFLTGc", TaskKey.NAVIGATION, TaskPriority.OTHER_TASK.getValue(), TaskType.LOCAL, NavigationMultitaskCard.i, null, null, new kl9.p(null, null, "sslocal://task_management/start_task", Boolean.TRUE, null, null, 215), new kl9.p(null, null, "sslocal://task_management/cancel_task", null, null, null, 247), new kl9.v(-1, 0, TaskReplaceStrategy.REPLACE_TASK_WITH_SAME_REFERENCE_ID_IN_PLACE, 2), MapsKt.mapOf(new Pair[]{TuplesKt.to("source_type", "map_navigation"), TuplesKt.to("source_id", "db_1GFLTGc")}), 103171), r33);
        if (r34 != null) goto L105;
    L108:
        boolean r35 = true;
    L110:
        if (r35 == false) goto L112;
        com.larus.navigation.api.c.b("nav_multitask_map", "createTask: createLocalTask returned null/empty (SPI responded but rejected)");
        goto L114
    L112:
        com.larus.navigation.api.c.d("nav_multitask_map", "createTask: taskId=" + r34 + " registered with controller#" + System.identityHashCode(r33));
        r32 = r34;
        goto L114
    L105:
        if (r34.length() == 0) goto L108;
        r35 = false;
    L114:
        if (r32.length() != 0) goto L116;
        boolean r36 = true;
    L117:
        if (r36 == false) goto L120;
        com.larus.navigation.api.c.b("nav_multitask_map", "updateNavigation: createTask failed, aborting update");
        return Unit.INSTANCE;
    L120:
        String r37 = NavigationMultitaskCard.d;
        NavigationMultitaskCard.d = r32;
        com.larus.navigation.api.c.d("nav_multitask_map", "updateNavigation: taskId assigned " + r37 + " → " + r32 + " thread=" + ThreadMethodProxy.currentThread().getName());
        NavigationMultitaskCard.a(r30);
        goto L121
    L116:
        r36 = false;
        goto L117
    L82:
        List r38 = r29.G1(new t());
        StringBuilder r39 = new StringBuilder("cancelLegacyIfRunning: snapshot total=");
        r39.append(r38.size());
        r39.append(" tasks=[");
        List r40 = r38;
        r39.append(CollectionsKt.joinToString$default(r40, null, null, null, 0, null, new u(), 31, null));
        r39.append(']');
        com.larus.navigation.api.c.d("nav_multitask_map", r39.toString());
        ArrayList r113 = new ArrayList();
        Iterator r42 = r40.iterator();
    L84:
        if (r42.hasNext() == false) goto L94;
        Object r43 = r42.next();
        kl9.u r44 = (kl9.u) r43;
        if (Intrinsics.areEqual(r44.u, CommentScene.COMMENTSCENE_NO_AWEME) == true) goto L88;
    L90:
        boolean r45 = false;
    L91:
        if (r45 == false) goto L84;
        r113.add(r43);
        goto L84
    L88:
        if (Intrinsics.areEqual(r44.v, "com.flow.locallife") == false) goto L90;
        r45 = true;
        goto L91
    L94:
        if (r113.isEmpty() == false) goto L96;
        com.larus.navigation.api.c.d("nav_multitask_map", "cancelLegacyIfRunning: no legacy task in snapshot, nothing to preempt");
        goto L99
    L96:
        int r46 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "cancelLegacyIfRunning: legacy task active (count=" + r113.size() + ", ids=[" + CollectionsKt.joinToString$default(r113, null, null, null, 0, null, new v(), 31, null) + "]), publishing flow.onNavigationCanceled (legacy event name — NOT renamed in protocol v2 because the receiver is the legacy mini-app that listens for flow.*)");
        Lazy r47 = l3.d.a;
        l3.d.c(new l3.a("flow.onNavigationCanceled", null, 6));
        NavigationMultitaskCard.c = System.currentTimeMillis();
        Function1 r48 = com.larus.navigation.api.o.a;
        Function1 r49 = com.larus.navigation.api.o.a;
        if (r49 == null) goto L99;
        r49.invoke(3000L);
        goto L99
    L78:
        return Unit.INSTANCE;
    L66:
        il9.a r50 = NavigationMultitaskCard.k("registerLegacyTaskObserver");
        if (r50 != null) goto L69;
        com.larus.navigation.api.c.b("nav_multitask_map", "registerLegacyTaskObserver: Direction-2 preempt DISABLED until SPI becomes available");
        goto L71
    L69:
        a0 r51 = new a0();
        r50.j3(CommentScene.COMMENTSCENE_NO_AWEME, "com.flow.locallife", r51);
        NavigationMultitaskCard.n = r51;
        com.larus.navigation.api.c.d("nav_multitask_map", "registerLegacyTaskObserver: registered for 1/com.flow.locallife — listener will fire on any legacy task change");
        goto L71
    L56:
        r20 = null;
        goto L57
    L58:
        b0 r52 = new b0();
        NavigationMultitaskCard.j = r52;
        r18.registerAppLifecycleCallbacks(r52);
        AppletApplication r53 = AppletAppManagerService.a("db_1GFLTGc");
        if (r53 == null) goto L61;
        AppletAppActivity r54 = r53.d;
    L62:
        NavigationMultitaskCard.c(r54);
        com.larus.navigation.api.c.d("nav_multitask_map", "registerLifecycleCallbacks: registered AppLifecycleCallbacks for appId=db_1GFLTGc");
        goto L64
    L61:
        r54 = null;
        goto L62
    L42:
        r9 = null;
        goto L43
    L39:
        r8 = null;
        goto L40
    L44:
        r12 = this.$data;
        goto L45
    L25:
        if (r4.length() == 0) goto L28;
        r5 = false;
    L158:
        return Unit.INSTANCE;
    L160:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
