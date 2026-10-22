package com.larus.init.task.bootprotector;

import android.app.Application;
import android.util.EventsUtils;
import bf6.d;
import bg9.i;
import com.bytedance.news.common.settings.SettingsManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.settings.provider.bootprotector.UrgentCmdConfig;
import com.larus.settings.value.e10;
import com.larus.settings.value.h5;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import dg9.a;
import hw9.b;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jg9.c;
import jg9.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/init/task/bootprotector/InitUrgentCmdTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "scene", "getScene", "()Ljava/lang/String;", "settingListenerRegistered", XmlPullParser.NO_NAMESPACE, "runInternal", XmlPullParser.NO_NAMESPACE, "executePreciseCleaning", "gson", "Lcom/google/gson/Gson;", "safelyToJson", "src", XmlPullParser.NO_NAMESPACE, "listenSettingUpdate", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitUrgentCmdTask extends d implements i {
    public final String a;
    public final String b;
    public boolean c;
    public final Gson d;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    public final void c() {
        e10 r1 = e10.a;
        int r2 = l0.a;
        UrgentCmdConfig r3 = (UrgentCmdConfig) l0.a(new UrgentCmdConfig(null, 1, null), new h5());
        FLogger.a.i(this.a, "executePreciseCleaning V1 " + r3);
        List r4 = r3.getUrgentCmds();
        if (r4 == null) goto L18;
        String r5 = this.d.toJson(r4);     // Catch: Throwable -> L6
    L16:
        FLogger.a.i(this.a, "executePreciseCleaning V1 cmd: " + r5);     // Catch: Exception -> L11
        JsonElement r0 = new JsonParser().parse(r5);     // Catch: Exception -> L11
        if (r0.isJsonArray() == false) goto L19;
        JsonArray r6 = r0.getAsJsonArray();     // Catch: Exception -> L11
        IBootProtectorLauncher.a r7 = IBootProtectorLauncher.a;     // Catch: Exception -> L11
        Application r8 = AppHost.a.getApplication();     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L11
        r7.getClass();     // Catch: Exception -> L11
        IBootProtectorLauncher.a.a(r8, r6);     // Catch: Exception -> L11
        return;
    L19:
        return;
    L11:
        e = move-exception;
        FLogger.a.e(this.a, "executePreciseCleaning V1 error: " + e.getMessage());
        return;
    L6:
        r5 = XmlPullParser.NO_NAMESPACE;
        goto L16
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r0 = FLogger.a;
        r0.i(this.a, "task runInternal! Try executePreciseCleaning!");
        ConcurrentHashMap r1 = jg9.d.a;
        e10 r5 = e10.a;     // Catch: Exception -> L12
        b r6 = e10.t0();     // Catch: Exception -> L12
        r0.i("UrgentCmdV2Manager", "onAppLaunch: " + r6);     // Catch: Exception -> L12
        if (Intrinsics.areEqual(r6.a(), Boolean.TRUE) == true) goto L6;
        r0.i("UrgentCmdV2Manager", "onAppLaunch，urgentCmdEnable is false");     // Catch: Exception -> L12
    L8:
        if (jg9.d.e == true) goto L17;
        r0.i("UrgentCmdV2Manager", "listenSettingUpdate V2");     // Catch: Exception -> L12
        SettingsManager.registerListener(new c(), false);     // Catch: Exception -> L12
        jg9.d.e = true;     // Catch: Exception -> L12
    L17:
        c();
        if (this.c == true) goto L24;
        FLogger.a.i(this.a, "listenSettingUpdate V1");
        SettingsManager.registerListener(new a(this), false);
        this.c = true;
        return;
    L24:
        return;
    L6:
        r0.i("UrgentCmdV2Manager", "onAppLaunch, urgentCmdEnable is true");     // Catch: Exception -> L12
        jg9.d.i();     // Catch: Exception -> L12
        jg9.d.d();     // Catch: Exception -> L12
        jg9.d.l();     // Catch: Exception -> L12
        jg9.d.k();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        FLogger.a.e("UrgentCmdV2Manager", "onAppLaunch", e);
        g.a.ensureNotReachHere(e, "UrgentCmd Error: onAppLaunch");
        int r2 = f.a;
        String r3 = e.getMessage();
        if (r3 != null) goto L16;
        r3 = XmlPullParser.NO_NAMESPACE;
    L16:
        f.b("onAppLaunch", r3);
        goto L17
    }

    public InitUrgentCmdTask() {
        this.a = "BootProtectorUrgentCmdTask";
        this.b = "Infra";
        this.d = new GsonBuilder().excludeFieldsWithModifiers(new int[]{128, 8}).create();
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
        return this.b;
    }
}
