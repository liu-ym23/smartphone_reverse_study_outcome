package com.larus.paging.adapter;

import androidx.collection.LongSparseArray;

/* JADX INFO: loaded from: classes29.dex */
public interface c {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f363772a;

        /* JADX INFO: renamed from: com.larus.paging.adapter.c$a$a, reason: collision with other inner class name */
        public class C4460a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LongSparseArray<Long> f363773a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f363774b;

            public C4460a(a r100) {
                this.f363774b = r100;
                this.f363773a = new LongSparseArray();
            }

            @Override // com.larus.paging.adapter.c.d
            public final long localToGlobal(long r100) {
                Long r101 = this.f363773a.get(r100);
                if (r101 != null) goto L6;
                a r102 = this.f363774b;
                long r103 = r102.f363772a;
                r102.f363772a = 1 + r103;
                r101 = Long.valueOf(r103);
                this.f363773a.put(r100, r101);
            L6:
                return r101.longValue();
            }
        }

        @Override // com.larus.paging.adapter.c
        public final d createStableIdLookup() {
            return new C4460a(this);
        }

        public a() {
            this.f363772a = 0;
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f363775a;

        public class a implements d {
            @Override // com.larus.paging.adapter.c.d
            public final long localToGlobal(long r100) {
                return -1;
            }

            public a() {
            }
        }

        public b() {
            this.f363775a = new a();
        }

        @Override // com.larus.paging.adapter.c
        public final d createStableIdLookup() {
            return this.f363775a;
        }
    }

    /* JADX INFO: renamed from: com.larus.paging.adapter.c$c, reason: collision with other inner class name */
    public static class C4461c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f363776a;

        /* JADX INFO: renamed from: com.larus.paging.adapter.c$c$a */
        public class a implements d {
            @Override // com.larus.paging.adapter.c.d
            public final long localToGlobal(long r100) {
                return r100;
            }

            public a() {
            }
        }

        public C4461c() {
            this.f363776a = new a();
        }

        @Override // com.larus.paging.adapter.c
        public final d createStableIdLookup() {
            return this.f363776a;
        }
    }

    public interface d {
        long localToGlobal(long r100);
    }

    d createStableIdLookup();
}
