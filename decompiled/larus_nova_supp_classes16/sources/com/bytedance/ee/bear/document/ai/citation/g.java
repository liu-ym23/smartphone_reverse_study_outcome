package com.bytedance.ee.bear.document.ai.citation;

import android.content.DialogInterface;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements DialogInterface.OnClickListener {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        Log.i("DocAICitationFragment", "clickClose");
        r2.dismiss();
    }
}
