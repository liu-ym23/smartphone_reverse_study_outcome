package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f421764a;

    public d(a r100) {
        this.f421764a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.H8(this.f421764a).Q5(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
