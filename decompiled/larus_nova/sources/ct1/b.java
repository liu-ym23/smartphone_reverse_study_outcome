package ct1;

import android.content.Context;
import android.os.CountDownTimer;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f465298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f465299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CountDownTimerC5582b f465300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f465301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveNetworkBroadcastReceiver f465302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f465303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f465304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f465305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f465306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f465307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.livesdk.coupon.expandcoupon.model.c f465308k;

    public static final class a {
    }

    /* JADX INFO: renamed from: ct1.b$b, reason: collision with other inner class name */
    public static final class CountDownTimerC5582b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f465309a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            b r100 = this.f465309a;
            r100.f465301d = 3;
            f r101 = r100.f465298a;
            if (r101 == null) goto L6;
            r101.onFinish();
            return;
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
            b r101 = this.f465309a;
            long r102 = r100 / 1000;
            r101.f465299b = r102;
            f r103 = r101.f465298a;
            if (r103 == null) goto L6;
            r103.onTick(r102);
            return;
        }

        public CountDownTimerC5582b(b r100, long r101) {
            this.f465309a = r100;
            super(r101, 1000);
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f465306i;
    }

    @Override // ct1.e
    public final long getRemainTime() {
        return this.f465299b;
    }

    @Override // ct1.e
    public final int getState() {
        return this.f465301d;
    }

    @Override // ct1.e
    public final long getTaskKey() {
        return this.f465307j;
    }

    public final void a(long r100) {
        if (NetworkUtils.f(this.f465306i) == true) goto L5;
        return;
    L5:
        if (this.f465303f == false) goto L8;
        return;
    L8:
        if (r100 > 0) goto L10;
        return;
    L10:
        CountDownTimerC5582b r101 = new CountDownTimerC5582b(this, r100 * 1000);
        this.f465300c = r101;
        r101.start();
        this.f465301d = 1;
    }

    public final void b(bt1.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f465298a = r100;
    }

    public b(Context r100, com.bytedance.android.livesdk.coupon.expandcoupon.model.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f465306i = r100;
        this.f465307j = 1;
        this.f465308k = r101;
        this.f465299b = r101.a();
        this.f465302e = new LiveNetworkBroadcastReceiver();
        this.f465304g = new d(this);
        this.f465305h = new c(this);
    }
}
