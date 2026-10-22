package sc5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements tk5.c {
    public final /* synthetic */ c a;

    public g(c r1) {
        this.a = r1;
    }

    @Override // tk5.c
    public final void a(tk5.d<? extends vk5.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "mission");
        tt5.a.h("HomeDriveOnBoarding", "open home drive page");
        this.a.e();
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.a.c);
    }

    @Override // tk5.c
    public final void b(tk5.d<? extends vk5.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "mission");
        tt5.a.h("HomeDriveOnBoarding", "home drive guide dismiss");
    }

    @Override // tk5.c
    public final void c(tk5.d<? extends vk5.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "mission");
        tt5.a.h("HomeDriveOnBoarding", "skip home drive guide");
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.a.c);
    }
}
