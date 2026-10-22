package i8a;

import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<LynxView> f488704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f488705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f488706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f488707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f488708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f488709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f488710h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f488711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f488712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f488713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f488714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f488715e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f488716f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public LynxView f488717g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f488718h;

        public a() {
            this.f488711a = 0;
            this.f488712b = 0;
            this.f488713c = false;
            this.f488714d = null;
            this.f488715e = 0;
            this.f488716f = 0;
            this.f488717g = null;
            this.f488718h = false;
        }
    }

    public j(a r100) {
        this.f488709g = r100.f488711a;
        this.f488710h = r100.f488712b;
        this.f488705c = r100.f488713c;
        this.f488703a = r100.f488714d;
        this.f488708f = r100.f488715e;
        this.f488706d = r100.f488716f;
        this.f488704b = new WeakReference(r100.f488717g);
        this.f488707e = r100.f488718h;
    }
}
