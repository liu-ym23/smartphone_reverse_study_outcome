package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.shopping.store.utils.t;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TrackShowProductActionHandler implements com.bytedance.android.shopping.store.slicecard.a {
    public final Fragment a;
    public final ECShopHybridProductViewModel b;

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void a(ShopSlcProductItemV2 r1, View r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "target");
    }

    public TrackShowProductActionHandler(Fragment r2, ECShopHybridProductViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
    }

    public final void e(final View r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r12, "target");
        ECShopHybridProductViewModel r0 = this.b;
        boolean r1 = false;
        if (r0 == null) goto L9;
        ECStoreParam r2 = r0.getStoreParam();
        if (r2 == null) goto L9;
        if (r2.isPreview() != true) goto L9;
        boolean r5 = true;
    L10:
        ECShopHybridProductViewModel r3 = this.b;
        String r4 = null;
        if (r3 == null) goto L13;
        HashSet<String> r6 = r3.getIdRecords();
    L14:
        ECShopHybridProductViewModel r7 = this.b;
        if (r7 == null) goto L17;
        ECStoreParam r8 = r7.getStoreParam();
    L18:
        ECShopHybridProductViewModel r9 = this.b;
        if (r8 == null) goto L25;
        ProductBasicRequestParam r10 = r8.getProductBasicRequestParam();
        if (r10 == null) goto L25;
        if (r10.isCustom() != true) goto L25;
        r1 = true;
    L25:
        if (r8 == null) goto L29;
        ProductBasicRequestParam r11 = r8.getProductBasicRequestParam();
        if (r11 == null) goto L29;
        r4 = r11.getMaterialId();
    L29:
        t.a(r12, r13, r5, r6, c.a(r9, r1, r4), PageFinder.via(this.a), new TrackShowProductActionHandler$showProduct$1(this), new TrackShowProductActionHandler$showProduct$2(this, r12));
        return;
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
    L9:
        r5 = false;
        goto L10
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void b(StoreV2ProductItemVO r1, View r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.c(r1, r2);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void c(SliceActionType r1, ShopSlcProductItemV2 r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.b(r1, r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void d(SliceActionType r1, StoreV2ProductItemVO r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.a(r1, r2, r3);
    }
}
