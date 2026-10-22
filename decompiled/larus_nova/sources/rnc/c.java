package rnc;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f538747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f538748b;

    static {
        f538747a = new c();
    }

    public c() {
    }

    @Override // rnc.d
    public final List<com.suite.lark.component.navroute.api.b<?>> a(com.suite.lark.component.navroute.api.d r100) {
        Intrinsics.checkNotNullParameter(r100, "graph");
        d r101 = f538748b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("repository");
        r101 = null;
    L6:
        return r101.a(r100);
    }
}
