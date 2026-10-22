package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.forms.OInputView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\f\u0010\u001d\u001a\u00020\u0019*\u00020\u0019H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAddSpecialContactSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "appNameInput", "Lcom/obric/oui/forms/OInputView;", "contactNameInput", "confirmBtn", "Lcom/obric/oui/button/OIconButtonFloating;", "contactId", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "buildBody", "Landroid/view/View;", "buildInput", "label", "hint", "inputParams", "Landroid/widget/LinearLayout$LayoutParams;", "topMarginDp", "", "validateInputs", "handleConfirm", "resolveSheetBackgroundColor", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsAddSpecialContactSheet extends DialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f339732h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OInputView f339733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OInputView f339734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OIconButtonFloating f339735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f339736g;

    public static final class a {
    }

    static {
    }

    public final void U90() {
        OInputView r100 = this.f339733d;
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.getText();
        if (r102 == null) goto L7;
        String r103 = StringsKt.trim(r102).toString();
    L8:
        String r104 = "";
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        OInputView r105 = this.f339734e;
        if (r105 == null) goto L16;
        String r106 = r105.getText();
        if (r106 == null) goto L16;
        r101 = StringsKt.trim(r106).toString();
    L16:
        if (r101 == null) goto L19;
        r104 = r101;
    L19:
        boolean r107 = true;
        if (r103.length() <= 0) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == true) goto L25;
    L30:
        r107 = false;
    L31:
        OIconButtonFloating r109 = this.f339735f;
        if (r109 == null) goto L34;
        r109.setEnabled(r107);
    L34:
        OIconButtonFloating r110 = this.f339735f;
        if (r110 == null) goto L41;
        if (r107 == false) goto L38;
        float r111 = 1.0f;
    L39:
        r110.setAlpha(r111);
        return;
    L38:
        r111 = 0.3f;
        goto L39
    L41:
        return;
    L25:
        if (r104.length() <= 0) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == false) goto L30;
    L27:
        r112 = false;
        goto L28
    L22:
        r108 = false;
    L7:
        r103 = null;
        goto L8
    }

    public DoraObricEarbudsAddSpecialContactSheet() {
    }

    public final int T90(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        String r102 = r101.getString("key_contact_id");
    L6:
        this.f339736g = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r110) {
        OSheet r111 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.r(r111, ContextCompat.getColor(requireContext(), R.color.larus_base_1_overlay));
        Window r100 = r111.getWindow();
        if (r100 == null) goto L5;
        r100.setSoftInputMode(21);
    L5:
        Context r101 = requireContext();
        if (this.f339736g == null) goto L8;
        String r102 = getString(R.string.larus_dora_broadcast_v3_special_chat_edit_panel_title_cn);
    L9:
        Intrinsics.checkNotNull(r102);
        q2 r103 = t2.a(r101, r102, new o(this), new p(this));
        OIconButtonFloating r104 = r103.f339928b;
        r104.setAlpha(0.3f);
        r104.setEnabled(false);
        this.f339735f = r104;
        OSheetBase.DefaultImpls.p(r111, r103.f339927a);
        LinearLayout r105 = new LinearLayout(requireContext());
        r105.setOrientation(1);
        r105.setPadding(T90(12), T90(12), T90(12), T90(16));
        r105.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.larus_base_1_overlay));
        r105.setFocusableInTouchMode(true);
        r105.setFocusable(true);
        OInputView r106 = S90(getString(R.string.larus_dora_broadcast_v3_special_chat_app_field_title_cn), getString(R.string.larus_dora_broadcast_v3_special_chat_app_field_placeholder_cn));
        this.f339733d = r106;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-1, -2);
        r107.topMargin = T90(0);
        r105.addView(r106, r107);
        OInputView r108 = S90(getString(R.string.larus_dora_broadcast_v3_special_chat_empty_cn), getString(R.string.larus_dora_broadcast_v3_special_chat_name_placeholder_cn));
        this.f339734e = r108;
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-1, -2);
        r109.topMargin = T90(16);
        r105.addView(r108, r109);
        Bundle r112 = getArguments();
        if (r112 == null) goto L16;
        String r113 = r112.getString("key_app_name");
        if (r113 == null) goto L16;
        OInputView r114 = this.f339733d;
        if (r114 == null) goto L16;
        r114.setText(r113);
    L16:
        Bundle r115 = getArguments();
        if (r115 == null) goto L23;
        String r116 = r115.getString("key_chat_name");
        if (r116 == null) goto L23;
        OInputView r117 = this.f339734e;
        if (r117 == null) goto L23;
        r117.setText(r116);
    L23:
        s r118 = new s(this);
        OInputView r119 = this.f339733d;
        if (r119 == null) goto L26;
        r119.E.addTextChangedListener(r118);
    L26:
        OInputView r120 = this.f339734e;
        if (r120 == null) goto L29;
        r120.E.addTextChangedListener(r118);
    L29:
        U90();
        OSheetBase.DefaultImpls.j(r111, r105);
        r111.setOnShowListener(new q(this));
        return r111;
    L8:
        r102 = getString(R.string.larus_dora_broadcast_v3_special_chat_input_panel_title_cn);
        goto L9
    }

    public final OInputView S90(String r100, String r101) {
        OInputView r102 = new OInputView(requireContext(), null, 6, 0);
        r102.setLabel(r100);
        r102.setHint(r101);
        r102.setShowLabel(true);
        r102.setShowLabelIcon(false);
        r102.setSingleLine(true);
        r102.setInputType(1);
        r102.setRadius(T90(20));
        r102.f400932f = true;
        r102.b6(true);
        r102.setBgResId(R.drawable.o_input_view_focused_background);
        TextView r103 = (TextView) r102.findViewById(R.id.o_input_title);
        if (r103 == null) goto L5;
        r103.setTextColor(ContextCompat.getColor(requireContext(), R.color.larus_neutral_100));
    L5:
        return r102;
    }
}
