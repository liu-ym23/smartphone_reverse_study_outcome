package com.ss.android.lark.contact.customized.common;

import android.R;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f418965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f418966b;

    public c(View r100, View r101) {
        this.f418965a = r100;
        this.f418966b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f418966b.findViewById(R.id.statusBarBackground);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setVisibility(4);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
