package q3a;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<p> f531553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f531554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f531555c;

    public static final class a {
    }

    static {
    }

    public o() {
        this.f531553a = new CopyOnWriteArrayList();
        this.f531554b = PThreadExecutorsUtils.newSingleThreadExecutor(new h());
        this.f531555c = new AtomicBoolean(false);
    }

    public final void a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f531555c.get() == true) goto L6;
        this.f531553a.addIfAbsent(r100);
        FLogger.f375446a.d("CameraEventDispatcher", "Added listener: " + r100.getClass().getSimpleName() + ", total: " + this.f531553a.size());
        return;
    }

    public final void b(final r3a.i r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if (this.f531555c.get() == false) goto L5;
        return;
    L5:
        FLogger.f375446a.e("CameraEventDispatcher", "Dispatching error: " + r100.f535926a + " - " + r100.f535927b);
        c("dispatchError", new q3a.a(r100));
    }

    public final void e(final r3a.j r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        if (this.f531555c.get() == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("CameraEventDispatcher", "Dispatching frame captured: textureId=" + r100.f535929a);
        if (z2.f365865a.enableCameraFrameSyncDispatch() == false) goto L11;
        Function1<? super p, Unit> r101 = new n(r100);
        if (this.f531555c.get() == true) goto L14;
        d("onFrameCaptured", r101);
        return;
    L14:
        return;
    L11:
        c("onFrameCaptured", new b(r100));
    }

    public final void c(final String r100, final Function1<? super p, Unit> r101) {
        if (this.f531555c.get() == false) goto L5;
        return;
    L5:
        this.f531554b.submit(new j(this, r100, r101));
    }

    public final void d(String r100, Function1<? super p, Unit> r101) {
        if (this.f531555c.get() == false) goto L17;
        return;
    L17:
        Iterator<T> r102 = this.f531553a.iterator();     // Catch: Exception -> L14
    L6:
        if (r102.hasNext() == false) goto L25;
        p r103 = (p) r102.next();     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L11
        r101.invoke(r103);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        FLogger.f375446a.e("CameraEventDispatcher", "Error in listener=" + r103.o() + '.' + r100, e);     // Catch: Exception -> L14
        goto L6
    L25:
        return;
    L14:
        e = move-exception;
        FLogger.f375446a.e("CameraEventDispatcher", "Error dispatching event=" + r100, e);
    }
}
