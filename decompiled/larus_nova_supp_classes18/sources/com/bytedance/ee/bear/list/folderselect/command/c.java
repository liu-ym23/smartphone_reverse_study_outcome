package com.bytedance.ee.bear.list.folderselect.command;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0<Unit> a;

    public c(Function0<Unit> r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        this.a.invoke();
    }
}
