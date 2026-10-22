package y4c;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f566171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f566172b;

    @Override // y4c.a
    public final void destroy() {
    }

    @Override // y4c.a
    public final l g() {
        return this.f566172b;
    }

    @Inject
    public c(l r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        this.f566171a = r100;
        this.f566172b = r100;
    }
}
