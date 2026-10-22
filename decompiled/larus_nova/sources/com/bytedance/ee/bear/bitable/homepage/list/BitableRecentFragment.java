package com.bytedance.ee.bear.bitable.homepage.list;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.listsync.entity.SyncPushConfig;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u001f !\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\f\u0010\u0012\u001a\u00060\u0013R\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001e\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/list/BitableRecentFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/list/BitableRecentBaseFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/IMenuScrollChangeNotifier;", "Lcom/bytedance/ee/bear/bitable/homepage/list/ICanScrollTop;", "<init>", "()V", "onMenuScrollChangeListener", "Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;", "getOnMenuScrollChangeListener", "()Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;", "setOnMenuScrollChangeListener", "(Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;)V", "isFirstDataFlush", "", "isVisibleToUser", "hasBaseBenefit", "initMVP", "", "createView", "Lcom/bytedance/ee/bear/bitable/homepage/list/BitableRecentFragment$BitableRecentView;", "onCreateBtnClick", "getSpecifyMoreItemList", "", "", "scrollToTop", "setUserVisibleHint", "reportRecentListAnalysis", "isSuccess", "reason", "errorMsg", "isLarkTab", "BitableRecentView", "BitableRecentModel", "BitableRecentPresenter", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableRecentFragment extends BitableRecentBaseFragment implements com.bytedance.ee.bear.bitable.homepage.m0, a1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f212771n = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.ee.bear.list.list.d.c f212772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f212773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f212774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f212775m;

    public class BitableRecentView extends q0 implements com.bytedance.ee.bear.bitable.homepage.n0 {
        public final boolean L;
        public final View M;
        public final View N;
        public final View O;
        public SpaceEmptyState P;
        public final k Q;
        public final /* synthetic */ BitableRecentFragment R;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BitableRecentFragment f212776a;

            public a(BitableRecentFragment r100) {
                this.f212776a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                com.bytedance.ee.bear.bitable.homepage.l0 r101 = (com.bytedance.ee.bear.bitable.homepage.l0) this.f212776a.getParentFragment();
                if (r101 == null) goto L6;
                r101.o00();
                return;
            }
        }

        public static final class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BitableRecentFragment f212777a;

            public b(BitableRecentFragment r100) {
                this.f212777a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                com.bytedance.ee.bear.bitable.homepage.l0 r101 = (com.bytedance.ee.bear.bitable.homepage.l0) this.f212777a.getParentFragment();
                if (r101 == null) goto L6;
                r101.Sz("create_base_lead");
                return;
            }
        }

        @Override // com.bytedance.ee.bear.list.list.c
        public final void P2(FolderSortStrategy r100) {
        }

        @Override // com.bytedance.ee.bear.list.list.c
        public final String S1() {
            return "lark_workspace_bitable_landing";
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.q0
        public com.bytedance.ee.bear.list.list.d B3() {
            if (this.L == false) goto L6;
            final String r100 = this.f228592z;
            final DocsLinearLayoutManager r101 = this.f228582p;
            final ce5.a r102 = this.D;
            return new BitableRecentFragment$BitableRecentView$getListAdapter$1(r100, r101, r102);
        L6:
            if (this.f228572f == false) goto L8;
            final ce5.a r103 = this.D;
            return new BitableRecentFragment$BitableRecentView$getListAdapter$2(r103);
        L8:
            final String r104 = this.f228592z;
            final DocsLinearLayoutManager r105 = this.f228582p;
            final ce5.a r106 = this.D;
            return new BitableRecentFragment$BitableRecentView$getListAdapter$3(r104, r105, r106);
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.q0
        public final void F3() {
            if (this.L == false) goto L5;
            return;
        L5:
            lc5.f.a r100 = lc5.f.f508440a;
            com.bytedance.ee.bear.bitable.homepage.l0 r101 = (com.bytedance.ee.bear.bitable.homepage.l0) this.R.getParentFragment();
            String r102 = null;
            if (r101 == null) goto L8;
            String r103 = r101.Sv();
        L9:
            com.bytedance.ee.bear.bitable.homepage.l0 r104 = (com.bytedance.ee.bear.bitable.homepage.l0) this.R.getParentFragment();
            if (r104 == null) goto L12;
            r102 = r104.getFrom();
        L12:
            lc5.f.a.E("recent", r103, r102);
            return;
        L8:
            r103 = null;
            goto L9
        }

        public void J3() {
            SpaceEmptyState r100 = this.P;
            if (r100 == null) goto L10;
            if (this.R.f212775m == false) goto L7;
            String r101 = UIHelper.getString(R.string.Bitable_HomeDashboard_CreateNew_Button);
        L8:
            r100.setPrimaryText(r101);
            r100.setPrimaryActionTopMargin(UIHelper.getDimens(R.dimen.dp_10));
            goto L10
        L7:
            r101 = "";
        L10:
            if (this.R.f212775m == false) goto L12;
            int r102 = R.string.Bitable_HomeDashboard_NoContent_Desc;
        L14:
            if (this.Q == null) goto L17;
            k.e(this.P, UIHelper.getString(r102));
            return;
        L17:
            return;
        L12:
            r102 = R.string.Bitable_Unbundle_NoContent_Desc;
            goto L14
        }

        @Override // com.bytedance.ee.bear.list.list.c
        public final void Z2() {
            this.f228576j.d(this);
        }

        @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
        public final void k3() {
            if (this.L == false) goto L12;
            com.bytedance.ee.bear.bitable.homepage.l0 r100 = (com.bytedance.ee.bear.bitable.homepage.l0) this.R.getParentFragment();
            if (r100 == null) goto L9;
            boolean r101 = true;
            if (r100.isFullScreen() != true) goto L9;
        L10:
            if (r101 == true) goto L12;
            return;
        L9:
            r101 = false;
        L12:
            if (com.bytedance.ee.util.ui.b.a(this.f228570d.getActivity()) == true) goto L14;
            tt5.a.k(i2(), "showRefreshTipsToast() activity is not active");
            return;
        L14:
            long r102 = System.currentTimeMillis();
            if ((r102 - this.I) >= SyncPushConfig.instance().getMinimum_tip_interval()) goto L18;
            tt5.a.h("BitableRecentBaseView", "showRefreshTipsToast()...too often, minimum_tip_interval = " + SyncPushConfig.instance().getMinimum_tip_interval());
            return;
        L18:
            if (this.f212847J != null) goto L26;
            LifeCycleFragment r103 = this.f228570d;
            if (r103 == null) goto L26;
            if (r103.getParentFragment() == null) goto L26;
            if (this.f228570d.getParentFragment().getView() == null) goto L26;
            this.f212847J = new gd5.e(this.f228568b);
            FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
            r104.bottomMargin = y9c.d.a(60);
            r104.gravity = 81;
            ((ViewGroup) this.f228570d.getParentFragment().getView()).addView(this.f212847J, r104);
            this.f212847J.setOnClickListener(new p0(this));
        L26:
            gd5.e r105 = this.f212847J;
            if (r105 == null) goto L29;
            r105.f480942a.setVisibility(8);
            r105.f480943b.setVisibility(0);
            r105.setVisibility(0);
            this.I = r102;
        L29:
            com.bytedance.ee.util.ui.m.b(this.K, SyncPushConfig.instance().getRefresh_tip_duration());
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.n0
        public final void onRefresh() {
            ((com.bytedance.ee.bear.list.recent.e.a) this.f228571e).onRefresh();
        }

        @Override // com.bytedance.ee.bear.list.list.c
        public void x2() {
            com.bytedance.ee.bear.list.loadstateview.h r100 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f228569c.findViewById(R.id.list_state_view_root));
            this.f228577k = r100;
            r100.a(EmptyCategory.RECENT_NORMAL);
            this.f228577k.e(new o0(this));
            this.f228577k.d(new r0(this));
            com.bytedance.ee.bear.list.loadstateview.h r101 = this.f228577k;
            if (this.R.f212775m == false) goto L5;
            EmptyCategory r102 = EmptyCategory.BITABLE_RECENT_NORMAL;
        L6:
            r101.a(r102);
            return;
        L5:
            r102 = EmptyCategory.BITABLE_RECENT_NORMAL_HAS_NO_BENEFIT;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
        public final void j8() {
            super.j8();
            if (this.L == false) goto L11;
            k r100 = this.Q;
            if (r100 == null) goto L7;
            r100.d((FrameLayout) this.f228569c.findViewById(R.id.list_state_loading_root));
        L7:
            View r101 = this.f228569c.findViewById(R.id.list_state_loading_Lottie_view);
            if (r101 == null) goto L12;
            r101.setVisibility(8);
            return;
        L12:
            return;
        }

        @Override // com.bytedance.ee.bear.list.list.c
        public final void z2() {
            super.z2();
            com.bytedance.ee.bear.bitable.homepage.l0 r100 = (com.bytedance.ee.bear.bitable.homepage.l0) this.R.getParentFragment();
            if (r100 == null) goto L6;
            r100.pB(this);
            return;
        }

        @Override // com.bytedance.ee.bear.list.list.c, dd5.p1
        public final void Mj(boolean r100) {
            if (this.L == true) goto L6;
            super.Mj(r100);
            return;
        }

        @Override // com.bytedance.ee.bear.list.list.c
        public final void W2(boolean r100) {
            if (this.R.f212774l == false) goto L6;
            super.W2(r100);
            return;
        }

        @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
        public final void W3(int r100) {
            v3(r100);
            k r101 = this.Q;
            if (r101 == null) goto L7;
            RecyclerView r102 = r101.f212801a;
            if (r102 == null) goto L7;
            r102.setVisibility(8);
        L7:
            boolean r103 = this.L;
            boolean r104 = true;
            if (r103 == false) goto L42;
            if (r100 != 0) goto L42;
            View r105 = this.M;
            if (r105 == null) goto L14;
            r105.setVisibility(8);
        L14:
            if (this.P == null) goto L16;
            J3();
            return;
        L16:
            LinearLayout r106 = (LinearLayout) this.f228569c.findViewById(R.id.list_state_empty_root);
            View r107 = new View(this.R.getContext());
            LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
            if (r106 == null) goto L19;
            r106.addView(r107, 0, r108);
        L19:
            View r109 = new View(this.R.getContext());
            LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-1, 0, 2.0f);
            if (r106 == null) goto L22;
            r106.addView(r109, 3, r110);
        L22:
            this.P = (SpaceEmptyState) this.f228569c.findViewById(R.id.list_state_empty_state);
            J3();
            SpaceEmptyState r111 = this.P;
            if (r111 == null) goto L25;
            TextView r112 = (TextView) r111.findViewById(R.id.btnPrimary);
        L26:
            int r113 = this.R.getResources().getDimensionPixelSize(R.dimen.dp_16);
            Drawable r114 = UIHelper.getDrawable(R.drawable.ud_icon_add_middle_outlined);
            if (r114 == null) goto L31;
            r114.setBounds(0, 0, r113, r113);
            r114.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            if (r112 == null) goto L31;
            r112.setCompoundDrawables(r114, null, null, null);
        L31:
            if (r112 == null) goto L33;
            r112.setCompoundDrawablePadding(this.R.getResources().getDimensionPixelSize(R.dimen.dp_4));
        L33:
            com.bytedance.ee.bear.bitable.homepage.l0 r115 = (com.bytedance.ee.bear.bitable.homepage.l0) this.R.getParentFragment();
            if (r115 != null) goto L36;
        L38:
            r104 = false;
        L39:
            if (r104 == true) goto L47;
            if (r106 == null) goto L48;
            r106.setOnClickListener(new s0(this.R));
            return;
        L48:
            return;
        L47:
            return;
        L36:
            if (r115.isFullScreen() != true) goto L38;
        L25:
            r112 = null;
        L42:
            if (r103 == false) goto L50;
            if (r100 <= 0) goto L51;
            BitableRecentFragment r116 = this.R;
            int r117 = BitableRecentFragment.f212771n;
            r116.X90(true, "", null);
            return;
        L51:
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.q0, com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
        public final void j3(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            super.j3(r100);
            k r101 = this.Q;
            if (r101 == null) goto L6;
            r101.c(this.f228569c);
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.q0, com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
        public void l0(ArrayList<Document> r100) {
            super.l0(r100);
            if (this.L == true) goto L6;
            return;
        L6:
            if (r100 == null) goto L8;
            int r101 = r100.size();
        L9:
            boolean r102 = true;
            if (1 <= r101) goto L12;
        L14:
            boolean r103 = false;
        L15:
            if (r103 == true) goto L17;
        L19:
            boolean r104 = false;
        L20:
            com.bytedance.ee.bear.bitable.homepage.l0 r105 = (com.bytedance.ee.bear.bitable.homepage.l0) this.R.getParentFragment();
            if (r105 != null) goto L23;
        L25:
            r102 = false;
        L26:
            View r106 = this.N;
            int r107 = 8;
            if (r106 == null) goto L32;
            if (r104 == false) goto L30;
            int r108 = 0;
        L31:
            r106.setVisibility(r108);
            goto L32
        L30:
            r108 = 8;
        L32:
            View r109 = this.M;
            if (r109 == null) goto L40;
            if (r102 == true) goto L36;
            if (r101 == 0) goto L36;
        L37:
            int r110 = 0;
        L39:
            r109.setVisibility(r110);
        L36:
            if (r104 == true) goto L37;
            r110 = 8;
        L40:
            View r111 = this.O;
            if (r111 == null) goto L47;
            if (r104 == true) goto L46;
            if (r102 == true) goto L46;
            r107 = 0;
        L46:
            r111.setVisibility(r107);
        L47:
            if (r104 == false) goto L52;
            View r112 = this.N;
            if (r112 == null) goto L53;
            com.bytedance.ee.bear.bitable.common.g.a((ImageView) r112.findViewById(R.id.home_page_list_guide_gif), "ccm_bitable_home_list_empty_guide_emoji", false);
            com.bytedance.ee.bear.bitable.common.g.a((ImageView) r112.findViewById(R.id.home_page_list_guide_line), "ccm_bitable_home_list_empty_guide_line", false);
            return;
        L53:
            return;
        L52:
            return;
        L23:
            if (r105.isFullScreen() != true) goto L25;
        L17:
            if (this.R.f212775m == false) goto L19;
            r104 = true;
            goto L20
        L12:
            if (r101 >= 3) goto L14;
            r103 = true;
            goto L15
        L8:
            r101 = 0;
            goto L9
        }

        @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.c
        public final void h0(Document r100, boolean r101) {
            super.h0(r100, r101);
            com.bytedance.ee.bear.list.list.d.c r102 = this.R.f212772j;
            if (r102 == null) goto L6;
            r102.h0(r100, r101);
            return;
        }

        public BitableRecentView(BitableRecentFragment r100, Context r101, View r110, LifeCycleFragment r111, q0.b r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r110, "view");
            Intrinsics.checkNotNullParameter(r111, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r112, "dependence");
            this.R = r100;
            super(r101, r110, r111, r112, new ce5.a());
            this.L = r113;
            if (r113 == false) goto L29;
            this.Q = new k();
            ViewGroup r114 = (ViewGroup) r110;
            View r102 = LayoutInflater.from(r101).inflate(R.layout.bitable_home_page_recent_list_cover, r114, false);
            this.M = r102;
            r114.addView(r102);
            View r115 = null;
            if (r102 == null) goto L7;
            View r116 = r102.findViewById(R.id.home_page_list_guide_root);
        L8:
            this.N = r116;
            if (r102 == null) goto L11;
            View r117 = r102.findViewById(R.id.home_page_list_cover_create);
        L12:
            if (r102 == null) goto L14;
            r115 = r102.findViewById(R.id.home_page_list_cover_gradient);
        L14:
            this.O = r115;
            com.bytedance.ee.bear.bitable.homepage.l0 r103 = (com.bytedance.ee.bear.bitable.homepage.l0) r100.getParentFragment();
            if (r103 == null) goto L19;
            boolean r104 = true;
            if (r103.isFullScreen() != true) goto L19;
        L20:
            if (r104 == true) goto L25;
            if (r102 == null) goto L23;
            r102.setOnClickListener(new a(r100));
        L23:
            if (r115 == null) goto L25;
            r115.setVisibility(0);
        L25:
            if (r117 == null) goto L27;
            r117.setOnClickListener(new b(r100));
        L27:
            r110.setBackgroundColor(0);
            return;
        L19:
            r104 = false;
            goto L20
        L11:
            r117 = null;
            goto L12
        L7:
            r116 = null;
            goto L8
        }
    }

    public static class a extends w {
        @Override // com.bytedance.ee.bear.list.list.a
        public final void j0(FolderSortStrategy r100) {
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.w
        public int u0() {
            return 13;
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.w
        public final com.bytedance.ee.bear.list.recent.z0 t0() {
            return new com.bytedance.ee.bear.list.recent.z0(new FolderSortStrategy("bitable_home", FilterType.BITABLE.getType(), "", "", RecentSort.OPENED.getRank(), false), new ce5.a());
        }

        public a(LifeCycleFragment r100, Context r101) {
            super(r100, r101);
        }
    }

    public class b extends m0 {
        public boolean C;
        public final /* synthetic */ BitableRecentFragment D;

        @Override // com.bytedance.ee.bear.bitable.homepage.list.m0, com.bytedance.ee.bear.list.list.b
        public String J8() {
            if (this.C == false) goto L6;
            return "base_home";
        L6:
            return "lark_workspace_bitable_landing";
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.m0, com.bytedance.ee.bear.list.list.b
        public String K8() {
            com.bytedance.ee.bear.bitable.homepage.l0 r100 = (com.bytedance.ee.bear.bitable.homepage.l0) this.D.getParentFragment();
            if (r100 == null) goto L5;
            boolean r101 = r100.rl();
        L7:
            if (this.C == false) goto L12;
            if (r101 == true) goto L10;
            return "base_hp_larktab_recent_hpmobile_v2";
        L10:
            return "base_hp_workbench_recent_hpmobile_v2";
        L12:
            BitableRecentFragment r102 = this.D;
            r102.getClass();
            if ((r102 instanceof BitableHomeRecentFragment) == false) goto L16;
            if (r101 == true) goto L16;
            return "base_hp_larktab_recent";
        L16:
            return "base_hp_workbench_recent";
        L5:
            r101 = false;
            goto L7
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.m0
        public final String f9() {
            if (this.C == false) goto L5;
            return "ccm_base_homepage_filelist_click";
        L5:
            BitableRecentFragment r100 = this.D;
            r100.getClass();
            if ((r100 instanceof BitableHomeRecentFragment) == true) goto L10;
            return "ccm_bitable_workspace_landing_page_click";
        L10:
            return "ccm_base_homepage_filelist_click";
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.m0
        public final String g9() {
            com.bytedance.ee.bear.bitable.homepage.l0 r100 = (com.bytedance.ee.bear.bitable.homepage.l0) this.D.getParentFragment();
            if (r100 == null) goto L6;
            String r101 = r100.Sv();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.m0
        public final String h9() {
            com.bytedance.ee.bear.bitable.homepage.l0 r100 = (com.bytedance.ee.bear.bitable.homepage.l0) this.D.getParentFragment();
            if (r100 == null) goto L6;
            String r101 = r100.getFrom();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
        public final void p2(Throwable r100) {
            super.p2(r100);
            com.bytedance.ee.bear.bitable.homepage.l0 r101 = (com.bytedance.ee.bear.bitable.homepage.l0) this.D.getParentFragment();
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L15;
            BitableRecentFragment r103 = this.D;
            if (r100 == null) goto L12;
            String r104 = r100.getMessage();
        L13:
            r103.X90(false, "load_file_list", r104);
            return;
        L12:
            r104 = null;
            goto L13
        L15:
            return;
        L5:
            if (r101.isFullScreen() == true) goto L7;
            r102 = true;
            goto L8
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.m0, com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
        public final void s8(int r100, boolean r101) {
            super.s8(r100, r101);
            com.bytedance.ee.bear.bitable.homepage.l0 r102 = (com.bytedance.ee.bear.bitable.homepage.l0) this.D.getParentFragment();
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            if (r103 == false) goto L11;
            BitableRecentFragment r104 = this.D;
            int r105 = BitableRecentFragment.f212771n;
            r104.X90(true, "", null);
            return;
        L11:
            return;
        L5:
            if (r102.isFullScreen() == true) goto L7;
            r103 = true;
            goto L8
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.list.m0, com.bytedance.ee.bear.list.list.f.a
        public void h3(Document r210, int r211, boolean r212) {
            com.bytedance.ee.bear.list.t0.r(new com.bytedance.ee.bear.list.v0(this.f228538b.getActivity(), r210, Q8(), d9(r210), J8(), "recent", K8(), r211, r212, 0), this.f228560x);
            if (this.C == false) goto L5;
            lc5.f.a r100 = lc5.f.f508440a;
            String r101 = f9();
            String r102 = J8();
            String r103 = r210.f227873d;
            int r104 = r210.getType();
            String r110 = r210.F;
            FolderVersion.a r105 = FolderVersion.Companion;
            int r111 = r210.L1;
            boolean r112 = r210.P1;
            r105.getClass();
            r100.L(new lc5.q(r101, r102, "recent", "recent", "", r103, r104, r110, FolderVersion.a.b(r111, r112), false, 0, com.bytedance.ee.bear.list.t0.m(r210), g9(), h9()));
            return;
        L5:
            lc5.f.a r106 = lc5.f.f508440a;
            String r107 = f9();
            String r108 = J8();
            String r109 = r210.f227873d;
            int r113 = r210.getType();
            String r114 = r210.F;
            FolderVersion.a r115 = FolderVersion.Companion;
            int r116 = r210.L1;
            boolean r117 = r210.P1;
            r115.getClass();
            lc5.f.a.K(new lc5.q(r107, r108, "recent", "recent", "", r109, r113, r114, FolderVersion.a.b(r116, r117), false, 0, com.bytedance.ee.bear.list.t0.m(r210), g9(), h9()), this.f228560x);
        }

        public b(BitableRecentFragment r100, com.bytedance.ee.bear.list.recent.e r101, a r102, Context r110, LifeCycleFragment r111) {
            this.D = r100;
            super(r101, r102, r110, r111, new ce5.a());
        }
    }

    public static final class c {
    }

    static {
    }

    public BitableRecentView W90() {
        return new BitableRecentView(this, getContext(), this.f212768g, this, this, false);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.a1
    public final void t0() {
        BitableRecentView r100 = this.f212770i;
        if ((r100 instanceof com.bytedance.ee.bear.list.list.c) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        r100.h3();
        return;
    }

    public BitableRecentFragment() {
        this.f212775m = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("base_create_base");
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.BitableRecentBaseFragment
    public void V90() {
        this.f212770i = W90();
        a r100 = new a(this, getContext());
        b r101 = new b(this, this.f212770i, r100, getContext(), this);
        this.f212769h = r101;
        r101.create();
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.BitableRecentBaseFragment, com.bytedance.ee.bear.bitable.homepage.list.q0.b
    public final void m3() {
        com.bytedance.ee.bear.bitable.homepage.l0 r100 = (com.bytedance.ee.bear.bitable.homepage.l0) getParentFragment();
        if (r100 == null) goto L6;
        r100.Sz("new_base_popup");
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.m0
    public final void gL(com.bytedance.ee.bear.list.list.d.c r100) {
        this.f212772j = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.BitableRecentBaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        this.f212774l = r100;
    }

    public final void X90(boolean r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r211, "reason");
        com.bytedance.ee.bear.bitable.homepage.l0 r100 = (com.bytedance.ee.bear.bitable.homepage.l0) getParentFragment();
        if (r100 == null) goto L31;
        String r110 = r100.getTraceId();
        if (r110 == null) goto L32;
        String r101 = r100.Sv();
        if (r101 != null) goto L9;
        ws4.b r111 = null;
    L15:
        if (this.f212773k == true) goto L19;
        this.f212773k = true;
        long r112 = System.currentTimeMillis();
        com.bytedance.ee.bear.bitable.statistic.m r102 = ws4.g.f561049a;
        Intrinsics.checkNotNullParameter(r110, "traceId");
        BitableStatisticEventModel$NormalPointModel r103 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_HOME_LOAD_DATA_END_FILE", r112, false, 12);
        ws4.g.a(r103, r111);
        com.bytedance.ee.bear.bitable.statistic.m r104 = ws4.g.f561049a;
        r104.addNormalPoint(r110, r103);
        long r105 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r110, "traceId");
        BitableStatisticEventModel$NormalPointModel r106 = BitableStatisticEventModel$NormalPointModel.a.b("OPEN_HOME_TTV_FILE", r105, true, null);
        ws4.g.a(r106, r111);
        r104.addNormalPoint(r110, r106);
        com.bytedance.ee.bear.bitable.homepage.j0 r107 = r100.F2();
        if (r107 == null) goto L33;
        r107.aa(r210, "recent_list", r111);
        return;
    L33:
        return;
    L19:
        long r108 = System.currentTimeMillis();
        if (TextUtils.isEmpty(ws4.d.f561045b) == false) goto L22;
        tt5.a.h("BitableHomePageV4MineTabReporter", "reportHomePageRecentListEnd : trace id is null");
    L23:
        long r113 = System.currentTimeMillis();
        if (TextUtils.isEmpty(ws4.d.f561045b) == false) goto L26;
        tt5.a.h("BitableHomePageV4MineTabReporter", "reportHomePageRecentListTTV : trace id is null");
    L27:
        com.bytedance.ee.bear.bitable.homepage.j0 r109 = r100.F2();
        if (r109 == null) goto L35;
        r109.aa(r210, "recent_list", r111);
        return;
    L35:
        return;
    L26:
        BitableStatisticEventModel$NormalPointModel r114 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_HOME_TTV_FILE", r113, false, 12);
        ws4.d.a(r114, r111);
        ws4.d.f561044a.addNormalPoint(ws4.d.f561045b, r114);
        goto L27
    L22:
        BitableStatisticEventModel$NormalPointModel r115 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_HOME_LOAD_DATA_END_FILE", r108, false, 12);
        ws4.d.a(r115, r111);
        ws4.d.f561044a.addNormalPoint(ws4.d.f561045b, r115);
        goto L23
    L9:
        if (r210 == false) goto L11;
        String r116 = BitableStatisticConstant$Result.SUCCESS.getValue();
    L12:
        r111 = new ws4.b(r101, "", "homepage", r211, r116, r212);
        goto L15
    L11:
        r116 = BitableStatisticConstant$Result.FAIL.getValue();
        goto L12
    L32:
        return;
    }
}
