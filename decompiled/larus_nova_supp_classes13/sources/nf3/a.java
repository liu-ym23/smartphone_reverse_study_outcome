package nf3;

import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.l;
import com.bytedance.android.shopping.mall.homepage.pagecard.monitor.DynamicParamsPerformanceBean;
import com.bytedance.android.shopping.mall.homepage.pagecard.monitor.LoadPerformanceBean;
import org.json.JSONObject;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public final LoadPerformanceBean a;
    public final DynamicParamsPerformanceBean b;

    /* JADX INFO: renamed from: nf3.a$a, reason: collision with other inner class name */
    public static final class C0220a {
    }

    static {
    }

    public final void b() {
        b.a(new String[]{"reportLoadPerformanceLog \n  " + b0.m(this.a)});
        JSONObject r0 = new JSONObject();
        r0.put("type", "LOAD_PERFORMANCE_LOG");
        r0.put("detail", k.b(this.a));
        l.a.getClass();
        l.a(r0);
    }

    public a() {
        this.a = new LoadPerformanceBean();
        this.b = new DynamicParamsPerformanceBean();
    }

    public final void a(boolean r5, boolean r6) {
        this.b.setTPullDynamicParamsFinish(Long.valueOf(System.currentTimeMillis()));
        DynamicParamsPerformanceBean r0 = this.b;
        Long r1 = 1L;
        if (r5 == false) goto L5;
        Long r7 = r1;
    L6:
        r0.setResult(r7);
        DynamicParamsPerformanceBean r8 = this.b;
        if (r6 == true) goto L10;
        r1 = 2L;
    L10:
        r8.setUseWhiteBoard(r1);
        b.a(new String[]{"reportDynamicParamsPerformanceLog \n  " + b0.m(this.b)});
        JSONObject r9 = new JSONObject();
        r9.put("type", "DYNAMIC_PARAMS_PERFORMANCE_LOG");
        r9.put("detail", k.b(this.b));
        r9.put("isWhiteBoard", this.b.getUseWhiteBoard());
        l.a.getClass();
        l.a(r9);
        return;
    L5:
        r7 = 2L;
        goto L6
    }
}
