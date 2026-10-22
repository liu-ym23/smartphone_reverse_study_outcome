package com.ss.android.lark.widget.util;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes38.dex */
class SoftInputUtils$1 extends ResultReceiver {
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r100, Bundle r101) {
        if (r100 != 1) goto L5;
    L6:
        InputMethodManager r102 = (InputMethodManager) LarkContext.getApplication().getSystemService("input_method");
        if (r102 == null) goto L12;
        r102.toggleSoftInput(2, 0);
        return;
    L12:
        return;
    L5:
        if (r100 == 3) goto L6;
    }
}
