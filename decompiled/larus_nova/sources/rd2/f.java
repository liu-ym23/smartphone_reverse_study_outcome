package rd2;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f537216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f537217b;

    public f(long r100, Function1 r101) {
        this.f537216a = r100;
        this.f537217b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        mb0.c.a.b(pd2.d.f528658n, LinkMonitorData.ApiListenSongList, System.currentTimeMillis() - this.f537216a, r101.logId);
        this.f537217b.invoke(r101);
    }
}
