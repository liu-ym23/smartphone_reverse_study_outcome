package com.bytedance.ee.bear.bitable.statistics;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.common.WatermarkUtils;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.utils.g;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.k;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "dragPanel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "lynxView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "onStart", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableStatisticsPanelFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int k = 0;
    public final Lazy h;
    public CommonActionPanelLayout i;
    public CCMLynxCardView j;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BitableStatisticsPanelFragment a;

        public b(BitableStatisticsPanelFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            String r4 = (String) r3;
            tt5.a.b("BitableStatisticsPanelFragment", "sendObtainData, " + r4);
            CCMLynxCardView r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.sendEvent("ccm-send-obtainData", CollectionsKt.listOf(r4));
            return;
        }
    }

    public static final class c implements CCMLynxCardView.b {
        public final /* synthetic */ BitableStatisticsPanelFragment a;

        public final void a(Map<String, String> r1) {
        }

        public final void onShow() {
        }

        public final void H() {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public c(BitableStatisticsPanelFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ BitableStatisticsPanelFragment a;

        public d(BitableStatisticsPanelFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            BitableStatisticsPanelFragment r3 = this.a;
            int r0 = BitableStatisticsPanelFragment.k;
            r3.Z90().close();
        }
    }

    public static final class e extends CommonActionPanelLayout.b {
        public final /* synthetic */ BitableStatisticsPanelFragment a;

        public final void d() {
            BitableStatisticsPanelFragment r0 = this.a;
            int r1 = BitableStatisticsPanelFragment.k;
            r0.Z90().close();
        }

        public e(BitableStatisticsPanelFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final BitableStatisticsPanelViewModel Z90() {
        return (BitableStatisticsPanelViewModel) this.h.getValue();
    }

    public BitableStatisticsPanelFragment() {
        this.h = LazyKt.lazy(new BitableStatisticsPanelFragment$viewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        CCMLynxCardView r0 = this.j;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        Z90().getActive().setValue(Boolean.FALSE);
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
        String r3 = Z90().getSrcObjToken();
        Integer r4 = Z90().getSrcObjType();
        if (g.b() == false) goto L10;
        int r5 = WatermarkUtils.a;
        WatermarkUtils.a(g.a(r3, r4), getDialog());
        return;
    L10:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        CCMLynxCardView r4 = this.j;
        if (r4 == null) goto L5;
        r4.b();
    L5:
        CommonActionPanelLayout r5 = this.i;
        CommonActionPanelLayout r0 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanel");
        r5 = null;
    L8:
        com.bytedance.ee.bear.facade.common.widget.d r6 = r5.getDragUtil();
        if (r6 == null) goto L11;
        r6.e();
    L11:
        CommonActionPanelLayout r7 = this.i;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanel");
    L15:
        com.bytedance.ee.bear.facade.common.widget.d r8 = r0.getDragUtil();
        if (r8 == null) goto L19;
        r8.f();
        return;
    L19:
        return;
    L14:
        r0 = r7;
        goto L15
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Z90().getTemplateData().observe(this, new AnonymousClass1(this));
        Z90().getObtainGroupData().observe(this, new b(this));
        CCMLynxCardView r5 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new AnonymousClass3(this), 2);
        r5.c(Z90().getLynxWebDelegate());
        r5.f(new c(this));
        this.j = r5;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        r5.setOnClickListener(new d(this));
        CommonActionPanelLayout r7 = r5.findViewById(2131381866);
        this.i = r7;
        CommonActionPanelLayout r8 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanel");
        r7 = null;
    L5:
        com.bytedance.ee.bear.facade.common.widget.d r9 = r7.getDragUtil();
        if (r9 == null) goto L8;
        r9.f();
    L8:
        CommonActionPanelLayout r10 = this.i;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanel");
        r10 = null;
    L11:
        r10.b(true);
        CommonActionPanelLayout r11 = this.i;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanel");
        r11 = null;
    L14:
        r11.setOnActionListener(new e(this));
        if (Z90().getPanelType() != StatPanelType.TOTAL_STATISTICS_VIEW) goto L23;
        CommonActionPanelLayout r12 = this.i;
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanel");
    L20:
        r8.setTitle(getResources().getString(2131886636));
        BitableFieldEditAnalytic r13 = Z90().getAnalytic();
        if (r13 == null) goto L31;
        HashMap r14 = new HashMap();
        r14.put("mobile_grid_type", ((BitableAnalytic) r13).a.b());
        r13.t("ccm_bitable_statistics_view", r14);
        return;
    L31:
        return;
    L19:
        r8 = r12;
        goto L20
    L23:
        BitableFieldEditAnalytic r16 = Z90().getAnalytic();
        if (r16 == null) goto L33;
        String r17 = Z90().getFocusStatType();
        List<String> r0 = Z90().getFocusId();
        if (r0 == null) goto L28;
        int r1 = r0.size();
    L29:
        HashMap r2 = new HashMap();
        r2.put("statstics_type", r17);
        r2.put("group_num", Integer.valueOf(r1));
        r2.put("mobile_grid_type", ((BitableAnalytic) r16).a.b());
        r16.t("ccm_bitable_group_statistics_view", r2);
        return;
    L28:
        r1 = 0;
        goto L29
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r7 = r4.inflate(2131559157, r5, false);
        CCMLynxCardView r8 = this.j;
        if (r8 == null) goto L5;
        CCMLynxCardView.a.a(r8, (ViewGroup) r7.findViewById(2131381866), 1, (Map) Z90().getTemplateData().getValue(), new ViewGroup.LayoutParams(-1, -1));
    L5:
        return r7;
    }
}
