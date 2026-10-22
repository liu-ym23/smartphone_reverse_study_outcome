package w3a;

import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.utils.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f558196a = null;

    static {
        f558196a = new e();
    }

    public e() {
    }

    @Override // w3a.g
    public final void b(final LarusFragmentInstantCallBaseBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        t0.e(new d(r100));
    }

    @Override // w3a.g
    public final void a(final LarusFragmentInstantCallBaseBinding r100, final e3a.a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "runtimeData");
        t0.e(new c(r101, r100));
    }
}
