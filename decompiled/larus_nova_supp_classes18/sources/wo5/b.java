package wo5;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.k;
import e0c.l;
import f0c.h;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final l a;
    public final g b;

    public static final class a implements d0c.c {
        public final /* synthetic */ vo5.a a;

        public final void afterUserOffline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void afterUserOnline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final /* synthetic */ Object generatedComponent() {
            return DwarfComponentProvider.-CC.$default$generatedComponent(this);
        }

        public final /* synthetic */ m getPassport() {
            return d0c.b.a(this);
        }

        public final void onUserOffline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void onUserOnline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final UserSession e9() {
            return this.a.b();
        }

        public final l provideComponent() {
            UserSession r0 = e9();
            return ((v) k.a(LarkContext.getApplication(), v.class)).c(r0);
        }

        /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
        public final /* bridge */ /* synthetic */ Object m751provideComponent() {
            return provideComponent();
        }

        public a(vo5.a r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: wo5.b$b, reason: collision with other inner class name */
    public static final class C0327b {
    }

    static {
    }

    public b(d0c.c r3) {
        Intrinsics.checkNotNullParameter(r3, "userScopeView");
        l r0 = r3.provideComponent();
        this.a = r0;
        r3.e9();
        Intrinsics.checkNotNullParameter(dn4.a.class, "userScopeApi");
        this.b = ((dn4.a) k.b(r0, dn4.a.class)).a();
    }

    public b(vo5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentDelegate");
        this(new a(r2));
    }
}
