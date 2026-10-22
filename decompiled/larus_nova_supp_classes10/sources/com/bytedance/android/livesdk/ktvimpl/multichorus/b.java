package com.bytedance.android.livesdk.ktvimpl.multichorus;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 a;

    public b(Function0 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        Function0 r3 = this.a;
        if (r3 == null) goto L5;
        Unit r4 = (Unit) r3.invoke();
    L5:
        r1.dismiss();
    }
}
