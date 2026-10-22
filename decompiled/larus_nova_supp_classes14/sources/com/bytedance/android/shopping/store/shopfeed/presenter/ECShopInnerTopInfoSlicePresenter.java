package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory;
import com.bytedance.android.shopping.store.slicecard.ShopSlcTemplateManager;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopInnerTopInfoSlicePresenter extends QPresenter {
    public final Lazy e;
    public r f;
    public final Lazy g;
    public final Fragment h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECShopInnerTopInfoSlicePresenter a;

        public a(ECShopInnerTopInfoSlicePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            fk3.a r11 = (fk3.a) r10;
            ECShopInnerTopInfoSlicePresenter r0 = this.a;
            r0.getClass();
            ShopSliceItemConfig r1 = r11.e;
            if (r1 == null) goto L5;
            r0.D().getSliceService().d(MapsKt.mapOf(TuplesKt.to(SliceItemType.SHOP_INNER_FLOW_TOP_BAR.getType(), r1)));
        L5:
            ShopSlcCardFactory r2 = r0.D().getSliceCardFactory();
            ShopSliceItemConfig r3 = r11.e;
            View r4 = null;
            if (r3 == null) goto L12;
            List<SliceTemplate> r5 = r3.getTemplates();
            if (r5 == null) goto L12;
            SliceTemplate r6 = (SliceTemplate) CollectionsKt.firstOrNull(r5);
            if (r6 == null) goto L12;
            String r7 = r6.getName();
        L13:
            r2.getClass();
            com.bytedance.android.ec.store.setting.j r8 = ShopSlcTemplateManager.a;
            boolean r9 = true;
            if (r7 != null) goto L16;
        L19:
            boolean r12 = true;
        L20:
            if (r12 == true) goto L32;
            ShopSliceItemConfig r13 = ShopSlcTemplateManager.i.get(SliceItemType.SHOP_INNER_FLOW_TOP_BAR.getType());
            if (r13 == null) goto L32;
            Iterator<T> r14 = r13.getTemplates().iterator();
        L26:
            if (r14.hasNext() == false) goto L30;
            T r15 = r14.next();
            if (Intrinsics.areEqual(((SliceTemplate) r15).getName(), r7) == false) goto L26;
        L31:
            SliceTemplate r16 = r15;
        L33:
            r r17 = r2.f(r16);
            if (r17 != null) goto L40;
            dm.a.b r18 = dm.a.a("ShopSlcProductCardFactory");
            StringBuilder r19 = new StringBuilder("createInnerFlowTopBarCard, viewInfo is null, context is null = ");
            if (r2.a == null) goto L39;
            r9 = false;
        L39:
            r19.append(r9);
            r18.b(r19.toString(), null);
        L40:
            r0.f = r17;
            View r20 = r0.y();
            if (r20 == null) goto L69;
            ViewGroup r21 = (ViewGroup) r20;
            r r22 = r0.f;
            if (r22 == null) goto L45;
            r4 = r22.c;
        L45:
            r21.addView(r4);
            r r23 = r0.f;
            if (r23 == null) goto L48;
            r23.b((ECShopInnerTopInfoSlicePresenter$slcActionHandler$2.a) r0.g.getValue());
        L48:
            ECShopInnerTopInfoSlicePresenter r24 = this.a;
            r24.getClass();
            if (r11.a == null) goto L66;
            r r25 = r24.f;
            if (r25 == null) goto L66;
            LinkedHashMap r26 = new LinkedHashMap();
            LinkedHashMap r27 = new LinkedHashMap();
            Map<String, Object> r28 = r11.a;
            if (r28 == null) goto L56;
            r27.putAll(r28);
        L56:
            HashMap r29 = new HashMap();
            Map<String, Object> r30 = r11.b;
            if (r30 == null) goto L59;
            r29.putAll(r30);
        L59:
            Unit r31 = Unit.INSTANCE;
            r27.put("slice_item_extra", r29);
            HashMap r32 = new HashMap();
            Map<String, Object> r33 = r11.d;
            if (r33 == null) goto L62;
            r32.putAll(r33);
        L62:
            r27.put("slice_item_states", r32);
            HashMap r34 = new HashMap();
            Map<String, Object> r110 = r11.c;
            if (r110 == null) goto L65;
            r34.putAll(r110);
        L65:
            r27.put("slice_item_actions", r34);
            r26.put("data", r27);
            r25.a(r26, ShopSliceUniqueId.SHOP_INNER_FLOW_TOP_BAR.getId());
        L66:
            this.a.getClass();
            return;
        L69:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L30:
            r15 = (T) null;
        L32:
            r16 = null;
            goto L33
        L16:
            if (r7.length() == 0) goto L19;
            r12 = false;
        L12:
            r7 = null;
            goto L13
        }
    }

    public final ECShopFeedViewModel D() {
        return (ECShopFeedViewModel) this.e.getValue();
    }

    public ECShopInnerTopInfoSlicePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.h = r2;
        this.e = LazyKt.lazy(new ECShopInnerTopInfoSlicePresenter$viewModel$2(this));
        this.g = LazyKt.lazy(new ECShopInnerTopInfoSlicePresenter$slcActionHandler$2(this));
    }

    public final void A(QModel r9) {
        D().getTopInfo().b(u().e(), new a(this));
        D().doAnyEventActionWithBtm("a1.b66972", PageFinder.via(this.h), "page_view", MapsKt.mapOf(TuplesKt.to("page_name", "shop_live_replay")), new Pair[0]);
    }
}
