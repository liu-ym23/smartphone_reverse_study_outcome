package ee.android.framework.manis.base;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f472259d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, IInterface> f472260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Method> f472261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f472262c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f472263a = null;

        static {
            f472263a = new b();
        }
    }

    /* JADX INFO: renamed from: ee.android.framework.manis.base.b$b, reason: collision with other inner class name */
    public final class C5770b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f472264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f472265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IInterface f472266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f472267d;

        /* JADX INFO: renamed from: ee.android.framework.manis.base.b$b$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C5770b f472268a;

            public final void a() {
                StringBuilder r100 = new StringBuilder("ManisDeathRecipient retry connect service:");
                r100.append(this.f472268a.f472265b);
                r100.append(", uri:");
                Uri r101 = this.f472268a.f472264a;
                if (r101 != null) goto L5;
                String r102 = "null";
            L6:
                r100.append(r102);
                krc.b.c("ServiceFetcher", r100.toString());
                return;
            L5:
                r102 = r101.toString();
                goto L6
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

            public a(C5770b r100) {
                this.f472268a = r100;
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            if (this.f472266c != null) goto L5;
            return;
        L5:
            Object r100 = this.f472267d.f472262c;
            monitor-enter(r100);
            this.f472266c.asBinder().unlinkToDeath(this, 0);     // Catch: Throwable -> L10
            Map<String, IInterface> r101 = this.f472267d.f472260a;     // Catch: Throwable -> L10
            ConcurrentHashMap r102 = (ConcurrentHashMap) r101;     // Catch: Throwable -> L10
            r102.remove(this.f472265b);     // Catch: Throwable -> L10
            ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "ServiceFetcher$ManisDeathRecipient"));     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public C5770b(b r100, Uri r101, String r102, IInterface r103) {
            this.f472267d = r100;
            this.f472264a = r101;
            this.f472265b = r102;
            this.f472266c = r103;
        }
    }

    static {
        f472259d = new String[]{PullConfiguration.PROCESS_NAME_MAIN};
    }

    public b() {
        this.f472260a = new ConcurrentHashMap();
        this.f472261b = new HashMap();
        this.f472262c = new Object();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}
