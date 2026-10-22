package com.bytedance.android.window.shop.product.presenter.group;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.product.presenter.baseinf.EventTags;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.WindowTabEventContext;
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
public final class ECWindowProductCardGroupPresenterBase$eventReporter$1 implements f {
    public final Set<EventTags> a;
    public final Set<EventTags> b;
    public final /* synthetic */ ECWindowProductCardGroupPresenterBase c;
    public final /* synthetic */ WindowLayoutType d;

    public final Set<EventTags> a() {
        return this.b;
    }

    public ECWindowProductCardGroupPresenterBase$eventReporter$1(ECWindowProductCardGroupPresenterBase r2, WindowLayoutType r3) {
        this.c = r2;
        this.d = r3;
        Set<EventTags> r4 = SetsKt.mutableSetOf(new EventTags[]{EventTags.SECKILL_INFO});
        this.a = r4;
        this.b = r4;
    }

    public final void b(WindowV2ProductItemVO r8, List<ECRitTag> r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "ritTagList");
        Intrinsics.checkNotNullParameter(r10, "eventParams");
        ECWindowProductCardGroupPresenterBase.a r1 = ECWindowProductCardGroupPresenterBase.w;
        ECWindowViewModel r2 = this.c.o0();
        BaseWindowTabViewModel r3 = this.c.n0();
        WindowLayoutType r5 = this.d;
        String r0 = ECWindowProductCardGroupPresenterBase.k0(this.c);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        MapsKt.plus(r10, ECWindowProductCardGroupPresenterBase.a.b(r1, r2, r3, r8, r5, r0));
        BtmItemBuilder r4 = new BtmItemBuilder(ECWindowProductCardGroupPresenterBase.l0(this.c, r8), Boolean.FALSE).withBtmPage(this.c.r.getValue());
        BcmParams r6 = new BcmParams();
        r6.put("category_id", this.c.n0().getLastCategoryId());
        Unit r7 = Unit.INSTANCE;
        r4.internalSetUnitParams("description", r6);
        BtmSDK.INSTANCE.obtainEventBtmParams(r4.build());
        if (this.c.n0().shouldReportEvent(wn.a.g, r8.a) == true) goto L8;
        return;
    L8:
        String r11 = this.c.m0();
        Iterator<T> r12 = r9.iterator();
    L10:
        if (r12.hasNext() == false) goto L18;
        WindowProductTagShowEvent r13 = new WindowProductTagShowEvent(false, ((ECRitTag) r12.next()).getTrackParam(), r11, r8);
        BaseEventContext[] r14 = new BaseEventContext[2];
        r14[0] = this.c.o0().getWindowEventContext();
        BaseWindowTabViewModel r15 = this.c.n0();
        if ((r15 instanceof BaseWindowTabViewModel) == true) goto L14;
        r15 = null;
    L14:
        if (r15 == null) goto L16;
        WindowTabEventContext r16 = r15.getWindowTabEventContext();
    L17:
        r14[1] = r16;
        r13.with(r14).post(null, null);
        goto L10
    L16:
        r16 = null;
        goto L17
    L18:
        this.c.q.putAll(r10);
        int r17 = WindowBstReport.a;
        WindowBstReport.i(this.c.a0(), ECWindowProductCardGroupPresenterBase.l0(this.c, r8), r8, this.d, r10, this.c.o0(), this.c.n0());
        this.c.n0().runLowPriorityTask(new ECWindowProductCardGroupPresenterBase$eventReporter$1$reportShow$1(this));
    }
}
