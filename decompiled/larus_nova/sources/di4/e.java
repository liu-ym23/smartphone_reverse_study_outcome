package di4;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f468738a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function0<? extends JSONObject> f468739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f468740c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f468741d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f468742e = null;

    public static final class a implements gx8.e {
        public a() {
        }

        @Override // gx8.e
        public final String getEventType() {
            return "open_album";
        }

        @Override // gx8.e
        public final String getUploadName() {
            return "basic_performance_operation_count";
        }

        @Override // gx8.e
        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }
    }

    public static final class b implements gx8.e {
        public b() {
        }

        @Override // gx8.e
        public final String getEventType() {
            return "open_album";
        }

        @Override // gx8.e
        public final String getUploadName() {
            return "basic_performance_operation_cost_time";
        }

        @Override // gx8.e
        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }
    }

    public static final class c implements gx8.e {
        public c() {
        }

        @Override // gx8.e
        public final String getEventType() {
            return "open_album_frame";
        }

        @Override // gx8.e
        public final String getUploadName() {
            return "basic_performance_operation_cost_time";
        }

        @Override // gx8.e
        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }
    }

    public static final class d extends gx8.a {

        public static final class a implements gx8.d {
            public a() {
            }

            @Override // gx8.d
            public final JSONObject a() {
                Lazy r100 = e.f468738a;
                Function0<? extends JSONObject> r101 = e.f468739b;
                if (r101 == null) goto L7;
                JSONObject r102 = r101.invoke();
                if (r102 == null) goto L7;
                return r102;
            L7:
                return new JSONObject();
            }
        }

        @Override // gx8.a
        public final gx8.d b() {
            return new a();
        }

        public d() {
        }
    }

    static {
        f468738a = LazyKt.lazy(new di4.a());
        f468740c = LazyKt.lazy(new di4.b());
        f468741d = LazyKt.lazy(new di4.c());
        f468742e = LazyKt.lazy(new di4.d());
    }

    public static d a() {
        return (d) f468738a.getValue();
    }
}
