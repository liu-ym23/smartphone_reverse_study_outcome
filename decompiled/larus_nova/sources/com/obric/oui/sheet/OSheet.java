package com.obric.oui.sheet;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/sheet/OSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OSheet extends BottomSheetDialogFragment {
    public OSheet() {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        OBottomSheetDialog r101 = new OBottomSheetDialog(requireContext());
        if (r101.f402820a != null) goto L5;
        r101.I0();
    L5:
        r101.f402820a.setSkipCollapsed(true);
        if (r101.f402820a != null) goto L8;
        r101.I0();
    L8:
        r101.f402820a.setPeekHeight(pla.d.i(r101.getContext()));
        return r101;
    }
}
