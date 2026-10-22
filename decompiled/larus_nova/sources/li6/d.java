package li6;

import com.bytedance.live.livelink.kmp.api.base.params.LiveRtcVideoParamsMode;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f509386h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f509387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f509388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f509389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f509390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f509391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f509392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f509393g;

    public static final class a {
    }

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f509387a, r101.f509387a) == true) goto L8;
        return false;
    L8:
        if (this.f509388b == r101.f509388b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509389c, r101.f509389c) == true) goto L12;
        return false;
    L12:
        if (this.f509390d == r101.f509390d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f509391e, r101.f509391e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f509392f, r101.f509392f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f509393g, r101.f509393g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        f r100 = this.f509387a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f509388b) * 31;
        e r104 = this.f509389c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f509390d) * 31;
        h r107 = this.f509391e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f509392f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        h r113 = this.f509393g;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveRTCVideoParam(serverMixParam=" + this.f509387a + ", rtcMixType=" + this.f509388b + ", rtcPerformanceProfiles=" + this.f509389c + ", rtcUpStreamVideoParamsMode=" + this.f509390d + ", serverDefineUpstreamVideoParam=" + this.f509391e + ", clientMixUpstreamVideoParam=" + this.f509392f + ", serverMixUpstreamVideoParam=" + this.f509393g + ")";
    }

    static {
        f509386h = new h(800, 0, 15, 640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION);
    }

    public d(int r100) {
        int r101 = LiveRtcVideoParamsMode.DEFAULT_LIVE_VIDEO_MODE.getValue();
        this.f509387a = null;
        this.f509388b = 0;
        this.f509389c = null;
        this.f509390d = r101;
        this.f509391e = null;
        this.f509392f = null;
        this.f509393g = null;
    }

    public final h a(fi6.a r100) {
        int r101 = this.f509390d;
        int r102 = LiveRtcVideoParamsMode.DEFAULT_LIVE_VIDEO_MODE.getValue();
        h r103 = f509386h;
        if (r101 != r102) goto L6;
        return r103;
    L6:
        if (r101 != LiveRtcVideoParamsMode.SERVER_LIVE_VIDEO_MODE.getValue()) goto L12;
        h r104 = this.f509391e;
        if (r104 != null) goto L21;
        return r103;
    L21:
        return r104;
    L12:
        if (r101 != LiveRtcVideoParamsMode.ONE_TO_ONE_lIVE_VIDEO_MODE.getValue()) goto L22;
        if (r100 != null) goto L15;
    L19:
        r104 = this.f509393g;
        if (r104 != null) goto L21;
        return r103;
    L15:
        if (r100.b() != true) goto L19;
        r104 = this.f509392f;
        if (r104 != null) goto L21;
        return r103;
    L22:
        return r103;
    }
}
