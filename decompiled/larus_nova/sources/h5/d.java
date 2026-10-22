package h5;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f483816a;

    public d(String r100) {
        this.f483816a = r100;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f37145f = this.f483816a;
    }
}
