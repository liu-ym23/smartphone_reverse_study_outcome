package vo5;

import com.ss.android.lark.passportc.entity.UserSession;
import d0c.c;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements a {
    public final /* synthetic */ c a;

    @Override // vo5.a
    public final UserSession b() {
        return this.a.e9();
    }

    public b(c r1) {
        this.a = r1;
    }

    @Override // vo5.a
    public final <T> T a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "userScopeApi");
        return (T) k.b(this.a.provideComponent(), r2);
    }
}
