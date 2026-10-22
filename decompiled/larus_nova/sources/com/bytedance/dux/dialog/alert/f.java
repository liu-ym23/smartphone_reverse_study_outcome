package com.bytedance.dux.dialog.alert;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<DialogInterface, Integer, Unit> f204937a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function2<? super DialogInterface, ? super Integer, Unit> r100) {
        this.f204937a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f204937a.invoke(r100, Integer.valueOf(r101));
    }
}
