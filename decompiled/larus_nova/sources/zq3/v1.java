package zq3;

import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f573318b;

    public static final class a {
    }

    public static final class b extends v1 {
        public b() {
            super("t_visible_loadmore_start");
        }
    }

    public static final class c extends v1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f573319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f573320d;

        public c(int r100, long r101) {
            super("t_request_loadmore_start");
            this.f573319c = r100;
            this.f573320d = r101;
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f573321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f573322e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Long f573323f;

        @Override // zq3.v1
        public final Map<String, Object> b() {
            return MapsKt.mapOf(TuplesKt.to("response_size", Integer.valueOf(this.f573321d)));
        }

        public d(String r100, int r101, long r102, Long r103) {
            Intrinsics.checkNotNullParameter(r100, "uniqueId");
            super("t_request_loadmore_end", r100);
            this.f573321d = r101;
            this.f573322e = r102;
            this.f573323f = r103;
        }
    }

    public static abstract class e extends v1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f573324c;

        public e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            Intrinsics.checkNotNullParameter(r101, "uniqueId");
            super(r100);
            this.f573324c = r101;
        }
    }

    public static final class f extends e {
        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uniqueId");
            super("t_render_loadmore_start", r100);
        }
    }

    public static final class g extends e {
        public g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uniqueId");
            super("t_render_loadmore_end", r100);
        }
    }

    public static abstract class h extends v1 {

        public static final class a extends h {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Boolean f573325c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f573326d;

            @Override // zq3.v1
            public final Map<String, Object> a() {
                Map<String, Object> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sort_name", this.f573326d)});
                Boolean r101 = this.f573325c;
                if (r101 == null) goto L5;
                r100.put(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, Integer.valueOf(r101.booleanValue() ? 1 : 0));
            L5:
                return r100;
            }

            public a(Boolean r100, String r101) {
                Intrinsics.checkNotNullParameter(r101, "name");
                this.f573325c = r100;
                this.f573326d = r101;
            }
        }

        public static final class b extends h {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f573327c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f573328d;

            @Override // zq3.v1
            public final Map<String, Object> a() {
                LinkedHashMap r100 = new LinkedHashMap();
                String r101 = this.f573327c;
                if (r101 == null) goto L5;
                r100.put("subcategory_id", r101);
            L5:
                String r102 = this.f573328d;
                if (r102 == null) goto L8;
                r100.put("subcategory_name", r102);
            L8:
                return r100;
            }

            public b(String r100, String r101) {
                this.f573327c = r100;
                this.f573328d = r101;
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

    public v1(String r100) {
        long r101 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        this.f573317a = r100;
        this.f573318b = r101;
    }
}
