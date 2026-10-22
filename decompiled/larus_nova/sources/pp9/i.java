package pp9;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f530229a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function0<? extends JSONObject> f530230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f530231c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f530232d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f530233e = null;

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
                Lazy r100 = i.f530229a;
                Function0<? extends JSONObject> r101 = i.f530230b;
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
        f530229a = LazyKt.lazy(new e());
        f530231c = LazyKt.lazy(new f());
        f530232d = LazyKt.lazy(new g());
        f530233e = LazyKt.lazy(new h());
    }

    public static d a() {
        return (d) f530229a.getValue();
    }

    public static void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "extraAttributes");
        d r101 = a();
        a r102 = (a) f530233e.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "event");
        Intrinsics.checkNotNullParameter(r100, "extraAttributes");
        r101.f483123a.b(r102, r100);
    }
}
