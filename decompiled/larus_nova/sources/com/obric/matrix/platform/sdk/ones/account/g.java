package com.obric.matrix.platform.sdk.ones.account;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class g extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f396941c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile com.obric.matrix.platform.sdk.ones.account.a f396942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Map<String, String> f396943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<cka.a> f396944f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f396945g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<cka.a> f396946h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<cka.a> f396947i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Handler f396948j = null;

    public static final class a extends i {
        @Override // com.obric.matrix.platform.sdk.ones.account.i, cka.a
        public final void a() {
            super.a();
            Set<cka.a> r100 = g.f396946h;
            monitor-enter(r100);
            Iterator r101 = ((CopyOnWriteArraySet) r100).iterator();     // Catch: Throwable -> L11
        L6:
            if (r101.hasNext() == false) goto L8;
            ((cka.a) r101.next()).a();     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r100);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.i, cka.a
        public final void b() {
            super.b();
            Set<cka.a> r100 = g.f396946h;
            monitor-enter(r100);
            Iterator r101 = ((CopyOnWriteArraySet) r100).iterator();     // Catch: Throwable -> L11
        L6:
            if (r101.hasNext() == false) goto L8;
            ((cka.a) r101.next()).b();     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r100);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.i, cka.a
        public final void c(int r100) {
            super.c(r100);
            Set<cka.a> r101 = g.f396946h;
            monitor-enter(r101);
            Iterator r102 = ((CopyOnWriteArraySet) r101).iterator();     // Catch: Throwable -> L11
        L6:
            if (r102.hasNext() == false) goto L8;
            ((cka.a) r102.next()).c(r100);     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r101);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.i
        public final void d(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            g.f396948j.post(r100);
        }
    }

    static {
        f396941c = new g();
        f396944f = new CopyOnWriteArraySet();
        f396945g = new a();
        f396946h = new CopyOnWriteArraySet();
        f396947i = new CopyOnWriteArraySet();
        new Handler(Looper.getMainLooper());
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("OAccountManager");
        ThreadMethodProxy.start(r100);
        f396948j = new Handler(r100.getLooper());
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, cka.a
    public final void a() {
        dka.a.a("AccountSDK_AccountStatusListener", "onAccountLogin");
        b();
        Set<cka.a> r100 = f396944f;
        monitor-enter(r100);
        Iterator r101 = ((CopyOnWriteArraySet) r100).iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        ((cka.a) r101.next()).a();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, cka.a
    public final void b() {
        dka.a.a("AccountSDK_AccountStatusListener", "onAccountInfoUpdate");
        f();
        g();
        Set<cka.a> r100 = f396944f;
        monitor-enter(r100);
        Iterator r101 = ((CopyOnWriteArraySet) r100).iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        ((cka.a) r101.next()).b();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e() {
        IntentFilter r100 = new IntentFilter();
        r100.addAction("obric.intent.action.account.LOGIN");
        r100.addAction("obric.intent.action.account.LOGOUT");
        r100.addAction("obric.intent.action.account.ACCOUNT_INFO_UPDATE");
        if (Build.VERSION.SDK_INT < 33) goto L25;
        Context r110 = this.f396929a;
        d.a r111 = this.f396930b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L111;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L111:
    L20:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L24;
        ReceiverRegisterCrashOptimizer.registerReceiver(r111, r100, null, null, 2);
    L53:
        a r101 = f396945g;
        r101.getClass();
        IntentFilter r112 = new IntentFilter();
        r112.addAction("obric.intent.action.account.SECURE_LOGIN");
        r112.addAction("obric.intent.action.account.SECURE_LOGOUT");
        r112.addAction("obric.intent.action.account.SECURE_ACCOUNT_INFO_UPDATE");
        if (Build.VERSION.SDK_INT < 33) goto L76;
        Context r113 = r101.f396951a;
        i.a r102 = r101.f396952b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L105;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L105:
    L71:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L75;
        ReceiverRegisterCrashOptimizer.registerReceiver(r102, r112, "com.obric.account.permission.ACCOUNT_STATUS", null, 2);
    L97:
        b();
        return;
    L75:
        throw e;
    L59:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L61;
    L69:
        r113.registerReceiver(r102, r112, "com.obric.account.permission.ACCOUNT_STATUS", null, 2);     // Catch: Exception -> L71
    L104:
        goto L97
    L61:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r112) == false) goto L69;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r102, r112, 2, "com.obric.account.permission.ACCOUNT_STATUS", null, 5, r113).result;     // Catch: Exception -> L71
        if (r103 == 1) goto L68;
        if (r103 == 2) goto L67;
        if (r103 == 3) goto L104;
        r113.registerReceiver(r102, r112, "com.obric.account.permission.ACCOUNT_STATUS", null, 2);     // Catch: Exception -> L71
        goto L104
    L67:
        new Intent();     // Catch: Exception -> L71
        goto L104
    L68:
        r113.registerReceiver(r102, r112, "com.obric.account.permission.ACCOUNT_STATUS", null, 2);     // Catch: Exception -> L71
        goto L104
    L76:
        Context r114 = r101.f396951a;
        i.a r104 = r101.f396952b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L102;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L102:
    L90:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L99;
        ReceiverRegisterCrashOptimizer.registerReceiver(r104, r112, "com.obric.account.permission.ACCOUNT_STATUS", null);
        goto L97
    L99:
        throw e;
    L80:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L82;
    L92:
        r114.registerReceiver(r104, r112, "com.obric.account.permission.ACCOUNT_STATUS", null);     // Catch: Exception -> L90
    L101:
        goto L97
    L82:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r112) == false) goto L92;
        int r105 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r104, r112, 0, "com.obric.account.permission.ACCOUNT_STATUS", null, 4, r114).result;     // Catch: Exception -> L90
        if (r105 == 1) goto L89;
        if (r105 == 2) goto L88;
        if (r105 == 3) goto L101;
        r114.registerReceiver(r104, r112, "com.obric.account.permission.ACCOUNT_STATUS", null);     // Catch: Exception -> L90
        goto L101
    L88:
        new Intent();     // Catch: Exception -> L90
        goto L101
    L89:
        r114.registerReceiver(r104, r112, "com.obric.account.permission.ACCOUNT_STATUS", null);     // Catch: Exception -> L90
        goto L101
    L24:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L10;
    L18:
        r110.registerReceiver(r111, r100, null, null, 2);     // Catch: Exception -> L20
    L110:
        goto L53
    L10:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L18;
        int r106 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r111, r100, 2, null, null, 5, r110).result;     // Catch: Exception -> L20
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 == 3) goto L110;
        r110.registerReceiver(r111, r100, null, null, 2);     // Catch: Exception -> L20
        goto L110
    L16:
        new Intent();     // Catch: Exception -> L20
        goto L110
    L17:
        r110.registerReceiver(r111, r100, null, null, 2);     // Catch: Exception -> L20
        goto L110
    L25:
        Context r115 = this.f396929a;
        d.a r116 = this.f396930b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L108;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L108:
    L49:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L100;
        ReceiverRegisterCrashOptimizer.registerReceiver(r116, r100);
        goto L53
    L100:
        throw e;
    L29:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L40;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L40;
        int r107 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r116, r100, 0, null, null, 2, r115).result;     // Catch: Exception -> L49
        if (r107 == 1) goto L38;
        if (r107 == 2) goto L37;
        if (r107 == 3) goto L107;
        r115.registerReceiver(r116, r100);     // Catch: Exception -> L49
    L107:
        goto L53
    L37:
        new Intent();     // Catch: Exception -> L49
        goto L107
    L38:
        r115.registerReceiver(r116, r100);     // Catch: Exception -> L49
    L40:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L43;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L49
        r115.registerReceiver(r116, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L49
        goto L107
    L43:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L45;
    L47:
        r115.registerReceiver(r116, r100);     // Catch: Exception -> L49
        goto L107
    L45:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L47;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L49
        ContextCompat.registerReceiver(r115, r116, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L49
        goto L107
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void f() {
        monitor-enter(this);
        Context r100 = AppGlobals.a();     // Catch: Throwable -> L35
        ContentProviderClient r101 = 0;
        Boolean r102 = null;
        ContentProviderClient r103 = d(r100.getContentResolver());     // Catch: Throwable -> L17 Exception -> L19
        if (r103 != null) goto L38;
        Bundle r104 = null;
    L12:
        if (r104 == null) goto L14;
        com.obric.matrix.platform.sdk.ones.account.a r105 = new com.obric.matrix.platform.sdk.ones.account.a(0);     // Catch: Exception -> L9 Throwable -> L30
        b.a(r105, r104);     // Catch: Exception -> L9 Throwable -> L30
        f396942d = r105;     // Catch: Exception -> L9 Throwable -> L30
    L15:
        if (r103 != null) goto L23;
    L24:
        StringBuilder r106 = new StringBuilder("updateAccountInfo loginState: ");     // Catch: Throwable -> L35
        com.obric.matrix.platform.sdk.ones.account.a r107 = f396942d;     // Catch: Throwable -> L35
        if (r107 == null) goto L27;
        r102 = Boolean.valueOf(r107.f396908a);     // Catch: Throwable -> L35
    L27:
        r106.append(r102);     // Catch: Throwable -> L35
        dka.a.c("AccountSDK_OAccountManager", r106.toString());     // Catch: Throwable -> L35
        monitor-exit(this);
        return;
    L23:
        r103.close();     // Catch: Throwable -> L35
        goto L24
    L14:
        f396942d = new com.obric.matrix.platform.sdk.ones.account.a(0);     // Catch: Exception -> L9 Throwable -> L30
        dka.a.b("AccountSDK_OAccountManager", "updateAccountInfo getAccountInfo: result is null");     // Catch: Exception -> L9 Throwable -> L30
        goto L15
    L38:
        r104 = r103.call("com.obric.common.account.provider", "getAccountInfo", null, null);     // Catch: Exception -> L9 Throwable -> L30
    L9:
        Exception e100 = e;
    L21:
        f396942d = new com.obric.matrix.platform.sdk.ones.account.a(0);     // Catch: Throwable -> L30
        dka.a.f469052a.e("AccountSDK_OAccountManager", "updateAccountInfo getAccountInfo err: " + e100, e100);     // Catch: Throwable -> L30
        if (r103 == null) goto L24;
    L30:
        th = th;
        r101 = r100;
    L32:
        if (r101 == 0) goto L34;
        r101.close();     // Catch: Throwable -> L35
    L34:
        throw th;     // Catch: Throwable -> L35
    L19:
        e = move-exception;
        e100 = e;
        r103 = null;
    L17:
        th = th;
    L35:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void g() {
        monitor-enter(this);
        Context r100 = AppGlobals.a();     // Catch: Throwable -> L39
        ContentProviderClient r101 = 0;
        Integer r102 = null;
        ContentProviderClient r103 = d(r100.getContentResolver());     // Catch: Throwable -> L21 Exception -> L23
        if (r103 != null) goto L43;
        Bundle r104 = null;
    L12:
        if (r104 == null) goto L18;
        Serializable r105 = r104.getSerializable("tokenMap");     // Catch: Exception -> L9 Throwable -> L34
        if (r105 == null) goto L17;
        f396943e = (Map) r105;     // Catch: Exception -> L9 Throwable -> L34
    L19:
        if (r103 != null) goto L27;
    L28:
        StringBuilder r106 = new StringBuilder("updateXttTokenMap: ");     // Catch: Throwable -> L39
        Map<String, String> r107 = f396943e;     // Catch: Throwable -> L39
        if (r107 == null) goto L31;
        r102 = Integer.valueOf(r107.size());     // Catch: Throwable -> L39
    L31:
        r106.append(r102);     // Catch: Throwable -> L39
        dka.a.a("AccountSDK_OAccountManager", r106.toString());     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L27:
        r103.close();     // Catch: Throwable -> L39
        goto L28
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L9 Throwable -> L34
    L18:
        f396943e = new HashMap();     // Catch: Exception -> L9 Throwable -> L34
        dka.a.f("AccountSDK_OAccountManager", "getXttTokenMap: result is null");     // Catch: Exception -> L9 Throwable -> L34
        goto L19
    L43:
        r104 = r103.call("com.obric.common.account.provider", "getTokenMap", null, null);     // Catch: Exception -> L9 Throwable -> L34
    L9:
        Exception e100 = e;
    L25:
        f396943e = new HashMap();     // Catch: Throwable -> L34
        dka.a.f469052a.e("AccountSDK_OAccountManager", "getXttTokenMap: ", e100);     // Catch: Throwable -> L34
        if (r103 == null) goto L28;
    L34:
        th = th;
        r101 = r100;
    L36:
        if (r101 == 0) goto L38;
        r101.close();     // Catch: Throwable -> L39
    L38:
        throw th;     // Catch: Throwable -> L39
    L23:
        e = move-exception;
        e100 = e;
        r103 = null;
    L21:
        th = th;
    L39:
        th = move-exception;
        throw th;
    }

    public g() {
    }

    public static ContentProviderClient d(ContentResolver r110) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {"com.obric.common.account.provider"};
        f06.b r111 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r112 = r106;
        int r113 = r105;
        f06.a[] r114 = r104;
        f06.d r108 = r107.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r111);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return (ContentProviderClient) r108.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient("com.obric.common.account.provider");
    L14:
        r106 = r112 + 1;
        r105 = r113;
        r104 = r114;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, cka.a
    public final void c(int r100) {
        dka.a.a("AccountSDK_AccountStatusListener", "onAccountLogout logoutScene = " + r100);
        b();
        Set<cka.a> r101 = f396944f;
        monitor-enter(r101);
        Iterator r102 = ((CopyOnWriteArraySet) r101).iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        ((cka.a) r102.next()).c(r100);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
