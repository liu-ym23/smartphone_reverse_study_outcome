package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f421762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nfb.a f421763b;

    public c(a r100, nfb.a r101) {
        this.f421762a = r100;
        this.f421763b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = false;
        a.H8(this.f421762a).T3(false, true, false);     // Catch: Throwable -> L7
        j r101 = a.H8(this.f421762a);     // Catch: Throwable -> L7
        if (this.f421763b.getType() == FileType.FOLDER) goto L5;
        r100 = true;
    L5:
        r101.Q5(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
