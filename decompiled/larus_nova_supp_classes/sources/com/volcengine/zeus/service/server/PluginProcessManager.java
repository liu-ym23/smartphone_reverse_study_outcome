package com.volcengine.zeus.service.server;

import android.app.ActivityManager;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.IPluginProcessManager;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.plugin.PluginManager;
import com.volcengine.zeus.servermanager.ServerManagerHelper;
import com.volcengine.zeus.util.kv.KVStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import mqc.p;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR<\u0010\u001f\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001d0\u001cj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001d`\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/volcengine/zeus/service/server/PluginProcessManager;", "Lcom/volcengine/zeus/IPluginProcessManager$Stub;", XmlPullParser.NO_NAMESPACE, "pluginPkg", XmlPullParser.NO_NAMESPACE, "killPluginProcessesByHostQuery", XmlPullParser.NO_NAMESPACE, "getLoadedPluginProcessNames", "processName", "resolveHostProcessName", XmlPullParser.NO_NAMESPACE, "Landroid/app/ActivityManager$RunningAppProcessInfo;", "getRunningAppProcesses", "tryWarmUpPluginAgain", "warmUpPlugin", "gatherPluginProcessName", "killPluginProcesses", "registerProcessPlugin", "onBinderDied", XmlPullParser.NO_NAMESPACE, "MSG_BINDER_DIED", "I", XmlPullParser.NO_NAMESPACE, "PLUGIN_RELAUNCH_DELAY", "J", "Lcom/volcengine/zeus/service/server/b;", "sProcessPluginMap", "Lcom/volcengine/zeus/service/server/b;", "Ljava/util/HashMap;", XmlPullParser.NO_NAMESPACE, "Lkotlin/collections/HashMap;", "mPluginProcessNames", "Ljava/util/HashMap;", XmlPullParser.NO_NAMESPACE, "mPluginProcessLock", "Ljava/lang/Object;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "<init>", "()V", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public final class PluginProcessManager extends IPluginProcessManager.Stub {
    public static final PluginProcessManager INSTANCE = null;
    private static final int MSG_BINDER_DIED = 1;
    private static final long PLUGIN_RELAUNCH_DELAY = 5000;
    private static final Object mPluginProcessLock = null;
    private static final HashMap<String, List<String>> mPluginProcessNames = null;
    private static final Handler mainHandler = null;
    private static final com.volcengine.zeus.service.server.b sProcessPluginMap = null;

    public static final class a implements Handler.Callback {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            if (r3.what != 1) goto L11;
            Object r4 = r3.obj;
            if ((r4 instanceof String) == false) goto L11;
            PluginProcessManager r0 = PluginProcessManager.INSTANCE;
            if (r4 == null) goto L10;
            PluginProcessManager.access$tryWarmUpPluginAgain(r0, (String) r4);
            goto L11
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L11:
            return true;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Zeus.loadPlugin(this.a.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(String r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Queue<Runnable> r0 = p.a;     // Catch: Throwable -> L4
            a r1 = new a(this);     // Catch: Throwable -> L4
            Intrinsics.checkNotNullParameter(r1, "runnable");     // Catch: Throwable -> L4
            p.c.post(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        INSTANCE = new PluginProcessManager();
        sProcessPluginMap = new com.volcengine.zeus.service.server.b();
        mPluginProcessNames = new HashMap();
        mPluginProcessLock = new Object();
        mainHandler = new Handler(Looper.getMainLooper(), a.a);
    }

    private final List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() {
        Object r0 = Zeus.getAppApplication().getSystemService("activity");     // Catch: Throwable -> L12
        if ((r0 instanceof ActivityManager) == true) goto L5;
        r0 = null;
    L5:
        ActivityManager r1 = (ActivityManager) r0;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        List<ActivityManager.RunningAppProcessInfo> r2 = r1.getRunningAppProcesses();     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        return r2;
    L10:
        return CollectionsKt.emptyList();
    L12:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_SERVER, "get running app processes failed", th);
        return CollectionsKt.emptyList();
    }

    private PluginProcessManager() {
    }

    private final Set<String> getLoadedPluginProcessNames(String r11) {
        Plugin r2 = PluginManager.getInstance().getPlugin(r11, false);     // Catch: Throwable -> L5
    L7:
        if (r2 == null) goto L28;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        String r4 = String.format("zeus_plugin_%s_loaded", Arrays.copyOf(new Object[]{r11}, 1));
        HashSet r5 = new HashSet();
        Iterator<String> r6 = r2.getAllPluginProcesses().iterator();
    L10:
        if (r6.hasNext() == false) goto L26;
        String r7 = r6.next();
        if (r7 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L10;
        boolean r9 = KVStorage.INSTANCE.dynamicKV(r7).getBoolean(r4, false);     // Catch: Throwable -> L22
    L24:
        if (r9 == false) goto L10;
        r5.add(resolveHostProcessName(r7));
    L22:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_SERVER, "read plugin loaded state failed, plugin = " + r11 + ", processName = " + r7, th);
        r9 = false;
        goto L24
    L14:
        if (r7.length() == 0) goto L17;
        r8 = false;
        goto L18
    L26:
        return r5;
    L28:
        return SetsKt.emptySet();
    L5:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_SERVER, "get plugin process config failed, plugin = " + r11, th);
        r2 = null;
        goto L7
    }

    private final void killPluginProcessesByHostQuery(String r8) {
        Set<String> r0 = getLoadedPluginProcessNames(r8);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        int r1 = Process.myUid();
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = getRunningAppProcesses().iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r3 = r2.next();
        if (r3.uid != r1) goto L7;
        if (r0.contains(r3.processName) == false) goto L7;
        Process.killProcess(r3.pid);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_SERVER, "kill plugin process failed, plugin = " + r8 + ", processName = " + r3.processName, e);
        goto L7
    }

    private final String resolveHostProcessName(String r7) {
        ProviderInfo r0 = Zeus.getServerManagerHashMap().get(r7);
        if (r0 == null) goto L5;
        String r1 = r0.processName;
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        return r1;
    L15:
        String r2 = Zeus.getAppApplication().getPackageName();
        if (Intrinsics.areEqual(r7, "main") == false) goto L19;
        return r2;
    L19:
        if (StringsKt.startsWith$default(r7, ":", false, 2, null) == false) goto L22;
        return r2 + r7;
    L22:
        if (StringsKt.contains$default(r7, ":", false, 2, null) == false) goto L25;
        return r7;
    L25:
        return r2 + ':' + r7;
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    private final void tryWarmUpPluginAgain(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        Object r1 = mPluginProcessLock;
        monitor-enter(r1);
        com.volcengine.zeus.service.server.a<String, String> r2 = sProcessPluginMap.a;     // Catch: Throwable -> L25
        if (r5 == null) goto L10;
        String r3 = (String) ((HashMap) r2.a).get(r5);     // Catch: Throwable -> L25
    L12:
        if (TextUtils.isEmpty(r3) == false) goto L16;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "binder died, but can not find plugin pkg, processName = " + r5);     // Catch: Throwable -> L25
        monitor-exit(r1);
        return;
    L16:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r1);
        IPluginProcessManager r4 = ServerManagerHelper.getPluginProcessManager(r5);
        if (r4 != null) goto L29;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "binder died, but can not find plugin process manager, processName = " + r5);
        return;
    L29:
        r4.warmUpPlugin(r3);     // Catch: RemoteException -> L22
        return;
    L22:
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "relaunch plugin failed");
        return;
    L10:
        r3 = null;
    L25:
        th = move-exception;
        throw th;
    }

    public final void killPluginProcesses(String r9) {
        Object r0 = mPluginProcessLock;
        monitor-enter(r0);
        com.volcengine.zeus.service.server.b r1 = sProcessPluginMap;     // Catch: Throwable -> L58
        r1.getClass();     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r9) == true) goto L10;
        com.volcengine.zeus.service.server.a<String, String> r2 = r1.a;     // Catch: Throwable -> L58
        Object r3 = ((HashMap) r2.b).remove(r9);     // Catch: Throwable -> L58
        if (r3 == null) goto L10;
        ((HashMap) r2.a).remove(r3);     // Catch: Throwable -> L58
    L10:
        boolean r4 = true;
        if (GlobalParam.getInstance().enableHostQueryPluginProcessPid() == false) goto L21;
        if (r9 != null) goto L14;
    L17:
        if (r4 == true) goto L19;
        INSTANCE.killPluginProcessesByHostQuery(r9);     // Catch: Throwable -> L58
    L19:
        monitor-exit(r0);
        return;
    L14:
        if (r9.length() == 0) goto L17;
        r4 = false;
        goto L17
    L21:
        List<ActivityManager.RunningAppProcessInfo> r5 = new ArrayList();     // Catch: Throwable -> L58
        ActivityManager r6 = (ActivityManager) Zeus.getAppApplication().getSystemService("activity");     // Catch: Throwable -> L24 Throwable -> L58
    L25:
        if (r6 == null) goto L30;
        r5 = r6.getRunningAppProcesses();     // Catch: Throwable -> L58
        if (r5 != null) goto L30;
        r5 = new ArrayList();     // Catch: Throwable -> L58
    L30:
        HashMap r7 = new HashMap();     // Catch: Throwable -> L58
        if ((!r5.isEmpty()) == false) goto L36;
        Iterator<ActivityManager.RunningAppProcessInfo> r8 = r5.iterator();     // Catch: Throwable -> L58
    L34:
        if (r8.hasNext() == false) goto L36;
        ActivityManager.RunningAppProcessInfo r10 = r8.next();     // Catch: Throwable -> L58
        r7.put(r10.processName, Integer.valueOf(r10.pid));     // Catch: Throwable -> L58
    L36:
        List<String> r11 = mPluginProcessNames.get(r9);     // Catch: Throwable -> L58
        if (r11 != null) goto L39;
    L55:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L58
        monitor-exit(r0);
        return;
    L39:
        if ((true ^ r11.isEmpty()) == false) goto L55;
        Iterator<String> r13 = r11.iterator();     // Catch: Throwable -> L58
    L42:
        if (r13.hasNext() == false) goto L50;
        String r14 = r13.next();     // Catch: Throwable -> L58
        Integer r15 = (Integer) r7.get(r14);     // Catch: Exception -> L48 Throwable -> L58
        if (r15 == null) goto L42;
        Process.killProcess(r15.intValue());     // Catch: Exception -> L48 Throwable -> L58
    L48:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_SERVER, "kill plugin process failed, plugin = " + r9 + ", processName = " + r14, e);     // Catch: Throwable -> L58
        goto L42
    L50:
        HashMap<String, List<String>> r16 = mPluginProcessNames;     // Catch: Throwable -> L58
        if (r16 == null) goto L54;
        TypeIntrinsics.asMutableMap(r16).remove(r9);     // Catch: Throwable -> L58
        goto L55
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Throwable -> L58
    L24:
        r6 = null;
    L58:
        th = move-exception;
        throw th;
    }

    public final void onBinderDied(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return;
    L5:
        Object r1 = mPluginProcessLock;
        monitor-enter(r1);
        com.volcengine.zeus.service.server.a<String, String> r2 = sProcessPluginMap.a;     // Catch: Throwable -> L20
        if (r9 == null) goto L10;
        String r3 = (String) ((HashMap) r2.a).get(r9);     // Catch: Throwable -> L20
    L12:
        if (TextUtils.isEmpty(r3) == false) goto L16;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "binder died, but can not find plugin pkg, processName = " + r9);     // Catch: Throwable -> L20
        monitor-exit(r1);
        return;
    L16:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r1);
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, String.format("binder died, try relaunch after %d, processName = %s", Arrays.copyOf(new Object[]{Long.valueOf(PLUGIN_RELAUNCH_DELAY), r9}, 2)));
        Handler r5 = mainHandler;
        r5.removeMessages(1, r9);
        Message r6 = Message.obtain();
        r6.what = 1;
        r6.obj = r9;
        r5.sendMessageDelayed(r6, PLUGIN_RELAUNCH_DELAY);
        return;
    L10:
        r3 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.volcengine.zeus.IPluginProcessManager
    public void warmUpPlugin(String r2) throws RemoteException {
        p.a(new b(r2));
    }

    public static final /* synthetic */ void access$tryWarmUpPluginAgain(PluginProcessManager r0, String r1) {
        r0.tryWarmUpPluginAgain(r1);
    }

    @Override // com.volcengine.zeus.IPluginProcessManager
    public void gatherPluginProcessName(String r4, String r5) throws RemoteException {
        if (r4 != null) goto L4;
        return;
    L4:
        Object r0 = mPluginProcessLock;
        monitor-enter(r0);
        HashMap<String, List<String>> r1 = mPluginProcessNames;     // Catch: Throwable -> L16
        List<String> r2 = r1.get(r4);     // Catch: Throwable -> L16
        if (r2 != null) goto L9;
        r2 = new ArrayList();     // Catch: Throwable -> L16
        r1.put(r4, r2);     // Catch: Throwable -> L16
    L9:
        if (r5 != null) goto L11;
    L13:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L11:
        if (r2.contains(r5) == true) goto L13;
        r2.add(r5);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final void registerProcessPlugin(String r3, String r4) {
        Object r0 = mPluginProcessLock;
        monitor-enter(r0);
        sProcessPluginMap.a(r3, r4);     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
