package p2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.ref.SoftReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference<Handler> f527352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f527353b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f527354c = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f527355a;

        public final void a() {
            this.f527355a.run();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.ai.applet.base.log.b r100 = com.bytedance.ai.applet.base.log.a.f34518a;
            com.bytedance.ai.applet.base.log.a.b("SafeWrapper", "fail to execute runnable = " + this.f527355a + " error = " + Log.getStackTraceString(e), null);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.f527355a = r100;
        }
    }

    static {
        f527353b = LazyKt.lazy(new p2.a());
        f527354c = LazyKt.lazy(new b());
    }

    public static Handler a() {
        SoftReference<Handler> r100 = f527352a;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        Handler r101 = r100.get();
        if (r101 == null) goto L7;
        return r101;
    L7:
        Handler r102 = new Handler(Looper.getMainLooper());
        f527352a = new SoftReference(r102);
        return r102;
    }

    @JvmStatic
    public static final boolean b() {
        return Intrinsics.areEqual(a().getLooper(), Looper.myLooper());
    }

    @JvmStatic
    public static final void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        Lazy r101 = f527354c;
        if (Intrinsics.areEqual(((Handler) r101.getValue()).getLooper(), Looper.myLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        ((Handler) r101.getValue()).post(new a(r100));
    }

    @JvmStatic
    public static final void d(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(a().getLooper(), Looper.myLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        a().post(new a(r100));
    }

    @JvmStatic
    public static final void e(Runnable r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        a().postDelayed(r100, r101);
    }
}
