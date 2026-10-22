package en6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements lq6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f473169a = null;

    static {
        f473169a = new e();
    }

    public e() {
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HostServiceUtilsKt.k().d(r100, r101);
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HostServiceUtilsKt.k().e(r100, r101);
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HostServiceUtilsKt.k().i(r100, r101);
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HostServiceUtilsKt.k().w(r100, r101);
    }
}
