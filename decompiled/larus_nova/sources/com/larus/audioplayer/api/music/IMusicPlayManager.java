package com.larus.audioplayer.api.music;

import a88.b;
import a88.c;
import a88.d;
import a88.e;
import com.bytedance.applet.jsb.c0;
import com.bytedance.applet.jsb.e1;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.platform.api.l0;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H&J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0017H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J>\u0010\u0014\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005H&J\b\u0010!\u001a\u00020\u000fH&J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H&J2\u0010%\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H&J\"\u0010+\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0005H&J$\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\b\u0010/\u001a\u00020\u0007H&J\b\u00100\u001a\u00020\u0007H&J\b\u00101\u001a\u00020\u0007H&J$\u00102\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u000105H&J \u00106\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H&J \u0010:\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H&J\b\u0010;\u001a\u000208H&J\b\u0010<\u001a\u000208H&J\b\u0010=\u001a\u00020\u0005H&J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050?2\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0018\u0010@\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H&J\u0012\u0010A\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010B\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010C\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010D\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005H&¨\u0006E"}, d2 = {"Lcom/larus/audioplayer/api/music/IMusicPlayManager;", "", "getCurrentMusic", "Lcom/larus/audioplayer/api/music/MusicData;", "getCurrentGroupId", "", "getCurrentMusicStatus", "", "registerMusicPlayEngine", "", "registerMediaSessionActionCallback", "callback", "Lcom/larus/audioplayer/api/music/IMusicMediaSessionActionCallback;", "unregisterMediaSessionActionCallback", "addMusicGroup", "", "groupId", "musicList", "Ljava/util/ArrayList;", "removeMusicGroup", "playMusic", "musicId", "setNextAndPreviousMusicCallback", "Lcom/larus/audioplayer/api/music/INextAndPreviousMusicHandler;", "getMusicPausedReason", "targetMusicId", "getMusicPlayReason", "music", "engineCallback", "Lcom/larus/audioplayer/api/music/IMusicPlayEngineCallback;", "nextAndPreviousCallback", "isAuto", "resolution", "stopCurrentMusicForBackgroundAudioTakeover", "pauseMusic", "stopMusic", "onMediaSessionLikeActionTriggered", "onMediaSessionSeekToActionTriggered", "position", "", "fromProgress", "toProgress", "enterMethod", "onMediaSessionMusicActionTriggered", ReportConstant.COMMON_ACTION_TYPE, "updateMusicFavoriteStatus", "status", "getMusicDuration", "getMusicCurrentPlaybackTime", "getMusicLoadedProgress", "setMusicCurrentPlaybackTime", "playbackTime", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "setMusicVolume", "left", "", "right", "setCurrentMusicVolumeByFactor", "getSystemVolume", "getSystemMaxVolume", "getMusicCurrentResolution", "getMusicSupportedResolution", "", "configMusicResolution", "hasNextMusic", "hasPreviousMusic", "playNextMusic", "playPreviousMusic", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMusicPlayManager {

    public static final class a {
        public static /* synthetic */ void a(MusicPlayManagerDelegate r100, e r101, c0 r110, e1 r111, boolean r112, int r113) {
            if ((r113 & 2) == 0) goto L5;
            c0 r102 = null;
        L7:
            if ((r113 & 4) == 0) goto L9;
            e1 r103 = null;
        L11:
            if ((r113 & 8) == 0) goto L13;
            boolean r104 = false;
        L14:
            r100.g(r101, r102, r103, r104, null);
            return;
        L13:
            r104 = r112;
            goto L14
        L9:
            r103 = r111;
            goto L11
        L5:
            r102 = r110;
            goto L7
        }
    }

    e a();

    String b(String r100);

    boolean c(String r100);

    boolean d();

    int e();

    int f();

    void g(e r100, c r101, d r102, boolean r103, String r104);

    String h(String r100);

    List<String> i(String r100);

    boolean j(String r100);

    void k(b r100);

    void l();

    void m(boolean r100, String r101, String r102);

    String n();

    boolean o(String r100, int r101, l0 r102);

    boolean p(String r100, String r101);

    int q();
}
