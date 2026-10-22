package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductReqParams;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.elements.b<LinearLayout> {
    public List<com.bytedance.android.ec.store.repository.dto.c> H3;
    public int I3;
    public final List<ECTagListView> J3;
    public ECShopHybridProductViewModel K3;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.slicecard.viewmanager.a$a, reason: collision with other inner class name */
    public static final class C0019a {
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/shopping/store/slicecard/viewmanager/a$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/ec/store/repository/dto/c;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends com.bytedance.android.ec.store.repository.dto.c>> {
        public b() {
        }
    }

    static {
    }

    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.J3 = new ArrayList();
    }

    public final void H0(Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r18, "props");
        if (((LinearLayout) k1()) != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ? extends Object>> r1 = r18.entrySet().iterator();
    L6:
        Object r3 = null;
        if (r1.hasNext() == false) goto L22;
        Map.Entry<String, ? extends Object> r2 = r1.next();
        String r4 = r2.getKey();
        if (r4.hashCode() != (-807739586)) goto L6;
        if (r4.equals("select_buttons") == false) goto L6;
        Type r5 = new b().getType();
        Object r6 = r2.getValue();
        if (r6 == null) goto L16;
        Object r7 = com.bytedance.android.ec.store.utils.m.a(r6, r5);
    L18:
        if ((r7 instanceof List) == false) goto L21;
        r3 = r7;
    L21:
        this.H3 = (List) r3;
        goto L6
    L16:
        r7 = null;
        goto L18
    L22:
        LinearLayout r8 = (LinearLayout) k1();
        if (r8 == null) goto L25;
        r8.removeAllViews();
    L25:
        ((ArrayList) this.J3).clear();
        int r9 = 0;
        this.I3 = 0;
        SlcTemplateContext r10 = ((BaseSlcViewManager) this).a;
        String r11 = r10.g;
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        Object r12 = r10.o(r11);
        if ((r12 instanceof gk3.a) == true) goto L31;
        r12 = null;
    L31:
        gk3.a r13 = (gk3.a) r12;
        if (r13 == null) goto L34;
        ECShopHybridProductViewModel r14 = r13.c();
    L35:
        this.K3 = r14;
        SlcTemplateContext r15 = ((BaseSlcViewManager) this).a;
        String r16 = r15.g;
        if (r16 != null) goto L38;
        r16 = "";
    L38:
        Object r17 = r15.o(r16);
        if ((r17 instanceof gk3.a) == true) goto L41;
        r17 = null;
    L41:
        gk3.a r19 = (gk3.a) r17;
        if (r19 == null) goto L44;
        r19.a();
    L44:
        List<com.bytedance.android.ec.store.repository.dto.c> r20 = this.H3;
        if (r20 == null) goto L51;
        List<com.bytedance.android.ec.store.repository.dto.c> r21 = CollectionsKt.toMutableList(r20);
        if (r21 == null) goto L51;
        ECShopHybridProductViewModel r22 = this.K3;
        if (r22 == null) goto L51;
        r22.setSelectButtons(r21);
    L51:
        List<com.bytedance.android.ec.store.repository.dto.c> r23 = this.H3;
        if (r23 == null) goto L54;
        this.I3 = r23.size();
    L54:
        List<com.bytedance.android.ec.store.repository.dto.c> r24 = this.H3;
        if (r24 == null) goto L64;
        Iterator<T> r25 = r24.iterator();
    L58:
        if (r25.hasNext() == false) goto L62;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.store.repository.dto.c) r26).e(), Boolean.TRUE) == false) goto L58;
    L63:
        com.bytedance.android.ec.store.repository.dto.c r27 = (com.bytedance.android.ec.store.repository.dto.c) r26;
    L65:
        ECShopHybridProductViewModel r28 = this.K3;
        if (r28 == null) goto L70;
        ECShopHybridProductReqParams r29 = r28.getRequestParam();
        if (r29 == null) goto L70;
        String r30 = r29.getFilterParams();
    L72:
        if (com.bytedance.android.shopping.extensions.k.c(r30) == false) goto L81;
        ECShopHybridProductViewModel r31 = this.K3;
        if (r31 == null) goto L80;
        ECShopHybridProductReqParams r32 = r31.getRequestParam();
        if (r32 == null) goto L80;
        String r33 = r32.getFilterParams();
        if (r33 == null) goto L80;
        JSONObject r34 = com.bytedance.commerce.base.json.b.a(r33);
    L82:
        if (r34 == null) goto L87;
        if (r27 == null) goto L85;
        String r35 = r27.c();
    L86:
        r34.put("select_params", r35);
        goto L87
    L85:
        r35 = null;
    L87:
        ECShopHybridProductViewModel r36 = this.K3;
        if (r36 == null) goto L92;
        ECShopHybridProductReqParams r37 = r36.getRequestParam();
        if (r37 == null) goto L92;
        r37.setFilterParams(String.valueOf(r34));
    L92:
        List<com.bytedance.android.ec.store.repository.dto.c> r38 = this.H3;
        if (r38 == null) goto L130;
        Iterator<T> r39 = r38.iterator();
        int r40 = 0;
    L96:
        if (r39.hasNext() == false) goto L130;
        Object r41 = r39.next();
        int r42 = r40 + 1;
        if (r40 >= 0) goto L100;
        CollectionsKt.throwIndexOverflow();
    L100:
        com.bytedance.android.ec.store.repository.dto.c r43 = (com.bytedance.android.ec.store.repository.dto.c) r41;
        if (r43.b() == null) goto L129;
        if (r43.d() == null) goto L129;
        if (r40 >= this.I3) goto L124;
        ECTagListView r44 = new ECTagListView(getContext(), null, 6, 0);
        ((ArrayList) this.J3).add(r44);
        r44.setOnClickListener(new com.bytedance.android.shopping.store.slicecard.viewmanager.b(this, r43, r40));
        LinearLayout.LayoutParams r45 = new LinearLayout.LayoutParams(-1, -2);
        r45.weight = 1.0f;
        if (this.I3 <= 1) goto L112;
        if (r40 <= 0) goto L112;
        int r46 = com.bytedance.android.shopping.extensions.b.b(9);
    L113:
        r45.setMargins(r46, 0, 0, com.bytedance.android.shopping.extensions.b.b(0));
        LinearLayout r47 = (LinearLayout) k1();
        if (r47 == null) goto L117;
        r47.addView(r44, r45);
    L117:
        if (Intrinsics.areEqual(r43.e(), Boolean.TRUE) == false) goto L121;
        ECTagListDTO r110 = r43.b();
        if (r110 == null) goto L124;
        ECTagListView.c(r44, r110, null, null, null, null, null, 62);
        goto L124
    L121:
        ECTagListDTO r111 = r43.d();
        if (r111 == null) goto L124;
        ECTagListView.c(r44, r111, null, null, null, null, null, 62);
    L112:
        r46 = 0;
    L124:
        Map r48 = r43.a();
        if (r48 == null) goto L129;
        String r49 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r48, "a", null);
        if (r49 == null) goto L129;
        com.bytedance.commerce.base.json.b.a(r49);
    L129:
        r40 = r42;
    L130:
        List<com.bytedance.android.ec.store.repository.dto.c> r50 = this.H3;
        if (r50 == null) goto L161;
        Iterator<T> r51 = r50.iterator();
    L134:
        if (r51.hasNext() == false) goto L181;
        Object r52 = r51.next();
        int r53 = r9 + 1;
        if (r9 >= 0) goto L138;
        CollectionsKt.throwIndexOverflow();
    L138:
        com.bytedance.android.ec.store.repository.dto.c r54 = (com.bytedance.android.ec.store.repository.dto.c) r52;
        boolean r55 = Intrinsics.areEqual(r54.e(), Boolean.TRUE);
        if (r55 == false) goto L145;
        ECTagListDTO r56 = r54.b();
        if (r56 == null) goto L150;
        Map r57 = r56.getExtraInfo();
        if (r57 == null) goto L150;
    L149:
        String r58 = (String) r57.get("filter_event_params");
    L151:
        o1("show_discount_filter_button", r58, "");
        if (r55 == false) goto L160;
        ECTagListDTO r59 = r54.b();
        if (r59 == null) goto L158;
        Map r60 = r59.getExtraInfo();
        if (r60 == null) goto L158;
        String r61 = (String) r60.get("filter_event_params");
    L159:
        o1("click_discount_filter_button", r61, CommentConstants$CmtLongPanelStrategy.DEFAULT);
    L158:
        r61 = null;
    L160:
        r9 = r53;
    L150:
        r58 = null;
        goto L151
    L145:
        ECTagListDTO r62 = r54.d();
        if (r62 == null) goto L150;
        r57 = r62.getExtraInfo();
        if (r57 == null) goto L150;
    L181:
        return;
    L161:
        return;
    L80:
        r34 = null;
        goto L82
    L81:
        r34 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
    L70:
        r30 = null;
        goto L72
    L62:
        r26 = null;
        goto L63
    L64:
        r27 = null;
        goto L65
    L34:
        r14 = null;
        goto L35
    }

    public final View n1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        LinearLayout r0 = new LinearLayout(r2);
        r0.setOrientation(0);
        return r0;
    }

    public final void p1(int r8) {
        ECShopHybridProductViewModel r0 = this.K3;
        if (r0 == null) goto L5;
        r0.refreshSelectStatus(r8);
    L5:
        Iterator r9 = ((ArrayList) this.J3).iterator();
        int r1 = 0;
    L7:
        if (r9.hasNext() == false) goto L28;
        Object r2 = r9.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        ECTagListView r4 = (ECTagListView) r2;
        ECShopHybridProductViewModel r5 = this.K3;
        if (r5 == null) goto L27;
        List<com.bytedance.android.ec.store.repository.dto.c> r6 = r5.getSelectButtons();
        if (r6 == null) goto L27;
        com.bytedance.android.ec.store.repository.dto.c r7 = (com.bytedance.android.ec.store.repository.dto.c) CollectionsKt.getOrNull(r6, r1);
        if (r7 == null) goto L27;
        dm.a.a("ShopFilterButtonViewManager").a("更新样式:" + r1 + ",isSelect:" + r7.e());
        if (Intrinsics.areEqual(r7.e(), Boolean.TRUE) == false) goto L23;
        ECTagListDTO r10 = r7.b();
        if (r10 == null) goto L27;
        r4.l(r10);
        goto L27
    L23:
        if (Intrinsics.areEqual(r7.e(), Boolean.FALSE) == false) goto L27;
        ECTagListDTO r11 = r7.d();
        if (r11 == null) goto L27;
        r4.l(r11);
    L27:
        r1 = r3;
        goto L7
    }

    public final void o1(String r6, String r7, String r8) {
        Pair[] r0 = new Pair[9];
        r0[0] = TuplesKt.to("store_type", "shop");
        ECShopHybridProductViewModel r1 = this.K3;
        String r3 = null;
        if (r1 == null) goto L9;
        ECStoreParam r2 = r1.getStoreParam();
        if (r2 == null) goto L9;
        StoreAccountParam r4 = r2.getStoreAccountParam();
        if (r4 == null) goto L9;
        String r5 = r4.getUserId();
    L10:
        r0[1] = TuplesKt.to("author_id", r5);
        ECShopHybridProductViewModel r9 = this.K3;
        if (r9 == null) goto L15;
        ECStoreParam r10 = r9.getStoreParam();
        if (r10 == null) goto L15;
        String r11 = r10.getShopId();
    L16:
        r0[2] = TuplesKt.to("shop_id", r11);
        ECShopHybridProductViewModel r12 = this.K3;
        if (r12 == null) goto L21;
        ECStoreParam r13 = r12.getStoreParam();
        if (r13 == null) goto L21;
        Integer r14 = r13.getFollowStatus();
    L22:
        r0[3] = TuplesKt.to("follow_status", String.valueOf(r14));
        ECShopHybridProductViewModel r15 = this.K3;
        if (r15 == null) goto L27;
        ECStoreParam r16 = r15.getStoreParam();
        if (r16 == null) goto L27;
        String r17 = r16.getEntranceLocation();
    L28:
        r0[4] = TuplesKt.to("entrance_location", r17);
        ECShopHybridProductViewModel r18 = this.K3;
        if (r18 == null) goto L33;
        ECStoreParam r19 = r18.getStoreParam();
        if (r19 == null) goto L33;
        String r20 = r19.getStoreSourcePage();
    L34:
        r0[5] = TuplesKt.to("store_source_page", r20);
        ECShopHybridProductViewModel r21 = this.K3;
        if (r21 == null) goto L39;
        ECStoreParam r22 = r21.getStoreParam();
        if (r22 == null) goto L39;
        String r23 = r22.getStoreSourceMethod();
    L40:
        r0[6] = TuplesKt.to("store_source_method", r23);
        ECShopHybridProductViewModel r24 = this.K3;
        if (r24 == null) goto L45;
        ECStoreParam r25 = r24.getStoreParam();
        if (r25 == null) goto L45;
        r3 = r25.getStoreGroupType();
    L45:
        r0[7] = TuplesKt.to("store_group_type", r3);
        r0[8] = TuplesKt.to("tab_name", "products");
        Map<String, String> r26 = MapsKt.mutableMapOf(r0);
        if (r7 == null) goto L51;
        Map<String, String> r27 = com.bytedance.android.shopping.store.hybridproduct.presenter.a.a(r7);
        if (r27 == null) goto L51;
        r26.putAll(r27);
    L51:
        if (Intrinsics.areEqual(r6, "click_discount_filter_button") == false) goto L53;
        r26.put("click_type", r8);
    L53:
        ECShopHybridProductViewModel r28 = this.K3;
        if (r28 == null) goto L57;
        r28.doEventAction(r6, r26, new Pair[0]);
        return;
    L57:
        return;
    L39:
        r23 = null;
    L33:
        r20 = null;
    L27:
        r17 = null;
    L21:
        r14 = null;
    L15:
        r11 = null;
    L9:
        r5 = null;
        goto L10
    }
}
