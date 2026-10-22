package com.larus.init.task.xtrace;

import android.os.Build;
import android.os.Process;
import android.util.EventsUtils;
import bf6.d;
import bg9.i;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.xtrace.HookMode;
import com.bytedance.xtrace.XTrace;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.settings.value.e10;
import com.larus.settings.value.mx;
import com.larus.utils.f;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.text.StringsKt;
import lg9.c;
import lg9.e;
import org.xmlpull.v1.XmlPullParser;
import qt9.b5;
import qt9.z4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J/\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/init/task/xtrace/InitXTraceTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "enableXTraceInDebug", XmlPullParser.NO_NAMESPACE, "runInternal", XmlPullParser.NO_NAMESPACE, "reportProguardEvent", "xTraceConfig", "Lcom/larus/settings/provider/XTraceConfig;", "member", "Ljava/lang/reflect/Member;", "args", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "(Lcom/larus/settings/provider/XTraceConfig;Ljava/lang/reflect/Member;[Ljava/lang/Object;)V", "reportTeaEvent", "event", "method", "tip", "appendXTraceInfoToNpthAttachData", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitXTraceTask extends d implements i {
    public static volatile boolean b;
    public static volatile int c;
    public static final ConcurrentHashMap<String, Boolean> d = null;
    public final String a;

    public static final class a {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    static {
        c = -1;
        d = new ConcurrentHashMap();
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r0 = FLogger.a;
        r0.i("InitXTraceTask", "InitXTraceTask runInternal");
        if (b == false) goto L6;
        r0.e("InitXTraceTask", "XTrace is already inited!!!");
        return;
    L6:
        e10 r2 = e10.a;
        int r3 = l0.a;
        z4 r4 = (z4) l0.a(new z4(null), new mx());
        r0.i("InitXTraceTask", "XTraceConfig: " + r4);
        r0.i("InitXTraceTask", "enableXTraceInDebug: false, enableXTraceInSetting: " + r4.c());
        if (r4.c() == true) goto L11;
        r0.e("InitXTraceTask", "XTrace is DISABLED!!!");
        return;
    L11:
        if (Build.VERSION.SDK_INT >= 23) goto L13;
    L18:
        List r5 = r4.a();
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == false) goto L29;
        r0.e("InitXTraceTask", "XTrace is DISABLED for the reason of EMPTY config!!!");
        return;
    L29:
        if (o0.d(r4.f()) == true) goto L31;
    L34:
        b = true;
        XTrace.enableLog(r4.d());
        XTrace.setHookMode(HookMode.MODE_REPLACE);
        XTrace.init(AppHost.a.getApplication());
        XTrace.setHookCallback(new lg9.d(this, r4));
        List r1 = r4.a();
        if (r1 == null) goto L67;
        Iterator r7 = r1.iterator();
    L38:
        if (r7.hasNext() == false) goto L67;
        b5 r8 = (b5) r7.next();
        if (r8 == null) goto L42;
        String r9 = r8.a();
    L43:
        if (r9 != null) goto L45;
    L48:
        boolean r10 = true;
    L49:
        if (r10 == true) goto L66;
        String r11 = r8.b();
        if (r11 != null) goto L53;
    L56:
        boolean r12 = true;
    L57:
        if (r12 == true) goto L66;
        Member r13 = c.b(r8.a(), r8.b(), r8.c());     // Catch: Throwable -> L64
        String r14 = r8.a() + '#' + r8.b();     // Catch: Throwable -> L64
        if (r13 != null) goto L61;
        String r15 = "dynamic hook get method failed: " + r14 + " (methodSign: " + r8.c() + ')';     // Catch: Throwable -> L64
        FLogger.a.e("InitXTraceTask", r15);     // Catch: Throwable -> L64
        g.a.ensureNotReachHere(new Exception(r15), r15);     // Catch: Throwable -> L64
        c("xtrace_hook_failed", r14, r15);     // Catch: Throwable -> L64
        goto L38
    L61:
        String r16 = "dynamic hook get method success: " + r14;     // Catch: Throwable -> L64
        FLogger.a.i("InitXTraceTask", r16);     // Catch: Throwable -> L64
        c("xtrace_hook_success", r14, r16);     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        FLogger.a.e("InitXTraceTask", "dynamic hook failed", th);
        goto L38
    L53:
        if (r11.length() == 0) goto L56;
        r12 = false;
    L66:
        FLogger.a.e("InitXTraceTask", "Invalid config: className or methodName is empty");
        goto L38
    L45:
        if (r9.length() == 0) goto L48;
        r10 = false;
        goto L49
    L42:
        r9 = null;
    L67:
        HashMap r17 = new HashMap();
        r17.put("xtrace_config", r4.toString());
        Npth.addAttachUserData(new e(r17), CrashType.ALL);
        return;
    L31:
        if (StringsKt.equals$default(r4.f(), String.valueOf(AppHost.a.getUpdateVersionCode()), false, 2, null) == true) goto L34;
        r0.e("InitXTraceTask", "XTrace is DISABLED for the reason of MISMATCH updateVersionCode!!!");
        return;
    L21:
        if (r5.isEmpty() == true) goto L24;
        r6 = false;
        goto L25
    L13:
        if (r4.b() == true) goto L18;
        if (Process.is64Bit() == true) goto L18;
        r0.e("InitXTraceTask", "InitXTraceTask: 32bit device is DISABLED by Settings!!!");
    }

    public InitXTraceTask() {
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

    public static void c(String r2, String r3, String r4) {
        IApplog.a.b(r2, f.c(new Pair[]{TuplesKt.to("method", r3), TuplesKt.to("tips", r4)}));
    }
}
