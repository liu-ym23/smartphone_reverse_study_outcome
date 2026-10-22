package com.bytedance.live.livelink.kmp.impl.core.video.pipeline.subscribe.process;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class e extends yi6.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f255510f;

    public static final class a {
    }

    static {
    }

    @Override // yi6.c, qi6.f
    public final void i() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeMixerFilterNode", this.f255510f + " start");
        qi6.e.f(this);
    }

    @Override // yi6.c, qi6.f
    public void init() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeMixerFilterNode", this.f255510f + " init");
        qi6.e.a(this);
    }

    @Override // yi6.c, qi6.f
    public final void pause() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeMixerFilterNode", this.f255510f + " pause");
        qi6.e.b(this);
    }

    @Override // yi6.c, qi6.f
    public void release() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeMixerFilterNode", this.f255510f + " destroy");
    }

    @Override // yi6.c, qi6.f
    public final void resume() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeMixerFilterNode", this.f255510f + " resume");
        qi6.e.e(this);
    }

    @Override // yi6.c, qi6.f
    public void stop() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeMixerFilterNode", this.f255510f + " stop");
        qi6.e.g(this);
    }

    @Override // qi6.f
    public final String getName() {
        return this.f255510f;
    }

    public e(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        super(r100);
        this.f255510f = "VideoSubscribeMixerFilterNode";
    }

    @Override // yi6.c, qi6.f
    public void m(qi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        qi6.e.c(this, r100);
    }
}
