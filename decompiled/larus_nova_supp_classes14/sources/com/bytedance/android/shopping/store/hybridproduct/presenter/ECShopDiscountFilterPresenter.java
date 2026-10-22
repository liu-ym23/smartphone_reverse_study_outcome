package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopDiscountFilterPresenter extends QFragmentPresenter {
    public boolean f;
    public final List<ECTagListView> g;
    public final Lazy h;
    public int i;
    public final ECStoreViewModel j;
    public final ViewGroup k;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ECShopDiscountFilterPresenter a;
        public final /* synthetic */ com.bytedance.android.ec.store.repository.dto.c b;
        public final /* synthetic */ int c;

        public a(ECShopDiscountFilterPresenter r1, com.bytedance.android.ec.store.repository.dto.c r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ECShopDiscountFilterPresenter r11 = this.a;
            com.bytedance.android.ec.store.repository.dto.c r0 = this.b;
            int r1 = this.c;
            if (((ECTagListView) CollectionsKt.getOrNull(r11.g, r1)) == null) goto L23;
            com.bytedance.android.ec.store.repository.dto.c r2 = (com.bytedance.android.ec.store.repository.dto.c) CollectionsKt.getOrNull(r11.h0().getSelectButtons(), r1);
            if (r2 == null) goto L24;
            String r8 = null;
            if (Intrinsics.areEqual(r2.e(), Boolean.FALSE) == false) goto L15;
            dm.a.a("chenlong_hz_筛选").a("选中:" + r1);
            r11.i0();
            r11.j0(r1);
            ECTagListDTO r3 = r0.d();
            if (r3 == null) goto L13;
            Map r4 = r3.getExtraInfo();
            if (r4 == null) goto L13;
            r8 = (String) r4.get("filter_event_params");
        L13:
            r11.h0().refreshByDiscountSelect(r0.c(), r8);
            r11.e0("click_discount_filter_button", r8, PinchEnterMethod.CLICK);
            return;
        L15:
            if (Intrinsics.areEqual(r2.e(), Boolean.TRUE) == false) goto L26;
            dm.a.a("chenlong_hz_筛选").a("取消选中:" + r1);
            r11.i0();
            r11.j0(-1);
            ECShopHybridProductViewModel.refreshByDiscountSelect$default(r11.h0(), null, null, 3, null);
            ECTagListDTO r5 = r0.b();
            if (r5 == null) goto L21;
            Map r6 = r5.getExtraInfo();
            if (r6 == null) goto L21;
            r8 = (String) r6.get("filter_event_params");
        L21:
            r11.e0("click_discount_filter_button", r8, PinchEnterMethod.CLICK);
            return;
        L26:
            return;
        L24:
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopDiscountFilterPresenter a;

        public b(ECShopDiscountFilterPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            com.bytedance.android.ec.store.repository.vo.n r11 = (com.bytedance.android.ec.store.repository.vo.n) r10;
            int r0 = 0;
            ViewParent r2 = null;
            if (r11 == null) goto L5;
        L6:
            if (r11 == null) goto L8;
            List r3 = r11.a;
        L9:
            List r4 = r3;
            if (r4 != null) goto L12;
        L15:
            boolean r5 = true;
        L16:
            if (r5 == true) goto L18;
        L19:
            Boolean r6 = (Boolean) this.a.h0().isClothesSelected().getValue();
            Boolean r7 = Boolean.TRUE;
            if (Intrinsics.areEqual(r6, r7) == false) goto L40;
        L21:
            ECShopDiscountFilterPresenter r12 = this.a;
            if (Intrinsics.areEqual((Boolean) r12.h0().isClothesSelected().getValue(), Boolean.TRUE) == true) goto L33;
            Iterator r8 = ((ArrayList) r12.g).iterator();
        L26:
            if (r8.hasNext() == false) goto L28;
            r12.k.removeView((ECTagListView) r8.next());
            goto L26
        L28:
            ((ArrayList) r12.g).clear();
            r12.h0().getSelectButtons().clear();
            if (com.bytedance.android.shopping.extensions.k.c(r12.h0().getRequestParam().getFilterParams()) == false) goto L31;
            JSONObject r9 = com.bytedance.commerce.base.json.b.a(r12.h0().getRequestParam().getFilterParams());
        L32:
            r9.remove("select_params");
            r12.h0().getRequestParam().setFilterParams(r9.toString());
            r12.f = false;
            goto L33
        L31:
            r9 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
        L33:
            ViewParent r13 = this.a.a0().getParent();
            if ((r13 instanceof ViewGroup) == false) goto L37;
            r2 = r13;
        L37:
            ViewGroup r14 = (ViewGroup) r2;
            if (r14 == null) goto L150;
            r14.setVisibility(8);
            return;
        L150:
            return;
        L40:
            if (r11 == null) goto L173;
            ViewParent r15 = this.a.a0().getParent();
            if ((r15 instanceof ViewGroup) == true) goto L45;
            r15 = null;
        L45:
            ViewGroup r16 = (ViewGroup) r15;
            if (r16 == null) goto L48;
            r16.setVisibility(0);
        L48:
            List r17 = r11.a;
            if (r17 == null) goto L53;
            List<com.bytedance.android.ec.store.repository.dto.c> r18 = CollectionsKt.toMutableList(r17);
            if (r18 == null) goto L53;
            this.a.h0().setSelectButtons(r18);
        L53:
            List r19 = r11.a;
            if (r19 == null) goto L56;
            this.a.i = r19.size();
        L56:
            ECShopDiscountFilterPresenter r20 = this.a;
            if (r20.f == true) goto L130;
            List r21 = r11.a;
            if (r21 == null) goto L68;
            Iterator<T> r22 = r21.iterator();
        L62:
            if (r22.hasNext() == false) goto L66;
            T r23 = r22.next();
            if (Intrinsics.areEqual(((com.bytedance.android.ec.store.repository.dto.c) r23).e(), Boolean.TRUE) == false) goto L62;
        L67:
            com.bytedance.android.ec.store.repository.dto.c r24 = (com.bytedance.android.ec.store.repository.dto.c) r23;
        L70:
            if (com.bytedance.android.shopping.extensions.k.c(this.a.h0().getRequestParam().getFilterParams()) == false) goto L72;
            JSONObject r25 = com.bytedance.commerce.base.json.b.a(this.a.h0().getRequestParam().getFilterParams());
        L73:
            if (r24 == null) goto L75;
            String r26 = r24.c();
        L76:
            r25.put("select_params", r26);
            this.a.h0().getRequestParam().setFilterParams(r25.toString());
            List r1 = r11.a;
            if (r1 == null) goto L98;
            Iterator<T> r27 = r1.iterator();
            int r28 = 0;
        L80:
            if (r27.hasNext() == false) goto L98;
            T r29 = r27.next();
            int r30 = r28 + 1;
            if (r28 >= 0) goto L84;
            CollectionsKt.throwIndexOverflow();
        L84:
            com.bytedance.android.ec.store.repository.dto.c r31 = (com.bytedance.android.ec.store.repository.dto.c) r29;
            if (r31.b() == null) goto L97;
            if (r31.d() == null) goto L97;
            this.a.d0(r28, r31);
            ECShopDiscountFilterPresenter r32 = this.a;
            if (r32.f == true) goto L92;
            r32.f = true;
        L92:
            Map r33 = r31.a();
            if (r33 == null) goto L97;
            String r34 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r33, "a", null);
            if (r34 == null) goto L97;
            com.bytedance.commerce.base.json.b.a(r34);
        L97:
            r28 = r30;
        L98:
            List r110 = r11.a;
            if (r110 == null) goto L170;
            Iterator<T> r111 = r110.iterator();
        L102:
            if (r111.hasNext() == false) goto L174;
            T r35 = r111.next();
            int r36 = r0 + 1;
            if (r0 >= 0) goto L106;
            CollectionsKt.throwIndexOverflow();
        L106:
            com.bytedance.android.ec.store.repository.dto.c r37 = (com.bytedance.android.ec.store.repository.dto.c) r35;
            boolean r38 = Intrinsics.areEqual(r37.e(), Boolean.TRUE);
            ECShopDiscountFilterPresenter r39 = this.a;
            if (r38 == false) goto L113;
            ECTagListDTO r40 = r37.b();
            if (r40 == null) goto L118;
            Map r41 = r40.getExtraInfo();
            if (r41 == null) goto L118;
        L117:
            String r42 = (String) r41.get("filter_event_params");
        L119:
            r39.e0("show_discount_filter_button", r42, "");
            if (r38 == false) goto L128;
            ECShopDiscountFilterPresenter r43 = this.a;
            ECTagListDTO r44 = r37.b();
            if (r44 == null) goto L126;
            Map r45 = r44.getExtraInfo();
            if (r45 == null) goto L126;
            String r46 = (String) r45.get("filter_event_params");
        L127:
            r43.e0("click_discount_filter_button", r46, CommentConstants$CmtLongPanelStrategy.DEFAULT);
        L126:
            r46 = null;
        L128:
            r0 = r36;
        L118:
            r42 = null;
            goto L119
        L113:
            ECTagListDTO r47 = r37.d();
            if (r47 == null) goto L118;
            r41 = r47.getExtraInfo();
            if (r41 == null) goto L118;
        L174:
            return;
        L170:
            return;
        L75:
            r26 = null;
            goto L76
        L72:
            r25 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
            goto L73
        L66:
            r23 = null;
            goto L67
        L68:
            r24 = null;
            goto L70
        L130:
            if (Intrinsics.areEqual((Boolean) r20.h0().getBigSaleMoveToTop().getValue(), r7) == false) goto L171;
            ECShopDiscountFilterPresenter r48 = this.a;
            Iterator r49 = ((ArrayList) r48.g).iterator();
        L133:
            if (r49.hasNext() == false) goto L135;
            r48.k.removeView((ECTagListView) r49.next());
            goto L133
        L135:
            ((ArrayList) r48.g).clear();
            List r112 = r11.a;
            if (r112 == null) goto L172;
            Iterator<T> r113 = r112.iterator();
        L139:
            if (r113.hasNext() == false) goto L175;
            T r50 = r113.next();
            int r51 = r0 + 1;
            if (r0 >= 0) goto L143;
            CollectionsKt.throwIndexOverflow();
        L143:
            com.bytedance.android.ec.store.repository.dto.c r52 = (com.bytedance.android.ec.store.repository.dto.c) r50;
            if (r52.b() == null) goto L149;
            if (r52.d() == null) goto L149;
            r48.d0(r0, r52);
        L149:
            r0 = r51;
            goto L139
        L175:
            return;
        L172:
            return;
        L171:
            return;
        L173:
            return;
        L18:
            if (this.a.h0().getMiddleCouponFilterVO() == null) goto L21;
        L12:
            if (r4.isEmpty() == true) goto L15;
            r5 = false;
            goto L16
        L8:
            r3 = null;
            goto L9
        L5:
            if (this.a.h0().getMiddleCouponFilterVO() == null) goto L21;
            goto L6
        }
    }

    public final ECShopHybridProductViewModel h0() {
        return (ECShopHybridProductViewModel) this.h.getValue();
    }

    public final void i0() {
        Iterator<com.bytedance.android.ec.store.repository.dto.c> r0 = h0().getFilterSelectButtons().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().f(Boolean.FALSE);
        goto L4
    }

    public final void b0(QModel r4) {
        h0().getDiscountButton().a(ECQuickUtilKt.a(Y()), new b(this), true);
    }

    public final void j0(int r8) {
        h0().refreshSelectStatus(r8);
        Iterator r9 = ((ArrayList) this.g).iterator();
        int r0 = 0;
    L4:
        if (r9.hasNext() == false) goto L21;
        Object r1 = r9.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ECTagListView r3 = (ECTagListView) r1;
        com.bytedance.android.ec.store.repository.dto.c r4 = (com.bytedance.android.ec.store.repository.dto.c) CollectionsKt.getOrNull(h0().getSelectButtons(), r0);
        if (r4 == null) goto L20;
        dm.a.a("chenlong_hz_筛选").a("更新样式:" + r0 + ",isSelect:" + r4.e());
        if (Intrinsics.areEqual(r4.e(), Boolean.TRUE) == false) goto L16;
        ECTagListDTO r5 = r4.b();
        if (r5 == null) goto L20;
        r3.l(r5);
        goto L20
    L16:
        if (Intrinsics.areEqual(r4.e(), Boolean.FALSE) == false) goto L20;
        ECTagListDTO r6 = r4.d();
        if (r6 == null) goto L20;
        r3.l(r6);
    L20:
        r0 = r2;
        goto L4
    }

    public final void d0(int r11, com.bytedance.android.ec.store.repository.dto.c r12) {
        if (r11 < this.i) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r3 = null;
        ECTagListView r1 = new ECTagListView(Y().c(), null, 6, 0);
        ((ArrayList) this.g).add(r1);
        a r0 = new a(this, r12, r11);
        int r2 = ((qc3.a.a - com.bytedance.android.shopping.extensions.b.b(24)) - ((this.i - 1) * com.bytedance.android.shopping.extensions.b.b(8))) / this.i;
        com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d));
        r1.setOnClickListener(r0);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -2);
        r4.weight = 1.0f;
        if (this.i <= 1) goto L9;
        if (r11 <= 0) goto L9;
        int r13 = com.bytedance.android.shopping.extensions.b.b(9);
    L10:
        r4.setMargins(r13, 0, 0, com.bytedance.android.shopping.extensions.b.b(0));
        this.k.addView(r1, r4);
        ViewGroup.LayoutParams r14 = this.k.getLayoutParams();
        if ((r14 instanceof FrameLayout.LayoutParams) == false) goto L14;
        r3 = r14;
    L14:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r3;
        if (r5 == null) goto L22;
        if (Intrinsics.areEqual((Boolean) this.j.isBrandShop().getValue(), Boolean.TRUE) == false) goto L19;
        int r15 = 8;
    L20:
        r5.bottomMargin = com.bytedance.android.shopping.extensions.b.b(r15);
        r5.rightMargin = com.bytedance.android.shopping.extensions.b.b(8);
        r5.leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
        this.k.setLayoutParams(r5);
        goto L22
    L19:
        r15 = 12;
    L22:
        if (Intrinsics.areEqual(r12.e(), Boolean.TRUE) == false) goto L26;
        ECTagListDTO r6 = r12.b();
        if (r6 == null) goto L30;
        ECTagListView.c(r1, r6, null, null, null, null, null, 62);
        return;
    L30:
        return;
    L26:
        ECTagListDTO r7 = r12.d();
        if (r7 == null) goto L32;
        ECTagListView.c(r1, r7, null, null, null, null, null, 62);
        return;
    L32:
        return;
    L9:
        r13 = 0;
        goto L10
    }

    public ECShopDiscountFilterPresenter(ECStoreViewModel r2, Fragment r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "storeViewModel");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "root");
        super(r3);
        this.j = r2;
        this.k = r4;
        this.g = new ArrayList();
        this.h = LazyKt.lazy(new ECShopDiscountFilterPresenter$viewModel$2(this));
    }

    public final void e0(String r5, String r6, String r7) {
        Map<String, String> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("store_type", "shop"), TuplesKt.to("author_id", h0().getStoreParam().getStoreAccountParam().getUserId()), TuplesKt.to("shop_id", h0().getStoreParam().getShopId()), TuplesKt.to("follow_status", String.valueOf(h0().getStoreParam().getFollowStatus())), TuplesKt.to("entrance_location", h0().getStoreParam().getEntranceLocation()), TuplesKt.to("store_source_page", h0().getStoreParam().getStoreSourcePage()), TuplesKt.to("store_source_method", h0().getStoreParam().getStoreSourceMethod()), TuplesKt.to("store_group_type", h0().getStoreParam().getStoreGroupType()), TuplesKt.to("tab_name", "products")});
        if (r6 == null) goto L8;
        Map<String, String> r8 = com.bytedance.android.shopping.store.hybridproduct.presenter.a.a(r6);
        if (r8 == null) goto L8;
        r0.putAll(r8);
    L8:
        if (Intrinsics.areEqual(r5, "click_discount_filter_button") == false) goto L10;
        r0.put("click_type", r7);
    L10:
        h0().doEventAction(r5, r0, new Pair[0]);
    }
}
