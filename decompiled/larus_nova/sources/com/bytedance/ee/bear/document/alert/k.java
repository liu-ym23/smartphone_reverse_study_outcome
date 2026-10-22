package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f218927a;

    public k(e r100) {
        this.f218927a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Function0<Unit> r101 = this.f218927a.f218900c;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
