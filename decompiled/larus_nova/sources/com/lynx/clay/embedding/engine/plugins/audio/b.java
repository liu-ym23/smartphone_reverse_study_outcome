package com.lynx.clay.embedding.engine.plugins.audio;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineSimpleCallback;
import com.ss.ttvideoengine.utils.Error;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements AudioPlayer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTVideoEngine f380766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioPlayer f380767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f380768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f380769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PthreadTimer f380770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f380771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C4548b f380772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f380773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f380774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f380775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f380776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f380777l;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f380778a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f380778a;     // Catch: Throwable -> L8
            AudioPlayer r101 = r100.f380767b;     // Catch: Throwable -> L8
            if (r101 == null) goto L11;
            TTVideoEngine r102 = r100.f380766a;     // Catch: Throwable -> L8
            if (r102 == null) goto L15;
            r101.onTimeUpdate(r102.getCurrentPlaybackTime(), this.f380778a.f380767b.getCurrentSrcID());     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(b r100) {
            this.f380778a = r100;
        }
    }

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.audio.b$b, reason: collision with other inner class name */
    public class C4548b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f380779a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            b r100 = this.f380779a;     // Catch: Throwable -> L6
            if (r100.f380774i == false) goto L9;
            r100.f380769d.post(r100.f380771f);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public C4548b(b r100) {
            this.f380779a = r100;
        }
    }

    public class c extends VideoEngineSimpleCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f380780a;

        public c(b r100) {
            this.f380780a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onCompletion(TTVideoEngine r100) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onCompletion");
            AudioPlayer r101 = this.f380780a.f380767b;
            r101.onFinished(r101.getCurrentSrcID());
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onError(Error r100) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onError - code: " + r100.code);
            AudioPlayer r101 = this.f380780a.f380767b;
            r101.onError(r100.code, r100.description, r101.getCurrentSrcID());
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onPrepared(TTVideoEngine r100) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onPrepared");
            AudioPlayer r101 = this.f380780a.f380767b;
            r101.onPrepared(r101.getCurrentSrcID());
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onLoadStateChanged " + r101);
            if (r101 != 0) goto L5;
            String r102 = "unknown";
        L12:
            AudioPlayer r103 = this.f380780a.f380767b;
            r103.onLoadingStateChanged(r101, r102, r103.getCurrentSrcID());
            return;
        L5:
            if (r101 != 1) goto L7;
            r102 = "playable";
            goto L12
        L7:
            if (r101 == 2) goto L9;
            r102 = "error";
            goto L12
        L9:
            r102 = "stalled";
            goto L12
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onPlaybackStateChanged " + r101);
            b r102 = this.f380780a;
            if (r101 != 1) goto L5;
            boolean r103 = true;
        L6:
            r102.f380774i = r103;
            if (r101 == 0) goto L14;
            if (r101 != 1) goto L10;
            String r104 = "playing";
        L15:
            AudioPlayer r105 = r102.f380767b;
            r105.onPlaybackStateChanged(r101, r104, r105.getCurrentSrcID());
            return;
        L10:
            if (r101 == 2) goto L12;
            r104 = "error";
            goto L15
        L12:
            r104 = "paused";
            goto L15
        L14:
            r104 = "stopped";
            goto L15
        L5:
            r103 = false;
            goto L6
        }
    }

    public class d implements SeekCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f380781a;

        public d(b r100) {
            this.f380781a = r100;
        }

        @Override // com.ss.ttvideoengine.SeekCompletionListener
        public final void onCompletion(boolean r100) {
            AudioPlayer r101 = this.f380781a.f380767b;
            r101.onSeek(r101.getCurrentSrcID());
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void f() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int b() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getIntOption(60);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int d() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getIntOption(61);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void dispose() {
        C4548b r100 = this.f380772g;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f380772g = null;
    L5:
        TTVideoEngine r101 = this.f380766a;
        if (r101 == null) goto L11;
        r101.setVideoEngineSimpleCallback(null);
        if (this.f380766a.getPlaybackState() != 1) goto L10;
        this.f380766a.stop();
    L10:
        this.f380766a.releaseAsync();
        this.f380766a = null;
    L11:
        this.f380767b = null;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void enterBackground() {
        if (this.f380776k == false) goto L6;
        return;
    L6:
        if (this.f380766a.getPlaybackState() != 1) goto L8;
        boolean r100 = true;
    L9:
        this.f380775j = r100;
        if (r100 == false) goto L14;
        this.f380766a.pause();
        C4548b r101 = this.f380772g;
        if (r101 == null) goto L14;
        r101.cancel();
        this.f380772g = null;
    L14:
        this.f380776k = true;
        return;
    L8:
        r100 = false;
        goto L9
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void enterForeground() {
        if (this.f380776k == true) goto L6;
        return;
    L6:
        if (this.f380775j == false) goto L8;
        this.f380766a.play();
        h();
    L8:
        this.f380776k = false;
    }

    public final void g() {
        if (this.f380766a == null) goto L5;
        return;
    L5:
        if (this.f380767b == null) goto L10;
        TTVideoEngine r100 = new TTVideoEngine(this.f380767b.getFlutterView().getContext().getApplicationContext(), this.f380768c);
        this.f380766a = r100;
        r100.setVideoEngineSimpleCallback(new c(this));
        this.f380766a.setIntOption(160, 1);
        this.f380766a.setIntOption(480, 1);
        this.f380766a.setIntOption(402, 1);
        this.f380766a.setIntOption(27, 1);
        this.f380766a.setIntOption(416, 0);
        this.f380766a.setIntOption(314, 1);
        this.f380766a.setIntOption(28, 6);
        this.f380766a.setIntOption(18, 1);
        this.f380766a.setIntOption(415, 1);
        this.f380766a.setIntOption(0, 300);
        this.f380766a.setIntOption(480, 1);
        this.f380766a.setLooping(this.f380767b.isLoop());
        this.f380766a.setIsMute(this.f380767b.isMute());
        this.f380766a.setVolume(this.f380767b.getVolume(), this.f380767b.getVolume());
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getCurrentTime() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getCurrentPlaybackTime();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getDuration() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getDuration();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getPlaybackState() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getPlaybackState();
    }

    public final void h() {
        C4548b r100 = this.f380772g;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f380772g = null;
    L5:
        C4548b r101 = new C4548b(this);
        this.f380772g = r101;
        this.f380770e.schedule(r101, 0, this.f380773h);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void pause() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.pause();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void play() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.play();
        this.f380766a.seekTo(0, null);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void prepare() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.prepare();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void resume() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.play();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void stop() {
        TTVideoEngine r100 = this.f380766a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.stop();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void a(int r100) {
        TTVideoEngine r101 = this.f380766a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.seekTo(r100, new d(this));
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void c(boolean r100) {
        TTVideoEngine r101 = this.f380766a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setIsMute(r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setInterval(int r100) {
        c5a.c.d(6, "AudioPlayerTTImpl", "setInterval - " + r100);
        C4548b r101 = this.f380772g;
        if (r101 == null) goto L6;
        r101.cancel();
        this.f380772g = null;
    L6:
        if (r100 >= 15) goto L8;
        r100 = 15;
    L8:
        this.f380773h = r100;
        h();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setLoop(boolean r100) {
        TTVideoEngine r101 = this.f380766a;
        if (r101 == null) goto L6;
        r101.setLooping(r100);
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setSrc(String r100) {
        g();
        AudioPlayer r101 = this.f380767b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f380766a != null) goto L8;
        return;
    L8:
        if (r101.isRemoteUrl(r100) == false) goto L10;
        this.f380766a.setDirectURL(r100);
    L12:
        if (this.f380767b.isAutoplay() == false) goto L16;
        this.f380766a.play();
        return;
    L16:
        return;
    L10:
        this.f380766a.setLocalURL(r100);
        goto L12
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setVid(String r100) {
        this.f380777l = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L25;
        g();
        if (this.f380767b != null) goto L10;
        return;
    L10:
        if (this.f380766a == null) goto L26;
        String r101 = this.f380777l;
        if (r101 == null) goto L19;
        if (r101.isEmpty() == true) goto L19;
        this.f380766a.setIntOption(21, 1);
        this.f380766a.setVideoID(this.f380777l);
    L19:
        if (this.f380767b.isAutoplay() == false) goto L24;
        this.f380766a.play();
        return;
    L24:
        return;
    L26:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setVolume(float r100) {
        TTVideoEngine r101 = this.f380766a;
        if (r101 == null) goto L6;
        r101.setVolume(r100, r100);
        return;
    }

    public b(AudioPlayer r100, String r101) {
        this.f380770e = new PthreadTimer("AudioPlayerTTImpl");
        this.f380771f = new a(this);
        this.f380773h = 500;
        this.f380774i = false;
        this.f380775j = false;
        this.f380776k = false;
        this.f380767b = r100;
        if (r101.equals("light") == false) goto L5;
        this.f380768c = 2;
    L6:
        this.f380769d = new Handler(this.f380767b.getFlutterView().getContext().getMainLooper());
        h();
        return;
    L5:
        this.f380768c = 0;
        goto L6
    }
}
