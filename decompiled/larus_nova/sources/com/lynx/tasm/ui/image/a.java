package com.lynx.tasm.ui.image;

import com.facebook.drawee.components.DeferredReleaser;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f383858c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<DeferredReleaser.Releasable> f383859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RunnableC4578a f383860b;

    /* JADX INFO: renamed from: com.lynx.tasm.ui.image.a$a, reason: collision with other inner class name */
    public class RunnableC4578a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f383861a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<DeferredReleaser.Releasable> r100 = this.f383861a.f383859a.iterator();     // Catch: Throwable -> L8
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().release();     // Catch: Throwable -> L8
            goto L4
        L6:
            this.f383861a.f383859a.clear();     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public RunnableC4578a(a r100) {
            this.f383861a = r100;
        }
    }

    public a() {
        this.f383860b = new RunnableC4578a(this);
        this.f383859a = Collections.newSetFromMap(new ConcurrentHashMap());
    }
}
