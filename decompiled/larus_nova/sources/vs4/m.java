package vs4;

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
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<BitableRecommendItemData> f557024a;

    public m(List<BitableRecommendItemData> r100) {
        this.f557024a = r100;
    }

    public final void a() {
        Iterator<T> r100 = this.f557024a.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        BitableRecommendItemData r101 = (BitableRecommendItemData) r100.next();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        lc5.f.f508440a.w(r101.getContentUrl(), r101.getContentId(), r101.getTitle(), r101.getRequestId(), Integer.valueOf(r101.getRequestRankFirst()), Integer.valueOf(r101.getAllPositionIndex()), Integer.valueOf(r101.getPositionIndex()), r101.getCoverLoadState(), Boolean.valueOf(r101.isRefresh()), MapsKt.mapOf(new Pair[]{TuplesKt.to("is_hot", Boolean.valueOf(r101.isHot())), TuplesKt.to("is_new", Boolean.valueOf(r101.isNew()))}));     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L4;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableHomePageFeedContentView error", r104, false);
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
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
