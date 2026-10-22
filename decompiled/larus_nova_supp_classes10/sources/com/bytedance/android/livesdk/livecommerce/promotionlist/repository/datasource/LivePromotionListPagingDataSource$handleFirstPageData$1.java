package com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource;

import android.util.LruCache;
import androidx.paging.PositionalDataSource;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mj2.e;
import mj2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"handleFirstPageDataInner", "", "uniqueIndex", "", "anchorUniqueIndex", "nextOffset", "", "logId", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LivePromotionListPagingDataSource$handleFirstPageData$1 extends Lambda implements Function4<String, String, Integer, String, Unit> {
    final /* synthetic */ PositionalDataSource.LoadInitialCallback $callback;
    final /* synthetic */ int $offset;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ int $requestType;
    final /* synthetic */ e $response;
    final /* synthetic */ LivePromotionListPagingDataSource this$0;

    public LivePromotionListPagingDataSource$handleFirstPageData$1(LivePromotionListPagingDataSource r1, e r2, int r3, int r4, int r5, PositionalDataSource.LoadInitialCallback r6) {
        this.this$0 = r1;
        this.$response = r2;
        this.$offset = r3;
        this.$requestType = r4;
        this.$pageSize = r5;
        this.$callback = r6;
        super(4);
    }

    public final void invoke(String r20, String r21, int r22, String r23) {
        LivePromotionListPagingDataSource r2 = this.this$0;
        tj2.b r3 = r2.i;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r4 = r2.h;
        Pair<List<ql.a>, List<j>> r5 = r3.q(r4.b, r4.h, this.$response, this.$offset);
        List r10 = (List) r5.getFirst();
        LivePromotionListPagingDataSource r6 = this.this$0;
        if (r6.b != 0) goto L5;
        List<j> r7 = (List) r5.getSecond();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.e = r7;
    L5:
        LivePromotionListPagingDataSource r11 = this.this$0;
        int r12 = this.$requestType;
        boolean r14 = !r10.isEmpty();
        List r8 = r10;
        if ((r8 instanceof Collection) == true) goto L8;
    L10:
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        if (((ql.a) r9.next()).isOnTopExplaining() == false) goto L12;
        boolean r15 = true;
    L17:
        int r13 = this.$offset;
        r11.o(r12, true, r14, r15, r13, (this.$pageSize + r13) - 1, r22);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_API_ERROR_REPORT() == true) goto L20;
    L27:
        LivePromotionListPagingDataSource.g(this.this$0, true, r20, r21, this.$requestType, this.$offset, this.$response);
        LivePromotionListPagingDataSource r1 = this.this$0;
        tj2.b r16 = r1.i;
        int r17 = this.$offset;
        String r18 = r1.h.b;
        r16.o(true, false, r17, r17, this.$response.u, r10, r1.l);
        LivePromotionListPagingDataSource r19 = this.this$0;
        PositionalDataSource.LoadInitialCallback r24 = this.$callback;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r26 = r8.iterator();
    L29:
        if (r26.hasNext() == false) goto L31;
        r25.add(new mj2.c((ql.a) r26.next()));
        goto L29
    L31:
        int r27 = this.$offset;
        r19.getClass();
        LivePromotionListPagingDataSource.k(r24, r25, r27);
        return;
    L20:
        if (r10.isEmpty() == false) goto L27;
        LruCache<String, uj2.a> r28 = uj2.b.a;
        if (r23 != null) goto L24;
        uj2.a r29 = null;
    L25:
        if (r29 == null) goto L27;
        Intrinsics.checkNotNullParameter("no_goods", LocationMonitorConst.TYPE);
        r29.a.c("error_type", "no_goods");
        r29.a.i(null);
        goto L27
    L24:
        r29 = uj2.b.a.get(r23);
    L16:
        r15 = false;
        goto L17
    L8:
        if (r8.isEmpty() == false) goto L10;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((String) r1, (String) r2, ((Number) r3).intValue(), (String) r4);
        return Unit.INSTANCE;
    }
}
