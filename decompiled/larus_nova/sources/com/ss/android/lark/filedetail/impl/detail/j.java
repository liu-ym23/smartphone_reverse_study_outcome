package com.ss.android.lark.filedetail.impl.detail;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileContent f421610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f421611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f421612c;

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.f421612c, this.f421610a, this.f421611b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(p r100, FileContent r101, VFSFile r102) {
        this.f421612c = r100;
        this.f421610a = r101;
        this.f421611b = r102;
    }
}
