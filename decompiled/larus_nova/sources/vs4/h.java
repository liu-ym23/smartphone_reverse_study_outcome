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
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableRecommendItemData f557012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f557013d;

    public h(String r100, String r101, BitableRecommendItemData r102, long r103) {
        this.f557010a = r100;
        this.f557011b = r101;
        this.f557012c = r102;
        this.f557013d = r103;
    }

    public final void a() {
        String r100 = this.f557010a;
        String r101 = this.f557011b;
        BitableRecommendItemData r102 = this.f557012c;
        long r103 = this.f557013d;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        boolean r105 = false;
        lc5.f.f508440a.t(r100, r101, r102.getContentUrl(), r102.getContentId(), r102.getTitle(), r102.getRequestId(), Integer.valueOf(r102.getRequestRankFirst()), Integer.valueOf(r102.getAllPositionIndex()), Integer.valueOf(r102.getPositionIndex()), r102.getCoverLoadState(), Boolean.valueOf(r102.isRefresh()), Long.valueOf(r103), MapsKt.mapOf(new Pair[]{TuplesKt.to("is_hot", Boolean.valueOf(r102.isHot())), TuplesKt.to("is_new", Boolean.valueOf(r102.isNew()))}));     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L12:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableHomePageFeedContentClick error", r107, r105);
        return;
    L20:
        return;
    L7:
        th = th;
    L11:
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L9:
        th = th;
        r105 = false;
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
