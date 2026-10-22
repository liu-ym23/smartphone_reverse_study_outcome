package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.engine;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.LoadingState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.MusicPlayerImpl;
import com.bytedance.ies.xelement.w;
import com.lynx.tasm.base.LLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import java.io.FileDescriptor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements o76.g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f249926i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o76.a f249927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f249928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f249929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f249930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f249931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f249932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f249933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f249934h;

    public static final class a {
        public a() {
        }

        public static final PlaybackState a(int r100) {
            int r101 = i.f249926i;
            if (r100 == 0) goto L15;
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L17;
            return PlaybackState.PLAYBACK_STATE_STOPPED;
        L17:
            return PlaybackState.PLAYBACK_STATE_ERROR;
        L18:
            return PlaybackState.PLAYBACK_STATE_PAUSED;
        L19:
            return PlaybackState.PLAYBACK_STATE_PLAYING;
        L15:
            return PlaybackState.PLAYBACK_STATE_STOPPED;
        }
    }

    public static final class b implements VideoEngineListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f249935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o76.a f249936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f249937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f249938d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Handler f249939e;

        public static final class a {
        }

        static {
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onFirstAVSyncFrame(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onRefreshSurface(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ int onSetSurface(TTVideoEngine r100, VideoSurface r101, Surface r102) {
            return VideoEngineListener.CC.$default$onSetSurface(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onSilenceDetected(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onSilenceDetected(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onVideoSecondFrame(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onVideoStatusException(int r100) {
        }

        public final void a() {
            long r100 = this.f249935a.getCurrentPlaybackTime();
            if (r100 == this.f249937c) goto L8;
            this.f249936b.k(this.f249935a, r100);
            if (Math.abs(r100 - this.f249938d) < 500) goto L7;
            this.f249936b.o(this.f249935a, r100);
            this.f249938d = r100;
        L7:
            this.f249937c = r100;
        L8:
            this.f249939e.postAtTime(new k(this), this, SystemClock.uptimeMillis() + 50);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onCompletion(TTVideoEngine r100) {
            l76.d r101 = l76.d.f507797a;
            v76.a.C7969a r102 = w.f250621a;
            this.f249936b.i(this.f249935a);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onError(Error r100) {
            if (r100 != null) goto L5;
            ErrorCode r101 = ErrorCode.UNKNOWN;
        L13:
            l76.d.f507797a.a("TTAudioEngineImpl", " ---> onError()  internal  --- errorCode is " + r101.name());
            this.f249936b.h(r101);
            return;
        L5:
            if (r100.getType() != 1001) goto L7;
        L12:
            r101 = ErrorCode.NETWORK_ERROR;
            goto L13
        L7:
            if (r100.getType() == 1003) goto L12;
            if (r100.getType() == 1000) goto L12;
            r101 = ErrorCode.UNKNOWN;
            goto L13
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPrepare(TTVideoEngine r100) {
            l76.d r101 = l76.d.f507797a;
            v76.a.C7969a r102 = w.f250621a;
            this.f249936b.l(this.f249935a);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPrepared(TTVideoEngine r100) {
            l76.d r101 = l76.d.f507797a;
            v76.a.C7969a r102 = w.f250621a;
            this.f249936b.q(this.f249935a);
            i r103 = this.f249935a;
            r103.f249932f = true;
            if (r103.f249933g == false) goto L6;
            r103.c(-1);
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onRenderStart(TTVideoEngine r100) {
            l76.d r101 = l76.d.f507797a;
            v76.a.C7969a r102 = w.f250621a;
            this.f249936b.r(this.f249935a);
            this.f249936b.p(this.f249935a, PlaybackState.PLAYBACK_STATE_START);
            i r103 = this.f249935a;
            long r104 = r103.f249934h;
            r103.f249934h = 0;
            if (r104 <= 0) goto L6;
            r103.f(r104, null);
            return;
        }

        public b(i r100, o76.a r101) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            Intrinsics.checkNotNullParameter(r101, "impl");
            this.f249935a = r100;
            this.f249936b = r101;
            this.f249937c = Long.MIN_VALUE;
            this.f249938d = Long.MIN_VALUE;
            this.f249939e = new Handler(Looper.getMainLooper());
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
            this.f249936b.n(this.f249935a);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
            if (r101 != 1) goto L5;
            LoadingState r102 = LoadingState.LOAD_STATE_PLAYABLE;
        L9:
            l76.d r103 = l76.d.f507797a;
            r102.name();
            v76.a.C7969a r104 = w.f250621a;
            this.f249936b.j(this.f249935a, r102);
            return;
        L5:
            if (r101 == 2) goto L7;
            r102 = LoadingState.LOAD_STATE_ERROR;
            goto L9
        L7:
            r102 = LoadingState.LOAD_STATE_STALLED;
            goto L9
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            boolean r102 = false;
            if (r101 != 1) goto L5;
            this.f249935a.f249933g = false;
        L9:
            l76.d r103 = l76.d.f507797a;
            int r104 = i.f249926i;
            a.a(r101).name();
            v76.a.C7969a r105 = w.f250621a;
            if (r101 != 1) goto L12;
            r102 = true;
        L12:
            if (r102 == false) goto L14;
            this.f249939e.postAtTime(new j(this), this, SystemClock.uptimeMillis() + 50);
        L15:
            this.f249936b.p(this.f249935a, a.a(r101));
            return;
        L14:
            long r106 = this.f249935a.getCurrentPlaybackTime();
            this.f249936b.o(this.f249935a, r106);
            this.f249939e.removeCallbacksAndMessages(this);
            goto L15
        L5:
            if (r101 != 2) goto L9;
            this.f249935a.f249933g = false;
            goto L9
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onStreamChanged(TTVideoEngine r100, int r101) {
            this.f249936b.m(this.f249935a);
        }
    }

    static {
        new a();
    }

    public final void h() {
        this.f249931e = false;
        this.f249932f = false;
        this.f249933g = false;
        this.f249934h = 0;
    }

    public final TTVideoEngine g() {
        return (TTVideoEngine) this.f249929c.getValue();
    }

    @Override // o76.g
    public final void pause() {
        l76.d r100 = l76.d.f507797a;
        StringBuilder r101 = new StringBuilder(" ---> stop(),  already pause ?: ");
        boolean r102 = true;
        if (g().getPlaybackState() != 2) goto L5;
        boolean r103 = true;
    L6:
        r101.append(r103);
        r100.b("TTAudioEngineImpl", r101.toString());
        if (g().getPlaybackState() == 2) goto L10;
        r102 = false;
    L10:
        if (r102 == false) goto L12;
        return;
    L12:
        g().pause();
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // o76.g
    public final void release() {
        l76.d r100 = l76.d.f507797a;
        r100.b("TTAudioEngineImpl", " ---> release(),  mIsEngineInstantiate ?: " + this.f249930d);
        if (this.f249930d == false) goto L5;
        g().setListener(null);
        g().release();
        return;
    L5:
        r100.a("TTAudioEngineImpl", "TTVideoEngine is not instantiate, ignore release.");
    }

    @Override // o76.g
    public final void resume() {
        l76.d r100 = l76.d.f507797a;
        StringBuilder r101 = new StringBuilder(" ---> resume(),  isPlaying ?: ");
        boolean r102 = false;
        if (g().getPlaybackState() != 1) goto L5;
        boolean r103 = true;
    L6:
        r101.append(r103);
        r100.b("TTAudioEngineImpl", r101.toString());
        if (g().getPlaybackState() != 2) goto L9;
        r102 = true;
    L9:
        if (r102 == false) goto L12;
        g().play();
        return;
    L12:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // o76.g
    public final void stop() {
        l76.d r100 = l76.d.f507797a;
        StringBuilder r101 = new StringBuilder(" ---> stop(),  already stop ?: ");
        boolean r102 = true;
        if (g().getPlaybackState() != 0) goto L5;
        boolean r103 = true;
    L6:
        r101.append(r103);
        r100.b("TTAudioEngineImpl", r101.toString());
        if (g().getPlaybackState() == 0) goto L10;
        r102 = false;
    L10:
        if (r102 == false) goto L12;
        return;
    L12:
        g().stop();
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // o76.g
    public final int a() {
        return g().getLoadedProgress();
    }

    @Override // o76.g
    public final long b() {
        return g().getLongOption(60);
    }

    @Override // o76.g
    public final boolean e() {
    L12:
        th = move-exception;
        LLog.e("TTAudioEngineImpl", "isPlayingCompletion: " + Log.getStackTraceString(th));
        return false;
    L17:
        Object r100 = q76.b.a(g());     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7 Throwable -> L12
    L10:
        return ((Boolean) r100).booleanValue();
    L5:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
    L9:
        r100 = null;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        goto L9
    }

    @Override // o76.g
    public final long getCurrentPlaybackTime() {
        return g().getCurrentPlaybackTime();
    }

    @Override // o76.g
    public final long getDuration() {
        return g().getDuration();
    }

    @Override // o76.g
    public final PlaybackState getPlaybackState() {
        return a.a(g().getPlaybackState());
    }

    @Override // o76.g
    public final void c(long r100) {
        l76.d.f507797a.b("TTAudioEngineImpl", " ---> play(),  startPlayTime is " + r100);
        this.f249933g = true;
        if (this.f249932f == false) goto L6;
        g().play();
        return;
    }

    @Override // o76.g
    public final void setDirectURL(String r100) {
        l76.d.f507797a.b("TTAudioEngineImpl", " ---> setDirectURL(),  playUrl is " + r100);
        h();
        g().setDirectURL(r100);
        g().prepare();
    }

    @Override // o76.g
    public final void setLocalURL(String r100) {
        l76.d.f507797a.b("TTAudioEngineImpl", " ---> setLocalURL(),  localFilePath is " + r100);
        h();
        g().setLocalURL(r100);
        g().prepare();
    }

    public i(final Context r100, MusicPlayerImpl.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f249927a = r101;
        this.f249928b = 300;
        this.f249929c = LazyKt.lazy(new TTAudioEngineImpl$mTTEngine$2(r100, this));
    }

    @Override // o76.g
    public final void d(Resolution r100, VideoModel r101) {
        h();
        if (r101 != null) goto L5;
        l76.d.f507797a.b("TTAudioEngineImpl", "videoMode is empty");
        return;
    L5:
        g().setVideoModel(r101);
        g().configResolution(r100);
        g().prepare();
    }

    @Override // o76.g
    public final void f(final long r100, final com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.b r101) {
        l76.d.f507797a.b("TTAudioEngineImpl", " ---> seekToTime(),  time is ?: " + r100 + ",   mIsSeeking : " + this.f249931e);
        if (this.f249931e == false) goto L5;
    L12:
        if (r101 == null) goto L15;
        r101.a(r100, false);
        return;
    L15:
        return;
    L5:
        if (r100 < 0) goto L12;
        this.f249931e = true;
        long r102 = RangesKt.coerceAtLeast(0, getDuration() - 2000);
        if (r100 <= r102) goto L10;
        r100 = r102;
    L10:
        g().seekTo((int) r100, new h(r101, r100, this));
    }

    @Override // o76.g
    public final void setDirectUrlUseDataLoader(String r100, String r101) {
        l76.d.f507797a.b("TTAudioEngineImpl", " ---> setDirectUrlUseDataLoader(),  playUrl is " + r100 + ",   cacheKey is " + r101);
        h();
        g().setDirectUrlUseDataLoader(r100, r101);
        g().prepare();
    }

    @Override // o76.g
    public final void setDataSource(FileDescriptor r110, long r111, long r112) {
        l76.d r100 = l76.d.f507797a;
        StringBuilder r101 = new StringBuilder(" ---> setDataSource(),  FileDescriptor is ");
        if (r110 == null) goto L5;
        String r102 = r110.toString();
    L6:
        r101.append(r102);
        r100.b("TTAudioEngineImpl", r101.toString());
        h();
        g().setDataSource(r110, r111, r112);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
