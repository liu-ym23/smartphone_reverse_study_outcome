package vs4;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.C8038a f557003a;

    public d(a.C8038a r100) {
        this.f557003a = r100;
    }

    public final void a() {
        a.C8038a r100 = this.f557003a;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L9
        r102.put(ComplianceResult.JsonKey.REQUEST_DURATION, r100.f556984a);     // Catch: Throwable -> L9
        r102.put("error_msg", r100.f556986c);     // Catch: Throwable -> L9
        r102.put("error_code", r100.f556985b);     // Catch: Throwable -> L9
        r102.put("request_type", r100.f556987d);     // Catch: Throwable -> L9
        r102.put("request_id", r100.f556988e);     // Catch: Throwable -> L9
        r102.put("request_index", r100.f556989f);     // Catch: Throwable -> L9
        lc5.f.a r103 = lc5.f.f508440a;     // Catch: Throwable -> L9
        com.bytedance.ee.bear.contract.d r104 = lc5.f.a.d();     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        r104.i("ccm_base_homepage_recommend_view", r102);     // Catch: Throwable -> L9
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L11:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        tt5.a.e("BitablePerformanceReport", "reportRecommendFailView error", r107, false);
        return;
    L17:
        return;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
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
