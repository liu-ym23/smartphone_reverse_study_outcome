package com.larus.platform.api;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl;
import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
public interface IVideoController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/IVideoController$MediaType;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO", "VOICE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MediaType extends Enum<MediaType> {
        public static final MediaType VIDEO = null;
        public static final MediaType VOICE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MediaType[] f364787a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f364788b = null;

        public static EnumEntries<MediaType> getEntries() {
            return f364788b;
        }

        static {
            MediaType r100 = new MediaType("VIDEO", 0);
            VIDEO = r100;
            MediaType r101 = new MediaType("VOICE", 1);
            VOICE = r101;
            MediaType[] r102 = {r100, r101};
            f364787a = r102;
            f364788b = EnumEntriesKt.enumEntries(r102);
        }

        public static MediaType[] values() {
            return (MediaType[]) f364787a.clone();
        }

        public static MediaType valueOf(String r100) {
            return (MediaType) r27.a.a(MediaType.class, r100);
        }

        public MediaType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/IVideoController$PlayType;", "", "<init>", "(Ljava/lang/String;I)V", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "PREPARE", "PAUSE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PlayType extends Enum<PlayType> {
        public static final PlayType PAUSE = null;
        public static final PlayType PLAY = null;
        public static final PlayType PREPARE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlayType[] f364789a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f364790b = null;

        public static EnumEntries<PlayType> getEntries() {
            return f364790b;
        }

        static {
            PlayType r100 = new PlayType(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0);
            PLAY = r100;
            PlayType r101 = new PlayType("PREPARE", 1);
            PREPARE = r101;
            PlayType r102 = new PlayType("PAUSE", 2);
            PAUSE = r102;
            PlayType[] r103 = {r100, r101, r102};
            f364789a = r103;
            f364790b = EnumEntriesKt.enumEntries(r103);
        }

        public static PlayType[] values() {
            return (PlayType[]) f364789a.clone();
        }

        public static PlayType valueOf(String r100) {
            return (PlayType) r27.a.a(PlayType.class, r100);
        }

        public PlayType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IVideoController r100, com.larus.video.impl.sdk.a r101, long r102, int r110) {
            if ((r110 & 4) == 0) goto L5;
            r102 = LynxResourceModule.DEFAULT_MEDIA_SIZE;
        L5:
            long r103 = r102;
            if ((r110 & 8) == 0) goto L8;
            DataLoaderPreloadPriority r104 = DataLoaderPreloadPriority.DEFAULT;
        L9:
            r100.m(r101, null, r103, r104, null);
            return;
        L8:
            r104 = null;
            goto L9
        }
    }

    void A(int r100, l0 r101);

    void B(float r100, float r101);

    void C(boolean r100);

    void D(VideoEngineMusicPlayerViewImpl.h r100, String r101);

    void E(String r100);

    boolean F(String r100);

    int G(VideoEngineState r100);

    void H(n r100);

    void I(boolean r100);

    n a();

    void b();

    void c(float r100);

    PlayType d();

    int e(com.larus.video.impl.sdk.a r100);

    void f(String r100, l4 r101);

    float g();

    String getBotId();

    int getCurrentPlaybackTime();

    String getCurrentResolution();

    String getMediaId();

    int getWatchedDuration();

    void h(k4 r100);

    void i(int r100);

    boolean isReleased();

    void j(p0 r100, boolean r101);

    void k(String r100);

    void l();

    void m(com.larus.video.impl.sdk.a r100, String r101, long r102, DataLoaderPreloadPriority r103, k0 r104);

    int n();

    int o();

    void p(n0 r100);

    boolean p3();

    void play();

    void q(VideoEngineMusicPlayerViewImpl.h r100, String r101);

    void r(String r100);

    void release();

    void releaseSurface();

    void s(o0 r100);

    void setDirectURL(String r100);

    void setDirectUrlUseDataLoader(String r100, String r101);

    void setLocalURL(String r100);

    void setLooping(boolean r100);

    void setStartTime(int r100);

    void setSubTag(String r100);

    void setSurface(Surface r100);

    void setSurfaceHolder(SurfaceHolder r100);

    void stop();

    void t();

    List<String> u();

    boolean v();

    void w(int r100);

    void x(String r100);

    void y(boolean r100, String r101);

    boolean z();
}
