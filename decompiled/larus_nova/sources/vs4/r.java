package vs4;

import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendItemData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableRecommendItemData f557036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f557037d;

    public r(String r100, String r101, BitableRecommendItemData r102, String r103) {
        this.f557034a = r100;
        this.f557035b = r101;
        this.f557036c = r102;
        this.f557037d = r103;
    }

    public final void a() {
        String r100 = this.f557034a;
        String r101 = this.f557035b;
        BitableRecommendItemData r102 = this.f557036c;
        String r110 = this.f557037d;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r104 = lc5.f.f508440a.f(r100, r101, r102.getContentUrl(), r102.getContentId(), r102.getTitle(), r102.getRequestId(), Integer.valueOf(r102.getRequestRankFirst()), Integer.valueOf(r102.getAllPositionIndex()), Integer.valueOf(r102.getPositionIndex()), r102.getCoverLoadState(), Boolean.valueOf(r102.isRefresh()));     // Catch: Throwable -> L8
        r104.put(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");     // Catch: Throwable -> L8
        r104.put("crash_reason", r110);     // Catch: Throwable -> L8
        com.bytedance.ee.bear.contract.d r105 = lc5.f.a.d();     // Catch: Throwable -> L8
        if (r105 == null) goto L6;
        r105.i("ccm_base_homepage_feed_cover_view", r104);     // Catch: Throwable -> L8
    L6:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L16;
        tt5.a.e("BitableRecommendBizReporter", "reportFeedCoverView error", r107, false);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
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
