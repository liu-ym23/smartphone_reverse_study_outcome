package vs4;

import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendReportResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x<T> f557052a = null;

    static {
        f557052a = new x();
    }

    public x() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BitableRecommendReportResponse r101 = (BitableRecommendReportResponse) r100;
        tt5.a.h("BitableRecommendScheduleReporter", "asyncReport success: " + r101.code + ", " + r101.msg);
    }
}
