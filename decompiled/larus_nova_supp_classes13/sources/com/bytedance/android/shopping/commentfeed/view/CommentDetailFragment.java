package com.bytedance.android.shopping.commentfeed.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.legacy.AbsFragment;
import com.bytedance.android.ec.core.widget.DoubleColorBallStatusView;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.core.widget.d;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.shopping.commentfeed.adapter.CommentDetailPagerAdapter;
import com.bytedance.android.shopping.commentfeed.model.CommentDetailParams;
import com.bytedance.android.shopping.commentfeed.utils.CommentListViewModel;
import com.bytedance.android.shopping.commentfeed.widget.CommonPageLoadingView;
import com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager;
import com.bytedance.android.shopping.extensions.m;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/view/CommentDetailFragment;", "Lcom/bytedance/android/ec/core/legacy/AbsFragment;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentDetailFragment extends AbsFragment {
    public static final /* synthetic */ int t = 0;
    public final com.bytedance.commerce.base.viewmodel.a f;
    public OverScrolledViewPager g;
    public ImageView h;
    public ViewGroup i;
    public CommentDetailParams j;
    public CommentDetailPagerAdapter k;
    public boolean l;
    public View m;
    public View n;
    public CommonPageLoadingView o;
    public ECStatusView p;
    public boolean q;
    public boolean r;
    public final b s;

    public static final class a {
    }

    public static final class b extends d {
        public final /* synthetic */ CommentDetailFragment g;

        public b(CommentDetailFragment r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r12) {
            Intrinsics.checkNotNullParameter(r12, "v");
            CommentDetailFragment r13 = this.g;
            int r0 = CommentDetailFragment.t;
            CommentListViewModel r14 = r13.S90();
            if (r14 == null) goto L8;
            CommentDetailFragment r1 = this.g;
            CommentDetailParams r2 = r1.j;
            if (r2 == null) goto L9;
            r1.T90(true);
            r14.loadCommentList(new zb3.d(r2.getProductId(), r2.getCommentCursor(), 12, "detail", true));
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final CommentListViewModel S90() {
        return (CommentListViewModel) this.f.getValue();
    }

    public CommentDetailFragment() {
        CommentDetailFragment$viewModel$2 r0 = CommentDetailFragment$viewModel$2.INSTANCE;
        this.f = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(CommentListViewModel.class), new CommentDetailFragment$$special$$inlined$activityViewModels$1(this), r0);
        this.l = true;
        this.s = new b(this);
    }

    public final void T90(boolean r3) {
        if (r3 == false) goto L8;
        CommonPageLoadingView r4 = this.o;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L7:
        r4.setVisibility(0);
        r4.a.a();
        DoubleColorBallStatusView r5 = r4.a;
        r5.setVisibility(0);
        r5.setECStatus(0);
        return;
    L8:
        CommonPageLoadingView r6 = this.o;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L11:
        r6.setVisibility(8);
        r6.a.a();
    }

    public final void U90(boolean r7) {
        if (r7 == false) goto L25;
        ViewGroup r8 = this.i;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L7:
        ViewGroup r5 = this.i;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L10:
        r8.setBackgroundColor(th.a.f(r5.getContext()).getColor(2131101227));
        ImageView r9 = this.h;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivBack");
    L13:
        r9.setImageResource(2131234444);
        View r10 = this.m;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("netWorkErrorView");
    L16:
        r10.setVisibility(0);
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L21;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L21;
        m.a(r12, true);
    L21:
        OverScrolledViewPager r13 = this.g;
        if (r13 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L24:
        r13.setVisibility(4);
        return;
    L25:
        ViewGroup r14 = this.i;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L28:
        ViewGroup r6 = this.i;
        if (r6 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L31:
        r14.setBackgroundColor(th.a.f(r6.getContext()).getColor(2131105874));
        ImageView r15 = this.h;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("ivBack");
    L34:
        r15.setImageResource(2131234445);
        View r16 = this.m;
        if (r16 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("netWorkErrorView");
    L37:
        r16.setVisibility(8);
        OverScrolledViewPager r17 = this.g;
        if (r17 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L40:
        r17.setVisibility(0);
        FragmentActivity r18 = getActivity();
        if (r18 == null) goto L47;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L48;
        m.a(r19, false);
        return;
    L48:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        Serializable r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("comment_detail");
    L7:
        if ((r5 instanceof CommentDetailParams) == false) goto L10;
        r0 = r5;
    L10:
        CommentDetailParams r1 = (CommentDetailParams) r0;
        if (r1 == null) goto L14;
        this.j = r1;
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, FreqActions.ACTION_VIEW);
        super.onViewCreated(r13, r14);
        this.g = (OverScrolledViewPager) r13.findViewById(2131370516);
        this.h = (ImageView) r13.findViewById(2131370515);
        View r15 = r13.findViewById(2131370536);
        this.m = r15;
        if (r15 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("netWorkErrorView");
    L5:
        this.n = r15.findViewById(2131370609);
        this.i = (ViewGroup) r13.findViewById(2131370514);
        this.p = r13.findViewById(2131370517);
        this.o = (CommonPageLoadingView) r13.findViewById(2131370533);
        ECStatusView r16 = this.p;
        if (r16 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStatusView");
    L8:
        Context r0 = r13.getContext();
        Context r17 = r13.getContext();
        ViewGroup r1 = this.i;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        boolean r3 = false;
        View r18 = th.a.c(r17, 2131560549, r1, false);
        List<PromotionProductCommentDTO> r2 = null;
        r16.b(r0, r18, null);
        View r19 = this.n;
        if (r19 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("networkRetryView");
    L14:
        r19.setOnClickListener(this.s);
        this.k = new CommentDetailPagerAdapter(getChildFragmentManager());
        OverScrolledViewPager r110 = this.g;
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L17:
        r110.setAdapter(this.k);
        OverScrolledViewPager r111 = this.g;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L20:
        r111.setOffscreenPageLimit(2);
        OverScrolledViewPager r112 = this.g;
        if (r112 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L23:
        ((ArrayList) r112.S).add(new CommentDetailFragment$initViews$1(this));
        OverScrolledViewPager r113 = this.g;
        if (r113 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L26:
        r113.setOnRefreshListener(new com.bytedance.android.shopping.commentfeed.view.a(this));
        ImageView r114 = this.h;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivBack");
    L29:
        r114.setOnClickListener(new com.bytedance.android.shopping.commentfeed.view.b(this));
        CommentListViewModel r115 = S90();
        if (r115 == null) goto L61;
        CommentDetailParams r116 = this.j;
        if (r116 == null) goto L59;
        String r117 = r116.getProductId();
        if (r117 == null) goto L59;
        if (r117.length() <= 0) goto L38;
        r3 = true;
    L38:
        if (r3 == false) goto L40;
        String r5 = r117;
    L41:
        if (r5 == null) goto L59;
        HashMap<String, List<PromotionProductCommentDTO>> r118 = ac3.c.a;
        Intrinsics.checkNotNullParameter(r5, "productId");
        List<PromotionProductCommentDTO> r119 = ac3.c.a.get(r5);
        if (r119 != null) goto L45;
    L49:
        T90(true);
        long r6 = r115.getCommentCursor();
        CommentDetailParams r120 = this.j;
        if (r120 == null) goto L52;
        long r4 = r120.getCommentCursor();
    L53:
        long r8 = 12;
        if (r6 == 0) goto L56;
    L58:
        r115.loadCommentList(new zb3.d(r5, r6, r8, "detail", true));
        goto L59
    L56:
        if (12 >= (1 + r4)) goto L58;
        r8 = r4 + ((long) 3);
        goto L58
    L52:
        r4 = 0;
        goto L53
    L45:
        if ((!r119.isEmpty()) == false) goto L47;
        r2 = r119;
    L47:
        if (r2 == null) goto L49;
        r115.setCommentModel(r2);
        this.r = true;
        goto L59
    L40:
        r5 = null;
    L59:
        r115.getCommentList().observe(this, new CommentDetailFragment$initViewModel$$inlined$apply$lambda$1(this));
        r115.isRequestSucceed().observe(this, new CommentDetailFragment$initViewModel$$inlined$apply$lambda$2(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560403, r3, false);
    }
}
