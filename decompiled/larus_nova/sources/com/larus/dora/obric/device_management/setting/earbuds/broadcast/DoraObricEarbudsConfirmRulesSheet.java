package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J.\u0010\u001f\u001a\u00020\u001a2\u001e\b\u0004\u0010 \u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0006\u0012\u0004\u0018\u00010#0!H\u0082\b¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000eH\u0002J\f\u0010)\u001a\u00020\u001a*\u00020*H\u0002J\u001a\u0010+\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001aH\u0016J\f\u0010/\u001a\u000200*\u000200H\u0002J\f\u00101\u001a\u000200*\u000202H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsConfirmRulesSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "confirmButton", "Lcom/obric/oui/button/OButton;", "reDescribeButton", "originalDesc", "", "getOriginalDesc", "()Ljava/lang/String;", "generatedRules", "", "getGeneratedRules", "()Ljava/util/List;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "buildHeader", "", DocumentType.SHEET_NAME, "Lcom/obric/oui/sheet/v2/OSheet;", "buildFooter", "observeViewModel", "launchAndRepeatWithLifecycle", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "buildBody", "Landroid/view/View;", "buildSectionLabel", "text", "applySectionLabelTextStyle", "Landroid/widget/TextView;", "buildCard", "isGeneratedRule", "", "onDestroyView", "dp", "", CloudControlInf.SP, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsConfirmRulesSheet extends DialogFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f339779g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f339780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OButton f339781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OButton f339782f;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f339781e = null;
        this.f339782f = null;
        super.onDestroyView();
    }

    public DoraObricEarbudsConfirmRulesSheet() {
        this.f339780d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CustomBroadcastRulesViewModel.class), new DoraObricEarbudsConfirmRulesSheet$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsConfirmRulesSheet$special$$inlined$activityViewModels$default$2(this));
    }

    public final List<String> V90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L9;
        ArrayList<String> r101 = r100.getStringArrayList("arg_generated_rules");
        if (r101 == null) goto L9;
        List<String> r102 = CollectionsKt.toList(r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return CollectionsKt.emptyList();
    }

    public final OSectionTitleBar T90(String r100) {
        OSectionTitleBar r101 = new OSectionTitleBar(requireContext(), null, 6, 0);
        r101.setTitleText(r100);
        r101.b(false);
        r101.a(false);
        LinearLayout r102 = (LinearLayout) r101.findViewById(R.id.container);
        if (r102 == null) goto L5;
        r102.setPadding(U90(20), U90(8), U90(12), U90(8));
    L5:
        TextView r103 = (TextView) r101.findViewById(R.id.titleTextView);
        if (r103 == null) goto L8;
        r103.setTextColor(v19.c.a(R.attr.larus_neutral_50, requireContext(), R.color.larus_neutral_50));
        r103.setTextSize(2, 12.0f);
        r103.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false));
    L8:
        r101.setLayoutParams(new LinearLayout.LayoutParams(U90(336), U90(32)));
        return r101;
    }

    public final int U90(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final int W90(float r100) {
        Resources r101 = getResources();
        return (int) TypedValue.applyDimension(2, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r210) {
        OSheet r110 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.o(r110, OSheet.Header.ONLY_TITLE, null, getString(R.string.larus_dora_broadcast_half_dialog_confirm_rule_title_cn), getString(R.string.larus_dora_broadcast_half_dialog_confirm_rule_desc_cn), false, null, null, 16166);
        TextView r100 = (TextView) r110.findViewById(R.id.fixed_center_sub_title);
        if (r100 == null) goto L10;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof LinearLayout.LayoutParams) == false) goto L7;
        LinearLayout.LayoutParams r102 = (LinearLayout.LayoutParams) r101;
    L8:
        if (r102 == null) goto L10;
        r102.topMargin = U90(4);
        r100.setLayoutParams(r102);
        goto L10
    L7:
        r102 = null;
    L10:
        Context r103 = requireContext();
        LinearLayout r104 = new LinearLayout(r103);
        r104.setOrientation(1);
        r104.setPadding(0, 0, 0, U90(24));
        LinearLayout r105 = new LinearLayout(r103);
        r105.setOrientation(1);
        r105.setGravity(1);
        OSectionTitleBar r106 = T90(getString(R.string.larus_dora_broadcast_half_dialog_confirm_rule_original_desc_label_cn));
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof LinearLayout.LayoutParams) == false) goto L13;
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107;
    L14:
        if (r108 == null) goto L16;
        r108.topMargin = U90(8);
    L16:
        r105.addView(r106);
        Bundle r109 = getArguments();
        if (r109 == null) goto L19;
        String r111 = r109.getString("arg_original_desc");
    L20:
        if (r111 != null) goto L22;
        r111 = "";
    L22:
        r105.addView(S90(r111, false));
        OSectionTitleBar r112 = T90(getString(R.string.larus_dora_broadcast_half_dialog_confirm_rule_generated_count_cn, new Object[]{String.valueOf(V90().size())}));
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof LinearLayout.LayoutParams) == false) goto L25;
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) r113;
    L27:
        if (r114 == null) goto L29;
        r114.topMargin = U90(16);
    L29:
        r105.addView(r112);
        Iterator<T> r115 = V90().iterator();
        int r116 = 0;
    L31:
        if (r115.hasNext() == false) goto L45;
        Object r117 = r115.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        View r119 = S90((String) r117, true);
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if ((r120 instanceof LinearLayout.LayoutParams) == false) goto L38;
        LinearLayout.LayoutParams r121 = (LinearLayout.LayoutParams) r120;
    L39:
        if (r121 == null) goto L44;
        if (r116 != 0) goto L42;
        int r122 = 0;
    L43:
        r121.topMargin = r122;
        goto L44
    L42:
        r122 = U90(16);
    L44:
        r105.addView(r119);
        r116 = r118;
        goto L31
    L38:
        r121 = null;
        goto L39
    L45:
        NestedScrollView r123 = new NestedScrollView(r103);
        r123.setOverScrollMode(2);
        r123.addView(r105, new ViewGroup.LayoutParams(-1, -2));
        r104.addView(r123, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        OSheetBase.DefaultImpls.j(r110, r104);
        OSheetBase.DefaultImpls.k(r110, getString(R.string.larus_dora_broadcast_half_dialog_confirm_rule_btn_redescribe_cn), false, new j1(this), getString(R.string.larus_dora_broadcast_half_dialog_confirm_rule_btn_confirm_add_cn), true, new k1(this));
        this.f339782f = (OButton) r110.findViewById(R.id.btn_negative);
        OButton r124 = (OButton) r110.findViewById(R.id.btn_positive);
        this.f339781e = r124;
        if (r124 == null) goto L48;
        r124.setSelected(true);
    L48:
        r110.setOnDismissListener(new i1(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$1(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$3(this, null, this), 3, null);
        return r110;
    L25:
        r114 = null;
        goto L27
    L19:
        r111 = null;
        goto L20
    L13:
        r108 = null;
        goto L14
    }

    public final View S90(String r100, boolean r101) {
        Context r102 = requireContext();
        LinearLayout r103 = new LinearLayout(r102);
        r103.setOrientation(1);
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(0);
        r104.setCornerRadius(U90(20));
        r104.setColor(v19.c.a(R.attr.larus_base_1, r102, R.color.larus_base_1));
        r103.setBackground(r104);
        r103.setPadding(U90(8), U90(8), U90(8), U90(8));
        TextView r105 = new TextView(r102);
        r105.setText(r100);
        r105.setTextColor(v19.c.a(R.attr.larus_neutral_100, r102, R.color.larus_neutral_100));
        if (r101 == false) goto L5;
        float r106 = 15.0f;
    L6:
        r105.setTextSize(2, r106);
        if (r101 == false) goto L9;
        float r107 = 22.5f;
    L10:
        TextViewCompat.setLineHeight(r105, W90(r107));
        Typeface r108 = Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0);
        if (r101 == false) goto L13;
        int r109 = 500;
    L14:
        r105.setTypeface(Typeface.create(r108, r109, false));
        r105.setPadding(U90(12), U90(13), U90(12), U90(13));
        r103.addView(r105, new LinearLayout.LayoutParams(-1, -2));
        r103.setLayoutParams(new LinearLayout.LayoutParams(U90(328), -2));
        return r103;
    L13:
        r109 = 400;
        goto L14
    L9:
        r107 = 22.0f;
        goto L10
    L5:
        r106 = 16.0f;
        goto L6
    }
}
