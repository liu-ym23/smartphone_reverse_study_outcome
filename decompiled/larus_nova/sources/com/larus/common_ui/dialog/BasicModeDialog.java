package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.common_res.common_ui.databinding.LarusDialogBasicModeShowBinding;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/common_ui/dialog/BasicModeDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogBasicModeShowBinding;", "msgListener", "Lcom/larus/common_ui/dialog/SpannaleClickListener;", "exitListener", "Landroid/view/View$OnClickListener;", "agreeListener", "basicModeListener", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupView", "setExitAppClick", "exit", "setAgreeClick", "agree", "setBasicModeClick", "enterBasic", "setUrlClick", "urlClickListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BasicModeDialog extends DialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogBasicModeShowBinding f327127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k1 f327128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f327129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f327130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f327131h;

    public static final class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L6;
            return true;
        L6:
            return false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Dialog r100 = getDialog();
        if (r100 == null) goto L10;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L10;
        r101.setLayout(-1, -2);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        Resources r103 = r101.getWindowStyle().getResources();
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r102.width = r104;
        if (r104 <= i5.L()) goto L9;
        r102.width = i5.L();
    L9:
        r101.setAttributes(r102);
    L10:
        Dialog r105 = getDialog();
        if (r105 == null) goto L14;
        r105.setOnKeyListener(new a());
        return;
    }

    public BasicModeDialog() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDialogBasicModeShowBinding r102 = this.f327127d;
        LarusDialogBasicModeShowBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        r102.f326658e.setOnClickListener(this.f327129f);
        LarusDialogBasicModeShowBinding r104 = this.f327127d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        r104.f326657d.setOnClickListener(this.f327131h);
        LarusDialogBasicModeShowBinding r105 = this.f327127d;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L11:
        r105.f326655b.setOnClickListener(this.f327130g);
        LarusDialogBasicModeShowBinding r106 = this.f327127d;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L14:
        r106.f326656c.setUrlSpannedText(getString(R.string.larus_preinstall_basic_mode_msg));
        LarusDialogBasicModeShowBinding r107 = this.f327127d;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        r103.f326656c.setOnClickListener(new s(this));
        Dialog r108 = getDialog();
        if (r108 == null) goto L22;
        r108.setCanceledOnTouchOutside(false);
        return;
    L22:
        return;
    L17:
        r103 = r107;
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dialog_basic_mode_show, r101, false);
        int r103 = R.id.agree;
        RelativeLayout r104 = (RelativeLayout) ViewBindings.findChildViewById(r102, R.id.agree);
        if (r104 == null) goto L23;
        r103 = R.id.dialog_message;
        UrlSpanTextView r105 = (UrlSpanTextView) ViewBindings.findChildViewById(r102, R.id.dialog_message);
        if (r105 == null) goto L23;
        r103 = R.id.dialog_title;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.dialog_title)) == null) goto L23;
        r103 = R.id.enter_basic_mode;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.enter_basic_mode);
        if (r106 == null) goto L23;
        r103 = R.id.exit;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.exit);
        if (r107 == null) goto L23;
        this.f327127d = new LarusDialogBasicModeShowBinding((ConstraintLayout) r102, r104, r105, r106, r107);
        Dialog r108 = getDialog();
        if (r108 == null) goto L17;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L17;
        r109.setBackgroundDrawable(new ColorDrawable(0));
    L17:
        LarusDialogBasicModeShowBinding r111 = this.f327127d;
        if (r111 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L21:
        return r111.f326654a;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
