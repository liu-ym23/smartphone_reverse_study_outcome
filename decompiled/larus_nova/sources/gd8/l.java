package gd8;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.nita.api.NitaSchdulerType;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l extends com.bytedance.nita.api.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f480952b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<Map<Integer, String>> f480953c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function1<? super Context, ? extends View> f480954d;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b implements com.bytedance.nita.view.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f480955a;

        public b() {
            this.f480955a = "";
        }

        @Override // com.bytedance.nita.view.b
        public final View c(Context r100, ViewGroup r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "parent");
            v19.f.a(r100.getTheme());
            if (r102 != (-1)) goto L10;
            this.f480955a = "MAIN_TAB_VIEW";     // Catch: Throwable -> L12
            Function1<? super Context, ? extends View> r103 = l.f480954d;     // Catch: Throwable -> L12
            if (r103 == null) goto L9;
            View r104 = r103.invoke(r100);     // Catch: Throwable -> L12
            if (r104 == null) goto L9;
            return r104;
        L9:
            return new View(r100);
        L10:
            this.f480955a = "else";     // Catch: Throwable -> L12
            return LayoutInflater.from(r100).inflate(r102, r101, false);
        L12:
            th = move-exception;
            FLogger.f375446a.e("MainPageTabNitaView", " msg=" + th.getMessage());
            JSONObject r105 = new JSONObject();
            r105.put("tag", "main_page_tab_view");
            r105.put(LocationMonitorConst.ERR_MSG, String.valueOf(th.getMessage()));
            r105.put("err_view", this.f480955a);
            o.f365780a.reportEvent("nita_preload_monitor", r105);
            com.larus.bmhome.utils.c.a("nita_preload_monitor", r105, true);
            return new View(r100);
        }
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final void e(View r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "activity");
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final String h() {
        return "main_page_tab_view";
    }

    @Override // com.bytedance.nita.api.c
    public final int theme() {
        return R.style.Theme_OApp;
    }

    static {
        f480952b = new ArrayList();
        f480953c = LazyKt.lazy(new k());
    }

    @Override // com.bytedance.nita.api.c
    public final int[] b() {
        return CollectionsKt.toIntArray(f480952b);
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final com.bytedance.nita.view.b c() {
        return new b();
    }

    public l() {
    }

    @Override // com.bytedance.nita.api.c
    public final NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}
