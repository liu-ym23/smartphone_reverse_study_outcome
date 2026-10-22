package org.threeten.bp.zone;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f526484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<b> f526485b = null;

    public static class a extends b {
        @Override // org.threeten.bp.zone.b
        public final void a() {
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: org.threeten.bp.zone.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static class C7103b extends b {
        @Override // org.threeten.bp.zone.b
        public final void a() {
            Iterator r100 = c.a();
        L4:
            if (r100.hasNext() == false) goto L13;
            d.d((d) r100.next());     // Catch: ServiceConfigurationError -> L8
        L8:
            e = move-exception;
            if ((e.getCause() instanceof SecurityException) == true) goto L4;
            throw e;
        }

        public C7103b() {
        }
    }

    public abstract void a();

    static {
        new a();
        f526484a = new AtomicBoolean(false);
        f526485b = new AtomicReference();
    }

    public b() {
    }
}
