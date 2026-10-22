package com.larus.ivykit.web;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.ProcessFeatureIndex;
import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.p;
import com.bytedance.lynx.webview.internal.q;
import com.bytedance.lynx.webview.internal.r;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l17.n;
import org.json.JSONObject;
import sg9.c;
import sg9.d;
import sg9.e;
import sg9.f;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0011H\u0002J$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J4\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0010\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0010\u0010\u001b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001fH\u0002J\u001a\u0010 \u001a\u00020\u001a2\u0010\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001fH\u0002J\u001c\u0010!\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u001a\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u001f\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(H\u0082\b¨\u0006*"}, d2 = {"Lcom/larus/ivykit/web/TTWebViewServiceImpl;", "Lcom/larus/ivykit/web/TTWebViewService;", "<init>", "()V", "init", "", "app", "Landroid/app/Application;", "isTTWebView", "", "webView", "Landroid/webkit/WebView;", "isUsedTTWebView", "initTTWebViewMainProcess", "initTTWebViewSubProcess", "isApp64Bit", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setBasicInfoForTTWebView", "initAlogForTTWebView", "initNpthForTTWebView", "initDataReportForTTWebView", "reportTTWebViewEvent", "eventCode", "", "data", "Lorg/json/JSONObject;", "extra", "reportTTWebViewData", "eventName", "", "", "reportDataToJson", "mergeJson", "copyJsonValues", "source", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "reportSafely", "reportType", "report", "Lkotlin/Function0;", "Companion", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TTWebViewServiceImpl implements TTWebViewService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f351657a = 0;

    public static final class a {
    }

    public static final class b implements q {
        public b() {
        }

        @Override // com.bytedance.lynx.webview.internal.q
        public final void a(String r100, String r101) {
            FLogger r102 = FLogger.f375446a;
            if (r100 != null) goto L5;
            r100 = "TTWebView";
        L5:
            r102.e(r100, r101);
        }

        @Override // com.bytedance.lynx.webview.internal.q
        public final void b(String r100, String r101) {
            FLogger r102 = FLogger.f375446a;
            if (r100 != null) goto L5;
            r100 = "TTWebView";
        L5:
            r102.d(r100, r101);
        }

        @Override // com.bytedance.lynx.webview.internal.q
        public final void c(String r100, String r101) {
            FLogger r102 = FLogger.f375446a;
            if (r100 != null) goto L5;
            r100 = "TTWebView";
        L5:
            r102.i(r100, r101);
        }
    }

    static {
    }

    public TTWebViewServiceImpl() {
    }

    public static void e() {
        FLogger.f375446a.i("TTWebViewServiceImpl", "initNpthForTTWebView");
        Npth.addAttachUserData(new sg9.b(), CrashType.ALL);
        Npth.registerCrashCallback(new c(), CrashType.LAUNCH);
    }

    @Override // com.larus.ivykit.web.TTWebViewService
    public final boolean a() {
        return TTWebSdk.isTTWebView();
    }

    public static void d(Context r100) {
        FLogger.f375446a.i("TTWebViewServiceImpl", "initAlogForTTWebView");
        b r101 = new b();
        r.f265356b = r101;
        r.f265357c = true;
        StringBuilder r102 = new StringBuilder("[TT_WEB_");
        if (n.d(r100) == false) goto L5;
        String r103 = PullConfiguration.PROCESS_NAME_MAIN;
    L14:
        r102.append(r103);
        r102.append("]");
        r.f265355a = r102.toString();
    L15:
        ConcurrentLinkedQueue<String> r104 = r.f265358d;
        if (r104.isEmpty() == true) goto L19;
        r.f265356b.a(r.f265355a, r104.poll());
        goto L15
    L19:
        if (TTWebContext.c(r100) == null) goto L33;
        Object r105 = p.f265346a;
        monitor-enter(p.class);
    L30:
        th = move-exception;
        throw th;
    L23:
        if (p.f265350e.get() == true) goto L26;
        p.f265347b = r101;     // Catch: Throwable -> L30
    L28:
        monitor-exit(p.class);     // Catch: Throwable -> L30
        return;
    L26:
        if (Setting.c().b("sdk_enable_alog_write", true) == true) goto L28;
        p.f265347b = r101;     // Catch: Throwable -> L30
        goto L28
    L33:
        return;
    L5:
        String r106 = n.b(r100);
        if (r106 == null) goto L10;
        String[] r107 = r106.split(":");
        if (r107.length != 2) goto L10;
        r103 = r107[1];
    L11:
        int r108 = r103.length();
        if (r108 <= 0) goto L14;
        r103 = r103.substring(0, Math.min(r103.length(), 5)) + r103.charAt(r108 - 1);
    L10:
        r103 = null;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [sg9.a] */
    @Override // com.larus.ivykit.web.TTWebViewService
    public final void init(Application r110) {
        Intrinsics.checkNotNullParameter(r110, "app");
        if (q0.c(r110) == false) goto L36;
        long r100 = System.currentTimeMillis();
        FLogger r101 = FLogger.f375446a;
        r101.i("TTWebViewServiceImpl", "init ttwebview start in main process");
        r101.i("TTWebViewServiceImpl", "setBasicInfoForTTWebView");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        boolean r102 = Process.is64Bit();
    L19:
        if (r102 == false) goto L21;
        String r103 = BDLocationException.ERROR_RESTRICTED_MODE_ON;
    L22:
        TTWebSdk.setHostAbi(r103);
        TTWebSdk.setAppInfoGetter(new f());
        d(r110);
        e();
        r101.i("TTWebViewServiceImpl", "initDataReportForTTWebView");
        d r104 = new d(this);
        if (TTWebContext.c(r110) != null) goto L25;
    L34:
        com.bytedance.lynx.webview.c.a(r110, new sg9.a(this));
        TTWebSdk.initTTWebView(r110, new e());
        r101.i("TTWebViewServiceImpl", "init ttwebview end in main process, cost " + (System.currentTimeMillis() - r100) + "ms");
        return;
    L25:
        if (TTWebContext.h().u(ProcessFeatureIndex.ENABLE_UPLOAD_EVENT.value()) == false) goto L34;
        int r105 = EventStatistics.f265113a;
        monitor-enter(EventStatistics.class);
        EventStatistics.f265119g = r104;     // Catch: Throwable -> L31
        monitor-exit(EventStatistics.class);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L21:
        r103 = BDLocationException.ERROR_CONNECT_GOOGLE_FAIL;
        goto L22
    L7:
        String r106 = r110.getApplicationInfo().nativeLibraryDir;
        if (r106 != null) goto L10;
    L13:
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
    L18:
        r102 = false;
        goto L19
    L16:
        if (StringsKt.endsWith$default(r106, "arm64", false, 2, null) == false) goto L18;
        r102 = true;
        goto L19
    L10:
        if (r106.length() == 0) goto L13;
        r107 = false;
        goto L14
    L36:
        if (TTWebSdk.needInitIndependent(r110) == false) goto L38;
        FLogger r108 = FLogger.f375446a;
        r108.i("TTWebViewServiceImpl", "init ttwebview start in webview process");
        d(r110);
        e();
        TTWebSdk.initTTWebView(r110);
        r108.i("TTWebViewServiceImpl", "init ttwebview end in webview process");
        return;
    L38:
        FLogger.f375446a.i("TTWebViewServiceImpl", "init ttwebview not need this process");
    }

    public static void c(JSONObject r100, JSONObject r101) {
        Iterator<String> r102 = r100.keys();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        r101.put(r103, r100.opt(r103));
        goto L6
    }

    public static final void b(TTWebViewServiceImpl r100, int r101, JSONObject r102, JSONObject r103) {
        r100.getClass();
        FLogger.f375446a.d("TTWebViewServiceImpl", "reportTTWebViewEvent, eventCode=" + r101);
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L5
        c(r102, r104);     // Catch: Throwable -> L5
        c(r103, r104);     // Catch: Throwable -> L5
        r104.put("status", r101);     // Catch: Throwable -> L5
        o.f365780a.reportEvent("ttwebview_sdk_detail", r104);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        FLogger.f375446a.e("TTWebViewServiceImpl", "report ttwebview Tea event failed", th);
    }
}
