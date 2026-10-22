package com.volcengine.zeus.servermanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.volcengine.zeus.IPackageManager;
import com.volcengine.zeus.IPluginProcessManager;
import com.volcengine.zeus.IServiceManager;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.service.client.ServiceManagerNative;
import com.volcengine.zeus.service.server.PluginProcessManager;
import dqc.d;
import fqc.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ServerManagerHelper {
    static final String EXTRA_IPC_FROM_PROCESS = "zeus_ipc_from_process";
    static final String EXTRA_IPC_REQUEST_ID = "zeus_ipc_request_id";
    static final String EXTRA_IPC_TARGET_PROCESS = "zeus_ipc_target_process";
    static final String EXTRA_IPC_TARGET_PROCESS_KEY = "zeus_ipc_target_process_key";
    static final String IPC_TRACE_LOG_PREFIX = "ServerManagerIPC";
    private static final int MAX_RETRY_COUNT = 3;
    public static final int PROCESS_ALIVE = 1;
    public static final int PROCESS_ALIVE_UNKNOWN = -1;
    public static final int PROCESS_NOT_ALIVE = 0;
    private static final Map<String, Boolean> sConnectedStates = null;
    private static final AtomicLong sIpcRequestId = null;
    private static final Object sLockActivity = null;
    private static final Object sLockPackage = null;
    private static final Object sLockPluginProcess = null;
    private static final Object sLockService = null;
    private static IPackageManager sPackageManager;
    private static final Map<String, IPluginProcessManager> sPluginProcessManager = null;
    private static final Map<String, IServiceManager> sServiceManager = null;

    public static class a implements IBinder.DeathRecipient {
        public final /* synthetic */ String a;
        public final /* synthetic */ IBinder b;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            ServerManagerHelper.access$000().put(this.a, Boolean.FALSE);
            ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
            HashMap<ServiceConnection, HashSet<ComponentName>> r0 = ServiceManagerNative.getInstance().process2ConnAndService.get(this.b);
            if (r0 == null) goto L13;
            Iterator<ServiceConnection> r1 = r0.keySet().iterator();
        L6:
            if (r1.hasNext() == false) goto L13;
            ServiceConnection r2 = r1.next();
            HashSet<ComponentName> r3 = r0.get(r2);
            if (r3 == null) goto L6;
            Iterator<ComponentName> r4 = r3.iterator();
        L11:
            if (r4.hasNext() == false) goto L6;
            r2.onServiceDisconnected(r4.next());
        L13:
            PluginProcessManager.INSTANCE.onBinderDied(this.a);
        }

        public a(String r1, IBinder r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ServerManagerHelper() {
    }

    static {
        sIpcRequestId = new AtomicLong();
        sLockActivity = new Object();
        sLockService = new Object();
        sLockPackage = new Object();
        sLockPluginProcess = new Object();
        sConnectedStates = new ConcurrentHashMap();
        sServiceManager = new ConcurrentHashMap();
        sPluginProcessManager = new ConcurrentHashMap();
    }

    public static int getMainProcessAliveState() {
        return getProcessAliveState("main", Zeus.getAppApplication().getPackageName(), null);
    L4:
        return -1;
    }

    public static IServiceManager getMainServiceManager() {
        return getServiceManager("main");
    }

    public static IPackageManager getPackageManager() {
        Boolean r0 = sConnectedStates.get("main");
        if (r0 == null) goto L7;
        if (r0.booleanValue() == false) goto L7;
    L11:
        if (sPackageManager != null) goto L26;
        Object r1 = sLockPackage;
        monitor-enter(r1);
        IPackageManager r2 = (IPackageManager) generateServerManager("package", "main");     // Catch: Throwable -> L22
        if (r2 != null) goto L19;
        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return null;
    L19:
        sPackageManager = r2;     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L26:
        return sPackageManager;
    L7:
        if (sPackageManager == null) goto L9;
        logCacheInvalid("package", "main", r0);
    L9:
        sPackageManager = null;
        goto L11
    }

    private static String getCurrentProcessName() {
        Zeus.getAppApplication();     // Catch: Throwable -> L4
        return d.c();
    L4:
        return "unknown";
    }

    public static /* synthetic */ Map access$000() {
        return sConnectedStates;
    }

    public static IPluginProcessManager getPluginProcessManager(String r3) {
        Boolean r0 = sConnectedStates.get(r3);
        if (r0 != null) goto L5;
    L6:
        Map<String, IPluginProcessManager> r1 = sPluginProcessManager;
        if (r1.get(r3) == null) goto L9;
        logCacheInvalid("plugin_process", r3, r0);
    L9:
        r1.remove(r3);
    L10:
        Map<String, IPluginProcessManager> r2 = sPluginProcessManager;
        if (r2.get(r3) != null) goto L27;
        Object r4 = sLockPluginProcess;
        monitor-enter(r4);
        IPluginProcessManager r5 = (IPluginProcessManager) generateServerManager("plugin_process", r3);     // Catch: Throwable -> L23
        if (r5 != null) goto L20;
        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPluginProcessManager failed!!!");     // Catch: Throwable -> L23
        monitor-exit(r4);     // Catch: Throwable -> L23
        return null;
    L20:
        r2.put(r3, r5);     // Catch: Throwable -> L23
        monitor-exit(r4);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L27:
        return r2.get(r3);
    L5:
        if (r0.booleanValue() == true) goto L10;
        goto L6
    }

    public static IServiceManager getServiceManager(String r3) {
        Boolean r0 = sConnectedStates.get(r3);
        if (r0 != null) goto L5;
    L6:
        Map<String, IServiceManager> r1 = sServiceManager;
        if (r1.get(r3) == null) goto L9;
        logCacheInvalid("service", r3, r0);
    L9:
        r1.remove(r3);
    L10:
        Map<String, IServiceManager> r2 = sServiceManager;
        if (r2.get(r3) != null) goto L27;
        Object r4 = sLockService;
        monitor-enter(r4);
        IServiceManager r5 = (IServiceManager) generateServerManager("service", r3);     // Catch: Throwable -> L23
        if (r5 != null) goto L20;
        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");     // Catch: Throwable -> L23
        monitor-exit(r4);     // Catch: Throwable -> L23
        return null;
    L20:
        r2.put(r3, r5);     // Catch: Throwable -> L23
        monitor-exit(r4);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L27:
        return r2.get(r3);
    L5:
        if (r0.booleanValue() == true) goto L10;
        goto L6
    }

    private static IInterface generateServerManager(String r12, String r13) {
        if (Zeus.hasInit() == false) goto L54;
        ProviderInfo r0 = Zeus.getServerManagerHashMap().get(r13);
        if (r0 == null) goto L52;
        String r1 = "content://" + r0.authority;
        long r10 = sIpcRequestId.incrementAndGet();
        String r2 = getCurrentProcessName();
        IBinder r3 = queryBinder(UriProtector.parse(r1), r12, r13, r0.processName, r10, r2);
        boolean r4 = true;
        if (r3 != null) goto L9;
    L39:
        StringBuilder r6 = new StringBuilder("ServerManagerIPC event=manager_unavailable requestId=");
        r6.append(r10);
        r6.append(" component=");
        r6.append(r12);
        r6.append(" fromProcess=");
        r6.append(r2);
        r6.append(" targetProcessKey=");
        r6.append(r13);
        r6.append(" targetProcess=");
        r6.append(r0.processName);
        r6.append(" binderNull=");
        if (r3 != null) goto L42;
        boolean r14 = true;
    L43:
        r6.append(r14);
        r6.append(" binderAlive=");
        if (r3 != null) goto L46;
    L48:
        r4 = false;
    L49:
        r6.append(r4);
        ZeusLogger.w(ZeusLogger.TAG_SERVER, r6.toString());
        return null;
    L46:
        if (r3.isBinderAlive() == false) goto L48;
    L42:
        r14 = false;
        goto L43
    L9:
        if (r3.isBinderAlive() == false) goto L39;
        r3.linkToDeath(new a(r13, r3), 0);     // Catch: RemoteException -> L37
        sConnectedStates.put(r13, Boolean.TRUE);     // Catch: RemoteException -> L37
        int r7 = r12.hashCode();     // Catch: RemoteException -> L37
        if (r7 == (-807062458)) goto L24;
        if (r7 == 1042764131) goto L21;
        if (r7 == 1984153269) goto L18;
    L26:
        byte r8 = -1;
    L27:
        if (r8 == 0) goto L36;
        if (r8 == 1) goto L34;
        if (r8 != 2) goto L39;
        return IPluginProcessManager.Stub.asInterface(r3);
    L34:
        return IServiceManager.Stub.asInterface(r3);
    L36:
        return IPackageManager.Stub.asInterface(r3);
    L18:
        if (r12.equals("service") == false) goto L26;
        r8 = 1;
        goto L27
    L21:
        if (r12.equals("plugin_process") == false) goto L26;
        r8 = 2;
        goto L27
    L24:
        if (r12.equals("package") == false) goto L26;
        r8 = 0;
    L37:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e);
        goto L39
    L52:
        throw new RuntimeException("宿主中没有找对对应进程的serverManager " + r13);
    L54:
        throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:" + r13);
    }

    private static int getProcessAliveState(String r2, String r3, IBinder r4) {
        if (r3 != null) goto L5;
    L21:
        return -1;
    L5:
        if (r3.length() == 0) goto L21;
        if (r3.equals(getCurrentProcessName()) == false) goto L10;
        return 1;
    L10:
        if (r4 != null) goto L12;
    L14:
        Boolean r5 = sConnectedStates.get(r2);     // Catch: Throwable -> L22
        if (Boolean.TRUE.equals(r5) == false) goto L17;
        return 1;
    L17:
        if (Boolean.FALSE.equals(r5) == false) goto L21;
        return 0;
    L12:
        if (r4.isBinderAlive() == false) goto L14;
        return 1;
    }

    private static void logCacheInvalid(String r2, String r3, Boolean r4) {
        ZeusLogger.i(ZeusLogger.TAG_SERVER, "ServerManagerIPC event=manager_cache_invalid component=" + r2 + " fromProcess=" + getCurrentProcessName() + " targetProcessKey=" + r3 + " connectedState=" + r4);
    }

    private static IBinder queryBinder(Uri r21, String r22, String r23, String r24, long r25, String r28) {
        long r16 = System.currentTimeMillis();
        int r8 = getProcessAliveState(r23, r24, null);
        if (ZeusLogger.isDebug() == false) goto L27;
        StringBuilder r0 = new StringBuilder("ServerManagerIPC event=query_binder_start requestId=");
        r0.append(r25);
        r0.append(" component=");
        r0.append(r22);
        r0.append(" fromProcess=");
        r0.append(r28);
        r0.append(" targetProcessKey=");
        r0.append(r23);
        r0.append(" targetProcess=");
        r0.append(r24);
        r0.append(" targetAliveBefore=");
        boolean r2 = true;
        if (r8 == 1) goto L8;
        r2 = false;
    L8:
        r0.append(r2);
        r0.append(" targetAliveBeforeState=");
        r0.append(r8);
        r0.append(" uri=");
        r0.append(r21);
        ZeusLogger.i(ZeusLogger.TAG_SERVER, r0.toString());
    L27:
        Bundle r1 = new Bundle();     // Catch: IllegalArgumentException -> L21
        r1.putLong(EXTRA_IPC_REQUEST_ID, r25);     // Catch: IllegalArgumentException -> L21
        r1.putString(EXTRA_IPC_FROM_PROCESS, r28);     // Catch: IllegalArgumentException -> L21
        r1.putString(EXTRA_IPC_TARGET_PROCESS, r24);     // Catch: IllegalArgumentException -> L21
        r1.putString(EXTRA_IPC_TARGET_PROCESS_KEY, r23);     // Catch: IllegalArgumentException -> L21
        Bundle r3 = Zeus.getAppApplication().getContentResolver().call(r21, "query_binder", r22, r1);     // Catch: IllegalArgumentException -> L21
        if (r3 == null) goto L19;
        r3.setClassLoader(AbsServerManager.class.getClassLoader());     // Catch: IllegalArgumentException -> L21
        BinderParcel r4 = (BinderParcel) r3.getParcelable("binder");     // Catch: IllegalArgumentException -> L21
        if (r4 == null) goto L19;
        IBinder r5 = r4.a;     // Catch: IllegalArgumentException -> L21
        logQueryBinderFinish(r25, r22, r28, r23, r24, r8, r5, r16, "success");     // Catch: IllegalArgumentException -> L17
        return r5;
    L17:
        e = e;
    L23:
        logQueryBinderFinish(r25, r22, r28, r23, r24, r8, null, r16, "exception");
        ZeusLogger.w(ZeusLogger.TAG_SERVER, "queryBinder failed. uri=" + r21, e);
        return 0;
    L19:
        logQueryBinderFinish(r25, r22, r28, r23, r24, r8, null, r16, "empty");
        return null;
    L21:
        e = e;
        goto L23
    }

    private static void logQueryBinderFinish(long r16, String r18, String r19, String r20, String r21, int r22, IBinder r23, long r24, String r26) {
        int r8 = getProcessAliveState(r20, r21, r23);
        if (r22 != 1) goto L5;
        boolean r3 = true;
    L6:
        if (r8 != 1) goto L8;
        boolean r6 = true;
    L9:
        if (r22 != 0) goto L12;
        if (r8 != 1) goto L12;
        boolean r9 = true;
    L13:
        if (r23 != null) goto L15;
    L17:
        boolean r11 = false;
    L18:
        long r12 = System.currentTimeMillis() - r24;
        StringBuilder r10 = new StringBuilder("ServerManagerIPC event=query_binder_finish requestId=");
        r10.append(r16);
        r10.append(" component=");
        r10.append(r18);
        r10.append(" fromProcess=");
        r10.append(r19);
        r10.append(" targetProcessKey=");
        r10.append(r20);
        r10.append(" targetProcess=");
        r10.append(r21);
        r10.append(" result=");
        r10.append(r26);
        r10.append(" targetAliveBefore=");
        r10.append(r3);
        r10.append(" targetAliveAfter=");
        r10.append(r6);
        r10.append(" targetAliveBeforeState=");
        r10.append(r22);
        r10.append(" targetAliveAfterState=");
        r10.append(r8);
        r10.append(" processStartLikely=");
        r10.append(r9);
        r10.append(" binderNull=");
        if (r23 != null) goto L21;
        boolean r1 = true;
    L22:
        r10.append(r1);
        r10.append(" binderAlive=");
        r10.append(r11);
        r10.append(" cost=");
        r10.append(r12);
        ZeusLogger.i(ZeusLogger.TAG_SERVER, r10.toString());
        if (r23 != null) goto L25;
        boolean r13 = true;
    L26:
        reportQueryBinderFinish(r16, r18, r19, r20, r21, r26, r22, r8, r9, r13, r11, r12);
        return;
    L25:
        r13 = false;
        goto L26
    L21:
        r1 = false;
        goto L22
    L15:
        if (r23.isBinderAlive() == false) goto L17;
        r11 = true;
    L12:
        r9 = false;
        goto L13
    L8:
        r6 = false;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    private static void reportQueryBinderFinish(long r5, String r7, String r8, String r9, String r10, String r11, int r12, int r13, boolean r14, boolean r15, boolean r16, long r17) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L16
        r0.put("event", "query_binder_finish");     // Catch: Throwable -> L16
        r0.put("request_id", r5);     // Catch: Throwable -> L16
        r0.put("component", r7);     // Catch: Throwable -> L16
        r0.put("from_process", r8);     // Catch: Throwable -> L16
        r0.put("target_process_key", r9);     // Catch: Throwable -> L16
        r0.put("target_process", r10);     // Catch: Throwable -> L16
        r0.put("result", r11);     // Catch: Throwable -> L16
        r0.put("target_alive_before", r12);     // Catch: Throwable -> L16
        r0.put("target_alive_after", r13);     // Catch: Throwable -> L16
        int r2 = 1;
        if (r14 == false) goto L5;
        int r4 = 1;
    L6:
        r0.put("process_start_likely", r4);     // Catch: Throwable -> L16
        if (r15 == false) goto L9;
        int r6 = 1;
    L10:
        r0.put("binder_null", r6);     // Catch: Throwable -> L16
        if (r16 == true) goto L14;
        r2 = 0;
    L14:
        r0.put("binder_alive", r2);     // Catch: Throwable -> L16
        r0.put("cost", r17);     // Catch: Throwable -> L16
        b.c("obric_zeus_server_manager_ipc", r0);     // Catch: Throwable -> L16
        return;
    L9:
        r6 = 0;
        goto L10
    L5:
        r4 = 0;
    L16:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "report ServerManager IPC failed", th);
    }
}
