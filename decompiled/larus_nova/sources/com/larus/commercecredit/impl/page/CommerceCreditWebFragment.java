package com.larus.commercecredit.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.huawei.hms.common.data.DataBufferUtils;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.commercecredit.impl.databinding.LarusFragmentCommerceCreditWebBinding;
import com.larus.commercecredit.impl.page.behavior.BottomSheetDialogWebViewBehavior;
import com.larus.nova.R;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u0012H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/commercecredit/impl/page/CommerceCreditWebFragment;", "Lcom/larus/commercecredit/impl/page/BaseCommerceCreditFragment;", "Lcom/larus/commercecredit/impl/databinding/LarusFragmentCommerceCreditWebBinding;", "<init>", "()V", NativeDownloadModel.JsonKey.WEB_URL, "", "webView", "Landroid/webkit/WebView;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "getAssociatedActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "parseArguments", "initViews", "setupTopCloseView", "hiddenBottomSheet", "setupWebFragment", "getWebViewScrollCallback", "Lcom/larus/bmhome/web/IWebViewProxyCallback;", WidgetCostModule.TYPE_ON_START, "setupFullScreen", "setupBottomSheetScrollListener", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getAvailableBottomSheetHeight", "", "postUpdateBottomSheetHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceCreditWebFragment extends BaseCommerceCreditFragment<LarusFragmentCommerceCreditWebBinding> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f325734h = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f325735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebView f325736g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final int U90() {
        com.larus.utils.i0.f375410a.getClass();
        int r100 = com.larus.utils.i0.g();
        Resources r101 = getResources();
        int r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).heightPixels - r100;
        if (r102 > 0) goto L6;
        int r103 = m0.f375450a;
        return (m0.a(getContext()) - r100) - com.larus.utils.i0.e();
    L6:
        return r102;
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void W90() {
        WebView r100 = this.f325736g;
        if (r100 == null) goto L6;
        r100.setTag(R.id.tag_web_view_scroll_top, Boolean.FALSE);
        return;
    }

    public CommerceCreditWebFragment() {
        this.f325735f = "";
    }

    public final void X90() {
        Dialog r100 = getDialog();
        BottomSheetBehavior r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.findViewById(R.id.design_bottom_sheet);
    L6:
        if (r102 == null) goto L8;
        r101 = BottomSheetBehavior.from(r102);
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.getState() != 3) goto L14;
        r101.setState(5);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void initViews() {
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        View r101 = r100.findViewById(R.id.view_top_close_range);
        if (r101 == null) goto L8;
        e1.d(r101, new r(this));
        r101.setOnTouchListener(new v(r101, this));
    L8:
        String r102 = this.f325735f;
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L39;
        AiChatHostWebService r104 = AiChatHostWebService.f317594a;
        AbsWebFragment r105 = r104.a(new t(this));
        if (r105 == null) goto L36;
        Context r106 = getContext();
        if (r106 == null) goto L22;
        Integer r107 = Integer.valueOf(ContextCompat.getColor(r106, R.color.larus_base_2));
    L23:
        Integer r108 = r107;
        String r109 = this.f325735f;
        if (r109 != null) goto L26;
        r109 = "";
    L26:
        r105.setArguments(r104.c(new zt8.b(r109, false, false, r108, false, 100)));
        FragmentTransaction r110 = getChildFragmentManager().beginTransaction();
        LarusFragmentCommerceCreditWebBinding r111 = (LarusFragmentCommerceCreditWebBinding) this.f325726d;
        if (r111 == null) goto L37;
        FrameLayout r112 = r111.f325695d;
        if (r112 == null) goto L38;
        int r113 = r112.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "web_fragment_tag", r113) == true) goto L34;
        r110.replace(r113, r105, "web_fragment_tag");
    L34:
        r110.commit();
        return;
    L38:
        return;
    L37:
        return;
    L22:
        r107 = null;
        goto L23
    L36:
        return;
    L39:
        return;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        BottomSheetDialog r101 = null;
        if ((r100 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r102 = (BottomSheetDialog) r100;
    L7:
        if (r102 == null) goto L20;
        int r103 = BottomSheetDialogWebViewBehavior.f325754d;
        Intrinsics.checkNotNullParameter(r102, "dialog");
        View r104 = r102.findViewById(R.id.design_bottom_sheet);
        if (r104 == null) goto L13;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r106 = (CoordinatorLayout.LayoutParams) r105;
        r106.setBehavior(new BottomSheetDialogWebViewBehavior(r104.getContext(), null));
        r104.setLayoutParams(r106);
    L13:
        View r107 = r102.findViewById(R.id.design_bottom_sheet);
        if (r107 == null) goto L20;
        Resources r108 = getResources();
        int r109 = WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).heightPixels;
        ViewGroup.LayoutParams r110 = r107.getLayoutParams();
        if (r110 == null) goto L19;
        r110.height = r109;
        r107.setLayoutParams(r110);
    L19:
        final BottomSheetBehavior r111 = BottomSheetBehavior.from(r107);
        r111.setPeekHeight(r109);
        r111.setState(3);
        r111.setSkipCollapsed(true);
        r111.setHideable(true);
        r102.setOnShowListener(new s(r111));
    L20:
        Dialog r112 = getDialog();
        if ((r112 instanceof BottomSheetDialog) == false) goto L23;
        r101 = (BottomSheetDialog) r112;
    L23:
        if (r101 == null) goto L30;
        View r113 = r101.findViewById(R.id.design_bottom_sheet);
        if (r113 == null) goto L31;
        BottomSheetBehavior.from(r113).setBottomSheetCallback(new u(this));
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final Class<? extends Activity> T90() {
        return CommerceCreditWebActivity.class;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        FLogger.f375446a.d("CommerceCreditWebFragment", "onConfigurationChanged orientation=" + r100.orientation);
        if (e2.f365734a.isPad() == false) goto L8;
        View r101 = getView();
        if (r101 == null) goto L9;
        r101.post(new b(this));
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = com.larus.commercecredit.impl.utils.k.f325826a;
        this.f325735f = y0.k(y0.b(y0.c(com.larus.commercecredit.impl.utils.k.a(getArguments(), "src_url"), "enter_method", com.larus.commercecredit.impl.utils.k.a(getArguments(), "enter_method")), DataBufferUtils.PREV_PAGE, com.larus.commercecredit.impl.utils.k.a(getArguments(), "previous_page")));
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final ViewBinding S90(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_fragment_commerce_credit_web, r101, false);
        int r103 = R.id.view_credit_indicator;
        View r104 = ViewBindings.findChildViewById(r102, R.id.view_credit_indicator);
        if (r104 == null) goto L11;
        r103 = R.id.view_top_close_range;
        View r105 = ViewBindings.findChildViewById(r102, R.id.view_top_close_range);
        if (r105 == null) goto L11;
        r103 = R.id.webContainer;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r102, R.id.webContainer);
        if (r106 == null) goto L11;
        return new LarusFragmentCommerceCreditWebBinding((ConstraintLayout) r102, r104, r105, r106);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
