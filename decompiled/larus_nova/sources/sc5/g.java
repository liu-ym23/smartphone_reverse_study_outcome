package sc5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements tk5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f541357a;

    public g(c r100) {
        this.f541357a = r100;
    }

    @Override // tk5.c
    public final void a(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        tt5.a.h("HomeDriveOnBoarding", "open home drive page");
        this.f541357a.e();
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.f541357a.f541349c);
    }

    @Override // tk5.c
    public final void b(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        tt5.a.h("HomeDriveOnBoarding", "home drive guide dismiss");
    }

    @Override // tk5.c
    public final void c(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        tt5.a.h("HomeDriveOnBoarding", "skip home drive guide");
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.f541357a.f541349c);
    }
}
