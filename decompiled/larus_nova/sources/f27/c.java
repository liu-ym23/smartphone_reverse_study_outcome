package f27;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements g27.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f475213a;

    public c(d r100) {
        this.f475213a = r100;
    }

    @Override // g27.a.b
    public final void a(long r100) {
        Map<AsyncTaskType, Long> r101 = this.f475213a.f475220d;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(AsyncTaskType.TIME_SENSITIVE, Long.valueOf(r100));
    }
}
