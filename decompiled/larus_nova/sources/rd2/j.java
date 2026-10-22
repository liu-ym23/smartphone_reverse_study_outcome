package rd2;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f537224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f537225b;

    public j(long r100, Function1 r101) {
        this.f537224a = r100;
        this.f537225b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        mb0.c.a.b(pd2.d.f528658n, LinkMonitorData.ApiGetSongWaitingList, System.currentTimeMillis() - this.f537224a, r101.logId);
        this.f537225b.invoke(r101);
    }
}
