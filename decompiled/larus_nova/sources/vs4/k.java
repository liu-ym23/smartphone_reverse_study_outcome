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
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableRecommendItemData f557019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f557020d;

    public k(String r100, String r101, BitableRecommendItemData r102, long r103) {
        this.f557017a = r100;
        this.f557018b = r101;
        this.f557019c = r102;
        this.f557020d = r103;
    }

    public final void a() {
        String r100 = this.f557017a;
        String r101 = this.f557018b;
        BitableRecommendItemData r102 = this.f557019c;
        long r103 = this.f557020d;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        boolean r105 = false;
        lc5.f.f508440a.v(r100, r101, r102.getContentUrl(), r102.getContentId(), r102.getTitle(), r102.getRequestId(), Integer.valueOf(r102.getRequestRankFirst()), Integer.valueOf(r102.getAllPositionIndex()), Integer.valueOf(r102.getPositionIndex()), r102.getCoverLoadState(), Boolean.valueOf(r102.isRefresh()), Long.valueOf(r103), MapsKt.mapOf(new Pair[]{TuplesKt.to("is_hot", Boolean.valueOf(r102.isHot())), TuplesKt.to("is_new", Boolean.valueOf(r102.isNew()))}));     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L12:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableHomePageFeedContentView error", r107, r105);
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
