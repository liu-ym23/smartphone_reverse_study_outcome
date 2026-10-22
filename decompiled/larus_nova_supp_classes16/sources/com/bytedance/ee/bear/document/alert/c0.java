package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ r a;

    public c0(r r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        Function0<Unit> r2 = this.a.c;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }
}
