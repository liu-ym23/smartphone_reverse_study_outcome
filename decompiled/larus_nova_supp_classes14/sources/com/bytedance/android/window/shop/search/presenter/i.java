package com.bytedance.android.window.shop.search.presenter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.paging.PagedList;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends QFragmentPresenter implements View.OnClickListener {
    public WindowSearchFragmentProductViewModel f;

    public static final class a<T> implements Observer {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            WindowLoadStatus r3 = (WindowLoadStatus) r2;
            if (r3 == null) goto L19;
            this.a.d0(r3);
            if (r3 != WindowLoadStatus.LoadMoreEnd) goto L17;
            WindowSearchFragmentProductViewModel r4 = this.a.f;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L11:
            if (r4.getObserveFlag() == true) goto L18;
            WindowSearchFragmentProductViewModel r5 = this.a.f;
            if (r5 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L15:
            r5.setObserveFlag(true);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public i(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void b0(QModel r7) {
        this.f = Y().g(WindowSearchFragmentProductViewModel.class);
        TextView r8 = (TextView) Z().b(2131391171).f();
        WindowSearchFragmentProductViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r8.setText(r0.getPublicityText());
        WindowSearchFragmentProductViewModel r9 = this.f;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        d0((WindowLoadStatus) r9.getLoadStatus().a());
        WindowSearchFragmentProductViewModel r10 = this.f;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        if (((WindowLoadStatus) r10.getLoadStatus().a()) != WindowLoadStatus.LoadMoreEnd) goto L39;
        WindowSearchFragmentProductViewModel r11 = this.f;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        if (r11.getObserveFlag() == false) goto L39;
        WindowSearchFragmentProductViewModel r12 = this.f;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        if (r12.getReportFlag() == true) goto L39;
        WindowSearchFragmentProductViewModel r13 = this.f;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("entrance_location", "store_page_bottom");
        r1[1] = TuplesKt.to("enter_from", "store_page_bottom");
        WindowSearchFragmentProductViewModel r2 = this.f;
        if (r2 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        String r3 = r2.getSearchParam().getAuthorId();
        if (r3 != null) goto L32;
        r3 = "";
    L32:
        r1[2] = TuplesKt.to("author_id", r3);
        r1[3] = TuplesKt.to("store_type", "window");
        r13.doEventAction("show_store_entrance", r1);
        WindowSearchFragmentProductViewModel r14 = this.f;
        if (r14 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L35:
        r14.setReportFlag(true);
        WindowSearchFragmentProductViewModel r15 = this.f;
        if (r15 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        r15.setObserveFlag(false);
    L39:
        WindowSearchFragmentProductViewModel r16 = this.f;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L42:
        r16.getLoadStatus().b(ECQuickUtilKt.a(Y()), new a(this));
    }

    public final void d0(WindowLoadStatus r12) {
        if (r12 == null) goto L9;
        int r13 = h.a[r12.ordinal()];
        if (r13 == 1) goto L12;
        if (r13 == 2) goto L11;
        if (r13 != 3) goto L9;
        Z().b(2131387793).f().b();
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
        ECToast.showToast$default(ECToast.INSTANCE, Y().c(), 2131913855, null, 4, null);
        return;
    L11:
        Z().b(2131387793).f().a();
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
        return;
    L12:
        WindowSearchFragmentProductViewModel r14 = this.f;
        if (r14 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        PagedList r15 = (PagedList) r14.getProducts().getValue();
        if (r15 == null) goto L18;
        Integer r16 = Integer.valueOf(r15.size());
    L19:
        Intrinsics.checkNotNull(r16);
        if (r16.intValue() >= 5) goto L39;
        WindowSearchFragmentProductViewModel r17 = this.f;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        if (r17.getReportFlag() == true) goto L39;
        WindowSearchFragmentProductViewModel r18 = this.f;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        Pair[] r7 = new Pair[4];
        r7[0] = TuplesKt.to("entrance_location", "store_page_bottom");
        r7[1] = TuplesKt.to("enter_from", "store_page_bottom");
        WindowSearchFragmentProductViewModel r9 = this.f;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        String r10 = r9.getSearchParam().getAuthorId();
        if (r10 != null) goto L35;
        r10 = "";
    L35:
        r7[2] = TuplesKt.to("author_id", r10);
        r7[3] = TuplesKt.to("store_type", "window");
        r18.doEventAction("show_store_entrance", r7);
        WindowSearchFragmentProductViewModel r19 = this.f;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        r19.setReportFlag(true);
    L39:
        Z().b(2131387793).f().setVisibility(8);
        ((TextView) Z().b(2131389441).f()).setVisibility(8);
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(0);
        ((TextView) Z().b(2131383172).f()).setText(2131913868);
        ((TextView) Z().b(2131391171).f()).setVisibility(8);
        return;
    L18:
        r16 = null;
    L9:
        Z().b(2131387793).f().b();
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (r6 == null) goto L4;
        Integer r7 = Integer.valueOf(r6.getId());
    L5:
        if (r7 != null) goto L8;
        return;
    L8:
        if (r7.intValue() != 2131387429) goto L20;
        WindowSearchFragmentProductViewModel r8 = this.f;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("entrance_location", "store_page_bottom");
        r1[1] = TuplesKt.to("enter_from", "store_page_bottom");
        WindowSearchFragmentProductViewModel r2 = this.f;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        String r0 = r2.getSearchParam().getAuthorId();
        if (r0 != null) goto L18;
        r0 = "";
    L18:
        r1[2] = TuplesKt.to("author_id", r0);
        r1[3] = TuplesKt.to("store_type", "window");
        r8.doEventAction("click_store_entrance", r1);
        return;
    L20:
        return;
    L4:
        r7 = null;
        goto L5
    }
}
