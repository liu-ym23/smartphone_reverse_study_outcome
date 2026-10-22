package com.bytedance.ee.bear.bitable.homepage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.linkcommon.cybergarage.upnp.ActionList;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.list.homepage.banner.BitableCreateActionItem;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010%\u001a\u00020\u0011H\u0002J\u0006\u0010&\u001a\u00020\u0011J\u0010\u0010'\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010(\u001a\u00020\u0011H\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/BitableCreatePanelFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "actionListLayoutFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceSettingGroupLayout;", "getActionListLayoutFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceSettingGroupLayout;", "setActionListLayoutFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceSettingGroupLayout;)V", "cancelFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getCancelFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setCancelFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "clearFromXmlViewCache", "", "onDestroyView", "delegate", "Lcom/bytedance/ee/bear/bitable/homepage/BitableCreatePanelFragment$Delegate;", ActionList.ELEM_NAME, "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/list/homepage/banner/BitableCreateActionItem;", "Lkotlin/collections/ArrayList;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onViewCreated", "view", "parseArguments", "initView", "setDelegate", "onFloatDismiss", "Companion", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableCreatePanelFragment extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f212147o = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SpaceSettingGroupLayout f212148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public UDButton f212149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f212150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<BitableCreateActionItem> f212151n;

    public static final class a {
    }

    public interface b {
        void a();

        void b(BitableCreateActionItem r100);

        void qa();
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void W90() {
        b r100 = this.f212150m;
        if (r100 == null) goto L6;
        r100.qa();
        return;
    }

    public BitableCreatePanelFragment() {
        this.f212151n = new ArrayList();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f212148k = null;
        this.f212149l = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.big_screen_bottom_panel_height_fix_enable") == false) goto L38;
        FragmentActivity r101 = getActivity();
        Dialog r102 = getDialog();
        Intrinsics.checkNotNullParameter("BitableCreatePanelFragment", "tag");
        if (r101 != null) goto L7;
        tt5.a.d("BitableCreatePanelFragment", "activity is null");
        return;
    L7:
        if (com.bytedance.ee.util.ui.n.D(r101) == false) goto L9;
    L12:
        if (r102 != null) goto L36;
    L26:
        ViewGroup.LayoutParams r103 = null;
    L28:
        if ((r103 instanceof CoordinatorLayout.LayoutParams) == false) goto L40;
        CoordinatorLayout.Behavior r104 = ((CoordinatorLayout.LayoutParams) r103).getBehavior();     // Catch: Throwable -> L24
        if ((r104 instanceof BottomSheetBehavior) == false) goto L41;
        ((BottomSheetBehavior) r104).setPeekHeight(com.bytedance.ee.util.ui.n.p(r101));     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        tt5.a.e("BitableCreatePanelFragment", "init peek height", th, false);
        return;
    L41:
        return;
    L40:
        return;
    L36:
        Window r105 = r102.getWindow();     // Catch: Throwable -> L24
        if (r105 == null) goto L26;
        View r106 = r105.getDecorView();     // Catch: Throwable -> L24
        if (com.larus.home.impl.utils.c.f346345e == false) goto L20;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L24
        Thread r107 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L24
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L20;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");     // Catch: Throwable -> L24
    L20:
        if (r106 == null) goto L26;
        FrameLayout r108 = (FrameLayout) r106.findViewById(R.id.design_bottom_sheet);     // Catch: Throwable -> L24
        if (r108 == null) goto L26;
        r103 = r108.getLayoutParams();     // Catch: Throwable -> L24
        goto L28
    L9:
        if (rcb.b.b(r101) == true) goto L12;
        if (com.bytedance.ee.util.ui.n.C(r101) == true) goto L12;
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        Serializable r102 = r101.getSerializable("action_list");
    L6:
        if (r102 == null) goto L9;
        this.f212151n = (ArrayList) r102;
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ArrayList<BitableCreateActionItem> r102 = this.f212151n;
        View r103 = null;
        if (r102 == null) goto L25;
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L25;
        BitableCreateActionItem r105 = (BitableCreateActionItem) r104.next();
        com.bytedance.ee.bear.list.homepage.banner.e r106 = new com.bytedance.ee.bear.list.homepage.banner.e(getContext());
        Integer r107 = r105.getIconResId();
        if (r107 == null) goto L10;
        r106.setLeftIcon(r107.intValue());
    L10:
        r106.setTitle(r105.getText());
        r106.setOnClickListener(new c(this, r105));
        String r108 = com.bytedance.ee.bear.list.homepage.banner.d.f228297a.get(r105.getType());
        if (r108 != null) goto L13;
    L17:
        View r109 = this.f212148k;
        if (r109 != null) goto L24;
        View r110 = getView();
        if (r110 == null) goto L22;
        r109 = r110.findViewById(R.id.action_list_layout);
    L23:
        this.f212148k = (SpaceSettingGroupLayout) r109;
        goto L24
    L22:
        r109 = null;
    L24:
        ((SpaceSettingGroupLayout) r109).addView(r106);
        goto L6
    L13:
        if ((!StringsKt.isBlank(r108)) == false) goto L17;
        if (((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().f(r108) == true) goto L17;
        r106.setBadgeVisibility(true);
    L25:
        View r111 = this.f212149l;
        if (r111 != null) goto L31;
        View r112 = getView();
        if (r112 == null) goto L30;
        r103 = r112.findViewById(R.id.cancel);
    L30:
        this.f212149l = (UDButton) r103;
        r111 = r103;
    L31:
        ((UDButton) r111).setOnClickListener(new d(this));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_create_panel_layout, r101, false);
    }
}
