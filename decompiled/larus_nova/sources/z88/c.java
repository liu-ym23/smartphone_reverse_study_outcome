package z88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements y88.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f570959b;

    @Override // y88.d
    public final y88.a X1() {
        return this.f570959b.f570953b.invoke().X1();
    }

    @Override // y88.d
    public final void j1() {
        this.f570959b.f570953b.invoke().j1();
    }

    public c(b r100) {
        this.f570959b = r100;
    }

    @Override // y88.d
    public final void X(int r100) {
        this.f570959b.f570953b.invoke().X(r100);
    }

    @Override // y88.d
    public final void j2(int r100) {
        this.f570959b.f570953b.invoke().j2(r100);
    }

    @Override // y88.d
    public final void k1(int r100) {
        this.f570959b.f570953b.invoke().k1(r100);
    }

    @Override // y88.d
    public final void log(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f570959b.f570953b.invoke().log(r100);
    }

    @Override // y88.d
    public final void k(boolean r100, int r101) {
        this.f570959b.f570953b.invoke().k(r100, r101);
    }

    @Override // y88.d
    public final void trackEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter("dora_avlink_timeout", "event");
        Intrinsics.checkNotNullParameter(r101, "paramsJson");
        this.f570959b.f570953b.invoke().trackEvent("dora_avlink_timeout", r101);
    }

    @Override // y88.d
    public final void v1(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "paramsJson");
        this.f570959b.f570953b.invoke().v1(r100, r101);
    }
}
