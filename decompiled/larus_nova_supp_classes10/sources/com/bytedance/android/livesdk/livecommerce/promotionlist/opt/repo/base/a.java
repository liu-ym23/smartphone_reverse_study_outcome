package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.LivePromotionListCategoryRepository;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.LivePromotionListRefreshRepository;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.functions.Function0;
import mj2.c;
import mj2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    LivePromotionListRefreshRepository a();

    Function0<RoomContextController> b();

    MutableLiveData c();

    LiveData<PagedList<c>> d();

    void e(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1, e r2, int r3, String r4);

    LivePromotionListCategoryRepository f();

    boolean g();

    b getMonitor();

    com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c h();
}
