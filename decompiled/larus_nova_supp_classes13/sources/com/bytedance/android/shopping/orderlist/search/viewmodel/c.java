package com.bytedance.android.shopping.orderlist.search.viewmodel;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonRepository;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.android.shopping.orderlist.search.request.OrderSearchResultApiRequestExtKt;
import com.bytedance.android.shopping.orderlist.search.starter.OrderSearchResultParams;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final OrderSearchResultViewModel a;

    public c(OrderSearchResultViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(OrderSearchResultActivity r17, final boolean r18, final boolean r19, boolean r20, Function1 r21, Function0 r22) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Lazy r5 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultRequestUseCase", new OrderSearchResultRequestUseCase$doQuery$1(r18, r19));
        int r6 = OrderCommonRepository.a;
        lg3.a r7 = this.a.getTracker();
        String r8 = null;
        if (r18 == false) goto L18;
        Map<String, Object> r9 = OrderSearchResultApiRequestExtKt.c(this.a.getStaticState().g);
        com.bytedance.android.btm.api.model.d r2 = new com.bytedance.android.btm.api.model.d();
        r2.a = "a1.b5418.c36711.d543737";
        if ((r17 instanceof OrderSearchResultActivity) == true) goto L7;
        Object r10 = null;
    L8:
        r2.b = PageFinder.via(r10);
        r2.c = new BcmParams();
        OrderSearchResultParams r11 = this.a.getStaticState().g;
        if (r11 == null) goto L11;
        boolean r12 = r11.isHideGul();
    L12:
        JSONObject r13 = EcomBcmTracker.e(r2, new JSONObject());
        String r14 = this.a.getStaticState().c;
        String r15 = EcomBcmTracker.g(r2);
        OrderSearchResultParams r3 = this.a.getStaticState().g;
        if (r3 == null) goto L16;
        Map<String, String> r4 = r3.getSchemaParamsMap();
        if (r4 == null) goto L16;
    L17:
        Map<String, Object> r16 = OrderSearchResultApiRequestExtKt.b(r9, r12, r13, r14, r15, r4, this.a.getStaticState().d, this.a.getStaticState().e);
    L21:
        if (r19 == false) goto L30;
        Object r1 = d0.a.getActivity(r17);
        if ((r1 instanceof OrderSearchResultActivity) == true) goto L25;
        r1 = null;
    L25:
        OrderSearchResultActivity r23 = (OrderSearchResultActivity) r1;
        if (r23 == null) goto L30;
        AndroidYaTaInstance r24 = r23.n;
        if (r24 == null) goto L30;
        r8 = r24.m();
    L30:
        PackYataSdkConfig r25 = com.bytedance.kmp.ec.yata.common.init.b.a;
        OrderCommonRepository.b(OrderCommonRepository.a(r7, new OrderCommonYataRequest(r16, r8, "1.23.7")), this.a.getTracker(), OrderSearchResultRequestUseCase$doQuery$2.INSTANCE, OrderSearchResultRequestUseCase$doQuery$3.INSTANCE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r21, r22), new b(r22));
        return;
    L16:
        r4 = MapsKt.emptyMap();
        goto L17
    L11:
        r12 = false;
        goto L12
    L7:
        r10 = r17;
        goto L8
    L18:
        if (r20 == false) goto L20;
        r16 = OrderSearchResultApiRequestExtKt.a(this.a.getStaticState().c, this.a.getStaticState().d, this.a.getStaticState().e);
        goto L21
    L20:
        r16 = null;
        goto L21
    }
}
