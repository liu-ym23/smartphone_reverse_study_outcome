package com.larus.dora.impl.nl.notification_rule.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraFragmentCustomBroadcastRulesBinding;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/CustomBroadcastRulesFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraFragmentCustomBroadcastRulesBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraFragmentCustomBroadcastRulesBinding;", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "adapter", "Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter;", "enterPageTraced", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initUI", "initData", "showAddRuleBottomSheet", "showEditRuleDialog", com.heytap.mcssdk.constant.b.f276366p, "Lcom/larus/dora/api/entity/NotificationRule;", "showDeleteConfirmDialog", "showLongClickMenu", "anchor", "onDestroyView", "onResume", "traceEnterPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomBroadcastRulesFragment extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f336300h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDoraFragmentCustomBroadcastRulesBinding f336301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CustomBroadcastRulesViewModel f336302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NotificationRuleAdapter f336303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f336304g;

    public static final class a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomBroadcastRulesFragment f336305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NotificationRule f336306b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            CustomBroadcastRulesViewModel r100 = this.f336305a.f336302e;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r100 = null;
        L5:
            String r101 = this.f336306b.getId();
            if (r101 != null) goto L8;
            r101 = "";
        L8:
            r100.deleteRule(r101);
        }

        public a(CustomBroadcastRulesFragment r100, NotificationRule r101) {
            this.f336305a = r100;
            this.f336306b = r101;
        }
    }

    public static final class b implements com.larus.common_ui.dialog.u {
        public b() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f336301d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f336304g == true) goto L25;
        Bundle r100 = getArguments();
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.getString("extra_current_page");
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L23;
        DoraBuryPointManager r104 = DoraBuryPointManager.f331862a;
        Pair[] r105 = new Pair[2];
        r105[0] = TuplesKt.to("current_page", r102);
        Bundle r106 = getArguments();
        if (r106 == null) goto L20;
        r101 = r106.getString("extra_previous_page");
    L20:
        if (r101 != null) goto L22;
        r101 = "";
    L22:
        r105[1] = TuplesKt.to("previous_page", r101);
        r104.L(CheckPointType.ENTER_PAGE, MapsKt.mapOf(r105));
    L23:
        this.f336304g = true;
        return;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L7:
        r102 = null;
        goto L9
    }

    public CustomBroadcastRulesFragment() {
    }

    public final void T90(NotificationRule r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        CommonDialog.a r102 = new CommonDialog.a();
        r102.i(r101.getString(R.string.larus_dora_broadcast_dialog_delete_rule_title_cn));
        r102.g(r101.getString(R.string.larus_dora_broadcast_dialog_delete_rule_desc_cn));
        CommonDialog.a.f(r102, new a(this, r100), r101.getString(R.string.larus_dora_broadcast_dialog_delete_rule_btn_confirm_cn), false, 12);
        CommonDialog.a.e(r102, new b(), r101.getString(R.string.larus_dora_broadcast_cancel_cn), 4);
        CommonDialog r103 = r102.a();
        FragmentManager r104 = getChildFragmentManager();
        LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, "DeleteNotificationRuleDialog", r105);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r103, r105) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r103.show(r104, "DeleteNotificationRuleDialog");
        return;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.dora.impl.nl.notification_rule.ui.n] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.dora.impl.nl.notification_rule.ui.p] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.dora.impl.nl.notification_rule.ui.q] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.dora.impl.nl.notification_rule.ui.r] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L17;
        this.f336302e = (CustomBroadcastRulesViewModel) new ViewModelProvider(r100).get(CustomBroadcastRulesViewModel.class);
        this.f336303f = new NotificationRuleAdapter(new n(this), new p(this), new q(this), new r(this));
        LarusDoraFragmentCustomBroadcastRulesBinding r101 = this.f336301d;
        if (r101 == null) goto L13;
        RecyclerView r102 = r101.f332566f;
        if (r102 == null) goto L13;
        r102.setLayoutManager(new LinearLayoutManager(r102.getContext()));
        NotificationRuleAdapter r103 = this.f336303f;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r103 = null;
    L12:
        r102.setAdapter(r103);
        r102.addOnScrollListener(new CustomBroadcastRulesFragment$initData$5$1(this));
    L13:
        Lifecycle.State r104 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CustomBroadcastRulesFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r104, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CustomBroadcastRulesFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r104, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CustomBroadcastRulesFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r104, null, this), 3, null);
        CustomBroadcastRulesViewModel r105 = this.f336302e;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r105 = null;
    L16:
        r105.loadRules();
    L17:
        LarusDoraFragmentCustomBroadcastRulesBinding r106 = this.f336301d;
        if (r106 == null) goto L22;
        Group r107 = r106.f332565e;
        if (r107 == null) goto L22;
        r107.setReferencedIds(new int[]{R.id.iv_empty_icon, R.id.tv_empty_title, R.id.tv_empty_desc});
    L22:
        LarusDoraFragmentCustomBroadcastRulesBinding r108 = this.f336301d;
        if (r108 == null) goto L27;
        NovaTitleBarEx r109 = r108.f332567g;
        if (r109 == null) goto L27;
        NovaTitleBarEx.Y5(r109, getString(R.string.larus_dora_broadcast_title_custom_broadcast_rules_cn), null, null, 6);
        NovaTitleBarEx.b6(r109, R.drawable.larus_dora_ic_left_back, false, null, null, new s(this), 14);
    L27:
        LarusDoraFragmentCustomBroadcastRulesBinding r110 = this.f336301d;
        if (r110 == null) goto L32;
        LinearLayout r111 = r110.f332562b;
        if (r111 == null) goto L32;
        e1.d(r111, new t(this));
    L32:
        LarusDoraFragmentCustomBroadcastRulesBinding r112 = this.f336301d;
        if (r112 == null) goto L38;
        ConstraintLayout r113 = r112.f332561a;
        if (r113 == null) goto L39;
        ViewCompat.setOnApplyWindowInsetsListener(r113, new u(this));
        return;
    L39:
        return;
    }

    public static void S90(NotificationRuleBottomSheet r100, FragmentManager r101, String r102) {
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, r102, r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r103) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_dora_fragment_custom_broadcast_rules, r110, false);
        int r112 = R.id.add_rule_btn;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.add_rule_btn);
        if (r102 == null) goto L23;
        r112 = R.id.bottom_desc;
        DoraTextView r103 = (DoraTextView) ViewBindings.findChildViewById(r101, R.id.bottom_desc);
        if (r103 == null) goto L23;
        r112 = R.id.bottom_gradient;
        View r104 = ViewBindings.findChildViewById(r101, R.id.bottom_gradient);
        if (r104 == null) goto L23;
        r112 = R.id.group_empty;
        Group r105 = (Group) ViewBindings.findChildViewById(r101, R.id.group_empty);
        if (r105 == null) goto L23;
        r112 = R.id.iv_empty_icon;
        if (((ImageView) ViewBindings.findChildViewById(r101, R.id.iv_empty_icon)) == null) goto L23;
        r112 = R.id.rules_recycler_view;
        RecyclerView r106 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.rules_recycler_view);
        if (r106 == null) goto L23;
        r112 = R.id.title_bar;
        NovaTitleBarEx r107 = (NovaTitleBarEx) ViewBindings.findChildViewById(r101, R.id.title_bar);
        if (r107 == null) goto L23;
        r112 = R.id.tv_empty_desc;
        if (((DoraTextView) ViewBindings.findChildViewById(r101, R.id.tv_empty_desc)) == null) goto L23;
        r112 = R.id.tv_empty_title;
        if (((DoraTextView) ViewBindings.findChildViewById(r101, R.id.tv_empty_title)) == null) goto L23;
        ConstraintLayout r108 = (ConstraintLayout) r101;
        this.f336301d = new LarusDoraFragmentCustomBroadcastRulesBinding(r108, r102, r103, r104, r105, r106, r107);
        return r108;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
