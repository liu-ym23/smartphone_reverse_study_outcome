package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements DialogInterface.OnClickListener {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
