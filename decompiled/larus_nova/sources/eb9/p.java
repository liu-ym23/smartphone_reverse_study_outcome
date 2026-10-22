package eb9;

import android.view.View;
import com.larus.home.api.feed.FlowFeedActionScene;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public interface p {

    public static final class a {
        public static void b(o r100, d r101, c r102, u r103) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r101, "action");
            Intrinsics.checkNotNullParameter(r102, "event");
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        public static void c(o r100, View r101, u r102) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r101, "anchor");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        public static List a(o r100, FlowFeedActionScene r101, u r102) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            return CollectionsKt.emptyList();
        }
    }

    boolean a(o<?> r100, u r101);

    boolean b(o<?> r100, View r101, int r102, u r103);

    boolean c(o<?> r100, u r101);

    void d(o<?> r100, int r101, u r102);

    void e(o<?> r100, d r101, c r102, u r103);

    List<d> f(o<?> r100, FlowFeedActionScene r101, u r102);
}
