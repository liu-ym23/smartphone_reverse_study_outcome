package gz2;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f483372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f483373b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet<String> f483374c = null;

    static {
        f483373b = SetsKt.hashSetOf(new String[]{"static", "js_exception", "fetchError", "jsbError", "nativeError", "navigationStart", "static_sri", "res_loader_error", "res_loader_error_template", "containerError"});
        f483374c = SetsKt.hashSetOf(new String[]{PerfLog.TAG_PERF, "performance", "ajax", "blank", "falconPerf", "res_loader_perf", "res_loader_perf_template"});
        SetsKt.hashSetOf(new String[]{"custom", "resource_performance", "jsbPerf", "jsbPerfV2", "jsbPv"});
    }
}
