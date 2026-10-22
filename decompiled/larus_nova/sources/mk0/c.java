package mk0;

import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mb6.b.a f514279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f514280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f514281c;

    public c(GuestLinkPipeLineManager.b r100, long r101, long r102) {
        this.f514279a = r100;
        this.f514280b = r101;
        this.f514281c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        jy0.b.b("GuestLinkApiManager", "enterChannel failed", r101);
        com.bytedance.live.kmp.util.a.b(r101);
        mb6.b.a r102 = this.f514279a;
        if (r102 == null) goto L6;
        r102.o(dc6.a.a(this.f514280b), r101, this.f514281c);
        return;
    }
}
