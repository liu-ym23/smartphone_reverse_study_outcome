package ce5;

import android.app.Application;
import by4.d;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.k;
import e0c.l;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int h = 0;
    public final l a;
    public final UserSession b;
    public final NetService c;
    public final g d;
    public final h e;
    public final d f;
    public final BenefitManagerAPI g;

    /* JADX INFO: renamed from: ce5.a$a, reason: collision with other inner class name */
    public static final class C0009a implements d0c.c {
        public C0009a() {
        }

        public final void afterUserOffline(f0c.h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void afterUserOnline(f0c.h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final /* synthetic */ Object generatedComponent() {
            return DwarfComponentProvider.-CC.$default$generatedComponent(this);
        }

        public final /* synthetic */ m getPassport() {
            return d0c.b.a(this);
        }

        public final void onUserOffline(f0c.h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void onUserOnline(f0c.h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final UserSession e9() {
            return ((com.ss.android.lark.passportc.convention.a) k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();
        }

        public final l provideComponent() {
            UserSession r0 = e9();
            return ((v) k.a(LarkContext.getApplication(), v.class)).c(r0);
        }

        /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
        public final /* bridge */ /* synthetic */ Object m0provideComponent() {
            return provideComponent();
        }
    }

    public static final class b implements d0c.c {
        public final /* synthetic */ vo5.a a;

        public final void afterUserOffline(f0c.h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void afterUserOnline(f0c.h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final /* synthetic */ Object generatedComponent() {
            return DwarfComponentProvider.-CC.$default$generatedComponent(this);
        }

        public final /* synthetic */ m getPassport() {
            return d0c.b.a(this);
        }

        public final void onUserOffline(f0c.h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void onUserOnline(f0c.h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final UserSession e9() {
            return this.a.b();
        }

        public final l provideComponent() {
            UserSession r0 = e9();
            Application r1 = LarkContext.getApplication();
            Intrinsics.checkNotNull(r1);
            return ((v) k.a(r1, v.class)).c(r0);
        }

        /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
        public final /* bridge */ /* synthetic */ Object m1provideComponent() {
            return provideComponent();
        }

        public b(vo5.a r1) {
            this.a = r1;
        }
    }

    public static final class c {
    }

    static {
    }

    public a() {
        this(new C0009a());
    }

    public a(d0c.c r2) {
        Intrinsics.checkNotNullParameter(r2, "userScopeView");
        this.a = r2.provideComponent();
        this.b = r2.e9();
        this.c = (NetService) a(NetService.class);
        this.d = ((dn4.a) a(dn4.a.class)).a();
        this.e = (h) a(h.class);
        this.f = (d) a(d.class);
        this.g = (BenefitManagerAPI) a(BenefitManagerAPI.class);
    }

    public final <T> T a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "userScopeApi");
        return (T) k.b(this.a, r2);
    }

    public a(vo5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentDelegate");
        this(new b(r2));
    }
}
