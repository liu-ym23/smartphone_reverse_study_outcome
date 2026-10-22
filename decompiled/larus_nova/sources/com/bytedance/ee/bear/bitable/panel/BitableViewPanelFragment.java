package com.bytedance.ee.bear.bitable.panel;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemAdapter;
import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemModel;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u0011H\u0002J\u0016\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u0010\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020-H\u0002J\u0010\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\u0011H\u0016J\b\u0010:\u001a\u00020;H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010<\u001a\u00020=X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/BitableViewPanelFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "<init>", "()V", "viewListFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getViewListFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setViewListFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "emptyViewFromXml", "Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyView;", "getEmptyViewFromXml", "()Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyView;", "setEmptyViewFromXml", "(Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyView;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/bitable/panel/BitableViewPanelViewModel;", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getActionHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setActionHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "adapter", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemAdapter;", "getAdapter", "()Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemAdapter;", "setAdapter", "(Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemAdapter;)V", "onCreateContentView", "Landroid/view/View;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "initPanel", "initContentView", "initViewModel", "getSelectPosition", "", "itemList", "", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemModel;", "adjustItemViewVisible", "position", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateData", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/ee/bear/bitable/panel/BitableViewPanelModel;", LiveCommonConstants.REASON_ON_DEDTROY, "openIndependentMode", "", "exitAnimDuration", "", "getExitAnimDuration", "()J", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableViewPanelFragment extends BaseActionPanelFragment {
    public static final /* synthetic */ int M = 0;
    public RecyclerView G;
    public EmptyView H;
    public BitableViewPanelViewModel I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public gv4.a f214823J;
    public CatalogItemAdapter K;
    public final long L;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, v15.b
    public final boolean D10() {
        return true;
    }

    public final EmptyView ya0() {
        View r100 = this.H;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.empty_view);
    L8:
        this.H = (EmptyView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (EmptyView) r100;
    }

    public final RecyclerView za0() {
        View r100 = this.G;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.view_list);
    L8:
        this.G = (RecyclerView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (RecyclerView) r100;
    }

    public BitableViewPanelFragment() {
        if (com.bytedance.ee.bear.bitable.c.i() == false) goto L5;
        this.f209813n = true;
    L5:
        this.L = 200;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        BitableViewPanelViewModel r100 = this.I;
        if (r100 == null) goto L8;
        MutableLiveData<Boolean> r101 = r100.getPanelActive();
        if (r101 == null) goto L9;
        r101.postValue(Boolean.FALSE);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.G = null;
        this.H = null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, v15.b
    public final long q30() {
        return this.L;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final View la0(CommonActionPanelLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return LayoutInflater.from(getContext()).inflate(R.layout.bitable_view_panel_fragment, r100, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        CatalogItemAdapter r101 = this.K;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L6:
        List<CatalogItemModel> r102 = r101.getData();
        int r103 = r102.size();
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L12;
        if (((CatalogItemModel) ListProtector.get(r102, r105)).isSelected() == true) goto L10;
        r105 = r105 + 1;
        goto L7
    L10:
        r104 = r105;
    L12:
        com.bytedance.ee.bear.bitable.m.k(za0(), new f(this, r104));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        CatalogItemAdapter r102 = null;
        if (com.bytedance.ee.bear.bitable.c.i() == true) goto L5;
    L12:
        oa0(Boolean.TRUE, Float.valueOf(0.5f));
    L13:
        pa0(R.color.bg_body);
        wa0(R.color.bg_body);
        Pair<Integer, ? extends CharSequence> r103 = new Pair(Integer.valueOf(R.drawable.ud_icon_close_small_outlined), null);
        Function0<Unit> r104 = new BitableViewPanelFragment$initPanel$1(this);
        int r105 = com.bytedance.ee.bear.bitable.common.fragment.b.f209834a;
        sa0(0, r103, null, r104);
        CatalogItemAdapter r106 = new CatalogItemAdapter(requireContext(), "ViewDragSort", true);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.K = r106;
        RecyclerView r107 = za0();
        CatalogItemAdapter r108 = this.K;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r108 = null;
    L17:
        r107.setAdapter(r108);
        CatalogItemAdapter r109 = this.K;
        if (r109 == null) goto L20;
        r102 = r109;
    L21:
        r102.bindToRecyclerView(za0());
        za0().setLayoutManager(new LinearLayoutManager(getContext()));
        View r110 = this.A;
        if (r110 == null) goto L24;
        r110.setVisibility(8);
    L24:
        BitableViewPanelViewModel r111 = (BitableViewPanelViewModel) q.a(this, BitableViewPanelViewModel.class);
        this.I = r111;
        if (r111 == null) goto L30;
        MutableLiveData<BitableViewPanelModel> r112 = r111.getPanelModel();
        if (r112 == null) goto L31;
        r112.observe(this, new g(this));
        return;
    L31:
        return;
    L30:
        return;
    L20:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        goto L21
    L5:
        if (ForsetiHelper.s(this) == false) goto L12;
        if (U90() == false) goto L12;
        UDShadowLayout r113 = (UDShadowLayout) ia0().findViewById(R.id.shadowLayout);
        if (r113 == null) goto L11;
        r113.setShadowSize(UDShadowLayout.Size.NONE);
    L11:
        oa0(Boolean.FALSE, null);
        goto L13
    }
}
