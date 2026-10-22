package ex3;

import android.content.Context;
import com.bytedance.bdinstall.g0;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f474670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f474671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f474672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f474673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f474674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ex3.a f474676g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f474677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f474678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f474679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g0 f474680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f474681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ExecutorService f474682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ex3.a f474683g;

        public a() {
        }
    }

    public final String toString() {
        return "MonitorV3Config{context=" + this.f474670a + ", appLogConfig=" + this.f474671b + ", eventReportInterval=" + this.f474672c + ", networkClient=" + this.f474673d + ", executor=" + this.f474674e + ", reportUrl='" + this.f474675f + "'}";
    }

    public Context getContext() {
        return this.f474670a;
    }

    public d(a r100) {
        this.f474672c = 60000;
        this.f474670a = r100.f474677a;
        this.f474671b = r100.f474678b;
        this.f474672c = r100.f474679c;
        this.f474673d = r100.f474680d;
        this.f474675f = r100.f474681e;
        this.f474674e = r100.f474682f;
        this.f474676g = r100.f474683g;
    }
}
