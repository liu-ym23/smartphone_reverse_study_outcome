package org.threeten.bp.format;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<f> f526427a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f526428a = null;

        static {
            AtomicReference<f> r100 = f.f526427a;
            h r101 = new h();
        L4:
            if (r100.compareAndSet(null, r101) == true) goto L8;
            if (r100.get() == null) goto L4;
        L8:
            f526428a = f.f526427a.get();
        }
    }

    public abstract String a(org.threeten.bp.temporal.f r100, long r101, TextStyle r102, Locale r103);

    public abstract Iterator<Map.Entry<String, Long>> b(org.threeten.bp.temporal.f r100, TextStyle r101, Locale r102);

    static {
        f526427a = new AtomicReference();
    }

    public f() {
    }
}
