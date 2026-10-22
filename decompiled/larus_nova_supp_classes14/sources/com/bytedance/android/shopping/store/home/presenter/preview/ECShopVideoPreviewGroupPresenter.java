package com.bytedance.android.shopping.store.home.presenter.preview;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.api.StoreUIParam;
import com.bytedance.android.shopping.store.home.frame.presenter.AbsShopGroupPresenter;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopVideoPreviewGroupPresenter extends AbsShopGroupPresenter<ShopHeaderVideoVO> {
    public final Lazy k;
    public final Lazy l;

    public static final class a implements com.bytedance.android.shopping.store.home.frame.presenter.f {
        public final ECStoreViewModel a;

        public a(ECShopVideoPreviewGroupPresenter r2, ECStoreViewModel r3) {
            Intrinsics.checkNotNullParameter(r2, "presenter");
            Intrinsics.checkNotNullParameter(r3, "viewModel");
            this.a = r3;
        }
    }

    public static final class b implements com.bytedance.android.shopping.store.home.frame.presenter.g {
        public final Context a;
        public final ECStoreViewModel b;

        public final Context getContext() {
            return this.a;
        }

        public b(Context r2, ECShopVideoPreviewGroupPresenter r3, ECStoreViewModel r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "presenter");
            Intrinsics.checkNotNullParameter(r4, "viewModel");
            this.a = r2;
            this.b = r4;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopVideoPreviewGroupPresenter a;

        public c(ECShopVideoPreviewGroupPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            ShopHeaderVideoVO r8 = (ShopHeaderVideoVO) r7;
            ECShopVideoPreviewGroupPresenter r0 = this.a;
            int r3 = 0;
            if (r0.h0().couldVideoV2() == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            StoreUIParam r2 = this.a.h0().getStoreParam().getStoreUIParam();
            ECShopVideoPreviewGroupPresenter r4 = this.a;
            if (r4.h0().couldVideoV2() == true) goto L11;
        L13:
            boolean r5 = false;
        L14:
            r2.setHasHeaderVideo(r5);
            if (r1 == false) goto L20;
            this.a.a0().setVisibility(0);
            ECShopVideoPreviewGroupPresenter r6 = this.a;
            int r9 = r6.f.size();
        L17:
            if (r3 >= r9) goto L19;
            ((com.bytedance.android.shopping.store.home.frame.presenter.a) ListProtector.get(r6.f, r3)).i0(r8);
            r3 = r3 + 1;
            goto L17
        L19:
            r6.h = true;
            return;
        L20:
            ExtensionsKt.gone(this.a.a0());
            return;
        L11:
            if (r4.h0().isWhiteBrand() == true) goto L13;
            r5 = true;
            goto L14
        L5:
            if (r0.h0().isWhiteBrand() == true) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopVideoPreviewGroupPresenter a;

        public d(ECShopVideoPreviewGroupPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            Float r11 = (Float) r10;
            ECShopVideoPreviewGroupPresenter r0 = this.a;
            if (r0.h == false) goto L14;
            Iterator<com.bytedance.android.shopping.store.home.frame.presenter.a<T>> r1 = r0.f.iterator();
        L6:
            if (r1.hasNext() == false) goto L20;
            QFragmentPresenter r2 = (com.bytedance.android.shopping.store.home.frame.presenter.a) ((com.bytedance.android.shopping.store.home.frame.presenter.a<T>) r1.next());
            if ((r2 instanceof q) == false) goto L6;
            q r3 = (q) r2;
            float r4 = r11.floatValue();
            Integer r5 = (Integer) this.a.h0().getSlideDistance().getValue();
            if (r5 == null) goto L12;
            int r6 = r5.intValue();
        L13:
            r3.O(r4, r6, this.a.h0().getSlideByAuto(), this.a.h0().getSlideDirection(), this.a.h0().isDragging());
            goto L6
        L12:
            r6 = 0;
            goto L13
        L20:
            return;
        }
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.AbsShopGroupPresenter
    public final com.bytedance.android.shopping.store.home.frame.presenter.f e0() {
        return (a) this.l.getValue();
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.AbsShopGroupPresenter
    public final com.bytedance.android.shopping.store.home.frame.presenter.g i0() {
        return (b) this.k.getValue();
    }

    public ECShopVideoPreviewGroupPresenter(Fragment r1) {
        Intrinsics.checkNotNull(r1);
        super(r1);
        this.k = LazyKt.lazy(new ECShopVideoPreviewGroupPresenter$modelAdapter$2(this));
        this.l = LazyKt.lazy(new ECShopVideoPreviewGroupPresenter$behavior$2(this));
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.AbsShopGroupPresenter
    public final void b0(QModel r4) {
        super.b0(r4);
        h0().getVideoInfo().a(((QFragmentPresenter) this).e, new c(this), false);
        h0().getCollapseFactor().a(((QFragmentPresenter) this).e, new d(this), false);
    }
}
