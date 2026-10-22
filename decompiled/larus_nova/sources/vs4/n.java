package vs4;

import com.bytedance.ee.bear.bitable.homepage.j0;
import com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendItemData;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<BitableRecommendItemData> f557025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f557026b;

    public n(List<BitableRecommendItemData> r100, j0 r101) {
        this.f557025a = r100;
        this.f557026b = r101;
    }

    public final void a() {
        List<BitableRecommendItemData> r100 = this.f557025a;
        j0 r101 = this.f557026b;
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        BitableRecommendItemData r103 = (BitableRecommendItemData) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        lc5.f.f508440a.x(r101.W9(), r101.Z9(), r103.getContentUrl(), r103.getContentId(), r103.getTitle(), r103.getRequestId(), Integer.valueOf(r103.getRequestRankFirst()), Integer.valueOf(r103.getAllPositionIndex()), Integer.valueOf(r103.getPositionIndex()), r103.getCoverLoadState(), Boolean.valueOf(r103.isRefresh()), MapsKt.mapOf(new Pair[]{TuplesKt.to("is_hot", Boolean.valueOf(r103.isHot())), TuplesKt.to("is_new", Boolean.valueOf(r103.isNew()))}));     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L4;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableHomePageFeedContentView error", r106, false);
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
