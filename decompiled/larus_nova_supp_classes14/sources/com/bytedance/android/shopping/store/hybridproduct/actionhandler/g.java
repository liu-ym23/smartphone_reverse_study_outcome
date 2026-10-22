package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.store.repository.dto.o;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.l;
import com.bytedance.android.ec.store.repository.vo.m;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.hybridproduct.dto.SubscribeProductRes;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.tools.ECToastUtils;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.services.apm.api.EnsureManager;
import dj3.i;
import dj3.j;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements com.bytedance.android.shopping.store.slicecard.a {
    public l a;
    public ShopSlcProductItemV2 b;
    public h c;
    public final d d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ View b;

        public a(g r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r15) {
            SubscribeProductRes r16 = (SubscribeProductRes) r15;
            if (r16 != null) goto L5;
            return;
        L5:
            if (r16.getStatusCode() != 0) goto L65;
            Map<String, i> r17 = r16.getSuccessRes();
            if (r17 == null) goto L63;
            h r0 = this.a.c;
            String r1 = null;
            if (r0 == null) goto L12;
            String r2 = r0.a;
        L13:
            i r18 = r17.get(r2);
            if (r18 == null) goto L64;
            ECToastUtils.INSTANCE.showToast(this.b.getContext(), r18.c(), Boolean.FALSE);
            g r3 = this.a;
            l r4 = r3.a;
            if (r4 == null) goto L18;
            r4.U.put("product_is_appointed", Boolean.TRUE);
            d r5 = r3.d;
            r5.d(m.a(r4, r5.a()));
        L18:
            ShopSlcProductItemV2 r6 = r3.b;
            if (r6 == null) goto L24;
            r6.d.put("product_is_appointed", Boolean.TRUE);
            d r7 = r3.d;
            Map<String, Object> r8 = r7.a();
            Intrinsics.checkNotNullParameter(r6, "$this$dataCxt");
            LinkedHashMap r9 = new LinkedHashMap();
            r9.putAll(r6.d);
            if (r8 == null) goto L23;
            r9.putAll(r8);
        L23:
            LinkedHashMap r10 = new LinkedHashMap();
            r10.putAll(r6.a);
            r10.putAll(r6.b);
            r10.putAll(r6.c);
            r10.put("slice_item_states", r9);
            Unit r11 = Unit.INSTANCE;
            r7.d(MapsKt.mapOf(TuplesKt.to("data", r10)));
        L24:
            g r12 = this.a;
            View r13 = this.b;
            r12.getClass();
            Activity r14 = l0.b(r13.getContext());
            if (r14 == null) goto L47;
            boolean r19 = ECServiceManager.a;
            IECHostService r20 = (IECHostService) ECServiceManager.c(IECHostService.class);
            if (r20 == null) goto L47;
            ej.c r21 = r20.getCalendarService();
            if (r21 == null) goto L47;
            h r22 = r12.c;
            if (r22 == null) goto L33;
            Long r23 = Long.valueOf(r22.c);
        L34:
            long r24 = k.h(r23);
            long r25 = ECDraweeView.SQUARE;
            long r26 = r24 * r25;
            h r27 = r12.c;
            if (r27 == null) goto L37;
            Long r28 = Long.valueOf(r27.c);
        L38:
            long r110 = k.h(r28) * r25;
            String r29 = k.j(r18.b());
            String r30 = k.j(r18.a());
            StringBuilder r111 = new StringBuilder();
            h r31 = r12.c;
            if (r31 == null) goto L41;
            String r32 = r31.a;
        L42:
            r111.append(k.j(r32));
            r111.append(":");
            h r33 = r12.c;
            if (r33 == null) goto L45;
            Long r34 = Long.valueOf(r33.c);
        L46:
            r111.append(r34);
            r111.append("shop");
            r21.a(r14, "bpea-ec_shop_new_product_calendar", new ej.a(r111.toString(), r29, r30, r26, r110, 96), new f());
            goto L47
        L45:
            r34 = null;
            goto L46
        L41:
            r32 = null;
            goto L42
        L37:
            r28 = null;
            goto L38
        L33:
            r23 = null;
        L47:
            g r112 = this.a;
            r112.getClass();
            Event r35 = new Event("ecom.shop.update_product_notify_status", System.currentTimeMillis(), null, 4, null);
            Pair[] r36 = new Pair[4];
            h r37 = r112.c;
            if (r37 == null) goto L50;
            String r38 = r37.a;
        L51:
            String r39 = "";
            if (r38 != null) goto L54;
            r38 = "";
        L54:
            r36[0] = TuplesKt.to("product_id", r38);
            r36[1] = TuplesKt.to("from", "product_list");
            r36[2] = TuplesKt.to("status", "open");
            r36[3] = TuplesKt.to("sec_shop_id", r112.d.b());
            r35.setMapParams(MapsKt.mapOf(r36));
            EventCenter.enqueueEvent(r35);
            d r113 = this.a.d;
            Pair[] r40 = new Pair[2];
            r40[0] = TuplesKt.to("module_name", CommentServiceId.HOT_SPOT);
            h r41 = this.a.c;
            if (r41 == null) goto L57;
            r1 = r41.a;
        L57:
            if (r1 == null) goto L60;
            r39 = r1;
        L60:
            r40[1] = TuplesKt.to("element_id", r39);
            r113.c(MapsKt.mutableMapOf(r40));
            return;
        L50:
            r38 = null;
            goto L51
        L64:
            return;
        L12:
            r2 = null;
            goto L13
        L63:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            EnsureManager.ensureNotReachHere((Throwable) r2, "subscribe_product_error");
        }
    }

    public final void e(View r9) {
        ECStoreApi.a.getClass();
        ECStoreApi r1 = ECStoreApi.a.a;
        if (r1 == null) goto L19;
        String r2 = this.d.getShopId();
        h r4 = this.c;
        Long r5 = null;
        if (r4 == null) goto L7;
        String r6 = r4.a;
    L8:
        if (r4 == null) goto L10;
        String r7 = r4.b;
    L11:
        if (r4 == null) goto L13;
        r5 = Long.valueOf(r4.c);
    L13:
        Observable<SubscribeProductRes> r0 = r1.subscribeProduct(r2, new j(CollectionsKt.listOf(new dj3.b(r6, r7, r5))), "product_tab_timing_sale_product", "0", this.d.getPassThroughApi());
        if (r0 == null) goto L20;
        Observable r3 = bg4.b.b(r0);
        if (r3 == null) goto L21;
        r3.subscribe(new a(this, r9), b.a);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r7 = null;
        goto L11
    L7:
        r6 = null;
        goto L8
    }

    public g(d r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "behavior");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.d = r2;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void b(StoreV2ProductItemVO r7, View r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Intrinsics.checkNotNullParameter(r8, "target");
        if (this.d.isClickable() == true) goto L5;
        return;
    L5:
        l r10 = (l) r7;
        this.a = r10;
        Intrinsics.checkNotNullParameter(r10, "$this$toSubScribeVO");
        String r1 = ((StoreV2ProductItemVO) r10).a;
        String r2 = ((StoreV2ProductItemVO) r10).d;
        o r0 = ((StoreV2ProductItemVO) r10).t;
        if (r0 == null) goto L8;
        long r3 = r0.a();
    L9:
        h r11 = new h(r1, r2, r3, Intrinsics.areEqual(r10.U.get("product_is_appointed"), Boolean.TRUE));
        this.c = r11;
        if (r11.d != true) goto L12;
        return;
    L12:
        e(r8);
        return;
    L8:
        r3 = 0;
        goto L9
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void a(ShopSlcProductItemV2 r7, View r8, Map<String, ? extends Object> r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Intrinsics.checkNotNullParameter(r8, "target");
        if (this.d.isClickable() == true) goto L5;
        return;
    L5:
        this.b = r7;
        Intrinsics.checkNotNullParameter(r7, "$this$toSubScribeVO");
        h r11 = new h(r7.j, r7.r, r7.s, Intrinsics.areEqual(r7.d.get("product_is_appointed"), Boolean.TRUE));
        this.c = r11;
        if (r11.d != true) goto L8;
        return;
    L8:
        e(r8);
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
