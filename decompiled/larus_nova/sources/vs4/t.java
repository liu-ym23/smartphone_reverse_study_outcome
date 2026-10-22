package vs4;

import android.os.Handler;
import com.bytedance.ee.bear.bitable.homepage.BitableHomePageConfig;
import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendReportRequestData;
import com.bytedance.ee.bear.contract.NetService;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes15.dex */
public final class t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f557039g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f557040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f557041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f557042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f557043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f557044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f557045f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f557046a;

        public b(t r100) {
            this.f557046a = r100;
        }

        public final void a() {
            if ((!((ArrayList) this.f557046a.f557042c).isEmpty()) == false) goto L6;
            ArrayList r100 = new ArrayList();
            r100.addAll(this.f557046a.f557042c);
            t.a(this.f557046a, r100, 1);
            ((ArrayList) this.f557046a.f557042c).clear();
        L6:
            if (this.f557046a.f557041b.get() == false) goto L9;
            this.f557046a.f557043d.quitSafely();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        BitableHomePageConfig r100 = (BitableHomePageConfig) SettingManager.getInstance().get(BitableHomePageConfig.class);
        if (r100 == null) goto L7;
        Long r101 = r100.getRecommendViewReportIntervalMills();
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        f557039g = r102;
        return;
    L7:
        r102 = 1500;
        goto L8
    }

    public t() {
        this.f557040a = new Gson();
        this.f557041b = new AtomicBoolean(false);
        this.f557042c = new ArrayList();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("bitable_home_recommend_reporter");
        ThreadMethodProxy.start(r100);
        this.f557043d = r100;
        this.f557044e = new Handler(r100.getLooper());
        this.f557045f = new b(this);
    }

    public static final void a(t r100, List r101, int r102) {
        r100.getClass();
        NetService.f r103 = new NetService.f("/space/api/platform/template/report_data");
        r103.f216906c = 1;
        BitableRecommendReportRequestData r104 = new BitableRecommendReportRequestData(r101, r102);
        Map<String, String> r105 = r103.f216907d;
        String r106 = r100.f557040a.toJson(r104);     // Catch: Exception -> L5
    L7:
        ((HashMap) r105).put("data", r106);
        ((HashMap) r103.f216907d).put("report_type", "6");
        tt5.a.h("BitableRecommendScheduleReporter", "asyncReport, params: " + r103.f216907d);
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new w(r100)).a(r103).subscribeOn(fo5.d.e()).observeOn(fo5.d.e()).subscribe(x.f557052a, y.f557053a);
        return;
    L5:
        e = move-exception;
        tt5.a.d("BitableRecommendScheduleReporter", "toJson exception:" + e);
        r106 = "";
        goto L7
    }
}
