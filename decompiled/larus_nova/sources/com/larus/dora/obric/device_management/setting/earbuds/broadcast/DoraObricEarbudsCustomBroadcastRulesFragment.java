package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.status.OPageStatus;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010'\u001a\u00020 H\u0002J\u0016\u0010(\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u000200H\u0002J\u0014\u00101\u001a\u00020 *\u00020-2\u0006\u0010.\u001a\u00020+H\u0002J\u0018\u00102\u001a\u0002002\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u000200H\u0002J\f\u00105\u001a\u00020 *\u00020-H\u0002J\f\u00106\u001a\u00020 *\u00020-H\u0002J\b\u00107\u001a\u00020\u000fH\u0002J\b\u00108\u001a\u00020\u0011H\u0002J\b\u00109\u001a\u00020\u0013H\u0002J\b\u0010:\u001a\u00020 H\u0002J\u0010\u0010;\u001a\u00020 2\u0006\u0010.\u001a\u00020+H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010.\u001a\u00020+H\u0002J\b\u0010=\u001a\u00020 H\u0002J\f\u0010>\u001a\u000200*\u000200H\u0002J\f\u0010?\u001a\u000200*\u00020@H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsCustomBroadcastRulesFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "page", "Lcom/larus/dora/obric/device_management/setting/earbuds/ui/DoraObricEarbudsOuiPage;", "listContainer", "Landroid/widget/LinearLayout;", "emptyView", "Lcom/obric/oui/status/OPageStatus;", "bottomDesc", "Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "addButton", "Lcom/obric/oui/button/OButton;", "canAddRule", "", "enterPageReported", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "observeViewModel", "renderList", "rules", "", "Lcom/larus/dora/api/entity/NotificationRule;", "buildRuleCard", "Lcom/obric/oui/lisitem/OCardListItem;", com.heytap.mcssdk.constant.b.f276366p, "position", "", "toggleRuleSelectionWithDebounce", "resolveCardPosition", "index", "size", "applyCardStyle", "resetCardContainerMargins", "buildEmptyView", "buildSectionSupportiveText", "buildAddButton", "onAddRuleClicked", "showEditDeleteDialog", "showDeleteConfirmDialog", "traceEnterPage", "dp", CloudControlInf.SP, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsCustomBroadcastRulesFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f339783n = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f339784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b79.d f339785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f339786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OPageStatus f339787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OSectionSupportiveText f339788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OButton f339789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f339790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f339791m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f339785g = null;
        this.f339786h = null;
        this.f339787i = null;
        this.f339788j = null;
        this.f339789k = null;
        super.onDestroyView();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        b79.d r100 = this.f339785g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f17984e;
    }

    public final CustomBroadcastRulesViewModel Y90() {
        return (CustomBroadcastRulesViewModel) this.f339784f.getValue();
    }

    public DoraObricEarbudsCustomBroadcastRulesFragment() {
        this.f339784f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CustomBroadcastRulesViewModel.class), new DoraObricEarbudsCustomBroadcastRulesFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsCustomBroadcastRulesFragment$special$$inlined$activityViewModels$default$2(this));
        this.f339790l = true;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f339791m == true) goto L25;
        Bundle r100 = getArguments();
        String r101 = null;
        if (r100 == null) goto L8;
        String r102 = r100.getString("extra_current_page");
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L26;
        this.f339791m = true;
        DoraBuryPointManager r104 = DoraBuryPointManager.f331862a;
        Pair[] r105 = new Pair[2];
        r105[0] = TuplesKt.to("current_page", r102);
        Bundle r106 = getArguments();
        if (r106 == null) goto L21;
        r101 = r106.getString("extra_previous_page");
    L21:
        if (r101 != null) goto L23;
        r101 = "";
    L23:
        r105[1] = TuplesKt.to("previous_page", r101);
        r104.L(CheckPointType.ENTER_PAGE, MapsKt.mapOf(r105));
        return;
    L26:
        return;
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L8:
        r102 = null;
        goto L10
    }

    public final int X90(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static void W90(DoraObricEarbudsAddRuleInputSheet r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "DoraObricEarbudsAddRuleInputSheet", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, "DoraObricEarbudsAddRuleInputSheet");
    }

    public final void Z90(OCardListItem r100, NotificationRule r101) {
        if (com.larus.dora.obric.device_management.setting.earbuds.k.a(r100) == true) goto L6;
        Y90().toggleRuleSelection(r101);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Lifecycle.State r112 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsCustomBroadcastRulesFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r112, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsCustomBroadcastRulesFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r112, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsCustomBroadcastRulesFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r112, null, this), 3, null);
        Y90().loadRules();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = requireContext();
        int r104 = com.larus.utils.j0.f375426a;
        b79.d r105 = new b79.d(r103, com.larus.utils.j0.d(R.string.larus_dora_broadcast_title_custom_broadcast_rules_cn), new o1(this));
        this.f339785g = r105;
        OPageStatus r106 = new OPageStatus(requireContext(), null, 6, 0);
        r106.setType(0);
        r106.setPadding(0, X90(48), 0, 0);
        r106.setTitle(getString(R.string.larus_dora_broadcast_custom_rule_empty_title_cn));
        r106.setMessage(null);
        r106.a(false);
        r105.a(r106, 0);
        this.f339787i = r106;
        LinearLayout r107 = new LinearLayout(requireContext());
        r107.setOrientation(1);
        r107.setClipChildren(false);
        r107.setClipToPadding(false);
        r107.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r105.a(r107, 0);
        this.f339786h = r107;
        OSectionSupportiveText r108 = new OSectionSupportiveText(requireContext(), null, 6, 0);
        r108.setSectionDes(getString(R.string.larus_dora_broadcast_v3_custom_rule_desc_cn));
        LinearLayout r109 = r105.f17982c;
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-1, -2);
        r110.setMarginStart(X90(20));
        r110.setMarginEnd(X90(20));
        r110.topMargin = X90(8);
        Unit r111 = Unit.INSTANCE;
        r109.addView(r108, r110);
        this.f339788j = r108;
        View r112 = new View(r105.f17980a);
        r112.setLayoutParams(new LinearLayout.LayoutParams(-1, r105.b(88)));
        r105.f17982c.addView(r112);
        FrameLayout r113 = new FrameLayout(requireContext());
        r113.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r113.addView(r105.f17985f, new FrameLayout.LayoutParams(-1, -1));
        OButton r114 = (OButton) vma.e.a(requireContext(), R.style.OStyleV2_OButton_L_Standard_Primary, new w1(this));
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-1, X90(48), 80);
        r115.setMarginStart(X90(24));
        r115.setMarginEnd(X90(24));
        r115.bottomMargin = X90(24);
        r113.addView(r114, r115);
        this.f339789k = r114;
        return r113;
    }
}
