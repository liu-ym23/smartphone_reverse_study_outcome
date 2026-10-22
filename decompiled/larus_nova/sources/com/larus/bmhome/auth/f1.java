package com.larus.bmhome.auth;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f295762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f295763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f295764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, a> f295765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<c, Set<Long>> f295766e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f295767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f295768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f295769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<LaunchBiz> f295770d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f295771e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f295772f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set<LaunchBiz> f295773g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f295774h;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f295767a == r101.f295767a) goto L12;
            return false;
        L12:
            if (this.f295768b == r101.f295768b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f295769c, r101.f295769c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f295770d, r101.f295770d) == true) goto L21;
            return false;
        L21:
            if (this.f295771e == r101.f295771e) goto L24;
            return false;
        L24:
            if (this.f295772f == r101.f295772f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f295773g, r101.f295773g) == true) goto L30;
            return false;
        L30:
            if (this.f295774h == r101.f295774h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f295767a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f295768b;
            int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f295769c.hashCode()) * 31) + this.f295770d.hashCode()) * 31;
            int r104 = 1231;
            if (this.f295771e == false) goto L5;
            int r105 = 1231;
        L6:
            int r106 = (r103 + r105) * 31;
            if (this.f295772f == false) goto L9;
            int r107 = 1231;
        L10:
            int r108 = (((r106 + r107) * 31) + this.f295773g.hashCode()) * 31;
            if (this.f295774h == true) goto L15;
            r104 = 1237;
        L15:
            return r108 + r104;
        L9:
            r107 = 1237;
            goto L10
        L5:
            r105 = 1237;
            goto L6
        }

        public final String toString() {
            return "Batch(id=" + this.f295767a + ", accountGeneration=" + this.f295768b + ", source=" + this.f295769c + ", expectedBiz=" + this.f295770d + ", publishCompat=" + this.f295771e + ", publishOnReuse=" + this.f295772f + ", terminalBiz=" + this.f295773g + ", networkTouched=" + this.f295774h + ')';
        }

        public a(long r100, long r101, String r102, Set r103, boolean r104, boolean r110) {
            LinkedHashSet r105 = new LinkedHashSet();
            Intrinsics.checkNotNullParameter(r102, "source");
            Intrinsics.checkNotNullParameter(r103, "expectedBiz");
            Intrinsics.checkNotNullParameter(r105, "terminalBiz");
            this.f295767a = r100;
            this.f295768b = r101;
            this.f295769c = r102;
            this.f295770d = r103;
            this.f295771e = r104;
            this.f295772f = r110;
            this.f295773g = r105;
            this.f295774h = false;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f295775a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f295776b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f295777c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final LaunchBiz f295778d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (this.f295775a == r101.f295775a) goto L12;
                return false;
            L12:
                if (this.f295776b == r101.f295776b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f295777c, r101.f295777c) == true) goto L18;
                return false;
            L18:
                if (this.f295778d == r101.f295778d) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f295775a;
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                long r102 = this.f295776b;
                return ((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f295777c.hashCode()) * 31) + this.f295778d.hashCode();
            }

            public final String toString() {
                return "BizReady(batchId=" + this.f295775a + ", accountGeneration=" + this.f295776b + ", source=" + this.f295777c + ", biz=" + this.f295778d + ')';
            }

            @Override // com.larus.bmhome.auth.f1.b
            public final long a() {
                return this.f295776b;
            }

            public a(long r100, long r101, String r102, LaunchBiz r103) {
                Intrinsics.checkNotNullParameter(r102, "source");
                Intrinsics.checkNotNullParameter(r103, "biz");
                this.f295775a = r100;
                this.f295776b = r101;
                this.f295777c = r102;
                this.f295778d = r103;
            }
        }

        /* JADX INFO: renamed from: com.larus.bmhome.auth.f1$b$b, reason: collision with other inner class name */
        public static final class C4018b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f295779a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f295780b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f295781c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Throwable f295782d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final boolean f295783e;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4018b) == true) goto L8;
                return false;
            L8:
                C4018b r101 = (C4018b) r100;
                if (this.f295779a == r101.f295779a) goto L12;
                return false;
            L12:
                if (this.f295780b == r101.f295780b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f295781c, r101.f295781c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f295782d, r101.f295782d) == true) goto L21;
                return false;
            L21:
                if (this.f295783e == r101.f295783e) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f295779a;
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                long r102 = this.f295780b;
                int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f295781c.hashCode()) * 31;
                Throwable r104 = this.f295782d;
                if (r104 != null) goto L5;
                int r105 = 0;
            L6:
                int r106 = (r103 + r105) * 31;
                if (this.f295783e == false) goto L9;
                int r107 = 1231;
            L11:
                return r106 + r107;
            L9:
                r107 = 1237;
                goto L11
            L5:
                r105 = r104.hashCode();
                goto L6
            }

            public final String toString() {
                return "Failure(batchId=" + this.f295779a + ", accountGeneration=" + this.f295780b + ", source=" + this.f295781c + ", error=" + this.f295782d + ", publishCompat=" + this.f295783e + ')';
            }

            @Override // com.larus.bmhome.auth.f1.b
            public final long a() {
                return this.f295780b;
            }

            public C4018b(long r100, long r101, String r102, Throwable r103, boolean r104) {
                Intrinsics.checkNotNullParameter(r102, "source");
                this.f295779a = r100;
                this.f295780b = r101;
                this.f295781c = r102;
                this.f295782d = r103;
                this.f295783e = r104;
            }
        }

        /* JADX INFO: loaded from: classes25.dex */
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f295784a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f295785b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f295786c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Set<LaunchBiz> f295787d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final boolean f295788e;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (this.f295784a == r101.f295784a) goto L12;
                return false;
            L12:
                if (this.f295785b == r101.f295785b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f295786c, r101.f295786c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f295787d, r101.f295787d) == true) goto L21;
                return false;
            L21:
                if (this.f295788e == r101.f295788e) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f295784a;
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                long r102 = this.f295785b;
                int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f295786c.hashCode()) * 31) + this.f295787d.hashCode()) * 31;
                if (this.f295788e == false) goto L5;
                int r104 = 1231;
            L7:
                return r103 + r104;
            L5:
                r104 = 1237;
                goto L7
            }

            public final String toString() {
                return "Success(batchId=" + this.f295784a + ", accountGeneration=" + this.f295785b + ", source=" + this.f295786c + ", expectedBiz=" + this.f295787d + ", publishCompat=" + this.f295788e + ')';
            }

            @Override // com.larus.bmhome.auth.f1.b
            public final long a() {
                return this.f295785b;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public c(long r100, long r101, String r102, Set<? extends LaunchBiz> r103, boolean r104) {
                Intrinsics.checkNotNullParameter(r102, "source");
                Intrinsics.checkNotNullParameter(r103, "expectedBiz");
                this.f295784a = r100;
                this.f295785b = r101;
                this.f295786c = r102;
                this.f295787d = r103;
                this.f295788e = r104;
            }
        }

        public b() {
        }

        public abstract long a();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f295789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f295790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LaunchBiz f295791c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f295789a == r101.f295789a) goto L12;
            return false;
        L12:
            if (this.f295790b == r101.f295790b) goto L15;
            return false;
        L15:
            if (this.f295791c == r101.f295791c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f295789a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f295790b;
            return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f295791c.hashCode();
        }

        public final String toString() {
            return "RequestToken(accountGeneration=" + this.f295789a + ", requestGeneration=" + this.f295790b + ", biz=" + this.f295791c + ')';
        }

        public c(long r100, long r101, LaunchBiz r102) {
            Intrinsics.checkNotNullParameter(r102, "biz");
            this.f295789a = r100;
            this.f295790b = r101;
            this.f295791c = r102;
        }
    }

    public f1() {
        this.f295765d = new LinkedHashMap();
        this.f295766e = new LinkedHashMap();
    }

    public final List<b> b(a r110) {
        if (r110.f295773g.containsAll(r110.f295770d) == false) goto L5;
        this.f295765d.remove(Long.valueOf(r110.f295767a));
        c(r110.f295767a);
        long r100 = r110.f295767a;
        long r101 = r110.f295768b;
        String r102 = r110.f295769c;
        Set<LaunchBiz> r103 = r110.f295770d;
        if (r110.f295771e == true) goto L9;
    L13:
        boolean r104 = false;
    L15:
        return CollectionsKt.listOf(new b.c(r100, r101, r102, r103, r104));
    L9:
        if (r110.f295774h == false) goto L11;
    L12:
        r104 = true;
        goto L15
    L11:
        if (r110.f295772f == false) goto L13;
    L5:
        return CollectionsKt.emptyList();
    }

    public final void c(long r100) {
        Iterator r101 = ((LinkedHashMap) this.f295766e).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();
        ((Set) r102.getValue()).remove(Long.valueOf(r100));
        if (((Set) r102.getValue()).isEmpty() == false) goto L4;
        r101.remove();
        goto L4
    }

    public final Set<Long> f(c r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Set<Long> r101 = this.f295766e.remove(r100);
        if (r101 != null) goto L5;
        r101 = SetsKt.emptySet();
    L5:
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        long r103 = ((Number) r102.next()).longValue();
        this.f295765d.remove(Long.valueOf(r103));
        c(r103);
        goto L7
    L9:
        return r101;
    }

    public final void a(long r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Map<Long, a> r102 = this.f295765d;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        a r104 = (a) r103.get(Long.valueOf(r100));
        if (r104 != null) goto L6;
        return;
    L6:
        if (r104.f295768b == r101.f295789a) goto L8;
        return;
    L8:
        if (r104.f295770d.contains(r101.f295791c) == false) goto L16;
        r104.f295774h = true;
        LinkedHashMap r105 = (LinkedHashMap) this.f295766e;
        Object r106 = r105.get(r101);
        if (r106 != null) goto L13;
        r106 = new LinkedHashSet();
        r105.put(r101, r106);
    L13:
        ((Set) r106).add(Long.valueOf(r100));
        return;
    }

    public final List<b> d(Long r110, LaunchBiz r111) {
        Intrinsics.checkNotNullParameter(r111, "biz");
        if (r110 == null) goto L5;
        a r112 = (a) ((LinkedHashMap) this.f295765d).get(r110);
        if (r112 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (r112.f295770d.contains(r111) == false) goto L13;
        List r100 = CollectionsKt.createListBuilder();
        if (r112.f295773g.add(r111) == false) goto L17;
        r100.add(new b.a(r112.f295767a, r112.f295768b, r112.f295769c, r111));
    L17:
        r100.addAll(b(r112));
        return CollectionsKt.build(r100);
    L13:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public final c e(Long r100, LaunchBiz r110) {
        Intrinsics.checkNotNullParameter(r110, "biz");
        long r101 = this.f295762a;
        long r102 = this.f295764c + 1;
        this.f295764c = r102;
        c r103 = new c(r101, r102, r110);
        if (r100 == null) goto L5;
        a(r100.longValue(), r103);
    L5:
        return r103;
    }
}
