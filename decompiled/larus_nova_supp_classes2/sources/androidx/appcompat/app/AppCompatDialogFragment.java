package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    public Dialog onCreateDialog(Bundle r3) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    public void setupDialog(Dialog r4, int r5) {
        if ((r4 instanceof AppCompatDialog) == false) goto L13;
        AppCompatDialog r0 = (AppCompatDialog) r4;
        if (r5 != 1) goto L7;
    L12:
        r0.supportRequestWindowFeature(1);
        return;
    L7:
        if (r5 == 2) goto L12;
        if (r5 != 3) goto L16;
        r4.getWindow().addFlags(24);
        goto L12
    L16:
        return;
    L13:
        super.setupDialog(r4, r5);
    }
}
