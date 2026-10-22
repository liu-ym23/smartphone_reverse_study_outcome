package com.obric.miniapp.intent;

import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f397727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f397728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f397729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<String> f397730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f397731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f397732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f397733g;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f397734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f397735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f397736c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f397734a == r101.f397734a) goto L12;
            return false;
        L12:
            if (this.f397735b == r101.f397735b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f397736c, r101.f397736c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f397734a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f397735b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f397736c.hashCode();
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "ScopedState(ownedByCard=" + this.f397734a + ", isPlaying=" + this.f397735b + ", currentId=" + this.f397736c + ')';
        }

        public b(boolean r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "currentId");
            this.f397734a = r100;
            this.f397735b = r101;
            this.f397736c = r102;
        }
    }

    static {
    }

    public t() {
        this.f397727a = 4000;
        this.f397728b = 30000;
        this.f397729c = 128;
        this.f397730d = new LinkedHashSet();
    }

    public final synchronized void a(String r100) {
        monitor-enter(this);
        if (r100 == null) goto L9;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f397731e, r100) == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.f397731e = null;     // Catch: Throwable -> L12
        this.f397732f = null;     // Catch: Throwable -> L12
        this.f397733g = 0;     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final synchronized boolean b(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "cardId");     // Catch: Throwable -> L11
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == false) goto L8;
        if (Intrinsics.areEqual(this.f397731e, r100) == false) goto L8;
    L9:
        monitor-exit(this);
        return r101;
    L8:
        r101 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e(String r100) {
        if (this.f397730d.add(r100) == true) goto L6;
        return;
    L6:
        if (this.f397730d.size() <= RangesKt.coerceAtLeast(this.f397729c, 1)) goto L11;
        Iterator<String> r101 = this.f397730d.iterator();
        if (r101.hasNext() == false) goto L9;
        r101.next();
        r101.remove();
        goto L6
    L9:
        return;
    }

    public final synchronized void d(String r100, boolean r101, long r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "currentId");     // Catch: Throwable -> L6
        h(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void h(String r100, boolean r101, long r102) {
        String r103 = this.f397732f;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r101 == false) goto L11;
        if (Intrinsics.areEqual(r100, r103) == false) goto L11;
        this.f397733g = 0;
        return;
    L11:
        if (r102 >= this.f397733g) goto L13;
        return;
    L13:
        a(null);
    }

    public final synchronized void c(String r100, String r101, boolean r102, long r103) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "cardId");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r101, "currentId");     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r100) == false) goto L6;
    L20:
        h(r101, r102, r103);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L6:
        if (StringsKt.isBlank(r101) == true) goto L20;
        if (r102 == false) goto L20;
        if (r103 >= this.f397733g) goto L17;
        String r104 = this.f397731e;     // Catch: Throwable -> L23
        if (r104 == null) goto L17;
        if (Intrinsics.areEqual(r104, r100) == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f397731e = r100;     // Catch: Throwable -> L23
        this.f397732f = r101;     // Catch: Throwable -> L23
        this.f397733g = 0;     // Catch: Throwable -> L23
        e(r100);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized b f(String r100, String r101, boolean r102, long r103) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "cardId");     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter(r101, "currentId");     // Catch: Throwable -> L35
        boolean r104 = false;
        if ((!StringsKt.isBlank(r100)) == true) goto L6;
    L8:
        boolean r105 = false;
    L9:
        if (r105 == true) goto L14;
        b r106 = new b(false, false, "");     // Catch: Throwable -> L35
        monitor-exit(this);
        return r106;
    L14:
        if (r103 >= this.f397733g) goto L16;
        boolean r107 = true;
    L17:
        if (r102 == true) goto L19;
    L23:
        boolean r108 = false;
    L25:
        if (r107 == true) goto L27;
        if (r108 == true) goto L27;
    L28:
        if (r107 == false) goto L32;
        r101 = this.f397732f;     // Catch: Throwable -> L35
        if (r101 != null) goto L32;
        r101 = "";
    L32:
        b r109 = new b(true, r104, r101);     // Catch: Throwable -> L35
        monitor-exit(this);
        return r109;
    L27:
        r104 = true;
        goto L28
    L19:
        if ((!StringsKt.isBlank(r101)) == false) goto L23;
        if (Intrinsics.areEqual(r101, this.f397732f) == false) goto L23;
        r108 = true;
        goto L25
    L16:
        r107 = false;
        goto L17
    L6:
        if (Intrinsics.areEqual(this.f397731e, r100) == false) goto L8;
        r105 = true;
    L35:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean g(String r100, String r101, boolean r102, Long r103, long r104) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "cardId");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r101, "musicId");     // Catch: Throwable -> L25
        if (StringsKt.isBlank(r100) == false) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (StringsKt.isBlank(r101) == true) goto L23;
        if (r102 == false) goto L23;
        if (r103 == null) goto L15;
        long r105 = r104 - r103.longValue();     // Catch: Throwable -> L25
        if ((-5000) > r105) goto L15;
        if (r105 > this.f397728b) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L23;
        if (this.f397730d.contains(r100) == true) goto L23;
        e(r100);     // Catch: Throwable -> L25
        monitor-exit(this);
        return true;
    L15:
        r106 = false;
    L25:
        th = move-exception;
        throw th;
    }
}
