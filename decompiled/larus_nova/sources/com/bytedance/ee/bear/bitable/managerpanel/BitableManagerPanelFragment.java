package com.bytedance.ee.bear.bitable.managerpanel;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.panel.EPanelItemIcon;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0006\u0010 \u001a\u00020\u0019J\b\u0010!\u001a\u00020\u0019H\u0002J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0006\u0010,\u001a\u00020+J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0019H\u0016J\b\u00101\u001a\u00020\u0012H\u0016J\b\u00106\u001a\u00020\u0019H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u000203X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "<init>", "()V", "mManagerPanelViewModel", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelViewModel;", "getMManagerPanelViewModel", "()Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelViewModel;", "mManagerPanelViewModel$delegate", "Lkotlin/Lazy;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mAdapter", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelAdapter;", "mRoot", "Landroid/view/ViewGroup;", "mBottomFixedBtnVisible", "", "mBottomFixedAddDocX", "Landroid/view/View;", "addDocX", "onCreateContentView", KtvSubElement.CONTAINER, "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "initPanelStyle", "initView", RootDescription.ROOT_ELEMENT, "initAddTableView", "bindAddDocxView", "updateData", "data", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData;", "updateBottomFixedBtn", "setDisable", "panel", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "onDraw", "getBottomViewHeight", "", "getDocXBottomHeight", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", LiveCommonConstants.REASON_ON_DEDTROY, "openIndependentMode", "exitAnimDuration", "", "getExitAnimDuration", "()J", "setViewModelInactive", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableManagerPanelFragment extends BaseActionPanelFragment implements ViewTreeObserver.OnDrawListener {
    public static final /* synthetic */ int O = 0;
    public final Lazy G;
    public RecyclerView H;
    public BitableManagerPanelAdapter I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ViewGroup f214659J;
    public boolean K;
    public View L;
    public boolean M;
    public final long N;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableManagerPanelFragment f214660a;

        public b(BitableManagerPanelFragment r100) {
            this.f214660a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            BitableManagerPanelData r111 = (BitableManagerPanelData) r110;
            final BitableManagerPanelFragment r100 = this.f214660a;
            int r101 = BitableManagerPanelFragment.O;
            r100.getClass();
            if (r111 == null) goto L57;
            r100.va0(r111.getTitle());
            r100.Aa0();
            List<MultiItemEntity> r102 = r111.convert2MultiItemEntities();
            if (r102 == null) goto L58;
            BitableManagerPanelAdapter r103 = r100.I;
            if (r103 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            r103 = null;
        L9:
            boolean r104 = r103.getData().isEmpty();
            BitableManagerPanelAdapter r105 = r100.I;
            if (r105 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            r105 = null;
        L12:
            r105.A2(r102);
            Function0<List<? extends Unit>> r106 = new BitableManagerPanelFragment$updateData$1$1$expandLastExpandItems$1(r100);
            if (r104 == false) goto L50;
            Integer r112 = r111.getActiveTableIndex();
            int r107 = 0;
            if (r112 == null) goto L20;
            int r113 = r112.intValue();
            BitableManagerPanelAdapter r108 = r100.I;
            if (r108 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            r108 = null;
        L19:
            r108.expand(r113, false);
        L20:
            r106.invoke();
            if (r100.H != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        L23:
            List<MultiItemEntity> r109 = r102;
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
            Iterator<T> r115 = r109.iterator();
        L25:
            if (r115.hasNext() == false) goto L59;
            T r116 = r115.next();
            int r117 = r107 + 1;
            if (r107 >= 0) goto L29;
            CollectionsKt.throwIndexOverflow();
        L29:
            MultiItemEntity r118 = (MultiItemEntity) r116;
            if ((r118 instanceof BitableManagerPanelData.ViewBean) == false) goto L34;
            if (((BitableManagerPanelData.ViewBean) r118).getActive() == false) goto L34;
        L37:
            RecyclerView r119 = r100.H;
            if (r119 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            r119 = null;
        L40:
            int r120 = r119.getContext().getResources().getDimensionPixelOffset(R.dimen.bitable_manager_panel_item_height);
            RecyclerView r121 = r100.H;
            if (r121 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            r121 = null;
        L43:
            RecyclerView.LayoutManager r122 = r121.getLayoutManager();
            if ((r122 instanceof LinearLayoutManager) == false) goto L46;
            LinearLayoutManager r123 = (LinearLayoutManager) r122;
        L47:
            if (r123 == null) goto L49;
            r123.scrollToPositionWithOffset(r107, r120);
        L49:
            r114.add(Unit.INSTANCE);
            r107 = r117;
            goto L25
        L46:
            r123 = null;
        L34:
            if ((r118 instanceof BitableManagerPanelData.BlockBean) == false) goto L49;
            if (((BitableManagerPanelData.BlockBean) r118).isActiveWithoutSubItem() == false) goto L49;
        L59:
            return;
        L50:
            List<? extends Unit> r124 = r106.invoke();
            return;
        L58:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final int ha0() {
        if (this.M == false) goto L6;
        return n.l(getContext(), R.dimen.bitable_manager_panel_with_docx_height);
    L6:
        return super.ha0();
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        if (this.K == true) goto L5;
        return;
    L5:
        int[] r100 = new int[2];
        ViewGroup r101 = this.f214659J;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        r101 = null;
    L8:
        r101.getLocationInWindow(r100);
        int[] r102 = new int[2];
        ka0().getLocationInWindow(r102);
        boolean r103 = true;
        if ((r102[1] - r100[1]) > 0) goto L12;
        r103 = false;
    L12:
        na0(r103);
    }

    public final BitableManagerPanelViewModel ya0() {
        return (BitableManagerPanelViewModel) this.G.getValue();
    }

    public BitableManagerPanelFragment() {
        this.G = LazyKt.lazy(new BitableManagerPanelFragment$mManagerPanelViewModel$2(this));
        this.N = 300;
    }

    public final void Aa0() {
        BitableManagerPanelData r100 = ya0().getPanelData().getValue();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        BitableManagerPanelData.BottomFixedData[] r102 = r100.getBottomFixedDatas();
    L6:
        int r103 = 0;
        if (ku5.c.k(getContext()) == false) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r102 != null) goto L14;
    L63:
        tt5.a.d("BitableManagerPanelFragment", "updateBottomFixedBtn error with " + ya0().getPanelData());
        this.K = false;
        na0(false);
        return;
    L14:
        if (r102.length == 0) goto L63;
        if (r104 == true) goto L63;
        if (r102.length <= 1) goto L20;
        boolean r105 = true;
    L21:
        this.M = r105;
        this.K = true;
        na0(true);
        TextView r106 = this.f209824y;
        if (r106 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedText");
        r106 = null;
    L25:
        r106.setText(r102[0].getText());
        AppCompatImageView r107 = this.f209823x;
        if (r107 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedIcon");
        r107 = null;
    L29:
        r107.setBackgroundResource(R.drawable.ud_icon_add_outlined);
        if (Intrinsics.areEqual(r102[0].getStyle(), "disable") == false) goto L33;
        View r108 = ja0();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundableLayout");
        za0((LKUIRoundableLayout) r108);
    L33:
        if (r102.length <= 1) goto L65;
        View r109 = ka0();
        ViewGroup.LayoutParams r110 = ka0().getLayoutParams();
        r110.height = n.l(getContext(), R.dimen.bitable_manager_panel_with_docx_height);
        r109.setLayoutParams(r110);
        View r111 = ka0().findViewById(R.id.panel_bottom_btn_2);
        this.L = r111;
        if (r111 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedAddDocX");
        r111 = null;
    L37:
        r111.setVisibility(0);
        View r112 = this.L;
        if (r112 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedAddDocX");
        r112 = null;
    L40:
        ((TextView) r112.findViewById(R.id.bottom_fixed_btn_text)).setText(r102[1].getText());
        if (Intrinsics.areEqual(r102[1].getStyle(), "disable") == false) goto L46;
        View r113 = this.L;
        if (r113 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedAddDocX");
        r113 = null;
    L45:
        za0((LKUIRoundableLayout) r113);
    L54:
        View r114 = this.L;
        if (r114 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedAddDocX");
        r114 = null;
    L57:
        r114.setOnClickListener(new f(this));
        ViewGroup r115 = this.f214659J;
        if (r115 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L61:
        r101.getViewTreeObserver().addOnDrawListener(this);
        return;
    L60:
        r101 = r115;
        goto L61
    L46:
        View r116 = this.L;
        if (r116 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedAddDocX");
        r116 = null;
    L49:
        UDBadgeView r117 = (UDBadgeView) r116.findViewById(R.id.bottom_fixed_btn_badge);
        if (r102[1].getShowBadge() == true) goto L53;
        r103 = 8;
    L53:
        r117.setVisibility(r103);
        goto L54
    L65:
        return;
    L20:
        r105 = false;
        goto L21
    L9:
        if (getResources().getConfiguration().orientation != 2) goto L11;
        r104 = true;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, v15.b
    public final void Yf() {
        ya0().getActive().setValue(Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ViewGroup r100 = this.f214659J;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        r100 = null;
    L5:
        r100.getViewTreeObserver().removeOnDrawListener(this);
        if (Intrinsics.areEqual(ya0().getActive().getValue(), Boolean.TRUE) == false) goto L9;
        ya0().getOperationCallBack();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, v15.b
    public final long q30() {
        return this.N;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final View la0(CommonActionPanelLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return LayoutInflater.from(requireContext()).inflate(R.layout.bitable_manager_panel_fragment, r100, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Aa0();
        xa0();
        BitableManagerPanelAdapter r101 = this.I;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        r101 = null;
    L5:
        r101.notifyDataSetChanged();
    }

    public final void za0(LKUIRoundableLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        ((AppCompatImageView) r100.findViewById(R.id.bottom_fixed_btn_icon)).setImageTintList(ColorStateList.valueOf(getResources().getColor(EPanelItemIcon.LINKED_DOC.inactiveImageTintRes)));
        ((TextView) r100.findViewById(R.id.bottom_fixed_btn_text)).setTextColor(getResources().getColor(R.color.text_disabled));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f209815p = 0;
        dn(Float.valueOf(0.7f), Float.valueOf(0.7f), Float.valueOf(0.9f));
        qa0(true);
        pa0(R.color.bg_float_base);
        this.f214659J = (ViewGroup) r100.findViewById(R.id.panel_root);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.recycler_view);
        this.H = r102;
        ViewGroup r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r102 = null;
    L5:
        r102.setLayoutManager(new LinearLayoutManager(getContext()));
        BitableManagerPanelAdapter r104 = new BitableManagerPanelAdapter(CollectionsKt.emptyList(), ya0().getMExpandedTableList());
        RecyclerView r105 = this.H;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r105 = null;
    L8:
        r104.bindToRecyclerView(r105);
        ya0().getOperationCallBack();
        r104.f214651c = new h(this);
        this.I = r104;
        ja0().setOnClickListener(new g(this));
        ViewGroup r106 = this.f214659J;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L12:
        r103.getViewTreeObserver().addOnDrawListener(this);
        ya0().getPanelData().observe(this, new b(this));
        return;
    L11:
        r103 = r106;
        goto L12
    }
}
