package com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tj2.e;
import tj2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/repository/datasource/LivePromotionListDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lmj2/c;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListDataSourceFactory extends DataSource.Factory<Integer, mj2.c> {
    public final MutableLiveData<tj2.d> a;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c b;
    public final tj2.b c;
    public final e d;
    public final Function0<Integer> e;
    public final Function0<List<ql.a>> f;
    public final Function0<g> g;
    public final com.bytedance.android.ec.core.async.b h;
    public final RoomContextController i;

    public final DataSource<Integer, mj2.c> create() {
        LivePromotionListPagingDataSource r9 = new LivePromotionListPagingDataSource(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        this.a.postValue(r9);
        return r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LivePromotionListDataSourceFactory(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r2, tj2.b r3, e r4, Function0<Integer> r5, Function0<? extends List<? extends ql.a>> r6, Function0<? extends g> r7, com.bytedance.android.ec.core.async.b r8, RoomContextController r9) {
        Intrinsics.checkNotNullParameter(r2, "requestParams");
        Intrinsics.checkNotNullParameter(r3, "cacheDataSource");
        Intrinsics.checkNotNullParameter(r4, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r5, "getPositionOffset");
        Intrinsics.checkNotNullParameter(r6, "getCurrentPromotions");
        Intrinsics.checkNotNullParameter(r7, "repositoryCallback");
        Intrinsics.checkNotNullParameter(r8, "disposableScope");
        Intrinsics.checkNotNullParameter(r9, "roomContextController");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.a = new MutableLiveData();
    }
}
