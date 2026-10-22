package q1b;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f531317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f531318b;

    @Override // q1b.a
    public final l g() {
        return this.f531318b;
    }

    @Override // q1b.a
    public final m r9() {
        return this.f531317a;
    }

    @Inject
    public c(m r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "p");
        Intrinsics.checkNotNullParameter(r101, "r");
        this.f531317a = r100;
        this.f531318b = r101;
    }
}
