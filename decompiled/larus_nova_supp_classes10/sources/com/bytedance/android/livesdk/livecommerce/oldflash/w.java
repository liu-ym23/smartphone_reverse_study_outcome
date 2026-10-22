package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements DialogInterface.OnClickListener {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
