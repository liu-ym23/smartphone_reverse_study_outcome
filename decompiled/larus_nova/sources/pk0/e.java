package pk0;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wb6.a.b f529549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f529550b;

    public e(com.bytedance.android.live.livelink.multilink.pipeline.c r100, long r101) {
        this.f529549a = r100;
        this.f529550b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        LinkMonitor.a("LinkApiM", "finish failed", null, null, null, false, 124);
        wb6.a.b r102 = this.f529549a;
        if (r102 == null) goto L6;
        r102.yp(dc6.a.a(this.f529550b), r101);
        return;
    }
}
