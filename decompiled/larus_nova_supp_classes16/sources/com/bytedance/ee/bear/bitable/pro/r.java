package com.bytedance.ee.bear.bitable.pro;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r implements DialogInterface.OnClickListener {
    public final /* synthetic */ BitableProFragment a;

    public r(BitableProFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        BitableProFragment.W90(this.a);
        r1.dismiss();
    }
}
