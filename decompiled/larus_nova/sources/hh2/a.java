package hh2;

import com.bytedance.android.livesdk.livecommerce.LiveConfigurationModule_ProvideFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import sg2.a0;
import sg2.d0;
import sg2.i;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f485148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f485149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zi2.a f485150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public mi2.c f485151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.saascoupon.a f485152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f485153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f485154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Provider<g> f485155h;

    /* JADX INFO: renamed from: hh2.a$a, reason: collision with other inner class name */
    public static final class C6144a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a0 f485156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gh2.a f485157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d0 f485158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f485159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public zi2.a f485160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public mi2.c f485161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.bytedance.android.livesdk.livecommerce.saascoupon.a f485162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public i f485163h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public d f485164i;

        public C6144a() {
        }
    }

    public static a a() {
        C6144a r100 = new C6144a();
        if (r100.f485156a != null) goto L6;
        r100.f485156a = new a0();
    L6:
        if (r100.f485157b != null) goto L9;
        r100.f485157b = new gh2.a();
    L9:
        if (r100.f485158c != null) goto L12;
        r100.f485158c = new d0();
    L12:
        if (r100.f485159d != null) goto L15;
        r100.f485159d = new b();
    L15:
        if (r100.f485160e != null) goto L18;
        r100.f485160e = new zi2.a();
    L18:
        if (r100.f485161f != null) goto L21;
        r100.f485161f = new mi2.c();
    L21:
        if (r100.f485162g != null) goto L24;
        r100.f485162g = new com.bytedance.android.livesdk.livecommerce.saascoupon.a();
    L24:
        if (r100.f485163h != null) goto L27;
        r100.f485163h = new i();
    L27:
        if (r100.f485164i != null) goto L30;
        r100.f485164i = new d();
    L30:
        return new a(r100);
    }

    public a(C6144a r100) {
        this.f485155h = DoubleCheck.provider(LiveConfigurationModule_ProvideFactory.create(r100.f485156a));
        this.f485148a = r100.f485158c;
        this.f485149b = r100.f485159d;
        this.f485150c = r100.f485160e;
        this.f485151d = r100.f485161f;
        this.f485152e = r100.f485162g;
        this.f485153f = r100.f485163h;
        this.f485154g = r100.f485164i;
    }
}
