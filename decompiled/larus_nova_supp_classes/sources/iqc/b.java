package iqc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.receiver.BroadcastReceiverProxy;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.service.server.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static b f;
    public final Map<String, a> a;
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> b;
    public final Set<Integer> c;
    public final Map<String, String> d;
    public final Map<String, PluginBroadcastReceiver> e;

    public static b c() {
        if (f != null) goto L15;
        monitor-enter(ServiceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public b() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new CopyOnWriteArraySet();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class b(PluginClassLoader r2, String r3) throws ClassNotFoundException {
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

    public final void d(Context r9, Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getAction() == null) goto L47;
        String r0 = r10.getAction();
        Map<String, a> r1 = this.a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (((ConcurrentHashMap) r1).size() <= 0) goto L49;
        Iterator r2 = ((ConcurrentHashMap) this.a).entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L50;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (r0.equals(r3.getKey()) == false) goto L11;
        a r4 = (a) r3.getValue();
        if (r4 == null) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "action[" + r0 + "] match success ！ invoke onReceiver");
        Set r5 = r4.b;
        if (r5 == null) goto L11;
        if (((CopyOnWriteArraySet) r5).size() <= 0) goto L11;
        Iterator r6 = ((CopyOnWriteArraySet) r4.b).iterator();
    L22:
        if (r6.hasNext() == false) goto L11;
        PluginBroadcastReceiver r7 = (PluginBroadcastReceiver) r6.next();
        if (r7 == null) goto L22;
        r7.onReceive(r9, r10);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + r10.getAction() + "[exception]:", th);
        goto L22
    L50:
        return;
    L49:
        return;
    }

    public final void e(IntentFilter r4, PluginBroadcastReceiver r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.actionsIterator() == null) goto L24;
        Iterator<String> r6 = r4.actionsIterator();
    L7:
        if (r6.hasNext() == false) goto L25;
        String r0 = r6.next();
        if (r0 == null) goto L7;
        a r1 = (a) ((ConcurrentHashMap) this.a).get(r0);
        if (r1 != null) goto L13;
        a r2 = new a();
        r2.a = r0;
        r2.registerReceiver(r5);
        ((ConcurrentHashMap) this.a).put(r0, r2);
        goto L7
    L13:
        r1.registerReceiver(r5);
        goto L7
    L25:
        return;
    }

    public void unregisterReceiver(Context r5, PluginBroadcastReceiver r6) {
        Iterator r0 = ((ConcurrentHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        a r1 = (a) ((Map.Entry) r0.next()).getValue();
        if (r1 == null) goto L8;
        r1.unregisterReceiver(r6);
    L8:
        BroadcastReceiver r2 = (BroadcastReceiver) ((ConcurrentHashMap) this.b).get(r6);
        if (r2 == null) goto L4;
        Set<Integer> r3 = this.c;     // Catch: Throwable -> L20
        CopyOnWriteArraySet r4 = (CopyOnWriteArraySet) r3;     // Catch: Throwable -> L20
        r4.remove(Integer.valueOf(r2.hashCode()));     // Catch: Throwable -> L20
        ((ConcurrentHashMap) this.b).remove(r6);     // Catch: Throwable -> L20
        ReceiverRegisterLancet.loge(r2, false);     // Catch: Throwable -> L20
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L18;
    L16:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r2.toString());     // Catch: Throwable -> L20
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L4
    L13:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r5) == false) goto L4;
        r5.unregisterReceiver(r2);     // Catch: Exception -> L16 Throwable -> L20
    L18:
        r5.unregisterReceiver(r2);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th);
        goto L4
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Context r8, BroadcastReceiverProxy r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    public Intent registerReceiver(Context r3, PluginBroadcastReceiver r4, IntentFilter r5, String r6) {
        if (r5 != null) goto L5;
    L12:
        return null;
    L5:
        if (r5.actionsIterator() == null) goto L12;
        if (r4 == null) goto L9;
        BroadcastReceiverProxy r0 = new BroadcastReceiverProxy(r6);
        Intent r7 = a(r3, r0, r5);
        ((ConcurrentHashMap) this.b).put(r4, r0);
        e(r5, r4);
        return r7;
    L9:
        return a(r3, null, r5);
    }

    public Intent registerReceiver(Context r9, PluginBroadcastReceiver r10, IntentFilter r11, int r12, String r13) {
        if (r11 != null) goto L5;
    L46:
        return null;
    L5:
        if (r11.actionsIterator() == null) goto L46;
        if (Build.VERSION.SDK_INT < 26) goto L46;
        if (r10 == null) goto L11;
        BroadcastReceiverProxy r7 = new BroadcastReceiverProxy(r13);
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L47;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L47:
    L39:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L45;
        Intent r14 = ReceiverRegisterCrashOptimizer.registerReceiver(r7, r11, r12);
    L43:
        ((ConcurrentHashMap) this.b).put(r10, r7);
        e(r11, r10);
        return r14;
    L45:
        throw e;
    L16:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L30;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L30;
        ReceiverRegisterAnrOptimizer.ResultWrapper r15 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r7, r11, r12, null, null, 3, r9);     // Catch: Exception -> L39
        int r0 = r15.result;     // Catch: Exception -> L39
        if (r0 != 1) goto L22;
        r14 = r9.registerReceiver(r7, r11, r12);     // Catch: Exception -> L39
        goto L43
    L22:
        if (r0 != 2) goto L24;
        r14 = new Intent();     // Catch: Exception -> L39
        goto L43
    L24:
        if (r0 == 3) goto L26;
        r14 = r9.registerReceiver(r7, r11, r12);     // Catch: Exception -> L39
        goto L43
    L26:
        r14 = r15.intent;     // Catch: Exception -> L39
    L30:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L33;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L39
        r14 = r9.registerReceiver(r7, r11, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L39
        goto L43
    L33:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L35;
    L37:
        r14 = r9.registerReceiver(r7, r11, r12);     // Catch: Exception -> L39
        goto L43
    L35:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r11) == false) goto L37;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L39
        r14 = ContextCompat.registerReceiver(r9, r7, r11, null, ReceiverRegisterLancet.sProxyHandler, r12);     // Catch: Exception -> L39
        goto L43
    L11:
        return a(r9, null, r11);
    }

    public Intent registerReceiver(Context r9, PluginBroadcastReceiver r10, IntentFilter r11, String r12, Handler r13, String r14) {
        if (r11 != null) goto L5;
    L39:
        return null;
    L5:
        if (r11.actionsIterator() == null) goto L39;
        if (r10 == null) goto L9;
        BroadcastReceiverProxy r7 = new BroadcastReceiverProxy(r14);
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        Intent r15 = ReceiverRegisterCrashOptimizer.registerReceiver(r7, r11, r12, r13);
    L33:
        ((ConcurrentHashMap) this.b).put(r10, r7);
        if (r13 == null) goto L36;
        Set<Integer> r16 = this.c;
        CopyOnWriteArraySet r17 = (CopyOnWriteArraySet) r16;
        r17.add(Integer.valueOf(r7.hashCode()));
    L36:
        e(r11, r10);
        return r15;
    L38:
        throw e;
    L14:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L16;
    L27:
        r15 = r9.registerReceiver(r7, r11, r12, r13);     // Catch: Exception -> L29
        goto L33
    L16:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L27;
        ReceiverRegisterAnrOptimizer.ResultWrapper r18 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r7, r11, 0, r12, r13, 4, r9);     // Catch: Exception -> L29
        int r0 = r18.result;     // Catch: Exception -> L29
        if (r0 != 1) goto L20;
        r15 = r9.registerReceiver(r7, r11, r12, r13);     // Catch: Exception -> L29
        goto L33
    L20:
        if (r0 != 2) goto L22;
        r15 = new Intent();     // Catch: Exception -> L29
        goto L33
    L22:
        if (r0 == 3) goto L24;
        r15 = r9.registerReceiver(r7, r11, r12, r13);     // Catch: Exception -> L29
        goto L33
    L24:
        r15 = r18.intent;     // Catch: Exception -> L29
        goto L33
    L9:
        return a(r9, null, r11);
    }

    public Intent registerReceiver(Context r9, PluginBroadcastReceiver r10, IntentFilter r11, String r12, Handler r13, int r14, String r15) {
        if (r11 != null) goto L5;
    L41:
        return null;
    L5:
        if (r11.actionsIterator() == null) goto L41;
        if (Build.VERSION.SDK_INT < 26) goto L41;
        if (r10 == null) goto L11;
        BroadcastReceiverProxy r7 = new BroadcastReceiverProxy(r15);
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        Intent r16 = ReceiverRegisterCrashOptimizer.registerReceiver(r7, r11, r12, r13, r14);
    L35:
        ((ConcurrentHashMap) this.b).put(r10, r7);
        if (r13 == null) goto L38;
        Set<Integer> r17 = this.c;
        CopyOnWriteArraySet r18 = (CopyOnWriteArraySet) r17;
        r18.add(Integer.valueOf(r7.hashCode()));
    L38:
        e(r11, r10);
        return r16;
    L40:
        throw e;
    L16:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L18;
    L29:
        r16 = r9.registerReceiver(r7, r11, r12, r13, r14);     // Catch: Exception -> L31
        goto L35
    L18:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L29;
        ReceiverRegisterAnrOptimizer.ResultWrapper r19 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r7, r11, r14, r12, r13, 5, r9);     // Catch: Exception -> L31
        int r0 = r19.result;     // Catch: Exception -> L31
        if (r0 != 1) goto L22;
        r16 = r9.registerReceiver(r7, r11, r12, r13, r14);     // Catch: Exception -> L31
        goto L35
    L22:
        if (r0 != 2) goto L24;
        r16 = new Intent();     // Catch: Exception -> L31
        goto L35
    L24:
        if (r0 == 3) goto L26;
        r16 = r9.registerReceiver(r7, r11, r12, r13, r14);     // Catch: Exception -> L31
        goto L35
    L26:
        r16 = r19.intent;     // Catch: Exception -> L31
        goto L35
    L11:
        return a(r9, null, r11);
    }
}
