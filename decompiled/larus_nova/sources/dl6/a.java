package dl6;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {
    public static final void a(String... r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.e("AndroidKtvDownload_Global", "msg: " + ArraysKt.joinToString$default(r110, "===", null, null, 0, null, null, 62, null));
    }

    public static final void b(String... r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.i("AndroidKtvDownload_Global", "msg: " + ArraysKt.joinToString$default(r110, "===", null, null, 0, null, null, 62, null));
    }

    public static final void c(String... r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.i("AndroidKtvMidi_Global", "msg: " + ArraysKt.joinToString$default(r110, "===", null, null, 0, null, null, 62, null));
    }
}
