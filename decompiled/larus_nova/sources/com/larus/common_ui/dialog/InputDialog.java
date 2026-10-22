package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_res.common_ui.databinding.LarusDialogInputBinding;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/dialog/InputDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogInputBinding;", "mCheckInputNull", "", "Ljava/lang/Boolean;", "mTitle", "", "mText", "", "mMaxInputLength", "", "mInputFilters", "", "Landroid/text/InputFilter;", "mConfirmOnEditorAction", "mConfirmText", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/InputConfirmClickListener;", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCancel", "dialog", "Landroid/content/DialogInterface;", "setupView", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputDialog extends DialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f327263o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogInputBinding f327264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f327265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f327266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f327267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f327268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<? extends InputFilter> f327269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f327270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f327271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y0 f327272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f327273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u f327274n;

    public InputDialog() {
        this.f327265e = Boolean.FALSE;
        this.f327267g = "";
        this.f327269i = CollectionsKt.emptyList();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Dialog r100 = getDialog();
        if (r100 == null) goto L11;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L12;
        r101.setLayout(-1, -2);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        Resources r103 = r101.getWindowStyle().getResources();
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r102.width = r104;
        if (r104 <= i5.L()) goto L9;
        r102.width = i5.L();
    L9:
        r101.setAttributes(r102);
        return;
    L12:
        return;
    }

    public static void S90(InputDialog r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        S90(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDialogInputBinding r102 = null;
        if (Intrinsics.areEqual(this.f327265e, Boolean.TRUE) == false) goto L8;
        LarusDialogInputBinding r103 = this.f327264d;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L7:
        r103.f326674d.addTextChangedListener(new c1(this));
    L8:
        List r104 = CollectionsKt.toMutableList(this.f327269i);
        boolean r105 = false;
        if (this.f327268h <= 0) goto L11;
        ListProtector.add(r104, 0, new InputFilter.LengthFilter(this.f327268h));
    L11:
        List r106 = r104;
        if ((!r106.isEmpty()) == false) goto L17;
        LarusDialogInputBinding r107 = this.f327264d;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L16:
        r107.f326674d.setFilters((InputFilter[]) r106.toArray(new InputFilter[0]));
    L17:
        LarusDialogInputBinding r108 = this.f327264d;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L20:
        r108.f326675e.setText(this.f327266f);
        LarusDialogInputBinding r109 = this.f327264d;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L23:
        r109.f326674d.setText(this.f327267g);
        LarusDialogInputBinding r110 = this.f327264d;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L26:
        r110.f326674d.requestFocus();
        Dialog r111 = getDialog();
        if (r111 == null) goto L31;
        Window r112 = r111.getWindow();
        if (r112 == null) goto L31;
        r112.setSoftInputMode(5);
    L31:
        String r113 = this.f327271k;
        if (r113 != null) goto L34;
    L37:
        boolean r114 = true;
    L38:
        if (r114 == true) goto L43;
        LarusDialogInputBinding r115 = this.f327264d;
        if (r115 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L42:
        r115.f326673c.setText(this.f327271k);
    L43:
        LarusDialogInputBinding r116 = this.f327264d;
        if (r116 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L46:
        r116.f326673c.setOnClickListener(new z0(this));
        if (this.f327270j == false) goto L55;
        LarusDialogInputBinding r117 = this.f327264d;
        if (r117 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L51:
        r117.f326674d.setImeOptions(6);
        LarusDialogInputBinding r118 = this.f327264d;
        if (r118 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L54:
        r118.f326674d.setOnEditorActionListener(new a1(this));
    L55:
        String r119 = this.f327273m;
        if (r119 != null) goto L58;
    L59:
        r105 = true;
    L60:
        if (r105 == true) goto L65;
        LarusDialogInputBinding r120 = this.f327264d;
        if (r120 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L64:
        r120.f326672b.setText(this.f327273m);
    L65:
        LarusDialogInputBinding r121 = this.f327264d;
        if (r121 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L69:
        r102.f326672b.setOnClickListener(new b1(this));
        Dialog r122 = getDialog();
        if (r122 == null) goto L73;
        r122.setCanceledOnTouchOutside(true);
        return;
    L73:
        return;
    L68:
        r102 = r121;
        goto L69
    L58:
        if (r119.length() != 0) goto L60;
    L34:
        if (r113.length() == 0) goto L37;
        r114 = false;
        goto L38
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dialog_input, r101, false);
        int r103 = R.id.cancel;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.cancel);
        if (r104 == null) goto L21;
        r103 = R.id.confirm;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.confirm);
        if (r105 == null) goto L21;
        r103 = R.id.dialog_input;
        EditText r106 = (EditText) ViewBindings.findChildViewById(r102, R.id.dialog_input);
        if (r106 == null) goto L21;
        r103 = R.id.dialog_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.dialog_title);
        if (r107 == null) goto L21;
        this.f327264d = new LarusDialogInputBinding((LinearLayout) r102, r104, r105, r106, r107);
        Dialog r108 = getDialog();
        if (r108 == null) goto L15;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L15;
        r109.setBackgroundDrawable(new ColorDrawable(0));
    L15:
        LarusDialogInputBinding r111 = this.f327264d;
        if (r111 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L19:
        return r111.f326671a;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
