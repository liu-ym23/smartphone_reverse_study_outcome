package com.bytedance.ee.bear.document.chatdraftdoc;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0<Unit> c;

    public f(String r1, String r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        i r5 = h.a;
        String r6 = this.a;
        String r7 = this.b;
        com.bytedance.ee.util.ui.j.f(new d(this.c));
        com.bytedance.ee.util.ui.j.d(new e(r7, r6), 250);
    }
}
