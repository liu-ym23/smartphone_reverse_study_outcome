package com.larus.dora.o.impl.diary.style;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.o.impl.databinding.DoraODialogDiaryStyleInputBinding;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes27.dex */
public final class b0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f338620e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<String, String, Function1<? super Boolean, Unit>, Unit> f338621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSheet f338622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraODialogDiaryStyleInputBinding f338623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f338624d;

    public static final class a {
    }

    static {
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

    public final void b(Context r100, int r101) {
        this.f338623c.f338353c.setText(r100.getString(R.string.larus_dora_o_diary_style_prompt_count, new Object[]{Integer.valueOf(r101), 200}));
    }

    public b0(final Context r110, int r111, String r112, String r113, v r114) {
        this.f338621a = r114;
        int r100 = 0;
        final OSheet r115 = new OSheet(r110, 0, false, 30);
        this.f338622b = r115;
        View r101 = LayoutInflater.from(r110).inflate(R.layout.dora_o_dialog_diary_style_input, null, false);
        int r102 = R.id.style_name_input;
        EditText r103 = (EditText) ViewBindings.findChildViewById(r101, R.id.style_name_input);
        if (r103 == null) goto L18;
        r102 = R.id.style_prompt_count;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.style_prompt_count);
        if (r104 == null) goto L18;
        r102 = R.id.style_prompt_input;
        EditText r105 = (EditText) ViewBindings.findChildViewById(r101, R.id.style_prompt_input);
        if (r105 == null) goto L18;
        LinearLayout r106 = (LinearLayout) r101;
        this.f338623c = new DoraODialogDiaryStyleInputBinding(r106, r103, r104, r105);
        r103.setText(r112);
        r105.setText(r113);
        Editable r116 = r105.getText();
        if (r116 == null) goto L11;
        int r117 = r116.length();
    L12:
        r105.setSelection(r117);
        Editable r118 = r105.getText();
        if (r118 == null) goto L15;
        r100 = r118.length();
    L15:
        b(r110, r100);
        r105.addTextChangedListener(new a0(this, r110));
        OSheetBase.DefaultImpls.q(r115, OSheet.HeightMode.WRAP_HEIGHT);
        OSheetBase.DefaultImpls.o(r115, OSheet.Header.ACTION, Integer.valueOf(r111), null, null, true, new w(r115), new x(this, r110, r115), 16156);
        OSheetBase.DefaultImpls.j(r115, r106);
        return;
    L11:
        r117 = 0;
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }
}
