package com.bytedance.applet.task;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.larus.audioplayer.api.music.IMusicPlayManager;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.business.multitask_management.api.IMultiTaskService;
import com.larus.multitask_management.api.data.TaskKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends BaseMediaControlTask {
    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final String a() {
        return "MusicControlTask";
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void c() {
        FLogger r0 = FLogger.a;
        r0.i("MusicControlTask", "open media detail");
        AppletAppManagerService r2 = AppletAppManagerService.INSTANCE;
        String r3 = this.a;
        r2.getClass();
        AppletApplication r4 = AppletAppManagerService.a(r3);
        if (r4 == null) goto L9;
        com.bytedance.ai.applet.app.foundation.j r1 = r4.h().e();
        IMultiTaskService r5 = (IMultiTaskService) ServiceManager.get().getService(IMultiTaskService.class);
        if (r5 == null) goto L7;
        String r6 = r5.i();
    L8:
        r1.b = r6;
    L10:
        Lazy r7 = l3.d.a;
        l3.a r8 = new l3.a("flow.onOpenPlayingMusic", null, 6);
        r8.d = this.a;
        l3.d.c(r8);
        return;
    L7:
        r6 = null;
        goto L8
    L9:
        r0.e("MusicControlTask", "openMusicDetail: but applet app is null");
        goto L10
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void d() {
        FLogger.a.i("MusicControlTask", "pause media");
        MusicPlayManagerDelegate r0 = MusicPlayManagerDelegate.b;
        a88.e r1 = r0.a();
        if (r1 == null) goto L8;
        String r2 = r1.a;
        if (r2 == null) goto L9;
        r0.j(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void f() {
        FLogger.a.i("MusicControlTask", "resume media");
        MusicPlayManagerDelegate r3 = MusicPlayManagerDelegate.b;
        a88.e r4 = r3.a();
        if (r4 == null) goto L6;
        IMusicPlayManager.a.a(r3, r4, null, null, false, 30);
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void h() {
        FLogger.a.i("MusicControlTask", "stop media");
        MusicPlayManagerDelegate r0 = MusicPlayManagerDelegate.b;
        a88.e r1 = r0.a();
        if (r1 == null) goto L8;
        String r2 = r1.a;
        if (r2 == null) goto L9;
        r0.c(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final TaskKey b() {
        return TaskKey.MUSIC;
    }

    public o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        super(r2);
    }
}
