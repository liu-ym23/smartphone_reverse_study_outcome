package rd2;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f537208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f537209b;

    public b(long r100, Function1 r101) {
        this.f537208a = r100;
        this.f537209b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        mb0.c.a.b(pd2.d.f528658n, LinkMonitorData.ApiWantToListen, System.currentTimeMillis() - this.f537208a, r101.logId);
        this.f537209b.invoke(r101);
    }
}
