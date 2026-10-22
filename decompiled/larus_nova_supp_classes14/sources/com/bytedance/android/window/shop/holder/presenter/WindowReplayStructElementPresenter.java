package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.tab.event.WindowTabCommonEvent;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowReplayStructElementPresenter extends com.bytedance.android.ec.window.base.utils.quick.c<sq3.h> implements com.bytedance.android.window.shop.product.presenter.group.d {
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public uq3.s h;
    public sq3.h i;
    public final Fragment j;
    public final int k;

    public final void C() {
        this.h = null;
    }

    public final BaseWindowTabViewModel E() {
        return (BaseWindowTabViewModel) this.f.getValue();
    }

    @Override // com.bytedance.android.window.shop.product.presenter.group.d
    public final void a() {
        if (this.h == null) goto L12;
        sq3.h r0 = this.i;
        if (r0 == null) goto L13;
        fo.b r1 = ((WindowV2ProductItemVO) r0).C;
        if (r1 == null) goto L14;
        fo.a r2 = wn.a.a;
        Integer r3 = (Integer) r1.a(wn.a.C);
        if (r3 == null) goto L15;
        F("to_watch_explain_show", "a1.b7635.c68164.d15552_i" + r3.intValue());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void D(QModel r4) {
        sq3.h r5 = (sq3.h) r4;
        if (r5 == null) goto L5;
        uq3.s r0 = r5.U;
    L6:
        this.h = r0;
        this.i = r5;
        if (r0 != null) goto L11;
        View r6 = (View) this.e.getValue();
        if (r6 == null) goto L18;
        r6.setVisibility(8);
        return;
    L18:
        return;
    L11:
        View r1 = (View) this.e.getValue();
        if (r1 == null) goto L14;
        r1.setVisibility(0);
    L14:
        View r2 = (View) this.e.getValue();
        if (r2 == null) goto L20;
        r2.setOnClickListener(new w(this, r5, r0));
        return;
    L20:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public WindowReplayStructElementPresenter(Fragment r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.j = r2;
        this.k = r3;
        this.e = LazyKt.lazy(new WindowReplayStructElementPresenter$tagView$2(this));
        this.f = LazyKt.lazy(new WindowReplayStructElementPresenter$tabVm$2(this));
        this.g = LazyKt.lazy(new WindowReplayStructElementPresenter$shopViewModel$2(this));
    }

    public final void F(String r4, String r5) {
        ECWindowViewModel r0 = (ECWindowViewModel) this.g.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.h == null) goto L9;
        BaseMetricsEvent2 r6 = new WindowTabCommonEvent(r4, this.k).with(new BaseEventContext[]{r0.getWindowEventContext(), E().getWindowTabEventContext()});
        r6.appendParam("tab_name", E().getLastCategoryId());
        r6.appendParam("tab_name_second", E().getLastSubCategoryId());
        r6.appendParam("ecom_entrance_form_second", E().getLastSubCategoryId());
        r6.appendParam("ecom_entrance_form", E().getLastCategoryId());
        r6.post(PageFinder.via(this.j), r5);
        return;
    }
}
