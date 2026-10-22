package com.bytedance.android.window.shop.home.tab;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowProductForm;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.utils.i;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.CategoryTabStruct;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowTabEventReporter {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabEventReporter$EventType;", "", "SHOW", "CLICK", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType CLICK = null;
        public static final EventType SHOW = null;
        public static final /* synthetic */ EventType[] a = null;

        static {
            EventType r1 = new EventType("SHOW", 0);
            SHOW = r1;
            EventType r2 = new EventType("CLICK", 1);
            CLICK = r2;
            a = new EventType[]{r1, r2};
        }

        public static EventType valueOf(String r1) {
            return (EventType) r27.a.a(EventType.class, r1);
        }

        public static EventType[] values() {
            return (EventType[]) a.clone();
        }

        public EventType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabEventReporter$HotSaleProductClickArea;", "", "", "position", "I", "getPosition", "()I", "WATCH_PLAY_BACK", "BUY", "OTHER", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HotSaleProductClickArea extends Enum<HotSaleProductClickArea> {
        public static final HotSaleProductClickArea BUY = null;
        public static final HotSaleProductClickArea OTHER = null;
        public static final HotSaleProductClickArea WATCH_PLAY_BACK = null;
        public static final /* synthetic */ HotSaleProductClickArea[] a = null;
        private final int position;

        static {
            HotSaleProductClickArea r1 = new HotSaleProductClickArea("WATCH_PLAY_BACK", 0, 101);
            WATCH_PLAY_BACK = r1;
            HotSaleProductClickArea r2 = new HotSaleProductClickArea("BUY", 1, 102);
            BUY = r2;
            HotSaleProductClickArea r3 = new HotSaleProductClickArea("OTHER", 2, 103);
            OTHER = r3;
            a = new HotSaleProductClickArea[]{r1, r2, r3};
        }

        public static HotSaleProductClickArea valueOf(String r1) {
            return (HotSaleProductClickArea) r27.a.a(HotSaleProductClickArea.class, r1);
        }

        public static HotSaleProductClickArea[] values() {
            return (HotSaleProductClickArea[]) a.clone();
        }

        public final int getPosition() {
            return this.position;
        }

        public HotSaleProductClickArea(String r1, int r2, int r3) {
            super(r1, r2);
            this.position = r3;
        }
    }

    public WindowTabEventReporter() {
    }

    static {
    }

    public static Map b(ECWindowParam r3) {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("author_id", r3.getAuthorId()), TuplesKt.to("entrance_location", r3.getEntranceLocation()), TuplesKt.to("page_name", "store_page"), TuplesKt.to("store_type", "window"), TuplesKt.to("follow_status", String.valueOf(r3.getFollowStatus()))});
    }

    public static Map c(ECWindowParam r5, String r6, Integer r7) {
        Map r0 = b(r5);
        Pair r1 = TuplesKt.to("tab_id", r6);
        r0.put(r1.getFirst(), r1.getSecond());
        ConcurrentHashMap<String, CategoryTabStruct> r2 = com.bytedance.android.window.shop.e.a;
        CategoryTabStruct r3 = r2.get(r6);
        String r4 = null;
        if (r3 == null) goto L7;
        Integer r8 = r3.getType();
        if (r8 == null) goto L7;
        String r9 = String.valueOf(r8.intValue());
    L8:
        Pair r10 = TuplesKt.to("tab_type", r9);
        r0.put(r10.getFirst(), r10.getSecond());
        CategoryTabStruct r11 = r2.get(r6);
        if (r11 == null) goto L11;
        String r12 = r11.getName();
    L12:
        Pair r13 = TuplesKt.to("tab_name", k.j(r12));
        r0.put(r13.getFirst(), r13.getSecond());
        Integer r14 = r5.getFollowStatus();
        if (r14 != null) goto L16;
    L18:
        String r15 = CommentScene.COMMENTSCENE_NO_AWEME;
    L19:
        Pair r16 = TuplesKt.to("follow_status", r15);
        r0.put(r16.getFirst(), r16.getSecond());
        if (r7 == null) goto L22;
        r4 = String.valueOf(r7.intValue());
    L22:
        Pair r17 = TuplesKt.to("show_order", r4);
        r0.put(r17.getFirst(), r17.getSecond());
        return r0;
    L16:
        if (r14.intValue() != 0) goto L18;
        r15 = "0";
        goto L19
    L11:
        r12 = null;
    L7:
        r9 = null;
        goto L8
    }

    public static void d(View r7, ECWindowViewModel r8, ECWindowParam r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "reporter");
        Intrinsics.checkNotNullParameter(r9, "shopParam");
        Intrinsics.checkNotNullParameter(r10, "orderType");
        PageFinder r3 = PageFinder.via(r7);
        Map r5 = b(r9);
        Pair r11 = TuplesKt.to("order_type", r10);
        r5.put(r11.getFirst(), r11.getSecond());
        Unit r12 = Unit.INSTANCE;
        r8.doAnyEventActionWithBtm("c68164.d66157", r3, "click_ecommerce_store_sort", r5, new Pair[0]);
    }

    public static void f(ECWindowViewModel r4, ECWindowParam r5, Integer r6, String r7) {
        Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("store_type", "window"), TuplesKt.to("author_id", r5.getAuthorId()), TuplesKt.to("entrance_location", r5.getEntranceLocation()), TuplesKt.to("store_source_page", r5.getStoreSourcePage()), TuplesKt.to("store_source_method", r5.getStoreSourceMethod()), TuplesKt.to("store_group_type", r5.getStoreGroupType())});
        if (r6 == null) goto L5;
        r8.put("product_cnt", String.valueOf(r6.intValue()));
    L5:
        r4.doEventAction(r7, r8, new Pair[0]);
    }

    public static Map a(WindowV2ProductItemVO r10, ECWindowParam r11, ECWindowProductForm r12, FragmentActivity r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "shopParam");
        Intrinsics.checkNotNullParameter(r12, "productForm");
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "entranceFormSecond");
        Pair[] r0 = new Pair[28];
        r0[0] = TuplesKt.to("bst_group_type", "product");
        r0[1] = TuplesKt.to("entrance_location", r11.getEntranceLocation());
        r0[2] = TuplesKt.to("source_page", "store_page");
        r0[3] = TuplesKt.to("store_type", "window");
        r0[4] = TuplesKt.to("ecom_entrance_form", "live_top");
        r0[5] = TuplesKt.to("tab_name_second", r14);
        r0[6] = TuplesKt.to("ecom_group_type", "product");
        r0[7] = TuplesKt.to("product_id", r10.a);
        String r15 = r10.b;
        String r1 = null;
        if (r15 != null) goto L5;
    L12:
        r15 = r10.a;
    L13:
        r0[8] = TuplesKt.to("commodity_id", r15);
        Long r16 = r10.c;
        if (r16 == null) goto L16;
        String r17 = String.valueOf(r16.longValue());
    L17:
        r0[9] = TuplesKt.to("commodity_type", r17);
        ECUrlModel r18 = r11.getBrandTag();
        String r2 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r18 == null) goto L20;
        Object r19 = CommentScene.COMMENTSCENE_NO_AWEME;
    L21:
        r0[10] = TuplesKt.to("brand_verified", r19);
        r0[11] = TuplesKt.to("search_params", r11.getSearchParams());
        r0[12] = TuplesKt.to("pre_product_id", r11.getPreProductId());
        r0[13] = TuplesKt.to("pre_room_id", r11.getPreRoomId());
        r0[14] = TuplesKt.to("pre_group_id", r11.getPreGroupId());
        Map r110 = r10.s;
        if (r110 == null) goto L29;
        List r111 = (List) r110.get("ecom_shop_product_before");
        if (r111 == null) goto L29;
        ECRitTag r112 = (ECRitTag) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L29;
        r1 = r112.getTrackTag();
    L29:
        if (r1 != null) goto L31;
        r1 = "";
    L31:
        r0[15] = TuplesKt.to("label_name", r1);
        if (r10.f() == null) goto L34;
        Object r3 = CommentScene.COMMENTSCENE_NO_AWEME;
    L35:
        r0[16] = TuplesKt.to("is_product_info", r3);
        if (k.c(r10.i) == false) goto L38;
        Object r4 = CommentScene.COMMENTSCENE_NO_AWEME;
    L39:
        r0[17] = TuplesKt.to("is_price_info", r4);
        if (r10.d() == null) goto L42;
        Object r5 = CommentScene.COMMENTSCENE_NO_AWEME;
    L43:
        r0[18] = TuplesKt.to("is_recommend_info", r5);
        WindowV2ProductItemDTO.b r6 = r10.v;
        if (r6 == null) goto L46;
        String r7 = r6.a();
    L47:
        r0[19] = TuplesKt.to("content_form", r7);
        r0[20] = TuplesKt.to("content_source", "shop");
        r0[21] = TuplesKt.to("product_form", r12.getDes());
        JSONObject r113 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d("source_method", "live_top"), JsonDslUtilKt.d("product_form", r12.getDes())});
        xn.c.b(r113, r13);
        r0[22] = TuplesKt.to("entrance_info", r113.toString());
        int r114 = i.a;
        r0[23] = i.a("c3406.d8964_i" + ((Integer) r10.C.a(wn.a.C)), false);
        if (Intrinsics.areEqual((Boolean) r10.C.a(wn.a.B), Boolean.TRUE) == true) goto L51;
        r2 = "0";
    L51:
        r0[24] = TuplesKt.to("is_live_explain", r2);
        r0[25] = TuplesKt.to("product_orders", String.valueOf(k.f((Integer) r10.C.a(wn.a.A))));
        if (r11.isEcShare() == false) goto L54;
        Pair r115 = TuplesKt.to("share_content", r11.getShareContent());
    L55:
        r0[26] = r115;
        if (r11.isEcShare() == false) goto L58;
        Pair r116 = TuplesKt.to("share_object", r11.getShareObject());
    L59:
        r0[27] = r116;
        return MapsKt.mutableMapOf(r0);
    L58:
        r116 = TuplesKt.to("", "");
        goto L59
    L54:
        r115 = TuplesKt.to("", "");
        goto L55
    L46:
        r7 = "";
        goto L47
    L42:
        r5 = "0";
        goto L43
    L38:
        r4 = "0";
        goto L39
    L34:
        r3 = "0";
        goto L35
    L20:
        r19 = "0";
        goto L21
    L16:
        r17 = null;
        goto L17
    L5:
        if (r15.length() <= 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L11;
        r15 = null;
    L11:
        if (r15 != null) goto L13;
    L7:
        r8 = false;
        goto L8
    }

    public static void g(View r7, ECWindowViewModel r8, ECWindowParam r9, String r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "reporter");
        Intrinsics.checkNotNullParameter(r9, "shopParam");
        Intrinsics.checkNotNullParameter(r10, "categoryId");
        r8.doAnyEventActionWithBtm("a1.b7635.c68164.d260725", PageFinder.via(r7), "commodity_source_tab_show", c(r9, r10, r11), new Pair[0]);
    }

    public static void e(View r1, ECWindowViewModel r2, ECWindowParam r3, String r4, Integer r5, ClickSeparatedTabSelectListener.ActionType r6) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "reporter");
        Intrinsics.checkNotNullParameter(r3, "shopParam");
        Intrinsics.checkNotNullParameter(r4, "categoryId");
        Map r7 = c(r3, r4, r5);
        if (r6 == null) goto L9;
        int r8 = f.b[r6.ordinal()];
        if (r8 != 1) goto L8;
        String r9 = "slide";
    L12:
        Pair r10 = TuplesKt.to("click_type", r9);
        r7.put(r10.getFirst(), r10.getSecond());
        r2.doAnyEventActionWithBtm("a1.b7635.c68164.d260725", PageFinder.via(r1), "commodity_source_tab_click", r7, new Pair[0]);
        return;
    L8:
        if (r8 != 2) goto L9;
        r9 = PinchEnterMethod.CLICK;
    L9:
        r9 = CommentConstants$CmtLongPanelStrategy.DEFAULT;
        goto L12
    }
}
