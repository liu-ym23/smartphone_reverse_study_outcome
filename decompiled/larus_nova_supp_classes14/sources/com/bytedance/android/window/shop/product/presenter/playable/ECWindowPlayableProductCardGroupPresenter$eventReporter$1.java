package com.bytedance.android.window.shop.product.presenter.playable;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.product.presenter.baseinf.EventTags;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.tab.event.WindowProductTagShowEvent;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import yo.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowPlayableProductCardGroupPresenter$eventReporter$1 implements f {
    public final Set<EventTags> a;
    public final Set<EventTags> b;
    public final /* synthetic */ ECWindowPlayableProductCardGroupPresenter c;
    public final /* synthetic */ WindowLayoutType d;

    public final Set<EventTags> a() {
        return this.b;
    }

    public ECWindowPlayableProductCardGroupPresenter$eventReporter$1(ECWindowPlayableProductCardGroupPresenter r2, WindowLayoutType r3) {
        this.c = r2;
        this.d = r3;
        Set<EventTags> r4 = SetsKt.mutableSetOf(new EventTags[]{EventTags.SECKILL_INFO});
        this.a = r4;
        this.b = r4;
    }

    public final void b(WindowV2ProductItemVO r12, List<ECRitTag> r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r13, "ritTagList");
        Intrinsics.checkNotNullParameter(r14, "eventParams");
        String r2 = this.c.l0(r12);
        BtmItemBuilder r0 = new BtmItemBuilder(r2, Boolean.FALSE).withBtmPage(this.c.p.getValue());
        BcmParams r1 = new BcmParams();
        r1.put("category_id", this.c.m0().getLastCategoryId());
        Unit r3 = Unit.INSTANCE;
        r0.internalSetUnitParams("description", r1);
        this.c.q.putAll(r14);
        Integer r4 = (Integer) r12.C.a(wn.a.f);
        if (r4 != null) goto L6;
    L8:
        boolean r5 = false;
    L9:
        int r6 = ECWindowPlayableProductCardGroupPresenter.v;
        ECWindowViewModel r7 = this.c.n0();
        BaseWindowTabViewModel r8 = this.c.m0();
        WindowLayoutType r9 = this.d;
        String r10 = this.c.m0().getLastCategoryId();
        if (r10 != null) goto L13;
        r10 = null;
    L13:
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        Map r11 = ECWindowPlayableProductCardGroupPresenter.a.a(r7, r8, r12, r9, r10);
        int r15 = WindowBstReport.a;
        View r16 = this.c.a0();
        WindowLayoutType r17 = this.d;
        if (r5 == false) goto L18;
        Map r18 = MapsKt.plus(r14, r11);
    L19:
        WindowBstReport.i(r16, r2, r12, r17, r18, this.c.n0(), this.c.m0());
        if (this.c.m0().shouldReportEvent(wn.a.g, r12.a) == true) goto L22;
        return;
    L22:
        String r19 = (String) r12.C.a(wn.a.d);
        if (r19 != null) goto L25;
        r19 = "product_card";
    L25:
        Iterator<T> r110 = r13.iterator();
    L27:
        if (r110.hasNext() == false) goto L29;
        new WindowProductTagShowEvent(true, ((ECRitTag) r110.next()).getTrackParam(), r19, r12).with(new BaseEventContext[]{this.c.n0().getWindowEventContext(), this.c.m0().getWindowTabEventContext()}).post(null, null);
        goto L27
    L29:
        this.c.m0().runLowPriorityTask(new ECWindowPlayableProductCardGroupPresenter$eventReporter$1$reportShow$1(this));
        return;
    L18:
        r18 = r11;
        goto L19
    L6:
        if (r4.intValue() != 210) goto L8;
        r5 = true;
        goto L9
    }
}
