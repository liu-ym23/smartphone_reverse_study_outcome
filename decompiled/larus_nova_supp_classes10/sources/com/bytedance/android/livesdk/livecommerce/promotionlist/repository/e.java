package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.LivePromotionListCategoryRepository;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.LivePromotionListRefreshRepository;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a {
    public final LivePromotionListCategoryRepository a;
    public final LivePromotionListRefreshRepository b;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b c;
    public final Function0<RoomContextController> d;
    public final /* synthetic */ LivePromotionListRepository e;
    public final /* synthetic */ Function0 f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ com.bytedance.android.ec.core.async.b h;

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final MutableLiveData c() {
        return this.e.e;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final LiveData<PagedList<mj2.c>> d() {
        return this.e.d;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final boolean g() {
        return this.e.g;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final c h() {
        return this.e.a;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final LivePromotionListRefreshRepository a() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final Function0<RoomContextController> b() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final LivePromotionListCategoryRepository f() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b getMonitor() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a
    public final void e(c r7, mj2.e r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "reqParams");
        Intrinsics.checkNotNullParameter(r8, "data");
        this.e.x(r7, r8, r9, true, r10);
    }

    public e(LivePromotionListRepository r13, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r14, Function0 r15, Function0 r16, com.bytedance.android.ec.core.async.b r17, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b r18, com.bytedance.android.livesdk.livecommerce.room.utils.g r19) {
        this.e = r13;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.a = new LivePromotionListCategoryRepository(this, r14, r15, r16);
        this.b = new LivePromotionListRefreshRepository(this, r17, r14, r18, r19, r15, r16, r13.n);
        this.c = r13.s;
        this.d = r13.q;
    }
}
