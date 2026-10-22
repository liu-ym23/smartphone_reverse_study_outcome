package s32;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f540454a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.e("ImageRecognition", r100);
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("ImageRecognition", r100);
    }
}
