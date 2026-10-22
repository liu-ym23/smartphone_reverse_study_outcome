package d40;

import a40.d;
import a40.k;
import a40.o;
import android.os.SystemClock;
import com.bytedance.android.live.cloudgrouplive.api.CloudGroupLiveApi;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.c;
import com.lynx.tasm.LynxError;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f466798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f466799b;

    /* JADX INFO: renamed from: d40.a$a, reason: collision with other inner class name */
    public static final class C5627a {
    }

    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f466800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f466801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f466802c;

        @Override // a40.o
        public final void a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        }

        @Override // a40.o
        public final void onPingSuccess() {
            a r100 = this.f466800a;
            r100.f466798a = Observable.timer(20, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new d40.b(this));
        }

        public b(a r100, long r101, long r102) {
            this.f466800a = r100;
            this.f466801b = r101;
            this.f466802c = r102;
        }
    }

    static {
    }

    public final void b() {
        int r100 = f40.a.f475503a;
        f40.a.d(CloudGroupLiveTraceEvent.PING_MANAGER, "stopPing", 0, null, 28);
        Disposable r101 = this.f466798a;
        if (r101 == null) goto L6;
        r101.dispose();
        return;
    }

    public a(k r100) {
        this.f466799b = r100;
    }

    public final void a(long r100, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "source");
        if (this.f466799b != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r111, "join_success") == false) goto L8;
        int r101 = f40.a.f475503a;
        f40.a.d(CloudGroupLiveTraceEvent.PING_MANAGER, "startPing", 0, "cloudGroupLiveRoomId=" + r100 + ", userRoomId=" + r110, 20);
    L8:
        ALogger.i("CloudGroupLivePingManager", "startPing source=".concat(r111));
        k r112 = this.f466799b;
        b r102 = new b(this, r100, r110);
        r112.getClass();
        long r103 = SystemClock.elapsedRealtime();
        RxUtilKt.c(((CloudGroupLiveApi) c.b().e(CloudGroupLiveApi.class)).cloudGroupLivePing(r100, r110).compose(RxUtil.rxSchedulerHelper()).subscribe(new a40.c(r102, r103), new d(r102, r103)), r112.f1731a);
    }
}
