package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Function0 b;

    public m(Ref.BooleanRef r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        if (this.a.element == true) goto L8;
        Function0 r2 = this.b;
        if (r2 == null) goto L9;
        Unit r3 = (Unit) r2.invoke();
        return;
    L9:
        return;
    }
}
