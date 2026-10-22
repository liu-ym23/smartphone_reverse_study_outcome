package y06;

import bolts.Task;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.sync.SyncSDK;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f565585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Long f565586b;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<V> f565587a = null;

        static {
            f565587a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            c r100 = c.f565585a;
            BulletLogger.d("BulletByteSyncManager： initByteSync");
            com.bytedance.sync.a.C3779a r101 = new com.bytedance.sync.a.C3779a(39);
            r101.a(d.f565588a);
            SyncSDK.registerBusiness(r101.b());
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public c() {
    }

    static {
        f565585a = new c();
        Task.callInBackground(a.f565587a);
    }
}
