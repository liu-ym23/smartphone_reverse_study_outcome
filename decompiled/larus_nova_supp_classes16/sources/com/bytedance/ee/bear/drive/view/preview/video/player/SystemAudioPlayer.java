package com.bytedance.ee.bear.drive.view.preview.video.player;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.ss.android.lark.media.Scene;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SystemAudioPlayer implements IPlayer {
    public final MutableLiveData<IPlayer.State> a;
    public final Context b;
    public final MediaPlayer c;
    public boolean d;
    public MediaPlayerState e;
    public sf5.a f;

    public static final enum MediaPlayerState extends Enum<MediaPlayerState> {
        public static final MediaPlayerState MPS_END = null;
        public static final MediaPlayerState MPS_ERROR = null;
        public static final MediaPlayerState MPS_IDLE = null;
        public static final MediaPlayerState MPS_INITIALIZED = null;
        public static final MediaPlayerState MPS_PAUSED = null;
        public static final MediaPlayerState MPS_PLAYBACK_COMPLETED = null;
        public static final MediaPlayerState MPS_PREPARED = null;
        public static final MediaPlayerState MPS_PREPARING = null;
        public static final MediaPlayerState MPS_STARTED = null;
        public static final MediaPlayerState MPS_STOPPED = null;
        public static final /* synthetic */ MediaPlayerState[] a = null;

        static {
            MediaPlayerState r0 = new MediaPlayerState("MPS_IDLE", 0);
            MPS_IDLE = r0;
            MediaPlayerState r1 = new MediaPlayerState("MPS_INITIALIZED", 1);
            MPS_INITIALIZED = r1;
            MediaPlayerState r3 = new MediaPlayerState("MPS_PREPARING", 2);
            MPS_PREPARING = r3;
            MediaPlayerState r5 = new MediaPlayerState("MPS_PREPARED", 3);
            MPS_PREPARED = r5;
            MediaPlayerState r7 = new MediaPlayerState("MPS_STARTED", 4);
            MPS_STARTED = r7;
            MediaPlayerState r9 = new MediaPlayerState("MPS_STOPPED", 5);
            MPS_STOPPED = r9;
            MediaPlayerState r11 = new MediaPlayerState("MPS_PAUSED", 6);
            MPS_PAUSED = r11;
            MediaPlayerState r13 = new MediaPlayerState("MPS_PLAYBACK_COMPLETED", 7);
            MPS_PLAYBACK_COMPLETED = r13;
            MediaPlayerState r16 = new MediaPlayerState("MPS_ERROR", 8);
            MPS_ERROR = r16;
            MediaPlayerState r14 = new MediaPlayerState("MPS_END", 9);
            MPS_END = r14;
            a = new MediaPlayerState[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14};
        }

        public static MediaPlayerState[] values() {
            return (MediaPlayerState[]) a.clone();
        }

        public static MediaPlayerState valueOf(String r1) {
            return (MediaPlayerState) r27.a.a(MediaPlayerState.class, r1);
        }

        public MediaPlayerState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaPlayerState.values().length];
            a = r0;
            r0[MediaPlayerState.MPS_IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[MediaPlayerState.MPS_PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[MediaPlayerState.MPS_PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[MediaPlayerState.MPS_PAUSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[MediaPlayerState.MPS_STOPPED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[MediaPlayerState.MPS_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[MediaPlayerState.MPS_STARTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public final void a(sf5.b r1) {
    }

    public final void c(Map<String, String> r1) {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f(Scene r1) {
    }

    public final void g(sf5.b r1) {
    }

    public final void setSpeed(float r1) {
    }

    public final void setStartTime(int r1) {
    }

    public final long getCurrentPosition() {
        return this.c.getCurrentPosition();
    L4:
        th = move-exception;
        tt5.a.f("SystemAudioPlayer", th, false);
        return 0;
    }

    public final int getPlaybackState() {
        switch(a.a[this.e.ordinal()]) {
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L10;
        };
    L5:
        return 4;
    L6:
        return 5;
    L7:
        return 3;
    L8:
        return 2;
    L10:
        return 1;
    }

    public final long i() {
        return this.c.getDuration();
    }

    public final void pause() {
        MediaPlayer r0 = this.c;     // Catch: Exception -> L8
        if (fna.g.d() == true) goto L5;
        r0.pause();     // Catch: Exception -> L8
    L6:
        j(MediaPlayerState.MPS_PAUSED);     // Catch: Exception -> L8
        return;
    L5:
        r0.pause();     // Catch: Exception -> L8
        gna.a.a(r0.hashCode());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    public final void preload() {
        tt5.a.k("SystemAudioPlayer", "preload, not supported.");
    }

    public final void release() {
        this.c.release();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    public final void start() {
        MediaPlayer r0 = this.c;     // Catch: Exception -> L8
        if (fna.g.d() == true) goto L5;
        r0.start();     // Catch: Exception -> L8
    L6:
        j(MediaPlayerState.MPS_STARTED);     // Catch: Exception -> L8
        return;
    L5:
        r0.start();     // Catch: Exception -> L8
        gna.a.c(r0.hashCode());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    public final void stop() {
        MediaPlayer r0 = this.c;     // Catch: Exception -> L8
        if (fna.g.d() == true) goto L5;
        r0.stop();     // Catch: Exception -> L8
    L6:
        j(MediaPlayerState.MPS_STOPPED);     // Catch: Exception -> L8
        return;
    L5:
        r0.stop();     // Catch: Exception -> L8
        gna.a.a(r0.hashCode());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    public final MutableLiveData h() {
        return this.a;
    }

    public final void b(Uri r5) {
    L7:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
        this.d = false;
        return;
    L3:
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;     // Catch: Exception -> L7
        this.c.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());     // Catch: Exception -> L7
        this.c.setDataSource(this.b, r5);     // Catch: Exception -> L7
        j(MediaPlayerState.MPS_INITIALIZED);     // Catch: Exception -> L7
        this.c.prepareAsync();     // Catch: Exception -> L7
        j(MediaPlayerState.MPS_PREPARING);     // Catch: Exception -> L7
    }

    public final void j(MediaPlayerState r2) {
        this.e = r2;
        sf5.a r3 = this.f;
        if (r3 == null) goto L6;
        r3.h(getPlaybackState());
        return;
    }

    public final void seekTo(long r2) {
        this.c.seekTo((int) r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    public final void setVolume(float r3) {
        this.c.setVolume(r3, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    public SystemAudioPlayer(Context r3, final boolean r4) {
        this.a = new MutableLiveData();
        MediaPlayerState r0 = MediaPlayerState.MPS_IDLE;
        this.e = r0;
        this.b = r3;
        MediaPlayer r5 = new MediaPlayer();
        this.c = r5;
        r5.setOnPreparedListener(new com.bytedance.ee.bear.drive.view.preview.video.player.a(this, r4));
        r5.setOnCompletionListener(new b(this));
        r5.setOnErrorListener(new c(this));
        j(r0);
    }
}
