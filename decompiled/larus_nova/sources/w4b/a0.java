package w4b;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class a0 implements c.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.m f558283a;

    @Override // w4b.c.o
    public final String Fc() {
        return this.f558283a.getUser().getSession();
    }

    @Override // w4b.c.o
    public final String fe() {
        return this.f558283a.getUser().getTenantId();
    }

    @Override // w4b.c.o
    public final String userId() {
        return this.f558283a.getUser().userId;
    }

    @Inject
    public a0(com.ss.android.lark.passportc.api.m r100) {
        Intrinsics.checkNotNullParameter(r100, "userService");
        this.f558283a = r100;
    }
}
