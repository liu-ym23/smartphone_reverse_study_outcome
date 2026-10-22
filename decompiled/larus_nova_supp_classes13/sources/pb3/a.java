package pb3;

import com.bytedance.android.shopping.collect.monitor.duration.CollectYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.collect.monitor.fps.CollectYataFpsMonitor;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Map<String, a> h = null;
    public boolean a;
    public CollectYataFirstScreenDurationMonitor b;
    public com.bytedance.android.shopping.collect.monitor.error.a c;
    public CollectYataFpsMonitor d;
    public String e;
    public String f;
    public final CollectParams g;

    /* JADX INFO: renamed from: pb3.a$a, reason: collision with other inner class name */
    public static final class C0223a {
    }

    public final Map<String, String> a() {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r0[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "collect_list_page");
        r0[2] = TuplesKt.to("previous_page", this.g.getPreviousPage());
        String r1 = this.g.getSession_id();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[3] = TuplesKt.to("session_id", r1);
        return MapsKt.mapOf(r0);
    }

    static {
        h = new LinkedHashMap();
    }

    public a(CollectParams r1) {
        this.g = r1;
    }
}
