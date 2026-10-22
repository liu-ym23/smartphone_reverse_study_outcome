package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponentManager;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalEntryPoint;
import com.ss.android.lark.officesdk.container.S2OGEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.statistics.Statistics;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.EntryPointAccessors;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements com.ss.android.lark.officesdk.internal.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f433359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OfficeSDKInitConfig f433360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OfficeSDKGlobalComponentManager f433361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OfficeSDKGlobalComponent f433362d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officesdk.internal.a
    public final IUserManager getUserManager() {
        if (this.f433359a.get() == true) goto L6;
        Log.w("OfficeSDKInternalImpl", "getUserManager: OfficeSDK not initialized");
        return null;
    L6:
        OfficeSDKGlobalComponent r100 = this.f433362d;
        if (r100 != null) goto L9;
        return null;
    L9:
        return ((OfficeSDKGlobalEntryPoint) EntryPoints.get(r100, OfficeSDKGlobalEntryPoint.class)).getUserManager();
    }

    public f() {
        this.f433359a = new AtomicBoolean(false);
    }

    @Override // com.ss.android.lark.officesdk.internal.a
    public final void a(OfficeSDKInitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "initConfig");
        this.f433360b = r100;
        OfficeSDKManager.setInitConfig$officesdk_core_release(r100);
        Log.i("OfficeSDKInternalImpl", "setInitConfig done");
    }

    @Override // com.ss.android.lark.officesdk.internal.a
    public final void b(IOfficeSDKRuntime r100) {
        Intrinsics.checkNotNullParameter(r100, "runtime");
        boolean r101 = this.f433359a.compareAndSet(false, true);
        if (r101 == true) goto L45;
        Log.i("OfficeSDKInternalImpl", "OfficeSDK already initialized, skip core init but will trigger callback");
    L45:
    L40:
        e = move-exception;
        Log.e("OfficeSDKInternalImpl", "OfficeSDK init failed", e);
        if (r101 == false) goto L46;
        this.f433359a.set(false);
        return;
    L46:
        return;
    L6:
        if (this.f433360b != null) goto L9;
        Log.e("OfficeSDKInternalImpl", "OfficeSDK init failed: initConfig not set");     // Catch: Exception -> L40
        return;
    L9:
        StringBuilder r102 = new StringBuilder("OfficeSDK init start, appName=");     // Catch: Exception -> L40
        OfficeSDKInitConfig r103 = this.f433360b;     // Catch: Exception -> L40
        IOfficeSDKLifeCycle r104 = null;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("initConfig");     // Catch: Exception -> L40
        r103 = null;
    L13:
        r102.append(r103.getAppName());     // Catch: Exception -> L40
        Log.i("OfficeSDKInternalImpl", r102.toString());     // Catch: Exception -> L40
        if (r101 == false) goto L26;
        OfficeSDKInitConfig r105 = this.f433360b;     // Catch: Exception -> L40
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("initConfig");     // Catch: Exception -> L40
        r105 = null;
    L18:
        OfficeSDKGlobalComponentManager r106 = ((S2OGEntryPoint) EntryPointAccessors.fromApplication(r105.getContext(), S2OGEntryPoint.class)).getOfficeSDKGlobalComponentManager();     // Catch: Exception -> L40
        this.f433361c = r106;     // Catch: Exception -> L40
        if (r106 == null) goto L21;
        OfficeSDKGlobalComponent r107 = r106.generatedComponent();     // Catch: Exception -> L40
    L22:
        this.f433362d = r107;     // Catch: Exception -> L40
        if (r107 == null) goto L25;
        OfficeSDKManager.setGlobalComponent$officesdk_core_release(r107);     // Catch: Exception -> L40
    L25:
        Log.i("OfficeSDKInternalImpl", "Global component initialized");     // Catch: Exception -> L40
        goto L26
    L21:
        r107 = null;
    L26:
        OfficeSDKGlobalComponent r108 = this.f433362d;     // Catch: Exception -> L40
        if (r108 == null) goto L29;
        OfficeSDKGlobalApi r109 = ((OfficeSDKGlobalEntryPoint) EntryPoints.get(r108, OfficeSDKGlobalEntryPoint.class)).getOfficeSDKGlobalApi();     // Catch: Exception -> L40
    L30:
        if (r109 == null) goto L37;
        Log.i("OfficeSDKInternalImpl", "OfficeSDK init ready");     // Catch: Exception -> L40
        OfficeSDKGlobalComponent r110 = this.f433362d;     // Catch: Exception -> L40
        if (r110 == null) goto L34;
        r104 = ((OfficeSDKGlobalEntryPoint) EntryPoints.get(r110, OfficeSDKGlobalEntryPoint.class)).getOfficeSDKLifeCycle();     // Catch: Exception -> L40
    L34:
        if (r104 == null) goto L36;
        r104.onInitReady(r100, r109);     // Catch: Exception -> L40
    L36:
        OfficeSDKManager.dispatchPendingUserComponentReady$officesdk_core_release();     // Catch: Exception -> L40
        HashMap<String, b> r111 = g.f433363a;     // Catch: Exception -> L40
        Statistics.sendEvent("officesdk_init");     // Catch: Exception -> L40
    L38:
        Log.i("OfficeSDKInternalImpl", "OfficeSDK init success");     // Catch: Exception -> L40
        return;
    L37:
        Log.e("OfficeSDKInternalImpl", "OfficeSDK init failed: globalApi is null");     // Catch: Exception -> L40
        goto L38
    L29:
        r109 = null;
        goto L30
    }
}
