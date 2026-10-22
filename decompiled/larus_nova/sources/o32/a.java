package o32;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("LiveHighlight", r100);
    }

    @JvmStatic
    public static final void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("LiveHighlight", r100, r101);
    }
}
