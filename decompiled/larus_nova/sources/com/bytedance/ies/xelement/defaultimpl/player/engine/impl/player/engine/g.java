package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.engine;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.MusicPlayerImpl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import java.io.FileDescriptor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements o76.g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f249908o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f249909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o76.a f249910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MediaPlayer f249911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f249912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f249913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f249914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f249915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f249916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f249917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f249918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PlaybackState f249919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f249920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f249921m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f249922n;

    public static final class a {
    }

    @Override // o76.g
    public final int a() {
        return 0;
    }

    @Override // o76.g
    public final long b() {
        return 0;
    }

    @Override // o76.g
    public final boolean e() {
        return false;
    }

    static {
        f249908o = g.class.getSimpleName();
    }

    public final void g() {
        MediaPlayer r100 = new MediaPlayer();
        r100.setAudioStreamType(3);
        r100.setOnPreparedListener(new d(this));
        r100.setOnCompletionListener(new e(this));
        r100.setLooping(false);
        this.f249911c = r100;
    }

    @Override // o76.g
    public final long getCurrentPlaybackTime() {
    L9:
        i();
        return 0;
    L4:
        if (this.f249912d == false) goto L13;
        MediaPlayer r100 = this.f249911c;     // Catch: Throwable -> L9
        if (r100 == null) goto L14;
        return r100.getCurrentPosition();
    L14:
        return 0;
    L13:
        return 0;
    }

    @Override // o76.g
    public final long getDuration() {
    L8:
        th = move-exception;
        l76.d.f507797a.a(f249908o, th.getMessage());
        i();
    L10:
        return 0;
    L3:
        if (this.f249912d == false) goto L10;
        MediaPlayer r100 = this.f249911c;     // Catch: Throwable -> L8
        if (r100 == null) goto L10;
        return r100.getDuration();
    }

    public final void h() {
        l76.d.f507797a.b(f249908o, " ---> resetFlags()");
        this.f249918j = true;
        this.f249913e = false;
        this.f249915g = false;
        this.f249916h = false;
        this.f249917i = false;
        k(false);
    }

    public final void i() {
        MediaPlayer r100 = this.f249911c;
        if (r100 == null) goto L5;
        h();
        r100.setOnCompletionListener(null);
        r100.setOnPreparedListener(null);
        r100.setOnSeekCompleteListener(null);
        r100.reset();
        r100.release();
    L5:
        this.f249911c = null;
    }

    public final void j() {
        l76.d r100 = l76.d.f507797a;
        String r101 = f249908o;
        r100.b(r101, " ---> start(), startPlayTime: " + this.f249914f + ",   mIsStart: " + this.f249915g + ",   mIsPendingStart: " + this.f249913e + ",   mIsPrepared: " + this.f249912d);
        long r102 = this.f249914f;
        if (r102 <= 0) goto L16;
        f(r102, null);
        this.f249914f = 0;
    L16:
        MediaPlayer r103 = this.f249911c;     // Catch: Throwable -> L13
        if (r103 != null) goto L8;
    L11:
        this.f249915g = true;     // Catch: Throwable -> L13
        this.f249913e = false;     // Catch: Throwable -> L13
        this.f249916h = false;     // Catch: Throwable -> L13
        this.f249918j = false;     // Catch: Throwable -> L13
        PlaybackState r104 = PlaybackState.PLAYBACK_STATE_PLAYING;     // Catch: Throwable -> L13
        this.f249919k = r104;     // Catch: Throwable -> L13
        this.f249910b.p(this, r104);     // Catch: Throwable -> L13
        k(true);     // Catch: Throwable -> L13
        return;
    L8:
        if (fna.g.d() == true) goto L10;
        r103.start();     // Catch: Throwable -> L13
        goto L11
    L10:
        r103.start();     // Catch: Throwable -> L13
        gna.a.c(r103.hashCode());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        l76.d.f507797a.a(r101, th.getMessage());
        this.f249910b.h(ErrorCode.INVALIDATE_PLAYER_MODEL);
    }

    @Override // o76.g
    public final void pause() {
        l76.d r100 = l76.d.f507797a;
        String r101 = f249908o;
        r100.b(r101, " ---> pause(), mIsStarted: " + this.f249915g);
        if (this.f249915g == false) goto L18;
        MediaPlayer r102 = this.f249911c;     // Catch: Throwable -> L11
        if (r102 != null) goto L7;
    L15:
    L13:
        this.f249916h = true;
        this.f249915g = false;
        this.f249913e = false;
        this.f249918j = false;
        PlaybackState r103 = PlaybackState.PLAYBACK_STATE_PAUSED;
        this.f249919k = r103;
        this.f249910b.p(this, r103);
        k(false);
        return;
    L7:
        if (fna.g.d() == true) goto L9;
        r102.pause();     // Catch: Throwable -> L11
        goto L15
    L9:
        r102.pause();     // Catch: Throwable -> L11
        gna.a.a(r102.hashCode());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        l76.d.f507797a.a(r101, th.getMessage());
        i();
        goto L13
    }

    @Override // o76.g
    public final void release() {
        l76.d.f507797a.b(f249908o, " ---> release()");
        i();
    }

    @Override // o76.g
    public final void resume() {
        l76.d.f507797a.b(f249908o, " ---> resume(), mIsPaused: " + this.f249916h);
        if (this.f249916h == false) goto L6;
        j();
        return;
    }

    @Override // o76.g
    public final void stop() {
        l76.d r100 = l76.d.f507797a;
        String r101 = f249908o;
        r100.b(r101, " ---> stop(), mIsStopped: " + this.f249918j);
        if (this.f249918j == false) goto L21;
        return;
    L21:
        MediaPlayer r102 = this.f249911c;     // Catch: Throwable -> L18
        if (r102 != null) goto L8;
    L11:
        PlaybackState r103 = PlaybackState.PLAYBACK_STATE_STOPPED;     // Catch: Throwable -> L18
        this.f249919k = r103;     // Catch: Throwable -> L18
        this.f249910b.p(this, r103);     // Catch: Throwable -> L18
        h();     // Catch: Throwable -> L18
        MediaPlayer r104 = this.f249911c;     // Catch: Throwable -> L18
        if (r104 == null) goto L14;
        r104.setOnSeekCompleteListener(null);     // Catch: Throwable -> L18
    L14:
        MediaPlayer r105 = this.f249911c;     // Catch: Throwable -> L18
        if (r105 == null) goto L23;
        r105.seekTo(0);     // Catch: Throwable -> L18
        return;
    L23:
        return;
    L8:
        if (fna.g.d() == true) goto L10;
        r102.pause();     // Catch: Throwable -> L18
        goto L11
    L10:
        r102.pause();     // Catch: Throwable -> L18
        gna.a.a(r102.hashCode());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        l76.d.f507797a.a(r101, th.getMessage());
        i();
    }

    public final void l() {
        long r100 = getCurrentPlaybackTime();
        if (r100 == this.f249920l) goto L8;
        this.f249910b.k(this, r100);
        if (Math.abs(r100 - this.f249921m) < 500) goto L7;
        this.f249910b.o(this, r100);
        this.f249921m = r100;
    L7:
        this.f249920l = r100;
    L8:
        this.f249922n.postAtTime(new f(this), this, SystemClock.uptimeMillis() + 50);
    }

    public final Context getContext() {
        return this.f249909a;
    }

    @Override // o76.g
    public final PlaybackState getPlaybackState() {
        return this.f249919k;
    }

    @Override // o76.g
    public final void c(long r100) {
        l76.d.f507797a.b(f249908o, " ---> play(), startPlayTime: " + r100 + ",   mIsStart: " + this.f249915g + ",   mIsPendingStart: " + this.f249913e + ",   mIsPrepared: " + this.f249912d);
        if (this.f249915g == false) goto L5;
        return;
    L5:
        if (this.f249913e == true) goto L14;
        this.f249914f = r100;
        if (this.f249912d == false) goto L10;
        j();
        return;
    L10:
        this.f249913e = true;
        return;
    }

    public final void k(boolean r100) {
        if (r100 == false) goto L4;
        this.f249922n.postAtTime(new c(this), this, SystemClock.uptimeMillis() + 50);
        return;
    L4:
        this.f249922n.removeCallbacksAndMessages(this);
    }

    @Override // o76.g
    public final void setDirectURL(String r100) {
        l76.d r101 = l76.d.f507797a;
        String r102 = f249908o;
        r101.b(r102, " ---> setDirectURL(), url is " + r100);
    L18:
        th = move-exception;
        l76.d.f507797a.a(r102, th.getMessage());
        this.f249910b.h(ErrorCode.INVALIDATE_PLAYER_MODEL);
        return;
    L4:
        if (this.f249911c != null) goto L6;
        r101.b(r102, "mediaplayer is null ---> createMediaPlayer");     // Catch: Throwable -> L18
        g();     // Catch: Throwable -> L18
    L6:
        MediaPlayer r103 = this.f249911c;     // Catch: Throwable -> L18
        if (r103 == null) goto L23;
        boolean r104 = false;
        this.f249912d = false;     // Catch: Throwable -> L18
        r103.reset();     // Catch: Throwable -> L18
        if (r100 != null) goto L11;
    L13:
        if (r104 == false) goto L15;
        r103.setDataSource(r100);     // Catch: Throwable -> L18
    L16:
        this.f249910b.l(this);     // Catch: Throwable -> L18
        r103.prepareAsync();     // Catch: Throwable -> L18
        return;
    L15:
        r103.setDataSource(this.f249909a, UriProtector.parse(r100));     // Catch: Throwable -> L18
        goto L16
    L11:
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) != true) goto L13;
        r104 = true;
        goto L13
    }

    @Override // o76.g
    public final void setLocalURL(String r100) {
        setDirectURL(r100);
    }

    public g(Context r100, MusicPlayerImpl.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f249909a = r100;
        this.f249910b = r101;
        this.f249918j = true;
        this.f249919k = PlaybackState.PLAYBACK_STATE_STOPPED;
        this.f249920l = Long.MIN_VALUE;
        this.f249921m = Long.MIN_VALUE;
        this.f249922n = new Handler(Looper.getMainLooper());
    }

    @Override // o76.g
    public final void d(Resolution r100, VideoModel r101) {
        l76.d.f507797a.a(f249908o, "light player not support VideoModel src Type");
    }

    @Override // o76.g
    public final void f(final long r100, final com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.b r101) {
        l76.d r102 = l76.d.f507797a;
        String r103 = f249908o;
        r102.b(r103, " ---> seekToTime(), time: " + r100 + ",   mIsSeeking: " + this.f249917i);
        if (this.f249917i == false) goto L5;
    L18:
        if (r101 == null) goto L25;
        r101.a(r100, false);
        return;
    L25:
        return;
    L5:
        if (r100 < 0) goto L18;
        this.f249917i = true;
        k(false);
        MediaPlayer r104 = this.f249911c;     // Catch: Throwable -> L15
        if (r104 == null) goto L11;
        r104.seekTo((int) r100);     // Catch: Throwable -> L15
    L11:
        MediaPlayer r105 = this.f249911c;     // Catch: Throwable -> L15
        if (r105 == null) goto L23;
        r105.setOnSeekCompleteListener(new b(r101, r100, this));     // Catch: Throwable -> L15
        return;
    L23:
        return;
    L15:
        th = move-exception;
        l76.d.f507797a.a(r103, th.getMessage());
        i();
    }

    @Override // o76.g
    public final void setDirectUrlUseDataLoader(String r100, String r101) {
        setDirectURL(r100);
    }

    @Override // o76.g
    public final void setDataSource(FileDescriptor r100, long r110, long r111) {
        String r101 = f249908o;
        l76.d r102 = l76.d.f507797a;     // Catch: Throwable -> L10
        r102.b(r101, " ---> setDataSource(), file descriptor is " + r100);     // Catch: Throwable -> L10
        if (this.f249911c != null) goto L6;
        r102.b(r101, "mediaplayer is null ---> createMediaPlayer");     // Catch: Throwable -> L10
        g();     // Catch: Throwable -> L10
    L6:
        MediaPlayer r103 = this.f249911c;     // Catch: Throwable -> L10
        if (r103 == null) goto L15;
        this.f249912d = false;     // Catch: Throwable -> L10
        r103.reset();     // Catch: Throwable -> L10
        r103.setDataSource(r100, r110, r111);     // Catch: Throwable -> L10
        this.f249910b.l(this);     // Catch: Throwable -> L10
        r103.prepareAsync();     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        l76.d.f507797a.a(r101, th.getMessage());
        this.f249910b.h(ErrorCode.INVALIDATE_PLAYER_MODEL);
    }
}
