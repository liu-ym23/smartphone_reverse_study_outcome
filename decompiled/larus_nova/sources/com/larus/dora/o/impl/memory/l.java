package com.larus.dora.o.impl.memory;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f338810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f338811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSheet f338812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EditText f338813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f338814e;

    public static final class a {
    }

    static {
    }

    public final void c() {
        OSheet r100 = this.f338812c;
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void a(OSheet r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final int b(l r100, int r101) {
        Resources r102 = r100.f338810a.getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density * r101) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Context r110, String r111, Function1<? super String, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "onSave");
        this.f338810a = r110;
        this.f338811b = r112;
        int r113 = 0;
        final OSheet r114 = new OSheet(r110, 0, false, 30);
        this.f338812c = r114;
        OSheetBase.DefaultImpls.q(r114, OSheet.HeightMode.WRAP_HEIGHT);
        OSheet.Header r100 = OSheet.Header.ACTION;
        if (r111 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        int r102 = R.string.larus_dora_environmental_data_personal_add_cn;
    L12:
        OSheetBase.DefaultImpls.o(r114, r100, Integer.valueOf(r102), null, null, true, new j(r114), new k(this, r114), 16156);
        LinearLayout r103 = new LinearLayout(r110);
        r103.setOrientation(1);
        r103.setPadding(b(this, 12), b(this, 8), b(this, 12), b(this, 16));
        LinearLayout r104 = new LinearLayout(r110);
        r104.setOrientation(1);
        r104.setBackground(ContextCompat.getDrawable(r104.getContext(), R.drawable.dora_o_bg_memory_card));
        r104.setPadding(b(this, 20), b(this, 16), b(this, 20), b(this, 16));
        r104.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        EditText r105 = new EditText(r110);
        r105.setLayoutParams(new LinearLayout.LayoutParams(-1, b(this, 132)));
        r105.setBackground(null);
        r105.setPadding(0, 0, 0, 0);
        r105.setGravity(48);
        r105.setInputType(131073);
        r105.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(300)});
        r105.setTextSize(16.0f);
        r105.setTextColor(ContextCompat.getColor(r105.getContext(), R.color.dora_o_text_primary));
        r105.setHintTextColor(ContextCompat.getColor(r105.getContext(), R.color.dora_o_text_tertiary));
        r105.setHint(r105.getContext().getString(R.string.larus_dora_o_memory_edit_hint));
        if (r111 != null) goto L15;
        r111 = "";
    L15:
        r105.setText(r111);
        Editable r115 = r105.getText();
        if (r115 == null) goto L18;
        int r116 = r115.length();
    L19:
        r105.setSelection(r116);
        this.f338813d = r105;
        FrameLayout r117 = new FrameLayout(r110);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-1, -2);
        r106.topMargin = b(this, 6);
        r117.setLayoutParams(r106);
        TextView r107 = new TextView(r110);
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(-2, -2);
        r118.gravity = GravityCompat.END;
        r107.setLayoutParams(r118);
        r107.setTextSize(10.0f);
        r107.setTextColor(ContextCompat.getColor(r107.getContext(), R.color.dora_o_text_secondary));
        this.f338814e = r107;
        r117.addView(r107);
        Editable r119 = r105.getText();
        if (r119 == null) goto L22;
        r113 = r119.length();
    L22:
        TextView r120 = this.f338814e;
        if (r120 == null) goto L25;
        r120.setText(r113 + "/300");
    L25:
        r105.addTextChangedListener(new m(this));
        r104.addView(r105);
        r104.addView(r117);
        r103.addView(r104);
        OSheetBase.DefaultImpls.j(r114, r103);
        return;
    L18:
        r116 = 0;
        goto L19
    L11:
        r102 = R.string.larus_dora_o_memory_personal_edit;
        goto L12
    L5:
        if (r111.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
