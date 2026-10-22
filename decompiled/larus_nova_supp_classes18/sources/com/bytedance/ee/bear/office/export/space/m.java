package com.bytedance.ee.bear.office.export.space;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public static final ConcurrentHashMap<String, a> a = null;

    public static final class a {
        public final WeakReference<h> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            WeakReference<h> r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Entry(listener=" + this.a + ')';
        }

        public a(WeakReference<h> r1) {
            this.a = r1;
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static h a(String r1) {
        if (r1 == null) goto L8;
        a r2 = a.get(r1);
        if (r2 == null) goto L8;
        WeakReference<h> r3 = r2.a;
        if (r3 == null) goto L8;
        return r3.get();
    L8:
        return null;
    }
}
