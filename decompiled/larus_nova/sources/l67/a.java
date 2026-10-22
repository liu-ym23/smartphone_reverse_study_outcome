package l67;

import android.content.Context;
import android.os.Looper;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f507734b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f507735a;

    /* JADX INFO: renamed from: l67.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes21.dex */
    public class RunnableC6656a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f507736a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f507736a.c();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            Context r101 = this.f507736a.f507735a;     // Catch: Throwable -> L6
            r100.c();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC6656a(a r100) {
            this.f507736a = r100;
        }
    }

    public final synchronized b c() {
        monitor-enter(this);
        Class r100 = a();     // Catch: Throwable -> L6
        b r101 = (b) r100.getMethod("inst", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L7:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.a.b.AKeeperImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.a.b.AKeeperImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.a.b.AKeeperImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.a.b.AKeeperImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.a.b.AKeeperImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.a.b.AKeeperImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.a.b.AKeeperImpl");
    }

    public final void b() {
        RunnableC6656a r100 = new RunnableC6656a(this);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        ThreadPlus.submitRunnable(r100);
        return;
    L5:
        r100.run();
    }

    public a(Context r100) {
        this.f507735a = r100.getApplicationContext();
        PushThreadHandlerManager.inst().getHandler();
    }

    public static a d(Context r100) {
        if (f507734b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f507734b != null) goto L9;
        f507734b = new a(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f507734b;
    }
}
