package com.bytedance.android.shopping.store.search.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.search.activity.ECShopSearchActivity;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchResultViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSearchResultTopBarPresenter extends QPresenter {
    public final Lazy e;
    public final Fragment f;

    public final ShopSearchResultViewModel F() {
        return (ShopSearchResultViewModel) this.e.getValue();
    }

    public ShopSearchResultTopBarPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.f = r2;
        this.e = LazyKt.lazy(new ShopSearchResultTopBarPresenter$viewModel$2(this));
    }

    public static final void D(ShopSearchResultTopBarPresenter r3) {
        r3.F().getSearchParam().setSearchKeyword("");
        Intent r0 = new Intent(r3.u().c(), ECShopSearchActivity.class);
        ECShopSearchParam r1 = r3.F().getSearchParam();
        if (r1 == null) goto L9;
        r0.putExtra("search_param", r1);
        ContextCompat.startActivity(r3.u().c(), r0, null);
        Activity r4 = com.bytedance.android.ec.core.utils.l0.b(r3.u().c());
        if (r4 == null) goto L10;
        r4.finish();
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.io.Serializable");
    }

    public final void A(QModel r11) {
        ((ImageView) y().findViewById(2131367526)).setOnClickListener(new r(this));
        if (F().getSearchParam().isSplitMode() == false) goto L13;
        View r12 = y().findViewById(2131367530);
        if (r12 == null) goto L7;
        d2.d(r12, 0, ExtensionsKt.getDp(8), 0, ExtensionsKt.getDp(8));
    L7:
        View r13 = y().findViewById(2131367528);
        if (r13 == null) goto L10;
        d2.d(r13, 0, 0, ExtensionsKt.getDp(8), 0);
    L10:
        View r14 = y().findViewById(2131367526);
        if (r14 == null) goto L13;
        d2.d(r14, ExtensionsKt.getDp(7), 0, ExtensionsKt.getDp(0), 0);
    L13:
        View r15 = y().findViewById(2131371063);
        if (F().getSearchParam().isSplitMode() == false) goto L16;
        ExtensionsKt.visible(r15);
        r15.setOnClickListener(new s(this));
    L16:
        View r16 = y().findViewById(2131367519);
        r16.setVisibility(8);
        r16.setOnClickListener(new t(this));
        View r17 = y().findViewById(2131367518);
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == true) goto L19;
        r17.setVisibility(0);
        F().doAnyEventActionWithBtm("a1.b7881.c59185.d28713", PageFinder.via(r17), "photo_search_icon_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("entrance_info", F().getSearchParam().getEntranceInfo()), TuplesKt.to("current_page", "shop_search_page")}), new Pair[0]);
    L20:
        r17.setOnClickListener(new u(r17, this));
        TextView r18 = (TextView) y().findViewById(2131367525);
        r18.setText(F().getSearchParam().getSearchKeyword());
        F().getData().putExtra("sug_enter_type", 1);
        r18.setOnClickListener(new v(this));
        View r19 = y().findViewById(2131387282);
        if (r19 == null) goto L24;
        int r1 = com.bytedance.android.ec.core.utils.j.a;
        com.bytedance.android.ec.core.utils.j.a.a(r19);
        return;
    L24:
        return;
    L19:
        r17.setVisibility(8);
        goto L20
    }

    public static final void E(ShopSearchResultTopBarPresenter r5, int r6) {
        r5.F().setMToNewPage(false);
        r5.F().getData().putExtra("sug_gap_time", SystemClock.elapsedRealtime() - r5.F().getMRecordTime());
        Activity r0 = com.bytedance.android.ec.core.utils.l0.b(r5.u().c());
        if (r0 == null) goto L5;
        r0.setResult(r6, r5.F().getData());
    L5:
        Activity r7 = com.bytedance.android.ec.core.utils.l0.b(r5.u().c());
        if (r7 == null) goto L9;
        r7.finish();
        return;
    }
}
