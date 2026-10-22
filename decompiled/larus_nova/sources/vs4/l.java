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
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<BitableRecommendItemData> f557021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f557023c;

    public l(List<BitableRecommendItemData> r100, String r101, String r102) {
        this.f557021a = r100;
        this.f557022b = r101;
        this.f557023c = r102;
    }

    public final void a() {
        List<BitableRecommendItemData> r100 = this.f557021a;
        String r110 = this.f557022b;
        String r111 = this.f557023c;
        Iterator<T> r112 = r100.iterator();
    L4:
        if (r112.hasNext() == false) goto L22;
        BitableRecommendItemData r101 = (BitableRecommendItemData) r112.next();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        lc5.f.a r103 = lc5.f.f508440a;     // Catch: Throwable -> L15
        String r104 = r101.getContentUrl();     // Catch: Throwable -> L15
        String r105 = r101.getContentId();     // Catch: Throwable -> L15
        String r106 = r101.getTitle();     // Catch: Throwable -> L15
        String r107 = r101.getRequestId();     // Catch: Throwable -> L15
        Integer r108 = Integer.valueOf(r101.getRequestRankFirst());     // Catch: Throwable -> L15
        Integer r113 = Integer.valueOf(r101.getAllPositionIndex());     // Catch: Throwable -> L15
        Integer r114 = Integer.valueOf(r101.getPositionIndex());     // Catch: Throwable -> L15
        String r115 = r101.getCoverLoadState();     // Catch: Throwable -> L15
        Boolean r116 = Boolean.valueOf(r101.isRefresh());     // Catch: Throwable -> L15
        long r117 = 0;
        if (r101.getShowTimestamp() <= 0) goto L9;
        r117 = System.currentTimeMillis() - r101.getShowTimestamp();     // Catch: Throwable -> L15
    L9:
        Long r118 = Long.valueOf(r117);     // Catch: Throwable -> L15
        boolean r109 = false;
        String r119 = r111;
        String r120 = r110;
        r103.v(r110, r111, r104, r105, r106, r107, r108, r113, r114, r115, r116, r118, MapsKt.mapOf(new Pair[]{TuplesKt.to("is_hot", Boolean.valueOf(r101.isHot())), TuplesKt.to("is_new", Boolean.valueOf(r101.isNew()))}));     // Catch: Throwable -> L13
        Object r121 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L18:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L21;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableHomePageFeedContentView error", r122, r109);
    L21:
        r111 = r119;
        r110 = r120;
    L13:
        th = th;
    L17:
        Result.Companion r123 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L15:
        th = th;
        r119 = r111;
        r120 = r110;
        r109 = false;
        goto L17
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
