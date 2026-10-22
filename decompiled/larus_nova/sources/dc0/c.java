package dc0;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import mb0.d;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f467846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f467847b;

    public c(long r100, Function1 r101) {
        this.f467846a = r100;
        this.f467847b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        d.a(LinkMonitorData.ApiGetTuningInfo, System.currentTimeMillis() - this.f467846a, r101);
        ExceptionUtils.handleException(s1.getContext(), r101);
        this.f467847b.invoke(r101);
    }
}
