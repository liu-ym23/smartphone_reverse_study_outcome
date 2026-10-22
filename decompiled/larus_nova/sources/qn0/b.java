package qn0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f533985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ pn0.d f533986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ pn0.g f533987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f533988d;

    @Override // qn0.a.b
    public final void onFailed() {
        this.f533985a.d(this.f533986b.e(), "GeckoOfflineResProducer loadReviewList Failed");
        sn0.a r100 = this.f533985a.f533981a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r100.c(this.f533986b, this.f533987c);
    }

    @Override // qn0.a.b
    public final void onSuccess() {
        this.f533985a.d(this.f533986b.e(), "GeckoOfflineResProducer loadReviewList success");
        this.f533985a.f(this.f533986b, this.f533987c, this.f533988d);
    }

    public b(a r100, pn0.d r101, pn0.g r102, c r103) {
        this.f533985a = r100;
        this.f533986b = r101;
        this.f533987c = r102;
        this.f533988d = r103;
    }
}
