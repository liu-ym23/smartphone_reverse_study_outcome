package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.common_res.common_ui.databinding.LarusDialogSpanableAlignedBinding;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J$\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006+"}, d2 = {"Lcom/larus/common_ui/dialog/AlignedSpanableDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogSpanableAlignedBinding;", "dialogView", "Landroid/view/View;", "title", "", "message", "", "bottomIndividualText", "scrollViewHeight", "", "confirmText", "confirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "cancelText", "cancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "spannaleClickListener", "Lcom/larus/common_ui/dialog/SpannaleClickListener;", "alignTargetViewRef", "Ljava/lang/ref/WeakReference;", "linkTextColor", "Ljava/lang/Integer;", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onResume", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupView", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlignedSpanableDialog extends DialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f327110o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogSpanableAlignedBinding f327111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f327112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f327113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f327114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f327115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f327116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public p0 f327117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f327118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u f327119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k1 f327120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f327121n;

    public AlignedSpanableDialog() {
        this.f327112e = "";
        this.f327113f = "";
        this.f327114g = "";
        this.f327115h = -1;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Dialog r100 = getDialog();
        if (r100 == null) goto L5;
        Window r101 = r100.getWindow();
    L6:
        if (r101 == null) goto L11;
        r101.setLayout(-1, -2);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        Resources r103 = r101.getWindowStyle().getResources();
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels - (i5.Q() * 2);
        r102.width = r104;
        if (r104 <= i5.a0()) goto L10;
        r102.width = i5.a0();
    L10:
        r102.gravity = 17;
        r101.setAttributes(r102);
    L11:
        Dialog r105 = getDialog();
        if (r105 == null) goto L15;
        r105.setOnKeyListener(new k());
        return;
    L15:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static void S90(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDialogSpanableAlignedBinding r102 = this.f327111d;
        LarusDialogSpanableAlignedBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        r102.f326681f.setText(this.f327112e);
        Integer r104 = this.f327121n;
        if (r104 == null) goto L11;
        int r105 = r104.intValue();
        LarusDialogSpanableAlignedBinding r106 = this.f327111d;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L10:
        r106.f326680e.setUrlTextColor(ColorStateList.valueOf(r105));
    L11:
        LarusDialogSpanableAlignedBinding r107 = this.f327111d;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L14:
        r107.f326680e.setUrlSpannedText(String.valueOf(this.f327113f));
        LarusDialogSpanableAlignedBinding r108 = this.f327111d;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L17:
        r108.f326680e.setOnClickListener(new n(this));
        if (this.f327115h <= 0) goto L24;
        LarusDialogSpanableAlignedBinding r109 = this.f327111d;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L22:
        r109.f326682g.getLayoutParams().height = this.f327115h;
    L24:
        if ((this.f327113f instanceof SpannableString) == false) goto L32;
        LarusDialogSpanableAlignedBinding r110 = this.f327111d;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L28:
        r110.f326680e.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableAlignedBinding r111 = this.f327111d;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L31:
        r111.f326680e.setHighlightColor(0);
    L32:
        String r112 = this.f327116i;
        boolean r113 = true;
        if (r112 != null) goto L35;
    L38:
        boolean r114 = true;
    L39:
        if (r114 == true) goto L44;
        LarusDialogSpanableAlignedBinding r115 = this.f327111d;
        if (r115 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L43:
        r115.f326679d.setText(this.f327116i);
    L44:
        LarusDialogSpanableAlignedBinding r116 = this.f327111d;
        if (r116 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L47:
        r116.f326679d.setOnClickListener(new l(this));
        String r117 = this.f327118k;
        if (r117 != null) goto L50;
    L53:
        boolean r118 = true;
    L54:
        if (r118 == true) goto L59;
        LarusDialogSpanableAlignedBinding r119 = this.f327111d;
        if (r119 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L58:
        r119.f326678c.setText(this.f327118k);
    L59:
        LarusDialogSpanableAlignedBinding r120 = this.f327111d;
        if (r120 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L62:
        r120.f326678c.setOnClickListener(new m(this));
        CharSequence r121 = this.f327114g;
        if (r121 != null) goto L65;
    L68:
        if (r113 == true) goto L92;
        LarusDialogSpanableAlignedBinding r122 = this.f327111d;
        if (r122 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r122 = null;
    L72:
        r122.f326677b.setVisibility(0);
        Integer r123 = this.f327121n;
        if (r123 == null) goto L78;
        int r124 = r123.intValue();
        LarusDialogSpanableAlignedBinding r125 = this.f327111d;
        if (r125 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r125 = null;
    L77:
        r125.f326677b.setUrlTextColor(ColorStateList.valueOf(r124));
    L78:
        LarusDialogSpanableAlignedBinding r126 = this.f327111d;
        if (r126 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L81:
        r126.f326677b.setUrlSpannedText(String.valueOf(this.f327114g));
        LarusDialogSpanableAlignedBinding r127 = this.f327111d;
        if (r127 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r127 = null;
    L84:
        r127.f326677b.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableAlignedBinding r128 = this.f327111d;
        if (r128 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L87:
        r128.f326677b.setHighlightColor(0);
        LarusDialogSpanableAlignedBinding r129 = this.f327111d;
        if (r129 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L91:
        r103.f326677b.setOnClickListener(new o(this));
    L97:
        Dialog r130 = getDialog();
        if (r130 == null) goto L101;
        r130.setCanceledOnTouchOutside(false);
        return;
    L101:
        return;
    L90:
        r103 = r129;
        goto L91
    L92:
        LarusDialogSpanableAlignedBinding r131 = this.f327111d;
        if (r131 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L96:
        r103.f326677b.setVisibility(8);
        goto L97
    L95:
        r103 = r131;
        goto L96
    L65:
        if (r121.length() == 0) goto L68;
        r113 = false;
        goto L68
    L50:
        if (r117.length() == 0) goto L53;
        r118 = false;
        goto L54
    L35:
        if (r112.length() == 0) goto L38;
        r114 = false;
        goto L39
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dialog_spanable_aligned, r111, false);
        int r114 = R.id.bottom_individual_text;
        UrlSpanTextView r100 = (UrlSpanTextView) ViewBindings.findChildViewById(r113, R.id.bottom_individual_text);
        if (r100 == null) goto L29;
        r114 = R.id.cancel;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r113, R.id.cancel);
        if (r101 == null) goto L29;
        r114 = R.id.confirm;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r113, R.id.confirm);
        if (r102 == null) goto L29;
        r114 = R.id.dialog_message;
        UrlSpanTextView r103 = (UrlSpanTextView) ViewBindings.findChildViewById(r113, R.id.dialog_message);
        if (r103 == null) goto L29;
        r114 = R.id.dialog_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r113, R.id.dialog_title);
        if (r104 == null) goto L29;
        r114 = R.id.scroll_content;
        ScrollView r105 = (ScrollView) ViewBindings.findChildViewById(r113, R.id.scroll_content);
        if (r105 == null) goto L29;
        this.f327111d = new LarusDialogSpanableAlignedBinding((ConstraintLayout) r113, r100, r101, r102, r103, r104, r105);
        Dialog r115 = getDialog();
        if (r115 == null) goto L19;
        Window r116 = r115.getWindow();
        if (r116 == null) goto L19;
        r116.setBackgroundDrawable(new ColorDrawable(0));
    L19:
        LarusDialogSpanableAlignedBinding r117 = this.f327111d;
        LarusDialogSpanableAlignedBinding r118 = null;
        if (r117 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L22:
        ConstraintLayout r119 = r117.f326676a;
        LarusDialogSpanableAlignedBinding r120 = this.f327111d;
        if (r120 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L27:
        return r118.f326676a;
    L25:
        r118 = r120;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
