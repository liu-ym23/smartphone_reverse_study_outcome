package hh2;

import com.bytedance.android.livesdk.livecommerce.LiveConfigurationModule_ProvideFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import sg2.a0;
import sg2.d0;
import sg2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public d0 a;
    public b b;
    public zi2.a c;
    public mi2.c d;
    public com.bytedance.android.livesdk.livecommerce.saascoupon.a e;
    public i f;
    public d g;
    public Provider<g> h;

    /* JADX INFO: renamed from: hh2.a$a, reason: collision with other inner class name */
    public static final class C0142a {
        public a0 a;
        public gh2.a b;
        public d0 c;
        public b d;
        public zi2.a e;
        public mi2.c f;
        public com.bytedance.android.livesdk.livecommerce.saascoupon.a g;
        public i h;
        public d i;

        public C0142a() {
        }
    }

    public static a a() {
        C0142a r0 = new C0142a();
        if (r0.a != null) goto L6;
        r0.a = new a0();
    L6:
        if (r0.b != null) goto L9;
        r0.b = new gh2.a();
    L9:
        if (r0.c != null) goto L12;
        r0.c = new d0();
    L12:
        if (r0.d != null) goto L15;
        r0.d = new b();
    L15:
        if (r0.e != null) goto L18;
        r0.e = new zi2.a();
    L18:
        if (r0.f != null) goto L21;
        r0.f = new mi2.c();
    L21:
        if (r0.g != null) goto L24;
        r0.g = new com.bytedance.android.livesdk.livecommerce.saascoupon.a();
    L24:
        if (r0.h != null) goto L27;
        r0.h = new i();
    L27:
        if (r0.i != null) goto L30;
        r0.i = new d();
    L30:
        return new a(r0);
    }

    public a(C0142a r2) {
        this.h = DoubleCheck.provider(LiveConfigurationModule_ProvideFactory.create(r2.a));
        this.a = r2.c;
        this.b = r2.d;
        this.c = r2.e;
        this.d = r2.f;
        this.e = r2.g;
        this.f = r2.h;
        this.g = r2.i;
    }
}
