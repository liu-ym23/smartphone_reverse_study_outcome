package com.larus.avlink.env.prompt;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.avlink.impl.databinding.FragmentTextInputDialogBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p98.b;
import p98.c;
import p98.d;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/avlink/env/prompt/DoraEnvObservePromptInputDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/FragmentTextInputDialogBinding;", "textInputClickListener", "Lcom/larus/avlink/env/prompt/DoraEnvObservePromptInputDialog$TextInputClickListener;", "getTextInputClickListener", "()Lcom/larus/avlink/env/prompt/DoraEnvObservePromptInputDialog$TextInputClickListener;", "setTextInputClickListener", "(Lcom/larus/avlink/env/prompt/DoraEnvObservePromptInputDialog$TextInputClickListener;)V", "inputLimit", "", "isTextChanging", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", WidgetCostModule.TYPE_ON_START, "onDestroyView", "setupView", "setupInputListener", "getInputText", "", "wakeUpSoftInput", "setInputLimit", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "Companion", "TextInputClickListener", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraEnvObservePromptInputDialog extends DialogFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f292313g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentTextInputDialogBinding f292314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f292315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f292316f;

    public static final class a {
    }

    static {
    }

    public DoraEnvObservePromptInputDialog() {
        this.f292315e = 1000;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f292314d = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.setBackgroundDrawable(null);
        r101.setLayout(-1, c7.b(310));
        r101.setGravity(80);
    L7:
        FragmentTextInputDialogBinding r102 = this.f292314d;
        if (r102 == null) goto L19;
        EditText r103 = r102.f293149d;
        if (r103 == null) goto L19;
        if (r102 == null) goto L17;
        if (r103 == null) goto L17;
        Editable r104 = r103.getText();
        if (r104 == null) goto L17;
        String r105 = r104.toString();
        if (r105 == null) goto L17;
    L18:
        r103.setSelection(r105.length());
    L17:
        r105 = "";
    L19:
        SoftReference<Handler> r106 = y.f375498a;
        Runnable r107 = new c(this);
        Intrinsics.checkNotNullParameter(r107, "action");
        y.d(r107, 200);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FLogger.f375446a.i("DoraEnvObservePromptInputDialog", "onViewCreated");
        FragmentTextInputDialogBinding r102 = this.f292314d;
        if (r102 == null) goto L7;
        EditText r103 = r102.f293149d;
        if (r103 == null) goto L7;
        r103.addTextChangedListener(new d(this));
    L7:
        Bundle r104 = getArguments();
        String r105 = null;
        if (r104 == null) goto L10;
        Integer r106 = Integer.valueOf(r104.getInt("promptState", 1));
    L11:
        FragmentTextInputDialogBinding r107 = this.f292314d;
        if (r107 == null) goto L22;
        TextView r108 = r107.f293151f;
        if (r108 == null) goto L22;
        if (r106 != null) goto L18;
    L20:
        String r109 = getString(R.string.larus_dora_personal_diary_replace_style_edit_cn);
    L21:
        r108.setText(r109);
        goto L22
    L18:
        if (r106.intValue() != 1) goto L20;
        r109 = getString(R.string.larus_dora_personal_diary_adjust_style_edit_cn);
    L22:
        FragmentTextInputDialogBinding r110 = this.f292314d;
        if (r110 == null) goto L33;
        EditText r111 = r110.f293149d;
        if (r111 == null) goto L33;
        if (r106 != null) goto L29;
    L31:
        String r112 = getString(R.string.larus_dora_personal_diary_replace_style_default_text_cn);
    L32:
        r111.setHint(r112);
        goto L33
    L29:
        if (r106.intValue() != 1) goto L31;
        r112 = getString(R.string.larus_dora_personal_diary_adjust_style_default_text_cn);
    L33:
        FragmentTextInputDialogBinding r113 = this.f292314d;
        if (r113 == null) goto L41;
        EditText r114 = r113.f293149d;
        if (r114 == null) goto L41;
        Bundle r115 = getArguments();
        if (r115 == null) goto L40;
        r105 = r115.getString("editContent", "");
    L40:
        r114.setText(r105);
    L41:
        FragmentTextInputDialogBinding r116 = this.f292314d;
        if (r116 == null) goto L46;
        EditText r117 = r116.f293149d;
        if (r117 == null) goto L46;
        r117.setLineSpacing(0.0f, 1.25f);
    L46:
        FragmentTextInputDialogBinding r118 = this.f292314d;
        if (r118 == null) goto L51;
        TextView r119 = r118.f293147b;
        if (r119 == null) goto L51;
        r119.setOnClickListener(new p98.a(this));
    L51:
        FragmentTextInputDialogBinding r120 = this.f292314d;
        if (r120 == null) goto L57;
        TextView r121 = r120.f293150e;
        if (r121 == null) goto L58;
        r121.setOnClickListener(new b(this));
        return;
    L58:
        return;
    L57:
        return;
    L10:
        r106 = null;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.fragment_text_input_dialog, r101, false);
        int r103 = R.id.cancel_btn;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.cancel_btn);
        if (r104 == null) goto L18;
        r103 = R.id.count_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.count_text);
        if (r105 == null) goto L18;
        r103 = R.id.edit_input;
        EditText r106 = (EditText) ViewBindings.findChildViewById(r102, R.id.edit_input);
        if (r106 == null) goto L18;
        r103 = R.id.save_btn;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.save_btn);
        if (r107 == null) goto L18;
        r103 = R.id.title;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.title);
        if (r108 == null) goto L18;
        LinearLayout r109 = (LinearLayout) r102;
        this.f292314d = new FragmentTextInputDialogBinding(r109, r104, r105, r106, r107, r108);
        if (r109 == null) goto L16;
        return r109;
    L16:
        return new View(getContext());
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
