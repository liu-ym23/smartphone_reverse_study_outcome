package nw3;

import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.e0;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.k;
import com.bytedance.bdinstall.l;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.w;
import com.bytedance.bdinstall.y;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f implements h, e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile l f520959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile o0 f520960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile g f520961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.applog.b f520962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile k f520963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f520964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n0 f520965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f520966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f520967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f520968j;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements e0, w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f520969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f520970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONObject f520971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public n0 f520972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f520973e;

        public final void c() {
            monitor-enter(this);
        L19:
            th = move-exception;
            throw th;
        L4:
            if (this.f520973e == false) goto L9;
            b r100 = this.f520970b;     // Catch: Throwable -> L19
            JSONObject r101 = this.f520971c;     // Catch: Throwable -> L19
            rw3.f.a r102 = (rw3.f.a) r100;     // Catch: Throwable -> L19
            r102.f539627a.f539623w |= 4;     // Catch: Throwable -> L19
            rw3.f r103 = r102.f539627a;     // Catch: Throwable -> L19
            r103.f539608h.h(r101);     // Catch: Throwable -> L19
            if ((r103.f539623w & 8) != 0) goto L8;
            r103.f539613m.removeMessages(2);     // Catch: Throwable -> L19
            r103.f539613m.sendEmptyMessage(2);     // Catch: Throwable -> L19
        L8:
            r102.f539627a.f539603c.f192434t0.g(0, rw3.f.B, "bdinstall onUpdate", new Object[0]);     // Catch: Throwable -> L19
        L17:
            monitor-exit(this);     // Catch: Throwable -> L19
            return;
        L9:
            JSONObject r104 = this.f520971c;     // Catch: Throwable -> L19
            if (r104 == null) goto L17;
            if (this.f520972d == null) goto L17;
            this.f520973e = true;     // Catch: Throwable -> L19
            rw3.f.a r105 = (rw3.f.a) this.f520970b;     // Catch: Throwable -> L19
            r105.f539627a.f539623w |= 2;     // Catch: Throwable -> L19
            rw3.f r106 = r105.f539627a;     // Catch: Throwable -> L19
            r106.f539608h.h(r104);     // Catch: Throwable -> L19
            if ((r106.f539623w & 8) != 0) goto L16;
            r106.f539613m.removeMessages(2);     // Catch: Throwable -> L19
            r106.f539613m.sendEmptyMessage(2);     // Catch: Throwable -> L19
        L16:
            r105.f539627a.f539603c.f192434t0.g(0, rw3.f.B, "bdinstall onLoad", new Object[0]);     // Catch: Throwable -> L19
            goto L17
        }

        @Override // com.bytedance.bdinstall.e0
        public final void a(n0 r100) {
            this.f520969a.a(r100);
            this.f520972d = r100;
            c();
        }

        @Override // com.bytedance.bdinstall.w
        public final void b(JSONObject r100) {
            this.f520971c = r100;
            c();
        }

        public a(f r100, rw3.f.a r101) {
            this.f520973e = false;
            this.f520969a = r100;
            this.f520970b = r101;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
    }

    public final y b() {
        if (this.f520963e != null) goto L20;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.f520963e != null) goto L14;
        com.bytedance.applog.b r100 = this.f520962d;     // Catch: Throwable -> L16
        if (AppLog.getInstance() != r100) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
        this.f520963e = i.f199652b;     // Catch: Throwable -> L16
        goto L14
    L13:
        j74.a r102 = i.f199651a;     // Catch: Throwable -> L16
        this.f520963e = new k();     // Catch: Throwable -> L16
        goto L14
    L10:
        r101 = false;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    L20:
        return this.f520963e;
    }

    public final n0 c() {
        if (this.f520965g != null) goto L6;
        this.f520965g = ((k) b()).j();
    L6:
        return this.f520965g;
    }

    public f(com.bytedance.applog.b r100) {
        this.f520959a = new l();
        this.f520964f = new ConcurrentHashMap();
        this.f520962d = r100;
    }

    @Override // com.bytedance.bdinstall.e0
    public final void a(n0 r100) {
        this.f520965g = r100;
    }
}
