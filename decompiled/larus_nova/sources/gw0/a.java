package gw0;

import com.bytedance.android.live.recharge.platform.service.RechargeConfigService;
import com.bytedance.android.live.recharge.utils.f;
import com.bytedance.android.livesdk.revenue.log.d;
import com.bytedance.android.scope.o;
import hx0.b;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RechargeConfigService f483000a;

    /* JADX INFO: renamed from: gw0.a$a, reason: collision with other inner class name */
    public static final class C6074a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6074a f483001a = null;

        public C6074a() {
        }

        static {
            f483001a = new C6074a();
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RechargeConfigService r100 = this.f483000a;
        b r101 = new b();
        r100.getClass();
        Intrinsics.checkNotNullParameter(b.class, "key");
        Intrinsics.checkNotNullParameter(r101, "logFilter");
        HashMap<Class<?>, d<?>> r102 = f.f90457a;
        Intrinsics.checkNotNullParameter(b.class, "logClass");
        Intrinsics.checkNotNullParameter(r101, "filter");
        f.f90457a.put(b.class, r101);
    }

    public a(RechargeConfigService r100) {
        Intrinsics.checkNotNullParameter(r100, "rechargeConfigService");
        this.f483000a = r100;
    }
}
