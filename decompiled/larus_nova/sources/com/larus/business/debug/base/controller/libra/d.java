package com.larus.business.debug.base.controller.libra;

import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.settings.value.w9;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import ft9.k;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import qt9.o4;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f320034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f320035b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f320036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PthreadTimer f320037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f320038e;

    /* JADX INFO: loaded from: classes26.dex */
    public static final class a extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            String r100 = d.f320034a;     // Catch: Throwable -> L4
            Function1 r101 = new b();     // Catch: Throwable -> L4
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CriticalLibraController$fetchAndCompareSetting$1(r101, null), 3, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a() {
        }
    }

    static {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        String r100 = "https";
    L6:
        f320034a = r100.concat("://www.doubao.com/inapp/ab-testing?major=1");
        f320035b = Keva.getRepo("CriticalLibraController.SETTINGS_KEY_LOCAL_REPO");
        k r101 = k.f478804a;
        Function1<JSONObject, Unit> r102 = new com.larus.business.debug.base.controller.libra.a();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        k.f478805b.add(r102);
        if (k.f478813j == null) goto L10;
        r102.invoke(k.f478813j);
        return;
    L10:
        return;
    L5:
        r100 = "http";
        goto L6
    }

    public static void a() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        o4 r102 = (o4) l0.a(new o4(), new w9());
        if (r102.a() == true) goto L6;
        FLogger.f375446a.i("CriticalLibraController", "change toast is not enabled");
        return;
    L6:
        int r103 = r102.b();
        if (r103 >= 0) goto L10;
        FLogger.f375446a.i("CriticalLibraController", "change toast delay time is not valid");
        return;
    L10:
        a r104 = f320038e;
        if (r104 == null) goto L13;
        r104.cancel();
    L13:
        f320038e = null;
        PthreadTimer r105 = f320037d;
        if (r105 == null) goto L16;
        r105.cancel();
    L16:
        f320037d = null;
        f320035b.storeBoolean("CriticalLibraController.SETTINGS_KEY_LOCAL_NEW_SETTING_FETCHED", false);
        f320037d = new PthreadTimer("CriticalLibraController");
        a r106 = new a();
        f320038e = r106;
        PthreadTimer r107 = f320037d;
        if (r107 == null) goto L20;
        r107.schedule(r106, ((long) r103) * 1000);
        return;
    }
}
