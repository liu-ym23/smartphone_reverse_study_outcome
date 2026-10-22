package com.bytedance.applet.task;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.applet.view.AppletActivity;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.common.apphost.AppHost;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskKey;
import com.larus.multitask_management.api.data.TaskPriority;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.multitask_management.api.data.TaskType;
import com.larus.multitask_management.api.data.TaskUITemplate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.UUID;
import kl9.l0;
import kl9.p0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.task.NavigationControlTask$updateNavigation$1", f = "NavigationControlTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NavigationControlTask$updateNavigation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Integer $customIconId;
    final /* synthetic */ String $iconUrl;
    final /* synthetic */ String $title;
    private /* synthetic */ Object L$0;
    int label;

    public NavigationControlTask$updateNavigation$1(String r1, String r2, Integer r3, String r4, Continuation<? super NavigationControlTask$updateNavigation$1> r5) {
        this.$title = r1;
        this.$content = r2;
        this.$customIconId = r3;
        this.$iconUrl = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        NavigationControlTask$updateNavigation$1 r6 = new NavigationControlTask$updateNavigation$1(this.$title, this.$content, this.$customIconId, this.$iconUrl, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L71;
        ResultKt.throwOnFailure(r35);
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        String r2 = p.a;
        if (p.b != null) goto L7;
        p.b = new q();
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(p.b);
    L7:
        p.a r3 = new p.a(this.$title, this.$content, this.$customIconId, this.$iconUrl);
        if (Intrinsics.areEqual(p.d, r3) == false) goto L11;
        FLogger.a.i("NavigationControlTask", "updateNavigationStatus: no change");
        return Unit.INSTANCE;
    L11:
        p.d = r3;
        String r4 = p.a;
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L34;
        il9.a r6 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r6 == null) goto L23;
        String r7 = r6.o0(new kl9.i(UUID.randomUUID().toString(), TaskKey.NAVIGATION, TaskPriority.OTHER_TASK.getValue(), TaskType.LOCAL, false, null, null, new kl9.p(null, null, "sslocal://task_management/start_task", Boolean.TRUE, null, null, 215), new kl9.p(null, null, "sslocal://task_management/cancel_task", null, null, null, 247), new kl9.v(-1, 0, null, 6), MapsKt.mapOf(new Pair[]{TuplesKt.to("source_id", "com.flow.locallife"), TuplesKt.to("source_type", CommentScene.COMMENTSCENE_NO_AWEME)}), 103171), p.c);
    L24:
        FLogger r8 = FLogger.a;
        r8.i("NavigationControlTask", "createTask: taskId=" + r7);
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        p.a = r7;
        if (r7.length() != 0) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L34;
        r8.e("NavigationControlTask", "updateNavigationStatus: createTask failed");
        return Unit.INSTANCE;
    L30:
        r9 = false;
        goto L31
    L23:
        r7 = null;
    L34:
        FLogger r10 = FLogger.a;
        r10.i("NavigationControlTask", "updateNavigationStatus: title = " + this.$title + ", content = " + this.$content + ", customIconId = " + this.$customIconId + ", iconUrl = " + this.$iconUrl);
        Object r11 = AppHost.a.a().getTopActivity();
        if ((r11 instanceof AppletActivity) == true) goto L37;
    L40:
        boolean r12 = true;
    L41:
        p.a(r12);
        Integer r13 = this.$customIconId;
        if (r13 == null) goto L45;
        String r14 = "res:///" + r13.intValue();
        if (r14 == null) goto L45;
    L48:
        String r15 = r14;
    L49:
        il9.a r16 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r16 == null) goto L64;
        String r17 = p.a;
        if (r17 != null) goto L54;
        String r18 = "";
    L56:
        if (p.e == false) goto L58;
        TaskDisplayStatus r19 = TaskDisplayStatus.DISPLAYED;
    L59:
        TaskDisplayStatus r110 = r19;
        TaskStatus r111 = TaskStatus.RUNNING;
        String r20 = this.$content;
        if (r20 != null) goto L62;
        String r112 = "";
    L63:
        Boxing.boxBoolean(r16.P(new p0(r18, null, new l0(r111, r110, new kl9.x(this.$title, r112, r15, null, Boxing.boxDouble(6.0d), r.a(2131102500), r.a(2131102501), TaskUITemplate.DEFAULT.getValue(), 264), null, 4088)), true));
        goto L64
    L62:
        r112 = r20;
        goto L63
    L58:
        r19 = TaskDisplayStatus.HIDDEN;
        goto L59
    L54:
        r18 = r17;
    L64:
        AppletRuntimeManager.INSTANCE.getClass();
        AppletRuntime r21 = AppletRuntimeManager.i(null, null, "com.flow.locallife");
        if (r21 == null) goto L67;
        r21.z();
    L69:
        return Unit.INSTANCE;
    L67:
        r10.e("NavigationControlTask", "updateNavigationStatus: keepAlive failed");
    L45:
        r14 = this.$iconUrl;
        if (r14 != null) goto L48;
        r15 = "";
        goto L49
    L37:
        if (Intrinsics.areEqual(((AppletActivity) r11).getAppId(), "com.flow.locallife") == false) goto L40;
        r12 = false;
        goto L41
    L14:
        if (r4.length() == 0) goto L17;
        r5 = false;
        goto L19
    L71:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
