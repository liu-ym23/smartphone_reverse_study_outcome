package r56;

import com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostPureNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostRouterDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend;
import com.bytedance.ies.xbridge.utils.d;
import com.bytedance.ies.xbridge.utils.k;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f536312g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IHostLogDepend f536313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IHostContextDepend f536314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IHostStyleUIDepend f536315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IHostRouterDepend f536316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IHostNetworkDepend f536317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IHostPureNetworkDepend f536318f;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f536312g != null) goto L10;
        f536312g = this;     // Catch: Throwable -> L12
        Map<Class<? extends com.bytedance.ies.xbridge.utils.c>, com.bytedance.ies.xbridge.utils.c> r100 = k.f249565a;     // Catch: Throwable -> L12
        IHostLogDepend r101 = this.f536313a;     // Catch: Throwable -> L12
        if (r101 == null) goto L8;
        d r102 = r101.getLogService();     // Catch: Throwable -> L12
    L9:
        Intrinsics.checkNotNullParameter(d.class, "clazz");     // Catch: Throwable -> L12
        k.f249565a.put(d.class, r102);     // Catch: Throwable -> L12
        goto L10
    L8:
        r102 = null;
    L10:
        monitor-exit(this);
    }
}
