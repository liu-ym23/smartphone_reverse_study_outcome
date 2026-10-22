package com.bytedance.helios.sdk;

import android.os.Looper;
import android.util.Pair;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f245494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f245495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f245496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f245497d = null;

    public b() {
    }

    static {
        f245497d = new b();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.helios.sdk.ActionInvokeEntranceImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.helios.sdk.ActionInvokeEntranceImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.helios.sdk.ActionInvokeEntranceImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.helios.sdk.ActionInvokeEntranceImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.helios.sdk.ActionInvokeEntranceImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.helios.sdk.ActionInvokeEntranceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.helios.sdk.ActionInvokeEntranceImpl");
    }

    public static void c(long r100, PrivacyEvent r101) {
        long r102 = (System.nanoTime() - r100) / ((long) 1000);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        int r103 = 1;
    L6:
        hz5.a r104 = hz5.a.d("timon_pipeline_apm");
        r104.a("EventName", "ActionInvokerEntrance.invoke");
        r104.a("MainThread", Integer.valueOf(r103));
        r104.a("optimize_enable", Boolean.valueOf(HeliosEnvImpl.get().f245470m.u()));
        Long r105 = Long.valueOf(r102);
        r104.f487681c.put("ActionInvokerEntrance.invoke", r105);
        r104.a("api_id", Integer.valueOf(r101.f245366c));
        hz5.l.b(r104);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @JvmStatic
    public static final Pair<Boolean, Object> b(Object r110, Object r111, Object[] r112, int r113, String r210, boolean r211, int r212, String r213, String r214) {
        long r114 = System.nanoTime();
        b r100 = f245497d;
        PrivacyEvent r115 = null;
        if (f245496c == null) goto L5;
    L26:
        a r101 = f245496c;
        if (r101 == null) goto L63;
        long r102 = System.currentTimeMillis();
        if (HeliosEnvImpl.get().e() == true) goto L33;
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", "triggerAction: not enabled, return id=" + r113 + " calledTime=" + r102);
        return new Pair(Boolean.FALSE, null);
    L33:
        if (HeliosEnvImpl.get().f245470m.r().contains(Integer.valueOf(r113)) == false) goto L37;
        return new Pair(Boolean.FALSE, null);
    L37:
        if (HeliosEnvImpl.get().f245474q.contains(Integer.valueOf(r113)) == false) goto L40;
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", "this event only support binder: id=" + r113);
        return new Pair(Boolean.FALSE, null);
    L40:
        PrivacyEvent r103 = r101.createPrivacyEvent(r110, r111, r112, r113, r210, r102, r211, r213, r214);
        if (r212 != 1) goto L43;
        Pair<Boolean, Object> r104 = r101.actionIntercept(r103);
        if (r103 == null) goto L61;
        c(r114, r103);
    L61:
        return r104;
    L43:
        if (r212 != 2) goto L45;
        Pair<Boolean, Object> r105 = r101.actionIntercept(r103);
        if (((Boolean) r105.first).booleanValue() == true) goto L55;
        if (r103 == null) goto L54;
        r115 = r103.a();
    L54:
        r101.actionInvoke(r115);
    L55:
        if (r103 == null) goto L57;
        c(r114, r103);
    L57:
        return r105;
    L45:
        if (r212 != 3) goto L63;
        r101.actionInvoke(r103);
        if (r103 == null) goto L63;
        c(r114, r103);
    L63:
        return new Pair(Boolean.FALSE, null);
    L5:
        if (f245494a == false) goto L26;
        monitor-enter(r100);
    L23:
        th = move-exception;
        throw th;
    L8:
        if (f245496c == null) goto L65;
    L20:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r100);
        goto L26
    L65:
        Object r107 = a().newInstance();     // Catch: Throwable -> L14
        if (r107 == null) goto L13;
        a r108 = (a) r107;     // Catch: Throwable -> L14
    L18:
        f245496c = r108;     // Catch: Throwable -> L23
        goto L20
    L13:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.sdk.ActionInvokeEntranceDef");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (f245495b == true) goto L19;
        th.printStackTrace();     // Catch: Throwable -> L23
        f245494a = false;     // Catch: Throwable -> L23
        r108 = null;
        goto L18
    L19:
        throw th;     // Catch: Throwable -> L23
    }
}
