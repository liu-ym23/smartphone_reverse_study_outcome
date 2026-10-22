package com.larus.avlink.aiproactive;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.avlink.impl.databinding.LarusDialogAiProactiveTaskEditBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u000fJ\u0012\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/avlink/aiproactive/AiProactiveTaskEditDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "_binding", "Lcom/larus/avlink/impl/databinding/LarusDialogAiProactiveTaskEditBinding;", "binding", "getBinding", "()Lcom/larus/avlink/impl/databinding/LarusDialogAiProactiveTaskEditBinding;", "editTaskId", "", "Ljava/lang/Long;", "initialContent", "", "isLoading", "", "confirmListener", "Lcom/larus/avlink/aiproactive/AiProactiveTaskEditDialog$OnConfirmListener;", "setOnConfirmListener", "", "listener", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupDialogBehavior", "setupViews", "setLoading", "loading", "updateConfirmEnabled", "s", "Landroid/text/Editable;", "updateCounter", "length", "", "onDestroyView", "OnConfirmListener", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiProactiveTaskEditDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f291537i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogAiProactiveTaskEditBinding f291538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f291539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f291540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f291541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f291542h;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f291538d = null;
    }

    public AiProactiveTaskEditDialog() {
    }

    public final void S90(Editable r100) {
        if (this.f291541g == false) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (r100 == null) goto L12;
        String r102 = r100.toString();
        if (r102 == null) goto L12;
        if ((!StringsKt.isBlank(r102)) != true) goto L12;
        r101 = true;
    L12:
        LarusDialogAiProactiveTaskEditBinding r103 = this.f291538d;
        Intrinsics.checkNotNull(r103);
        r103.f293172c.setEnabled(r101);
    }

    public final void T90(int r100) {
        LarusDialogAiProactiveTaskEditBinding r101 = this.f291538d;
        Intrinsics.checkNotNull(r101);
        r101.f293175f.setText(r100 + "/100");
        LarusDialogAiProactiveTaskEditBinding r102 = this.f291538d;
        Intrinsics.checkNotNull(r102);
        Context r103 = r102.f293175f.getContext();
        if (r100 < 100) goto L5;
        int r104 = R.color.larus_danger_50;
    L6:
        LarusDialogAiProactiveTaskEditBinding r105 = this.f291538d;
        Intrinsics.checkNotNull(r105);
        r105.f293175f.setTextColor(ContextCompat.getColor(r103, r104));
        return;
    L5:
        r104 = R.color.larus_neutral_50;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 != null) goto L5;
    L7:
        Long r103 = null;
    L8:
        this.f291539e = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L11;
        r102 = r104.getString("arg_initial_content");
    L11:
        this.f291540f = r102;
        return;
    L5:
        if (r101.containsKey("arg_task_id") == false) goto L7;
        r103 = Long.valueOf(r101.getLong("arg_task_id"));
        goto L8
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetDialog r102 = (BottomSheetDialog) r101;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L5;
        r103.setSoftInputMode(21);
    L5:
        return r102;
    }

    public final void setLoading(boolean r100) {
        this.f291541g = r100;
        if (r100 == false) goto L5;
        LarusDialogAiProactiveTaskEditBinding r101 = this.f291538d;
        Intrinsics.checkNotNull(r101);
        r101.f293173d.setVisibility(0);
        LarusDialogAiProactiveTaskEditBinding r102 = this.f291538d;
        Intrinsics.checkNotNull(r102);
        r102.f293171b.setEnabled(false);
        LarusDialogAiProactiveTaskEditBinding r103 = this.f291538d;
        Intrinsics.checkNotNull(r103);
        r103.f293174e.setEnabled(false);
        LarusDialogAiProactiveTaskEditBinding r104 = this.f291538d;
        Intrinsics.checkNotNull(r104);
        r104.f293174e.setTextColor(v19.c.a(R.attr.larus_neutral_30, requireContext(), R.color.larus_neutral_30));
        LarusDialogAiProactiveTaskEditBinding r105 = this.f291538d;
        Intrinsics.checkNotNull(r105);
        r105.f293172c.setEnabled(false);
        return;
    L5:
        LarusDialogAiProactiveTaskEditBinding r106 = this.f291538d;
        Intrinsics.checkNotNull(r106);
        r106.f293173d.setVisibility(8);
        LarusDialogAiProactiveTaskEditBinding r107 = this.f291538d;
        Intrinsics.checkNotNull(r107);
        r107.f293171b.setEnabled(true);
        LarusDialogAiProactiveTaskEditBinding r108 = this.f291538d;
        Intrinsics.checkNotNull(r108);
        r108.f293174e.setEnabled(true);
        LarusDialogAiProactiveTaskEditBinding r109 = this.f291538d;
        Intrinsics.checkNotNull(r109);
        r109.f293174e.setTextColor(v19.c.a(R.attr.larus_neutral_100, requireContext(), R.color.larus_neutral_100));
        LarusDialogAiProactiveTaskEditBinding r110 = this.f291538d;
        Intrinsics.checkNotNull(r110);
        S90(r110.f293171b.getText());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L5;
        View r103 = (View) r102;
    L6:
        int r104 = 0;
        if (r103 == null) goto L9;
        r103.setBackgroundColor(0);
    L9:
        Dialog r105 = getDialog();
        if (r105 == null) goto L12;
        r105.setOnShowListener(new c0(this));
    L12:
        String r106 = this.f291540f;
        if (r106 == null) goto L15;
        LarusDialogAiProactiveTaskEditBinding r107 = this.f291538d;
        Intrinsics.checkNotNull(r107);
        r107.f293171b.setText(r106);
        LarusDialogAiProactiveTaskEditBinding r108 = this.f291538d;
        Intrinsics.checkNotNull(r108);
        r108.f293171b.setSelection(r106.length());
    L15:
        LarusDialogAiProactiveTaskEditBinding r109 = this.f291538d;
        Intrinsics.checkNotNull(r109);
        Editable r110 = r109.f293171b.getText();
        if (r110 == null) goto L18;
        r104 = r110.length();
    L18:
        T90(r104);
        LarusDialogAiProactiveTaskEditBinding r111 = this.f291538d;
        Intrinsics.checkNotNull(r111);
        S90(r111.f293171b.getText());
        LarusDialogAiProactiveTaskEditBinding r112 = this.f291538d;
        Intrinsics.checkNotNull(r112);
        r112.f293171b.addTextChangedListener(new g0(this));
        LarusDialogAiProactiveTaskEditBinding r113 = this.f291538d;
        Intrinsics.checkNotNull(r113);
        r113.f293174e.setOnClickListener(new d0(this));
        LarusDialogAiProactiveTaskEditBinding r114 = this.f291538d;
        Intrinsics.checkNotNull(r114);
        r114.f293172c.setOnClickListener(new e0(this));
        LarusDialogAiProactiveTaskEditBinding r115 = this.f291538d;
        Intrinsics.checkNotNull(r115);
        r115.f293171b.requestFocus();
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dialog_ai_proactive_task_edit, r101, false);
        int r103 = R.id.et_input;
        EditText r104 = (EditText) ViewBindings.findChildViewById(r102, R.id.et_input);
        if (r104 == null) goto L23;
        r103 = R.id.fl_confirm_btn;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r102, R.id.fl_confirm_btn);
        if (r105 == null) goto L23;
        r103 = R.id.input_card;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r102, R.id.input_card)) == null) goto L23;
        r103 = R.id.pb_loading;
        ProgressBar r106 = (ProgressBar) ViewBindings.findChildViewById(r102, R.id.pb_loading);
        if (r106 == null) goto L23;
        r103 = R.id.tv_cancel;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.tv_cancel);
        if (r107 == null) goto L23;
        r103 = R.id.tv_confirm_text;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_confirm_text)) == null) goto L23;
        r103 = R.id.tv_counter;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.tv_counter);
        if (r108 == null) goto L23;
        r103 = R.id.tv_subtitle;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_subtitle)) == null) goto L23;
        r103 = R.id.tv_title;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_title)) == null) goto L23;
        ConstraintLayout r109 = (ConstraintLayout) r102;
        LarusDialogAiProactiveTaskEditBinding r111 = new LarusDialogAiProactiveTaskEditBinding(r109, r104, r105, r106, r107, r108);
        this.f291538d = r111;
        Intrinsics.checkNotNull(r111);
        return r109;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
