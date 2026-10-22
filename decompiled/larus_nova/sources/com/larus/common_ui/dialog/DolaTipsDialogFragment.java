package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.keva.Keva;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_res.common_ui.databinding.PageDolaTipsBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/common_ui/dialog/DolaTipsDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/PageDolaTipsBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "safeDismiss", "", "initViews", "getTheme", "", "onViewCreated", "view", "setupLandscape", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DolaTipsDialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f327260e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<Keva> f327261f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PageDolaTipsBinding f327262d;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(FragmentActivity r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1) == false) goto L7;
            DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1 r102 = (DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L15;
            if (r106 != 1) goto L14;
            ResultKt.throwOnFailure(r104);     // Catch: Exception -> L23
        L26:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r104);
            Lazy<Keva> r107 = DolaTipsDialogFragment.f327261f;     // Catch: Exception -> L23
            if (r107.getValue().getBoolean("default", false) == true) goto L19;
            r107.getValue().storeBoolean("default", true);     // Catch: Exception -> L23
            DolaTipsDialogFragment r108 = new DolaTipsDialogFragment();     // Catch: Exception -> L23
            MainCoroutineDispatcher r109 = Dispatchers.getMain();     // Catch: Exception -> L23
            DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$2 r110 = new DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$2(r108, r100, null);     // Catch: Exception -> L23
            r102.label = 1;     // Catch: Exception -> L23
            if (BuildersKt.withContext(r109, r110, r102) != r105) goto L26;
            return r105;
        L19:
            return Unit.INSTANCE;
        L23:
            e = move-exception;
            FLogger.f375446a.e("DolaTipsDialogFragment", "find MinorTipsDialogFragment exception: " + e);
        L7:
            r102 = new DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1(this, r101);
            goto L8
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    static {
        f327260e = new Companion();
        f327261f = LazyKt.lazy(new w0());
    }

    public final void S90() {
        FragmentActivity r100 = getActivity();     // Catch: Exception -> L22
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L29;
        Dialog r103 = getDialog();     // Catch: Exception -> L22
        if (r103 != null) goto L12;
    L14:
        if (r101 == false) goto L30;
        dismiss();     // Catch: Exception -> L17
    L32:
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L22
        Throwable r104 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L22
        if (r104 == null) goto L31;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L22
        return;
    L31:
        return;
    L30:
        return;
    L12:
        if (r103.isShowing() != true) goto L14;
        r101 = true;
        goto L14
    L29:
        return;
    L5:
        if (r100.isFinishing() == true) goto L7;
        r102 = true;
    L22:
        e = move-exception;
        FLogger.f375446a.e("safeDismiss", "commonLoadDialog dismiss crash because: " + e.getMessage(), e);
    }

    public DolaTipsDialogFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        final View r103 = null;
        if ((r102 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r104 = (BottomSheetDialog) r102;
    L6:
        if (r104 == null) goto L8;
        r103 = r104.findViewById(R.id.design_bottom_sheet);
    L8:
        Dialog r105 = getDialog();
        if (r105 == null) goto L12;
        r105.setOnShowListener(new x0(r103));
        return;
    L12:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.page_dola_tips, r101, false);
        int r104 = R.id.close_btn;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.close_btn);
        if (r105 == null) goto L19;
        r104 = R.id.dola_icon;
        if (((ImageView) ViewBindings.findChildViewById(r103, R.id.dola_icon)) == null) goto L19;
        r104 = R.id.dola_sub_title;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.dola_sub_title)) == null) goto L19;
        r104 = R.id.dola_title;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.dola_title)) == null) goto L19;
        ConstraintLayout r106 = (ConstraintLayout) r103;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r103, R.id.start_with_dola);
        if (r107 == null) goto L17;
        this.f327262d = new PageDolaTipsBinding(r106, r105, r106, r107);
        com.larus.utils.e1.d(r105, new u0(this));
        com.larus.utils.e1.d(r107, new v0(this));
        PageDolaTipsBinding r108 = this.f327262d;
        if (r108 != null) goto L20;
        return null;
    L20:
        return r108.f326846b;
    L17:
        r104 = R.id.start_with_dola;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
