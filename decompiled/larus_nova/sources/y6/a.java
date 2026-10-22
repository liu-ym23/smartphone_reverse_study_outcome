package y6;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566286a;

    public a() {
        this.f566286a = "default";
    }

    public Map<String, n56.c> c() {
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> j() {
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> m() {
        return MapsKt.emptyMap();
    }

    public String a() {
        return this.f566286a;
    }

    public Map<String, n56.c> d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.plus(c(), e(r100));
    }

    public Map<String, n56.c> e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> h(HybridFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> i(HybridFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> k(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.plus(j(), l(r100));
    }

    public Map<String, f.b> l(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> n(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.plus(m(), o(r100));
    }

    public Map<String, g<?, ?>> o(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    public Map b(FragmentActivity r100, HybridDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "dialogFragment");
        return MapsKt.emptyMap();
    }

    public Map f(FragmentActivity r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        return MapsKt.emptyMap();
    }

    public Map g(FragmentActivity r100, HybridFragment r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        return MapsKt.emptyMap();
    }
}
