package hz5;

import android.os.Looper;
import androidx.collection.ArrayMap;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f487676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f487677g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f487678h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f487679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap f487680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayMap f487681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayMap f487682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f487683e;

    @Override // hz5.f
    public final String getTag() {
        return "ApmEvent";
    }

    static {
        f487677g = new Object();
        f487678h = 0;
    }

    public final void e() {
        this.f487679a = "";
        this.f487680b.clear();
        this.f487681c.clear();
        this.f487682d.clear();
        Object r100 = f487677g;
        monitor-enter(r100);
        int r101 = f487678h;     // Catch: Throwable -> L9
        if (r101 >= 50) goto L7;
        this.f487683e = f487676f;     // Catch: Throwable -> L9
        f487676f = this;     // Catch: Throwable -> L9
        f487678h = r101 + 1;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        return super.toString();
    }

    public a(String r100) {
        this.f487680b = new ArrayMap();
        this.f487681c = new ArrayMap();
        this.f487682d = new ArrayMap();
        this.f487679a = r100;
    }

    public static a d(String r100) {
        Object r101 = f487677g;
        monitor-enter(r101);
        a r102 = f487676f;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        f487676f = r102.f487683e;     // Catch: Throwable -> L12
        r102.f487683e = null;     // Catch: Throwable -> L12
        f487678h--;     // Catch: Throwable -> L12
        r102.f487679a = r100;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return new a(r100);
    L12:
        th = move-exception;
        throw th;
    }

    public static a c(String r100, long r101) {
        a r102 = d("sky_eye_apm_log");
        r102.a("EventName", "MethodTimeCost");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        int r103 = 1;
    L6:
        r102.a("MainThread", Integer.valueOf(r103));
        Long r104 = Long.valueOf(r101);
        r102.f487681c.put(r100, r104);
        return r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final void a(String r100, Object r101) {
        this.f487680b.put(r100, r101);
    }

    public static a b(String r100, String r101, boolean r102, long r103) {
        a r104 = d("helios_api_statistics");
        r104.a("type", r100);
        r104.a("is_front", Boolean.valueOf(r102));
        Long r105 = Long.valueOf(r103);
        r104.f487681c.put(r101, r105);
        k.b("Helios-Frequency-Manager", super.toString());
        return r104;
    }
}
