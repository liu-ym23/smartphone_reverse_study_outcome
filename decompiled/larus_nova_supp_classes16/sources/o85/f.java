package o85;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements vo5.a {
    public final UserSession a;

    public final UserSession b() {
        return this.a;
    }

    @Inject
    public f(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, "usersession");
        this.a = r2;
    }

    public final <T> T a(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "userScopeApi");
        UserSession r0 = this.a;
        return (T) k.b(((v) k.a(LarkContext.getApplication(), v.class)).c(r0), r4);
    }
}
