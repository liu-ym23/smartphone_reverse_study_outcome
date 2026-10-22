package pk0;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f529563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f529564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ wb6.a.e f529565c;

    public l(String r100, long r101, com.bytedance.android.live.livelink.multilink.pipeline.d r102) {
        this.f529563a = r100;
        this.f529564b = r101;
        this.f529565c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        LinkMonitor.a("LinkApiM", "leaveChannel failed " + r101, null, null, null, false, 124);
        InteractLinkFullLinkMonitor.w(this.f529563a, dc6.a.a(this.f529564b), r101);
        wb6.a.e r102 = this.f529565c;
        if (r102 == null) goto L6;
        r102.F2(dc6.a.a(this.f529564b), r101);
        return;
    }
}
