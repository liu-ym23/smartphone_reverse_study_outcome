package com.bytedance.android.shopping.store.home.presenter.preview;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.api.StoreUIParam;
import com.bytedance.android.shopping.store.home.frame.presenter.AbsShopGroupPresenter;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopHeaderPreviewGroupPresenter extends AbsShopGroupPresenter<StoreV3LiveRoomVO> {
    public static final /* synthetic */ int n = 0;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopHeaderPreviewGroupPresenter a;

        public b(ECShopHeaderPreviewGroupPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            StoreV3LiveRoomVO r7 = (StoreV3LiveRoomVO) r6;
            if (ECShopHeaderPreviewGroupPresenter.j0(this.a) == false) goto L16;
            if (r7 == null) goto L16;
            int r1 = 0;
            this.a.a0().setVisibility(0);
            StoreUIParam r0 = this.a.h0().getStoreParam().getStoreUIParam();
            if (this.a.h0().couldLive() == true) goto L9;
        L11:
            boolean r2 = false;
        L12:
            r0.setHasHeaderLive(r2);
            ECShopHeaderPreviewGroupPresenter r3 = this.a;
            int r4 = r3.f.size();
        L13:
            if (r1 >= r4) goto L15;
            ((com.bytedance.android.shopping.store.home.frame.presenter.a) ListProtector.get(r3.f, r1)).i0(r7);
            r1 = r1 + 1;
            goto L13
        L15:
            r3.h = true;
            return;
        L9:
            if (this.a.h0().isCroppedStyle() == true) goto L11;
            r2 = true;
        L16:
            ExtensionsKt.gone(this.a.a0());
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopHeaderPreviewGroupPresenter a;

        public c(ECShopHeaderPreviewGroupPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            Float r11 = (Float) r10;
            if (ECShopHeaderPreviewGroupPresenter.j0(this.a) == false) goto L17;
            ECShopHeaderPreviewGroupPresenter r0 = this.a;
            if (r0.h == false) goto L23;
            Iterator<com.bytedance.android.shopping.store.home.frame.presenter.a<T>> r1 = r0.f.iterator();
        L9:
            if (r1.hasNext() == false) goto L24;
            QFragmentPresenter r2 = (com.bytedance.android.shopping.store.home.frame.presenter.a) ((com.bytedance.android.shopping.store.home.frame.presenter.a<T>) r1.next());
            if ((r2 instanceof q) == false) goto L9;
            q r3 = (q) r2;
            float r4 = r11.floatValue();
            Integer r5 = (Integer) this.a.h0().getSlideDistance().getValue();
            if (r5 == null) goto L15;
            int r6 = r5.intValue();
        L16:
            r3.O(r4, r6, this.a.h0().getSlideByAuto(), this.a.h0().getSlideDirection(), this.a.h0().isDragging());
            goto L9
        L15:
            r6 = 0;
            goto L16
        L24:
            return;
        L23:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopHeaderPreviewGroupPresenter a;

        public d(ECShopHeaderPreviewGroupPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ShopLiveState r3 = (ShopLiveState) r2;
            if (ECShopHeaderPreviewGroupPresenter.j0(this.a) == false) goto L7;
            this.a.h0().isLiveOn().setValue(Boolean.FALSE);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopHeaderPreviewGroupPresenter a;

        public e(ECShopHeaderPreviewGroupPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            ShopStatus r10 = (ShopStatus) r9;
            if (ECShopHeaderPreviewGroupPresenter.j0(this.a) == false) goto L17;
            ECShopHeaderPreviewGroupPresenter r11 = this.a;
            if (r11.h == false) goto L23;
            Iterator<com.bytedance.android.shopping.store.home.frame.presenter.a<T>> r12 = r11.f.iterator();
        L9:
            if (r12.hasNext() == false) goto L24;
            QFragmentPresenter r0 = (com.bytedance.android.shopping.store.home.frame.presenter.a) ((com.bytedance.android.shopping.store.home.frame.presenter.a<T>) r12.next());
            if ((r0 instanceof q) == false) goto L9;
            q r2 = (q) r0;
            float r3 = com.bytedance.android.shopping.extensions.k.d((Float) this.a.h0().getCollapseFactor().getValue());
            Integer r1 = (Integer) this.a.h0().getSlideDistance().getValue();
            if (r1 == null) goto L15;
            int r4 = r1.intValue();
        L16:
            r2.O(r3, r4, this.a.h0().getSlideByAuto(), this.a.h0().getSlideDirection(), this.a.h0().isDragging());
            goto L9
        L15:
            r4 = 0;
            goto L16
        L24:
            return;
        L23:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.AbsShopGroupPresenter
    public final com.bytedance.android.shopping.store.home.frame.presenter.f e0() {
        return (com.bytedance.android.shopping.store.home.frame.presenter.f) this.m.getValue();
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.AbsShopGroupPresenter
    public final com.bytedance.android.shopping.store.home.frame.presenter.g i0() {
        return (com.bytedance.android.shopping.store.home.frame.presenter.g) this.l.getValue();
    }

    public ECShopHeaderPreviewGroupPresenter(Fragment r2) {
        Intrinsics.checkNotNull(r2);
        super(r2);
        this.k = LazyKt.lazy(ECShopHeaderPreviewGroupPresenter$enableLivePlugin$2.INSTANCE);
        this.l = LazyKt.lazy(new ECShopHeaderPreviewGroupPresenter$modelAdapter$2(this));
        this.m = LazyKt.lazy(new ECShopHeaderPreviewGroupPresenter$behavior$2(this, r2));
    }

    public static final boolean j0(ECShopHeaderPreviewGroupPresenter r0) {
        return ((Boolean) r0.k.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.AbsShopGroupPresenter
    public final void b0(QModel r4) {
        super.b0(r4);
        h0().getLiveInfo().a(ECQuickUtilKt.a(Y()), new b(this), false);
        h0().getCollapseFactor().a(Y().e(), new c(this), false);
        h0().getLiveState().a(Y().e(), new d(this), false);
        h0().getShopStatus().a(Y().e(), new e(this), false);
    }

    public final String l0(String r3) {
        StoreV3LiveRoomVO r0 = (StoreV3LiveRoomVO) h0().getLiveInfo().getValue();
        if (r0 != null) goto L5;
        return r3;
    L5:
        if (r0.getHasLiveTab() == true) goto L7;
        return r3;
    L7:
        return "shop_".concat(r3);
    }

    public static final void k0(ECShopHeaderPreviewGroupPresenter r0, String r1) {
        r0.getClass();
        if (StringsKt.isBlank(r1) == true) goto L9;
        Lazy r2 = ECAppInfoService.a;
        if (we.a.a == true) goto L10;
        boolean r3 = ECServiceManager.a;
        ((s83.g) ECServiceManager.c(s83.g.class)).y();
        StoreV3LiveRoomVO r4 = (StoreV3LiveRoomVO) r0.h0().getLiveInfo().getValue();
        return;
    L10:
        return;
    }
}
