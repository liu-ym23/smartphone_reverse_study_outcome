package com.larus.audioplayer.api.music;

import a88.b;
import a88.c;
import a88.d;
import a88.e;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.platform.api.l0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J6\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J2\u0010'\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010-\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u00101\u001a\u00020\tH\u0016J\b\u00102\u001a\u00020\tH\u0016J\b\u00103\u001a\u00020\tH\u0016J\"\u00104\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00105\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000107H\u0016J \u00108\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0016J \u0010<\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020:H\u0016J\b\u0010>\u001a\u00020:H\u0016J\b\u0010?\u001a\u00020\u0007H\u0016J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070A2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010B\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0012\u0010C\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010D\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010E\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010F\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006G"}, d2 = {"Lcom/larus/audioplayer/api/music/NoopMusicPlayManager;", "Lcom/larus/audioplayer/api/music/IMusicPlayManager;", "<init>", "()V", "getCurrentMusic", "Lcom/larus/audioplayer/api/music/MusicData;", "getCurrentGroupId", "", "getCurrentMusicStatus", "", "registerMusicPlayEngine", "", "registerMediaSessionActionCallback", "callback", "Lcom/larus/audioplayer/api/music/IMusicMediaSessionActionCallback;", "unregisterMediaSessionActionCallback", "addMusicGroup", "", "groupId", "musicList", "Ljava/util/ArrayList;", "removeMusicGroup", "playMusic", "musicId", "setNextAndPreviousMusicCallback", "Lcom/larus/audioplayer/api/music/INextAndPreviousMusicHandler;", "getMusicPausedReason", "targetMusicId", "getMusicPlayReason", "music", "engineCallback", "Lcom/larus/audioplayer/api/music/IMusicPlayEngineCallback;", "nextAndPreviousCallback", "isAuto", "resolution", "stopCurrentMusicForBackgroundAudioTakeover", "pauseMusic", "stopMusic", "onMediaSessionLikeActionTriggered", "onMediaSessionSeekToActionTriggered", "position", "", "fromProgress", "toProgress", "enterMethod", "onMediaSessionMusicActionTriggered", ReportConstant.COMMON_ACTION_TYPE, "updateMusicFavoriteStatus", "status", "getMusicDuration", "getMusicCurrentPlaybackTime", "getMusicLoadedProgress", "setMusicCurrentPlaybackTime", "playbackTime", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "setMusicVolume", "left", "", "right", "setCurrentMusicVolumeByFactor", "getSystemVolume", "getSystemMaxVolume", "getMusicCurrentResolution", "getMusicSupportedResolution", "", "configMusicResolution", "hasNextMusic", "hasPreviousMusic", "playNextMusic", "playPreviousMusic", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopMusicPlayManager implements IMusicPlayManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NoopMusicPlayManager f290178a = null;

    static {
        f290178a = new NoopMusicPlayManager();
    }

    private NoopMusicPlayManager() {
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final e a() {
        return null;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "targetMusicId");
        return null;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "targetMusicId");
        return false;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean d() {
        return false;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int e() {
        return 0;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int f() {
        return 0;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void g(e r100, c r101, d r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "music");
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "targetMusicId");
        return null;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "targetMusicId");
        return false;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void k(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void l() {
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void m(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "musicId");
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String n() {
        return "";
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean o(String r100, int r101, l0 r102) {
        Intrinsics.checkNotNullParameter(r100, "targetMusicId");
        return false;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean p(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "targetMusicId");
        Intrinsics.checkNotNullParameter(r101, "resolution");
        return false;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int q() {
        return 0;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final List<String> i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "targetMusicId");
        return CollectionsKt.emptyList();
    }
}
