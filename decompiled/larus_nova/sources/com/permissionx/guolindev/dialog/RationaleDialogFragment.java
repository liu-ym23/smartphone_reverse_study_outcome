package com.permissionx.guolindev.dialog;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes34.dex */
public abstract class RationaleDialogFragment extends DialogFragment {
    public RationaleDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 == null) goto L13;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L14;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }
}
