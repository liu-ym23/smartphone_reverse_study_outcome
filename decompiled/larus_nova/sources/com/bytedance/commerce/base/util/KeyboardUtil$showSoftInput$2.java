package com.bytedance.commerce.base.util;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import dg4.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/commerce/base/util/KeyboardUtil$showSoftInput$2", "Landroid/os/ResultReceiver;", "base_release"}, k = 1, mv = {1, 4, 0})
public final class KeyboardUtil$showSoftInput$2 extends ResultReceiver {
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r100, Bundle r101) {
        if (r100 != 1) goto L5;
    L6:
        int r102 = a.f468390a;
        Object r103 = uf4.a.a().getSystemService("input_method");
        if ((r103 instanceof InputMethodManager) == true) goto L9;
        r103 = null;
    L9:
        InputMethodManager r104 = (InputMethodManager) r103;
        if (r104 == null) goto L14;
        r104.toggleSoftInput(0, 0);
        return;
    L14:
        return;
    L5:
        if (r100 == 3) goto L6;
    }
}
