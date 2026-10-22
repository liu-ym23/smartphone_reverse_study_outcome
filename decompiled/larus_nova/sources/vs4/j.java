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
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<BitableRecommendItemData> f557016a;

    public j(List<BitableRecommendItemData> r100) {
        this.f557016a = r100;
    }

    public final void a() {
        Iterator<T> r100 = this.f557016a.iterator();
    L4:
        if (r100.hasNext() == false) goto L17;
        BitableRecommendItemData r101 = (BitableRecommendItemData) r100.next();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        lc5.f.a r103 = lc5.f.f508440a;     // Catch: Throwable -> L11
        String r104 = r101.getContentUrl();     // Catch: Throwable -> L11
        String r105 = r101.getContentId();     // Catch: Throwable -> L11
        String r106 = r101.getTitle();     // Catch: Throwable -> L11
        String r107 = r101.getRequestId();     // Catch: Throwable -> L11
        Integer r110 = Integer.valueOf(r101.getRequestRankFirst());     // Catch: Throwable -> L11
        Integer r111 = Integer.valueOf(r101.getAllPositionIndex());     // Catch: Throwable -> L11
        Integer r112 = Integer.valueOf(r101.getPositionIndex());     // Catch: Throwable -> L11
        String r113 = r101.getCoverLoadState();     // Catch: Throwable -> L11
        Boolean r114 = Boolean.valueOf(r101.isRefresh());     // Catch: Throwable -> L11
        long r115 = 0;
        if (r101.getShowTimestamp() <= 0) goto L9;
        r115 = System.currentTimeMillis() - r101.getShowTimestamp();     // Catch: Throwable -> L11
    L9:
        r103.u(r104, r105, r106, r107, r110, r111, r112, r113, r114, Long.valueOf(r115), MapsKt.mapOf(new Pair[]{TuplesKt.to("is_hot", Boolean.valueOf(r101.isHot())), TuplesKt.to("is_new", Boolean.valueOf(r101.isNew()))}));     // Catch: Throwable -> L11
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L4;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableHomePageFeedContentView error", r109, false);
    L11:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
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
