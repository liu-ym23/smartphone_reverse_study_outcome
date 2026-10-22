package com.bytedance.android.window.shop.holder.presenter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.window.shop.home.tab.WindowTabViewModelDeprecated;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.WindowTabRequestParam;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/holder/presenter/WindowHotsaleLiveOrderItemPresenter;", "Lcom/bytedance/android/window/shop/holder/presenter/ECWindowHolderBaseFragmentPresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onDestroy", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleLiveOrderItemPresenter extends ECWindowHolderBaseFragmentPresenter implements View.OnClickListener, LifecycleObserver {
    public sq3.g i;
    public boolean j;
    public final String k;

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.j == false) goto L5;
        ShopRepository r0 = ShopRepository.a;
        WindowTabRequestParam r1 = new WindowTabRequestParam();
        r1.setSecAuthorId(d0().getShopParam().getSecAuthorId());
        r1.setTabType(300);
        int r2 = zq3.d.a;
        r1.setEcExtra(zq3.d.a(d0().getShopParam(), d0().getEntranceInfoJsonObject()));
        Unit r3 = Unit.INSTANCE;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "reqParam");
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(kq3.a.c(r1)).subscribe(new u(this), v.a), Y().g(WindowTabViewModelDeprecated.class));
    L5:
        this.j = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        e0().getLifecycle().removeObserver(this);
    }

    public WindowHotsaleLiveOrderItemPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.k = "c3406.d99860";
    }

    public final void b0(QModel r7) {
        if ((r7 instanceof sq3.g) == true) goto L5;
        r7 = null;
    L5:
        sq3.g r8 = (sq3.g) r7;
        if (r8 == null) goto L22;
        this.i = r8;
        ((TextView) Z().b(2131374551).f()).setText(r8.j);
        LinearLayout r0 = (LinearLayout) Z().b(2131374550).f();
        TextView r2 = (TextView) Z().b(2131391046).f();
        Integer r3 = r8.l;
        if (r3 != null) goto L11;
    L13:
        r2.setText(ag4.a.d(2131896780));
        r2.setTextColor(ResourcesCompat.getColor(r2.getContext().getResources(), 2131101747, null));
    L14:
        Integer r9 = r8.l;
        if (r9 != null) goto L18;
    L20:
        r0.setBackgroundResource(2131247924);
        Z().b(2131363242).f().setBackgroundResource(2131234721);
    L21:
        a0().setOnClickListener(this);
        ECWindowViewModel r10 = d0();
        int r1 = com.bytedance.android.ec.window.base.utils.i.a;
        r10.doEventAction("show_live_appointment", new Pair[]{TuplesKt.to("author_id", d0().getShopParam().getAuthorId()), TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation()), TuplesKt.to("page_name", "store_page"), TuplesKt.to("store_type", "window"), com.bytedance.android.ec.window.base.utils.i.a(this.k, false)});
        goto L22
    L18:
        if (r9.intValue() != 1) goto L20;
        r0.setBackgroundResource(2131247923);
        Z().b(2131363242).f().setBackgroundResource(2131234720);
        goto L21
    L11:
        if (r3.intValue() != 1) goto L13;
        r2.setText(ag4.a.d(2131896743));
        r2.setTextColor(ResourcesCompat.getColor(r2.getContext().getResources(), 2131101182, null));
    L22:
        e0().getLifecycle().removeObserver(this);
        e0().getLifecycle().addObserver(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        Intrinsics.checkNotNullParameter(r7, "v");
        int r0 = rp.a.a;
        if (rp.a.a(r7.getId()) == false) goto L5;
        return;
    L5:
        sq3.g r8 = this.i;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVO");
    L8:
        String r9 = r8.m;
        if (com.bytedance.android.shopping.extensions.k.c(r9) == true) goto L12;
        r9 = null;
    L12:
        if (r9 == null) goto L16;
        this.j = true;
        com.bytedance.android.ec.sdk.helper.p r2 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r3 = Y().c();
        int r4 = zq3.f.a;
        r2.openSchema(r3, zq3.f.c(r9, this.k, PageFinder.via(((QFragmentPresenter) this).e), null));
        ECWindowViewModel r10 = d0();
        int r1 = com.bytedance.android.ec.window.base.utils.i.a;
        r10.doEventAction("click_live_appointment", new Pair[]{TuplesKt.to("author_id", d0().getShopParam().getAuthorId()), TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation()), TuplesKt.to("page_name", "store_page"), TuplesKt.to("store_type", "window"), com.bytedance.android.ec.window.base.utils.i.a(this.k, false)});
        return;
    }
}
