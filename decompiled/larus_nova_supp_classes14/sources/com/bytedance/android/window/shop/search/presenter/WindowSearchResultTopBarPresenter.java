package com.bytedance.android.window.shop.search.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.window.shop.search.activity.ECWindowSearchActivity;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchResultViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowSearchResultTopBarPresenter extends QPresenter {
    public final Lazy e;
    public final Fragment f;

    public final WindowSearchResultViewModel F() {
        return (WindowSearchResultViewModel) this.e.getValue();
    }

    public WindowSearchResultTopBarPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.f = r2;
        this.e = LazyKt.lazy(new WindowSearchResultTopBarPresenter$viewModel$2(this));
    }

    public static final void D(WindowSearchResultTopBarPresenter r5) {
        r5.F().getSearchParam().setSearchKeyword("");
        Intent r0 = new Intent(r5.u().c(), ECWindowSearchActivity.class);
        ECWindowSearchParam r1 = r5.F().getSearchParam();
        if (r1 == null) goto L17;
        r0.putExtra("search_param", r1);
        Uri r2 = r5.F().getUri();
        if (r2 == null) goto L7;
        String r3 = UriProtector.getQueryParameter(r2, "entrance_info");
    L8:
        Uri r4 = r5.F().getUri();
        if (r4 == null) goto L11;
        String r6 = UriProtector.getQueryParameter(r4, "ec_shop_inner_info");
    L12:
        xn.c.f(r0, r3, z1.g(r6));
        ContextCompat.startActivity(r5.u().c(), r0, null);
        Activity r7 = l0.b(r5.u().c());
        if (r7 == null) goto L18;
        r7.finish();
        return;
    L18:
        return;
    L11:
        r6 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.io.Serializable");
    }

    public final void A(QModel r4) {
        ((ImageView) y().findViewById(2131367526)).setOnClickListener(new m(this));
        View r5 = y().findViewById(2131367519);
        r5.setVisibility(0);
        r5.setOnClickListener(new n(this));
        View r6 = y().findViewById(2131367518);
        r6.setVisibility(8);
        r6.setOnClickListener(new o(r6, this));
        TextView r7 = (TextView) y().findViewById(2131367525);
        r7.setText(F().getSearchParam().getSearchKeyword());
        F().getData().putExtra("sug_enter_type", 1);
        r7.setOnClickListener(new p(this));
        View r8 = y().findViewById(2131387282);
        if (r8 == null) goto L6;
        int r0 = com.bytedance.android.ec.core.utils.j.a;
        com.bytedance.android.ec.core.utils.j.a.a(r8);
        return;
    }

    public static final void E(WindowSearchResultTopBarPresenter r5, int r6) {
        r5.F().setMToNewPage(false);
        r5.F().getData().putExtra("sug_gap_time", SystemClock.elapsedRealtime() - r5.F().getMRecordTime());
        Activity r0 = l0.b(r5.u().c());
        if (r0 == null) goto L5;
        r0.setResult(r6, r5.F().getData());
    L5:
        Activity r7 = l0.b(r5.u().c());
        if (r7 == null) goto L9;
        r7.finish();
        return;
    }
}
