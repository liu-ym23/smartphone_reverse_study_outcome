package com.bytedance.applet.task;

import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.multitask_management.api.data.TaskKey;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 extends BaseMediaControlTask {
    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final String a() {
        return "PodcastControlTask";
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void c() {
        FLogger.a.i("PodcastControlTask", "open media detail");
        Lazy r0 = l3.d.a;
        l3.d.c(new l3.a("flow.onOpenPlayingPodcast", null, 6));
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void d() {
        FLogger.a.i("PodcastControlTask", "pause media");
        NewsUrlAudioManagerDelegate r0 = NewsUrlAudioManagerDelegate.b;
        b88.d r1 = r0.c();
        if (r1 == null) goto L6;
        r0.g(r1.c, Integer.valueOf(r1.b), r1.d);
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void f() {
        FLogger.a.i("PodcastControlTask", "resume media");
        NewsUrlAudioManagerDelegate r0 = NewsUrlAudioManagerDelegate.b;
        b88.d r1 = r0.c();
        if (r1 == null) goto L6;
        r0.i(r1, null);
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final void h() {
        FLogger.a.i("PodcastControlTask", "stop media");
        NewsUrlAudioManagerDelegate r0 = NewsUrlAudioManagerDelegate.b;
        b88.d r1 = r0.c();
        if (r1 == null) goto L6;
        r0.d(r1.c, Integer.valueOf(r1.b), r1.d);
        return;
    }

    @Override // com.bytedance.applet.task.BaseMediaControlTask
    public final TaskKey b() {
        return TaskKey.PODCAST;
    }

    public c0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        super(r2);
    }
}
