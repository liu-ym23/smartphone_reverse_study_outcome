package com.bytedance.android.shopping.sameproduct;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.widget.DoubleColorBallStatusView;
import com.bytedance.android.ec.innerflow.jedi.LoadMoreRecyclerViewAdapter;
import com.bytedance.android.shopping.anchorv3.AnchorV3GridLayoutManager;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.feed.adapter.QuickDividerItemDecoration;
import com.bytedance.android.shopping.feed.event.f1;
import com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.sameproduct.adapter.SameProductListAdapter;
import com.bytedance.android.shopping.sameproduct.event.SameTrackerProvider;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.crash.d;
import com.bytedance.jedi.arch.ISubscriber;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import dh3.c;
import dh3.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/SameProductListFragment;", "Lcom/bytedance/android/shopping/inflow/compat/ToggleBottomSheetFragment;", "<init>", "()V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductListFragment extends ToggleBottomSheetFragment {
    public static final /* synthetic */ int w = 0;
    public final lifecycleAwareLazy m;
    public final int n;
    public RecyclerView o;
    public DoubleColorBallStatusView p;
    public View q;
    public View r;
    public View s;
    public SameProductPageParams t;
    public SameProductListAdapter u;
    public final b v;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SameProductListFragment a;

        public b(SameProductListFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            int r3 = SameProductListFragment.w;
            SameProductListFragment r4 = this.a;
            Intrinsics.checkNotNullParameter(r4, "fragment");
            r4.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L12;
            d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final int S90() {
        return 2131560667;
    }

    public final SameProductViewModel aa0() {
        return (SameProductViewModel) this.m.getValue();
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final int getLayoutId() {
        return 2131560668;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final String getTAG() {
        return "javaClass";
    }

    public SameProductListFragment() {
        final KClass r0 = Reflection.getOrCreateKotlinClass(SameProductViewModel.class);
        final Function0<String> r1 = new SameProductListFragment$$special$$inlined$viewModel$1(r0);
        final SameProductListFragment$$special$$inlined$viewModel$2 r2 = SameProductListFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.m = new lifecycleAwareLazy(this, r1, new SameProductListFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        n1.i.getClass();
        this.n = n1.a.b();
        this.v = new b(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        s0.a(new c(aa0().getFilterProductHelper().b));
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final int T90() {
        return this.n;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final int U90() {
        return this.n;
    }

    public static final void Z90(SameProductListFragment r6) {
        RecyclerView r0 = r6.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == true) goto L8;
        r1 = null;
    L8:
        LinearLayoutManager r2 = (LinearLayoutManager) r1;
        if (r2 == null) goto L15;
        int r5 = r2.findLastVisibleItemPosition();
        int r3 = r2.getItemCount();
        if (r3 <= 2) goto L15;
        if (((r3 - 1) - r5) > 3) goto L15;
        r6.aa0().loadSameProductList();
    L15:
        RecyclerView r4 = r6.o;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L18:
        RecyclerView.LayoutManager r7 = r4.getLayoutManager();
        if ((r7 instanceof StaggeredGridLayoutManager) == true) goto L21;
        r7 = null;
    L21:
        StaggeredGridLayoutManager r8 = (StaggeredGridLayoutManager) r7;
        if (r8 == null) goto L29;
        int r9 = r8.findLastVisibleItemPositions(null)[0];
        int r10 = r8.getItemCount();
        if (r10 > 2) goto L26;
        return;
    L26:
        if (((r10 - 1) - r9) > 3) goto L31;
        r6.aa0().loadSameProductList();
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        Dialog r7 = getDialog();
        if (r7 == null) goto L5;
        View r8 = r7.findViewById(2131389274);
    L6:
        this.s = r8;
        SameProductPageParams r9 = this.t;
        if (r9 != null) goto L9;
    L22:
        View r10 = this.q;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("backView");
    L25:
        r10.setVisibility(0);
        View r11 = this.r;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L28:
        r11.setVisibility(8);
        return;
    L9:
        if (r9.isFullScreenFlowPage() != true) goto L22;
        View r12 = this.r;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L13:
        r12.setVisibility(0);
        View r13 = this.q;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("backView");
    L16:
        r13.setVisibility(8);
        View r14 = this.s;
        if (r14 == null) goto L30;
        View r0 = this.q;
        if (r0 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("backView");
    L21:
        r14.setBackgroundColor(th.a.f(r0.getContext()).getColor(2131101181));
        return;
    L30:
        return;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        if (r8 == null) goto L5;
        Object r9 = r8.get("param_key");
    L7:
        if ((r9 instanceof SameProductPageParams) == true) goto L9;
        r9 = null;
    L9:
        SameProductPageParams r10 = (SameProductPageParams) r9;
        if (r10 == null) goto L22;
        Context r1 = getContext();
        if (r1 == null) goto L21;
        SameTrackerProvider.a r2 = SameTrackerProvider.Companion;
        int r3 = e.b;
        Intrinsics.checkNotNullParameter(r10, "param");
        e r4 = new e();
        e.a(r4, PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
        e.a(r4, PdpOpenThirdParam.KEY_SOURCE_PAGE, r10.getEnterFrom());
        e.a(r4, "ecom_entrance_form", r10.getEcomEntranceForm());
        e.a(r4, "author_id", r10.getAuthorId());
        e.a(r4, "group_id", r10.getVideoId());
        Integer r5 = r10.getFollowStatus();
        if (r5 == null) goto L16;
        String r6 = String.valueOf(r5.intValue());
    L17:
        e.a(r4, PdpOpenThirdParam.KEY_FOLLOW_STATUS, r6);
        e.a(r4, "inflow_landing_page_type", "product_inflow_similar_tab");
        e.a(r4, "target_product_id", r10.getMainProductId());
        if (r10.isFromFlowGuessULike() == false) goto L20;
        e.a(r4, "module_label", "guess_you_like_product");
        e.a(r4, "from_product_module_label", "guess_you_like_product");
    L20:
        e.a(r4, "ecom_group_type", "video");
        r2.getClass();
        SameTrackerProvider.a.a(r1, r4);
        goto L21
    L16:
        r6 = null;
    L21:
        this.t = r10;
        aa0().setPageParams(r10);
        aa0().loadMainProductCard();
        aa0().loadSameProductList();
    L22:
        f1 r11 = new f1();
        r11.a = "same_product";
        r11.b = "SameProductListFragment";
        SameProductPageParams r12 = this.t;
        if (r12 == null) goto L25;
        String r13 = r12.getMainProductRequestId();
    L26:
        r11.c = r13;
        r11.post(null, null);
        return;
    L25:
        r13 = null;
        goto L26
    L5:
        r9 = null;
        goto L7
    }

    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r17, r18);
        this.o = r17.findViewById(2131370828);
        this.p = r17.findViewById(2131370827);
        this.q = r17.findViewById(2131370757);
        View r0 = r17.findViewById(2131370758);
        this.r = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L5:
        r0.setOnClickListener(this.v);
        View r1 = this.q;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backView");
    L8:
        r1.setOnClickListener(this.v);
        RecyclerView r2 = this.o;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L11:
        SameProductPageParams r3 = this.t;
        if (r3 == null) goto L14;
        int r4 = r3.getSameProductStyle();
    L15:
        SameProductListAdapter r5 = new SameProductListAdapter(this, r2, r4);
        ((LoadMoreRecyclerViewAdapter) r5).p = new SameProductListFragment$initViews$$inlined$apply$lambda$1(this);
        Unit r6 = Unit.INSTANCE;
        this.u = r5;
        RecyclerView r7 = this.o;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L18:
        r7.setAdapter(this.u);
        SameProductPageParams r8 = this.t;
        if (r8 != null) goto L21;
    L26:
        SameProductPageParams r9 = this.t;
        if (r9 != null) goto L29;
    L34:
        RecyclerView r10 = this.o;
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L37:
        r10.addOnScrollListener(new SameProductListFragment$initViews$4(this));
        ISubscriber.DefaultImpls.selectSubscribe$default(this, aa0(), SameProductListFragment$initSubscribe$1.INSTANCE, null, new SameProductListFragment$initSubscribe$2(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, aa0(), SameProductListFragment$initSubscribe$3.INSTANCE, SameProductListFragment$initSubscribe$4.INSTANCE, null, new SameProductListFragment$initSubscribe$5(this), 4, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, aa0(), SameProductListFragment$initSubscribe$6.INSTANCE, null, new SameProductListFragment$initSubscribe$7(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, aa0(), SameProductListFragment$initSubscribe$8.INSTANCE, SameProductListFragment$initSubscribe$9.INSTANCE, null, new SameProductListFragment$initSubscribe$10(this), 4, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, aa0(), SameProductListFragment$initSubscribe$11.INSTANCE, SameProductListFragment$initSubscribe$12.INSTANCE, null, new SameProductListFragment$initSubscribe$13(this), 4, null);
        return;
    L29:
        if (r9.getSameProductStyle() != 1) goto L34;
        RecyclerView r11 = this.o;
        if (r11 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L33:
        r11.setLayoutManager(new LinearLayoutManager(r11.getContext()));
        SameProductListAdapter r12 = this.u;
        Intrinsics.checkNotNull(r12);
        r11.addItemDecoration(new QuickDividerItemDecoration(r12, new com.bytedance.android.shopping.sameproduct.a()));
        goto L34
    L21:
        if (r8.getSameProductStyle() != 2) goto L26;
        RecyclerView r13 = this.o;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L25:
        r13.setLayoutManager(new AnchorV3GridLayoutManager());
        r13.addItemDecoration(new StaggeredGridDoubleColumnDecoration(12.0f, 0.0f, 12.0f, 9.0f, 10.0f, new SameProductListFragment$initViews$2$1(StaggeredGridDoubleColumnDecoration.g)));
        goto L34
    L14:
        r4 = 0;
        goto L15
    }
}
