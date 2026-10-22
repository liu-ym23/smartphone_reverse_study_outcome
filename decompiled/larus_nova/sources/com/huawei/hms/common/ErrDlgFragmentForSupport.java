package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class ErrDlgFragmentForSupport extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f277013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f277014b;

    public ErrDlgFragmentForSupport() {
        this.f277013a = null;
        this.f277014b = null;
    }

    public static ErrDlgFragmentForSupport newInstance(Dialog r100) {
        return newInstance(r100, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r100) {
        DialogInterface.OnCancelListener r101 = this.f277014b;
        if (r101 == null) goto L6;
        r101.onCancel(r100);
        return;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        if (this.f277013a != null) goto L6;
        setShowsDialog(false);
    L6:
        return this.f277013a;
    }

    public static ErrDlgFragmentForSupport newInstance(Dialog r100, DialogInterface.OnCancelListener r101) {
        Preconditions.checkNotNull(r100, "Dialog cannot be null!");
        ErrDlgFragmentForSupport r102 = new ErrDlgFragmentForSupport();
        r102.f277013a = r100;
        r100.setOnCancelListener(null);
        r102.f277013a.setOnDismissListener(null);
        r102.f277014b = r101;
        return r102;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager r100, String r101) {
        Preconditions.checkNotNull(r100, "FragmentManager cannot be null!");
        super.show(r100, r101);
    }
}
