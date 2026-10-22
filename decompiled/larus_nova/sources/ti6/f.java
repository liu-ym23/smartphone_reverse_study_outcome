package ti6;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {
    public boolean A;
    public LiveWrappedVideoSuperResolutionMode B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f546159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f546160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f546161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f546162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f546163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f546164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f546165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f546166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f546167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f546168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f546169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f546170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f546171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f546172n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f546173o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f546174p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f546175q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f546176r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f546177s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f546178t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public double f546179u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f546180v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f546181w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LiveWrappedMixedStreamVideoType f546182x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f546183y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f546184z;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "MixRegion{mediaType=" + this.f546159a + ", interactId='" + this.f546160b + "', userId='" + this.f546161c + "', x=" + this.f546162d + ", y=" + this.f546163e + ", width=" + this.f546164f + ", height=" + this.f546165g + ", status=" + this.f546167i + ", isTalking=" + this.f546168j + ", talkVolume=" + this.f546169k + ", isMuteAudio=" + this.f546171m + ", isMuteVideo=" + this.f546172n + ", zorder=" + this.f546173o + ", renderMode=" + this.f546177s + ", roomID='" + this.f546180v + "', streamType=" + this.f546182x + ", isIgnoreRtcSei=" + this.A + '}';
    }

    public f() {
        this.f546160b = "";
        this.f546161c = "";
        this.f546164f = 1.0d;
        this.f546165g = 1.0d;
        this.f546166h = 100;
        this.f546170l = true;
        this.f546177s = 1;
        this.f546178t = true;
        this.f546180v = "";
        this.f546181w = new b();
        this.f546182x = LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN;
        this.B = LiveWrappedVideoSuperResolutionMode.OFF;
    }

    public final void a(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f546160b = r100;
    }

    public final void b(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f546180v = r100;
    }

    public final void c(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f546161c = r100;
    }

    public final void d(LiveWrappedMixedStreamVideoType r100) {
        Intrinsics.checkNotNullParameter(r100, "streamType");
        this.f546182x = r100;
    }
}
