package com.bytedance.android.shopping.store.router.hybridpage.presenter.product;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ShopSlicedProductCardPresenterV2Kt$wrapAction$1;
import com.bytedance.android.shopping.store.router.hybridpage.action.SliceTrackShowProductActionHandler;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.android.shopping.store.router.hybridpage.slice.a {
    public final /* synthetic */ d e;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.router.hybridpage.presenter.product.a$a, reason: collision with other inner class name */
    public static final class C0014a extends SliceTrackShowProductActionHandler {
        public final /* synthetic */ a d;

        public C0014a(a r1, Fragment r2, SliceProductCardData r3, HybridPageViewModel r4) {
            this.d = r1;
            super(r2, r3, r4);
        }
    }

    @Override // com.bytedance.android.shopping.store.slicecard.d
    public final IAction d(IAction r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        Object r2 = null;
        ArrayList r3 = null;
        if (Intrinsics.areEqual(r7.getType(), SliceActionType.GROUP.getType()) == false) goto L12;
        Map r0 = r7.getParams();
        List r4 = r7.getActions();
        if (r4 == null) goto L10;
        List r5 = r4;
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r3.add(d((IAction) r6.next()));
    L10:
        Intrinsics.checkNotNullParameter(r7, "$this$wrapAction");
        return new ShopSlicedProductCardPresenterV2Kt$wrapAction$1(r7, r0, r3);
    L12:
        Map r1 = r7.getParams();
        if (r1 != null) goto L15;
        return r7;
    L15:
        if (Intrinsics.areEqual(r1.get("btm_id"), "ec_shop_product_card_btm_placeholder") == false) goto L43;
        LinkedHashMap r8 = new LinkedHashMap();
        Map r9 = r7.getParams();
        if (r9 != null) goto L19;
        r9 = MapsKt.emptyMap();
    L19:
        r8.putAll(r9);
        r8.put("btm_id", this.e.e0());
        if (Intrinsics.areEqual(r7.getType(), SliceActionType.TRACK.getType()) == false) goto L39;
        Object r10 = r8.get("event_params");
        if ((r10 instanceof Map) == false) goto L25;
        r2 = r10;
    L25:
        Map r11 = (Map) r2;
        LinkedHashMap r12 = new LinkedHashMap();
        if (r11 != null) goto L28;
    L31:
        boolean r13 = true;
    L32:
        if (r13 == true) goto L35;
        r12.putAll(r11);
    L35:
        if (this.e.w != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L37;
        String r14 = "single_product";
    L38:
        r12.put("layout_type", r14);
        r12.put("product_form", r14);
        Unit r15 = Unit.INSTANCE;
        r8.put("event_params", r12);
        goto L39
    L37:
        r14 = "double_product";
        goto L38
    L28:
        if (r11.isEmpty() == true) goto L31;
        r13 = false;
    L39:
        List r16 = r7.getActions();
        Intrinsics.checkNotNullParameter(r7, "$this$wrapAction");
        return new ShopSlicedProductCardPresenterV2Kt$wrapAction$1(r7, r8, r16);
    L43:
        return r7;
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.slice.a
    public final void e(IAction r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "targetView");
        super.e(r6, r7);
        Map<String, ? extends Object> r0 = r6.getParams();
        SliceActionType.a r1 = SliceActionType.Companion;
        String r2 = r6.getType();
        r1.getClass();
        SliceActionType r3 = SliceActionType.a.a(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        ShopSlcProductItemV2 r4 = this.e.k;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L8:
        ((com.bytedance.android.shopping.store.slicecard.a) this.e.s.getValue()).c(r3, r4, this.e.a0(), r0);
        if (r3 != SliceActionType.TRACK_SHOW_PRODUCT) goto L12;
        d r5 = this.e;
        new C0014a(this, ((QFragmentPresenter) r5).e, r5.x.getSliceProductCardData(), this.e.x).e(r7, r6.getParams());
        return;
    }

    public a(d r1, HybridPageViewModel r2, QContext r3) {
        this.e = r1;
        super(r2, r3);
    }
}
