package com.bytedance.ee.bear.drive.view.preview.video.player;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import com.bytedance.ee.bear.drive.view.preview.video.audio.AudioFocusManager;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.statistics.Statistics;
import com.ss.texturerender.VideoSurface;
import com.ss.ttm.player.HLSInfoCallback;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.log.VideoEventListener;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.utils.Error;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class e implements IPlayer {
    public static volatile boolean k;
    public static final a l = null;
    public static final C0186e m = null;
    public TTVideoEngine a;
    public b b;
    public j c;
    public final Set<sf5.a> d;
    public final f e;
    public final MutableLiveData<IPlayer.State> f;
    public String g;
    public final Map<String, String> h;
    public long i;
    public final NetService j;

    public class a implements VideoEngineInfoListener {
        public a() {
        }

        public final void onVideoEngineInfos(VideoEngineInfos r6) {
            if (r6 != null) goto L6;
            tt5.a.d("TTPlayer", "onVideoEngineInfos is null");
            return;
        L6:
            if ("mdlhitcachesize".equals(r6.getKey()) == false) goto L8;
            tt5.a.h("TTPlayer", "usingKey " + r6.getUsingMDLPlayTaskKey() + " hitCacheSize " + r6.getUsingMDLHitCacheSize());
            return;
        L8:
            tt5.a.b("TTPlayer", "videoEngineInfos.getKey()=" + r6.getKey());
        }
    }

    public class b implements com.ss.android.lark.media.a {
        public final Scene a;
        public boolean b;
        public boolean c;
        public final AudioFocusManager d;
        public final /* synthetic */ e e;

        public final synchronized void e() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.b == false) goto L8;
            tt5.a.h("TTPlayer", "MediaMutexProxy-onStart, isMutexLocked: true, start playing.");     // Catch: Throwable -> L11
            this.c = false;     // Catch: Throwable -> L11
            f();     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L8:
            tt5.a.h("TTPlayer", "MediaMutexProxy-onStart, isMutexLocked: false, tryLock.");     // Catch: Throwable -> L11
            this.c = true;     // Catch: Throwable -> L11
            MediaMutex r1 = MediaMutex.r;     // Catch: Throwable -> L11
            MediaMutex.r.l(this.a, true, this, true);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        public final synchronized void d() {
            monitor-enter(this);
            tt5.a.h("TTPlayer", "MediaMutexProxy-onRelease, scene: " + this.a);     // Catch: Throwable -> L7
            this.b = false;     // Catch: Throwable -> L7
            this.c = false;     // Catch: Throwable -> L7
            MediaMutex r0 = MediaMutex.r;     // Catch: Throwable -> L7
            MediaMutex.r.n(this.a, this);     // Catch: Throwable -> L7
            this.d.b();     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final void f() {
            if ((!DowngradeSettingUtil.a("downgradeTTPlayerRequestAudioFocus")) == false) goto L5;
            this.d.a(new n(this));
            return;
        L5:
            TTVideoEngine r0 = this.e.a;
            if (r0 == null) goto L10;
            r0.play();
            return;
        }

        public final void onSuccess() {
            tt5.a.h("TTPlayer", "MediaMutexProxy-onSuccess, scene: " + this.a + ", isWaitingForPlay: " + this.c);
            this.b = true;
            if (this.c == false) goto L6;
            com.bytedance.ee.util.ui.j.f(new m(this));
            return;
        }

        public final void a(MediaMutex.LockError r3) {
            tt5.a.h("TTPlayer", "MediaMutexProxy-onError, scene: " + this.a + ", lockError: " + r3);
            d();
        }

        public b(e r2, Scene r3) {
            this.e = r2;
            this.b = false;
            this.c = false;
            this.a = r3;
            this.d = new AudioFocusManager(r2.a.getContext());
        }

        public final void b(Scene r4, MediaType r5) {
            int r0 = this.e.a.getPlaybackState();
            tt5.a.h("TTPlayer", "MediaMutexProxy-mediaResourceWasInterrupted, scene: " + r4 + ", mediaType: " + r5 + ", interruptMsg: , playbackState: " + r0);
            if (r0 != 1) goto L5;
            this.c = true;
            com.bytedance.ee.util.ui.j.f(new l(this));
            return;
        L5:
            d();
        }

        public final void c(Scene r4, MediaType r5) {
            tt5.a.h("TTPlayer", "MediaMutexProxy-mediaResourceInterruptionEnd, scene: " + r4 + ", mediaType: " + r5 + ", playbackState: " + this.e.a.getPlaybackState() + ", isWaitingForPlay: " + this.c);
            if (this.c == false) goto L6;
            com.bytedance.ee.util.ui.j.f(new k(this));
            return;
        }
    }

    public class c implements VideoEngineCallback {
        public final /* synthetic */ e a;

        public final /* synthetic */ String getEncryptedLocalTime() {
            return VideoEngineCallback.-CC.$default$getEncryptedLocalTime(this);
        }

        public final /* synthetic */ void onABRPredictBitrate(int r1, int r2) {
            VideoEngineCallback.-CC.$default$onABRPredictBitrate(this, r1, r2);
        }

        public final /* synthetic */ void onAVBadInterlaced(Map r1) {
            VideoEngineCallback.-CC.$default$onAVBadInterlaced(this, r1);
        }

        public final /* synthetic */ void onBufferEnd(int r1) {
            VideoEngineCallback.-CC.$default$onBufferEnd(this, r1);
        }

        public final /* synthetic */ void onBufferStart(int r1, int r2, int r3) {
            VideoEngineCallback.-CC.$default$onBufferStart(this, r1, r2, r3);
        }

        public final /* synthetic */ void onBufferingUpdate(TTVideoEngine r1, int r2) {
            VideoEngineCallback.-CC.$default$onBufferingUpdate(this, r1, r2);
        }

        public final /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine r1, int r2) {
            VideoEngineCallback.-CC.$default$onCurrentPlaybackTimeUpdate(this, r1, r2);
        }

        public final /* synthetic */ void onError(Error r1) {
            VideoEngineCallback.-CC.$default$onError(this, r1);
        }

        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onFirstAVSyncFrame(this, r1);
        }

        public final /* synthetic */ void onFrameAboutToBeRendered(TTVideoEngine r1, int r2, long r3, long r5, Map r7) {
            VideoEngineCallback.-CC.$default$onFrameAboutToBeRendered(this, r1, r2, r3, r5, r7);
        }

        public final /* synthetic */ void onFrameDraw(int r1, Map r2) {
            VideoEngineCallback.-CC.$default$onFrameDraw(this, r1, r2);
        }

        public final /* synthetic */ void onInfoIdChanged(int r1) {
            VideoEngineCallback.-CC.$default$onInfoIdChanged(this, r1);
        }

        public final /* synthetic */ void onLoadStateChanged(TTVideoEngine r1, int r2) {
            VideoEngineCallback.-CC.$default$onLoadStateChanged(this, r1, r2);
        }

        public final /* synthetic */ void onPlayUrlChanged(int r1, String r2, String r3) {
            VideoEngineCallback.-CC.$default$onPlayUrlChanged(this, r1, r2, r3);
        }

        public final /* synthetic */ void onPlaybackStateChanged(TTVideoEngine r1, int r2) {
            VideoEngineCallback.-CC.$default$onPlaybackStateChanged(this, r1, r2);
        }

        public final /* synthetic */ void onPrepare(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onPrepare(this, r1);
        }

        public final /* synthetic */ void onPrepared(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onPrepared(this, r1);
        }

        public final /* synthetic */ void onReadyForDisplay(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onReadyForDisplay(this, r1);
        }

        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onRefreshSurface(this, r1);
        }

        public final /* synthetic */ void onRenderStart(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onRenderStart(this, r1);
        }

        public final /* synthetic */ void onSARChanged(int r1, int r2) {
            VideoEngineCallback.-CC.$default$onSARChanged(this, r1, r2);
        }

        public final /* synthetic */ int onSetSurface(TTVideoEngine r1, VideoSurface r2, Surface r3) {
            return VideoEngineCallback.-CC.$default$onSetSurface(this, r1, r2, r3);
        }

        public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onSilenceDetected(this, r1);
        }

        public final /* synthetic */ void onStreamChanged(TTVideoEngine r1, int r2) {
            VideoEngineCallback.-CC.$default$onStreamChanged(this, r1, r2);
        }

        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onVideoSecondFrame(this, r1);
        }

        public final /* synthetic */ void onVideoSizeChanged(TTVideoEngine r1, int r2, int r3) {
            VideoEngineCallback.-CC.$default$onVideoSizeChanged(this, r1, r2, r3);
        }

        public final /* synthetic */ void onVideoStatusException(int r1) {
            VideoEngineCallback.-CC.$default$onVideoStatusException(this, r1);
        }

        public final /* synthetic */ void onVideoStreamBitrateChanged(Resolution r1, int r2) {
            VideoEngineCallback.-CC.$default$onVideoStreamBitrateChanged(this, r1, r2);
        }

        public final /* synthetic */ void onVideoURLRouteFailed(Error r1, String r2) {
            VideoEngineCallback.-CC.$default$onVideoURLRouteFailed(this, r1, r2);
        }

        public c(e r1) {
            this.a = r1;
        }

        public final void onCompletion(TTVideoEngine r2) {
            tt5.a.h("TTPlayer", "TTVideoEngineCallback-onCompletion, playbackState: " + this.a.a.getPlaybackState() + ", loadState: " + this.a.a.getLoadState());
            if (Objects.equals((IPlayer.State) this.a.f.getValue(), IPlayer.State.ENDED) == true) goto L6;
            com.bytedance.ee.util.ui.j.f(new o(this));
            return;
        }
    }

    public class d implements VideoEngineListener {
        public final /* synthetic */ e a;

        public final void onBufferingUpdate(TTVideoEngine r1, int r2) {
        }

        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onFirstAVSyncFrame(this, r1);
        }

        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onRefreshSurface(this, r1);
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

        public d(e r1) {
            this.a = r1;
        }

        public final void onCompletion(TTVideoEngine r2) {
            tt5.a.h("TTPlayer", "ttvideo engine onVideoStatusException, onCompletion ");
        }

        public final void onError(Error r3) {
            tt5.a.d("TTPlayer", "ttvideo engine onError, error = " + r3);
            com.bytedance.ee.util.ui.j.f(new p(this));
            j r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.j(new Exception(r3.toString()));
            return;
        }

        public final void onPrepare(TTVideoEngine r3) {
            tt5.a.h("TTPlayer", "ttvideo engine onPrepare start load video");
            if (this.a.a.getPlaybackState() != 1) goto L5;
            tt5.a.k("TTPlayer", "TTVideoEngineListener-onPrepare, already playing, ignored.");
            return;
        L5:
            com.bytedance.ee.util.ui.j.f(new q(this));
        }

        public final void onPrepared(TTVideoEngine r3) {
            tt5.a.h("TTPlayer", "ttvideo engine onPrepared load video finished");
            if (this.a.a.getPlaybackState() != 1) goto L5;
            tt5.a.k("TTPlayer", "TTVideoEngineListener-onPrepare, already playing, ignored.");
        L6:
            j r4 = this.a.c;
            if (r4 == null) goto L10;
            r4.h(3);
            return;
        L10:
            return;
        L5:
            com.bytedance.ee.util.ui.j.f(new r(this));
            goto L6
        }

        public final void onRenderStart(TTVideoEngine r2) {
            tt5.a.h("TTPlayer", "ttvideo engine onRenderStart auto play");
            j r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.onRenderStart();
            return;
        }

        public final void onVideoStatusException(int r3) {
            tt5.a.h("TTPlayer", "ttvideo engine onVideoStatusException, status = " + r3);
        }

        public final void a(int r6, int r7) {
            IPlayer.State r0 = (IPlayer.State) this.a.f.getValue();
            if (r6 != 0) goto L5;
            final IPlayer.State r2 = IPlayer.State.STOPPED;
        L16:
            tt5.a.h("TTPlayer", "convertPlayerState, playbackState: " + r6 + ", loadState: " + r7 + ", lastPlayerState: " + r0 + ", newPlayerState: " + r2);
            if (Objects.equals(r0, r2) == true) goto L20;
            com.bytedance.ee.util.ui.j.f(new s(this, r2));
            return;
        L20:
            return;
        L5:
            if (r6 == 1) goto L12;
            if (r6 != 2) goto L8;
            r2 = IPlayer.State.PAUSED;
            goto L16
        L8:
            if (r6 == 3) goto L10;
            tt5.a.k("TTPlayer", "convertPlayerState, unrecognized playback state: " + r6);
            r2 = r0;
            goto L16
        L10:
            r2 = IPlayer.State.ERROR;
            goto L16
        L12:
            if (r7 != 2) goto L14;
            r2 = IPlayer.State.BUFFERING;
            goto L16
        L14:
            r2 = IPlayer.State.PLAYING;
            goto L16
        }

        public final void onLoadStateChanged(TTVideoEngine r2, int r3) {
            tt5.a.h("TTPlayer", "ttvideo engine onLoadStateChanged, loadState = " + r3);
            int r4 = this.a.a.getPlaybackState();
            if (r4 == 0) goto L6;
            a(r4, r3);
            return;
        }

        public final void onPlaybackStateChanged(TTVideoEngine r4, int r5) {
            tt5.a.h("TTPlayer", "ttvideo engine onPlaybackStateChanged, state = " + r5);
            a(r5, this.a.a.getLoadState());
            j r6 = this.a.c;
            if (r6 == null) goto L15;
            if (r5 == 0) goto L13;
            int r1 = 1;
            if (r5 != 1) goto L8;
            r1 = 4;
        L14:
            r6.h(r1);
            goto L15
        L8:
            if (r5 == 2) goto L11;
            if (r5 == 3) goto L13;
        L11:
            r1 = 2;
        L13:
            r1 = 5;
        L15:
            if (r5 == 0) goto L17;
            if (r5 == 3) goto L17;
            return;
        L17:
            b r7 = this.a.b;
            if (r7 == null) goto L22;
            r7.d();
            return;
        }

        public final void onVideoSizeChanged(TTVideoEngine r2, int r3, int r4) {
            tt5.a.h("TTPlayer", "onVideoSizeChanged, width = " + r3 + ", height = " + r4);
            j r5 = this.a.c;
            if (r5 == null) goto L6;
            r5.onVideoSizeChanged(r3, r4);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.video.player.e$e, reason: collision with other inner class name */
    public static class C0186e implements VideoEventListener {
        public final void onEvent() {
            JSONArray r2 = VideoEventManager.instance.popAllEvents();     // Catch: Exception -> L8
            int r3 = 0;
        L5:
            if (r3 >= r2.length()) goto L14;
            JSONObject r4 = JSONArrayProtectorUtils.getJSONObject(r2, r3);     // Catch: Exception -> L8
            Statistics.recordMiscLog("video_playq", r4);     // Catch: Exception -> L8
            tt5.a.h("TTPlayer", "onEvent: " + du5.b.g(r4.toString()));     // Catch: Exception -> L8
            r3 = r3 + 1;
            goto L5
        L14:
            return;
        L8:
            e = move-exception;
            tt5.a.e("TTPlayer", "VideoEventManager onEvent error", e, false);
        }

        public C0186e() {
        }

        public void onEventV2(String r8) {
            if (TextUtils.isEmpty(r8) == false) goto L14;
            return;
        L14:
            JSONArray r2 = VideoEventManager.instance.popAllEventsV2();     // Catch: Exception -> L11
            int r3 = 0;
        L8:
            if (r3 >= r2.length()) goto L17;
            JSONObject r4 = JSONArrayProtectorUtils.getJSONObject(r2, r3);     // Catch: Exception -> L11
            r4.put("params_for_special", "videoplayer_monitor");     // Catch: Exception -> L11
            Statistics.sendEvent(r8, r4);     // Catch: Exception -> L11
            tt5.a.h("TTPlayer", "onEvent: " + r4.toString());     // Catch: Exception -> L11
            r3 = r3 + 1;
            goto L8
        L17:
            return;
        L11:
            e = move-exception;
            tt5.a.e("TTPlayer", "VideoEventManager onEventV2 error", e, false);
        }
    }

    public static class f extends HLSInfoCallback {
        public final Set<sf5.b> a;

        public f() {
            this.a = Collections.newSetFromMap(new ConcurrentHashMap());
        }

        public final void onContentCallback(final String r2) {
            com.bytedance.ee.util.ui.j.c(new u(this, r2));
        }

        public final void onLiveDurationCallback(final long r2) {
            com.bytedance.ee.util.ui.j.c(new t(this, r2));
        }
    }

    static {
        l = new a();
        m = new C0186e();
    }

    public final void d() {
        this.g = "";
    }

    public final void e() {
        b r0 = this.b;
        if (r0 != null) goto L6;
        tt5.a.h("TTPlayer", "disableMutex, mMutexProxy is null.");
        return;
    L6:
        tt5.a.h("TTPlayer", "disableMutex, scene: " + r0.a);
        r0.d();
        this.b = null;
    }

    public final long getCurrentPosition() {
        return this.a.getCurrentPlaybackTime();
    }

    public final int getPlaybackState() {
        int r0 = this.a.getPlaybackState();
        if (r0 != 0) goto L5;
    L13:
        return 5;
    L5:
        if (r0 != 1) goto L7;
        return 4;
    L7:
        if (r0 != 2) goto L9;
        return 2;
    L9:
        if (r0 == 3) goto L13;
        return 1;
    }

    public final void j() {
        if (hu5.a.e(this.h) == false) goto L5;
        return;
    L5:
        if (this.a == null) goto L23;
        Iterator r0 = ((ConcurrentHashMap) this.h).entrySet().iterator();
    L9:
        if (r0.hasNext() == false) goto L24;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (TextUtils.isEmpty((CharSequence) r1.getKey()) == true) goto L9;
        if (TextUtils.isEmpty((CharSequence) r1.getValue()) == true) goto L9;
        this.a.setCustomHeader((String) r1.getKey(), (String) r1.getValue());
        goto L9
    L24:
        return;
    }

    public final long k() {
        return this.a.getDuration();
    }

    public final void pause() {
        tt5.a.h("TTPlayer", "ttPlayer pause");
        b r0 = this.b;
        if (r0 != null) goto L5;
        this.a.pause();
        return;
    L5:
        monitor-enter(r0);
        tt5.a.h("TTPlayer", "MediaMutexProxy-onPause.");     // Catch: Throwable -> L9
        r0.e.a.pause();     // Catch: Throwable -> L9
        r0.d();     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void preload() {
        if (this.a.isPrepared() == true) goto L6;
        tt5.a.h("TTPlayer", "preload, engine not prepared, start preparing.");
        this.a.prepare();
        return;
    L6:
        tt5.a.k("TTPlayer", "preload, no available preload entry.");
    }

    public void release() {
        tt5.a.h("TTPlayer", "ttPlayer release... ");
        this.a.setListener(null);
        this.a.setVideoEngineCallback(null);
        this.a.setHLSInfoCallback(null);
        this.e.a.clear();
        this.a.releaseAsync();
        b r0 = this.b;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public void start() {
        tt5.a.h("TTPlayer", "ttPlayer start");
        this.i = SystemClock.elapsedRealtime();
        if (this.a.getPlaybackState() != 1) goto L6;
        tt5.a.h("TTPlayer", "video is playing return");
        return;
    L6:
        b r0 = this.b;
        if (r0 != null) goto L9;
        this.a.play();
        return;
    L9:
        r0.e();
    }

    public final void stop() {
        tt5.a.h("TTPlayer", "ttPlayer stop");
        b r0 = this.b;
        if (r0 != null) goto L5;
        this.a.stop();
        return;
    L5:
        monitor-enter(r0);
        tt5.a.h("TTPlayer", "MediaMutexProxy-onStop.");     // Catch: Throwable -> L9
        r0.e.a.stop();     // Catch: Throwable -> L9
        r0.d();     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L7;
        return "TTPlayer(" + hashCode() + "){engine: null}";
    L7:
        return "TTPlayer(" + hashCode() + "){engine: " + r0.hashCode() + ", playbackState: " + r0.getPlaybackState() + ", loadState: " + r0.getLoadState() + "}";
    }

    public final MutableLiveData h() {
        return this.f;
    }

    public e(Context r5) {
        this.d = Collections.newSetFromMap(new ConcurrentHashMap());
        f r0 = new f();
        this.e = r0;
        this.f = new MutableLiveData(IPlayer.State.IDLE);
        this.h = new ConcurrentHashMap();
        long r1 = o75.b.a().getDriveConfig().f;
        this.j = (NetService) org.koin.java.a.a(NetService.class);
        r5.getApplicationContext();
        v.a();     // Catch: Exception -> L5
        TTVideoEngine r2 = v.b(new d(this));     // Catch: Exception -> L5
        this.a = r2;     // Catch: Exception -> L5
        r2.setVideoEngineCallback(new c(this));     // Catch: Exception -> L5
        this.a.setHLSInfoCallback(r0);     // Catch: Exception -> L5
        tt5.a.h("TTPlayer", "isSystemPlayer=" + this.a.isSystemPlayer());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("TTPlayer", e, false);
    }

    public final void a(sf5.b r3) {
        tt5.a.h("TTPlayer", "removeHlsInfoListener, listener: " + r3);
        this.e.a.remove(r3);
    }

    public final void b(Uri r4) {
        String r5 = r4.toString();
        tt5.a.h("TTPlayer", "prepare uri = " + du5.b.g(r5) + ", mCacheKey = " + this.g);
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
    L15:
        this.a.setDirectURL(r5);
    L16:
        this.a.setCustomHeader("doc-device-id", ((b0) org.koin.java.a.a(b0.class)).getDeviceId());
        NetService r6 = this.j;
        if (r6 != null) goto L19;
    L21:
        j();
        return;
    L19:
        if (r6.getEnv() != 3) goto L21;
        tt5.a.h("TTPlayer", "isPreRelease, add prerelease env header");
        this.a.setCustomHeader("env", "Pre_release");
        goto L21
    L10:
        if (r5.startsWith("file") == true) goto L15;
        if (TextUtils.isEmpty(this.g) == true) goto L15;
        this.a.setDirectUrlUseDataLoader(r5, this.g);
        goto L16
    L5:
        if (r5.contains("api/box/stream/sdk") == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void c(Map<String, String> r4) {
        ((ConcurrentHashMap) this.h).clear();
        if (hu5.a.e(r4) == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, String> r0 = r5.next();
        if (TextUtils.isEmpty(r0.getKey()) == true) goto L7;
        if (TextUtils.isEmpty(r0.getValue()) == true) goto L7;
        Map<String, String> r1 = this.h;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.put(r0.getKey(), r0.getValue());
        goto L7
    L13:
        j();
    }

    public final void f(Scene r5) {
        b r0 = this.b;
        if (r0 == null) goto L6;
        tt5.a.k("TTPlayer", "enableMutex, scene: " + r5 + ", but mMutexProxy already exists, scene: " + r0.a);
        return;
    L6:
        tt5.a.h("TTPlayer", "enableMutex, scene: " + r5);
        this.b = new b(this, r5);
    }

    public final void g(sf5.b r3) {
        tt5.a.h("TTPlayer", "addHlsInfoListener, listener: " + r3);
        this.e.a.add(r3);
    }

    public final void i(sf5.a r2) {
        if (this.c != null) goto L5;
        this.c = new j(this);
    L5:
        this.d.add(r2);
    }

    public final void seekTo(long r8) {
        int r0 = this.a.getDuration() / 10;
        int r1 = ImportResult.STATUS_SHEET_UPLOAD_WARNING_COLUMN_CUT;
        if (r0 >= 2000) goto L5;
        r1 = this.a.getDuration() / 10;
    L5:
        long r4 = r1;
        if ((((long) this.a.getDuration()) - r8) >= r4) goto L9;
        tt5.a.h("TTPlayer", "seek to end return gap = " + r1);
        r8 = r8 - r4;
    L9:
        if (this.a.getPlaybackState() != 0) goto L11;
        tt5.a.h("TTPlayer", "seek to current status is stop, start play");
        setStartTime((int) r8);
        start();
        return;
    L11:
        tt5.a.h("TTPlayer", "seek to ... ");
        this.a.seekTo((int) r8, null);
    }

    public final void setSpeed(float r3) {
        tt5.a.h("TTPlayer", "setSpeed, speed: " + r3);
        if (r3 > 0.0f) goto L5;
        r3 = 1.0f;
    L5:
        PlaybackParams r0 = new PlaybackParams();
        r0.setSpeed(r3);
        this.a.setPlaybackParams(r0);
    }

    public final void setStartTime(int r2) {
        this.a.setStartTime(r2);
    }

    public final void setVolume(float r3) {
        tt5.a.h("TTPlayer", "ttPlayer setVolume volume=" + r3);
        if (r3 >= 0.01f) goto L5;
        boolean r4 = true;
    L6:
        this.a.setIsMute(r4);
        return;
    L5:
        r4 = false;
        goto L6
    }
}
