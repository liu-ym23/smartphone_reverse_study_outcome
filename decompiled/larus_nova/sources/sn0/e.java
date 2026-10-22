package sn0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements b.InterfaceC7630b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f542629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ pn0.d f542630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ pn0.g f542631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f542632d;

    @Override // sn0.b.InterfaceC7630b
    public final void onFailed() {
        this.f542629a.d(this.f542630b.e(), "GeckoOfflineResProducer loadReviewList Failed");
        a r100 = this.f542629a.f542618a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r100.c(this.f542630b, this.f542631c);
    }

    @Override // sn0.b.InterfaceC7630b
    public final void onSuccess() {
        this.f542629a.d(this.f542630b.e(), "GeckoOfflineResProducer loadReviewList success");
        this.f542629a.e(this.f542630b, this.f542631c, this.f542632d);
    }

    public e(b r100, pn0.d r101, pn0.g r102, f r103) {
        this.f542629a = r100;
        this.f542630b = r101;
        this.f542631c = r102;
        this.f542632d = r103;
    }
}
