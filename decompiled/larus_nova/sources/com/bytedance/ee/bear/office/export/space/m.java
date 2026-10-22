package com.bytedance.ee.bear.office.export.space;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f235477a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<h> f235478a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f235478a, ((a) r100).f235478a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            WeakReference<h> r100 = this.f235478a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Entry(listener=" + this.f235478a + ')';
        }

        public a(WeakReference<h> r100) {
            this.f235478a = r100;
        }
    }

    static {
        f235477a = new ConcurrentHashMap();
    }

    public static h a(String r100) {
        if (r100 == null) goto L8;
        a r101 = f235477a.get(r100);
        if (r101 == null) goto L8;
        WeakReference<h> r102 = r101.f235478a;
        if (r102 == null) goto L8;
        return r102.get();
    L8:
        return null;
    }
}
