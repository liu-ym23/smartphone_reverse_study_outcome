package com.larus.apm.impl;

import ai4.n;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.EventsUtils;
import com.bytedance.apm.d;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.util.b;
import com.bytedance.keva.Keva;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larus.apm.api.IApmConfigs;
import com.larus.apm.api.INpth;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ec9.d0;
import java.io.BufferedReader;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import q48.o;
import q48.p;
import q48.q;
import q48.r;
import q48.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/apm/impl/NpthImpl;", "Lcom/larus/apm/api/INpth;", "<init>", "()V", "init", XmlPullParser.NO_NAMESPACE, "baseCtx", "Landroid/content/Context;", "deviceIdKV", "Lcom/bytedance/keva/Keva;", "trySaveDeviceIdToKeva", "getDeviceIdFromKeva", XmlPullParser.NO_NAMESPACE, "getDeviceIdForNpth", "registerExitReasonCallback", "addAttachUserData", "registerCrashCallbackOnResNotFound", "registerCrashCallback", "getCurrentDateString", "crashCallback", "Lcom/larus/apm/api/ICrashCallback;", "getProcessNameFromCmd", "stopUpload", "stop", XmlPullParser.NO_NAMESPACE, "goUpload", "startNpthLifecycleRecorder", "app", "Landroid/app/Application;", "maxLifeCycleCount", XmlPullParser.NO_NAMESPACE, "enableGwpAsan", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class NpthImpl implements INpth {
    public static final /* synthetic */ int c = 0;
    public final Keva b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.apm.api.INpth
    public final void d() {
        Npth.enableGwpAsan(true);
    }

    public static String f() {
        BufferedReader r2 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + Process.myPid() + "/cmdline"));     // Catch: Throwable -> L26
        String r0 = r2.readLine();     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r0) == true) goto L32;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L25
        int r3 = r0.length() - 1;     // Catch: Throwable -> L25
        int r6 = 0;
        boolean r7 = false;
    L7:
        if (r6 > r3) goto L22;
        if (r7 == true) goto L10;
        int r8 = r6;
    L12:
        if (Intrinsics.compare(r0.charAt(r8), 32) > 0) goto L14;
        boolean r9 = true;
    L15:
        if (r7 == false) goto L16;
        if (r9 == false) goto L22;
        r3 = r3 - 1;     // Catch: Throwable -> L25
        goto L7
    L16:
        if (r9 == false) goto L17;
        r6 = r6 + 1;     // Catch: Throwable -> L25
        goto L7
    L17:
        r7 = true;
        goto L7
    L14:
        r9 = false;
        goto L15
    L10:
        r8 = r3;
    L22:
        r0 = r0.subSequence(r6, r3 + 1).toString();     // Catch: Throwable -> L25
    L32:
        r2.close();     // Catch: IOException -> L30
    L24:
        return r0;
    L27:
        if (r2 != null) goto L34;
    L29:
        return null;
    L34:
        r2.close();     // Catch: IOException -> L31
    L26:
        r2 = null;
        goto L27
    }

    public final String e() {
        String r0 = this.b.getString("latest_did", XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        FLogger.a.i("NpthImpl", "getDeviceIdFromKeva latest_did empty");
    L8:
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        if (Intrinsics.areEqual(MiraMonitor.VALUE_DEFAULT, r0) == true) goto L7;
        FLogger.a.i("NpthImpl", "getDeviceIdFromKeva latest_did success");
        goto L8
    }

    public NpthImpl() {
        this.b = Keva.getRepo("device_id_repo", 1);
    }

    @Override // com.larus.apm.api.INpth
    public final void b(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "crashCallback");
        Npth.registerCrashCallback(new o(r2), CrashType.ALL);
    }

    @Override // com.larus.apm.api.INpth
    public final void c(boolean r1) {
        if (r1 == false) goto L5;
        Npth.stopUpload();
        return;
    }

    @Override // com.larus.apm.api.INpth
    public final void init(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "baseCtx");
        IApmConfigs r0 = (IApmConfigs) ServiceManager.get().getService(IApmConfigs.class);
        if (r0 == null) goto L11;
        ConfigManager r1 = Npth.getConfigManager();
        r1.setJavaCrashUploadUrl(r0.f());
        r1.setLaunchCrashUrl(r0.c());
        r1.setNativeCrashUrl(r0.d());
        r1.setAlogUploadUrl(r0.i());
        AppHost.Companion r2 = AppHost.a;
        r1.setDebugMode(r2.isDebug());
        r1.setConfigGetUrl(r0.h());
        Npth.setApplication(r2.getApplication());
        b.a = f();
        ObricAlogServiceDelegate.b.d();
        Npth.init(r5, new b(this), true, true, true);
        IApplog.a.j(new c());
        q r6 = new q(this);
        CrashType r3 = CrashType.ALL;
        Npth.registerCrashCallback(r6, r3);
        if (Build.VERSION.SDK_INT < 30) goto L8;
        p r7 = new p();
        n.g.add(r7);
    L8:
        s r8 = new s();
        Npth.registerCrashCallback(r8, CrashType.JAVA);
        Npth.registerCrashCallback(r8, CrashType.LAUNCH);
        Npth.addAttachUserData(new q48.n(), r3);
        FLogger.a.i("NpthImpl", "trySaveDeviceIdToKeva start delay 2s");
        t0.b(new r(this), 2000);
        return;
    L11:
        throw new IllegalStateException();
    }

    @Override // com.larus.apm.api.INpth
    public final void a(Application r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "app");
        Application.ActivityLifecycleCallbacks r7 = NpthLifecycleRecoder.a;
        AppHost.Companion r1 = AppHost.a;
        Application r2 = r1.getApplication();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "app");
        NpthLifecycleRecoder.g = r2;
        NpthLifecycleRecoder.i = r6;
        r7.a(r2, "onAppCreate, process:" + d.c() + ", " + r1.getAppId() + ' ' + r1.getBuildChannel() + ' ' + r1.getVersionName() + ' ' + r1.getVersionCode() + ' ' + r1.isDebug());
        r7.b(r2, "onAppCreate");
        r2.registerActivityLifecycleCallbacks(r7);
    }
}
