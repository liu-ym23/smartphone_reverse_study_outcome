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
import com.alibaba.gaiax.render.view.GXViewKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentFabView;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import com.bytedance.ee.bear.bitable.toolbox.model.fab.BitableFabModel;
import com.bytedance.ee.bear.bitable.toolbox.model.fab.EBitableFab;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.ToolbarData;
import com.bytedance.ee.bear.bitable.toolbox.viewmodel.BitableToolboxViewModel;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020#H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0015H\u0002J\u001d\u0010/\u001a\u00020#2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002¢\u0006\u0002\u00103J\u001d\u00104\u001a\u00020#2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002¢\u0006\u0002\u00103J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000202H\u0002J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020#H\u0002J\b\u0010=\u001a\u00020#H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/view/BitableToolboxFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "mToolboxViewModel", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "getMToolboxViewModel", "()Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "mToolboxViewModel$delegate", "Lkotlin/Lazy;", "mToolboxContainer", "Landroid/widget/LinearLayout;", "mFabContainer", "mToolbarContainer", "mMenuRV", "Landroidx/recyclerview/widget/RecyclerView;", "mMenuAdapter", "Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter;", "mGridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "mLastScrollDirection", "Lcom/bytedance/ee/bear/bitable/toolbox/view/BitableToolboxFragment$ScrollDirection;", "mToolbarScrollAnim", "Landroid/animation/ValueAnimator;", "defaultFabMarginBottom", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "initView", "rootView", "initDataObserver", "updateToolboxBottomPadding", "height", "initToolbarScrollStrategy", "showToolbarScrollAnim", "direction", "updateDashboardFab", "updateFabItems", "items", "", "Lcom/bytedance/ee/bear/bitable/toolbox/model/fab/BitableFabModel$BitableFabItem;", "([Lcom/bytedance/ee/bear/bitable/toolbox/model/fab/BitableFabModel$BitableFabItem;)V", "reportFabVisibility", "createFabItemView", MapController.ITEM_LAYER_TAG, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isPhoneLandscape", "", "updateFabVisibility", "updateToolbarVisibility", "ScrollDirection", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableToolboxFragment extends BaseFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f216007n = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f216008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f216009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f216010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f216011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ToolbarMenuAdapter f216012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GridLayoutManager f216013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ScrollDirection f216014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f216015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f216016m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/view/BitableToolboxFragment$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection DOWN = null;
        public static final ScrollDirection UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollDirection[] f216017a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f216018b = null;

        public static EnumEntries<ScrollDirection> getEntries() {
            return f216018b;
        }

        static {
            ScrollDirection r100 = new ScrollDirection("UP", 0);
            UP = r100;
            ScrollDirection r101 = new ScrollDirection("DOWN", 1);
            DOWN = r101;
            ScrollDirection[] r102 = {r100, r101};
            f216017a = r102;
            f216018b = EnumEntriesKt.enumEntries(r102);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) f216017a.clone();
        }

        public static ScrollDirection valueOf(String r100) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r100);
        }

        public ScrollDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableToolboxFragment f216019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BitableFabModel.BitableFabItem f216020d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            BitableToolboxFragment r101 = this.f216019c;
            int r102 = BitableToolboxFragment.f216007n;
            BitableToolboxAnalytic r103 = r101.W90().getToolboxAnalytic();
            if (r103 == null) goto L46;
            kr4.a r104 = r103.f209805a;
            if (r104 == null) goto L7;
            SceneModel r105 = r104.e();
        L8:
            boolean r106 = false;
            if (r105 != null) goto L11;
        L13:
            boolean r107 = false;
        L14:
            if (r107 == false) goto L16;
            String r108 = "dashboard";
        L17:
            if (r105 != null) goto L19;
        L21:
            boolean r109 = false;
        L22:
            if (r109 == false) goto L24;
            String r110 = "kanban";
        L45:
            HashMap r111 = new HashMap();
            r111.put("click", "AI_qa");
            r111.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r108);
            r111.put(BytedCertConstant.IntentKey.VIEW_TYPE, r110);
            r103.t("ccm_bitable_ai_bottombar_entrance_click", r111);
            goto L46
        L24:
            if (r105 != null) goto L26;
        L28:
            boolean r112 = false;
        L29:
            if (r112 == false) goto L31;
            r110 = "calendar";
            goto L45
        L31:
            if (r105 != null) goto L33;
        L35:
            boolean r113 = false;
        L36:
            if (r113 == false) goto L38;
            r110 = "gantt";
            goto L45
        L38:
            if (r105 != null) goto L40;
        L42:
            if (r106 == false) goto L44;
            r110 = "gallery";
            goto L45
        L44:
            r110 = GXViewKey.VIEW_TYPE_CONTAINER_GRID;
            goto L45
        L40:
            if (r105.isGallery() != true) goto L42;
            r106 = true;
            goto L42
        L33:
            if (r105.isGantt() != true) goto L35;
            r113 = true;
            goto L36
        L26:
            if (r105.isCalendar() != true) goto L28;
            r112 = true;
            goto L29
        L19:
            if (r105.isKanban() != true) goto L21;
            r109 = true;
            goto L22
        L16:
            r108 = "tables";
            goto L17
        L11:
            if (r105.isDashBoard() != true) goto L13;
            r107 = true;
            goto L14
        L7:
            r105 = null;
        L46:
            this.f216019c.W90().clickFabItem(this.f216020d.getId());
        }

        public b(BitableToolboxFragment r100, BitableFabModel.BitableFabItem r101) {
            this.f216019c = r100;
            this.f216020d = r101;
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableToolboxFragment f216021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BitableFabModel.BitableFabItem f216022d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            BitableToolboxFragment r101 = this.f216021c;
            int r102 = BitableToolboxFragment.f216007n;
            r101.W90().clickFabItem(this.f216022d.getId());
        }

        public c(BitableToolboxFragment r100, BitableFabModel.BitableFabItem r101) {
            this.f216021c = r100;
            this.f216022d = r101;
        }
    }

    static {
    }

    public final BitableToolboxViewModel W90() {
        return (BitableToolboxViewModel) this.f216008e.getValue();
    }

    public final void aa0() {
        LinearLayout r100 = this.f216009f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r100 = null;
    L5:
        int r101 = r100.getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L22;
        LinearLayout r103 = this.f216009f;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r103 = null;
    L10:
        View r104 = r103.getChildAt(r102);
        if ((r104 instanceof FabView) == false) goto L21;
        FabView r105 = (FabView) r104;
        if ((r105.getTag() instanceof String) == false) goto L21;
        Object r106 = r105.getTag();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.String");
        if (TextUtils.equals((String) r106, "createRecord") == false) goto L21;
        if (X90() == false) goto L19;
        int r107 = 8;
    L20:
        r105.setVisibility(r107);
        goto L21
    L19:
        r107 = 0;
    L21:
        r102 = r102 + 1;
        goto L6
    }

    public BitableToolboxFragment() {
        this.f216008e = LazyKt.lazy(new BitableToolboxFragment$mToolboxViewModel$2(this));
    }

    public final boolean X90() {
        boolean r100 = !ku5.c.k(getContext());
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r100 == false) goto L9;
        if (r101 == false) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public final void ba0() {
        ToolbarData r100 = W90().getToolbarData().getValue();
        LinearLayout r101 = null;
        if (r100 == null) goto L5;
        ToolbarData.MenuItem[] r102 = r100.getMenus();
    L6:
        int r103 = 0;
        boolean r104 = true;
        if (r102 != null) goto L9;
    L15:
        boolean r105 = true;
    L17:
        if ((!r105) == true) goto L19;
    L21:
        r104 = false;
    L22:
        LinearLayout r106 = this.f216010g;
        if (r106 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
        r106 = null;
    L25:
        if (r104 == true) goto L28;
        r103 = 8;
    L28:
        r106.setVisibility(r103);
        LinearLayout r107 = this.f216010g;
        if (r107 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
    L33:
        if (r101.getHeight() != 0) goto L37;
        if (r104 == false) goto L38;
        Y90(ScrollDirection.UP);
        return;
    L38:
        return;
    L37:
        return;
    L31:
        r101 = r107;
        goto L33
    L19:
        if (X90() == true) goto L21;
    L9:
        if (r102.length != 0) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == true) goto L15;
        r105 = false;
        goto L17
    L11:
        r108 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ValueAnimator r100 = null;
        W90().setWebTouchListener(null);
        ValueAnimator r101 = this.f216015l;
        if (r101 != null) goto L5;
    L14:
        super.onDestroyView();
        return;
    L5:
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
        r101 = null;
    L8:
        if (r101.isRunning() == false) goto L14;
        ValueAnimator r102 = this.f216015l;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
    L13:
        r100.cancel();
        goto L14
    L12:
        r100 = r102;
        goto L13
    }

    public final View V90(BitableFabModel.BitableFabItem r100) {
        if (Intrinsics.areEqual(r100.getId(), BitableToolboxViewModel.FAB_SUPER_AGENT) == false) goto L6;
        BitableSuperAgentFabView r101 = new BitableSuperAgentFabView(requireContext(), null, 6, 0);
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(0, -2);
        r102.weight = 1.0f;
        r102.setMarginStart(n.d(16));
        r101.setLayoutParams(r102);
        r101.setTag(r100.getId());
        r101.setEnabled(!r100.isDisabled());
        r101.setCarouselTexts(r100.carouselTexts);
        r101.setOnClickListener(new b(this, r100));
        return r101;
    L6:
        EBitableFab r103 = EBitableFab.getEBitableFabByName(r100.getId());
        FabView r104 = new FabView(requireContext());
        r104.setType(r103.type);
        r104.setImageRes(r103.imageRes);
        r104.setColorRes(r103.colorRes);
        r104.setImageTintRes(r103.imageTintColorRes);
        r104.setTextRes(r100.getTitle());
        r104.setTag(r100.getId());
        r104.setEnabled(!r100.isDisabled());
        r104.setOnClickListener(new c(this, r100));
        r104.b(r104.getContext());
        return r104;
    }

    public final void Y90(ScrollDirection r100) {
        if (isAdded() == false) goto L45;
        LinearLayout r101 = this.f216010g;
        ValueAnimator r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
        r101 = null;
    L8:
        if (r101.getVisibility() == 0) goto L11;
        return;
    L11:
        if (this.f216014k != r100) goto L13;
        return;
    L13:
        ValueAnimator r103 = this.f216015l;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
        r103 = null;
    L17:
        if (r103.isRunning() == false) goto L22;
        ValueAnimator r104 = this.f216015l;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
        r104 = null;
    L21:
        r104.cancel();
    L22:
        this.f216014k = r100;
        LinearLayout r105 = this.f216010g;
        if (r105 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
        r105 = null;
    L25:
        float r106 = r105.getMeasuredHeight();
        float r107 = getResources().getDimensionPixelSize(R.dimen.bitable_toolbar_height);
        ScrollDirection r108 = ScrollDirection.UP;
        if (r100 == r108) goto L29;
        r107 = 0.0f;
    L29:
        ValueAnimator r109 = this.f216015l;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
        r109 = null;
    L32:
        r109.setFloatValues(new float[]{r106, r107});
        ValueAnimator r110 = this.f216015l;
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarScrollAnim");
    L36:
        r102.start();
        if (r100 != r108) goto L46;
        BitableToolboxAnalytic r111 = W90().getToolboxAnalytic();
        if (r111 == null) goto L47;
        HashMap r112 = new HashMap();
        String r113 = r111.f209805a.b();
        if (r113 == null) goto L43;
        r112.put("mobile_grid_type", r113);
    L43:
        r111.t(BitableToolboxAnalytic.ToolboxEvent.BOTTOM_TOOLBAR_VIEW, r112);
        return;
    L47:
        return;
    L46:
        return;
    L35:
        r102 = r110;
        goto L36
    }

    public final void Z90(BitableFabModel.BitableFabItem[] r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L11:
        boolean r101 = true;
    L12:
        String r102 = null;
        LinearLayout r103 = null;
        if (r101 == false) goto L21;
        LinearLayout r111 = this.f216009f;
        if (r111 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
    L18:
        r103.removeAllViews();
        return;
    L17:
        r103 = r111;
        goto L18
    L21:
        if (getContext() != null) goto L24;
        tt5.a.d("BitableToolbarFragment", "updateFabItems context is null");
        return;
    L24:
        LinearLayout r104 = this.f216009f;
        if (r104 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r104 = null;
    L27:
        int r105 = r104.getChildCount();
        int r106 = 0;
    L29:
        if (r106 >= r110.length) goto L51;
        if (r106 >= r105) goto L51;
        LinearLayout r107 = this.f216009f;
        if (r107 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r107 = null;
    L34:
        View r108 = r107.getChildAt(r106);
        BitableFabModel.BitableFabItem r109 = r110[r106];
        String r112 = r109.getId();
        Object r113 = r108.getTag();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.String");
        if (TextUtils.equals(r112, (String) r113) == true) goto L37;
    L40:
        boolean r114 = true;
    L41:
        if (r114 == false) goto L49;
        LinearLayout r115 = this.f216009f;
        if (r115 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r115 = null;
    L45:
        r115.removeView(r108);
        LinearLayout r116 = this.f216009f;
        if (r116 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r116 = null;
    L48:
        r116.addView(V90(r110[r106]), r106);
    L49:
        r106 = r106 + 1;
        goto L29
    L37:
        if (r108.isEnabled() != (!r109.isDisabled())) goto L40;
        r114 = false;
    L51:
        if (r106 >= r110.length) goto L56;
        LinearLayout r117 = this.f216009f;
        if (r117 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r117 = null;
    L55:
        r117.addView(V90(r110[r106]), r106);
        r106 = r106 + 1;
        goto L51
    L56:
        if (r106 >= r105) goto L61;
        LinearLayout r118 = this.f216009f;
        if (r118 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r118 = null;
    L60:
        r118.removeViews(r110.length, r105 - r110.length);
    L61:
        aa0();
        int r119 = r110.length;
        int r120 = 0;
    L62:
        if (r120 >= r119) goto L67;
        BitableFabModel.BitableFabItem r121 = r110[r120];
        if (Intrinsics.areEqual(r121.getId(), BitableToolboxViewModel.FAB_SUPER_AGENT) == true) goto L68;
        r120 = r120 + 1;
    L68:
        if (r121 == null) goto L134;
        BitableToolboxAnalytic r122 = W90().getToolboxAnalytic();
        if (r122 == null) goto L135;
        kr4.a r123 = r122.f209805a;
        if (r123 == null) goto L74;
        SceneModel r124 = r123.e();
    L75:
        String[] r125 = new String[2];
        if (r124 == null) goto L78;
        String r126 = r124.getBlockId();
    L79:
        r125[0] = r126;
        if (r124 == null) goto L82;
        r102 = r124.getViewId();
    L82:
        r125[1] = r102;
        String r127 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r125), ",", null, null, 0, null, null, 62, null);
        if (Intrinsics.areEqual(r127, r122.f215993c) == true) goto L136;
        r122.f215993c = r127;
        if (r124 != null) goto L88;
    L90:
        boolean r128 = false;
    L91:
        if (r128 == false) goto L93;
        String r129 = "dashboard";
    L94:
        if (r124 != null) goto L96;
    L98:
        boolean r130 = false;
    L99:
        if (r130 == false) goto L101;
        String r131 = "kanban";
    L122:
        HashMap r132 = new HashMap();
        r132.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r129);
        r132.put(BytedCertConstant.IntentKey.VIEW_TYPE, r131);
        r122.t("ccm_bitable_ai_bottombar_entrance_view", r132);
        return;
    L101:
        if (r124 != null) goto L103;
    L105:
        boolean r133 = false;
    L106:
        if (r133 == false) goto L108;
        r131 = "calendar";
        goto L122
    L108:
        if (r124 != null) goto L110;
    L112:
        boolean r134 = false;
    L113:
        if (r134 == false) goto L115;
        r131 = "gantt";
        goto L122
    L115:
        if (r124 != null) goto L117;
    L119:
        if (r100 == false) goto L121;
        r131 = "gallery";
        goto L122
    L121:
        r131 = GXViewKey.VIEW_TYPE_CONTAINER_GRID;
        goto L122
    L117:
        if (r124.isGallery() != true) goto L119;
        r100 = true;
        goto L119
    L110:
        if (r124.isGantt() != true) goto L112;
        r134 = true;
        goto L113
    L103:
        if (r124.isCalendar() != true) goto L105;
        r133 = true;
        goto L106
    L96:
        if (r124.isKanban() != true) goto L98;
        r130 = true;
        goto L99
    L93:
        r129 = "tables";
        goto L94
    L88:
        if (r124.isDashBoard() != true) goto L90;
        r128 = true;
        goto L91
    L136:
        return;
    L78:
        r126 = null;
        goto L79
    L74:
        r124 = null;
        goto L75
    L135:
        return;
    L134:
        return;
    L67:
        r121 = null;
        goto L68
    L5:
        if (r110.length != 0) goto L7;
        boolean r135 = true;
    L8:
        if (r135 == true) goto L11;
        r101 = false;
        goto L12
    L7:
        r135 = false;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        ba0();
        aa0();
    }

    public static final void U90(BitableToolboxFragment r110, ScrollDirection r111) {
        BitableFabModel.BitableFabItem[] r100 = r110.W90().getFabData().getValue();
        if (r100 == null) goto L30;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
        boolean r104 = false;
    L5:
        if (r103 >= r102) goto L21;
        BitableFabModel.BitableFabItem r105 = r100[r103];
        if (TextUtils.equals(r105.getId(), "shareDashboard") == false) goto L9;
    L19:
        r104 = true;
    L20:
        r103 = r103 + 1;
        goto L5
    L9:
        if (TextUtils.equals(r105.getId(), BitableToolboxViewModel.FAB_SUPER_AGENT) == false) goto L18;
        SceneModel r106 = r110.W90().getSceneModel();
        if (r106 != null) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r107 == false) goto L18;
    L13:
        if (r106.isDashBoard() != true) goto L15;
        r107 = true;
    L18:
        r101.add(r105);
        goto L20
    L21:
        if (r104 == true) goto L23;
        return;
    L23:
        if (r111 != ScrollDirection.UP) goto L25;
        r110.Z90(r100);
        return;
    L25:
        r110.Z90((BitableFabModel.BitableFabItem[]) r101.toArray(new BitableFabModel.BitableFabItem[0]));
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.toolbox_container);
        LinearLayout r103 = (LinearLayout) r100.findViewById(R.id.fab_container);
        this.f216009f = r103;
        ToolbarMenuAdapter r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r103 = null;
    L5:
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L9:
        if (r106 == null) goto L11;
        int r107 = r106.bottomMargin;
    L12:
        this.f216016m = r107;
        this.f216010g = (LinearLayout) r100.findViewById(R.id.toolbar_container);
        this.f216011h = (RecyclerView) r100.findViewById(R.id.toolbar_menu_rv);
        this.f216013j = new GridLayoutManager(getContext(), -1);
        ToolbarMenuAdapter r108 = new ToolbarMenuAdapter();
        Function1<String, Unit> r109 = new BitableToolboxFragment$initView$1$1(this);
        Intrinsics.checkNotNullParameter(r109, "listener");
        r108.f216027b = r109;
        this.f216012i = r108;
        RecyclerView r110 = this.f216011h;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mMenuRV");
        r110 = null;
    L15:
        GridLayoutManager r111 = this.f216013j;
        if (r111 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mGridLayoutManager");
        r111 = null;
    L18:
        r110.setLayoutManager(r111);
        ToolbarMenuAdapter r112 = this.f216012i;
        if (r112 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mMenuAdapter");
    L22:
        r110.setAdapter(r104);
        BitableToolboxViewModel r113 = W90();
        r113.getFabData().observe(getViewLifecycleOwner(), new BitableToolboxFragment$initDataObserver$1$1(this));
        r113.getFabVisible().observe(getViewLifecycleOwner(), new BitableToolboxFragment$initDataObserver$1$2(this));
        r113.getBottomPanelHeight().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.toolbox.view.a(this));
        r113.getToolbarData().observe(getViewLifecycleOwner(), new BitableToolboxFragment$initDataObserver$1$4(this));
        ValueAnimator r114 = new ValueAnimator();
        r114.setInterpolator(new AccelerateDecelerateInterpolator());
        r114.setDuration(200);
        r114.addUpdateListener(new com.bytedance.ee.bear.bitable.toolbox.view.b(this));
        this.f216015l = r114;
        W90().setWebTouchListener(new com.bytedance.ee.bear.bitable.toolbox.view.c(new GestureDetector(getContext(), new d(this))));
        return;
    L21:
        r104 = r112;
        goto L22
    L11:
        r107 = 0;
        goto L12
    L8:
        r106 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_toolbox_layout, r101, false);
    }
}
