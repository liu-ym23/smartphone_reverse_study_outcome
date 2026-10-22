package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.utils.x1;
import com.larus.bot.impl.common.util.j;
import com.larus.bot.impl.databinding.LarusDialogBgPromptGenerateBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.PromptInputButtonView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u000eH\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0010J\u000f\u0010&\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u001bH\u0002J\u0017\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0002\u0010,R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/BgPromptGenerateDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogBgPromptGenerateBinding;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "isImeShown", "", "hasBindObservers", "viewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/IBgPromptGenerateViewModel;", "prePromptEditState", "", "initialPrompt", "", "getTheme", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "bindViewModel", "vm", "initPrompt", EventConstant.Key.RETAIN_PROMPT, "initView", "()Lkotlin/Unit;", "bindObservers", "refreshState", "state", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/BgPromptGenerateUIState;", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/BgPromptGenerateUIState;)Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgPromptGenerateDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f318702k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogBgPromptGenerateBinding f318703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x1 f318704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f318705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f318706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i f318707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f318708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f318709j;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BgPromptGenerateDialog f318710a;

        public b(BgPromptGenerateDialog r100) {
            this.f318710a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L13;
            FLogger.f375446a.i("AIGenBgImageChooseDialog", "dismiss when key back");
            this.f318710a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return true;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L17;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return true;
        L17:
            return true;
        L13:
            return false;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    public BgPromptGenerateDialog() {
        this.f318709j = "";
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f318703d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LarusDialogBgPromptGenerateBinding r100 = this.f318703d;
        if (r100 == null) goto L8;
        r100.f317736b.requestFocus();
        x1 r101 = this.f318704e;
        if (r101 == null) goto L9;
        x1.d(r101, 3);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        i r101 = this.f318707h;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.dispatchUIAction(d.c.f318735a);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.b, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L7;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L7;
        r103.setSoftInputMode(5);
    L7:
        Dialog r104 = getDialog();
        if (r104 == null) goto L10;
        r104.setOnKeyListener(new b(this));
    L10:
        LarusDialogBgPromptGenerateBinding r105 = this.f318703d;
        if (r105 == null) goto L17;
        ConstraintLayout r106 = r105.f317735a;
        if (r106 == null) goto L17;
        ViewTreeObserver r107 = r106.getViewTreeObserver();
        if (r107 == null) goto L17;
        r107.addOnGlobalLayoutListener(new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.a(this));
    L17:
        LarusDialogBgPromptGenerateBinding r108 = this.f318703d;
        if (r108 == null) goto L25;
        r108.f317736b.setText(this.f318709j);
        AppCompatEditText r109 = r108.f317736b;
        Editable r110 = r109.getText();
        if (r110 == null) goto L22;
        int r111 = r110.length();
    L23:
        r109.setSelection(r111);
        AppCompatEditText r112 = r108.f317736b;
        ?? r113 = new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.b(this);
        Intrinsics.checkNotNullParameter(r112, "<this>");
        Intrinsics.checkNotNullParameter(r113, "afterTextChanged");
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = "";
        r112.addTextChangedListener(new av8.a(r114, new Ref.IntRef(), r113, r112));
        e1.d(r108.f317737c, new c(this));
        j.a(r108.f317736b);
        Unit r115 = Unit.INSTANCE;
        return;
    L22:
        r111 = 0;
        goto L23
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dialog_bg_prompt_generate, r101, false);
        int r104 = R.id.prompt_edit;
        AppCompatEditText r105 = (AppCompatEditText) ViewBindings.findChildViewById(r103, R.id.prompt_edit);
        if (r105 == null) goto L9;
        r104 = R.id.prompt_gen_button;
        PromptInputButtonView r106 = (PromptInputButtonView) ViewBindings.findChildViewById(r103, R.id.prompt_gen_button);
        if (r106 == null) goto L9;
        ConstraintLayout r107 = (ConstraintLayout) r103;
        LarusDialogBgPromptGenerateBinding r108 = new LarusDialogBgPromptGenerateBinding(r107, r105, r106);
        this.f318704e = new x1(r105);
        this.f318703d = r108;
        return r107;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
