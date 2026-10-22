package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InsertNewBlockFragment f226340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InsertNewBlock f226341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f226342c;

    public h(InsertNewBlockFragment r100, InsertNewBlock r101, View.OnClickListener r102) {
        this.f226340a = r100;
        this.f226341b = r101;
        this.f226342c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsertNewBlockFragment.Z90(this.f226340a, this.f226341b, this.f226342c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
