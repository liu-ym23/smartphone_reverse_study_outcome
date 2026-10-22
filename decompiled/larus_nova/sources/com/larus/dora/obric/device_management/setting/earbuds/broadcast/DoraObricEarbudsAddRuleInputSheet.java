package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J.\u0010\u001f\u001a\u00020\u00192\u001e\b\u0004\u0010 \u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\"\u0012\u0006\u0012\u0004\u0018\u00010#0!H\u0082\b¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\f\u0010*\u001a\u00020\u0019*\u00020\rH\u0002J\u0010\u0010+\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u0011H\u0002J\b\u00106\u001a\u00020\u0019H\u0016J\f\u00107\u001a\u000203*\u000203H\u0002J\f\u00108\u001a\u000203*\u000209H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006;"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAddRuleInputSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "ruleInput", "Landroid/widget/EditText;", "charCount", "Landroid/widget/TextView;", "generateButton", "Lcom/obric/oui/button/OButton;", "isLoading", "", "editingRule", "Lcom/larus/dora/api/entity/NotificationRule;", "getEditingRule", "()Lcom/larus/dora/api/entity/NotificationRule;", "isEditMode", "()Z", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "observeViewModel", "launchAndRepeatWithLifecycle", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "buildContent", "Landroid/view/View;", "buildInputLabel", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "applyLabelTextStyle", "buildInputCard", "buildInputField", "focusRuleInput", "showKeyboard", "input", "handleAction", "updateCharCount", "length", "", "updateGenerateEnabled", "enabled", LiveCommonConstants.REASON_ON_DEDTROY, "dp", CloudControlInf.SP, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsAddRuleInputSheet extends DialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f339726i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f339727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OEditText f339728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f339729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OButton f339730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f339731h;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f339728e = null;
        this.f339729f = null;
        this.f339730g = null;
        super.onDestroy();
    }

    public final void T90() {
        final OEditText r100 = this.f339728e;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.requestFocus();
        Editable r101 = r100.getText();
        if (r101 == null) goto L8;
        int r102 = r101.length();
    L9:
        r100.setSelection(r102);
        r100.post(new g(this, r100));
        return;
    L8:
        r102 = 0;
        goto L9
    }

    public final CustomBroadcastRulesViewModel V90() {
        return (CustomBroadcastRulesViewModel) this.f339727d.getValue();
    }

    public DoraObricEarbudsAddRuleInputSheet() {
        this.f339727d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CustomBroadcastRulesViewModel.class), new DoraObricEarbudsAddRuleInputSheet$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsAddRuleInputSheet$special$$inlined$activityViewModels$default$2(this));
    }

    public final NotificationRule U90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        Serializable r101 = r100.getSerializable("arg_rule");
    L7:
        if ((r101 instanceof NotificationRule) == true) goto L9;
        return null;
    L9:
        return (NotificationRule) r101;
    L5:
        r101 = null;
        goto L7
    }

    public final int S90(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void W90(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L7:
        OButton r102 = this.f339730g;
        if (r102 == null) goto L10;
        r102.setEnabled(r101);
    L10:
        OButton r103 = this.f339730g;
        if (r103 == null) goto L17;
        if (r101 == false) goto L14;
        float r104 = 1.0f;
    L15:
        r103.setAlpha(r104);
        return;
    L14:
        r104 = 0.3f;
        goto L15
    L17:
        return;
    L4:
        if (this.f339731h == true) goto L6;
        r101 = true;
        goto L7
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r210) {
        super.onCreate(r210);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$1(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$3(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$4(this, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$5(this, null, this), 3, null);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r110) {
        boolean r111 = false;
        OSheet r112 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.q(r112, OSheet.HeightMode.FULL_HEIGHT);
        OSheet.Header r100 = OSheet.Header.PAGE;
        if (U90() == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        int r102 = R.string.larus_dora_broadcast_title_edit_custom_rule_cn;
    L9:
        OSheetBase.DefaultImpls.o(r112, r100, null, getString(r102), null, false, new com.larus.dora.obric.device_management.setting.earbuds.broadcast.a(this), null, 16182);
        Context r103 = requireContext();
        LinearLayout r104 = new LinearLayout(r103);
        r104.setOrientation(1);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        OSectionTitleBar r105 = new OSectionTitleBar(r103, null, 6, 0);
        r105.setTitleText(getString(R.string.larus_dora_g_feedback_description_cn));
        r105.b(false);
        r105.a(false);
        LinearLayout r106 = (LinearLayout) r105.findViewById(R.id.container);
        if (r106 == null) goto L12;
        r106.setPadding(S90(20), S90(8), S90(12), S90(8));
    L12:
        TextView r107 = (TextView) r105.findViewById(R.id.titleTextView);
        if (r107 == null) goto L15;
        r107.setTextColor(v19.c.a(R.attr.larus_neutral_50, requireContext(), R.color.larus_neutral_50));
        r107.setTextSize(2, 12.0f);
        r107.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 500, false));
    L15:
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-1, S90(32));
        r108.topMargin = S90(8);
        Unit r109 = Unit.INSTANCE;
        r104.addView(r105, r108);
        LinearLayout r113 = new LinearLayout(r103);
        r113.setOrientation(1);
        GradientDrawable r114 = new GradientDrawable();
        r114.setShape(0);
        r114.setCornerRadius(S90(20));
        r114.setColor(v19.c.a(R.attr.larus_base_1, r103, R.color.larus_base_1));
        r113.setBackground(r114);
        r113.setPadding(S90(8), S90(8), S90(8), S90(8));
        LinearLayout r115 = new LinearLayout(r103);
        r115.setOrientation(1);
        r115.setPadding(S90(12), S90(8), S90(12), S90(8));
        final OEditText r116 = new OEditText(r103, null, 6, 0);
        r116.setHint(getString(R.string.larus_dora_broadcast_half_dialog_add_custom_rule_placeholder_cn));
        r116.setBackground(null);
        r116.setGravity(8388659);
        r116.setIncludeFontPadding(false);
        r116.setFocusable(true);
        r116.setFocusableInTouchMode(true);
        r116.setSingleLine(false);
        r116.setInputType(147457);
        r116.setHintTextColor(v19.c.a(R.attr.larus_neutral_30, r103, R.color.larus_neutral_30));
        r116.setTextColor(v19.c.a(R.attr.larus_neutral_100, r103, R.color.larus_neutral_100));
        r116.setTextSize(2, 16.0f);
        Resources r117 = getResources();
        TextViewCompat.setLineHeight(r116, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r117, r117.getDisplayMetrics())));
        r116.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(300)});
        r116.setOnClickListener(new e(this));
        r116.setOnFocusChangeListener(new f(r116, this));
        r116.addTextChangedListener(new i(this));
        NotificationRule r118 = U90();
        if (r118 == null) goto L18;
        String r119 = r118.getRuleDesc();
    L19:
        if (r119 != null) goto L22;
        r119 = "";
    L22:
        if (r119.length() <= 0) goto L24;
        boolean r120 = true;
    L25:
        if (r120 == true) goto L28;
        r119 = null;
    L28:
        if (r119 == null) goto L33;
        r116.setText(r119);
        r116.setSelection(r119.length());
        int r121 = r119.length();
        TextView r122 = this.f339729f;
        if (r122 == null) goto L32;
        r122.setText(r121 + "/300");
    L32:
        W90(true);
    L33:
        this.f339728e = r116;
        r115.addView(r116, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView r123 = new TextView(r103);
        r123.setText("0/300");
        r123.setGravity(GravityCompat.END);
        r123.setIncludeFontPadding(false);
        r123.setTextColor(v19.c.a(R.attr.larus_neutral_50, r103, R.color.larus_neutral_50));
        r123.setTextSize(2, 10.0f);
        this.f339729f = r123;
        LinearLayout.LayoutParams r124 = new LinearLayout.LayoutParams(-1, -2);
        r124.topMargin = S90(6);
        r115.addView(r123, r124);
        r113.addView(r115, new LinearLayout.LayoutParams(-1, S90(146)));
        r113.setOnClickListener(new c(this));
        r115.setOnClickListener(new d(this));
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(-1, S90(162));
        r125.setMarginStart(S90(12));
        r125.setMarginEnd(S90(12));
        r104.addView(r113, r125);
        OSheetBase.DefaultImpls.j(r112, r104);
        if (U90() == null) goto L36;
        boolean r126 = true;
    L37:
        if (r126 == false) goto L39;
        int r127 = R.string.larus_dora_broadcast_finish_cn;
    L40:
        OSheetBase.DefaultImpls.l(r112, getString(r127), new b(this));
        Intrinsics.checkNotNullParameter(r112, "this");
        View r128 = r112.getFooterContainer().findViewById(R.id.btn_positive);
        if ((r128 instanceof OButton) == false) goto L43;
        OButton r129 = (OButton) r128;
    L44:
        this.f339730g = r129;
        OEditText r130 = this.f339728e;
        if (r130 == null) goto L54;
        Editable r131 = r130.getText();
        if (r131 == null) goto L54;
        if (r131.length() <= 0) goto L51;
        boolean r132 = true;
    L52:
        if (r132 != true) goto L54;
        r111 = true;
        goto L54
    L51:
        r132 = false;
    L54:
        W90(r111);
        Window r133 = r112.getWindow();
        if (r133 == null) goto L57;
        r133.setSoftInputMode(16);
    L57:
        return r112;
    L43:
        r129 = null;
        goto L44
    L39:
        r127 = R.string.larus_dora_broadcast_half_dialog_add_custom_rule_btn_generate_cn;
        goto L40
    L36:
        r126 = false;
        goto L37
    L24:
        r120 = false;
        goto L25
    L18:
        r119 = null;
        goto L19
    L8:
        r102 = R.string.larus_dora_broadcast_btn_add_custom_rule_cn;
        goto L9
    L5:
        r101 = false;
        goto L6
    }
}
