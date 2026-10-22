package onb;

import android.app.Application;
import androidx.camera.core.RetryPolicy;

/* JADX INFO: loaded from: classes36.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f524426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f524427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f524428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f524429d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f524430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Application f524431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f524432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f524433d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f524434e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public nnb.d f524435f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f524436g;

        public a() {
        }
    }

    public k(a r100) {
        d r101 = r100.f524433d;
        if (r101 == null) goto L11;
        Application r102 = r100.f524431b;
        if (r102 == null) goto L9;
        this.f524427b = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        this.f524428c = 20000;
        nnb.c.C6948c r103 = new nnb.c.C6948c();
        r103.f519696b = r102;
        r103.f519695a = r100.f524430a;
        r103.f519697c = r100.f524432c;
        r103.f519698d = r100.f524435f;
        r103.f519699e = r100.f524436g;
        d r104 = r100.f524434e;
        this.f524429d = new l();
        this.f524426a = new g(new nnb.c(r103), new n(), r101, r104);
        return;
    L9:
        throw new NullPointerException("jsclient build npe");
    L11:
        throw new NullPointerException("jsclient build npe");
    }
}
