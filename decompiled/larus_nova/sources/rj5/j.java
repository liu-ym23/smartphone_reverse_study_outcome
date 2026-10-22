package rj5;

import io.reactivex.Scheduler;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements nc5.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f538092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.contract.c0.a f538093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f538094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f538095d;

    @Override // nc5.a
    public final void onFailure(final Throwable r100) {
        Scheduler r101 = fo5.d.d();
        final com.bytedance.ee.bear.contract.c0.a r102 = this.f538093b;
        final String r103 = this.f538092a;
        final int r104 = this.f538094c;
        r101.scheduleDirect(new h(this, r100, r102, r103, r104));
    }

    @Override // nc5.a
    public final void onSuccess(Boolean r100) {
        final Boolean r101 = r100;
        Scheduler r102 = fo5.d.d();
        final String r103 = this.f538092a;
        final com.bytedance.ee.bear.contract.c0.a r104 = this.f538093b;
        final int r105 = this.f538094c;
        r102.scheduleDirect(new i(r101, r103, r104, r105));
    }

    public j(g r100, String r101, com.bytedance.ee.bear.contract.c0.a r102, int r103) {
        this.f538095d = r100;
        this.f538092a = r101;
        this.f538093b = r102;
        this.f538094c = r103;
    }
}
