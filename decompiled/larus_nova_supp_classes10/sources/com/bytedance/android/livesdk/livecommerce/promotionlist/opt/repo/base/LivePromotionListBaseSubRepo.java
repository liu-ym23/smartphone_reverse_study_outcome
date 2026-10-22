package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base;

import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class LivePromotionListBaseSubRepo {
    public static final /* synthetic */ int b = 0;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a a;

    public static final class a {
    }

    static {
    }

    public final PromotionListController h() {
        return ((RoomContextController) this.a.b().invoke()).A().r;
    }

    public LivePromotionListBaseSubRepo(com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "repositoryContext");
        this.a = r2;
    }

    public final void k(pj2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$save");
        this.a.getMonitor().b(r2);
    }

    public final void i(final int r2, final Integer r3) {
        Function1<c, Unit> r0 = new LivePromotionListBaseSubRepo$refresh$1(this, r3, r2);
        Intrinsics.checkNotNullParameter(r0, "editBlock");
        r0.invoke(this.a.h());
    }

    public final void j(com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.c r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$save");
        this.a.getMonitor().a(r2, r3);
    }
}
