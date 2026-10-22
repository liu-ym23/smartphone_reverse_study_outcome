package si0;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f542089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f542090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f542091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f542092d;

    /* JADX INFO: renamed from: si0.a$a, reason: collision with other inner class name */
    public static final class C7611a {
    }

    public interface b {
        void a();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f542093a;

        public c(a r100) {
            this.f542093a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("CustomVideoMixerDetector", "detectFirstFrameTask run");     // Catch: Throwable -> L6
            this.f542093a.getClass();     // Catch: Throwable -> L6
            ALogger.e("CustomVideoMixerDetector", "detectFirstFrameTask failed");     // Catch: Throwable -> L6
            b r100 = this.f542093a.f542090b;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public a() {
        this.f542089a = ((Number) vm2.d.f555950r3.getValue(null, vm2.d.f555776a[223(0xdf, float:3.12E-43)])).intValue();
        this.f542091c = new Handler(Looper.getMainLooper());
        this.f542092d = new c(this);
    }
}
