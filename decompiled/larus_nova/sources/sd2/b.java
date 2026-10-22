package sd2;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f541429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f541430b;

    public b(long r100, Function1 r101) {
        this.f541429a = r100;
        this.f541430b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        mb0.d.b(LinkMonitorData.ApiKtvListActivityStatus, System.currentTimeMillis() - this.f541429a, r101.logId);
        this.f541430b.invoke(r101);
    }
}
