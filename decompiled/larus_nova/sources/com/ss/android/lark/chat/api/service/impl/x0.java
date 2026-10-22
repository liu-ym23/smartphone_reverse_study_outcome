package com.ss.android.lark.chat.api.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes35.dex */
public final class x0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f411698a = null;

    static {
        f411698a = new x0();
    }

    public x0() {
    }

    public static void a() {
        Lazy<PreviewCache> r100 = PreviewCache.f411536f;
        PreviewCache r101 = PreviewCache.a.a();
        r101.getClass();
        r101.f411540d.writeLock().lock();     // Catch: Throwable -> L6
        Log.i("PreviewPushCache", "preview push cache clear");     // Catch: Throwable -> L6
        r101.f411538b.clear();     // Catch: Throwable -> L6
        r101.f411539c.clear();     // Catch: Throwable -> L6
        r101.f411540d.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        r101.f411540d.writeLock().unlock();
        throw th;
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
