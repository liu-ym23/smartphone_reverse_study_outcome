package com.bytedance.android.shopping.store.router.hybridpage.presenter.product;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.vo.HybridPageGeneralCardVO;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridPageGeneralCardPresenter extends QFragmentPresenter {
    public final Lazy f;
    public final com.bytedance.android.shopping.store.router.hybridpage.holder.c g;
    public final HybridPageViewModel h;

    public static final class a implements View.OnTouchListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            if (r2.getAction() == 3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public final void b0(QModel r5) {
        if ((r5 instanceof HybridPageGeneralCardVO) == true) goto L5;
        r5 = null;
    L5:
        HybridPageGeneralCardVO r6 = (HybridPageGeneralCardVO) r5;
        if (r6 != null) goto L8;
        return;
    L8:
        r r0 = this.g.a;
        if (r0 == null) goto L11;
        r0.b((com.bytedance.android.shopping.store.router.hybridpage.slice.a) this.f.getValue());
    L11:
        r r1 = this.g.a;
        if (r1 == null) goto L14;
        r1.a((Map) r6.h.getValue(), ShopSliceUniqueId.HYBRID_PAGE_GENERAL_CARD.getId() + '_' + r6.e);
    L14:
        a0().setOnTouchListener(a.a);
    }

    public HybridPageGeneralCardPresenter(Fragment r2, com.bytedance.android.shopping.store.router.hybridpage.holder.c r3, LayoutTypes r4, HybridPageViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewInfoProxy");
        Intrinsics.checkNotNullParameter(r4, "layoutTypes");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        super(r2);
        this.g = r3;
        this.h = r5;
        this.f = LazyKt.lazy(new HybridPageGeneralCardPresenter$slcActionHandler$2(this));
    }
}
