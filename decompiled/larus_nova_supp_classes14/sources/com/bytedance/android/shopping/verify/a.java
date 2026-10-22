package com.bytedance.android.shopping.verify;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function2 a;

    public a(Function2 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        in.b r4 = new in.b();
        r4.a = "cancel";
        r4.post(null, null);
        this.a.invoke(Boolean.FALSE, Boolean.TRUE);
    }
}
