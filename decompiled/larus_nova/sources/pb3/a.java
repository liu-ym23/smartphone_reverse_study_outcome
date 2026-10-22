package pb3;

import com.bytedance.android.shopping.collect.monitor.duration.CollectYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.collect.monitor.fps.CollectYataFpsMonitor;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, a> f528424h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f528425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CollectYataFirstScreenDurationMonitor f528426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.collect.monitor.error.a f528427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CollectYataFpsMonitor f528428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f528429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f528430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CollectParams f528431g;

    /* JADX INFO: renamed from: pb3.a$a, reason: collision with other inner class name */
    public static final class C7175a {
    }

    public final Map<String, String> a() {
        Pair[] r100 = new Pair[4];
        r100[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r100[1] = TuplesKt.to("page_name", "collect_list_page");
        r100[2] = TuplesKt.to("previous_page", this.f528431g.getPreviousPage());
        String r101 = this.f528431g.getSession_id();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100[3] = TuplesKt.to("session_id", r101);
        return MapsKt.mapOf(r100);
    }

    static {
        f528424h = new LinkedHashMap();
    }

    public a(CollectParams r100) {
        this.f528431g = r100;
    }
}
