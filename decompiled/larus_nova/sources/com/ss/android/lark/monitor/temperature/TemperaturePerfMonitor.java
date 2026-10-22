package com.ss.android.lark.monitor.temperature;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.e;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class TemperaturePerfMonitor extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f432459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f432460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledFuture<?> f432461c;

    public static final class a implements xpc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemperaturePerfMonitor f432463a;

        /* JADX INFO: renamed from: com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor$a$a, reason: collision with other inner class name */
        public static final class RunnableC5138a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TemperaturePerfMonitor f432464a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f432465b;

            public RunnableC5138a(TemperaturePerfMonitor r100, Ref.IntRef r101) {
                this.f432464a = r100;
                this.f432465b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator<d> r100 = this.f432464a.f432460b.iterator();     // Catch: Throwable -> L8
            L4:
                if (r100.hasNext() == false) goto L6;
                r100.next().onThermalStatusChanged(this.f432465b.element);     // Catch: Throwable -> L8
                goto L4
            L6:
                TemperaturePerfMonitor r101 = this.f432464a;     // Catch: Throwable -> L8
                int r102 = this.f432465b.element;     // Catch: Throwable -> L8
                r101.getClass();     // Catch: Throwable -> L8
                TemperaturePerfMonitor.b(r102);     // Catch: Throwable -> L8
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public a(TemperaturePerfMonitor r100) {
            this.f432463a = r100;
        }

        @Override // xpc.a
        public final void a(int r100, Bundle r101) {
            if (r100 == 2) goto L6;
            return;
        L6:
            if (r101.getString("value") == null) goto L22;
            TemperaturePerfMonitor r102 = this.f432463a;
            Ref.IntRef r103 = new Ref.IntRef();     // Catch: Exception -> L17
            xpc.c r104 = xpc.c.b.f564790a;     // Catch: Exception -> L17
            Integer r105 = StringsKt.toIntOrNull(xpc.c.a(CastIntegerProtector.parseInt("2")));     // Catch: Exception -> L17
            if (r105 == null) goto L11;
            int r106 = r105.intValue();     // Catch: Exception -> L17
        L12:
            r103.element = r106;     // Catch: Exception -> L17
            Log.i("TemperatureMonitor", "vivo ThermalStatusListener cpu temperateure level is " + r103.element);     // Catch: Exception -> L17
            ScheduledFuture<?> r107 = r102.f432461c;     // Catch: Exception -> L17
            if (r107 == null) goto L15;
            r107.cancel(true);     // Catch: Exception -> L17
        L15:
            r102.f432461c = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new RunnableC5138a(r102, r103), 60, TimeUnit.SECONDS);     // Catch: Exception -> L17
            return;
        L11:
            r106 = 0;
        L17:
            e = move-exception;
            Log.e("TemperatureMonitor", "parse bundle exception", e);
            return;
        }
    }

    public static final class b implements PowerManager.OnThermalStatusChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemperaturePerfMonitor f432466a;

        public b(TemperaturePerfMonitor r100) {
            this.f432466a = r100;
        }

        @Override // android.os.PowerManager.OnThermalStatusChangedListener
        public final void onThermalStatusChanged(int r100) {
            Log.i("TemperatureMonitor", "ThermalStatusListener status:" + r100);
            TemperaturePerfMonitor r101 = this.f432466a;
            if (r101.f432459a == false) goto L8;
            Iterator<d> r102 = r101.f432460b.iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            r102.next().onThermalStatusChanged(r100 - 1);
        L8:
            this.f432466a.getClass();
            TemperaturePerfMonitor.b(r100);
        }
    }

    public static final class c {
    }

    public interface d {
        void a(float r100);

        void onThermalStatusChanged(int r100);
    }

    static {
    }

    @Override // com.ss.android.lark.monitor.e
    public final void pauseScene(String r100) {
    }

    @Override // com.ss.android.lark.monitor.e
    public final void startScene(String r100) {
    }

    @Override // com.ss.android.lark.monitor.e
    public final void stopScene(String r100, JSONObject r101) {
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor$3] */
    public TemperaturePerfMonitor() {
        this.f432459a = true;
        this.f432460b = Collections.synchronizedList(new ArrayList());
        xpc.c r100 = xpc.c.b.f564790a;
        Object[] r101 = xpc.b.f564784d.b("checkPermission", new Object[]{"0467dacf1f5560a49c10d4fa055a8fa675e58eace6a6c60fa059387e856946f5"});     // Catch: Exception -> L7
        if (r101.length <= 0) goto L8;
        boolean r102 = ((Boolean) r101[0]).booleanValue();     // Catch: Exception -> L7
    L9:
        if (r102 == false) goto L12;
        Log.i("TemperatureMonitor", "vivo sdk init");
        xpc.c.b.f564790a.f564788a = new a(this);
        xpc.b.f564784d.b("callback_register", new Object[]{2, new xpc.c.a()});
    L19:
        a(LarkContext.getApplication(), new AnonymousClass3(this), new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L16
        return;
    L21:
        return;
    L12:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        Object r103 = LarkContext.getApplication().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.os.PowerManager");
        ((PowerManager) r103).addThermalStatusListener(new b(this));
    L8:
        r102 = false;
        goto L9
    }

    public static void b(int r100) {
        if (r100 > 2) goto L10;
        return;
    L10:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L7
        r101.put("scene", MonitorModule.e().d());     // Catch: Throwable -> L7
        r101.put("temperatureType", "cpu");     // Catch: Throwable -> L7
        r101.put("level", r100);     // Catch: Throwable -> L7
        isb.a.c("scene_temperature_info", r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.e("ScenePerfMonitor", th);
    }

    @Override // com.ss.android.lark.monitor.d
    public final void onAppFrontStateChanged(boolean r100) {
        this.f432459a = r100;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r100, AnonymousClass3 r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
