package gd9;

import android.app.Application;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public interface l {

    /* JADX INFO: loaded from: classes29.dex */
    public static final class a {
        public static void a(final l r100, long r101) {
            ReentrantLock r102 = d0.f480963a;
            Function0 r103 = new j(r100);
            Intrinsics.checkNotNullParameter(r103, "elapsedRealtimeProvider");
            if (r101 == 0) goto L17;
            ReentrantLock r104 = d0.f480963a;
            r104.lock();
        L12:
            th = move-exception;
            r104.unlock();
            throw th;
        L7:
            if (d0.f480964b != null) goto L9;
            d0.f480964b = TuplesKt.to(r103.invoke(), Long.valueOf(r101));     // Catch: Throwable -> L12
        L9:
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L12
            r104.unlock();
            return;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public interface b {
        void onAppLifeCycleChange(boolean r100);
    }

    boolean a();

    int appId();

    String appName();

    boolean b();

    String c(CharSequence r100, boolean r101, boolean r102);

    String channel();

    long currentTimeMillis();

    void d(long r100);

    String e();

    long elapsedRealtime();

    int f();

    long g(String r100);

    Application getApplication();

    boolean h();

    String i();

    boolean isDebug();

    boolean isDebugChannel();

    void isOversea();

    void isPlugin();

    boolean isTestChannel();

    boolean j();

    boolean k();

    long l();

    String m();

    boolean n();

    boolean o();

    long p();

    void q(b r100);

    void r(b r100);
}
