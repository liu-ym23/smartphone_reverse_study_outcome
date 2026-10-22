package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.h0;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowProductStoreEntryPresenter extends QPresenter {
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public h0 h;
    public final Lazy i;
    public final Lazy j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WindowProductStoreEntryPresenter a;

        public a(WindowProductStoreEntryPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            int r0 = rp.a.a;
            if (rp.a.a(r4.getId()) == false) goto L5;
            return;
        L5:
            h0 r5 = this.a.h;
            if (r5 == null) goto L20;
            String r6 = r5.l;
            if (r6 == null) goto L20;
            m0 r1 = new m0(r6);
            r1.b("entrance_location", "store_page_bottom");
            String r7 = this.a.E().getShopParam().getStoreSourcePage();
            String r2 = "";
            if (r7 != null) goto L12;
            r7 = "";
        L12:
            r1.b("store_source_page", r7);
            String r8 = this.a.E().getShopParam().getStoreSourceMethod();
            if (r8 != null) goto L15;
            r8 = "";
        L15:
            r1.b("store_source_method", r8);
            String r9 = this.a.E().getShopParam().getStoreGroupType();
            if (r9 == null) goto L19;
            r2 = r9;
        L19:
            r1.b("store_group_type", r2);
            String r10 = r1.c();
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.u().c(), r10);
        L20:
            WindowProductStoreEntryPresenter.D(this.a, WindowTabEventReporter.EventType.CLICK);
        }
    }

    public final ECWindowViewModel E() {
        return (ECWindowViewModel) this.i.getValue();
    }

    public WindowProductStoreEntryPresenter() {
        this.e = LazyKt.lazy(new WindowProductStoreEntryPresenter$guideNoticeView$2(this));
        this.f = LazyKt.lazy(new WindowProductStoreEntryPresenter$storeNameView$2(this));
        this.g = LazyKt.lazy(new WindowProductStoreEntryPresenter$navigator$2(this));
        this.i = LazyKt.lazy(new WindowProductStoreEntryPresenter$shopViewModel$2(this));
        this.j = LazyKt.lazy(new WindowProductStoreEntryPresenter$reportShowEventOnce$2(this));
    }

    public final void A(QModel r6) {
        if (r6 == null) goto L12;
        h0 r7 = (h0) r6;
        Unit r0 = (Unit) this.j.getValue();
        int r1 = k0.a;
        k0.c((View) this.g.getValue(), true);
        Integer r2 = r7.k;
        if (r2 == null) goto L6;
        int r3 = r2.intValue();
        ((TextView) this.e.getValue()).setText(u().c().getString(2131896812, new Object[]{Integer.valueOf(r3)}));
    L6:
        String r4 = r7.j;
        if (r4 == null) goto L9;
        ((TextView) this.f.getValue()).setText(r4);
    L9:
        this.h = r7;
        ((View) this.g.getValue()).setOnClickListener(new a(this));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.WindowStoreEntranceVO");
    }

    public static final void D(WindowProductStoreEntryPresenter r8, WindowTabEventReporter.EventType r9) {
        r8.getClass();
        int r0 = WindowTabEventReporter.a;
        ECWindowViewModel r1 = r8.E();
        ECWindowParam r10 = r8.E().getShopParam();
        Intrinsics.checkNotNullParameter(r1, "reporter");
        Intrinsics.checkNotNullParameter(r10, "shopParam");
        Intrinsics.checkNotNullParameter(r9, "type");
        Map r11 = MapsKt.mapOf(new Pair[]{TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("entrance_location", "store_page_bottom"), TuplesKt.to("store_type", r10.getStoreSourcePage()), TuplesKt.to("store_source_method", r10.getStoreSourceMethod()), TuplesKt.to("store_group_type", r10.getStoreGroupType()), TuplesKt.to("store_type", "shop"), TuplesKt.to("author_id", r10.getAuthorId())});
        int r12 = com.bytedance.android.window.shop.home.tab.f.a[r9.ordinal()];
        if (r12 == 1) goto L8;
        if (r12 != 2) goto L7;
        String r13 = "click_store_entrance";
    L9:
        r1.doEventAction(r13, r11, new Pair[0]);
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r13 = "show_store_entrance";
        goto L9
    }
}
