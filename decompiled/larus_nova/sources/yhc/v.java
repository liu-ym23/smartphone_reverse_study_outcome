package yhc;

import android.app.Activity;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f567737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCommonContext f567738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f567739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i0 f567740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f567741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f567742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f567743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f567744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d0 f567745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f567746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f567747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f567748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f567749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f567750n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f567751o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f567752p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f567753q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f567754r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f567755s;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f567756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AppCommonContext f567757b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f567758c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i0 f567759d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public j f567760e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public d f567761f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f567762g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f567763h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f567764i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public d0 f567765j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f567766k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f567767l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f567768m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public c f567769n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f567770o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f567771p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f567772q;

        /* JADX INFO: renamed from: yhc.v$a$a, reason: collision with other inner class name */
        public class C8343a implements d {
            @Override // yhc.d
            public final WeakReference<Activity> getCurrentActivity() {
                return null;
            }

            public C8343a() {
            }
        }

        public a() {
            this.f567761f = new C8343a();
            this.f567767l = 3600000;
            this.f567768m = "";
            this.f567771p = false;
            this.f567772q = true;
        }
    }

    public final i0 a() {
        i0 r100 = this.f567740d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("updateStrategyInfo can not null");
    }

    public final j b() {
        j r100 = this.f567741e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("iUpdateForceExit can not null");
    }

    public v(a r100) {
        this.f567748l = 3600000;
        this.f567749m = true;
        this.f567750n = "";
        this.f567751o = true;
        this.f567754r = false;
        this.f567755s = true;
        this.f567737a = r100.f567756a;
        this.f567738b = r100.f567757b;
        this.f567739c = r100.f567758c;
        this.f567740d = r100.f567759d;
        this.f567741e = r100.f567760e;
        this.f567742f = r100.f567761f;
        this.f567744h = r100.f567763h;
        this.f567746j = r100.f567764i;
        this.f567745i = r100.f567765j;
        this.f567747k = r100.f567766k;
        this.f567748l = r100.f567767l;
        this.f567743g = r100.f567762g;
        this.f567749m = true;
        this.f567750n = r100.f567768m;
        this.f567751o = true;
        this.f567752p = r100.f567769n;
        this.f567753q = r100.f567770o;
        this.f567754r = r100.f567771p;
        this.f567755s = r100.f567772q;
    }
}
