package com.bytedance.ee.bear.bitable.timezone;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u001a\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "mCcmLynxCardView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "mDragPanel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "getContentView", "Landroid/view/View;", WidgetCostModule.TYPE_ON_START, LiveCommonConstants.REASON_ON_DEDTROY, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initView", "rootView", "sendHeightChangedEvent", "initDialogAttr", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "dismissAllowingStateLoss", "getViewModel", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListViewModel;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableTimeZoneListFragment extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f215939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f215940k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CCMLynxCardView f215941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommonActionPanelLayout f215942i;

    public static final class a {
    }

    public static final class b implements CCMLynxCardView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableTimeZoneListFragment f215943a;

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void onShow() {
        }

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void H() {
            Context r100 = this.f215943a.getContext();
            if (r100 == null) goto L5;
            UDToast.show(r100, R.string.Bitable_Timezone_TimezoneChanged_Mobile, R.drawable.ud_icon_yes_outlined);
        L5:
            BitableTimeZoneListFragment r101 = this.f215943a;
            r101.getClass();
            BitableTimeZonePlugin.b r102 = ((BitableTimeZoneListViewModel) q.a(r101, BitableTimeZoneListViewModel.class)).getPluginDelegate();
            if (r102 == null) goto L9;
            r102.d();
            return;
        }

        public b(BitableTimeZoneListFragment r100) {
            this.f215943a = r100;
        }

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void a(Map<String, String> r100) {
            BitableTimeZoneListFragment.f215940k = true;
            if (r100 == null) goto L5;
            String r101 = r100.get("params");
        L6:
            TimeZoneItemParams r102 = (TimeZoneItemParams) GsonProtectorUtils.fromJson(new Gson(), r101, TimeZoneItemParams.class);
            HashMap r103 = new HashMap();
            r103.put("click", "time_zone_type");
            r103.put("time_zone_type_value", "(" + r102.formate + ')');
            BitableTimeZoneListFragment r104 = this.f215943a;
            r104.getClass();
            BitableTimeZonePlugin.b r105 = ((BitableTimeZoneListViewModel) q.a(r104, BitableTimeZoneListViewModel.class)).getPluginDelegate();
            if (r105 == null) goto L10;
            r105.reportEvent("ccm_bitable_time_zone_setting_click", r103);
            return;
        L10:
            return;
        L5:
            r101 = null;
            goto L6
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableTimeZoneListFragment f215944a;

        public c(BitableTimeZoneListFragment r100) {
            this.f215944a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            this.f215944a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        f215939j = false;
        tt5.a.b("BitableTimeZoneListFragment", "dismissAllowingStateLoss show: " + f215939j);
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L8;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (f215940k == true) goto L7;
        HashMap r100 = new HashMap();
        r100.put("click", "cancel");
        BitableTimeZonePlugin.b r101 = ((BitableTimeZoneListViewModel) q.a(this, BitableTimeZoneListViewModel.class)).getPluginDelegate();
        if (r101 == null) goto L7;
        r101.reportEvent("ccm_bitable_time_zone_setting_click", r100);
    L7:
        CCMLynxCardView r102 = this.f215941h;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mCcmLynxCardView");
        r102 = null;
    L10:
        r102.destroy();
        f215939j = false;
        tt5.a.b("BitableTimeZoneListFragment", "onDestroy show: " + f215939j);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.gravity = 80;
        r102.y = k.e(r101.getContext());
        r102.windowAnimations = R.style.ActionSheetDialogAnimation;
        r101.setAttributes(r102);
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        Dialog r103 = getDialog();
        if (r103 == null) goto L11;
        r103.setOnDismissListener(new com.bytedance.ee.bear.bitable.timezone.b(this));
        return;
    }

    public BitableTimeZoneListFragment() {
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        CommonActionPanelLayout r101 = this.f215942i;
        CommonActionPanelLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r101 = null;
    L5:
        com.bytedance.ee.bear.facade.common.widget.d r103 = r101.getDragUtil();
        if (r103 == null) goto L8;
        r103.e();
    L8:
        CommonActionPanelLayout r104 = this.f215942i;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
    L12:
        com.bytedance.ee.bear.facade.common.widget.d r105 = r102.getDragUtil();
        if (r105 == null) goto L15;
        r105.f();
    L15:
        j.d(new e(this), 200);
        return;
    L11:
        r102 = r104;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        CCMLynxCardView r101 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new AnonymousClass1(this), 2);
        BitableTimeZoneListViewModel r102 = (BitableTimeZoneListViewModel) q.a(this, BitableTimeZoneListViewModel.class);
        if (r102 == null) goto L5;
        r101.c(r102.getLynxWebDelegate());
    L5:
        r101.f(new b(this));
        this.f215941h = r101;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r110) {
        int r100 = 0;
        setStyle(0, R.style.InsertNewBlockDialogStyle);
        if (r110 != null) goto L5;
        r110 = new Bundle();
    L5:
        Dialog r111 = super.onCreateDialog(r110);
        CCMLynxCardView r101 = null;
        View r102 = View.inflate(getActivity(), R.layout.bitable_time_zone_list_layout, null);
        Intrinsics.checkNotNull(r102);
        CommonActionPanelLayout r103 = (CommonActionPanelLayout) r102.findViewById(R.id.panel_layout);
        this.f215942i = r103;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r103 = null;
    L8:
        r103.b(true);
        CommonActionPanelLayout r104 = this.f215942i;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r104 = null;
    L11:
        com.bytedance.ee.bear.facade.common.widget.d r105 = r104.getDragUtil();
        if (r105 == null) goto L14;
        r105.e();
    L14:
        Ref.IntRef r106 = new Ref.IntRef();
        CommonActionPanelLayout r107 = this.f215942i;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r107 = null;
    L17:
        com.bytedance.ee.bear.facade.common.widget.d r108 = r107.getDragUtil();
        if (r108 == null) goto L20;
        r108.f226593h = new com.bytedance.ee.bear.bitable.timezone.c(this, r106);
    L20:
        CommonActionPanelLayout r109 = this.f215942i;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r109 = null;
    L23:
        com.bytedance.ee.bear.facade.common.widget.d r112 = r109.getDragUtil();
        if (r112 == null) goto L26;
        r112.f226599n = new d(r106, this);
    L26:
        ViewParent r113 = r102.getParent();
        if (r113 == null) goto L29;
        ((ViewGroup) r113).removeAllViews();
    L29:
        r102.setOnClickListener(new com.bytedance.ee.bear.bitable.timezone.a(this));
        Bundle r114 = getArguments();
        if (r114 == null) goto L32;
        String r115 = r114.getString("panel_content_page");
    L33:
        Bundle r116 = getArguments();
        if (r116 == null) goto L47;
        String r117 = r116.getString("panel_data");
        if (r117 == null) goto L47;
        JSONObject r118 = new JSONObject(r117);
        int r119 = n.E((int) (((double) n.t()) * 0.9d));
        if (r115 == null) goto L47;
        HashMap r120 = new HashMap();
        r120.put(TimeZoneItemV2.TIME_ZONE, r118.get(TimeZoneItemV2.TIME_ZONE));
        Object r121 = r118.get("timeZoneList");
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray r122 = (JSONArray) r121;
        int r123 = r122.length();
    L40:
        if (r100 >= r123) goto L42;
        JSONObject r124 = JSONArrayProtectorUtils.getJSONObject(r122, r100);
        Object r125 = r124.get("id");
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type kotlin.String");
        String r126 = zu5.b.b(TimeZone.getTimeZone((String) r125));
        r124.remove("formate");
        r124.put("formate", r126);
        r100 = r100 + 1;
        goto L40
    L42:
        r120.put("initDatas", r122);
        r120.put("pageHeight", Integer.valueOf(r119));
        CCMLynxCardView r127 = this.f215941h;
        if (r127 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mCcmLynxCardView");
    L46:
        CCMLynxCardView.a.a(r101, (ViewGroup) r102.findViewById(R.id.panel_layout), 4, r120, new ViewGroup.LayoutParams(-1, -2));
        goto L47
    L45:
        r101 = r127;
    L47:
        r111.setContentView(r102);
        Window r128 = r111.getWindow();
        if (r128 == null) goto L50;
        WindowManager.LayoutParams r129 = r128.getAttributes();
        r129.width = -1;
        r129.height = n.t();
        r129.flags |= 256;
        r129.gravity = 80;
    L50:
        r111.setOnCancelListener(new c(this));
        return r111;
    L32:
        r115 = null;
        goto L33
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        tt5.a.b("BitableTimeZoneListFragment", "show: " + f215939j);
        if (f215939j == false) goto L29;
        return;
    L29:
        boolean r102 = true;
        if (r100.findFragmentByTag(r101) != null) goto L17;
        r100.beginTransaction().remove(this).commitAllowingStateLoss();     // Catch: Exception -> L23
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L23
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r103);     // Catch: Exception -> L23
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r103) == false) goto L27;
    L12:
        f215939j = true;     // Catch: Exception -> L23
        Dialog r104 = getDialog();     // Catch: Exception -> L23
        if (r104 == null) goto L30;
        Window r105 = r104.getWindow();     // Catch: Exception -> L23
        if (r105 == null) goto L31;
        r105.clearFlags(131072);     // Catch: Exception -> L23
        return;
    L31:
        return;
    L30:
        return;
    L27:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L11:
        super.show(r100, r101);     // Catch: Exception -> L23
        goto L12
    L17:
        StringBuilder r106 = new StringBuilder("manager had Fragment: ");     // Catch: Exception -> L23
        if (r100.findFragmentByTag(r101) == null) goto L21;
        r102 = false;
    L21:
        r106.append(r102);     // Catch: Exception -> L23
        tt5.a.b("BitableTimeZoneListFragment", r106.toString());     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        tt5.a.d("BitableTimeZoneListFragment", "show error: " + e);
    }
}
