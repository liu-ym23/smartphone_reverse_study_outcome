package ko1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.ViewConfiguration;
import com.bytedance.android.livesdk.config.LiveGestureConfig;
import com.bytedance.android.livesdk.config.qy;
import com.bytedance.common.utility.reflect.Reflect;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f504384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveGestureConfig f504385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f504386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f504387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f504388e;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f504389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f504390b;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f504390b.handleMessage(r100);
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (this.f504389a.f504385b.b() == false) goto L21;
            if (this.f504389a.f504384a == false) goto L21;
            if (Intrinsics.areEqual(r100.getCallback(), this.f504389a.f504388e) == true) goto L21;
            if (r100.what != 2) goto L21;
            if ((r101 - SystemClock.uptimeMillis()) <= 100) goto L21;
            int r102 = this.f504389a.f504385b.a();
            int r103 = this.f504389a.f504386c;
            if (r102 <= r103) goto L21;
            r101 = r101 + ((long) (r102 - r103));
        L21:
            return super.sendMessageAtTime(r100, r101);
        }

        public a(d r100, Handler r101, Looper r102) {
            this.f504389a = r100;
            this.f504390b = r101;
            super(r102);
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f504391a;

        public c(d r100) {
            this.f504391a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f504391a.f504384a = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public d(GestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        this.f504385b = qy.f121091a.getValue();
        this.f504386c = ViewConfiguration.getLongPressTimeout();
        Reflect r101 = Reflect.on(r100);     // Catch: Exception -> L15
        if (r101 != null) goto L7;
        Handler r102 = null;
    L9:
        if (r102 == null) goto L13;
        a r103 = new a(this, r102, r102.getLooper());     // Catch: Exception -> L15
        this.f504387d = r103;     // Catch: Exception -> L15
        if (r101 == null) goto L13;
        r101.set("mHandler", r103);     // Catch: Exception -> L15
        goto L13
    L7:
        r102 = (Handler) r101.get("mHandler", new Class[0]);     // Catch: Exception -> L15
    L13:
        this.f504388e = new c(this);
    }
}
