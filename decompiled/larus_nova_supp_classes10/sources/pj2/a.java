package pj2;

import android.os.SystemClock;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a {
    public final long a;
    public final String b;
    public final String c;
    public final Map<String, String> d;

    /* JADX INFO: renamed from: pj2.a$a, reason: collision with other inner class name */
    public static final class C0159a extends a {
        public final Map<String, String> e;

        public C0159a(String r2, String r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            super(r2, r3, r4);
            this.e = r4;
        }
    }

    public static final class b extends a {
        public final String e;
        public final Map<String, String> f;

        public /* synthetic */ b(String r3) {
            this("page_resp", r3, null);
        }

        public b(String r3, String r4, Map r5) {
            Intrinsics.checkNotNullParameter("list_refresh_msg", "scene");
            Intrinsics.checkNotNullParameter(r3, "stage");
            super("list_refresh_msg", r4, r5);
            this.e = r3;
            this.f = r5;
        }
    }

    public static final class c extends a {
        public final Map<String, String> e;

        public c(String r2, String r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            super(r2, r3, r4);
            this.e = r4;
        }
    }

    public a() {
        throw null;
    }

    public a(String r3, String r4, Map r5) {
        this.a = SystemClock.elapsedRealtime();
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
