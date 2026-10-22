package com.larus.im.internal.rtcsdk.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.bytertc.engine.utils.IAudioFrame;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class m extends e implements ff9.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.im.service.audio.t f349931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final he9.c f349933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f349934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f349935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f349936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f349937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedBlockingQueue<g> f349938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedBlockingQueue<com.larus.im.service.audio.l> f349939i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PthreadThreadV2 f349940j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f349941k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f349942l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f349943m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f349944n;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f349945a;

        public final void a() {
            fe9.a.f476620a.e(this.f349945a.f349932b, "Capture Processing thread start loop");
        L4:
            if (Thread.interrupted() == true) goto L18;
            if (this.f349945a.f349942l == true) goto L18;
            g r100 = this.f349945a.f349938h.take();     // Catch: InterruptedException -> L16
            m r101 = this.f349945a;     // Catch: InterruptedException -> L16
            boolean r102 = r101.f349934d;     // Catch: InterruptedException -> L16
            if (r102 == false) goto L12;
            if (r101.f349935e == false) goto L12;
            com.larus.im.internal.utils.c r103 = (com.larus.im.internal.utils.c) r101.f349943m.getValue();     // Catch: InterruptedException -> L16
            Intrinsics.checkNotNull(r100);     // Catch: InterruptedException -> L16
            r103.b(r100);     // Catch: InterruptedException -> L16
        L12:
            if (r102 == true) goto L13;
            Intrinsics.checkNotNull(r100);     // Catch: InterruptedException -> L16
            r101.h(r100);     // Catch: InterruptedException -> L16
            goto L4
        L13:
            Intrinsics.checkNotNull(r100);     // Catch: InterruptedException -> L16
            g r104 = r101.i(r100);     // Catch: InterruptedException -> L16
            this.f349945a.h(r104);     // Catch: InterruptedException -> L16
        L16:
            ThreadMethodProxy.currentThread().interrupt();
        L18:
            if (this.f349945a.f349942l == false) goto L20;
            fe9.a.f476620a.e(this.f349945a.f349932b, "Capture Processing thread stopped by release");
            return;
        L20:
            fe9.a.f476620a.e(this.f349945a.f349932b, "Capture Processing thread stopped unexpectedly");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(m r100) {
            this.f349945a = r100;
        }
    }

    @Override // ff9.y
    public final void start() {
        l(true);
    }

    @Override // ff9.y
    public final void stop() {
        l(false);
    }

    public final void k() {
        if (this.f349936f <= 0) goto L6;
        fe9.a.f476620a.e(this.f349932b, "mute recording frameCount: " + this.f349936f);
        this.f349936f = 0;
        return;
    }

    public final void h(g r100) {
        com.larus.im.service.audio.l r101 = r100.f349863a;
        com.larus.im.service.audio.t r102 = this.f349931a;
        if ((r102 instanceof u1) == false) goto L5;
        u1 r103 = (u1) r102;
    L6:
        if (r103 == null) goto L8;
        r103.b(r101.f350772a.length);
    L8:
        com.larus.im.service.audio.l r104 = this.f349931a.a(r100.f349863a);
        this.f349939i.offer(r104);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final g i(g r100) {
        Pair<com.larus.im.service.audio.l, com.larus.im.service.audio.l> r101 = this.f349931a.c(r100.f349863a, r100.f349864b);
        if (r101 != null) goto L6;
        return r100;
    L6:
        return new g(r101.getFirst(), r101.getSecond());
    }

    public final void j(com.larus.im.service.audio.l r100) {
        long r101 = this.f349936f;
        this.f349936f = 1 + r101;
        if ((r101 % ((long) 10)) != 0) goto L6;
        fe9.a.f476620a.e(this.f349932b, "audio capture running, frameCount: " + this.f349936f + ", current extra: " + r100.f350773b);
        return;
    }

    public final void l(boolean r100) {
        if (this.f349937g == r100) goto L6;
        this.f349937g = r100;
        fe9.a.f476620a.e(this.f349932b, "set isRecording: " + r100 + ", inputQueueSize: " + this.f349938h.size() + ", productionQueueSize: " + this.f349939i.size());
        return;
    }

    @Override // com.larus.im.internal.rtcsdk.impl.e, com.ss.bytertc.engine.IAudioFrameProcessor
    public final int onProcessRecordAudioFrame(IAudioFrame r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (this.f349937g == true) goto L10;
        com.flow.kmp.common.util.b.c(r100.getDataBuffer());
        k();
        return 0;
    L10:
        if (this.f349944n != (-1)) goto L12;
        this.f349944n = r100.getDataBuffer().capacity();
        fe9.a.f476620a.a(this.f349932b, "frameSize: " + this.f349944n);
    L12:
        com.larus.im.internal.utils.x r101 = com.larus.im.internal.utils.x.f350563a;
        com.larus.im.internal.utils.x.f350567e.getClass();
        com.larus.im.service.audio.l r102 = new com.larus.im.service.audio.l(com.flow.kmp.common.util.b.e(r100.getDataBuffer()), new JSONObject().put("audioFrameMs", r100.captureTimestampMs()).toString(), new ue9.g.a(r100.sample_rate().value(), r100.channel().value()), false);
        com.larus.im.service.audio.t r103 = this.f349931a;
        if ((r103 instanceof u1) == false) goto L15;
        u1 r104 = (u1) r103;
    L16:
        if (r104 == null) goto L18;
        r104.b(r102.f350772a.length);
    L18:
        com.larus.im.service.audio.l r105 = this.f349931a.a(r102);
        if (Intrinsics.areEqual(r102, r105) == true) goto L26;
        com.flow.kmp.common.util.b.d(r100.getDataBuffer(), r105.f350772a);
        j(r105);
        he9.c r106 = this.f349933c;
        if (r106 == null) goto L24;
        byte[] r107 = r106.b(r105.f350773b);
        if (r107 == null) goto L24;
    L25:
        r100.setExtraInfo(ByteBuffer.wrap(r107));
    L24:
        r107 = new byte[0];
    L26:
        return 0;
    L15:
        r104 = null;
        goto L16
    }

    public m(he9.a r100, df9.d.b r101) {
        Intrinsics.checkNotNullParameter(r101, "preProcessor");
        this.f349931a = r101;
        this.f349932b = "FlowRTCAudioCaptureProcessor_" + hashCode();
        if (r100 == null) goto L5;
        ge9.d.c r102 = r100.b();
    L6:
        this.f349933c = r102;
        this.f349938h = new LinkedBlockingQueue();
        this.f349939i = new LinkedBlockingQueue();
        PthreadThreadV2 r103 = new PthreadThreadV2(new a(this), "AudioFrameCaptureThread");
        ThreadMethodProxy.setPriority(r103, 10);
        this.f349940j = r103;
        this.f349941k = 8;
        this.f349943m = LazyKt.lazy(new j(this));
        ThreadMethodProxy.start(r103);
        this.f349944n = -1;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void g(IAudioFrame r100, long r101) {
        if (r101 == 0) goto L5;
    L8:
        com.larus.im.service.audio.l r102 = this.f349939i.poll(r101, TimeUnit.MILLISECONDS);
        if (r102 == null) goto L16;
        com.flow.kmp.common.util.b.d(r100.getDataBuffer(), r102.f350772a);
        j(r102);
        he9.c r103 = this.f349933c;
        if (r103 == null) goto L14;
        byte[] r104 = r103.b(r102.f350773b);
        if (r104 == null) goto L14;
    L15:
        r100.setExtraInfo(ByteBuffer.wrap(r104));
        return;
    L14:
        r104 = new byte[0];
        goto L15
    L16:
        com.flow.kmp.common.util.b.c(r100.getDataBuffer());
        k();
        return;
    L5:
        if (this.f349939i.isEmpty() == false) goto L8;
        com.flow.kmp.common.util.b.c(r100.getDataBuffer());
        k();
    }

    @Override // com.larus.im.internal.rtcsdk.impl.e, com.ss.bytertc.engine.IAudioFrameProcessor
    public final int onProcessRecordAudioFrame(IAudioFrame r100, IAudioFrame r101) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r101 != null) goto L9;
        fe9.a.f476620a.e(this.f349932b, "refAudioFrame is null");
        return 0;
    L9:
        if (this.f349944n != (-1)) goto L12;
        this.f349944n = r100.getDataBuffer().capacity();
        fe9.a.f476620a.a(this.f349932b, "frameSize: " + this.f349944n);
    L12:
        if (this.f349937g == false) goto L14;
        com.larus.im.internal.utils.x r102 = com.larus.im.internal.utils.x.f350563a;
        com.larus.im.internal.utils.x.f350567e.getClass();
        this.f349938h.offer(new g(new com.larus.im.service.audio.l(com.flow.kmp.common.util.b.e(r100.getDataBuffer()), new JSONObject().put("audioFrameMs", r100.captureTimestampMs()).toString(), new ue9.g.a(r100.sample_rate().value(), r100.channel().value()), false), new com.larus.im.service.audio.l(com.flow.kmp.common.util.b.e(r101.getDataBuffer()), null, new ue9.g.a(r101.sample_rate().value(), r101.channel().value()), false)));
        g(r100, this.f349941k);
        return 0;
    L14:
        if (this.f349934d == false) goto L16;
        g(r100, 0);
    L17:
        return 0;
    L16:
        com.flow.kmp.common.util.b.c(r100.getDataBuffer());
        k();
        goto L17
    }
}
