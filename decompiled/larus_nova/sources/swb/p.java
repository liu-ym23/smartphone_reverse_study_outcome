package swb;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f543779a = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final Resources getResources(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return r100.getResources();
        }

        @JvmStatic
        public static int a(Context r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Resources r102 = r100.getResources();
            return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
        }
    }

    static {
        f543779a = new a();
    }

    @JvmStatic
    public static final int a(Context r100, float r101) {
        return a.a(r100, r101);
    }

    @JvmStatic
    public static final Resources getResources(Context r100) {
        return f543779a.getResources(r100);
    }
}
