package rt2;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("UnifyLogger", r100);
    }
}
