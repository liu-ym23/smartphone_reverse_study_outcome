package com.bytedance.android.shopping.commentv3.audio;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.bytedance.android.shopping.api.video.AVScene;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TTVideoEngineAudioPlayer implements k, VideoEngineListener {
    public final Handler a;
    public l b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final TTVideoEngine f;

    public static final class a {
    }

    public final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void onBufferingUpdate(TTVideoEngine r1, int r2) {
    }

    public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onFirstAVSyncFrame(this, r1);
    }

    public final void onLoadStateChanged(TTVideoEngine r1, int r2) {
    }

    public final void onPlaybackStateChanged(TTVideoEngine r1, int r2) {
    }

    public final void onPrepare(TTVideoEngine r1) {
    }

    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onRefreshSurface(this, r1);
    }

    public final void onRenderStart(TTVideoEngine r1) {
    }

    public final /* synthetic */ int onSetSurface(TTVideoEngine r1, VideoSurface r2, Surface r3) {
        return VideoEngineListener.-CC.$default$onSetSurface(this, r1, r2, r3);
    }

    public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onSilenceDetected(this, r1);
    }

    public final void onStreamChanged(TTVideoEngine r1, int r2) {
    }

    public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onVideoSecondFrame(this, r1);
    }

    public final void onVideoSizeChanged(TTVideoEngine r1, int r2, int r3) {
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.k
    public final void release() {
        this.e = true;
        this.c = false;
        this.d = false;
        this.a.removeCallbacksAndMessages(null);
        this.f.release();
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.k
    public final void stop() {
        this.d = false;
        this.f.stop();
    }

    public final void c() {
        if (this.e == false) goto L6;
        return;
    L6:
        if (this.c == false) goto L8;
        this.f.play();
        return;
    L8:
        this.d = true;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.k
    public final void a(o r1) {
        this.b = r1;
    }

    public final void b(Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.a.post(new b(r3));
    }

    public final void d(e r3) {
        Intrinsics.checkNotNullParameter(r3, "audioInfo");
        this.c = false;
        this.d = false;
        String r0 = r3.a;
        if (r0 != null) goto L5;
        r0 = TTVideoEngine.computeMD5(r3.b);
    L5:
        this.f.setDirectUrlUseDataLoader(r3.b, r0);
        this.f.prepare();
    }

    public final void onCompletion(TTVideoEngine r1) {
        b(new AnonymousClass1(this));
    }

    public final void onError(final Error r2) {
        b(new C02551(this, r2));
    }

    public final void onPrepared(TTVideoEngine r1) {
        b(new C02561(this));
    }

    public final void onVideoStatusException(final int r2) {
        b(new C02571(this, r2));
    }

    public TTVideoEngineAudioPlayer(Context r3, AVScene r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "avScene");
        this.a = new Handler(Looper.getMainLooper());
        TTVideoEngine r0 = new TTVideoEngine(r3.getApplicationContext(), 0);
        r0.setTag(r4.getTag());
        r0.setSubTag(r4.getSubTag());
        r0.setIntOption(160, 1);
        r0.setListener(this);
        Unit r5 = Unit.INSTANCE;
        this.f = r0;
    }
}
