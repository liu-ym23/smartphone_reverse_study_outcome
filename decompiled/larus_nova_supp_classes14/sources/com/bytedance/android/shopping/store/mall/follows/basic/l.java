package com.bytedance.android.shopping.store.mall.follows.basic;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {
    public final Lazy f;
    public final Class<T> g;
    public final boolean h;

    public static final class a {
    }

    static {
    }

    public final void b0(QModel r6) {
        ViewGroup r7 = (ViewGroup) Z().b(2131370736).f();
        if (this.h == true) goto L5;
        r7.setVisibility(8);
        return;
    L5:
        hj3.g r0 = ((BaseFollowStoreViewModel) this.f.getValue()).getMomentConfig();
        if (r0 == null) goto L8;
        String r1 = r0.k();
    L10:
        if (r1 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L18;
        r7.setVisibility(0);
        ECLynxCard r2 = new ECLynxCard();
        ECLynxLoadParam.a r4 = new ECLynxLoadParam.a(a0().getContext(), r1, r7);
        r4.j(2000);
        m r5 = new m(r2, r7);
        Intrinsics.checkNotNullParameter(r5, "lifecycle");
        r4.o = r5;
        r4.h(((BaseFollowStoreViewModel) this.f.getValue()).getSceneId());
        r4.e(MapsKt.emptyMap());
        r2.j(new ECLynxLoadParam(r4));
        return;
    L18:
        r7.setVisibility(8);
        return;
    L12:
        if (StringsKt.isBlank(r1) == true) goto L15;
        r3 = false;
        goto L16
    L8:
        r1 = null;
        goto L10
    }

    public l(Fragment r2, Class r3) {
        Intrinsics.checkNotNullParameter(r2, "f");
        Intrinsics.checkNotNullParameter(r3, "vmClazz");
        super(r2);
        this.g = r3;
        this.h = false;
        this.f = LazyKt.lazy(new BaseFollowStoreSearchPresenter$viewModel$2(this));
    }
}
