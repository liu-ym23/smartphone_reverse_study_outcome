package nu0;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {
    public static void a(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$logD");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogger.d("VoiceChat#" + r100.getClass().getSimpleName() + "#", r101);
    }

    public static final void d(Object r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$logI");
        Intrinsics.checkNotNullParameter(r101, "msg");
        StringBuilder r103 = new StringBuilder("VoiceChat#");
        r103.append(r100.getClass().getSimpleName());
        r103.append('#');
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r103.append(r102);
        ALogger.d(r103.toString(), r101);
    }

    public static final void b(Object r100, String r101, Throwable r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$logE");
        Intrinsics.checkNotNullParameter(r101, "msg");
        StringBuilder r104 = new StringBuilder("VoiceChat#");
        r104.append(r100.getClass().getSimpleName());
        r104.append('#');
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r104.append(r103);
        ALogger.e(r104.toString(), r101, r102);
    }

    public static /* synthetic */ void c(Object r100, String r101, Throwable r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        b(r100, r101, r102, null);
    }
}
