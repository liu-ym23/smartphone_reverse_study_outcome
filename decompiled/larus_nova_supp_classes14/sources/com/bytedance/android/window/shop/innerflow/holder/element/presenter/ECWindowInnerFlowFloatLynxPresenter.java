package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.repo.ECWindowInnerFlowApi;
import com.bytedance.android.window.shop.innerflow.repo.ECWindowInnerFlowComponentDTO;
import com.bytedance.android.window.shop.innerflow.util.WindowInnerFlowComponentType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowFloatLynxPresenter extends QPresenter {
    public static final /* synthetic */ int i = 0;
    public final List<String> e;
    public final Lazy f;
    public final ECWindowInnerFlowFloatLynxPresenter$jsShowFollowToastEventSubscriber$1 g;
    public final b h;

    public static final class a {
    }

    public static final class b implements j {
        public b() {
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            s0.a(new bp3.b(r2.optInt("follow_status")));
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowInnerFlowFloatLynxPresenter a;

        public c(ECWindowInnerFlowFloatLynxPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            if (((Boolean) r5).booleanValue() == false) goto L15;
            ECWindowInnerFlowFloatLynxPresenter r6 = this.a;
            r6.getClass();
            ECWindowInnerFlowApi.a.getClass();
            ECWindowInnerFlowApi r0 = ECWindowInnerFlowApi.a.a;
            if (r0 == null) goto L13;
            Observable<ECWindowInnerFlowComponentDTO> r1 = r0.getInnerFlowComponent(r6.G().getInnerFlowParam().b, WindowInnerFlowComponentType.FOLLOWTOAST.getType(), "");
            if (r1 == null) goto L13;
            Observable r2 = bg4.b.b(r1);
            if (r2 == null) goto L13;
            Disposable r3 = r2.subscribe(new f(r6), g.a);
            if (r3 == null) goto L13;
            com.bytedance.android.ec.core.async.a.a(r3, r6.G());
        L13:
            ECLiveHybridUtil.m("ecom.store.create_float_lynx_container", this.a.g);
            ECLiveHybridUtil.m("ecom.shop.follow_status_update", this.a.h);
            return;
        }
    }

    static {
    }

    public final ECWindowInnerFlowViewModel G() {
        return (ECWindowInnerFlowViewModel) this.f.getValue();
    }

    public final void C() {
        ECLiveHybridUtil.p("ecom.store.create_float_lynx_container", this.g);
        ECLiveHybridUtil.p("ecom.shop.follow_status_update", this.h);
    }

    public ECWindowInnerFlowFloatLynxPresenter() {
        this.e = new ArrayList();
        this.f = LazyKt.lazy(new ECWindowInnerFlowFloatLynxPresenter$viewModel$2(this));
        this.g = new ECWindowInnerFlowFloatLynxPresenter$jsShowFollowToastEventSubscriber$1(this);
        this.h = new b();
    }

    public static final Map E(ECWindowInnerFlowFloatLynxPresenter r18) {
        com.bytedance.android.window.shop.innerflow.b r0 = r18.G().getInnerFlowParam();
        LinkedHashMap r1 = new LinkedHashMap();
        MapsKt.toMap(ECWindowInnerFlowViewModel.getParamPairs$default(r18.G(), new String[]{"author_id", "sec_author_id", "entrance_location", "enter_from", "shop_name", "is_preview", "follow_status", "search_params", "store_source_page", "store_source_method", "store_group_type", "shop_id", "sec_shop_id", "token", "pass_through_api"}, null, 2, null), r1);
        r1.put("inner_flow_type", String.valueOf(r18.G().getInnerFlowParam().c));
        r1.put("store_type", "window");
        r0.getClass();
        Intrinsics.checkNotNullParameter("pass_through_hybrid", "key");
        JSONObject r2 = z1.g(r0.a.get("pass_through_hybrid"));
        if (r2 != null) goto L5;
        r2 = new JSONObject();
    L5:
        r1.put("pass_through_hybrid", r2);
        return r1;
    }

    public final void A(QModel r3) {
        G().getLynxModuleStatus().b(ECQuickUtilKt.a(u()), new c(this));
    }

    public static final Map D(ECWindowInnerFlowFloatLynxPresenter r3, List r4, String r5, int r6) {
        r3.getClass();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        Object r0 = r8.next();
        io.a r1 = (io.a) r0;
        if (Intrinsics.areEqual(r1.d, r5) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L4;
        r7.add(r0);
        goto L4
    L8:
        if (r1.e != r6) goto L10;
        r2 = true;
        goto L11
    L13:
        LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator r10 = r7.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        r9.put(((io.a) r11).d, r11);
        goto L15
    L17:
        return r9;
    }

    public static final void F(ECWindowInnerFlowFloatLynxPresenter r9, io.a r10, String r11, String r12, int r13, String r14) {
        r9.getClass();
        if (r10 == null) goto L5;
        r10.g++;
        jo.a r15 = jo.a.a;
        bg4.b.b(jo.a.c(r10)).subscribe();
        return;
    L5:
        io.a r16 = new io.a(0, r11, r.a.f(), r12, r13, r14, 1);
        jo.a r17 = jo.a.a;
        bg4.b.b(jo.a.a(r16)).subscribe();
    }
}
