package o48;

import kotlin.jvm.internal.Intrinsics;
import n38.p;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u64.a f521985a;

    public b(u64.a r100) {
        this.f521985a = r100;
    }

    @Override // n38.p
    public final void a(n38.e r100) {
        Intrinsics.checkNotNullParameter(r100, "oouYinTokenResult");
        this.f521985a.a(c.a(r100));
    }

    @Override // n38.p
    public final void onFail(int r100) {
        this.f521985a.onFail(r100);
    }
}
