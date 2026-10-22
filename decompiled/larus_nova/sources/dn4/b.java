package dn4;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@UserScope
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f469318a;

    @Override // dn4.a
    public final g a() {
        return this.f469318a;
    }

    @Inject
    public b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "userFgService");
        this.f469318a = r100;
    }
}
