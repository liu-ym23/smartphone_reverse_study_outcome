package ny3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements p24.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f521200a;

    public f(h.a r100) {
        this.f521200a = r100;
    }

    @Override // r34.e
    public final void onFail(Exception r100) {
        h.a r101 = this.f521200a;
        r101.f521205b.O1(r101.f521204a, 0);
    }

    @Override // r34.e
    public final void onSuccess(o14.f r100) {
        o14.f r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f521200a.a(r101, false);
    }
}
