package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Function0 b;

    public n(Ref.BooleanRef r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        this.a.element = true;
        r2.dismiss();
        Function0 r4 = this.b;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke();
        return;
    }
}
