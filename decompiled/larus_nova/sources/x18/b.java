package x18;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Request;

/* JADX INFO: loaded from: classes24.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeUnit f562133a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f562134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<y18.b> f562135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f562136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f562137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TimeUnit f562138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f562139f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TimeUnit f562140g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f562141h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public TimeUnit f562142i;

        public a() {
            this.f562135b = new ArrayList();
            this.f562137d = 10000;
            TimeUnit r100 = b.f562133a;
            this.f562138e = r100;
            this.f562139f = 10000;
            this.f562140g = r100;
            this.f562141h = 10000;
            this.f562142i = r100;
        }
    }

    List<a28.a> a(String r100);

    void b(String r100, List<a28.a> r101);

    com.larksuite.framework.http.call.b c(z18.a r100);

    b28.b newCall(Request r100);

    static {
        f562133a = TimeUnit.MILLISECONDS;
    }
}
