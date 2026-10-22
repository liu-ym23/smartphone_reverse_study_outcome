package com.bytedance.ee.bear.bitable.toolbox.view;

import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentFabView;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import com.bytedance.ee.bear.bitable.toolbox.model.fab.BitableFabModel;
import com.bytedance.ee.bear.bitable.toolbox.model.fab.EBitableFab;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.ToolbarData;
import com.bytedance.ee.bear.bitable.toolbox.viewmodel.BitableToolboxViewModel;
import com.bytedance.ee.bear.doc.cover.CoverConstants$CoverSource;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020#H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0015H\u0002J\u001d\u0010/\u001a\u00020#2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002¢\u0006\u0002\u00103J\u001d\u00104\u001a\u00020#2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002¢\u0006\u0002\u00103J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000202H\u0002J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020#H\u0002J\b\u0010=\u001a\u00020#H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/view/BitableToolboxFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "mToolboxViewModel", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "getMToolboxViewModel", "()Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "mToolboxViewModel$delegate", "Lkotlin/Lazy;", "mToolboxContainer", "Landroid/widget/LinearLayout;", "mFabContainer", "mToolbarContainer", "mMenuRV", "Landroidx/recyclerview/widget/RecyclerView;", "mMenuAdapter", "Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter;", "mGridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "mLastScrollDirection", "Lcom/bytedance/ee/bear/bitable/toolbox/view/BitableToolboxFragment$ScrollDirection;", "mToolbarScrollAnim", "Landroid/animation/ValueAnimator;", "defaultFabMarginBottom", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "initView", "rootView", "initDataObserver", "updateToolboxBottomPadding", "height", "initToolbarScrollStrategy", "showToolbarScrollAnim", "direction", "updateDashboardFab", "updateFabItems", "items", "", "Lcom/bytedance/ee/bear/bitable/toolbox/model/fab/BitableFabModel$BitableFabItem;", "([Lcom/bytedance/ee/bear/bitable/toolbox/model/fab/BitableFabModel$BitableFabItem;)V", "reportFabVisibility", "createFabItemView", "item", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isPhoneLandscape", "", "updateFabVisibility", "updateToolbarVisibility", "ScrollDirection", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableToolboxFragment extends BaseFragment {
    public static final /* synthetic */ int n = 0;
    public final Lazy e;
    public LinearLayout f;
    public LinearLayout g;
    public RecyclerView h;
    public ToolbarMenuAdapter i;
    public GridLayoutManager j;
    public ScrollDirection k;
    public ValueAnimator l;
    public int m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/view/BitableToolboxFragment$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection DOWN = null;
        public static final ScrollDirection UP = null;
        public static final /* synthetic */ ScrollDirection[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScrollDirection> getEntries() {
            return b;
        }

        static {
            ScrollDirection r0 = new ScrollDirection("UP", 0);
            UP = r0;
            ScrollDirection r1 = new ScrollDirection("DOWN", 1);
            DOWN = r1;
            ScrollDirection[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) a.clone();
        }

        public static ScrollDirection valueOf(String r1) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r1);
        }

        public ScrollDirection(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b extends t {
        public final /* synthetic */ BitableToolboxFragment c;
        public final /* synthetic */ BitableFabModel.BitableFabItem d;

        public final void a(View r6) {
            Intrinsics.checkNotNullParameter(r6, "v");
            BitableToolboxFragment r7 = this.c;
            int r0 = BitableToolboxFragment.n;
            BitableToolboxAnalytic r8 = r7.W90().getToolboxAnalytic();
            if (r8 == null) goto L46;
            kr4.a r1 = ((BitableAnalytic) r8).a;
            if (r1 == null) goto L7;
            SceneModel r2 = r1.e();
        L8:
            boolean r3 = false;
            if (r2 != null) goto L11;
        L13:
            boolean r4 = false;
        L14:
            if (r4 == false) goto L16;
            String r5 = "dashboard";
        L17:
            if (r2 != null) goto L19;
        L21:
            boolean r9 = false;
        L22:
            if (r9 == false) goto L24;
            String r10 = "kanban";
        L45:
            HashMap r11 = new HashMap();
            r11.put("click", "AI_qa");
            r11.put("entrance_type", r5);
            r11.put("view_type", r10);
            r8.t("ccm_bitable_ai_bottombar_entrance_click", r11);
            goto L46
        L24:
            if (r2 != null) goto L26;
        L28:
            boolean r12 = false;
        L29:
            if (r12 == false) goto L31;
            r10 = "calendar";
            goto L45
        L31:
            if (r2 != null) goto L33;
        L35:
            boolean r13 = false;
        L36:
            if (r13 == false) goto L38;
            r10 = "gantt";
            goto L45
        L38:
            if (r2 != null) goto L40;
        L42:
            if (r3 == false) goto L44;
            r10 = CoverConstants$CoverSource.GALLERY;
            goto L45
        L44:
            r10 = "grid";
            goto L45
        L40:
            if (r2.isGallery() != true) goto L42;
            r3 = true;
            goto L42
        L33:
            if (r2.isGantt() != true) goto L35;
            r13 = true;
            goto L36
        L26:
            if (r2.isCalendar() != true) goto L28;
            r12 = true;
            goto L29
        L19:
            if (r2.isKanban() != true) goto L21;
            r9 = true;
            goto L22
        L16:
            r5 = "tables";
            goto L17
        L11:
            if (r2.isDashBoard() != true) goto L13;
            r4 = true;
            goto L14
        L7:
            r2 = null;
        L46:
            this.c.W90().clickFabItem(this.d.getId());
        }

        public b(BitableToolboxFragment r1, BitableFabModel.BitableFabItem r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class c extends t {
        public final /* synthetic */ BitableToolboxFragment c;
        public final /* synthetic */ BitableFabModel.BitableFabItem d;

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            BitableToolboxFragment r3 = this.c;
            int r0 = BitableToolboxFragment.n;
            r3.W90().clickFabItem(this.d.getId());
        }

        public c(BitableToolboxFragment r1, BitableFabModel.BitableFabItem r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    static {
    }

    public final BitableToolboxViewModel W90() {
        return (BitableToolboxViewModel) this.e.getValue();
    }

    public final void aa0() {
        LinearLayout r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r0 = null;
    L5:
        int r1 = r0.getChildCount();
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L22;
        LinearLayout r5 = this.f;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r5 = null;
    L10:
        View r6 = r5.getChildAt(r4);
        if ((r6 instanceof FabView) == false) goto L21;
        FabView r7 = (FabView) r6;
        if ((r7.getTag() instanceof String) == false) goto L21;
        Object r8 = r7.getTag();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.String");
        if (TextUtils.equals((String) r8, "createRecord") == false) goto L21;
        if (X90() == false) goto L19;
        int r9 = 8;
    L20:
        r7.setVisibility(r9);
        goto L21
    L19:
        r9 = 0;
    L21:
        r4 = r4 + 1;
        goto L6
    }

    public BitableToolboxFragment() {
        this.e = LazyKt.lazy(new BitableToolboxFragment$mToolboxViewModel$2(this));
    }

    public final boolean X90() {
        boolean r0 = !ku5.c.k(getContext());
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r2 = true;
    L6:
        if (r0 == false) goto L9;
        if (r2 == false) goto L9;
        return true;
    L9:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    public final void ba0() {
        ToolbarData r0 = (ToolbarData) W90().getToolbarData().getValue();
        LinearLayout r1 = null;
        if (r0 == null) goto L5;
        ToolbarData.MenuItem[] r2 = r0.getMenus();
    L6:
        int r3 = 0;
        boolean r4 = true;
        if (r2 != null) goto L9;
    L15:
        boolean r5 = true;
    L17:
        if ((!r5) == true) goto L19;
    L21:
        r4 = false;
    L22:
        LinearLayout r6 = this.g;
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
        r6 = null;
    L25:
        if (r4 == true) goto L28;
        r3 = 8;
    L28:
        r6.setVisibility(r3);
        LinearLayout r7 = this.g;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
    L33:
        if (r1.getHeight() != 0) goto L37;
        if (r4 == false) goto L38;
        Y90(ScrollDirection.UP);
        return;
    L38:
        return;
    L37:
        return;
    L31:
        r1 = r7;
        goto L33
    L19:
        if (X90() == true) goto L21;
    L9:
        if (r2.length != 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L15;
        r5 = false;
        goto L17
    L11:
        r8 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroyView() {
        ValueAnimator r1 = null;
        W90().setWebTouchListener(null);
        ValueAnimator r0 = this.l;
        if (r0 != null) goto L5;
    L14:
        super.onDestroyView();
        return;
    L5:
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
        r0 = null;
    L8:
        if (r0.isRunning() == false) goto L14;
        ValueAnimator r2 = this.l;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
    L13:
        r1.cancel();
        goto L14
    L12:
        r1 = r2;
        goto L13
    }

    public final View V90(BitableFabModel.BitableFabItem r6) {
        if (Intrinsics.areEqual(r6.getId(), BitableToolboxViewModel.FAB_SUPER_AGENT) == false) goto L6;
        BitableSuperAgentFabView r0 = new BitableSuperAgentFabView(requireContext(), null, 6, 0);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(0, -2);
        r1.weight = 1.0f;
        r1.setMarginStart(n.d(16));
        r0.setLayoutParams(r1);
        r0.setTag(r6.getId());
        r0.setEnabled(!r6.isDisabled());
        r0.setCarouselTexts(r6.carouselTexts);
        r0.setOnClickListener(new b(this, r6));
        return r0;
    L6:
        EBitableFab r2 = EBitableFab.getEBitableFabByName(r6.getId());
        FabView r3 = new FabView(requireContext());
        r3.setType(r2.type);
        r3.setImageRes(r2.imageRes);
        r3.setColorRes(r2.colorRes);
        r3.setImageTintRes(r2.imageTintColorRes);
        r3.setTextRes(r6.getTitle());
        r3.setTag(r6.getId());
        r3.setEnabled(!r6.isDisabled());
        r3.setOnClickListener(new c(this, r6));
        r3.b(r3.getContext());
        return r3;
    }

    public final void Y90(ScrollDirection r9) {
        if (isAdded() == false) goto L45;
        LinearLayout r0 = this.g;
        ValueAnimator r2 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
        r0 = null;
    L8:
        if (r0.getVisibility() == 0) goto L11;
        return;
    L11:
        if (this.k != r9) goto L13;
        return;
    L13:
        ValueAnimator r1 = this.l;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
        r1 = null;
    L17:
        if (r1.isRunning() == false) goto L22;
        ValueAnimator r3 = this.l;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
        r3 = null;
    L21:
        r3.cancel();
    L22:
        this.k = r9;
        LinearLayout r4 = this.g;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
        r4 = null;
    L25:
        float r5 = r4.getMeasuredHeight();
        float r6 = getResources().getDimensionPixelSize(2131165457);
        ScrollDirection r7 = ScrollDirection.UP;
        if (r9 == r7) goto L29;
        r6 = 0.0f;
    L29:
        ValueAnimator r8 = this.l;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
        r8 = null;
    L32:
        r8.setFloatValues(new float[]{r5, r6});
        ValueAnimator r10 = this.l;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
    L36:
        r2.start();
        if (r9 != r7) goto L46;
        BitableToolboxAnalytic r11 = W90().getToolboxAnalytic();
        if (r11 == null) goto L47;
        HashMap r12 = new HashMap();
        String r13 = ((BitableAnalytic) r11).a.b();
        if (r13 == null) goto L43;
        r12.put("mobile_grid_type", r13);
    L43:
        r11.t(BitableToolboxAnalytic.ToolboxEvent.BOTTOM_TOOLBAR_VIEW, r12);
        return;
    L47:
        return;
    L46:
        return;
    L35:
        r2 = r10;
        goto L36
    }

    public final void Z90(BitableFabModel.BitableFabItem[] r14) {
        boolean r0 = false;
        if (r14 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        String r4 = null;
        LinearLayout r5 = null;
        if (r2 == false) goto L21;
        LinearLayout r16 = this.f;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
    L18:
        r5.removeAllViews();
        return;
    L17:
        r5 = r16;
        goto L18
    L21:
        if (getContext() != null) goto L24;
        tt5.a.d("BitableToolbarFragment", "updateFabItems context is null");
        return;
    L24:
        LinearLayout r3 = this.f;
        if (r3 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r3 = null;
    L27:
        int r6 = r3.getChildCount();
        int r7 = 0;
    L29:
        if (r7 >= r14.length) goto L51;
        if (r7 >= r6) goto L51;
        LinearLayout r8 = this.f;
        if (r8 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r8 = null;
    L34:
        View r9 = r8.getChildAt(r7);
        BitableFabModel.BitableFabItem r10 = r14[r7];
        String r11 = r10.getId();
        Object r12 = r9.getTag();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.String");
        if (TextUtils.equals(r11, (String) r12) == true) goto L37;
    L40:
        boolean r13 = true;
    L41:
        if (r13 == false) goto L49;
        LinearLayout r17 = this.f;
        if (r17 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r17 = null;
    L45:
        r17.removeView(r9);
        LinearLayout r18 = this.f;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r18 = null;
    L48:
        r18.addView(V90(r14[r7]), r7);
    L49:
        r7 = r7 + 1;
        goto L29
    L37:
        if (r9.isEnabled() != (!r10.isDisabled())) goto L40;
        r13 = false;
    L51:
        if (r7 >= r14.length) goto L56;
        LinearLayout r19 = this.f;
        if (r19 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r19 = null;
    L55:
        r19.addView(V90(r14[r7]), r7);
        r7 = r7 + 1;
        goto L51
    L56:
        if (r7 >= r6) goto L61;
        LinearLayout r20 = this.f;
        if (r20 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r20 = null;
    L60:
        r20.removeViews(r14.length, r6 - r14.length);
    L61:
        aa0();
        int r21 = r14.length;
        int r22 = 0;
    L62:
        if (r22 >= r21) goto L67;
        BitableFabModel.BitableFabItem r23 = r14[r22];
        if (Intrinsics.areEqual(r23.getId(), BitableToolboxViewModel.FAB_SUPER_AGENT) == true) goto L68;
        r22 = r22 + 1;
    L68:
        if (r23 == null) goto L134;
        BitableToolboxAnalytic r110 = W90().getToolboxAnalytic();
        if (r110 == null) goto L135;
        kr4.a r24 = ((BitableAnalytic) r110).a;
        if (r24 == null) goto L74;
        SceneModel r26 = r24.e();
    L75:
        String[] r27 = new String[2];
        if (r26 == null) goto L78;
        String r28 = r26.getBlockId();
    L79:
        r27[0] = r28;
        if (r26 == null) goto L82;
        r4 = r26.getViewId();
    L82:
        r27[1] = r4;
        String r29 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r27), ",", null, null, 0, null, null, 62, null);
        if (Intrinsics.areEqual(r29, r110.c) == true) goto L136;
        r110.c = r29;
        if (r26 != null) goto L88;
    L90:
        boolean r30 = false;
    L91:
        if (r30 == false) goto L93;
        String r31 = "dashboard";
    L94:
        if (r26 != null) goto L96;
    L98:
        boolean r32 = false;
    L99:
        if (r32 == false) goto L101;
        String r1 = "kanban";
    L122:
        HashMap r33 = new HashMap();
        r33.put("entrance_type", r31);
        r33.put("view_type", r1);
        r110.t("ccm_bitable_ai_bottombar_entrance_view", r33);
        return;
    L101:
        if (r26 != null) goto L103;
    L105:
        boolean r34 = false;
    L106:
        if (r34 == false) goto L108;
        r1 = "calendar";
        goto L122
    L108:
        if (r26 != null) goto L110;
    L112:
        boolean r36 = false;
    L113:
        if (r36 == false) goto L115;
        r1 = "gantt";
        goto L122
    L115:
        if (r26 != null) goto L117;
    L119:
        if (r0 == false) goto L121;
        r1 = CoverConstants$CoverSource.GALLERY;
        goto L122
    L121:
        r1 = "grid";
        goto L122
    L117:
        if (r26.isGallery() != true) goto L119;
        r0 = true;
        goto L119
    L110:
        if (r26.isGantt() != true) goto L112;
        r36 = true;
        goto L113
    L103:
        if (r26.isCalendar() != true) goto L105;
        r34 = true;
        goto L106
    L96:
        if (r26.isKanban() != true) goto L98;
        r32 = true;
        goto L99
    L93:
        r31 = "tables";
        goto L94
    L88:
        if (r26.isDashBoard() != true) goto L90;
        r30 = true;
        goto L91
    L136:
        return;
    L78:
        r28 = null;
        goto L79
    L74:
        r26 = null;
        goto L75
    L135:
        return;
    L134:
        return;
    L67:
        r23 = null;
        goto L68
    L5:
        if (r14.length != 0) goto L7;
        boolean r37 = true;
    L8:
        if (r37 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r37 = false;
        goto L8
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        ba0();
        aa0();
    }

    public static final void U90(BitableToolboxFragment r10, ScrollDirection r11) {
        BitableFabModel.BitableFabItem[] r0 = (BitableFabModel.BitableFabItem[]) r10.W90().getFabData().getValue();
        if (r0 == null) goto L30;
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        int r4 = 0;
        boolean r5 = false;
    L5:
        if (r4 >= r2) goto L21;
        BitableFabModel.BitableFabItem r6 = r0[r4];
        if (TextUtils.equals(r6.getId(), "shareDashboard") == false) goto L9;
    L19:
        r5 = true;
    L20:
        r4 = r4 + 1;
        goto L5
    L9:
        if (TextUtils.equals(r6.getId(), BitableToolboxViewModel.FAB_SUPER_AGENT) == false) goto L18;
        SceneModel r7 = r10.W90().getSceneModel();
        if (r7 != null) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L18;
    L13:
        if (r7.isDashBoard() != true) goto L15;
        r8 = true;
    L18:
        r1.add(r6);
        goto L20
    L21:
        if (r5 == true) goto L23;
        return;
    L23:
        if (r11 != ScrollDirection.UP) goto L25;
        r10.Z90(r0);
        return;
    L25:
        r10.Z90((BitableFabModel.BitableFabItem[]) r1.toArray(new BitableFabModel.BitableFabItem[0]));
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        LinearLayout r5 = (LinearLayout) r3.findViewById(2131389086);
        LinearLayout r6 = (LinearLayout) r3.findViewById(2131372038);
        this.f = r6;
        ToolbarMenuAdapter r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r6 = null;
    L5:
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L9:
        if (r8 == null) goto L11;
        int r9 = r8.bottomMargin;
    L12:
        this.m = r9;
        this.g = (LinearLayout) r3.findViewById(2131389067);
        this.h = r3.findViewById(2131389080);
        this.j = new GridLayoutManager(getContext(), -1);
        ToolbarMenuAdapter r10 = new ToolbarMenuAdapter();
        Function1<String, Unit> r11 = new BitableToolboxFragment$initView$1$1(this);
        Intrinsics.checkNotNullParameter(r11, "listener");
        r10.b = r11;
        this.i = r10;
        RecyclerView r12 = this.h;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mMenuRV");
        r12 = null;
    L15:
        RecyclerView.LayoutManager r13 = this.j;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mGridLayoutManager");
        r13 = null;
    L18:
        r12.setLayoutManager(r13);
        ToolbarMenuAdapter r14 = this.i;
        if (r14 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mMenuAdapter");
    L22:
        r12.setAdapter(r0);
        BitableToolboxViewModel r16 = W90();
        r16.getFabData().observe(getViewLifecycleOwner(), new BitableToolboxFragment$initDataObserver$1$1(this));
        r16.getFabVisible().observe(getViewLifecycleOwner(), new BitableToolboxFragment$initDataObserver$1$2(this));
        r16.getBottomPanelHeight().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.toolbox.view.a(this));
        r16.getToolbarData().observe(getViewLifecycleOwner(), new BitableToolboxFragment$initDataObserver$1$4(this));
        ValueAnimator r17 = new ValueAnimator();
        r17.setInterpolator(new AccelerateDecelerateInterpolator());
        r17.setDuration(200);
        r17.addUpdateListener(new com.bytedance.ee.bear.bitable.toolbox.view.b(this));
        this.l = r17;
        W90().setWebTouchListener(new com.bytedance.ee.bear.bitable.toolbox.view.c(new GestureDetector(getContext(), new d(this))));
        return;
    L21:
        r0 = r14;
        goto L22
    L11:
        r9 = 0;
        goto L12
    L8:
        r8 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559176, r3, false);
    }
}
