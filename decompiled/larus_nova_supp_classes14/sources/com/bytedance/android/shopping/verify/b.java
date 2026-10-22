package com.bytedance.android.shopping.verify;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function2 b;

    public b(long r1, Function2 r3) {
        this.a = r1;
        this.b = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        in.b r5 = new in.b();
        r5.a = "confirm";
        r5.post(null, null);
        int r6 = AuthUtils.a;
        AuthUtils.b(this.a, null, 6);
        Function2 r7 = this.b;
        Boolean r8 = Boolean.TRUE;
        r7.invoke(r8, r8);
    }
}
