package vs4;

import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendItemData;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableRecommendItemData f557008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f557009b;

    public g(BitableRecommendItemData r100, long r101) {
        this.f557008a = r100;
        this.f557009b = r101;
    }

    public final void a() {
        BitableRecommendItemData r100 = this.f557008a;
        long r101 = this.f557009b;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        lc5.f.f508440a.s(r100.getContentUrl(), r100.getContentId(), r100.getTitle(), r100.getRequestId(), Integer.valueOf(r100.getRequestRankFirst()), Integer.valueOf(r100.getAllPositionIndex()), Integer.valueOf(r100.getPositionIndex()), r100.getCoverLoadState(), Boolean.valueOf(r100.isRefresh()), Long.valueOf(r101), MapsKt.mapOf(new Pair[]{TuplesKt.to("is_hot", Boolean.valueOf(r100.isHot())), TuplesKt.to("is_new", Boolean.valueOf(r100.isNew()))}));     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableHomePageFeedContentClick error", r104, false);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
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
