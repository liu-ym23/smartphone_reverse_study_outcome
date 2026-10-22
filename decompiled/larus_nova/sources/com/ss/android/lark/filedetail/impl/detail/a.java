package com.ss.android.lark.filedetail.impl.detail;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f421598a;

    public a(String r100) {
        this.f421598a = r100;
    }

    public final void a() {
        VFSFile r100 = sfb.c.b().i(this.f421598a);
        if (r100.exists() == true) goto L11;
        Log.i("DecryptFileProcessor", "delete path: " + this.f421598a + " failed for not exist");
        return;
    L11:
        r100.delete();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Log.e("DecryptFileProcessor", "delete path " + this.f421598a + " failed for " + e.getMessage());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
