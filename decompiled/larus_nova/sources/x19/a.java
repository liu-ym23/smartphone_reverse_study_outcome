package x19;

import com.larus.common_ui.video.VideoPlayView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f562148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f562149b;

    static {
        f562148a = true;
    }

    public static void a() {
        f562149b = 0;
        f562148a = true;
    }

    public static long b(VideoPlayView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "videoView");
        if (r101 == false) goto L5;
        long r102 = r100.getDuration();
    L7:
        return r102 - f562149b;
    L5:
        r102 = r100.getCurrentPlaybackTime();
        goto L7
    }
}
