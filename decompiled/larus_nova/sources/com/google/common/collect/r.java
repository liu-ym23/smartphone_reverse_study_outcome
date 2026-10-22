package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f275496b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f275497c = null;

    public class a extends r {
        @Override // com.google.common.collect.r
        public final int b() {
            return 0;
        }

        public a() {
        }

        @Override // com.google.common.collect.r
        public final r a(Comparable<?> r100, Comparable<?> r101) {
            int r102 = r100.compareTo(r101);
            if (r102 < 0) goto L9;
            if (r102 <= 0) goto L8;
            return r.f275497c;
        L8:
            return r.f275495a;
        L9:
            return r.f275496b;
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f275498d;

        @Override // com.google.common.collect.r
        public final r a(Comparable<?> r100, Comparable<?> r101) {
            return this;
        }

        @Override // com.google.common.collect.r
        public final int b() {
            return this.f275498d;
        }

        public b(int r100) {
            this.f275498d = r100;
        }
    }

    public abstract r a(Comparable<?> r100, Comparable<?> r101);

    public abstract int b();

    static {
        f275495a = new a();
        f275496b = new b(-1);
        f275497c = new b(1);
    }

    public r() {
    }
}
