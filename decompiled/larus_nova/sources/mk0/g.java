package mk0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mb6.b.c f514289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f514290b;

    public g(com.bytedance.android.live.livelink.guestlink.pipeline.a r100, long r101) {
        this.f514289a = r100;
        this.f514290b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        jy0.b.b("GuestLinkApiManager", "joinChannel failed", r101);
        com.bytedance.live.kmp.util.a.b(r101);
        mb6.b.c r102 = this.f514289a;
        if (r102 == null) goto L6;
        r102.o1(dc6.a.a(this.f514290b), r101);
        return;
    }
}
