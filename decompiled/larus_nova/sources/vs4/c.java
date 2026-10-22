package vs4;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f557000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f557001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f557002c;

    public c(long r100, long r101, long r102) {
        this.f557000a = r100;
        this.f557001b = r101;
        this.f557002c = r102;
    }

    public final void a() {
        long r100 = this.f557000a;
        long r101 = this.f557001b;
        long r102 = this.f557002c;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L9
        r104.put("duration", r100);     // Catch: Throwable -> L9
        r104.put(ComplianceResult.JsonKey.REQUEST_DURATION, r101);     // Catch: Throwable -> L9
        r104.put("render_duration", r102);     // Catch: Throwable -> L9
        lc5.f.a r105 = lc5.f.f508440a;     // Catch: Throwable -> L9
        com.bytedance.ee.bear.contract.d r106 = lc5.f.a.d();     // Catch: Throwable -> L9
        if (r106 == null) goto L6;
        r106.i("ccm_base_homepage_recommend_load_view", r104);     // Catch: Throwable -> L9
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L9
    L11:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L17;
        tt5.a.e("BitablePerformanceReport", "reportHomePageRecommendLoadView error", r109, false);
        return;
    L17:
        return;
    L6:
        r107 = null;
    L9:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
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
