package dc0;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.e;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import mb0.d;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f467844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f467845b;

    public b(long r100, Function1 r101) {
        this.f467844a = r100;
        this.f467845b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        e r101 = (e) r100;
        d.b(LinkMonitorData.ApiGetTuningInfo, System.currentTimeMillis() - this.f467844a, r101.logId);
        this.f467845b.invoke(r101);
    }
}
