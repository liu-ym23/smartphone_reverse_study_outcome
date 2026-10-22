package hz5;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.collection.ArraySet;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Set<b>> f487698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f487699b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f487700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static j f487701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f487702e = null;

    public static final class a extends Handler {
        public a(Looper r100) {
            super(r100);
        }

        public static void a(Message r100) {
            Object r101 = r100.obj;
            List<i> r102 = null;
            if ((r101 instanceof f) == true) goto L5;
            r101 = null;
        L5:
            f r103 = (f) r101;
            if (r103 == null) goto L23;
            Set r104 = (Set) ((HashMap) l.f487698a).get(r103.getTag());
            if ((r103 instanceof PrivacyEvent) == false) goto L18;
            PrivacyEvent r105 = (PrivacyEvent) r103;
            g.f487690b.a(5, r105);
            if (r105.D != null) goto L18;
            j r106 = l.f487701d;
            if (r106 == null) goto L14;
            r102 = r106.getJsbEvents();
        L14:
            if (r102 == null) goto L18;
            if ((!r102.isEmpty()) != true) goto L18;
            r105.E = r102;
            r105.D = PrefetchTiming.JSB;
        L18:
            if (r104 == null) goto L25;
            Iterator r107 = r104.iterator();
        L21:
            if (r107.hasNext() == false) goto L26;
            ((b) r107.next()).b(r103);
            goto L21
        L26:
            return;
        L25:
            return;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            a(r100);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Object r101 = r100.obj;
            if (r101 == null) goto L15;
            if ((!Intrinsics.areEqual(((f) r101).getTag(), "ExceptionEvent")) == false) goto L18;
            b r102 = l.f487700c;
            if (r102 == null) goto L19;
            r102.b(new iz5.b(ThreadMethodProxy.currentThread(), th, "Reporter", null, 24));
            return;
        L19:
            return;
        L18:
            return;
        L15:
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.consumer.Event");
        }
    }

    public l() {
    }

    static {
        f487702e = new l();
        f487698a = new HashMap();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("helios.consumer", 0);
        ThreadMethodProxy.start(r100);
        r100.setUncaughtExceptionHandler(iz5.a.f496698a);
        f487699b = new a(r100.getLooper());
    }

    @JvmStatic
    public static final void b(f r100) {
        Message r101 = Message.obtain();
        r101.what = 1000;
        r101.obj = r100;
        f487699b.sendMessageDelayed(r101, 0);
    }

    public final synchronized void a(b r100) {
        monitor-enter(this);
        String r101 = r100.a();     // Catch: Throwable -> L12
        k.d("Reporter", "addConsumer " + r101 + " --> " + r100);     // Catch: Throwable -> L12
        Map<String, Set<b>> r102 = f487698a;     // Catch: Throwable -> L12
        Set r103 = (Set) ((HashMap) r102).get(r101);     // Catch: Throwable -> L12
        if (r103 != null) goto L7;
        r103 = new ArraySet();     // Catch: Throwable -> L12
    L7:
        r103.add(r100);     // Catch: Throwable -> L12
        ((HashMap) r102).put(r101, r103);     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r101, "ExceptionEvent") == false) goto L10;
        f487700c = r100;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
