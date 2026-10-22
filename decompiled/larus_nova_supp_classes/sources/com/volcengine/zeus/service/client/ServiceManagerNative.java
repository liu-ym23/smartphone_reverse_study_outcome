package com.volcengine.zeus.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.volcengine.zeus.IServiceManager;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.g;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.plugin.PluginManager;
import com.volcengine.zeus.servermanager.ServerManagerHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ServiceManagerNative {
    private static volatile ServiceManagerNative sInstance;
    private HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service;
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService;
    private final HashMap<ServiceConnection, com.volcengine.zeus.ServiceConnection> serviceConn2ServiceConn;

    public static ServiceManagerNative getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ServiceManagerNative.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ServiceManagerNative();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ServiceManagerNative.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ServiceManagerNative() {
        this.serviceConn2ServiceConn = new HashMap();
        this.process2ConnAndService = new HashMap();
        this.conn2Service = new HashMap();
    }

    public void unbindServiceNative(Context r5, ServiceConnection r6) {
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "unbindServiceNative start, conn=" + r6);
        HashSet<ServiceInfo> r0 = this.conn2Service.get(r6);
        if (r0 == null) goto L12;
        Iterator<ServiceInfo> r7 = r0.iterator();
    L6:
        if (r7.hasNext() == false) goto L27;
        ServiceInfo r1 = r7.next();
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "unbindServiceNative call remote, service=" + r1);     // Catch: RemoteException -> L10
        ServerManagerHelper.getServiceManager(r1.processName).unbindService(this.serviceConn2ServiceConn.get(r6));     // Catch: RemoteException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L6
    L27:
        return;
    L12:
        ZeusLogger.w(ZeusLogger.TAG_SERVICE, "unbindServiceNative: conn not found in conn2Service map, delegate to system unbind. conn=" + r6);
        r5.unbindService(r6);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_SERVICE, "unbindServiceNative system unbind failed, conn=" + r6, e);
    }

    public ServiceInfo queryServiceFromPlugin(Context r3, Intent r4, String r5) {
        Zeus.loadOrAwaitLoad(r5, g.c);
        ComponentName r6 = r4.getComponent();
        if (r6 != null) goto L5;
        return null;
    L5:
        if (TextUtils.equals(r3.getPackageName(), r6.getPackageName()) == true) goto L8;
        return null;
    L8:
        return PluginManager.getInstance().getPlugin(r5).pluginServices.get(r6.getClassName());
    }

    public ComponentName startServiceNative(Context r2, Intent r3, String r4) {
        ServiceInfo r0 = queryServiceFromPlugin(r2, r3, r4);
        if (r0 == null) goto L5;
        return ServerManagerHelper.getServiceManager(r0.processName).startService(r3, r4);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return r2.startService(r3);
    }

    public boolean stopServiceNative(Context r5, Intent r6, String r7) {
        ServiceInfo r2 = queryServiceFromPlugin(r5, r6, r7);
        if (r2 != null) goto L11;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "ServiceManagerNative.stopServiceNative serviceInfo is null, use system stopService.");
        return r5.stopService(r6);
    L11:
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "ServiceManagerNative.stopServiceNative call remote stopService, processName=" + r2.processName);     // Catch: RemoteException -> L8
        boolean r8 = ServerManagerHelper.getServiceManager(r2.processName).stopService(r6, r7);     // Catch: RemoteException -> L8
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "ServiceManagerNative.stopServiceNative remote result=" + r8);     // Catch: RemoteException -> L8
        return r8;
    L8:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "ServiceManagerNative.stopServiceNative remote failed", e);
        e.printStackTrace();
        return false;
    }

    public boolean bindServiceNative(Context r7, Intent r8, final ServiceConnection r9, int r10, String r11) {
        ServiceInfo r2 = queryServiceFromPlugin(r7, r8, r11);
        if (r2 != null) goto L15;
        StringBuilder r0 = new StringBuilder("Plugin installed = ");
        Plugin r1 = PluginManager.getInstance().getPlugin(r11);
        r0.append(r1.isInstalled());
        r0.append(", loaded = ");
        r0.append(r1.isLoaded());
        r0.append('\n');
        ComponentName r4 = r8.getComponent();
        if (r4 != null) goto L7;
        r0.append("Component is null!");
    L8:
        r0.append("\nPlugin package: ");
        r0.append(r11);
        r0.append("\nServiceInfo map:\n");
        Iterator<Map.Entry<String, ServiceInfo>> r12 = r1.pluginServices.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, ServiceInfo> r3 = r12.next();
        r0.append("key: ");
        r0.append(r3.getKey());
        r0.append(", value: ");
        r0.append(r3.getValue());
        r0.append("\n");
        goto L10
    L12:
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "bindServiceNative serviceInfo is null, use system bindService. intent=" + r8 + '\n' + r0);
        return r7.bindService(r8, r9, r10);
    L7:
        r0.append("Request package: ");
        r0.append(r4.getPackageName());
        r0.append(", Request class: ");
        r0.append(r4.getClassName());
        r0.append(", Our package: ");
        r0.append(r7.getPackageName());
        goto L8
    L15:
        if (this.serviceConn2ServiceConn.containsKey(r9) == true) goto L18;
        this.serviceConn2ServiceConn.put(r9, new AnonymousClass1(this, r9));
    L18:
        if (this.conn2Service.get(r9) != null) goto L20;
        this.conn2Service.put(r9, new HashSet());
    L20:
        this.conn2Service.get(r9).add(r2);
        IServiceManager r13 = ServerManagerHelper.getServiceManager(r2.processName);
        IBinder r5 = r13.asBinder();
        HashMap<ServiceConnection, HashSet<ComponentName>> r6 = this.process2ConnAndService.get(r5);
        if (r6 != null) goto L23;
        r6 = new HashMap();
        this.process2ConnAndService.put(r5, r6);
    L23:
        HashSet<ComponentName> r14 = r6.get(r9);
        if (r14 != null) goto L26;
        r14 = new HashSet();
        r6.put(r9, r14);
    L26:
        r14.add(r8.getComponent());
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "bindServiceNative call serverManager.bindService, intent=" + r8);     // Catch: RemoteException -> L29
        boolean r15 = r13.bindService(r8, this.serviceConn2ServiceConn.get(r9), r10, r11);     // Catch: RemoteException -> L29
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "bindServiceNative serverManager.bindService result=" + r15);     // Catch: RemoteException -> L29
        return r15;
    L29:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed! intent=" + r8, e);
        return false;
    }
}
