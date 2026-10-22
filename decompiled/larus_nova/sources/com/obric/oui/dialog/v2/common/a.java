package com.obric.oui.dialog.v2.common;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f400782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ODialogListItemView f400783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f400784c;

    public a(ODialogListItemView r100, ODialogListItemView r101, boolean r102) {
        this.f400782a = r100;
        this.f400783b = r101;
        this.f400784c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ODialogListItemView r100 = this.f400783b;     // Catch: Throwable -> L4
        boolean r101 = this.f400784c;     // Catch: Throwable -> L4
        int r102 = ODialogListItemView.f400773p;     // Catch: Throwable -> L4
        r100.e(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
