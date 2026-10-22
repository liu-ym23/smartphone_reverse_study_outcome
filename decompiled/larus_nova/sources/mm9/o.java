package mm9;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements o37.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f514504a;

    @Override // o37.b
    public final void c() {
    }

    @Override // o37.b
    public final void d() {
    }

    @Override // o37.b
    public final void e() {
    }

    @Override // o37.b
    public final int a() {
        return ((Number) this.f514504a.getValue()).intValue();
    }

    @Override // o37.b
    public final n f() {
        return new n();
    }

    @Override // o37.b
    public Context getContext() {
        return AppHost.f326268a.getApplication();
    }

    @Override // o37.b
    public final Boolean getDebug() {
        return Boolean.valueOf(AppHost.f326268a.isDebug());
    }

    public o() {
        this.f514504a = LazyKt.lazy(new m());
    }

    @Override // o37.b
    public final PThreadPoolExecutor b() {
        return nm9.a.f519606a;
    }
}
