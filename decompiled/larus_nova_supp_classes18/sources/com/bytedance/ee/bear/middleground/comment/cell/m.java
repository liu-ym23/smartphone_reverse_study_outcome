package com.bytedance.ee.bear.middleground.comment.cell;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ComponentCallbacks d;

    public m(Function0 r1, com.bytedance.ee.bear.middleground.comment.uitls.p r2, boolean r3, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.k r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        Function0<Unit> r3 = this.a;
        if (r3 == null) goto L5;
        r3.invoke();
    L5:
        this.b.N.a(new ef5.k());
        if (this.c == false) goto L9;
        this.b.getActivity().unregisterComponentCallbacks(this.d);
        return;
    }
}
