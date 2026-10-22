package com.bytedance.ee.bear.edit.component.toolbar2.insertblock;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements Runnable {
    public final /* synthetic */ InsertNewBlockFragment a;
    public final /* synthetic */ InsertNewBlock b;
    public final /* synthetic */ View.OnClickListener c;

    public h(InsertNewBlockFragment r1, InsertNewBlock r2, View.OnClickListener r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsertNewBlockFragment.Z90(this.a, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
