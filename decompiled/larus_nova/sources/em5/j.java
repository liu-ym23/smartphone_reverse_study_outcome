package em5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends cpc.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f473093e;

    @Override // cpc.a
    public final void c() {
        this.f473093e = false;
    }

    public j() {
        Intrinsics.checkNotNullParameter("doc/my_own", "id");
        super("doc/my_own");
    }

    @Override // cpc.a
    public final boolean a() {
        return this.f473093e;
    }
}
