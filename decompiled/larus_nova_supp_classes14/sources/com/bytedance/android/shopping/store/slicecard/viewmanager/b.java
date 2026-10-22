package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ com.bytedance.android.ec.store.repository.dto.c b;
    public final /* synthetic */ int c;

    public b(a r1, com.bytedance.android.ec.store.repository.dto.c r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        a r11 = this.a;
        com.bytedance.android.ec.store.repository.dto.c r0 = this.b;
        int r1 = this.c;
        if (((ECTagListView) CollectionsKt.getOrNull(r11.J3, r1)) == null) goto L33;
        ECShopHybridProductViewModel r2 = r11.K3;
        if (r2 == null) goto L34;
        List<com.bytedance.android.ec.store.repository.dto.c> r3 = r2.getSelectButtons();
        if (r3 == null) goto L35;
        com.bytedance.android.ec.store.repository.dto.c r4 = (com.bytedance.android.ec.store.repository.dto.c) CollectionsKt.getOrNull(r3, r1);
        if (r4 == null) goto L36;
        String r8 = null;
        if (Intrinsics.areEqual(r4.e(), Boolean.FALSE) == false) goto L22;
        dm.a.a("ShopFilterButtonViewManager").a("选中:" + r1);
        r11.p1(r1);
        ECTagListDTO r5 = r0.d();
        if (r5 == null) goto L17;
        Map r6 = r5.getExtraInfo();
        if (r6 == null) goto L17;
        r8 = (String) r6.get("filter_event_params");
    L17:
        ECShopHybridProductViewModel r7 = r11.K3;
        if (r7 == null) goto L20;
        r7.refreshByDiscountSelect(r0.c(), r8);
    L20:
        r11.o1("click_discount_filter_button", r8, PinchEnterMethod.CLICK);
        return;
    L22:
        if (Intrinsics.areEqual(r4.e(), Boolean.TRUE) == false) goto L38;
        dm.a.a("ShopFilterButtonViewManager").a("取消选中:" + r1);
        r11.p1(-1);
        ECShopHybridProductViewModel r9 = r11.K3;
        if (r9 == null) goto L26;
        ECShopHybridProductViewModel.refreshByDiscountSelect$default(r9, null, null, 3, null);
    L26:
        ECTagListDTO r12 = r0.b();
        if (r12 == null) goto L31;
        Map r13 = r12.getExtraInfo();
        if (r13 == null) goto L31;
        r8 = (String) r13.get("filter_event_params");
    L31:
        r11.o1("click_discount_filter_button", r8, PinchEnterMethod.CLICK);
        return;
    L38:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }
}
