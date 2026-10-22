package n3c;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements ne6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f517015a = null;

    static {
        f517015a = new b();
    }

    public b() {
    }

    @Override // ne6.a
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter("PolicyEngine", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        ScsLogger.a("PolicyEngine", r100);
    }

    @Override // ne6.a
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter("PolicyEngine", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        ScsLogger.e("PolicyEngine", r100);
    }

    @Override // ne6.a
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        ScsLogger.c(r100, r101);
    }

    @Override // ne6.a
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        ScsLogger.d(r100, r101);
    }
}
