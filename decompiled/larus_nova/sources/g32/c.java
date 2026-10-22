package g32;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f479795a = 0;

    static {
    }

    public static void a(e32.a r100) {
        Intrinsics.checkNotNullParameter(r100, "degradeRequest");
        ALogger.i("InteractivityDegradeLogger", "receive request. Type: " + r100.f470901a.name() + ", Level: " + r100.f470902b.logName() + ", Dimension: " + r100.f470903c.name() + ' ');
    }
}
