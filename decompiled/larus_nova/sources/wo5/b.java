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

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f560522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f560523b;

    public static final class a implements d0c.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vo5.a f560524a;

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
        public final /* synthetic */ Object generatedComponent() {
            return DwarfComponentProvider.CC.$default$generatedComponent(this);
        }

        @Override // com.ss.android.lark.passportc.api.r
        public final /* synthetic */ m getPassport() {
            return d0c.b.a(this);
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // d0c.c
        public final UserSession e9() {
            return this.f560524a.b();
        }

        @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
        public final l provideComponent() {
            UserSession r100 = e9();
            return ((v) k.a(LarkContext.getApplication(), v.class)).c(r100);
        }

        @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
        public final /* bridge */ /* synthetic */ Object provideComponent() {
            return provideComponent();
        }

        public a(vo5.a r100) {
            this.f560524a = r100;
        }
    }

    /* JADX INFO: renamed from: wo5.b$b, reason: collision with other inner class name */
    public static final class C8141b {
    }

    static {
    }

    public b(d0c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "userScopeView");
        l r101 = r100.provideComponent();
        this.f560522a = r101;
        r100.e9();
        Intrinsics.checkNotNullParameter(dn4.a.class, "userScopeApi");
        this.f560523b = ((dn4.a) k.b(r101, dn4.a.class)).a();
    }

    public b(vo5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentDelegate");
        this(new a(r100));
    }
}
