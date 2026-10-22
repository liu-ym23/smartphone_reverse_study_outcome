package com.larus.avlink.env.diary.detail;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.ChipGroup;
import com.larus.avlink.impl.databinding.LarusDialogDiaryFeedbackBottomSheetBinding;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryFeedbackBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusDialogDiaryFeedbackBottomSheetBinding;", "viewModel", "Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailViewModel;", "getViewModel", "()Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "latestRenderedActionType", "", "latestRenderedSessionId", "", "Ljava/lang/Long;", "textWatcher", "Landroid/text/TextWatcher;", "getTheme", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "setupDialogBehavior", "setupViews", "observeViewModel", "renderState", "state", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackSheetUiState;", "renderChips", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiaryFeedbackBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f291980h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogDiaryFeedbackBottomSheetBinding f291981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f291982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f291983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f291984g;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f291985a;

        public b(i r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f291985a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f291985a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f291985a.invoke(r100);
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    public final DoraEnvObserveDiaryDetailViewModel S90() {
        return (DoraEnvObserveDiaryDetailViewModel) this.f291982e.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        LarusDialogDiaryFeedbackBottomSheetBinding r100 = this.f291981d;
        if (r100 == null) goto L7;
        EditText r101 = r100.f293178c;
        if (r101 == null) goto L7;
        r101.removeTextChangedListener(this.f291984g);
    L7:
        this.f291981d = null;
        super.onDestroyView();
    }

    public DiaryFeedbackBottomSheetDialogFragment() {
        final Function0 r100 = new h(this);
        this.f291982e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveDiaryDetailViewModel.class), new DiaryFeedbackBottomSheetDialogFragment$special$$inlined$viewModels$default$1(r100), new DiaryFeedbackBottomSheetDialogFragment$special$$inlined$viewModels$default$2(r100, this));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetDialog r102 = (BottomSheetDialog) r101;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L5;
        r103.setSoftInputMode(18);
    L5:
        return r102;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        Long r101 = this.f291983f;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        S90().onFeedbackSheetDismissed(r101.longValue());     // Catch: Throwable -> L7
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

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.env.diary.detail.i] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L5;
        r102.setOnShowListener(new j());
    L5:
        LarusDialogDiaryFeedbackBottomSheetBinding r103 = this.f291981d;
        if (r103 == null) goto L10;
        ImageView r104 = r103.f293177b;
        if (r104 == null) goto L10;
        r104.setOnClickListener(new k(this));
    L10:
        LarusDialogDiaryFeedbackBottomSheetBinding r105 = this.f291981d;
        if (r105 == null) goto L15;
        TextView r106 = r105.f293180e;
        if (r106 == null) goto L15;
        r106.setOnClickListener(new l(this));
    L15:
        p r107 = new p(this);
        this.f291984g = r107;
        LarusDialogDiaryFeedbackBottomSheetBinding r108 = this.f291981d;
        if (r108 == null) goto L20;
        EditText r109 = r108.f293178c;
        if (r109 == null) goto L20;
        r109.addTextChangedListener(r107);
    L20:
        LarusDialogDiaryFeedbackBottomSheetBinding r110 = this.f291981d;
        if (r110 == null) goto L25;
        EditText r111 = r110.f293178c;
        if (r111 == null) goto L25;
        r111.setOnTouchListener(new m());
    L25:
        S90().getFeedbackSheetState().observe(getViewLifecycleOwner(), new b(new i(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dialog_diary_feedback_bottom_sheet, r101, false);
        int r103 = R.id.dora_feedback_sheet_close_image;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r102, R.id.dora_feedback_sheet_close_image);
        if (r104 == null) goto L15;
        r103 = R.id.dora_feedback_sheet_input_edit;
        EditText r105 = (EditText) ViewBindings.findChildViewById(r102, R.id.dora_feedback_sheet_input_edit);
        if (r105 == null) goto L15;
        r103 = R.id.dora_feedback_sheet_reason_chip_group;
        ChipGroup r106 = (ChipGroup) ViewBindings.findChildViewById(r102, R.id.dora_feedback_sheet_reason_chip_group);
        if (r106 == null) goto L15;
        r103 = R.id.dora_feedback_sheet_submit_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.dora_feedback_sheet_submit_text);
        if (r107 == null) goto L15;
        r103 = R.id.dora_feedback_sheet_title_text;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.dora_feedback_sheet_title_text);
        if (r108 == null) goto L15;
        ConstraintLayout r109 = (ConstraintLayout) r102;
        LarusDialogDiaryFeedbackBottomSheetBinding r111 = new LarusDialogDiaryFeedbackBottomSheetBinding(r109, r104, r105, r106, r107, r108);
        this.f291981d = r111;
        Intrinsics.checkNotNull(r111);
        return r109;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
