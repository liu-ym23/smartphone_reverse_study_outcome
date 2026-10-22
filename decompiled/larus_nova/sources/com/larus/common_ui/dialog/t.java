package com.larus.common_ui.dialog;

import android.widget.TextView;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderV2Binding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutBottomSheetHeaderV2Binding f327376a;

    public t(LarusLayoutBottomSheetHeaderV2Binding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        this.f327376a = r100;
    }

    public final void a(CharSequence r100) {
        TextView r101 = this.f327376a.f326756d;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.setText(r100);
    }
}
