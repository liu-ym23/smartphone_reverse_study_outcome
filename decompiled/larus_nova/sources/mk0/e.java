package mk0;

import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mb6.b.InterfaceC6793b f514285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f514286b;

    public e(GuestLinkPipeLineManager.f r100, long r101) {
        this.f514285a = r100;
        this.f514286b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        jy0.b.b("GuestLinkApiManager", "finishChannel failed", r101);
        com.bytedance.live.kmp.util.a.b(r101);
        mb6.b.InterfaceC6793b r102 = this.f514285a;
        if (r102 == null) goto L6;
        r102.r(dc6.a.a(this.f514286b), r101);
        return;
    }
}
