package d6;

import com.bytedance.als.LogicComponent;
import com.bytedance.als.monitor.ComponentLifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<ComponentLifecycle, Long> f467099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f467100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LogicComponent<?> f467101c;

    public b(LogicComponent<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f467101c = r100;
        this.f467099a = new HashMap();
    }

    public final void a(LogicComponent<?> r100, ComponentLifecycle r101, long r102) {
        if (this.f467099a.get(r101) != null) goto L5;
        this.f467099a.put(r101, Long.valueOf(r102));
    L5:
        int r103 = a.f467098a;
        Intrinsics.checkNotNullParameter(r100, "component");
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
    }
}
