package com.bytedance.ee.bear.document.ai.citation;

import android.content.DialogInterface;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f218764a = null;

    static {
        f218764a = new g();
    }

    public g() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Log.i("DocAICitationFragment", "clickClose");
        r100.dismiss();
    }
}
