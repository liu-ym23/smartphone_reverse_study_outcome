package f27;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g27.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f475212a;

    public b(d r100) {
        this.f475212a = r100;
    }

    @Override // g27.a.b
    public final void a(long r100) {
        Map<AsyncTaskType, Long> r101 = this.f475212a.f475220d;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(AsyncTaskType.LIGHT_WEIGHT, Long.valueOf(r100));
    }
}
