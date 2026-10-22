package com.larus.init.task.xtrace;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.util.EventsUtils;
import bf6.d;
import bg9.i;
import com.bytedance.crash.Npth;
import com.bytedance.dtrace.DTrace;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.settings.value.uu;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import lg9.b;
import org.xmlpull.v1.XmlPullParser;
import qt9.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/init/task/xtrace/InitDTraceTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "enableDTraceInDebug", XmlPullParser.NO_NAMESPACE, "runInternal", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitDTraceTask extends d implements i {
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r0 = FLogger.a;
        r0.i("InitDTraceTask", "InitDTraceTask runInternal");
        boolean r2 = InitXTraceTask.b;
        if (InitXTraceTask.b == false) goto L6;
        r0.e("InitDTraceTask", "XTrace is already inited!!!");
        return;
    L6:
        e10 r3 = e10.a;
        int r4 = l0.a;
        m0 r5 = (m0) l0.a(new m0(null), new uu());
        r0.i("InitDTraceTask", "DTraceConfig: " + r5);
        r0.i("InitDTraceTask", "enableDTraceInDebug: false, enableDTraceInSetting: " + r5.a());
        if (r5.a() == true) goto L11;
        r0.e("InitDTraceTask", "DTrace is DISABLED!!!");
        return;
    L11:
        if (o0.d(r5.c()) == true) goto L13;
    L16:
        InitXTraceTask.b = true;
        Application r6 = AppHost.a.getApplication();
        if (Build.VERSION.SDK_INT >= 26) goto L20;
        r0.w("DTraceHelper", "just process >= 8 system version");
        return;
    L20:
        if (Process.is64Bit() == true) goto L22;
        r0.w("DTraceHelper", "just process 64 bits system");
        return;
    L22:
        Npth.addTag("dtrace_enable", "true");
        if (b.a == true) goto L37;
        DTrace.setTraceListener(new lg9.a());
        if (DTrace.init(r6) == false) goto L31;
        System.err.println("init trace success");
        r0.d("DTraceHelper", "init trace success");
        b.a();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        System.err.println("startHook failed:" + th);
        FLogger.a.e("DTraceHelper", "startHook failed:" + th);
    L31:
        b.a = true;
        return;
    L37:
        return;
    L13:
        if (StringsKt.equals$default(r5.c(), String.valueOf(AppHost.a.getUpdateVersionCode()), false, 2, null) == true) goto L16;
        r0.e("InitDTraceTask", "DTrace is DISABLED for the reason of MISMATCH updateVersionCode!!!");
    }

    public InitDTraceTask() {
        this.a = "Infra";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }
}
