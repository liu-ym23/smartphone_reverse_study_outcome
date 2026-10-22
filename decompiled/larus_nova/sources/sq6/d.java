package sq6;

import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.core.y;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.dito.log.ReportType;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class d {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f543078a = null;

        static {
            int[] r100 = new int[ReportType.values().length];
            r100[ReportType.IMMEDIATELY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ReportType.STATICS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ReportType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f543078a = r100;
        }
    }

    public d() {
    }

    public boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return true;
    }

    public void f(b r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        rq6.a.f538927a.b("dito_log", "immediatelyReport no impl,error:" + r100);
    }

    public void g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        rq6.a.f538927a.b("dito_log", "staticsReport no impl,error:" + r100);
    }

    public void j(b r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if (r100.f543074a.b() != ReportType.WARNING) goto L5;
        rq6.a.f538927a.d("dito_log", String.valueOf(r100));
        return;
    L5:
        rq6.a.f538927a.b("dito_log", String.valueOf(r100));
    }

    public void b(DitoViewModel r100, y r101) {
        Intrinsics.checkNotNullParameter(r101, "ditoParams");
        rq6.a.f538927a.b("dito_log", "ditoPageCreateReport no impl,ditoParams:" + r100);
    }

    public void c(y r100, DitoFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "ditoParams");
        Intrinsics.checkNotNullParameter(r101, "ditoFragment");
        rq6.a.f538927a.b("dito_log", "ditoPageDestroyReport no impl,ditoFragment:" + r101);
    }

    public void d(String r100, String r101, DitoPageInfo r102) {
        rq6.a.f538927a.b("dito_log", "ditoPageWillShowReport no impl, scene:" + r100 + " bizCode=" + r101);
    }

    public void i(Map<String, Integer> r100, String r101, DitoPageInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        rq6.a.f538927a.b("dito_log", "not impl reportViewCreateEvent");
    }

    public void e(Map r100, Map r101, com.bytedance.locallife.dito.plugin.d r102, DitoViewModel r103) {
        Intrinsics.checkNotNullParameter("dito_component_statics", "eventName");
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "metrics");
        Intrinsics.checkNotNullParameter(r102, "stats");
        if (r103 == null) goto L11;
        DitoPageInfo r104 = r103.f258040f;
        if (r104 == null) goto L8;
        Map<String, String> r105 = r104.getGlobalTrackParamsStrMap();
        if (r105 == null) goto L8;
    L9:
        ((HashMap) r100).putAll(r105);
        return;
    L8:
        r105 = MapsKt.emptyMap();
        goto L9
    }

    public void h(String r100, Map<String, String> r101, Object r102, DitoViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        rq6.a.f538927a.c("dito_log", "reportEvent,eventName" + r100 + ",params:" + r101);
    }
}
