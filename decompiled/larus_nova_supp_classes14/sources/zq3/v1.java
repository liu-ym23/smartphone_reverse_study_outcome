package zq3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class v1 {
    public final String a;
    public final long b;

    public static final class a {
    }

    public static final class b extends v1 {
        public b() {
            super("t_visible_loadmore_start");
        }
    }

    public static final class c extends v1 {
        public final int c;
        public final long d;

        public c(int r2, long r3) {
            super("t_request_loadmore_start");
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class d extends e {
        public final int d;
        public final long e;
        public final Long f;

        @Override // zq3.v1
        public final Map<String, Object> b() {
            return MapsKt.mapOf(TuplesKt.to("response_size", Integer.valueOf(this.d)));
        }

        public d(String r2, int r3, long r4, Long r6) {
            Intrinsics.checkNotNullParameter(r2, "uniqueId");
            super("t_request_loadmore_end", r2);
            this.d = r3;
            this.e = r4;
            this.f = r6;
        }
    }

    public static abstract class e extends v1 {
        public final String c;

        public e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "desc");
            Intrinsics.checkNotNullParameter(r3, "uniqueId");
            super(r2);
            this.c = r3;
        }
    }

    public static final class f extends e {
        public f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uniqueId");
            super("t_render_loadmore_start", r2);
        }
    }

    public static final class g extends e {
        public g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uniqueId");
            super("t_render_loadmore_end", r2);
        }
    }

    public static abstract class h extends v1 {

        public static final class a extends h {
            public final Boolean c;
            public final String d;

            @Override // zq3.v1
            public final Map<String, Object> a() {
                Map<String, Object> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sort_name", this.d)});
                Boolean r1 = this.c;
                if (r1 == null) goto L5;
                r0.put("sort_type", Integer.valueOf(r1.booleanValue() ? 1 : 0));
            L5:
                return r0;
            }

            public a(Boolean r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "name");
                this.c = r2;
                this.d = r3;
            }
        }

        public static final class b extends h {
            public final String c;
            public final String d;

            @Override // zq3.v1
            public final Map<String, Object> a() {
                LinkedHashMap r0 = new LinkedHashMap();
                String r1 = this.c;
                if (r1 == null) goto L5;
                r0.put("subcategory_id", r1);
            L5:
                String r2 = this.d;
                if (r2 == null) goto L8;
                r0.put("subcategory_name", r2);
            L8:
                return r0;
            }

            public b(String r1, String r2) {
                this.c = r1;
                this.d = r2;
            }
        }

        public h() {
            super("t_user_sort_click");
        }
    }

    static {
    }

    public Map<String, Object> a() {
        return MapsKt.emptyMap();
    }

    public Map<String, Object> b() {
        return MapsKt.emptyMap();
    }

    public v1(String r4) {
        long r0 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r4, "desc");
        this.a = r4;
        this.b = r0;
    }
}
