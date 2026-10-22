package pj2;

import android.os.SystemClock;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f529445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f529446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f529447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f529448d;

    /* JADX INFO: renamed from: pj2.a$a, reason: collision with other inner class name */
    public static final class C7198a extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, String> f529449e;

        public C7198a(String r100, String r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            super(r100, r101, r102);
            this.f529449e = r102;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f529450e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, String> f529451f;

        public /* synthetic */ b(String r100) {
            this("page_resp", r100, null);
        }

        public b(String r100, String r101, Map r102) {
            Intrinsics.checkNotNullParameter("list_refresh_msg", "scene");
            Intrinsics.checkNotNullParameter(r100, "stage");
            super("list_refresh_msg", r101, r102);
            this.f529450e = r100;
            this.f529451f = r102;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, String> f529452e;

        public c(String r100, String r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            super(r100, r101, r102);
            this.f529452e = r102;
        }
    }

    public a() {
        throw null;
    }

    public a(String r100, String r101, Map r102) {
        this.f529445a = SystemClock.elapsedRealtime();
        this.f529446b = r100;
        this.f529447c = r101;
        this.f529448d = r102;
    }
}
