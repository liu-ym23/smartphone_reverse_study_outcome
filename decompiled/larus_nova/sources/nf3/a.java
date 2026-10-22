package nf3;

import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.l;
import com.bytedance.android.shopping.mall.homepage.pagecard.monitor.DynamicParamsPerformanceBean;
import com.bytedance.android.shopping.mall.homepage.pagecard.monitor.LoadPerformanceBean;
import org.json.JSONObject;
import ps3.b;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f518944c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadPerformanceBean f518945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DynamicParamsPerformanceBean f518946b;

    /* JADX INFO: renamed from: nf3.a$a, reason: collision with other inner class name */
    public static final class C6922a {
    }

    static {
    }

    public final void b() {
        b.a(new String[]{"reportLoadPerformanceLog \n  " + b0.m(this.f518945a)});
        JSONObject r100 = new JSONObject();
        r100.put("type", "LOAD_PERFORMANCE_LOG");
        r100.put("detail", k.b(this.f518945a));
        l.f170445a.getClass();
        l.a(r100);
    }

    public a() {
        this.f518945a = new LoadPerformanceBean();
        this.f518946b = new DynamicParamsPerformanceBean();
    }

    public final void a(boolean r100, boolean r101) {
        this.f518946b.setTPullDynamicParamsFinish(Long.valueOf(System.currentTimeMillis()));
        DynamicParamsPerformanceBean r102 = this.f518946b;
        Long r103 = 1L;
        if (r100 == false) goto L5;
        Long r104 = r103;
    L6:
        r102.setResult(r104);
        DynamicParamsPerformanceBean r105 = this.f518946b;
        if (r101 == true) goto L10;
        r103 = 2L;
    L10:
        r105.setUseWhiteBoard(r103);
        b.a(new String[]{"reportDynamicParamsPerformanceLog \n  " + b0.m(this.f518946b)});
        JSONObject r106 = new JSONObject();
        r106.put("type", "DYNAMIC_PARAMS_PERFORMANCE_LOG");
        r106.put("detail", k.b(this.f518946b));
        r106.put("isWhiteBoard", this.f518946b.getUseWhiteBoard());
        l.f170445a.getClass();
        l.a(r106);
        return;
    L5:
        r104 = 2L;
        goto L6
    }
}
