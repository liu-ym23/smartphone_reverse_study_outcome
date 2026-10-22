package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryRecyclerView;
import com.bytedance.android.livesdk.livecommerce.iron.ui.tab.CategoryExpandView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListTabPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a {
    public static final /* synthetic */ int n = 0;
    public CategoryRecyclerView j;
    public View k;
    public CategoryExpandView l;
    public boolean m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        this.j = (CategoryRecyclerView) a0().findViewById(2131365291);
        this.k = a0().findViewById(2131392481);
        this.l = (CategoryExpandView) a0().findViewById(2131365289);
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListTabPresenter$init$1.INSTANCE, new LivePromotionListTabPresenter$init$2(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListTabPresenter$init$3.INSTANCE, new LivePromotionListTabPresenter$init$4(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListTabPresenter$init$5.INSTANCE, new LivePromotionListTabPresenter$init$6(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d.class), new LivePromotionListTabPresenter$init$7(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f.class), new LivePromotionListTabPresenter$init$8(this));
    }

    public static final /* synthetic */ CategoryRecyclerView h0(LivePromotionListTabPresenter r1) {
        CategoryRecyclerView r2 = r1.j;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("categoryList");
    L5:
        return r2;
    }

    public LivePromotionListTabPresenter(Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3);
    }
}
