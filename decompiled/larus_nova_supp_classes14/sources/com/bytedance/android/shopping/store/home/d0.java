package com.bytedance.android.shopping.store.home;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.host.api.split.ECFoldScene;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.repository.vo.AuthorReputationVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.api.StoreV3UIParam;
import com.bytedance.android.shopping.store.home.entity.ECShopBrandHeaderModule;
import com.bytedance.android.shopping.store.home.entity.ECShopBrandModuleInfo;
import com.bytedance.android.shopping.store.home.entity.ShopValueInfoItem;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair[] a(ECStoreViewModel r11) {
        Intrinsics.checkNotNullParameter(r11, "storeViewModel");
        com.bytedance.android.shopping.store.home.entity.n r12 = (com.bytedance.android.shopping.store.home.entity.n) r11.getHeaderArea().getValue();
        if (r12 == null) goto L9;
        com.bytedance.android.shopping.store.home.entity.d r2 = r12.c;
        if (r2 == null) goto L9;
        if (r2.d == true) goto L9;
        boolean r3 = true;
    L10:
        Integer r4 = null;
        if (r12 == null) goto L13;
        uj3.b r5 = r12.d;
    L14:
        if (r5 == null) goto L16;
        boolean r6 = true;
    L18:
        if (r12 == null) goto L22;
        Map<String, String> r7 = r12.k;
        if (r7 == null) goto L22;
        String r8 = r7.get("is_flagship");
    L23:
        if (r8 == null) goto L25;
        boolean r9 = true;
    L26:
        if (r12 == null) goto L30;
        com.bytedance.android.shopping.store.home.entity.e r10 = r12.b;
        if (r10 == null) goto L30;
        Map<String, ShopValueInfoItem> r13 = r10.f;
    L31:
        Pair[] r14 = new Pair[10];
        r14[0] = TuplesKt.to("enter_from", "store_page");
        r14[1] = TuplesKt.to("page_name", "store_page");
        r14[2] = TuplesKt.to("is_shop_bind_author", String.valueOf(r3));
        String r0 = "";
        if (r13 == null) goto L39;
        ShopValueInfoItem r1 = r13.get("fans");
        if (r1 == null) goto L39;
        String r15 = r1.getNumberText();
        String r16 = r1.getSuffix();
        if (r16 != null) goto L38;
        r16 = "";
    L38:
        String r17 = Intrinsics.stringPlus(r15, r16);
    L40:
        r14[3] = TuplesKt.to("fans_cnt", r17);
        if (r13 == null) goto L48;
        ShopValueInfoItem r18 = r13.get("sales");
        if (r18 == null) goto L48;
        String r19 = r18.getNumberText();
        String r20 = r18.getSuffix();
        if (r20 != null) goto L47;
        r20 = "";
    L47:
        String r21 = Intrinsics.stringPlus(r19, r20);
    L49:
        r14[4] = TuplesKt.to("sale_cnt", r21);
        if (r13 == null) goto L58;
        ShopValueInfoItem r22 = r13.get("works");
        if (r22 == null) goto L58;
        String r23 = r22.getNumberText();
        String r24 = r22.getSuffix();
        if (r24 == null) goto L57;
        r0 = r24;
    L57:
        String r25 = Intrinsics.stringPlus(r23, r0);
    L59:
        r14[5] = TuplesKt.to("works_cnt", r25);
        r14[6] = TuplesKt.to("is_flagship", String.valueOf(r9));
        if (r12 == null) goto L66;
        com.bytedance.android.shopping.store.home.entity.e r26 = r12.b;
        if (r26 == null) goto L66;
        AuthorReputationVO r27 = r26.d;
        if (r27 == null) goto L66;
        Double r28 = r27.getScore();
    L67:
        r14[7] = TuplesKt.to("experience_score", String.valueOf(r28));
        if (r12 == null) goto L74;
        com.bytedance.android.shopping.store.home.entity.e r110 = r12.b;
        if (r110 == null) goto L74;
        com.bytedance.android.ec.model.o r111 = r110.j;
        if (r111 == null) goto L74;
        r4 = r111.e();
    L74:
        r14[8] = TuplesKt.to("shop_level", String.valueOf(r4));
        r14[9] = TuplesKt.to("is_shop_list", String.valueOf(r6));
        return r14;
    L66:
        r28 = null;
    L58:
        r25 = null;
    L48:
        r21 = null;
    L39:
        r17 = null;
    L30:
        r13 = null;
        goto L31
    L25:
        r9 = false;
    L22:
        r8 = null;
        goto L23
    L16:
        r6 = false;
        goto L18
    L13:
        r5 = null;
    L9:
        r3 = false;
        goto L10
    }

    public static StoreV3LiveRoomVO b(ECStoreViewModel r5) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        im.v r2 = null;
        if (r5.getStoreParam().getSplitParent() == ECFoldScene.VIDEO) goto L5;
    L9:
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) r5.getHeaderArea().getValue();
        if (r0 == null) goto L28;
        ECShopBrandModuleInfo r1 = r0.l;
        if (r1 == null) goto L28;
        List<ECShopBrandHeaderModule> r3 = r1.getModuleList();
        if (r3 == null) goto L28;
        Iterator<T> r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L24;
        Object r6 = r4.next();
        if (((ECShopBrandHeaderModule) r6).getModuleType() != 1) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L17;
    L25:
        ECShopBrandHeaderModule r8 = (ECShopBrandHeaderModule) r6;
        if (r8 == null) goto L28;
        r2 = r8.getLiveInfo();
        goto L28
    L21:
        r7 = false;
        goto L22
    L24:
        r6 = null;
    L28:
        if (r2 == null) goto L31;
        StoreV3LiveRoomVO.Companion.getClass();
        return StoreV3LiveRoomVO.a.a(r2);
    L31:
        return (StoreV3LiveRoomVO) r5.getLiveInfo().getValue();
    L5:
        if ((!Intrinsics.areEqual((Boolean) r5.isBrandShop().getValue(), Boolean.TRUE)) == false) goto L9;
        com.bytedance.android.shopping.store.home.entity.n r9 = (com.bytedance.android.shopping.store.home.entity.n) r5.getHeaderArea().getValue();
        if (r9 == null) goto L28;
        r2 = r9.p;
        goto L28
    }

    public static void d(ECStoreViewModel r2, ECStoreViewModel r3, String r4, Map r5) {
        Pair[] r6 = a(r3);
        if (r2 == null) goto L6;
        SpreadBuilder r0 = new SpreadBuilder(2);
        r0.addSpread(r6);
        r0.add(TuplesKt.to("click_area", r4));
        r2.doAnyEventAction("store_experience_score_click", r5, (Pair[]) r0.toArray(new Pair[r0.size()]));
        return;
    }

    public static void c(ECStoreViewModel r4, View r5, ECStoreViewModel r6, Context r7, Map r8) {
        Intrinsics.checkNotNullParameter(r4, "eventReporter");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "storeViewModel");
        Intrinsics.checkNotNullParameter(r7, "context");
        ECStoreParam r0 = r6.getStoreParam();
        if (r0 == null) goto L7;
        StoreV3UIParam r1 = r0.getStoreV3UIParam();
        if (r1 == null) goto L7;
        Boolean r2 = r1.getHideDetailEntry();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L11;
        return;
    L11:
        ECStoreParam r3 = r6.getStoreParam();
        if (r3 == null) goto L20;
        String r9 = r3.getStoreDetailUrl();
        if (r9 == null) goto L20;
        int r10 = com.bytedance.android.ec.store.utils.b.a;
        String r11 = com.bytedance.android.ec.store.utils.b.b(r9, "a1.b6269.c5887.d3193", PageFinder.via(r5), null);
        if (r11 != null) goto L18;
        return;
    L18:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r7, r11);
    L20:
        if (r5.getId() != 2131371076) goto L22;
        String r12 = "105";
    L23:
        d(r4, r6, r12, r8);
        return;
    L22:
        r12 = "";
    L7:
        r2 = null;
        goto L9
    }
}
