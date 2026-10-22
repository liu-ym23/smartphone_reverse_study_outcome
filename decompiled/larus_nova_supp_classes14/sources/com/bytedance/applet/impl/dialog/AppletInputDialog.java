package com.bytedance.applet.impl.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.applet.databinding.LarusAppletDialogInputBinding;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import fw3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0002J\u001c\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u001b\u0010$\u001a\u0004\u0018\u00010%*\u00020\u00122\u0006\u0010&\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010'R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006)"}, d2 = {"Lcom/bytedance/applet/impl/dialog/AppletInputDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "_binding", "Lcom/bytedance/applet/databinding/LarusAppletDialogInputBinding;", "binding", "getBinding", "()Lcom/bytedance/applet/databinding/LarusAppletDialogInputBinding;", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "onCancel", "dialog", "Landroid/content/DialogInterface;", "setupView", "setupHeader", "titleText", "", "messageText", "requestId", "", "getRequestId", "()Ljava/lang/String;", "callbackStore", "Lcom/bytedance/applet/impl/dialog/AppletInputDialogCallbackStore;", "optionalColor", "", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletInputDialog extends DialogFragment {
    public static final /* synthetic */ int e = 0;
    public LarusAppletDialogInputBinding d;

    public static final class a {
    }

    static {
    }

    public final AppletInputDialogCallbackStore T90() {
        return (AppletInputDialogCallbackStore) new ViewModelProvider(requireActivity()).get(AppletInputDialogCallbackStore.class);
    }

    public final LarusAppletDialogInputBinding U90() {
        LarusAppletDialogInputBinding r0 = this.d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String V90() {
        String r0 = requireArguments().getString("request_id");
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setLayout(-1, -2);
        Resources r2 = r1.getWindowStyle().getResources();
        int r3 = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).widthPixels;
        WindowManager.LayoutParams r4 = r1.getAttributes();
        r4.width = RangesKt.coerceAtMost(r3 - (i5.d0() * 2), i5.L());
        r1.setAttributes(r4);
        return;
    L9:
        return;
    }

    public AppletInputDialog() {
    }

    public static void S90(AppletInputDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCancel(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        AppletInputDialogCallbackStore.a r0 = T90().take(V90());
        if (r0 == null) goto L7;
        DialogInterface.OnCancelListener r1 = r0.c;
        if (r1 == null) goto L7;
        r1.onCancel(r3);
    L7:
        super.onCancel(r3);
        S90(this);
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        if (T90().contains(V90()) == true) goto L6;
        S90(this);
        return;
    L6:
        Bundle r10 = requireArguments();
        CharSequence r11 = r10.getCharSequence("title");
        CharSequence r0 = r10.getCharSequence("message");
        int r2 = 0;
        if (r11 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        boolean r4 = !r3;
        if (r0 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        boolean r6 = !r5;
        TextView r7 = U90().g;
        r7.setText(r11);
        if (r4 == false) goto L23;
        int r12 = 0;
    L24:
        r7.setVisibility(r12);
        TextView r13 = U90().f;
        r13.setText(r0);
        if (r6 == true) goto L28;
        r2 = 8;
    L28:
        r13.setVisibility(r2);
        Intrinsics.checkNotNull(r13);
        ViewGroup.LayoutParams r1 = r13.getLayoutParams();
        if (r1 == null) goto L75;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r1;
        if (r4 == false) goto L33;
        int r15 = i5.r0();
    L34:
        r14.topMargin = r15;
        r13.setLayoutParams(r14);
        LinearLayout r16 = U90().h;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L73;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r4 == true) goto L41;
        if (r6 == true) goto L41;
        int r19 = i5.E();
    L42:
        r18.topMargin = r19;
        r16.setLayoutParams(r18);
        EditText r20 = U90().e;
        r20.setHint(r10.getCharSequence("placeholder"));
        r20.requestFocus();
        Dialog r21 = getDialog();
        if (r21 == null) goto L47;
        Window r22 = r21.getWindow();
        if (r22 == null) goto L47;
        r22.setSoftInputMode(5);
    L47:
        TextView r23 = U90().d;
        String r24 = r10.getString("confirm_text");
        String r25 = "";
        if (r24 != null) goto L50;
        r24 = "";
    L50:
        r23.setText(r24);
        Integer r26 = null;
        if (r10.containsKey("confirm_text_color") == false) goto L53;
        Integer r27 = Integer.valueOf(r10.getInt("confirm_text_color"));
    L54:
        if (r27 == null) goto L56;
        r23.setTextColor(r27.intValue());
    L56:
        r23.setOnClickListener(new fw3.a(this));
        TextView r28 = U90().c;
        String r29 = r10.getString("cancel_text");
        if (r29 == null) goto L60;
        r25 = r29;
    L60:
        r28.setText(r25);
        if (r10.containsKey("cancel_text_color") == false) goto L63;
        r26 = Integer.valueOf(r10.getInt("cancel_text_color"));
    L63:
        if (r26 == null) goto L65;
        r28.setTextColor(r26.intValue());
    L65:
        r28.setOnClickListener(new b(this));
        if (r10.getBoolean("show_cancel", true) == true) goto L68;
        U90().c.setVisibility(8);
        U90().b.setVisibility(8);
        U90().d.setBackgroundResource(c.b(2130970660, U90().d.getContext(), 2131239031));
    L68:
        boolean r30 = requireArguments().getBoolean("canceled_on_touch_outside", true);
        setCancelable(r30);
        Dialog r31 = getDialog();
        if (r31 == null) goto L76;
        r31.setCanceledOnTouchOutside(r30);
        r31.setCancelable(r30);
        return;
    L76:
        return;
    L53:
        r27 = null;
    L41:
        r19 = i5.q();
        goto L42
    L73:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L33:
        r15 = i5.E();
        goto L34
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L23:
        r12 = 8;
        goto L24
    L16:
        if (r0.length() == 0) goto L19;
        r5 = false;
        goto L20
    L9:
        if (r11.length() == 0) goto L12;
        r3 = false;
        goto L13
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r14 = r11.inflate(2131561810, r12, false);
        int r15 = 2131365012;
        View r3 = ViewBindings.findChildViewById(r14, 2131365012);
        if (r3 == null) goto L24;
        r15 = 2131365114;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r14, 2131365114);
        if (r4 == null) goto L24;
        r15 = 2131367639;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r14, 2131367639);
        if (r5 == null) goto L24;
        r15 = 2131368970;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r14, 2131368970);
        if (r6 == null) goto L24;
        r15 = 2131368971;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, 2131368971);
        if (r7 == null) goto L24;
        r15 = 2131368982;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, 2131368982);
        if (r8 == null) goto L24;
        r15 = 2131375355;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131375355);
        if (r9 == null) goto L24;
        this.d = new LarusAppletDialogInputBinding((LinearLayout) r14, r3, r4, r5, r6, r7, r8, r9);
        Dialog r16 = getDialog();
        if (r16 == null) goto L22;
        Window r17 = r16.getWindow();
        if (r17 == null) goto L22;
        r17.setBackgroundDrawable(new ColorDrawable(0));
    L22:
        return U90().a;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
