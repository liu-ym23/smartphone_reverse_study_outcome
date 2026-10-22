package com.bytedance.ee.bear.bitable.panel;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.card.view.description.expandabletext.ExpandableTextLayout;
import com.bytedance.ee.bear.bitable.common.ClearFocusWrapper;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.common.widgets.item.CommonHeaderView;
import com.bytedance.ee.bear.bitable.filter.view.ddui.BitableFilterConjunctionFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.widget.u;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010:2\u0006\u0010H\u001a\u00020IH\u0016J\u001a\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020:2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\n\u0010N\u001a\u0004\u0018\u00010OH\u0014J\b\u0010P\u001a\u00020)H\u0016J\b\u0010Q\u001a\u00020)H\u0002J\b\u0010R\u001a\u00020)H\u0016J\b\u0010S\u001a\u00020)H\u0002J\u0010\u0010T\u001a\u00020)2\b\u0010U\u001a\u0004\u0018\u00010VJ\u0010\u0010W\u001a\u00020)2\u0006\u0010U\u001a\u00020VH\u0004J\u0010\u0010X\u001a\u00020)2\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010Y\u001a\u00020)2\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010Z\u001a\u00020)2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010[\u001a\u00020)H\u0016J\b\u0010\\\u001a\u000204H\u0016J\u0010\u0010]\u001a\u00020)2\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u000204H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0004\n\u0002\u0010FR\u0014\u0010a\u001a\u00020bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/BitablePanelFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "<init>", "()V", "recyclerViewFromXml", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelGroupView;", "getRecyclerViewFromXml", "()Lcom/bytedance/ee/bear/bitable/panel/BitablePanelGroupView;", "setRecyclerViewFromXml", "(Lcom/bytedance/ee/bear/bitable/panel/BitablePanelGroupView;)V", "contentWrapperFromXml", "Lcom/bytedance/ee/bear/bitable/common/ClearFocusWrapper;", "getContentWrapperFromXml", "()Lcom/bytedance/ee/bear/bitable/common/ClearFocusWrapper;", "setContentWrapperFromXml", "(Lcom/bytedance/ee/bear/bitable/common/ClearFocusWrapper;)V", "defaultContentContainerFromXml", "Landroid/widget/LinearLayout;", "getDefaultContentContainerFromXml", "()Landroid/widget/LinearLayout;", "setDefaultContentContainerFromXml", "(Landroid/widget/LinearLayout;)V", "rootViewFromXml", "Landroidx/core/widget/NestedScrollView;", "getRootViewFromXml", "()Landroidx/core/widget/NestedScrollView;", "setRootViewFromXml", "(Landroidx/core/widget/NestedScrollView;)V", "fieldDescContainerFromXml", "Lcom/bytedance/ee/bear/bitable/card/view/description/expandabletext/ExpandableTextLayout;", "getFieldDescContainerFromXml", "()Lcom/bytedance/ee/bear/bitable/card/view/description/expandabletext/ExpandableTextLayout;", "setFieldDescContainerFromXml", "(Lcom/bytedance/ee/bear/bitable/card/view/description/expandabletext/ExpandableTextLayout;)V", "fieldDescFromXml", "Landroid/widget/TextView;", "getFieldDescFromXml", "()Landroid/widget/TextView;", "setFieldDescFromXml", "(Landroid/widget/TextView;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelViewModel;", "callback", "Lcom/bytedance/ee/bear/bitable/panel/PanelItemCallback;", "getCallback", "()Lcom/bytedance/ee/bear/bitable/panel/PanelItemCallback;", "setCallback", "(Lcom/bytedance/ee/bear/bitable/panel/PanelItemCallback;)V", "shouldCallbackCancel", "", "getShouldCallbackCancel", "()Z", "setShouldCallbackCancel", "(Z)V", "extendHeaderView", "Landroid/view/View;", "getExtendHeaderView", "()Landroid/view/View;", "setExtendHeaderView", "(Landroid/view/View;)V", "extendContentView", "getExtendContentView", "setExtendContentView", "srcObjToken", "", "srcObjType", "", "Ljava/lang/Integer;", "onCreateContentView", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "getSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "initPanelData", "initPanel", "initContentView", "initViewModel", "updateDataModel", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelModel;", "updateData", "bindHeader", "bindContent", "bindBottom", LiveCommonConstants.REASON_ON_DEDTROY, "isSupportScreenLandscape", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "openIndependentMode", "exitAnimDuration", "", "getExitAnimDuration", "()J", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitablePanelFragment extends BaseActionPanelFragment {
    public static final /* synthetic */ int U = 0;
    public BitablePanelGroupView G;
    public ClearFocusWrapper H;
    public LinearLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public NestedScrollView f214803J;
    public ExpandableTextLayout K;
    public TextView L;
    public BitablePanelViewModel M;
    public m N;
    public boolean O;
    public View P;
    public View Q;
    public String R;
    public Integer S;
    public final long T;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitablePanelFragment f214804a;

        public b(BitablePanelFragment r100) {
            this.f214804a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f214804a.isResumed() == false) goto L9;
            BitablePanelFragment r100 = this.f214804a;     // Catch: Throwable -> L6
            int r101 = BitablePanelFragment.U;     // Catch: Throwable -> L6
            r100.xa0();     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, v15.b
    public boolean D10() {
        return !(this instanceof BitableFilterConjunctionFragment);
    }

    public final BitablePanelGroupView Aa0() {
        View r100 = this.G;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.recycler_view);
    L8:
        this.G = (BitablePanelGroupView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (BitablePanelGroupView) r100;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.mobile.common_panel_support_landscape");
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public mr4.a o() {
        String r100 = this.R;
        Integer r101 = null;
        if (r100 != null) goto L12;
        BitablePanelViewModel r102 = this.M;
        if (r102 == null) goto L11;
        MutableLiveData<BitablePanelModel> r103 = r102.getPanelModel();
        if (r103 == null) goto L11;
        BitablePanelModel r104 = r103.getValue();
        if (r104 == null) goto L11;
        r100 = r104.getSrcObjToken();
    L11:
        r100 = null;
    L12:
        Integer r105 = this.S;
        if (r105 != null) goto L21;
        BitablePanelViewModel r106 = this.M;
        if (r106 == null) goto L23;
        MutableLiveData<BitablePanelModel> r107 = r106.getPanelModel();
        if (r107 == null) goto L23;
        BitablePanelModel r108 = r107.getValue();
        if (r108 == null) goto L23;
        r101 = r108.getSrcObjType();
    L23:
        return com.bytedance.ee.bear.bitable.utils.g.a(r100, r101);
    L21:
        r101 = r105;
        goto L23
    }

    public final ClearFocusWrapper ya0() {
        View r100 = this.H;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.content_wrapper);
    L8:
        this.H = (ClearFocusWrapper) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (ClearFocusWrapper) r100;
    }

    public final ExpandableTextLayout za0() {
        View r100 = this.K;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.field_desc_container);
    L8:
        this.K = (ExpandableTextLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (ExpandableTextLayout) r100;
    }

    public BitablePanelFragment() {
        this.O = true;
        if (com.bytedance.ee.bear.bitable.c.i() == false) goto L5;
        this.f209813n = true;
    L5:
        this.T = 200;
    }

    public void Ba0() {
        BitablePanelGroupView r100 = Aa0();
        if (r100 == null) goto L5;
        r100.setItemCallback(this.N);
    L5:
        Aa0().setLifecycle(getLifecycle());
        ya0().setGetFocusView(new BitablePanelFragment$initContentView$1(this));
    }

    public void Ca0() {
        if (getArguments() == null) goto L13;
        Bundle r100 = getArguments();
        Serializable r101 = null;
        if (r100 == null) goto L7;
        Serializable r102 = r100.getSerializable("data");
    L8:
        if (r102 == null) goto L13;
        Bundle r103 = getArguments();
        if (r103 == null) goto L12;
        r101 = r103.getSerializable("data");
    L12:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.panel.BitablePanelModel");
        Da0((BitablePanelModel) r101);
        xa0();
        return;
    L7:
        r102 = null;
    L13:
        BitablePanelViewModel r104 = (BitablePanelViewModel) q.a(this, BitablePanelViewModel.class);
        this.M = r104;
        if (r104 == null) goto L20;
        MutableLiveData<BitablePanelModel> r105 = r104.getPanelModel();
        if (r105 == null) goto L21;
        r105.observe(this, new com.bytedance.ee.bear.bitable.panel.b(this));
        return;
    L21:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.O == false) goto L8;
        m r100 = this.N;
        if (r100 == null) goto L9;
        r100.a("exit");
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.G = null;
        this.H = null;
        this.I = null;
        this.f214803J = null;
        this.K = null;
        this.L = null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, v15.b
    public final long q30() {
        return this.T;
    }

    public final void Da0(BitablePanelModel r110) {
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        AppCompatImageView r100 = null;
        if (ForsetiHelper.r(this) == false) goto L5;
        oa0(Boolean.FALSE, null);
    L6:
        CommonActionPanelLayout r101 = ia0();
        if (r101 == null) goto L9;
        ViewGroup r102 = r101.getTopBar();
    L11:
        if (r102 == null) goto L49;
        View r103 = r102.findViewById(R.id.titleBar);
        Gson r104 = com.bytedance.ee.bear.bitable.common.widgets.item.e.f210019a;
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (TextUtils.isEmpty(r110.getHeaderExtendMode()) == false) goto L16;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == false) goto L34;
        if (r103 == null) goto L24;
        r103.setVisibility(8);
    L24:
        com.bytedance.ee.bear.bitable.common.widgets.item.k r106 = com.bytedance.ee.bear.bitable.common.widgets.item.e.f210020b.get(r110.getHeaderExtendMode());
        if (this.P != null) goto L30;
        if (r106 == null) goto L28;
        CommonHeaderView r107 = r106.a(r102);
    L29:
        this.P = r107;
        r102.addView(r107);
        goto L30
    L28:
        r107 = null;
    L30:
        View r108 = this.P;
        if (r108 == null) goto L43;
        if (r106 == null) goto L43;
        r110.getTitle();
        BitablePanelItem r109 = r110.getLeftAction();
        r110.getRightAction();
        r106.b(r108, r109, this.N);
    L43:
        if (ForsetiHelper.s(this) == false) goto L49;
        if (U90() == false) goto L49;
        UDShadowLayout r111 = (UDShadowLayout) ia0().findViewById(R.id.shadowLayout);
        if (r111 == null) goto L49;
        r111.setShadowSize(UDShadowLayout.Size.NONE);
        goto L49
    L34:
        if (r103 == null) goto L36;
        r103.setVisibility(0);
    L36:
        r102.removeView(this.P);
        va0(r110.getTitle());
        final BitablePanelItem r112 = r110.getLeftAction();
        if (r112 == null) goto L39;
        ia0().setLeftIconVisible(false);
        ia0().setLeftTextVisible(false);
        sa0(1, new Pair(null, r112.getLeftText()), null, new BitablePanelFragment$bindHeader$2$1(this, r112));
    L39:
        final BitablePanelItem r113 = r110.getRightAction();
        if (r113 == null) goto L43;
        ia0().setRightIconVisible(false);
        ia0().setRightTextVisible(false);
        ua0(new Pair(null, r113.getLeftText()), Integer.valueOf(R.color.primary_pri_500), new BitablePanelFragment$bindHeader$3$1(this, r113));
        goto L43
    L16:
        if (TextUtils.equals(r110.getHeaderExtendMode(), "default_header") == true) goto L20;
        if (com.bytedance.ee.bear.bitable.common.widgets.item.e.f210020b.get(r110.getHeaderExtendMode()) == null) goto L20;
        r105 = true;
    L49:
        Gson r114 = com.bytedance.ee.bear.bitable.common.widgets.item.e.f210019a;
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r110.isContentExtendValid() == true) goto L52;
    L54:
        boolean r115 = false;
    L56:
        if (r115 == false) goto L86;
        View r116 = this.I;
        if (r116 != null) goto L64;
        View r117 = getView();
        if (r117 == null) goto L62;
        r116 = r117.findViewById(R.id.default_content_container);
    L63:
        this.I = (LinearLayout) r116;
        goto L64
    L62:
        r116 = null;
    L64:
        ((LinearLayout) r116).setVisibility(8);
        com.bytedance.ee.bear.bitable.common.widgets.item.j<?> r118 = com.bytedance.ee.bear.bitable.common.widgets.item.e.f210021c.get(r110.getContentExtendMode());
        if (this.Q != null) goto L79;
        if (r118 == null) goto L75;
        View r119 = this.f214803J;
        if (r119 != null) goto L74;
        View r120 = getView();
        if (r120 == null) goto L72;
        r119 = r120.findViewById(R.id.root_view);
    L73:
        this.f214803J = (NestedScrollView) r119;
        goto L74
    L72:
        r119 = null;
    L74:
        View r121 = r118.b((NestedScrollView) r119);
    L76:
        this.Q = r121;
        if (r121 == null) goto L79;
        ya0().addView(r121);
        goto L79
    L75:
        r121 = null;
    L79:
        View r122 = this.Q;
        if (r122 == null) goto L125;
        if (r118 == null) goto L125;
        r118.a(r122, r110.getExtra());     // Catch: Exception -> L84
        Unit r123 = Unit.INSTANCE;     // Catch: Exception -> L84
    L84:
        e = move-exception;
        tt5.a.e("BitablePanelFragment", "onBindContent error: " + r110, e, false);
        Unit r124 = Unit.INSTANCE;
    L125:
        if (r110.getBottomFixedData() == null) goto L146;
        na0(true);
        TextView r125 = this.f209824y;
        if (r125 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedText");
        r125 = null;
    L130:
        BitablePanelItem r126 = r110.getBottomFixedData();
        if (r126 == null) goto L133;
        String r127 = r126.getLeftText();
    L134:
        r125.setText(r127);
        BitablePanelItem r128 = r110.getBottomFixedData();
        if (r128 == null) goto L143;
        Icon r129 = r128.getLeftIcon();
        if (r129 == null) goto L143;
        AppCompatImageView r130 = this.f209823x;
        if (r130 == null) goto L141;
        r100 = r130;
    L142:
        e.i(r100, r129);
        goto L143
    L141:
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedIcon");
    L143:
        View r131 = ja0();
        if (r131 == null) goto L147;
        r131.setOnClickListener(new com.bytedance.ee.bear.bitable.panel.a(this, r110));
    L147:
        this.R = r110.getSrcObjToken();
        this.S = r110.getSrcObjType();
        return;
    L133:
        r127 = null;
        goto L134
    L146:
        na0(false);
        goto L147
    L86:
        View r132 = this.I;
        if (r132 != null) goto L93;
        View r133 = getView();
        if (r133 == null) goto L91;
        r132 = r133.findViewById(R.id.default_content_container);
    L92:
        this.I = (LinearLayout) r132;
        goto L93
    L91:
        r132 = null;
    L93:
        ((LinearLayout) r132).setVisibility(0);
        ya0().removeView(this.Q);
        ArrayList<GroupInfo> r134 = r110.getGroupInfo();
        if (r134 == null) goto L96;
        Aa0().v(r134);
    L96:
        boolean r135 = com.larksuite.framework.utils.q.a(r110.getData());
        if (com.larksuite.framework.utils.q.a(r110.getDesc()) == false) goto L99;
        za0().setVisibility(8);
    L115:
        if (r135 == true) goto L125;
        BitablePanelGroupView r136 = Aa0();
        if (r136 == null) goto L125;
        ArrayList<BitablePanelItem> r137 = r110.getData();
        if (r137 == null) goto L122;
        List r138 = CollectionsKt.toMutableList(r137);
        if (r138 == null) goto L122;
    L123:
        r136.w(r138);
    L122:
        r138 = new ArrayList();
        goto L123
    L99:
        if (r135 == false) goto L103;
        za0().setMaxLine(Integer.MAX_VALUE);
        za0().f208377f = true;
        if (za0().f208372a == null) goto L104;
        za0().a();
    L104:
        int r139 = eq4.d.f473486a;
        ArrayList<SegmentModel> r140 = r110.getDesc();
        View r141 = this.L;
        if (r141 != null) goto L111;
        View r142 = getView();
        if (r142 == null) goto L109;
        r141 = r142.findViewById(R.id.field_desc);
    L110:
        this.L = (TextView) r141;
        goto L111
    L109:
        r141 = null;
    L111:
        TextView r143 = (TextView) r141;
        Intrinsics.checkNotNullParameter(r143, "textView");
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        eq4.e r144 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.c(r140);
        if (r144.f467804a == null) goto L114;
        r143.setMovementMethod(u.a());
        Flowable.just(r144.b()).map(new eq4.f(r143, new eq4.a(this))).subscribe(new eq4.b(r143), eq4.c.f473485a);
    L114:
        za0().setVisibility(0);
        za0().setMaskStyle(true);
        goto L115
    L103:
        za0().setMaxLine(3);
        goto L104
    L52:
        if (com.bytedance.ee.bear.bitable.common.widgets.item.e.f210021c.get(r110.getContentExtendMode()) == null) goto L54;
        r115 = true;
        goto L56
    L9:
        r102 = null;
        goto L11
    L5:
        oa0(r110.getDraggable(), r110.getHeightPercent());
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final View la0(CommonActionPanelLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        ForsetiHelper.w(getActivity(), 0.8f);
        return LayoutInflater.from(getContext()).inflate(R.layout.bitable_panel_fragment, r100, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.mobile.common_panel_support_landscape") == false) goto L6;
        com.bytedance.ee.util.ui.j.c(new b(this));
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        oa0(Boolean.FALSE, null);
        pa0(R.color.bg_float_base);
        wa0(R.color.bg_float_base);
        Ba0();
        Ca0();
    }
}
