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
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.toast.UDToast;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u001a\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "mCcmLynxCardView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "mDragPanel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "getContentView", "Landroid/view/View;", "onStart", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initView", "rootView", "sendHeightChangedEvent", "initDialogAttr", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "dismissAllowingStateLoss", "getViewModel", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListViewModel;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableTimeZoneListFragment extends BaseAntiScreenshotsDialogFragment {
    public static boolean j;
    public static boolean k;
    public CCMLynxCardView h;
    public CommonActionPanelLayout i;

    public static final class a {
    }

    public static final class b implements CCMLynxCardView.b {
        public final /* synthetic */ BitableTimeZoneListFragment a;

        public final void onShow() {
        }

        public final void H() {
            Context r0 = this.a.getContext();
            if (r0 == null) goto L5;
            UDToast.show(r0, 2131886900, 2131256306);
        L5:
            BitableTimeZoneListFragment r1 = this.a;
            r1.getClass();
            BitableTimeZonePlugin.b r2 = ((BitableTimeZoneListViewModel) q.a(r1, BitableTimeZoneListViewModel.class)).getPluginDelegate();
            if (r2 == null) goto L9;
            r2.d();
            return;
        }

        public b(BitableTimeZoneListFragment r1) {
            this.a = r1;
        }

        public final void a(Map<String, String> r4) {
            BitableTimeZoneListFragment.k = true;
            if (r4 == null) goto L5;
            String r5 = r4.get("params");
        L6:
            TimeZoneItemParams r6 = (TimeZoneItemParams) GsonProtectorUtils.fromJson(new Gson(), r5, TimeZoneItemParams.class);
            HashMap r0 = new HashMap();
            r0.put("click", "time_zone_type");
            r0.put("time_zone_type_value", "(" + r6.formate + ')');
            BitableTimeZoneListFragment r7 = this.a;
            r7.getClass();
            BitableTimeZonePlugin.b r8 = ((BitableTimeZoneListViewModel) q.a(r7, BitableTimeZoneListViewModel.class)).getPluginDelegate();
            if (r8 == null) goto L10;
            r8.reportEvent("ccm_bitable_time_zone_setting_click", r0);
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ BitableTimeZoneListFragment a;

        public c(BitableTimeZoneListFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        j = false;
        tt5.a.b("BitableTimeZoneListFragment", "dismissAllowingStateLoss show: " + j);
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L8;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        if (k == true) goto L7;
        HashMap r0 = new HashMap();
        r0.put("click", "cancel");
        BitableTimeZonePlugin.b r1 = ((BitableTimeZoneListViewModel) q.a(this, BitableTimeZoneListViewModel.class)).getPluginDelegate();
        if (r1 == null) goto L7;
        r1.reportEvent("ccm_bitable_time_zone_setting_click", r0);
    L7:
        CCMLynxCardView r2 = this.h;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mCcmLynxCardView");
        r2 = null;
    L10:
        r2.destroy();
        j = false;
        tt5.a.b("BitableTimeZoneListFragment", "onDestroy show: " + j);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.gravity = 80;
        r2.y = k.e(r1.getContext());
        r2.windowAnimations = 2131951621;
        r1.setAttributes(r2);
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        Dialog r3 = getDialog();
        if (r3 == null) goto L11;
        r3.setOnDismissListener(new com.bytedance.ee.bear.bitable.timezone.b(this));
        return;
    }

    public BitableTimeZoneListFragment() {
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        CommonActionPanelLayout r4 = this.i;
        CommonActionPanelLayout r0 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r4 = null;
    L5:
        com.bytedance.ee.bear.facade.common.widget.d r5 = r4.getDragUtil();
        if (r5 == null) goto L8;
        r5.e();
    L8:
        CommonActionPanelLayout r6 = this.i;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
    L12:
        com.bytedance.ee.bear.facade.common.widget.d r7 = r0.getDragUtil();
        if (r7 == null) goto L15;
        r7.f();
    L15:
        j.d(new e(this), 200);
        return;
    L11:
        r0 = r6;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        CCMLynxCardView r5 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new AnonymousClass1(this), 2);
        BitableTimeZoneListViewModel r0 = (BitableTimeZoneListViewModel) q.a(this, BitableTimeZoneListViewModel.class);
        if (r0 == null) goto L5;
        r5.c(r0.getLynxWebDelegate());
    L5:
        r5.f(new b(this));
        this.h = r5;
    }

    public final Dialog onCreateDialog(Bundle r13) {
        int r0 = 0;
        setStyle(0, 2131952402);
        if (r13 != null) goto L5;
        r13 = new Bundle();
    L5:
        Dialog r14 = super.onCreateDialog(r13);
        CCMLynxCardView r3 = null;
        View r1 = View.inflate(getActivity(), 2131559172, null);
        Intrinsics.checkNotNull(r1);
        CommonActionPanelLayout r4 = r1.findViewById(2131381877);
        this.i = r4;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r4 = null;
    L8:
        r4.b(true);
        CommonActionPanelLayout r5 = this.i;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r5 = null;
    L11:
        com.bytedance.ee.bear.facade.common.widget.d r6 = r5.getDragUtil();
        if (r6 == null) goto L14;
        r6.e();
    L14:
        Ref.IntRef r7 = new Ref.IntRef();
        CommonActionPanelLayout r8 = this.i;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r8 = null;
    L17:
        com.bytedance.ee.bear.facade.common.widget.d r9 = r8.getDragUtil();
        if (r9 == null) goto L20;
        r9.h = new com.bytedance.ee.bear.bitable.timezone.c(this, r7);
    L20:
        CommonActionPanelLayout r10 = this.i;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r10 = null;
    L23:
        com.bytedance.ee.bear.facade.common.widget.d r11 = r10.getDragUtil();
        if (r11 == null) goto L26;
        r11.n = new d(r7, this);
    L26:
        ViewParent r12 = r1.getParent();
        if (r12 == null) goto L29;
        ((ViewGroup) r12).removeAllViews();
    L29:
        r1.setOnClickListener(new com.bytedance.ee.bear.bitable.timezone.a(this));
        Bundle r16 = getArguments();
        if (r16 == null) goto L32;
        String r17 = r16.getString("panel_content_page");
    L33:
        Bundle r18 = getArguments();
        if (r18 == null) goto L47;
        String r19 = r18.getString("panel_data");
        if (r19 == null) goto L47;
        JSONObject r20 = new JSONObject(r19);
        int r21 = n.E((int) (((double) n.t()) * 0.9d));
        if (r17 == null) goto L47;
        HashMap r22 = new HashMap();
        r22.put(TimeZoneItemV2.TIME_ZONE, r20.get(TimeZoneItemV2.TIME_ZONE));
        Object r23 = r20.get("timeZoneList");
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray r24 = (JSONArray) r23;
        int r26 = r24.length();
    L40:
        if (r0 >= r26) goto L42;
        JSONObject r27 = JSONArrayProtectorUtils.getJSONObject(r24, r0);
        Object r110 = r27.get("id");
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.String");
        String r111 = zu5.b.b(TimeZone.getTimeZone((String) r110));
        r27.remove("formate");
        r27.put("formate", r111);
        r0 = r0 + 1;
        goto L40
    L42:
        r22.put("initDatas", r24);
        r22.put("pageHeight", Integer.valueOf(r21));
        CCMLynxCardView r2 = this.h;
        if (r2 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mCcmLynxCardView");
    L46:
        CCMLynxCardView.a.a(r3, (ViewGroup) r1.findViewById(2131381877), 4, r22, new ViewGroup.LayoutParams(-1, -2));
        goto L47
    L45:
        r3 = r2;
    L47:
        r14.setContentView(r1);
        Window r28 = r14.getWindow();
        if (r28 == null) goto L50;
        WindowManager.LayoutParams r29 = r28.getAttributes();
        r29.width = -1;
        r29.height = n.t();
        r29.flags |= 256;
        r29.gravity = 80;
    L50:
        r14.setOnCancelListener(new c(this));
        return r14;
    L32:
        r17 = null;
        goto L33
    }

    public final void show(FragmentManager r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "manager");
        tt5.a.b("BitableTimeZoneListFragment", "show: " + j);
        if (j == false) goto L29;
        return;
    L29:
        boolean r3 = true;
        if (r5.findFragmentByTag(r6) != null) goto L17;
        r5.beginTransaction().remove(this).commitAllowingStateLoss();     // Catch: Exception -> L23
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L23
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r6, r0);     // Catch: Exception -> L23
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, this, r0) == false) goto L27;
    L12:
        j = true;     // Catch: Exception -> L23
        Dialog r7 = getDialog();     // Catch: Exception -> L23
        if (r7 == null) goto L30;
        Window r8 = r7.getWindow();     // Catch: Exception -> L23
        if (r8 == null) goto L31;
        r8.clearFlags(131072);     // Catch: Exception -> L23
        return;
    L31:
        return;
    L30:
        return;
    L27:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L11:
        super.show(r5, r6);     // Catch: Exception -> L23
        goto L12
    L17:
        StringBuilder r1 = new StringBuilder("manager had Fragment: ");     // Catch: Exception -> L23
        if (r5.findFragmentByTag(r6) == null) goto L21;
        r3 = false;
    L21:
        r1.append(r3);     // Catch: Exception -> L23
        tt5.a.b("BitableTimeZoneListFragment", r1.toString());     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        tt5.a.d("BitableTimeZoneListFragment", "show error: " + e);
    }
}
