package com.lynx.animax.loader;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u4a.c;
import u4a.d;
import u4a.k;
import w4a.b;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXResourceLoaderHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f380312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AnimaXLoader> f380313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q4a.a f380314c;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f380315a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f380315a == 0) goto L10;
            AnimaXLog.b("AnimaXResourceLoaderHolder", "Call nativeDestroy.");     // Catch: Throwable -> L7
            AnimaXResourceLoaderHolder.a(this.f380315a);     // Catch: Throwable -> L7
            this.f380315a = 0;     // Catch: Throwable -> L7
            return;
        }

        public a(long r100) {
            this.f380315a = r100;
        }
    }

    private static native long nativeCreate();

    private static native void nativeDestroy(long r100);

    private static native void nativeRegisterLoaderForScheme(long r100, AnimaXLoader r101, int r102);

    public AnimaXResourceLoaderHolder(b r100) {
        this.f380313b = new ArrayList();
        this.f380314c = null;
        this.f380312a = nativeCreate();
        this.f380314c = new q4a.a(this, new a(this.f380312a));
        b(new u4a.a());
        b(new d());
        b(new u4a.b());
        b(new c());
        if (r100 != null) goto L5;
        AnimaXLog.a("AnimaXResourceLoaderHolder", "resourceFactory is null");
        return;
    L5:
        List<k> r101 = r100.b();
        if (r101 != null) goto L8;
        AnimaXLog.a("AnimaXResourceLoaderHolder", "loaders is null");
        return;
    L8:
        Iterator<k> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L15;
        b(r102.next());
        goto L10
    }

    public static /* synthetic */ void a(long r100) {
        nativeDestroy(r100);
    }

    public final void b(k r100) {
        AnimaXLoader r101 = AnimaXLoader.create(r100);
        this.f380313b.add(r101);
        nativeRegisterLoaderForScheme(this.f380312a, r101, r100.getScheme().ordinal());
    }
}
