package com.bytedance.applet.task;

import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import com.larus.multitask_management.api.data.TaskKey;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 extends BaseMediaControlTask {
    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final String a() {
        return "StreamAudioControlTask";
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void c() {
        FLogger.a.i("StreamAudioControlTask", "open media detail");
        Lazy r0 = l3.d.a;
        l3.d.c(new l3.a("flow.onOpenPlayingPodcast", null, 6));
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void d() {
        FLogger.a.i("StreamAudioControlTask", "pause media");
        AudioStreamPlayerDelegate r0 = AudioStreamPlayerDelegate.b;
        c88.a r1 = r0.f();
        if (r1 == null) goto L6;
        r0.j(r1.f, "control_task");
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void f() {
        FLogger.a.i("StreamAudioControlTask", "resume media");
        AudioStreamPlayerDelegate r0 = AudioStreamPlayerDelegate.b;
        c88.a r1 = r0.f();
        if (r1 == null) goto L6;
        r0.e(r1.f, "control_task");
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void h() {
        FLogger.a.i("StreamAudioControlTask", "stop media");
        AudioStreamPlayerDelegate r0 = AudioStreamPlayerDelegate.b;
        c88.a r1 = r0.f();
        if (r1 == null) goto L6;
        r0.a(r1.f, "control_task");
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final TaskKey b() {
        return TaskKey.STREAMING_PODCAST;
    }

    public d0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        super(r2);
    }
}
