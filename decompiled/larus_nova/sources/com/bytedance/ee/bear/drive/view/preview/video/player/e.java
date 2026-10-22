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

/* JADX INFO: loaded from: classes16.dex */
public class e implements IPlayer {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f225552k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f225553l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C3242e f225554m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTVideoEngine f225555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f225556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f225557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<sf5.a> f225558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f225559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<IPlayer.State> f225560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f225561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f225562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f225563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NetService f225564j;

    public class a implements VideoEngineInfoListener {
        public a() {
        }

        @Override // com.ss.ttvideoengine.VideoEngineInfoListener
        public final void onVideoEngineInfos(VideoEngineInfos r100) {
            if (r100 != null) goto L6;
            tt5.a.d("TTPlayer", "onVideoEngineInfos is null");
            return;
        L6:
            if (VideoEngineInfos.USING_MDL_HIT_CACHE_SIZE.equals(r100.getKey()) == false) goto L8;
            tt5.a.h("TTPlayer", "usingKey " + r100.getUsingMDLPlayTaskKey() + " hitCacheSize " + r100.getUsingMDLHitCacheSize());
            return;
        L8:
            tt5.a.b("TTPlayer", "videoEngineInfos.getKey()=" + r100.getKey());
        }
    }

    public class b implements com.ss.android.lark.media.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Scene f225565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f225566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f225567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AudioFocusManager f225568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f225569e;

        public final synchronized void e() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f225566b == false) goto L8;
            tt5.a.h("TTPlayer", "MediaMutexProxy-onStart, isMutexLocked: true, start playing.");     // Catch: Throwable -> L11
            this.f225567c = false;     // Catch: Throwable -> L11
            f();     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L8:
            tt5.a.h("TTPlayer", "MediaMutexProxy-onStart, isMutexLocked: false, tryLock.");     // Catch: Throwable -> L11
            this.f225567c = true;     // Catch: Throwable -> L11
            MediaMutex r100 = MediaMutex.f431631r;     // Catch: Throwable -> L11
            MediaMutex.f431631r.l(this.f225565a, true, this, true);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        public final synchronized void d() {
            monitor-enter(this);
            tt5.a.h("TTPlayer", "MediaMutexProxy-onRelease, scene: " + this.f225565a);     // Catch: Throwable -> L7
            this.f225566b = false;     // Catch: Throwable -> L7
            this.f225567c = false;     // Catch: Throwable -> L7
            MediaMutex r100 = MediaMutex.f431631r;     // Catch: Throwable -> L7
            MediaMutex.f431631r.n(this.f225565a, this);     // Catch: Throwable -> L7
            this.f225568d.b();     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final void f() {
            if ((!DowngradeSettingUtil.a("downgradeTTPlayerRequestAudioFocus")) == false) goto L5;
            this.f225568d.a(new n(this));
            return;
        L5:
            TTVideoEngine r100 = this.f225569e.f225555a;
            if (r100 == null) goto L10;
            r100.play();
            return;
        }

        @Override // com.ss.android.lark.media.a
        public final void onSuccess() {
            tt5.a.h("TTPlayer", "MediaMutexProxy-onSuccess, scene: " + this.f225565a + ", isWaitingForPlay: " + this.f225567c);
            this.f225566b = true;
            if (this.f225567c == false) goto L6;
            com.bytedance.ee.util.ui.j.f(new m(this));
            return;
        }

        @Override // com.ss.android.lark.media.a
        public final void a(MediaMutex.LockError r100) {
            tt5.a.h("TTPlayer", "MediaMutexProxy-onError, scene: " + this.f225565a + ", lockError: " + r100);
            d();
        }

        public b(e r100, Scene r101) {
            this.f225569e = r100;
            this.f225566b = false;
            this.f225567c = false;
            this.f225565a = r101;
            this.f225568d = new AudioFocusManager(r100.f225555a.getContext());
        }

        @Override // com.ss.android.lark.media.a
        public final void b(Scene r100, MediaType r101) {
            int r102 = this.f225569e.f225555a.getPlaybackState();
            tt5.a.h("TTPlayer", "MediaMutexProxy-mediaResourceWasInterrupted, scene: " + r100 + ", mediaType: " + r101 + ", interruptMsg: , playbackState: " + r102);
            if (r102 != 1) goto L5;
            this.f225567c = true;
            com.bytedance.ee.util.ui.j.f(new l(this));
            return;
        L5:
            d();
        }

        @Override // com.ss.android.lark.media.a
        public final void c(Scene r100, MediaType r101) {
            tt5.a.h("TTPlayer", "MediaMutexProxy-mediaResourceInterruptionEnd, scene: " + r100 + ", mediaType: " + r101 + ", playbackState: " + this.f225569e.f225555a.getPlaybackState() + ", isWaitingForPlay: " + this.f225567c);
            if (this.f225567c == false) goto L6;
            com.bytedance.ee.util.ui.j.f(new k(this));
            return;
        }
    }

    public class c implements VideoEngineCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f225570a;

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ String getEncryptedLocalTime() {
            return VideoEngineCallback.CC.$default$getEncryptedLocalTime(this);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onABRPredictBitrate(int r100, int r101) {
            VideoEngineCallback.CC.$default$onABRPredictBitrate(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onAVBadInterlaced(Map r100) {
            VideoEngineCallback.CC.$default$onAVBadInterlaced(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onBufferEnd(int r100) {
            VideoEngineCallback.CC.$default$onBufferEnd(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onBufferStart(int r100, int r101, int r102) {
            VideoEngineCallback.CC.$default$onBufferStart(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onBufferingUpdate(TTVideoEngine r100, int r101) {
            VideoEngineCallback.CC.$default$onBufferingUpdate(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine r100, int r101) {
            VideoEngineCallback.CC.$default$onCurrentPlaybackTimeUpdate(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onError(Error r100) {
            VideoEngineCallback.CC.$default$onError(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onFirstAVSyncFrame(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onFrameAboutToBeRendered(TTVideoEngine r100, int r101, long r102, long r103, Map r104) {
            VideoEngineCallback.CC.$default$onFrameAboutToBeRendered(this, r100, r101, r102, r103, r104);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onFrameDraw(int r100, Map r101) {
            VideoEngineCallback.CC.$default$onFrameDraw(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onInfoIdChanged(int r100) {
            VideoEngineCallback.CC.$default$onInfoIdChanged(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onLoadStateChanged(TTVideoEngine r100, int r101) {
            VideoEngineCallback.CC.$default$onLoadStateChanged(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onPlayUrlChanged(int r100, String r101, String r102) {
            VideoEngineCallback.CC.$default$onPlayUrlChanged(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            VideoEngineCallback.CC.$default$onPlaybackStateChanged(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onPrepare(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onPrepare(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onPrepared(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onPrepared(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onReadyForDisplay(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onReadyForDisplay(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onRefreshSurface(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onRenderStart(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onRenderStart(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onSARChanged(int r100, int r101) {
            VideoEngineCallback.CC.$default$onSARChanged(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ int onSetSurface(TTVideoEngine r100, VideoSurface r101, Surface r102) {
            return VideoEngineCallback.CC.$default$onSetSurface(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onSilenceDetected(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onSilenceDetected(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onStreamChanged(TTVideoEngine r100, int r101) {
            VideoEngineCallback.CC.$default$onStreamChanged(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onVideoSecondFrame(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
            VideoEngineCallback.CC.$default$onVideoSizeChanged(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onVideoStatusException(int r100) {
            VideoEngineCallback.CC.$default$onVideoStatusException(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onVideoStreamBitrateChanged(Resolution r100, int r101) {
            VideoEngineCallback.CC.$default$onVideoStreamBitrateChanged(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onVideoURLRouteFailed(Error r100, String r101) {
            VideoEngineCallback.CC.$default$onVideoURLRouteFailed(this, r100, r101);
        }

        public c(e r100) {
            this.f225570a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onCompletion(TTVideoEngine r100) {
            tt5.a.h("TTPlayer", "TTVideoEngineCallback-onCompletion, playbackState: " + this.f225570a.f225555a.getPlaybackState() + ", loadState: " + this.f225570a.f225555a.getLoadState());
            if (Objects.equals(this.f225570a.f225560f.getValue(), IPlayer.State.ENDED) == true) goto L6;
            com.bytedance.ee.util.ui.j.f(new o(this));
            return;
        }
    }

    public class d implements VideoEngineListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f225571a;

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
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
        public final void onStreamChanged(TTVideoEngine r100, int r101) {
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onVideoSecondFrame(this, r100);
        }

        public d(e r100) {
            this.f225571a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onCompletion(TTVideoEngine r100) {
            tt5.a.h("TTPlayer", "ttvideo engine onVideoStatusException, onCompletion ");
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onError(Error r100) {
            tt5.a.d("TTPlayer", "ttvideo engine onError, error = " + r100);
            com.bytedance.ee.util.ui.j.f(new p(this));
            j r101 = this.f225571a.f225557c;
            if (r101 == null) goto L6;
            r101.j(new Exception(r100.toString()));
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPrepare(TTVideoEngine r100) {
            tt5.a.h("TTPlayer", "ttvideo engine onPrepare start load video");
            if (this.f225571a.f225555a.getPlaybackState() != 1) goto L5;
            tt5.a.k("TTPlayer", "TTVideoEngineListener-onPrepare, already playing, ignored.");
            return;
        L5:
            com.bytedance.ee.util.ui.j.f(new q(this));
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPrepared(TTVideoEngine r100) {
            tt5.a.h("TTPlayer", "ttvideo engine onPrepared load video finished");
            if (this.f225571a.f225555a.getPlaybackState() != 1) goto L5;
            tt5.a.k("TTPlayer", "TTVideoEngineListener-onPrepare, already playing, ignored.");
        L6:
            j r101 = this.f225571a.f225557c;
            if (r101 == null) goto L10;
            r101.h(3);
            return;
        L10:
            return;
        L5:
            com.bytedance.ee.util.ui.j.f(new r(this));
            goto L6
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onRenderStart(TTVideoEngine r100) {
            tt5.a.h("TTPlayer", "ttvideo engine onRenderStart auto play");
            j r101 = this.f225571a.f225557c;
            if (r101 == null) goto L6;
            r101.onRenderStart();
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onVideoStatusException(int r100) {
            tt5.a.h("TTPlayer", "ttvideo engine onVideoStatusException, status = " + r100);
        }

        public final void a(int r100, int r101) {
            IPlayer.State r102 = this.f225571a.f225560f.getValue();
            if (r100 != 0) goto L5;
            final IPlayer.State r103 = IPlayer.State.STOPPED;
        L16:
            tt5.a.h("TTPlayer", "convertPlayerState, playbackState: " + r100 + ", loadState: " + r101 + ", lastPlayerState: " + r102 + ", newPlayerState: " + r103);
            if (Objects.equals(r102, r103) == true) goto L20;
            com.bytedance.ee.util.ui.j.f(new s(this, r103));
            return;
        L20:
            return;
        L5:
            if (r100 == 1) goto L12;
            if (r100 != 2) goto L8;
            r103 = IPlayer.State.PAUSED;
            goto L16
        L8:
            if (r100 == 3) goto L10;
            tt5.a.k("TTPlayer", "convertPlayerState, unrecognized playback state: " + r100);
            r103 = r102;
            goto L16
        L10:
            r103 = IPlayer.State.ERROR;
            goto L16
        L12:
            if (r101 != 2) goto L14;
            r103 = IPlayer.State.BUFFERING;
            goto L16
        L14:
            r103 = IPlayer.State.PLAYING;
            goto L16
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
            tt5.a.h("TTPlayer", "ttvideo engine onLoadStateChanged, loadState = " + r101);
            int r102 = this.f225571a.f225555a.getPlaybackState();
            if (r102 == 0) goto L6;
            a(r102, r101);
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            tt5.a.h("TTPlayer", "ttvideo engine onPlaybackStateChanged, state = " + r101);
            a(r101, this.f225571a.f225555a.getLoadState());
            j r102 = this.f225571a.f225557c;
            if (r102 == null) goto L15;
            if (r101 == 0) goto L13;
            int r103 = 1;
            if (r101 != 1) goto L8;
            r103 = 4;
        L14:
            r102.h(r103);
            goto L15
        L8:
            if (r101 == 2) goto L11;
            if (r101 == 3) goto L13;
        L11:
            r103 = 2;
        L13:
            r103 = 5;
        L15:
            if (r101 == 0) goto L17;
            if (r101 == 3) goto L17;
            return;
        L17:
            b r104 = this.f225571a.f225556b;
            if (r104 == null) goto L22;
            r104.d();
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
            tt5.a.h("TTPlayer", "onVideoSizeChanged, width = " + r101 + ", height = " + r102);
            j r103 = this.f225571a.f225557c;
            if (r103 == null) goto L6;
            r103.onVideoSizeChanged(r101, r102);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.video.player.e$e, reason: collision with other inner class name */
    public static class C3242e implements VideoEventListener {
        @Override // com.ss.ttvideoengine.log.VideoEventListener
        public final void onEvent() {
            JSONArray r100 = VideoEventManager.instance.popAllEvents();     // Catch: Exception -> L8
            int r101 = 0;
        L5:
            if (r101 >= r100.length()) goto L14;
            JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r100, r101);     // Catch: Exception -> L8
            Statistics.recordMiscLog("video_playq", r102);     // Catch: Exception -> L8
            tt5.a.h("TTPlayer", "onEvent: " + du5.b.g(r102.toString()));     // Catch: Exception -> L8
            r101 = r101 + 1;
            goto L5
        L14:
            return;
        L8:
            e = move-exception;
            tt5.a.e("TTPlayer", "VideoEventManager onEvent error", e, false);
        }

        public C3242e() {
        }

        @Override // com.ss.ttvideoengine.log.VideoEventListener
        public void onEventV2(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L14;
            return;
        L14:
            JSONArray r101 = VideoEventManager.instance.popAllEventsV2();     // Catch: Exception -> L11
            int r102 = 0;
        L8:
            if (r102 >= r101.length()) goto L17;
            JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r101, r102);     // Catch: Exception -> L11
            r103.put("params_for_special", "videoplayer_monitor");     // Catch: Exception -> L11
            Statistics.sendEvent(r100, r103);     // Catch: Exception -> L11
            tt5.a.h("TTPlayer", "onEvent: " + r103.toString());     // Catch: Exception -> L11
            r102 = r102 + 1;
            goto L8
        L17:
            return;
        L11:
            e = move-exception;
            tt5.a.e("TTPlayer", "VideoEventManager onEventV2 error", e, false);
        }
    }

    public static class f extends HLSInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<sf5.b> f225572a;

        public f() {
            this.f225572a = Collections.newSetFromMap(new ConcurrentHashMap());
        }

        @Override // com.ss.ttm.player.HLSInfoCallback
        public final void onContentCallback(final String r100) {
            com.bytedance.ee.util.ui.j.c(new u(this, r100));
        }

        @Override // com.ss.ttm.player.HLSInfoCallback
        public final void onLiveDurationCallback(final long r100) {
            com.bytedance.ee.util.ui.j.c(new t(this, r100));
        }
    }

    static {
        f225553l = new a();
        f225554m = new C3242e();
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void d() {
        this.f225561g = "";
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void e() {
        b r100 = this.f225556b;
        if (r100 != null) goto L6;
        tt5.a.h("TTPlayer", "disableMutex, mMutexProxy is null.");
        return;
    L6:
        tt5.a.h("TTPlayer", "disableMutex, scene: " + r100.f225565a);
        r100.d();
        this.f225556b = null;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final long getCurrentPosition() {
        return this.f225555a.getCurrentPlaybackTime();
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final int getPlaybackState() {
        int r100 = this.f225555a.getPlaybackState();
        if (r100 != 0) goto L5;
    L13:
        return 5;
    L5:
        if (r100 != 1) goto L7;
        return 4;
    L7:
        if (r100 != 2) goto L9;
        return 2;
    L9:
        if (r100 == 3) goto L13;
        return 1;
    }

    public final void j() {
        if (hu5.a.e(this.f225562h) == false) goto L5;
        return;
    L5:
        if (this.f225555a == null) goto L23;
        Iterator r100 = ((ConcurrentHashMap) this.f225562h).entrySet().iterator();
    L9:
        if (r100.hasNext() == false) goto L24;
        Map.Entry r101 = (Map.Entry) r100.next();
        if (TextUtils.isEmpty((CharSequence) r101.getKey()) == true) goto L9;
        if (TextUtils.isEmpty((CharSequence) r101.getValue()) == true) goto L9;
        this.f225555a.setCustomHeader((String) r101.getKey(), (String) r101.getValue());
        goto L9
    L24:
        return;
    }

    public final long k() {
        return this.f225555a.getDuration();
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void pause() {
        tt5.a.h("TTPlayer", "ttPlayer pause");
        b r100 = this.f225556b;
        if (r100 != null) goto L5;
        this.f225555a.pause();
        return;
    L5:
        monitor-enter(r100);
        tt5.a.h("TTPlayer", "MediaMutexProxy-onPause.");     // Catch: Throwable -> L9
        r100.f225569e.f225555a.pause();     // Catch: Throwable -> L9
        r100.d();     // Catch: Throwable -> L9
        monitor-exit(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void preload() {
        if (this.f225555a.isPrepared() == true) goto L6;
        tt5.a.h("TTPlayer", "preload, engine not prepared, start preparing.");
        this.f225555a.prepare();
        return;
    L6:
        tt5.a.k("TTPlayer", "preload, no available preload entry.");
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public void release() {
        tt5.a.h("TTPlayer", "ttPlayer release... ");
        this.f225555a.setListener(null);
        this.f225555a.setVideoEngineCallback(null);
        this.f225555a.setHLSInfoCallback(null);
        this.f225559e.f225572a.clear();
        this.f225555a.releaseAsync();
        b r100 = this.f225556b;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public void start() {
        tt5.a.h("TTPlayer", "ttPlayer start");
        this.f225563i = SystemClock.elapsedRealtime();
        if (this.f225555a.getPlaybackState() != 1) goto L6;
        tt5.a.h("TTPlayer", "video is playing return");
        return;
    L6:
        b r100 = this.f225556b;
        if (r100 != null) goto L9;
        this.f225555a.play();
        return;
    L9:
        r100.e();
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void stop() {
        tt5.a.h("TTPlayer", "ttPlayer stop");
        b r100 = this.f225556b;
        if (r100 != null) goto L5;
        this.f225555a.stop();
        return;
    L5:
        monitor-enter(r100);
        tt5.a.h("TTPlayer", "MediaMutexProxy-onStop.");     // Catch: Throwable -> L9
        r100.f225569e.f225555a.stop();     // Catch: Throwable -> L9
        r100.d();     // Catch: Throwable -> L9
        monitor-exit(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        TTVideoEngine r100 = this.f225555a;
        if (r100 != null) goto L7;
        return "TTPlayer(" + hashCode() + "){engine: null}";
    L7:
        return "TTPlayer(" + hashCode() + "){engine: " + r100.hashCode() + ", playbackState: " + r100.getPlaybackState() + ", loadState: " + r100.getLoadState() + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final MutableLiveData h() {
        return this.f225560f;
    }

    public e(Context r100) {
        this.f225558d = Collections.newSetFromMap(new ConcurrentHashMap());
        f r101 = new f();
        this.f225559e = r101;
        this.f225560f = new MutableLiveData(IPlayer.State.IDLE);
        this.f225562h = new ConcurrentHashMap();
        long r102 = o75.b.a().getDriveConfig().f531963f;
        this.f225564j = (NetService) org.koin.java.a.a(NetService.class);
        r100.getApplicationContext();
        v.a();     // Catch: Exception -> L5
        TTVideoEngine r103 = v.b(new d(this));     // Catch: Exception -> L5
        this.f225555a = r103;     // Catch: Exception -> L5
        r103.setVideoEngineCallback(new c(this));     // Catch: Exception -> L5
        this.f225555a.setHLSInfoCallback(r101);     // Catch: Exception -> L5
        tt5.a.h("TTPlayer", "isSystemPlayer=" + this.f225555a.isSystemPlayer());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("TTPlayer", e, false);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void a(sf5.b r100) {
        tt5.a.h("TTPlayer", "removeHlsInfoListener, listener: " + r100);
        this.f225559e.f225572a.remove(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void b(Uri r100) {
        String r101 = r100.toString();
        tt5.a.h("TTPlayer", "prepare uri = " + du5.b.g(r101) + ", mCacheKey = " + this.f225561g);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
    L15:
        this.f225555a.setDirectURL(r101);
    L16:
        this.f225555a.setCustomHeader("doc-device-id", ((b0) org.koin.java.a.a(b0.class)).getDeviceId());
        NetService r103 = this.f225564j;
        if (r103 != null) goto L19;
    L21:
        j();
        return;
    L19:
        if (r103.getEnv() != 3) goto L21;
        tt5.a.h("TTPlayer", "isPreRelease, add prerelease env header");
        this.f225555a.setCustomHeader("env", "Pre_release");
        goto L21
    L10:
        if (r101.startsWith("file") == true) goto L15;
        if (TextUtils.isEmpty(this.f225561g) == true) goto L15;
        this.f225555a.setDirectUrlUseDataLoader(r101, this.f225561g);
        goto L16
    L5:
        if (r101.contains("api/box/stream/sdk") == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void c(Map<String, String> r100) {
        ((ConcurrentHashMap) this.f225562h).clear();
        if (hu5.a.e(r100) == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<String, String> r102 = r101.next();
        if (TextUtils.isEmpty(r102.getKey()) == true) goto L7;
        if (TextUtils.isEmpty(r102.getValue()) == true) goto L7;
        Map<String, String> r103 = this.f225562h;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(r102.getKey(), r102.getValue());
        goto L7
    L13:
        j();
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void f(Scene r100) {
        b r101 = this.f225556b;
        if (r101 == null) goto L6;
        tt5.a.k("TTPlayer", "enableMutex, scene: " + r100 + ", but mMutexProxy already exists, scene: " + r101.f225565a);
        return;
    L6:
        tt5.a.h("TTPlayer", "enableMutex, scene: " + r100);
        this.f225556b = new b(this, r100);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void g(sf5.b r100) {
        tt5.a.h("TTPlayer", "addHlsInfoListener, listener: " + r100);
        this.f225559e.f225572a.add(r100);
    }

    public final void i(sf5.a r100) {
        if (this.f225557c != null) goto L5;
        this.f225557c = new j(this);
    L5:
        this.f225558d.add(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void seekTo(long r100) {
        int r101 = 2000;
        if ((this.f225555a.getDuration() / 10) >= 2000) goto L5;
        r101 = this.f225555a.getDuration() / 10;
    L5:
        long r102 = r101;
        if ((((long) this.f225555a.getDuration()) - r100) >= r102) goto L9;
        tt5.a.h("TTPlayer", "seek to end return gap = " + r101);
        r100 = r100 - r102;
    L9:
        if (this.f225555a.getPlaybackState() != 0) goto L11;
        tt5.a.h("TTPlayer", "seek to current status is stop, start play");
        setStartTime((int) r100);
        start();
        return;
    L11:
        tt5.a.h("TTPlayer", "seek to ... ");
        this.f225555a.seekTo((int) r100, null);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void setSpeed(float r100) {
        tt5.a.h("TTPlayer", "setSpeed, speed: " + r100);
        if (r100 > 0.0f) goto L5;
        r100 = 1.0f;
    L5:
        PlaybackParams r101 = new PlaybackParams();
        r101.setSpeed(r100);
        this.f225555a.setPlaybackParams(r101);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void setStartTime(int r100) {
        this.f225555a.setStartTime(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void setVolume(float r100) {
        tt5.a.h("TTPlayer", "ttPlayer setVolume volume=" + r100);
        if (r100 >= 0.01f) goto L5;
        boolean r101 = true;
    L6:
        this.f225555a.setIsMute(r101);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
