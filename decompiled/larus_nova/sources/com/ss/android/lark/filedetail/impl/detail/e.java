package com.ss.android.lark.filedetail.impl.detail;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f421602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f421603b;

    public final void a() {
        Lazy r100 = FileHitPointUtil.f421568a;
        if (FileHitPointUtil.b(this.f421602a).length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        FileHitPointUtil.a(this.f421603b);
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
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

    public e(int r100, String r101, FileContent r102) {
        this.f421602a = r100;
        this.f421603b = r101;
    }
}
