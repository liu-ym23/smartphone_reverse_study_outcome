package com.larus.drive.sdk.impl.view.operation.download;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.drive.sdk.impl.databinding.LarusDialogDriveDownloadBinding;
import com.larus.drive.sdk.impl.utils.file.DriveDownloadManager;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/drive/sdk/impl/view/operation/download/DriveDownloadDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogDriveDownloadBinding;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", WidgetCostModule.TYPE_ON_START, "onDestroyView", "updateProgress", "progress", "", "dismissSafely", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveDownloadDialog extends DialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f342255e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogDriveDownloadBinding f342256d;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L13
        if (isAdded() == true) goto L19;
        return;
    L19:
        dismissAllowingStateLoss();     // Catch: Exception -> L7 Throwable -> L13
    L11:
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L23;
        FLogger.f375446a.e("DriveDownloadDialog", "[dismissSafely] Dismiss dialog error: " + r102.getMessage());
        return;
    L23:
        return;
    L7:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r103 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r103 == null) goto L11;
        d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        CoroutineScope r100 = DriveDownloadManager.f342019a;
        Intrinsics.checkNotNullParameter(this, "dialog");
        WeakReference<DriveDownloadDialog> r101 = DriveDownloadManager.f342024f;
        if (r101 == null) goto L5;
        DriveDownloadDialog r102 = r101.get();
    L6:
        if (r102 != this) goto L8;
        DriveDownloadManager.f342024f = null;
    L8:
        this.f342256d = null;
        return;
    L5:
        r102 = null;
        goto L6
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
        r101.setLayout(-2, -2);
        r101.setGravity(17);
        r101.clearFlags(2);
        r101.setDimAmount(0.0f);
    L7:
        Dialog r102 = getDialog();
        if (r102 == null) goto L10;
        r102.setCanceledOnTouchOutside(false);
    L10:
        CoroutineScope r103 = DriveDownloadManager.f342019a;
        Intrinsics.checkNotNullParameter(this, "dialog");
        DriveDownloadManager.f342024f = new WeakReference(this);
        if (DriveDownloadManager.f342022d == false) goto L14;
        T90(DriveDownloadManager.f342021c);
        return;
    }

    public DriveDownloadDialog() {
    }

    public final void T90(int r100) {
        LarusDialogDriveDownloadBinding r101 = this.f342256d;
        if (r101 == null) goto L8;
        CircleProgressBar r102 = r101.f341719c;
        if (r102 == null) goto L9;
        r102.setProgress(r100);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCancelable(true);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dialog_drive_download, r101, false);
        int r104 = R.id.download_cancel;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r103, R.id.download_cancel);
        if (r105 == null) goto L26;
        CardView r106 = (CardView) r103;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.downloading_tip)) == null) goto L24;
        CircleProgressBar r107 = (CircleProgressBar) ViewBindings.findChildViewById(r103, R.id.progressBar);
        if (r107 == null) goto L23;
        this.f342256d = new LarusDialogDriveDownloadBinding(r106, r105, r107);
        Dialog r108 = getDialog();
        if (r108 == null) goto L13;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L13;
        r109.setBackgroundDrawable(new ColorDrawable(0));
    L13:
        LarusDialogDriveDownloadBinding r110 = this.f342256d;
        if (r110 == null) goto L18;
        ImageView r111 = r110.f341718b;
        if (r111 == null) goto L18;
        r111.setOnClickListener(new com.larus.drive.sdk.impl.view.operation.download.a(this));
    L18:
        LarusDialogDriveDownloadBinding r112 = this.f342256d;
        if (r112 != null) goto L27;
        return null;
    L27:
        return r112.f341717a;
    L23:
        r104 = R.id.progressBar;
        goto L26
    L24:
        r104 = R.id.downloading_tip;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
