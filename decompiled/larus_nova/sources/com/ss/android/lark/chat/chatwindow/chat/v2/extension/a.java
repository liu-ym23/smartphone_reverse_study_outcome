package com.ss.android.lark.chat.chatwindow.chat.v2.extension;

import androidx.lifecycle.Observer;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Observer<Object> f414418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f414419b;

    public a(Observer<Object> r100, Object r101) {
        this.f414418a = r100;
        this.f414419b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f414418a.onChanged(this.f414419b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
