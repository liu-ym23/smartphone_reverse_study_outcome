package com.larus.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f362173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<String, a> f362174b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f362175c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f362176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f362177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f362178c;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f362176a == r101.f362176a) goto L12;
            return false;
        L12:
            if (this.f362177b == r101.f362177b) goto L15;
            return false;
        L15:
            if (this.f362178c == r101.f362178c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f362176a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f362177b == true) goto L10;
            r100 = 1237;
        L10:
            int r103 = (r102 + r100) * 31;
            long r104 = this.f362178c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "HostVisibilityState(visible=" + this.f362176a + ", active=" + this.f362177b + ", activationOrder=" + this.f362178c + ')';
        }

        public /* synthetic */ a(int r100) {
            this(true, false, 0);
        }

        public a(boolean r100, boolean r101, long r102) {
            this.f362176a = r100;
            this.f362177b = r101;
            this.f362178c = r102;
        }
    }

    static {
        f362174b = new LinkedHashMap();
    }

    public static void a() {
        g r100 = f362173a;
        if (r100 != null) goto L5;
        return;
    L5:
        Collection<a> r101 = f362174b.values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((a) r104).f362177b == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        Iterator r105 = r102.iterator();
        if (r105.hasNext() == true) goto L14;
        Object r106 = null;
    L24:
        a r107 = (a) r106;
        if (r107 != null) goto L27;
        return;
    L27:
        r100.a(r107.f362176a);
        return;
    L14:
        Object r108 = r105.next();
        if (r105.hasNext() == true) goto L17;
    L16:
        r106 = r108;
        goto L24
    L17:
        long r109 = ((a) r108).f362178c;
    L18:
        Object r110 = r105.next();
        long r111 = ((a) r110).f362178c;
        if (r109 >= r111) goto L22;
        r108 = r110;
        r109 = r111;
    L22:
        if (r105.hasNext() == true) goto L18;
        goto L16
    }

    public static void b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "hostKey");
        LinkedHashMap<String, a> r102 = f362174b;
        a r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new a(0);
    L5:
        if (r101 == false) goto L7;
        long r104 = f362175c + 1;
        f362175c = r104;
    L8:
        r102.put(r100, new a(r103.f362176a, r101, r104));
        a();
        return;
    L7:
        r104 = r103.f362178c;
        goto L8
    }

    public static void c(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "hostKey");
        LinkedHashMap<String, a> r102 = f362174b;
        a r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new a(0);
    L5:
        r102.put(r100, new a(r101, r103.f362177b, r103.f362178c));
        a();
    }
}
