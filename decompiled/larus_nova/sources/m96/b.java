package m96;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.c;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f512652c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f512653b;

    static {
        f512652c = new b();
    }

    @Override // m96.a
    public final void B(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f512653b.B(r100, r101);
    }

    public b() {
        pd6.b r100 = c.f528682a;
        pd6.a r101 = c.a(Reflection.getOrCreateKotlinClass(a.class));
        Intrinsics.checkNotNull(r101);
        this.f512653b = (a) r101;
    }
}
