package com.volcengine.zeus.service.server;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.IServiceManager;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.ServiceConnection;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ServiceManager extends IServiceManager.Stub {
    private static volatile ServiceManager sInstance;
    private final HashMap<ComponentName, lqc.a> mAliveServicesMap;
    private final ServiceConnectionMap<Intent> mConnectionIntentMap;
    private final HashMap<ComponentName, IBinder> mServiceBinderMap;
    private final HashMap<ComponentName, ServiceConnectionSet> mServiceConnectionMap;
    private final HashSet<ComponentName> mServiceStartByStartServiceSet;
    private final HashSet<ComponentName> mServiceStopCalledMap;
    private final Handler mainHandler;

    public class ServiceConnectionMap<T> extends HashMap<ServiceConnection, T> {
        final /* synthetic */ ServiceManager this$0;

        public ServiceConnectionMap(ServiceManager r1) {
            this.this$0 = r1;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r6) {
            if (super.containsKey(r6) == false) goto L6;
            return true;
        L6:
            if ((r6 instanceof ServiceConnection) == true) goto L8;
            return false;
        L8:
            Iterator<ServiceConnection> r0 = keySet().iterator();
        L10:
            if (r0.hasNext() == false) goto L17;
            if (r0.next().getHashCode() != ((ServiceConnection) r6).getHashCode()) goto L10;
            return true;
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L10
        L17:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public T remove(Object r5) {
            T r0 = (T) super.remove(r5);
            if (r0 == null) goto L5;
            return r0;
        L5:
            Iterator<ServiceConnection> r1 = keySet().iterator();
        L7:
            if (r1.hasNext() == false) goto L14;
            ServiceConnection r2 = r1.next();
            if (r2.getHashCode() != ((ServiceConnection) r5).getHashCode()) goto L7;
        L16:
            return (T) super.remove(r2);
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L7
        L14:
            r2 = null;
            goto L16
        }
    }

    public class ServiceConnectionSet extends HashSet<ServiceConnection> {
        final /* synthetic */ ServiceManager this$0;

        public ServiceConnectionSet(ServiceManager r1) {
            this.this$0 = r1;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r6) {
            if (super.contains(r6) == false) goto L6;
            return true;
        L6:
            if ((r6 instanceof ServiceConnection) == true) goto L8;
            return false;
        L8:
            Iterator<ServiceConnection> r0 = iterator();
        L10:
            if (r0.hasNext() == false) goto L17;
            if (r0.next().getHashCode() != ((ServiceConnection) r6).getHashCode()) goto L10;
            return true;
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L10
        L17:
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r5) {
            if (super.remove(r5) == false) goto L6;
            return true;
        L6:
            Iterator r0 = iterator();
        L8:
            if (r0.hasNext() == false) goto L15;
            ServiceConnection r1 = (ServiceConnection) r0.next();
            if (r1.getHashCode() != ((ServiceConnection) r5).getHashCode()) goto L8;
        L17:
            return super.remove(r1);
        L13:
            e = move-exception;
            e.printStackTrace();
            goto L8
        L15:
            r1 = null;
            goto L17
        }
    }

    @Override // com.volcengine.zeus.IServiceManager.Stub, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public static ServiceManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ServiceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ServiceManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ServiceManager() {
        this.mServiceBinderMap = new HashMap();
        this.mServiceConnectionMap = new HashMap();
        this.mConnectionIntentMap = new ServiceConnectionMap(this);
        this.mAliveServicesMap = new HashMap();
        this.mServiceStartByStartServiceSet = new HashSet();
        this.mServiceStopCalledMap = new HashSet();
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private void destroy(ComponentName r3) {
        lqc.a r0 = this.mAliveServicesMap.remove(r3);
        this.mServiceStopCalledMap.remove(r3);
        this.mServiceBinderMap.remove(r3);
        this.mServiceStartByStartServiceSet.remove(r3);
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    private boolean destroyServiceIfNeed(ComponentName r6) {
        if (this.mServiceStartByStartServiceSet.contains(r6) == false) goto L5;
        boolean r0 = this.mServiceStopCalledMap.contains(r6);
        boolean r3 = this.mServiceConnectionMap.containsKey(r6);
        if (r0 == false) goto L14;
        if (r3 == true) goto L14;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "destroyServiceIfNeed: destroy because stop called and no connections. component=" + r6);
        destroy(r6);
        return true;
    L14:
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "destroyServiceIfNeed: not destroy. component=" + r6 + ", stopCalled=" + r0 + ", hasConnections=" + r3);
        return false;
    L5:
        if (this.mServiceConnectionMap.get(r6) != null) goto L8;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "destroyServiceIfNeed: destroy because not started by startService and no connections. component=" + r6);
        destroy(r6);
        return true;
    L8:
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "destroyServiceIfNeed: not destroy because has connections. component=" + r6);
        return false;
    }

    private synchronized void realUnbindService(ServiceConnection r6) {
        monitor-enter(this);
        Iterator<ComponentName> r0 = this.mServiceConnectionMap.keySet().iterator();     // Catch: Throwable -> L19
    L5:
        if (r0.hasNext() == false) goto L14;
        ComponentName r1 = r0.next();     // Catch: Throwable -> L19
        ServiceConnectionSet r2 = this.mServiceConnectionMap.get(r1);     // Catch: Throwable -> L19
        if (r2.contains(r6) == false) goto L5;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "realUnbindService found conn for component=" + r1);     // Catch: Throwable -> L19
        r2.remove(r6);     // Catch: Throwable -> L19
        Intent r7 = this.mConnectionIntentMap.remove(r6);     // Catch: Throwable -> L19
        if (r2.size() != 0) goto L13;
        this.mServiceConnectionMap.remove(r1);     // Catch: Throwable -> L19
        lqc.a r3 = this.mAliveServicesMap.get(r1);     // Catch: Throwable -> L19
        if (r3 == null) goto L13;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "realUnbindService onUnbind, component=" + r1);     // Catch: Throwable -> L19
        r3.onUnbind(r7);     // Catch: Throwable -> L19
    L13:
        destroyServiceIfNeed(r1);     // Catch: Throwable -> L19
        boolean r8 = true;
    L15:
        if (r8 == true) goto L17;
        ZeusLogger.w(ZeusLogger.TAG_SERVICE, "realUnbindService failed: conn not found in any service connections");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L14:
        r8 = false;
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized boolean realStopService(ComponentName r4) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mAliveServicesMap.containsKey(r4) == false) goto L9;
        this.mServiceStopCalledMap.add(r4);     // Catch: Throwable -> L13
        boolean r5 = destroyServiceIfNeed(r4);     // Catch: Throwable -> L13
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "ServiceManager.realStopService destroyed=" + r5);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r5;
    L9:
        ZeusLogger.w(ZeusLogger.TAG_SERVICE, "ServiceManager.realStopService service not found in alive map");     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    }

    @Override // com.volcengine.zeus.IServiceManager
    public void unbindService(ServiceConnection r3) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        realUnbindService(r3);
        return;
    L5:
        this.mainHandler.post(new d(this, r3));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_service_server_ServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(PluginClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    public static /* synthetic */ void access$200(ServiceManager r0, ServiceConnection r1) {
        r0.realUnbindService(r1);
    }

    private lqc.a createServiceAndCallOnCreate(Intent r1, String r2) {
        lqc.a r3 = newServiceInstance(r1, r2);
        if (r3 == null) goto L5;
        r3.onCreate();
    L5:
        return r3;
    }

    private lqc.a newServiceInstance(Intent r3, String r4) {
        ComponentName r5 = r3.getComponent();
        Plugin r0 = PluginManager.getInstance().getPlugin(r4);
        boolean r6 = Zeus.loadPlugin(r4);     // Catch: Exception -> L8
        lqc.a r7 = (lqc.a) INVOKEVIRTUAL_com_volcengine_zeus_service_server_ServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r0.mClassLoader, r5.getClassName()).newInstance();     // Catch: Exception -> L6
        r7.attach(r0);     // Catch: Exception -> L6
        return r7;
    L6:
        e = e;
    L10:
        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = " + r6, e);
        throw new RuntimeException(e);
    L8:
        e = e;
        r6 = false;
        goto L10
    }

    private synchronized ComponentName realStartService(Intent r3, String r4) {
        monitor-enter(this);
        Plugin r0 = Zeus.getPlugin(r4);     // Catch: Throwable -> L18
        if (r0 == null) goto L6;
        r3.setExtrasClassLoader(r0.mClassLoader);     // Catch: Throwable -> L18
    L6:
        ComponentName r1 = r3.getComponent();     // Catch: Throwable -> L18
        if (this.mAliveServicesMap.containsKey(r1) == true) goto L13;
        lqc.a r5 = createServiceAndCallOnCreate(r3, r4);     // Catch: Throwable -> L18
        if (r5 != null) goto L12;
        monitor-exit(this);
        return r1;
    L12:
        this.mAliveServicesMap.put(r1, r5);     // Catch: Throwable -> L18
        this.mServiceStartByStartServiceSet.add(r1);     // Catch: Throwable -> L18
    L13:
        lqc.a r6 = this.mAliveServicesMap.get(r1);     // Catch: Throwable -> L18
        if (r6 == null) goto L16;
        r6.onStartCommand(r3, 0, 0);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return r1;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.volcengine.zeus.IServiceManager
    public ComponentName startService(Intent r3, String r4) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        this.mainHandler.post(new a(this, r3, r4));
        return r3.getComponent();
    L5:
        return realStartService(r3, r4);
    }

    @Override // com.volcengine.zeus.IServiceManager
    public boolean stopService(Intent r3, String r4) {
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "ServiceManager.stopService receive request, intent=" + r3 + ", pluginPkg=" + r4);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        getInstance().realStopService(r3.getComponent());
        return true;
    L5:
        this.mainHandler.post(new b(r3));
        return true;
    }

    public static /* synthetic */ ComponentName access$000(ServiceManager r0, Intent r1, String r2) {
        return r0.realStartService(r1, r2);
    }

    private synchronized boolean realBindService(Intent r5, ServiceConnection r6, int r7, String r8) throws RemoteException {
        monitor-enter(this);
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "realBindService start, intent=" + r5 + ", pluginPkg=" + r8);     // Catch: Throwable -> L30
        Plugin r1 = Zeus.getPlugin(r8);     // Catch: Throwable -> L30
        if (r1 == null) goto L7;
        r5.setExtrasClassLoader(r1.mClassLoader);     // Catch: Throwable -> L30
    L7:
        ComponentName r2 = r5.getComponent();     // Catch: Throwable -> L30
        if (this.mAliveServicesMap.containsKey(r2) == true) goto L16;
        lqc.a r9 = createServiceAndCallOnCreate(r5, r8);     // Catch: Throwable -> L30
        if (r9 != null) goto L15;
        ZeusLogger.w(ZeusLogger.TAG_SERVICE, "realBindService create service failed, component=" + r2);     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L15:
        this.mAliveServicesMap.put(r2, r9);     // Catch: Throwable -> L30
    L16:
        lqc.a r10 = this.mAliveServicesMap.get(r2);     // Catch: Throwable -> L30
        if (this.mServiceBinderMap.containsKey(r2) == true) goto L19;
        this.mServiceBinderMap.put(r2, r10.onBind(r5));     // Catch: Throwable -> L30
    L19:
        IBinder r11 = this.mServiceBinderMap.get(r2);     // Catch: Throwable -> L30
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "realBindService get binder=" + r11);     // Catch: Throwable -> L30
        if (r11 != null) goto L22;
    L27:
        monitor-exit(this);
        return true;
    L22:
        if (this.mServiceConnectionMap.containsKey(r2) == true) goto L24;
        ServiceConnectionSet r12 = new ServiceConnectionSet(this);     // Catch: Throwable -> L30
        r12.add(r6);     // Catch: Throwable -> L30
        this.mServiceConnectionMap.put(r2, r12);     // Catch: Throwable -> L30
        this.mConnectionIntentMap.put(r6, r5);     // Catch: Throwable -> L30
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "realBindService callback onServiceConnected (first)");     // Catch: Throwable -> L30
        r6.onServiceConnected(r2, r11);     // Catch: Throwable -> L30
        goto L27
    L24:
        if (this.mServiceConnectionMap.get(r2).contains(r6) == true) goto L27;
        this.mServiceConnectionMap.get(r2).add(r6);     // Catch: Throwable -> L30
        this.mConnectionIntentMap.put(r6, r5);     // Catch: Throwable -> L30
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "realBindService callback onServiceConnected");     // Catch: Throwable -> L30
        r6.onServiceConnected(r2, r11);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.volcengine.zeus.IServiceManager
    public boolean bindService(Intent r9, ServiceConnection r10, int r11, String r12) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        this.mainHandler.post(new c(this, r9, r10, r11, r12));
        return true;
    L5:
        return realBindService(r9, r10, r11, r12);
    }

    public static /* synthetic */ boolean access$100(ServiceManager r0, Intent r1, ServiceConnection r2, int r3, String r4) throws RemoteException {
        return r0.realBindService(r1, r2, r3, r4);
    }
}
