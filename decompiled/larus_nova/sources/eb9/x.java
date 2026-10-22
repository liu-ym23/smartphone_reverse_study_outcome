package eb9;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public interface x {

    public static final class a {
        public static void b(View r100, u r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        public static void c(View r100, u r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        public static void a(x r100, View r101, o<?> r102, int r103, u r104) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
            r100.e(r101, r102, r103, r104);
        }
    }

    void a(View r100, o<?> r101, int r102, u r103);

    View b(ViewGroup r100);

    void c(View r100, u r101);

    void d(View r100, u r101);

    void e(View r100, o<?> r101, int r102, u r103);

    View f(View r100);

    void g(View r100, u r101);

    void h(o<?> r100, View r101, int r102, u r103);

    View i(View r100);
}
