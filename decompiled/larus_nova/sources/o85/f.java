package o85;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements vo5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserSession f522384a;

    @Override // vo5.a
    public final UserSession b() {
        return this.f522384a;
    }

    @Inject
    public f(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, "usersession");
        this.f522384a = r100;
    }

    @Override // vo5.a
    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "userScopeApi");
        UserSession r101 = this.f522384a;
        return (T) k.b(((v) k.a(LarkContext.getApplication(), v.class)).c(r101), r100);
    }
}
