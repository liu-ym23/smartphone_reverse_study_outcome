package com.bytedance.ee.bear.drive.view.preview.video.player;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.ss.android.lark.media.Scene;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class SystemAudioPlayer implements IPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<IPlayer.State> f225540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f225541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaPlayer f225542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f225543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaPlayerState f225544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public sf5.a f225545f;

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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MediaPlayerState[] f225546a = null;

        static {
            MediaPlayerState r100 = new MediaPlayerState("MPS_IDLE", 0);
            MPS_IDLE = r100;
            MediaPlayerState r101 = new MediaPlayerState("MPS_INITIALIZED", 1);
            MPS_INITIALIZED = r101;
            MediaPlayerState r102 = new MediaPlayerState("MPS_PREPARING", 2);
            MPS_PREPARING = r102;
            MediaPlayerState r103 = new MediaPlayerState("MPS_PREPARED", 3);
            MPS_PREPARED = r103;
            MediaPlayerState r104 = new MediaPlayerState("MPS_STARTED", 4);
            MPS_STARTED = r104;
            MediaPlayerState r105 = new MediaPlayerState("MPS_STOPPED", 5);
            MPS_STOPPED = r105;
            MediaPlayerState r110 = new MediaPlayerState("MPS_PAUSED", 6);
            MPS_PAUSED = r110;
            MediaPlayerState r111 = new MediaPlayerState("MPS_PLAYBACK_COMPLETED", 7);
            MPS_PLAYBACK_COMPLETED = r111;
            MediaPlayerState r112 = new MediaPlayerState("MPS_ERROR", 8);
            MPS_ERROR = r112;
            MediaPlayerState r113 = new MediaPlayerState("MPS_END", 9);
            MPS_END = r113;
            f225546a = new MediaPlayerState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static MediaPlayerState[] values() {
            return (MediaPlayerState[]) f225546a.clone();
        }

        public static MediaPlayerState valueOf(String r100) {
            return (MediaPlayerState) r27.a.a(MediaPlayerState.class, r100);
        }

        public MediaPlayerState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f225547a = null;

        static {
            int[] r100 = new int[MediaPlayerState.values().length];
            f225547a = r100;
            r100[MediaPlayerState.MPS_IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f225547a[MediaPlayerState.MPS_PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f225547a[MediaPlayerState.MPS_PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f225547a[MediaPlayerState.MPS_PAUSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f225547a[MediaPlayerState.MPS_STOPPED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f225547a[MediaPlayerState.MPS_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f225547a[MediaPlayerState.MPS_STARTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void a(sf5.b r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void c(Map<String, String> r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void d() {
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void e() {
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void f(Scene r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void g(sf5.b r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void setSpeed(float r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void setStartTime(int r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final long getCurrentPosition() {
        return this.f225542c.getCurrentPosition();
    L4:
        th = move-exception;
        tt5.a.f("SystemAudioPlayer", th, false);
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final int getPlaybackState() {
        switch(a.f225547a[this.f225544e.ordinal()]) {
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
        return this.f225542c.getDuration();
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void pause() {
        MediaPlayer r100 = this.f225542c;     // Catch: Exception -> L8
        if (fna.g.d() == true) goto L5;
        r100.pause();     // Catch: Exception -> L8
    L6:
        j(MediaPlayerState.MPS_PAUSED);     // Catch: Exception -> L8
        return;
    L5:
        r100.pause();     // Catch: Exception -> L8
        gna.a.a(r100.hashCode());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void preload() {
        tt5.a.k("SystemAudioPlayer", "preload, not supported.");
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void release() {
        this.f225542c.release();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void start() {
        MediaPlayer r100 = this.f225542c;     // Catch: Exception -> L8
        if (fna.g.d() == true) goto L5;
        r100.start();     // Catch: Exception -> L8
    L6:
        j(MediaPlayerState.MPS_STARTED);     // Catch: Exception -> L8
        return;
    L5:
        r100.start();     // Catch: Exception -> L8
        gna.a.c(r100.hashCode());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void stop() {
        MediaPlayer r100 = this.f225542c;     // Catch: Exception -> L8
        if (fna.g.d() == true) goto L5;
        r100.stop();     // Catch: Exception -> L8
    L6:
        j(MediaPlayerState.MPS_STOPPED);     // Catch: Exception -> L8
        return;
    L5:
        r100.stop();     // Catch: Exception -> L8
        gna.a.a(r100.hashCode());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final MutableLiveData h() {
        return this.f225540a;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void b(Uri r100) {
    L7:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
        this.f225543d = false;
        return;
    L3:
        if (this.f225543d == false) goto L5;
        return;
    L5:
        this.f225543d = true;     // Catch: Exception -> L7
        this.f225542c.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());     // Catch: Exception -> L7
        this.f225542c.setDataSource(this.f225541b, r100);     // Catch: Exception -> L7
        j(MediaPlayerState.MPS_INITIALIZED);     // Catch: Exception -> L7
        this.f225542c.prepareAsync();     // Catch: Exception -> L7
        j(MediaPlayerState.MPS_PREPARING);     // Catch: Exception -> L7
    }

    public final void j(MediaPlayerState r100) {
        this.f225544e = r100;
        sf5.a r101 = this.f225545f;
        if (r101 == null) goto L6;
        r101.h(getPlaybackState());
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void seekTo(long r100) {
        this.f225542c.seekTo((int) r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.player.IPlayer
    public final void setVolume(float r100) {
        this.f225542c.setVolume(r100, r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    }

    public SystemAudioPlayer(Context r100, final boolean r101) {
        this.f225540a = new MutableLiveData();
        MediaPlayerState r102 = MediaPlayerState.MPS_IDLE;
        this.f225544e = r102;
        this.f225541b = r100;
        MediaPlayer r103 = new MediaPlayer();
        this.f225542c = r103;
        r103.setOnPreparedListener(new com.bytedance.ee.bear.drive.view.preview.video.player.a(this, r101));
        r103.setOnCompletionListener(new b(this));
        r103.setOnErrorListener(new c(this));
        j(r102);
    }
}
