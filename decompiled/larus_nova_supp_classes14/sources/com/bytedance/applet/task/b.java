package com.bytedance.applet.task;

import android.os.Bundle;
import aw3.q0;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.KeepAliveRequester;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.applet.view.AppletActivity;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.audioplayer.api.stream.StreamPlayerStatus;
import com.larus.common.apphost.AppHost;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskKey;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.multitask_management.api.data.TaskUITemplate;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kl9.l0;
import kl9.p0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final b a = null;
    public static BaseMediaControlTask b;
    public static l c;
    public static m d;
    public static k e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PlaybackState.values().length];
            r0[PlaybackState.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PlaybackState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PlaybackState.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new b();
    }

    public b() {
    }

    public static void c(int r7) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MediaControlTaskManager$onMusicStatusChanged$1(r7, null), 3, null);
    }

    public static void d(UrlAudioPlayStatus r7) {
        Intrinsics.checkNotNullParameter(r7, "status");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MediaControlTaskManager$onPodcastStatusChanged$1(r7, null), 3, null);
    }

    public static void e(StreamPlayerStatus r7) {
        Intrinsics.checkNotNullParameter(r7, "status");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MediaControlTaskManager$onStreamingStatusChanged$1(r7, null), 3, null);
    }

    public static void b(q0 r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "state");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MediaControlTaskManager$onBackgroundAudioStatusChanged$1(r8, r7, null), 3, null);
    }

    public static final void a(b r22, TaskKey r23, PlaybackState r24, n r25, Function0 r26, Function1 r27) {
        r22.getClass();
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("processUpdate: taskKey = ");
        r4.append(r23);
        r4.append(", state = ");
        r4.append(r24);
        r4.append(", mediaInfo = ");
        r4.append(r25);
        r4.append(", currentTaskKey = ");
        BaseMediaControlTask r6 = b;
        String r7 = null;
        if (r6 == null) goto L5;
        TaskKey r8 = r6.b();
    L6:
        r4.append(r8);
        r3.i("MediaControlTaskManager", r4.toString());
        if (c != null) goto L10;
        l r5 = new l();
        c = r5;
        AppletAppManagerService.INSTANCE.registerAppLifecycleCallbacks(r5);
    L10:
        if (d != null) goto L15;
        m r9 = new m();
        d = r9;
        List r10 = com.bytedance.ai.view.popup.n.a;
        Intrinsics.checkNotNullParameter(r9, "callback");
        ArrayList r11 = (ArrayList) com.bytedance.ai.view.popup.n.a;
        if (r11.contains(r9) == true) goto L15;
        r11.add(r9);
    L15:
        if (e != null) goto L17;
        e = new k();
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(e);
    L17:
        int r12 = a.a[r24.ordinal()];
        boolean r13 = false;
        if (r12 != 1) goto L20;
        if (r25 != null) goto L69;
        r3.e("MediaControlTaskManager", "processUpdate PLAYING: mediaInfo is null, cannot play.");
        return;
    L69:
        BaseMediaControlTask r0 = b;
        if (r0 != null) goto L72;
    L75:
        r3.i("MediaControlTaskManager", "processUpdate PLAYING: task changed, create new task.");
        BaseMediaControlTask r1 = b;
        if (r1 == null) goto L78;
        r1.e();
    L78:
        b = (BaseMediaControlTask) r26.invoke();
    L79:
        BaseMediaControlTask r2 = b;
        if (r2 == null) goto L129;
        AppletAppManagerService r14 = AppletAppManagerService.INSTANCE;
        String r15 = r2.a;
        r14.getClass();
        AppletApplication r16 = AppletAppManagerService.a(r15);
        if (r16 == null) goto L84;
        Boolean r17 = Boolean.valueOf(!r16.m());
    L108:
        boolean r18 = r17.booleanValue();
    L110:
        r2.g(r18);
        String r19 = r25.b;
        String r110 = r25.c;
        String r111 = r25.d;
        Intrinsics.checkNotNullParameter(r19, "title");
        Intrinsics.checkNotNullParameter(r110, "subtitle");
        Intrinsics.checkNotNullParameter(r111, "iconUri");
        if (r2.d.length() != 0) goto L113;
        r13 = true;
    L113:
        if (r13 == false) goto L115;
        FLogger.a.e(r2.a(), "changeTaskCardToPlay: taskId is empty");
        return;
    L115:
        r2.b = BaseMediaControlTask.TaskCardStatus.PLAYING;
        FLogger r20 = FLogger.a;
        r20.i(r2.a(), "changeTaskCardToPlay: appId = " + r2.a + ", title = " + r19 + ", subtitle = " + r110 + ", iconUri = " + r111);
        AppletAppManagerService r21 = AppletAppManagerService.INSTANCE;
        String r28 = r2.a;
        r21.getClass();
        AppletApplication r29 = AppletAppManagerService.a(r28);
        if (r29 == null) goto L118;
        r20.i(r2.a(), "changeTaskCardToPlay: acquireKeepAlive, appId = " + r2.a);
        r29.b(KeepAliveRequester.AUDIO_PLAYER);
        r29.getLifecycle().addObserver(r2.c);
    L122:
        il9.a r30 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r30 == null) goto L149;
        String r31 = r2.d;
        if (r2.e == false) goto L127;
        TaskDisplayStatus r32 = TaskDisplayStatus.DISPLAYED;
    L128:
        TaskStatus r33 = TaskStatus.RUNNING;
        kl9.x r34 = new kl9.x(r19, r110, r111, null, null, null, null, TaskUITemplate.SINGLE_ICON.getValue(), 376);
        int r35 = j0.a;
        il9.a.a.a(r30, new p0(r31, null, new l0(r33, r32, r34, CollectionsKt.listOf(new kl9.p(j0.d(2131898857), "res:///2131243096", "sslocal://task_management/pause_task", null, null, MapsKt.mapOf(TuplesKt.to("click_from", "pause")), 116)), 4080)));
        return;
    L127:
        r32 = TaskDisplayStatus.HIDDEN;
        goto L128
    L149:
        return;
    L118:
        AppletRuntimeManager r36 = AppletRuntimeManager.INSTANCE;
        String r37 = r2.a;
        r36.getClass();
        AppletRuntime r38 = AppletRuntimeManager.i(null, null, r37);
        if (r38 == null) goto L121;
        r20.i(r2.a(), "changeTaskCardToPlay: keepAlive, appId = " + r2.a);
        r38.z();
        goto L122
    L121:
        r20.e(r2.a(), "changeTaskCardToPlay: keepAlive failed, appId = " + r2.a);
        goto L122
    L84:
        Iterator r39 = ((ArrayList) com.bytedance.ai.view.popup.n.b).iterator();
    L86:
        if (r39.hasNext() == false) goto L90;
        if (((WeakReference) r39.next()).get() != null) goto L86;
        r39.remove();
        goto L86
    L90:
        WeakReference r40 = (WeakReference) CollectionsKt.lastOrNull(com.bytedance.ai.view.popup.n.b);
        if (r40 == null) goto L93;
        AppletPopup r41 = (AppletPopup) r40.get();
    L94:
        if (r41 == null) goto L100;
        Bundle r42 = r41.getArguments();
        if (r42 == null) goto L98;
        String r43 = r42.getString("appId");
    L99:
        r18 = Boolean.valueOf(!Intrinsics.areEqual(r43, r2.a)).booleanValue();
        goto L110
    L98:
        r43 = null;
        goto L99
    L100:
        Object r44 = AppHost.a.a().getTopActivity();
        if ((r44 instanceof AppletActivity) == false) goto L103;
        AppletActivity r45 = (AppletActivity) r44;
    L104:
        if (r45 == null) goto L106;
        r17 = Boolean.valueOf(!Intrinsics.areEqual(r45.getAppId(), r2.a));
    L107:
        if (r17 != null) goto L108;
        r18 = true;
        goto L110
    L106:
        r17 = null;
        goto L107
    L103:
        r45 = null;
        goto L104
    L93:
        r41 = null;
        goto L94
    L129:
        r3.e("MediaControlTaskManager", "processUpdate: changeTaskCardToPlay failed, appId = " + r25.a);
        return;
    L72:
        if (((Boolean) r27.invoke(r0)).booleanValue() == false) goto L75;
        if (Intrinsics.areEqual(r0.a, r25.a) == true) goto L79;
    L20:
        if (r12 != 2) goto L22;
        BaseMediaControlTask r46 = b;
        if (r46 != null) goto L39;
        r3.e("MediaControlTaskManager", "processUpdate PAUSED: currentTask is null, ignore.");
        return;
    L39:
        if (((Boolean) r27.invoke(r46)).booleanValue() == true) goto L41;
        r3.e("MediaControlTaskManager", "processUpdate PAUSED: task type not match, ignore. current taskKey = " + r46.b() + ", update taskKey = " + r23);
        return;
    L41:
        String r47 = r46.a;
        if (r25 == null) goto L44;
        String r48 = r25.a;
    L46:
        if (Intrinsics.areEqual(r47, r48) == true) goto L52;
        StringBuilder r49 = new StringBuilder("processUpdate PAUSED: appId not match, ignore. current appId = ");
        r49.append(r46.a);
        r49.append(", update appId = ");
        if (r25 == null) goto L50;
        r7 = r25.a;
    L50:
        r49.append(r7);
        r3.e("MediaControlTaskManager", r49.toString());
        return;
    L52:
        if (r46.d.length() != 0) goto L54;
        r13 = true;
    L54:
        if (r13 == false) goto L56;
        r3.e(r46.a(), "changeTaskCardToPause: taskId is empty");
        return;
    L56:
        r3.i(r46.a(), "changeTaskCardToPause");
        if (r46.b == BaseMediaControlTask.TaskCardStatus.PLAYING) goto L59;
        r3.e(r46.a(), "changeTaskCardToPause: task is not playing");
        return;
    L59:
        r46.b = BaseMediaControlTask.TaskCardStatus.PAUSED;
        il9.a r50 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r50 == null) goto L144;
        String r51 = r46.d;
        if (r46.e == false) goto L64;
        TaskDisplayStatus r52 = TaskDisplayStatus.DISPLAYED;
    L65:
        TaskStatus r53 = TaskStatus.PAUSED;
        int r54 = j0.a;
        il9.a.a.a(r50, new p0(r51, null, new l0(r53, r52, null, CollectionsKt.listOf(new kl9.p(j0.d(2131898871), "res:///2131243099", "sslocal://task_management/start_task", null, null, MapsKt.mapOf(TuplesKt.to("click_from", "play")), 116)), 4084)));
        return;
    L64:
        r52 = TaskDisplayStatus.HIDDEN;
        goto L65
    L144:
        return;
    L44:
        r48 = null;
        goto L46
    L22:
        if (r12 != 3) goto L35;
        BaseMediaControlTask r55 = b;
        if (r55 != null) goto L26;
        r3.e("MediaControlTaskManager", "processUpdate STOPPED: currentTask is null, ignore.");
        return;
    L26:
        if (((Boolean) r27.invoke(r55)).booleanValue() == true) goto L28;
        r3.e("MediaControlTaskManager", "processUpdate STOPPED: task type not match, ignore. current taskKey = " + r55.b() + ", update taskKey = " + r23);
        return;
    L28:
        if (r25 != null) goto L30;
    L32:
        r55.e();
        b = null;
        return;
    L30:
        if (Intrinsics.areEqual(r55.a, r25.a) == true) goto L32;
        r3.e("MediaControlTaskManager", "processUpdate STOPPED: appId not match, ignore. current appId = " + r55.a + ", update appId = " + r25.a);
        return;
    L35:
        throw new NoWhenBranchMatchedException();
    L5:
        r8 = null;
        goto L6
    }
}
