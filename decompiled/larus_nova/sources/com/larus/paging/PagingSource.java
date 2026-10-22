package com.larus.paging;

import com.lynx.tasm.LynxError;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class PagingSource<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r<Function0<Unit>> f363720a;

    public static abstract class a<Key> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f363721c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f363722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f363723b;

        /* JADX INFO: renamed from: com.larus.paging.PagingSource$a$a, reason: collision with other inner class name */
        public static final class C4453a<Key> extends a<Key> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Key f363724d;

            @Override // com.larus.paging.PagingSource.a
            public final Key a() {
                return this.f363724d;
            }

            public C4453a(Key r100, int r101, boolean r102) {
                Intrinsics.checkNotNullParameter(r100, "key");
                super(r101, r102);
                this.f363724d = r100;
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: com.larus.paging.PagingSource$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C4454a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f363725a = null;

                static {
                    int[] r100 = new int[LoadType.values().length];
                    r100[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r100[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r100[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    f363725a = r100;
                }
            }
        }

        public static final class c<Key> extends a<Key> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Key f363726d;

            @Override // com.larus.paging.PagingSource.a
            public final Key a() {
                return this.f363726d;
            }

            public c(Key r100, int r101, boolean r102) {
                Intrinsics.checkNotNullParameter(r100, "key");
                super(r101, r102);
                this.f363726d = r100;
            }
        }

        public static final class d<Key> extends a<Key> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Key f363727d;

            @Override // com.larus.paging.PagingSource.a
            public final Key a() {
                return this.f363727d;
            }

            public d(Key r100, int r101, boolean r102) {
                super(r101, r102);
                this.f363727d = r100;
            }
        }

        static {
        }

        public abstract Key a();

        public a(int r100, boolean r101) {
            this.f363722a = r100;
            this.f363723b = r101;
        }
    }

    public static abstract class b<Key, Value> {

        public static final class a<Key, Value> extends b<Key, Value> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f363728a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f363728a, ((a) r100).f363728a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f363728a.hashCode();
            }

            public final String toString() {
                return "Error(throwable=" + this.f363728a + ')';
            }

            public a(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
                this.f363728a = r100;
            }
        }

        /* JADX INFO: renamed from: com.larus.paging.PagingSource$b$b, reason: collision with other inner class name */
        public static final class C4455b<Key, Value> extends b<Key, Value> {
        }

        public static final class c<Key, Value> extends b<Key, Value> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<Value> f363729a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Key f363730b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Key f363731c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f363732d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final int f363733e;

            public static final class a {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (Intrinsics.areEqual(this.f363729a, r101.f363729a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f363730b, r101.f363730b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f363731c, r101.f363731c) == true) goto L18;
                return false;
            L18:
                if (this.f363732d == r101.f363732d) goto L21;
                return false;
            L21:
                if (this.f363733e == r101.f363733e) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f363729a.hashCode() * 31;
                Key r101 = this.f363730b;
                int r102 = 0;
                if (r101 != null) goto L5;
                int r103 = 0;
            L6:
                int r104 = (r100 + r103) * 31;
                Key r105 = this.f363731c;
                if (r105 == null) goto L11;
                r102 = r105.hashCode();
            L11:
                return ((((r104 + r102) * 31) + this.f363732d) * 31) + this.f363733e;
            L5:
                r103 = r101.hashCode();
                goto L6
            }

            public final String toString() {
                return "Page(data=" + this.f363729a + ", prevKey=" + this.f363730b + ", nextKey=" + this.f363731c + ", itemsBefore=" + this.f363732d + ", itemsAfter=" + this.f363733e + ')';
            }

            static {
                new c(CollectionsKt.emptyList(), null, null, 0, 0);
            }

            public c(List r100, Object r101) {
                Intrinsics.checkNotNullParameter(r100, "data");
                this(r100, null, r101, Integer.MIN_VALUE, Integer.MIN_VALUE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public c(List<? extends Value> r100, Key r101, Key r102, int r103, int r104) {
                Intrinsics.checkNotNullParameter(r100, "data");
                this.f363729a = r100;
                this.f363730b = r101;
                this.f363731c = r102;
                this.f363732d = r103;
                this.f363733e = r104;
                boolean r105 = false;
                if (r103 == Integer.MIN_VALUE) goto L7;
                if (r103 >= 0) goto L7;
                boolean r106 = false;
            L8:
                if (r106 == false) goto L17;
                if (r104 == Integer.MIN_VALUE) goto L11;
                if (r104 >= 0) goto L11;
            L12:
                if (r105 == false) goto L15;
                return;
            L15:
                throw new IllegalArgumentException("itemsAfter cannot be negative".toString());
            L11:
                r105 = true;
                goto L12
            L17:
                throw new IllegalArgumentException("itemsBefore cannot be negative".toString());
            L7:
                r106 = true;
                goto L8
            }
        }

        public b() {
        }
    }

    public boolean a() {
        return false;
    }

    public abstract Key b(w0<Key, Value> r100);

    public abstract Object c(a<Key> r100, Continuation<? super b<Key, Value>> r101);

    public PagingSource() {
        this.f363720a = new r(PagingSource$invalidateCallbackTracker$1.INSTANCE, null);
    }
}
