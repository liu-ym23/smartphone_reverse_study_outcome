package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes16.dex */
public final class c0 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218893a;

    public c0(r r100) {
        this.f218893a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Function0<Unit> r101 = this.f218893a.f218942c;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
