package g77;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends e implements Handler.Callback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile d f480246g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Method f480247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f480248f;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f480249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f480250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f480251c;

        public final void a() {
            d r100 = this.f480251c;     // Catch: Throwable -> L11
            r100.f480248f = this.f480249a.invoke(null, new Object[0]);     // Catch: Throwable -> L11
            Object r101 = this.f480250b;
            monitor-enter(r101);
            this.f480250b.notify();     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L12:
            monitor-enter(this.f480250b);
            this.f480250b.notify();     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
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

        public a(d r100, Method r101, Object r102) {
            this.f480251c = r100;
            this.f480249a = r101;
            this.f480250b = r102;
        }
    }

    @Override // g77.e
    public final synchronized boolean b() {
        monitor-enter(this);
    L23:
        th = move-exception;
        com.bytedance.push.utils.f.f(this.f480252a, "error when hook ActivityThread ", th);     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return false;
    L27:
        th = move-exception;
        throw th;
    L6:
        if (this.f480255d == false) goto L9;
        monitor-exit(this);
        return true;
    L9:
        Object r100 = e();     // Catch: Throwable -> L23
        this.f480248f = r100;     // Catch: Throwable -> L23
        if (r100 != null) goto L30;
        com.bytedance.push.utils.f.e(this.f480252a, "sActivityThread is null!");     // Catch: Throwable -> L23
        goto L25
    L30:
        Field r101 = com.bytedance.push.utils.b.e(r100.getClass(), "mH");     // Catch: Throwable -> L19
        r101.setAccessible(true);     // Catch: Throwable -> L19
        Handler r102 = (Handler) r101.get(this.f480248f);     // Catch: Throwable -> L19
        Field r103 = com.bytedance.push.utils.b.e(Handler.class, "mCallback");     // Catch: Throwable -> L19
        r103.setAccessible(true);     // Catch: Throwable -> L19
        Object r104 = r103.get(r102);     // Catch: Throwable -> L19
        if ((r104 instanceof d) == false) goto L16;
        com.bytedance.push.utils.f.i(this.f480252a, "not duplicate hook field because originCallback is ActivityThreadHooker");     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    L16:
        this.f480253b = r104;     // Catch: Throwable -> L19
        this.f480247e = com.bytedance.push.utils.b.f(Handler.Callback.class, "handleMessage", new Class[]{Message.class});     // Catch: Throwable -> L19
        r103.set(r102, this);     // Catch: Throwable -> L19
        com.bytedance.push.utils.f.b(this.f480252a, "success replace ActivityThread#H#mCallback");     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        com.bytedance.push.utils.f.f(this.f480252a, "error when replace ActivityThread#H#mCallback ", th);     // Catch: Throwable -> L23
        goto L25
    }

    @Override // g77.e
    public final String c() {
        return "ActivityThreadHooker";
    }

    public final synchronized Object e() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f480248f == null) goto L32;
    L20:
        Object r100 = this.f480248f;     // Catch: Throwable -> L23
        monitor-exit(this);
        return r100;
    L32:
        Method r101 = com.bytedance.push.utils.b.f(d(), "currentActivityThread", new Class[0]);     // Catch: Throwable -> L18
        r101.setAccessible(true);     // Catch: Throwable -> L18
        Object r102 = r101.invoke(null, new Object[0]);     // Catch: Throwable -> L18
        this.f480248f = r102;     // Catch: Throwable -> L18
        if (r102 != null) goto L20;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L20;
        Object r103 = new Object();     // Catch: Throwable -> L18
        new Handler(Looper.getMainLooper()).post(new a(this, r101, r103));     // Catch: Throwable -> L18
        if (this.f480248f != null) goto L20;
        monitor-enter(r103);     // Catch: Throwable -> L18
        r103.wait();     // Catch: Throwable -> L26
    L30:
        monitor-exit(r103);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L23
        goto L20
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static d f() {
        if (f480246g != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f480246g != null) goto L9;
        f480246g = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f480246g;
    }

    public d() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        com.bytedance.push.utils.f.b(this.f480252a, "handleMessage:" + r100.what);
        Object r101 = invoke(this.f480253b, this.f480247e, new Object[]{r100});     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return false;
    L6:
        return ((Boolean) r101).booleanValue();
    L8:
        th = move-exception;
        throw new RuntimeException(th);
    }
}
