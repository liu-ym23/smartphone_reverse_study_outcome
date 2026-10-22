package vo5;

import com.ss.android.lark.passportc.entity.UserSession;
import d0c.c;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f556506a;

    @Override // vo5.a
    public final UserSession b() {
        return this.f556506a.e9();
    }

    public b(c r100) {
        this.f556506a = r100;
    }

    @Override // vo5.a
    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "userScopeApi");
        return (T) k.b(this.f556506a.provideComponent(), r100);
    }
}
