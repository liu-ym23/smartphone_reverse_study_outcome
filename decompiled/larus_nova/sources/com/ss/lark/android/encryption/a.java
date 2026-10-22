package com.ss.lark.android.encryption;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import jkc.b;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f456800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f456801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f456802c;

    public a(File r100, boolean r101, b r102) {
        this.f456800a = r100;
        this.f456801b = r101;
        this.f456802c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PolarisFileWrapper r100 = CipherManager.e(this.f456800a, this.f456801b);     // Catch: Throwable -> L6 DecryptException -> L8
        b r101 = this.f456802c;     // Catch: Throwable -> L6 DecryptException -> L8
        if (r101 == null) goto L17;
        r101.a(r100);     // Catch: Throwable -> L6 DecryptException -> L8
    L17:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    L21:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        b r102 = this.f456802c;     // Catch: Throwable -> L6
        if (r102 == null) goto L17;
        r102.b(e);     // Catch: Throwable -> L6
        goto L17
    }
}
