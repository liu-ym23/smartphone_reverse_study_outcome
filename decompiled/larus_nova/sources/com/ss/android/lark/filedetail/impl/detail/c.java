package com.ss.android.lark.filedetail.impl.detail;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f421599a;

    public final void a() {
        Lazy r100 = FileHitPointUtil.f421568a;
        FileHitPointUtil.a(this.f421599a);
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

    public c(String r100, FileContent r101, boolean r102) {
        this.f421599a = r100;
    }
}
