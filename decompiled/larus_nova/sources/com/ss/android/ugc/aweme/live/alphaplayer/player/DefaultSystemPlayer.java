package com.ss.android.ugc.aweme.live.alphaplayer.player;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.ugc.aweme.live.alphaplayer.model.VideoInfo;
import f06.b;
import f06.d;
import fna.g;
import gna.a;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class DefaultSystemPlayer extends AbsPlayer<DefaultSystemPlayer> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MediaPlayer f451189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MediaMetadataRetriever f451190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f451191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MediaPlayer.OnCompletionListener f451192j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MediaPlayer.OnPreparedListener f451193k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MediaPlayer.OnErrorListener f451194l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MediaPlayer.OnInfoListener f451195m;

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final String c() {
        return "DefaultSystemPlayer";
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void a() {
        this.f451189g.setScreenOnWhilePlaying(true);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void b() {
        MediaPlayer r100 = new MediaPlayer();
        this.f451189g = r100;
        r100.setOnCompletionListener(this.f451192j);
        this.f451189g.setOnPreparedListener(this.f451193k);
        this.f451189g.setOnErrorListener(this.f451194l);
        this.f451189g.setOnInfoListener(this.f451195m);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final int getCurrentPosition() {
        return this.f451189g.getCurrentPosition();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final VideoInfo getVideoInfo() throws Exception {
        if (TextUtils.isEmpty(this.f451191i) == true) goto L13;
        this.f451190h.setDataSource(this.f451191i);
        String r100 = h(this.f451190h, 18);
        String r101 = h(this.f451190h, 19);
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return new VideoInfo(CastIntegerProtector.parseInt(h(this.f451190h, 18)), CastIntegerProtector.parseInt(h(this.f451190h, 19)), this.f451189g.getDuration());
    L11:
        throw new Exception("retriever get metadata failure");
    L13:
        throw new Exception("dataSource is null, please set setDataSource firstly");
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final boolean isPlaying() {
        return this.f451189g.isPlaying();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void pause() {
        MediaPlayer r100 = this.f451189g;
        if (g.d() == true) goto L5;
        r100.pause();
        return;
    L5:
        r100.pause();
        a.a(r100.hashCode());
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void prepareAsync() {
        this.f451189g.prepareAsync();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void release() {
        this.f451189g.release();
        this.f451191i = null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void reset() {
        this.f451189g.reset();
        this.f451191i = null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void start() {
        MediaPlayer r100 = this.f451189g;
        if (g.d() == true) goto L5;
        r100.start();
        return;
    L5:
        r100.start();
        a.c(r100.hashCode());
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void stop() {
        MediaPlayer r100 = this.f451189g;
        if (g.d() == true) goto L5;
        r100.stop();
        return;
    L5:
        r100.stop();
        a.a(r100.hashCode());
    }

    public DefaultSystemPlayer() {
        this.f451190h = new MediaMetadataRetriever();
        this.f451192j = new AnonymousClass1(this);
        this.f451193k = new AnonymousClass2(this);
        this.f451194l = new AnonymousClass3(this);
        this.f451195m = new AnonymousClass4(this);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void seekTo(int r100) {
        this.f451189g.seekTo(r100, 3);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setDataSource(String r100) throws IOException {
        this.f451191i = r100;
        this.f451189g.setDataSource(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setLooping(boolean r100) {
        this.f451189g.setLooping(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setSurface(Surface r100) {
        this.f451189g.setSurface(r100);
    }

    public static String h(MediaMetadataRetriever r110, int r111) throws Exception {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
