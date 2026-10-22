package vs4;

import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendItemData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableRecommendItemData f557032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557033b;

    public q(BitableRecommendItemData r100, String r101) {
        this.f557032a = r100;
        this.f557033b = r101;
    }

    public final void a() {
        BitableRecommendItemData r100 = this.f557032a;
        String r101 = this.f557033b;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r103 = lc5.f.f508440a.e(r100.getContentUrl(), r100.getContentId(), r100.getTitle(), r100.getRequestId(), Integer.valueOf(r100.getRequestRankFirst()), Integer.valueOf(r100.getAllPositionIndex()), Integer.valueOf(r100.getPositionIndex()), r100.getCoverLoadState(), Boolean.valueOf(r100.isRefresh()));     // Catch: Throwable -> L8
        r103.put(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");     // Catch: Throwable -> L8
        r103.put("crash_reason", r101);     // Catch: Throwable -> L8
        com.bytedance.ee.bear.contract.d r104 = lc5.f.a.d();     // Catch: Throwable -> L8
        if (r104 == null) goto L6;
        r104.i("ccm_base_homepage_feed_cover_view", r103);     // Catch: Throwable -> L8
    L6:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L16;
        tt5.a.e("BitableRecommendBizReporter", "reportFeedCoverView error", r106, false);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
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
