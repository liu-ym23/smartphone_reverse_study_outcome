package com.larus.common_ui.widget.concat_adapter;

import androidx.collection.LongSparseArray;

/* JADX INFO: loaded from: classes27.dex */
public interface c {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f328581a;

        /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.c$a$a, reason: collision with other inner class name */
        public class C4192a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LongSparseArray<Long> f328582a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f328583b;

            public C4192a(a r100) {
                this.f328583b = r100;
                this.f328582a = new LongSparseArray();
            }

            @Override // com.larus.common_ui.widget.concat_adapter.c.d
            public final long localToGlobal(long r100) {
                Long r101 = this.f328582a.get(r100);
                if (r101 != null) goto L6;
                a r102 = this.f328583b;
                long r103 = r102.f328581a;
                r102.f328581a = 1 + r103;
                r101 = Long.valueOf(r103);
                this.f328582a.put(r100, r101);
            L6:
                return r101.longValue();
            }
        }

        @Override // com.larus.common_ui.widget.concat_adapter.c
        public final d createStableIdLookup() {
            return new C4192a(this);
        }

        public a() {
            this.f328581a = 0;
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f328584a;

        public class a implements d {
            @Override // com.larus.common_ui.widget.concat_adapter.c.d
            public final long localToGlobal(long r100) {
                return -1;
            }

            public a() {
            }
        }

        public b() {
            this.f328584a = new a();
        }

        @Override // com.larus.common_ui.widget.concat_adapter.c
        public final d createStableIdLookup() {
            return this.f328584a;
        }
    }

    /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.c$c, reason: collision with other inner class name */
    public static class C4193c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f328585a;

        /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.c$c$a */
        public class a implements d {
            @Override // com.larus.common_ui.widget.concat_adapter.c.d
            public final long localToGlobal(long r100) {
                return r100;
            }

            public a() {
            }
        }

        public C4193c() {
            this.f328585a = new a();
        }

        @Override // com.larus.common_ui.widget.concat_adapter.c
        public final d createStableIdLookup() {
            return this.f328585a;
        }
    }

    public interface d {
        long localToGlobal(long r100);
    }

    d createStableIdLookup();
}
