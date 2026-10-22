package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$n;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$n;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$13 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.n, Unit> {
    public LivePromotionListGroupPresenter$observeData$13(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "logLiveListShowEvent", "logLiveListShowEvent(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$LogLiveListShowEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.n r8) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        LivePromotionListGroupPresenter r9 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        if (r9.n == true) goto L64;
        r9.n = true;
        if (r9.d0().isDefaultTab() == false) goto L8;
        String r1 = "livesdk_live_list_show";
    L9:
        String r2 = r9.d0().getParams().getExtraEntranceInfo();
        ECLivePerformanceMonitor r4 = null;
        if (r2 == null) goto L14;
        JSONObject r3 = z1.g(r2);
        if (r3 == null) goto L14;
        String r5 = r3.optString("preview_coupon_id");
    L15:
        sg2.v r6 = new sg2.v(r1, r9.d0().getPromotionListParams());
        if (r5 != null) goto L18;
    L26:
        r6.c("preview_coupon_id", "-1");
    L27:
        String r7 = r9.d0().getParams().getOpenMethod();
        if (r7 != null) goto L30;
        r7 = "other";
    L30:
        r6.c("live_list_from", r7);
        List<PromotionCategory> r10 = ((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.c) r9.d0().getState()).a;
        if (r10 != null) goto L33;
    L36:
        boolean r11 = true;
    L38:
        if (r11 == false) goto L40;
        String r12 = BDLocationException.ERROR_TIMEOUT;
    L41:
        r6.c("has_prd_tab", r12);
        r6.i(null);
        if (r9.d0().isDefaultTab() == false) goto L50;
        ECContext r13 = r9.i0().r();
        if (r13 == null) goto L48;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r14 = r13.getEcLivePerformanceMonitor();
        if (r14 == null) goto L48;
        r4 = (ECLivePerformanceMonitor) r14.getValue();
    L48:
        if (r4 == null) goto L50;
        ECLivePerformanceMonitor.A(r4, false, BDLocationException.ERROR_TIMEOUT, r9.a0(), 4);
    L50:
        xh.a r15 = xh.c.a("Live");
        Pair[] r16 = new Pair[2];
        int r17 = xh2.c.a;
        switch(r9.d0().getLatestRequestType()) {
            case 0: goto L61;
            case 1: goto L60;
            case 2: goto L59;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L56;
            case 6: goto L55;
            case 7: goto L54;
            case 8: goto L53;
            default: goto L52;
        };
    L52:
        String r18 = "";
    L62:
        r16[0] = TuplesKt.to("show_type", r18);
        r16[1] = TuplesKt.to("is_default_tab", String.valueOf(r9.d0().isDefaultTab()));
        r15.j("good_list", "good_list", MapsKt.mapOf(r16));
        return;
    L53:
        r18 = "update_list";
        goto L62
    L54:
        r18 = "select_tab";
        goto L62
    L55:
        r18 = "update_when_cache";
        goto L62
    L56:
        r18 = LocationMonitorConst.CACHE;
        goto L62
    L57:
        r18 = "refresh";
        goto L62
    L58:
        r18 = "back_from_other_page";
        goto L62
    L59:
        r18 = "explaining_change";
        goto L62
    L60:
        r18 = "list_change";
        goto L62
    L61:
        r18 = "normal";
        goto L62
    L40:
        r12 = "1";
        goto L41
    L33:
        if (r10.isEmpty() == true) goto L36;
        r11 = false;
        goto L38
    L18:
        if (r5.length() <= 0) goto L20;
        boolean r19 = true;
    L21:
        if (r19 == false) goto L23;
        String r20 = r5;
    L24:
        if (r20 == null) goto L26;
        r6.c("preview_coupon_id", r5);
        r6.c("preview_extra_info", "ecom");
        goto L27
    L23:
        r20 = null;
        goto L24
    L20:
        r19 = false;
    L14:
        r5 = null;
        goto L15
    L8:
        r1 = "livesdk_live_list_show_linkmic";
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.n) r1);
        return Unit.INSTANCE;
    }
}
