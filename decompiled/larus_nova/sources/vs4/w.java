package vs4;

import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendReportResponse;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes15.dex */
public final class w implements NetService.c<BitableRecommendReportResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f557051a;

    public w(t r100) {
        this.f557051a = r100;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 != null) goto L12;
    L10:
        tt5.a.d("BitableRecommendScheduleReporter", "parse data with null json");
        return new BitableRecommendReportResponse();
    L12:
        BitableRecommendReportResponse r101 = (BitableRecommendReportResponse) this.f557051a.f557040a.fromJson(r100, BitableRecommendReportResponse.class);     // Catch: Throwable -> L7
    L9:
        if (r101 == null) goto L10;
        return r101;
    L7:
        th = move-exception;
        tt5.a.e("BitableRecommendScheduleReporter", "parse data error", th, false);
        r101 = new BitableRecommendReportResponse();
        goto L9
    }
}
