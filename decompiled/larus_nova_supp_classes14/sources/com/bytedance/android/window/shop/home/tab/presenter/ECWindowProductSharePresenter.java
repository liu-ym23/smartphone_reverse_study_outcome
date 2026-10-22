package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.tab.entity.o0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowProductSharePresenter extends ECWindowVideoCardPresenter {
    public static final /* synthetic */ int n = 0;
    public final Lazy m;

    public final Map<String, String> j0() {
        o0 r0 = this.j;
        String r2 = null;
        if ((r0 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r1 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r0;
        if (r1 == null) goto L12;
        List<? extends WindowV2ProductItemVO> r3 = r1.q;
        if (r3 == null) goto L12;
        WindowV2ProductItemVO r4 = (WindowV2ProductItemVO) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L12;
        r2 = r4.a;
    L12:
        Pair[] r5 = new Pair[17];
        r5[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r5[1] = TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation());
        r5[2] = TuplesKt.to("author_id", d0().getShopParam().getAuthorId());
        r5[3] = TuplesKt.to("sec_author_id", d0().getShopParam().getSecAuthorId());
        r5[4] = TuplesKt.to("enter_from", d0().getShopParam().getEnterFrom());
        r5[5] = TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation());
        r5[6] = TuplesKt.to("store_source_page", d0().getShopParam().getStoreSourcePage());
        r5[7] = TuplesKt.to("store_source_method", d0().getShopParam().getStoreSourceMethod());
        r5[8] = TuplesKt.to("store_group_type", d0().getShopParam().getStoreGroupType());
        r5[9] = TuplesKt.to("store_type", "window");
        r5[10] = TuplesKt.to("product_id", r2);
        Integer r6 = d0().getShopParam().getFollowStatus();
        String r7 = "";
        if (r6 == null) goto L16;
        String r8 = String.valueOf(r6.intValue());
        if (r8 == null) goto L16;
    L17:
        r5[11] = TuplesKt.to("follow_status", r8);
        o0 r9 = this.j;
        if (r9 == null) goto L20;
        r7 = String.valueOf(r9.p);
    L20:
        r5[12] = TuplesKt.to("card_type", r7);
        r5[13] = TuplesKt.to("ecom_entrance_form", "video_tab");
        r5[14] = TuplesKt.to("tab_name_second", "video_tab_101");
        r5[15] = TuplesKt.to("product_form", "double_product");
        r5[16] = TuplesKt.to("bst_group_type", "product");
        return MapsKt.mutableMapOf(r5);
    L16:
        r8 = "";
        goto L17
    }

    public ECWindowProductSharePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.m = LazyKt.lazy(new ECWindowProductSharePresenter$btmHost$2(this));
    }
}
