package rd9;

import com.larus.im.internal.audio.video.fps.VideoFpsDowngradeLevel;
import com.larus.im.internal.delegate.w;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Integer f537343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, rd9.a> f537344b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f537345c = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f537346a = null;

        static {
            int[] r100 = new int[VideoFpsDowngradeLevel.values().length];
            r100[VideoFpsDowngradeLevel.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VideoFpsDowngradeLevel.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VideoFpsDowngradeLevel.LOWER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f537346a = r100;
        }
    }

    static {
        VideoFpsDowngradeLevel r100 = VideoFpsDowngradeLevel.NONE;
        f537344b = new LinkedHashMap();
        f537345c = new Object();
    }

    public static VideoFpsDowngradeLevel a(VideoFpsDowngradeLevel r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "level");
        if (w.p().f348441e == false) goto L5;
        f537343a = r101;
        Object r102 = f537345c;
        monitor-enter(r102);
        fe9.a.f476620a.e("VideoFpsConfigManager", "updateVideoFpsDowngradeLevel: " + r100 + ", thermalStatus: " + r101);     // Catch: Throwable -> L21
        if (r101 == null) goto L18;
        Iterator r103 = ((LinkedHashMap) f537344b).values().iterator();     // Catch: Throwable -> L21
    L12:
        if (r103.hasNext() == false) goto L18;
        rd9.a r104 = (rd9.a) r103.next();     // Catch: Throwable -> L21
        Integer r105 = r104.f537339b;     // Catch: Throwable -> L21
        if (r105 == null) goto L17;
        if (r101.intValue() <= r105.intValue()) goto L12;
    L17:
        r104.f537339b = r101;     // Catch: Throwable -> L21
        r104.f537341d = com.larus.im.internal.network.stragery.a.b();     // Catch: Throwable -> L21
    L18:
        fe9.a.f476620a.e("VideoFpsConfigManager", "updateVideoFpsDowngradeLevel: " + r100 + ", thermalStatus: " + r101 + ", size: " + f537344b.size());     // Catch: Throwable -> L21
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r102);
        return r100;
    L21:
        th = move-exception;
        throw th;
    L5:
        return VideoFpsDowngradeLevel.NONE;
    }
}
