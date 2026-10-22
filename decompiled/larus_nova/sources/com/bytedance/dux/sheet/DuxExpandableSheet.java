package com.bytedance.dux.sheet;

import android.app.Dialog;
import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/sheet/DuxExpandableSheet;", "Lcom/bytedance/dux/sheet/DuxSheet;", "<init>", "()V", "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxExpandableSheet extends DuxSheet {
    public DuxExpandableSheet() {
    }

    @Override // com.bytedance.dux.sheet.DuxSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        DuxBottomSheetDialog r101 = new DuxBottomSheetDialog(requireContext());
        r101.f205628d = false;
        if (r101.f205625a != null) goto L5;
        r101.I0();
    L5:
        r101.f205625a.setSkipCollapsed(true);
        if (r101.f205625a != null) goto L8;
        r101.I0();
    L8:
        r101.f205625a.setFitToContents(true);
        r101.f205632h = true;
        return r101;
    }
}
