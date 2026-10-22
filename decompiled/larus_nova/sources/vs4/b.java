package vs4;

import com.bytedance.ee.bear.bitable.homepage.recommend.report.LoadFrom;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Long f556995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f556996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LoadFrom f556997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Long f556998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Long f556999e;

    public b(Long r100, String r101, LoadFrom r102, Long r103, Long r104) {
        this.f556995a = r100;
        this.f556996b = r101;
        this.f556997c = r102;
        this.f556998d = r103;
        this.f556999e = r104;
    }

    public final void a() {
        Long r100 = this.f556995a;
        String r101 = this.f556996b;
        LoadFrom r102 = this.f556997c;
        Long r103 = this.f556998d;
        Long r104 = this.f556999e;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L9
        r106.put("duration", r100);     // Catch: Throwable -> L9
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r101);     // Catch: Throwable -> L9
        r106.put(ResourceData.KEY_LOAD_FROM, r102);     // Catch: Throwable -> L9
        r106.put(ComplianceResult.JsonKey.REQUEST_DURATION, r103);     // Catch: Throwable -> L9
        r106.put("render_duration", r104);     // Catch: Throwable -> L9
        lc5.f.a r107 = lc5.f.f508440a;     // Catch: Throwable -> L9
        com.bytedance.ee.bear.contract.d r108 = lc5.f.a.d();     // Catch: Throwable -> L9
        if (r108 == null) goto L6;
        r108.i("ccm_base_homepage_load_view", r106);     // Catch: Throwable -> L9
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L9
    L11:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L17;
        tt5.a.e("BitablePerformanceReport", "reportHomePageLoadView error", r111, false);
        return;
    L17:
        return;
    L6:
        r109 = null;
    L9:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
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
