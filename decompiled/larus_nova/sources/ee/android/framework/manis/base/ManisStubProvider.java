package ee.android.framework.manis.base;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ManisStubProvider extends ContentProvider {
    private static final int BLOCK_COUNT_LIMIT = 3;
    private static final String KEY_CLASS = "class";
    private static final String STUB_SUFFIX = "Stub";
    protected static final String TAG = "ManisManager";
    private final long WAIT_TIMEOUT_MILL;
    protected Map<String, IBinder> mBinderMaps;
    private AtomicInteger mBinderThreadCount;
    private volatile ClassLoader mClassLoader;
    private volatile long mStart;

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    public ManisStubProvider() {
        this.WAIT_TIMEOUT_MILL = 4000;
        this.mClassLoader = null;
        this.mBinderMaps = new HashMap();
        this.mStart = 0;
        this.mBinderThreadCount = new AtomicInteger(0);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mStart = System.currentTimeMillis();
        return true;
    }

    private void reportTooBlockingBinderThread(int r100) {
        RuntimeException r101 = new RuntimeException("BlockingQuery");
        r101.fillInStackTrace();
        if (r100 <= 3) goto L6;
        krc.b.b(TAG, "query thread waiting count:" + r100, r101);
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_ee_android_framework_manis_base_ManisStubProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public IBinder getBinderByClass(Uri r110, String r111) {
        IBinder r100 = this.mBinderMaps.get(r111);
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.mClassLoader != null) goto L8;
        this.mClassLoader = getContext().getClassLoader();
    L8:
        krc.b.c(TAG, "getBinderByClass  className:" + r111 + ", classLoader:" + this.mClassLoader.toString());
        monitor-enter(this);
        IBinder r101 = this.mBinderMaps.get(r111);     // Catch: Throwable -> L34
        if (r101 == null) goto L38;
        monitor-exit(this);     // Catch: Throwable -> L34
        return r101;
    L38:
        IBinder r102 = (IBinder) INVOKEVIRTUAL_ee_android_framework_manis_base_ManisStubProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.mClassLoader, r111).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext().getApplicationContext()});     // Catch: InvocationTargetException -> L21 NoSuchMethodException -> L23 ClassNotFoundException -> L25 InstantiationException -> L27 IllegalAccessException -> L29 Throwable -> L34
        if (r102 == null) goto L19;
        this.mBinderMaps.put(r111, r102);     // Catch: InvocationTargetException -> L21 NoSuchMethodException -> L23 ClassNotFoundException -> L25 InstantiationException -> L27 IllegalAccessException -> L29 Throwable -> L34
        monitor-exit(this);     // Catch: Throwable -> L34
        return r102;
    L19:
        krc.b.a(TAG, "ERROR: create binder <" + r111 + "> failed for uri:" + r110.toString());     // Catch: InvocationTargetException -> L21 NoSuchMethodException -> L23 ClassNotFoundException -> L25 InstantiationException -> L27 IllegalAccessException -> L29 Throwable -> L34
    L31:
        monitor-exit(this);     // Catch: Throwable -> L34
        krc.b.a(TAG, "ERROR: getBinderByClass failed for uri:" + r110.toString());
        return null;
    L23:
        e = move-exception;
        krc.b.b(TAG, "ERROR: create binder <" + r111 + "> NoSuchMethodException! has no constructor! for uri:" + r110.toString(), e);     // Catch: Throwable -> L34
    L29:
        e = move-exception;
        krc.b.b(TAG, "ERROR: create binder <" + r111 + "> class illegalAccessException! for uri:" + r110.toString(), e);     // Catch: Throwable -> L34
    L25:
        e = move-exception;
        krc.b.b(TAG, "ERROR: create binder <" + r111 + "> class not found! for uri:" + r110.toString(), e);     // Catch: Throwable -> L34
    L27:
        e = move-exception;
        krc.b.b(TAG, "ERROR: create binder <" + r111 + "> class instantiation failed! for uri:" + r110.toString(), e);     // Catch: Throwable -> L34
    L21:
        e = move-exception;
        krc.b.b(TAG, "ERROR: create binder <" + r111 + "> InvocationTargetException! invoke constructor exception! for uri:" + r110.toString(), e);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r110, String[] r111, String r112) {
        if (r100 != null) goto L5;
        return null;
    L5:
        long r102 = System.currentTimeMillis() - this.mStart;
        String r103 = "query called. start: " + this.mStart + " diff:" + r102 + ", current thread:" + ThreadMethodProxy.currentThread().getName();
        if (krc.b.f505900a == null) goto L9;
        Log.d(TAG, r103);
    L9:
        krc.b.c(TAG, "query service" + getClass().getName() + " uri: " + r100.toString() + " in process:" + lrc.b.a(getContext()));
        String r113 = UriProtector.getQueryParameter(r100, "class");
        if (TextUtils.isEmpty(r113) == false) goto L13;
        krc.b.a(TAG, "query service service name is empty, uri:" + r100.toString());
        return null;
    L13:
        IBinder r104 = getBinderByClass(r100, r113 + STUB_SUFFIX);
        if (r104 != null) goto L17;
        krc.b.a(TAG, "query service getBinderByClass is empty, serviceName:" + r113);
        return null;
    L17:
        jrc.b r114 = jrc.b.a.f500175a;
        if (r114.f500173b == false) goto L20;
    L41:
        String[] r105 = lrc.a.f510480b;
        Intrinsics.checkNotNullParameter(r104, "binder");
        lrc.a r106 = new lrc.a(lrc.a.f510480b, r104);     // Catch: RemoteException -> L44
        Map<String, lrc.a> r115 = lrc.a.f510481c;     // Catch: RemoteException -> L44
        String r107 = r104.getInterfaceDescriptor();     // Catch: RemoteException -> L44
        Intrinsics.checkNotNull(r107);     // Catch: RemoteException -> L44
        ((ConcurrentHashMap) r115).put(r107, r106);     // Catch: RemoteException -> L44
        return r106;
    L44:
        e = move-exception;
        krc.b.b("ProcessCursor", "generateCursor cursor failed.", e);
        return null;
    L20:
        if (r102 >= 4000) goto L41;
        krc.b.c(TAG, "query called, wait.");
        Object r116 = r114.f500172a;
        monitor-enter(r116);
        reportTooBlockingBinderThread(this.mBinderThreadCount.getAndIncrement());     // Catch: Throwable -> L28 InterruptedException -> L30
        long r108 = 4000 - r102;     // Catch: Throwable -> L28 InterruptedException -> L30
        r116.wait(r108);     // Catch: Throwable -> L28 InterruptedException -> L30
        krc.b.c(TAG, "query service called. wait:" + r108);     // Catch: Throwable -> L28 InterruptedException -> L30
        AtomicInteger r109 = this.mBinderThreadCount;     // Catch: Throwable -> L38
    L26:
        r109.getAndDecrement();     // Catch: Throwable -> L38
        this.mStart = 0;     // Catch: Throwable -> L38
        monitor-exit(r116);     // Catch: Throwable -> L38
        goto L41
    L30:
        e = move-exception;
        krc.b.a(TAG, "failed to wait, e:" + e);     // Catch: Throwable -> L28
        r109 = this.mBinderThreadCount;     // Catch: Throwable -> L38
        goto L26
    L28:
        th = move-exception;
        this.mBinderThreadCount.getAndDecrement();     // Catch: Throwable -> L38
        this.mStart = 0;     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }
}
