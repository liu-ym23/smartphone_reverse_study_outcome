package zo0;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.livesdk.config.ae0;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.Objects;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f573080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f573081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PerformanceScene f573082c;

    public interface a {
        void d(PerformanceScene r100);

        void e(PerformanceScene r100, long r101, double r102, JSONObject r103);
    }

    /* JADX INFO: renamed from: zo0.b$b, reason: collision with other inner class name */
    public static final class C8480b implements IStallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f573083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f573084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f573085c;

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onFpsReady(double r100, JSONObject r110) {
            if (v.a() == false) goto L5;
            Objects.toString(this.f573083a.f573082c);
            Objects.toString(r110);
        L5:
            a r101 = this.f573084b;
            if (r101 == null) goto L9;
            r101.e(this.f573083a.f573082c, this.f573085c, r100, r110);
            return;
        }

        public C8480b(b r100, a r101, long r102) {
            this.f573083a = r100;
            this.f573084b = r101;
            this.f573085c = r102;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onBlockReady(long r100, int r101, long r102) {
            if (v.a() == false) goto L5;
            Objects.toString(this.f573083a.f573082c);
        L5:
            a r103 = this.f573084b;
            if (r103 == null) goto L9;
            r103.d(this.f573083a.f573082c);
            return;
        }
    }

    public final void a() {
        if (this.f573080a == false) goto L5;
        return;
    L5:
        if (ae0.f119782a.getValue().booleanValue() == false) goto L13;
        this.f573080a = true;
        this.f573081b = SystemClock.uptimeMillis();
        IPerformanceManager r100 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r100 == null) goto L12;
        r100.startMonitorFps(this.f573082c.getValue());
        return;
    L12:
        return;
    }

    public b(PerformanceScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f573082c = r100;
    }

    public final void b(a r100) {
        if (this.f573080a == true) goto L5;
        return;
    L5:
        this.f573080a = false;
        long r101 = SystemClock.uptimeMillis() - this.f573081b;
        IPerformanceManager r102 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r102 == null) goto L9;
        r102.stopMonitorFps(this.f573082c.getValue(), new C8480b(this, r100, r101));
        r102.releaseFpsMonitor(this.f573082c.getValue());
        return;
    }
}
