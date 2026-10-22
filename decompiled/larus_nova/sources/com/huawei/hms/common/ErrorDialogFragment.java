package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class ErrorDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f277015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f277016b;

    public ErrorDialogFragment() {
        this.f277015a = null;
        this.f277016b = null;
    }

    public static ErrorDialogFragment newInstance(Dialog r100) {
        return newInstance(r100, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r100) {
        DialogInterface.OnCancelListener r101 = this.f277016b;
        if (r101 == null) goto L6;
        r101.onCancel(r100);
        return;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        if (this.f277015a != null) goto L6;
        setShowsDialog(false);
    L6:
        return this.f277015a;
    }

    public static ErrorDialogFragment newInstance(Dialog r100, DialogInterface.OnCancelListener r101) {
        Preconditions.checkNotNull(r100, "Dialog cannot be null!");
        ErrorDialogFragment r102 = new ErrorDialogFragment();
        r102.f277015a = r100;
        r100.setOnCancelListener(null);
        r102.f277015a.setOnDismissListener(null);
        if (r101 == null) goto L5;
        r102.f277016b = r101;
    L5:
        return r102;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager r100, String r101) {
        Preconditions.checkNotNull(r100, "FragmentManager cannot be null!");
        super.show(r100, r101);
    }
}
